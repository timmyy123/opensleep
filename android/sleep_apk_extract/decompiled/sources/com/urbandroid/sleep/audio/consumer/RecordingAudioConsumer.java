package com.urbandroid.sleep.audio.consumer;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AuthenticationTokenClaims;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.NoiseLevelRecorder;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.mic.IRecordingWriter;
import com.urbandroid.sleep.mic.RecorderException;
import com.urbandroid.sleep.mic.RecordingUpdate;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.SoundClass;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class RecordingAudioConsumer extends BaseAudioConsumer implements NoiseLevelRecorder {
    private int MAX_LONG_PRE_RECORDING_BUFFERS;
    private final int MAX_UNDER_THRESHOLD_TERMINATE;
    private final int SKIP_COUNT_RECORDS;
    private Future<DocumentFile> currentRecordingFile;
    private String currentRecordingFileName;
    private float currentThreshold;
    private boolean doRecording;
    private final AtomicLong dontRecordTill;
    private int explicitRecordingCycledRemaining;
    private long explicitRecordingTimestamp;
    private boolean forceMeaningfulSoundRecording;
    private final ConcurrentHashMap<SoundClass, SoundEvent> lastSoundEvents;
    private long lastWriteTimestamp;
    private float maxAmplitude;
    private long overThresholds;
    private LinkedList<AudioReadBuffer> pendingBuffers;
    private LinkedList<AudioReadBuffer> prePendingBuffers;
    private final SleepRecord record;
    private List<Float> recordAmplitudes;
    private int recordingCounter;
    private final AtomicLong recordingStartedTime;
    private IRecordingWriter recordingWriter;
    private final Settings settings;
    private BroadcastReceiver soundEventReceiver;
    private final AtomicBoolean soundEventReceiverRegistered;
    private final AtomicBoolean soundEventsGatheringStarted;
    private final boolean supportLongPrebuffer;
    private final int thresholdParam;
    private int underThresholdCount;

    public RecordingAudioConsumer(Context context, SleepRecord sleepRecord, boolean z) {
        super(context);
        this.MAX_UNDER_THRESHOLD_TERMINATE = 16;
        this.SKIP_COUNT_RECORDS = 4;
        this.recordingCounter = 0;
        this.prePendingBuffers = new LinkedList<>();
        this.pendingBuffers = new LinkedList<>();
        this.recordingStartedTime = new AtomicLong(0L);
        this.dontRecordTill = new AtomicLong(0L);
        this.explicitRecordingTimestamp = -1L;
        this.explicitRecordingCycledRemaining = 0;
        this.lastWriteTimestamp = 0L;
        this.maxAmplitude = 0.0f;
        this.currentThreshold = 1.0f;
        this.underThresholdCount = 0;
        this.forceMeaningfulSoundRecording = false;
        this.soundEventReceiverRegistered = new AtomicBoolean();
        this.lastSoundEvents = new ConcurrentHashMap<>();
        this.soundEventsGatheringStarted = new AtomicBoolean(false);
        this.overThresholds = 0L;
        this.soundEventReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.audio.consumer.RecordingAudioConsumer.2
            private volatile long lastLogged = 0;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null) {
                    return;
                }
                RecordingAudioConsumer.this.soundEventsGatheringStarted.set(true);
                SoundEvent soundEventFromIntent = SoundEvent.fromIntent(intent);
                if (soundEventFromIntent.isMeaningfulSound()) {
                    RecordingAudioConsumer.this.lastSoundEvents.put(soundEventFromIntent.getSoundClass(), soundEventFromIntent);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.lastLogged > 30000) {
                        Logger.logInfo("RecordingAudioConsumer: Received " + soundEventFromIntent);
                        this.lastLogged = jCurrentTimeMillis;
                    }
                }
            }
        };
        this.record = sleepRecord;
        this.doRecording = z;
        this.thresholdParam = compatibilityFetchParamValue(SharedApplicationContext.getSettings().getRecordingThreshold());
        this.supportLongPrebuffer = ((ActivityManager) context.getSystemService("activity")).getMemoryClass() >= 24;
        this.settings = new Settings(context);
        Logger.addFilter(Filters.filter(Matchers.startsWith("AudioRecorder:Finalizing recording"), FrequencyGuards.maxCountPerInterval(60, 30)));
    }

    private void appendTag(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(str);
    }

    private int compatibilityFetchParamValue(int i) {
        return i > 2700 ? i / 2700 : i;
    }

    private boolean currentRecordingIsExplicit() {
        return this.explicitRecordingTimestamp != -1;
    }

    private void finalizeRecording(IRecordingWriter iRecordingWriter, long j, LinkedList<AudioReadBuffer> linkedList) throws IOException {
        Future<DocumentFile> future;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        int size = linkedList.size();
        zza$$ExternalSyntheticOutline0.m(size, "AudioRecorder:Finalizing recording ... buffer size: ");
        long jFlushPendingBuffers = iRecordingWriter.flushPendingBuffers(linkedList, false, this.recordAmplitudes);
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(size, "AudioRecorder:Finalizing recording - ", " buffer(s) flushed in ");
        sbM65m.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sbM65m.append(" ms");
        Logger.logInfo(sbM65m.toString());
        if (j >= jFlushPendingBuffers) {
            jFlushPendingBuffers = j;
        }
        this.recordAmplitudes.add(Float.valueOf(0.0f));
        int size2 = this.recordAmplitudes.size();
        final float[] fArr = new float[size2];
        for (int i = 0; i < size2; i++) {
            fArr[i] = this.recordAmplitudes.get(i).floatValue();
        }
        StringBuilder sbM65m2 = Fragment$$ExternalSyntheticOutline1.m65m(size2, "AudioRecorder:Finalizing recording - recordAmplitudes: ", " in ");
        sbM65m2.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sbM65m2.append(" ms");
        Logger.logInfo(sbM65m2.toString());
        final long j2 = this.recordingStartedTime.get();
        final long j3 = this.explicitRecordingTimestamp;
        try {
            DocumentFile documentFile = (!this.settings.hasNoiseDirUri() || (future = this.currentRecordingFile) == null) ? null : future.get(3L, TimeUnit.SECONDS);
            final String string = documentFile != null ? documentFile.getUri().toString() : this.currentRecordingFileName;
            Logger.logInfo("AudioRecorder:Finalizing recording - stopping ... " + string);
            final long j4 = jFlushPendingBuffers;
            iRecordingWriter.stopWritingToFile(new Runnable() { // from class: com.urbandroid.sleep.audio.consumer.RecordingAudioConsumer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$finalizeRecording$0(jCurrentTimeMillis, j2, j4, j3, string, fArr);
                }
            });
            ContextExtKt.sendExplicitBroadcast(this.context, new RecordingUpdate(false, 0, 0, 0).toIntent());
            Logger.logInfo("AudioRecorder:Finalizing recording took " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private boolean isOverThreshold() {
        return this.overThresholds > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finalizeRecording$0(long j, long j2, long j3, long j4, String str, float[] fArr) {
        Logger.logInfo("AudioRecorder:Finalizing recording - stopWritingToFile finished in " + (System.currentTimeMillis() - j) + "ms");
        storeNoise(this.record, j2, j3, j4, str, fArr);
    }

    private boolean meaningfulSoundDetectedRecently() {
        long jMax = 0;
        for (SoundEvent soundEvent : this.lastSoundEvents.values()) {
            if (soundEvent.isMeaningfulSound()) {
                jMax = Math.max(jMax, soundEvent.getTimestamp());
            }
        }
        return System.currentTimeMillis() - jMax < 40000;
    }

    private boolean soundDetectedAfter(SoundClass soundClass, long j) {
        SoundEvent soundEvent = this.lastSoundEvents.get(soundClass);
        return soundEvent != null && soundEvent.getTimestamp() > j;
    }

    private void storeNoise(SleepRecord sleepRecord, long j, long j2, long j3, String str, float[] fArr) {
        if (j2 <= j) {
            j2 = j;
        }
        if (sleepRecord != null) {
            Noise noise = new Noise(new Date(j), new Date(j2), str, TimeZone.getDefault().getID(), sleepRecord);
            noise.filterAndSetData(fArr);
            StringBuilder sb = new StringBuilder();
            if (soundDetectedAfter(SoundClass.SNORE, j)) {
                appendTag(sb, Tag.SNORE.getTagString());
                this.settings.addAchievement(Achievement.Type.SOUND_RECOGNITION, 1);
            }
            if (soundDetectedAfter(SoundClass.TALK, j)) {
                appendTag(sb, Tag.TALK.getTagString());
                this.settings.addAchievement(Achievement.Type.SOUND_RECOGNITION, 1);
            }
            if (soundDetectedAfter(SoundClass.BABY, j)) {
                appendTag(sb, Tag.BABY.getTagString());
                this.settings.addAchievement(Achievement.Type.SOUND_RECOGNITION, 1);
            }
            if (soundDetectedAfter(SoundClass.COUGH, j)) {
                appendTag(sb, Tag.SICK.getTagString());
                this.settings.addAchievement(Achievement.Type.SOUND_RECOGNITION, 1);
            }
            if (soundDetectedAfter(SoundClass.LAUGH, j)) {
                appendTag(sb, Tag.LAUGH.getTagString());
                this.settings.addAchievement(Achievement.Type.SOUND_RECOGNITION, 1);
            }
            if (j3 != -1 && j3 >= j) {
                appendTag(sb, Tag.NOTE.getTagString());
                noise.setStarred(true);
            }
            if (sb.length() > 0) {
                noise.setComment(sb.toString());
            }
            SharedApplicationContext.getInstance().getSleepRecordRepository().addNoise(noise);
            Logger.logInfo("Storing noise record " + str);
        }
    }

    @Override // com.urbandroid.sleep.audio.NoiseLevelRecorder
    public void addNoiseLevel(float f) {
        if (this.state != AudioRecorder.Consumer.State.OPEN) {
            return;
        }
        if (f > this.maxAmplitude) {
            this.maxAmplitude = f;
            this.currentThreshold = (f / 200.0f) * this.thresholdParam;
        }
        long j = this.overThresholds << 1;
        this.overThresholds = j;
        if (f > this.currentThreshold) {
            this.overThresholds = j + 1;
        }
        this.overThresholds &= 7;
        try {
            ContextExtKt.sendExplicitBroadcast(this.context, new RecordingUpdate(this.recordingWriter.isRecording(), (int) (f * 32767.0f), (int) (this.maxAmplitude * 32767.0f), (int) (this.currentThreshold * 32767.0f)).toIntent());
        } catch (RecorderException e) {
            Logger.logSevere(e);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.NEW_RECORDER_FAILURE, "Failure in new recording.");
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doClose() {
        IRecordingWriter iRecordingWriter = this.recordingWriter;
        if (iRecordingWriter != null) {
            try {
                if (iRecordingWriter.isRecording()) {
                    finalizeRecording(this.recordingWriter, this.lastWriteTimestamp, this.pendingBuffers);
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        if (this.soundEventReceiverRegistered.get()) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.soundEventReceiver);
            this.soundEventReceiverRegistered.set(false);
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doOpen(AudioRecorderContext audioRecorderContext) {
        this.recordingWriter = audioRecorderContext.createWriter(audioRecorderContext);
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.soundEventReceiver, new IntentFilter("action_sound_event_aggregated"));
        this.soundEventReceiverRegistered.set(true);
        this.MAX_LONG_PRE_RECORDING_BUFFERS = (int) (20.0f / (audioRecorderContext.getFloatBufferSize() / audioRecorderContext.getSampleRate()));
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doProcess(AudioReadBuffer audioReadBuffer) {
        if (this.dontRecordTill.get() > System.currentTimeMillis()) {
            return;
        }
        boolean z = this.recordingWriter.isRecording() && (System.currentTimeMillis() - this.recordingStartedTime.get()) / 60000 >= 10;
        long lastReadStartTime = this.recorderContext.getLastReadStartTime();
        if (this.recorderContext.isExplicitRecording()) {
            this.recorderContext.resetExplicitRecording();
            this.explicitRecordingCycledRemaining = 20;
            Logger.logInfo("Explicit recording " + lastReadStartTime);
            this.explicitRecordingTimestamp = lastReadStartTime;
        }
        try {
            if (z) {
                Logger.logInfo("AudioRecorder: Record too long - recording will be suspended for 10 minutes");
                this.pendingBuffers.addLast(audioReadBuffer);
                finalizeRecording(this.recordingWriter, this.lastWriteTimestamp, this.pendingBuffers);
                this.dontRecordTill.set(System.currentTimeMillis() + AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
                this.overThresholds = 0L;
                return;
            }
            if (this.explicitRecordingCycledRemaining > 0 || this.forceMeaningfulSoundRecording || (isOverThreshold() && this.recordingCounter > 4 && (!this.recorderContext.isPaused() || currentRecordingIsExplicit()))) {
                int i = this.explicitRecordingCycledRemaining;
                if (i > 0) {
                    this.explicitRecordingCycledRemaining = i - 1;
                }
                this.underThresholdCount = 0;
                if ((this.recorderContext.isExplicitRecording() || this.doRecording) && !this.recordingWriter.isRecording()) {
                    Logger.logInfo("AudioRecorder: Starting recording");
                    if (!meaningfulSoundDetectedRecently()) {
                        while (this.prePendingBuffers.size() > 1) {
                            this.prePendingBuffers.removeFirst();
                        }
                    }
                    this.recordAmplitudes = Collections.synchronizedList(new LinkedList());
                    this.recordingStartedTime.set(this.prePendingBuffers.size() > 0 ? this.prePendingBuffers.getFirst().getReadTimestamp() : lastReadStartTime);
                    if (this.recorderContext.isExplicitRecording() || this.explicitRecordingCycledRemaining > 0) {
                        Logger.logDebug("AudioRecorder: Explicit recording " + lastReadStartTime);
                        this.explicitRecordingTimestamp = lastReadStartTime;
                    }
                    this.currentRecordingFileName = this.recordingWriter.getNewRecordingFileName(this.recordingStartedTime.get());
                    boolean zHasNoiseDirUri = this.settings.hasNoiseDirUri();
                    IRecordingWriter iRecordingWriter = this.recordingWriter;
                    if (zHasNoiseDirUri) {
                        this.currentRecordingFile = iRecordingWriter.safStartWritingToFile(this.currentRecordingFileName, new IRecordingWriter.FailureListener() { // from class: com.urbandroid.sleep.audio.consumer.RecordingAudioConsumer.1
                            @Override // com.urbandroid.sleep.mic.IRecordingWriter.FailureListener
                            public void fail(String str) {
                                Logger.logSevere("Stopping Recording - reason: " + str);
                                RecordingAudioConsumer.this.close();
                                ContextExtKt.sendExplicitBroadcast(RecordingAudioConsumer.this.context, new RecordingUpdate(RecordingAudioConsumer.this.recordingWriter.isRecording(), 0, 0, 0).toIntent());
                            }
                        });
                    } else {
                        iRecordingWriter.startWritingToFile(this.currentRecordingFileName);
                    }
                    Iterator<AudioReadBuffer> it = this.prePendingBuffers.iterator();
                    while (it.hasNext()) {
                        this.recordingWriter.writeBuffer(it.next(), this.recordAmplitudes);
                    }
                    if (this.prePendingBuffers.size() > 0) {
                        Logger.logInfo("AudioRecorder: Appended pre buffers of length: " + this.prePendingBuffers.size());
                    }
                    this.prePendingBuffers.clear();
                }
                this.forceMeaningfulSoundRecording = false;
            } else if (this.recordingWriter.isRecording()) {
                this.underThresholdCount++;
                if ((this.recorderContext.isPaused() && !currentRecordingIsExplicit()) || ((this.underThresholdCount > 16 && !meaningfulSoundDetectedRecently()) || (!this.doRecording && this.soundEventsGatheringStarted.get() && !meaningfulSoundDetectedRecently()))) {
                    finalizeRecording(this.recordingWriter, this.lastWriteTimestamp, this.pendingBuffers);
                    this.explicitRecordingTimestamp = -1L;
                }
            }
            if (!this.recordingWriter.isRecording()) {
                this.prePendingBuffers.addLast(audioReadBuffer);
                if (this.settings.isSnoringDetection()) {
                    while (true) {
                        if (this.prePendingBuffers.size() <= (this.supportLongPrebuffer ? this.MAX_LONG_PRE_RECORDING_BUFFERS : 1)) {
                            break;
                        } else {
                            this.prePendingBuffers.removeFirst();
                        }
                    }
                } else {
                    while (this.prePendingBuffers.size() > 1) {
                        this.prePendingBuffers.removeFirst();
                    }
                }
            } else if (isOverThreshold() || meaningfulSoundDetectedRecently()) {
                this.recordingWriter.flushPendingBuffers(this.pendingBuffers, true, this.recordAmplitudes);
                this.recordingWriter.writeBuffer(audioReadBuffer, this.recordAmplitudes);
                this.lastWriteTimestamp = System.currentTimeMillis();
            } else {
                this.pendingBuffers.addLast(audioReadBuffer);
            }
            if (this.doRecording && this.soundEventsGatheringStarted.get() && meaningfulSoundDetectedRecently() && !this.recordingWriter.isRecording()) {
                this.forceMeaningfulSoundRecording = true;
            }
            this.recordingCounter++;
        } catch (Exception e) {
            Logger.logSevere(e);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.NEW_RECORDER_FAILURE, "Failure in new recording.");
            close();
        }
    }
}

package com.google.firebase.ai.type;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.util.Log;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.common.util.AndroidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/ai/type/AudioHelper;", "", "recorder", "Landroid/media/AudioRecord;", "playbackTrack", "Landroid/media/AudioTrack;", "<init>", "(Landroid/media/AudioRecord;Landroid/media/AudioTrack;)V", "released", "", "release", "", "playAudio", "data", "", "pauseRecording", "resumeRecording", "listenToRecording", "Lkotlinx/coroutines/flow/Flow;", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AudioHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(AudioHelper.class).getSimpleName();
    private final AudioTrack playbackTrack;
    private final AudioRecord recorder;
    private boolean released;

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/AudioHelper$Companion;", "", "<init>", "()V", "TAG", "", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/AudioHelper;", "initializationHandler", "Lkotlin/Function2;", "Landroid/media/AudioRecord$Builder;", "Landroid/media/AudioTrack$Builder;", "", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AudioHelper build$default(Companion companion, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                function2 = null;
            }
            return companion.build(function2);
        }

        public final AudioHelper build(Function2<? super AudioRecord.Builder, ? super AudioTrack.Builder, Unit> initializationHandler) {
            AcousticEchoCanceler acousticEchoCancelerCreate;
            AudioTrack.Builder builder = new AudioTrack.Builder();
            builder.setAudioFormat(new AudioFormat.Builder().setSampleRate(24000).setChannelMask(4).setEncoding(2).build()).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build()).setBufferSizeInBytes(AudioTrack.getMinBufferSize(24000, 4, 2)).setTransferMode(1);
            int minBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
            if (minBufferSize <= 0) {
                throw new AudioRecordInitializationFailedException("Audio Record buffer size is invalid (" + minBufferSize + ')');
            }
            AudioRecord.Builder bufferSizeInBytes = new AudioRecord.Builder().setAudioSource(7).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(16000).setChannelMask(16).build()).setBufferSizeInBytes(minBufferSize);
            if (initializationHandler != null) {
                bufferSizeInBytes.getClass();
                initializationHandler.invoke(bufferSizeInBytes, builder);
            }
            AudioRecord audioRecordBuild = bufferSizeInBytes.build();
            AudioTrack audioTrackBuild = builder.build();
            audioTrackBuild.getClass();
            if (audioRecordBuild.getState() == 1) {
                if (AcousticEchoCanceler.isAvailable() && (acousticEchoCancelerCreate = AcousticEchoCanceler.create(audioRecordBuild.getAudioSessionId())) != null) {
                    acousticEchoCancelerCreate.setEnabled(true);
                }
                return new AudioHelper(audioRecordBuild, audioTrackBuild);
            }
            throw new AudioRecordInitializationFailedException("Audio Record initialization has failed. State: " + audioRecordBuild.getState());
        }

        private Companion() {
        }
    }

    public AudioHelper(AudioRecord audioRecord, AudioTrack audioTrack) {
        audioRecord.getClass();
        audioTrack.getClass();
        this.recorder = audioRecord;
        this.playbackTrack = audioTrack;
    }

    public final Flow<byte[]> listenToRecording() {
        if (this.released) {
            return FlowKt.emptyFlow();
        }
        resumeRecording();
        return AndroidKt.readAsFlow(this.recorder);
    }

    public final void pauseRecording() {
        if (this.released || this.recorder.getRecordingState() == 1) {
            return;
        }
        try {
            this.recorder.stop();
        } catch (IllegalStateException unused) {
            release();
            Utf8$$ExternalSyntheticBUOutline0.m$3("The playback track was not properly initialized.");
        }
    }

    public final void playAudio(byte[] data2) {
        data2.getClass();
        if (this.released || data2.length == 0) {
            return;
        }
        if (this.playbackTrack.getPlayState() == 1) {
            this.playbackTrack.play();
        }
        int iWrite = this.playbackTrack.write(data2, 0, data2.length);
        if (iWrite > 0) {
            return;
        }
        if (iWrite == 0) {
            Log.w(TAG, "Failed to write any audio bytes to the playback track. The audio track may have been stopped or paused.");
            return;
        }
        if (iWrite == -6) {
            Log.w(TAG, "Attempted to playback some audio, but the track has been released.");
            release();
        } else if (iWrite == -3) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("The playback track was not properly initialized.");
        } else if (iWrite == -2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Playback data is somehow invalid.");
        } else {
            if (iWrite != -1) {
                return;
            }
            Types$$ExternalSyntheticBUOutline0.m$2("Failed to play the audio data for some unknown reason.");
        }
    }

    public final void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.recorder.release();
        this.playbackTrack.release();
    }

    public final void resumeRecording() {
        if (this.released || this.recorder.getRecordingState() == 3) {
            return;
        }
        this.recorder.startRecording();
    }
}

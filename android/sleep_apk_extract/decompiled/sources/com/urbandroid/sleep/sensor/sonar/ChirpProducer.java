package com.urbandroid.sleep.sensor.sonar;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import com.urbandroid.sleep.sensor.sonar.SonarProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.VolumeUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class ChirpProducer implements SonarProducer {
    private AudioTrack audioTrack;
    private int bufferSize;
    private Context context;
    private ExecutorService executor;
    private final Handler handler;
    private SonarProducer.SoundStartListener listener;
    private Future<Void> playbackFuture;
    private int sampleRate;
    private SonarConfig.SonarMethod sonarMethod;
    private int stream = 3;
    private int revertVolume = -1;
    private final AtomicInteger restartDownCounter = new AtomicInteger(5);

    public enum PlaybackResult {
        AUDIO_TRACK_NOT_INITIALIZED,
        AUDIO_TRACK_WRITE_ERROR,
        FINISHED,
        INTERRUPTED
    }

    public ChirpProducer(Context context, int i, int i2, SonarConfig.SonarMethod sonarMethod) {
        this.context = context;
        this.sampleRate = i;
        this.bufferSize = i * 10;
        setStream(i2);
        this.handler = new Handler(Looper.getMainLooper());
        this.sonarMethod = sonarMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void assureStreamVolume(final int i, final int i2) {
        VolumeUtil.unmuteStream(this.context, i);
        int streamVolume = ((AudioManager) this.context.getSystemService("audio")).getStreamVolume(i);
        if (SleepService.SONAR_INITIAL_VOLUME == -1) {
            SleepService.SONAR_INITIAL_VOLUME = streamVolume;
        }
        int i3 = i2 - streamVolume;
        zza$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m(streamVolume, i2, "Sonar: volume ", " -> ", " diff "), i3);
        if (VolumeUtil.getHeadsetState(this.context) > 0) {
            Logger.logWarning("Sonar: ignoring volume increase because headphones!");
            i3 = 0;
        }
        if (i3 != 0) {
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.context);
            Intent intent = new Intent("com.urbandroid.sleep.LULLABY_VOLUME_ACTION");
            intent.putExtra("volume_current", streamVolume);
            intent.putExtra("volume_target", i2);
            localBroadcastManager.sendBroadcast(intent);
            Logger.logInfo("Sonar: update lullaby ");
            this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.sensor.sonar.ChirpProducer.1
                @Override // java.lang.Runnable
                public void run() {
                    VolumeUtil.setStreamVolumeGrant(ChirpProducer.this.context, i, i2);
                }
            }, 500L);
        }
    }

    private void genTone(float[] fArr, short[] sArr) {
        if (this.sonarMethod.isMonoFreq()) {
            getMonoTone(fArr, sArr);
        } else {
            getChirp(fArr, sArr);
        }
    }

    private void getChirp(float[] fArr, short[] sArr) {
        for (int i = 0; i < fArr.length; i++) {
            double d = i;
            float fCos = (float) (Math.cos(((d * 6.283185307179586d) * ((((double) ((this.sonarMethod.getFreqTo() - this.sonarMethod.getFreqFrom()) * i)) / 8191.0d) + ((double) this.sonarMethod.getFreqFrom()))) / ((double) this.sampleRate)) * Math.sin((3.141592653589793d * d) / 8192.0d));
            sArr[i] = (short) (32767.0f * fCos);
            fArr[i] = fCos;
        }
    }

    public void getMonoTone(float[] fArr, short[] sArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float fCos = (float) (Math.cos(((((double) i) * 6.283185307179586d) * ((double) ((this.sonarMethod.getFreqFrom() * length) / this.sampleRate))) / ((double) length)) * 1.0d);
            sArr[i] = (short) (32767.0f * fCos);
            fArr[i] = fCos;
        }
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarProducer
    public synchronized void play() {
        playSound();
    }

    public void playSound() {
        final AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        ExecutorService executorService = this.executor;
        if (executorService == null || executorService.isShutdown()) {
            this.executor = Executors.newSingleThreadExecutor();
        }
        this.playbackFuture = this.executor.submit(new Callable<Void>() { // from class: com.urbandroid.sleep.sensor.sonar.ChirpProducer.2
            /* JADX WARN: Finally extract failed */
            /* JADX WARN: Multi-variable type inference failed */
            private PlaybackResult play() {
                StringBuilder sb;
                int freqTo;
                PlaybackResult playbackResult;
                AudioTrack audioTrack;
                Object obj = "Audio track not initialized (state=";
                Settings settings = SharedApplicationContext.getSettings();
                ChirpProducer chirpProducer = ChirpProducer.this;
                chirpProducer.revertVolume = audioManager.getStreamVolume(chirpProducer.stream);
                if (settings.getSonarRevertVolume() != -1) {
                    Logger.logInfo("Sonar - has persistent revert volume - process was probably killed, let's use " + settings.getSonarRevertVolume() + " instead " + ChirpProducer.this.revertVolume);
                    ChirpProducer.this.revertVolume = settings.getSonarRevertVolume();
                } else {
                    SharedApplicationContext.getSettings().setSonarRevertVolume(ChirpProducer.this.revertVolume);
                }
                int sonarVolume = new Settings(ChirpProducer.this.context).getSonarVolume(ChirpProducer.this.stream);
                StringBuilder sb2 = new StringBuilder("Sonar: chirp play current volume ");
                sb2.append(ChirpProducer.this.revertVolume);
                sb2.append(" setting ");
                sb2.append(sonarVolume);
                sb2.append(" / ");
                sb2.append(audioManager.getStreamMaxVolume(ChirpProducer.this.stream));
                sb2.append(" ");
                boolean zIsMonoFreq = ChirpProducer.this.sonarMethod.isMonoFreq();
                ChirpProducer chirpProducer2 = ChirpProducer.this;
                if (zIsMonoFreq) {
                    sb = new StringBuilder(" MONO FREQ ");
                    freqTo = chirpProducer2.sonarMethod.getFreqFrom();
                } else {
                    sb = new StringBuilder(" CHIRP ");
                    sb.append(chirpProducer2.sonarMethod.getFreqFrom());
                    sb.append(" - ");
                    freqTo = ChirpProducer.this.sonarMethod.getFreqTo();
                }
                sb.append(freqTo);
                sb2.append(sb.toString());
                Logger.logInfo(sb2.toString());
                ChirpProducer chirpProducer3 = ChirpProducer.this;
                chirpProducer3.assureStreamVolume(chirpProducer3.stream, sonarVolume);
                VolumeUtil.cancelDndAll(ChirpProducer.this.context, true);
                ChirpProducer.this.audioTrack = new AudioTrack(ChirpProducer.this.stream, ChirpProducer.this.sampleRate, 4, 2, ChirpProducer.this.bufferSize, 1);
                short[] sArr = new short[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                ChirpProducer.this.genTone(sArr);
                int state = ChirpProducer.this.audioTrack.getState();
                try {
                    try {
                    } catch (Throwable th) {
                        if (ChirpProducer.this.audioTrack != null) {
                            try {
                                ChirpProducer.this.audioTrack.stop();
                            } catch (IllegalStateException unused) {
                            }
                            ChirpProducer.this.audioTrack.release();
                            ChirpProducer.this.audioTrack = null;
                        }
                        throw th;
                    }
                } catch (IllegalStateException unused2) {
                }
                if (state != 1) {
                    Logger.logSevere("Audio track not initialized (state=" + state + ")");
                    Object obj2 = PlaybackResult.AUDIO_TRACK_NOT_INITIALIZED;
                    playbackResult = obj2;
                    if (ChirpProducer.this.audioTrack != null) {
                        audioTrack = ChirpProducer.this.audioTrack;
                        obj = obj2;
                    }
                    return playbackResult;
                }
                ChirpProducer.this.audioTrack.play();
                Logger.logInfo("Sonar: chirp play()");
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        boolean zIsInterrupted = Thread.currentThread().isInterrupted();
                        if (zIsInterrupted) {
                            Logger.logInfo("Chirp playback interrupted");
                        }
                        PlaybackResult playbackResult2 = zIsInterrupted ? PlaybackResult.INTERRUPTED : PlaybackResult.FINISHED;
                        if (ChirpProducer.this.audioTrack == null) {
                            return playbackResult2;
                        }
                        audioTrack = ChirpProducer.this.audioTrack;
                        obj = playbackResult2;
                    } else if (ChirpProducer.this.audioTrack != null && ChirpProducer.this.audioTrack.getPlayState() == 3) {
                        int iWrite = ChirpProducer.this.audioTrack.write(sArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                        if (iWrite <= 0) {
                            Logger.logSevere("Audio track write error: " + iWrite);
                            i2++;
                            if (i2 < 10) {
                                TimeUnit.MILLISECONDS.sleep(10L);
                            } else {
                                PlaybackResult playbackResult3 = PlaybackResult.AUDIO_TRACK_WRITE_ERROR;
                                if (ChirpProducer.this.audioTrack == null) {
                                    return playbackResult3;
                                }
                                audioTrack = ChirpProducer.this.audioTrack;
                                obj = playbackResult3;
                            }
                        } else {
                            if (ChirpProducer.this.listener != null && i > 50) {
                                Logger.logInfo("Sonar: chirp playback started ");
                                ChirpProducer.this.listener.onSoundStarted();
                                ChirpProducer.this.listener = null;
                            }
                            if (i % 300 == 0) {
                                ChirpProducer chirpProducer4 = ChirpProducer.this;
                                chirpProducer4.assureStreamVolume(chirpProducer4.stream, new Settings(ChirpProducer.this.context).getSonarVolume(ChirpProducer.this.stream));
                            }
                            i++;
                        }
                    }
                }
                audioTrack.stop();
                ChirpProducer.this.audioTrack.release();
                ChirpProducer.this.audioTrack = null;
                playbackResult = obj;
                return playbackResult;
            }

            @Override // java.util.concurrent.Callable
            public Void call() {
                PlaybackResult playbackResultPlay = play();
                Logger.logInfo("Chirp Playback finished with result " + playbackResultPlay + ", restartDownCounter: " + ChirpProducer.this.restartDownCounter.get());
                if (playbackResultPlay != PlaybackResult.FINISHED && playbackResultPlay != PlaybackResult.INTERRUPTED && ChirpProducer.this.restartDownCounter.decrementAndGet() != 0) {
                    ChirpProducer.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.sensor.sonar.ChirpProducer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.logInfo("Chirp Playback restarting ...");
                            ChirpProducer.this.play();
                        }
                    }, 10000L);
                }
                return null;
            }
        });
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarProducer
    public void setSoundStartListener(SonarProducer.SoundStartListener soundStartListener) {
        this.listener = soundStartListener;
    }

    public synchronized void setStream(int i) {
        this.stream = i;
        Logger.logInfo("Sonar: using stream " + i);
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarProducer
    public synchronized void stop() {
        try {
            Logger.logInfo("Sonar: chirp stop");
            Future<Void> future = this.playbackFuture;
            if (future != null) {
                future.cancel(true);
            }
            ExecutorService executorService = this.executor;
            if (executorService != null) {
                try {
                    executorService.shutdown();
                    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            if (this.revertVolume > -1) {
                Logger.logInfo("Sonar: revert volume " + this.revertVolume);
                VolumeUtil.setStreamVolume(this.context, this.stream, this.revertVolume);
                SharedApplicationContext.getSettings().setSonarRevertVolume(-1);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void genTone(short[] sArr) {
        genTone(new float[sArr.length], sArr);
    }
}

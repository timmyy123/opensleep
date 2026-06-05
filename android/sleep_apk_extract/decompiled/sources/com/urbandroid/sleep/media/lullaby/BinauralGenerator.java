package com.urbandroid.sleep.media.lullaby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.media.AudioTrack;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.volume.IVolumeChangeListener;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class BinauralGenerator implements IVolumeChangeListener, IBinauralGenerator {
    private final AudioTrack audioTrack;
    public float baseBeatFrequency;
    private float baseFrequency;
    private final boolean externalVolumeSource;
    private int from;
    private final byte[] generatedSnd;
    private WriteBufferRunnable t;
    private int time;
    private int to;
    private final BinauralVolumeManager volumeManager;
    private final int duration = 1;
    private final int sampleRate = 8000;
    private final int numSamples = 8000;
    private final float[] sampleLeft = new float[8000];
    private final float[] sampleRight = new float[8000];
    private final int bufferSize = 6;
    private boolean playing = false;
    private boolean stopped = false;

    public BinauralGenerator(int i, int i2, int i3, int i4, boolean z) {
        byte[] bArr = new byte[32000];
        this.generatedSnd = bArr;
        this.from = i;
        this.to = i2;
        this.time = i3;
        this.externalVolumeSource = z;
        float f = i;
        this.baseBeatFrequency = f;
        this.baseFrequency = 200.0f;
        if (f != 20.0f) {
            this.baseFrequency = FileInsert$$ExternalSyntheticOutline0.m(f, 20.0f, 5.0f, 200.0f);
        }
        Logger.logInfo("LullabyPlayer: binaural init");
        AudioTrack audioTrack = new AudioTrack(i4, 8000, 3, 2, bArr.length * 6, 1);
        this.audioTrack = audioTrack;
        BinauralVolumeManager binauralVolumeManager = new BinauralVolumeManager(audioTrack);
        this.volumeManager = binauralVolumeManager;
        binauralVolumeManager.setVolume(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int writeTone(float f, float f2) {
        try {
            if (isStopped()) {
                return 0;
            }
            float f3 = 8000.0f / f;
            float f4 = 8000.0f / f2;
            for (int i = 0; i < 8000; i++) {
                float f5 = 6.2831855f * i;
                this.sampleLeft[i] = (float) Math.sin(f5 / f3);
                this.sampleRight[i] = (float) Math.sin(f5 / f4);
            }
            int i2 = 0;
            int i3 = 0;
            while (true) {
                float[] fArr = this.sampleLeft;
                if (i2 >= fArr.length) {
                    AudioTrack audioTrack = this.audioTrack;
                    byte[] bArr = this.generatedSnd;
                    int iWrite = audioTrack.write(bArr, 0, bArr.length);
                    this.audioTrack.flush();
                    return iWrite;
                }
                double d = fArr[i2];
                short s = (short) (d * 32767.0d);
                short s2 = (short) (((double) this.sampleRight[i2]) * 32767.0d);
                byte[] bArr2 = this.generatedSnd;
                bArr2[i3] = (byte) (s & 255);
                bArr2[i3 + 1] = (byte) ((s & 65280) >>> 8);
                int i4 = i3 + 3;
                bArr2[i3 + 2] = (byte) (s2 & 255);
                i3 += 4;
                bArr2[i4] = (byte) ((s2 & 65280) >>> 8);
                i2++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public synchronized boolean isStopped() {
        return this.stopped;
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public synchronized void mute() {
        if (this.audioTrack != null && isPlaying()) {
            this.volumeManager.mute();
        }
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public synchronized void play() {
        BinauralGenerator binauralGenerator;
        try {
            try {
                Logger.logInfo("LullabyPlayer: binaural play() " + isStopped());
                if (isStopped()) {
                    binauralGenerator = this;
                } else {
                    for (int i = 0; i < 6; i++) {
                        float f = this.baseFrequency;
                        writeTone(f, this.from + f);
                    }
                    try {
                        Logger.logInfo("LullabyPlayer: binaural Playing binaural beat track");
                        this.audioTrack.play();
                        binauralGenerator = this;
                        binauralGenerator.t = new WriteBufferRunnable(binauralGenerator, this.from, this.to, this.time, 0);
                        new Thread(binauralGenerator.t).start();
                        binauralGenerator.setPlaying(true);
                    } catch (IllegalStateException e) {
                        Logger.logSevere(e);
                        ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "illegal state of AudioTrack, cannot call play()", 1);
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
        throw th;
    }

    public void setPlaying(boolean z) {
        this.playing = z;
    }

    public synchronized void setStopped(boolean z) {
        this.stopped = z;
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public synchronized void stop() {
        try {
            Logger.logInfo("LullabyPlayer: binaural stop()");
            setStopped(true);
            WriteBufferRunnable writeBufferRunnable = this.t;
            if (writeBufferRunnable != null) {
                writeBufferRunnable.stop();
            }
            if (this.audioTrack != null) {
                if (isPlaying()) {
                    this.audioTrack.stop();
                }
                this.audioTrack.release();
            }
            setPlaying(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public void unmute() {
        if (this.audioTrack == null || !isPlaying()) {
            return;
        }
        this.volumeManager.unmute();
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeChangeListener
    public synchronized void volumeUpdated(float f) {
        this.volumeManager.volumeUpdated(f);
    }

    public class WriteBufferRunnable implements Runnable {
        private int from;
        private long lastTime;
        private volatile AtomicBoolean running;
        private int sleepTime;
        private int time;
        private int to;

        private WriteBufferRunnable(int i, int i2, int i3) {
            this.sleepTime = 100;
            this.lastTime = System.currentTimeMillis();
            this.running = new AtomicBoolean(true);
            this.from = i;
            this.to = i2;
            this.time = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            boolean z = this.from < this.to;
            int iRound = Math.round(((this.time * 60) / 4.0f) / Math.abs(r1 - r2));
            float binauralVolume = SharedApplicationContext.getSettings().getBinauralVolume();
            float f = binauralVolume / 50.0f;
            Logger.logDebug("LullabyPlayer: binaural Target volume " + binauralVolume + " " + f);
            float fMin = 0.0f;
            long j = 0;
            long j2 = 0;
            while (this.running.get()) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.lastTime;
                    this.lastTime = System.currentTimeMillis();
                    j += jCurrentTimeMillis;
                    j2 += jCurrentTimeMillis;
                    if (!BinauralGenerator.this.externalVolumeSource && fMin < binauralVolume) {
                        fMin = Math.min(fMin + f, binauralVolume);
                        BinauralGenerator.this.volumeManager.setVolume(fMin < 100.0f ? 1.0f - (((float) Math.log(100.0f - fMin)) / ((float) Math.log(100.0d))) : 1.0f);
                    }
                    if (j2 > iRound * 1000) {
                        if (z && (i2 = this.from) < this.to) {
                            this.from = i2 + 1;
                        } else if (!z && (i = this.from) > this.to) {
                            this.from = i - 1;
                        }
                        j2 = 0;
                    }
                    float f2 = BinauralGenerator.this.baseFrequency;
                    float f3 = this.from;
                    BinauralGenerator binauralGenerator = BinauralGenerator.this;
                    float fM = FileInsert$$ExternalSyntheticOutline0.m(f3, binauralGenerator.baseBeatFrequency, 5.0f, f2);
                    float f4 = f3 + fM;
                    if (j >= 1000 - this.sleepTime) {
                        j -= 1000;
                        binauralGenerator.writeTone(fM, f4);
                    }
                    Thread.sleep(this.sleepTime);
                } catch (InterruptedException unused) {
                    stop();
                    return;
                }
            }
        }

        public void stop() {
            this.running.set(false);
            Logger.logInfo("LullabyPlayer: binaural runnable STOP " + this.running.get());
        }

        public /* synthetic */ WriteBufferRunnable(BinauralGenerator binauralGenerator, int i, int i2, int i3, int i4) {
            this(i, i2, i3);
        }
    }
}

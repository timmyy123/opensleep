package com.urbandroid.sleep.media.lullaby;

import android.content.Context;
import android.content.Intent;
import android.media.AudioTrack;
import android.os.Process;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.hecz.android.FlexPlayer;
import com.hecz.android.IFlexListener;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity;
import com.urbandroid.sleep.alarmclock.volume.IVolumeChangeListener;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class BinauralGeneratorFlex implements IVolumeChangeListener, IBinauralGenerator {
    private AudioTrack audioTrack;
    public double baseBeatFrequency;
    private double baseFrequency;
    private int color;
    private Context context;
    private boolean externalVolumeSource;
    private FlexPlayer flexPlayer;
    private int[] program;
    private boolean serial;
    private int serialMaxIntensity;
    private int stream;
    private Thread t;
    private int time;
    private BinauralVolumeManager volumeManager;
    private final int duration = 1;
    private final int sampleRate = 8000;
    private final int numSamples = 8000;
    private final double[] sampleLeft = new double[8000];
    private final double[] sampleRight = new double[8000];
    private final byte[] generatedSnd = new byte[32000];
    private final Object LOCK = new Object();
    private boolean gentleStop = false;
    private boolean pause = false;
    private boolean stopped = false;
    private final int bufferSize = 4;
    private double currentTime = 0.0d;
    private double bufferTime = 0.0d;
    private long startTime = -1;
    private WriteBufferRunnable runnable = null;
    private List<Double> errorList = null;
    private double forceFreq = -1.0d;
    private long lastWrite = -1;
    private long count = 0;

    public BinauralGeneratorFlex(Context context, int[] iArr, int i, int i2, boolean z) {
        this.baseFrequency = 200.0d;
        this.baseBeatFrequency = 20.0d;
        this.serial = false;
        if (iArr.length < 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Frequency definition too short");
            throw null;
        }
        this.stream = i2;
        this.time = i;
        this.context = context;
        this.program = iArr;
        double d = iArr[0];
        this.baseBeatFrequency = d;
        this.baseFrequency = ((d - 20.0d) * 5.0d) + 200.0d;
        this.serial = SharedApplicationContext.getSettings().isSmartlightMaskEnabled() && SmartLightSettingsActivity.isSerialConnected(context);
        Logger.logInfo("Smartlight: Flex serial " + this.serial);
        this.serialMaxIntensity = SharedApplicationContext.getSettings().getSmartlightMaskIntensity();
        this.color = Color.RED;
        this.externalVolumeSource = z;
    }

    private double avg(List<Double> list) {
        Iterator<Double> it = list.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue / ((double) list.size());
    }

    private boolean isFlexReady() {
        return this.serial && !new Settings(this.context).isLucidMaskReserved();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playInternal() {
        setAudioTrack(new AudioTrack(this.stream, 8000, 12, 2, this.generatedSnd.length * 4, 1));
        BinauralVolumeManager binauralVolumeManager = new BinauralVolumeManager(getAudioTrack());
        this.volumeManager = binauralVolumeManager;
        binauralVolumeManager.setVolume(0.01f);
        for (int i = 0; i < 4; i++) {
            double d = this.baseFrequency;
            writeTone(d, this.baseBeatFrequency + d);
        }
        Intent intent = new Intent("com.urbandroid.mind.FREQ_UPDATE");
        intent.putExtra("com.urbandroid.mind.FREQ1", this.baseFrequency);
        intent.putExtra("com.urbandroid.mind.FREQ2", this.baseFrequency + this.baseBeatFrequency);
        ContextExtKt.sendExplicitBroadcast(this.context, intent);
        this.volumeManager.setVolume(0.0f);
        Logger.logInfo("Smarlight: Binaural play");
        this.runnable = new WriteBufferRunnable(this, this.program, this.time, this.forceFreq, 0);
        Thread thread = new Thread(this.runnable);
        this.t = thread;
        thread.start();
        if (this.flexPlayer == null || !isFlexReady()) {
            new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.6
                @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                public Object doExecute(AudioTrack audioTrack) {
                    audioTrack.play();
                    return null;
                }
            }.execute();
        } else {
            Logger.logInfo("Smarlight: Flex prepare " + this.flexPlayer);
            this.flexPlayer.prepare();
            new Thread() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.5
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (BinauralGeneratorFlex.this.getAudioTrack() != null) {
                        Process.setThreadPriority(-16);
                        new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.5.1
                            {
                                BinauralGeneratorFlex binauralGeneratorFlex = BinauralGeneratorFlex.this;
                            }

                            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                            public Object doExecute(AudioTrack audioTrack) {
                                audioTrack.play();
                                return null;
                            }
                        }.execute();
                        while (BinauralGeneratorFlex.this.isPlaybackStarted()) {
                            try {
                                try {
                                    Thread.sleep(1L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e2) {
                                Logger.logSevere(e2);
                            }
                        }
                        new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.5.2
                            {
                                BinauralGeneratorFlex binauralGeneratorFlex = BinauralGeneratorFlex.this;
                            }

                            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                            public Object doExecute(AudioTrack audioTrack) {
                                audioTrack.pause();
                                return null;
                            }
                        }.execute();
                        BinauralGeneratorFlex.this.startTime = System.currentTimeMillis();
                        Logger.logInfo("Smarlight: FLEX Audio Start time " + BinauralGeneratorFlex.this.startTime);
                        new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.5.3
                            {
                                BinauralGeneratorFlex binauralGeneratorFlex = BinauralGeneratorFlex.this;
                            }

                            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                            public Object doExecute(AudioTrack audioTrack) {
                                audioTrack.play();
                                return null;
                            }
                        }.execute();
                    }
                }
            }.start();
        }
        if (this.flexPlayer == null || !isFlexReady()) {
            return;
        }
        int iRound = Math.round((this.serialMaxIntensity / 100.0f) * 255.0f * 1.0f);
        Logger.logInfo("Smarlight: Flex start " + this.flexPlayer + " intensity " + iRound);
        this.flexPlayer.setIntensity(iRound);
        this.flexPlayer.setRgb(android.graphics.Color.red(this.color), android.graphics.Color.green(this.color), android.graphics.Color.blue(this.color));
        this.flexPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int writeTone(double d, double d2) {
        double d3;
        double d4;
        double d5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iRound = (int) Math.round(Math.abs(d2 - d));
        Logger.logInfo("Smartlight: FREQ " + d + " " + d2 + " " + iRound);
        this.lastWrite = jCurrentTimeMillis;
        if (this.flexPlayer != null) {
            double d6 = iRound;
            double d7 = 1000.0d / d6;
            Integer numExecute = new AudioTrackExecutor<Integer>() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                public Integer doExecute(AudioTrack audioTrack) {
                    try {
                        return Integer.valueOf(audioTrack.getPlaybackHeadPosition());
                    } catch (Exception unused) {
                        return null;
                    }
                }
            }.execute();
            if (numExecute == null || numExecute.intValue() <= 0) {
                d3 = 1000.0d;
                d4 = 8000.0d;
            } else {
                d4 = 8000.0d;
                if (System.currentTimeMillis() - this.startTime > 120000) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - this.startTime;
                    double dIntValue = (((double) numExecute.intValue()) * 1000.0d) / 8000.0d;
                    d3 = 1000.0d;
                    this.errorList.add(Double.valueOf(dIntValue / jCurrentTimeMillis2));
                    if (this.errorList.size() > 15) {
                        this.errorList.remove(0);
                    }
                    double dAvg = avg(this.errorList);
                    this.flexPlayer.setSoundTimeRatio(dAvg);
                    StringBuilder sb = new StringBuilder("Smartlight: FLEX audio ");
                    sb.append(dIntValue);
                    zzba$$ExternalSyntheticOutline0.m(sb, " elapsed ", jCurrentTimeMillis2, " delta=");
                    sb.append(dAvg);
                    Logger.logInfo(sb.toString());
                } else {
                    d3 = 1000.0d;
                }
            }
            int i = 0;
            while (i < iRound) {
                if (this.flexPlayer.isBufferAcceptData()) {
                    d5 = d6;
                    this.flexPlayer.insert2Buffer(this.currentTime / d3, d5, 200.0d);
                    this.currentTime += d7;
                } else {
                    d5 = d6;
                    Logger.logSevere("FLEX ACCEPT false");
                }
                i++;
                d6 = d5;
            }
        } else {
            d3 = 1000.0d;
            d4 = 8000.0d;
        }
        double d8 = d4 / d;
        double d9 = d4 / d2;
        for (int i2 = 0; i2 < 8000; i2++) {
            long j = i2;
            this.sampleLeft[i2] = Math.sin((((this.count * 8000) + j) * 6.283185307179586d) / d8);
            this.sampleRight[i2] = Math.sin((6.283185307179586d * ((this.count * 8000) + j)) / d9);
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            double[] dArr = this.sampleLeft;
            if (i3 >= dArr.length) {
                break;
            }
            double d10 = dArr[i3];
            short s = (short) (d10 * 32767.0d);
            short s2 = (short) (this.sampleRight[i3] * 32767.0d);
            byte[] bArr = this.generatedSnd;
            bArr[i4] = (byte) (s & 255);
            bArr[i4 + 1] = (byte) ((s & 65280) >>> 8);
            int i5 = i4 + 3;
            bArr[i4 + 2] = (byte) (s2 & 255);
            i4 += 4;
            bArr[i5] = (byte) ((s2 & 65280) >>> 8);
            i3++;
        }
        this.bufferTime += d3;
        Integer numExecute2 = new AudioTrackExecutor<Integer>() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
            public Integer doExecute(AudioTrack audioTrack) {
                int iWrite = audioTrack.write(BinauralGeneratorFlex.this.generatedSnd, 0, BinauralGeneratorFlex.this.generatedSnd.length);
                BinauralGeneratorFlex.this.count++;
                audioTrack.flush();
                return Integer.valueOf(iWrite);
            }
        }.execute();
        if (numExecute2 != null) {
            return numExecute2.intValue();
        }
        return -1;
    }

    public synchronized AudioTrack getAudioTrack() {
        return this.audioTrack;
    }

    public synchronized boolean isGentleStop() {
        return this.gentleStop;
    }

    public synchronized boolean isPause() {
        return this.pause;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isPlaybackStarted() {
        boolean z;
        if (getAudioTrack() != null) {
            z = getAudioTrack().getPlaybackHeadPosition() == 0;
        }
        return z;
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public void mute() {
        this.volumeManager.mute();
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public void play() {
        if (!isFlexReady()) {
            playInternal();
            return;
        }
        this.errorList = new LinkedList();
        FlexPlayer flexPlayer = new FlexPlayer();
        this.flexPlayer = flexPlayer;
        flexPlayer.initPort(this.context, new IFlexListener() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.4
            @Override // com.hecz.android.IFlexListener
            public void onConnected() {
                Logger.logInfo("Smarlight: binaural Flex connected");
                if (BinauralGeneratorFlex.this.stopped) {
                    return;
                }
                Logger.logInfo("Smarlight: starting playback");
                BinauralGeneratorFlex.this.playInternal();
            }

            @Override // com.hecz.android.IFlexListener
            public void onDisconnect() {
                Logger.logInfo("Smartlight: Serial disconnected");
            }
        });
    }

    public synchronized void setAudioTrack(AudioTrack audioTrack) {
        this.audioTrack = audioTrack;
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public void stop() {
        this.stopped = true;
        Logger.logInfo("Smarlight: Binaural stop");
        new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.7
            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
            public Object doExecute(AudioTrack audioTrack) {
                audioTrack.stop();
                audioTrack.release();
                BinauralGeneratorFlex.this.setAudioTrack(null);
                return null;
            }
        }.execute();
        if (this.t != null) {
            this.runnable.setStop(true);
            this.t.interrupt();
        }
        this.currentTime = 0.0d;
        if (this.flexPlayer == null || !isFlexReady()) {
            return;
        }
        Logger.logInfo("Smarlight: flex stop");
        this.flexPlayer.resetBuffer();
        this.flexPlayer.stop();
    }

    @Override // com.urbandroid.sleep.media.lullaby.IBinauralGenerator
    public void unmute() {
        this.volumeManager.unmute();
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeChangeListener
    public synchronized void volumeUpdated(final float f) {
        new AudioTrackExecutor<Void>() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(BinauralGeneratorFlex.this, 0);
            }

            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
            public Void doExecute(AudioTrack audioTrack) {
                BinauralGeneratorFlex.this.volumeManager.setVolume(f);
                return null;
            }
        }.execute();
    }

    public abstract class AudioTrackExecutor<T> {
        private AudioTrackExecutor() {
        }

        public abstract T doExecute(AudioTrack audioTrack);

        public T execute() {
            synchronized (BinauralGeneratorFlex.this.LOCK) {
                try {
                    AudioTrack audioTrack = BinauralGeneratorFlex.this.getAudioTrack();
                    if (audioTrack == null) {
                        return null;
                    }
                    return doExecute(audioTrack);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ AudioTrackExecutor(BinauralGeneratorFlex binauralGeneratorFlex, int i) {
            this();
        }
    }

    public class WriteBufferRunnable implements Runnable {
        private double forceFreq;
        private long lastTime;
        private int[] program;
        private int sleepTime;
        private boolean stop;
        private int time;

        private WriteBufferRunnable(int[] iArr, int i, double d) {
            this.sleepTime = 100;
            this.lastTime = System.currentTimeMillis();
            this.stop = false;
            this.program = iArr;
            this.time = i;
            this.forceFreq = d;
        }

        public synchronized boolean isStop() {
            return this.stop;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis;
            VolumeController volumeController = new VolumeController("BI", 1, Math.round(BinauralGeneratorFlex.this.volumeManager.getConfigurredVolume() * 100.0f), 10000L, 3000L);
            long j = this.time * 60000;
            Logger.logInfo("Smartlight: Program generator " + this.program);
            long j2 = 0;
            long j3 = 0;
            int i = 0;
            while (!isStop()) {
                try {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - this.lastTime;
                    this.lastTime = System.currentTimeMillis();
                    j2 += jCurrentTimeMillis2;
                    j3 += jCurrentTimeMillis2;
                    double dMax = Math.max(Math.min(36.0d, this.program[Math.min(Math.round((((long) this.program.length) * j3) / j), this.program.length - 1)]), 1.0d);
                    double d = this.forceFreq;
                    if (d > 0.0d) {
                        dMax = d;
                    }
                    double d2 = ((dMax - BinauralGeneratorFlex.this.baseBeatFrequency) * 5.0d) + BinauralGeneratorFlex.this.baseFrequency;
                    double d3 = dMax + d2;
                    if (j2 >= 1000 - this.sleepTime) {
                        j2 -= 1000;
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        BinauralGeneratorFlex.this.writeTone(d2, d3);
                        if (BinauralGeneratorFlex.this.flexPlayer != null) {
                            BinauralGeneratorFlex.this.flexPlayer.runOnce();
                        }
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis3;
                        if (i >= 4) {
                            Intent intent = new Intent("com.urbandroid.mind.FREQ_UPDATE");
                            intent.putExtra("com.urbandroid.mind.FREQ1", d2);
                            intent.putExtra("com.urbandroid.mind.FREQ2", d3);
                            ContextExtKt.sendExplicitBroadcast(BinauralGeneratorFlex.this.context, intent);
                            i = 0;
                        }
                        i++;
                    } else {
                        jCurrentTimeMillis = 0;
                    }
                    long j4 = ((long) this.sleepTime) - jCurrentTimeMillis;
                    if (j4 > 0) {
                        Thread.sleep(j4);
                    }
                    if (BinauralGeneratorFlex.this.isPause()) {
                        Logger.logInfo("Smartlight: Pausing binaural");
                        new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.WriteBufferRunnable.1
                            {
                                BinauralGeneratorFlex binauralGeneratorFlex = BinauralGeneratorFlex.this;
                            }

                            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                            public Void doExecute(AudioTrack audioTrack) {
                                audioTrack.pause();
                                return null;
                            }
                        }.execute();
                        if (BinauralGeneratorFlex.this.flexPlayer != null) {
                            BinauralGeneratorFlex.this.flexPlayer.pause();
                        }
                        while (BinauralGeneratorFlex.this.isPause()) {
                            Thread.sleep(this.sleepTime);
                        }
                        this.lastTime = System.currentTimeMillis();
                        new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.WriteBufferRunnable.2
                            {
                                BinauralGeneratorFlex binauralGeneratorFlex = BinauralGeneratorFlex.this;
                            }

                            @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                            public Void doExecute(AudioTrack audioTrack) {
                                audioTrack.play();
                                return null;
                            }
                        }.execute();
                        if (BinauralGeneratorFlex.this.flexPlayer != null) {
                            BinauralGeneratorFlex.this.flexPlayer.start();
                        }
                    }
                    if (!BinauralGeneratorFlex.this.externalVolumeSource) {
                        if (volumeController.update()) {
                            final float volume = volumeController.getVolume();
                            new AudioTrackExecutor() { // from class: com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.WriteBufferRunnable.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(BinauralGeneratorFlex.this, 0);
                                }

                                @Override // com.urbandroid.sleep.media.lullaby.BinauralGeneratorFlex.AudioTrackExecutor
                                public Void doExecute(AudioTrack audioTrack) {
                                    BinauralGeneratorFlex.this.volumeManager.setVolume(volume);
                                    return null;
                                }
                            }.execute();
                        }
                        if (volumeController.isIncreasing() && BinauralGeneratorFlex.this.isGentleStop()) {
                            volumeController.revert();
                        }
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }

        public synchronized void setStop(boolean z) {
            this.stop = z;
        }

        public /* synthetic */ WriteBufferRunnable(BinauralGeneratorFlex binauralGeneratorFlex, int[] iArr, int i, double d, int i2) {
            this(iArr, i, d);
        }
    }
}

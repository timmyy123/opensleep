package com.urbandroid.sleep.alarmclock.volume;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.util.VolumeUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class GentleAlarmRunnable implements IVolumeControlRunnable {
    private AudioAttributes attr;
    private final AudioManager audioManager;
    private int audioStream;
    private Context context;
    private int currentVolume;
    private final int increaseDuration;
    private int initialVolume;
    private boolean isStreaming;
    private MediaPlayer player;
    private long postponeSound;
    private boolean silent;
    private SmartLight smartLight;
    private boolean smartLightStart;
    private Thread thread;
    private final long vibrationStartAfter;
    private final Vibrator vibrator;
    private boolean stopRequested = false;
    private boolean finished = false;
    private Integer forcedVolume = null;
    private boolean vibrating = false;
    private Set<IVolumeChangeListener> listeners = new HashSet();
    boolean touchSystemVolume = true;
    private boolean postponeDone = false;

    public GentleAlarmRunnable(Context context, MediaPlayer mediaPlayer, Vibrator vibrator, int i, int i2, boolean z, int i3, int i4, int i5, boolean z2, boolean z3) {
        this.currentVolume = 0;
        this.postponeSound = 0L;
        this.smartLightStart = false;
        this.player = mediaPlayer;
        this.vibrator = vibrator;
        this.context = context;
        this.increaseDuration = i;
        this.silent = z2;
        this.isStreaming = z3;
        this.postponeSound = z ? 0L : i5;
        this.vibrationStartAfter = System.currentTimeMillis() + ((long) i2);
        this.audioStream = i3;
        if (z) {
            this.currentVolume = 100;
        }
        setVolume(this.currentVolume);
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.audioManager = audioManager;
        this.initialVolume = i4;
        if (i3 != -1) {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i4, audioManager.getStreamMaxVolume(i3), "GentleAlarmRunnable: Initialized GAR: ", " -> ", " Starting on max: ");
            sbM.append(z);
            sbM.append(" Forced volume: ");
            sbM.append(this.forcedVolume);
            sbM.append(" Postpone sound: ");
            sbM.append(this.postponeSound);
            sbM.append(" vibrate: ");
            sbM.append(vibrator != null);
            sbM.append(" isStream ");
            sbM.append(z3);
            Logger.logInfo(sbM.toString());
        } else {
            StringBuilder sb = new StringBuilder("GentleAlarmRunnable: Initialized Fixed system volume GAR: ");
            sb.append(i4);
            sb.append(" Starting on max: ");
            sb.append(z);
            sb.append(" Forced volume: ");
            sb.append(this.forcedVolume);
            sb.append(" Postpone sound: ");
            sb.append(this.postponeSound);
            sb.append(" vibrate: ");
            sb.append(vibrator != null);
            sb.append(" isStream ");
            sb.append(z3);
            Logger.logInfo(sb.toString());
        }
        setMaxVolume();
        this.smartLightStart = false;
        this.attr = new AudioAttributes.Builder().setContentType(2).setUsage(4).setLegacyStreamType(i3).build();
    }

    private boolean hasAlreadyProgressedToVibration() {
        return System.currentTimeMillis() >= this.vibrationStartAfter;
    }

    private synchronized boolean isStopRequested() {
        return this.stopRequested;
    }

    private synchronized boolean isSuspended() {
        return this.forcedVolume != null;
    }

    private boolean renewVibrationsStrong() {
        return System.currentTimeMillis() > this.vibrationStartAfter + 60000;
    }

    private synchronized boolean requestStop() {
        try {
            Thread thread = this.thread;
            if (thread != null) {
                thread.interrupt();
            }
            this.stopRequested = true;
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    private synchronized void setFinished(boolean z) {
        this.finished = z;
    }

    private void setMaxVolume() {
        int i;
        int streamMaxVolume;
        if (this.player == null || (i = this.audioStream) == -1 || this.audioManager.getStreamVolume(this.audioStream) == (streamMaxVolume = this.audioManager.getStreamMaxVolume(i))) {
            return;
        }
        VolumeUtil.setStreamVolume(this.context, this.audioStream, streamMaxVolume);
        Logger.logDebug("GentleAlarmRunnable: setMaxVolume " + streamMaxVolume);
    }

    private synchronized void setVolume(int i) {
        float fLog;
        try {
            Integer num = this.forcedVolume;
            if (num != null) {
                i = num.intValue();
            }
            float f = 1.0f;
            if (i < 100) {
                fLog = 1.0f - (((float) Math.log(100 - i)) / ((float) Math.log(100.0d)));
            } else {
                fLog = 1.0f;
            }
            if (fLog < 0.0f) {
                f = 0.0f;
            } else if (fLog <= 1.0f) {
                f = fLog;
            }
            try {
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    this.player.setVolume(f, f);
                }
            } catch (IllegalStateException e) {
                Logger.logWarning(e.toString());
            }
            Iterator<IVolumeChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().volumeUpdated(f);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void addVolumeListener(IVolumeChangeListener iVolumeChangeListener) {
        this.listeners.add(iVolumeChangeListener);
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public float getVolume() {
        return this.currentVolume / 100.0f;
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void mute() {
        this.currentVolume = 0;
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void renewVibration() {
        try {
            if (this.vibrator != null && !isSuspended() && hasAlreadyProgressedToVibration()) {
                Logger.logDebug("GentleAlarmRunnable: Renewing vibrations.");
                this.vibrating = true;
                this.vibrator.cancel();
                if (renewVibrationsStrong()) {
                    Logger.logInfo("GentleAlarmRunnable: renew vibrate()");
                    this.vibrator.vibrate(AlarmKlaxon.sVibratePatternResume, 0, this.attr);
                } else {
                    Logger.logInfo("GentleAlarmRunnable: renew vibrate()");
                    this.vibrator.vibrate(AlarmKlaxon.sVibratePattern, 0, this.attr);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void reset() {
        try {
            if (this.audioStream != -1) {
                Logger.logDebug("GentleAlarmRunnable: Resetting initial volume back to initial volume: " + this.initialVolume);
                VolumeUtil.setStreamVolume(this.context, this.audioStream, this.initialVolume);
            }
            resume();
            if (this.vibrating && this.vibrator != null) {
                Logger.logDebug("GentleAlarmRunnable: Cancelling vibrations");
                this.vibrator.cancel();
            }
            requestStop();
            this.player = null;
            Logger.logDebug("GentleAlarmRunnable finished.");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void resume() {
        this.forcedVolume = null;
        setVolume(this.currentVolume);
        renewVibration();
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0165, code lost:
    
        java.lang.Thread.sleep(r2);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        long j = this.increaseDuration / 100;
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("GentleAlarmRunnable: Starting gentle alarm with initial volume: ");
        sb.append(this.currentVolume);
        sb.append(" and increase duration: ");
        sb.append(this.increaseDuration);
        sb.append(" Stream volume: ");
        sb.append(this.initialVolume);
        sb.append(" Vibration after: ");
        sb.append(this.vibrator != null ? Long.valueOf(this.vibrationStartAfter - System.currentTimeMillis()) : "-");
        Logger.logDebug(sb.toString());
        while (true) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            synchronized (this) {
                try {
                    if (this.thread == null) {
                        this.thread = Thread.currentThread();
                    }
                    setMaxVolume();
                    if (!isStopRequested()) {
                        if (this.vibrator != null && !this.vibrating && hasAlreadyProgressedToVibration() && !isSuspended()) {
                            Logger.logInfo("GentleAlarmRunnable: vibrate()");
                            this.vibrator.vibrate(AlarmKlaxon.sVibratePattern, 15, this.attr);
                            this.vibrating = true;
                        }
                        long j2 = this.postponeSound;
                        if (j2 > jCurrentTimeMillis2) {
                            try {
                                wait(Math.max(Math.min(j2, 10000L), 0L));
                                this.postponeDone = false;
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            if (!this.postponeDone && j2 > 0 && !this.isStreaming) {
                                this.postponeDone = true;
                                try {
                                    MediaPlayer mediaPlayer = this.player;
                                    if (mediaPlayer != null) {
                                        Logger.logInfo("GentleAlarmRunnable: reset track " + mediaPlayer.getCurrentPosition());
                                        if (this.player.getCurrentPosition() > 0) {
                                            Logger.logInfo("GentleAlarmRunnable: reset track as postpone reached");
                                            this.player.seekTo(0);
                                        }
                                    }
                                } catch (Exception e) {
                                    Logger.logSevere(e);
                                }
                            }
                            if (this.currentVolume > 100) {
                                try {
                                    wait(j);
                                } catch (InterruptedException unused2) {
                                }
                            }
                            int i = this.currentVolume;
                            if (i >= 0) {
                                if (i % 5 == 0) {
                                    if (i < 150) {
                                        Logger.logInfo("GentleAlarmRunnable: Current GAR volume update: " + this.currentVolume);
                                    }
                                    Intent intent = new Intent("com.urbandroid.sleep.ACTION_VOLUME_UPDATE");
                                    intent.putExtra("EXTRA_VOLUME", this.silent ? -1 : this.currentVolume);
                                    LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
                                }
                                int i2 = this.currentVolume + 1;
                                this.currentVolume = i2;
                                SmartLight smartLight = this.smartLight;
                                if (smartLight != null) {
                                    if (this.smartLightStart) {
                                        smartLight.sunrise(i2, 100);
                                    } else {
                                        this.smartLightStart = true;
                                        smartLight.sunriseStart();
                                        this.smartLight.sunrise(this.currentVolume, 100);
                                    }
                                }
                                if (!isStopRequested()) {
                                    setVolume(this.currentVolume);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        setFinished(true);
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void suspend(int i, boolean z) {
        try {
            Integer numValueOf = Integer.valueOf(i == 1 ? 10 : 0);
            this.forcedVolume = numValueOf;
            int iIntValue = numValueOf.intValue();
            int i2 = this.currentVolume;
            if (iIntValue > i2 && !z) {
                this.forcedVolume = Integer.valueOf(i2);
            }
            Logger.logInfo("GentleAlarmRunnable: Suspending alarm - volume " + this.forcedVolume + " current " + this.currentVolume);
            setVolume(this.forcedVolume.intValue());
            if (this.vibrator != null) {
                Logger.logDebug("GentleAlarmRunnable: CANCELLING VIBRATOR");
                this.vibrator.cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

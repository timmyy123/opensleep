package com.urbandroid.sleep.alarmclock.volume;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.util.VolumeUtil;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes4.dex */
public class VolumeControlRunnable implements IVolumeControlRunnable {
    private AudioAttributes attr;
    private AudioManager audioManager;
    private Context context;
    private int currentVolume;
    private boolean finished;
    private Integer forcedVolume;
    private boolean increase;
    private int initialVolume;
    private int maxVolume;
    private int originalVolume;
    private int pause;
    private MediaPlayer player;
    private long postpone;
    private boolean reachedTargetVolume;
    private boolean shouldStartOnMaximumVolume;
    private int sleep;
    private boolean stop;
    private int streamtype;
    private long vibrateAfter;
    private boolean vibrating;
    private Vibrator vibrator;

    public VolumeControlRunnable(Context context, MediaPlayer mediaPlayer, int i, boolean z, int i2, boolean z2, Vibrator vibrator, int i3, int i4, int i5, int i6, long j) {
        this.sleep = DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT;
        this.increase = true;
        this.reachedTargetVolume = false;
        this.initialVolume = -1;
        this.originalVolume = -1;
        this.currentVolume = 0;
        this.forcedVolume = null;
        this.stop = false;
        this.pause = -1;
        this.finished = false;
        this.vibrating = false;
        this.shouldStartOnMaximumVolume = false;
        StringBuilder sb = new StringBuilder("VolumeControlRunnable::VolumeControlRunnable - start on max: ");
        sb.append(z2);
        sb.append(" Original: ");
        sb.append(i3);
        sb.append(" Initial: ");
        Fragment$$ExternalSyntheticOutline1.m(sb, i4, " maxVolume: ", i5, " Vibrate after: ");
        sb.append(i6);
        sb.append(" Postpone: ");
        sb.append(j);
        sb.append(" Increase: ");
        sb.append(z);
        sb.append(" Speed: ");
        sb.append(i);
        sb.append(" streamtype: ");
        sb.append(i2 == 3 ? "MUSIC" : "ALARM");
        sb.append("[");
        sb.append(i2);
        sb.append("]");
        Log.e("VolumeControlRunnable", sb.toString());
        StringBuilder sb2 = new StringBuilder("VolumeControlRunnable::VolumeControlRunnable - start on max: ");
        sb2.append(z2);
        sb2.append(" Original: ");
        Fragment$$ExternalSyntheticOutline1.m(sb2, i3, " Initial: ", i4, " maxVolume: ");
        Fragment$$ExternalSyntheticOutline1.m(sb2, i5, " Vibrate after: ", i6, " Postpone: ");
        long j2 = j;
        sb2.append(j2);
        sb2.append(" Increase: ");
        sb2.append(z);
        sb2.append(" Speed: ");
        sb2.append(i);
        sb2.append(" streamtype: ");
        sb2.append(i2 == 3 ? "MUSIC" : "ALARM");
        sb2.append("[");
        sb2.append(i2);
        sb2.append("]");
        Logger.logInfo(sb2.toString());
        this.player = mediaPlayer;
        this.context = context;
        this.sleep = i;
        this.increase = z;
        this.streamtype = i2;
        this.vibrator = vibrator;
        this.vibrateAfter = System.currentTimeMillis() + ((long) i6);
        this.shouldStartOnMaximumVolume = z2;
        this.postpone = z2 ? 0L : j2;
        if (i4 >= 0) {
            this.initialVolume = i4;
        } else {
            this.initialVolume = ((AudioManager) context.getSystemService("audio")).getStreamVolume(i2);
        }
        if (i3 >= 0) {
            this.originalVolume = i3;
        } else {
            this.originalVolume = ((AudioManager) context.getSystemService("audio")).getStreamVolume(i2);
        }
        if (i5 < 0 || z2) {
            this.maxVolume = ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(i2);
        } else {
            this.maxVolume = i5;
        }
        this.attr = new AudioAttributes.Builder().setContentType(2).setUsage(4).setLegacyStreamType(i2).build();
    }

    public static int convertIncreaseDurationToIncreaseSpeed(Context context, int i, int i2) {
        int streamMaxVolume = ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(i2);
        if (streamMaxVolume < 1) {
            streamMaxVolume = 1;
        }
        if (i <= 0) {
            return 0;
        }
        return i / streamMaxVolume;
    }

    private synchronized int getPause() {
        return this.pause;
    }

    private boolean hasAlreadyProgressedToVibration() {
        if (this.maxVolume == 0) {
            return false;
        }
        Logger.logInfo("VolumeControlRunnable: hasAlreadyProgressedToVibration " + System.currentTimeMillis() + " " + this.vibrateAfter);
        return System.currentTimeMillis() > this.vibrateAfter;
    }

    private synchronized boolean isStop() {
        return this.stop;
    }

    private synchronized boolean isSuspended() {
        return this.forcedVolume != null;
    }

    private boolean renewVibrationsStrong() {
        return System.currentTimeMillis() > this.vibrateAfter + 60000;
    }

    private synchronized boolean setStop() {
        this.stop = true;
        return true;
    }

    private synchronized void setVolume(int i, int i2, boolean z) {
        Integer num;
        try {
            Logger.logDebug("VolumeControlRunnable: VOLUME " + i2 + " Forced: " + this.forcedVolume + " HF: " + z);
            if (z && (num = this.forcedVolume) != null && num.intValue() < i2) {
                i2 = this.forcedVolume.intValue();
            }
            if (this.audioManager != null) {
                Logger.logInfo("VolumeControlRunnable: VolumeControlRunnable: setStreamVolume: " + i2);
                setVolumeFixNonZero(this.context, i, i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void setVolumeFixNonZero(Context context, int i, int i2) {
        try {
            try {
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer != null && i == 4 && this.sleep == 0) {
                    if (i2 == 0) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        mediaPlayer.setVolume(1.0f, 1.0f);
                    }
                }
            } catch (Exception unused) {
                Logger.logSevere("VolumeControlRunnable: cannot set player zero volume to fix non-zero alarm stream problem");
            }
            VolumeUtil.setStreamVolume(context, i, i2);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void updateVolume() {
        int iRound = (int) Math.round((((double) this.currentVolume) / ((double) ((AudioManager) this.context.getSystemService("audio")).getStreamMaxVolume(this.streamtype))) * 100.0d);
        Logger.logInfo("VolumeControlRunnable: volume update " + iRound);
        Intent intent = new Intent("com.urbandroid.sleep.ACTION_VOLUME_UPDATE");
        intent.putExtra("EXTRA_VOLUME", iRound);
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public float getVolume() {
        return this.currentVolume / this.maxVolume;
    }

    public synchronized boolean isFinished() {
        return this.finished;
    }

    public boolean isReachedTargetVolume() {
        return this.reachedTargetVolume;
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void mute() {
        Logger.logInfo("VolumeControlRunnable: mute()");
        this.currentVolume = 0;
        setVolumeFixNonZero(this.context, this.streamtype, 0);
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void renewVibration() {
        try {
            if (this.vibrator != null && !isSuspended() && hasAlreadyProgressedToVibration()) {
                Logger.logDebug("VolumeControlRunnable: renewing vibrations ");
                this.vibrating = true;
                this.vibrator.cancel();
                if (renewVibrationsStrong()) {
                    Logger.logInfo("VolumeControlRunnable: renew vibrate()");
                    this.vibrator.vibrate(AlarmKlaxon.sVibratePatternResume, 0, this.attr);
                } else {
                    Logger.logInfo("VolumeControlRunnable: vibrate()");
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
            Logger.logDebug("VolumeControlRunnable: Stop initial volume: " + this.initialVolume);
            resume();
            if (this.vibrating) {
                Logger.logDebug("VolumeControlRunnable: Cancelling vibrations");
                this.vibrator.cancel();
            }
            setStop();
            setInitialVolume();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void resume() {
        Logger.logDebug("VolumeControlRunnable: resume ");
        this.forcedVolume = null;
        setVolume(this.streamtype, this.currentVolume, true);
        renewVibration();
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0218, code lost:
    
        com.urbandroid.common.logging.Logger.logDebug("VolumeControlRunnable: Pause sleep done");
        java.lang.Thread.sleep(r10.sleep);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0228, code lost:
    
        if (getPause() <= (-1)) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x022a, code lost:
    
        r1 = getPause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x022e, code lost:
    
        if (r1 <= (-1)) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0230, code lost:
    
        setPause(-1);
        com.urbandroid.common.logging.Logger.logDebug("Pause sleep");
        java.lang.Thread.sleep(r1);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                this.audioManager = (AudioManager) this.context.getSystemService("audio");
                Logger.logDebug("VolumeControlRunnable: Initial volume " + this.initialVolume + " Increase speed: " + this.sleep + " Original volume: " + this.originalVolume);
                if (this.increase) {
                    this.currentVolume = this.initialVolume;
                    Logger.logDebug("VolumeControlRunnable: setVolumeStream() -> " + this.initialVolume);
                    setVolumeFixNonZero(this.context, this.streamtype, this.initialVolume);
                    if (this.currentVolume > 0 && this.postpone == 0) {
                        updateVolume();
                    }
                } else {
                    this.currentVolume = this.audioManager.getStreamVolume(this.streamtype);
                }
                if (this.shouldStartOnMaximumVolume) {
                    int i = this.maxVolume;
                    this.currentVolume = i;
                    setVolumeFixNonZero(this.context, this.streamtype, i);
                }
                Logger.logDebug("VolumeControlRunnable: VOLUME FIRST. Current: " + this.currentVolume + " Max: " + this.maxVolume);
                try {
                    int iMin = this.sleep;
                    if (this.increase && this.currentVolume == 0) {
                        iMin = Math.min(15000, iMin);
                    }
                    if (this.sleep > 0) {
                        Logger.logInfo("VolumeControlRunnable: Doing initial sleep: " + iMin);
                        wait((long) iMin);
                    }
                } catch (InterruptedException unused) {
                    Logger.logInfo("VolumeControlRunnable: Interrupted in start block.");
                }
            } finally {
            }
        }
        while (true) {
            try {
                try {
                    if (Thread.interrupted()) {
                        break;
                    }
                    synchronized (this) {
                        try {
                            if (isStop() || this.currentVolume < 0) {
                                break;
                            }
                            if (this.increase && this.vibrator != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("VolumeControlRunnable: Vibrate ");
                                sb.append(hasAlreadyProgressedToVibration());
                                sb.append(" ");
                                sb.append(!isSuspended());
                                sb.append(" ");
                                sb.append(!this.vibrating);
                                Logger.logDebug(sb.toString());
                                if (hasAlreadyProgressedToVibration() && !isSuspended()) {
                                    if (!this.vibrating) {
                                        Logger.logDebug("VolumeControlRunnable: Starting vibrator.");
                                    }
                                    Logger.logInfo("VolumeControlRunnable: vibrate()");
                                    this.vibrator.vibrate(AlarmKlaxon.sVibratePattern, 15, this.attr);
                                }
                                this.vibrating = true;
                            }
                            Logger.logDebug("VolumeControlRunnable: CURRENT VOLUME " + this.currentVolume + " INITIAL  " + this.initialVolume + " MAX " + this.maxVolume);
                            if (this.increase) {
                                if (this.postpone > 0) {
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    long j = this.postpone;
                                    if (jCurrentTimeMillis2 < j) {
                                        wait(Math.min(j, 10000L));
                                    }
                                }
                                int i2 = this.currentVolume + 1;
                                this.currentVolume = i2;
                                int i3 = this.maxVolume;
                                if (i2 > i3) {
                                    this.currentVolume = i3;
                                    setVolume(this.streamtype, i3, true);
                                    wait(5000L);
                                    Logger.logInfo(getClass().getSimpleName() + ": reached target volume " + this.currentVolume);
                                    this.reachedTargetVolume = true;
                                    updateVolume();
                                } else {
                                    updateVolume();
                                }
                            } else {
                                int streamVolume = this.audioManager.getStreamVolume(this.streamtype) - 1;
                                this.currentVolume = streamVolume;
                                if (streamVolume < 0) {
                                    this.currentVolume = 0;
                                    Logger.logInfo(getClass().getSimpleName() + ": reached target volume " + this.currentVolume);
                                    this.reachedTargetVolume = true;
                                }
                            }
                            if (!this.stop) {
                                setVolume(this.streamtype, this.currentVolume, true);
                            }
                        } finally {
                        }
                    }
                } catch (InterruptedException unused2) {
                    Logger.logDebug("Interrupted");
                }
            } finally {
                Logger.logDebug("VCRunnable finished.");
                setFinished(true);
            }
        }
        Logger.logDebug("VolumeControlRunnable: Stopping volume control runnable");
    }

    public synchronized void setFinished(boolean z) {
        this.finished = z;
    }

    public synchronized void setInitialVolume() {
        int i = this.originalVolume;
        if (i != -1) {
            setVolume(this.streamtype, i, false);
        }
    }

    public synchronized void setPause(int i) {
        this.pause = i;
    }

    @Override // com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable
    public synchronized void suspend(int i, boolean z) {
        Logger.logInfo("VolumeControlRunnable: forcing suspend mode " + i + " stream " + this.streamtype);
        Integer numValueOf = Integer.valueOf(i == 1 ? 1 : 0);
        this.forcedVolume = numValueOf;
        int iMin = Math.min(numValueOf.intValue(), this.currentVolume);
        Logger.logInfo("VolumeControlRunnable: forcing suspend volume " + iMin);
        setVolume(this.streamtype, iMin, true);
        if (this.vibrator != null) {
            Logger.logDebug("VolumeControlRunnable: CANCELLING VIBRATOR");
            this.vibrator.cancel();
        }
    }

    public VolumeControlRunnable(Context context, MediaPlayer mediaPlayer, int i, boolean z, int i2, boolean z2, int i3, int i4, int i5, long j) {
        this(context, mediaPlayer, i, z, i2, z2, null, i3, i4, i5, 0, j);
    }
}

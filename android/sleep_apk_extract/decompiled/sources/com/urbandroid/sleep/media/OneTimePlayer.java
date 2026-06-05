package com.urbandroid.sleep.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.util.VolumeUtil;

/* JADX INFO: loaded from: classes.dex */
public class OneTimePlayer {
    private MediaPlayer.OnCompletionListener listener;
    private MediaPlayer player;
    private int stream;
    private Handler handler = new Handler();
    private float minVolume = -1.0f;
    private Runnable stopRunnable = new Runnable() { // from class: com.urbandroid.sleep.media.OneTimePlayer.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (OneTimePlayer.this.listener != null) {
                    OneTimePlayer.this.listener.onCompletion(OneTimePlayer.this.player);
                }
                if (OneTimePlayer.this.player != null) {
                    OneTimePlayer.this.player.stop();
                }
            } catch (Exception unused) {
            }
        }
    };
    private int originalVolume = -1;
    private int originalRingerMode = -1;

    private void enforceStreamVolume(Context context) {
        if (AlarmKlaxon.isRunning() || this.minVolume <= 0.0f) {
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.originalVolume = audioManager.getStreamVolume(this.stream);
        this.originalRingerMode = audioManager.getRingerMode();
        int streamMaxVolume = audioManager.getStreamMaxVolume(this.stream);
        int iMax = Math.max(1, Math.round(streamMaxVolume * this.minVolume));
        if (this.originalVolume < iMax) {
            StringBuilder sb = new StringBuilder("OneTimePlayer: Adjust volume, original ");
            Fragment$$ExternalSyntheticOutline1.m(sb, this.originalVolume, " max ", streamMaxVolume, " threshold ");
            sb.append(iMax);
            sb.append(" ringer mode ");
            zza$$ExternalSyntheticOutline0.m(sb, this.originalRingerMode);
            VolumeUtil.setStreamVolume(context, this.stream, iMax);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$play$0(Context context, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer mediaPlayer) {
        this.handler.removeCallbacks(this.stopRunnable);
        Logger.logInfo("OneTimePlayer: complete ");
        try {
            mediaPlayer.stop();
            mediaPlayer.release();
            revertStreamVolume(context);
        } catch (Exception e) {
            Logger.logWarning("Player stop failed", e);
        }
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this.player);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$play$1(Uri uri, MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "OneTimePlayer: Media playback error ", " ", " uri ");
        sbM.append(uri);
        Logger.logSevere(sbM.toString());
        return true;
    }

    private void revertStreamVolume(Context context) {
        if (AlarmKlaxon.isRunning() || this.minVolume <= 0.0f) {
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(this.stream);
        int iMax = Math.max(1, Math.round(streamMaxVolume * this.minVolume));
        int i = this.originalVolume;
        if (i != -1 && i < iMax) {
            StringBuilder sb = new StringBuilder("OneTimePlayer: Adjust volume back, original ");
            Fragment$$ExternalSyntheticOutline1.m(sb, this.originalVolume, " max ", streamMaxVolume, " threshold ");
            sb.append(iMax);
            Logger.logWarning(sb.toString());
            VolumeUtil.setStreamVolume(context, this.stream, this.originalVolume);
        }
        int ringerMode = audioManager.getRingerMode();
        int i2 = this.originalRingerMode;
        if (i2 == -1 || ringerMode == i2) {
            return;
        }
        Logger.logWarning("OneTimePlayer: revert ringer mode " + this.originalRingerMode);
        audioManager.setRingerMode(this.originalRingerMode);
    }

    public synchronized void play(final Context context, Uri uri, int i, int i2, float f, final MediaPlayer.OnCompletionListener onCompletionListener) {
        this.minVolume = f;
        this.listener = onCompletionListener;
        Logger.logInfo("OneTimePlayer: play ");
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.player = mediaPlayer;
        mediaPlayer.setDataSource(context, uri);
        this.player.setAudioStreamType(i);
        this.stream = i;
        enforceStreamVolume(context);
        float fLog = 1.0f;
        if (i2 < 100) {
            fLog = 1.0f - (((float) Math.log(100 - i2)) / ((float) Math.log(100.0d)));
        }
        this.player.setVolume(fLog, fLog);
        this.player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.urbandroid.sleep.media.OneTimePlayer$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                this.f$0.lambda$play$0(context, onCompletionListener, mediaPlayer2);
            }
        });
        this.player.setOnErrorListener(new OneTimePlayer$$ExternalSyntheticLambda1(uri, 0));
        try {
            this.player.prepare();
            this.player.setLooping(false);
            this.player.start();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        this.handler.removeCallbacks(this.stopRunnable);
        this.handler.postDelayed(this.stopRunnable, this.player.getDuration() + 500);
    }

    public synchronized void setVolume(int i) {
        MediaPlayer mediaPlayer;
        try {
            mediaPlayer = this.player;
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            float f = i;
            this.player.setVolume(f, f);
        }
    }

    public synchronized void stop() {
        try {
            try {
                MediaPlayer mediaPlayer = this.player;
                if (mediaPlayer != null) {
                    try {
                        mediaPlayer.stop();
                    } catch (IllegalStateException e) {
                        Logger.logSevere(e);
                    }
                    this.player.release();
                }
            } catch (IllegalStateException e2) {
                Logger.logSevere(e2);
            }
        } finally {
            this.player = null;
        }
    }
}

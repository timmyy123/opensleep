package com.urbandroid.sleep.media.lullaby;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class GaplessMediaPlayer {
    private Context context;
    private AssetFileDescriptor fd;
    private MediaPlayer player1;
    private MediaPlayer player2;
    private Uri uri;
    private float currentVolume = 1.0f;
    private boolean stopped = false;
    private int failedCounter = 0;
    private Handler h = new Handler();

    public GaplessMediaPlayer(Context context, AssetFileDescriptor assetFileDescriptor) {
        this.fd = assetFileDescriptor;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompletion(final Context context, MediaPlayer mediaPlayer) {
        if (this.stopped) {
            return;
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.urbandroid.sleep.media.lullaby.GaplessMediaPlayer.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                if (GaplessMediaPlayer.this.stopped) {
                    return;
                }
                try {
                    GaplessMediaPlayer.this.player1.release();
                    GaplessMediaPlayer gaplessMediaPlayer = GaplessMediaPlayer.this;
                    gaplessMediaPlayer.player1 = gaplessMediaPlayer.player2;
                    final MediaPlayer mediaPlayer3 = new MediaPlayer();
                    mediaPlayer3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.media.lullaby.GaplessMediaPlayer.3.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer4) {
                            if (GaplessMediaPlayer.this.stopped) {
                                return;
                            }
                            try {
                                GaplessMediaPlayer.this.player1.setNextMediaPlayer(mediaPlayer3);
                                GaplessMediaPlayer.this.player2 = mediaPlayer3;
                                GaplessMediaPlayer.this.player1.setVolume(GaplessMediaPlayer.this.currentVolume, GaplessMediaPlayer.this.currentVolume);
                                GaplessMediaPlayer.this.player2.setVolume(GaplessMediaPlayer.this.currentVolume, GaplessMediaPlayer.this.currentVolume);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                GaplessMediaPlayer gaplessMediaPlayer2 = GaplessMediaPlayer.this;
                                gaplessMediaPlayer2.handleCompletion(context, gaplessMediaPlayer2.player1);
                            } catch (IllegalStateException unused) {
                                if (GaplessMediaPlayer.this.stopped) {
                                    return;
                                }
                                ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Gapless error");
                            }
                        }
                    });
                    GaplessMediaPlayer.this.resetPlayer(context, mediaPlayer3);
                } catch (IllegalStateException unused) {
                    if (GaplessMediaPlayer.this.stopped) {
                        return;
                    }
                    ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Gapless error");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPlayer(final Context context, MediaPlayer mediaPlayer) {
        final MediaPlayer mediaPlayer2;
        try {
            mediaPlayer.reset();
            Uri uri = this.uri;
            if (uri != null) {
                mediaPlayer.setDataSource(context, uri);
                mediaPlayer2 = mediaPlayer;
            } else {
                mediaPlayer2 = mediaPlayer;
                try {
                    mediaPlayer2.setDataSource(this.fd.getFileDescriptor(), this.fd.getStartOffset(), this.fd.getLength());
                } catch (Exception e) {
                    e = e;
                    Logger.logSevere("Cannot prepare player, failed counter " + this.failedCounter, e);
                    int i = this.failedCounter + 1;
                    this.failedCounter = i;
                    if (i < 5) {
                        this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.media.lullaby.GaplessMediaPlayer.2
                            @Override // java.lang.Runnable
                            public void run() {
                                GaplessMediaPlayer.this.resetPlayer(context, mediaPlayer2);
                            }
                        }, 100L);
                        return;
                    }
                    return;
                }
            }
            mediaPlayer2.prepare();
            this.failedCounter = 0;
        } catch (Exception e2) {
            e = e2;
            mediaPlayer2 = mediaPlayer;
        }
    }

    private void stopPlayer(MediaPlayer mediaPlayer) {
        try {
            try {
                try {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                } catch (Exception e) {
                    Logger.logSevere("Cannot stop player", e);
                    mediaPlayer.release();
                }
            } catch (Exception e2) {
                Logger.logSevere("Cannot release player", e2);
            }
        } catch (Throwable th) {
            try {
                mediaPlayer.release();
            } catch (Exception e3) {
                Logger.logSevere("Cannot release player", e3);
            }
            throw th;
        }
    }

    public void pause() {
        this.player1.pause();
    }

    public void resume() {
        this.player1.start();
    }

    public void setCurrentVolume(float f) {
        Logger.logInfo("VOL " + f);
        this.currentVolume = f;
        try {
            this.player1.setVolume(f, f);
        } catch (Exception unused) {
        }
        try {
            MediaPlayer mediaPlayer = this.player2;
            float f2 = this.currentVolume;
            mediaPlayer.setVolume(f2, f2);
        } catch (Exception unused2) {
        }
    }

    public void setVolume(float f) {
        Logger.logInfo("VOL " + f);
        this.currentVolume = f;
    }

    public void start() {
        Logger.logInfo("Gapless start");
        this.player1 = new MediaPlayer();
        this.player2 = new MediaPlayer();
        Logger.logInfo("Player1 " + this.player1);
        Logger.logInfo("Player2 " + this.player2);
        this.player1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.media.lullaby.GaplessMediaPlayer.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                GaplessMediaPlayer.this.player1.setNextMediaPlayer(GaplessMediaPlayer.this.player2);
                Logger.logInfo("REAL VOL " + GaplessMediaPlayer.this.currentVolume);
                GaplessMediaPlayer.this.player1.setVolume(GaplessMediaPlayer.this.currentVolume, GaplessMediaPlayer.this.currentVolume);
                GaplessMediaPlayer.this.player2.setVolume(GaplessMediaPlayer.this.currentVolume, GaplessMediaPlayer.this.currentVolume);
                GaplessMediaPlayer.this.player1.start();
            }
        });
        handleCompletion(this.context, this.player1);
        resetPlayer(this.context, this.player1);
        resetPlayer(this.context, this.player2);
    }

    public void stop() {
        this.stopped = true;
        Logger.logInfo("Gapless stop");
        stopPlayer(this.player1);
        stopPlayer(this.player2);
    }
}

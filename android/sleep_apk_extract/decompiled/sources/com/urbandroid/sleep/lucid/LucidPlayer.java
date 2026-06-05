package com.urbandroid.sleep.lucid;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.media.OneTimePlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class LucidPlayer {
    private static OneTimePlayer player;
    private final AtomicBoolean suspended = new AtomicBoolean(false);
    private final AtomicBoolean paused = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$play$0(int i, Context context, int i2, int i3, Uri uri, MediaPlayer mediaPlayer) {
        if (i == 1) {
            pauseRecording(context, false);
        }
        play(context, i2, i3, uri, i - 1, false);
    }

    private void pauseRecording(Context context, boolean z) {
        Intent intent = new Intent(z ? "com.urbandroid.sleep.ACTION_PAUSE_RECORDING" : "com.urbandroid.sleep.ACTION_RESUME_RECORDING");
        intent.putExtra("extra_pause_reason", AudioRecorder.PauseReason.LUCID);
        ContextExtKt.sendExplicitBroadcast(context, intent);
        this.paused.set(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.urbandroid.sleep.lucid.LucidPlayer] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.urbandroid.sleep.lucid.LucidPlayer] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r12v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    public boolean play(final Context context, final int i, final int i2, final Uri uri, final int i3, boolean z) {
        ?? r12;
        Exception exc;
        ?? r10;
        Logger.logInfo("LucidPlayer: Playing Lucid " + uri.toString() + " " + i3 + " " + ((int) i2));
        if ("silent".equals(uri.toString())) {
            Logger.logInfo("LucidPlayer: Silent cue ");
            return false;
        }
        if (player == null) {
            player = new OneTimePlayer();
        }
        try {
            try {
                if (this.suspended.get() || i3 <= 0) {
                    if (this.paused.get()) {
                        pauseRecording(context, false);
                    }
                    player = null;
                    return false;
                }
                if (z) {
                    try {
                        pauseRecording(context, true);
                    } catch (Exception e) {
                        exc = e;
                        r12 = context;
                        r10 = this;
                    }
                }
                context = this;
                try {
                    player.play(context, uri, i, i2, 0.5f, new MediaPlayer.OnCompletionListener() { // from class: com.urbandroid.sleep.lucid.LucidPlayer$$ExternalSyntheticLambda0
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            this.f$0.lambda$play$0(i3, context, i, i2, uri, mediaPlayer);
                        }
                    });
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    i2 = context;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            i2 = context;
            context = this;
        }
        exc = e;
        r10 = context;
        r12 = i2;
        Logger.logSevere(exc);
        if (r10.paused.get()) {
            Logger.logInfo("LucidPlayer: Failed resuming recording");
            r10.pauseRecording(r12, false);
        }
        return false;
    }

    public void resume() {
        this.suspended.set(false);
    }

    public void stop(Context context) {
        OneTimePlayer oneTimePlayer = player;
        if (oneTimePlayer != null) {
            oneTimePlayer.stop();
            player = null;
            Logger.logInfo("LucidPlayer: Player NULL");
            pauseRecording(context, false);
        }
    }

    public void suspend() {
        this.suspended.set(true);
        OneTimePlayer oneTimePlayer = player;
        if (oneTimePlayer != null) {
            oneTimePlayer.setVolume(0);
        }
    }

    public boolean play(Context context, int i, int i2, Uri uri, int i3) {
        return play(context, i, i2, uri, i3, true);
    }
}

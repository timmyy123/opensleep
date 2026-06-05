package com.urbandroid.sleep.media.player;

import android.content.Context;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/media/player/MusicStopPlayingController;", "Ljava/lang/Runnable;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "playerName", "", "timeoutInSeconds", "", "repeatInMillis", "playbackListener", "Lcom/urbandroid/sleep/media/player/PlaybackListener;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/content/Context;Ljava/lang/String;JJLcom/urbandroid/sleep/media/player/PlaybackListener;Landroid/os/Handler;)V", "startTime", "cancelFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopTime", "Ljava/util/concurrent/atomic/AtomicLong;", "start", "", "cancel", "run", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MusicStopPlayingController implements Runnable {
    private final AtomicBoolean cancelFlag;
    private final Context context;
    private final Handler handler;
    private final PlaybackListener playbackListener;
    private final String playerName;
    private final long repeatInMillis;
    private long startTime;
    private final AtomicLong stopTime;
    private final long timeoutInSeconds;

    public MusicStopPlayingController(Context context, String str, long j, long j2, PlaybackListener playbackListener, Handler handler) {
        context.getClass();
        str.getClass();
        playbackListener.getClass();
        handler.getClass();
        this.context = context;
        this.playerName = str;
        this.timeoutInSeconds = j;
        this.repeatInMillis = j2;
        this.playbackListener = playbackListener;
        this.handler = handler;
        this.cancelFlag = new AtomicBoolean(false);
        this.stopTime = new AtomicLong(-1L);
    }

    public final void cancel() {
        this.cancelFlag.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cancelFlag.get()) {
            Logger.logInfo("MusicStopPlayingController: " + this.playerName + " cancelled");
            return;
        }
        if (ContextExtKt.getAudioManager(this.context).isMusicActive()) {
            this.handler.postDelayed(this, this.repeatInMillis);
            return;
        }
        if (!AlarmKlaxon.isRunning()) {
            Logger.logInfo("MusicStopPlayingController: AlarmKlaxon not running");
            cancel();
            return;
        }
        if (this.stopTime.get() == -1) {
            this.stopTime.set(System.currentTimeMillis());
            this.handler.postDelayed(this, this.repeatInMillis);
            return;
        }
        if (System.currentTimeMillis() - this.stopTime.get() <= TimeUnit.SECONDS.toMillis(this.timeoutInSeconds)) {
            this.handler.postDelayed(this, this.repeatInMillis);
            return;
        }
        Logger.logInfo(this.playerName + " not playing for " + this.timeoutInSeconds + " seconds");
        cancel();
        this.playbackListener.fail(4);
    }

    public final void start() {
        this.startTime = System.currentTimeMillis();
        this.handler.postDelayed(this, this.repeatInMillis);
    }
}

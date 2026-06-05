package com.urbandroid.sleep.media.googlemusic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiContext;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.media.player.MusicActivityController;
import com.urbandroid.sleep.media.player.MusicStopPlayingController;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.media.spotify.ConnectivityChangeReceiver;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010(\u001a\n '*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/urbandroid/sleep/media/googlemusic/GoogleMusicPlayer;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "forcePlay", "activateWifiIfNeeded", "useHeadUp", "Lcom/urbandroid/sleep/media/player/PlaybackListener;", "playbackListener", "<init>", "(Landroid/content/Context;ZZZLcom/urbandroid/sleep/media/player/PlaybackListener;)V", "", ShareConstants.MEDIA_URI, "", "playInternal", "(Ljava/lang/String;)V", "play", "stop", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Z", "getForcePlay", "()Z", "Lcom/urbandroid/sleep/media/player/PlaybackListener;", "getPlaybackListener", "()Lcom/urbandroid/sleep/media/player/PlaybackListener;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/urbandroid/common/wifi/WifiContext;", "wifiContext", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "playerName", "Ljava/lang/String;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleMusicPlayer {
    private final boolean activateWifiIfNeeded;
    private final Context context;
    private final boolean forcePlay;
    private final Handler handler;
    private final AtomicBoolean isStopped;
    private final PlaybackListener playbackListener;
    private final String playerName;
    private final boolean useHeadUp;
    private final AtomicReference<WifiContext> wifiContext;

    public GoogleMusicPlayer(Context context, boolean z, boolean z2, boolean z3, PlaybackListener playbackListener) {
        context.getClass();
        playbackListener.getClass();
        this.context = context;
        this.forcePlay = z;
        this.activateWifiIfNeeded = z2;
        this.useHeadUp = z3;
        this.playbackListener = playbackListener;
        this.handler = new Handler();
        this.isStopped = new AtomicBoolean(false);
        this.wifiContext = new AtomicReference<>();
        this.playerName = "GoogleMusicPlayer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playInternal(String uri) {
        boolean zIsMusicActive = ContextExtKt.getAudioManager(this.context).isMusicActive();
        Logger.logDebug("GoogleMusicPlayer is playing: " + zIsMusicActive);
        if (!this.forcePlay && zIsMusicActive) {
            this.playbackListener.playbackStarted();
            return;
        }
        if (StringsKt.startsWith$default(uri, "googlemusic://playlist/")) {
            uri = uri.substring(23);
        }
        Logger.logDebug("GoogleMusicPlayer going to play: " + uri);
        Intent intent = new Intent("android.media.action.MEDIA_PLAY_FROM_SEARCH");
        intent.putExtra("android.intent.extra.focus", "vnd.android.cursor.item/playlist");
        intent.putExtra("android.intent.extra.playlist", uri);
        intent.putExtra("query", uri);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.setPackage("com.google.android.music");
        try {
            this.context.startActivity(intent);
            Logger.logInfo("GoogleMusicPlayer: playIntent sent: " + uri);
            Context context = this.context;
            String str = this.playerName;
            str.getClass();
            new MusicActivityController(context, str, 40L, 50L, new PlaybackListener() { // from class: com.urbandroid.sleep.media.googlemusic.GoogleMusicPlayer.playInternal.1
                private final /* synthetic */ PlaybackListener $$delegate_0;

                {
                    this.$$delegate_0 = GoogleMusicPlayer.this.getPlaybackListener();
                }

                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void fail(int reason) {
                    this.$$delegate_0.fail(reason);
                }

                @Override // com.urbandroid.sleep.media.player.PlaybackListener
                public void playbackStarted() {
                    if (AlarmKlaxon.isRunning() && !GoogleMusicPlayer.this.useHeadUp) {
                        Context context2 = GoogleMusicPlayer.this.getContext();
                        Intent intent2 = new Intent(GoogleMusicPlayer.this.getContext(), (Class<?>) AlarmAlertFullScreen.class);
                        intent2.putExtra("CREATION_SOURCE", "GoogleMusicPlayer-Restarting");
                        intent2.putExtra("klaxon_restart", false);
                        intent2.setFlags(872415232);
                        context2.startActivity(intent2);
                    }
                    GoogleMusicPlayer.this.getPlaybackListener().playbackStarted();
                    Context context3 = GoogleMusicPlayer.this.getContext();
                    String str2 = GoogleMusicPlayer.this.playerName;
                    str2.getClass();
                    new MusicStopPlayingController(context3, str2, 10L, 1000L, this, GoogleMusicPlayer.this.handler).start();
                }
            }, this.handler).start();
        } catch (ActivityNotFoundException e) {
            Logger.logWarning("Google Music app not found", e);
            this.playbackListener.fail(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stop$lambda$0(GoogleMusicPlayer googleMusicPlayer) {
        WifiContext wifiContext = googleMusicPlayer.wifiContext.get();
        if (wifiContext != null) {
            wifiContext.disable();
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final PlaybackListener getPlaybackListener() {
        return this.playbackListener;
    }

    public final void play(final String uri) {
        uri.getClass();
        this.isStopped.set(false);
        boolean zIsConnected = ConnectivityChangeReceiver.isConnected(ContextExtKt.getConnectivityManager(this.context));
        Logger.logDebug("GoogleMusicPlayer play [connected: " + zIsConnected + "] ...");
        if (this.activateWifiIfNeeded || zIsConnected) {
            this.wifiContext.set(WifiEnabler.getInstance().enable(GoogleMusicPlayer.class, 45, new WifiEnabler.OnConnectListener() { // from class: com.urbandroid.sleep.media.googlemusic.GoogleMusicPlayer.play.1
                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void connected(WifiContext wifiContext) {
                    wifiContext.getClass();
                    Logger.logDebug("GoogleMusicPlayer - wifi connected");
                    if (GoogleMusicPlayer.this.isStopped.get()) {
                        return;
                    }
                    GoogleMusicPlayer.this.playInternal(uri);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void failed() {
                    Logger.logDebug("GoogleMusicPlayer - wifi failure");
                    GoogleMusicPlayer.this.getPlaybackListener().fail(1);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void timeouted() {
                    Logger.logDebug("GoogleMusicPlayer - wifi timeout");
                    GoogleMusicPlayer.this.getPlaybackListener().fail(1);
                }
            }));
        } else {
            this.playbackListener.fail(5);
        }
    }

    public final void stop() {
        Logger.logDebug(this.playerName + " stop ...");
        if (this.isStopped.get()) {
            Logger.logDebug(this.playerName + " already stopped");
            return;
        }
        if (this.wifiContext.get() != null) {
            this.handler.postDelayed(new Endpoint$$ExternalSyntheticLambda0(this, 4), 15000L);
        }
        if (ContextExtKt.getAudioManager(this.context).isMusicActive()) {
            Context context = this.context;
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "stop");
            intent.setPackage("com.google.android.music");
            context.sendBroadcast(intent);
        }
    }
}

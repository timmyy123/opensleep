package com.urbandroid.sleep.media.spotify;

import android.content.Context;
import android.net.Uri;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bJ\u0012\u0010\u0002\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0005\u001a\u00020\u0000H&J\b\u0010\u0006\u001a\u00020\u0000H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer;", "", "play", ShareConstants.MEDIA_URI, "", "stop", "setForcePlay", "setMode", "mode", "Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer$PlayerMode;", "PlayerMode", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ISpotifyPlayer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer$PlayerMode;", "", "<init>", "(Ljava/lang/String;I)V", "ALARM", "LULLABY", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PlayerMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlayerMode[] $VALUES;
        public static final PlayerMode ALARM = new PlayerMode("ALARM", 0);
        public static final PlayerMode LULLABY = new PlayerMode("LULLABY", 1);

        private static final /* synthetic */ PlayerMode[] $values() {
            return new PlayerMode[]{ALARM, LULLABY};
        }

        static {
            PlayerMode[] playerModeArr$values = $values();
            $VALUES = playerModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(playerModeArr$values);
        }

        private PlayerMode(String str, int i) {
        }

        public static PlayerMode valueOf(String str) {
            return (PlayerMode) Enum.valueOf(PlayerMode.class, str);
        }

        public static PlayerMode[] values() {
            return (PlayerMode[]) $VALUES.clone();
        }
    }

    ISpotifyPlayer play(String uri);

    ISpotifyPlayer setForcePlay();

    ISpotifyPlayer setMode(PlayerMode mode);

    ISpotifyPlayer stop();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer$Companion;", "", "<init>", "()V", "", "isAppRemoteScopeAllowed", "()Z", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/media/player/PlaybackListener;", "playbackListener", "", "mediaStream", "Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer;", "getSpotifyPlayer", "(Landroid/content/Context;Lcom/urbandroid/sleep/media/player/PlaybackListener;I)Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer;", "isSpotifyPremium", "", ShareConstants.MEDIA_URI, "isSpotifyUri", "(Ljava/lang/String;)Z", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ ISpotifyPlayer getSpotifyPlayer$default(Companion companion, Context context, PlaybackListener playbackListener, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = -1;
            }
            return companion.getSpotifyPlayer(context, playbackListener, i);
        }

        private final boolean isAppRemoteScopeAllowed() {
            return SharedApplicationContext.getSettings().isSpotifyAppRemoteScopeAllowed();
        }

        public final ISpotifyPlayer getSpotifyPlayer(Context context, PlaybackListener playbackListener, int mediaStream) {
            context.getClass();
            playbackListener.getClass();
            Logger.logDebug("getSpotifyPlayer: sdkPlayer premium: " + isSpotifyPremium() + " remoteScopeGranted: " + isAppRemoteScopeAllowed(), null);
            if (!isAppRemoteScopeAllowed()) {
                Logger.logDebug("getSpotifyPlayer: intentPlayer", null);
                return new SpotifyIntentPlayer(context, playbackListener);
            }
            Logger.logDebug("getSpotifyPlayer: sdkPlayer", null);
            boolean z = false;
            if (mediaStream != -1 ? mediaStream == 3 : new Settings(context).getAlarmOutput() > 0) {
                z = true;
            }
            return new SpotifySdkPlayer(context, playbackListener, z);
        }

        public final boolean isSpotifyPremium() {
            return SharedApplicationContext.getSettings().isSpotifyPremium();
        }

        public final boolean isSpotifyUri(String uri) {
            if (uri != null) {
                return StringsKt.startsWith$default(uri, "spotify-play-last-song") || StringsKt.startsWith$default(uri, "spotify:");
            }
            return false;
        }

        public final boolean isSpotifyUri(Uri uri) {
            return uri != null && isSpotifyUri(uri.toString());
        }

        public final ISpotifyPlayer getSpotifyPlayer(Context context, PlaybackListener playbackListener) {
            context.getClass();
            playbackListener.getClass();
            return getSpotifyPlayer$default(this, context, playbackListener, 0, 4, null);
        }
    }
}

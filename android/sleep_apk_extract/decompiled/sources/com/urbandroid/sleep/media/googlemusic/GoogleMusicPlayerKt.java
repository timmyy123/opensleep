package com.urbandroid.sleep.media.googlemusic;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"isGoogleMusicPlaylistUri", "", ShareConstants.MEDIA_URI, "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class GoogleMusicPlayerKt {
    public static final boolean isGoogleMusicPlaylistUri(String str) {
        return (str != null && StringsKt.startsWith$default(str, "googlemusic://playlist/")) || (str != null && StringsKt.startsWith$default(str, "THIS_IS_A_PLAYLIST"));
    }
}

package com.urbandroid.sleep.media.spotify;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\" \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Ljava/util/Map;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SpotifyServiceExecutorKt {
    private static final Map<String, Object> options = MapsKt.mapOf(TuplesKt.to(SpotifyService.LIMIT, 50));
}

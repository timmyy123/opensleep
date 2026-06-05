package com.urbandroid.sleep.gui.toolbar;

import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/gui/toolbar/OffsetObserver;", "", "setExpanded", "", "expanded", "", "setVerticalOffset", SpotifyService.OFFSET, "", "getVerticalOffset", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface OffsetObserver {
    int getVerticalOffset();

    void setExpanded(boolean expanded);

    void setVerticalOffset(int offset);
}

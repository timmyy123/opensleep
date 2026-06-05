package com.urbandroid.sleep.alarmclock.settings;

import java.net.URL;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/DocsItem;", "", "url", "Ljava/net/URL;", "titles", "", "", "<init>", "(Ljava/net/URL;[Ljava/lang/String;)V", "getUrl", "()Ljava/net/URL;", "getTitles", "()[Ljava/lang/String;", "[Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DocsItem {
    private final String[] titles;
    private final URL url;

    public DocsItem(URL url, String... strArr) {
        url.getClass();
        strArr.getClass();
        this.url = url;
        this.titles = strArr;
    }

    public final String[] getTitles() {
        return this.titles;
    }

    public final URL getUrl() {
        return this.url;
    }
}

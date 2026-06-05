package com.urbandroid.sleep.smartlight;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/smartlight/SmartLight;", "", "", "off", "()V", "", "force", "(Z)V", "", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", ViewHierarchyConstants.HINT_KEY, "loop", "shortHint", "close", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SmartLight {
    default void close() {
    }

    void hint();

    void hint(int loop);

    void nightLight(int timeoutSeconds);

    void off();

    void off(boolean force);

    void shortHint();

    void sunrise(int progress, int max);

    void sunriseFull();

    void sunriseStart();
}

package com.urbandroid.sleep.service.awake;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/awake/AwakeDetector;", "", "isAwake", "", "stop", "", "forceNotAwake", "forceAwakeNow", "onScreenOn", "onScreenOff", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AwakeDetector {
    default void forceAwakeNow() {
    }

    default void forceNotAwake() {
    }

    boolean isAwake();

    default void onScreenOff() {
    }

    default void onScreenOn() {
    }

    void stop();
}

package com.launchdarkly.eventsource.background;

import com.launchdarkly.eventsource.MessageEvent;

/* JADX INFO: loaded from: classes4.dex */
public interface BackgroundEventHandler {
    void onClosed();

    void onComment(String str);

    void onError(Throwable th);

    void onMessage(String str, MessageEvent messageEvent);

    void onOpen();
}

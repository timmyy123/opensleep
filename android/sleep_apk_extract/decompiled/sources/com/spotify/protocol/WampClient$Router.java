package com.spotify.protocol;

/* JADX INFO: loaded from: classes4.dex */
public interface WampClient$Router {
    void addReceiver(WampClient$Receiver wampClient$Receiver);

    boolean route(WampMessage wampMessage);
}

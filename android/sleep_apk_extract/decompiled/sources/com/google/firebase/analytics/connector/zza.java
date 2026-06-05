package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zza implements EventHandler {
    static final /* synthetic */ zza zza = new zza();

    private /* synthetic */ zza() {
    }

    @Override // com.google.firebase.events.EventHandler
    public final /* synthetic */ void handle(Event event) {
        AnalyticsConnectorImpl.zza(event);
    }
}

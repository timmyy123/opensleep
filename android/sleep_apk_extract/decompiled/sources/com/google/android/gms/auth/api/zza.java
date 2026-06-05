package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzbe;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zza extends Api.AbstractClientBuilder {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        if (obj == null) {
            return new zzbe(context, looper, clientSettings, null, connectionCallbacks, onConnectionFailedListener);
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}

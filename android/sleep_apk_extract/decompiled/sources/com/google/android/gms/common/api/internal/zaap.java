package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zaap implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    final /* synthetic */ zaar zaa;

    public /* synthetic */ zaap(zaar zaarVar, byte[] bArr) {
        Objects.requireNonNull(zaarVar);
        this.zaa = zaarVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zaar zaarVar = this.zaa;
        ((com.google.android.gms.signin.zae) Preconditions.checkNotNull(zaarVar.zav())).zaa(new zaao(zaarVar));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zaar zaarVar = this.zaa;
        zaarVar.zas().lock();
        try {
            if (zaarVar.zan(connectionResult)) {
                zaarVar.zam();
                zaarVar.zak();
            } else {
                zaarVar.zao(connectionResult);
            }
            this.zaa.zas().unlock();
        } catch (Throwable th) {
            this.zaa.zas().unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}

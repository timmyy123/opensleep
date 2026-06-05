package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zabm implements Runnable {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zabn zab;

    public zabm(zabn zabnVar, ConnectionResult connectionResult) {
        this.zaa = connectionResult;
        Objects.requireNonNull(zabnVar);
        this.zab = zabnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabn zabnVar = this.zab;
        zabk zabkVar = (zabk) zabnVar.zaa.zaC().get(zabnVar.zaf());
        if (zabkVar == null) {
            return;
        }
        if (!this.zaa.isSuccess()) {
            zabkVar.zac(this.zaa, null);
            return;
        }
        zabnVar.zag(true);
        if (zabnVar.zae().requiresSignIn()) {
            zabnVar.zad();
            return;
        }
        try {
            zabnVar.zae().getRemoteService(null, zabnVar.zae().getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.zab.zae().disconnect("Failed to get service from broker.");
            zabkVar.zac(new ConnectionResult(10), null);
        }
    }
}

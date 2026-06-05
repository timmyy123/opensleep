package com.google.android.gms.common.api.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zaag implements zaba {
    private final zabd zaa;
    private boolean zab = false;

    public zaag(zabd zabdVar) {
        this.zaa = zabdVar;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaa() {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final BaseImplementation$ApiMethodImpl zab(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        zac(baseImplementation$ApiMethodImpl);
        return baseImplementation$ApiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final BaseImplementation$ApiMethodImpl zac(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        try {
            zabd zabdVar = this.zaa;
            zaaz zaazVar = zabdVar.zag;
            zaazVar.zai.zaa(baseImplementation$ApiMethodImpl);
            Api.Client client = (Api.Client) zaazVar.zac.get(baseImplementation$ApiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !zabdVar.zab.containsKey(baseImplementation$ApiMethodImpl.getClientKey())) {
                baseImplementation$ApiMethodImpl.run(client);
                return baseImplementation$ApiMethodImpl;
            }
            baseImplementation$ApiMethodImpl.setFailedResult(new Status(17));
            return baseImplementation$ApiMethodImpl;
        } catch (DeadObjectException unused) {
            this.zaa.zar(new zaae(this, this));
            return baseImplementation$ApiMethodImpl;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final boolean zad() {
        if (this.zab) {
            return false;
        }
        zabd zabdVar = this.zaa;
        Set set = zabdVar.zag.zah;
        if (set == null || set.isEmpty()) {
            zabdVar.zaq(null);
            return true;
        }
        this.zab = true;
        Iterator it = set.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m(it);
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zar(new zaaf(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaf(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zag(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zah(int i) {
        zabd zabdVar = this.zaa;
        zabdVar.zaq(null);
        zabdVar.zah.zac(i, this.zab);
    }

    public final /* synthetic */ zabd zaj() {
        return this.zaa;
    }
}

package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzdtb implements zzgta {
    static final /* synthetic */ zzdtb zza = new zzdtb();

    private /* synthetic */ zzdtb() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzblp zzblpVar : (List) obj) {
            if (zzblpVar != null) {
                arrayList.add(zzblpVar);
            }
        }
        return arrayList;
    }
}

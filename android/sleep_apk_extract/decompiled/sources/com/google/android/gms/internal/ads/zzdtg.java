package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzdtg implements zzgta {
    static final /* synthetic */ zzdtg zza = new zzdtg();

    private /* synthetic */ zzdtg() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzdte zzdteVar : (List) obj) {
            if (zzdteVar != null) {
                arrayList.add(zzdteVar);
            }
        }
        return arrayList;
    }
}

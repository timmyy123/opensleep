package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzhbf extends zzhbh {
    public zzhbf(zzgwi zzgwiVar, boolean z) {
        super(zzgwiVar, z);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final /* bridge */ /* synthetic */ Object zzD(List list) {
        ArrayList arrayListZzb = zzgxm.zzb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhbg zzhbgVar = (zzhbg) it.next();
            arrayListZzb.add(zzhbgVar != null ? zzhbgVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZzb);
    }
}

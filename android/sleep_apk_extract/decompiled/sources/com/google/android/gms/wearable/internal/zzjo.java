package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzjo extends zzjf {
    public zzjo(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        super(baseImplementation$ResultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzgm
    public final void zzp(zzfh zzfhVar) {
        ArrayList arrayList = new ArrayList();
        List list = zzfhVar.zzb;
        if (list != null) {
            arrayList.addAll(list);
        }
        zzS(new zzho(zziy.zza(zzfhVar.zza), arrayList));
    }
}

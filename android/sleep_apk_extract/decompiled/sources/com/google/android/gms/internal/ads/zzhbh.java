package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhbh extends zzhay {
    private List zza;

    public zzhbh(zzgwi zzgwiVar, boolean z) {
        super(zzgwiVar, z, true);
        List listZzb = zzgwiVar.isEmpty() ? Collections.EMPTY_LIST : zzgxm.zzb(zzgwiVar.size());
        for (int i = 0; i < zzgwiVar.size(); i++) {
            listZzb.add(null);
        }
        this.zza = listZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzA(int i) {
        super.zzA(i);
        this.zza = null;
    }

    public abstract Object zzD(List list);

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzw(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzhbg(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzx() {
        List list = this.zza;
        if (list != null) {
            zza(zzD(list));
        }
    }
}

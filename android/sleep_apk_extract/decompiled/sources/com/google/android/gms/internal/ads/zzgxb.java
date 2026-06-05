package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzgxb extends zzguk {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzgtk zzb;

    public zzgxb(Iterator it, zzgtk zzgtkVar) {
        this.zza = it;
        this.zzb = zzgtkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguk
    public final Object zza() {
        zzgtk zzgtkVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzgtkVar = this.zzb;
            next = it.next();
        } while (!zzgtkVar.zza(next));
        return next;
    }
}

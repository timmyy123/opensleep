package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzgyc extends zzgul {
    final transient zzgub zza;

    public zzgyc(Map map, zzgub zzgubVar) {
        super(map);
        this.zza = zzgubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgvc
    public final /* bridge */ /* synthetic */ Collection zzc() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    public final Set zzh() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    public final Map zzl() {
        return zzm();
    }
}

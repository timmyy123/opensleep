package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
final class zzfhp implements zzgta {
    final /* synthetic */ zzfhs zza;

    public zzfhp(zzfhs zzfhsVar) {
        Objects.requireNonNull(zzfhsVar);
        this.zza = zzfhsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzcbd zzcbdVar = (zzcbd) obj;
        zzfhq zzfhqVar = new zzfhq(zzcbdVar, new zzfmz(zzcbdVar.zzj), null);
        zzfhs zzfhsVar = this.zza;
        zzfhsVar.zzd(zzfhqVar);
        return zzfhsVar.zzc();
    }
}

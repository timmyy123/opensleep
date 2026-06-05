package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zztx extends zzuw {
    private static final zzuw zza = new zztx();

    private zztx() {
    }

    @Override // com.google.android.gms.internal.measurement.zzuw
    public final String zza(zzti zztiVar) {
        Preconditions.checkNotNull(zztiVar);
        return "singleproc";
    }

    @Override // com.google.android.gms.internal.measurement.zzuw
    public final /* bridge */ /* synthetic */ zzuv zzb(zztr zztrVar, String str, Executor executor, zzru zzruVar, zzti zztiVar) {
        Preconditions.checkNotNull(zztiVar);
        return new zzui(str, Futures.immediateFuture(zztrVar.zza()), zzve.zzd(zztrVar.zzb(), zztrVar.zzf() ? zzadf.zzb() : zzadf.zza()), executor, zzruVar, zztrVar.zzc(), zzwb.zzb());
    }
}

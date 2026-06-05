package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfsc {
    private final Context zza;
    private final Executor zzb;
    private final zzhch zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzfru zze;
    private final zzfqj zzf;
    private final zzcng zzg;

    public zzfsc(Context context, Executor executor, zzhch zzhchVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzfru zzfruVar, zzfqj zzfqjVar, zzcng zzcngVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzhchVar;
        this.zzd = zzuVar;
        this.zze = zzfruVar;
        this.zzf = zzfqjVar;
        this.zzg = zzcngVar;
    }

    public final void zza(List list, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), zzvVar, null, null);
        }
    }

    public final void zzb(final String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfqg zzfqgVar, zzdfg zzdfgVar) {
        ListenableFuture listenableFutureZzc;
        zzfpw zzfpwVarZzn = null;
        if (zzfqj.zza() && ((Boolean) zzbkj.zzd.zze()).booleanValue()) {
            zzfpwVarZzn = zzfpw.zzn(this.zza, 14);
            zzfpwVarZzn.zza();
        }
        if (zzvVar != null) {
            listenableFutureZzc = new zzfrt(zzvVar.zza(), this.zzd, this.zzc, this.zze, this.zzg).zza(str);
        } else {
            listenableFutureZzc = this.zzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfsb
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzc(str);
                }
            });
        }
        zzhbw.zzr(listenableFutureZzc, new zzfsa(this, zzfpwVarZzn, zzfqgVar, zzdfgVar), this.zzb);
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzt zzc(String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzki)).booleanValue() || (!com.google.android.gms.ads.internal.zzt.zzc().zzh(str) && !com.google.android.gms.ads.internal.zzt.zzc().zzi(str))) {
            return this.zzd.zzc(str, null);
        }
        String strZzb = this.zzg.zzb();
        HashMap map = new HashMap();
        if (strZzb != null) {
            map.put((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkj), strZzb);
        }
        return this.zzd.zzc(str, map);
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzu zzd() {
        return this.zzd;
    }

    public final /* synthetic */ zzfqj zze() {
        return this.zzf;
    }
}

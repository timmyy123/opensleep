package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeel {
    private final zzhcg zza;
    private final zzhcg zzb;
    private final zzefv zzc;
    private final zzimo zzd;

    public zzeel(zzhcg zzhcgVar, zzhcg zzhcgVar2, zzefv zzefvVar, zzimo zzimoVar) {
        this.zza = zzhcgVar;
        this.zzb = zzhcgVar2;
        this.zzc = zzefvVar;
        this.zzd = zzimoVar;
    }

    public final ListenableFuture zza(final zzcbd zzcbdVar) {
        ListenableFuture listenableFutureZzh;
        String str = zzcbdVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzF(str)) {
            listenableFutureZzh = zzhbw.zzc(new zzegr(1));
        } else {
            listenableFutureZzh = zzhbw.zzh(this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeek
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzb(zzcbdVar);
                }
            }), ExecutionException.class, zzeeh.zza, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzhbw.zzh(listenableFutureZzh, zzegr.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzeei
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzcbdVar, callingUid, (zzegr) obj);
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzegs zzb(zzcbd zzcbdVar) {
        return (zzegs) this.zzc.zza(zzcbdVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS);
    }

    public final /* synthetic */ ListenableFuture zzc(final zzcbd zzcbdVar, int i, zzegr zzegrVar) {
        Bundle bundle;
        if (zzcbdVar != null && (bundle = zzcbdVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzhbw.zzj(((zzeii) this.zzd.zzb()).zzb(zzcbdVar, i), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzeej
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzhbw.zza(new zzegs((InputStream) obj, zzcbdVar));
            }
        }, this.zzb);
    }
}

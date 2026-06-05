package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzehd {
    private final zzhcg zza;
    private final zzegi zzb;
    private final zzimo zzc;

    public zzehd(zzhcg zzhcgVar, zzegi zzegiVar, zzimo zzimoVar) {
        this.zza = zzhcgVar;
        this.zzb = zzegiVar;
        this.zzc = zzimoVar;
    }

    private final ListenableFuture zzg(final zzcbd zzcbdVar, zzegt zzegtVar, final zzegt zzegtVar2, final zzhbe zzhbeVar) {
        ListenableFuture listenableFutureZzh;
        String str = zzcbdVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzF(str)) {
            listenableFutureZzh = zzhbw.zzc(new zzegr(1));
        } else {
            listenableFutureZzh = zzhbw.zzh(zzegtVar.zza(zzcbdVar), ExecutionException.class, zzehc.zza, this.zza);
        }
        zzhcg zzhcgVar = this.zza;
        return (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzj(zzhbo.zzw(listenableFutureZzh), zzegv.zza, zzhcgVar), zzhbeVar, zzhcgVar), zzegr.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzegw
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzegtVar2, zzcbdVar, zzhbeVar, (zzegr) obj);
            }
        }, zzhcgVar);
    }

    public final ListenableFuture zza(final zzcbd zzcbdVar) {
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzegx
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                String str = new String(zzgzm.zza((InputStream) obj), StandardCharsets.UTF_8);
                zzcbd zzcbdVar2 = zzcbdVar;
                zzcbdVar2.zzj = str;
                return zzhbw.zza(zzcbdVar2);
            }
        };
        final zzegi zzegiVar = this.zzb;
        Objects.requireNonNull(zzegiVar);
        return zzg(zzcbdVar, new zzegt() { // from class: com.google.android.gms.internal.ads.zzegu
            @Override // com.google.android.gms.internal.ads.zzegt
            public final /* synthetic */ ListenableFuture zza(zzcbd zzcbdVar2) {
                return zzegiVar.zza(zzcbdVar2);
            }
        }, new zzegt() { // from class: com.google.android.gms.internal.ads.zzegy
            @Override // com.google.android.gms.internal.ads.zzegt
            public final /* synthetic */ ListenableFuture zza(zzcbd zzcbdVar2) {
                return this.zza.zzd(zzcbdVar2);
            }
        }, zzhbeVar);
    }

    public final ListenableFuture zzb(zzcbd zzcbdVar) {
        return zzg(zzcbdVar, new zzegt() { // from class: com.google.android.gms.internal.ads.zzeha
            @Override // com.google.android.gms.internal.ads.zzegt
            public final /* synthetic */ ListenableFuture zza(zzcbd zzcbdVar2) {
                return this.zza.zze(zzcbdVar2);
            }
        }, new zzegt() { // from class: com.google.android.gms.internal.ads.zzehb
            @Override // com.google.android.gms.internal.ads.zzegt
            public final /* synthetic */ ListenableFuture zza(zzcbd zzcbdVar2) {
                return this.zza.zzf(zzcbdVar2);
            }
        }, zzegz.zza);
    }

    public final /* synthetic */ ListenableFuture zzc(zzegt zzegtVar, zzcbd zzcbdVar, zzhbe zzhbeVar, zzegr zzegrVar) {
        return zzhbw.zzj(zzegtVar.zza(zzcbdVar), zzhbeVar, this.zza);
    }

    public final /* synthetic */ ListenableFuture zzd(zzcbd zzcbdVar) {
        return ((zzeii) this.zzc.zzb()).zzc(zzcbdVar, Binder.getCallingUid());
    }

    public final /* synthetic */ ListenableFuture zze(zzcbd zzcbdVar) {
        return this.zzb.zzd(zzcbdVar.zzh);
    }

    public final /* synthetic */ ListenableFuture zzf(zzcbd zzcbdVar) {
        return ((zzeii) this.zzc.zzb()).zzd(zzcbdVar.zzh);
    }
}

package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzego implements zzegq {
    private final Map zza;
    private final zzhcg zzb;
    private final zzdfv zzc;

    public zzego(Map map, zzhcg zzhcgVar, zzdfv zzdfvVar) {
        this.zza = map;
        this.zzb = zzhcgVar;
        this.zzc = zzdfvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zza(final zzcbd zzcbdVar) {
        this.zzc.zzdP(zzcbdVar);
        ListenableFuture listenableFutureZzc = zzhbw.zzc(new zzeed(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjx)).split(",")) {
            final zzinj zzinjVar = (zzinj) this.zza.get(str.trim());
            if (zzinjVar != null) {
                listenableFutureZzc = zzhbw.zzh(listenableFutureZzc, zzeed.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzegn
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return ((zzegq) zzinjVar.zzb()).zza(zzcbdVar);
                    }
                }, this.zzb);
            }
        }
        zzhbw.zzr(listenableFutureZzc, new zzegm(this), zzcfr.zzh);
        return listenableFutureZzc;
    }

    public final /* synthetic */ zzdfv zzb() {
        return this.zzc;
    }
}

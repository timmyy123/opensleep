package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfef implements zzfck {
    public zzfef(zzces zzcesVar, zzhcg zzhcgVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        final ListenableFuture listenableFutureZza = zzhbw.zza(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgO)).booleanValue()) {
            listenableFutureZza = zzhbw.zza(null);
        }
        final ListenableFuture listenableFutureZza2 = zzhbw.zza(null);
        return zzhbw.zzo(listenableFutureZza, listenableFutureZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfee
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzfeg((String) listenableFutureZza.get(), (String) listenableFutureZza2.get());
            }
        }, zzcfr.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 47;
    }
}

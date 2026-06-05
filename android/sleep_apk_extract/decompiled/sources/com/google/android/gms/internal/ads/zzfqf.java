package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfqf {
    public static boolean zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkc), str);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfpw zzfpwVar) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzhbw.zzr(zzhbo.zzw(listenableFuture), new zzfqb(zzfpwVar), zzcfr.zzh);
        }
    }

    public static zzfok zzc(final zzfpw zzfpwVar) {
        return new zzfok() { // from class: com.google.android.gms.internal.ads.zzfqe
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj) {
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfpwVar.zza();
                }
                return obj;
            }
        };
    }

    public static void zzd(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        zzh(listenableFuture, zzfqgVar, zzfpwVar, false);
    }

    public static void zze(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        zzh(listenableFuture, zzfqgVar, zzfpwVar, true);
    }

    public static void zzf(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzhbw.zzr(zzhbo.zzw(listenableFuture), new zzfqd(zzfqgVar, zzfpwVar), zzcfr.zzh);
        }
    }

    public static int zzg(zzfky zzfkyVar) {
        int iZzg = com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzg(zzfkyVar) - 1;
        return (iZzg == 0 || iZzg == 1) ? 7 : 23;
    }

    private static void zzh(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar, boolean z) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzhbw.zzr(zzhbo.zzw(listenableFuture), new zzfqc(zzfqgVar, zzfpwVar, z), zzcfr.zzh);
        }
    }
}

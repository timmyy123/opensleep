package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzpu {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzvb zzb = new zzvb(zznu.zzb());
    private static final Object zzc = new Object();
    private static volatile zztt zzd = null;

    public static ListenableFuture zza(zzlk zzlkVar, final String str, String str2) {
        zztq zztqVarZzh = zztr.zzh();
        zzrz zzrzVarZza = zzsa.zza(zzlkVar.zzc());
        zzrzVarZza.zzb("phenotype");
        zzrzVarZza.zzc("all_accounts.pb");
        zztqVarZzh.zza(zzrzVarZza.zzd());
        zztqVarZzh.zzb(zznu.zzb());
        zztqVarZzh.zzc(zzb);
        zztqVarZzh.zzf(false);
        zztr zztrVarZzg = zztqVarZzh.zzg();
        zztt zzttVarZzd = zzd;
        if (zzttVarZzd == null) {
            synchronized (zzc) {
                try {
                    zzttVarZzd = zzd;
                    if (zzttVarZzd == null) {
                        zztu zztuVar = new zztu();
                        zztuVar.zza(zzlkVar.zzg());
                        zztuVar.zzb(zzlkVar.zzi());
                        zztuVar.zzc(zzui.zza());
                        zzttVarZzd = zztuVar.zzd();
                        zzd = zzttVarZzd;
                    }
                } finally {
                }
            }
        }
        final String str3 = "";
        return zzttVarZzd.zza(zztrVarZzg).zzb(new Function(str, str3) { // from class: com.google.android.gms.internal.measurement.zzpt
            private final /* synthetic */ String zza;

            @Override // com.google.common.base.Function
            public final /* synthetic */ Object apply(Object obj) {
                zznu zznuVar = (zznu) obj;
                int i = zzpu.$r8$clinit;
                String str4 = this.zza;
                zznq zznqVar = (zznq) zznuVar.zza(str4, zznr.zzb()).zzco();
                if (!zznqVar.zza().contains("")) {
                    zznqVar.zzb("");
                }
                zznt zzntVar = (zznt) zznuVar.zzco();
                zznqVar.zzc("");
                zzntVar.zza(str4, (zznr) zznqVar.zzbd());
                return (zznu) zzntVar.zzbd();
            }
        }, zzlkVar.zzg());
    }
}

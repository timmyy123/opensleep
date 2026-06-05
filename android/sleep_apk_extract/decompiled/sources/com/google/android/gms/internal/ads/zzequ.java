package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzequ implements zzels {
    private final zzelu zza;
    private final zzely zzb;
    private final zzfpk zzc;
    private final zzhcg zzd;

    public zzequ(zzfpk zzfpkVar, zzhcg zzhcgVar, zzelu zzeluVar, zzely zzelyVar) {
        this.zzc = zzfpkVar;
        this.zzd = zzhcgVar;
        this.zzb = zzelyVar;
        this.zza = zzeluVar;
    }

    public static final String zze(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(i).length());
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return !zzfkfVar.zzt.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(final zzfkq zzfkqVar, final zzfkf zzfkfVar) {
        final zzelv zzelvVarZza;
        Iterator it = zzfkfVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzelvVarZza = null;
                break;
            }
            try {
                zzelvVarZza = this.zza.zza((String) it.next(), zzfkfVar.zzv);
                break;
            } catch (zzflf unused) {
            }
        }
        if (zzelvVarZza == null) {
            return zzhbw.zzc(new zzeol("Unable to instantiate mediation adapter class."));
        }
        zzcfw zzcfwVar = new zzcfw();
        zzelvVarZza.zzc.zza(new zzeqr(this, zzelvVarZza, zzcfwVar));
        if (zzfkfVar.zzM) {
            Bundle bundle = zzfkqVar.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfpk zzfpkVar = this.zzc;
        zzfpe zzfpeVar = zzfpe.ADAPTER_LOAD_AD_SYN;
        Objects.requireNonNull(zzfpkVar);
        return zzfov.zzd(new zzfoq() { // from class: com.google.android.gms.internal.ads.zzeqt
            @Override // com.google.android.gms.internal.ads.zzfoq
            public final /* synthetic */ void zza() {
                this.zza.zzc(zzfkqVar, zzfkfVar, zzelvVarZza);
            }
        }, this.zzd, zzfpeVar, zzfpkVar).zzj(zzfpe.ADAPTER_LOAD_AD_ACK).zze(zzcfwVar).zzj(zzfpe.ADAPTER_WRAP_ADAPTER).zzb(new zzfok() { // from class: com.google.android.gms.internal.ads.zzeqs
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj) {
                return this.zza.zzd(zzfkqVar, zzfkfVar, zzelvVarZza, (Void) obj);
            }
        }).zzi();
    }

    public final /* synthetic */ void zzc(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        this.zzb.zza(zzfkqVar, zzfkfVar, zzelvVar);
    }

    public final /* synthetic */ Object zzd(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar, Void r4) {
        return this.zzb.zzb(zzfkqVar, zzfkfVar, zzelvVar);
    }
}

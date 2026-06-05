package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevc implements zzfck {
    private final zzhcg zza;
    private final zzdxc zzb;
    private final zzebw zzc;
    private final zzeve zzd;

    public zzevc(zzhcg zzhcgVar, zzdxc zzdxcVar, zzebw zzebwVar, zzeve zzeveVar) {
        this.zza = zzhcgVar;
        this.zzb = zzdxcVar;
        this.zzc = zzebwVar;
        this.zzd = zzeveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzbih zzbihVar = zzbiq.zznd;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzeve zzeveVar = this.zzd;
            if (zzeveVar.zzd() != null) {
                zzevd zzevdVarZzd = zzeveVar.zzd();
                zzevdVarZzd.getClass();
                return zzhbw.zza(zzevdVarZzd);
            }
        }
        if (zzgua.zzc((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcc)) || (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && (this.zzd.zzb() || !this.zzc.zze()))) {
            return zzhbw.zza(new zzevd(new Bundle()));
        }
        this.zzd.zza(true);
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzevb
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 1;
    }

    public final /* synthetic */ zzevd zzc() {
        List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcc)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                zzflw zzflwVarZza = this.zzb.zza(str, new JSONObject());
                zzflwVarZza.zzn();
                boolean zZze = this.zzc.zze();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznd)).booleanValue() || zZze) {
                    try {
                        zzbxq zzbxqVarZzC = zzflwVarZza.zzC();
                        if (zzbxqVarZzC != null) {
                            bundle2.putString("sdk_version", zzbxqVarZzC.toString());
                        }
                    } catch (zzflf unused) {
                    }
                }
                try {
                    zzbxq zzbxqVarZzB = zzflwVarZza.zzB();
                    if (zzbxqVarZzB != null) {
                        bundle2.putString("adapter_version", zzbxqVarZzB.toString());
                    }
                } catch (zzflf unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzflf unused3) {
            }
        }
        zzevd zzevdVar = new zzevd(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznd)).booleanValue()) {
            this.zzd.zzc(zzevdVar);
        }
        return zzevdVar;
    }
}

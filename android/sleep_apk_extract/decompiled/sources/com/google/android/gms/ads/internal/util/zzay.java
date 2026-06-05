package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzata;
import com.google.android.gms.internal.ads.zzate;
import com.google.android.gms.internal.ads.zzath;
import com.google.android.gms.internal.ads.zzatn;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzaua;
import com.google.android.gms.internal.ads.zzauf;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbro;
import com.google.android.gms.internal.ads.zzfzk;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class zzay extends zzatt {
    private final Context zzb;

    private zzay(Context context, zzats zzatsVar) {
        super(zzatsVar);
        this.zzb = context;
    }

    public static zzath zzb(Context context) {
        zzath zzathVar = new zzath(new zzaua(new File(zzfzk.zza().zza(context.getCacheDir(), "admob_volley")), 20971520), new zzay(context, new zzauf(null, null)), 4);
        zzathVar.zza();
        return zzathVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatt, com.google.android.gms.internal.ads.zzasx
    public final zzata zza(zzate zzateVar) throws zzatn {
        if (zzateVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfr), zzateVar.zzh())) {
                Context context = this.zzb;
                com.google.android.gms.ads.internal.client.zzay.zza();
                if (com.google.android.gms.ads.internal.util.client.zzf.zzz(context, 13400000)) {
                    zzata zzataVarZza = new zzbro(context).zza(zzateVar);
                    if (zzataVarZza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzateVar.zzh())));
                        return zzataVarZza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzateVar.zzh())));
                }
            }
        }
        return super.zza(zzateVar);
    }
}

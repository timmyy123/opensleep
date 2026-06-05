package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcak;
import com.google.android.gms.internal.ads.zzcdn;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzcdn zzc;
    private final zzcak zzd = new zzcak(false, Collections.EMPTY_LIST);

    public zzb(Context context, zzcdn zzcdnVar, zzcak zzcakVar) {
        this.zza = context;
        this.zzc = zzcdnVar;
    }

    private final boolean zzd() {
        zzcdn zzcdnVar = this.zzc;
        return (zzcdnVar != null && zzcdnVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final boolean zzb() {
        return !zzd() || this.zzb;
    }

    public final void zzc(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzcdn zzcdnVar = this.zzc;
            if (zzcdnVar != null) {
                zzcdnVar.zze(str, null, 3);
                return;
            }
            zzcak zzcakVar = this.zzd;
            if (!zzcakVar.zza || (list = zzcakVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzt.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zzO(context, "", strReplace);
                }
            }
        }
    }
}

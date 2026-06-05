package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R$string;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbyd extends zzbyg {
    private final Map zza;
    private final Context zzb;

    public zzbyd(zzcku zzckuVar, Map map) {
        super(zzckuVar, "storePicture");
        this.zza = map;
        this.zzb = zzckuVar.zzj();
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        if (!new zzbhx(context).zza()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzg("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzg("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzt.zzc();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzg("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        com.google.android.gms.ads.internal.zzt.zzc();
        AlertDialog.Builder builderZzN = com.google.android.gms.ads.internal.util.zzs.zzN(context);
        builderZzN.setTitle(resourcesZzf != null ? resourcesZzf.getString(R$string.s1) : "Save image");
        builderZzN.setMessage(resourcesZzf != null ? resourcesZzf.getString(R$string.s2) : "Allow Ad to store image in Picture gallery?");
        builderZzN.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R$string.s3) : "Accept", new zzbyb(this, str, lastPathSegment));
        builderZzN.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R$string.s4) : "Decline", new zzbyc(this));
        builderZzN.create().show();
    }

    public final /* synthetic */ Context zzb() {
        return this.zzb;
    }
}

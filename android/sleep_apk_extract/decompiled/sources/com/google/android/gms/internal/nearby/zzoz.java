package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzoz {
    public static final Uri zza = zzpa.zza;
    public static final Uri zzb = zzpa.zzb;
    private static final zzpb zzc = zzpc.zza();

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        return zzc.zza(contentResolver, "gms:nearby:requires_gms_check", true);
    }
}

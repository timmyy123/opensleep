package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbad {
    public static final String zza(Context context, String str, long j, boolean z) {
        try {
            zzayx zzayxVarZza = zzayy.zza();
            zzayxVarZza.zzb(str);
            zzayxVarZza.zza("0.828153725");
            zzayxVarZza.zzd(context.getPackageName());
            zzayxVarZza.zzf((System.currentTimeMillis() - j) / 1000);
            zzayxVarZza.zzc(System.currentTimeMillis() / 1000);
            try {
                zzayxVarZza.zze(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzayxVarZza.zze(-1L);
            }
            zzaze zzazeVarZzc = zzazo.zzc(((zzayy) zzayxVarZza.zzbm()).zzaN(), null);
            zzazeVarZzc.zzc(5);
            zzazeVarZzc.zzd(2);
            return Base64.encodeToString(((zzazf) zzazeVarZzc.zzbm()).zzaN(), 11);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused2) {
            return Integer.toString(7);
        }
    }
}

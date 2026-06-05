package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgla {
    private final File zza;
    private final zzfxb zzb;
    private final zzgqh zzc;

    public zzgla(File file, zzfxb zzfxbVar, zzgqh zzgqhVar) {
        this.zza = file;
        this.zzb = zzfxbVar;
        this.zzc = zzgqhVar;
    }

    public final boolean zza(byte[] bArr) {
        boolean zZza;
        try {
            File file = this.zza;
            zzgzt.zzb(file);
            zzgzt.zza(bArr, file);
            zZza = this.zzb.zza(file);
        } catch (IOException | GeneralSecurityException e) {
            this.zzc.zzd(2027, e);
            zZza = false;
        }
        try {
            this.zza.delete();
        } catch (SecurityException unused) {
        }
        return zZza;
    }
}

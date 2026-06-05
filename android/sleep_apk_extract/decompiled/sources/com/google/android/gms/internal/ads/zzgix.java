package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgix implements zzgiw {
    private final String zza;
    private final String zzb;
    private final zzght zzc;
    private final zzaxm zzd;
    private final zzgqf zze;

    public zzgix(String str, String str2, zzaxm zzaxmVar, zzght zzghtVar, zzgqf zzgqfVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = zzaxmVar;
        this.zzc = zzghtVar;
        this.zze = zzgqfVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        try {
            this.zze.zza();
            Method methodZzc = this.zzc.zzc(this.zza, this.zzb);
            if (methodZzc != null) {
                zza(methodZzc, this.zzd);
            }
            this.zze.zzc();
            return null;
        } catch (Throwable th) {
            try {
                this.zze.zzb(th);
                throw th;
            } catch (Throwable th2) {
                this.zze.zzc();
                throw th2;
            }
        }
    }

    public abstract void zza(Method method, zzaxm zzaxmVar);
}

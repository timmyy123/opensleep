package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbde {
    private final zzbbs zza;
    private final String zzb;
    private final String zzc;
    private final Class[] zze;
    private volatile Method zzd = null;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzbde(zzbbs zzbbsVar, String str, String str2, Class... clsArr) {
        this.zza = zzbbsVar;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzbbsVar.zzd().submit(new zzbdd(this));
    }

    private final String zzc(byte[] bArr, String str) {
        return new String(this.zza.zzf().zzb(bArr, str), OAuth.ENCODING);
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (this.zzf.await(2L, TimeUnit.SECONDS)) {
                return this.zzd;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public final /* synthetic */ void zzb() {
        try {
            zzbbs zzbbsVar = this.zza;
            Class<?> clsLoadClass = zzbbsVar.zze().loadClass(zzc(zzbbsVar.zzg(), this.zzb));
            if (clsLoadClass != null) {
                this.zzd = clsLoadClass.getMethod(zzc(zzbbsVar.zzg(), this.zzc), this.zze);
            }
        } catch (zzbaw | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            this.zzf.countDown();
            throw th;
        }
        this.zzf.countDown();
    }
}

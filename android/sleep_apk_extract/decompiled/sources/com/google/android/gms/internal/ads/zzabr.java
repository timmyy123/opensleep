package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabr implements zzabl {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzabj[] zzd = new zzabj[100];

    public zzabr(boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized zzabj zza() {
        zzabj zzabjVar;
        try {
            this.zzb++;
            int i = this.zzc;
            if (i > 0) {
                zzabj[] zzabjVarArr = this.zzd;
                int i2 = i - 1;
                this.zzc = i2;
                zzabjVar = zzabjVarArr[i2];
                if (zzabjVar == null) {
                    throw null;
                }
                zzabjVarArr[i2] = null;
            } else {
                zzabjVar = new zzabj(new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST], 0);
                int i3 = this.zzb;
                zzabj[] zzabjVarArr2 = this.zzd;
                int length = zzabjVarArr2.length;
                if (i3 > length) {
                    this.zzd = (zzabj[]) Arrays.copyOf(zzabjVarArr2, length + length);
                    return zzabjVar;
                }
            }
            return zzabjVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzb(zzabj zzabjVar) {
        zzabj[] zzabjVarArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzabjVarArr[i] = zzabjVar;
        this.zzb--;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzc(zzabk zzabkVar) {
        while (zzabkVar != null) {
            zzabj[] zzabjVarArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzabjVarArr[i] = zzabkVar.zzd();
            this.zzb--;
            zzabkVar = zzabkVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzd() {
        int i = this.zza;
        String str = zzfl.zza;
        int iMax = Math.max(0, ((i + 65535) / NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) - this.zzb);
        int i2 = this.zzc;
        if (iMax >= i2) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i2, (Object) null);
        this.zzc = iMax;
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzd();
        }
    }

    public final synchronized int zzg() {
        return this.zzb * NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    public final synchronized int zzh() {
        return this.zzc * NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }
}

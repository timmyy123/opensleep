package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcq {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzcp zzc;

    public final zzcq zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzci.zzc(length, i2));
        }
        zzbw.zzb(obj, obj2);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzcr zzb() {
        zzcp zzcpVar = this.zzc;
        if (zzcpVar != null) {
            throw zzcpVar.zza();
        }
        zzdp zzdpVarZzg = zzdp.zzg(this.zzb, this.zza, this);
        zzcp zzcpVar2 = this.zzc;
        if (zzcpVar2 == null) {
            return zzdpVarZzg;
        }
        throw zzcpVar2.zza();
    }
}

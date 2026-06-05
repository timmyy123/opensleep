package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgwo {
    Object[] zza;
    int zzb;
    zzgwn zzc;

    public zzgwo(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }

    private final void zze(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzgwh.zze(length, i2));
        }
    }

    private final zzgwp zzf(boolean z) {
        zzgwn zzgwnVar;
        zzgwn zzgwnVar2;
        if (z && (zzgwnVar2 = this.zzc) != null) {
            throw zzgwnVar2.zza();
        }
        zzgym zzgymVarZzk = zzgym.zzk(this.zzb, this.zza, this);
        if (!z || (zzgwnVar = this.zzc) == null) {
            return zzgymVarZzk;
        }
        throw zzgwnVar.zza();
    }

    public final zzgwo zza(Object obj, Object obj2) {
        zze(this.zzb + 1);
        zzgvi.zza(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    public final zzgwo zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zze(((Collection) iterable).size() + this.zzb);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzgwp zzc() {
        return zzf(true);
    }

    public final zzgwp zzd() {
        return zzf(false);
    }

    public zzgwo() {
        this(4);
    }
}

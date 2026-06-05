package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajf extends zzajo {
    public final byte[] zza;

    public zzajf(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajf.class == obj.getClass()) {
            zzajf zzajfVar = (zzajf) obj;
            if (this.zzf.equals(zzajfVar.zzf) && Arrays.equals(this.zza, zzajfVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        return Arrays.hashCode(this.zza) + (iHashCode * 31);
    }
}

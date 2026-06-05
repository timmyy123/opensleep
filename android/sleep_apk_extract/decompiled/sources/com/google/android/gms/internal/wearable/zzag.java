package com.google.android.gms.internal.wearable;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class zzag {
    private final String zza;
    private final zzaf zzb;
    private zzaf zzc;

    public /* synthetic */ zzag(String str, byte[] bArr) {
        zzaf zzafVar = new zzaf();
        this.zzb = zzafVar;
        this.zzc = zzafVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzaf zzafVar = this.zzb.zzc;
        String str = "";
        while (zzafVar != null) {
            Object obj = zzafVar.zzb;
            sb.append(str);
            String str2 = zzafVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r1.length() - 1);
            }
            zzafVar = zzafVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzag zza(String str, Object obj) {
        zzaf zzafVar = new zzaf();
        this.zzc.zzc = zzafVar;
        this.zzc = zzafVar;
        zzafVar.zzb = obj;
        zzafVar.zza = str;
        return this;
    }

    public final zzag zzb(String str, int i) {
        String strValueOf = String.valueOf(i);
        zzae zzaeVar = new zzae(null);
        this.zzc.zzc = zzaeVar;
        this.zzc = zzaeVar;
        zzaeVar.zzb = strValueOf;
        zzaeVar.zza = "filterType";
        return this;
    }
}

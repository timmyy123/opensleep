package com.google.android.gms.internal.serialization;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdc {
    private final String zza;
    private final zzdb zzb;
    private zzdb zzc;

    public /* synthetic */ zzdc(String str, byte[] bArr) {
        zzdb zzdbVar = new zzdb();
        this.zzb = zzdbVar;
        this.zzc = zzdbVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzdb zzdbVar = this.zzb.zzc;
        String str = "";
        while (zzdbVar != null) {
            Object obj = zzdbVar.zzb;
            sb.append(str);
            String str2 = zzdbVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r1.length() - 1);
            }
            zzdbVar = zzdbVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdc zza(String str, @CheckForNull Object obj) {
        zzdb zzdbVar = new zzdb();
        this.zzc.zzc = zzdbVar;
        this.zzc = zzdbVar;
        zzdbVar.zzb = obj;
        zzdbVar.zza = str;
        return this;
    }
}

package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzba {
    public final Object zza;
    public final int zzb;
    public final zzak zzc;
    public final Object zzd;
    public final int zze;
    public final long zzf;
    public final long zzg;
    public final int zzh;
    public final int zzi;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
    }

    public zzba(Object obj, int i, zzak zzakVar, Object obj2, int i2, long j, long j2, int i3, int i4) {
        zzgtj.zza(i >= 0);
        zzgtj.zza(i2 >= 0);
        this.zza = obj;
        this.zzb = i;
        this.zzc = zzakVar;
        this.zzd = obj2;
        this.zze = i2;
        this.zzf = j;
        this.zzg = j2;
        this.zzh = i3;
        this.zzi = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzba.class == obj.getClass()) {
            zzba zzbaVar = (zzba) obj;
            if (this.zzb == zzbaVar.zzb && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && this.zzh == zzbaVar.zzh && this.zzi == zzbaVar.zzi && Objects.equals(this.zzc, zzbaVar.zzc) && Objects.equals(this.zza, zzbaVar.zza) && Objects.equals(this.zzd, zzbaVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd, Integer.valueOf(this.zze), Long.valueOf(this.zzf), Long.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi));
    }

    public final String toString() {
        int i = this.zzb;
        int length = String.valueOf(i).length();
        int i2 = this.zze;
        int length2 = String.valueOf(i2).length();
        long j = this.zzf;
        StringBuilder sb = new StringBuilder(length + 19 + length2 + 6 + String.valueOf(j).length());
        Fragment$$ExternalSyntheticOutline1.m(sb, "mediaItem=", i, ", period=", i2);
        String strM = zzba$$ExternalSyntheticOutline0.m(j, ", pos=", sb);
        int i3 = this.zzh;
        if (i3 == -1) {
            return strM;
        }
        long j2 = this.zzg;
        int i4 = this.zzi;
        int length3 = strM.length();
        StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + length3 + 13 + String.valueOf(j2).length() + 10 + 5 + String.valueOf(i4).length());
        sb2.append(strM);
        sb2.append(", contentPos=");
        sb2.append(j2);
        return zzba$$ExternalSyntheticOutline0.m(sb2, i3, ", adGroup=", i4, ", ad=");
    }
}

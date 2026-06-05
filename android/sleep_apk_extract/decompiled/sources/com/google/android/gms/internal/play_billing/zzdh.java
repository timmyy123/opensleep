package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import javax.annotation.CheckForNull;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdh extends zzdi implements Serializable {
    private static final zzdh zzd = new zzdh(zzcd.zzb, zzcb.zzb);
    final zzce zza;
    final zzce zzb;

    private zzdh(zzce zzceVar, zzce zzceVar2) {
        this.zza = zzceVar;
        this.zzb = zzceVar2;
        if (zzceVar.compareTo(zzceVar2) > 0 || zzceVar == zzcb.zzb || zzceVar2 == zzcd.zzb) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid range: ".concat(zze(zzceVar, zzceVar2)));
            throw null;
        }
    }

    public static zzdh zza() {
        return zzd;
    }

    private static String zze(zzce zzceVar, zzce zzceVar2) {
        StringBuilder sb = new StringBuilder(16);
        zzceVar.zzc(sb);
        sb.append("..");
        zzceVar2.zzd(sb);
        return sb.toString();
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzdh) {
            zzdh zzdhVar = (zzdh) obj;
            if (this.zza.equals(zzdhVar.zza) && this.zzb.equals(zzdhVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return zze(this.zza, this.zzb);
    }

    public final zzdh zzb(zzdh zzdhVar) {
        int iCompareTo = this.zza.compareTo(zzdhVar.zza);
        int iCompareTo2 = this.zzb.compareTo(zzdhVar.zzb);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return zzdhVar;
        }
        zzce zzceVar = iCompareTo >= 0 ? this.zza : zzdhVar.zza;
        zzce zzceVar2 = iCompareTo2 <= 0 ? this.zzb : zzdhVar.zzb;
        zzbe.zzd(zzceVar.compareTo(zzceVar2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, zzdhVar);
        return new zzdh(zzceVar, zzceVar2);
    }

    public final zzdh zzc(zzdh zzdhVar) {
        int iCompareTo = this.zza.compareTo(zzdhVar.zza);
        int iCompareTo2 = this.zzb.compareTo(zzdhVar.zzb);
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return this;
        }
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return zzdhVar;
        }
        zzce zzceVar = iCompareTo <= 0 ? this.zza : zzdhVar.zza;
        if (iCompareTo2 < 0) {
            this = zzdhVar;
        }
        return new zzdh(zzceVar, this.zzb);
    }

    public final boolean zzd() {
        return this.zza.equals(this.zzb);
    }
}

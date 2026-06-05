package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzvw {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzvw(String str, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzvw.class) {
            zzvw zzvwVar = (zzvw) obj;
            if (TextUtils.equals(this.zza, zzvwVar.zza) && this.zzb == zzvwVar.zzb && this.zzc == zzvwVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzba$$ExternalSyntheticOutline0.m(this.zza.hashCode() + 31, 31, true != this.zzb ? 1237 : 1231, 31) + (true != this.zzc ? 1237 : 1231);
    }
}

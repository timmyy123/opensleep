package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzejv extends zzejy {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    public zzejv(String str, String str2, Drawable drawable) {
        this.zza = str;
        if (str2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Null imageUrl");
            throw null;
        }
        this.zzb = str2;
        this.zzc = drawable;
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzejy) {
            zzejy zzejyVar = (zzejy) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzejyVar.zza()) : zzejyVar.zza() == null) {
                if (this.zzb.equals(zzejyVar.zzb()) && ((drawable = this.zzc) != null ? drawable.equals(zzejyVar.zzc()) : zzejyVar.zzc() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        return (iHashCode * 1000003) ^ (drawable != null ? drawable.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        String str = this.zza;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(str2.length() + length + 42 + 7 + length2 + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "OfflineAdAssets{advertiserName=", str, ", imageUrl=", str2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", icon=", strValueOf, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzejy
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzejy
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzejy
    public final Drawable zzc() {
        return this.zzc;
    }
}

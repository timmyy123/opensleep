package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
final class zzdl extends zzdn {
    public zzdl(zzdo zzdoVar, CharSequence charSequence, zzdh zzdhVar) {
        super(zzdoVar, charSequence);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdn
    public final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdn
    public final int zzd(int i) {
        CharSequence charSequence = ((zzdn) this).zza;
        int length = charSequence.length();
        zzdj.zzb(i, length, "index");
        while (i < length) {
            if (charSequence.charAt(i) == ',') {
                return i;
            }
            i++;
        }
        return -1;
    }
}

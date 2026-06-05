package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzdn extends zzdc {
    final CharSequence zza;
    int zzb = 0;
    int zzc = Integer.MAX_VALUE;

    public zzdn(zzdo zzdoVar, CharSequence charSequence) {
        this.zza = charSequence;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdc
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i = this.zzb;
        while (true) {
            int i2 = this.zzb;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i2);
            if (iZzd == -1) {
                iZzd = this.zza.length();
                this.zzb = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzb = iZzc;
            }
            if (iZzc != i) {
                if (i < iZzd) {
                    this.zza.charAt(i);
                }
                if (i < iZzd) {
                    this.zza.charAt(iZzd - 1);
                }
                int i3 = this.zzc;
                if (i3 == 1) {
                    CharSequence charSequence = this.zza;
                    int length = charSequence.length();
                    this.zzb = -1;
                    if (length > i) {
                        charSequence.charAt(length - 1);
                    }
                    iZzd = length;
                } else {
                    this.zzc = i3 - 1;
                }
                return this.zza.subSequence(i, iZzd).toString();
            }
            int i4 = iZzc + 1;
            this.zzb = i4;
            if (i4 > this.zza.length()) {
                this.zzb = -1;
            }
        }
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}

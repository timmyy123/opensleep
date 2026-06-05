package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgtr extends zzgtw {
    public zzgtr(zzgty zzgtyVar, CharSequence charSequence, int i) {
        super(zzgtyVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzc(int i) {
        int i2 = i + 4000;
        if (i2 < ((zzgtw) this).zzb.length()) {
            return i2;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzd(int i) {
        return i;
    }
}

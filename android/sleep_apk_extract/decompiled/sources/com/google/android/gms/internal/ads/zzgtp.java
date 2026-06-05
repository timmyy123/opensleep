package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgtp extends zzgtw {
    final /* synthetic */ zzgsx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgtp(zzgty zzgtyVar, CharSequence charSequence, zzgsx zzgsxVar) {
        super(zzgtyVar, charSequence);
        this.zza = zzgsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzc(int i) {
        CharSequence charSequence = ((zzgtw) this).zzb;
        int length = charSequence.length();
        zzgtj.zzn(i, length, "index");
        while (i < length) {
            if (this.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzd(int i) {
        return i + 1;
    }
}

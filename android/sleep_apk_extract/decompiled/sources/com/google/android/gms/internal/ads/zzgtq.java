package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
final class zzgtq extends zzgtw {
    final /* synthetic */ zzgsy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgtq(zzgty zzgtyVar, CharSequence charSequence, zzgsy zzgsyVar) {
        super(zzgtyVar, charSequence);
        this.zza = zzgsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzc(int i) {
        Matcher matcher = ((zzgtb) this.zza).zza;
        if (matcher.find(i)) {
            return matcher.start();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzd(int i) {
        return ((zzgtb) this.zza).zza.end();
    }
}

package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
final class zzahz implements zzahq {
    public final String zza;

    private zzahz(String str) {
        this.zza = str;
    }

    public static zzahz zzb(zzet zzetVar) {
        return new zzahz(zzetVar.zzK(zzetVar.zzd(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return 1852994675;
    }
}

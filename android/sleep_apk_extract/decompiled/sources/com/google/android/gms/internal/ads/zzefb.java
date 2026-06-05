package com.google.android.gms.internal.ads;

import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class zzefb implements zzimu {
    public static zzefb zza() {
        return zzefa.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        com.google.android.gms.ads.internal.zzt.zzc();
        String string = UUID.randomUUID().toString();
        zzinc.zzb(string);
        return string;
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhfk implements zzhln {
    static final /* synthetic */ zzhfk zza = new zzhfk();

    private /* synthetic */ zzhfk() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhfo zzhfoVar = (zzhfo) zzhehVar;
        int i = zzhfl.$r8$clinit;
        if (zzhfoVar.zzc() == 24) {
            zzbuy$$ExternalSyntheticBUOutline0.m("192 bit AES EAX Parameters are not valid");
            return null;
        }
        zzhfh zzhfhVar = new zzhfh(null);
        zzhfhVar.zza(zzhfoVar);
        zzhfhVar.zzc(num);
        zzhfhVar.zzb(zzibb.zzb(zzhfoVar.zzc()));
        return zzhfhVar.zzd();
    }
}

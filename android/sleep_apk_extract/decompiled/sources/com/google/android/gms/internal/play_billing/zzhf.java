package com.google.android.gms.internal.play_billing;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzhf implements zzik {
    private static final zzhf zza = new zzhf();

    private zzhf() {
    }

    public static zzhf zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public final zzij zzb(Class cls) {
        if (!zzhk.class.isAssignableFrom(cls)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (zzij) zzhk.zzo(cls.asSubclass(zzhk.class)).zzd(3, null, null);
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unable to get message info for ".concat(cls.getName()), (Throwable) e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public final boolean zzc(Class cls) {
        return zzhk.class.isAssignableFrom(cls);
    }
}

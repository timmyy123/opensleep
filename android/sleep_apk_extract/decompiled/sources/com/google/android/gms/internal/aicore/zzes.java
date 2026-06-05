package com.google.android.gms.internal.aicore;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzes implements zzfy {
    private static final zzes zza = new zzes();

    private zzes() {
    }

    public static zzes zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.aicore.zzfy
    public final boolean zzb(Class cls) {
        return zzex.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.aicore.zzfy
    public final zzfx zzc(Class cls) {
        if (!zzex.class.isAssignableFrom(cls)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (zzfx) zzex.zzo(cls.asSubclass(zzex.class)).zzd(3, null, null);
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unable to get message info for ".concat(cls.getName()), (Throwable) e);
            return null;
        }
    }
}

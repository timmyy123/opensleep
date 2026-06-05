package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzyx implements zzaao {
    private static final zzyx zza = new zzyx();

    private zzyx() {
    }

    public static zzyx zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.serialization.zzaao
    public final boolean zzb(Class cls) {
        return zzzg.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.serialization.zzaao
    public final zzaan zzc(Class cls) {
        if (!zzzg.class.isAssignableFrom(cls)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (zzaan) zzzg.getDefaultInstance(cls.asSubclass(zzzg.class)).buildMessageInfo();
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unable to get message info for ".concat(cls.getName()), (Throwable) e);
            return null;
        }
    }
}

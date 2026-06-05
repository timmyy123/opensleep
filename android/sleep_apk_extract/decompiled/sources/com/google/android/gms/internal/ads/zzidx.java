package com.google.android.gms.internal.ads;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzidx implements zzifn {
    private static final zzidx zza = new zzidx();

    private zzidx() {
    }

    public static zzidx zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzifn
    public final boolean zzb(Class cls) {
        return zziee.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzifn
    public final zzifm zzc(Class cls) {
        if (!zziee.class.isAssignableFrom(cls)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (zzifm) zziee.zzbt(cls.asSubclass(zziee.class)).zzbs();
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unable to get message info for ".concat(cls.getName()), (Throwable) e);
            return null;
        }
    }
}

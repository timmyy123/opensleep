package com.google.android.gms.internal.consent_sdk;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zztj {
    public static Object zza(Object obj) {
        if (obj != null) {
            return obj;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Cannot return null from a non-@Nullable @Provides method");
        return null;
    }

    public static void zzb(Object obj, Class cls) {
        if (obj != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
    }
}

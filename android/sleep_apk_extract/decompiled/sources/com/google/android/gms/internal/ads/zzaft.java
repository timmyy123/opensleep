package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzaft {
    private final zzafs zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzaft(zzafs zzafsVar) {
        this.zza = zzafsVar;
    }

    public final zzafy zza(Object... objArr) {
        Constructor constructorZza;
        AtomicBoolean atomicBoolean = this.zzb;
        synchronized (atomicBoolean) {
            if (!atomicBoolean.get()) {
                try {
                    constructorZza = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                    constructorZza = null;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
            constructorZza = null;
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzafy) constructorZza.newInstance(objArr);
        } catch (Exception e2) {
            Types$$ExternalSyntheticBUOutline0.m("Unexpected error creating extractor", e2);
            return null;
        }
    }
}

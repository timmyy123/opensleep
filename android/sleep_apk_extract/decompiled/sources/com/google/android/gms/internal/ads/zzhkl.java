package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
final class zzhkl extends ThreadLocal {
    @Nullable
    public static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzhzz.zza.zzb("AES/GCM-SIV/NoPadding");
            if (zzhjb.zzb(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    @Override // java.lang.ThreadLocal
    @Nullable
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}

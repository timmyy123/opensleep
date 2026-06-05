package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
final class zzhzf extends ThreadLocal {
    public static final Cipher zza() {
        try {
            return (Cipher) zzhzz.zza.zzb("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}

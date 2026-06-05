package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhaq;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhar implements PrivilegedExceptionAction {
    static final /* synthetic */ zzhar zza = new zzhar();

    private /* synthetic */ zzhar() {
    }

    @Override // java.security.PrivilegedExceptionAction
    public final /* synthetic */ Object run() throws IllegalAccessException {
        Unsafe unsafe = zzhaq.zzd.zza;
        for (Field field : Unsafe.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        throw new NoSuchFieldError("the Unsafe");
    }
}

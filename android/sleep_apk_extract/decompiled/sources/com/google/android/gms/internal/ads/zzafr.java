package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzafr implements zzafs {
    static final /* synthetic */ zzafr zza = new zzafr();

    private /* synthetic */ zzafr() {
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final /* synthetic */ Constructor zza() throws IllegalAccessException, InvocationTargetException {
        int i = zzafu.$r8$clinit;
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzafy.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
}

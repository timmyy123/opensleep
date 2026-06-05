package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgzr {
    public static final FileOutputStream zza(File file, zzgww zzgwwVar, zzgzi zzgziVar) {
        return new FileOutputStream(file, zzgwwVar.contains(zzgzq.APPEND));
    }
}

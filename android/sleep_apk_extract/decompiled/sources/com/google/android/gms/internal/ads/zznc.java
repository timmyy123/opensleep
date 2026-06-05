package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public interface zznc {
    static boolean zzac(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    String zzU();

    int zza();

    int zzad(zzv zzvVar);

    int zzu();

    void zzv(zznb zznbVar);

    void zzw();
}

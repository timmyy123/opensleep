package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public final class zzauz extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzauz(zzauy zzauyVar, zzauw zzauwVar, long j) {
        int i = (((((~2143124030) & 85005376) | 430547086) + ((2143124030 & 878451808) | 1894615585)) - (-2031609844)) ^ (1747844822 % 1617876982);
        Locale locale = Locale.US;
        Object[] objArr = new Object[i];
        objArr[0] = Long.valueOf(zzauyVar.zza());
        objArr[1] = Long.valueOf(zzauwVar.zza());
        int i2 = (((((~1434433518) & 1229726181) | 671269892) + ((1434433518 & 1096561121) | 546312716)) - 1772679974) ^ (1830539036 % 1290127955);
        Long lValueOf = Long.valueOf(j);
        objArr[i2] = lValueOf;
        super(String.format(locale, zzavo.zza("bk3t6gFTc30="), objArr));
        Optional.of(zzauwVar);
        Optional.of(lValueOf);
    }

    public zzauz(zzauy zzauyVar, Throwable th) {
        super(String.format(Locale.US, zzavo.zza("bk0="), Long.valueOf(zzauyVar.zza())), th);
        Optional.empty();
        Optional.empty();
    }
}

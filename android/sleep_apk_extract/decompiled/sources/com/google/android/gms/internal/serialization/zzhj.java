package com.google.android.gms.internal.serialization;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhj extends zzgx {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Set zzb;
    private static final zzgh zzc;
    private static final zzhh zzd;
    private final String zze;
    private final Level zzf;
    private final Set zzg;
    private final zzgh zzh;
    private final int zzi;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzep.zza, zzfq.zza, zzfr.zza)));
        zzb = setUnmodifiableSet;
        zzc = zzgk.zza(setUnmodifiableSet).zzc();
        zzd = new zzhh(null);
    }

    public /* synthetic */ zzhj(String str, String str2, boolean z, int i, Level level, Set set, zzgh zzghVar, byte[] bArr) {
        super(str2);
        this.zze = zzhc.zza("", str2, true);
        this.zzi = 2;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzghVar;
    }

    public static zzhh zze() {
        return zzd;
    }
}

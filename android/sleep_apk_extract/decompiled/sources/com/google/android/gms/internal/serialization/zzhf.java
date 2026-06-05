package com.google.android.gms.internal.serialization;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class zzhf extends zzgx {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zzf;
    private static final ConcurrentLinkedQueue zzg;
    private volatile zzfw zze;

    static {
        String str = Build.FINGERPRINT;
        zza = str == null || "robolectric".equals(str);
        String str2 = Build.HARDWARE;
        zzb = "goldfish".equals(str2) || "ranchu".equals(str2);
        String str3 = Build.TYPE;
        zzc = "eng".equals(str3) || "userdebug".equals(str3);
        zzd = new AtomicReference();
        zzf = new AtomicLong();
        zzg = new ConcurrentLinkedQueue();
    }

    private zzhf(String str) {
        super(str);
        if (zza || zzb) {
            this.zze = new zzgy().zza(zzd());
        } else if (zzc) {
            this.zze = zzhj.zze().zzb(false).zza(zzd());
        } else {
            this.zze = null;
        }
    }

    public static zzfw zze(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzgz) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char cCharAt = str.charAt(length);
                if (cCharAt != '$') {
                    if (cCharAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace('$', '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzhf zzhfVar = new zzhf(str);
        zzhd.zza.offer(zzhfVar);
        if (zzd.get() != null) {
            while (true) {
                zzhf zzhfVar2 = (zzhf) zzhd.zza.poll();
                if (zzhfVar2 == null) {
                    break;
                }
                zzhfVar2.zze = ((zzgz) zzd.get()).zza(zzhfVar2.zzd());
            }
            zzf();
        }
        return zzhfVar;
    }

    private static void zzf() {
    }
}

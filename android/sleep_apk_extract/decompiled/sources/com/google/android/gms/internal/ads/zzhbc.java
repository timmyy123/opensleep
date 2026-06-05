package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhap;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhbc extends zzhap.zzf {
    private static final zzhaz zzbq;
    private static final zzhce zzbr = new zzhce(zzhbc.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    static {
        Throwable th;
        zzhaz zzhbbVar;
        byte[] bArr = null;
        try {
            zzhbbVar = new zzhba(bArr);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzhbbVar = new zzhbb(bArr);
        }
        zzbq = zzhbbVar;
        if (th != null) {
            zzbr.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzhbc(int i) {
        this.remainingField = i;
    }

    public final Set zzB() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzf(setNewSetFromMap);
        zzbq.zza(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptionsField;
        Objects.requireNonNull(set2);
        return set2;
    }

    public final int zzC() {
        return zzbq.zzb(this);
    }

    public abstract void zzf(Set set);
}

package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
final class zzhba extends zzhaz {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzhbc.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzhbc.class, "remainingField");

    public /* synthetic */ zzhba(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    public final void zza(zzhbc zzhbcVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = zza;
        while (!atomicReferenceFieldUpdater.compareAndSet(zzhbcVar, null, set2) && atomicReferenceFieldUpdater.get(zzhbcVar) == null) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    public final int zzb(zzhbc zzhbcVar) {
        return zzb.decrementAndGet(zzhbcVar);
    }
}

package com.google.android.gms.internal.measurement;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb;

    public zzad(zzae zzaeVar) {
        Objects.requireNonNull(zzaeVar);
        this.zza = zzaeVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zzh();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        zzae zzaeVar = this.zza;
        int i = this.zzb;
        int iZzh = zzaeVar.zzh();
        int i2 = this.zzb;
        if (i < iZzh) {
            this.zzb = i2 + 1;
            return zzaeVar.zzl(i2);
        }
        Events$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(i2, "Out of bounds index: ", new StringBuilder(String.valueOf(i2).length() + 21)));
        return null;
    }
}

package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzibf extends zzibg implements Iterable {
    private final ArrayList zza = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzibf) && ((zzibf) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzibg zzibgVar) {
        this.zza.add(zzibgVar);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final zzibg zzc(int i) {
        return (zzibg) this.zza.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzibg
    public final String zzd() {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        if (size == 1) {
            return ((zzibg) arrayList.get(0)).zzd();
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(size, "Array must have size 1, but has size ", new StringBuilder(String.valueOf(size).length() + 37)));
        return null;
    }
}

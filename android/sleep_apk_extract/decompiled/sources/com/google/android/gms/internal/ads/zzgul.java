package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgul extends zzgvc implements zzgxh {
    public zzgul(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzgvc
    public final Collection zza(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.ads.zzgvc
    public final Collection zzb(Object obj, Collection collection) {
        return zzg(obj, (List) collection, null);
    }
}

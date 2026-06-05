package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
final class zzwk extends zzwl {
    static final zzwl zza;
    static final zzwl zzb;

    static {
        zzwl zzwlVarZzb = new zzwk(null, new SimpleArrayMap(0)).zzb();
        zza = zzwlVarZzb;
        zzwk zzwkVar = new zzwk(zzwlVarZzb, new SimpleArrayMap(), null);
        boolean z = !zzwkVar.zzh();
        Boolean bool = Boolean.TRUE;
        Preconditions.checkState(z, "Can't mutate after handing to trace");
        Preconditions.checkNotNull(bool);
        zzwj zzwjVar = zzwl.zza;
        Preconditions.checkState(!zzwkVar.zzd(zzwjVar), "Key already present");
        zzwkVar.zzg().put(zzwjVar, bool);
        zzb = zzwkVar.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzwk(zzwl zzwlVar, SimpleArrayMap simpleArrayMap) {
        super(null, simpleArrayMap, 0 == true ? 1 : 0);
    }

    public /* synthetic */ zzwk(zzwl zzwlVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        super(zzwlVar, simpleArrayMap, null);
    }
}

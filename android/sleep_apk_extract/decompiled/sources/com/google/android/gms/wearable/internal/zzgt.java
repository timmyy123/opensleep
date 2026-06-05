package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzgt extends zzjf {
    private final WeakReference zza;
    private final WeakReference zzb;

    public zzgt(Map map, Object obj, BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        super(baseImplementation$ResultHolder);
        this.zza = new WeakReference(map);
        this.zzb = new WeakReference(obj);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzgm
    public final void zzy(Status status) {
        Map map = (Map) this.zza.get();
        Object obj = this.zzb.get();
        if (status.getStatus().getStatusCode() == 4002 && map != null && obj != null) {
            synchronized (map) {
                try {
                    zzko zzkoVar = (zzko) map.remove(obj);
                    if (zzkoVar != null) {
                        zzkoVar.zzu();
                    }
                } finally {
                }
            }
        }
        zzS(status);
    }
}

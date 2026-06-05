package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcit implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final boolean zza(zzchn zzchnVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcis zzcisVar = (zzcis) it.next();
            if (zzcisVar.zza == zzchnVar) {
                arrayList.add(zzcisVar);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((zzcis) it2.next()).zzb.zzl();
        }
        return true;
    }

    public final zzcis zzb(zzchn zzchnVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcis zzcisVar = (zzcis) it.next();
            if (zzcisVar.zza == zzchnVar) {
                return zzcisVar;
            }
        }
        return null;
    }

    public final void zzc(zzcis zzcisVar) {
        this.zza.add(zzcisVar);
    }

    public final void zzd(zzcis zzcisVar) {
        this.zza.remove(zzcisVar);
    }
}

package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public final class zzanm implements zzagb {
    private final zzagb zzb;
    private final zzanj zzc;
    private final SparseArray zzd = new SparseArray();
    private boolean zze;

    public zzanm(zzagb zzagbVar, zzanj zzanjVar) {
        this.zzb = zzagbVar;
        this.zzc = zzanjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final zzahk zzu(int i, int i2) {
        if (i2 != 3 && i2 != 5) {
            this.zze = true;
        }
        if (i2 != 3) {
            return this.zzb.zzu(i, i2);
        }
        SparseArray sparseArray = this.zzd;
        zzano zzanoVar = (zzano) sparseArray.get(i);
        if (zzanoVar != null) {
            return zzanoVar;
        }
        zzano zzanoVar2 = new zzano(this.zzb.zzu(i, 3), this.zzc);
        sparseArray.put(i, zzanoVar2);
        return zzanoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzv() {
        this.zzb.zzv();
        if (!this.zze) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.zzd;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzano) sparseArray.valueAt(i)).zzf(true);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagb
    public final void zzw(zzahb zzahbVar) {
        this.zzb.zzw(zzahbVar);
    }
}

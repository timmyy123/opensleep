package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfvh extends zzfvk {
    private static final zzfvh zzb = new zzfvh();

    private zzfvh() {
    }

    public static zzfvh zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfvk
    public final boolean zzb() {
        Iterator it = zzfvi.zza().zzf().iterator();
        while (it.hasNext()) {
            View viewZzi = ((zzfuo) it.next()).zzi();
            if (viewZzi != null && viewZzi.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfvk
    public final void zzc(boolean z) {
        Iterator it = zzfvi.zza().zze().iterator();
        while (it.hasNext()) {
            ((zzfuo) it.next()).zzg().zzf(z);
        }
    }
}

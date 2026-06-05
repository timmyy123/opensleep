package com.google.android.gms.internal.vision;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzlg extends zzlh {
    public zzlg(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.vision.zzlh
    public final void zza() {
        if (!zzb()) {
            if (zzc() > 0) {
                throw Fragment$$ExternalSyntheticOutline1.m(zzb(0));
            }
            Iterator it = zzd().iterator();
            if (it.hasNext()) {
                throw Fragment$$ExternalSyntheticOutline1.m((Map.Entry) it.next());
            }
        }
        super.zza();
    }
}

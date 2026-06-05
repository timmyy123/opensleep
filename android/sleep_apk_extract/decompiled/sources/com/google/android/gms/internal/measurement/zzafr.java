package com.google.android.gms.internal.measurement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzafr extends zzafv {
    public zzafr() {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzafv
    public final void zza() {
        if (!zzb()) {
            if (zzc() > 0) {
                ((zzafs) zzd(0)).zza().getClass();
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            } else {
                Iterator it = zze().iterator();
                if (it.hasNext()) {
                    throw Fragment$$ExternalSyntheticOutline1.m((Map.Entry) it.next());
                }
            }
        }
        super.zza();
    }
}

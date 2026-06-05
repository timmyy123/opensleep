package com.google.android.gms.internal.consent_sdk;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzsd extends zzsi {
    public zzsd() {
        super(null);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsi
    public final void zza() {
        if (!zzj()) {
            if (zzc() > 0) {
                ((zzse) zzg(0)).zza().getClass();
                Events$$ExternalSyntheticBUOutline0.m();
                return;
            } else {
                Iterator it = zzd().iterator();
                if (it.hasNext()) {
                    throw Fragment$$ExternalSyntheticOutline1.m((Map.Entry) it.next());
                }
            }
        }
        super.zza();
    }
}

package com.google.android.gms.internal.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class zzcx extends zzdc {
    public zzcx(zzcz zzczVar, String str, Double d, boolean z) {
        super(zzczVar, str, d, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Invalid double value for ", this.zzc, ": ");
            sbM5m.append((String) obj);
            Log.e("PhenotypeFlag", sbM5m.toString());
            return null;
        }
    }
}

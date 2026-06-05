package com.google.android.gms.internal.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class zzcw extends zzdc {
    public zzcw(zzcz zzczVar, String str, Boolean bool, boolean z) {
        super(zzczVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        if (zzcb.zzc.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (zzcb.zzd.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Invalid boolean value for ", this.zzc, ": ");
        sbM5m.append((String) obj);
        Log.e("PhenotypeFlag", sbM5m.toString());
        return null;
    }
}

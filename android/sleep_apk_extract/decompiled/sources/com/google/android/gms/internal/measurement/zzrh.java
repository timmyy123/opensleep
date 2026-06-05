package com.google.android.gms.internal.measurement;

import com.facebook.internal.ServerProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class zzrh implements zzrl {
    @Override // com.google.android.gms.internal.measurement.zzrl
    public final boolean zza(zzrg zzrgVar) {
        return zzrm.zza(zzrgVar.zza(), "false").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }
}

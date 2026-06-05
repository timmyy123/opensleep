package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdcm {
    public static final zzcdn zza(Context context, VersionInfoParcel versionInfoParcel, zzfkf zzfkfVar, zzcdj zzcdjVar) {
        zzcdk zzcdkVar = zzfkfVar.zzA;
        if (zzcdkVar == null) {
            return null;
        }
        zzfkk zzfkkVar = zzfkfVar.zzs;
        return new zzcdi(context, versionInfoParcel, zzcdkVar, zzfkkVar != null ? zzfkkVar.zzb : null, zzcdjVar);
    }
}

package com.google.android.gms.internal.measurement;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzacd implements zzafj {
    static {
        zzadf zzadfVar = zzadf.zza;
        int i = zzacf.$r8$clinit;
    }

    @Override // com.google.android.gms.internal.measurement.zzafj
    public final /* synthetic */ Object zza(InputStream inputStream, zzadf zzadfVar) throws zzaeh {
        zzacv zzacvVarZzM = zzacv.zzM(inputStream, 4096);
        zzafc zzafcVar = (zzafc) zzb(zzacvVarZzM, zzadfVar);
        zzacvVarZzM.zzb(0);
        if (zzafcVar == null || zzafcVar.zzcJ()) {
            return zzafcVar;
        }
        throw (!(zzafcVar instanceof zzacb) ? new zzafy(zzafcVar) : new zzafy((zzacb) zzafcVar)).zza();
    }
}

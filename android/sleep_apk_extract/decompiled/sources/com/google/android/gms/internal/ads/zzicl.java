package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzicl implements zzifx {
    static {
        zzido zzidoVar = zzido.zza;
        int i = zzicn.$r8$clinit;
    }

    @Override // com.google.android.gms.internal.ads.zzifx
    public final /* synthetic */ Object zza(InputStream inputStream, zzido zzidoVar) throws zziet {
        zzide zzideVarZzH = zzide.zzH(inputStream, 4096);
        zzifp zzifpVar = (zzifp) zzb(zzideVarZzH, zzidoVar);
        zzideVarZzH.zzb(0);
        if (zzifpVar == null || zzifpVar.zzbi()) {
            return zzifpVar;
        }
        throw (!(zzifpVar instanceof zzicj) ? new zzigs(zzifpVar) : ((zzicj) zzifpVar).zzaU()).zza();
    }
}

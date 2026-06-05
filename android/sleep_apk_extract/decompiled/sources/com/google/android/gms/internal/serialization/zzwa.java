package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzwa implements zzaay {
    private static final zzyp zza;

    static {
        zzyp zzypVar = zzyp.zza;
        int i = zzaba.$r8$clinit;
        zza = zzyp.zza;
    }

    public abstract zzaaq zza(byte[] bArr, int i, int i2, zzyp zzypVar);

    @Override // com.google.android.gms.internal.serialization.zzaay
    public final /* synthetic */ Object zzb(byte[] bArr) throws zzzv {
        zzaaq zzaaqVarZza = zza(bArr, 0, bArr.length, zza);
        if (zzaaqVarZza == null || zzaaqVarZza.isInitialized()) {
            return zzaaqVarZza;
        }
        throw ((zzvy) zzaaqVarZza).newUninitializedMessageException().zza();
    }
}

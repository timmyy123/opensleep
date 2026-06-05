package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzqz implements Function {
    static final /* synthetic */ zzqz zza = new zzqz();

    private /* synthetic */ zzqz() {
    }

    @Override // com.google.common.base.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzmk zzmkVar = (zzmk) obj;
        if (zzmkVar.zza() != 29514) {
            throw zzmkVar;
        }
        zznn zznnVarZzd = zzno.zzd();
        zznh zznhVarZzo = zzni.zzo();
        zznhVarZzo.zza(System.currentTimeMillis());
        zznnVarZzd.zza(zznhVarZzo);
        return (zzno) zznnVarZzd.zzbd();
    }
}

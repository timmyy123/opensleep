package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class zzgik extends zzgix {
    private final zzgdf zza;

    public zzgik(zzaxm zzaxmVar, zzght zzghtVar, zzgdf zzgdfVar, zzgqh zzgqhVar) {
        super("de6gUXOvTKpdGE5e57jp8swLYylxAp36VAePPwAMuyFk31nrvwJ6wnCTxnWSrTp+", "XwiXIeWI3naOC54KqLF8O0lcVu19tfx8ftfv+yyfX8s=", zzaxmVar, zzghtVar, zzgqhVar.zza(116));
        this.zza = zzgdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    public final void zza(Method method, zzaxm zzaxmVar) {
        Object[] objArr = (Object[]) method.invoke("", this.zza.zzd());
        objArr.getClass();
        synchronized (zzaxmVar) {
            zzaxmVar.zzb((String) objArr[0]);
            zzaxmVar.zzaa((String) objArr[1]);
        }
    }
}

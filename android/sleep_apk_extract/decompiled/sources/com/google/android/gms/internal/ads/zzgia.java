package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class zzgia extends zzgix {
    private final Activity zza;
    private final View zzb;

    public zzgia(zzaxm zzaxmVar, zzght zzghtVar, View view, Activity activity, zzgqh zzgqhVar) {
        super("kICru+RlF37DZcClNNNafekAyIWCS20ItrldPwSS9IbAVJbkDXFc3qpTOJ54cMxf", "nLYdoqqtMnuDPwVM1aO+ZLMTTK034noiKo5dDDQLXK0=", zzaxmVar, zzghtVar, zzgqhVar.zza(111));
        this.zzb = view;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    public final void zza(Method method, zzaxm zzaxmVar) {
        Object[] objArr = (Object[]) method.invoke("", this.zzb, this.zza);
        objArr.getClass();
        synchronized (zzaxmVar) {
            zzaxmVar.zzS(((Long) objArr[0]).longValue());
            zzaxmVar.zzT(((Long) objArr[1]).longValue());
            zzaxmVar.zzU((String) objArr[2]);
        }
    }
}

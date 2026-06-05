package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class zzgig extends zzgix {
    public zzgig(zzaxm zzaxmVar, zzght zzghtVar, zzgqh zzgqhVar) {
        super("EX3s5CgykVWHs0pNTwHE120YyOO6kVwj6XxXcnDAUKRtpcEwHZ8iefuHYFjxhN+G", "iYfOB+UFjdSgOmvtOabB6aboS+drDofqdo6l56HlvdE=", zzaxmVar, zzghtVar, zzgqhVar.zza(114));
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    public final void zza(Method method, zzaxm zzaxmVar) {
        synchronized (zzaxmVar) {
            zzaxmVar.zza("E");
            zzaxmVar.zzB(0L);
            zzaxmVar.zzV("D");
        }
        Object[] objArr = (Object[]) method.invoke("", null);
        objArr.getClass();
        synchronized (zzaxmVar) {
            zzaxmVar.zza((String) objArr[0]);
            zzaxmVar.zzB(((Long) objArr[1]).longValue());
            zzaxmVar.zzV((String) objArr[2]);
        }
    }
}

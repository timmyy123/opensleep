package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzftx implements Comparator {
    static final /* synthetic */ zzftx zza = new zzftx();

    private /* synthetic */ zzftx() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzftm zzftmVar = (zzftm) obj2;
        zzftm zzftmVar2 = (zzftm) obj;
        int iCompare = Double.compare(zzftmVar.zze(), zzftmVar2.zze());
        return iCompare == 0 ? Long.compare(zzftmVar2.zzd(), zzftmVar.zzd()) : iCompare;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbft implements Comparator {
    public zzbft(zzbfv zzbfvVar) {
        Objects.requireNonNull(zzbfvVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbfy zzbfyVar = (zzbfy) obj;
        zzbfy zzbfyVar2 = (zzbfy) obj2;
        int i = zzbfyVar.zzc - zzbfyVar2.zzc;
        return i != 0 ? i : Long.compare(zzbfyVar.zza, zzbfyVar2.zza);
    }
}

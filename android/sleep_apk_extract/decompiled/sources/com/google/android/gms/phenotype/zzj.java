package com.google.android.gms.phenotype;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
final class zzj implements Comparator<zzi> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzi zziVar, zzi zziVar2) {
        zzi zziVar3 = zziVar;
        zzi zziVar4 = zziVar2;
        int i = zziVar3.zzah;
        int i2 = zziVar4.zzah;
        return i == i2 ? zziVar3.name.compareTo(zziVar4.name) : i - i2;
    }
}

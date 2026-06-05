package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
final class zzavp implements Comparator {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        return java.lang.Integer.compare(r1, r5.zza.length);
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzavq zzavqVar = (zzavq) obj;
        zzavq zzavqVar2 = (zzavq) obj2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzavqVar.zza.length;
            if (i >= length || i2 >= zzavqVar2.zza.length) {
                break;
            }
            int iCompare = Integer.compare(zzavq.zzg(zzavqVar.zzb(i)), zzavq.zzg(zzavqVar2.zzb(i2)));
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
            i2++;
        }
    }
}

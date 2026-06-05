package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzige {
    public static final /* synthetic */ zzida zza(zzida zzidaVar, zzida zzidaVar2, ArrayDeque arrayDeque) {
        zzb(zzidaVar, arrayDeque);
        zzb(zzidaVar2, arrayDeque);
        zzida zziggVar = (zzida) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zziggVar = new zzigg((zzida) arrayDeque.pop(), zziggVar, null);
        }
        return zziggVar;
    }

    private static final void zzb(zzida zzidaVar, ArrayDeque arrayDeque) {
        byte[] bArr;
        if (!zzidaVar.zzq()) {
            if (!(zzidaVar instanceof zzigg)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzidaVar.getClass())));
                return;
            }
            zzigg zziggVar = (zzigg) zzidaVar;
            zzb(zziggVar.zzo(), arrayDeque);
            zzb(zziggVar.zzF(), arrayDeque);
            return;
        }
        int iZzc = zzc(zzidaVar.zzb(), arrayDeque);
        int iZzn = zzigg.zzn(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzida) arrayDeque.peek()).zzb() >= iZzn) {
            arrayDeque.push(zzidaVar);
            return;
        }
        int iZzn2 = zzigg.zzn(iZzc);
        zzida zziggVar2 = (zzida) arrayDeque.pop();
        while (true) {
            bArr = null;
            if (arrayDeque.isEmpty() || ((zzida) arrayDeque.peek()).zzb() >= iZzn2) {
                break;
            } else {
                zziggVar2 = new zzigg((zzida) arrayDeque.pop(), zziggVar2, bArr);
            }
        }
        zzigg zziggVar3 = new zzigg(zziggVar2, zzidaVar, bArr);
        while (!arrayDeque.isEmpty()) {
            if (((zzida) arrayDeque.peek()).zzb() >= zzigg.zzn(zzc(zziggVar3.zzb(), arrayDeque) + 1)) {
                break;
            } else {
                zziggVar3 = new zzigg((zzida) arrayDeque.pop(), zziggVar3, bArr);
            }
        }
        arrayDeque.push(zziggVar3);
    }

    private static final int zzc(int i, ArrayDeque arrayDeque) {
        int iBinarySearch = Arrays.binarySearch(zzigg.zzb, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }
}

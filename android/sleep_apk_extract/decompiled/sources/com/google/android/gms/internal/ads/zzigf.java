package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzigf implements Iterator {
    private final ArrayDeque zza;
    private zzicx zzb;

    public /* synthetic */ zzigf(zzida zzidaVar, byte[] bArr) {
        if (!(zzidaVar instanceof zzigg)) {
            this.zza = null;
            this.zzb = (zzicx) zzidaVar;
            return;
        }
        zzigg zziggVar = (zzigg) zzidaVar;
        ArrayDeque arrayDeque = new ArrayDeque(zziggVar.zzp());
        this.zza = arrayDeque;
        arrayDeque.push(zziggVar);
        this.zzb = zzb(zziggVar.zzo());
    }

    private final zzicx zzb(zzida zzidaVar) {
        while (zzidaVar instanceof zzigg) {
            zzigg zziggVar = (zzigg) zzidaVar;
            this.zza.push(zziggVar);
            zzidaVar = zziggVar.zzo();
        }
        return (zzicx) zzidaVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzicx next() {
        zzicx zzicxVar = this.zzb;
        zzicx zzicxVar2 = null;
        if (zzicxVar == null) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        while (true) {
            ArrayDeque arrayDeque = this.zza;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzicx zzicxVarZzb = zzb(((zzigg) arrayDeque.pop()).zzF());
            if (!zzicxVarZzb.zzs()) {
                zzicxVar2 = zzicxVarZzb;
                break;
            }
        }
        this.zzb = zzicxVar2;
        return zzicxVar;
    }
}

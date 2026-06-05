package com.google.android.gms.internal.measurement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class zzvk extends AbstractFuture {
    private zzvm zza;
    private final int zzb;

    public /* synthetic */ zzvk(zzvm zzvmVar, int i, byte[] bArr) {
        this.zza = zzvmVar;
        this.zzb = i;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        zzvm zzvmVar = this.zza;
        this.zza = null;
        if (zzvmVar != null && zzvmVar.zze()) {
            while (true) {
                zzvl zzvlVar = (zzvl) zzvmVar.zzg().get();
                if (zzvlVar != null) {
                    if (zzvlVar.zza() <= this.zzb) {
                        zzvlVar.cancel(true);
                        AtomicReference atomicReferenceZzg = zzvmVar.zzg();
                        while (!atomicReferenceZzg.compareAndSet(zzvlVar, null)) {
                            if (atomicReferenceZzg.get() != zzvlVar) {
                                break;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        AsyncCallable asyncCallableZza;
        zzvm zzvmVar = this.zza;
        if (zzvmVar == null || (asyncCallableZza = zzvmVar.zzf().zza()) == null) {
            return null;
        }
        String string = asyncCallableZza.toString();
        String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 11), "callable=[", string, "]");
        zzvl zzvlVar = (zzvl) this.zza.zzg().get();
        if (zzvlVar == null) {
            return strM;
        }
        int length = strM.length();
        String string2 = zzvlVar.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string2.length() + length + 9 + 1), strM, ", trial=[", string2, "]");
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}

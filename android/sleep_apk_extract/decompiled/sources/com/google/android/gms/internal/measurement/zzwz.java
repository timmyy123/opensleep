package com.google.android.gms.internal.measurement;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
public final class zzwz implements Runnable {
    final /* synthetic */ Ref$ObjectRef zza;
    final /* synthetic */ zzws zzb;
    final /* synthetic */ Runnable zzc;

    public zzwz(Ref$ObjectRef ref$ObjectRef, zzws zzwsVar, Runnable runnable) {
        this.zza = ref$ObjectRef;
        this.zzb = zzwsVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.element != 0) {
            Events$$ExternalSyntheticBUOutline0.m();
            return;
        }
        zzws zzwsVar = this.zzb;
        zzwsVar.getClass();
        Runnable runnable = this.zzc;
        zzws zzwsVarZzc = zzvy.zzc(zzvy.zzd(), zzwsVar);
        try {
            runnable.run();
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    public final String toString() {
        Runnable runnable = this.zzc;
        StringBuilder sb = new StringBuilder(runnable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(runnable);
        sb.append("]");
        return sb.toString();
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

/* JADX INFO: loaded from: classes3.dex */
final class zzlg {
    final /* synthetic */ zzlh zza;
    private final WeakReference zzb;
    private final IntConsumer zzc;

    public /* synthetic */ zzlg(zzlh zzlhVar, Context context, byte[] bArr) {
        Objects.requireNonNull(zzlhVar);
        this.zza = zzlhVar;
        this.zzb = new WeakReference(context);
        IntConsumer intConsumer = new IntConsumer() { // from class: com.google.android.gms.internal.ads.zzle
            @Override // java.util.function.IntConsumer
            public final /* synthetic */ void accept(int i) {
                zzlh zzlhVar2 = this.zza.zza;
                if (zzlhVar2.zzae()) {
                    return;
                }
                zzlhVar2.zzT(1, 19, Integer.valueOf(i));
            }
        };
        this.zzc = intConsumer;
        final zzdz zzdzVarZzd = zzlhVar.zzX().zzd(zzlhVar.zzW(), null);
        Objects.requireNonNull(zzdzVarZzd);
        context.registerDeviceIdChangeListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzlf
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                zzdzVarZzd.zzm(runnable);
            }
        }, intConsumer);
    }

    public final /* synthetic */ void zza() {
        Context context = (Context) this.zzb.get();
        if (context == null) {
            return;
        }
        context.unregisterDeviceIdChangeListener(this.zzc);
    }
}

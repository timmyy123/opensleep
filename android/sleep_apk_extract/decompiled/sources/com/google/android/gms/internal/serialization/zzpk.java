package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/home/automation/internal/impl/AutomationController;", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzpk extends Lambda implements Function0 {
    final /* synthetic */ zzpu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpk(zzpu zzpuVar) {
        super(0);
        this.zza = zzpuVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        zzpu zzpuVar = this.zza;
        return new AutomationController(zzpuVar, zzpuVar.zzc());
    }
}

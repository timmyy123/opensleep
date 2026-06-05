package com.google.android.gms.internal.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzso extends Lambda implements Function1 {
    final /* synthetic */ List zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzso(List list) {
        super(1);
        this.zza = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        zzvs zzvsVar = (zzvs) obj;
        zzvsVar.getClass();
        while (zzvsVar.zze()) {
            this.zza.add(UInt.m2388boximpl(zzvsVar.zzl()));
        }
        return Unit.INSTANCE;
    }
}

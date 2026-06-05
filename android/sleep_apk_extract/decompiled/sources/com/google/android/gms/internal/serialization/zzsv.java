package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "name", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzsv extends Lambda implements Function2 {
    final /* synthetic */ Ref$ObjectRef zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzsv(Ref$ObjectRef ref$ObjectRef) {
        super(2);
        this.zza = ref$ObjectRef;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        zzvs zzvsVar = (zzvs) obj;
        String str = (String) obj2;
        zzvsVar.getClass();
        str.getClass();
        if (Intrinsics.areEqual(str, "deviceObjectId")) {
            this.zza.element = zzvsVar.zzh();
        }
        return Unit.INSTANCE;
    }
}

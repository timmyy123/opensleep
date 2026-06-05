package com.google.android.gms.internal.serialization;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "trait", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zztg extends Lambda implements Function2 {
    final /* synthetic */ Map zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztg(Map map) {
        super(2);
        this.zza = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.google.android.gms.internal.home.zzsk] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.google.android.gms.internal.home.zztk] */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        zzvs zzvsVar = (zzvs) obj;
        String str = (String) obj2;
        zzvsVar.getClass();
        str.getClass();
        zzvsVar.getClass();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = zzsk.zza;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = zztk.zza;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = "";
        zzvu.zzb(zzvsVar, new zztl(ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
        this.zza.put(str, new zztm((zzsk) ref$ObjectRef.element, (zztk) ref$ObjectRef2.element, (String) ref$ObjectRef3.element));
        return Unit.INSTANCE;
    }
}

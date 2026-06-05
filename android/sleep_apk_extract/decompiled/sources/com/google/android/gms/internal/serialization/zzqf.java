package com.google.android.gms.internal.serialization;

import com.google.home.HomeException;
import com.google.home.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/google/home/internal/impl/MatterNode;", "components", "Lcom/google/home/internal/impl/ComponentImpl;", "objects", "", "Lcom/google/nest/platform/mesh/serialization/ObjectData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.NodeController$sharedFlow$2", f = "NodeController.kt", l = {}, m = "invokeSuspend")
final class zzqf extends SuspendLambda implements Function3 {
    /* synthetic */ Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzqh zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqf(zzqh zzqhVar, Continuation continuation) {
        super(3, continuation);
        this.zzc = zzqhVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        zzqf zzqfVar = new zzqf(this.zzc, (Continuation) obj3);
        zzqfVar.zza = (Set) obj;
        zzqfVar.zzb = (List) obj2;
        return zzqfVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws HomeException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Set set = (Set) this.zza;
        List<ObjectData> list = (List) this.zzb;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ObjectData objectData : list) {
            ArrayList<zznq> arrayList2 = new ArrayList();
            for (Object obj2 : set) {
                zznq zznqVar = (zznq) obj2;
                if ((zznqVar instanceof zzpy) && Intrinsics.areEqual(((zzpy) zznqVar).getZza(), objectData.getId())) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (zznq zznqVar2 : arrayList2) {
                zznqVar2.getClass();
                arrayList3.add((zzpy) zznqVar2);
            }
            zzqh zzqhVar = this.zzc;
            Set set2 = CollectionsKt.toSet(arrayList3);
            zzpu zzpuVar = zzqhVar.zzb;
            objectData.getClass();
            set2.getClass();
            zzpuVar.getClass();
            zzsu zzsuVar = (zzsu) zzsu.zza.zze(objectData);
            if (zzsuVar == null) {
                throw HomeException.INSTANCE.invalidArgument("Trait data for home.internal.traits.MatterNodeTrait is invalid");
            }
            String id = objectData.getId();
            Id.m441constructorimpl(id);
            arrayList.add(new MatterNodeImpl(id, set2, zzsuVar.getZzb(), zzsuVar.getZzc(), zzsuVar.getZzd(), zzsuVar.getZze(), zzsuVar.getZzf(), zzsuVar.getZzg(), zzpuVar, null));
        }
        return CollectionsKt.toSet(arrayList);
    }
}

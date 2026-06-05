package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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
import kotlinx.coroutines.flow.FlowCollector;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
public final class zzqo implements FlowCollector {
    final /* synthetic */ FlowCollector zza;
    final /* synthetic */ zzqq zzb;

    public zzqo(FlowCollector flowCollector, zzqq zzqqVar) {
        this.zza = flowCollector;
        this.zzb = zzqqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) throws HomeException {
        zzqn zzqnVar;
        if (continuation instanceof zzqn) {
            zzqnVar = (zzqn) continuation;
            int i = zzqnVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzqnVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zzqnVar = new zzqn(this, continuation);
            }
        }
        Object obj2 = zzqnVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzqnVar.zzb;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            FlowCollector flowCollector = this.zza;
            List<ObjectData> list = (List) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ObjectData objectData : list) {
                zzpu zzpuVar = this.zzb.zzb;
                objectData.getClass();
                zzpuVar.getClass();
                zzpv.zza().zzb().zza("Building Room: %s", objectData.getId());
                zzta zztaVar = (zzta) zzta.zza.zze(objectData);
                if (zztaVar == null) {
                    throw HomeException.INSTANCE.invalidArgument("Trait data for home.internal.traits.RoomTrait is invalid");
                }
                String zzb = zztaVar.getZzb();
                String id = objectData.getId();
                Id.m441constructorimpl(id);
                String zzc = zztaVar.getZzc();
                Id.m441constructorimpl(zzc);
                arrayList.add(new zzqv(zzb, id, zzc, zzpuVar, null));
            }
            Set set = CollectionsKt.toSet(arrayList);
            zzqnVar.zzb = 1;
            if (flowCollector.emit(set, zzqnVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj2);
        }
        return Unit.INSTANCE;
    }
}

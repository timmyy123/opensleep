package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
public final class zzto<T> implements FlowCollector {
    final /* synthetic */ FlowCollector zza;

    public zzto(FlowCollector flowCollector) {
        this.zza = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        zztn zztnVar;
        OnSimpleEvent onSimpleEvent;
        FlowCollector flowCollector;
        Iterator it;
        if (continuation instanceof zztn) {
            zztnVar = (zztn) continuation;
            int i = zztnVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zztnVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zztnVar = new zztn(this, continuation);
            }
        }
        Object obj = zztnVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zztnVar.zzb;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = this.zza;
            onSimpleEvent = (OnSimpleEvent) t;
            flowCollector = flowCollector2;
            it = onSimpleEvent.getZzc().iterator();
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            it = (Iterator) zztnVar.zze;
            flowCollector = (FlowCollector) zztnVar.zzd;
            onSimpleEvent = zztnVar.zzf;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            ObjectEventPayload objectEventPayload = new ObjectEventPayload(onSimpleEvent.getZzb(), (EventPayload) it.next());
            zztnVar.zzf = onSimpleEvent;
            zztnVar.zzd = flowCollector;
            zztnVar.zze = it;
            zztnVar.zzb = 1;
            if (flowCollector.emit(objectEventPayload, zztnVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}

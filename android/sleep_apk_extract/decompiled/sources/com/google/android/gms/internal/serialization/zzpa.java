package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
public final class zzpa implements FlowCollector {
    final /* synthetic */ FlowCollector zza;
    final /* synthetic */ zzpj zzb;

    public zzpa(FlowCollector flowCollector, zzpj zzpjVar) {
        this.zza = flowCollector;
        this.zzb = zzpjVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        zzoz zzozVar;
        if (continuation instanceof zzoz) {
            zzozVar = (zzoz) continuation;
            int i = zzozVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzozVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zzozVar = new zzoz(this, continuation);
            }
        }
        Object obj2 = zzozVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzozVar.zzb;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            FlowCollector flowCollector = this.zza;
            zzpj zzpjVar = this.zzb;
            zznu zznuVar = zznx.zza;
            Set setZzb = zznu.zzb(zzpjVar.getZza(), (Set) obj);
            zzozVar.zzb = 1;
            if (flowCollector.emit(setZzb, zzozVar) == coroutine_suspended) {
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

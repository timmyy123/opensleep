package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import java.util.Iterator;
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
public final class zzpe<T> implements FlowCollector {
    final /* synthetic */ FlowCollector zza;
    final /* synthetic */ DeviceTypeFactory zzb;

    public zzpe(FlowCollector flowCollector, DeviceTypeFactory deviceTypeFactory) {
        this.zzb = deviceTypeFactory;
        this.zza = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        zzpd zzpdVar;
        DeviceType deviceTypeZzb;
        if (continuation instanceof zzpd) {
            zzpdVar = (zzpd) continuation;
            int i = zzpdVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzpdVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zzpdVar = new zzpd(this, continuation);
            }
        }
        Object obj = zzpdVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzpdVar.zzb;
        zznq zznqVar = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.zza;
            Set set = (Set) t;
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (((zznq) next).has(this.zzb)) {
                    zznqVar = next;
                    break;
                }
            }
            zznq zznqVar2 = zznqVar;
            if (zznqVar2 != null && (deviceTypeZzb = zzng.zzb(zznqVar2, this.zzb, zzng.zza(zznqVar2, set))) != null) {
                zzpdVar.zzb = 1;
                if (flowCollector.emit(deviceTypeZzb, zzpdVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

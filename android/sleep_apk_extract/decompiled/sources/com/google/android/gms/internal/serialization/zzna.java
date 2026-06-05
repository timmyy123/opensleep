package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
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
public final class zzna implements FlowCollector {
    final /* synthetic */ FlowCollector zza;
    final /* synthetic */ zznc zzb;

    public zzna(FlowCollector flowCollector, zznc zzncVar) {
        this.zza = flowCollector;
        this.zzb = zzncVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        zzmz zzmzVar;
        if (continuation instanceof zzmz) {
            zzmzVar = (zzmz) continuation;
            int i = zzmzVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzmzVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zzmzVar = new zzmz(this, continuation);
            }
        }
        Object obj2 = zzmzVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzmzVar.zzb;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            FlowCollector flowCollector = this.zza;
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zznq zznqVarZza = zznc.zza.zza((ObjectData) it.next(), this.zzb.zzb);
                if (zznqVarZza != null) {
                    arrayList.add(zznqVarZza);
                }
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(CollectionsKt.sortedWith(CollectionsKt.sortedWith(arrayList, new zzmw()), new zzmx()));
            zzmzVar.zzb = 1;
            if (flowCollector.emit(linkedHashSet, zzmzVar) == coroutine_suspended) {
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

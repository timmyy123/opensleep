package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
public final class zzni<T> implements FlowCollector {
    final /* synthetic */ FlowCollector zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ TraitFactory zzc;
    final /* synthetic */ zznq zzd;

    public zzni(FlowCollector flowCollector, String str, TraitFactory traitFactory, zznq zznqVar) {
        this.zzb = str;
        this.zzc = traitFactory;
        this.zzd = zznqVar;
        this.zza = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        zznh zznhVar;
        if (continuation instanceof zznh) {
            zznhVar = (zznh) continuation;
            int i = zznhVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zznhVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zznhVar = new zznh(this, continuation);
            }
        }
        Object obj = zznhVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zznhVar.zzb;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.zza;
            zznq zznqVar = (zznq) t;
            if (((TraitElementPayload) zznqVar.zzf.getContents().get(this.zzb)) != null) {
                Trait traitZzd = zzop.zzd(this.zzc.getFactory(), zznqVar.zzf, new Trait.TraitMetadata(zznqVar.getSourceConnectivity(this.zzc)), this.zzd.getZzb().getZza());
                if (traitZzd != null) {
                    zznhVar.zzb = 1;
                    if (flowCollector.emit(traitZzd, zznhVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

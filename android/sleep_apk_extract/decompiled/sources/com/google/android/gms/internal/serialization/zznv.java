package com.google.android.gms.internal.serialization;

import com.google.home.HomeDevice;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/google/home/HomeDevice;", "components", "Lcom/google/home/internal/impl/ComponentImpl;", "objects", "", "Lcom/google/nest/platform/mesh/serialization/ObjectData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.DeviceController$sharedFlow$2", f = "DeviceController.kt", l = {}, m = "invokeSuspend")
final class zznv extends SuspendLambda implements Function3 {
    /* synthetic */ Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zznx zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zznv(zznx zznxVar, Continuation continuation) {
        super(3, continuation);
        this.zzc = zznxVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        zznv zznvVar = new zznv(this.zzc, (Continuation) obj3);
        zznvVar.zza = (Set) obj;
        zznvVar.zzb = (List) obj2;
        return zznvVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Set set = (Set) this.zza;
        List<ObjectData> list = (List) this.zzb;
        ArrayList arrayList = new ArrayList();
        for (ObjectData objectData : list) {
            zznx zznxVar = this.zzc;
            zznu zznuVar = zznx.zza;
            String id = objectData.getId();
            Id.m441constructorimpl(id);
            HomeDevice homeDeviceZza = zznuVar.zza(objectData, zznu.zzb(id, set), zznxVar.zzb);
            if (homeDeviceZza != null) {
                arrayList.add(homeDeviceZza);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }
}

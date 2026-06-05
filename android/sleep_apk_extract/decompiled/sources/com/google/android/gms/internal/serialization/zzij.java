package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Id;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.automation.Automation;
import com.google.home.google.AutomationEntity;
import com.google.home.google.AutomationExecution;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public final class zzij implements FlowCollector {
    final /* synthetic */ FlowCollector zza;
    final /* synthetic */ AutomationController zzb;

    public zzij(FlowCollector flowCollector, AutomationController automationController) {
        this.zza = flowCollector;
        this.zzb = automationController;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x014a, code lost:
    
        if (r0.emit(r12, r11) != r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x011f -> B:29:0x0123). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        zzii zziiVar;
        Collection arrayList;
        zzii zziiVar2;
        FlowCollector flowCollector;
        Iterator it;
        zzij zzijVar;
        Object objZze;
        if (continuation instanceof zzii) {
            zziiVar = (zzii) continuation;
            int i = zziiVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zziiVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zziiVar = new zzii(this, continuation);
            }
        }
        Object obj2 = zziiVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zziiVar.zzb;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            FlowCollector flowCollector2 = this.zza;
            List list = (List) obj;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            zziiVar2 = zziiVar;
            flowCollector = flowCollector2;
            it = list.iterator();
            zzijVar = this;
            collection = arrayList;
            if (it.hasNext()) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj2);
                return Unit.INSTANCE;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        Collection collection = (Collection) zziiVar.zzg;
        Iterator it2 = (Iterator) zziiVar.zzf;
        arrayList = (Collection) zziiVar.zze;
        FlowCollector flowCollector3 = (FlowCollector) zziiVar.zzd;
        zzij zzijVar2 = zziiVar.zzh;
        ResultKt.throwOnFailure(obj2);
        zziiVar2 = zziiVar;
        Iterator it3 = it2;
        zzijVar = zzijVar2;
        collection.add((Automation) obj2);
        it = it3;
        flowCollector = flowCollector3;
        collection = arrayList;
        if (it.hasNext()) {
            ObjectData objectData = (ObjectData) it.next();
            zzpu zzpuVar = zzijVar.zzb.zza;
            zziiVar2.zzh = zzijVar;
            zziiVar2.zzd = flowCollector;
            zziiVar2.zze = collection;
            zziiVar2.zzf = it;
            zziiVar2.zzg = collection;
            zziiVar2.zzb = 1;
            AutomationSdkLogger.zza().zzb().zza("Building Automation: %s", objectData.getId());
            InternalTraitFactory<AutomationEntity> factory = AutomationEntity.INSTANCE.getFactory();
            Trait.TraitMetadata traitMetadata = new Trait.TraitMetadata(null, 1, null);
            Object value = zzpuVar.getZza().getValue();
            value.getClass();
            AutomationEntity automationEntity = (AutomationEntity) zzop.zzc(factory, objectData, traitMetadata, (InteractionClient) value);
            if (automationEntity == null) {
                AutomationSdkLogger.zza().zzc().zza("Could not unpack AutomationEntityTrait on %s", objectData.getId());
            } else {
                InternalTraitFactory<AutomationExecution> factory2 = AutomationExecution.INSTANCE.getFactory();
                Trait.TraitMetadata traitMetadata2 = new Trait.TraitMetadata(null, 1, null);
                Object value2 = zzpuVar.getZza().getValue();
                value2.getClass();
                AutomationExecution automationExecution = (AutomationExecution) zzop.zzc(factory2, objectData, traitMetadata2, (InteractionClient) value2);
                if (automationExecution == null) {
                    AutomationSdkLogger.zza().zzc().zza("Could not unpack AutomationExecutionTrait on %s", objectData.getId());
                } else {
                    zzkt zzktVar = new zzkt();
                    String id = objectData.getId();
                    Id.m441constructorimpl(id);
                    objZze = zzktVar.zze(id, automationEntity, automationExecution, zzpuVar, zziiVar2);
                    if (objZze != coroutine_suspended) {
                        flowCollector3 = flowCollector;
                        it3 = it;
                        obj2 = objZze;
                        arrayList = collection;
                        collection.add((Automation) obj2);
                        it = it3;
                        flowCollector = flowCollector3;
                        collection = arrayList;
                        if (it.hasNext()) {
                            Set set = CollectionsKt.toSet(CollectionsKt.filterNotNull((List) collection));
                            zziiVar2.zzh = null;
                            zziiVar2.zzd = null;
                            zziiVar2.zze = null;
                            zziiVar2.zzf = null;
                            zziiVar2.zzg = null;
                            zziiVar2.zzb = 2;
                        }
                    }
                }
            }
            objZze = null;
            if (objZze != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}

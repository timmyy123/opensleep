package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.HomeConfig;
import com.google.home.HomeException;
import com.google.home.Id;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import com.google.home.matter.serialization.codec.factory.SerializationCodecFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlin.time.TimeSource$Monotonic;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001#B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJP\u0010\u0019\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ;\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"¨\u0006$"}, d2 = {"Lcom/google/home/internal/impl/MatterTraitClientImpl;", "Lcom/google/home/matter/MatterTraitClient;", "Lcom/google/home/Id;", "objectId", "Lcom/google/home/matter/serialization/ClusterId;", "cluster", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "interactionClient", "<init>", "(Ljava/lang/String;Lcom/google/home/matter/serialization/ClusterId;Lcom/google/nest/platform/mesh/interaction/InteractionClient;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Lkotlinx/coroutines/flow/StateFlow;", "interactionClientProvider", "(Ljava/lang/String;Lcom/google/home/matter/serialization/ClusterId;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "strictOperationValidation", "()Z", "REQUEST", "RESPONSE", "Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Lcom/google/home/matter/serialization/StructAdapter;", "requestAdapter", "responseAdapter", "request", "useTimedCommand", "sendCommand", "(Lcom/google/home/matter/serialization/ScopedCommandId;Lcom/google/home/matter/serialization/StructAdapter;Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "createObjectCommand", "(Lcom/google/home/matter/serialization/ScopedCommandId;Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;Z)Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "Ljava/lang/String;", "getObjectId-sJHuco4$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Ljava/lang/String;", "Lcom/google/home/matter/serialization/ClusterId;", "Lkotlinx/coroutines/flow/StateFlow;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzqd implements MatterTraitClient {
    private static final TraitElementPayload zzd = new TraitElementPayload("", "", "", null, null);
    private final String zza;
    private final ClusterId zzb;
    private final StateFlow zzc;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzqd(String str, ClusterId clusterId, InteractionClient interactionClient, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, clusterId, FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(interactionClient)));
        str.getClass();
        clusterId.getClass();
        interactionClient.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.util.List] */
    @Override // com.google.home.matter.MatterTraitClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <REQUEST, RESPONSE> Object sendCommand(ScopedCommandId scopedCommandId, StructAdapter<REQUEST> structAdapter, StructAdapter<RESPONSE> structAdapter2, REQUEST request, boolean z, Continuation<? super RESPONSE> continuation) throws HomeException {
        zzqb zzqbVar;
        Ref$ObjectRef ref$ObjectRef;
        StructAdapter<RESPONSE> structAdapter3;
        Object objZzi;
        Ref$ObjectRef ref$ObjectRef2;
        long j;
        ScopedCommandId scopedCommandId2;
        if (continuation instanceof zzqb) {
            zzqbVar = (zzqb) continuation;
            int i = zzqbVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzqbVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzqbVar = new zzqb(this, continuation);
            }
        }
        Object obj = zzqbVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzqbVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            zzpv.zza().zzb().zza("Sending command %s on %s", scopedCommandId.getTraitId(), this.zza);
            ref$ObjectRef = new Ref$ObjectRef();
            long jM2565markNowz9LOYto = TimeSource$Monotonic.INSTANCE.m2565markNowz9LOYto();
            InteractionClient interactionClient = (InteractionClient) this.zzc.getValue();
            if (interactionClient != null) {
                String str = this.zza;
                String traitId = scopedCommandId.getTraitId();
                ClusterPayloadWriter clusterPayloadWriterCreateWriter = SerializationCodecFactory.INSTANCE.createWriter(strictOperationValidation());
                clusterPayloadWriterCreateWriter.write(structAdapter, request);
                Unit unit = Unit.INSTANCE;
                List listListOf = CollectionsKt.listOf(new ObjectCommand(str, new TraitElementPayload(traitId, "type.googleapis.com/home.uddm.traits.Command", clusterPayloadWriterCreateWriter.toString(), null, null), z));
                zzqbVar.zzf = this;
                zzqbVar.zzg = scopedCommandId;
                structAdapter3 = structAdapter2;
                zzqbVar.zza = structAdapter3;
                zzqbVar.zzh = ref$ObjectRef;
                zzqbVar.zzi = ref$ObjectRef;
                zzqbVar.zzb = jM2565markNowz9LOYto;
                zzqbVar.zze = 1;
                objZzi = interactionClient.zzi(listListOf, zzqbVar);
                if (objZzi == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$ObjectRef2 = ref$ObjectRef;
                j = jM2565markNowz9LOYto;
                scopedCommandId2 = scopedCommandId;
            }
            throw HomeException.INSTANCE.apiNotConnected("Unable to send command for ".concat(Id.m445toStringimpl(this.zza)));
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j = zzqbVar.zzb;
        Ref$ObjectRef ref$ObjectRef3 = zzqbVar.zzi;
        ref$ObjectRef2 = zzqbVar.zzh;
        StructAdapter<RESPONSE> structAdapter4 = (StructAdapter) zzqbVar.zza;
        scopedCommandId2 = zzqbVar.zzg;
        zzqd zzqdVar = zzqbVar.zzf;
        ResultKt.throwOnFailure(obj);
        ref$ObjectRef = ref$ObjectRef3;
        this = zzqdVar;
        objZzi = obj;
        structAdapter3 = structAdapter4;
        ?? r1 = (List) objZzi;
        if (r1 != 0) {
            ref$ObjectRef.element = r1;
            long jM2536getInWholeMillisecondsimpl = Duration.m2536getInWholeMillisecondsimpl(TimeSource$Monotonic.ValueTimeMark.m2567elapsedNowUwyO8pc(j));
            zzrt zzrtVarZzb = zzpv.zza().zzb();
            String traitId2 = scopedCommandId2.getTraitId();
            String str2 = this.zza;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(traitId2).length() + 29 + String.valueOf(str2).length() + 6, 2, String.valueOf(jM2536getInWholeMillisecondsimpl)));
            sb.append("Command traitId=");
            sb.append(traitId2);
            sb.append(" on objectId=");
            sb.append(str2);
            sb.append(" took ");
            sb.append(jM2536getInWholeMillisecondsimpl);
            sb.append("ms");
            zzrtVarZzb.zza(sb.toString(), new Object[0]);
            ObjectCommandResult objectCommandResult = (ObjectCommandResult) CollectionsKt.firstOrNull((List) ref$ObjectRef2.element);
            if (objectCommandResult == null || Intrinsics.areEqual(objectCommandResult.getObjectId(), this.zza)) {
                return SerializationCodecFactory.INSTANCE.createReader(objectCommandResult != null ? objectCommandResult.getPayload() : zzd, this.strictOperationValidation()).read(structAdapter3);
            }
            HomeException.Companion companion = HomeException.INSTANCE;
            String strM445toStringimpl = Id.m445toStringimpl(this.zza);
            String objectId = objectCommandResult.getObjectId();
            throw companion.invalidArgument(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strM445toStringimpl.length() + 31 + String.valueOf(objectId).length()), "Command result for object ", strM445toStringimpl, " has ", objectId));
        }
        throw HomeException.INSTANCE.apiNotConnected("Unable to send command for ".concat(Id.m445toStringimpl(this.zza)));
    }

    @Override // com.google.home.matter.MatterTraitClient
    public final boolean strictOperationValidation() {
        HomeConfig homeConfigZza;
        InteractionClient interactionClient = (InteractionClient) this.zzc.getValue();
        if (interactionClient == null || (homeConfigZza = interactionClient.zza()) == null) {
            return true;
        }
        return homeConfigZza.getStrictOperationValidation();
    }

    public /* synthetic */ zzqd(String str, ClusterId clusterId, StateFlow stateFlow, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, clusterId, stateFlow);
    }

    private zzqd(String str, ClusterId clusterId, StateFlow stateFlow) {
        str.getClass();
        clusterId.getClass();
        stateFlow.getClass();
        this.zza = str;
        this.zzb = clusterId;
        this.zzc = stateFlow;
    }
}

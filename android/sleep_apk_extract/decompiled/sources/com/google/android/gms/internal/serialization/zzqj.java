package com.google.android.gms.internal.serialization;

import com.google.home.google.PlatformTraitClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0004\b\t\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/google/home/internal/impl/PlatformTraitClientImpl;", "Lcom/google/home/google/PlatformTraitClient;", "Lcom/google/home/Id;", "objectId", "", "Lcom/google/home/google/TraitId;", "cluster", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "interactionClient", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/nest/platform/mesh/interaction/InteractionClient;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Lkotlinx/coroutines/flow/StateFlow;", "interactionClientProvider", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "getObjectId-sJHuco4", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/StateFlow;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzqj implements PlatformTraitClient {
    private static final TraitElementPayload zzc = new TraitElementPayload("", "", "", null, null);
    private final String zza;
    private final StateFlow zzb;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzqj(String str, String str2, InteractionClient interactionClient, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(interactionClient)));
        str.getClass();
        str2.getClass();
        interactionClient.getClass();
    }

    public /* synthetic */ zzqj(String str, String str2, StateFlow stateFlow, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, stateFlow);
    }

    private zzqj(String str, String str2, StateFlow stateFlow) {
        str.getClass();
        str2.getClass();
        stateFlow.getClass();
        this.zza = str;
        this.zzb = stateFlow;
    }
}

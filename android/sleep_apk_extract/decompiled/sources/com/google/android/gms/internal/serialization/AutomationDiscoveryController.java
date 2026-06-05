package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource$WithComparableMarks;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzit, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00110\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/google/home/automation/internal/impl/AutomationDiscoveryController;", "", "Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "automationInteractionClient", "<init>", "(Lcom/google/home/automation/internal/impl/AutomationInteractionClient;)V", "Lcom/google/home/Id;", "structureId", "", "refreshByClient", "", "refreshDiscovery-4rhpr1w", "(Ljava/lang/String;Z)V", "refreshDiscovery", "Lcom/google/home/HasId;", "homeObject", "Lkotlinx/coroutines/flow/Flow;", "", "candidates", "(Lcom/google/home/HasId;)Lkotlinx/coroutines/flow/Flow;", "allCandidates", "getStructureIdForHomeObject-X8Ebcw8", "(Lcom/google/home/HasId;)Ljava/lang/String;", "getStructureIdForHomeObject", "Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/google/home/automation/internal/impl/DiscoveredCandidates;", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getStateFlow$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Z", "getRefreshByClient$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Z", "setRefreshByClient$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Z)V", "Lkotlin/time/TimeSource$WithComparableMarks;", "timeSource", "Lkotlin/time/TimeSource$WithComparableMarks;", "getTimeSource$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lkotlin/time/TimeSource$WithComparableMarks;", "setTimeSource$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lkotlin/time/TimeSource$WithComparableMarks;)V", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutomationDiscoveryController {
    private static final long zzf;
    private final AutomationInteractionClient zzb;
    private final MutableStateFlow zzc;
    private final TimeSource$WithComparableMarks zze;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        zzf = DurationKt.toDuration(1, DurationUnit.MINUTES);
    }

    public AutomationDiscoveryController(AutomationInteractionClient automationInteractionClient) {
        automationInteractionClient.getClass();
        this.zzb = automationInteractionClient;
        this.zzc = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.zze = zzrw.zza;
    }
}

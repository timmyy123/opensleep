package com.google.android.gms.internal.serialization;

import com.google.home.HomeConfig;
import com.google.home.HomeDevice;
import com.google.home.HomeManager;
import com.google.home.HomeObjectsFlow;
import com.google.home.Structure;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0010R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\u0012\u001a\u00020#8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020'8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010*R\u001b\u0010\u000f\u001a\u00020,8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010/R\u001b\u0010\u0014\u001a\u0002008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103R\u001b\u00108\u001a\u0002048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001f\u001a\u0004\b6\u00107R\u001b\u0010\u0016\u001a\u0002098@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001f\u001a\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001f\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001f\u001a\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/google/home/internal/impl/HomeManagerImpl;", "Lcom/google/home/HomeManager;", "Lcom/google/home/internal/impl/HasComponents;", "Lcom/google/home/internal/impl/HasNodes;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "interactionClientProvider", "Lcom/google/home/HomeConfig;", "homeConfig", "Lcom/google/home/internal/impl/TokenRefresh;", "tokenRefresh", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lcom/google/home/HomeConfig;Lcom/google/home/internal/impl/TokenRefresh;)V", "Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/HomeDevice;", "devices", "()Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/Structure;", "structures", "Lcom/google/home/internal/impl/ComponentImpl;", "components", "Lcom/google/home/internal/impl/MatterNode;", "nodes", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractionClientProvider$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lkotlinx/coroutines/flow/StateFlow;", "Lcom/google/home/HomeConfig;", "getHomeConfig", "()Lcom/google/home/HomeConfig;", "Lcom/google/home/internal/impl/GhpCoreMetadataController;", "ghpCoreMetadata$delegate", "Lkotlin/Lazy;", "getGhpCoreMetadata$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/GhpCoreMetadataController;", "ghpCoreMetadata", "Lcom/google/home/internal/impl/StructureController;", "structures$delegate", "getStructures$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/StructureController;", "Lcom/google/home/internal/impl/RoomController;", "rooms$delegate", "getRooms$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/RoomController;", "rooms", "Lcom/google/home/internal/impl/DeviceController;", "devices$delegate", "getDevices$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/DeviceController;", "Lcom/google/home/internal/impl/ComponentController;", "components$delegate", "getComponents$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/ComponentController;", "Lcom/google/home/internal/impl/EventController;", "events$delegate", "getEvents$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/EventController;", "events", "Lcom/google/home/internal/impl/NodeController;", "nodes$delegate", "getNodes$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/NodeController;", "Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "automationInteractionClient$delegate", "getAutomationInteractionClient", "()Lcom/google/home/automation/internal/impl/AutomationInteractionClient;", "automationInteractionClient", "Lcom/google/home/automation/internal/impl/AutomationDiscoveryController;", "discoveryController$delegate", "getDiscoveryController", "()Lcom/google/home/automation/internal/impl/AutomationDiscoveryController;", "discoveryController", "Lcom/google/home/automation/internal/impl/AutomationController;", "automationController$delegate", "getAutomationController", "()Lcom/google/home/automation/internal/impl/AutomationController;", "automationController", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzpu implements HomeManager {
    private final StateFlow zza;
    private final HomeConfig zzb;
    private final Lazy zzc;
    private final Lazy zzd;
    private final Lazy zze;
    private final Lazy zzf;
    private final Lazy zzg;
    private final Lazy zzh;
    private final Lazy zzi;
    private final Lazy zzj;
    private final Lazy zzk;

    public zzpu(StateFlow stateFlow, HomeConfig homeConfig, zzrn zzrnVar) {
        stateFlow.getClass();
        homeConfig.getClass();
        zzrnVar.getClass();
        this.zza = stateFlow;
        this.zzb = homeConfig;
        this.zzc = LazyKt.lazy(new zzpq(this, zzrnVar));
        this.zzd = LazyKt.lazy(new zzpt(this));
        this.zze = LazyKt.lazy(new zzps(this));
        this.zzf = LazyKt.lazy(new zzpn(this));
        this.zzg = LazyKt.lazy(new zzpm(this));
        this.zzh = LazyKt.lazy(new zzpp(this));
        LazyKt.lazy(new zzpr(this));
        this.zzi = LazyKt.lazy(new zzpl(this));
        this.zzj = LazyKt.lazy(new zzpo(this));
        this.zzk = LazyKt.lazy(new zzpk(this));
    }

    @Override // com.google.home.HasHomeDevices
    public final HomeObjectsFlow<HomeDevice> devices() {
        return zzf().devices();
    }

    @Override // com.google.home.HasStructures
    public final HomeObjectsFlow<Structure> structures() {
        return zzd().structures();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final StateFlow getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final HomeConfig getZzb() {
        return this.zzb;
    }

    public final zzow zzc() {
        return (zzow) this.zzc.getValue();
    }

    public final zzrb zzd() {
        return (zzrb) this.zzd.getValue();
    }

    public final zznx zzf() {
        return (zznx) this.zzf.getValue();
    }

    public final zznc zzg() {
        return (zznc) this.zzg.getValue();
    }

    public final zzom zzh() {
        return (zzom) this.zzh.getValue();
    }

    public final AutomationInteractionClient zzi() {
        return (AutomationInteractionClient) this.zzi.getValue();
    }
}

package com.google.android.gms.internal.serialization;

import com.google.home.HomeObjectsFlow;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzil, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/google/home/automation/internal/impl/AutomationController;", "Lcom/google/home/internal/impl/BaseController;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "Lcom/google/home/internal/impl/GhpCoreMetadataController;", "ghpCoreMetadataController", "<init>", "(Lcom/google/home/internal/impl/HomeManagerImpl;Lcom/google/home/internal/impl/GhpCoreMetadataController;)V", "Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/automation/Automation;", "automations", "()Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "AUTOMATIONS_FILTER_QUERY", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "sharedFlow", "Lcom/google/home/HomeObjectsFlow;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutomationController extends zzmr {
    private final zzpu zza;
    private final FilterQuery zzb;
    private final HomeObjectsFlow zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutomationController(zzpu zzpuVar, zzow zzowVar) {
        super(zzowVar);
        zzpuVar.getClass();
        zzowVar.getClass();
        this.zza = zzpuVar;
        this.zzb = new FilterQuery(null, CollectionsKt.listOf((Object[]) new FilterTraitSupported[]{new FilterTraitSupported("home.platform.traits.automation.AutomationEntityTrait"), new FilterTraitSupported("home.platform.traits.automation.AutomationExecutionTrait")}), 1, null);
        this.zzc = zzd(new zzik(FlowKt.transformLatest(zzpuVar.getZza(), new zzih(null, this)), this), zzpuVar.getZzb().get_scope());
    }
}

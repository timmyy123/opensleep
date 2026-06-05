package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/internal/impl/NodeController;", "Lcom/google/home/internal/impl/HasNodes;", "Lcom/google/home/internal/impl/BaseController;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "Lcom/google/home/internal/impl/GhpCoreMetadataController;", "ghpCoreMetadataController", "<init>", "(Lcom/google/home/internal/impl/HomeManagerImpl;Lcom/google/home/internal/impl/GhpCoreMetadataController;)V", "Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/internal/impl/MatterNode;", "nodes", "()Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "MATTER_NODE_OBJECTS_FILTER_QUERY", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "sharedFlow", "Lcom/google/home/HomeObjectsFlow;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzqh extends zzmr {
    public static final zzqe zza = new zzqe(null);
    private final zzpu zzb;
    private final FilterQuery zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqh(zzpu zzpuVar, zzow zzowVar) {
        super(zzowVar);
        zzpuVar.getClass();
        zzowVar.getClass();
        this.zzb = zzpuVar;
        this.zzc = new FilterQuery(null, CollectionsKt.listOf(new FilterTraitSupported("home.internal.traits.MatterNodeTrait")), 1, null);
        zzd(FlowKt.flowCombine(zzpuVar.zzg().getZzd(), FlowKt.transformLatest(zzpuVar.getZza(), new zzqg(null, this)), new zzqf(this, null)), zzpuVar.getZzb().get_scope());
    }
}

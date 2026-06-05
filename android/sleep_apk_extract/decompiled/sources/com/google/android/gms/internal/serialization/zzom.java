package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\b\b\u0000\u0010\t*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u000f\u0010\u0014J7\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u0017\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u000f\u0010\u0018J%\u0010\u001b\u001a\u0004\u0018\u00010\b*\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/google/home/internal/impl/EventController;", "Lcom/google/home/internal/impl/BaseController;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "Lcom/google/home/internal/impl/GhpCoreMetadataController;", "ghpCoreMetadataController", "<init>", "(Lcom/google/home/internal/impl/HomeManagerImpl;Lcom/google/home/internal/impl/GhpCoreMetadataController;)V", "", "T", "", "componentId", "Lcom/google/home/EventFactory;", "eventFactory", "Lkotlinx/coroutines/flow/Flow;", "subscribeEventsForObject", "(Ljava/lang/String;Lcom/google/home/EventFactory;)Lkotlinx/coroutines/flow/Flow;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "traitFactory", "(Ljava/lang/String;Lcom/google/home/TraitFactory;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "", "hasTrait", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Lcom/google/nest/platform/mesh/interaction/EventPayload;", "eventPayload", "parseEvent", "(Lcom/google/home/TraitFactory;Lcom/google/nest/platform/mesh/interaction/EventPayload;)Ljava/lang/Object;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "EVENTS_ON_COMPONENTS", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/google/nest/platform/mesh/interaction/ObjectEventPayload;", "sharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzom extends zzmr {
    private final zzpu zza;
    private final FilterQuery zzb;
    private final SharedFlow zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzom(zzpu zzpuVar, zzow zzowVar) {
        super(zzowVar);
        zzpuVar.getClass();
        zzowVar.getClass();
        this.zza = zzpuVar;
        this.zzb = new FilterQuery(null, CollectionsKt.listOf(new FilterObjectTypeSupported("home.internal.types.Component")), 1, null);
        this.zzc = FlowKt.shareIn(FlowKt.transformLatest(zzowVar.getZze(), new zznz(null, this)), zzpuVar.getZzb().get_scope(), SharingStarted.INSTANCE.WhileSubscribed(500L, 0L), 0);
    }
}

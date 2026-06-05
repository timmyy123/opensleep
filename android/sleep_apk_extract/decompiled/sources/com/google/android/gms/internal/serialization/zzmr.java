package com.google.android.gms.internal.serialization;

import com.google.home.HomeObjectsFlow;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0007*\u00020\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/internal/impl/BaseController;", "", "Lcom/google/home/internal/impl/GhpCoreMetadataController;", "ghpCoreMetadataController", "<init>", "(Lcom/google/home/internal/impl/GhpCoreMetadataController;)V", "Lcom/google/home/HasId;", "T", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/google/home/HomeObjectsFlow;", "asHomeObjectsSharedFlow", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lcom/google/home/HomeObjectsFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/google/home/internal/impl/GhpCoreMetadataImpl;", "ghpCoreMetadataFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzmr {
    private final SharedFlow zza;

    public zzmr(zzow zzowVar) {
        zzowVar.getClass();
        this.zza = zzowVar.getZze();
    }

    public final HomeObjectsFlow zzd(Flow flow, CoroutineScope coroutineScope) {
        flow.getClass();
        coroutineScope.getClass();
        return new HomeObjectsFlow(FlowKt.shareIn(FlowKt.distinctUntilChanged(FlowKt.transformLatest(this.zza, new zzmq(null, flow))), coroutineScope, SharingStarted.INSTANCE.WhileSubscribed(500L, 0L), 1));
    }
}

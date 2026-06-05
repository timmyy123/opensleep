package com.google.home;

import java.util.Set;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"asHomeObjectsFlow", "Lcom/google/home/HomeObjectsFlow;", "T", "Lcom/google/home/HasId;", "Lkotlinx/coroutines/flow/Flow;", "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HomeObjectsFlowKt {
    public static final <T extends HasId> HomeObjectsFlow<T> asHomeObjectsFlow(Flow<? extends Set<? extends T>> flow) {
        flow.getClass();
        return new HomeObjectsFlow<>(flow);
    }
}

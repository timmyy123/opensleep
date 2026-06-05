package com.google.home;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/google/home/HomeConfig;", "", "", "strictOperationValidation", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lcom/google/home/FactoryRegistry;", "factoryRegistry", "<init>", "(ZLkotlin/coroutines/CoroutineContext;Lcom/google/home/FactoryRegistry;)V", "Z", "getStrictOperationValidation", "()Z", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lcom/google/home/FactoryRegistry;", "getFactoryRegistry", "()Lcom/google/home/FactoryRegistry;", "Lkotlinx/coroutines/CoroutineScope;", "_scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_config-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeConfig {
    private final CoroutineScope _scope;
    private final CoroutineContext coroutineContext;
    private final FactoryRegistry factoryRegistry;
    private final boolean strictOperationValidation;

    public HomeConfig(boolean z, CoroutineContext coroutineContext, FactoryRegistry factoryRegistry) {
        factoryRegistry.getClass();
        this.strictOperationValidation = z;
        this.coroutineContext = coroutineContext;
        this.factoryRegistry = factoryRegistry;
        this._scope = CoroutineScopeKt.CoroutineScope((coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final FactoryRegistry getFactoryRegistry() {
        return this.factoryRegistry;
    }

    /* JADX INFO: renamed from: getScope, reason: from getter */
    public final CoroutineScope get_scope() {
        return this._scope;
    }

    public final boolean getStrictOperationValidation() {
        return this.strictOperationValidation;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ HomeConfig(boolean z, CoroutineContext coroutineContext, FactoryRegistry factoryRegistry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i & 2;
        this(1 == ((z ? 1 : 0) | (i & 1)), i2 != 0 ? null : coroutineContext, (i & 4) != 0 ? new FactoryRegistry(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : factoryRegistry);
    }
}

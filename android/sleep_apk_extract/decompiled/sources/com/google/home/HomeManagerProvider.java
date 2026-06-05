package com.google.home;

import com.google.android.gms.internal.serialization.InteractionClient;
import com.google.android.gms.internal.serialization.zzpu;
import com.google.android.gms.internal.serialization.zzrn;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ(\u0010\u0004\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"Lcom/google/home/HomeManagerProvider;", "", "<init>", "()V", "getInstance", "Lcom/google/home/HomeManager;", "interactionClient", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "homeConfig", "Lcom/google/home/HomeConfig;", "tokenRefresh", "Lcom/google/home/internal/impl/TokenRefresh;", "interactionClientProvider", "Lkotlinx/coroutines/flow/StateFlow;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_ghp_sdk-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeManagerProvider {
    public static final HomeManagerProvider INSTANCE = new HomeManagerProvider();

    private HomeManagerProvider() {
    }

    public final HomeManager getInstance(StateFlow<? extends InteractionClient> stateFlow, HomeConfig homeConfig, zzrn zzrnVar) {
        stateFlow.getClass();
        homeConfig.getClass();
        zzrnVar.getClass();
        return new zzpu(stateFlow, homeConfig, zzrnVar);
    }
}

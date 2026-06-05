package com.google.android.gms.internal.serialization;

import com.google.home.FlowExtensionsKt;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/google/home/internal/impl/GhpCoreMetadataController;", "Lcom/google/home/internal/impl/HasGhpCoreMetadata;", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "Lcom/google/home/internal/impl/TokenRefresh;", "tokenRefresh", "<init>", "(Lcom/google/home/internal/impl/HomeManagerImpl;Lcom/google/home/internal/impl/TokenRefresh;)V", "", "objectId", "refreshedOAuthToken", "", "Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "refreshOAuthTokenRequest", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "oAuthToken", "Ljava/lang/String;", "getOAuthToken$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Ljava/lang/String;", "setOAuthToken$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/lang/String;)V", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "CLOUD_SESSION_FILTER_QUERY", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "CLOUD_CONNECTION_STATE_FILTER_QUERY", "OAUTH_SESSION_FILTER_QUERY", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/google/home/internal/impl/GhpCoreMetadataImpl;", "permissionsSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "ghpCoreMetadataSharedFlow", "getGhpCoreMetadataSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzow {
    private final FilterQuery zza;
    private final FilterQuery zzb;
    private final FilterQuery zzc;
    private final SharedFlow zzd;
    private final SharedFlow zze;

    public zzow(zzpu zzpuVar, zzrn zzrnVar) {
        zzpuVar.getClass();
        zzrnVar.getClass();
        this.zza = new FilterQuery(null, CollectionsKt.listOf(new FilterTraitSupported("home.internal.traits.CloudSessionTrait")), 1, null);
        this.zzb = new FilterQuery(null, CollectionsKt.listOf(new FilterTraitSupported("home.internal.traits.CloudConnectionStateTrait")), 1, null);
        this.zzc = new FilterQuery(null, CollectionsKt.listOf(new FilterTraitSupported("home.internal.traits.OAuthSessionTrait")), 1, null);
        SharedFlow sharedFlowAsSharedFlow = FlowExtensionsKt.asSharedFlow(FlowKt.onEach(new zzov(FlowKt.transformLatest(zzpuVar.getZza(), new zzos(null, this))), new zzor(zzrnVar, zzpuVar, this, null)), zzpuVar.getZzb().get_scope());
        this.zzd = sharedFlowAsSharedFlow;
        this.zze = sharedFlowAsSharedFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List zzf(String str, String str2) {
        String strConcat;
        zzafr zzafrVarZza = zzafs.zza();
        zzafrVarZza.getClass();
        str2.getClass();
        zzafrVarZza.zza(str2);
        zzzg zzzgVarBuild = zzafrVarZza.build();
        zzzgVarBuild.getClass();
        zzafs zzafsVar = (zzafs) zzzgVarBuild;
        zzvk zzvkVarZza = SerializationMetadata.zza();
        zzvk zzvkVar = zzvk.zza;
        int iOrdinal = zzvkVarZza.ordinal();
        if (iOrdinal == 0) {
            byte[] byteArray = zzafsVar.toByteArray();
            byteArray.getClass();
            strConcat = "proto:".concat(String.valueOf(zzvo.zzb(byteArray)));
        } else {
            if (iOrdinal != 1) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            byte[] byteArray2 = zzafsVar.toByteArray();
            byteArray2.getClass();
            strConcat = zzvo.zzb(byteArray2);
        }
        return CollectionsKt.listOf(new ObjectCommand(str, new TraitElementPayload("home.internal.traits.OAuthSessionTrait.UpdateToken", "type.googleapis.com/home.internal.traits.OAuthSessionTrait.UpdateToken", strConcat, null, null), false));
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final SharedFlow getZze() {
        return this.zze;
    }
}

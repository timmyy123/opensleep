package com.google.android.gms.internal.serialization;

import com.google.home.TraitProvider;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/google/home/internal/impl/TraitProviderImpl;", "Lcom/google/home/TraitProvider;", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "objectData", "", "Lcom/google/home/Id;", "Lcom/google/home/Trait$TraitMetadata;", "metadataMap", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "interactionClientProvider", "", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "deviceTypeTraits", "<init>", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/Map;Lkotlinx/coroutines/flow/StateFlow;Ljava/util/Set;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "Ljava/util/Map;", "Lkotlinx/coroutines/flow/StateFlow;", "Ljava/util/Set;", "availableTraits", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzrp implements TraitProvider {
    private final ObjectData zza;
    private final Map zzb;
    private final StateFlow zzc;
    private final Set zzd;
    private final Set zze;

    public zzrp(ObjectData objectData, Map map, StateFlow stateFlow, Set set) {
        objectData.getClass();
        map.getClass();
        stateFlow.getClass();
        set.getClass();
        this.zza = objectData;
        this.zzb = map;
        this.zzc = stateFlow;
        this.zzd = set;
        this.zze = SequencesKt.toSet(SequencesKt.plus(SequencesKt.mapNotNull(CollectionsKt.asSequence(objectData.getContents().keySet()), new zzro(this)), (Iterable) set));
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzrp)) {
            return false;
        }
        zzrp zzrpVar = (zzrp) other;
        return Intrinsics.areEqual(this.zza, zzrpVar.zza) && Intrinsics.areEqual(this.zzb, zzrpVar.zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }
}

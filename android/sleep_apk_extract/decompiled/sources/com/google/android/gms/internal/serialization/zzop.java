package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.home.DeviceType;
import com.google.home.HomeManager;
import com.google.home.Id;
import com.google.home.InternalDeviceTypeFactory;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.google.PlatformTrait;
import com.google.home.google.PlatformTraitFactory;
import com.google.home.matter.MatterDeviceTypeFactory;
import com.google.home.matter.MatterTrait;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.ClusterId;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a=\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001aE\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0000¢\u0006\u0004\b\t\u0010\r\u001a-\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\t\u0010\u0012\u001ae\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u00152\u001a\u0010\u001b\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\t\u0010\u001e\u001a#\u0010$\u001a\u00020#*\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b$\u0010%\u001a#\u0010$\u001a\u00020&*\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0000¢\u0006\u0004\b$\u0010'\u001a+\u0010$\u001a\u00020#*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b$\u0010(\u001a+\u0010$\u001a\u00020&*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0000¢\u0006\u0004\b$\u0010)\u001a3\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0,0\u0015*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000+0*¢\u0006\u0004\b-\u0010.\"%\u0010\"\u001a\u00020!\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F¢\u0006\u0006\u001a\u0004\b/\u00100\"9\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0,0\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F¢\u0006\u0006\u001a\u0004\b1\u00102\"1\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002030\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F¢\u0006\u0006\u001a\u0004\b4\u00102\"(\u00108\u001a\u00020\u000e\"\b\b\u0000\u0010\u0001*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\"(\u0010;\u001a\u00020\u001f\"\b\b\u0000\u0010\u0001*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\"(\u0010=\u001a\u00020\u001f\"\b\b\u0000\u0010\u0001*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010:\"(\u0010@\u001a\u00020\u0016\"\b\b\u0000\u0010\u0001*\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/google/home/Trait;", "T", "Lcom/google/home/InternalTraitFactory;", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "objectData", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "interactionClient", "create", "(Lcom/google/home/InternalTraitFactory;Lcom/google/nest/platform/mesh/serialization/ObjectData;Lcom/google/home/Trait$TraitMetadata;Lcom/google/nest/platform/mesh/interaction/InteractionClient;)Lcom/google/home/Trait;", "Lkotlinx/coroutines/flow/StateFlow;", "interactionClientProvider", "(Lcom/google/home/InternalTraitFactory;Lcom/google/nest/platform/mesh/serialization/ObjectData;Lcom/google/home/Trait$TraitMetadata;Lkotlinx/coroutines/flow/StateFlow;)Lcom/google/home/Trait;", "", "Lcom/google/home/InternalEventFactory;", "Lcom/google/nest/platform/mesh/interaction/EventPayload;", "eventPayload", "(Lcom/google/home/InternalEventFactory;Lcom/google/nest/platform/mesh/interaction/EventPayload;)Ljava/lang/Object;", "Lcom/google/home/DeviceType;", "Lcom/google/home/InternalDeviceTypeFactory;", "", "Lcom/google/home/Id;", "metadataMap", "Lkotlin/Function1;", "", "Lcom/google/home/DeviceType$Metadata;", "deviceTypeMetadataBuilder", "Lcom/google/home/HomeManager;", "homeManager", "(Lcom/google/home/InternalDeviceTypeFactory;Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lcom/google/home/HomeManager;)Lcom/google/home/DeviceType;", "", "objectId", "Lcom/google/home/matter/serialization/ClusterId;", "clusterId", "Lcom/google/home/matter/MatterTraitClient;", "traitClient", "(Lcom/google/nest/platform/mesh/interaction/InteractionClient;Ljava/lang/String;Lcom/google/home/matter/serialization/ClusterId;)Lcom/google/home/matter/MatterTraitClient;", "Lcom/google/home/google/PlatformTraitClient;", "(Lcom/google/nest/platform/mesh/interaction/InteractionClient;Ljava/lang/String;Ljava/lang/String;)Lcom/google/home/google/PlatformTraitClient;", "(Lkotlinx/coroutines/flow/StateFlow;Ljava/lang/String;Lcom/google/home/matter/serialization/ClusterId;)Lcom/google/home/matter/MatterTraitClient;", "(Lkotlinx/coroutines/flow/StateFlow;Ljava/lang/String;Ljava/lang/String;)Lcom/google/home/google/PlatformTraitClient;", "", "Lcom/google/home/TraitFactory;", "Lcom/google/home/EventFactory;", "supportedEvents", "(Ljava/util/Set;)Ljava/util/Map;", "getClusterId", "(Lcom/google/home/InternalTraitFactory;)Lcom/google/home/matter/serialization/ClusterId;", "getSupportedEvents", "(Lcom/google/home/InternalTraitFactory;)Ljava/util/Map;", "Lcom/google/home/CommandDescriptor;", "getCommands", "commands", "getScopedEventId", "(Lcom/google/home/InternalEventFactory;)Ljava/lang/Object;", "scopedEventId", "getTraitId", "(Lcom/google/home/InternalEventFactory;)Ljava/lang/String;", "traitId", "getEventName", "eventName", "getTypeId", "(Lcom/google/home/InternalDeviceTypeFactory;)Ljava/lang/String;", "typeId", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzop {
    public static final Map zza(InternalTraitFactory internalTraitFactory) {
        internalTraitFactory.getClass();
        return internalTraitFactory instanceof MatterTraitFactory ? ((MatterTraitFactory) internalTraitFactory).getSupportedEvents() : internalTraitFactory instanceof PlatformTraitFactory ? ((PlatformTraitFactory) internalTraitFactory).getSupportedEvents() : MapsKt.emptyMap();
    }

    public static final Map zzb(InternalTraitFactory internalTraitFactory) {
        internalTraitFactory.getClass();
        return internalTraitFactory instanceof MatterTraitFactory ? ((MatterTraitFactory) internalTraitFactory).getCommands() : internalTraitFactory instanceof PlatformTraitFactory ? ((PlatformTraitFactory) internalTraitFactory).getCommands() : MapsKt.emptyMap();
    }

    public static final Trait zzc(InternalTraitFactory internalTraitFactory, ObjectData objectData, Trait.TraitMetadata traitMetadata, InteractionClient interactionClient) {
        internalTraitFactory.getClass();
        objectData.getClass();
        traitMetadata.getClass();
        interactionClient.getClass();
        DefaultConstructorMarker defaultConstructorMarker = null;
        try {
            if (internalTraitFactory instanceof PlatformTraitFactory) {
                PlatformTraitFactory platformTraitFactory = (PlatformTraitFactory) internalTraitFactory;
                TraitElementPayload traitElementPayload = (TraitElementPayload) objectData.getContents().get(platformTraitFactory.getTraitId());
                if (traitElementPayload != null) {
                    String id = objectData.getId();
                    String traitId = platformTraitFactory.getTraitId();
                    interactionClient.getClass();
                    id.getClass();
                    traitId.getClass();
                    Id.m441constructorimpl(id);
                    PlatformTrait platformTraitCreateTrait = platformTraitFactory.createTrait(traitElementPayload, traitMetadata, new zzqj(id, traitId, interactionClient, defaultConstructorMarker));
                    platformTraitCreateTrait.getClass();
                    return platformTraitCreateTrait;
                }
            } else if (internalTraitFactory instanceof MatterTraitFactory) {
                MatterTraitFactory matterTraitFactory = (MatterTraitFactory) internalTraitFactory;
                TraitElementPayload traitElementPayload2 = (TraitElementPayload) objectData.getContents().get(matterTraitFactory.getTraitId());
                if (traitElementPayload2 != null) {
                    if (!Intrinsics.areEqual(matterTraitFactory.getClusterId().getTraitId(), traitElementPayload2.getZzb())) {
                        throw new IllegalStateException("Check failed.");
                    }
                    String id2 = objectData.getId();
                    ClusterId clusterId = matterTraitFactory.getClusterId();
                    interactionClient.getClass();
                    id2.getClass();
                    clusterId.getClass();
                    Id.m441constructorimpl(id2);
                    MatterTrait matterTraitCreateTrait = matterTraitFactory.createTrait(traitElementPayload2, traitMetadata, new zzqd(id2, clusterId, interactionClient, defaultConstructorMarker));
                    matterTraitCreateTrait.getClass();
                    return matterTraitCreateTrait;
                }
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Trait Factory not part of correct class hierarchy");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final Trait zzd(InternalTraitFactory internalTraitFactory, ObjectData objectData, Trait.TraitMetadata traitMetadata, StateFlow stateFlow) {
        internalTraitFactory.getClass();
        objectData.getClass();
        traitMetadata.getClass();
        stateFlow.getClass();
        DefaultConstructorMarker defaultConstructorMarker = null;
        try {
            if (internalTraitFactory instanceof PlatformTraitFactory) {
                PlatformTraitFactory platformTraitFactory = (PlatformTraitFactory) internalTraitFactory;
                TraitElementPayload traitElementPayload = (TraitElementPayload) objectData.getContents().get(platformTraitFactory.getTraitId());
                if (traitElementPayload != null) {
                    String id = objectData.getId();
                    String traitId = platformTraitFactory.getTraitId();
                    stateFlow.getClass();
                    id.getClass();
                    traitId.getClass();
                    Id.m441constructorimpl(id);
                    PlatformTrait platformTraitCreateTrait = platformTraitFactory.createTrait(traitElementPayload, traitMetadata, new zzqj(id, traitId, stateFlow, defaultConstructorMarker));
                    platformTraitCreateTrait.getClass();
                    return platformTraitCreateTrait;
                }
            } else if (internalTraitFactory instanceof MatterTraitFactory) {
                MatterTraitFactory matterTraitFactory = (MatterTraitFactory) internalTraitFactory;
                TraitElementPayload traitElementPayload2 = (TraitElementPayload) objectData.getContents().get(matterTraitFactory.getTraitId());
                if (traitElementPayload2 != null) {
                    if (!Intrinsics.areEqual(matterTraitFactory.getClusterId().getTraitId(), traitElementPayload2.getZzb())) {
                        throw new IllegalStateException("Check failed.");
                    }
                    String id2 = objectData.getId();
                    ClusterId clusterId = matterTraitFactory.getClusterId();
                    stateFlow.getClass();
                    id2.getClass();
                    clusterId.getClass();
                    Id.m441constructorimpl(id2);
                    MatterTrait matterTraitCreateTrait = matterTraitFactory.createTrait(traitElementPayload2, traitMetadata, new zzqd(id2, clusterId, stateFlow, defaultConstructorMarker));
                    matterTraitCreateTrait.getClass();
                    return matterTraitCreateTrait;
                }
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Trait Factory not part of correct class hierarchy");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final DeviceType zzh(InternalDeviceTypeFactory internalDeviceTypeFactory, ObjectData objectData, Map map, Function1 function1, HomeManager homeManager) {
        internalDeviceTypeFactory.getClass();
        objectData.getClass();
        map.getClass();
        function1.getClass();
        homeManager.getClass();
        if (!(internalDeviceTypeFactory instanceof MatterDeviceTypeFactory)) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Type Factory not part of correct class hierarchy");
            return null;
        }
        zzpu zzpuVar = (zzpu) homeManager;
        StateFlow zza = zzpuVar.getZza();
        MatterDeviceTypeFactory matterDeviceTypeFactory = (MatterDeviceTypeFactory) internalDeviceTypeFactory;
        List<TraitFactory<?>> traits = matterDeviceTypeFactory.getTraits();
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) traits, 10, 16));
        for (Object obj : traits) {
            TraitFactory traitFactory = (TraitFactory) obj;
            InternalTraitFactory factory = traitFactory.getFactory();
            String traitId = traitFactory.getFactory().getTraitId();
            Id.m441constructorimpl(traitId);
            Trait.TraitMetadata traitMetadata = (Trait.TraitMetadata) map.get(Id.m440boximpl(traitId));
            if (traitMetadata == null) {
                traitMetadata = new Trait.TraitMetadata(null, 1, null);
            }
            linkedHashMap.put(obj, zzd(factory, objectData, traitMetadata, zza));
        }
        return matterDeviceTypeFactory.createType(linkedHashMap, function1, new zzrp(objectData, map, zza, CollectionsKt.toSet(matterDeviceTypeFactory.getTraits())), new zzoo(objectData, zzpuVar.zzh(), zzpuVar.getZzb()));
    }
}

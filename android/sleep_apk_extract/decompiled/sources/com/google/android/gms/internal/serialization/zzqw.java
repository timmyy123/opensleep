package com.google.android.gms.internal.serialization;

import com.google.home.HomeException;
import com.google.home.HomeManager;
import com.google.home.Id;
import com.google.home.Structure;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/home/internal/impl/StructureController$Companion;", "", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "structureData", "Lcom/google/home/HomeManager;", "homeManager", "Lcom/google/home/Structure;", "createStructure", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Lcom/google/home/HomeManager;)Lcom/google/home/Structure;", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "STRUCTURES_FILTER_QUERY", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzqw {
    public /* synthetic */ zzqw(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    public final Structure zza(ObjectData objectData, HomeManager homeManager) throws HomeException {
        ?? EmptyList;
        List listZzb;
        objectData.getClass();
        homeManager.getClass();
        zzpv.zza().zzb().zza("Building Structure: %s", objectData.getId());
        zztd zztdVar = (zztd) zztd.zza.zze(objectData);
        if (zztdVar == null) {
            throw HomeException.INSTANCE.invalidArgument("Trait data for home.internal.traits.StructureTrait is invalid");
        }
        Attributes zztjVar = (Attributes) Attributes.zza.zze(objectData);
        String zzb = zztdVar.getZzb();
        String id = objectData.getId();
        Id.m441constructorimpl(id);
        zzpu zzpuVar = (zzpu) homeManager;
        if (zztjVar == null || (listZzb = zztjVar.getSupportedTraits()) == null) {
            EmptyList = CollectionsKt.emptyList();
        } else {
            List<String> list = listZzb;
            EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                Id.m441constructorimpl(str);
                EmptyList.add(Id.m440boximpl(str));
            }
        }
        return new zzrl(zzb, id, zzpuVar, EmptyList, objectData, null);
    }
}

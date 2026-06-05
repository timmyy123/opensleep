package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\fJ%\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/home/internal/impl/ComponentController$Companion;", "", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "componentData", "", "isComponentMatterEndpoint", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;)Z", "data", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "Lcom/google/home/internal/impl/ComponentImpl;", "createComponent$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Lcom/google/home/internal/impl/HomeManagerImpl;)Lcom/google/home/internal/impl/ComponentImpl;", "createComponent", "component", "Lcom/google/home/internal/impl/MatterEndpointImpl;", "createMatterEndpoint$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Lcom/google/home/internal/impl/ComponentImpl;)Lcom/google/home/internal/impl/MatterEndpointImpl;", "createMatterEndpoint", "createBaseComponent", "", "", "traits", "", "assertTraitsSupportedExist", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/List;)V", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmv {
    public /* synthetic */ zzmv(DefaultConstructorMarker defaultConstructorMarker) {
    }

    private final zznq zzb(ObjectData objectData, zzpu zzpuVar) {
        zzpv.zza().zzb().zza("Building Component: %s", objectData.getId());
        zzsx zzsxVar = (zzsx) zzsx.zza.zze(objectData);
        String zzb = null;
        if (zzsxVar == null) {
            zzpv.zza().zzb().zza("Component %s does not have a ParentDeviceTrait", objectData.getId());
            zzsxVar = null;
        }
        Attributes zztjVar = (Attributes) Attributes.zza.zzf(objectData);
        if (zztjVar == null) {
            return null;
        }
        zzc(objectData, CollectionsKt.plus((Collection<? extends String>) zztjVar.getSupportedTraits(), "home.internal.traits.SupportedTypesTrait"));
        if (zzsxVar != null) {
            zzb = zzsxVar.getZzb();
            Id.m441constructorimpl(zzb);
        }
        String str = zzb;
        String id = objectData.getId();
        Id.m441constructorimpl(id);
        List<String> listZzb = zztjVar.getSupportedTraits();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZzb, 10));
        for (String str2 : listZzb) {
            Id.m441constructorimpl(str2);
            arrayList.add(Id.m440boximpl(str2));
        }
        List<String> listZza = zztjVar.getSupportedObjectTypes();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZza, 10));
        for (String str3 : listZza) {
            Id.m441constructorimpl(str3);
            arrayList2.add(Id.m440boximpl(str3));
        }
        Map mapZzc = zztjVar.getSupportedTraitInfos();
        ArrayList arrayList3 = new ArrayList(mapZzc.size());
        for (Map.Entry entry : mapZzc.entrySet()) {
            String str4 = (String) entry.getKey();
            Id.m441constructorimpl(str4);
            arrayList3.add(TuplesKt.to(Id.m440boximpl(str4), zzrm.zza((zztm) entry.getValue())));
        }
        return new zznq(id, zzpuVar, arrayList, arrayList2, str, objectData, MapsKt.toMap(arrayList3), null);
    }

    private static final void zzc(ObjectData objectData, List list) {
        Set set = CollectionsKt.toSet(CollectionsKt.sorted(objectData.getContents().keySet()));
        Set set2 = CollectionsKt.toSet(CollectionsKt.sorted(list));
        if (set.containsAll(set2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (!set2.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : set2) {
            if (!set.contains((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        String id = objectData.getId();
        String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(id).length() + 11), "Object ", id, " has");
        if (!arrayList.isEmpty()) {
            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, null, null, null, null, 63);
            strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strM.length() + 19 + String.valueOf(strJoinToString$default).length()), strM, " unexpected traits ", strJoinToString$default);
        }
        if (!arrayList2.isEmpty()) {
            String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList2, null, null, null, null, 63);
            strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strM.length() + 16 + String.valueOf(strJoinToString$default2).length()), strM, " missing traits ", strJoinToString$default2);
        }
        zzrq.zza().zzc().zza(strM, new Object[0]);
    }

    public final zznq zza(ObjectData objectData, zzpu zzpuVar) {
        objectData.getClass();
        zzpuVar.getClass();
        zznq zznqVarZzb = zzb(objectData, zzpuVar);
        if (zznqVarZzb == null) {
            return null;
        }
        Attributes zztjVar = (Attributes) Attributes.zza.zzf(objectData);
        if (zztjVar == null || !zztjVar.getSupportedTraits().contains("home.internal.traits.MatterEndpointTrait")) {
            return zznqVarZzb;
        }
        objectData.getClass();
        zzsn zzsnVar = (zzsn) zzsn.zza.zzf(objectData);
        if (zzsnVar == null) {
            return null;
        }
        String zzc = zzsnVar.getZzc();
        Id.m441constructorimpl(zzc);
        return new zzpy(zzc, zzsnVar.getZzb(), zznqVarZzb, null);
    }
}

package com.google.android.gms.internal.serialization;

import com.google.home.HomeDevice;
import com.google.home.HomeException;
import com.google.home.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000b\u001a\u0004\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/google/home/internal/impl/DeviceController$Companion;", "", "Lcom/google/home/Id;", "deviceId", "", "Lcom/google/home/internal/impl/ComponentImpl;", "allComponents", "getDeviceComponents-4rhpr1w$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "getDeviceComponents", "matchingComponentsForTheDevice", "findEndpoint0", "(Ljava/util/Set;Ljava/util/Set;)Lcom/google/home/internal/impl/ComponentImpl;", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "deviceData", "components", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "Lcom/google/home/HomeDevice;", "createDevice", "(Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/Set;Lcom/google/home/internal/impl/HomeManagerImpl;)Lcom/google/home/HomeDevice;", "", "INTERNAL_TYPES_PREFIX", "Ljava/lang/String;", "", "UTILITY_TYPES", "Ljava/util/List;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zznu {
    public /* synthetic */ zznu(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final Set zzb(String str, Set set) {
        Object obj;
        Object next;
        Set setPlus;
        str.getClass();
        set.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set) {
            String zze = ((zznq) obj2).getZze();
            if (zze != null && Id.m443equalsimpl0(zze, str)) {
                arrayList.add(obj2);
            }
        }
        Set set2 = CollectionsKt.toSet(arrayList);
        Iterator it = set2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((zznq) next) instanceof zzpy) {
                break;
            }
        }
        zzpy zzpyVar = next instanceof zzpy ? (zzpy) next : null;
        String zza = zzpyVar != null ? zzpyVar.getZza() : null;
        Iterator it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            zznq zznqVar = (zznq) next2;
            if (zznqVar instanceof zzpy) {
                zzpy zzpyVar2 = (zzpy) zznqVar;
                String zza2 = zzpyVar2.getZza();
                if (zza != null && Id.m443equalsimpl0(zza2, zza) && zzpyVar2.getZzb() == 0) {
                    obj = next2;
                    break;
                }
            }
        }
        zznq zznqVar2 = (zznq) obj;
        return (zznqVar2 == null || (setPlus = SetsKt.plus((Set<? extends zznq>) set2, zznqVar2)) == null) ? set2 : setPlus;
    }

    public final HomeDevice zza(ObjectData objectData, Set set, zzpu zzpuVar) {
        zzsr zzsrVar;
        String str;
        String str2;
        objectData.getClass();
        set.getClass();
        zzpuVar.getClass();
        zzpv.zza().zzb().zza("Building HomeDevice: %s with %d components: %s", objectData.getId(), Integer.valueOf(set.size()), CollectionsKt.joinToString$default(set, null, null, null, zzns.zza, 31));
        zzsi zzsiVar = (zzsi) zzsi.zza.zzf(objectData);
        if (zzsiVar == null) {
            zzpv.zza().zzd().zza("Device %s has an invalid DeviceTrait", objectData.getId());
            return null;
        }
        Attributes zztjVar = (Attributes) Attributes.zza.zzf(objectData);
        if (zztjVar == null) {
            zzpv.zza().zzd().zza("Device %s has an invalid SupportedTypesTrait", objectData.getId());
            return null;
        }
        List<String> listZzb = zztjVar.getSupportedTraits();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZzb, 10));
        for (String str3 : listZzb) {
            Id.m441constructorimpl(str3);
            arrayList.add(Id.m440boximpl(str3));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((zznq) it.next()).getZzc());
        }
        List listPlus = CollectionsKt.plus((Collection) arrayList, (Iterable) CollectionsKt.toSet(arrayList2));
        List<String> listZza = zztjVar.getSupportedObjectTypes();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZza, 10));
        for (String str4 : listZza) {
            Id.m441constructorimpl(str4);
            arrayList3.add(Id.m440boximpl(str4));
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList4, ((zznq) it2.next()).getZzd());
        }
        List listPlus2 = CollectionsKt.plus((Collection) arrayList3, (Iterable) CollectionsKt.toSet(arrayList4));
        ArrayList arrayList5 = new ArrayList();
        for (Object obj : listPlus2) {
            String id = ((Id) obj).getId();
            if (!StringsKt.startsWith$default(id, "home.internal.types.") && !zznx.zze.contains(id)) {
                arrayList5.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList5, 10)), 16));
        for (Object obj2 : arrayList5) {
            String id2 = ((Id) obj2).getId();
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : set) {
                if (((zznq) obj3).getZzd().contains(Id.m440boximpl(id2))) {
                    arrayList6.add(obj3);
                }
            }
            linkedHashMap.put(obj2, arrayList6);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it3.next();
            if (((List) entry.getValue()).size() > 1) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            zzpv.zza().zzc().zza("For Device %s Found %d components with type %s: %s", objectData.getId(), Integer.valueOf(((List) entry2.getValue()).size()), entry2.getKey(), CollectionsKt.joinToString$default((Iterable) entry2.getValue(), null, null, null, zznt.zza, 31));
        }
        try {
            zzsrVar = (zzsr) zzsr.zza.zze(objectData);
        } catch (HomeException unused) {
            zzpv.zza().zzc().zza("Device %s has an invalid MatterMappingTrait", objectData.getId());
            zzsrVar = null;
        }
        String id3 = objectData.getId();
        Id.m441constructorimpl(id3);
        String zzb = zzsiVar.getZzb();
        if (StringsKt.isBlank(zzsiVar.getZzd())) {
            str = null;
        } else {
            String zzd = zzsiVar.getZzd();
            Id.m441constructorimpl(zzd);
            str = zzd;
        }
        if (StringsKt.isBlank(zzsiVar.getZzc())) {
            str2 = null;
        } else {
            String zzc = zzsiVar.getZzc();
            Id.m441constructorimpl(zzc);
            str2 = zzc;
        }
        boolean z = zzsrVar != null;
        Map mapZzc = zztjVar.getSupportedTraitInfos();
        ArrayList arrayList7 = new ArrayList(mapZzc.size());
        for (Map.Entry entry3 : mapZzc.entrySet()) {
            String str5 = (String) entry3.getKey();
            Id.m441constructorimpl(str5);
            arrayList7.add(TuplesKt.to(Id.m440boximpl(str5), zzrm.zza((zztm) entry3.getValue())));
        }
        return new zzpj(id3, zzb, str, str2, listPlus, listPlus2, z, set, zzpuVar, MapsKt.toMap(arrayList7), zzsrVar != null ? ULong.m2410boximpl(zzsrVar.getZzd()) : null, null);
    }
}

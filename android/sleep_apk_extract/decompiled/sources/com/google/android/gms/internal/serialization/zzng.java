package com.google.android.gms.internal.serialization;

import com.google.home.ConnectivityState;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.Id;
import com.google.home.LocalityType;
import com.google.home.SourceConnectivity;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ9\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002¨\u0006\""}, d2 = {"Lcom/google/home/internal/impl/ComponentImpl$Companion;", "", "<init>", "()V", "typesSnapshot", "", "Lcom/google/home/DeviceType;", "component", "Lcom/google/home/internal/impl/ComponentImpl;", "isPrimary", "", "typesSnapshot$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "typeSnapshot", "T", "type", "Lcom/google/home/DeviceTypeFactory;", "typeSnapshot$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Lcom/google/home/internal/impl/ComponentImpl;Lcom/google/home/DeviceTypeFactory;Z)Lcom/google/home/DeviceType;", "isPrimaryComponent", "components", "Lcom/google/home/internal/impl/Component;", "isPrimaryComponent$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "calculateSourceConnectivityForDeviceType", "Lcom/google/home/SourceConnectivity;", "traits", "", "Lcom/google/home/Trait;", "calculateSourceConnectivityForDeviceType$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "calculateDataSourceLocalityForDevice", "Lcom/google/home/LocalityType;", "calculateCombinedConnectivityForDeviceType", "Lcom/google/home/ConnectivityState;", "calculateOwningDeviceIdSet", "Lcom/google/home/Id;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzng {
    public static final boolean zza(zznq zznqVar, Set set) {
        zznqVar.getClass();
        set.getClass();
        if (set.isEmpty()) {
            return false;
        }
        if (zznqVar instanceof zzpy) {
            zzpy zzpyVar = (zzpy) zznqVar;
            if (zzpyVar.getZzb() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : set) {
                if (obj instanceof zzpy) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((zzpy) obj2).getZzb() != 0) {
                    arrayList2.add(obj2);
                }
            }
            if (zzpyVar.getZzb() == ((zzpy) CollectionsKt.first(CollectionsKt.sortedWith(arrayList2, new zznd()))).getZzb()) {
                return true;
            }
        } else {
            String zza = zznqVar.getId();
            Iterator it = set.iterator();
            if (!it.hasNext()) {
                Types$$ExternalSyntheticBUOutline0.m();
                return false;
            }
            Object next = it.next();
            if (it.hasNext()) {
                String zza2 = ((zzmu) next).getId();
                do {
                    Object next2 = it.next();
                    String zza3 = ((zzmu) next2).getId();
                    int iCompareTo = zza2.compareTo(zza3);
                    if (iCompareTo > 0) {
                        zza2 = zza3;
                    }
                    if (iCompareTo > 0) {
                        next = next2;
                    }
                } while (it.hasNext());
            }
            if (Id.m443equalsimpl0(zza, ((zzmu) next).getId())) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : set) {
                    if (obj3 instanceof zzpy) {
                        arrayList3.add(obj3);
                    }
                }
                if (arrayList3.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final DeviceType zzb(zznq zznqVar, DeviceTypeFactory deviceTypeFactory, boolean z) {
        zznqVar.getClass();
        deviceTypeFactory.getClass();
        if (!zznqVar.has(deviceTypeFactory)) {
            return null;
        }
        List<TraitFactory<?>> traits = deviceTypeFactory.getFactory().getTraits();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(traits, 10));
        Iterator<T> it = traits.iterator();
        while (it.hasNext()) {
            arrayList.add(((TraitFactory) it.next()).getFactory().getTraitId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        Set setKeySet = zznqVar.zzf.getContents().keySet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : setKeySet) {
            if (!StringsKt.startsWith$default((String) obj, "home.internal.traits")) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            TraitFactory<? extends Trait> traitOrNull = zznqVar.getZzb().getZzb().getFactoryRegistry().getTraitOrNull((String) it2.next());
            if (traitOrNull != null) {
                arrayList3.add(traitOrNull);
            }
        }
        Set<TraitFactory> set2 = CollectionsKt.toSet(arrayList3);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set2, 10)), 16));
        for (TraitFactory traitFactory : set2) {
            String traitId = traitFactory.getFactory().getTraitId();
            Id.m441constructorimpl(traitId);
            Pair pair = TuplesKt.to(Id.m440boximpl(traitId), new Trait.TraitMetadata(zznqVar.getSourceConnectivity(traitFactory)));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        if (CollectionsKt___CollectionsKt.intersect(zznqVar.zzf.getContents().keySet(), set).isEmpty()) {
            return zzop.zzh(deviceTypeFactory.getFactory(), zznqVar.zzf, linkedHashMap, new zzne(z, set), zznqVar.getZzb());
        }
        try {
            return zzop.zzh(deviceTypeFactory.getFactory(), zznqVar.zzf, linkedHashMap, new zznf(z), zznqVar.getZzb());
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static final SourceConnectivity zzd(List list) {
        return new SourceConnectivity(zze(list), zzf(list), zzg(list));
    }

    private static final ConnectivityState zze(List list) {
        if (list == null) {
            return ConnectivityState.ONLINE;
        }
        if (list.isEmpty()) {
            return ConnectivityState.UNKNOWN;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SourceConnectivity sourceConnectivity = ((Trait) it.next()).getMetadata().getSourceConnectivity();
            ConnectivityState connectivityState = sourceConnectivity != null ? sourceConnectivity.getConnectivityState() : null;
            if (connectivityState != null) {
                arrayList.add(connectivityState);
            }
        }
        if (CollectionsKt.distinct(arrayList).size() == 1) {
            return (ConnectivityState) CollectionsKt.first((List) arrayList);
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((ConnectivityState) it2.next()) == ConnectivityState.ONLINE) {
                    return ConnectivityState.PARTIALLY_ONLINE;
                }
            }
        }
        return ConnectivityState.UNKNOWN;
    }

    private static final LocalityType zzf(List list) {
        if (list == null) {
            return LocalityType.UNSPECIFIED;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SourceConnectivity sourceConnectivity = ((Trait) it.next()).getMetadata().getSourceConnectivity();
            LocalityType dataSourceLocality = sourceConnectivity != null ? sourceConnectivity.getDataSourceLocality() : null;
            if (dataSourceLocality != null) {
                arrayList.add(dataSourceLocality);
            }
        }
        return arrayList.isEmpty() ? LocalityType.UNSPECIFIED : CollectionsKt.distinct(arrayList).size() == 1 ? (LocalityType) CollectionsKt.first((List) arrayList) : LocalityType.MIXED;
    }

    private static final Set zzg(List list) {
        Set<Id> setEmptySet;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SourceConnectivity sourceConnectivity = ((Trait) it.next()).getMetadata().getSourceConnectivity();
            if (sourceConnectivity == null || (setEmptySet = sourceConnectivity.getBackingHubs()) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, setEmptySet);
        }
        return CollectionsKt.toSet(arrayList);
    }
}

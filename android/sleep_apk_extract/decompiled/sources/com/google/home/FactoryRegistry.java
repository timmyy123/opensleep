package com.google.home;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\rJ\u0016\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0013\u001a\u00020\rJ\u0018\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\rR\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/google/home/FactoryRegistry;", "", "traits", "", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "types", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "traitRegistry", "", "", "getTrait", "traitId", "getTraitOrNull", "typeRegistry", "getType", "typeId", "getTypeOrNull", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_factory_registry-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FactoryRegistry {
    private final Map<String, TraitFactory<? extends Trait>> traitRegistry;
    private final Map<String, DeviceTypeFactory<? extends DeviceType>> typeRegistry;

    public FactoryRegistry(List<? extends TraitFactory<? extends Trait>> list, List<? extends DeviceTypeFactory<? extends DeviceType>> list2) {
        list.getClass();
        list2.getClass();
        List<? extends TraitFactory<? extends Trait>> list3 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) list3, 10, 16));
        for (Object obj : list3) {
            linkedHashMap.put(((TraitFactory) obj).getFactory().getTraitId(), obj);
        }
        this.traitRegistry = linkedHashMap;
        List<? extends DeviceTypeFactory<? extends DeviceType>> list4 = list2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) list4, 10, 16));
        for (Object obj2 : list4) {
            linkedHashMap2.put(((DeviceTypeFactory) obj2).getFactory().getTypeId(), obj2);
        }
        this.typeRegistry = linkedHashMap2;
    }

    public final TraitFactory<? extends Trait> getTrait(String traitId) throws HomeException {
        TraitFactory<? extends Trait> traitFactory;
        traitId.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, TraitFactory<? extends Trait>> entry : this.traitRegistry.entrySet()) {
            if (StringsKt.startsWith$default(traitId, entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                traitFactory = null;
                break;
            }
            traitFactory = (TraitFactory) ((Map.Entry) it.next()).getValue();
            if (traitFactory != null) {
                break;
            }
        }
        if (traitFactory != null) {
            return traitFactory;
        }
        throw HomeException.INSTANCE.sdkInitializationMissingInfo("Trait not found: ".concat(traitId));
    }

    public final TraitFactory<? extends Trait> getTraitOrNull(String traitId) {
        traitId.getClass();
        try {
            return getTrait(traitId);
        } catch (HomeException unused) {
            return null;
        }
    }

    public final DeviceTypeFactory<? extends DeviceType> getType(String typeId) throws HomeException {
        DeviceTypeFactory<? extends DeviceType> deviceTypeFactory;
        typeId.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, DeviceTypeFactory<? extends DeviceType>> entry : this.typeRegistry.entrySet()) {
            if (StringsKt.startsWith$default(typeId, entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                deviceTypeFactory = null;
                break;
            }
            deviceTypeFactory = (DeviceTypeFactory) ((Map.Entry) it.next()).getValue();
            if (deviceTypeFactory != null) {
                break;
            }
        }
        if (deviceTypeFactory != null) {
            return deviceTypeFactory;
        }
        throw HomeException.INSTANCE.sdkInitializationMissingInfo("Device type not found: ".concat(typeId));
    }

    public final DeviceTypeFactory<? extends DeviceType> getTypeOrNull(String typeId) {
        typeId.getClass();
        try {
            return getType(typeId);
        } catch (HomeException unused) {
            return null;
        }
    }

    public /* synthetic */ FactoryRegistry(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }
}

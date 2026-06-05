package com.google.home.matter;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.DeviceType;
import com.google.home.HasEvents;
import com.google.home.Id;
import com.google.home.InternalDeviceTypeFactory;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.TraitProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0004\b\t\u0010\nJU\u0010\u0014\u001a\u00028\u00002\u0018\u0010\b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u0017\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0002*\u00020\f*\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u001bR$\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/google/home/matter/MatterDeviceTypeFactory;", "Lcom/google/home/DeviceType;", "T", "Lcom/google/home/InternalDeviceTypeFactory;", "Lcom/google/home/Id;", "typeId", "", "Lcom/google/home/TraitFactory;", "traits", "<init>", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "Lcom/google/home/Trait;", "Lkotlin/Function1;", "Lcom/google/home/DeviceType$Metadata;", "metadataBuilder", "Lcom/google/home/TraitProvider;", "traitProvider", "Lcom/google/home/HasEvents;", "eventProvider", "createType", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lcom/google/home/TraitProvider;Lcom/google/home/HasEvents;)Lcom/google/home/DeviceType;", SDKConstants.PARAM_KEY, "getAs", "(Ljava/util/Map;Lcom/google/home/TraitFactory;)Lcom/google/home/Trait;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getTypeId-sJHuco4", "Ljava/util/List;", "getTraits", "()Ljava/util/List;", "java.com.google.home.matter_matter-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MatterDeviceTypeFactory<T extends DeviceType> implements InternalDeviceTypeFactory<T> {
    private final List<TraitFactory<?>> traits;
    private final String typeId;

    /* JADX WARN: Multi-variable type inference failed */
    private MatterDeviceTypeFactory(String str, List<? extends TraitFactory<?>> list) {
        str.getClass();
        list.getClass();
        this.typeId = str;
        this.traits = list;
    }

    public abstract T createType(Map<TraitFactory<?>, ? extends Trait> traits, Function1<? super List<? extends Trait>, DeviceType.Metadata> metadataBuilder, TraitProvider traitProvider, HasEvents eventProvider);

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MatterDeviceTypeFactory) && Id.m443equalsimpl0(getTypeId(), ((MatterDeviceTypeFactory) other).getTypeId());
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lcom/google/home/Trait;>(Ljava/util/Map<Lcom/google/home/TraitFactory<*>;+Lcom/google/home/Trait;>;Lcom/google/home/TraitFactory<TT;>;)TT; */
    public final Trait getAs(Map map, TraitFactory traitFactory) {
        map.getClass();
        traitFactory.getClass();
        return (Trait) map.get(traitFactory);
    }

    @Override // com.google.home.InternalTypeFactory
    public List<TraitFactory<?>> getTraits() {
        return this.traits;
    }

    @Override // com.google.home.InternalTypeFactory
    /* JADX INFO: renamed from: getTypeId-sJHuco4, reason: from getter */
    public String getTypeId() {
        return this.typeId;
    }

    public final int hashCode() {
        return Id.m444hashCodeimpl(getTypeId());
    }

    public final String toString() {
        return getTypeId();
    }

    public /* synthetic */ MatterDeviceTypeFactory(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }
}

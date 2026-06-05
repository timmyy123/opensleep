package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.HasConnectivityState;
import com.google.home.Id;
import com.google.home.SourceConnectivity;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001:\u0001BBc\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\"\u001a\u00020\u0018\"\b\b\u0000\u0010\u001f*\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b\"\u0010#J)\u0010$\u001a\u0004\u0018\u00010\r\"\b\b\u0000\u0010\u001f*\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b$\u0010%J'\u0010\"\u001a\u00020\u0018\"\b\b\u0000\u0010\u001f*\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b\"\u0010)J\u0017\u0010\"\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0013H\u0000¢\u0006\u0004\b+\u0010,J+\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000-\"\b\b\u0000\u0010\u001f*\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b!\u0010.J\u001d\u00103\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00132\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u0010\u0015R\u0014\u00107\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u00106R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010;\u001a\u0004\b>\u0010=R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00104\u001a\u0004\b?\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010@R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010A¨\u0006C"}, d2 = {"Lcom/google/home/internal/impl/ComponentImpl;", "Lcom/google/home/internal/impl/Component;", "Lcom/google/home/Id;", "id", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "", "supportedTraits", "supportedTypes", "parentDeviceId", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "objectData", "", "Lcom/google/home/SourceConnectivity;", "sourceConnectivityMap", "<init>", "(Ljava/lang/String;Lcom/google/home/internal/impl/HomeManagerImpl;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/ObjectData;Ljava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "component", "(Lcom/google/home/internal/impl/ComponentImpl;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/home/Trait;", "T", "Lcom/google/home/TraitFactory;", "trait", "has", "(Lcom/google/home/TraitFactory;)Z", "getSourceConnectivity", "(Lcom/google/home/TraitFactory;)Lcom/google/home/SourceConnectivity;", "Lcom/google/home/DeviceType;", "Lcom/google/home/DeviceTypeFactory;", "type", "(Lcom/google/home/DeviceTypeFactory;)Z", "traitId", "has$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "(Ljava/lang/String;)Z", "Lkotlinx/coroutines/flow/Flow;", "(Lcom/google/home/TraitFactory;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ULong;", "expectedVersion", "traitVersionAtleast-2TYgG_w", "(Ljava/lang/String;J)Z", "traitVersionAtleast", "Ljava/lang/String;", "getId-sJHuco4", "()Lcom/google/home/SourceConnectivity;", "sourceConnectivity", "Lcom/google/home/internal/impl/HomeManagerImpl;", "getHomeManager", "()Lcom/google/home/internal/impl/HomeManagerImpl;", "Ljava/util/List;", "getSupportedTraits", "()Ljava/util/List;", "getSupportedTypes", "getParentDeviceId-JizaUOo", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "Ljava/util/Map;", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class zznq implements zzmu {
    private final String zza;
    private final zzpu zzb;
    private final List zzc;
    private final List zzd;
    private final String zze;
    private final ObjectData zzf;
    private final Map zzg;

    private zznq(String str, zzpu zzpuVar, List list, List list2, String str2, ObjectData objectData, Map map) {
        str.getClass();
        zzpuVar.getClass();
        list.getClass();
        list2.getClass();
        objectData.getClass();
        map.getClass();
        this.zza = str;
        this.zzb = zzpuVar;
        this.zzc = list;
        this.zzd = list2;
        this.zze = str2;
        this.zzf = objectData;
        this.zzg = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof zznq) {
            zznq zznqVar = (zznq) other;
            if (!Id.m443equalsimpl0(this.zza, zznqVar.zza) || !Intrinsics.areEqual(this.zzc, zznqVar.zzc) || !Intrinsics.areEqual(this.zzd, zznqVar.zzd)) {
                return false;
            }
            String str = this.zze;
            String str2 = zznqVar.zze;
            if (str != null ? !(str2 == null || !Id.m443equalsimpl0(str, str2)) : str2 == null) {
                return Intrinsics.areEqual(this.zzf, zznqVar.zzf) && Intrinsics.areEqual(getSourceConnectivity(), zznqVar.getSourceConnectivity()) && Intrinsics.areEqual(this.zzg, zznqVar.zzg);
            }
        }
        return false;
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public final String getId() {
        return this.zza;
    }

    public final SourceConnectivity getSourceConnectivity() {
        HasConnectivityState.Companion companion = HasConnectivityState.INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : this.zzg.entrySet()) {
            if (!StringsKt.startsWith$default(((Id) entry.getKey()).getId(), "home.internal.traits")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return companion.computeSourceConnectivity$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(CollectionsKt.toList(linkedHashMap.values()));
    }

    @Override // com.google.home.HasDeviceTypes
    public final <T extends DeviceType> boolean has(DeviceTypeFactory<T> type) {
        type.getClass();
        return this.zzd.contains(Id.m440boximpl(type.getFactory().getTypeId()));
    }

    public int hashCode() {
        int iHashCode = this.zzd.hashCode() + ((this.zzc.hashCode() + (Id.m444hashCodeimpl(this.zza) * 31)) * 31);
        String str = this.zze;
        int iHashCode2 = (this.zzf.hashCode() + zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, str != null ? Id.m444hashCodeimpl(str) : 0, 31)) * 31;
        String str2 = this.zze;
        Id idM440boximpl = str2 != null ? Id.m440boximpl(str2) : null;
        int iHashCode3 = idM440boximpl != null ? idM440boximpl.hashCode() : 0;
        return getSourceConnectivity().hashCode() + ((this.zzg.hashCode() + ((iHashCode2 + iHashCode3) * 31)) * 31);
    }

    public String toString() {
        String strM445toStringimpl = Id.m445toStringimpl(this.zza);
        String str = this.zze;
        String strM445toStringimpl2 = str == null ? "null" : Id.m445toStringimpl(str);
        List list = this.zzc;
        List list2 = this.zzd;
        SourceConnectivity sourceConnectivity = getSourceConnectivity();
        Map map = this.zzg;
        StringBuilder sb = new StringBuilder(sourceConnectivity.toString().length() + list.toString().length() + strM445toStringimpl2.length() + strM445toStringimpl.length() + 34 + 18 + 17 + list2.toString().length() + 15 + 24 + String.valueOf(map).length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, "ComponentImpl(id=", strM445toStringimpl, ", parentDeviceId=", strM445toStringimpl2);
        sb.append(", supportedTraits=");
        sb.append(list);
        sb.append(", supportedTypes=");
        sb.append(list2);
        sb.append(", connectivity=");
        sb.append(sourceConnectivity);
        sb.append(", sourceConnectivityMap=");
        sb.append(map);
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final zzpu getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final List getZzd() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: zzd, reason: from getter */
    public final String getZze() {
        return this.zze;
    }

    public final boolean zze(String str) {
        str.getClass();
        Id.m441constructorimpl(str);
        return this.zzc.contains(Id.m440boximpl(str));
    }

    public final Flow zzf(TraitFactory traitFactory) {
        traitFactory.getClass();
        if (!has(traitFactory)) {
            return FlowKt.emptyFlow();
        }
        return FlowKt.distinctUntilChanged(FlowKt.flow(new zznj(this.zzb.zzg().getZzd().m439itemFlowImLHPvw(this.zza), null, traitFactory.getFactory().getTraitId(), traitFactory, this)));
    }

    public /* synthetic */ zznq(String str, zzpu zzpuVar, List list, List list2, String str2, ObjectData objectData, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, zzpuVar, list, list2, str2, objectData, map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zznq(zznq zznqVar) {
        this(zznqVar.zza, zznqVar.zzb, zznqVar.zzc, zznqVar.zzd, zznqVar.zze, zznqVar.zzf, zznqVar.zzg);
        zznqVar.getClass();
    }

    @Override // com.google.home.HasTraits
    public final <T extends Trait> boolean has(TraitFactory<T> trait) {
        trait.getClass();
        return zze(trait.getFactory().getTraitId());
    }

    public final <T extends Trait> SourceConnectivity getSourceConnectivity(TraitFactory<T> trait) {
        trait.getClass();
        String traitId = trait.getFactory().getTraitId();
        Id.m441constructorimpl(traitId);
        return (SourceConnectivity) this.zzg.get(Id.m440boximpl(traitId));
    }
}

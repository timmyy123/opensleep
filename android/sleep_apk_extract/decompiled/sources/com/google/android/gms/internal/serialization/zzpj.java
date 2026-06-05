package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.HasConnectivityState;
import com.google.home.HomeDevice;
import com.google.home.Id;
import com.google.home.SourceConnectivity;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u008d\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u000b\"\b\b\u0000\u0010\u001a*\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001d\u001a\u00020\u000b\"\b\b\u0000\u0010\u001a*\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b\u001d\u0010\"J-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\b\b\u0000\u0010\u001a*\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0017¢\u0006\u0004\b!\u0010$J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\b\b\u0000\u0010\u001a*\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u001c\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0096\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020/0\r¢\u0006\u0004\b0\u00101J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b2\u00103R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u0010'R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b6\u0010'R\u0014\u00109\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b=\u0010<R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u00101R\u001a\u0010\u0011\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010@\u001a\u0004\bA\u0010BR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010CR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010D\u001a\u0004\bE\u00103R \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0F0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/google/home/internal/impl/HomeDeviceImpl;", "Lcom/google/home/HomeDevice;", "Lcom/google/home/Id;", "id", "", "name", "structureId", "roomId", "", "supportedTraits", "supportedTypes", "", "isMatterDevice", "", "Lcom/google/home/internal/impl/ComponentImpl;", "components", "Lcom/google/home/internal/impl/HomeManagerImpl;", "homeManager", "", "Lcom/google/home/SourceConnectivity;", "sourceConnectivityMap", "Lkotlin/ULong;", "matterNodeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/util/Collection;Lcom/google/home/internal/impl/HomeManagerImpl;Ljava/util/Map;Lkotlin/ULong;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Lcom/google/home/DeviceType;", "T", "Lcom/google/home/DeviceTypeFactory;", "type", "has", "(Lcom/google/home/DeviceTypeFactory;)Z", "Lcom/google/home/Trait;", "Lcom/google/home/TraitFactory;", "trait", "(Lcom/google/home/TraitFactory;)Z", "Lkotlinx/coroutines/flow/Flow;", "(Lcom/google/home/TraitFactory;)Lkotlinx/coroutines/flow/Flow;", "(Lcom/google/home/DeviceTypeFactory;)Lkotlinx/coroutines/flow/Flow;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/home/internal/impl/MatterEndpoint;", "endpoints", "()Ljava/util/Collection;", "matterNodeId-6VbMDqA", "()Lkotlin/ULong;", "Ljava/lang/String;", "getId-sJHuco4", "getName", "getSourceConnectivity", "()Lcom/google/home/SourceConnectivity;", "sourceConnectivity", "Ljava/util/List;", "getSupportedTraits", "()Ljava/util/List;", "getSupportedTypes", "Ljava/util/Collection;", "getComponents$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "Lcom/google/home/internal/impl/HomeManagerImpl;", "getHomeManager$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "()Lcom/google/home/internal/impl/HomeManagerImpl;", "Ljava/util/Map;", "Lkotlin/ULong;", "getMatterNodeId-6VbMDqA$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "", "componentsFlow", "Lkotlinx/coroutines/flow/Flow;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzpj implements HomeDevice {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final List zzf;
    private final boolean zzg;
    private final Collection zzh;
    private final zzpu zzi;
    private final Map zzj;
    private final Flow zzk;
    private final boolean zzl;
    private final boolean zzm;

    public /* synthetic */ zzpj(String str, String str2, String str3, String str4, List list, List list2, boolean z, Collection collection, zzpu zzpuVar, Map map, ULong uLong, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        str2.getClass();
        list.getClass();
        list2.getClass();
        collection.getClass();
        zzpuVar.getClass();
        map.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = list;
        this.zzf = list2;
        this.zzg = z;
        this.zzh = collection;
        this.zzi = zzpuVar;
        this.zzj = map;
        this.zzk = FlowKt.distinctUntilChanged(new zzpb(zzpuVar.zzg().getZzd(), this));
        this.zzl = str3 != null;
        this.zzm = str4 != null;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof zzpj) {
            zzpj zzpjVar = (zzpj) other;
            if (Id.m443equalsimpl0(this.zza, zzpjVar.zza) && Intrinsics.areEqual(this.zzb, zzpjVar.zzb)) {
                String str = this.zzc;
                String str2 = zzpjVar.zzc;
                if (str != null ? !(str2 == null || !Id.m443equalsimpl0(str, str2)) : str2 == null) {
                    String str3 = this.zzd;
                    String str4 = zzpjVar.zzd;
                    if (str3 != null ? !(str4 == null || !Id.m443equalsimpl0(str3, str4)) : str4 == null) {
                        return Intrinsics.areEqual(this.zze, zzpjVar.zze) && Intrinsics.areEqual(this.zzf, zzpjVar.zzf) && this.zzg == zzpjVar.zzg && Intrinsics.areEqual(getSourceConnectivity(), zzpjVar.getSourceConnectivity());
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public final String getId() {
        return this.zza;
    }

    @Override // com.google.home.HomeDevice
    /* JADX INFO: renamed from: getName, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    public final SourceConnectivity getSourceConnectivity() {
        Collection collection = this.zzh;
        HasConnectivityState.Companion companion = HasConnectivityState.INSTANCE;
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(((zznq) it.next()).getSourceConnectivity());
        }
        return companion.computeSourceConnectivity$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(CollectionsKt.toList(arrayList));
    }

    @Override // com.google.home.HasDeviceTypes
    public final <T extends DeviceType> boolean has(DeviceTypeFactory<T> type) {
        Object next;
        type.getClass();
        Iterator it = this.zzh.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((zznq) next).has(type)) {
                break;
            }
        }
        return next != null;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + (Id.m444hashCodeimpl(this.zza) * 31);
        String str = this.zzc;
        int iM = zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, str != null ? Id.m444hashCodeimpl(str) : 0, 31);
        String str2 = this.zzd;
        return getSourceConnectivity().hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.zzg, FileInsert$$ExternalSyntheticOutline0.m(this.zzf, FileInsert$$ExternalSyntheticOutline0.m(this.zze, (iM + (str2 != null ? Id.m444hashCodeimpl(str2) : 0)) * 31, 31), 31), 31);
    }

    public final String toString() {
        String str = this.zzc;
        String strM445toStringimpl = Id.m445toStringimpl(this.zza);
        String strM445toStringimpl2 = str == null ? "null" : Id.m445toStringimpl(str);
        String str2 = this.zzd;
        String strM445toStringimpl3 = str2 != null ? Id.m445toStringimpl(str2) : "null";
        String str3 = this.zzb;
        List list = this.zze;
        List list2 = this.zzf;
        boolean z = this.zzg;
        SourceConnectivity sourceConnectivity = getSourceConnectivity();
        Collection collection = this.zzh;
        StringBuilder sb = new StringBuilder(String.valueOf(collection).length() + sourceConnectivity.toString().length() + String.valueOf(list).length() + strM445toStringimpl3.length() + zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(strM445toStringimpl.length() + 21, 14, String.valueOf(str3)), 9, strM445toStringimpl2) + 18 + 17 + String.valueOf(list2).length() + 17 + String.valueOf(z).length() + 21 + 12 + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "HomeDevice(id=", strM445toStringimpl, ", name=", str3);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", structureId=", strM445toStringimpl2, ", roomId=", strM445toStringimpl3);
        sb.append(", supportedTraits=");
        sb.append(list);
        sb.append(", supportedTypes=");
        sb.append(list2);
        sb.append(", isMatterDevice=");
        sb.append(z);
        sb.append(", sourceConnectivity=");
        sb.append(sourceConnectivity);
        sb.append(", endpoints=");
        sb.append(collection);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.home.HomeDevice
    public final <T extends Trait> Flow<T> trait(TraitFactory<T> trait) {
        Object next;
        Flow<T> flowZzf;
        trait.getClass();
        Iterator it = this.zzh.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((zznq) next).has(trait)) {
                break;
            }
        }
        zznq zznqVar = (zznq) next;
        return (zznqVar == null || (flowZzf = zznqVar.zzf(trait)) == null) ? FlowKt.emptyFlow() : flowZzf;
    }

    @Override // com.google.home.HasDeviceTypes
    public final <T extends DeviceType> Flow<T> type(DeviceTypeFactory<T> type) {
        Object next;
        type.getClass();
        Iterator it = this.zzh.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((zznq) next).has(type)) {
                break;
            }
        }
        return next == null ? FlowKt.emptyFlow() : FlowKt.flow(new zzpf(this.zzk, null, type));
    }

    @Override // com.google.home.HasTraits
    public final <T extends Trait> boolean has(TraitFactory<T> trait) {
        Object next;
        trait.getClass();
        Iterator it = this.zzh.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((zznq) next).has(trait)) {
                break;
            }
        }
        return next != null;
    }
}

package com.google.android.gms.internal.serialization;

import com.google.home.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\b\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/google/home/internal/impl/GhpCoreMetadataController$Companion;", "", "<init>", "()V", "createMetaData", "Lcom/google/home/internal/impl/GhpCoreMetadataImpl;", "metadataObjects", "", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "createMetaData$java_com_google_nest_platform_mesh_semantic_src_com_google_home_impl_android", "getObjectsWithTrait", "traitId", "", "objects", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzoq {
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final zzox zza(List list) {
        zzsf zzsfVar;
        zzsf zzsfVar2;
        Iterator it;
        zzsb zzsbVarZza;
        zzsf zzsfVarZza;
        list.getClass();
        List listZzb = zzb("home.internal.traits.CloudSessionTrait", list);
        if (listZzb.isEmpty()) {
            zzpv.zza().zzb().zza("Unable to fetch the Object with CloudSessionTrait.", new Object[0]);
            return null;
        }
        List listZzb2 = zzb("home.internal.traits.OAuthSessionTrait", list);
        if (listZzb2.isEmpty()) {
            zzpv.zza().zzb().zza("Unable to fetch the Object with OAuthSessionTrait.", new Object[0]);
            return null;
        }
        List listZzb3 = zzb("home.internal.traits.CloudConnectionStateTrait", list);
        if (listZzb3.isEmpty()) {
            zzpv.zza().zzb().zza("Unable to fetch the Object with CloudConnectionStateTrait.", new Object[0]);
        }
        List list2 = listZzb;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Attributes zzseVar = (Attributes) Attributes.zza.zze((ObjectData) it2.next());
            if (zzseVar == null || (zzsfVarZza = zzseVar.getAuthState()) == null) {
                zzsfVarZza = zzsf.zza;
            }
            arrayList.add(zzsfVarZza);
        }
        List list3 = CollectionsKt.toList(arrayList);
        if (CollectionsKt.distinct(list3).size() == 1) {
            zzsfVar = (zzsf) CollectionsKt.first(list3);
        } else {
            zzsf zzsfVar3 = zzsf.zzc;
            if (list3.contains(zzsfVar3)) {
                zzsfVar2 = zzsfVar3;
                List list4 = listZzb3;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                it = list4.iterator();
                while (it.hasNext()) {
                    Attributes zzsaVar = (Attributes) Attributes.zza.zze((ObjectData) it.next());
                    if (zzsaVar == null || (zzsbVarZza = zzsaVar.getConnectionState()) == null) {
                        zzsbVarZza = zzsb.zza;
                    }
                    arrayList2.add(zzsbVarZza);
                }
                List list5 = CollectionsKt.toList(arrayList2);
                String id = ((ObjectData) CollectionsKt.first(listZzb)).getId();
                Id.m441constructorimpl(id);
                return new zzox(id, zzsfVar2, (zzsb) CollectionsKt.firstOrNull(list5), ((ObjectData) CollectionsKt.first(listZzb2)).getId(), null);
            }
            zzsfVar = zzsf.zza;
        }
        zzsfVar2 = zzsfVar;
        List list42 = listZzb3;
        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list42, 10));
        it = list42.iterator();
        while (it.hasNext()) {
        }
        List list52 = CollectionsKt.toList(arrayList22);
        String id2 = ((ObjectData) CollectionsKt.first(listZzb)).getId();
        Id.m441constructorimpl(id2);
        return new zzox(id2, zzsfVar2, (zzsb) CollectionsKt.firstOrNull(list52), ((ObjectData) CollectionsKt.first(listZzb2)).getId(), null);
    }

    private static final List zzb(String str, List list) {
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ObjectData) obj).getContents().get(str) != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

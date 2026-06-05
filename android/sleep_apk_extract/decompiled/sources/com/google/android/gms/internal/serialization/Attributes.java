package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zztj, reason: from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001!B=\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JF\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u0016R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001e\u0010\u0016R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0019¨\u0006\""}, d2 = {"Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$Attributes;", "Lcom/google/nest/platform/mesh/serialization/GhpSerializable;", "", "", "supportedObjectTypes", "supportedTraits", "", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$SupportedTraitInfo;", "supportedTraitInfos", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1", "()Ljava/util/List;", "component2", "component3", "()Ljava/util/Map;", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;)Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$Attributes;", "Ljava/util/List;", "getSupportedObjectTypes", "getSupportedTraits", "Ljava/util/Map;", "getSupportedTraitInfos", "Companion", "java.com.google.nest.platform.mesh.data_model.generated.internal.ghp.traits_internal_trait_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Attributes implements GhpSerializable {
    public static final zzti zza = new zzti(null);

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final List supportedObjectTypes;

    /* JADX INFO: renamed from: zzc, reason: from toString */
    private final List supportedTraits;

    /* JADX INFO: renamed from: zzd, reason: from toString */
    private final Map supportedTraitInfos;

    public Attributes(List list, List list2, Map map) {
        list.getClass();
        list2.getClass();
        map.getClass();
        this.supportedObjectTypes = list;
        this.supportedTraits = list2;
        this.supportedTraitInfos = map;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attributes)) {
            return false;
        }
        Attributes attributes = (Attributes) other;
        return Intrinsics.areEqual(this.supportedObjectTypes, attributes.supportedObjectTypes) && Intrinsics.areEqual(this.supportedTraits, attributes.supportedTraits) && Intrinsics.areEqual(this.supportedTraitInfos, attributes.supportedTraitInfos);
    }

    public final int hashCode() {
        int iHashCode = this.supportedTraits.hashCode() + (this.supportedObjectTypes.hashCode() * 31);
        return this.supportedTraitInfos.hashCode() + (iHashCode * 31);
    }

    public final String toString() {
        List list = this.supportedObjectTypes;
        int length = String.valueOf(list).length();
        List list2 = this.supportedTraits;
        int length2 = String.valueOf(list2).length();
        Map map = this.supportedTraitInfos;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 50, length2, 22, String.valueOf(map).length()) + 1);
        sb.append("Attributes(supportedObjectTypes=");
        sb.append(list);
        sb.append(", supportedTraits=");
        sb.append(list2);
        sb.append(", supportedTraitInfos=");
        sb.append(map);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final List getSupportedObjectTypes() {
        return this.supportedObjectTypes;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getSupportedTraits() {
        return this.supportedTraits;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final Map getSupportedTraitInfos() {
        return this.supportedTraitInfos;
    }
}

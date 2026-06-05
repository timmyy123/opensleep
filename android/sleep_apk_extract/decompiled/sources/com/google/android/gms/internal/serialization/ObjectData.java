package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzvi, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\"B5\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0018\u001a\u00020\u000022\u0010\u0017\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00160\u0015\"\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R'\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/ObjectData;", "", "", "Lcom/google/nest/platform/mesh/serialization/ObjectId;", "id", "", "Lcom/google/nest/platform/mesh/serialization/TraitId;", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "contents", "", "useTimedInteraction", "<init>", "(Ljava/lang/String;Ljava/util/Map;Z)V", "other", "equals", "(Ljava/lang/Object;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "Lkotlin/Pair;", "overrides", "copy", "([Lkotlin/Pair;)Lcom/google/nest/platform/mesh/serialization/ObjectData;", "Ljava/lang/String;", "getId", "Ljava/util/Map;", "getContents", "()Ljava/util/Map;", "Z", "getUseTimedInteraction", "()Z", "Companion", "java.com.google.nest.platform.mesh.serialization_serialization_objects-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObjectData {
    public static final zzvh zza = new zzvh(null);

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final String id;

    /* JADX INFO: renamed from: zzc, reason: from toString */
    private final Map contents;

    /* JADX INFO: renamed from: zzd, reason: from toString */
    private final boolean useTimedInteraction;

    public ObjectData(String str, Map map, boolean z) {
        str.getClass();
        map.getClass();
        this.id = str;
        this.contents = map;
        this.useTimedInteraction = z;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObjectData)) {
            return false;
        }
        ObjectData objectData = (ObjectData) other;
        return Intrinsics.areEqual(this.id, objectData.id) && Intrinsics.areEqual(this.contents, objectData.contents) && this.useTimedInteraction == objectData.useTimedInteraction;
    }

    public final int hashCode() {
        int iHashCode = this.contents.hashCode() + (this.id.hashCode() * 31);
        return Boolean.hashCode(this.useTimedInteraction) + (iHashCode * 31);
    }

    public final String toString() {
        String str = this.id;
        int length = String.valueOf(str).length();
        Map map = this.contents;
        int length2 = String.valueOf(map).length();
        boolean z = this.useTimedInteraction;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 25, length2, 22, String.valueOf(z).length()) + 1);
        sb.append("ObjectData(id=");
        sb.append(str);
        sb.append(", contents=");
        sb.append(map);
        sb.append(", useTimedInteraction=");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final Map getContents() {
        return this.contents;
    }
}

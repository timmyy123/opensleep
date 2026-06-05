package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzuf, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/ObjectCommandResult;", "", "objectId", "", "payload", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "<init>", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;)V", "getObjectId", "()Ljava/lang/String;", "getPayload", "()Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ObjectCommandResult {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final String objectId;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final TraitElementPayload payload;

    public ObjectCommandResult(String str, TraitElementPayload traitElementPayload) {
        str.getClass();
        this.objectId = str;
        this.payload = traitElementPayload;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObjectCommandResult)) {
            return false;
        }
        ObjectCommandResult objectCommandResult = (ObjectCommandResult) other;
        return Intrinsics.areEqual(this.objectId, objectCommandResult.objectId) && Intrinsics.areEqual(this.payload, objectCommandResult.payload);
    }

    public final int hashCode() {
        return this.payload.hashCode() + (this.objectId.hashCode() * 31);
    }

    public final String toString() {
        String str = this.objectId;
        int length = String.valueOf(str).length();
        TraitElementPayload traitElementPayload = this.payload;
        StringBuilder sb = new StringBuilder(length + 39 + traitElementPayload.toString().length() + 1);
        sb.append("ObjectCommandResult(objectId=");
        sb.append(str);
        sb.append(", payload=");
        sb.append(traitElementPayload);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getObjectId() {
        return this.objectId;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final TraitElementPayload getPayload() {
        return this.payload;
    }
}

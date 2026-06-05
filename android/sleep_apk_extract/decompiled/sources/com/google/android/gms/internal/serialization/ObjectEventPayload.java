package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzuh, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/ObjectEventPayload;", "", "objectId", "", "eventPayload", "Lcom/google/nest/platform/mesh/interaction/EventPayload;", "<init>", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/interaction/EventPayload;)V", "getObjectId", "()Ljava/lang/String;", "getEventPayload", "()Lcom/google/nest/platform/mesh/interaction/EventPayload;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ObjectEventPayload {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final String objectId;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final EventPayload eventPayload;

    public ObjectEventPayload(String str, EventPayload eventPayload) {
        str.getClass();
        eventPayload.getClass();
        this.objectId = str;
        this.eventPayload = eventPayload;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObjectEventPayload)) {
            return false;
        }
        ObjectEventPayload objectEventPayload = (ObjectEventPayload) other;
        return Intrinsics.areEqual(this.objectId, objectEventPayload.objectId) && Intrinsics.areEqual(this.eventPayload, objectEventPayload.eventPayload);
    }

    public final int hashCode() {
        return this.eventPayload.hashCode() + (this.objectId.hashCode() * 31);
    }

    public final String toString() {
        String str = this.objectId;
        int length = String.valueOf(str).length();
        EventPayload eventPayload = this.eventPayload;
        StringBuilder sb = new StringBuilder(length + 43 + String.valueOf(eventPayload).length() + 1);
        sb.append("ObjectEventPayload(objectId=");
        sb.append(str);
        sb.append(", eventPayload=");
        sb.append(eventPayload);
        sb.append(")");
        return sb.toString();
    }
}

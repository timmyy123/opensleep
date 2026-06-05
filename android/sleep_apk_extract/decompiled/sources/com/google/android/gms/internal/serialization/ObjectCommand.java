package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzue, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "", "objectId", "", "payload", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "useTimedCommand", "", "<init>", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;Z)V", "getObjectId", "()Ljava/lang/String;", "getPayload", "()Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "getUseTimedCommand", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ObjectCommand {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final String objectId;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final TraitElementPayload payload;

    /* JADX INFO: renamed from: zzc, reason: from toString */
    private final boolean useTimedCommand;

    public ObjectCommand(String str, TraitElementPayload traitElementPayload, boolean z) {
        str.getClass();
        traitElementPayload.getClass();
        this.objectId = str;
        this.payload = traitElementPayload;
        this.useTimedCommand = z;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObjectCommand)) {
            return false;
        }
        ObjectCommand objectCommand = (ObjectCommand) other;
        return Intrinsics.areEqual(this.objectId, objectCommand.objectId) && Intrinsics.areEqual(this.payload, objectCommand.payload) && this.useTimedCommand == objectCommand.useTimedCommand;
    }

    public final int hashCode() {
        int iHashCode = this.payload.hashCode() + (this.objectId.hashCode() * 31);
        return Boolean.hashCode(this.useTimedCommand) + (iHashCode * 31);
    }

    public final String toString() {
        String str = this.objectId;
        int length = String.valueOf(str).length();
        TraitElementPayload traitElementPayload = this.payload;
        int length2 = traitElementPayload.toString().length();
        boolean z = this.useTimedCommand;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 33, length2, 18, String.valueOf(z).length()) + 1);
        sb.append("ObjectCommand(objectId=");
        sb.append(str);
        sb.append(", payload=");
        sb.append(traitElementPayload);
        sb.append(", useTimedCommand=");
        sb.append(z);
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

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final boolean getUseTimedCommand() {
        return this.useTimedCommand;
    }
}

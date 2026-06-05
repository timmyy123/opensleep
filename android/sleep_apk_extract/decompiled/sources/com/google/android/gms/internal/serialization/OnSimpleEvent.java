package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzui, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J4\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/OnSimpleEvent;", "Lcom/google/nest/platform/mesh/interaction/EventSubscriberHandler;", "handle", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "objectId", "", "events", "", "Lcom/google/nest/platform/mesh/interaction/EventPayload;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHandle-fY7bYOI", "()Ljava/lang/String;", "Ljava/lang/String;", "getObjectId", "getEvents", "()Ljava/util/List;", "component1", "component1-fY7bYOI", "component2", "component3", "copy", "copy-17BgtZs", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/google/nest/platform/mesh/interaction/OnSimpleEvent;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class OnSimpleEvent {
    private final String zza;
    private final String zzb;
    private final List zzc;

    public /* synthetic */ OnSimpleEvent(String str, String str2, List list, DefaultConstructorMarker defaultConstructorMarker) {
        str.getClass();
        str2.getClass();
        list.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnSimpleEvent)) {
            return false;
        }
        OnSimpleEvent onSimpleEvent = (OnSimpleEvent) other;
        return Intrinsics.areEqual(this.zza, onSimpleEvent.zza) && Intrinsics.areEqual(this.zzb, onSimpleEvent.zzb) && Intrinsics.areEqual(this.zzc, onSimpleEvent.zzc);
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + (this.zza.hashCode() * 31);
        return this.zzc.hashCode() + (iHashCode * 31);
    }

    public final String toString() {
        String strZza = ReceiveHandle.zza(this.zza);
        int length = strZza.length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        List list = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 32, length2, 9, String.valueOf(list).length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "OnSimpleEvent(handle=", strZza, ", objectId=", str);
        sb.append(", events=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final List getZzc() {
        return this.zzc;
    }
}

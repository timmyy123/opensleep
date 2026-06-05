package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zztv, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\rJ8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0012\u0010\r¨\u0006#"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/EventPayload;", "", "timeStamp", "", "encodedTrait", "Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "eventImportance", "Lcom/google/nest/platform/mesh/interaction/EventImportance;", "eventNumber", "Lkotlin/ULong;", "<init>", "(JLcom/google/nest/platform/mesh/serialization/TraitElementPayload;Lcom/google/nest/platform/mesh/interaction/EventImportance;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTimeStamp", "()J", "getEncodedTrait", "()Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "getEventImportance", "()Lcom/google/nest/platform/mesh/interaction/EventImportance;", "getEventNumber-s-VKNKU", "J", "component1", "component2", "component3", "component4", "component4-s-VKNKU", "copy", "copy-ARK9YDc", "(JLcom/google/nest/platform/mesh/serialization/TraitElementPayload;Lcom/google/nest/platform/mesh/interaction/EventImportance;J)Lcom/google/nest/platform/mesh/interaction/EventPayload;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class EventPayload {
    private final long zza;
    private final TraitElementPayload zzb;
    private final EventImportance zzc;
    private final long zzd;

    public /* synthetic */ EventPayload(long j, TraitElementPayload traitElementPayload, EventImportance eventImportance, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        traitElementPayload.getClass();
        eventImportance.getClass();
        this.zza = j;
        this.zzb = traitElementPayload;
        this.zzc = eventImportance;
        this.zzd = j2;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventPayload)) {
            return false;
        }
        EventPayload eventPayload = (EventPayload) other;
        return this.zza == eventPayload.zza && Intrinsics.areEqual(this.zzb, eventPayload.zzb) && this.zzc == eventPayload.zzc && this.zzd == eventPayload.zzd;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + (Long.hashCode(this.zza) * 31);
        int iHashCode2 = this.zzc.hashCode() + (iHashCode * 31);
        return ULong.m2413hashCodeimpl(this.zzd) + (iHashCode2 * 31);
    }

    public final String toString() {
        String strM2414toStringimpl = ULong.m2414toStringimpl(this.zzd);
        long j = this.zza;
        int length = String.valueOf(j).length();
        TraitElementPayload traitElementPayload = this.zzb;
        int length2 = traitElementPayload.toString().length();
        EventImportance eventImportance = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 38, length2, 18, String.valueOf(eventImportance).length(), 14, String.valueOf(strM2414toStringimpl).length()) + 1);
        zzba$$ExternalSyntheticOutline0.m(sb, "EventPayload(timeStamp=", j, ", encodedTrait=");
        sb.append(traitElementPayload);
        sb.append(", eventImportance=");
        sb.append(eventImportance);
        sb.append(", eventNumber=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, strM2414toStringimpl, ")");
    }
}

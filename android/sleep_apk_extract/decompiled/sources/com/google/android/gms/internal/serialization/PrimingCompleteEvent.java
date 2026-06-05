package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzuj, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/PrimingCompleteEvent;", "Lcom/google/nest/platform/mesh/interaction/SubscribeTraitsEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class PrimingCompleteEvent implements SubscribeTraitsEvent {
    public static final PrimingCompleteEvent zza = new PrimingCompleteEvent();

    private PrimingCompleteEvent() {
    }

    public final boolean equals(Object other) {
        return this == other || (other instanceof PrimingCompleteEvent);
    }

    public final int hashCode() {
        return -533913707;
    }

    public final String toString() {
        return "PrimingCompleteEvent";
    }
}

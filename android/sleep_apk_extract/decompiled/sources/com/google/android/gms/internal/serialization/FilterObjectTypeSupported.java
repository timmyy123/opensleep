package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zztz, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/FilterObjectTypeSupported;", "Lcom/google/nest/platform/mesh/interaction/FilterMatcher;", "objectTypeId", "", "<init>", "(Ljava/lang/String;)V", "getObjectTypeId", "()Ljava/lang/String;", "type", "Lcom/google/nest/platform/mesh/interaction/FilterMatcherType;", "getType", "()Lcom/google/nest/platform/mesh/interaction/FilterMatcherType;", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilterObjectTypeSupported implements FilterMatcher {
    private final String zza = "home.internal.types.Component";

    public FilterObjectTypeSupported(String str) {
    }

    public final String toString() {
        String str = this.zza;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + 45), "FilterMatcherType.FilterObjectTypeSupported(", str, ")");
    }

    @Override // com.google.android.gms.internal.serialization.FilterMatcher
    public final FilterMatcherType zza() {
        return FilterMatcherType.zzd;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getZza() {
        return this.zza;
    }
}

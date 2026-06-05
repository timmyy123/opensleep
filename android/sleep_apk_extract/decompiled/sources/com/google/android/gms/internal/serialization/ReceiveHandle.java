package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzuk, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000e"}, d2 = {"Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "", "id", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getId", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.interaction_interaction_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReceiveHandle {
    private final String zza;

    private /* synthetic */ ReceiveHandle(String str) {
        this.zza = str;
    }

    public static String zza(String str) {
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 18), "ReceiveHandle(id=", str, ")");
    }

    public static final /* synthetic */ ReceiveHandle zzb(String str) {
        return new ReceiveHandle(str);
    }

    public final boolean equals(Object other) {
        return (other instanceof ReceiveHandle) && Intrinsics.areEqual(this.zza, ((ReceiveHandle) other).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zza(this.zza);
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final /* synthetic */ String getZza() {
        return this.zza;
    }
}

package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzvn, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B/\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J>\u0010\u001c\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001f\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b \u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0018¨\u0006$"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "", "", "Lcom/google/nest/platform/mesh/serialization/TraitId;", "id", "typeUrl", "data", "Lkotlin/ULong;", "globalVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/ULong;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1", "component2", "component3", "component4-6VbMDqA", "()Lkotlin/ULong;", "component4", "copy-nRXsjtY", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/ULong;)Lcom/google/nest/platform/mesh/serialization/TraitElementPayload;", "copy", "Ljava/lang/String;", "getId", "getTypeUrl", "getData", "Lkotlin/ULong;", "getGlobalVersion-6VbMDqA", "Companion", "java.com.google.nest.platform.mesh.serialization_serialization_objects-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class TraitElementPayload {
    public static final zzvm zza = new zzvm(null);
    private final String zzb;
    private final String zzc;
    private final String zzd;

    /* JADX INFO: renamed from: zze, reason: from toString */
    private final ULong globalVersion;

    public /* synthetic */ TraitElementPayload(String str, String str2, String str3, ULong uLong, DefaultConstructorMarker defaultConstructorMarker) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.globalVersion = uLong;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraitElementPayload)) {
            return false;
        }
        TraitElementPayload traitElementPayload = (TraitElementPayload) other;
        return Intrinsics.areEqual(this.zzb, traitElementPayload.zzb) && Intrinsics.areEqual(this.zzc, traitElementPayload.zzc) && Intrinsics.areEqual(this.zzd, traitElementPayload.zzd) && Intrinsics.areEqual(this.globalVersion, traitElementPayload.globalVersion);
    }

    public final int hashCode() {
        int iHashCode = this.zzd.hashCode() + ((this.zzc.hashCode() + (this.zzb.hashCode() * 31)) * 31);
        ULong uLong = this.globalVersion;
        return (iHashCode * 31) + (uLong == null ? 0 : ULong.m2413hashCodeimpl(uLong.getData()));
    }

    public final String toString() {
        String str = this.zzb;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzd;
        int length3 = String.valueOf(str3).length();
        ULong uLong = this.globalVersion;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 33, length2, 7, length3, 16, String.valueOf(uLong).length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "TraitElementPayload(id=", str, ", typeUrl=", str2);
        sb.append(", data=");
        sb.append(str3);
        sb.append(", globalVersion=");
        sb.append(uLong);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzd() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: zzd, reason: from getter */
    public final ULong getGlobalVersion() {
        return this.globalVersion;
    }
}

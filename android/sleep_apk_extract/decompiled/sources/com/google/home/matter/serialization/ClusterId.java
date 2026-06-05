package com.google.home.matter.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\nR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\n¨\u0006$"}, d2 = {"Lcom/google/home/matter/serialization/ClusterId;", "", "Lkotlin/UInt;", SDKConstants.PARAM_VALUE, "", "traitName", "vendorName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getValue-pVg5ArA", "Ljava/lang/String;", "getTraitName", "getVendorName", "Lkotlin/UShort;", "id", "S", "getId-Mh2AYeg", "()S", ShareConstants.FEED_SOURCE_PARAM, "getSource-Mh2AYeg", "traitId", "getTraitId", "_vendorName", "traitFriendlyName", "getTraitFriendlyName", "Companion", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ClusterId {
    private final String _vendorName;
    private final short id;
    private final short source;
    private final String traitFriendlyName;
    private final String traitId;
    private final String traitName;
    private final int value;
    private final String vendorName;

    private ClusterId(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.value = i;
        this.traitName = str;
        this.vendorName = str2;
        short sM2433constructorimpl = UShort.m2433constructorimpl((short) UInt.m2389constructorimpl((char) i));
        this.id = sM2433constructorimpl;
        short sM2433constructorimpl2 = UShort.m2433constructorimpl((short) UInt.m2389constructorimpl((char) UInt.m2389constructorimpl(i >>> 16)));
        this.source = sM2433constructorimpl2;
        String strM533hex4xj2QHRw = ClusterIdKt.m533hex4xj2QHRw(sM2433constructorimpl2);
        String strM533hex4xj2QHRw2 = ClusterIdKt.m533hex4xj2QHRw(sM2433constructorimpl);
        this.traitId = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strM533hex4xj2QHRw).length() + 22 + String.valueOf(strM533hex4xj2QHRw2).length()), "home.matter.", strM533hex4xj2QHRw, ".clusters.", strM533hex4xj2QHRw2);
        str2 = StringsKt.isBlank(str2) ? sM2433constructorimpl2 == UShort.m2433constructorimpl((short) 0) ? "standard" : sM2433constructorimpl2 == UShort.m2433constructorimpl((short) 24582) ? "google" : ClusterIdKt.m533hex4xj2QHRw(sM2433constructorimpl2) : str2;
        this._vendorName = str2;
        str = StringsKt.isBlank(str) ? ClusterIdKt.m533hex4xj2QHRw(sM2433constructorimpl) : str;
        this.traitFriendlyName = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str2).length() + 8 + String.valueOf(str).length()), "matter.", str2, ".", str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClusterId)) {
            return false;
        }
        ClusterId clusterId = (ClusterId) other;
        return this.value == clusterId.value && Intrinsics.areEqual(this.traitName, clusterId.traitName) && Intrinsics.areEqual(this.vendorName, clusterId.vendorName);
    }

    /* JADX INFO: renamed from: getId-Mh2AYeg, reason: not valid java name and from getter */
    public final short getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: getSource-Mh2AYeg, reason: not valid java name and from getter */
    public final short getSource() {
        return this.source;
    }

    public final String getTraitId() {
        return this.traitId;
    }

    public int hashCode() {
        int iHashCode = this.traitName.hashCode() + (UInt.m2391hashCodeimpl(this.value) * 31);
        return this.vendorName.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        return this.traitId;
    }

    public /* synthetic */ ClusterId(int i, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2);
    }

    public /* synthetic */ ClusterId(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, null);
    }
}

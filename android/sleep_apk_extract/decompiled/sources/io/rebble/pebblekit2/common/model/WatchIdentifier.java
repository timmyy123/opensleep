package io.rebble.pebblekit2.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.BoxingConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lio/rebble/pebblekit2/common/model/WatchIdentifier;", "", "", SDKConstants.PARAM_VALUE, "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "hashCode-impl", "(Ljava/lang/String;)I", "hashCode", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WatchIdentifier {
    private final String value;

    private /* synthetic */ WatchIdentifier(String str, BoxingConstructorMarker boxingConstructorMarker) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WatchIdentifier m2349boximpl(String str) {
        return new WatchIdentifier(str, null);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m2350constructorimpl(String str) {
        str.getClass();
        return str;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2351equalsimpl(String str, Object obj) {
        return (obj instanceof WatchIdentifier) && Intrinsics.areEqual(str, ((WatchIdentifier) obj).getValue());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2352equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2353hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2354toStringimpl(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m("WatchIdentifier(value=", str, ")");
    }

    public boolean equals(Object obj) {
        return m2351equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2353hashCodeimpl(this.value);
    }

    public String toString() {
        return m2354toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ String getValue() {
        return this.value;
    }
}

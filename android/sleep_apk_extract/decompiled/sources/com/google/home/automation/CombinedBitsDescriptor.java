package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/google/home/automation/CombinedBitsDescriptor;", "", "Lkotlin/UInt;", "startBit", "endBit", "", "name", "<init>", "(IILjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getStartBit-pVg5ArA", "getEndBit-pVg5ArA", "Ljava/lang/String;", "getName", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CombinedBitsDescriptor {
    private final int endBit;
    private final String name;
    private final int startBit;

    private CombinedBitsDescriptor(int i, int i2, String str) {
        str.getClass();
        this.startBit = i;
        this.endBit = i2;
        this.name = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CombinedBitsDescriptor)) {
            return false;
        }
        CombinedBitsDescriptor combinedBitsDescriptor = (CombinedBitsDescriptor) other;
        return this.startBit == combinedBitsDescriptor.startBit && this.endBit == combinedBitsDescriptor.endBit && Intrinsics.areEqual(this.name, combinedBitsDescriptor.name);
    }

    public int hashCode() {
        int iM2391hashCodeimpl = UInt.m2391hashCodeimpl(this.endBit) + (UInt.m2391hashCodeimpl(this.startBit) * 31);
        return this.name.hashCode() + (iM2391hashCodeimpl * 31);
    }

    public String toString() {
        int i = this.endBit;
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.startBit);
        String strM2392toStringimpl2 = UInt.m2392toStringimpl(i);
        int length = String.valueOf(strM2392toStringimpl).length();
        int length2 = String.valueOf(strM2392toStringimpl2).length();
        String str = this.name;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 41, length2, 7, String.valueOf(str).length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "CombinedBitsDescriptor(startBit=", strM2392toStringimpl, ", endBit=", strM2392toStringimpl2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", name=", str, ")");
    }

    public /* synthetic */ CombinedBitsDescriptor(int i, int i2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str);
    }
}

package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/automation/ByteConstraint;", "Lcom/google/home/automation/Constraint;", "Lkotlin/UInt;", "minLength", "maxLength", "<init>", "(Lkotlin/UInt;Lkotlin/UInt;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UInt;", "getMinLength-0hXNFcg", "()Lkotlin/UInt;", "getMaxLength-0hXNFcg", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteConstraint implements Constraint {
    private final UInt maxLength;
    private final UInt minLength;

    private ByteConstraint(UInt uInt, UInt uInt2) {
        this.minLength = uInt;
        this.maxLength = uInt2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ByteConstraint)) {
            return false;
        }
        ByteConstraint byteConstraint = (ByteConstraint) other;
        return Intrinsics.areEqual(this.minLength, byteConstraint.minLength) && Intrinsics.areEqual(this.maxLength, byteConstraint.maxLength);
    }

    public int hashCode() {
        UInt uInt = this.minLength;
        int iHashCode = uInt != null ? uInt.hashCode() : 0;
        UInt uInt2 = this.maxLength;
        return (iHashCode * 31) + (uInt2 != null ? uInt2.hashCode() : 0);
    }

    public String toString() {
        return zza.zza(this.maxLength, this.minLength, (byte) 1, (byte) 37, "ByteConstraint(minLength=", ", maxLength=", ")");
    }

    public /* synthetic */ ByteConstraint(UInt uInt, UInt uInt2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uInt, uInt2);
    }
}

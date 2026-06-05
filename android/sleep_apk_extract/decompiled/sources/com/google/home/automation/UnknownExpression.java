package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.serialization.zzvo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\t\b\u0010¢\u0006\u0004\b\u0006\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/google/home/automation/UnknownExpression;", "Lcom/google/home/automation/ExpressionWithId;", "byteArray", "", "expressionId", "", "<init>", "([BLjava/lang/String;)V", "([B)V", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnknownExpression extends ExpressionWithId {
    private final byte[] byteArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownExpression(byte[] bArr, String str) {
        super(str, null);
        bArr.getClass();
        str.getClass();
        this.byteArray = bArr;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UnknownExpression) && super.equals(other)) {
            return Arrays.equals(this.byteArray, ((UnknownExpression) other).byteArray);
        }
        return false;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        return Arrays.hashCode(this.byteArray) + (super.hashCode() * 31);
    }

    public String toString() {
        String strZzb = zzvo.zzb(this.byteArray);
        String expressionId = getExpressionId();
        StringBuilder sb = new StringBuilder(String.valueOf(expressionId).length() + 43 + String.valueOf(strZzb).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "UnknownExpression(expressionId=", expressionId, ", byteArray=", strZzb);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownExpression(byte[] bArr) {
        super((DefaultConstructorMarker) null);
        bArr.getClass();
        this.byteArray = bArr;
    }

    public UnknownExpression() {
        super((DefaultConstructorMarker) null);
        this.byteArray = new byte[0];
    }
}

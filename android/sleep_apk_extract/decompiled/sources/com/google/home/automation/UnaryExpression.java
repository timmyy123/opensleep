package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0019\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0001\u0015¨\u0006\u0016"}, d2 = {"Lcom/google/home/automation/UnaryExpression;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "operand", "", "expressionId", "<init>", "(Lcom/google/home/automation/Expression;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getOperand", "()Lcom/google/home/automation/Expression;", "Lcom/google/home/automation/Not;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class UnaryExpression extends ExpressionWithId {
    private final Expression operand;

    private UnaryExpression(Expression expression, String str) {
        super(str, null);
        this.operand = expression;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UnaryExpression) && Reflection.getOrCreateKotlinClass(getClass()).isInstance(other) && super.equals(other)) {
            return Intrinsics.areEqual(this.operand, ((UnaryExpression) other).operand);
        }
        return false;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        return this.operand.hashCode() + (super.hashCode() * 31);
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        String expressionId = getExpressionId();
        int length = String.valueOf(simpleName).length();
        Expression expression = this.operand;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 9, String.valueOf(expression).length(), 15, String.valueOf(expressionId).length()) + 1);
        sb.append(simpleName);
        sb.append("(operand=");
        sb.append(expression);
        sb.append(", expressionId=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, expressionId, ")");
    }

    public /* synthetic */ UnaryExpression(Expression expression, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, str);
    }
}

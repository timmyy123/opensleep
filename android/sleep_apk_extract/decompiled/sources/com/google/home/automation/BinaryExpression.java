package com.google.home.automation;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B!\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015\u0082\u0001\f\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Lcom/google/home/automation/BinaryExpression;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "operand1", "operand2", "", "expressionId", "<init>", "(Lcom/google/home/automation/Expression;Lcom/google/home/automation/Expression;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getOperand1", "()Lcom/google/home/automation/Expression;", "getOperand2", "Lcom/google/home/automation/And;", "Lcom/google/home/automation/Divide;", "Lcom/google/home/automation/Equals;", "Lcom/google/home/automation/GreaterThan;", "Lcom/google/home/automation/GreaterThanOrEquals;", "Lcom/google/home/automation/LessThan;", "Lcom/google/home/automation/LessThanOrEquals;", "Lcom/google/home/automation/Minus;", "Lcom/google/home/automation/Multiply;", "Lcom/google/home/automation/NotEquals;", "Lcom/google/home/automation/Or;", "Lcom/google/home/automation/Plus;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BinaryExpression extends ExpressionWithId {
    private final Expression operand1;
    private final Expression operand2;

    private BinaryExpression(Expression expression, Expression expression2, String str) {
        super(str, null);
        this.operand1 = expression;
        this.operand2 = expression2;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BinaryExpression) || !Reflection.getOrCreateKotlinClass(getClass()).isInstance(other) || !super.equals(other)) {
            return false;
        }
        BinaryExpression binaryExpression = (BinaryExpression) other;
        return Intrinsics.areEqual(this.operand1, binaryExpression.operand1) && Intrinsics.areEqual(this.operand2, binaryExpression.operand2);
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        int iHashCode = this.operand1.hashCode() + (super.hashCode() * 31);
        return this.operand2.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        String expressionId = getExpressionId();
        int length = String.valueOf(simpleName).length();
        Expression expression = this.operand1;
        int length2 = String.valueOf(expression).length();
        Expression expression2 = this.operand2;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 10, length2, 11, String.valueOf(expression2).length(), 15, String.valueOf(expressionId).length()) + 1);
        sb.append(simpleName);
        sb.append("(operand1=");
        sb.append(expression);
        sb.append(", operand2=");
        sb.append(expression2);
        sb.append(", expressionId=");
        sb.append(expressionId);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ BinaryExpression(Expression expression, Expression expression2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, expression2, str);
    }
}

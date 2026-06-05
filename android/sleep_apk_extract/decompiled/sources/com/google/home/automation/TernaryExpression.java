package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B)\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/google/home/automation/TernaryExpression;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "operand1", "operand2", "operand3", "", "expressionId", "<init>", "(Lcom/google/home/automation/Expression;Lcom/google/home/automation/Expression;Lcom/google/home/automation/Expression;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getOperand1", "()Lcom/google/home/automation/Expression;", "getOperand2", "getOperand3", "Lcom/google/home/automation/Between;", "Lcom/google/home/automation/BetweenTimes;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TernaryExpression extends ExpressionWithId {
    private final Expression operand1;
    private final Expression operand2;
    private final Expression operand3;

    private TernaryExpression(Expression expression, Expression expression2, Expression expression3, String str) {
        super(str, null);
        this.operand1 = expression;
        this.operand2 = expression2;
        this.operand3 = expression3;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TernaryExpression) || !Reflection.getOrCreateKotlinClass(getClass()).isInstance(other) || !super.equals(other)) {
            return false;
        }
        TernaryExpression ternaryExpression = (TernaryExpression) other;
        return Intrinsics.areEqual(this.operand1, ternaryExpression.operand1) && Intrinsics.areEqual(this.operand2, ternaryExpression.operand2) && Intrinsics.areEqual(this.operand3, ternaryExpression.operand3);
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        int iHashCode = this.operand1.hashCode() + (super.hashCode() * 31);
        int iHashCode2 = this.operand2.hashCode();
        return this.operand3.hashCode() + ((iHashCode2 + (iHashCode * 31)) * 31);
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        String expressionId = getExpressionId();
        int length = String.valueOf(simpleName).length();
        Expression expression = this.operand1;
        int length2 = String.valueOf(expression).length();
        Expression expression2 = this.operand2;
        int length3 = String.valueOf(expression2).length();
        Expression expression3 = this.operand3;
        StringBuilder sb = new StringBuilder(length + 10 + length2 + 11 + length3 + 11 + String.valueOf(expression3).length() + 15 + String.valueOf(expressionId).length() + 1);
        sb.append(simpleName);
        sb.append("(operand1=");
        sb.append(expression);
        sb.append(", operand2=");
        sb.append(expression2);
        sb.append(", operand3=");
        sb.append(expression3);
        sb.append(", expressionId=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, expressionId, ")");
    }

    public /* synthetic */ TernaryExpression(Expression expression, Expression expression2, Expression expression3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, expression2, expression3, str);
    }
}

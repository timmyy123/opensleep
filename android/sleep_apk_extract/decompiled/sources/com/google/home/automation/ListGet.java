package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/google/home/automation/ListGet;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "listExpression", "index", "", "expressionId", "<init>", "(Lcom/google/home/automation/Expression;Lcom/google/home/automation/Expression;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getListExpression", "()Lcom/google/home/automation/Expression;", "getIndex", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListGet extends ExpressionWithId {
    private final Expression index;
    private final Expression listExpression;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListGet(Expression expression, Expression expression2, String str) {
        super(str, null);
        expression.getClass();
        expression2.getClass();
        str.getClass();
        this.listExpression = expression;
        this.index = expression2;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListGet) || !super.equals(other)) {
            return false;
        }
        ListGet listGet = (ListGet) other;
        return Intrinsics.areEqual(this.index, listGet.index) && Intrinsics.areEqual(this.listExpression, listGet.listExpression);
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        int iHashCode = this.listExpression.hashCode() + (super.hashCode() * 31);
        return this.index.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        String expressionId = getExpressionId();
        Expression expression = this.listExpression;
        int length = String.valueOf(expression).length();
        Expression expression2 = this.index;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 31, String.valueOf(expression2).length(), 15, String.valueOf(expressionId).length()) + 1);
        sb.append("ListGet(listExpression=");
        sb.append(expression);
        sb.append(", index=");
        sb.append(expression2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", expressionId=", expressionId, ")");
    }
}

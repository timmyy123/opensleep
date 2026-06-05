package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B1\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/google/home/automation/MapFilter;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "mapExpression", "Lcom/google/home/automation/ReferenceDeclaration;", "lambdaVarK", "lambdaVarV", "lambdaBody", "", "expressionId", "<init>", "(Lcom/google/home/automation/Expression;Lcom/google/home/automation/ReferenceDeclaration;Lcom/google/home/automation/ReferenceDeclaration;Lcom/google/home/automation/Expression;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getMapExpression", "()Lcom/google/home/automation/Expression;", "Lcom/google/home/automation/ReferenceDeclaration;", "getLambdaVarK", "()Lcom/google/home/automation/ReferenceDeclaration;", "getLambdaVarV", "getLambdaBody", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MapFilter extends ExpressionWithId {
    private final Expression lambdaBody;
    private final ReferenceDeclaration lambdaVarK;
    private final ReferenceDeclaration lambdaVarV;
    private final Expression mapExpression;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapFilter(Expression expression, ReferenceDeclaration referenceDeclaration, ReferenceDeclaration referenceDeclaration2, Expression expression2, String str) {
        super(str, null);
        expression.getClass();
        referenceDeclaration.getClass();
        referenceDeclaration2.getClass();
        expression2.getClass();
        str.getClass();
        this.mapExpression = expression;
        this.lambdaVarK = referenceDeclaration;
        this.lambdaVarV = referenceDeclaration2;
        this.lambdaBody = expression2;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapFilter) || !super.equals(other)) {
            return false;
        }
        MapFilter mapFilter = (MapFilter) other;
        return Intrinsics.areEqual(this.mapExpression, mapFilter.mapExpression) && Intrinsics.areEqual(this.lambdaVarK, mapFilter.lambdaVarK) && Intrinsics.areEqual(this.lambdaVarV, mapFilter.lambdaVarV) && Intrinsics.areEqual(this.lambdaBody, mapFilter.lambdaBody);
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        int iHashCode = this.mapExpression.hashCode() + (super.hashCode() * 31);
        int iHashCode2 = this.lambdaVarK.hashCode() + (iHashCode * 31);
        int iHashCode3 = this.lambdaVarV.hashCode();
        return this.lambdaBody.hashCode() + ((iHashCode3 + (iHashCode2 * 31)) * 31);
    }

    public String toString() {
        String expressionId = getExpressionId();
        Expression expression = this.mapExpression;
        int length = String.valueOf(expression).length();
        ReferenceDeclaration referenceDeclaration = this.lambdaVarK;
        int length2 = String.valueOf(referenceDeclaration).length();
        ReferenceDeclaration referenceDeclaration2 = this.lambdaVarV;
        int length3 = String.valueOf(referenceDeclaration2).length();
        Expression expression2 = this.lambdaBody;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 8 + length3 + 13 + String.valueOf(expression2).length() + 15 + String.valueOf(expressionId).length() + 1);
        sb.append("MapFilter(mapExpression=");
        sb.append(expression);
        sb.append(", key=");
        sb.append(referenceDeclaration);
        sb.append(", value=");
        sb.append(referenceDeclaration2);
        sb.append(", lambdaBody=");
        sb.append(expression2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", expressionId=", expressionId, ")");
    }
}

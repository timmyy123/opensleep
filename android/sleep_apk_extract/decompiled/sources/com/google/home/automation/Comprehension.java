package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B)\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\u0082\u0001\u0005\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/google/home/automation/Comprehension;", "Lcom/google/home/automation/ExpressionWithId;", "Lcom/google/home/automation/Expression;", "rangeExpression", "Lcom/google/home/automation/ReferenceDeclaration;", "lambdaVar", "lambdaBody", "", "expressionId", "<init>", "(Lcom/google/home/automation/Expression;Lcom/google/home/automation/ReferenceDeclaration;Lcom/google/home/automation/Expression;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Expression;", "getRangeExpression", "()Lcom/google/home/automation/Expression;", "Lcom/google/home/automation/ReferenceDeclaration;", "getLambdaVar", "()Lcom/google/home/automation/ReferenceDeclaration;", "getLambdaBody", "Lcom/google/home/automation/ListAllMatch;", "Lcom/google/home/automation/ListAnyMatch;", "Lcom/google/home/automation/ListFilter;", "Lcom/google/home/automation/ListMap;", "Lcom/google/home/automation/ListNoneMatch;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Comprehension extends ExpressionWithId {
    private final Expression lambdaBody;
    private final ReferenceDeclaration lambdaVar;
    private final Expression rangeExpression;

    private Comprehension(Expression expression, ReferenceDeclaration referenceDeclaration, Expression expression2, String str) {
        super(str, null);
        this.rangeExpression = expression;
        this.lambdaVar = referenceDeclaration;
        this.lambdaBody = expression2;
    }

    @Override // com.google.home.automation.ExpressionWithId
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Comprehension) || !Reflection.getOrCreateKotlinClass(getClass()).isInstance(other) || !super.equals(other)) {
            return false;
        }
        Comprehension comprehension = (Comprehension) other;
        return Intrinsics.areEqual(this.rangeExpression, comprehension.rangeExpression) && Intrinsics.areEqual(this.lambdaVar, comprehension.lambdaVar) && Intrinsics.areEqual(this.lambdaBody, comprehension.lambdaBody);
    }

    @Override // com.google.home.automation.ExpressionWithId
    public int hashCode() {
        int iHashCode = this.rangeExpression.hashCode() + (super.hashCode() * 31);
        int iHashCode2 = this.lambdaVar.hashCode();
        return this.lambdaBody.hashCode() + ((iHashCode2 + (iHashCode * 31)) * 31);
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        String expressionId = getExpressionId();
        int length = String.valueOf(simpleName).length();
        Expression expression = this.rangeExpression;
        int length2 = String.valueOf(expression).length();
        ReferenceDeclaration referenceDeclaration = this.lambdaVar;
        int length3 = String.valueOf(referenceDeclaration).length();
        Expression expression2 = this.lambdaBody;
        StringBuilder sb = new StringBuilder(length + 17 + length2 + 12 + length3 + 13 + String.valueOf(expression2).length() + 15 + String.valueOf(expressionId).length() + 1);
        sb.append(simpleName);
        sb.append("(rangeExpression=");
        sb.append(expression);
        sb.append(", lambdaVar=");
        sb.append(referenceDeclaration);
        sb.append(", lambdaBody=");
        sb.append(expression2);
        sb.append(", expressionId=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, expressionId, ")");
    }

    public /* synthetic */ Comprehension(Expression expression, ReferenceDeclaration referenceDeclaration, Expression expression2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, referenceDeclaration, expression2, str);
    }
}

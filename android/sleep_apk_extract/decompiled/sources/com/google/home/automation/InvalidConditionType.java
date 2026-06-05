package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/google/home/automation/InvalidConditionType;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/Expression;", "expression", "", "expected", "actual", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;Ljava/lang/String;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/home/automation/Expression;", "getExpression", "()Lcom/google/home/automation/Expression;", "Ljava/lang/String;", "getExpected", "()Ljava/lang/String;", "getActual", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvalidConditionType extends ValidationIssue {
    private final String actual;
    private final String expected;
    private final Expression expression;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidConditionType(Node node, ValidationIssueSeverity validationIssueSeverity, Expression expression, String str, String str2) {
        super(node, validationIssueSeverity, ValidationIssueType.InvalidConditionType, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        str2.getClass();
        this.expression = expression;
        this.expected = str;
        this.actual = str2;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvalidConditionType)) {
            return false;
        }
        InvalidConditionType invalidConditionType = (InvalidConditionType) other;
        return Intrinsics.areEqual(this.expression, invalidConditionType.expression) && Intrinsics.areEqual(this.expected, invalidConditionType.expected) && Intrinsics.areEqual(this.actual, invalidConditionType.actual) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Expression expression = this.expression;
        return this.actual.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((iHashCode + (expression != null ? expression.hashCode() : 0)) * 31, 31, this.expected);
    }
}

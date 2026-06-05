package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/google/home/automation/InvalidArgumentCount;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/Expression;", "expression", "", "operator", "", "minOperands", "maxOperands", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;Ljava/lang/String;II)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcom/google/home/automation/Expression;", "getExpression", "()Lcom/google/home/automation/Expression;", "Ljava/lang/String;", "getOperator", "()Ljava/lang/String;", "I", "getMinOperands", "getMaxOperands", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvalidArgumentCount extends ValidationIssue {
    private final Expression expression;
    private final int maxOperands;
    private final int minOperands;
    private final String operator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidArgumentCount(Node node, ValidationIssueSeverity validationIssueSeverity, Expression expression, String str, int i, int i2) {
        super(node, validationIssueSeverity, ValidationIssueType.InvalidArgumentCount, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        this.expression = expression;
        this.operator = str;
        this.minOperands = i;
        this.maxOperands = i2;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvalidArgumentCount)) {
            return false;
        }
        InvalidArgumentCount invalidArgumentCount = (InvalidArgumentCount) other;
        return Intrinsics.areEqual(this.expression, invalidArgumentCount.expression) && Intrinsics.areEqual(this.operator, invalidArgumentCount.operator) && this.minOperands == invalidArgumentCount.minOperands && this.maxOperands == invalidArgumentCount.maxOperands && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Expression expression = this.expression;
        return Integer.hashCode(this.maxOperands) + FileInsert$$ExternalSyntheticOutline0.m(this.minOperands, FileInsert$$ExternalSyntheticOutline0.m((iHashCode + (expression != null ? expression.hashCode() : 0)) * 31, 31, this.operator), 31);
    }
}

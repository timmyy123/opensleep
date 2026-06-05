package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/google/home/automation/InvalidOperand;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/Expression;", "expression", "", "operator", "", "operandIndex", "operandType", "", "validOperandTypes", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcom/google/home/automation/Expression;", "getExpression", "()Lcom/google/home/automation/Expression;", "Ljava/lang/String;", "getOperator", "()Ljava/lang/String;", "I", "getOperandIndex", "getOperandType", "Ljava/util/List;", "getValidOperandTypes", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvalidOperand extends ValidationIssue {
    private final Expression expression;
    private final int operandIndex;
    private final String operandType;
    private final String operator;
    private final List<String> validOperandTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidOperand(Node node, ValidationIssueSeverity validationIssueSeverity, Expression expression, String str, int i, String str2, List<String> list) {
        super(node, validationIssueSeverity, ValidationIssueType.InvalidOperand, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        str2.getClass();
        list.getClass();
        this.expression = expression;
        this.operator = str;
        this.operandIndex = i;
        this.operandType = str2;
        this.validOperandTypes = list;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvalidOperand)) {
            return false;
        }
        InvalidOperand invalidOperand = (InvalidOperand) other;
        return Intrinsics.areEqual(this.expression, invalidOperand.expression) && Intrinsics.areEqual(this.operator, invalidOperand.operator) && this.operandIndex == invalidOperand.operandIndex && Intrinsics.areEqual(this.operandType, invalidOperand.operandType) && Intrinsics.areEqual(this.validOperandTypes, invalidOperand.validOperandTypes) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Expression expression = this.expression;
        return this.validOperandTypes.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.operandIndex, FileInsert$$ExternalSyntheticOutline0.m((iHashCode + (expression != null ? expression.hashCode() : 0)) * 31, 31, this.operator), 31), 31, this.operandType);
    }
}

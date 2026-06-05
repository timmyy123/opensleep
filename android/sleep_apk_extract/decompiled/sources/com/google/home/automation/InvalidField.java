package com.google.home.automation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0015¨\u0006!"}, d2 = {"Lcom/google/home/automation/InvalidField;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/Expression;", "expression", "", "id", "", "name", "operandIndex", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/Expression;Ljava/lang/Integer;Ljava/lang/String;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcom/google/home/automation/Expression;", "getExpression", "()Lcom/google/home/automation/Expression;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "I", "getOperandIndex", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvalidField extends ValidationIssue {
    private final Expression expression;
    private final Integer id;
    private final String name;
    private final int operandIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidField(Node node, ValidationIssueSeverity validationIssueSeverity, Expression expression, Integer num, String str, int i) {
        super(node, validationIssueSeverity, ValidationIssueType.InvalidField, null);
        node.getClass();
        validationIssueSeverity.getClass();
        this.expression = expression;
        this.id = num;
        this.name = str;
        this.operandIndex = i;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvalidField)) {
            return false;
        }
        InvalidField invalidField = (InvalidField) other;
        return Intrinsics.areEqual(this.expression, invalidField.expression) && Intrinsics.areEqual(this.id, invalidField.id) && Intrinsics.areEqual(this.name, invalidField.name) && this.operandIndex == invalidField.operandIndex && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Expression expression = this.expression;
        int iHashCode2 = (iHashCode + (expression != null ? expression.hashCode() : 0)) * 31;
        Integer num = this.id;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return Integer.hashCode(this.operandIndex) + ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public /* synthetic */ InvalidField(Node node, ValidationIssueSeverity validationIssueSeverity, Expression expression, Integer num, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(node, validationIssueSeverity, expression, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : str, i);
    }
}

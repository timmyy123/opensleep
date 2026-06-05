package com.google.home.automation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/google/home/automation/InvalidNullParameterValue;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "id", "", "name", "expected", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getExpected", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvalidNullParameterValue extends ValidationIssue {
    private final String expected;
    private final Integer id;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidNullParameterValue(Node node, ValidationIssueSeverity validationIssueSeverity, Integer num, String str, String str2) {
        super(node, validationIssueSeverity, ValidationIssueType.InvalidNullParameterValue, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str2.getClass();
        this.id = num;
        this.name = str;
        this.expected = str2;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvalidNullParameterValue)) {
            return false;
        }
        InvalidNullParameterValue invalidNullParameterValue = (InvalidNullParameterValue) other;
        return Intrinsics.areEqual(this.id, invalidNullParameterValue.id) && Intrinsics.areEqual(this.name, invalidNullParameterValue.name) && Intrinsics.areEqual(this.expected, invalidNullParameterValue.expected) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.id;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return this.expected.hashCode() + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public /* synthetic */ InvalidNullParameterValue(Node node, ValidationIssueSeverity validationIssueSeverity, Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(node, validationIssueSeverity, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, str2);
    }
}

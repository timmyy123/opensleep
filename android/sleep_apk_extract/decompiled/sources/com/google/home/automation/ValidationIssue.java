package com.google.home.automation;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0082\u0001/\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJK¨\u0006L"}, d2 = {"Lcom/google/home/automation/ValidationIssue;", "", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/ValidationIssueType;", "issueType", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Lcom/google/home/automation/ValidationIssueType;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/Node;", "getNode", "()Lcom/google/home/automation/Node;", "Lcom/google/home/automation/ValidationIssueSeverity;", "getSeverity", "()Lcom/google/home/automation/ValidationIssueSeverity;", "Lcom/google/home/automation/ValidationIssueType;", "getIssueType", "()Lcom/google/home/automation/ValidationIssueType;", "Lcom/google/home/automation/AutomationTooLarge;", "Lcom/google/home/automation/BlockedAction;", "Lcom/google/home/automation/ConditionDurationOutOfRange;", "Lcom/google/home/automation/DelayDurationOutOfRange;", "Lcom/google/home/automation/DuplicateStarterNode;", "Lcom/google/home/automation/InvalidArgumentCount;", "Lcom/google/home/automation/InvalidArgumentsForOperator;", "Lcom/google/home/automation/InvalidCommand;", "Lcom/google/home/automation/InvalidConditionType;", "Lcom/google/home/automation/InvalidDuration;", "Lcom/google/home/automation/InvalidEntity;", "Lcom/google/home/automation/InvalidEvent;", "Lcom/google/home/automation/InvalidField;", "Lcom/google/home/automation/InvalidNullParameterValue;", "Lcom/google/home/automation/InvalidOperand;", "Lcom/google/home/automation/InvalidParameter;", "Lcom/google/home/automation/InvalidParameterType;", "Lcom/google/home/automation/InvalidReference;", "Lcom/google/home/automation/InvalidTrait;", "Lcom/google/home/automation/InvalidValue;", "Lcom/google/home/automation/MisplacedSelectFlow;", "Lcom/google/home/automation/MisplacedStarterNode;", "Lcom/google/home/automation/MissingRequiredFields;", "Lcom/google/home/automation/MissingRequiredParameters;", "Lcom/google/home/automation/MissingStarterNode;", "Lcom/google/home/automation/MultipleManualStarters;", "Lcom/google/home/automation/OutputNotAccessible;", "Lcom/google/home/automation/OutputReinitialized;", "Lcom/google/home/automation/OutputTypeMismatch;", "Lcom/google/home/automation/ReadOnlyAttribute;", "Lcom/google/home/automation/SuppressionDurationOutOfRange;", "Lcom/google/home/automation/TooManyNodes;", "Lcom/google/home/automation/TooManyOperations;", "Lcom/google/home/automation/UnknownIssue;", "Lcom/google/home/automation/UnsubscribableAttribute;", "Lcom/google/home/automation/UnsupportedActionBehavior;", "Lcom/google/home/automation/UnsupportedEntityCommand;", "Lcom/google/home/automation/UnsupportedEntityEvent;", "Lcom/google/home/automation/UnsupportedEntityParameter;", "Lcom/google/home/automation/UnsupportedEntityParameterValue;", "Lcom/google/home/automation/UnsupportedEntityTrait;", "Lcom/google/home/automation/UnsupportedEntityType;", "Lcom/google/home/automation/UnsupportedNodeOutput;", "Lcom/google/home/automation/UnsupportedOperator;", "Lcom/google/home/automation/UnsupportedStarterBehavior;", "Lcom/google/home/automation/UnsupportedStateReaderBehavior;", "Lcom/google/home/automation/UnsupportedSubNodeType;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ValidationIssue {
    private final ValidationIssueType issueType;
    private final Node node;
    private final ValidationIssueSeverity severity;

    private ValidationIssue(Node node, ValidationIssueSeverity validationIssueSeverity, ValidationIssueType validationIssueType) {
        this.node = node;
        this.severity = validationIssueSeverity;
        this.issueType = validationIssueType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationIssue)) {
            return false;
        }
        ValidationIssue validationIssue = (ValidationIssue) other;
        return Intrinsics.areEqual(this.node, validationIssue.node) && this.severity == validationIssue.severity && this.issueType == validationIssue.issueType;
    }

    public final ValidationIssueType getIssueType() {
        return this.issueType;
    }

    public int hashCode() {
        int iHashCode = this.severity.hashCode() + (this.node.hashCode() * 31);
        return this.issueType.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        Node node = this.node;
        int length = String.valueOf(node).length();
        ValidationIssueSeverity validationIssueSeverity = this.severity;
        int length2 = String.valueOf(validationIssueSeverity).length();
        ValidationIssueType validationIssueType = this.issueType;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 32, length2, 12, String.valueOf(validationIssueType).length()) + 1);
        sb.append("ValidationIssue(node=");
        sb.append(node);
        sb.append(", severity=");
        sb.append(validationIssueSeverity);
        sb.append(", issueType=");
        sb.append(validationIssueType);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ ValidationIssue(Node node, ValidationIssueSeverity validationIssueSeverity, ValidationIssueType validationIssueType, DefaultConstructorMarker defaultConstructorMarker) {
        this(node, validationIssueSeverity, validationIssueType);
    }
}

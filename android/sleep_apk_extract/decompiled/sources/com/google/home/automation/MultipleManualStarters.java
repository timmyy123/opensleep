package com.google.home.automation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¨\u0006\f"}, d2 = {"Lcom/google/home/automation/MultipleManualStarters;", "Lcom/google/home/automation/ValidationIssue;", "node", "Lcom/google/home/automation/Node;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/home/automation/ValidationIssueSeverity;", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;)V", "equals", "", "other", "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultipleManualStarters extends ValidationIssue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipleManualStarters(Node node, ValidationIssueSeverity validationIssueSeverity) {
        super(node, validationIssueSeverity, ValidationIssueType.MultipleManualStarters, null);
        node.getClass();
        validationIssueSeverity.getClass();
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MultipleManualStarters) {
            return super.equals(other);
        }
        return false;
    }
}

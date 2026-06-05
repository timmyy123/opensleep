package com.google.home.automation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/google/home/automation/TooManyNodes;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "nodeCount", "nodeCountLimit", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;II)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getNodeCount", "getNodeCountLimit", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TooManyNodes extends ValidationIssue {
    private final int nodeCount;
    private final int nodeCountLimit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooManyNodes(Node node, ValidationIssueSeverity validationIssueSeverity, int i, int i2) {
        super(node, validationIssueSeverity, ValidationIssueType.TooManyNodes, null);
        node.getClass();
        validationIssueSeverity.getClass();
        this.nodeCount = i;
        this.nodeCountLimit = i2;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TooManyNodes)) {
            return false;
        }
        TooManyNodes tooManyNodes = (TooManyNodes) other;
        return this.nodeCount == tooManyNodes.nodeCount && this.nodeCountLimit == tooManyNodes.nodeCountLimit && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.nodeCount) + (super.hashCode() * 31);
        return Integer.hashCode(this.nodeCountLimit) + (iHashCode * 31);
    }
}

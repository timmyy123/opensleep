package com.google.home.automation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/automation/UnsupportedEntityCommand;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "commandId", "entityId", "entityType", "", "Lcom/google/home/automation/UnsupportedCandidateReason;", "unsupportedReasons", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "getEntityId", "getEntityType", "Ljava/util/List;", "getUnsupportedReasons", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsupportedEntityCommand extends ValidationIssue {
    private final String commandId;
    private final String entityId;
    private final String entityType;
    private final List<UnsupportedCandidateReason> unsupportedReasons;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnsupportedEntityCommand(Node node, ValidationIssueSeverity validationIssueSeverity, String str, String str2, String str3, List<? extends UnsupportedCandidateReason> list) {
        super(node, validationIssueSeverity, ValidationIssueType.UnsupportedEntityCommand, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        list.getClass();
        this.commandId = str;
        this.entityId = str2;
        this.entityType = str3;
        this.unsupportedReasons = list;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnsupportedEntityCommand)) {
            return false;
        }
        UnsupportedEntityCommand unsupportedEntityCommand = (UnsupportedEntityCommand) other;
        return Intrinsics.areEqual(this.commandId, unsupportedEntityCommand.commandId) && Intrinsics.areEqual(this.entityId, unsupportedEntityCommand.entityId) && Intrinsics.areEqual(this.entityType, unsupportedEntityCommand.entityType) && Intrinsics.areEqual(this.unsupportedReasons, unsupportedEntityCommand.unsupportedReasons) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = this.commandId.hashCode() + (super.hashCode() * 31);
        int iHashCode2 = this.entityId.hashCode() + (iHashCode * 31);
        int iHashCode3 = this.entityType.hashCode();
        return this.unsupportedReasons.hashCode() + ((iHashCode3 + (iHashCode2 * 31)) * 31);
    }
}

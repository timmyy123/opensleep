package com.google.home.automation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/google/home/automation/UnsupportedEntityType;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "entityType", "entityId", "", "supportedTypes", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getEntityType", "()Ljava/lang/String;", "getEntityId", "Ljava/util/List;", "getSupportedTypes", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsupportedEntityType extends ValidationIssue {
    private final String entityId;
    private final String entityType;
    private final List<String> supportedTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedEntityType(Node node, ValidationIssueSeverity validationIssueSeverity, String str, String str2, List<String> list) {
        super(node, validationIssueSeverity, ValidationIssueType.UnsupportedEntityType, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        str2.getClass();
        list.getClass();
        this.entityType = str;
        this.entityId = str2;
        this.supportedTypes = list;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnsupportedEntityType)) {
            return false;
        }
        UnsupportedEntityType unsupportedEntityType = (UnsupportedEntityType) other;
        return Intrinsics.areEqual(this.entityType, unsupportedEntityType.entityType) && Intrinsics.areEqual(this.entityId, unsupportedEntityType.entityId) && Intrinsics.areEqual(this.supportedTypes, unsupportedEntityType.supportedTypes) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = this.entityType.hashCode() + (super.hashCode() * 31);
        int iHashCode2 = this.entityId.hashCode();
        return this.supportedTypes.hashCode() + ((iHashCode2 + (iHashCode * 31)) * 31);
    }
}

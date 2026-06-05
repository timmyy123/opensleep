package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b \u0010\u001aR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"Lcom/google/home/automation/UnsupportedEntityParameter;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "parameterName", "", "fieldId", "commandId", "eventId", "traitId", "entityId", "entityType", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getParameterName", "()Ljava/lang/String;", "I", "getFieldId", "getCommandId", "getEventId", "getTraitId", "getEntityId", "getEntityType", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsupportedEntityParameter extends ValidationIssue {
    private final String commandId;
    private final String entityId;
    private final String entityType;
    private final String eventId;
    private final int fieldId;
    private final String parameterName;
    private final String traitId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedEntityParameter(Node node, ValidationIssueSeverity validationIssueSeverity, String str, int i, String str2, String str3, String str4, String str5, String str6) {
        super(node, validationIssueSeverity, ValidationIssueType.UnsupportedEntityParameter, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        str5.getClass();
        str6.getClass();
        this.parameterName = str;
        this.fieldId = i;
        this.commandId = str2;
        this.eventId = str3;
        this.traitId = str4;
        this.entityId = str5;
        this.entityType = str6;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnsupportedEntityParameter)) {
            return false;
        }
        UnsupportedEntityParameter unsupportedEntityParameter = (UnsupportedEntityParameter) other;
        return Intrinsics.areEqual(this.parameterName, unsupportedEntityParameter.parameterName) && this.fieldId == unsupportedEntityParameter.fieldId && Intrinsics.areEqual(this.commandId, unsupportedEntityParameter.commandId) && Intrinsics.areEqual(this.eventId, unsupportedEntityParameter.eventId) && Intrinsics.areEqual(this.traitId, unsupportedEntityParameter.traitId) && Intrinsics.areEqual(this.entityId, unsupportedEntityParameter.entityId) && Intrinsics.areEqual(this.entityType, unsupportedEntityParameter.entityType) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.fieldId) + ((this.parameterName.hashCode() + (super.hashCode() * 31)) * 31);
        String str = this.commandId;
        int iM = zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, str != null ? str.hashCode() : 0, 31);
        String str2 = this.eventId;
        int iHashCode2 = (iM + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.traitId;
        return this.entityType.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31, 31, this.entityId);
    }
}

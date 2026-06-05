package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u001aR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\"\u0010\u001dR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/google/home/automation/UnsupportedEntityParameterValue;", "Lcom/google/home/automation/ValidationIssue;", "Lcom/google/home/automation/Node;", "node", "Lcom/google/home/automation/ValidationIssueSeverity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "parameterName", "", "fieldId", "commandId", "eventId", "traitId", "entityId", "entityType", "", SDKConstants.PARAM_VALUE, "Lcom/google/home/automation/Constraint;", "valueConstraint", "<init>", "(Lcom/google/home/automation/Node;Lcom/google/home/automation/ValidationIssueSeverity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/google/home/automation/Constraint;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getParameterName", "()Ljava/lang/String;", "I", "getFieldId", "getCommandId", "getEventId", "getTraitId", "getEntityId", "getEntityType", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Lcom/google/home/automation/Constraint;", "getValueConstraint", "()Lcom/google/home/automation/Constraint;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsupportedEntityParameterValue extends ValidationIssue {
    private final String commandId;
    private final String entityId;
    private final String entityType;
    private final String eventId;
    private final int fieldId;
    private final String parameterName;
    private final String traitId;
    private final Object value;
    private final Constraint valueConstraint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedEntityParameterValue(Node node, ValidationIssueSeverity validationIssueSeverity, String str, int i, String str2, String str3, String str4, String str5, String str6, Object obj, Constraint constraint) {
        super(node, validationIssueSeverity, ValidationIssueType.UnsupportedEntityParameterValue, null);
        node.getClass();
        validationIssueSeverity.getClass();
        str.getClass();
        str5.getClass();
        this.parameterName = str;
        this.fieldId = i;
        this.commandId = str2;
        this.eventId = str3;
        this.traitId = str4;
        this.entityId = str5;
        this.entityType = str6;
        this.value = obj;
        this.valueConstraint = constraint;
    }

    @Override // com.google.home.automation.ValidationIssue
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnsupportedEntityParameterValue)) {
            return false;
        }
        UnsupportedEntityParameterValue unsupportedEntityParameterValue = (UnsupportedEntityParameterValue) other;
        return Intrinsics.areEqual(this.parameterName, unsupportedEntityParameterValue.parameterName) && this.fieldId == unsupportedEntityParameterValue.fieldId && Intrinsics.areEqual(this.commandId, unsupportedEntityParameterValue.commandId) && Intrinsics.areEqual(this.eventId, unsupportedEntityParameterValue.eventId) && Intrinsics.areEqual(this.traitId, unsupportedEntityParameterValue.traitId) && Intrinsics.areEqual(this.entityId, unsupportedEntityParameterValue.entityId) && Intrinsics.areEqual(this.entityType, unsupportedEntityParameterValue.entityType) && Intrinsics.areEqual(this.value, unsupportedEntityParameterValue.value) && Intrinsics.areEqual(this.valueConstraint, unsupportedEntityParameterValue.valueConstraint) && super.equals(other);
    }

    @Override // com.google.home.automation.ValidationIssue
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.fieldId) + ((this.parameterName.hashCode() + (super.hashCode() * 31)) * 31);
        String str = this.commandId;
        int iM = zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, str != null ? str.hashCode() : 0, 31);
        String str2 = this.eventId;
        int iHashCode2 = (iM + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.traitId;
        int iM2 = FileInsert$$ExternalSyntheticOutline0.m((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31, 31, this.entityId);
        String str4 = this.entityType;
        int iHashCode3 = (iM2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Object obj = this.value;
        int iHashCode4 = (iHashCode3 + (obj != null ? obj.hashCode() : 0)) * 31;
        Constraint constraint = this.valueConstraint;
        return iHashCode4 + (constraint != null ? constraint.hashCode() : 0);
    }
}

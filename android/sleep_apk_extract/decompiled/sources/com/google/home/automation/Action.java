package com.google.home.automation;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.HasId;
import com.google.home.TypeFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001e\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/google/home/automation/Action;", "Lcom/google/home/automation/Node;", "Lcom/google/home/HasId;", "entity", "Lcom/google/home/TypeFactory;", "", "genericType", "Lcom/google/home/automation/ActionBehavior;", "behavior", "", "nodeId", "<init>", "(Lcom/google/home/HasId;Lcom/google/home/TypeFactory;Lcom/google/home/automation/ActionBehavior;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/HasId;", "getEntity", "()Lcom/google/home/HasId;", "Lcom/google/home/TypeFactory;", "Lcom/google/home/automation/ActionBehavior;", "getBehavior", "()Lcom/google/home/automation/ActionBehavior;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "getDeviceType", "()Lcom/google/home/DeviceTypeFactory;", "deviceType", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Action extends Node {
    private final ActionBehavior behavior;
    private final HasId entity;
    private final TypeFactory<Object> genericType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Action(HasId hasId, TypeFactory<Object> typeFactory, ActionBehavior actionBehavior, String str) {
        super(str, null);
        hasId.getClass();
        actionBehavior.getClass();
        str.getClass();
        this.entity = hasId;
        this.genericType = typeFactory;
        this.behavior = actionBehavior;
    }

    @Override // com.google.home.automation.Node
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Action) || !super.equals(other)) {
            return false;
        }
        Action action = (Action) other;
        return Intrinsics.areEqual(this.entity, action.entity) && Intrinsics.areEqual(getDeviceType(), action.getDeviceType()) && Intrinsics.areEqual(this.behavior, action.behavior);
    }

    public final DeviceTypeFactory<? extends DeviceType> getDeviceType() {
        TypeFactory<Object> typeFactory = this.genericType;
        if (typeFactory instanceof DeviceTypeFactory) {
            return (DeviceTypeFactory) typeFactory;
        }
        return null;
    }

    @Override // com.google.home.automation.Node
    public int hashCode() {
        int iHashCode = this.entity.hashCode() + (super.hashCode() * 31);
        DeviceTypeFactory<? extends DeviceType> deviceType = getDeviceType();
        return this.behavior.hashCode() + zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, deviceType != null ? deviceType.hashCode() : 0, 31);
    }

    public String toString() {
        DeviceTypeFactory<? extends DeviceType> deviceType = getDeviceType();
        String nodeId = getNodeId();
        HasId hasId = this.entity;
        int length = String.valueOf(hasId).length();
        int length2 = String.valueOf(deviceType).length();
        ActionBehavior actionBehavior = this.behavior;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 27, length2, 11, String.valueOf(actionBehavior).length(), 9, String.valueOf(nodeId).length()) + 1);
        sb.append("Action(entity=");
        sb.append(hasId);
        sb.append(", deviceType=");
        sb.append(deviceType);
        sb.append(", behavior=");
        sb.append(actionBehavior);
        sb.append(", nodeId=");
        sb.append(nodeId);
        sb.append(")");
        return sb.toString();
    }
}

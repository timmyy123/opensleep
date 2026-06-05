package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.EventFactory;
import com.google.home.HasId;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.TypeFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BI\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fBY\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"R!\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%R!\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u001eR\u0017\u0010.\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b/\u0010\u001eR\u001b\u00104\u001a\f\u0012\u0006\b\u0001\u0012\u000201\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/google/home/automation/Starter;", "Lcom/google/home/automation/Node;", "Lcom/google/home/automation/HasOutput;", "Lcom/google/home/HasId;", "entity", "Lcom/google/home/TypeFactory;", "", "genericType", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "trait", "", "output", "nodeId", "<init>", "(Lcom/google/home/HasId;Lcom/google/home/TypeFactory;Lcom/google/home/TraitFactory;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/home/EventFactory;", "event", "", "Lcom/google/home/automation/Parameter;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "(Lcom/google/home/HasId;Lcom/google/home/TypeFactory;Lcom/google/home/EventFactory;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/HasId;", "getEntity", "()Lcom/google/home/HasId;", "Lcom/google/home/TypeFactory;", "Lcom/google/home/TraitFactory;", "getTrait", "()Lcom/google/home/TraitFactory;", "Lcom/google/home/EventFactory;", "getEvent", "()Lcom/google/home/EventFactory;", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "Ljava/lang/String;", "getOutput", "traitId", "getTraitId", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "getDeviceType", "()Lcom/google/home/DeviceTypeFactory;", "deviceType", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Starter extends Node implements HasOutput {
    private final HasId entity;
    private final EventFactory<Object> event;
    private final TypeFactory<Object> genericType;
    private final String output;
    private final List<Parameter> parameters;
    private final TraitFactory<? extends Trait> trait;
    private final String traitId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Starter(HasId hasId, TypeFactory<Object> typeFactory, TraitFactory<? extends Trait> traitFactory, String str, String str2) {
        super(str2, null);
        hasId.getClass();
        traitFactory.getClass();
        str.getClass();
        this.entity = hasId;
        this.genericType = typeFactory;
        this.trait = traitFactory;
        this.event = null;
        this.parameters = CollectionsKt.emptyList();
        this.output = str;
        InternalTraitFactory<T> factory = traitFactory.getFactory();
        factory.getClass();
        this.traitId = factory.getTraitId();
    }

    @Override // com.google.home.automation.Node
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Starter) || !super.equals(other)) {
            return false;
        }
        Starter starter = (Starter) other;
        return Intrinsics.areEqual(this.entity, starter.entity) && Intrinsics.areEqual(getDeviceType(), starter.getDeviceType()) && Intrinsics.areEqual(this.trait, starter.trait) && Intrinsics.areEqual(this.event, starter.event) && Intrinsics.areEqual(getOutput(), starter.getOutput());
    }

    public final DeviceTypeFactory<? extends DeviceType> getDeviceType() {
        TypeFactory<Object> typeFactory = this.genericType;
        if (typeFactory instanceof DeviceTypeFactory) {
            return (DeviceTypeFactory) typeFactory;
        }
        return null;
    }

    public final EventFactory<Object> getEvent() {
        return this.event;
    }

    @Override // com.google.home.automation.HasOutput
    public String getOutput() {
        return this.output;
    }

    public final TraitFactory<? extends Trait> getTrait() {
        return this.trait;
    }

    @Override // com.google.home.automation.Node
    public int hashCode() {
        int iHashCode = this.entity.hashCode() + (super.hashCode() * 31);
        DeviceTypeFactory<? extends DeviceType> deviceType = getDeviceType();
        int iM = zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, deviceType != null ? deviceType.hashCode() : 0, 31);
        TraitFactory<? extends Trait> traitFactory = this.trait;
        int iHashCode2 = (iM + (traitFactory != null ? traitFactory.hashCode() : 0)) * 31;
        EventFactory<Object> eventFactory = this.event;
        return getOutput().hashCode() + ((iHashCode2 + (eventFactory != null ? eventFactory.hashCode() : 0)) * 31);
    }

    public String toString() {
        DeviceTypeFactory<? extends DeviceType> deviceType = getDeviceType();
        String output = getOutput();
        String nodeId = getNodeId();
        HasId hasId = this.entity;
        int length = String.valueOf(hasId).length();
        int length2 = String.valueOf(deviceType).length();
        TraitFactory<? extends Trait> traitFactory = this.trait;
        int length3 = String.valueOf(traitFactory).length();
        String str = this.traitId;
        int length4 = String.valueOf(str).length();
        EventFactory<Object> eventFactory = this.event;
        int length5 = String.valueOf(eventFactory).length();
        List<Parameter> list = this.parameters;
        int length6 = String.valueOf(list).length();
        StringBuilder sb = new StringBuilder(length + 28 + length2 + 8 + length3 + 11 + length4 + 9 + length5 + 13 + length6 + 10 + String.valueOf(output).length() + 11 + String.valueOf(nodeId).length() + 2);
        sb.append("Starter(entity=");
        sb.append(hasId);
        sb.append(", deviceType=");
        sb.append(deviceType);
        sb.append(", trait=");
        sb.append(traitFactory);
        sb.append(", traitId='");
        sb.append(str);
        sb.append("', event=");
        sb.append(eventFactory);
        sb.append(", parameters=");
        sb.append(list);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", output='", output, "', nodeId='", nodeId);
        sb.append("')");
        return sb.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Starter(HasId hasId, TypeFactory<Object> typeFactory, EventFactory<Object> eventFactory, List<Parameter> list, String str, String str2) {
        super(str2, null);
        hasId.getClass();
        eventFactory.getClass();
        list.getClass();
        str.getClass();
        this.entity = hasId;
        this.genericType = typeFactory;
        this.trait = null;
        this.event = eventFactory;
        this.parameters = list;
        this.output = str;
        this.traitId = "";
    }
}

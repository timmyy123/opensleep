package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.HasId;
import com.google.home.InternalTraitFactory;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.TypeFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BG\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u001f\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0018R\u0017\u0010\"\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0018R\u001b\u0010(\u001a\f\u0012\u0006\b\u0001\u0012\u00020%\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/google/home/automation/StateReader;", "Lcom/google/home/automation/Node;", "Lcom/google/home/automation/HasOutput;", "Lcom/google/home/HasId;", "entity", "Lcom/google/home/TypeFactory;", "", "genericType", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "trait", "", "output", "nodeId", "<init>", "(Lcom/google/home/HasId;Lcom/google/home/TypeFactory;Lcom/google/home/TraitFactory;Ljava/lang/String;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/HasId;", "getEntity", "()Lcom/google/home/HasId;", "Lcom/google/home/TypeFactory;", "Lcom/google/home/TraitFactory;", "getTrait", "()Lcom/google/home/TraitFactory;", "Ljava/lang/String;", "getOutput", "traitId", "getTraitId", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "getDeviceType", "()Lcom/google/home/DeviceTypeFactory;", "deviceType", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StateReader extends Node implements HasOutput {
    private final HasId entity;
    private final TypeFactory<Object> genericType;
    private final String output;
    private final TraitFactory<? extends Trait> trait;
    private final String traitId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateReader(HasId hasId, TypeFactory<Object> typeFactory, TraitFactory<? extends Trait> traitFactory, String str, String str2) {
        super(str2, null);
        hasId.getClass();
        traitFactory.getClass();
        str.getClass();
        this.entity = hasId;
        this.genericType = typeFactory;
        this.trait = traitFactory;
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
        if (!(other instanceof StateReader) || !super.equals(other)) {
            return false;
        }
        StateReader stateReader = (StateReader) other;
        return Intrinsics.areEqual(this.entity, stateReader.entity) && Intrinsics.areEqual(getDeviceType(), stateReader.getDeviceType()) && Intrinsics.areEqual(this.trait, stateReader.trait) && Intrinsics.areEqual(getOutput(), stateReader.getOutput());
    }

    public final DeviceTypeFactory<? extends DeviceType> getDeviceType() {
        TypeFactory<Object> typeFactory = this.genericType;
        if (typeFactory instanceof DeviceTypeFactory) {
            return (DeviceTypeFactory) typeFactory;
        }
        return null;
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
        return getOutput().hashCode() + ((this.trait.hashCode() + zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, deviceType != null ? deviceType.hashCode() : 0, 31)) * 31);
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
        int length4 = String.valueOf(output).length();
        String str = this.traitId;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 8 + length3 + 10 + length4 + 12 + String.valueOf(str).length() + 11 + String.valueOf(nodeId).length() + 2);
        sb.append("StateReader(entity=");
        sb.append(hasId);
        sb.append(", deviceType=");
        sb.append(deviceType);
        sb.append(", trait=");
        sb.append(traitFactory);
        sb.append(", output='");
        sb.append(output);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "', traitId='", str, "', nodeId='", nodeId);
        sb.append("')");
        return sb.toString();
    }
}

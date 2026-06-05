package com.google.home.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Trait;
import com.google.home.google.ExtendedThermostatTrait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u001c\u0010(\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010/\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010'R\u0016\u00103\u001a\u0004\u0018\u0001008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0004\u0018\u0001048\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010\u0013R\u0016\u0010;\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010\u001cR\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010'R\u0016\u0010A\u001a\u0004\u0018\u00010>8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001c\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010'R\u0016\u0010E\u001a\u0004\u0018\u0001048\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u00106R\u0016\u0010I\u001a\u0004\u0018\u00010F8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u0004\u0018\u00010>8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010@R\u0016\u0010N\u001a\u0004\u0018\u00010%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020>0$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010'R\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020>0$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010'R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020>0$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010'R\u0014\u0010X\u001a\u00020U8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006]"}, d2 = {"Lcom/google/home/google/ExtendedThermostatImpl;", "Lcom/google/home/google/ExtendedThermostat;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "", "Lcom/google/home/google/ExtendedThermostatTrait$MutableAttributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/google/ExtendedThermostatTrait$Attributes;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "getAttributes$home_platform_traits_google_common_clusters_android", "()Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "", "getMinHeatSafetySetpointLimit", "()Ljava/lang/Short;", "minHeatSafetySetpointLimit", "getMaxHeatSafetySetpointLimit", "maxHeatSafetySetpointLimit", "getMinCoolSafetySetpointLimit", "minCoolSafetySetpointLimit", "getMaxCoolSafetySetpointLimit", "maxCoolSafetySetpointLimit", "", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "getExtendedSupportedModes", "()Ljava/util/List;", "extendedSupportedModes", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "getExtendedRunningMode", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "extendedRunningMode", "Lcom/google/home/google/ExtendedThermostatTrait$Preset;", "getPresets", "presets", "", "getMaxSetpointHoldSeconds", "()Ljava/lang/Integer;", "maxSetpointHoldSeconds", "", "getTargetTemperatureTimestampSeconds", "()Ljava/lang/Long;", "targetTemperatureTimestampSeconds", "getActivePresetHandle", "activePresetHandle", "getAverageLocalTemperature", "averageLocalTemperature", "getRemoteTemperatureSensorIds", "remoteTemperatureSensorIds", "Lkotlin/UInt;", "getMaxSettableThermostatTemperatureSensors-0hXNFcg", "()Lkotlin/UInt;", "maxSettableThermostatTemperatureSensors", "getActiveRemoteTemperatureSensorIds", "activeRemoteTemperatureSensorIds", "getTemperatureSetpointHoldExpiryTimestampSeconds", "temperatureSetpointHoldExpiryTimestampSeconds", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "getExtendedSetpointChangeSource", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "extendedSetpointChangeSource", "getExtendedProgrammingOperationMode-0hXNFcg", "extendedProgrammingOperationMode", "getExtendedSystemMode", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "extendedSystemMode", "getGeneratedCommandList", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "getFeatureMap", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "featureMap", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedThermostatImpl extends MatterTraitImpl implements ExtendedThermostat, ExtendedThermostatTrait.Attributes {
    private final ExtendedThermostatTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedThermostatImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ExtendedThermostatTrait.Attributes attributes) {
        super(traitMetadata, matterTraitClient);
        traitMetadata.getClass();
        matterTraitClient.getClass();
        attributes.getClass();
        this.metadata = traitMetadata;
        this.attributes = attributes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtendedThermostatImpl)) {
            return false;
        }
        ExtendedThermostatImpl extendedThermostatImpl = (ExtendedThermostatImpl) other;
        return Intrinsics.areEqual(getMetadata(), extendedThermostatImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, extendedThermostatImpl.attributes);
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public String getActivePresetHandle() {
        return this.attributes.getActivePresetHandle();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<String> getActiveRemoteTemperatureSensorIds() {
        return this.attributes.getActiveRemoteTemperatureSensorIds();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Short getAverageLocalTemperature() {
        return this.attributes.getAverageLocalTemperature();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    /* JADX INFO: renamed from: getExtendedProgrammingOperationMode-0hXNFcg, reason: not valid java name */
    public UInt getExtendedProgrammingOperationMode() {
        return this.attributes.getExtendedProgrammingOperationMode();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public ExtendedThermostatTrait.ExtendedRunningMode getExtendedRunningMode() {
        return this.attributes.getExtendedRunningMode();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public ExtendedThermostatTrait.ExtendedSetpointChangeSource getExtendedSetpointChangeSource() {
        return this.attributes.getExtendedSetpointChangeSource();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<ExtendedThermostatTrait.ExtendedThermostatMode> getExtendedSupportedModes() {
        return this.attributes.getExtendedSupportedModes();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public ExtendedThermostatTrait.ExtendedThermostatMode getExtendedSystemMode() {
        return this.attributes.getExtendedSystemMode();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public ExtendedThermostatTrait.ExtendedThermostatFeature getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Short getMaxCoolSafetySetpointLimit() {
        return this.attributes.getMaxCoolSafetySetpointLimit();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Short getMaxHeatSafetySetpointLimit() {
        return this.attributes.getMaxHeatSafetySetpointLimit();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Integer getMaxSetpointHoldSeconds() {
        return this.attributes.getMaxSetpointHoldSeconds();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    /* JADX INFO: renamed from: getMaxSettableThermostatTemperatureSensors-0hXNFcg, reason: not valid java name */
    public UInt getMaxSettableThermostatTemperatureSensors() {
        return this.attributes.getMaxSettableThermostatTemperatureSensors();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Short getMinCoolSafetySetpointLimit() {
        return this.attributes.getMinCoolSafetySetpointLimit();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Short getMinHeatSafetySetpointLimit() {
        return this.attributes.getMinHeatSafetySetpointLimit();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<ExtendedThermostatTrait.Preset> getPresets() {
        return this.attributes.getPresets();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public List<String> getRemoteTemperatureSensorIds() {
        return this.attributes.getRemoteTemperatureSensorIds();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Long getTargetTemperatureTimestampSeconds() {
        return this.attributes.getTargetTemperatureTimestampSeconds();
    }

    @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
    public Long getTemperatureSetpointHoldExpiryTimestampSeconds() {
        return this.attributes.getTemperatureSetpointHoldExpiryTimestampSeconds();
    }

    public String toString() {
        return this.attributes.toString();
    }
}

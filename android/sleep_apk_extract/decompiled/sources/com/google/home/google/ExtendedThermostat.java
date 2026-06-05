package com.google.home.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.Type;
import com.google.home.google.ExtendedThermostatTrait;
import com.google.home.matter.MatterTrait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.ClusterId;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0003:\u0002\u0006\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/google/home/google/ExtendedThermostat;", "Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "Lcom/google/home/matter/MatterTrait;", "", "Lcom/google/home/google/ExtendedThermostatTrait$MutableAttributes;", "Companion", "Attribute", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ExtendedThermostat extends ExtendedThermostatTrait.Attributes, MatterTrait {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, d2 = {"Lcom/google/home/google/ExtendedThermostat$Attribute;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "minHeatSafetySetpointLimit", "maxHeatSafetySetpointLimit", "minCoolSafetySetpointLimit", "maxCoolSafetySetpointLimit", "extendedSupportedModes", "extendedRunningMode", "presets", "maxSetpointHoldSeconds", "targetTemperatureTimestampSeconds", "activePresetHandle", "averageLocalTemperature", "remoteTemperatureSensorIds", "maxSettableThermostatTemperatureSensors", "activeRemoteTemperatureSensorIds", "temperatureSetpointHoldExpiryTimestampSeconds", "extendedSetpointChangeSource", "extendedProgrammingOperationMode", "extendedSystemMode", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "clusterRevision", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Attribute implements Field {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Attribute[] $VALUES;
        public static final Attribute acceptedCommandList;
        public static final Attribute activePresetHandle;
        public static final Attribute activeRemoteTemperatureSensorIds;
        public static final Attribute attributeList;
        public static final Attribute averageLocalTemperature;
        public static final Attribute clusterRevision;
        public static final Attribute extendedProgrammingOperationMode;
        public static final Attribute extendedRunningMode;
        public static final Attribute extendedSetpointChangeSource;
        public static final Attribute extendedSupportedModes;
        public static final Attribute extendedSystemMode;
        public static final Attribute featureMap;
        public static final Attribute generatedCommandList;
        public static final Attribute maxCoolSafetySetpointLimit;
        public static final Attribute maxHeatSafetySetpointLimit;
        public static final Attribute maxSetpointHoldSeconds;
        public static final Attribute maxSettableThermostatTemperatureSensors;
        public static final Attribute minCoolSafetySetpointLimit;
        public static final Attribute minHeatSafetySetpointLimit;
        public static final Attribute presets;
        public static final Attribute remoteTemperatureSensorIds;
        public static final Attribute targetTemperatureTimestampSeconds;
        public static final Attribute temperatureSetpointHoldExpiryTimestampSeconds;
        private final Descriptor descriptor;
        private final boolean isNullable;
        private final int tag;
        private final Type typeEnum;
        private final String typeName;

        private static final /* synthetic */ Attribute[] $values() {
            return new Attribute[]{minHeatSafetySetpointLimit, maxHeatSafetySetpointLimit, minCoolSafetySetpointLimit, maxCoolSafetySetpointLimit, extendedSupportedModes, extendedRunningMode, presets, maxSetpointHoldSeconds, targetTemperatureTimestampSeconds, activePresetHandle, averageLocalTemperature, remoteTemperatureSensorIds, maxSettableThermostatTemperatureSensors, activeRemoteTemperatureSensorIds, temperatureSetpointHoldExpiryTimestampSeconds, extendedSetpointChangeSource, extendedProgrammingOperationMode, extendedSystemMode, generatedCommandList, acceptedCommandList, attributeList, featureMap, clusterRevision};
        }

        static {
            Type type = Type.Short;
            NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
            minHeatSafetySetpointLimit = new Attribute("minHeatSafetySetpointLimit", 0, 0, "Short", type, noOpDescriptor, false);
            maxHeatSafetySetpointLimit = new Attribute("maxHeatSafetySetpointLimit", 1, 1, "Short", type, noOpDescriptor, false);
            minCoolSafetySetpointLimit = new Attribute("minCoolSafetySetpointLimit", 2, 2, "Short", type, noOpDescriptor, false);
            maxCoolSafetySetpointLimit = new Attribute("maxCoolSafetySetpointLimit", 3, 3, "Short", type, noOpDescriptor, false);
            Type type2 = Type.Enum;
            extendedSupportedModes = new Attribute("extendedSupportedModes", 4, 4, "ExtendedThermostatMode", type2, noOpDescriptor, false);
            extendedRunningMode = new Attribute("extendedRunningMode", 5, 5, "ExtendedRunningMode", type2, noOpDescriptor, false);
            presets = new Attribute("presets", 6, 6, "Preset", Type.Struct, ExtendedThermostatTrait.Preset.INSTANCE, false);
            maxSetpointHoldSeconds = new Attribute("maxSetpointHoldSeconds", 7, 7, "Int", Type.Int, noOpDescriptor, false);
            Type type3 = Type.Long;
            targetTemperatureTimestampSeconds = new Attribute("targetTemperatureTimestampSeconds", 8, 8, "Long", type3, noOpDescriptor, false);
            Type type4 = Type.String;
            activePresetHandle = new Attribute("activePresetHandle", 9, 9, "String", type4, noOpDescriptor, false);
            averageLocalTemperature = new Attribute("averageLocalTemperature", 10, 10, "Short", type, noOpDescriptor, false);
            remoteTemperatureSensorIds = new Attribute("remoteTemperatureSensorIds", 11, 11, "String", type4, noOpDescriptor, false);
            Type type5 = Type.UInt;
            maxSettableThermostatTemperatureSensors = new Attribute("maxSettableThermostatTemperatureSensors", 12, 12, "UInt", type5, noOpDescriptor, false);
            activeRemoteTemperatureSensorIds = new Attribute("activeRemoteTemperatureSensorIds", 13, 13, "String", type4, noOpDescriptor, false);
            temperatureSetpointHoldExpiryTimestampSeconds = new Attribute("temperatureSetpointHoldExpiryTimestampSeconds", 14, 14, "Long", type3, noOpDescriptor, false);
            extendedSetpointChangeSource = new Attribute("extendedSetpointChangeSource", 15, 15, "ExtendedSetpointChangeSource", type2, noOpDescriptor, false);
            extendedProgrammingOperationMode = new Attribute("extendedProgrammingOperationMode", 16, 16, "UInt", type5, noOpDescriptor, false);
            extendedSystemMode = new Attribute("extendedSystemMode", 17, 17, "ExtendedThermostatMode", type2, noOpDescriptor, false);
            generatedCommandList = new Attribute("generatedCommandList", 18, 65528, "UInt", type5, noOpDescriptor, false);
            acceptedCommandList = new Attribute("acceptedCommandList", 19, 65529, "UInt", type5, noOpDescriptor, false);
            attributeList = new Attribute("attributeList", 20, 65531, "UInt", type5, noOpDescriptor, false);
            featureMap = new Attribute("featureMap", 21, 65532, "ExtendedThermostatFeature", Type.Bitmap, noOpDescriptor, false);
            clusterRevision = new Attribute("clusterRevision", 22, 65533, "UShort", Type.UShort, noOpDescriptor, false);
            Attribute[] attributeArr$values = $values();
            $VALUES = attributeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(attributeArr$values);
        }

        private Attribute(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
            this.tag = i2;
            this.typeName = str2;
            this.typeEnum = type;
            this.descriptor = descriptor;
            this.isNullable = z;
        }

        public static Attribute valueOf(String str) {
            return (Attribute) Enum.valueOf(Attribute.class, str);
        }

        public static Attribute[] values() {
            return (Attribute[]) $VALUES.clone();
        }

        @Override // com.google.home.Field
        public Descriptor getDescriptor() {
            return this.descriptor;
        }

        /* JADX INFO: renamed from: getTag-pVg5ArA, reason: not valid java name and from getter */
        public int getTag() {
            return this.tag;
        }

        @Override // com.google.home.Field
        public Type getTypeEnum() {
            return this.typeEnum;
        }

        @Override // com.google.home.Field
        public String getTypeName() {
            return this.typeName;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/home/google/ExtendedThermostat$Companion;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/google/ExtendedThermostat;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getAttributeById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getAttributeById", "", "name", "getAttributeByName", "(Ljava/lang/String;)Lcom/google/home/Field;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends TraitFactory<ExtendedThermostat> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostat$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Trait.TraitMetadata, MatterTraitClient, ExtendedThermostatTrait.Attributes, ExtendedThermostatImpl> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(3, ExtendedThermostatImpl.class, "<init>", "<init>(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/google/ExtendedThermostatTrait$Attributes;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final ExtendedThermostatImpl invoke(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ExtendedThermostatTrait.Attributes attributes) {
                traitMetadata.getClass();
                matterTraitClient.getClass();
                attributes.getClass();
                return new ExtendedThermostatImpl(traitMetadata, matterTraitClient, attributes);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Companion() {
            ClusterId id = ExtendedThermostatTrait.INSTANCE.getId();
            ExtendedThermostatTrait.Attributes.Companion companion = ExtendedThermostatTrait.Attributes.INSTANCE;
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("ExtendedThermostatMode", ExtendedThermostatTrait.ExtendedThermostatMode.INSTANCE.getAdapter()), TuplesKt.to("ExtendedRunningMode", ExtendedThermostatTrait.ExtendedRunningMode.INSTANCE.getAdapter()), TuplesKt.to("PresetScenario", ExtendedThermostatTrait.PresetScenario.INSTANCE.getAdapter()), TuplesKt.to("ExtendedSetpointChangeSource", ExtendedThermostatTrait.ExtendedSetpointChangeSource.INSTANCE.getAdapter()), TuplesKt.to("SensorType", ExtendedThermostatTrait.SensorType.INSTANCE.getAdapter()), TuplesKt.to("AlarmType", ExtendedThermostatTrait.AlarmType.INSTANCE.getAdapter()));
            Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("ExtendedThermostatFeature", ExtendedThermostatTrait.ExtendedThermostatFeature.INSTANCE), TuplesKt.to("ExtendedProgrammingOperationMode", ExtendedThermostatTrait.ExtendedProgrammingOperationMode.INSTANCE));
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            Map mapEmptyMap = MapsKt.emptyMap();
            ExtendedThermostatTrait.NotifySensorStateChangeCommand notifySensorStateChangeCommand = ExtendedThermostatTrait.NotifySensorStateChangeCommand.INSTANCE;
            super(new MatterTraitFactory(id, companion, mapMapOf, mapMapOf2, anonymousClass1, mapEmptyMap, MapsKt.mapOf(TuplesKt.to(notifySensorStateChangeCommand.getRequestId().toString(), notifySensorStateChangeCommand))));
        }

        @Override // com.google.home.TraitFactory
        /* JADX INFO: renamed from: getAttributeById-WZ4Q5Ns */
        public Field mo449getAttributeByIdWZ4Q5Ns(int tagId) {
            for (Attribute attribute : Attribute.values()) {
                if (attribute.getTag() == tagId) {
                    return attribute;
                }
            }
            return null;
        }

        @Override // com.google.home.TraitFactory
        public Field getAttributeByName(String name) {
            name.getClass();
            for (Attribute attribute : Attribute.values()) {
                if (Intrinsics.areEqual(attribute.name(), name)) {
                    return attribute;
                }
            }
            return null;
        }

        public String toString() {
            return "ExtendedThermostat";
        }
    }
}

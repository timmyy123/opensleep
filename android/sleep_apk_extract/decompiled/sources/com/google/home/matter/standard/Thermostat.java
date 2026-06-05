package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.Type;
import com.google.home.matter.MatterTrait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.standard.ThermostatTrait;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0003:\u0002\u0006\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/Thermostat;", "Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "Lcom/google/home/matter/MatterTrait;", "", "Lcom/google/home/matter/standard/ThermostatTrait$MutableAttributes;", "Companion", "Attribute", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Thermostat extends ThermostatTrait.Attributes, MatterTrait {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bV\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`¨\u0006a"}, d2 = {"Lcom/google/home/matter/standard/Thermostat$Attribute;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "localTemperature", "outdoorTemperature", "occupancy", "absMinHeatSetpointLimit", "absMaxHeatSetpointLimit", "absMinCoolSetpointLimit", "absMaxCoolSetpointLimit", "piCoolingDemand", "piHeatingDemand", "hvacSystemTypeConfiguration", "localTemperatureCalibration", "occupiedCoolingSetpoint", "occupiedHeatingSetpoint", "unoccupiedCoolingSetpoint", "unoccupiedHeatingSetpoint", "minHeatSetpointLimit", "maxHeatSetpointLimit", "minCoolSetpointLimit", "maxCoolSetpointLimit", "minSetpointDeadBand", "remoteSensing", "controlSequenceOfOperation", "systemMode", "thermostatRunningMode", "startOfWeek", "numberOfWeeklyTransitions", "numberOfDailyTransitions", "temperatureSetpointHold", "temperatureSetpointHoldDuration", "thermostatProgrammingOperationMode", "thermostatRunningState", "setpointChangeSource", "setpointChangeAmount", "setpointChangeSourceTimestamp", "occupiedSetback", "occupiedSetbackMin", "occupiedSetbackMax", "unoccupiedSetback", "unoccupiedSetbackMin", "unoccupiedSetbackMax", "emergencyHeatDelta", "acType", "acCapacity", "acRefrigerantType", "acCompressorType", "acErrorCode", "acLouverPosition", "acCoilTemperature", "acCapacityformat", "presetTypes", "scheduleTypes", "numberOfPresets", "numberOfSchedules", "numberOfScheduleTransitions", "numberOfScheduleTransitionPerDay", "activePresetHandle", "activeScheduleHandle", "presets", "schedules", "presetsSchedulesEditable", "temperatureSetpointHoldPolicy", "setpointHoldExpiryTimestamp", "queuedPreset", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Attribute implements Field {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Attribute[] $VALUES;
        public static final Attribute absMaxCoolSetpointLimit;
        public static final Attribute absMaxHeatSetpointLimit;
        public static final Attribute absMinCoolSetpointLimit;
        public static final Attribute absMinHeatSetpointLimit;
        public static final Attribute acCapacity;
        public static final Attribute acCapacityformat;
        public static final Attribute acCoilTemperature;
        public static final Attribute acCompressorType;
        public static final Attribute acErrorCode;
        public static final Attribute acLouverPosition;
        public static final Attribute acRefrigerantType;
        public static final Attribute acType;
        public static final Attribute acceptedCommandList;
        public static final Attribute activePresetHandle;
        public static final Attribute activeScheduleHandle;
        public static final Attribute attributeList;
        public static final Attribute clusterRevision;
        public static final Attribute controlSequenceOfOperation;
        public static final Attribute emergencyHeatDelta;
        public static final Attribute featureMap;
        public static final Attribute generatedCommandList;
        public static final Attribute hvacSystemTypeConfiguration;
        public static final Attribute localTemperature;
        public static final Attribute localTemperatureCalibration;
        public static final Attribute maxCoolSetpointLimit;
        public static final Attribute maxHeatSetpointLimit;
        public static final Attribute minCoolSetpointLimit;
        public static final Attribute minHeatSetpointLimit;
        public static final Attribute minSetpointDeadBand;
        public static final Attribute numberOfDailyTransitions;
        public static final Attribute numberOfPresets;
        public static final Attribute numberOfScheduleTransitionPerDay;
        public static final Attribute numberOfScheduleTransitions;
        public static final Attribute numberOfSchedules;
        public static final Attribute numberOfWeeklyTransitions;
        public static final Attribute occupancy;
        public static final Attribute occupiedCoolingSetpoint;
        public static final Attribute occupiedHeatingSetpoint;
        public static final Attribute occupiedSetback;
        public static final Attribute occupiedSetbackMax;
        public static final Attribute occupiedSetbackMin;
        public static final Attribute outdoorTemperature;
        public static final Attribute piCoolingDemand;
        public static final Attribute piHeatingDemand;
        public static final Attribute presetTypes;
        public static final Attribute presets;
        public static final Attribute presetsSchedulesEditable;
        public static final Attribute queuedPreset;
        public static final Attribute remoteSensing;
        public static final Attribute scheduleTypes;
        public static final Attribute schedules;
        public static final Attribute setpointChangeAmount;
        public static final Attribute setpointChangeSource;
        public static final Attribute setpointChangeSourceTimestamp;
        public static final Attribute setpointHoldExpiryTimestamp;
        public static final Attribute startOfWeek;
        public static final Attribute systemMode;
        public static final Attribute temperatureSetpointHold;
        public static final Attribute temperatureSetpointHoldDuration;
        public static final Attribute temperatureSetpointHoldPolicy;
        public static final Attribute thermostatProgrammingOperationMode;
        public static final Attribute thermostatRunningMode;
        public static final Attribute thermostatRunningState;
        public static final Attribute unoccupiedCoolingSetpoint;
        public static final Attribute unoccupiedHeatingSetpoint;
        public static final Attribute unoccupiedSetback;
        public static final Attribute unoccupiedSetbackMax;
        public static final Attribute unoccupiedSetbackMin;
        private final Descriptor descriptor;
        private final boolean isNullable;
        private final int tag;
        private final Type typeEnum;
        private final String typeName;

        private static final /* synthetic */ Attribute[] $values() {
            return new Attribute[]{localTemperature, outdoorTemperature, occupancy, absMinHeatSetpointLimit, absMaxHeatSetpointLimit, absMinCoolSetpointLimit, absMaxCoolSetpointLimit, piCoolingDemand, piHeatingDemand, hvacSystemTypeConfiguration, localTemperatureCalibration, occupiedCoolingSetpoint, occupiedHeatingSetpoint, unoccupiedCoolingSetpoint, unoccupiedHeatingSetpoint, minHeatSetpointLimit, maxHeatSetpointLimit, minCoolSetpointLimit, maxCoolSetpointLimit, minSetpointDeadBand, remoteSensing, controlSequenceOfOperation, systemMode, thermostatRunningMode, startOfWeek, numberOfWeeklyTransitions, numberOfDailyTransitions, temperatureSetpointHold, temperatureSetpointHoldDuration, thermostatProgrammingOperationMode, thermostatRunningState, setpointChangeSource, setpointChangeAmount, setpointChangeSourceTimestamp, occupiedSetback, occupiedSetbackMin, occupiedSetbackMax, unoccupiedSetback, unoccupiedSetbackMin, unoccupiedSetbackMax, emergencyHeatDelta, acType, acCapacity, acRefrigerantType, acCompressorType, acErrorCode, acLouverPosition, acCoilTemperature, acCapacityformat, presetTypes, scheduleTypes, numberOfPresets, numberOfSchedules, numberOfScheduleTransitions, numberOfScheduleTransitionPerDay, activePresetHandle, activeScheduleHandle, presets, schedules, presetsSchedulesEditable, temperatureSetpointHoldPolicy, setpointHoldExpiryTimestamp, queuedPreset, generatedCommandList, acceptedCommandList, attributeList, featureMap, clusterRevision};
        }

        static {
            Type type = Type.Short;
            NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
            localTemperature = new Attribute("localTemperature", 0, 0, "Short", type, noOpDescriptor, true);
            outdoorTemperature = new Attribute("outdoorTemperature", 1, 1, "Short", type, noOpDescriptor, true);
            Type type2 = Type.UByte;
            occupancy = new Attribute("occupancy", 2, 2, "UByte", type2, noOpDescriptor, false);
            absMinHeatSetpointLimit = new Attribute("absMinHeatSetpointLimit", 3, 3, "Short", type, noOpDescriptor, false);
            absMaxHeatSetpointLimit = new Attribute("absMaxHeatSetpointLimit", 4, 4, "Short", type, noOpDescriptor, false);
            absMinCoolSetpointLimit = new Attribute("absMinCoolSetpointLimit", 5, 5, "Short", type, noOpDescriptor, false);
            absMaxCoolSetpointLimit = new Attribute("absMaxCoolSetpointLimit", 6, 6, "Short", type, noOpDescriptor, false);
            piCoolingDemand = new Attribute("piCoolingDemand", 7, 7, "UByte", type2, noOpDescriptor, false);
            piHeatingDemand = new Attribute("piHeatingDemand", 8, 8, "UByte", type2, noOpDescriptor, false);
            hvacSystemTypeConfiguration = new Attribute("hvacSystemTypeConfiguration", 9, 9, "UByte", type2, noOpDescriptor, false);
            Type type3 = Type.Byte;
            localTemperatureCalibration = new Attribute("localTemperatureCalibration", 10, 16, "Byte", type3, noOpDescriptor, false);
            occupiedCoolingSetpoint = new Attribute("occupiedCoolingSetpoint", 11, 17, "Short", type, noOpDescriptor, false);
            occupiedHeatingSetpoint = new Attribute("occupiedHeatingSetpoint", 12, 18, "Short", type, noOpDescriptor, false);
            unoccupiedCoolingSetpoint = new Attribute("unoccupiedCoolingSetpoint", 13, 19, "Short", type, noOpDescriptor, false);
            unoccupiedHeatingSetpoint = new Attribute("unoccupiedHeatingSetpoint", 14, 20, "Short", type, noOpDescriptor, false);
            minHeatSetpointLimit = new Attribute("minHeatSetpointLimit", 15, 21, "Short", type, noOpDescriptor, false);
            maxHeatSetpointLimit = new Attribute("maxHeatSetpointLimit", 16, 22, "Short", type, noOpDescriptor, false);
            minCoolSetpointLimit = new Attribute("minCoolSetpointLimit", 17, 23, "Short", type, noOpDescriptor, false);
            maxCoolSetpointLimit = new Attribute("maxCoolSetpointLimit", 18, 24, "Short", type, noOpDescriptor, false);
            minSetpointDeadBand = new Attribute("minSetpointDeadBand", 19, 25, "Byte", type3, noOpDescriptor, false);
            Type type4 = Type.Bitmap;
            remoteSensing = new Attribute("remoteSensing", 20, 26, "RemoteSensingBitmap", type4, noOpDescriptor, false);
            Type type5 = Type.Enum;
            controlSequenceOfOperation = new Attribute("controlSequenceOfOperation", 21, 27, "ControlSequenceOfOperationEnum", type5, noOpDescriptor, false);
            systemMode = new Attribute("systemMode", 22, 28, "SystemModeEnum", type5, noOpDescriptor, false);
            thermostatRunningMode = new Attribute("thermostatRunningMode", 23, 30, "ThermostatRunningModeEnum", type5, noOpDescriptor, false);
            startOfWeek = new Attribute("startOfWeek", 24, 32, "StartOfWeekEnum", type5, noOpDescriptor, false);
            numberOfWeeklyTransitions = new Attribute("numberOfWeeklyTransitions", 25, 33, "UByte", type2, noOpDescriptor, false);
            numberOfDailyTransitions = new Attribute("numberOfDailyTransitions", 26, 34, "UByte", type2, noOpDescriptor, false);
            temperatureSetpointHold = new Attribute("temperatureSetpointHold", 27, 35, "TemperatureSetpointHoldEnum", type5, noOpDescriptor, false);
            Type type6 = Type.UShort;
            temperatureSetpointHoldDuration = new Attribute("temperatureSetpointHoldDuration", 28, 36, "UShort", type6, noOpDescriptor, true);
            thermostatProgrammingOperationMode = new Attribute("thermostatProgrammingOperationMode", 29, 37, "ProgrammingOperationModeBitmap", type4, noOpDescriptor, false);
            thermostatRunningState = new Attribute("thermostatRunningState", 30, 41, "RelayStateBitmap", type4, noOpDescriptor, false);
            setpointChangeSource = new Attribute("setpointChangeSource", 31, 48, "SetpointChangeSourceEnum", type5, noOpDescriptor, false);
            setpointChangeAmount = new Attribute("setpointChangeAmount", 32, 49, "Short", type, noOpDescriptor, true);
            Type type7 = Type.UInt;
            setpointChangeSourceTimestamp = new Attribute("setpointChangeSourceTimestamp", 33, 50, "UInt", type7, noOpDescriptor, false);
            occupiedSetback = new Attribute("occupiedSetback", 34, 52, "UByte", type2, noOpDescriptor, true);
            occupiedSetbackMin = new Attribute("occupiedSetbackMin", 35, 53, "UByte", type2, noOpDescriptor, true);
            occupiedSetbackMax = new Attribute("occupiedSetbackMax", 36, 54, "UByte", type2, noOpDescriptor, true);
            unoccupiedSetback = new Attribute("unoccupiedSetback", 37, 55, "UByte", type2, noOpDescriptor, true);
            unoccupiedSetbackMin = new Attribute("unoccupiedSetbackMin", 38, 56, "UByte", type2, noOpDescriptor, true);
            unoccupiedSetbackMax = new Attribute("unoccupiedSetbackMax", 39, 57, "UByte", type2, noOpDescriptor, true);
            emergencyHeatDelta = new Attribute("emergencyHeatDelta", 40, 58, "UByte", type2, noOpDescriptor, false);
            acType = new Attribute("acType", 41, 64, "ACTypeEnum", type5, noOpDescriptor, false);
            acCapacity = new Attribute("acCapacity", 42, 65, "UShort", type6, noOpDescriptor, false);
            acRefrigerantType = new Attribute("acRefrigerantType", 43, 66, "ACRefrigerantTypeEnum", type5, noOpDescriptor, false);
            acCompressorType = new Attribute("acCompressorType", 44, 67, "ACCompressorTypeEnum", type5, noOpDescriptor, false);
            acErrorCode = new Attribute("acErrorCode", 45, 68, "ACErrorCodeBitmap", type4, noOpDescriptor, false);
            acLouverPosition = new Attribute("acLouverPosition", 46, 69, "ACLouverPositionEnum", type5, noOpDescriptor, false);
            acCoilTemperature = new Attribute("acCoilTemperature", 47, 70, "Short", type, noOpDescriptor, true);
            acCapacityformat = new Attribute("acCapacityformat", 48, 71, "ACCapacityFormatEnum", type5, noOpDescriptor, false);
            Type type8 = Type.Struct;
            presetTypes = new Attribute("presetTypes", 49, 72, "PresetTypeStruct", type8, ThermostatTrait.PresetTypeStruct.INSTANCE, false);
            scheduleTypes = new Attribute("scheduleTypes", 50, 73, "ScheduleTypeStruct", type8, ThermostatTrait.ScheduleTypeStruct.INSTANCE, false);
            numberOfPresets = new Attribute("numberOfPresets", 51, 74, "UByte", type2, noOpDescriptor, false);
            numberOfSchedules = new Attribute("numberOfSchedules", 52, 75, "UByte", type2, noOpDescriptor, false);
            numberOfScheduleTransitions = new Attribute("numberOfScheduleTransitions", 53, 76, "UByte", type2, noOpDescriptor, false);
            numberOfScheduleTransitionPerDay = new Attribute("numberOfScheduleTransitionPerDay", 54, 77, "UByte", type2, noOpDescriptor, true);
            Type type9 = Type.ByteArray;
            activePresetHandle = new Attribute("activePresetHandle", 55, 78, "ByteArray", type9, noOpDescriptor, true);
            activeScheduleHandle = new Attribute("activeScheduleHandle", 56, 79, "ByteArray", type9, noOpDescriptor, true);
            presets = new Attribute("presets", 57, 80, "PresetStruct", type8, ThermostatTrait.PresetStruct.INSTANCE, false);
            schedules = new Attribute("schedules", 58, 81, "ScheduleStruct", type8, ThermostatTrait.ScheduleStruct.INSTANCE, false);
            presetsSchedulesEditable = new Attribute("presetsSchedulesEditable", 59, 82, "Boolean", Type.Boolean, noOpDescriptor, false);
            temperatureSetpointHoldPolicy = new Attribute("temperatureSetpointHoldPolicy", 60, 83, "TemperatureSetpointHoldPolicyBitmap", type4, noOpDescriptor, false);
            setpointHoldExpiryTimestamp = new Attribute("setpointHoldExpiryTimestamp", 61, 84, "UInt", type7, noOpDescriptor, true);
            queuedPreset = new Attribute("queuedPreset", 62, 85, "QueuedPresetStruct", type8, ThermostatTrait.QueuedPresetStruct.INSTANCE, true);
            generatedCommandList = new Attribute("generatedCommandList", 63, 65528, "UInt", type7, noOpDescriptor, false);
            acceptedCommandList = new Attribute("acceptedCommandList", 64, 65529, "UInt", type7, noOpDescriptor, false);
            attributeList = new Attribute("attributeList", 65, 65531, "UInt", type7, noOpDescriptor, false);
            featureMap = new Attribute("featureMap", 66, 65532, "Feature", type4, noOpDescriptor, false);
            clusterRevision = new Attribute("clusterRevision", 67, 65533, "UShort", type6, noOpDescriptor, false);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/home/matter/standard/Thermostat$Companion;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/matter/standard/Thermostat;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getAttributeById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getAttributeById", "", "name", "getAttributeByName", "(Ljava/lang/String;)Lcom/google/home/Field;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends TraitFactory<Thermostat> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: com.google.home.matter.standard.Thermostat$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Trait.TraitMetadata, MatterTraitClient, ThermostatTrait.Attributes, ThermostatImpl> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(3, ThermostatImpl.class, "<init>", "<init>(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/ThermostatTrait$Attributes;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final ThermostatImpl invoke(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ThermostatTrait.Attributes attributes) {
                traitMetadata.getClass();
                matterTraitClient.getClass();
                attributes.getClass();
                return new ThermostatImpl(traitMetadata, matterTraitClient, attributes);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Companion() {
            ClusterId id = ThermostatTrait.INSTANCE.getId();
            ThermostatTrait.Attributes.Companion companion = ThermostatTrait.Attributes.INSTANCE;
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("ACCapacityFormatEnum", ThermostatTrait.AcCapacityFormatEnum.INSTANCE.getAdapter()), TuplesKt.to("ACCompressorTypeEnum", ThermostatTrait.AcCompressorTypeEnum.INSTANCE.getAdapter()), TuplesKt.to("ACLouverPositionEnum", ThermostatTrait.AcLouverPositionEnum.INSTANCE.getAdapter()), TuplesKt.to("ACRefrigerantTypeEnum", ThermostatTrait.AcRefrigerantTypeEnum.INSTANCE.getAdapter()), TuplesKt.to("ACTypeEnum", ThermostatTrait.AcTypeEnum.INSTANCE.getAdapter()), TuplesKt.to("ControlSequenceOfOperationEnum", ThermostatTrait.ControlSequenceOfOperationEnum.INSTANCE.getAdapter()), TuplesKt.to("PresetScenarioEnum", ThermostatTrait.PresetScenarioEnum.INSTANCE.getAdapter()), TuplesKt.to("SetpointChangeSourceEnum", ThermostatTrait.SetpointChangeSourceEnum.INSTANCE.getAdapter()), TuplesKt.to("SetpointRaiseLowerModeEnum", ThermostatTrait.SetpointRaiseLowerModeEnum.INSTANCE.getAdapter()), TuplesKt.to("StartOfWeekEnum", ThermostatTrait.StartOfWeekEnum.INSTANCE.getAdapter()), TuplesKt.to("SystemModeEnum", ThermostatTrait.SystemModeEnum.INSTANCE.getAdapter()), TuplesKt.to("TemperatureSetpointHoldEnum", ThermostatTrait.TemperatureSetpointHoldEnum.INSTANCE.getAdapter()), TuplesKt.to("ThermostatRunningModeEnum", ThermostatTrait.ThermostatRunningModeEnum.INSTANCE.getAdapter()));
            Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("AcErrorCodeBitmap", ThermostatTrait.AcErrorCodeBitmap.INSTANCE), TuplesKt.to("Feature", ThermostatTrait.Feature.INSTANCE), TuplesKt.to("HvacSystemTypeBitmap", ThermostatTrait.HvacSystemTypeBitmap.INSTANCE), TuplesKt.to("PresetTypeFeaturesBitmap", ThermostatTrait.PresetTypeFeaturesBitmap.INSTANCE), TuplesKt.to("ProgrammingOperationModeBitmap", ThermostatTrait.ProgrammingOperationModeBitmap.INSTANCE), TuplesKt.to("RelayStateBitmap", ThermostatTrait.RelayStateBitmap.INSTANCE), TuplesKt.to("RemoteSensingBitmap", ThermostatTrait.RemoteSensingBitmap.INSTANCE), TuplesKt.to("ScheduleDayOfWeekBitmap", ThermostatTrait.ScheduleDayOfWeekBitmap.INSTANCE), TuplesKt.to("ScheduleModeBitmap", ThermostatTrait.ScheduleModeBitmap.INSTANCE), TuplesKt.to("ScheduleTypeFeaturesBitmap", ThermostatTrait.ScheduleTypeFeaturesBitmap.INSTANCE), TuplesKt.to("TemperatureSetpointHoldPolicyBitmap", ThermostatTrait.TemperatureSetpointHoldPolicyBitmap.INSTANCE));
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            Map mapEmptyMap = MapsKt.emptyMap();
            ThermostatTrait.SetpointRaiseLowerCommand setpointRaiseLowerCommand = ThermostatTrait.SetpointRaiseLowerCommand.INSTANCE;
            Pair pair = TuplesKt.to(setpointRaiseLowerCommand.getRequestId().toString(), setpointRaiseLowerCommand);
            ThermostatTrait.SetWeeklyScheduleCommand setWeeklyScheduleCommand = ThermostatTrait.SetWeeklyScheduleCommand.INSTANCE;
            Pair pair2 = TuplesKt.to(setWeeklyScheduleCommand.getRequestId().toString(), setWeeklyScheduleCommand);
            ThermostatTrait.GetWeeklyScheduleCommand getWeeklyScheduleCommand = ThermostatTrait.GetWeeklyScheduleCommand.INSTANCE;
            Pair pair3 = TuplesKt.to(getWeeklyScheduleCommand.getRequestId().toString(), getWeeklyScheduleCommand);
            ThermostatTrait.ClearWeeklyScheduleCommand clearWeeklyScheduleCommand = ThermostatTrait.ClearWeeklyScheduleCommand.INSTANCE;
            Pair pair4 = TuplesKt.to(clearWeeklyScheduleCommand.getRequestId().toString(), clearWeeklyScheduleCommand);
            ThermostatTrait.SetActiveScheduleRequestCommand setActiveScheduleRequestCommand = ThermostatTrait.SetActiveScheduleRequestCommand.INSTANCE;
            Pair pair5 = TuplesKt.to(setActiveScheduleRequestCommand.getRequestId().toString(), setActiveScheduleRequestCommand);
            ThermostatTrait.SetActivePresetRequestCommand setActivePresetRequestCommand = ThermostatTrait.SetActivePresetRequestCommand.INSTANCE;
            Pair pair6 = TuplesKt.to(setActivePresetRequestCommand.getRequestId().toString(), setActivePresetRequestCommand);
            ThermostatTrait.StartPresetsSchedulesEditRequestCommand startPresetsSchedulesEditRequestCommand = ThermostatTrait.StartPresetsSchedulesEditRequestCommand.INSTANCE;
            Pair pair7 = TuplesKt.to(startPresetsSchedulesEditRequestCommand.getRequestId().toString(), startPresetsSchedulesEditRequestCommand);
            ThermostatTrait.CancelPresetsSchedulesEditRequestCommand cancelPresetsSchedulesEditRequestCommand = ThermostatTrait.CancelPresetsSchedulesEditRequestCommand.INSTANCE;
            Pair pair8 = TuplesKt.to(cancelPresetsSchedulesEditRequestCommand.getRequestId().toString(), cancelPresetsSchedulesEditRequestCommand);
            ThermostatTrait.CommitPresetsSchedulesRequestCommand commitPresetsSchedulesRequestCommand = ThermostatTrait.CommitPresetsSchedulesRequestCommand.INSTANCE;
            Pair pair9 = TuplesKt.to(commitPresetsSchedulesRequestCommand.getRequestId().toString(), commitPresetsSchedulesRequestCommand);
            ThermostatTrait.CancelSetActivePresetRequestCommand cancelSetActivePresetRequestCommand = ThermostatTrait.CancelSetActivePresetRequestCommand.INSTANCE;
            Pair pair10 = TuplesKt.to(cancelSetActivePresetRequestCommand.getRequestId().toString(), cancelSetActivePresetRequestCommand);
            ThermostatTrait.SetTemperatureSetpointHoldPolicyCommand setTemperatureSetpointHoldPolicyCommand = ThermostatTrait.SetTemperatureSetpointHoldPolicyCommand.INSTANCE;
            super(new MatterTraitFactory(id, companion, mapMapOf, mapMapOf2, anonymousClass1, mapEmptyMap, MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, TuplesKt.to(setTemperatureSetpointHoldPolicyCommand.getRequestId().toString(), setTemperatureSetpointHoldPolicyCommand))));
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
            return "Thermostat";
        }
    }
}

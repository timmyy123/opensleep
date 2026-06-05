package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Trait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import com.google.home.matter.standard.ThermostatTrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0005\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0016\u0010)\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0016\u0010+\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0016\u0010-\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\"R\u0016\u0010/\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\"R\u0016\u00101\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\"R\u0016\u00105\u001a\u0004\u0018\u0001028\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00107\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u0010\u001cR\u0016\u00109\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010\u001cR\u0016\u0010;\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010\u001cR\u0016\u0010=\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010\u001cR\u0016\u0010?\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010\u001cR\u0016\u0010A\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010\u001cR\u0016\u0010C\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010\u001cR\u0016\u0010E\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010\u001cR\u0016\u0010G\u001a\u0004\u0018\u0001028\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u00104R\u0016\u0010K\u001a\u0004\u0018\u00010H8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010O\u001a\u0004\u0018\u00010L8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0016\u0010S\u001a\u0004\u0018\u00010P8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u0010W\u001a\u0004\u0018\u00010T8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0016\u0010[\u001a\u0004\u0018\u00010X8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0016\u0010]\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010\"R\u0016\u0010_\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b^\u0010\"R\u0016\u0010c\u001a\u0004\u0018\u00010`8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0016\u0010g\u001a\u0004\u0018\u00010d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u0010fR\u0016\u0010k\u001a\u0004\u0018\u00010h8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0016\u0010o\u001a\u0004\u0018\u00010l8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0016\u0010s\u001a\u0004\u0018\u00010p8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0016\u0010u\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bt\u0010\u001cR\u0016\u0010y\u001a\u0004\u0018\u00010v8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0016\u0010{\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bz\u0010\"R\u0016\u0010}\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b|\u0010\"R\u0016\u0010\u007f\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b~\u0010\"R\u0018\u0010\u0081\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\"R\u0018\u0010\u0083\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\"R\u0018\u0010\u0085\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\"R\u0018\u0010\u0087\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\"R\u001a\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008d\u0001\u001a\u0004\u0018\u00010d8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010fR\u001a\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\u001cR\u001a\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R!\u0010¨\u0001\u001a\f\u0012\u0005\u0012\u00030¥\u0001\u0018\u00010¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R!\u0010«\u0001\u001a\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bª\u0001\u0010§\u0001R\u0018\u0010\u00ad\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010\"R\u0018\u0010¯\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\"R\u0018\u0010±\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b°\u0001\u0010\"R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b²\u0001\u0010\"R\u001a\u0010·\u0001\u001a\u0005\u0018\u00010´\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010¹\u0001\u001a\u0005\u0018\u00010´\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¸\u0001\u0010¶\u0001R!\u0010¼\u0001\u001a\f\u0012\u0005\u0012\u00030º\u0001\u0018\u00010¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b»\u0001\u0010§\u0001R!\u0010¿\u0001\u001a\f\u0012\u0005\u0012\u00030½\u0001\u0018\u00010¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¾\u0001\u0010§\u0001R\u0019\u0010Â\u0001\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u001a\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u0018\u0010È\u0001\u001a\u0004\u0018\u00010v8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010xR\u001a\u0010Ì\u0001\u001a\u0005\u0018\u00010É\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u001e\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020v0¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÍ\u0001\u0010§\u0001R\u001e\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020v0¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÏ\u0001\u0010§\u0001R\u001e\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020v0¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÑ\u0001\u0010§\u0001R\u0018\u0010Ö\u0001\u001a\u00030Ó\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u0017\u0010Ù\u0001\u001a\u00020d8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b×\u0001\u0010Ø\u0001¨\u0006Ú\u0001"}, d2 = {"Lcom/google/home/matter/standard/ThermostatImpl;", "Lcom/google/home/matter/standard/Thermostat;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "", "Lcom/google/home/matter/standard/ThermostatTrait$MutableAttributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/ThermostatTrait$Attributes;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "getAttributes$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "", "getLocalTemperature", "()Ljava/lang/Short;", "localTemperature", "getOutdoorTemperature", "outdoorTemperature", "Lkotlin/UByte;", "getOccupancy-7PGSa80", "()Lkotlin/UByte;", "occupancy", "getAbsMinHeatSetpointLimit", "absMinHeatSetpointLimit", "getAbsMaxHeatSetpointLimit", "absMaxHeatSetpointLimit", "getAbsMinCoolSetpointLimit", "absMinCoolSetpointLimit", "getAbsMaxCoolSetpointLimit", "absMaxCoolSetpointLimit", "getPiCoolingDemand-7PGSa80", "piCoolingDemand", "getPiHeatingDemand-7PGSa80", "piHeatingDemand", "getHvacSystemTypeConfiguration-7PGSa80", "hvacSystemTypeConfiguration", "", "getLocalTemperatureCalibration", "()Ljava/lang/Byte;", "localTemperatureCalibration", "getOccupiedCoolingSetpoint", "occupiedCoolingSetpoint", "getOccupiedHeatingSetpoint", "occupiedHeatingSetpoint", "getUnoccupiedCoolingSetpoint", "unoccupiedCoolingSetpoint", "getUnoccupiedHeatingSetpoint", "unoccupiedHeatingSetpoint", "getMinHeatSetpointLimit", "minHeatSetpointLimit", "getMaxHeatSetpointLimit", "maxHeatSetpointLimit", "getMinCoolSetpointLimit", "minCoolSetpointLimit", "getMaxCoolSetpointLimit", "maxCoolSetpointLimit", "getMinSetpointDeadBand", "minSetpointDeadBand", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "getRemoteSensing", "()Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "remoteSensing", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "getControlSequenceOfOperation", "()Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "controlSequenceOfOperation", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "getSystemMode", "()Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "getThermostatRunningMode", "()Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "thermostatRunningMode", "Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "getStartOfWeek", "()Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "startOfWeek", "getNumberOfWeeklyTransitions-7PGSa80", "numberOfWeeklyTransitions", "getNumberOfDailyTransitions-7PGSa80", "numberOfDailyTransitions", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "getTemperatureSetpointHold", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "temperatureSetpointHold", "Lkotlin/UShort;", "getTemperatureSetpointHoldDuration-XRpZGF0", "()Lkotlin/UShort;", "temperatureSetpointHoldDuration", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "getThermostatProgrammingOperationMode", "()Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "thermostatProgrammingOperationMode", "Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "getThermostatRunningState", "()Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "thermostatRunningState", "Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "getSetpointChangeSource", "()Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "setpointChangeSource", "getSetpointChangeAmount", "setpointChangeAmount", "Lkotlin/UInt;", "getSetpointChangeSourceTimestamp-0hXNFcg", "()Lkotlin/UInt;", "setpointChangeSourceTimestamp", "getOccupiedSetback-7PGSa80", "occupiedSetback", "getOccupiedSetbackMin-7PGSa80", "occupiedSetbackMin", "getOccupiedSetbackMax-7PGSa80", "occupiedSetbackMax", "getUnoccupiedSetback-7PGSa80", "unoccupiedSetback", "getUnoccupiedSetbackMin-7PGSa80", "unoccupiedSetbackMin", "getUnoccupiedSetbackMax-7PGSa80", "unoccupiedSetbackMax", "getEmergencyHeatDelta-7PGSa80", "emergencyHeatDelta", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "getAcType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "acType", "getAcCapacity-XRpZGF0", "acCapacity", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "getAcRefrigerantType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "acRefrigerantType", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "getAcCompressorType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "acCompressorType", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "getAcErrorCode", "()Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "acErrorCode", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "getAcLouverPosition", "()Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "acLouverPosition", "getAcCoilTemperature", "acCoilTemperature", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "getAcCapacityformat", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "acCapacityformat", "", "Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;", "getPresetTypes", "()Ljava/util/List;", "presetTypes", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;", "getScheduleTypes", "scheduleTypes", "getNumberOfPresets-7PGSa80", "numberOfPresets", "getNumberOfSchedules-7PGSa80", "numberOfSchedules", "getNumberOfScheduleTransitions-7PGSa80", "numberOfScheduleTransitions", "getNumberOfScheduleTransitionPerDay-7PGSa80", "numberOfScheduleTransitionPerDay", "", "getActivePresetHandle", "()[B", "activePresetHandle", "getActiveScheduleHandle", "activeScheduleHandle", "Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "getPresets", "presets", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "getSchedules", "schedules", "getPresetsSchedulesEditable", "()Ljava/lang/Boolean;", "presetsSchedulesEditable", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "getTemperatureSetpointHoldPolicy", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "temperatureSetpointHoldPolicy", "getSetpointHoldExpiryTimestamp-0hXNFcg", "setpointHoldExpiryTimestamp", "Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "getQueuedPreset", "()Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "queuedPreset", "getGeneratedCommandList", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "featureMap", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThermostatImpl extends MatterTraitImpl implements Thermostat, ThermostatTrait.Attributes {
    private final ThermostatTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThermostatImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ThermostatTrait.Attributes attributes) {
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
        if (!(other instanceof ThermostatImpl)) {
            return false;
        }
        ThermostatImpl thermostatImpl = (ThermostatImpl) other;
        return Intrinsics.areEqual(getMetadata(), thermostatImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, thermostatImpl.attributes);
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getAbsMaxCoolSetpointLimit() {
        return this.attributes.getAbsMaxCoolSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getAbsMaxHeatSetpointLimit() {
        return this.attributes.getAbsMaxHeatSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getAbsMinCoolSetpointLimit() {
        return this.attributes.getAbsMinCoolSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getAbsMinHeatSetpointLimit() {
        return this.attributes.getAbsMinHeatSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getAcCapacity-XRpZGF0, reason: not valid java name */
    public UShort getAcCapacity() {
        return this.attributes.getAcCapacity();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.AcCapacityFormatEnum getAcCapacityformat() {
        return this.attributes.getAcCapacityformat();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getAcCoilTemperature() {
        return this.attributes.getAcCoilTemperature();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.AcCompressorTypeEnum getAcCompressorType() {
        return this.attributes.getAcCompressorType();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.AcErrorCodeBitmap getAcErrorCode() {
        return this.attributes.getAcErrorCode();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.AcLouverPositionEnum getAcLouverPosition() {
        return this.attributes.getAcLouverPosition();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.AcRefrigerantTypeEnum getAcRefrigerantType() {
        return this.attributes.getAcRefrigerantType();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.AcTypeEnum getAcType() {
        return this.attributes.getAcType();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public byte[] getActivePresetHandle() {
        return this.attributes.getActivePresetHandle();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public byte[] getActiveScheduleHandle() {
        return this.attributes.getActiveScheduleHandle();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.ControlSequenceOfOperationEnum getControlSequenceOfOperation() {
        return this.attributes.getControlSequenceOfOperation();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getEmergencyHeatDelta-7PGSa80, reason: not valid java name */
    public UByte getEmergencyHeatDelta() {
        return this.attributes.getEmergencyHeatDelta();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.Feature getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getHvacSystemTypeConfiguration-7PGSa80, reason: not valid java name */
    public UByte getHvacSystemTypeConfiguration() {
        return this.attributes.getHvacSystemTypeConfiguration();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getLocalTemperature() {
        return this.attributes.getLocalTemperature();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Byte getLocalTemperatureCalibration() {
        return this.attributes.getLocalTemperatureCalibration();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getMaxCoolSetpointLimit() {
        return this.attributes.getMaxCoolSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getMaxHeatSetpointLimit() {
        return this.attributes.getMaxHeatSetpointLimit();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getMinCoolSetpointLimit() {
        return this.attributes.getMinCoolSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getMinHeatSetpointLimit() {
        return this.attributes.getMinHeatSetpointLimit();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Byte getMinSetpointDeadBand() {
        return this.attributes.getMinSetpointDeadBand();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfDailyTransitions-7PGSa80, reason: not valid java name */
    public UByte getNumberOfDailyTransitions() {
        return this.attributes.getNumberOfDailyTransitions();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfPresets-7PGSa80, reason: not valid java name */
    public UByte getNumberOfPresets() {
        return this.attributes.getNumberOfPresets();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfScheduleTransitionPerDay-7PGSa80, reason: not valid java name */
    public UByte getNumberOfScheduleTransitionPerDay() {
        return this.attributes.getNumberOfScheduleTransitionPerDay();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfScheduleTransitions-7PGSa80, reason: not valid java name */
    public UByte getNumberOfScheduleTransitions() {
        return this.attributes.getNumberOfScheduleTransitions();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfSchedules-7PGSa80, reason: not valid java name */
    public UByte getNumberOfSchedules() {
        return this.attributes.getNumberOfSchedules();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfWeeklyTransitions-7PGSa80, reason: not valid java name */
    public UByte getNumberOfWeeklyTransitions() {
        return this.attributes.getNumberOfWeeklyTransitions();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getOccupancy-7PGSa80, reason: not valid java name */
    public UByte getOccupancy() {
        return this.attributes.getOccupancy();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getOccupiedCoolingSetpoint() {
        return this.attributes.getOccupiedCoolingSetpoint();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getOccupiedHeatingSetpoint() {
        return this.attributes.getOccupiedHeatingSetpoint();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getOccupiedSetback-7PGSa80, reason: not valid java name */
    public UByte getOccupiedSetback() {
        return this.attributes.getOccupiedSetback();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getOccupiedSetbackMax-7PGSa80, reason: not valid java name */
    public UByte getOccupiedSetbackMax() {
        return this.attributes.getOccupiedSetbackMax();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getOccupiedSetbackMin-7PGSa80, reason: not valid java name */
    public UByte getOccupiedSetbackMin() {
        return this.attributes.getOccupiedSetbackMin();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getOutdoorTemperature() {
        return this.attributes.getOutdoorTemperature();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getPiCoolingDemand-7PGSa80, reason: not valid java name */
    public UByte getPiCoolingDemand() {
        return this.attributes.getPiCoolingDemand();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getPiHeatingDemand-7PGSa80, reason: not valid java name */
    public UByte getPiHeatingDemand() {
        return this.attributes.getPiHeatingDemand();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<ThermostatTrait.PresetTypeStruct> getPresetTypes() {
        return this.attributes.getPresetTypes();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<ThermostatTrait.PresetStruct> getPresets() {
        return this.attributes.getPresets();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Boolean getPresetsSchedulesEditable() {
        return this.attributes.getPresetsSchedulesEditable();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.QueuedPresetStruct getQueuedPreset() {
        return this.attributes.getQueuedPreset();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.RemoteSensingBitmap getRemoteSensing() {
        return this.attributes.getRemoteSensing();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<ThermostatTrait.ScheduleTypeStruct> getScheduleTypes() {
        return this.attributes.getScheduleTypes();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public List<ThermostatTrait.ScheduleStruct> getSchedules() {
        return this.attributes.getSchedules();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getSetpointChangeAmount() {
        return this.attributes.getSetpointChangeAmount();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.SetpointChangeSourceEnum getSetpointChangeSource() {
        return this.attributes.getSetpointChangeSource();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getSetpointChangeSourceTimestamp-0hXNFcg, reason: not valid java name */
    public UInt getSetpointChangeSourceTimestamp() {
        return this.attributes.getSetpointChangeSourceTimestamp();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getSetpointHoldExpiryTimestamp-0hXNFcg, reason: not valid java name */
    public UInt getSetpointHoldExpiryTimestamp() {
        return this.attributes.getSetpointHoldExpiryTimestamp();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.StartOfWeekEnum getStartOfWeek() {
        return this.attributes.getStartOfWeek();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.SystemModeEnum getSystemMode() {
        return this.attributes.getSystemMode();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.TemperatureSetpointHoldEnum getTemperatureSetpointHold() {
        return this.attributes.getTemperatureSetpointHold();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getTemperatureSetpointHoldDuration-XRpZGF0, reason: not valid java name */
    public UShort getTemperatureSetpointHoldDuration() {
        return this.attributes.getTemperatureSetpointHoldDuration();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.TemperatureSetpointHoldPolicyBitmap getTemperatureSetpointHoldPolicy() {
        return this.attributes.getTemperatureSetpointHoldPolicy();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.ProgrammingOperationModeBitmap getThermostatProgrammingOperationMode() {
        return this.attributes.getThermostatProgrammingOperationMode();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.ThermostatRunningModeEnum getThermostatRunningMode() {
        return this.attributes.getThermostatRunningMode();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public ThermostatTrait.RelayStateBitmap getThermostatRunningState() {
        return this.attributes.getThermostatRunningState();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getUnoccupiedCoolingSetpoint() {
        return this.attributes.getUnoccupiedCoolingSetpoint();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    public Short getUnoccupiedHeatingSetpoint() {
        return this.attributes.getUnoccupiedHeatingSetpoint();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getUnoccupiedSetback-7PGSa80, reason: not valid java name */
    public UByte getUnoccupiedSetback() {
        return this.attributes.getUnoccupiedSetback();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getUnoccupiedSetbackMax-7PGSa80, reason: not valid java name */
    public UByte getUnoccupiedSetbackMax() {
        return this.attributes.getUnoccupiedSetbackMax();
    }

    @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
    /* JADX INFO: renamed from: getUnoccupiedSetbackMin-7PGSa80, reason: not valid java name */
    public UByte getUnoccupiedSetbackMin() {
        return this.attributes.getUnoccupiedSetbackMin();
    }

    public String toString() {
        return this.attributes.toString();
    }
}

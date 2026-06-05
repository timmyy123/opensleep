package com.google.home.google;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.HomeException;
import com.google.home.NoOpDescriptor;
import com.google.home.StructDescriptor;
import com.google.home.Type;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.home.google.ExtendedThermostatTrait;
import com.google.home.matter.serialization.Bitmap;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.ClusterBitmap;
import com.google.home.matter.serialization.ClusterEnum;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadReaderKt;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.ClusterPayloadWriterKt;
import com.google.home.matter.serialization.EnumAdapter;
import com.google.home.matter.serialization.MutableBitmap;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u000e\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "ExtendedThermostatMode", "ExtendedRunningMode", "PresetScenario", "ExtendedSetpointChangeSource", "SensorType", "AlarmType", "ExtendedThermostatFeature", "ExtendedProgrammingOperationMode", "PresetSynonyms", "Preset", "Attributes", "AttributesImpl", "MutableAttributes", "NotifySensorStateChangeCommand", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedThermostatTrait {
    public static final ExtendedThermostatTrait INSTANCE = new ExtendedThermostatTrait();
    private static final ClusterId Id = new ClusterId(1611070530, "ExtendedThermostat", null, 4, null);

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 G2\u00020\u0001:\u0001GR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u0004\u0018\u00010!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u001a\u0010&\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0010R\u0014\u0010(\u001a\u0004\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0010R\u0014\u0010.\u001a\u0004\u0018\u00010\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001fR\u0014\u00100\u001a\u0004\u0018\u000101X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0004\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010+R\u0014\u00106\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020)0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0010R\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020)0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0010R\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020)0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0010R\u0012\u0010?\u001a\u00020@X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0012\u0010C\u001a\u00020DX¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010Fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006HÀ\u0006\u0001"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "", "minHeatSafetySetpointLimit", "", "getMinHeatSafetySetpointLimit", "()Ljava/lang/Short;", "maxHeatSafetySetpointLimit", "getMaxHeatSafetySetpointLimit", "minCoolSafetySetpointLimit", "getMinCoolSafetySetpointLimit", "maxCoolSafetySetpointLimit", "getMaxCoolSafetySetpointLimit", "extendedSupportedModes", "", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "getExtendedSupportedModes", "()Ljava/util/List;", "extendedRunningMode", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "getExtendedRunningMode", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "presets", "Lcom/google/home/google/ExtendedThermostatTrait$Preset;", "getPresets", "maxSetpointHoldSeconds", "", "getMaxSetpointHoldSeconds", "()Ljava/lang/Integer;", "targetTemperatureTimestampSeconds", "", "getTargetTemperatureTimestampSeconds", "()Ljava/lang/Long;", "activePresetHandle", "", "getActivePresetHandle", "()Ljava/lang/String;", "averageLocalTemperature", "getAverageLocalTemperature", "remoteTemperatureSensorIds", "getRemoteTemperatureSensorIds", "maxSettableThermostatTemperatureSensors", "Lkotlin/UInt;", "getMaxSettableThermostatTemperatureSensors-0hXNFcg", "()Lkotlin/UInt;", "activeRemoteTemperatureSensorIds", "getActiveRemoteTemperatureSensorIds", "temperatureSetpointHoldExpiryTimestampSeconds", "getTemperatureSetpointHoldExpiryTimestampSeconds", "extendedSetpointChangeSource", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "getExtendedSetpointChangeSource", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "extendedProgrammingOperationMode", "getExtendedProgrammingOperationMode-0hXNFcg", "extendedSystemMode", "getExtendedSystemMode", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "generatedCommandList", "getGeneratedCommandList", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "getFeatureMap", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostatTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ExtendedThermostatTrait.INSTANCE.getId());
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(6), Preset.INSTANCE)));
                ArrayList arrayList = new ArrayList();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi0 = payload.getShort().mo549getOptionalNullableqim9Vi0(0, "MinHeatSafetySetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                Short orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi02 = payload.getShort().mo549getOptionalNullableqim9Vi0(1, "MaxHeatSafetySetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                Short orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi03 = payload.getShort().mo549getOptionalNullableqim9Vi0(2, "MinCoolSafetySetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                Unit unit = Unit.INSTANCE;
                Short orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi04 = payload.getShort().mo549getOptionalNullableqim9Vi0(3, "MaxCoolSafetySetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                Short orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                ExtendedThermostatMode.Companion companion = ExtendedThermostatMode.INSTANCE;
                OptionalValue optionalValueMo550getOptionalNullableListqim9Vi0 = payload.m545enum(companion.getAdapter()).mo550getOptionalNullableListqim9Vi0(4, "ExtendedSupportedModes");
                if (optionalValueMo550getOptionalNullableListqim9Vi0.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                List list = (List) optionalValueMo550getOptionalNullableListqim9Vi0.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi05 = payload.m545enum(ExtendedRunningMode.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(5, "ExtendedRunningMode");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent() && optionalValueMo549getOptionalNullableqim9Vi05.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(5));
                }
                ExtendedRunningMode extendedRunningMode = (ExtendedRunningMode) optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi02 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<Preset>() { // from class: com.google.home.google.ExtendedThermostatTrait$Attributes$Adapter$read$7
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExtendedThermostatTrait.Preset invoke() {
                        return new ExtendedThermostatTrait.Preset(null, null, 0, null, 15, null);
                    }
                }, Reflection.getOrCreateKotlinClass(Preset.class)).mo550getOptionalNullableListqim9Vi0(6, "Presets");
                if (optionalValueMo550getOptionalNullableListqim9Vi02.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(6));
                }
                List list2 = (List) optionalValueMo550getOptionalNullableListqim9Vi02.getOrNull();
                OptionalValue<Integer> optionalValueMo549getOptionalNullableqim9Vi06 = payload.getInt().mo549getOptionalNullableqim9Vi0(7, "MaxSetpointHoldSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi06.isPresent() && optionalValueMo549getOptionalNullableqim9Vi06.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(7));
                }
                Integer orNull5 = optionalValueMo549getOptionalNullableqim9Vi06.getOrNull();
                OptionalValue<Long> optionalValueMo549getOptionalNullableqim9Vi07 = payload.getLong().mo549getOptionalNullableqim9Vi0(8, "TargetTemperatureTimestampSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi07.isPresent() && optionalValueMo549getOptionalNullableqim9Vi07.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(8));
                }
                Long orNull6 = optionalValueMo549getOptionalNullableqim9Vi07.getOrNull();
                OptionalValue<String> optionalValueMo549getOptionalNullableqim9Vi08 = payload.getString().mo549getOptionalNullableqim9Vi0(9, "ActivePresetHandle");
                if (optionalValueMo549getOptionalNullableqim9Vi08.isPresent() && optionalValueMo549getOptionalNullableqim9Vi08.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(9));
                }
                String orNull7 = optionalValueMo549getOptionalNullableqim9Vi08.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi09 = payload.getShort().mo549getOptionalNullableqim9Vi0(10, "AverageLocalTemperature");
                if (optionalValueMo549getOptionalNullableqim9Vi09.isPresent() && optionalValueMo549getOptionalNullableqim9Vi09.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(10));
                }
                Short orNull8 = optionalValueMo549getOptionalNullableqim9Vi09.getOrNull();
                OptionalValue<List<String>> optionalValueMo550getOptionalNullableListqim9Vi03 = payload.getString().mo550getOptionalNullableListqim9Vi0(11, "RemoteTemperatureSensorIds");
                if (optionalValueMo550getOptionalNullableListqim9Vi03.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(11));
                }
                List<String> orNull9 = optionalValueMo550getOptionalNullableListqim9Vi03.getOrNull();
                OptionalValue<UInt> optionalValueMo549getOptionalNullableqim9Vi010 = payload.getUint().mo549getOptionalNullableqim9Vi0(12, "MaxSettableThermostatTemperatureSensors");
                if (optionalValueMo549getOptionalNullableqim9Vi010.isPresent() && optionalValueMo549getOptionalNullableqim9Vi010.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(12));
                }
                UInt orNull10 = optionalValueMo549getOptionalNullableqim9Vi010.getOrNull();
                OptionalValue<List<String>> optionalValueMo550getOptionalNullableListqim9Vi04 = payload.getString().mo550getOptionalNullableListqim9Vi0(13, "ActiveRemoteTemperatureSensorIds");
                if (optionalValueMo550getOptionalNullableListqim9Vi04.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(13));
                }
                List<String> orNull11 = optionalValueMo550getOptionalNullableListqim9Vi04.getOrNull();
                OptionalValue<Long> optionalValueMo549getOptionalNullableqim9Vi011 = payload.getLong().mo549getOptionalNullableqim9Vi0(14, "TemperatureSetpointHoldExpiryTimestampSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi011.isPresent() && optionalValueMo549getOptionalNullableqim9Vi011.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(14));
                }
                Long orNull12 = optionalValueMo549getOptionalNullableqim9Vi011.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi012 = payload.m545enum(ExtendedSetpointChangeSource.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(15, "ExtendedSetpointChangeSource");
                if (optionalValueMo549getOptionalNullableqim9Vi012.isPresent() && optionalValueMo549getOptionalNullableqim9Vi012.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(15));
                }
                ExtendedSetpointChangeSource extendedSetpointChangeSource = (ExtendedSetpointChangeSource) optionalValueMo549getOptionalNullableqim9Vi012.getOrNull();
                OptionalValue<UInt> optionalValueMo549getOptionalNullableqim9Vi013 = payload.getUint().mo549getOptionalNullableqim9Vi0(16, "ExtendedProgrammingOperationMode");
                if (optionalValueMo549getOptionalNullableqim9Vi013.isPresent() && optionalValueMo549getOptionalNullableqim9Vi013.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16));
                }
                UInt orNull13 = optionalValueMo549getOptionalNullableqim9Vi013.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi014 = payload.m545enum(companion.getAdapter()).mo549getOptionalNullableqim9Vi0(17, "ExtendedSystemMode");
                if (optionalValueMo549getOptionalNullableqim9Vi014.isPresent() && optionalValueMo549getOptionalNullableqim9Vi014.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(17));
                }
                ExtendedThermostatMode extendedThermostatMode = (ExtendedThermostatMode) optionalValueMo549getOptionalNullableqim9Vi014.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                arrayList.add(UInt.m2388boximpl(65531));
                ExtendedThermostatFeature extendedThermostatFeature = (ExtendedThermostatFeature) payload.bitmap(ExtendedThermostatFeature.INSTANCE).mo546getqim9Vi0(65532, "FeatureMap");
                arrayList.add(UInt.m2388boximpl(65532));
                UShort uShortMo546getqim9Vi0 = payload.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new AttributesImpl(orNull, orNull2, orNull3, orNull4, list, extendedRunningMode, list2, orNull5, orNull6, orNull7, orNull8, orNull9, orNull10, orNull11, orNull12, extendedSetpointChangeSource, orNull13, extendedThermostatMode, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, extendedThermostatFeature, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, ExtendedThermostatTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getShort().mo554writeqim9Vi0(0, value.getMinHeatSafetySetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getShort().mo554writeqim9Vi0(1, value.getMaxHeatSafetySetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getShort().mo554writeqim9Vi0(2, value.getMinCoolSafetySetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getShort().mo554writeqim9Vi0(3, value.getMaxCoolSafetySetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.m552enum(ExtendedThermostatMode.INSTANCE.getAdapter()).mo555writeListqim9Vi0(4, value.getExtendedSupportedModes());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(5))) {
                    writer.m552enum(ExtendedRunningMode.INSTANCE.getAdapter()).mo554writeqim9Vi0(5, value.getExtendedRunningMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(6))) {
                    writer.struct(Preset.INSTANCE).mo555writeListqim9Vi0(6, value.getPresets());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(7))) {
                    writer.getInt().mo554writeqim9Vi0(7, value.getMaxSetpointHoldSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(8))) {
                    writer.getLong().mo554writeqim9Vi0(8, value.getTargetTemperatureTimestampSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(9))) {
                    writer.getString().mo554writeqim9Vi0(9, value.getActivePresetHandle());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(10))) {
                    writer.getShort().mo554writeqim9Vi0(10, value.getAverageLocalTemperature());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(11))) {
                    writer.getString().mo555writeListqim9Vi0(11, value.getRemoteTemperatureSensorIds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(12))) {
                    writer.getUint().mo554writeqim9Vi0(12, value.getMaxSettableThermostatTemperatureSensors());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(13))) {
                    writer.getString().mo555writeListqim9Vi0(13, value.getActiveRemoteTemperatureSensorIds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(14))) {
                    writer.getLong().mo554writeqim9Vi0(14, value.getTemperatureSetpointHoldExpiryTimestampSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(15))) {
                    writer.m552enum(ExtendedSetpointChangeSource.INSTANCE.getAdapter()).mo554writeqim9Vi0(15, value.getExtendedSetpointChangeSource());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16))) {
                    writer.getUint().mo554writeqim9Vi0(16, value.getExtendedProgrammingOperationMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                    writer.m552enum(ExtendedThermostatMode.INSTANCE.getAdapter()).mo554writeqim9Vi0(17, value.getExtendedSystemMode());
                }
                writer.getUint().mo555writeListqim9Vi0(65528, value.getGeneratedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65529, value.getAcceptedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65531, value.getAttributeList());
                writer.bitmap(ExtendedThermostatFeature.INSTANCE).mo554writeqim9Vi0(65532, value.getFeatureMap());
                writer.getUshort().mo554writeqim9Vi0(65533, UShort.m2432boximpl(value.getClusterRevision()));
            }
        }

        List<UInt> getAcceptedCommandList();

        String getActivePresetHandle();

        List<String> getActiveRemoteTemperatureSensorIds();

        List<UInt> getAttributeList();

        Short getAverageLocalTemperature();

        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg */
        short getClusterRevision();

        /* JADX INFO: renamed from: getExtendedProgrammingOperationMode-0hXNFcg */
        UInt getExtendedProgrammingOperationMode();

        ExtendedRunningMode getExtendedRunningMode();

        ExtendedSetpointChangeSource getExtendedSetpointChangeSource();

        List<ExtendedThermostatMode> getExtendedSupportedModes();

        ExtendedThermostatMode getExtendedSystemMode();

        ExtendedThermostatFeature getFeatureMap();

        List<UInt> getGeneratedCommandList();

        Short getMaxCoolSafetySetpointLimit();

        Short getMaxHeatSafetySetpointLimit();

        Integer getMaxSetpointHoldSeconds();

        /* JADX INFO: renamed from: getMaxSettableThermostatTemperatureSensors-0hXNFcg */
        UInt getMaxSettableThermostatTemperatureSensors();

        Short getMinCoolSafetySetpointLimit();

        Short getMinHeatSafetySetpointLimit();

        List<Preset> getPresets();

        List<String> getRemoteTemperatureSensorIds();

        Long getTargetTemperatureTimestampSeconds();

        Long getTemperatureSetpointHoldExpiryTimestampSeconds();
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b4\b\u0016\u0018\u0000 ]2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001]B»\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\t\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\t\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\t\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0010H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0014H\u0016¢\u0006\u0004\b/\u00100R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b4\u00103R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00101\u001a\u0004\b5\u00103R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b6\u00103R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u00107\u001a\u0004\b8\u00109R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010:\u001a\u0004\b;\u0010<R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\b=\u00109R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010D\u001a\u0004\bE\u00100R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u00101\u001a\u0004\bF\u00103R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\bG\u00109R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010H\u001a\u0004\bI\u0010JR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\bK\u00109R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010A\u001a\u0004\bL\u0010CR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010H\u001a\u0004\bP\u0010JR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010Q\u001a\u0004\bR\u0010SR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u00107\u001a\u0004\bT\u00109R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\bU\u00109R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\bV\u00109R\u001a\u0010$\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010W\u001a\u0004\bX\u0010YR\u001a\u0010&\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010Z\u001a\u0004\b[\u0010\\¨\u0006^"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$AttributesImpl;", "Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "", "Lcom/google/home/google/ExtendedThermostatTrait$MutableAttributes;", "", "minHeatSafetySetpointLimit", "maxHeatSafetySetpointLimit", "minCoolSafetySetpointLimit", "maxCoolSafetySetpointLimit", "", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "extendedSupportedModes", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "extendedRunningMode", "Lcom/google/home/google/ExtendedThermostatTrait$Preset;", "presets", "", "maxSetpointHoldSeconds", "", "targetTemperatureTimestampSeconds", "", "activePresetHandle", "averageLocalTemperature", "remoteTemperatureSensorIds", "Lkotlin/UInt;", "maxSettableThermostatTemperatureSensors", "activeRemoteTemperatureSensorIds", "temperatureSetpointHoldExpiryTimestampSeconds", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "extendedSetpointChangeSource", "extendedProgrammingOperationMode", "extendedSystemMode", "generatedCommandList", "acceptedCommandList", "attributeList", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/util/List;Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Short;Ljava/util/List;Lkotlin/UInt;Ljava/util/List;Ljava/lang/Long;Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;Lkotlin/UInt;Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/Short;", "getMinHeatSafetySetpointLimit", "()Ljava/lang/Short;", "getMaxHeatSafetySetpointLimit", "getMinCoolSafetySetpointLimit", "getMaxCoolSafetySetpointLimit", "Ljava/util/List;", "getExtendedSupportedModes", "()Ljava/util/List;", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "getExtendedRunningMode", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "getPresets", "Ljava/lang/Integer;", "getMaxSetpointHoldSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Long;", "getTargetTemperatureTimestampSeconds", "()Ljava/lang/Long;", "Ljava/lang/String;", "getActivePresetHandle", "getAverageLocalTemperature", "getRemoteTemperatureSensorIds", "Lkotlin/UInt;", "getMaxSettableThermostatTemperatureSensors-0hXNFcg", "()Lkotlin/UInt;", "getActiveRemoteTemperatureSensorIds", "getTemperatureSetpointHoldExpiryTimestampSeconds", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "getExtendedSetpointChangeSource", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "getExtendedProgrammingOperationMode-0hXNFcg", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "getExtendedSystemMode", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "getGeneratedCommandList", "getAcceptedCommandList", "getAttributeList", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "getFeatureMap", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final String activePresetHandle;
        private final List<String> activeRemoteTemperatureSensorIds;
        private final List<UInt> attributeList;
        private final Short averageLocalTemperature;
        private final short clusterRevision;
        private final UInt extendedProgrammingOperationMode;
        private final ExtendedRunningMode extendedRunningMode;
        private final ExtendedSetpointChangeSource extendedSetpointChangeSource;
        private final List<ExtendedThermostatMode> extendedSupportedModes;
        private final ExtendedThermostatMode extendedSystemMode;
        private final ExtendedThermostatFeature featureMap;
        private final List<UInt> generatedCommandList;
        private final Short maxCoolSafetySetpointLimit;
        private final Short maxHeatSafetySetpointLimit;
        private final Integer maxSetpointHoldSeconds;
        private final UInt maxSettableThermostatTemperatureSensors;
        private final Short minCoolSafetySetpointLimit;
        private final Short minHeatSafetySetpointLimit;
        private final List<Preset> presets;
        private final List<String> remoteTemperatureSensorIds;
        private final Long targetTemperatureTimestampSeconds;
        private final Long temperatureSetpointHoldExpiryTimestampSeconds;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        /* JADX WARN: Multi-variable type inference failed */
        private AttributesImpl(Short sh, Short sh2, Short sh3, Short sh4, List<? extends ExtendedThermostatMode> list, ExtendedRunningMode extendedRunningMode, List<Preset> list2, Integer num, Long l, String str, Short sh5, List<String> list3, UInt uInt, List<String> list4, Long l2, ExtendedSetpointChangeSource extendedSetpointChangeSource, UInt uInt2, ExtendedThermostatMode extendedThermostatMode, List<UInt> list5, List<UInt> list6, List<UInt> list7, ExtendedThermostatFeature extendedThermostatFeature, short s) {
            list5.getClass();
            list6.getClass();
            list7.getClass();
            extendedThermostatFeature.getClass();
            this.minHeatSafetySetpointLimit = sh;
            this.maxHeatSafetySetpointLimit = sh2;
            this.minCoolSafetySetpointLimit = sh3;
            this.maxCoolSafetySetpointLimit = sh4;
            this.extendedSupportedModes = list;
            this.extendedRunningMode = extendedRunningMode;
            this.presets = list2;
            this.maxSetpointHoldSeconds = num;
            this.targetTemperatureTimestampSeconds = l;
            this.activePresetHandle = str;
            this.averageLocalTemperature = sh5;
            this.remoteTemperatureSensorIds = list3;
            this.maxSettableThermostatTemperatureSensors = uInt;
            this.activeRemoteTemperatureSensorIds = list4;
            this.temperatureSetpointHoldExpiryTimestampSeconds = l2;
            this.extendedSetpointChangeSource = extendedSetpointChangeSource;
            this.extendedProgrammingOperationMode = uInt2;
            this.extendedSystemMode = extendedThermostatMode;
            this.generatedCommandList = list5;
            this.acceptedCommandList = list6;
            this.attributeList = list7;
            this.featureMap = extendedThermostatFeature;
            this.clusterRevision = s;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Attributes)) {
                return false;
            }
            Short minHeatSafetySetpointLimit = getMinHeatSafetySetpointLimit();
            Integer numValueOf = minHeatSafetySetpointLimit != null ? Integer.valueOf(minHeatSafetySetpointLimit.shortValue()) : null;
            Attributes attributes = (Attributes) other;
            Short minHeatSafetySetpointLimit2 = attributes.getMinHeatSafetySetpointLimit();
            if (!Intrinsics.areEqual(numValueOf, minHeatSafetySetpointLimit2 != null ? Integer.valueOf(minHeatSafetySetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short maxHeatSafetySetpointLimit = getMaxHeatSafetySetpointLimit();
            Integer numValueOf2 = maxHeatSafetySetpointLimit != null ? Integer.valueOf(maxHeatSafetySetpointLimit.shortValue()) : null;
            Short maxHeatSafetySetpointLimit2 = attributes.getMaxHeatSafetySetpointLimit();
            if (!Intrinsics.areEqual(numValueOf2, maxHeatSafetySetpointLimit2 != null ? Integer.valueOf(maxHeatSafetySetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short minCoolSafetySetpointLimit = getMinCoolSafetySetpointLimit();
            Integer numValueOf3 = minCoolSafetySetpointLimit != null ? Integer.valueOf(minCoolSafetySetpointLimit.shortValue()) : null;
            Short minCoolSafetySetpointLimit2 = attributes.getMinCoolSafetySetpointLimit();
            if (!Intrinsics.areEqual(numValueOf3, minCoolSafetySetpointLimit2 != null ? Integer.valueOf(minCoolSafetySetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short maxCoolSafetySetpointLimit = getMaxCoolSafetySetpointLimit();
            Integer numValueOf4 = maxCoolSafetySetpointLimit != null ? Integer.valueOf(maxCoolSafetySetpointLimit.shortValue()) : null;
            Short maxCoolSafetySetpointLimit2 = attributes.getMaxCoolSafetySetpointLimit();
            if (!Intrinsics.areEqual(numValueOf4, maxCoolSafetySetpointLimit2 != null ? Integer.valueOf(maxCoolSafetySetpointLimit2.shortValue()) : null) || !Intrinsics.areEqual(getExtendedSupportedModes(), attributes.getExtendedSupportedModes()) || getExtendedRunningMode() != attributes.getExtendedRunningMode() || !Intrinsics.areEqual(getPresets(), attributes.getPresets()) || !Intrinsics.areEqual(getMaxSetpointHoldSeconds(), attributes.getMaxSetpointHoldSeconds()) || !Intrinsics.areEqual(getTargetTemperatureTimestampSeconds(), attributes.getTargetTemperatureTimestampSeconds()) || !Intrinsics.areEqual(getActivePresetHandle(), attributes.getActivePresetHandle())) {
                return false;
            }
            Short averageLocalTemperature = getAverageLocalTemperature();
            Integer numValueOf5 = averageLocalTemperature != null ? Integer.valueOf(averageLocalTemperature.shortValue()) : null;
            Short averageLocalTemperature2 = attributes.getAverageLocalTemperature();
            return Intrinsics.areEqual(numValueOf5, averageLocalTemperature2 != null ? Integer.valueOf(averageLocalTemperature2.shortValue()) : null) && Intrinsics.areEqual(getRemoteTemperatureSensorIds(), attributes.getRemoteTemperatureSensorIds()) && Intrinsics.areEqual(getMaxSettableThermostatTemperatureSensors(), attributes.getMaxSettableThermostatTemperatureSensors()) && Intrinsics.areEqual(getActiveRemoteTemperatureSensorIds(), attributes.getActiveRemoteTemperatureSensorIds()) && Intrinsics.areEqual(getTemperatureSetpointHoldExpiryTimestampSeconds(), attributes.getTemperatureSetpointHoldExpiryTimestampSeconds()) && getExtendedSetpointChangeSource() == attributes.getExtendedSetpointChangeSource() && Intrinsics.areEqual(getExtendedProgrammingOperationMode(), attributes.getExtendedProgrammingOperationMode()) && getExtendedSystemMode() == attributes.getExtendedSystemMode() && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && Intrinsics.areEqual(getFeatureMap(), attributes.getFeatureMap()) && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public String getActivePresetHandle() {
            return this.activePresetHandle;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<String> getActiveRemoteTemperatureSensorIds() {
            return this.activeRemoteTemperatureSensorIds;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Short getAverageLocalTemperature() {
            return this.averageLocalTemperature;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        /* JADX INFO: renamed from: getExtendedProgrammingOperationMode-0hXNFcg, reason: from getter */
        public UInt getExtendedProgrammingOperationMode() {
            return this.extendedProgrammingOperationMode;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public ExtendedRunningMode getExtendedRunningMode() {
            return this.extendedRunningMode;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public ExtendedSetpointChangeSource getExtendedSetpointChangeSource() {
            return this.extendedSetpointChangeSource;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<ExtendedThermostatMode> getExtendedSupportedModes() {
            return this.extendedSupportedModes;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public ExtendedThermostatMode getExtendedSystemMode() {
            return this.extendedSystemMode;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public ExtendedThermostatFeature getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Short getMaxCoolSafetySetpointLimit() {
            return this.maxCoolSafetySetpointLimit;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Short getMaxHeatSafetySetpointLimit() {
            return this.maxHeatSafetySetpointLimit;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Integer getMaxSetpointHoldSeconds() {
            return this.maxSetpointHoldSeconds;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        /* JADX INFO: renamed from: getMaxSettableThermostatTemperatureSensors-0hXNFcg, reason: from getter */
        public UInt getMaxSettableThermostatTemperatureSensors() {
            return this.maxSettableThermostatTemperatureSensors;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Short getMinCoolSafetySetpointLimit() {
            return this.minCoolSafetySetpointLimit;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Short getMinHeatSafetySetpointLimit() {
            return this.minHeatSafetySetpointLimit;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<Preset> getPresets() {
            return this.presets;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<String> getRemoteTemperatureSensorIds() {
            return this.remoteTemperatureSensorIds;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Long getTargetTemperatureTimestampSeconds() {
            return this.targetTemperatureTimestampSeconds;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.Attributes
        public Long getTemperatureSetpointHoldExpiryTimestampSeconds() {
            return this.temperatureSetpointHoldExpiryTimestampSeconds;
        }

        public int hashCode() {
            Short minHeatSafetySetpointLimit = getMinHeatSafetySetpointLimit();
            int iHashCode = minHeatSafetySetpointLimit != null ? minHeatSafetySetpointLimit.hashCode() : 0;
            Short maxHeatSafetySetpointLimit = getMaxHeatSafetySetpointLimit();
            int iHashCode2 = maxHeatSafetySetpointLimit != null ? maxHeatSafetySetpointLimit.hashCode() : 0;
            int i = iHashCode + 31;
            Short minCoolSafetySetpointLimit = getMinCoolSafetySetpointLimit();
            int iHashCode3 = ((((i * 31) + iHashCode2) * 31) + (minCoolSafetySetpointLimit != null ? minCoolSafetySetpointLimit.hashCode() : 0)) * 31;
            Short maxCoolSafetySetpointLimit = getMaxCoolSafetySetpointLimit();
            int iHashCode4 = (iHashCode3 + (maxCoolSafetySetpointLimit != null ? maxCoolSafetySetpointLimit.hashCode() : 0)) * 31;
            List<ExtendedThermostatMode> extendedSupportedModes = getExtendedSupportedModes();
            int iHashCode5 = (iHashCode4 + (extendedSupportedModes != null ? extendedSupportedModes.hashCode() : 0)) * 31;
            ExtendedRunningMode extendedRunningMode = getExtendedRunningMode();
            int iHashCode6 = (iHashCode5 + (extendedRunningMode != null ? extendedRunningMode.hashCode() : 0)) * 31;
            List<Preset> presets = getPresets();
            int iHashCode7 = (iHashCode6 + (presets != null ? presets.hashCode() : 0)) * 31;
            Integer maxSetpointHoldSeconds = getMaxSetpointHoldSeconds();
            int iHashCode8 = (iHashCode7 + (maxSetpointHoldSeconds != null ? maxSetpointHoldSeconds.hashCode() : 0)) * 31;
            Long targetTemperatureTimestampSeconds = getTargetTemperatureTimestampSeconds();
            int iHashCode9 = (iHashCode8 + (targetTemperatureTimestampSeconds != null ? targetTemperatureTimestampSeconds.hashCode() : 0)) * 31;
            String activePresetHandle = getActivePresetHandle();
            int iHashCode10 = (iHashCode9 + (activePresetHandle != null ? activePresetHandle.hashCode() : 0)) * 31;
            Short averageLocalTemperature = getAverageLocalTemperature();
            int iHashCode11 = (iHashCode10 + (averageLocalTemperature != null ? averageLocalTemperature.hashCode() : 0)) * 31;
            List<String> remoteTemperatureSensorIds = getRemoteTemperatureSensorIds();
            int iHashCode12 = (iHashCode11 + (remoteTemperatureSensorIds != null ? remoteTemperatureSensorIds.hashCode() : 0)) * 31;
            UInt maxSettableThermostatTemperatureSensors = getMaxSettableThermostatTemperatureSensors();
            int iM2391hashCodeimpl = (iHashCode12 + (maxSettableThermostatTemperatureSensors != null ? UInt.m2391hashCodeimpl(maxSettableThermostatTemperatureSensors.getData()) : 0)) * 31;
            List<String> activeRemoteTemperatureSensorIds = getActiveRemoteTemperatureSensorIds();
            int iHashCode13 = (iM2391hashCodeimpl + (activeRemoteTemperatureSensorIds != null ? activeRemoteTemperatureSensorIds.hashCode() : 0)) * 31;
            Long temperatureSetpointHoldExpiryTimestampSeconds = getTemperatureSetpointHoldExpiryTimestampSeconds();
            int iHashCode14 = (iHashCode13 + (temperatureSetpointHoldExpiryTimestampSeconds != null ? temperatureSetpointHoldExpiryTimestampSeconds.hashCode() : 0)) * 31;
            ExtendedSetpointChangeSource extendedSetpointChangeSource = getExtendedSetpointChangeSource();
            int iHashCode15 = (iHashCode14 + (extendedSetpointChangeSource != null ? extendedSetpointChangeSource.hashCode() : 0)) * 31;
            UInt extendedProgrammingOperationMode = getExtendedProgrammingOperationMode();
            int iM2391hashCodeimpl2 = (iHashCode15 + (extendedProgrammingOperationMode != null ? UInt.m2391hashCodeimpl(extendedProgrammingOperationMode.getData()) : 0)) * 31;
            ExtendedThermostatMode extendedSystemMode = getExtendedSystemMode();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((getFeatureMap().hashCode() + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iM2391hashCodeimpl2 + (extendedSystemMode != null ? extendedSystemMode.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            Short minHeatSafetySetpointLimit = getMinHeatSafetySetpointLimit();
            Short maxHeatSafetySetpointLimit = getMaxHeatSafetySetpointLimit();
            Short minCoolSafetySetpointLimit = getMinCoolSafetySetpointLimit();
            Short maxCoolSafetySetpointLimit = getMaxCoolSafetySetpointLimit();
            List<ExtendedThermostatMode> extendedSupportedModes = getExtendedSupportedModes();
            ExtendedRunningMode extendedRunningMode = getExtendedRunningMode();
            List<Preset> presets = getPresets();
            Integer maxSetpointHoldSeconds = getMaxSetpointHoldSeconds();
            Long targetTemperatureTimestampSeconds = getTargetTemperatureTimestampSeconds();
            String activePresetHandle = getActivePresetHandle();
            Short averageLocalTemperature = getAverageLocalTemperature();
            List<String> remoteTemperatureSensorIds = getRemoteTemperatureSensorIds();
            UInt maxSettableThermostatTemperatureSensors = getMaxSettableThermostatTemperatureSensors();
            List<String> activeRemoteTemperatureSensorIds = getActiveRemoteTemperatureSensorIds();
            Long temperatureSetpointHoldExpiryTimestampSeconds = getTemperatureSetpointHoldExpiryTimestampSeconds();
            ExtendedSetpointChangeSource extendedSetpointChangeSource = getExtendedSetpointChangeSource();
            UInt extendedProgrammingOperationMode = getExtendedProgrammingOperationMode();
            ExtendedThermostatMode extendedSystemMode = getExtendedSystemMode();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            ExtendedThermostatFeature featureMap = getFeatureMap();
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(minHeatSafetySetpointLimit).length();
            int length2 = String.valueOf(maxHeatSafetySetpointLimit).length();
            int length3 = String.valueOf(minCoolSafetySetpointLimit).length();
            int length4 = String.valueOf(maxCoolSafetySetpointLimit).length();
            int length5 = String.valueOf(extendedSupportedModes).length();
            int length6 = String.valueOf(extendedRunningMode).length();
            int length7 = String.valueOf(presets).length();
            int length8 = String.valueOf(maxSetpointHoldSeconds).length();
            int length9 = String.valueOf(targetTemperatureTimestampSeconds).length();
            int length10 = String.valueOf(activePresetHandle).length();
            int length11 = String.valueOf(averageLocalTemperature).length();
            int length12 = String.valueOf(remoteTemperatureSensorIds).length();
            int length13 = String.valueOf(maxSettableThermostatTemperatureSensors).length();
            int length14 = String.valueOf(activeRemoteTemperatureSensorIds).length();
            int length15 = String.valueOf(temperatureSetpointHoldExpiryTimestampSeconds).length();
            int length16 = length + 75 + length2 + 29 + length3 + 29 + length4 + 25 + length5 + 22 + length6 + 10 + length7 + 25 + length8 + 36 + length9 + 21 + length10 + 26 + length11 + 29 + length12 + 42 + length13 + 35 + length14 + 48 + length15 + 31 + String.valueOf(extendedSetpointChangeSource).length() + 35 + String.valueOf(extendedProgrammingOperationMode).length();
            StringBuilder sb = new StringBuilder(String.valueOf(strM2436toStringimpl).length() + length16 + 21 + String.valueOf(extendedSystemMode).length() + 23 + String.valueOf(generatedCommandList).length() + 22 + String.valueOf(acceptedCommandList).length() + 16 + String.valueOf(attributeList).length() + 13 + String.valueOf(featureMap).length() + 18 + 1);
            sb.append("ExtendedThermostat(minHeatSafetySetpointLimit=");
            sb.append(minHeatSafetySetpointLimit);
            sb.append(", maxHeatSafetySetpointLimit=");
            sb.append(maxHeatSafetySetpointLimit);
            sb.append(", minCoolSafetySetpointLimit=");
            sb.append(minCoolSafetySetpointLimit);
            sb.append(", maxCoolSafetySetpointLimit=");
            sb.append(maxCoolSafetySetpointLimit);
            sb.append(", extendedSupportedModes=");
            sb.append(extendedSupportedModes);
            sb.append(", extendedRunningMode=");
            sb.append(extendedRunningMode);
            sb.append(", presets=");
            sb.append(presets);
            sb.append(", maxSetpointHoldSeconds=");
            sb.append(maxSetpointHoldSeconds);
            sb.append(", targetTemperatureTimestampSeconds=");
            sb.append(targetTemperatureTimestampSeconds);
            sb.append(", activePresetHandle=");
            sb.append(activePresetHandle);
            sb.append(", averageLocalTemperature=");
            sb.append(averageLocalTemperature);
            sb.append(", remoteTemperatureSensorIds=");
            sb.append(remoteTemperatureSensorIds);
            sb.append(", maxSettableThermostatTemperatureSensors=");
            sb.append(maxSettableThermostatTemperatureSensors);
            sb.append(", activeRemoteTemperatureSensorIds=");
            sb.append(activeRemoteTemperatureSensorIds);
            sb.append(", temperatureSetpointHoldExpiryTimestampSeconds=");
            sb.append(temperatureSetpointHoldExpiryTimestampSeconds);
            sb.append(", extendedSetpointChangeSource=");
            sb.append(extendedSetpointChangeSource);
            sb.append(", extendedProgrammingOperationMode=");
            sb.append(extendedProgrammingOperationMode);
            sb.append(", extendedSystemMode=");
            sb.append(extendedSystemMode);
            sb.append(", generatedCommandList=");
            sb.append(generatedCommandList);
            sb.append(", acceptedCommandList=");
            sb.append(acceptedCommandList);
            sb.append(", attributeList=");
            sb.append(attributeList);
            sb.append(", featureMap=");
            sb.append(featureMap);
            return Fragment$$ExternalSyntheticOutline1.m(sb, ", clusterRevision=", strM2436toStringimpl, ")");
        }

        public /* synthetic */ AttributesImpl(Short sh, Short sh2, Short sh3, Short sh4, List list, ExtendedRunningMode extendedRunningMode, List list2, Integer num, Long l, String str, Short sh5, List list3, UInt uInt, List list4, Long l2, ExtendedSetpointChangeSource extendedSetpointChangeSource, UInt uInt2, ExtendedThermostatMode extendedThermostatMode, List list5, List list6, List list7, ExtendedThermostatFeature extendedThermostatFeature, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(sh, sh2, sh3, sh4, list, extendedRunningMode, list2, num, l, str, sh5, list3, uInt, list4, l2, extendedSetpointChangeSource, uInt2, extendedThermostatMode, list5, list6, list7, extendedThermostatFeature, s);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedProgrammingOperationMode;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "safetyOverride", "preconditioningSchedule", "preconditioningEnergyProgram", "<init>", "(ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSafetyOverride", "()Z", "getPreconditioningSchedule", "getPreconditioningEnergyProgram", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ExtendedProgrammingOperationMode extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean preconditioningEnergyProgram;
        private final boolean preconditioningSchedule;
        private final boolean safetyOverride;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostatTrait$ExtendedProgrammingOperationMode$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedProgrammingOperationMode$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedProgrammingOperationMode;", "<init>", "()V", "SAFETY_OVERRIDE_FLAG", "Lkotlin/ULong;", "J", "PRECONDITIONING_SCHEDULE_FLAG", "PRECONDITIONING_ENERGY_PROGRAM_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ExtendedProgrammingOperationMode> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ExtendedProgrammingOperationMode value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getSafetyOverride());
                mutableBitmap.m564set4PLdz1A(2L, value.getPreconditioningSchedule());
                mutableBitmap.m564set4PLdz1A(4L, value.getPreconditioningEnergyProgram());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ExtendedProgrammingOperationMode toRuntime(Bitmap value) {
                value.getClass();
                return new ExtendedProgrammingOperationMode(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ExtendedProgrammingOperationMode(boolean z, boolean z2, boolean z3) {
            super(zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ExtendedProgrammingOperationMode");
            this.safetyOverride = z;
            this.preconditioningSchedule = z2;
            this.preconditioningEnergyProgram = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExtendedProgrammingOperationMode)) {
                return false;
            }
            ExtendedProgrammingOperationMode extendedProgrammingOperationMode = (ExtendedProgrammingOperationMode) other;
            return this.safetyOverride == extendedProgrammingOperationMode.safetyOverride && this.preconditioningSchedule == extendedProgrammingOperationMode.preconditioningSchedule && this.preconditioningEnergyProgram == extendedProgrammingOperationMode.preconditioningEnergyProgram;
        }

        public final boolean getPreconditioningEnergyProgram() {
            return this.preconditioningEnergyProgram;
        }

        public final boolean getPreconditioningSchedule() {
            return this.preconditioningSchedule;
        }

        public final boolean getSafetyOverride() {
            return this.safetyOverride;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.preconditioningSchedule) + (Boolean.hashCode(this.safetyOverride) * 31);
            return Boolean.hashCode(this.preconditioningEnergyProgram) + (iHashCode * 31);
        }

        public String toString() {
            boolean z = this.safetyOverride;
            int length = String.valueOf(z).length();
            boolean z2 = this.preconditioningSchedule;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.preconditioningEnergyProgram;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 74, length2, 31, String.valueOf(z3).length()) + 1);
            zza$$ExternalSyntheticOutline0.m(sb, "ExtendedProgrammingOperationMode(safetyOverride=", z, ", preconditioningSchedule=", z2);
            sb.append(", preconditioningEnergyProgram=");
            sb.append(z3);
            sb.append(")");
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "presets", "remoteTemperatureSensing", "<init>", "(ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPresets", "()Z", "getRemoteTemperatureSensing", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ExtendedThermostatFeature extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean presets;
        private final boolean remoteTemperatureSensing;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostatTrait$ExtendedThermostatFeature$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatFeature;", "<init>", "()V", "PRESETS_FLAG", "Lkotlin/ULong;", "J", "REMOTE_TEMPERATURE_SENSING_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ExtendedThermostatFeature> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ExtendedThermostatFeature value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getPresets());
                mutableBitmap.m564set4PLdz1A(2L, value.getRemoteTemperatureSensing());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ExtendedThermostatFeature toRuntime(Bitmap value) {
                value.getClass();
                return new ExtendedThermostatFeature(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ExtendedThermostatFeature(boolean z, boolean z2) {
            super(zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ExtendedThermostatFeature");
            this.presets = z;
            this.remoteTemperatureSensing = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExtendedThermostatFeature)) {
                return false;
            }
            ExtendedThermostatFeature extendedThermostatFeature = (ExtendedThermostatFeature) other;
            return this.presets == extendedThermostatFeature.presets && this.remoteTemperatureSensing == extendedThermostatFeature.remoteTemperatureSensing;
        }

        public final boolean getPresets() {
            return this.presets;
        }

        public final boolean getRemoteTemperatureSensing() {
            return this.remoteTemperatureSensing;
        }

        public int hashCode() {
            return Boolean.hashCode(this.remoteTemperatureSensing) + (Boolean.hashCode(this.presets) * 31);
        }

        public String toString() {
            return zzq.zza(this.remoteTemperatureSensing, this.presets, (byte) 61, "ExtendedThermostatFeature(presets=", ", remoteTemperatureSensing=");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u001c\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u0016\u0010&\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001e¨\u0006("}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$MutableAttributes;", "Lcom/google/home/google/ExtendedThermostatTrait$AttributesImpl;", "Lcom/google/home/google/ExtendedThermostatTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/google/ExtendedThermostatTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "_activePresetHandle", "Ljava/lang/String;", "get_activePresetHandle$home_platform_traits_google_common_clusters_android", "set_activePresetHandle$home_platform_traits_google_common_clusters_android", "(Ljava/lang/String;)V", "", "_activeRemoteTemperatureSensorIds", "Ljava/util/List;", "get_activeRemoteTemperatureSensorIds$home_platform_traits_google_common_clusters_android", "()Ljava/util/List;", "set_activeRemoteTemperatureSensorIds$home_platform_traits_google_common_clusters_android", "(Ljava/util/List;)V", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "_extendedSystemMode", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "get_extendedSystemMode$home_platform_traits_google_common_clusters_android", "()Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "set_extendedSystemMode$home_platform_traits_google_common_clusters_android", "(Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;)V", "getActivePresetHandle", "activePresetHandle", "getActiveRemoteTemperatureSensorIds", "activeRemoteTemperatureSensorIds", "getExtendedSystemMode", "extendedSystemMode", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends AttributesImpl {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String _activePresetHandle;
        private List<String> _activeRemoteTemperatureSensorIds;
        private ExtendedThermostatMode _extendedSystemMode;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostatTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<MutableAttributes> {
            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public MutableAttributes read(ClusterPayloadReader reader) {
                reader.getClass();
                return new MutableAttributes(Attributes.INSTANCE.read(reader));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, MutableAttributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, ExtendedThermostatTrait.INSTANCE.getId());
                if (value.get_activePresetHandle() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(9))) {
                        throw HomeException.INSTANCE.invalidArgument("activePresetHandle");
                    }
                    writer.getString().mo554writeqim9Vi0(9, value.get_activePresetHandle());
                }
                if (value.get_activeRemoteTemperatureSensorIds$home_platform_traits_google_common_clusters_android() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(13))) {
                        throw HomeException.INSTANCE.invalidArgument("activeRemoteTemperatureSensorIds");
                    }
                    writer.getString().mo555writeListqim9Vi0(13, value.get_activeRemoteTemperatureSensorIds$home_platform_traits_google_common_clusters_android());
                }
                if (value.get_extendedSystemMode() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                        throw HomeException.INSTANCE.invalidArgument("extendedSystemMode");
                    }
                    writer.m552enum(ExtendedThermostatMode.INSTANCE.getAdapter()).mo554writeqim9Vi0(17, value.get_extendedSystemMode());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getMinHeatSafetySetpointLimit(), attributes.getMaxHeatSafetySetpointLimit(), attributes.getMinCoolSafetySetpointLimit(), attributes.getMaxCoolSafetySetpointLimit(), attributes.getExtendedSupportedModes(), attributes.getExtendedRunningMode(), attributes.getPresets(), attributes.getMaxSetpointHoldSeconds(), attributes.getTargetTemperatureTimestampSeconds(), attributes.getActivePresetHandle(), attributes.getAverageLocalTemperature(), attributes.getRemoteTemperatureSensorIds(), attributes.getMaxSettableThermostatTemperatureSensors(), attributes.getActiveRemoteTemperatureSensorIds(), attributes.getTemperatureSetpointHoldExpiryTimestampSeconds(), attributes.getExtendedSetpointChangeSource(), attributes.getExtendedProgrammingOperationMode(), attributes.getExtendedSystemMode(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.AttributesImpl
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.AttributesImpl, com.google.home.google.ExtendedThermostatTrait.Attributes
        public String getActivePresetHandle() {
            String str = this._activePresetHandle;
            return str == null ? super.getActivePresetHandle() : str;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.AttributesImpl, com.google.home.google.ExtendedThermostatTrait.Attributes
        public List<String> getActiveRemoteTemperatureSensorIds() {
            List<String> list = this._activeRemoteTemperatureSensorIds;
            return list == null ? super.getActiveRemoteTemperatureSensorIds() : list;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.AttributesImpl, com.google.home.google.ExtendedThermostatTrait.Attributes
        public ExtendedThermostatMode getExtendedSystemMode() {
            ExtendedThermostatMode extendedThermostatMode = this._extendedSystemMode;
            return extendedThermostatMode == null ? super.getExtendedSystemMode() : extendedThermostatMode;
        }

        /* JADX INFO: renamed from: get_activePresetHandle$home_platform_traits_google_common_clusters_android, reason: from getter */
        public final String get_activePresetHandle() {
            return this._activePresetHandle;
        }

        public final List<String> get_activeRemoteTemperatureSensorIds$home_platform_traits_google_common_clusters_android() {
            return this._activeRemoteTemperatureSensorIds;
        }

        /* JADX INFO: renamed from: get_extendedSystemMode$home_platform_traits_google_common_clusters_android, reason: from getter */
        public final ExtendedThermostatMode get_extendedSystemMode() {
            return this._extendedSystemMode;
        }

        @Override // com.google.home.google.ExtendedThermostatTrait.AttributesImpl
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 38), "ExtendedThermostat.MutableAttributes(", string, ")");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$NotifySensorStateChangeCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NotifySensorStateChangeCommand implements CommandDescriptor {
        public static final NotifySensorStateChangeCommand INSTANCE = new NotifySensorStateChangeCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedThermostatTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private NotifySensorStateChangeCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields extendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields : ExtendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields.values()) {
                if (extendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields extendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields : ExtendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields.name(), name)) {
                    return extendedThermostatTrait$NotifySensorStateChangeCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private ExtendedThermostatTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms;", "", "language", "", "synonyms", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLanguage", "()Ljava/lang/String;", "getSynonyms", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PresetSynonyms {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final List<String> synonyms;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostatTrait$PresetSynonyms$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<PresetSynonyms>, StructDescriptor {
            private Companion() {
            }

            @Override // com.google.home.StructDescriptor
            /* JADX INFO: renamed from: getFieldById-WZ4Q5Ns */
            public Field mo448getFieldByIdWZ4Q5Ns(int tagId) {
                for (StructFields structFields : StructFields.values()) {
                    if (structFields.getTag() == tagId) {
                        return structFields;
                    }
                }
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public PresetSynonyms read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new PresetSynonyms(payload$default.getString().mo546getqim9Vi0(0, "Language"), payload$default.getString().mo547getListqim9Vi0(1, "Synonyms"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, PresetSynonyms value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getLanguage());
                writer.getString().mo555writeListqim9Vi0(1, value.getSynonyms());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "language", "synonyms", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields language;
            public static final StructFields synonyms;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{language, synonyms};
            }

            static {
                Type type = Type.String;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                language = new StructFields("language", 0, 0, "String", type, noOpDescriptor, false);
                synonyms = new StructFields("synonyms", 1, 1, "String", type, noOpDescriptor, false);
                StructFields[] structFieldsArr$values = $values();
                $VALUES = structFieldsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(structFieldsArr$values);
            }

            private StructFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
                this.tag = i2;
                this.typeName = str2;
                this.typeEnum = type;
                this.descriptor = descriptor;
                this.isNullable = z;
            }

            public static StructFields valueOf(String str) {
                return (StructFields) Enum.valueOf(StructFields.class, str);
            }

            public static StructFields[] values() {
                return (StructFields[]) $VALUES.clone();
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

        public /* synthetic */ PresetSynonyms(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresetSynonyms)) {
                return false;
            }
            PresetSynonyms presetSynonyms = (PresetSynonyms) other;
            return Intrinsics.areEqual(this.language, presetSynonyms.language) && Intrinsics.areEqual(this.synonyms, presetSynonyms.synonyms);
        }

        public final String getLanguage() {
            return this.language;
        }

        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        public int hashCode() {
            int iHashCode = this.language.hashCode() + 31;
            return this.synonyms.hashCode() + (iHashCode * 31);
        }

        public String toString() {
            return zzl.zza(this.synonyms, this.language, (byte) 35, "PresetSynonyms(language=", ", synonyms=");
        }

        public PresetSynonyms(String str, List<String> list) {
            str.getClass();
            list.getClass();
            this.language = str;
            this.synonyms = list;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$Preset;", "", "presetHandle", "", "presetScenario", "Lcom/google/home/google/ExtendedThermostatTrait$PresetScenario;", "presetMaxHoldSeconds", "", "names", "", "Lcom/google/home/google/ExtendedThermostatTrait$PresetSynonyms;", "<init>", "(Ljava/lang/String;Lcom/google/home/google/ExtendedThermostatTrait$PresetScenario;ILjava/util/List;)V", "getPresetHandle", "()Ljava/lang/String;", "getPresetScenario", "()Lcom/google/home/google/ExtendedThermostatTrait$PresetScenario;", "getPresetMaxHoldSeconds", "()I", "getNames", "()Ljava/util/List;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Preset {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<PresetSynonyms> names;
        private final String presetHandle;
        private final int presetMaxHoldSeconds;
        private final PresetScenario presetScenario;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedThermostatTrait$Preset$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$Preset$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$Preset;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedThermostatTrait$Preset;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedThermostatTrait$Preset;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Preset>, StructDescriptor {
            private Companion() {
            }

            @Override // com.google.home.StructDescriptor
            /* JADX INFO: renamed from: getFieldById-WZ4Q5Ns */
            public Field mo448getFieldByIdWZ4Q5Ns(int tagId) {
                for (StructFields structFields : StructFields.values()) {
                    if (structFields.getTag() == tagId) {
                        return structFields;
                    }
                }
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Preset read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(3), PresetSynonyms.INSTANCE)));
                return new Preset(payload.getString().mo546getqim9Vi0(0, "PresetHandle"), (PresetScenario) payload.m545enum(PresetScenario.INSTANCE.getAdapter()).mo546getqim9Vi0(1, "PresetScenario"), payload.getInt().mo546getqim9Vi0(2, "PresetMaxHoldSeconds").intValue(), new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<PresetSynonyms>() { // from class: com.google.home.google.ExtendedThermostatTrait$Preset$Adapter$read$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExtendedThermostatTrait.PresetSynonyms invoke() {
                        return new ExtendedThermostatTrait.PresetSynonyms(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                }, Reflection.getOrCreateKotlinClass(PresetSynonyms.class)).mo547getListqim9Vi0(3, "Names"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Preset value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getPresetHandle());
                writer.m552enum(PresetScenario.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.getPresetScenario());
                writer.getInt().mo554writeqim9Vi0(2, Integer.valueOf(value.getPresetMaxHoldSeconds()));
                writer.struct(PresetSynonyms.INSTANCE).mo555writeListqim9Vi0(3, value.getNames());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$Preset$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "presetHandle", "presetScenario", "presetMaxHoldSeconds", "names", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields names;
            public static final StructFields presetHandle;
            public static final StructFields presetMaxHoldSeconds;
            public static final StructFields presetScenario;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{presetHandle, presetScenario, presetMaxHoldSeconds, names};
            }

            static {
                Type type = Type.String;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                presetHandle = new StructFields("presetHandle", 0, 0, "String", type, noOpDescriptor, false);
                presetScenario = new StructFields("presetScenario", 1, 1, "PresetScenario", Type.Enum, noOpDescriptor, false);
                presetMaxHoldSeconds = new StructFields("presetMaxHoldSeconds", 2, 2, "Int", Type.Int, noOpDescriptor, false);
                names = new StructFields("names", 3, 3, "PresetSynonyms", Type.Struct, PresetSynonyms.INSTANCE, false);
                StructFields[] structFieldsArr$values = $values();
                $VALUES = structFieldsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(structFieldsArr$values);
            }

            private StructFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
                this.tag = i2;
                this.typeName = str2;
                this.typeEnum = type;
                this.descriptor = descriptor;
                this.isNullable = z;
            }

            public static StructFields valueOf(String str) {
                return (StructFields) Enum.valueOf(StructFields.class, str);
            }

            public static StructFields[] values() {
                return (StructFields[]) $VALUES.clone();
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

        public /* synthetic */ Preset(String str, PresetScenario presetScenario, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i2 & 1) ? "" : str, (i2 & 2) != 0 ? PresetScenario.Unspecified : presetScenario, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Preset)) {
                return false;
            }
            Preset preset = (Preset) other;
            return Intrinsics.areEqual(this.presetHandle, preset.presetHandle) && this.presetScenario == preset.presetScenario && this.presetMaxHoldSeconds == preset.presetMaxHoldSeconds && Intrinsics.areEqual(this.names, preset.names);
        }

        public final List<PresetSynonyms> getNames() {
            return this.names;
        }

        public final String getPresetHandle() {
            return this.presetHandle;
        }

        public final int getPresetMaxHoldSeconds() {
            return this.presetMaxHoldSeconds;
        }

        public final PresetScenario getPresetScenario() {
            return this.presetScenario;
        }

        public int hashCode() {
            int iHashCode = this.presetHandle.hashCode() + 31;
            int iHashCode2 = this.presetScenario.hashCode() + (iHashCode * 31);
            int iHashCode3 = Integer.hashCode(this.presetMaxHoldSeconds);
            return this.names.hashCode() + ((iHashCode3 + (iHashCode2 * 31)) * 31);
        }

        public String toString() {
            String str = this.presetHandle;
            int length = String.valueOf(str).length();
            PresetScenario presetScenario = this.presetScenario;
            int length2 = String.valueOf(presetScenario).length();
            int i = this.presetMaxHoldSeconds;
            int length3 = String.valueOf(i).length();
            List<PresetSynonyms> list = this.names;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 37, length2, 23, length3, 8, String.valueOf(list).length()) + 1);
            sb.append("Preset(presetHandle=");
            sb.append(str);
            sb.append(", presetScenario=");
            sb.append(presetScenario);
            sb.append(", presetMaxHoldSeconds=");
            sb.append(i);
            sb.append(", names=");
            sb.append(list);
            sb.append(")");
            return sb.toString();
        }

        public Preset(String str, PresetScenario presetScenario, int i, List<PresetSynonyms> list) {
            str.getClass();
            presetScenario.getClass();
            list.getClass();
            this.presetHandle = str;
            this.presetScenario = presetScenario;
            this.presetMaxHoldSeconds = i;
            this.names = list;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$AlarmType;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "Ok", "Warning", "Critical", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AlarmType implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AlarmType[] $VALUES;
        private static final EnumAdapter<AlarmType> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AlarmType Critical;
        public static final AlarmType Ok;
        public static final AlarmType UnknownValue;
        public static final AlarmType Unspecified;
        public static final AlarmType Warning;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$AlarmType$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$AlarmType;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<AlarmType> getAdapter() {
                return AlarmType.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ AlarmType[] $values() {
            return new AlarmType[]{Unspecified, Ok, Warning, Critical, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new AlarmType("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            Ok = new AlarmType("Ok", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Warning = new AlarmType("Warning", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Critical = new AlarmType("Critical", 3, 3L, str3, str4, 6, null);
            UnknownValue = new AlarmType("UnknownValue", 4, -1L, str4, null, 6, null);
            AlarmType[] alarmTypeArr$values = $values();
            $VALUES = alarmTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(alarmTypeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ AlarmType(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "AlarmType" : str3);
        }

        public static AlarmType valueOf(String str) {
            return (AlarmType) Enum.valueOf(AlarmType.class, str);
        }

        public static AlarmType[] values() {
            return (AlarmType[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private AlarmType(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001aB%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Standard", "Off", "FanOnly", "Purifier", "Dry", "Auto", "On", "HeatCool", "Eco", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExtendedRunningMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ExtendedRunningMode[] $VALUES;
        private static final EnumAdapter<ExtendedRunningMode> Adapter;
        public static final ExtendedRunningMode Auto;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ExtendedRunningMode Dry;
        public static final ExtendedRunningMode Eco;
        public static final ExtendedRunningMode FanOnly;
        public static final ExtendedRunningMode HeatCool;
        public static final ExtendedRunningMode Off;
        public static final ExtendedRunningMode On;
        public static final ExtendedRunningMode Purifier;
        public static final ExtendedRunningMode Standard;
        public static final ExtendedRunningMode UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedRunningMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ExtendedRunningMode> getAdapter() {
                return ExtendedRunningMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ExtendedRunningMode[] $values() {
            return new ExtendedRunningMode[]{Standard, Off, FanOnly, Purifier, Dry, Auto, On, HeatCool, Eco, UnknownValue};
        }

        static {
            String str = null;
            Standard = new ExtendedRunningMode("Standard", 0, 0L, null, str, 6, null);
            String str2 = null;
            Off = new ExtendedRunningMode("Off", 1, 1L, str, str2, 6, null);
            String str3 = null;
            FanOnly = new ExtendedRunningMode("FanOnly", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Purifier = new ExtendedRunningMode("Purifier", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Dry = new ExtendedRunningMode("Dry", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            Auto = new ExtendedRunningMode("Auto", 5, 5L, str5, str6, 6, null);
            String str7 = null;
            On = new ExtendedRunningMode("On", 6, 6L, str6, str7, 6, null);
            String str8 = null;
            HeatCool = new ExtendedRunningMode("HeatCool", 7, 7L, str7, str8, 6, null);
            String str9 = null;
            Eco = new ExtendedRunningMode("Eco", 8, 8L, str8, str9, 6, null);
            UnknownValue = new ExtendedRunningMode("UnknownValue", 9, -1L, str9, null, 6, null);
            ExtendedRunningMode[] extendedRunningModeArr$values = $values();
            $VALUES = extendedRunningModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(extendedRunningModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ExtendedRunningMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ExtendedRunningMode" : str3);
        }

        public static ExtendedRunningMode valueOf(String str) {
            return (ExtendedRunningMode) Enum.valueOf(ExtendedRunningMode.class, str);
        }

        public static ExtendedRunningMode[] values() {
            return (ExtendedRunningMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private ExtendedRunningMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "EnergyProgram", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExtendedSetpointChangeSource implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ExtendedSetpointChangeSource[] $VALUES;
        private static final EnumAdapter<ExtendedSetpointChangeSource> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ExtendedSetpointChangeSource EnergyProgram;
        public static final ExtendedSetpointChangeSource UnknownValue;
        public static final ExtendedSetpointChangeSource Unspecified;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedSetpointChangeSource;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ExtendedSetpointChangeSource> getAdapter() {
                return ExtendedSetpointChangeSource.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ExtendedSetpointChangeSource[] $values() {
            return new ExtendedSetpointChangeSource[]{Unspecified, EnergyProgram, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new ExtendedSetpointChangeSource("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            EnergyProgram = new ExtendedSetpointChangeSource("EnergyProgram", 1, 1L, str, str2, 6, null);
            UnknownValue = new ExtendedSetpointChangeSource("UnknownValue", 2, -1L, str2, null, 6, null);
            ExtendedSetpointChangeSource[] extendedSetpointChangeSourceArr$values = $values();
            $VALUES = extendedSetpointChangeSourceArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(extendedSetpointChangeSourceArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ExtendedSetpointChangeSource(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ExtendedSetpointChangeSource" : str3);
        }

        public static ExtendedSetpointChangeSource valueOf(String str) {
            return (ExtendedSetpointChangeSource) Enum.valueOf(ExtendedSetpointChangeSource.class, str);
        }

        public static ExtendedSetpointChangeSource[] values() {
            return (ExtendedSetpointChangeSource[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private ExtendedSetpointChangeSource(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Standard", "On", "Purifier", "Eco", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExtendedThermostatMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ExtendedThermostatMode[] $VALUES;
        private static final EnumAdapter<ExtendedThermostatMode> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ExtendedThermostatMode Eco;
        public static final ExtendedThermostatMode On;
        public static final ExtendedThermostatMode Purifier;
        public static final ExtendedThermostatMode Standard;
        public static final ExtendedThermostatMode UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$ExtendedThermostatMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ExtendedThermostatMode> getAdapter() {
                return ExtendedThermostatMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ExtendedThermostatMode[] $values() {
            return new ExtendedThermostatMode[]{Standard, On, Purifier, Eco, UnknownValue};
        }

        static {
            String str = null;
            Standard = new ExtendedThermostatMode("Standard", 0, 0L, null, str, 6, null);
            String str2 = null;
            On = new ExtendedThermostatMode("On", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Purifier = new ExtendedThermostatMode("Purifier", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Eco = new ExtendedThermostatMode("Eco", 3, 3L, str3, str4, 6, null);
            UnknownValue = new ExtendedThermostatMode("UnknownValue", 4, -1L, str4, null, 6, null);
            ExtendedThermostatMode[] extendedThermostatModeArr$values = $values();
            $VALUES = extendedThermostatModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(extendedThermostatModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ExtendedThermostatMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ExtendedThermostatMode" : str3);
        }

        public static ExtendedThermostatMode valueOf(String str) {
            return (ExtendedThermostatMode) Enum.valueOf(ExtendedThermostatMode.class, str);
        }

        public static ExtendedThermostatMode[] values() {
            return (ExtendedThermostatMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private ExtendedThermostatMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001cB%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$PresetScenario;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "Comfort", "Eco", "Sleep", "Wake", "Home", "Away", "Occupied", "Unoccupied", "Vacation", "UserDefined", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PresetScenario implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PresetScenario[] $VALUES;
        private static final EnumAdapter<PresetScenario> Adapter;
        public static final PresetScenario Away;
        public static final PresetScenario Comfort;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final PresetScenario Eco;
        public static final PresetScenario Home;
        public static final PresetScenario Occupied;
        public static final PresetScenario Sleep;
        public static final PresetScenario UnknownValue;
        public static final PresetScenario Unoccupied;
        public static final PresetScenario Unspecified;
        public static final PresetScenario UserDefined;
        public static final PresetScenario Vacation;
        public static final PresetScenario Wake;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$PresetScenario$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$PresetScenario;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<PresetScenario> getAdapter() {
                return PresetScenario.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ PresetScenario[] $values() {
            return new PresetScenario[]{Unspecified, Comfort, Eco, Sleep, Wake, Home, Away, Occupied, Unoccupied, Vacation, UserDefined, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new PresetScenario("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            Comfort = new PresetScenario("Comfort", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Eco = new PresetScenario("Eco", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Sleep = new PresetScenario("Sleep", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Wake = new PresetScenario("Wake", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            Home = new PresetScenario("Home", 5, 5L, str5, str6, 6, null);
            String str7 = null;
            Away = new PresetScenario("Away", 6, 6L, str6, str7, 6, null);
            String str8 = null;
            Occupied = new PresetScenario("Occupied", 7, 7L, str7, str8, 6, null);
            String str9 = null;
            Unoccupied = new PresetScenario("Unoccupied", 8, 8L, str8, str9, 6, null);
            Vacation = new PresetScenario("Vacation", 9, 9L, str9, null, 6, null);
            String str10 = null;
            UserDefined = new PresetScenario("UserDefined", 10, 10L, null, str10, 6, null);
            UnknownValue = new PresetScenario("UnknownValue", 11, -1L, str10, null, 6, null);
            PresetScenario[] presetScenarioArr$values = $values();
            $VALUES = presetScenarioArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(presetScenarioArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ PresetScenario(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "PresetScenario" : str3);
        }

        public static PresetScenario valueOf(String str) {
            return (PresetScenario) Enum.valueOf(PresetScenario.class, str);
        }

        public static PresetScenario[] values() {
            return (PresetScenario[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private PresetScenario(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$SensorType;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "Smoke", "CarbonMonoxide", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SensorType implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SensorType[] $VALUES;
        private static final EnumAdapter<SensorType> Adapter;
        public static final SensorType CarbonMonoxide;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SensorType Smoke;
        public static final SensorType UnknownValue;
        public static final SensorType Unspecified;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedThermostatTrait$SensorType$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedThermostatTrait$SensorType;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SensorType> getAdapter() {
                return SensorType.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SensorType[] $values() {
            return new SensorType[]{Unspecified, Smoke, CarbonMonoxide, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new SensorType("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            Smoke = new SensorType("Smoke", 1, 1L, str, str2, 6, null);
            String str3 = null;
            CarbonMonoxide = new SensorType("CarbonMonoxide", 2, 3L, str2, str3, 6, null);
            UnknownValue = new SensorType("UnknownValue", 3, -1L, str3, null, 6, null);
            SensorType[] sensorTypeArr$values = $values();
            $VALUES = sensorTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sensorTypeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SensorType(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070530, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SensorType" : str3);
        }

        public static SensorType valueOf(String str) {
            return (SensorType) Enum.valueOf(SensorType.class, str);
        }

        public static SensorType[] values() {
            return (SensorType[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private SensorType(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}

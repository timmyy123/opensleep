package com.google.home.matter.standard;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.CommandDescriptor;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.HomeException;
import com.google.home.NoOpDescriptor;
import com.google.home.StructDescriptor;
import com.google.home.Type;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
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
import com.google.home.matter.standard.ThermostatTrait;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UByte;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\bÆ\u0002\u0018\u00002\u00020\u0001:-\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01234B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00065"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "AcCapacityFormatEnum", "AcCompressorTypeEnum", "AcLouverPositionEnum", "AcRefrigerantTypeEnum", "AcTypeEnum", "ControlSequenceOfOperationEnum", "PresetScenarioEnum", "SetpointChangeSourceEnum", "SetpointRaiseLowerModeEnum", "StartOfWeekEnum", "SystemModeEnum", "TemperatureSetpointHoldEnum", "ThermostatRunningModeEnum", "AcErrorCodeBitmap", "Feature", "HvacSystemTypeBitmap", "PresetTypeFeaturesBitmap", "ProgrammingOperationModeBitmap", "RelayStateBitmap", "RemoteSensingBitmap", "ScheduleDayOfWeekBitmap", "ScheduleModeBitmap", "ScheduleTypeFeaturesBitmap", "TemperatureSetpointHoldPolicyBitmap", "ScheduleTransitionStruct", "ScheduleStruct", "PresetStruct", "PresetTypeStruct", "QueuedPresetStruct", "ScheduleTypeStruct", "WeeklyScheduleTransitionStruct", "Attributes", "AttributesImpl", "MutableAttributes", "SetpointRaiseLowerCommand", "SetWeeklyScheduleCommand", "GetWeeklyScheduleCommand", "ClearWeeklyScheduleCommand", "SetActiveScheduleRequestCommand", "SetActivePresetRequestCommand", "StartPresetsSchedulesEditRequestCommand", "CancelPresetsSchedulesEditRequestCommand", "CommitPresetsSchedulesRequestCommand", "CancelSetActivePresetRequestCommand", "SetTemperatureSetpointHoldPolicyCommand", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThermostatTrait {
    public static final ThermostatTrait INSTANCE = new ThermostatTrait();
    private static final ClusterId Id = new ClusterId(513, "Thermostat", null, 4, null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "compressorFail", "roomSensorFail", "outdoorSensorFail", "coilSensorFail", "fanFail", "<init>", "(ZZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCompressorFail", "()Z", "getRoomSensorFail", "getOutdoorSensorFail", "getCoilSensorFail", "getFanFail", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AcErrorCodeBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean coilSensorFail;
        private final boolean compressorFail;
        private final boolean fanFail;
        private final boolean outdoorSensorFail;
        private final boolean roomSensorFail;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$AcErrorCodeBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "<init>", "()V", "COMPRESSOR_FAIL_FLAG", "Lkotlin/ULong;", "J", "ROOM_SENSOR_FAIL_FLAG", "OUTDOOR_SENSOR_FAIL_FLAG", "COIL_SENSOR_FAIL_FLAG", "FAN_FAIL_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<AcErrorCodeBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(AcErrorCodeBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getCompressorFail());
                mutableBitmap.m564set4PLdz1A(2L, value.getRoomSensorFail());
                mutableBitmap.m564set4PLdz1A(4L, value.getOutdoorSensorFail());
                mutableBitmap.m564set4PLdz1A(8L, value.getCoilSensorFail());
                mutableBitmap.m564set4PLdz1A(16L, value.getFanFail());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public AcErrorCodeBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new AcErrorCodeBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L), value.m525getVKZWuLQ(16L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AcErrorCodeBitmap(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "AcErrorCodeBitmap");
            this.compressorFail = z;
            this.roomSensorFail = z2;
            this.outdoorSensorFail = z3;
            this.coilSensorFail = z4;
            this.fanFail = z5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AcErrorCodeBitmap)) {
                return false;
            }
            AcErrorCodeBitmap acErrorCodeBitmap = (AcErrorCodeBitmap) other;
            return this.compressorFail == acErrorCodeBitmap.compressorFail && this.roomSensorFail == acErrorCodeBitmap.roomSensorFail && this.outdoorSensorFail == acErrorCodeBitmap.outdoorSensorFail && this.coilSensorFail == acErrorCodeBitmap.coilSensorFail && this.fanFail == acErrorCodeBitmap.fanFail;
        }

        public final boolean getCoilSensorFail() {
            return this.coilSensorFail;
        }

        public final boolean getCompressorFail() {
            return this.compressorFail;
        }

        public final boolean getFanFail() {
            return this.fanFail;
        }

        public final boolean getOutdoorSensorFail() {
            return this.outdoorSensorFail;
        }

        public final boolean getRoomSensorFail() {
            return this.roomSensorFail;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.roomSensorFail) + (Boolean.hashCode(this.compressorFail) * 31);
            int iHashCode2 = Boolean.hashCode(this.outdoorSensorFail) + (iHashCode * 31);
            int iHashCode3 = Boolean.hashCode(this.coilSensorFail);
            return Boolean.hashCode(this.fanFail) + ((iHashCode3 + (iHashCode2 * 31)) * 31);
        }

        public String toString() {
            boolean z = this.compressorFail;
            int length = String.valueOf(z).length();
            boolean z2 = this.roomSensorFail;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.outdoorSensorFail;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.coilSensorFail;
            int length4 = String.valueOf(z4).length();
            boolean z5 = this.fanFail;
            return zzp.zza(new StringBuilder(length + 50 + length2 + 20 + length3 + 17 + length4 + 10 + String.valueOf(z5).length() + 1), z5, z4, z3, z2, z, "AcErrorCodeBitmap(compressorFail=", ", roomSensorFail=", ", outdoorSensorFail=", ", coilSensorFail=", ", fanFail=");
        }
    }

    @Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0005\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 Ã\u00012\u00020\u0001:\u0002Ã\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0014\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0014\u0010$\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0014\u0010&\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u0014\u0010(\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0014\u0010*\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0014\u0010,\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005R\u0014\u0010.\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001dR\u0014\u00100\u001a\u0004\u0018\u000101X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0004\u0018\u000105X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0004\u0018\u000109X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u0004\u0018\u00010=X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u0004\u0018\u00010AX¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000bR\u0014\u0010F\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u000bR\u0014\u0010H\u001a\u0004\u0018\u00010IX¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u0004\u0018\u00010MX¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u0004\u0018\u00010QX¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u0004\u0018\u00010UX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u0004\u0018\u00010YX¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u0005R\u0014\u0010^\u001a\u0004\u0018\u00010_X¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u000bR\u0014\u0010d\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u000bR\u0014\u0010f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u000bR\u0014\u0010h\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010\u000bR\u0014\u0010j\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u000bR\u0014\u0010l\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010\u000bR\u0014\u0010n\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u000bR\u0014\u0010p\u001a\u0004\u0018\u00010qX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0014\u0010t\u001a\u0004\u0018\u00010MX¦\u0004¢\u0006\u0006\u001a\u0004\bu\u0010OR\u0014\u0010v\u001a\u0004\u0018\u00010wX¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0014\u0010z\u001a\u0004\u0018\u00010{X¦\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0016\u0010~\u001a\u0004\u0018\u00010\u007fX¦\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u0005R\u0018\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001f\u0010\u008c\u0001\u001a\f\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001f\u0010\u0091\u0001\u001a\f\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0090\u0001R\u0016\u0010\u0094\u0001\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\u000bR\u0016\u0010\u0096\u0001\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u000bR\u0016\u0010\u0098\u0001\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010\u000bR\u0016\u0010\u009a\u0001\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010\u000bR\u0018\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010\u009f\u0001R\u001f\u0010¢\u0001\u001a\f\u0012\u0005\u0012\u00030£\u0001\u0018\u00010\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u0090\u0001R\u001f\u0010¥\u0001\u001a\f\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010\u0090\u0001R\u0018\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X¦\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0018\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001X¦\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u0016\u0010°\u0001\u001a\u0004\u0018\u00010_X¦\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010aR\u0018\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001X¦\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R\u001c\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020_0\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010\u0090\u0001R\u001c\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020_0\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¹\u0001\u0010\u0090\u0001R\u001c\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020_0\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010\u0090\u0001R\u0016\u0010¼\u0001\u001a\u00030½\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0015\u0010À\u0001\u001a\u00020MX¦\u0004¢\u0006\b\u001a\u0006\bÁ\u0001\u0010Â\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006Ä\u0001À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "", "localTemperature", "", "getLocalTemperature", "()Ljava/lang/Short;", "outdoorTemperature", "getOutdoorTemperature", "occupancy", "Lkotlin/UByte;", "getOccupancy-7PGSa80", "()Lkotlin/UByte;", "absMinHeatSetpointLimit", "getAbsMinHeatSetpointLimit", "absMaxHeatSetpointLimit", "getAbsMaxHeatSetpointLimit", "absMinCoolSetpointLimit", "getAbsMinCoolSetpointLimit", "absMaxCoolSetpointLimit", "getAbsMaxCoolSetpointLimit", "piCoolingDemand", "getPiCoolingDemand-7PGSa80", "piHeatingDemand", "getPiHeatingDemand-7PGSa80", "hvacSystemTypeConfiguration", "getHvacSystemTypeConfiguration-7PGSa80", "localTemperatureCalibration", "", "getLocalTemperatureCalibration", "()Ljava/lang/Byte;", "occupiedCoolingSetpoint", "getOccupiedCoolingSetpoint", "occupiedHeatingSetpoint", "getOccupiedHeatingSetpoint", "unoccupiedCoolingSetpoint", "getUnoccupiedCoolingSetpoint", "unoccupiedHeatingSetpoint", "getUnoccupiedHeatingSetpoint", "minHeatSetpointLimit", "getMinHeatSetpointLimit", "maxHeatSetpointLimit", "getMaxHeatSetpointLimit", "minCoolSetpointLimit", "getMinCoolSetpointLimit", "maxCoolSetpointLimit", "getMaxCoolSetpointLimit", "minSetpointDeadBand", "getMinSetpointDeadBand", "remoteSensing", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "getRemoteSensing", "()Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "controlSequenceOfOperation", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "getControlSequenceOfOperation", "()Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "getSystemMode", "()Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "thermostatRunningMode", "Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "getThermostatRunningMode", "()Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "startOfWeek", "Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "getStartOfWeek", "()Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "numberOfWeeklyTransitions", "getNumberOfWeeklyTransitions-7PGSa80", "numberOfDailyTransitions", "getNumberOfDailyTransitions-7PGSa80", "temperatureSetpointHold", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "getTemperatureSetpointHold", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "temperatureSetpointHoldDuration", "Lkotlin/UShort;", "getTemperatureSetpointHoldDuration-XRpZGF0", "()Lkotlin/UShort;", "thermostatProgrammingOperationMode", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "getThermostatProgrammingOperationMode", "()Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "thermostatRunningState", "Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "getThermostatRunningState", "()Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "setpointChangeSource", "Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "getSetpointChangeSource", "()Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "setpointChangeAmount", "getSetpointChangeAmount", "setpointChangeSourceTimestamp", "Lkotlin/UInt;", "getSetpointChangeSourceTimestamp-0hXNFcg", "()Lkotlin/UInt;", "occupiedSetback", "getOccupiedSetback-7PGSa80", "occupiedSetbackMin", "getOccupiedSetbackMin-7PGSa80", "occupiedSetbackMax", "getOccupiedSetbackMax-7PGSa80", "unoccupiedSetback", "getUnoccupiedSetback-7PGSa80", "unoccupiedSetbackMin", "getUnoccupiedSetbackMin-7PGSa80", "unoccupiedSetbackMax", "getUnoccupiedSetbackMax-7PGSa80", "emergencyHeatDelta", "getEmergencyHeatDelta-7PGSa80", "acType", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "getAcType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "acCapacity", "getAcCapacity-XRpZGF0", "acRefrigerantType", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "getAcRefrigerantType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "acCompressorType", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "getAcCompressorType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "acErrorCode", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "getAcErrorCode", "()Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "acLouverPosition", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "getAcLouverPosition", "()Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "acCoilTemperature", "getAcCoilTemperature", "acCapacityformat", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "getAcCapacityformat", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "presetTypes", "", "Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;", "getPresetTypes", "()Ljava/util/List;", "scheduleTypes", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;", "getScheduleTypes", "numberOfPresets", "getNumberOfPresets-7PGSa80", "numberOfSchedules", "getNumberOfSchedules-7PGSa80", "numberOfScheduleTransitions", "getNumberOfScheduleTransitions-7PGSa80", "numberOfScheduleTransitionPerDay", "getNumberOfScheduleTransitionPerDay-7PGSa80", "activePresetHandle", "", "getActivePresetHandle", "()[B", "activeScheduleHandle", "getActiveScheduleHandle", "presets", "Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "getPresets", "schedules", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "getSchedules", "presetsSchedulesEditable", "", "getPresetsSchedulesEditable", "()Ljava/lang/Boolean;", "temperatureSetpointHoldPolicy", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "getTemperatureSetpointHoldPolicy", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "setpointHoldExpiryTimestamp", "getSetpointHoldExpiryTimestamp-0hXNFcg", "queuedPreset", "Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "getQueuedPreset", "()Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "generatedCommandList", "getGeneratedCommandList", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "clusterRevision", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ThermostatTrait.INSTANCE.getId());
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(72), PresetTypeStruct.INSTANCE), TuplesKt.to(UInt.m2388boximpl(73), ScheduleTypeStruct.INSTANCE), TuplesKt.to(UInt.m2388boximpl(80), PresetStruct.INSTANCE), TuplesKt.to(UInt.m2388boximpl(81), ScheduleStruct.INSTANCE), TuplesKt.to(UInt.m2388boximpl(85), QueuedPresetStruct.INSTANCE)));
                ArrayList arrayList = new ArrayList();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi0 = payload.getShort().mo549getOptionalNullableqim9Vi0(0, "LocalTemperature");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                Unit unit = Unit.INSTANCE;
                Short orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi02 = payload.getShort().mo549getOptionalNullableqim9Vi0(1, "OutdoorTemperature");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                Short orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi03 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(2, "Occupancy");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                UByte orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi04 = payload.getShort().mo549getOptionalNullableqim9Vi0(3, "AbsMinHeatSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                Short orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi05 = payload.getShort().mo549getOptionalNullableqim9Vi0(4, "AbsMaxHeatSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent() && optionalValueMo549getOptionalNullableqim9Vi05.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                Short orNull5 = optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi06 = payload.getShort().mo549getOptionalNullableqim9Vi0(5, "AbsMinCoolSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi06.isPresent() && optionalValueMo549getOptionalNullableqim9Vi06.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(5));
                }
                Short orNull6 = optionalValueMo549getOptionalNullableqim9Vi06.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi07 = payload.getShort().mo549getOptionalNullableqim9Vi0(6, "AbsMaxCoolSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi07.isPresent() && optionalValueMo549getOptionalNullableqim9Vi07.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(6));
                }
                Short orNull7 = optionalValueMo549getOptionalNullableqim9Vi07.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi08 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(7, "PiCoolingDemand");
                if (optionalValueMo549getOptionalNullableqim9Vi08.isPresent() && optionalValueMo549getOptionalNullableqim9Vi08.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(7));
                }
                UByte orNull8 = optionalValueMo549getOptionalNullableqim9Vi08.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi09 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(8, "PiHeatingDemand");
                if (optionalValueMo549getOptionalNullableqim9Vi09.isPresent() && optionalValueMo549getOptionalNullableqim9Vi09.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(8));
                }
                UByte orNull9 = optionalValueMo549getOptionalNullableqim9Vi09.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi010 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(9, "HvacSystemTypeConfiguration");
                if (optionalValueMo549getOptionalNullableqim9Vi010.isPresent() && optionalValueMo549getOptionalNullableqim9Vi010.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(9));
                }
                UByte orNull10 = optionalValueMo549getOptionalNullableqim9Vi010.getOrNull();
                OptionalValue<Byte> optionalValueMo549getOptionalNullableqim9Vi011 = payload.getByte().mo549getOptionalNullableqim9Vi0(16, "LocalTemperatureCalibration");
                if (optionalValueMo549getOptionalNullableqim9Vi011.isPresent() && optionalValueMo549getOptionalNullableqim9Vi011.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16));
                }
                Byte orNull11 = optionalValueMo549getOptionalNullableqim9Vi011.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi012 = payload.getShort().mo549getOptionalNullableqim9Vi0(17, "OccupiedCoolingSetpoint");
                if (optionalValueMo549getOptionalNullableqim9Vi012.isPresent() && optionalValueMo549getOptionalNullableqim9Vi012.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(17));
                }
                Short orNull12 = optionalValueMo549getOptionalNullableqim9Vi012.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi013 = payload.getShort().mo549getOptionalNullableqim9Vi0(18, "OccupiedHeatingSetpoint");
                if (optionalValueMo549getOptionalNullableqim9Vi013.isPresent() && optionalValueMo549getOptionalNullableqim9Vi013.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(18));
                }
                Short orNull13 = optionalValueMo549getOptionalNullableqim9Vi013.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi014 = payload.getShort().mo549getOptionalNullableqim9Vi0(19, "UnoccupiedCoolingSetpoint");
                if (optionalValueMo549getOptionalNullableqim9Vi014.isPresent() && optionalValueMo549getOptionalNullableqim9Vi014.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(19));
                }
                Short orNull14 = optionalValueMo549getOptionalNullableqim9Vi014.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi015 = payload.getShort().mo549getOptionalNullableqim9Vi0(20, "UnoccupiedHeatingSetpoint");
                if (optionalValueMo549getOptionalNullableqim9Vi015.isPresent() && optionalValueMo549getOptionalNullableqim9Vi015.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(20));
                }
                Short orNull15 = optionalValueMo549getOptionalNullableqim9Vi015.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi016 = payload.getShort().mo549getOptionalNullableqim9Vi0(21, "MinHeatSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi016.isPresent() && optionalValueMo549getOptionalNullableqim9Vi016.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(21));
                }
                Short orNull16 = optionalValueMo549getOptionalNullableqim9Vi016.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi017 = payload.getShort().mo549getOptionalNullableqim9Vi0(22, "MaxHeatSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi017.isPresent() && optionalValueMo549getOptionalNullableqim9Vi017.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(22));
                }
                Short orNull17 = optionalValueMo549getOptionalNullableqim9Vi017.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi018 = payload.getShort().mo549getOptionalNullableqim9Vi0(23, "MinCoolSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi018.isPresent() && optionalValueMo549getOptionalNullableqim9Vi018.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(23));
                }
                Short orNull18 = optionalValueMo549getOptionalNullableqim9Vi018.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi019 = payload.getShort().mo549getOptionalNullableqim9Vi0(24, "MaxCoolSetpointLimit");
                if (optionalValueMo549getOptionalNullableqim9Vi019.isPresent() && optionalValueMo549getOptionalNullableqim9Vi019.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(24));
                }
                Short orNull19 = optionalValueMo549getOptionalNullableqim9Vi019.getOrNull();
                OptionalValue<Byte> optionalValueMo549getOptionalNullableqim9Vi020 = payload.getByte().mo549getOptionalNullableqim9Vi0(25, "MinSetpointDeadBand");
                if (optionalValueMo549getOptionalNullableqim9Vi020.isPresent() && optionalValueMo549getOptionalNullableqim9Vi020.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(25));
                }
                Byte orNull20 = optionalValueMo549getOptionalNullableqim9Vi020.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi021 = payload.bitmap(RemoteSensingBitmap.INSTANCE).mo549getOptionalNullableqim9Vi0(26, "RemoteSensing");
                if (optionalValueMo549getOptionalNullableqim9Vi021.isPresent() && optionalValueMo549getOptionalNullableqim9Vi021.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(26));
                }
                RemoteSensingBitmap remoteSensingBitmap = (RemoteSensingBitmap) optionalValueMo549getOptionalNullableqim9Vi021.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi022 = payload.m545enum(ControlSequenceOfOperationEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(27, "ControlSequenceOfOperation");
                if (optionalValueMo549getOptionalNullableqim9Vi022.isPresent() && optionalValueMo549getOptionalNullableqim9Vi022.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(27));
                }
                ControlSequenceOfOperationEnum controlSequenceOfOperationEnum = (ControlSequenceOfOperationEnum) optionalValueMo549getOptionalNullableqim9Vi022.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi023 = payload.m545enum(SystemModeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(28, "SystemMode");
                if (optionalValueMo549getOptionalNullableqim9Vi023.isPresent() && optionalValueMo549getOptionalNullableqim9Vi023.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(28));
                }
                SystemModeEnum systemModeEnum = (SystemModeEnum) optionalValueMo549getOptionalNullableqim9Vi023.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi024 = payload.m545enum(ThermostatRunningModeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(30, "ThermostatRunningMode");
                if (optionalValueMo549getOptionalNullableqim9Vi024.isPresent() && optionalValueMo549getOptionalNullableqim9Vi024.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(30));
                }
                ThermostatRunningModeEnum thermostatRunningModeEnum = (ThermostatRunningModeEnum) optionalValueMo549getOptionalNullableqim9Vi024.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi025 = payload.m545enum(StartOfWeekEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(32, "StartOfWeek");
                if (optionalValueMo549getOptionalNullableqim9Vi025.isPresent() && optionalValueMo549getOptionalNullableqim9Vi025.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(32));
                }
                StartOfWeekEnum startOfWeekEnum = (StartOfWeekEnum) optionalValueMo549getOptionalNullableqim9Vi025.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi026 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(33, "NumberOfWeeklyTransitions");
                if (optionalValueMo549getOptionalNullableqim9Vi026.isPresent() && optionalValueMo549getOptionalNullableqim9Vi026.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(33));
                }
                UByte orNull21 = optionalValueMo549getOptionalNullableqim9Vi026.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi027 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(34, "NumberOfDailyTransitions");
                if (optionalValueMo549getOptionalNullableqim9Vi027.isPresent() && optionalValueMo549getOptionalNullableqim9Vi027.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(34));
                }
                UByte orNull22 = optionalValueMo549getOptionalNullableqim9Vi027.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi028 = payload.m545enum(TemperatureSetpointHoldEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(35, "TemperatureSetpointHold");
                if (optionalValueMo549getOptionalNullableqim9Vi028.isPresent() && optionalValueMo549getOptionalNullableqim9Vi028.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(35));
                }
                TemperatureSetpointHoldEnum temperatureSetpointHoldEnum = (TemperatureSetpointHoldEnum) optionalValueMo549getOptionalNullableqim9Vi028.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi029 = payload.getUshort().mo549getOptionalNullableqim9Vi0(36, "TemperatureSetpointHoldDuration");
                if (optionalValueMo549getOptionalNullableqim9Vi029.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(36));
                }
                UShort orNull23 = optionalValueMo549getOptionalNullableqim9Vi029.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi030 = payload.bitmap(ProgrammingOperationModeBitmap.INSTANCE).mo549getOptionalNullableqim9Vi0(37, "ThermostatProgrammingOperationMode");
                if (optionalValueMo549getOptionalNullableqim9Vi030.isPresent() && optionalValueMo549getOptionalNullableqim9Vi030.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(37));
                }
                ProgrammingOperationModeBitmap programmingOperationModeBitmap = (ProgrammingOperationModeBitmap) optionalValueMo549getOptionalNullableqim9Vi030.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi031 = payload.bitmap(RelayStateBitmap.INSTANCE).mo549getOptionalNullableqim9Vi0(41, "ThermostatRunningState");
                if (optionalValueMo549getOptionalNullableqim9Vi031.isPresent() && optionalValueMo549getOptionalNullableqim9Vi031.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(41));
                }
                RelayStateBitmap relayStateBitmap = (RelayStateBitmap) optionalValueMo549getOptionalNullableqim9Vi031.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi032 = payload.m545enum(SetpointChangeSourceEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(48, "SetpointChangeSource");
                if (optionalValueMo549getOptionalNullableqim9Vi032.isPresent() && optionalValueMo549getOptionalNullableqim9Vi032.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(48));
                }
                SetpointChangeSourceEnum setpointChangeSourceEnum = (SetpointChangeSourceEnum) optionalValueMo549getOptionalNullableqim9Vi032.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi033 = payload.getShort().mo549getOptionalNullableqim9Vi0(49, "SetpointChangeAmount");
                if (optionalValueMo549getOptionalNullableqim9Vi033.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(49));
                }
                Short orNull24 = optionalValueMo549getOptionalNullableqim9Vi033.getOrNull();
                OptionalValue<UInt> optionalValueMo549getOptionalNullableqim9Vi034 = payload.getUint().mo549getOptionalNullableqim9Vi0(50, "SetpointChangeSourceTimestamp");
                if (optionalValueMo549getOptionalNullableqim9Vi034.isPresent() && optionalValueMo549getOptionalNullableqim9Vi034.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(50));
                }
                UInt orNull25 = optionalValueMo549getOptionalNullableqim9Vi034.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi035 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(52, "OccupiedSetback");
                if (optionalValueMo549getOptionalNullableqim9Vi035.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(52));
                }
                UByte orNull26 = optionalValueMo549getOptionalNullableqim9Vi035.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi036 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(53, "OccupiedSetbackMin");
                if (optionalValueMo549getOptionalNullableqim9Vi036.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(53));
                }
                UByte orNull27 = optionalValueMo549getOptionalNullableqim9Vi036.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi037 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(54, "OccupiedSetbackMax");
                if (optionalValueMo549getOptionalNullableqim9Vi037.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(54));
                }
                UByte orNull28 = optionalValueMo549getOptionalNullableqim9Vi037.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi038 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(55, "UnoccupiedSetback");
                if (optionalValueMo549getOptionalNullableqim9Vi038.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(55));
                }
                UByte orNull29 = optionalValueMo549getOptionalNullableqim9Vi038.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi039 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(56, "UnoccupiedSetbackMin");
                if (optionalValueMo549getOptionalNullableqim9Vi039.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(56));
                }
                UByte orNull30 = optionalValueMo549getOptionalNullableqim9Vi039.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi040 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(57, "UnoccupiedSetbackMax");
                if (optionalValueMo549getOptionalNullableqim9Vi040.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(57));
                }
                UByte orNull31 = optionalValueMo549getOptionalNullableqim9Vi040.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi041 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(58, "EmergencyHeatDelta");
                if (optionalValueMo549getOptionalNullableqim9Vi041.isPresent() && optionalValueMo549getOptionalNullableqim9Vi041.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(58));
                }
                UByte orNull32 = optionalValueMo549getOptionalNullableqim9Vi041.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi042 = payload.m545enum(AcTypeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(64, "AcType");
                if (optionalValueMo549getOptionalNullableqim9Vi042.isPresent() && optionalValueMo549getOptionalNullableqim9Vi042.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(64));
                }
                AcTypeEnum acTypeEnum = (AcTypeEnum) optionalValueMo549getOptionalNullableqim9Vi042.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi043 = payload.getUshort().mo549getOptionalNullableqim9Vi0(65, "AcCapacity");
                if (optionalValueMo549getOptionalNullableqim9Vi043.isPresent() && optionalValueMo549getOptionalNullableqim9Vi043.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(65));
                }
                UShort orNull33 = optionalValueMo549getOptionalNullableqim9Vi043.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi044 = payload.m545enum(AcRefrigerantTypeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(66, "AcRefrigerantType");
                if (optionalValueMo549getOptionalNullableqim9Vi044.isPresent() && optionalValueMo549getOptionalNullableqim9Vi044.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(66));
                }
                AcRefrigerantTypeEnum acRefrigerantTypeEnum = (AcRefrigerantTypeEnum) optionalValueMo549getOptionalNullableqim9Vi044.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi045 = payload.m545enum(AcCompressorTypeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(67, "AcCompressorType");
                if (optionalValueMo549getOptionalNullableqim9Vi045.isPresent() && optionalValueMo549getOptionalNullableqim9Vi045.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(67));
                }
                AcCompressorTypeEnum acCompressorTypeEnum = (AcCompressorTypeEnum) optionalValueMo549getOptionalNullableqim9Vi045.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi046 = payload.bitmap(AcErrorCodeBitmap.INSTANCE).mo549getOptionalNullableqim9Vi0(68, "AcErrorCode");
                if (optionalValueMo549getOptionalNullableqim9Vi046.isPresent() && optionalValueMo549getOptionalNullableqim9Vi046.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(68));
                }
                AcErrorCodeBitmap acErrorCodeBitmap = (AcErrorCodeBitmap) optionalValueMo549getOptionalNullableqim9Vi046.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi047 = payload.m545enum(AcLouverPositionEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(69, "AcLouverPosition");
                if (optionalValueMo549getOptionalNullableqim9Vi047.isPresent() && optionalValueMo549getOptionalNullableqim9Vi047.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(69));
                }
                AcLouverPositionEnum acLouverPositionEnum = (AcLouverPositionEnum) optionalValueMo549getOptionalNullableqim9Vi047.getOrNull();
                OptionalValue<Short> optionalValueMo549getOptionalNullableqim9Vi048 = payload.getShort().mo549getOptionalNullableqim9Vi0(70, "AcCoilTemperature");
                if (optionalValueMo549getOptionalNullableqim9Vi048.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(70));
                }
                Short orNull34 = optionalValueMo549getOptionalNullableqim9Vi048.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi049 = payload.m545enum(AcCapacityFormatEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(71, "AcCapacityformat");
                if (optionalValueMo549getOptionalNullableqim9Vi049.isPresent() && optionalValueMo549getOptionalNullableqim9Vi049.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(71));
                }
                AcCapacityFormatEnum acCapacityFormatEnum = (AcCapacityFormatEnum) optionalValueMo549getOptionalNullableqim9Vi049.getOrNull();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi0 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<PresetTypeStruct>() { // from class: com.google.home.matter.standard.ThermostatTrait$Attributes$Adapter$read$50
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ThermostatTrait.PresetTypeStruct invoke() {
                        return new ThermostatTrait.PresetTypeStruct(null, (byte) 0, null, 7, null);
                    }
                }, Reflection.getOrCreateKotlinClass(PresetTypeStruct.class)).mo550getOptionalNullableListqim9Vi0(72, "PresetTypes");
                if (optionalValueMo550getOptionalNullableListqim9Vi0.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(72));
                }
                List list = (List) optionalValueMo550getOptionalNullableListqim9Vi0.getOrNull();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi02 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<ScheduleTypeStruct>() { // from class: com.google.home.matter.standard.ThermostatTrait$Attributes$Adapter$read$52
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ThermostatTrait.ScheduleTypeStruct invoke() {
                        return new ThermostatTrait.ScheduleTypeStruct(null, (byte) 0, null, 7, null);
                    }
                }, Reflection.getOrCreateKotlinClass(ScheduleTypeStruct.class)).mo550getOptionalNullableListqim9Vi0(73, "ScheduleTypes");
                if (optionalValueMo550getOptionalNullableListqim9Vi02.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(73));
                }
                List list2 = (List) optionalValueMo550getOptionalNullableListqim9Vi02.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi050 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(74, "NumberOfPresets");
                if (optionalValueMo549getOptionalNullableqim9Vi050.isPresent() && optionalValueMo549getOptionalNullableqim9Vi050.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(74));
                }
                UByte orNull35 = optionalValueMo549getOptionalNullableqim9Vi050.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi051 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(75, "NumberOfSchedules");
                if (optionalValueMo549getOptionalNullableqim9Vi051.isPresent() && optionalValueMo549getOptionalNullableqim9Vi051.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(75));
                }
                UByte orNull36 = optionalValueMo549getOptionalNullableqim9Vi051.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi052 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(76, "NumberOfScheduleTransitions");
                if (optionalValueMo549getOptionalNullableqim9Vi052.isPresent() && optionalValueMo549getOptionalNullableqim9Vi052.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(76));
                }
                UByte orNull37 = optionalValueMo549getOptionalNullableqim9Vi052.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi053 = payload.getUbyte().mo549getOptionalNullableqim9Vi0(77, "NumberOfScheduleTransitionPerDay");
                if (optionalValueMo549getOptionalNullableqim9Vi053.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(77));
                }
                UByte orNull38 = optionalValueMo549getOptionalNullableqim9Vi053.getOrNull();
                OptionalValue<byte[]> optionalValueMo549getOptionalNullableqim9Vi054 = payload.getBytearray().mo549getOptionalNullableqim9Vi0(78, "ActivePresetHandle");
                if (optionalValueMo549getOptionalNullableqim9Vi054.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(78));
                }
                byte[] orNull39 = optionalValueMo549getOptionalNullableqim9Vi054.getOrNull();
                OptionalValue<byte[]> optionalValueMo549getOptionalNullableqim9Vi055 = payload.getBytearray().mo549getOptionalNullableqim9Vi0(79, "ActiveScheduleHandle");
                if (optionalValueMo549getOptionalNullableqim9Vi055.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(79));
                }
                byte[] orNull40 = optionalValueMo549getOptionalNullableqim9Vi055.getOrNull();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi03 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<PresetStruct>() { // from class: com.google.home.matter.standard.ThermostatTrait$Attributes$Adapter$read$60
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ThermostatTrait.PresetStruct invoke() {
                        return new ThermostatTrait.PresetStruct(null, null, null, null, null, null, 63, null);
                    }
                }, Reflection.getOrCreateKotlinClass(PresetStruct.class)).mo550getOptionalNullableListqim9Vi0(80, "Presets");
                if (optionalValueMo550getOptionalNullableListqim9Vi03.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(80));
                }
                List list3 = (List) optionalValueMo550getOptionalNullableListqim9Vi03.getOrNull();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi04 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<ScheduleStruct>() { // from class: com.google.home.matter.standard.ThermostatTrait$Attributes$Adapter$read$62
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ThermostatTrait.ScheduleStruct invoke() {
                        return new ThermostatTrait.ScheduleStruct(null, null, null, null, null, null, 63, null);
                    }
                }, Reflection.getOrCreateKotlinClass(ScheduleStruct.class)).mo550getOptionalNullableListqim9Vi0(81, "Schedules");
                if (optionalValueMo550getOptionalNullableListqim9Vi04.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(81));
                }
                List list4 = (List) optionalValueMo550getOptionalNullableListqim9Vi04.getOrNull();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi056 = payload.getBoolean().mo549getOptionalNullableqim9Vi0(82, "PresetsSchedulesEditable");
                if (optionalValueMo549getOptionalNullableqim9Vi056.isPresent() && optionalValueMo549getOptionalNullableqim9Vi056.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(82));
                }
                Boolean orNull41 = optionalValueMo549getOptionalNullableqim9Vi056.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi057 = payload.bitmap(TemperatureSetpointHoldPolicyBitmap.INSTANCE).mo549getOptionalNullableqim9Vi0(83, "TemperatureSetpointHoldPolicy");
                if (optionalValueMo549getOptionalNullableqim9Vi057.isPresent() && optionalValueMo549getOptionalNullableqim9Vi057.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(83));
                }
                TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicyBitmap = (TemperatureSetpointHoldPolicyBitmap) optionalValueMo549getOptionalNullableqim9Vi057.getOrNull();
                OptionalValue<UInt> optionalValueMo549getOptionalNullableqim9Vi058 = payload.getUint().mo549getOptionalNullableqim9Vi0(84, "SetpointHoldExpiryTimestamp");
                if (optionalValueMo549getOptionalNullableqim9Vi058.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(84));
                }
                UInt orNull42 = optionalValueMo549getOptionalNullableqim9Vi058.getOrNull();
                OptionalValue<T> optionalValueMo549getOptionalNullableqim9Vi059 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<QueuedPresetStruct>() { // from class: com.google.home.matter.standard.ThermostatTrait$Attributes$Adapter$read$67
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final ThermostatTrait.QueuedPresetStruct invoke() {
                        return new ThermostatTrait.QueuedPresetStruct(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                }, Reflection.getOrCreateKotlinClass(QueuedPresetStruct.class)).mo549getOptionalNullableqim9Vi0(85, "QueuedPreset");
                if (optionalValueMo549getOptionalNullableqim9Vi059.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(85));
                }
                QueuedPresetStruct queuedPresetStruct = (QueuedPresetStruct) optionalValueMo549getOptionalNullableqim9Vi059.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                arrayList.add(UInt.m2388boximpl(65531));
                Feature feature = (Feature) payload.bitmap(Feature.INSTANCE).mo546getqim9Vi0(65532, "FeatureMap");
                arrayList.add(UInt.m2388boximpl(65532));
                UShort uShortMo546getqim9Vi0 = payload.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new AttributesImpl(orNull, orNull2, orNull3, orNull4, orNull5, orNull6, orNull7, orNull8, orNull9, orNull10, orNull11, orNull12, orNull13, orNull14, orNull15, orNull16, orNull17, orNull18, orNull19, orNull20, remoteSensingBitmap, controlSequenceOfOperationEnum, systemModeEnum, thermostatRunningModeEnum, startOfWeekEnum, orNull21, orNull22, temperatureSetpointHoldEnum, orNull23, programmingOperationModeBitmap, relayStateBitmap, setpointChangeSourceEnum, orNull24, orNull25, orNull26, orNull27, orNull28, orNull29, orNull30, orNull31, orNull32, acTypeEnum, orNull33, acRefrigerantTypeEnum, acCompressorTypeEnum, acErrorCodeBitmap, acLouverPositionEnum, orNull34, acCapacityFormatEnum, list, list2, orNull35, orNull36, orNull37, orNull38, orNull39, orNull40, list3, list4, orNull41, temperatureSetpointHoldPolicyBitmap, orNull42, queuedPresetStruct, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, feature, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, ThermostatTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getShort().mo554writeqim9Vi0(0, value.getLocalTemperature());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getShort().mo554writeqim9Vi0(1, value.getOutdoorTemperature());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getUbyte().mo554writeqim9Vi0(2, value.getOccupancy());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getShort().mo554writeqim9Vi0(3, value.getAbsMinHeatSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.getShort().mo554writeqim9Vi0(4, value.getAbsMaxHeatSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(5))) {
                    writer.getShort().mo554writeqim9Vi0(5, value.getAbsMinCoolSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(6))) {
                    writer.getShort().mo554writeqim9Vi0(6, value.getAbsMaxCoolSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(7))) {
                    writer.getUbyte().mo554writeqim9Vi0(7, value.getPiCoolingDemand());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(8))) {
                    writer.getUbyte().mo554writeqim9Vi0(8, value.getPiHeatingDemand());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(9))) {
                    writer.getUbyte().mo554writeqim9Vi0(9, value.getHvacSystemTypeConfiguration());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16))) {
                    writer.getByte().mo554writeqim9Vi0(16, value.getLocalTemperatureCalibration());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                    writer.getShort().mo554writeqim9Vi0(17, value.getOccupiedCoolingSetpoint());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(18))) {
                    writer.getShort().mo554writeqim9Vi0(18, value.getOccupiedHeatingSetpoint());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(19))) {
                    writer.getShort().mo554writeqim9Vi0(19, value.getUnoccupiedCoolingSetpoint());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(20))) {
                    writer.getShort().mo554writeqim9Vi0(20, value.getUnoccupiedHeatingSetpoint());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(21))) {
                    writer.getShort().mo554writeqim9Vi0(21, value.getMinHeatSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(22))) {
                    writer.getShort().mo554writeqim9Vi0(22, value.getMaxHeatSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(23))) {
                    writer.getShort().mo554writeqim9Vi0(23, value.getMinCoolSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(24))) {
                    writer.getShort().mo554writeqim9Vi0(24, value.getMaxCoolSetpointLimit());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(25))) {
                    writer.getByte().mo554writeqim9Vi0(25, value.getMinSetpointDeadBand());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(26))) {
                    writer.bitmap(RemoteSensingBitmap.INSTANCE).mo554writeqim9Vi0(26, value.getRemoteSensing());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(27))) {
                    writer.m552enum(ControlSequenceOfOperationEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(27, value.getControlSequenceOfOperation());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(28))) {
                    writer.m552enum(SystemModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(28, value.getSystemMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(30))) {
                    writer.m552enum(ThermostatRunningModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(30, value.getThermostatRunningMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(32))) {
                    writer.m552enum(StartOfWeekEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(32, value.getStartOfWeek());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(33))) {
                    writer.getUbyte().mo554writeqim9Vi0(33, value.getNumberOfWeeklyTransitions());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(34))) {
                    writer.getUbyte().mo554writeqim9Vi0(34, value.getNumberOfDailyTransitions());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(35))) {
                    writer.m552enum(TemperatureSetpointHoldEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(35, value.getTemperatureSetpointHold());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(36))) {
                    writer.getUshort().mo554writeqim9Vi0(36, value.getTemperatureSetpointHoldDuration());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(37))) {
                    writer.bitmap(ProgrammingOperationModeBitmap.INSTANCE).mo554writeqim9Vi0(37, value.getThermostatProgrammingOperationMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(41))) {
                    writer.bitmap(RelayStateBitmap.INSTANCE).mo554writeqim9Vi0(41, value.getThermostatRunningState());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(48))) {
                    writer.m552enum(SetpointChangeSourceEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(48, value.getSetpointChangeSource());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(49))) {
                    writer.getShort().mo554writeqim9Vi0(49, value.getSetpointChangeAmount());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(50))) {
                    writer.getUint().mo554writeqim9Vi0(50, value.getSetpointChangeSourceTimestamp());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(52))) {
                    writer.getUbyte().mo554writeqim9Vi0(52, value.getOccupiedSetback());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(53))) {
                    writer.getUbyte().mo554writeqim9Vi0(53, value.getOccupiedSetbackMin());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(54))) {
                    writer.getUbyte().mo554writeqim9Vi0(54, value.getOccupiedSetbackMax());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(55))) {
                    writer.getUbyte().mo554writeqim9Vi0(55, value.getUnoccupiedSetback());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(56))) {
                    writer.getUbyte().mo554writeqim9Vi0(56, value.getUnoccupiedSetbackMin());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(57))) {
                    writer.getUbyte().mo554writeqim9Vi0(57, value.getUnoccupiedSetbackMax());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(58))) {
                    writer.getUbyte().mo554writeqim9Vi0(58, value.getEmergencyHeatDelta());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(64))) {
                    writer.m552enum(AcTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(64, value.getAcType());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(65))) {
                    writer.getUshort().mo554writeqim9Vi0(65, value.getAcCapacity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(66))) {
                    writer.m552enum(AcRefrigerantTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(66, value.getAcRefrigerantType());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(67))) {
                    writer.m552enum(AcCompressorTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(67, value.getAcCompressorType());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(68))) {
                    writer.bitmap(AcErrorCodeBitmap.INSTANCE).mo554writeqim9Vi0(68, value.getAcErrorCode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(69))) {
                    writer.m552enum(AcLouverPositionEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(69, value.getAcLouverPosition());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(70))) {
                    writer.getShort().mo554writeqim9Vi0(70, value.getAcCoilTemperature());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(71))) {
                    writer.m552enum(AcCapacityFormatEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(71, value.getAcCapacityformat());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(72))) {
                    writer.struct(PresetTypeStruct.INSTANCE).mo555writeListqim9Vi0(72, value.getPresetTypes());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(73))) {
                    writer.struct(ScheduleTypeStruct.INSTANCE).mo555writeListqim9Vi0(73, value.getScheduleTypes());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(74))) {
                    writer.getUbyte().mo554writeqim9Vi0(74, value.getNumberOfPresets());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(75))) {
                    writer.getUbyte().mo554writeqim9Vi0(75, value.getNumberOfSchedules());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(76))) {
                    writer.getUbyte().mo554writeqim9Vi0(76, value.getNumberOfScheduleTransitions());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(77))) {
                    writer.getUbyte().mo554writeqim9Vi0(77, value.getNumberOfScheduleTransitionPerDay());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(78))) {
                    writer.getBytearray().mo554writeqim9Vi0(78, value.getActivePresetHandle());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(79))) {
                    writer.getBytearray().mo554writeqim9Vi0(79, value.getActiveScheduleHandle());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(80))) {
                    writer.struct(PresetStruct.INSTANCE).mo555writeListqim9Vi0(80, value.getPresets());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(81))) {
                    writer.struct(ScheduleStruct.INSTANCE).mo555writeListqim9Vi0(81, value.getSchedules());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(82))) {
                    writer.getBoolean().mo554writeqim9Vi0(82, value.getPresetsSchedulesEditable());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(83))) {
                    writer.bitmap(TemperatureSetpointHoldPolicyBitmap.INSTANCE).mo554writeqim9Vi0(83, value.getTemperatureSetpointHoldPolicy());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(84))) {
                    writer.getUint().mo554writeqim9Vi0(84, value.getSetpointHoldExpiryTimestamp());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(85))) {
                    writer.struct(QueuedPresetStruct.INSTANCE).mo554writeqim9Vi0(85, value.getQueuedPreset());
                }
                writer.getUint().mo555writeListqim9Vi0(65528, value.getGeneratedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65529, value.getAcceptedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65531, value.getAttributeList());
                writer.bitmap(Feature.INSTANCE).mo554writeqim9Vi0(65532, value.getFeatureMap());
                writer.getUshort().mo554writeqim9Vi0(65533, UShort.m2432boximpl(value.getClusterRevision()));
            }
        }

        Short getAbsMaxCoolSetpointLimit();

        Short getAbsMaxHeatSetpointLimit();

        Short getAbsMinCoolSetpointLimit();

        Short getAbsMinHeatSetpointLimit();

        /* JADX INFO: renamed from: getAcCapacity-XRpZGF0 */
        UShort getAcCapacity();

        AcCapacityFormatEnum getAcCapacityformat();

        Short getAcCoilTemperature();

        AcCompressorTypeEnum getAcCompressorType();

        AcErrorCodeBitmap getAcErrorCode();

        AcLouverPositionEnum getAcLouverPosition();

        AcRefrigerantTypeEnum getAcRefrigerantType();

        AcTypeEnum getAcType();

        List<UInt> getAcceptedCommandList();

        byte[] getActivePresetHandle();

        byte[] getActiveScheduleHandle();

        List<UInt> getAttributeList();

        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg */
        short getClusterRevision();

        ControlSequenceOfOperationEnum getControlSequenceOfOperation();

        /* JADX INFO: renamed from: getEmergencyHeatDelta-7PGSa80 */
        UByte getEmergencyHeatDelta();

        Feature getFeatureMap();

        List<UInt> getGeneratedCommandList();

        /* JADX INFO: renamed from: getHvacSystemTypeConfiguration-7PGSa80 */
        UByte getHvacSystemTypeConfiguration();

        Short getLocalTemperature();

        Byte getLocalTemperatureCalibration();

        Short getMaxCoolSetpointLimit();

        Short getMaxHeatSetpointLimit();

        Short getMinCoolSetpointLimit();

        Short getMinHeatSetpointLimit();

        Byte getMinSetpointDeadBand();

        /* JADX INFO: renamed from: getNumberOfDailyTransitions-7PGSa80 */
        UByte getNumberOfDailyTransitions();

        /* JADX INFO: renamed from: getNumberOfPresets-7PGSa80 */
        UByte getNumberOfPresets();

        /* JADX INFO: renamed from: getNumberOfScheduleTransitionPerDay-7PGSa80 */
        UByte getNumberOfScheduleTransitionPerDay();

        /* JADX INFO: renamed from: getNumberOfScheduleTransitions-7PGSa80 */
        UByte getNumberOfScheduleTransitions();

        /* JADX INFO: renamed from: getNumberOfSchedules-7PGSa80 */
        UByte getNumberOfSchedules();

        /* JADX INFO: renamed from: getNumberOfWeeklyTransitions-7PGSa80 */
        UByte getNumberOfWeeklyTransitions();

        /* JADX INFO: renamed from: getOccupancy-7PGSa80 */
        UByte getOccupancy();

        Short getOccupiedCoolingSetpoint();

        Short getOccupiedHeatingSetpoint();

        /* JADX INFO: renamed from: getOccupiedSetback-7PGSa80 */
        UByte getOccupiedSetback();

        /* JADX INFO: renamed from: getOccupiedSetbackMax-7PGSa80 */
        UByte getOccupiedSetbackMax();

        /* JADX INFO: renamed from: getOccupiedSetbackMin-7PGSa80 */
        UByte getOccupiedSetbackMin();

        Short getOutdoorTemperature();

        /* JADX INFO: renamed from: getPiCoolingDemand-7PGSa80 */
        UByte getPiCoolingDemand();

        /* JADX INFO: renamed from: getPiHeatingDemand-7PGSa80 */
        UByte getPiHeatingDemand();

        List<PresetTypeStruct> getPresetTypes();

        List<PresetStruct> getPresets();

        Boolean getPresetsSchedulesEditable();

        QueuedPresetStruct getQueuedPreset();

        RemoteSensingBitmap getRemoteSensing();

        List<ScheduleTypeStruct> getScheduleTypes();

        List<ScheduleStruct> getSchedules();

        Short getSetpointChangeAmount();

        SetpointChangeSourceEnum getSetpointChangeSource();

        /* JADX INFO: renamed from: getSetpointChangeSourceTimestamp-0hXNFcg */
        UInt getSetpointChangeSourceTimestamp();

        /* JADX INFO: renamed from: getSetpointHoldExpiryTimestamp-0hXNFcg */
        UInt getSetpointHoldExpiryTimestamp();

        StartOfWeekEnum getStartOfWeek();

        SystemModeEnum getSystemMode();

        TemperatureSetpointHoldEnum getTemperatureSetpointHold();

        /* JADX INFO: renamed from: getTemperatureSetpointHoldDuration-XRpZGF0 */
        UShort getTemperatureSetpointHoldDuration();

        TemperatureSetpointHoldPolicyBitmap getTemperatureSetpointHoldPolicy();

        ProgrammingOperationModeBitmap getThermostatProgrammingOperationMode();

        ThermostatRunningModeEnum getThermostatRunningMode();

        RelayStateBitmap getThermostatRunningState();

        Short getUnoccupiedCoolingSetpoint();

        Short getUnoccupiedHeatingSetpoint();

        /* JADX INFO: renamed from: getUnoccupiedSetback-7PGSa80 */
        UByte getUnoccupiedSetback();

        /* JADX INFO: renamed from: getUnoccupiedSetbackMax-7PGSa80 */
        UByte getUnoccupiedSetbackMax();

        /* JADX INFO: renamed from: getUnoccupiedSetbackMin-7PGSa80 */
        UByte getUnoccupiedSetbackMin();
    }

    @Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b~\b\u0016\u0018\u0000 ë\u00012\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0002ë\u0001B×\u0006\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010I\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010R\u0012\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010I\u0012\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010I\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\u000e\b\u0002\u0010`\u001a\b\u0012\u0004\u0012\u0002020I\u0012\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u0002020I\u0012\u000e\b\u0002\u0010b\u001a\b\u0012\u0004\u0012\u0002020I\u0012\b\b\u0002\u0010d\u001a\u00020c\u0012\b\b\u0002\u0010e\u001a\u00020)¢\u0006\u0004\bf\u0010gJ\u001a\u0010i\u001a\u00020Y2\b\u0010h\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\bi\u0010jJ\u000f\u0010l\u001a\u00020kH\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010o\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010q\u001a\u0004\br\u0010sR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010q\u001a\u0004\bt\u0010sR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010u\u001a\u0004\bv\u0010wR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010q\u001a\u0004\bx\u0010sR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010q\u001a\u0004\by\u0010sR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010q\u001a\u0004\bz\u0010sR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010q\u001a\u0004\b{\u0010sR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010u\u001a\u0004\b|\u0010wR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010u\u001a\u0004\b}\u0010wR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010u\u001a\u0004\b~\u0010wR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004¢\u0006\u000e\n\u0004\b\u0011\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0012\u0010q\u001a\u0005\b\u0082\u0001\u0010sR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0013\u0010q\u001a\u0005\b\u0083\u0001\u0010sR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0014\u0010q\u001a\u0005\b\u0084\u0001\u0010sR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0015\u0010q\u001a\u0005\b\u0085\u0001\u0010sR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0016\u0010q\u001a\u0005\b\u0086\u0001\u0010sR\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0017\u0010q\u001a\u0005\b\u0087\u0001\u0010sR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0018\u0010q\u001a\u0005\b\u0088\u0001\u0010sR\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b\u0019\u0010q\u001a\u0005\b\u0089\u0001\u0010sR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004¢\u0006\u000e\n\u0004\b\u001a\u0010\u007f\u001a\u0006\b\u008a\u0001\u0010\u0081\u0001R\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u001c\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u001e\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001f\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b \u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001f\u0010\"\u001a\u0004\u0018\u00010!8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\"\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001f\u0010$\u001a\u0004\u0018\u00010#8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b$\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010%\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b%\u0010u\u001a\u0005\b\u009a\u0001\u0010wR\u001d\u0010&\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b&\u0010u\u001a\u0005\b\u009b\u0001\u0010wR\u001f\u0010(\u001a\u0004\u0018\u00010'8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b(\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001f\u0010*\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b*\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001R\u001f\u0010,\u001a\u0004\u0018\u00010+8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b,\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u001f\u0010.\u001a\u0004\u0018\u00010-8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b.\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u001f\u00100\u001a\u0004\u0018\u00010/8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b0\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R\u001d\u00101\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\b1\u0010q\u001a\u0005\b«\u0001\u0010sR\u001f\u00103\u001a\u0004\u0018\u0001028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b3\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u001d\u00104\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b4\u0010u\u001a\u0005\b¯\u0001\u0010wR\u001d\u00105\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b5\u0010u\u001a\u0005\b°\u0001\u0010wR\u001d\u00106\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b6\u0010u\u001a\u0005\b±\u0001\u0010wR\u001d\u00107\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b7\u0010u\u001a\u0005\b²\u0001\u0010wR\u001d\u00108\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b8\u0010u\u001a\u0005\b³\u0001\u0010wR\u001d\u00109\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b9\u0010u\u001a\u0005\b´\u0001\u0010wR\u001d\u0010:\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b:\u0010u\u001a\u0005\bµ\u0001\u0010wR\u001f\u0010<\u001a\u0004\u0018\u00010;8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b<\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R\u001f\u0010=\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b=\u0010\u009f\u0001\u001a\u0006\b¹\u0001\u0010¡\u0001R\u001f\u0010?\u001a\u0004\u0018\u00010>8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b?\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001R\u001f\u0010A\u001a\u0004\u0018\u00010@8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bA\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001R\u001f\u0010C\u001a\u0004\u0018\u00010B8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bC\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u001f\u0010E\u001a\u0004\u0018\u00010D8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bE\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u001d\u0010F\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\r\n\u0004\bF\u0010q\u001a\u0005\bÆ\u0001\u0010sR\u001f\u0010H\u001a\u0004\u0018\u00010G8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bH\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R%\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bK\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R%\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bM\u0010Ê\u0001\u001a\u0006\bÍ\u0001\u0010Ì\u0001R\u001d\u0010N\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\bN\u0010u\u001a\u0005\bÎ\u0001\u0010wR\u001d\u0010O\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\bO\u0010u\u001a\u0005\bÏ\u0001\u0010wR\u001d\u0010P\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\bP\u0010u\u001a\u0005\bÐ\u0001\u0010wR\u001d\u0010Q\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\bQ\u0010u\u001a\u0005\bÑ\u0001\u0010wR\u001f\u0010S\u001a\u0004\u0018\u00010R8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bS\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u001f\u0010T\u001a\u0004\u0018\u00010R8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bT\u0010Ò\u0001\u001a\u0006\bÕ\u0001\u0010Ô\u0001R%\u0010V\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bV\u0010Ê\u0001\u001a\u0006\bÖ\u0001\u0010Ì\u0001R%\u0010X\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bX\u0010Ê\u0001\u001a\u0006\b×\u0001\u0010Ì\u0001R\u001f\u0010Z\u001a\u0004\u0018\u00010Y8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bZ\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u001f\u0010\\\u001a\u0004\u0018\u00010[8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\\\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001R\u001f\u0010]\u001a\u0004\u0018\u0001028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b]\u0010¬\u0001\u001a\u0006\bÞ\u0001\u0010®\u0001R\u001f\u0010_\u001a\u0004\u0018\u00010^8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b_\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001R#\u0010`\u001a\b\u0012\u0004\u0012\u0002020I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b`\u0010Ê\u0001\u001a\u0006\bâ\u0001\u0010Ì\u0001R#\u0010a\u001a\b\u0012\u0004\u0012\u0002020I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\ba\u0010Ê\u0001\u001a\u0006\bã\u0001\u0010Ì\u0001R#\u0010b\u001a\b\u0012\u0004\u0012\u0002020I8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bb\u0010Ê\u0001\u001a\u0006\bä\u0001\u0010Ì\u0001R\u001d\u0010d\u001a\u00020c8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bd\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R\u001d\u0010e\u001a\u00020)8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\be\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001¨\u0006ì\u0001"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AttributesImpl;", "Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "", "Lcom/google/home/matter/standard/ThermostatTrait$MutableAttributes;", "", "localTemperature", "outdoorTemperature", "Lkotlin/UByte;", "occupancy", "absMinHeatSetpointLimit", "absMaxHeatSetpointLimit", "absMinCoolSetpointLimit", "absMaxCoolSetpointLimit", "piCoolingDemand", "piHeatingDemand", "hvacSystemTypeConfiguration", "", "localTemperatureCalibration", "occupiedCoolingSetpoint", "occupiedHeatingSetpoint", "unoccupiedCoolingSetpoint", "unoccupiedHeatingSetpoint", "minHeatSetpointLimit", "maxHeatSetpointLimit", "minCoolSetpointLimit", "maxCoolSetpointLimit", "minSetpointDeadBand", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "remoteSensing", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "controlSequenceOfOperation", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "thermostatRunningMode", "Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "startOfWeek", "numberOfWeeklyTransitions", "numberOfDailyTransitions", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "temperatureSetpointHold", "Lkotlin/UShort;", "temperatureSetpointHoldDuration", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "thermostatProgrammingOperationMode", "Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "thermostatRunningState", "Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "setpointChangeSource", "setpointChangeAmount", "Lkotlin/UInt;", "setpointChangeSourceTimestamp", "occupiedSetback", "occupiedSetbackMin", "occupiedSetbackMax", "unoccupiedSetback", "unoccupiedSetbackMin", "unoccupiedSetbackMax", "emergencyHeatDelta", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "acType", "acCapacity", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "acRefrigerantType", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "acCompressorType", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "acErrorCode", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "acLouverPosition", "acCoilTemperature", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "acCapacityformat", "", "Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;", "presetTypes", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;", "scheduleTypes", "numberOfPresets", "numberOfSchedules", "numberOfScheduleTransitions", "numberOfScheduleTransitionPerDay", "", "activePresetHandle", "activeScheduleHandle", "Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "presets", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "schedules", "", "presetsSchedulesEditable", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "temperatureSetpointHoldPolicy", "setpointHoldExpiryTimestamp", "Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "queuedPreset", "generatedCommandList", "acceptedCommandList", "attributeList", "Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "featureMap", "clusterRevision", "<init>", "(Ljava/lang/Short;Ljava/lang/Short;Lkotlin/UByte;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Ljava/lang/Byte;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Byte;Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;Lkotlin/UByte;Lkotlin/UByte;Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;Lkotlin/UShort;Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;Ljava/lang/Short;Lkotlin/UInt;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;Lkotlin/UShort;Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;Ljava/lang/Short;Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;Ljava/util/List;Ljava/util/List;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;[B[BLjava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;Lkotlin/UInt;Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/google/home/matter/standard/ThermostatTrait$Feature;SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/Short;", "getLocalTemperature", "()Ljava/lang/Short;", "getOutdoorTemperature", "Lkotlin/UByte;", "getOccupancy-7PGSa80", "()Lkotlin/UByte;", "getAbsMinHeatSetpointLimit", "getAbsMaxHeatSetpointLimit", "getAbsMinCoolSetpointLimit", "getAbsMaxCoolSetpointLimit", "getPiCoolingDemand-7PGSa80", "getPiHeatingDemand-7PGSa80", "getHvacSystemTypeConfiguration-7PGSa80", "Ljava/lang/Byte;", "getLocalTemperatureCalibration", "()Ljava/lang/Byte;", "getOccupiedCoolingSetpoint", "getOccupiedHeatingSetpoint", "getUnoccupiedCoolingSetpoint", "getUnoccupiedHeatingSetpoint", "getMinHeatSetpointLimit", "getMaxHeatSetpointLimit", "getMinCoolSetpointLimit", "getMaxCoolSetpointLimit", "getMinSetpointDeadBand", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "getRemoteSensing", "()Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "getControlSequenceOfOperation", "()Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "getSystemMode", "()Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "getThermostatRunningMode", "()Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "getStartOfWeek", "()Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "getNumberOfWeeklyTransitions-7PGSa80", "getNumberOfDailyTransitions-7PGSa80", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "getTemperatureSetpointHold", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "Lkotlin/UShort;", "getTemperatureSetpointHoldDuration-XRpZGF0", "()Lkotlin/UShort;", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "getThermostatProgrammingOperationMode", "()Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "getThermostatRunningState", "()Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "getSetpointChangeSource", "()Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "getSetpointChangeAmount", "Lkotlin/UInt;", "getSetpointChangeSourceTimestamp-0hXNFcg", "()Lkotlin/UInt;", "getOccupiedSetback-7PGSa80", "getOccupiedSetbackMin-7PGSa80", "getOccupiedSetbackMax-7PGSa80", "getUnoccupiedSetback-7PGSa80", "getUnoccupiedSetbackMin-7PGSa80", "getUnoccupiedSetbackMax-7PGSa80", "getEmergencyHeatDelta-7PGSa80", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "getAcType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "getAcCapacity-XRpZGF0", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "getAcRefrigerantType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "getAcCompressorType", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "getAcErrorCode", "()Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "getAcLouverPosition", "()Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "getAcCoilTemperature", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "getAcCapacityformat", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "Ljava/util/List;", "getPresetTypes", "()Ljava/util/List;", "getScheduleTypes", "getNumberOfPresets-7PGSa80", "getNumberOfSchedules-7PGSa80", "getNumberOfScheduleTransitions-7PGSa80", "getNumberOfScheduleTransitionPerDay-7PGSa80", "[B", "getActivePresetHandle", "()[B", "getActiveScheduleHandle", "getPresets", "getSchedules", "Ljava/lang/Boolean;", "getPresetsSchedulesEditable", "()Ljava/lang/Boolean;", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "getTemperatureSetpointHoldPolicy", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "getSetpointHoldExpiryTimestamp-0hXNFcg", "Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "getQueuedPreset", "()Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "getGeneratedCommandList", "getAcceptedCommandList", "getAttributeList", "Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final Short absMaxCoolSetpointLimit;
        private final Short absMaxHeatSetpointLimit;
        private final Short absMinCoolSetpointLimit;
        private final Short absMinHeatSetpointLimit;
        private final UShort acCapacity;
        private final AcCapacityFormatEnum acCapacityformat;
        private final Short acCoilTemperature;
        private final AcCompressorTypeEnum acCompressorType;
        private final AcErrorCodeBitmap acErrorCode;
        private final AcLouverPositionEnum acLouverPosition;
        private final AcRefrigerantTypeEnum acRefrigerantType;
        private final AcTypeEnum acType;
        private final List<UInt> acceptedCommandList;
        private final byte[] activePresetHandle;
        private final byte[] activeScheduleHandle;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final ControlSequenceOfOperationEnum controlSequenceOfOperation;
        private final UByte emergencyHeatDelta;
        private final Feature featureMap;
        private final List<UInt> generatedCommandList;
        private final UByte hvacSystemTypeConfiguration;
        private final Short localTemperature;
        private final Byte localTemperatureCalibration;
        private final Short maxCoolSetpointLimit;
        private final Short maxHeatSetpointLimit;
        private final Short minCoolSetpointLimit;
        private final Short minHeatSetpointLimit;
        private final Byte minSetpointDeadBand;
        private final UByte numberOfDailyTransitions;
        private final UByte numberOfPresets;
        private final UByte numberOfScheduleTransitionPerDay;
        private final UByte numberOfScheduleTransitions;
        private final UByte numberOfSchedules;
        private final UByte numberOfWeeklyTransitions;
        private final UByte occupancy;
        private final Short occupiedCoolingSetpoint;
        private final Short occupiedHeatingSetpoint;
        private final UByte occupiedSetback;
        private final UByte occupiedSetbackMax;
        private final UByte occupiedSetbackMin;
        private final Short outdoorTemperature;
        private final UByte piCoolingDemand;
        private final UByte piHeatingDemand;
        private final List<PresetTypeStruct> presetTypes;
        private final List<PresetStruct> presets;
        private final Boolean presetsSchedulesEditable;
        private final QueuedPresetStruct queuedPreset;
        private final RemoteSensingBitmap remoteSensing;
        private final List<ScheduleTypeStruct> scheduleTypes;
        private final List<ScheduleStruct> schedules;
        private final Short setpointChangeAmount;
        private final SetpointChangeSourceEnum setpointChangeSource;
        private final UInt setpointChangeSourceTimestamp;
        private final UInt setpointHoldExpiryTimestamp;
        private final StartOfWeekEnum startOfWeek;
        private final SystemModeEnum systemMode;
        private final TemperatureSetpointHoldEnum temperatureSetpointHold;
        private final UShort temperatureSetpointHoldDuration;
        private final TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicy;
        private final ProgrammingOperationModeBitmap thermostatProgrammingOperationMode;
        private final ThermostatRunningModeEnum thermostatRunningMode;
        private final RelayStateBitmap thermostatRunningState;
        private final Short unoccupiedCoolingSetpoint;
        private final Short unoccupiedHeatingSetpoint;
        private final UByte unoccupiedSetback;
        private final UByte unoccupiedSetbackMax;
        private final UByte unoccupiedSetbackMin;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(Short sh, Short sh2, UByte uByte, Short sh3, Short sh4, Short sh5, Short sh6, UByte uByte2, UByte uByte3, UByte uByte4, Byte b, Short sh7, Short sh8, Short sh9, Short sh10, Short sh11, Short sh12, Short sh13, Short sh14, Byte b2, RemoteSensingBitmap remoteSensingBitmap, ControlSequenceOfOperationEnum controlSequenceOfOperationEnum, SystemModeEnum systemModeEnum, ThermostatRunningModeEnum thermostatRunningModeEnum, StartOfWeekEnum startOfWeekEnum, UByte uByte5, UByte uByte6, TemperatureSetpointHoldEnum temperatureSetpointHoldEnum, UShort uShort, ProgrammingOperationModeBitmap programmingOperationModeBitmap, RelayStateBitmap relayStateBitmap, SetpointChangeSourceEnum setpointChangeSourceEnum, Short sh15, UInt uInt, UByte uByte7, UByte uByte8, UByte uByte9, UByte uByte10, UByte uByte11, UByte uByte12, UByte uByte13, AcTypeEnum acTypeEnum, UShort uShort2, AcRefrigerantTypeEnum acRefrigerantTypeEnum, AcCompressorTypeEnum acCompressorTypeEnum, AcErrorCodeBitmap acErrorCodeBitmap, AcLouverPositionEnum acLouverPositionEnum, Short sh16, AcCapacityFormatEnum acCapacityFormatEnum, List<PresetTypeStruct> list, List<ScheduleTypeStruct> list2, UByte uByte14, UByte uByte15, UByte uByte16, UByte uByte17, byte[] bArr, byte[] bArr2, List<PresetStruct> list3, List<ScheduleStruct> list4, Boolean bool, TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicyBitmap, UInt uInt2, QueuedPresetStruct queuedPresetStruct, List<UInt> list5, List<UInt> list6, List<UInt> list7, Feature feature, short s) {
            list5.getClass();
            list6.getClass();
            list7.getClass();
            feature.getClass();
            this.localTemperature = sh;
            this.outdoorTemperature = sh2;
            this.occupancy = uByte;
            this.absMinHeatSetpointLimit = sh3;
            this.absMaxHeatSetpointLimit = sh4;
            this.absMinCoolSetpointLimit = sh5;
            this.absMaxCoolSetpointLimit = sh6;
            this.piCoolingDemand = uByte2;
            this.piHeatingDemand = uByte3;
            this.hvacSystemTypeConfiguration = uByte4;
            this.localTemperatureCalibration = b;
            this.occupiedCoolingSetpoint = sh7;
            this.occupiedHeatingSetpoint = sh8;
            this.unoccupiedCoolingSetpoint = sh9;
            this.unoccupiedHeatingSetpoint = sh10;
            this.minHeatSetpointLimit = sh11;
            this.maxHeatSetpointLimit = sh12;
            this.minCoolSetpointLimit = sh13;
            this.maxCoolSetpointLimit = sh14;
            this.minSetpointDeadBand = b2;
            this.remoteSensing = remoteSensingBitmap;
            this.controlSequenceOfOperation = controlSequenceOfOperationEnum;
            this.systemMode = systemModeEnum;
            this.thermostatRunningMode = thermostatRunningModeEnum;
            this.startOfWeek = startOfWeekEnum;
            this.numberOfWeeklyTransitions = uByte5;
            this.numberOfDailyTransitions = uByte6;
            this.temperatureSetpointHold = temperatureSetpointHoldEnum;
            this.temperatureSetpointHoldDuration = uShort;
            this.thermostatProgrammingOperationMode = programmingOperationModeBitmap;
            this.thermostatRunningState = relayStateBitmap;
            this.setpointChangeSource = setpointChangeSourceEnum;
            this.setpointChangeAmount = sh15;
            this.setpointChangeSourceTimestamp = uInt;
            this.occupiedSetback = uByte7;
            this.occupiedSetbackMin = uByte8;
            this.occupiedSetbackMax = uByte9;
            this.unoccupiedSetback = uByte10;
            this.unoccupiedSetbackMin = uByte11;
            this.unoccupiedSetbackMax = uByte12;
            this.emergencyHeatDelta = uByte13;
            this.acType = acTypeEnum;
            this.acCapacity = uShort2;
            this.acRefrigerantType = acRefrigerantTypeEnum;
            this.acCompressorType = acCompressorTypeEnum;
            this.acErrorCode = acErrorCodeBitmap;
            this.acLouverPosition = acLouverPositionEnum;
            this.acCoilTemperature = sh16;
            this.acCapacityformat = acCapacityFormatEnum;
            this.presetTypes = list;
            this.scheduleTypes = list2;
            this.numberOfPresets = uByte14;
            this.numberOfSchedules = uByte15;
            this.numberOfScheduleTransitions = uByte16;
            this.numberOfScheduleTransitionPerDay = uByte17;
            this.activePresetHandle = bArr;
            this.activeScheduleHandle = bArr2;
            this.presets = list3;
            this.schedules = list4;
            this.presetsSchedulesEditable = bool;
            this.temperatureSetpointHoldPolicy = temperatureSetpointHoldPolicyBitmap;
            this.setpointHoldExpiryTimestamp = uInt2;
            this.queuedPreset = queuedPresetStruct;
            this.generatedCommandList = list5;
            this.acceptedCommandList = list6;
            this.attributeList = list7;
            this.featureMap = feature;
            this.clusterRevision = s;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Attributes)) {
                return false;
            }
            Short localTemperature = getLocalTemperature();
            Integer numValueOf = localTemperature != null ? Integer.valueOf(localTemperature.shortValue()) : null;
            Attributes attributes = (Attributes) other;
            Short localTemperature2 = attributes.getLocalTemperature();
            if (!Intrinsics.areEqual(numValueOf, localTemperature2 != null ? Integer.valueOf(localTemperature2.shortValue()) : null)) {
                return false;
            }
            Short outdoorTemperature = getOutdoorTemperature();
            Integer numValueOf2 = outdoorTemperature != null ? Integer.valueOf(outdoorTemperature.shortValue()) : null;
            Short outdoorTemperature2 = attributes.getOutdoorTemperature();
            if (!Intrinsics.areEqual(numValueOf2, outdoorTemperature2 != null ? Integer.valueOf(outdoorTemperature2.shortValue()) : null) || !Intrinsics.areEqual(getOccupancy(), attributes.getOccupancy())) {
                return false;
            }
            Short absMinHeatSetpointLimit = getAbsMinHeatSetpointLimit();
            Integer numValueOf3 = absMinHeatSetpointLimit != null ? Integer.valueOf(absMinHeatSetpointLimit.shortValue()) : null;
            Short absMinHeatSetpointLimit2 = attributes.getAbsMinHeatSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf3, absMinHeatSetpointLimit2 != null ? Integer.valueOf(absMinHeatSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short absMaxHeatSetpointLimit = getAbsMaxHeatSetpointLimit();
            Integer numValueOf4 = absMaxHeatSetpointLimit != null ? Integer.valueOf(absMaxHeatSetpointLimit.shortValue()) : null;
            Short absMaxHeatSetpointLimit2 = attributes.getAbsMaxHeatSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf4, absMaxHeatSetpointLimit2 != null ? Integer.valueOf(absMaxHeatSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short absMinCoolSetpointLimit = getAbsMinCoolSetpointLimit();
            Integer numValueOf5 = absMinCoolSetpointLimit != null ? Integer.valueOf(absMinCoolSetpointLimit.shortValue()) : null;
            Short absMinCoolSetpointLimit2 = attributes.getAbsMinCoolSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf5, absMinCoolSetpointLimit2 != null ? Integer.valueOf(absMinCoolSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short absMaxCoolSetpointLimit = getAbsMaxCoolSetpointLimit();
            Integer numValueOf6 = absMaxCoolSetpointLimit != null ? Integer.valueOf(absMaxCoolSetpointLimit.shortValue()) : null;
            Short absMaxCoolSetpointLimit2 = attributes.getAbsMaxCoolSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf6, absMaxCoolSetpointLimit2 != null ? Integer.valueOf(absMaxCoolSetpointLimit2.shortValue()) : null) || !Intrinsics.areEqual(getPiCoolingDemand(), attributes.getPiCoolingDemand()) || !Intrinsics.areEqual(getPiHeatingDemand(), attributes.getPiHeatingDemand()) || !Intrinsics.areEqual(getHvacSystemTypeConfiguration(), attributes.getHvacSystemTypeConfiguration())) {
                return false;
            }
            Byte localTemperatureCalibration = getLocalTemperatureCalibration();
            Integer numValueOf7 = localTemperatureCalibration != null ? Integer.valueOf(localTemperatureCalibration.byteValue()) : null;
            Byte localTemperatureCalibration2 = attributes.getLocalTemperatureCalibration();
            if (!Intrinsics.areEqual(numValueOf7, localTemperatureCalibration2 != null ? Integer.valueOf(localTemperatureCalibration2.byteValue()) : null)) {
                return false;
            }
            Short occupiedCoolingSetpoint = getOccupiedCoolingSetpoint();
            Integer numValueOf8 = occupiedCoolingSetpoint != null ? Integer.valueOf(occupiedCoolingSetpoint.shortValue()) : null;
            Short occupiedCoolingSetpoint2 = attributes.getOccupiedCoolingSetpoint();
            if (!Intrinsics.areEqual(numValueOf8, occupiedCoolingSetpoint2 != null ? Integer.valueOf(occupiedCoolingSetpoint2.shortValue()) : null)) {
                return false;
            }
            Short occupiedHeatingSetpoint = getOccupiedHeatingSetpoint();
            Integer numValueOf9 = occupiedHeatingSetpoint != null ? Integer.valueOf(occupiedHeatingSetpoint.shortValue()) : null;
            Short occupiedHeatingSetpoint2 = attributes.getOccupiedHeatingSetpoint();
            if (!Intrinsics.areEqual(numValueOf9, occupiedHeatingSetpoint2 != null ? Integer.valueOf(occupiedHeatingSetpoint2.shortValue()) : null)) {
                return false;
            }
            Short unoccupiedCoolingSetpoint = getUnoccupiedCoolingSetpoint();
            Integer numValueOf10 = unoccupiedCoolingSetpoint != null ? Integer.valueOf(unoccupiedCoolingSetpoint.shortValue()) : null;
            Short unoccupiedCoolingSetpoint2 = attributes.getUnoccupiedCoolingSetpoint();
            if (!Intrinsics.areEqual(numValueOf10, unoccupiedCoolingSetpoint2 != null ? Integer.valueOf(unoccupiedCoolingSetpoint2.shortValue()) : null)) {
                return false;
            }
            Short unoccupiedHeatingSetpoint = getUnoccupiedHeatingSetpoint();
            Integer numValueOf11 = unoccupiedHeatingSetpoint != null ? Integer.valueOf(unoccupiedHeatingSetpoint.shortValue()) : null;
            Short unoccupiedHeatingSetpoint2 = attributes.getUnoccupiedHeatingSetpoint();
            if (!Intrinsics.areEqual(numValueOf11, unoccupiedHeatingSetpoint2 != null ? Integer.valueOf(unoccupiedHeatingSetpoint2.shortValue()) : null)) {
                return false;
            }
            Short minHeatSetpointLimit = getMinHeatSetpointLimit();
            Integer numValueOf12 = minHeatSetpointLimit != null ? Integer.valueOf(minHeatSetpointLimit.shortValue()) : null;
            Short minHeatSetpointLimit2 = attributes.getMinHeatSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf12, minHeatSetpointLimit2 != null ? Integer.valueOf(minHeatSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short maxHeatSetpointLimit = getMaxHeatSetpointLimit();
            Integer numValueOf13 = maxHeatSetpointLimit != null ? Integer.valueOf(maxHeatSetpointLimit.shortValue()) : null;
            Short maxHeatSetpointLimit2 = attributes.getMaxHeatSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf13, maxHeatSetpointLimit2 != null ? Integer.valueOf(maxHeatSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short minCoolSetpointLimit = getMinCoolSetpointLimit();
            Integer numValueOf14 = minCoolSetpointLimit != null ? Integer.valueOf(minCoolSetpointLimit.shortValue()) : null;
            Short minCoolSetpointLimit2 = attributes.getMinCoolSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf14, minCoolSetpointLimit2 != null ? Integer.valueOf(minCoolSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Short maxCoolSetpointLimit = getMaxCoolSetpointLimit();
            Integer numValueOf15 = maxCoolSetpointLimit != null ? Integer.valueOf(maxCoolSetpointLimit.shortValue()) : null;
            Short maxCoolSetpointLimit2 = attributes.getMaxCoolSetpointLimit();
            if (!Intrinsics.areEqual(numValueOf15, maxCoolSetpointLimit2 != null ? Integer.valueOf(maxCoolSetpointLimit2.shortValue()) : null)) {
                return false;
            }
            Byte minSetpointDeadBand = getMinSetpointDeadBand();
            Integer numValueOf16 = minSetpointDeadBand != null ? Integer.valueOf(minSetpointDeadBand.byteValue()) : null;
            Byte minSetpointDeadBand2 = attributes.getMinSetpointDeadBand();
            if (!Intrinsics.areEqual(numValueOf16, minSetpointDeadBand2 != null ? Integer.valueOf(minSetpointDeadBand2.byteValue()) : null) || !Intrinsics.areEqual(getRemoteSensing(), attributes.getRemoteSensing()) || getControlSequenceOfOperation() != attributes.getControlSequenceOfOperation() || getSystemMode() != attributes.getSystemMode() || getThermostatRunningMode() != attributes.getThermostatRunningMode() || getStartOfWeek() != attributes.getStartOfWeek() || !Intrinsics.areEqual(getNumberOfWeeklyTransitions(), attributes.getNumberOfWeeklyTransitions()) || !Intrinsics.areEqual(getNumberOfDailyTransitions(), attributes.getNumberOfDailyTransitions()) || getTemperatureSetpointHold() != attributes.getTemperatureSetpointHold() || !Intrinsics.areEqual(getTemperatureSetpointHoldDuration(), attributes.getTemperatureSetpointHoldDuration()) || !Intrinsics.areEqual(getThermostatProgrammingOperationMode(), attributes.getThermostatProgrammingOperationMode()) || !Intrinsics.areEqual(getThermostatRunningState(), attributes.getThermostatRunningState()) || getSetpointChangeSource() != attributes.getSetpointChangeSource()) {
                return false;
            }
            Short setpointChangeAmount = getSetpointChangeAmount();
            Integer numValueOf17 = setpointChangeAmount != null ? Integer.valueOf(setpointChangeAmount.shortValue()) : null;
            Short setpointChangeAmount2 = attributes.getSetpointChangeAmount();
            if (!Intrinsics.areEqual(numValueOf17, setpointChangeAmount2 != null ? Integer.valueOf(setpointChangeAmount2.shortValue()) : null) || !Intrinsics.areEqual(getSetpointChangeSourceTimestamp(), attributes.getSetpointChangeSourceTimestamp()) || !Intrinsics.areEqual(getOccupiedSetback(), attributes.getOccupiedSetback()) || !Intrinsics.areEqual(getOccupiedSetbackMin(), attributes.getOccupiedSetbackMin()) || !Intrinsics.areEqual(getOccupiedSetbackMax(), attributes.getOccupiedSetbackMax()) || !Intrinsics.areEqual(getUnoccupiedSetback(), attributes.getUnoccupiedSetback()) || !Intrinsics.areEqual(getUnoccupiedSetbackMin(), attributes.getUnoccupiedSetbackMin()) || !Intrinsics.areEqual(getUnoccupiedSetbackMax(), attributes.getUnoccupiedSetbackMax()) || !Intrinsics.areEqual(getEmergencyHeatDelta(), attributes.getEmergencyHeatDelta()) || getAcType() != attributes.getAcType() || !Intrinsics.areEqual(getAcCapacity(), attributes.getAcCapacity()) || getAcRefrigerantType() != attributes.getAcRefrigerantType() || getAcCompressorType() != attributes.getAcCompressorType() || !Intrinsics.areEqual(getAcErrorCode(), attributes.getAcErrorCode()) || getAcLouverPosition() != attributes.getAcLouverPosition()) {
                return false;
            }
            Short acCoilTemperature = getAcCoilTemperature();
            Integer numValueOf18 = acCoilTemperature != null ? Integer.valueOf(acCoilTemperature.shortValue()) : null;
            Short acCoilTemperature2 = attributes.getAcCoilTemperature();
            return Intrinsics.areEqual(numValueOf18, acCoilTemperature2 != null ? Integer.valueOf(acCoilTemperature2.shortValue()) : null) && getAcCapacityformat() == attributes.getAcCapacityformat() && Intrinsics.areEqual(getPresetTypes(), attributes.getPresetTypes()) && Intrinsics.areEqual(getScheduleTypes(), attributes.getScheduleTypes()) && Intrinsics.areEqual(getNumberOfPresets(), attributes.getNumberOfPresets()) && Intrinsics.areEqual(getNumberOfSchedules(), attributes.getNumberOfSchedules()) && Intrinsics.areEqual(getNumberOfScheduleTransitions(), attributes.getNumberOfScheduleTransitions()) && Intrinsics.areEqual(getNumberOfScheduleTransitionPerDay(), attributes.getNumberOfScheduleTransitionPerDay()) && Arrays.equals(getActivePresetHandle(), attributes.getActivePresetHandle()) && Arrays.equals(getActiveScheduleHandle(), attributes.getActiveScheduleHandle()) && Intrinsics.areEqual(getPresets(), attributes.getPresets()) && Intrinsics.areEqual(getSchedules(), attributes.getSchedules()) && Intrinsics.areEqual(getPresetsSchedulesEditable(), attributes.getPresetsSchedulesEditable()) && Intrinsics.areEqual(getTemperatureSetpointHoldPolicy(), attributes.getTemperatureSetpointHoldPolicy()) && Intrinsics.areEqual(getSetpointHoldExpiryTimestamp(), attributes.getSetpointHoldExpiryTimestamp()) && Intrinsics.areEqual(getQueuedPreset(), attributes.getQueuedPreset()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && Intrinsics.areEqual(getFeatureMap(), attributes.getFeatureMap()) && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getAbsMaxCoolSetpointLimit() {
            return this.absMaxCoolSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getAbsMaxHeatSetpointLimit() {
            return this.absMaxHeatSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getAbsMinCoolSetpointLimit() {
            return this.absMinCoolSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getAbsMinHeatSetpointLimit() {
            return this.absMinHeatSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getAcCapacity-XRpZGF0, reason: from getter */
        public UShort getAcCapacity() {
            return this.acCapacity;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcCapacityFormatEnum getAcCapacityformat() {
            return this.acCapacityformat;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getAcCoilTemperature() {
            return this.acCoilTemperature;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcCompressorTypeEnum getAcCompressorType() {
            return this.acCompressorType;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcErrorCodeBitmap getAcErrorCode() {
            return this.acErrorCode;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcLouverPositionEnum getAcLouverPosition() {
            return this.acLouverPosition;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcRefrigerantTypeEnum getAcRefrigerantType() {
            return this.acRefrigerantType;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcTypeEnum getAcType() {
            return this.acType;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public byte[] getActivePresetHandle() {
            return this.activePresetHandle;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public byte[] getActiveScheduleHandle() {
            return this.activeScheduleHandle;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public ControlSequenceOfOperationEnum getControlSequenceOfOperation() {
            return this.controlSequenceOfOperation;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getEmergencyHeatDelta-7PGSa80, reason: from getter */
        public UByte getEmergencyHeatDelta() {
            return this.emergencyHeatDelta;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Feature getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getHvacSystemTypeConfiguration-7PGSa80, reason: from getter */
        public UByte getHvacSystemTypeConfiguration() {
            return this.hvacSystemTypeConfiguration;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getLocalTemperature() {
            return this.localTemperature;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Byte getLocalTemperatureCalibration() {
            return this.localTemperatureCalibration;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMaxCoolSetpointLimit() {
            return this.maxCoolSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMaxHeatSetpointLimit() {
            return this.maxHeatSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMinCoolSetpointLimit() {
            return this.minCoolSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMinHeatSetpointLimit() {
            return this.minHeatSetpointLimit;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Byte getMinSetpointDeadBand() {
            return this.minSetpointDeadBand;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfDailyTransitions-7PGSa80, reason: from getter */
        public UByte getNumberOfDailyTransitions() {
            return this.numberOfDailyTransitions;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfPresets-7PGSa80, reason: from getter */
        public UByte getNumberOfPresets() {
            return this.numberOfPresets;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfScheduleTransitionPerDay-7PGSa80, reason: from getter */
        public UByte getNumberOfScheduleTransitionPerDay() {
            return this.numberOfScheduleTransitionPerDay;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfScheduleTransitions-7PGSa80, reason: from getter */
        public UByte getNumberOfScheduleTransitions() {
            return this.numberOfScheduleTransitions;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfSchedules-7PGSa80, reason: from getter */
        public UByte getNumberOfSchedules() {
            return this.numberOfSchedules;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfWeeklyTransitions-7PGSa80, reason: from getter */
        public UByte getNumberOfWeeklyTransitions() {
            return this.numberOfWeeklyTransitions;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getOccupancy-7PGSa80, reason: from getter */
        public UByte getOccupancy() {
            return this.occupancy;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getOccupiedCoolingSetpoint() {
            return this.occupiedCoolingSetpoint;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getOccupiedHeatingSetpoint() {
            return this.occupiedHeatingSetpoint;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getOccupiedSetback-7PGSa80, reason: from getter */
        public UByte getOccupiedSetback() {
            return this.occupiedSetback;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getOccupiedSetbackMax-7PGSa80, reason: from getter */
        public UByte getOccupiedSetbackMax() {
            return this.occupiedSetbackMax;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getOccupiedSetbackMin-7PGSa80, reason: from getter */
        public UByte getOccupiedSetbackMin() {
            return this.occupiedSetbackMin;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getOutdoorTemperature() {
            return this.outdoorTemperature;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getPiCoolingDemand-7PGSa80, reason: from getter */
        public UByte getPiCoolingDemand() {
            return this.piCoolingDemand;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getPiHeatingDemand-7PGSa80, reason: from getter */
        public UByte getPiHeatingDemand() {
            return this.piHeatingDemand;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<PresetTypeStruct> getPresetTypes() {
            return this.presetTypes;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<PresetStruct> getPresets() {
            return this.presets;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Boolean getPresetsSchedulesEditable() {
            return this.presetsSchedulesEditable;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public QueuedPresetStruct getQueuedPreset() {
            return this.queuedPreset;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public RemoteSensingBitmap getRemoteSensing() {
            return this.remoteSensing;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<ScheduleTypeStruct> getScheduleTypes() {
            return this.scheduleTypes;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<ScheduleStruct> getSchedules() {
            return this.schedules;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getSetpointChangeAmount() {
            return this.setpointChangeAmount;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public SetpointChangeSourceEnum getSetpointChangeSource() {
            return this.setpointChangeSource;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getSetpointChangeSourceTimestamp-0hXNFcg, reason: from getter */
        public UInt getSetpointChangeSourceTimestamp() {
            return this.setpointChangeSourceTimestamp;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getSetpointHoldExpiryTimestamp-0hXNFcg, reason: from getter */
        public UInt getSetpointHoldExpiryTimestamp() {
            return this.setpointHoldExpiryTimestamp;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public StartOfWeekEnum getStartOfWeek() {
            return this.startOfWeek;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public SystemModeEnum getSystemMode() {
            return this.systemMode;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public TemperatureSetpointHoldEnum getTemperatureSetpointHold() {
            return this.temperatureSetpointHold;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getTemperatureSetpointHoldDuration-XRpZGF0, reason: from getter */
        public UShort getTemperatureSetpointHoldDuration() {
            return this.temperatureSetpointHoldDuration;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public TemperatureSetpointHoldPolicyBitmap getTemperatureSetpointHoldPolicy() {
            return this.temperatureSetpointHoldPolicy;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public ProgrammingOperationModeBitmap getThermostatProgrammingOperationMode() {
            return this.thermostatProgrammingOperationMode;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public ThermostatRunningModeEnum getThermostatRunningMode() {
            return this.thermostatRunningMode;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public RelayStateBitmap getThermostatRunningState() {
            return this.thermostatRunningState;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getUnoccupiedCoolingSetpoint() {
            return this.unoccupiedCoolingSetpoint;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getUnoccupiedHeatingSetpoint() {
            return this.unoccupiedHeatingSetpoint;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getUnoccupiedSetback-7PGSa80, reason: from getter */
        public UByte getUnoccupiedSetback() {
            return this.unoccupiedSetback;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getUnoccupiedSetbackMax-7PGSa80, reason: from getter */
        public UByte getUnoccupiedSetbackMax() {
            return this.unoccupiedSetbackMax;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getUnoccupiedSetbackMin-7PGSa80, reason: from getter */
        public UByte getUnoccupiedSetbackMin() {
            return this.unoccupiedSetbackMin;
        }

        public int hashCode() {
            Short localTemperature = getLocalTemperature();
            int iHashCode = localTemperature != null ? localTemperature.hashCode() : 0;
            Short outdoorTemperature = getOutdoorTemperature();
            int iHashCode2 = outdoorTemperature != null ? outdoorTemperature.hashCode() : 0;
            int i = iHashCode + 31;
            UByte occupancy = getOccupancy();
            int iM2369hashCodeimpl = ((((i * 31) + iHashCode2) * 31) + (occupancy != null ? UByte.m2369hashCodeimpl(occupancy.getData()) : 0)) * 31;
            Short absMinHeatSetpointLimit = getAbsMinHeatSetpointLimit();
            int iHashCode3 = (iM2369hashCodeimpl + (absMinHeatSetpointLimit != null ? absMinHeatSetpointLimit.hashCode() : 0)) * 31;
            Short absMaxHeatSetpointLimit = getAbsMaxHeatSetpointLimit();
            int iHashCode4 = (iHashCode3 + (absMaxHeatSetpointLimit != null ? absMaxHeatSetpointLimit.hashCode() : 0)) * 31;
            Short absMinCoolSetpointLimit = getAbsMinCoolSetpointLimit();
            int iHashCode5 = (iHashCode4 + (absMinCoolSetpointLimit != null ? absMinCoolSetpointLimit.hashCode() : 0)) * 31;
            Short absMaxCoolSetpointLimit = getAbsMaxCoolSetpointLimit();
            int iHashCode6 = (iHashCode5 + (absMaxCoolSetpointLimit != null ? absMaxCoolSetpointLimit.hashCode() : 0)) * 31;
            UByte piCoolingDemand = getPiCoolingDemand();
            int iM2369hashCodeimpl2 = (iHashCode6 + (piCoolingDemand != null ? UByte.m2369hashCodeimpl(piCoolingDemand.getData()) : 0)) * 31;
            UByte piHeatingDemand = getPiHeatingDemand();
            int iM2369hashCodeimpl3 = (iM2369hashCodeimpl2 + (piHeatingDemand != null ? UByte.m2369hashCodeimpl(piHeatingDemand.getData()) : 0)) * 31;
            UByte hvacSystemTypeConfiguration = getHvacSystemTypeConfiguration();
            int iM2369hashCodeimpl4 = (iM2369hashCodeimpl3 + (hvacSystemTypeConfiguration != null ? UByte.m2369hashCodeimpl(hvacSystemTypeConfiguration.getData()) : 0)) * 31;
            Byte localTemperatureCalibration = getLocalTemperatureCalibration();
            int iHashCode7 = (iM2369hashCodeimpl4 + (localTemperatureCalibration != null ? localTemperatureCalibration.hashCode() : 0)) * 31;
            Short occupiedCoolingSetpoint = getOccupiedCoolingSetpoint();
            int iHashCode8 = (iHashCode7 + (occupiedCoolingSetpoint != null ? occupiedCoolingSetpoint.hashCode() : 0)) * 31;
            Short occupiedHeatingSetpoint = getOccupiedHeatingSetpoint();
            int iHashCode9 = (iHashCode8 + (occupiedHeatingSetpoint != null ? occupiedHeatingSetpoint.hashCode() : 0)) * 31;
            Short unoccupiedCoolingSetpoint = getUnoccupiedCoolingSetpoint();
            int iHashCode10 = (iHashCode9 + (unoccupiedCoolingSetpoint != null ? unoccupiedCoolingSetpoint.hashCode() : 0)) * 31;
            Short unoccupiedHeatingSetpoint = getUnoccupiedHeatingSetpoint();
            int iHashCode11 = (iHashCode10 + (unoccupiedHeatingSetpoint != null ? unoccupiedHeatingSetpoint.hashCode() : 0)) * 31;
            Short minHeatSetpointLimit = getMinHeatSetpointLimit();
            int iHashCode12 = (iHashCode11 + (minHeatSetpointLimit != null ? minHeatSetpointLimit.hashCode() : 0)) * 31;
            Short maxHeatSetpointLimit = getMaxHeatSetpointLimit();
            int iHashCode13 = (iHashCode12 + (maxHeatSetpointLimit != null ? maxHeatSetpointLimit.hashCode() : 0)) * 31;
            Short minCoolSetpointLimit = getMinCoolSetpointLimit();
            int iHashCode14 = (iHashCode13 + (minCoolSetpointLimit != null ? minCoolSetpointLimit.hashCode() : 0)) * 31;
            Short maxCoolSetpointLimit = getMaxCoolSetpointLimit();
            int iHashCode15 = (iHashCode14 + (maxCoolSetpointLimit != null ? maxCoolSetpointLimit.hashCode() : 0)) * 31;
            Byte minSetpointDeadBand = getMinSetpointDeadBand();
            int iHashCode16 = (iHashCode15 + (minSetpointDeadBand != null ? minSetpointDeadBand.hashCode() : 0)) * 31;
            RemoteSensingBitmap remoteSensing = getRemoteSensing();
            int iHashCode17 = (iHashCode16 + (remoteSensing != null ? remoteSensing.hashCode() : 0)) * 31;
            ControlSequenceOfOperationEnum controlSequenceOfOperation = getControlSequenceOfOperation();
            int iHashCode18 = (iHashCode17 + (controlSequenceOfOperation != null ? controlSequenceOfOperation.hashCode() : 0)) * 31;
            SystemModeEnum systemMode = getSystemMode();
            int iHashCode19 = (iHashCode18 + (systemMode != null ? systemMode.hashCode() : 0)) * 31;
            ThermostatRunningModeEnum thermostatRunningMode = getThermostatRunningMode();
            int iHashCode20 = (iHashCode19 + (thermostatRunningMode != null ? thermostatRunningMode.hashCode() : 0)) * 31;
            StartOfWeekEnum startOfWeek = getStartOfWeek();
            int iHashCode21 = (iHashCode20 + (startOfWeek != null ? startOfWeek.hashCode() : 0)) * 31;
            UByte numberOfWeeklyTransitions = getNumberOfWeeklyTransitions();
            int iM2369hashCodeimpl5 = (iHashCode21 + (numberOfWeeklyTransitions != null ? UByte.m2369hashCodeimpl(numberOfWeeklyTransitions.getData()) : 0)) * 31;
            UByte numberOfDailyTransitions = getNumberOfDailyTransitions();
            int iM2369hashCodeimpl6 = (iM2369hashCodeimpl5 + (numberOfDailyTransitions != null ? UByte.m2369hashCodeimpl(numberOfDailyTransitions.getData()) : 0)) * 31;
            TemperatureSetpointHoldEnum temperatureSetpointHold = getTemperatureSetpointHold();
            int iHashCode22 = (iM2369hashCodeimpl6 + (temperatureSetpointHold != null ? temperatureSetpointHold.hashCode() : 0)) * 31;
            UShort temperatureSetpointHoldDuration = getTemperatureSetpointHoldDuration();
            int iM2435hashCodeimpl = (iHashCode22 + (temperatureSetpointHoldDuration != null ? UShort.m2435hashCodeimpl(temperatureSetpointHoldDuration.getData()) : 0)) * 31;
            ProgrammingOperationModeBitmap thermostatProgrammingOperationMode = getThermostatProgrammingOperationMode();
            int iHashCode23 = (iM2435hashCodeimpl + (thermostatProgrammingOperationMode != null ? thermostatProgrammingOperationMode.hashCode() : 0)) * 31;
            RelayStateBitmap thermostatRunningState = getThermostatRunningState();
            int iHashCode24 = (iHashCode23 + (thermostatRunningState != null ? thermostatRunningState.hashCode() : 0)) * 31;
            SetpointChangeSourceEnum setpointChangeSource = getSetpointChangeSource();
            int iHashCode25 = (iHashCode24 + (setpointChangeSource != null ? setpointChangeSource.hashCode() : 0)) * 31;
            Short setpointChangeAmount = getSetpointChangeAmount();
            int iHashCode26 = (iHashCode25 + (setpointChangeAmount != null ? setpointChangeAmount.hashCode() : 0)) * 31;
            UInt setpointChangeSourceTimestamp = getSetpointChangeSourceTimestamp();
            int iM2391hashCodeimpl = (iHashCode26 + (setpointChangeSourceTimestamp != null ? UInt.m2391hashCodeimpl(setpointChangeSourceTimestamp.getData()) : 0)) * 31;
            UByte occupiedSetback = getOccupiedSetback();
            int iM2369hashCodeimpl7 = (iM2391hashCodeimpl + (occupiedSetback != null ? UByte.m2369hashCodeimpl(occupiedSetback.getData()) : 0)) * 31;
            UByte occupiedSetbackMin = getOccupiedSetbackMin();
            int iM2369hashCodeimpl8 = (iM2369hashCodeimpl7 + (occupiedSetbackMin != null ? UByte.m2369hashCodeimpl(occupiedSetbackMin.getData()) : 0)) * 31;
            UByte occupiedSetbackMax = getOccupiedSetbackMax();
            int iM2369hashCodeimpl9 = (iM2369hashCodeimpl8 + (occupiedSetbackMax != null ? UByte.m2369hashCodeimpl(occupiedSetbackMax.getData()) : 0)) * 31;
            UByte unoccupiedSetback = getUnoccupiedSetback();
            int iM2369hashCodeimpl10 = (iM2369hashCodeimpl9 + (unoccupiedSetback != null ? UByte.m2369hashCodeimpl(unoccupiedSetback.getData()) : 0)) * 31;
            UByte unoccupiedSetbackMin = getUnoccupiedSetbackMin();
            int iM2369hashCodeimpl11 = (iM2369hashCodeimpl10 + (unoccupiedSetbackMin != null ? UByte.m2369hashCodeimpl(unoccupiedSetbackMin.getData()) : 0)) * 31;
            UByte unoccupiedSetbackMax = getUnoccupiedSetbackMax();
            int iM2369hashCodeimpl12 = (iM2369hashCodeimpl11 + (unoccupiedSetbackMax != null ? UByte.m2369hashCodeimpl(unoccupiedSetbackMax.getData()) : 0)) * 31;
            UByte emergencyHeatDelta = getEmergencyHeatDelta();
            int iM2369hashCodeimpl13 = (iM2369hashCodeimpl12 + (emergencyHeatDelta != null ? UByte.m2369hashCodeimpl(emergencyHeatDelta.getData()) : 0)) * 31;
            AcTypeEnum acType = getAcType();
            int iHashCode27 = (iM2369hashCodeimpl13 + (acType != null ? acType.hashCode() : 0)) * 31;
            UShort acCapacity = getAcCapacity();
            int iM2435hashCodeimpl2 = (iHashCode27 + (acCapacity != null ? UShort.m2435hashCodeimpl(acCapacity.getData()) : 0)) * 31;
            AcRefrigerantTypeEnum acRefrigerantType = getAcRefrigerantType();
            int iHashCode28 = (iM2435hashCodeimpl2 + (acRefrigerantType != null ? acRefrigerantType.hashCode() : 0)) * 31;
            AcCompressorTypeEnum acCompressorType = getAcCompressorType();
            int iHashCode29 = (iHashCode28 + (acCompressorType != null ? acCompressorType.hashCode() : 0)) * 31;
            AcErrorCodeBitmap acErrorCode = getAcErrorCode();
            int iHashCode30 = (iHashCode29 + (acErrorCode != null ? acErrorCode.hashCode() : 0)) * 31;
            AcLouverPositionEnum acLouverPosition = getAcLouverPosition();
            int iHashCode31 = (iHashCode30 + (acLouverPosition != null ? acLouverPosition.hashCode() : 0)) * 31;
            Short acCoilTemperature = getAcCoilTemperature();
            int iHashCode32 = (iHashCode31 + (acCoilTemperature != null ? acCoilTemperature.hashCode() : 0)) * 31;
            AcCapacityFormatEnum acCapacityformat = getAcCapacityformat();
            int iHashCode33 = (iHashCode32 + (acCapacityformat != null ? acCapacityformat.hashCode() : 0)) * 31;
            List<PresetTypeStruct> presetTypes = getPresetTypes();
            int iHashCode34 = (iHashCode33 + (presetTypes != null ? presetTypes.hashCode() : 0)) * 31;
            List<ScheduleTypeStruct> scheduleTypes = getScheduleTypes();
            int iHashCode35 = (iHashCode34 + (scheduleTypes != null ? scheduleTypes.hashCode() : 0)) * 31;
            UByte numberOfPresets = getNumberOfPresets();
            int iM2369hashCodeimpl14 = (iHashCode35 + (numberOfPresets != null ? UByte.m2369hashCodeimpl(numberOfPresets.getData()) : 0)) * 31;
            UByte numberOfSchedules = getNumberOfSchedules();
            int iM2369hashCodeimpl15 = (iM2369hashCodeimpl14 + (numberOfSchedules != null ? UByte.m2369hashCodeimpl(numberOfSchedules.getData()) : 0)) * 31;
            UByte numberOfScheduleTransitions = getNumberOfScheduleTransitions();
            int iM2369hashCodeimpl16 = (iM2369hashCodeimpl15 + (numberOfScheduleTransitions != null ? UByte.m2369hashCodeimpl(numberOfScheduleTransitions.getData()) : 0)) * 31;
            UByte numberOfScheduleTransitionPerDay = getNumberOfScheduleTransitionPerDay();
            int iM2369hashCodeimpl17 = (iM2369hashCodeimpl16 + (numberOfScheduleTransitionPerDay != null ? UByte.m2369hashCodeimpl(numberOfScheduleTransitionPerDay.getData()) : 0)) * 31;
            byte[] activePresetHandle = getActivePresetHandle();
            int iHashCode36 = (iM2369hashCodeimpl17 + (activePresetHandle != null ? Arrays.hashCode(activePresetHandle) : 0)) * 31;
            byte[] activeScheduleHandle = getActiveScheduleHandle();
            int iHashCode37 = (iHashCode36 + (activeScheduleHandle != null ? Arrays.hashCode(activeScheduleHandle) : 0)) * 31;
            List<PresetStruct> presets = getPresets();
            int iHashCode38 = (iHashCode37 + (presets != null ? presets.hashCode() : 0)) * 31;
            List<ScheduleStruct> schedules = getSchedules();
            int iHashCode39 = (iHashCode38 + (schedules != null ? schedules.hashCode() : 0)) * 31;
            Boolean presetsSchedulesEditable = getPresetsSchedulesEditable();
            int iHashCode40 = (iHashCode39 + (presetsSchedulesEditable != null ? presetsSchedulesEditable.hashCode() : 0)) * 31;
            TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicy = getTemperatureSetpointHoldPolicy();
            int iHashCode41 = (iHashCode40 + (temperatureSetpointHoldPolicy != null ? temperatureSetpointHoldPolicy.hashCode() : 0)) * 31;
            UInt setpointHoldExpiryTimestamp = getSetpointHoldExpiryTimestamp();
            int iM2391hashCodeimpl2 = (iHashCode41 + (setpointHoldExpiryTimestamp != null ? UInt.m2391hashCodeimpl(setpointHoldExpiryTimestamp.getData()) : 0)) * 31;
            QueuedPresetStruct queuedPreset = getQueuedPreset();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((getFeatureMap().hashCode() + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iM2391hashCodeimpl2 + (queuedPreset != null ? queuedPreset.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            Short localTemperature = getLocalTemperature();
            Short outdoorTemperature = getOutdoorTemperature();
            UByte occupancy = getOccupancy();
            Short absMinHeatSetpointLimit = getAbsMinHeatSetpointLimit();
            Short absMaxHeatSetpointLimit = getAbsMaxHeatSetpointLimit();
            Short absMinCoolSetpointLimit = getAbsMinCoolSetpointLimit();
            Short absMaxCoolSetpointLimit = getAbsMaxCoolSetpointLimit();
            UByte piCoolingDemand = getPiCoolingDemand();
            UByte piHeatingDemand = getPiHeatingDemand();
            UByte hvacSystemTypeConfiguration = getHvacSystemTypeConfiguration();
            Byte localTemperatureCalibration = getLocalTemperatureCalibration();
            Short occupiedCoolingSetpoint = getOccupiedCoolingSetpoint();
            Short occupiedHeatingSetpoint = getOccupiedHeatingSetpoint();
            Short unoccupiedCoolingSetpoint = getUnoccupiedCoolingSetpoint();
            Short unoccupiedHeatingSetpoint = getUnoccupiedHeatingSetpoint();
            Short minHeatSetpointLimit = getMinHeatSetpointLimit();
            Short maxHeatSetpointLimit = getMaxHeatSetpointLimit();
            Short minCoolSetpointLimit = getMinCoolSetpointLimit();
            Short maxCoolSetpointLimit = getMaxCoolSetpointLimit();
            Byte minSetpointDeadBand = getMinSetpointDeadBand();
            RemoteSensingBitmap remoteSensing = getRemoteSensing();
            ControlSequenceOfOperationEnum controlSequenceOfOperation = getControlSequenceOfOperation();
            SystemModeEnum systemMode = getSystemMode();
            ThermostatRunningModeEnum thermostatRunningMode = getThermostatRunningMode();
            StartOfWeekEnum startOfWeek = getStartOfWeek();
            UByte numberOfWeeklyTransitions = getNumberOfWeeklyTransitions();
            UByte numberOfDailyTransitions = getNumberOfDailyTransitions();
            TemperatureSetpointHoldEnum temperatureSetpointHold = getTemperatureSetpointHold();
            UShort temperatureSetpointHoldDuration = getTemperatureSetpointHoldDuration();
            ProgrammingOperationModeBitmap thermostatProgrammingOperationMode = getThermostatProgrammingOperationMode();
            RelayStateBitmap thermostatRunningState = getThermostatRunningState();
            SetpointChangeSourceEnum setpointChangeSource = getSetpointChangeSource();
            Short setpointChangeAmount = getSetpointChangeAmount();
            UInt setpointChangeSourceTimestamp = getSetpointChangeSourceTimestamp();
            UByte occupiedSetback = getOccupiedSetback();
            UByte occupiedSetbackMin = getOccupiedSetbackMin();
            UByte occupiedSetbackMax = getOccupiedSetbackMax();
            UByte unoccupiedSetback = getUnoccupiedSetback();
            UByte unoccupiedSetbackMin = getUnoccupiedSetbackMin();
            UByte unoccupiedSetbackMax = getUnoccupiedSetbackMax();
            UByte emergencyHeatDelta = getEmergencyHeatDelta();
            AcTypeEnum acType = getAcType();
            UShort acCapacity = getAcCapacity();
            AcRefrigerantTypeEnum acRefrigerantType = getAcRefrigerantType();
            AcCompressorTypeEnum acCompressorType = getAcCompressorType();
            AcErrorCodeBitmap acErrorCode = getAcErrorCode();
            AcLouverPositionEnum acLouverPosition = getAcLouverPosition();
            Short acCoilTemperature = getAcCoilTemperature();
            AcCapacityFormatEnum acCapacityformat = getAcCapacityformat();
            List<PresetTypeStruct> presetTypes = getPresetTypes();
            List<ScheduleTypeStruct> scheduleTypes = getScheduleTypes();
            UByte numberOfPresets = getNumberOfPresets();
            UByte numberOfSchedules = getNumberOfSchedules();
            UByte numberOfScheduleTransitions = getNumberOfScheduleTransitions();
            UByte numberOfScheduleTransitionPerDay = getNumberOfScheduleTransitionPerDay();
            byte[] activePresetHandle = getActivePresetHandle();
            byte[] activeScheduleHandle = getActiveScheduleHandle();
            List<PresetStruct> presets = getPresets();
            List<ScheduleStruct> schedules = getSchedules();
            Boolean presetsSchedulesEditable = getPresetsSchedulesEditable();
            TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicy = getTemperatureSetpointHoldPolicy();
            UInt setpointHoldExpiryTimestamp = getSetpointHoldExpiryTimestamp();
            QueuedPresetStruct queuedPreset = getQueuedPreset();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            Feature featureMap = getFeatureMap();
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int iM = zzba$$ExternalSyntheticOutline0.m(String.valueOf(localTemperature).length(), 49, String.valueOf(outdoorTemperature).length(), 12, String.valueOf(occupancy).length());
            int length = iM + 26 + String.valueOf(absMinHeatSetpointLimit).length() + 26 + String.valueOf(absMaxHeatSetpointLimit).length() + 26 + String.valueOf(absMinCoolSetpointLimit).length() + 26;
            int length2 = String.valueOf(absMaxCoolSetpointLimit).length();
            int length3 = length + length2 + 18 + String.valueOf(piCoolingDemand).length() + 18;
            int length4 = String.valueOf(piHeatingDemand).length();
            int length5 = length3 + length4 + 30 + String.valueOf(hvacSystemTypeConfiguration).length() + 30;
            int length6 = String.valueOf(localTemperatureCalibration).length();
            String strValueOf = String.valueOf(occupiedCoolingSetpoint);
            int length7 = length5 + length6 + 26 + strValueOf.length() + 26 + String.valueOf(occupiedHeatingSetpoint).length() + 28 + String.valueOf(unoccupiedCoolingSetpoint).length() + 28;
            int length8 = String.valueOf(unoccupiedHeatingSetpoint).length();
            int length9 = length7 + length8 + 23 + String.valueOf(minHeatSetpointLimit).length() + 23 + String.valueOf(maxHeatSetpointLimit).length() + 23 + String.valueOf(minCoolSetpointLimit).length() + 23 + String.valueOf(maxCoolSetpointLimit).length() + 22 + String.valueOf(minSetpointDeadBand).length() + 16 + String.valueOf(remoteSensing).length() + 29 + String.valueOf(controlSequenceOfOperation).length() + 13 + String.valueOf(systemMode).length() + 24;
            int length10 = String.valueOf(thermostatRunningMode).length();
            int iM2 = zzba$$ExternalSyntheticOutline0.m(String.valueOf(setpointChangeSource).length() + zzba$$ExternalSyntheticOutline0.m(length9 + length10 + 14 + String.valueOf(startOfWeek).length() + 28 + String.valueOf(numberOfWeeklyTransitions).length() + 27 + String.valueOf(numberOfDailyTransitions).length() + 26 + String.valueOf(temperatureSetpointHold).length() + 34 + String.valueOf(temperatureSetpointHoldDuration).length() + 37 + String.valueOf(thermostatProgrammingOperationMode).length() + 25, 23, String.valueOf(thermostatRunningState)) + 23 + String.valueOf(setpointChangeAmount).length() + 32, 18, String.valueOf(setpointChangeSourceTimestamp));
            int length11 = String.valueOf(occupiedSetback).length();
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(featureMap).length() + String.valueOf(attributeList).length() + String.valueOf(acceptedCommandList).length() + String.valueOf(generatedCommandList).length() + zzba$$ExternalSyntheticOutline0.m(String.valueOf(temperatureSetpointHoldPolicy).length() + String.valueOf(presetsSchedulesEditable).length() + String.valueOf(schedules).length() + zzba$$ExternalSyntheticOutline0.m(String.valueOf(activePresetHandle).length() + zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(String.valueOf(scheduleTypes).length() + String.valueOf(presetTypes).length() + zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(String.valueOf(unoccupiedSetbackMin).length() + zzba$$ExternalSyntheticOutline0.m(iM2 + length11 + 21 + String.valueOf(occupiedSetbackMin).length() + 21 + String.valueOf(occupiedSetbackMax).length() + 20, 23, String.valueOf(unoccupiedSetback)) + 23 + String.valueOf(unoccupiedSetbackMax).length() + 21 + String.valueOf(emergencyHeatDelta).length() + 9, 13, String.valueOf(acType)) + String.valueOf(acCapacity).length() + 20 + String.valueOf(acRefrigerantType).length() + 19, 14, String.valueOf(acCompressorType)) + String.valueOf(acErrorCode).length() + 19 + String.valueOf(acLouverPosition).length() + 20 + String.valueOf(acCoilTemperature).length() + 19, 14, String.valueOf(acCapacityformat)) + 16 + 18 + String.valueOf(numberOfPresets).length() + 20, 30, String.valueOf(numberOfSchedules)) + String.valueOf(numberOfScheduleTransitions).length() + 35, 21, String.valueOf(numberOfScheduleTransitionPerDay)) + 23 + String.valueOf(activeScheduleHandle).length() + 10, 12, String.valueOf(presets)) + 27 + 32 + 30 + String.valueOf(setpointHoldExpiryTimestamp).length() + 15, 23, String.valueOf(queuedPreset)) + 22 + 16 + 13 + 18, strM2436toStringimpl) + 1);
            sb.append("Thermostat(localTemperature=");
            sb.append(localTemperature);
            sb.append(", outdoorTemperature=");
            sb.append(outdoorTemperature);
            sb.append(", occupancy=");
            sb.append(occupancy);
            sb.append(", absMinHeatSetpointLimit=");
            sb.append(absMinHeatSetpointLimit);
            sb.append(", absMaxHeatSetpointLimit=");
            sb.append(absMaxHeatSetpointLimit);
            sb.append(", absMinCoolSetpointLimit=");
            sb.append(absMinCoolSetpointLimit);
            sb.append(", absMaxCoolSetpointLimit=");
            sb.append(absMaxCoolSetpointLimit);
            sb.append(", piCoolingDemand=");
            sb.append(piCoolingDemand);
            sb.append(", piHeatingDemand=");
            sb.append(piHeatingDemand);
            sb.append(", hvacSystemTypeConfiguration=");
            sb.append(hvacSystemTypeConfiguration);
            sb.append(", localTemperatureCalibration=");
            sb.append(localTemperatureCalibration);
            sb.append(", occupiedCoolingSetpoint=");
            sb.append(occupiedCoolingSetpoint);
            sb.append(", occupiedHeatingSetpoint=");
            sb.append(occupiedHeatingSetpoint);
            sb.append(", unoccupiedCoolingSetpoint=");
            sb.append(unoccupiedCoolingSetpoint);
            sb.append(", unoccupiedHeatingSetpoint=");
            sb.append(unoccupiedHeatingSetpoint);
            sb.append(", minHeatSetpointLimit=");
            sb.append(minHeatSetpointLimit);
            sb.append(", maxHeatSetpointLimit=");
            sb.append(maxHeatSetpointLimit);
            sb.append(", minCoolSetpointLimit=");
            sb.append(minCoolSetpointLimit);
            sb.append(", maxCoolSetpointLimit=");
            sb.append(maxCoolSetpointLimit);
            sb.append(", minSetpointDeadBand=");
            sb.append(minSetpointDeadBand);
            sb.append(", remoteSensing=");
            sb.append(remoteSensing);
            sb.append(", controlSequenceOfOperation=");
            sb.append(controlSequenceOfOperation);
            sb.append(", systemMode=");
            sb.append(systemMode);
            sb.append(", thermostatRunningMode=");
            sb.append(thermostatRunningMode);
            sb.append(", startOfWeek=");
            sb.append(startOfWeek);
            sb.append(", numberOfWeeklyTransitions=");
            sb.append(numberOfWeeklyTransitions);
            sb.append(", numberOfDailyTransitions=");
            sb.append(numberOfDailyTransitions);
            sb.append(", temperatureSetpointHold=");
            sb.append(temperatureSetpointHold);
            sb.append(", temperatureSetpointHoldDuration=");
            sb.append(temperatureSetpointHoldDuration);
            sb.append(", thermostatProgrammingOperationMode=");
            sb.append(thermostatProgrammingOperationMode);
            sb.append(", thermostatRunningState=");
            sb.append(thermostatRunningState);
            sb.append(", setpointChangeSource=");
            sb.append(setpointChangeSource);
            sb.append(", setpointChangeAmount=");
            sb.append(setpointChangeAmount);
            sb.append(", setpointChangeSourceTimestamp=");
            sb.append(setpointChangeSourceTimestamp);
            sb.append(", occupiedSetback=");
            sb.append(occupiedSetback);
            sb.append(", occupiedSetbackMin=");
            sb.append(occupiedSetbackMin);
            sb.append(", occupiedSetbackMax=");
            sb.append(occupiedSetbackMax);
            sb.append(", unoccupiedSetback=");
            sb.append(unoccupiedSetback);
            sb.append(", unoccupiedSetbackMin=");
            sb.append(unoccupiedSetbackMin);
            sb.append(", unoccupiedSetbackMax=");
            sb.append(unoccupiedSetbackMax);
            sb.append(", emergencyHeatDelta=");
            sb.append(emergencyHeatDelta);
            sb.append(", acType=");
            sb.append(acType);
            sb.append(", acCapacity=");
            sb.append(acCapacity);
            sb.append(", acRefrigerantType=");
            sb.append(acRefrigerantType);
            sb.append(", acCompressorType=");
            sb.append(acCompressorType);
            sb.append(", acErrorCode=");
            sb.append(acErrorCode);
            sb.append(", acLouverPosition=");
            sb.append(acLouverPosition);
            sb.append(", acCoilTemperature=");
            return zzaf.zza(strM2436toStringimpl, featureMap, attributeList, acceptedCommandList, generatedCommandList, queuedPreset, setpointHoldExpiryTimestamp, temperatureSetpointHoldPolicy, presetsSchedulesEditable, schedules, presets, activeScheduleHandle, activePresetHandle, numberOfScheduleTransitionPerDay, numberOfScheduleTransitions, numberOfSchedules, numberOfPresets, sb, scheduleTypes, presetTypes, acCapacityformat, acCoilTemperature, ", presetsSchedulesEditable=", ", presetTypes=", ", activeScheduleHandle=", ", scheduleTypes=", ", numberOfScheduleTransitionPerDay=", ", numberOfSchedules=", ", numberOfScheduleTransitions=", ", activePresetHandle=", ", presets=", ", acCapacityformat=", ", numberOfPresets=", ", schedules=", ", queuedPreset=", ", temperatureSetpointHoldPolicy=", ", setpointHoldExpiryTimestamp=");
        }

        public /* synthetic */ AttributesImpl(Short sh, Short sh2, UByte uByte, Short sh3, Short sh4, Short sh5, Short sh6, UByte uByte2, UByte uByte3, UByte uByte4, Byte b, Short sh7, Short sh8, Short sh9, Short sh10, Short sh11, Short sh12, Short sh13, Short sh14, Byte b2, RemoteSensingBitmap remoteSensingBitmap, ControlSequenceOfOperationEnum controlSequenceOfOperationEnum, SystemModeEnum systemModeEnum, ThermostatRunningModeEnum thermostatRunningModeEnum, StartOfWeekEnum startOfWeekEnum, UByte uByte5, UByte uByte6, TemperatureSetpointHoldEnum temperatureSetpointHoldEnum, UShort uShort, ProgrammingOperationModeBitmap programmingOperationModeBitmap, RelayStateBitmap relayStateBitmap, SetpointChangeSourceEnum setpointChangeSourceEnum, Short sh15, UInt uInt, UByte uByte7, UByte uByte8, UByte uByte9, UByte uByte10, UByte uByte11, UByte uByte12, UByte uByte13, AcTypeEnum acTypeEnum, UShort uShort2, AcRefrigerantTypeEnum acRefrigerantTypeEnum, AcCompressorTypeEnum acCompressorTypeEnum, AcErrorCodeBitmap acErrorCodeBitmap, AcLouverPositionEnum acLouverPositionEnum, Short sh16, AcCapacityFormatEnum acCapacityFormatEnum, List list, List list2, UByte uByte14, UByte uByte15, UByte uByte16, UByte uByte17, byte[] bArr, byte[] bArr2, List list3, List list4, Boolean bool, TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicyBitmap, UInt uInt2, QueuedPresetStruct queuedPresetStruct, List list5, List list6, List list7, Feature feature, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(sh, sh2, uByte, sh3, sh4, sh5, sh6, uByte2, uByte3, uByte4, b, sh7, sh8, sh9, sh10, sh11, sh12, sh13, sh14, b2, remoteSensingBitmap, controlSequenceOfOperationEnum, systemModeEnum, thermostatRunningModeEnum, startOfWeekEnum, uByte5, uByte6, temperatureSetpointHoldEnum, uShort, programmingOperationModeBitmap, relayStateBitmap, setpointChangeSourceEnum, sh15, uInt, uByte7, uByte8, uByte9, uByte10, uByte11, uByte12, uByte13, acTypeEnum, uShort2, acRefrigerantTypeEnum, acCompressorTypeEnum, acErrorCodeBitmap, acLouverPositionEnum, sh16, acCapacityFormatEnum, list, list2, uByte14, uByte15, uByte16, uByte17, bArr, bArr2, list3, list4, bool, temperatureSetpointHoldPolicyBitmap, uInt2, queuedPresetStruct, list5, list6, list7, feature, s);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$CancelPresetsSchedulesEditRequestCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CancelPresetsSchedulesEditRequestCommand implements CommandDescriptor {
        public static final CancelPresetsSchedulesEditRequestCommand INSTANCE = new CancelPresetsSchedulesEditRequestCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 8, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private CancelPresetsSchedulesEditRequestCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$CancelSetActivePresetRequestCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CancelSetActivePresetRequestCommand implements CommandDescriptor {
        public static final CancelSetActivePresetRequestCommand INSTANCE = new CancelSetActivePresetRequestCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 10, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private CancelSetActivePresetRequestCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ClearWeeklyScheduleCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ClearWeeklyScheduleCommand implements CommandDescriptor {
        public static final ClearWeeklyScheduleCommand INSTANCE = new ClearWeeklyScheduleCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 3, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private ClearWeeklyScheduleCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$CommitPresetsSchedulesRequestCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CommitPresetsSchedulesRequestCommand implements CommandDescriptor {
        public static final CommitPresetsSchedulesRequestCommand INSTANCE = new CommitPresetsSchedulesRequestCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 9, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private CommitPresetsSchedulesRequestCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'Bu\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b \u0010\u001cR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b!\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b#\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b%\u0010\u001cR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b&\u0010\u001c¨\u0006("}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "heating", "cooling", "occupancy", "scheduleConfiguration", "setback", "autoMode", "localTemperatureNotExposed", "matterScheduleConfiguration", "presets", "setpoints", "queuedPresetsSupported", "<init>", "(ZZZZZZZZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHeating", "()Z", "getCooling", "getOccupancy", "getScheduleConfiguration", "getSetback", "getAutoMode", "getLocalTemperatureNotExposed", "getMatterScheduleConfiguration", "getPresets", "getSetpoints", "getQueuedPresetsSupported", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Feature extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean autoMode;
        private final boolean cooling;
        private final boolean heating;
        private final boolean localTemperatureNotExposed;
        private final boolean matterScheduleConfiguration;
        private final boolean occupancy;
        private final boolean presets;
        private final boolean queuedPresetsSupported;
        private final boolean scheduleConfiguration;
        private final boolean setback;
        private final boolean setpoints;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$Feature$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$Feature$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$Feature;", "<init>", "()V", "HEATING_FLAG", "Lkotlin/ULong;", "J", "COOLING_FLAG", "OCCUPANCY_FLAG", "SCHEDULE_CONFIGURATION_FLAG", "SETBACK_FLAG", "AUTO_MODE_FLAG", "LOCAL_TEMPERATURE_NOT_EXPOSED_FLAG", "MATTER_SCHEDULE_CONFIGURATION_FLAG", "PRESETS_FLAG", "SETPOINTS_FLAG", "QUEUED_PRESETS_SUPPORTED_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<Feature> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(Feature value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getHeating());
                mutableBitmap.m564set4PLdz1A(2L, value.getCooling());
                mutableBitmap.m564set4PLdz1A(4L, value.getOccupancy());
                mutableBitmap.m564set4PLdz1A(8L, value.getScheduleConfiguration());
                mutableBitmap.m564set4PLdz1A(16L, value.getSetback());
                mutableBitmap.m564set4PLdz1A(32L, value.getAutoMode());
                mutableBitmap.m564set4PLdz1A(64L, value.getLocalTemperatureNotExposed());
                mutableBitmap.m564set4PLdz1A(128L, value.getMatterScheduleConfiguration());
                mutableBitmap.m564set4PLdz1A(256L, value.getPresets());
                mutableBitmap.m564set4PLdz1A(512L, value.getSetpoints());
                mutableBitmap.m564set4PLdz1A(1024L, value.getQueuedPresetsSupported());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Feature toRuntime(Bitmap value) {
                value.getClass();
                return new Feature(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L), value.m525getVKZWuLQ(16L), value.m525getVKZWuLQ(32L), value.m525getVKZWuLQ(64L), value.m525getVKZWuLQ(128L), value.m525getVKZWuLQ(256L), value.m525getVKZWuLQ(512L), value.m525getVKZWuLQ(1024L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Feature(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "Feature");
            this.heating = z;
            this.cooling = z2;
            this.occupancy = z3;
            this.scheduleConfiguration = z4;
            this.setback = z5;
            this.autoMode = z6;
            this.localTemperatureNotExposed = z7;
            this.matterScheduleConfiguration = z8;
            this.presets = z9;
            this.setpoints = z10;
            this.queuedPresetsSupported = z11;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Feature)) {
                return false;
            }
            Feature feature = (Feature) other;
            return this.heating == feature.heating && this.cooling == feature.cooling && this.occupancy == feature.occupancy && this.scheduleConfiguration == feature.scheduleConfiguration && this.setback == feature.setback && this.autoMode == feature.autoMode && this.localTemperatureNotExposed == feature.localTemperatureNotExposed && this.matterScheduleConfiguration == feature.matterScheduleConfiguration && this.presets == feature.presets && this.setpoints == feature.setpoints && this.queuedPresetsSupported == feature.queuedPresetsSupported;
        }

        public final boolean getAutoMode() {
            return this.autoMode;
        }

        public final boolean getCooling() {
            return this.cooling;
        }

        public final boolean getHeating() {
            return this.heating;
        }

        public final boolean getLocalTemperatureNotExposed() {
            return this.localTemperatureNotExposed;
        }

        public final boolean getMatterScheduleConfiguration() {
            return this.matterScheduleConfiguration;
        }

        public final boolean getOccupancy() {
            return this.occupancy;
        }

        public final boolean getPresets() {
            return this.presets;
        }

        public final boolean getQueuedPresetsSupported() {
            return this.queuedPresetsSupported;
        }

        public final boolean getScheduleConfiguration() {
            return this.scheduleConfiguration;
        }

        public final boolean getSetback() {
            return this.setback;
        }

        public final boolean getSetpoints() {
            return this.setpoints;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.cooling) + (Boolean.hashCode(this.heating) * 31);
            int iHashCode2 = Boolean.hashCode(this.occupancy) + (iHashCode * 31);
            int iHashCode3 = Boolean.hashCode(this.scheduleConfiguration) + (iHashCode2 * 31);
            int iHashCode4 = Boolean.hashCode(this.setback) + (iHashCode3 * 31);
            int iHashCode5 = Boolean.hashCode(this.autoMode) + (iHashCode4 * 31);
            int iHashCode6 = Boolean.hashCode(this.localTemperatureNotExposed) + (iHashCode5 * 31);
            int iHashCode7 = Boolean.hashCode(this.matterScheduleConfiguration) + (iHashCode6 * 31);
            int iHashCode8 = Boolean.hashCode(this.presets) + (iHashCode7 * 31);
            int iHashCode9 = Boolean.hashCode(this.setpoints);
            return Boolean.hashCode(this.queuedPresetsSupported) + ((iHashCode9 + (iHashCode8 * 31)) * 31);
        }

        public String toString() {
            boolean z = this.heating;
            int length = String.valueOf(z).length();
            boolean z2 = this.cooling;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.occupancy;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.scheduleConfiguration;
            int length4 = String.valueOf(z4).length();
            boolean z5 = this.setback;
            int length5 = String.valueOf(z5).length();
            boolean z6 = this.autoMode;
            int length6 = String.valueOf(z6).length();
            boolean z7 = this.localTemperatureNotExposed;
            int length7 = String.valueOf(z7).length();
            boolean z8 = this.matterScheduleConfiguration;
            int length8 = String.valueOf(z8).length();
            boolean z9 = this.presets;
            int length9 = String.valueOf(z9).length();
            boolean z10 = this.setpoints;
            int length10 = String.valueOf(z10).length();
            boolean z11 = this.queuedPresetsSupported;
            StringBuilder sb = new StringBuilder(length + 26 + length2 + 12 + length3 + 24 + length4 + 10 + length5 + 11 + length6 + 29 + length7 + 30 + length8 + 10 + length9 + 12 + length10 + 25 + String.valueOf(z11).length() + 1);
            zza$$ExternalSyntheticOutline0.m(sb, "Feature(heating=", z, ", cooling=", z2);
            zza$$ExternalSyntheticOutline0.m(sb, ", occupancy=", z3, ", scheduleConfiguration=", z4);
            zza$$ExternalSyntheticOutline0.m(sb, ", setback=", z5, ", autoMode=", z6);
            zza$$ExternalSyntheticOutline0.m(sb, ", localTemperatureNotExposed=", z7, ", matterScheduleConfiguration=", z8);
            zza$$ExternalSyntheticOutline0.m(sb, ", presets=", z9, ", setpoints=", z10);
            sb.append(", queuedPresetsSupported=");
            sb.append(z11);
            sb.append(")");
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$GetWeeklyScheduleCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "responseId", "getResponseId", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GetWeeklyScheduleCommand implements CommandDescriptor {
        public static final GetWeeklyScheduleCommand INSTANCE = new GetWeeklyScheduleCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;
        private static final ScopedCommandId responseId;

        static {
            ThermostatTrait thermostatTrait = ThermostatTrait.INSTANCE;
            ScopedCommandId scopedCommandId = new ScopedCommandId(thermostatTrait.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
            responseId = new ScopedCommandId(thermostatTrait.getId(), 0, null);
        }

        private GetWeeklyScheduleCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields thermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields : ThermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields.values()) {
                if (thermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields thermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields : ThermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$GetWeeklyScheduleCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$HvacSystemTypeBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "coolingStage", "heatingStage", "heatingIsHeatPump", "heatingUsesFuel", "<init>", "(ZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCoolingStage", "()Z", "getHeatingStage", "getHeatingIsHeatPump", "getHeatingUsesFuel", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class HvacSystemTypeBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean coolingStage;
        private final boolean heatingIsHeatPump;
        private final boolean heatingStage;
        private final boolean heatingUsesFuel;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$HvacSystemTypeBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$HvacSystemTypeBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$HvacSystemTypeBitmap;", "<init>", "()V", "COOLING_STAGE_FLAG", "Lkotlin/ULong;", "J", "HEATING_STAGE_FLAG", "HEATING_IS_HEAT_PUMP_FLAG", "HEATING_USES_FUEL_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<HvacSystemTypeBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(HvacSystemTypeBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(3L, value.getCoolingStage());
                mutableBitmap.m564set4PLdz1A(12L, value.getHeatingStage());
                mutableBitmap.m564set4PLdz1A(16L, value.getHeatingIsHeatPump());
                mutableBitmap.m564set4PLdz1A(32L, value.getHeatingUsesFuel());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public HvacSystemTypeBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new HvacSystemTypeBitmap(value.m525getVKZWuLQ(3L), value.m525getVKZWuLQ(12L), value.m525getVKZWuLQ(16L), value.m525getVKZWuLQ(32L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public HvacSystemTypeBitmap(boolean z, boolean z2, boolean z3, boolean z4) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "HvacSystemTypeBitmap");
            this.coolingStage = z;
            this.heatingStage = z2;
            this.heatingIsHeatPump = z3;
            this.heatingUsesFuel = z4;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HvacSystemTypeBitmap)) {
                return false;
            }
            HvacSystemTypeBitmap hvacSystemTypeBitmap = (HvacSystemTypeBitmap) other;
            return this.coolingStage == hvacSystemTypeBitmap.coolingStage && this.heatingStage == hvacSystemTypeBitmap.heatingStage && this.heatingIsHeatPump == hvacSystemTypeBitmap.heatingIsHeatPump && this.heatingUsesFuel == hvacSystemTypeBitmap.heatingUsesFuel;
        }

        public final boolean getCoolingStage() {
            return this.coolingStage;
        }

        public final boolean getHeatingIsHeatPump() {
            return this.heatingIsHeatPump;
        }

        public final boolean getHeatingStage() {
            return this.heatingStage;
        }

        public final boolean getHeatingUsesFuel() {
            return this.heatingUsesFuel;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.heatingStage) + (Boolean.hashCode(this.coolingStage) * 31);
            int iHashCode2 = Boolean.hashCode(this.heatingIsHeatPump);
            return Boolean.hashCode(this.heatingUsesFuel) + ((iHashCode2 + (iHashCode * 31)) * 31);
        }

        public String toString() {
            boolean z = this.coolingStage;
            int length = String.valueOf(z).length();
            boolean z2 = this.heatingStage;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.heatingIsHeatPump;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.heatingUsesFuel;
            return zzs.zza(z4, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 49, length2, 20, length3, 18, String.valueOf(z4).length()) + 1), z3, z2, z, "HvacSystemTypeBitmap(coolingStage=", ", heatingStage=", ", heatingIsHeatPump=", ", heatingUsesFuel=");
        }
    }

    @Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b?\u0018\u0000 í\u00012\u00020\u0001:\u0002í\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R$\u0010)\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R$\u0010,\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R$\u0010/\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001e\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R$\u00102\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001e\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R$\u00105\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R$\u00108\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0017\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR$\u0010<\u001a\u0004\u0018\u00010;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010J\u001a\u0004\u0018\u00010I8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010Q\u001a\u0004\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010X\u001a\u0004\u0018\u00010W8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010^\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010e\u001a\u0004\u0018\u00010d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010k\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0010\u001a\u0004\bl\u0010\u0012\"\u0004\bm\u0010\u0014R\"\u0010n\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bn\u0010_\u001a\u0004\bo\u0010a\"\u0004\bp\u0010cR$\u0010q\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0010\u001a\u0004\br\u0010\u0012\"\u0004\bs\u0010\u0014R\"\u0010t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010_\u001a\u0004\bu\u0010a\"\u0004\bv\u0010cR$\u0010w\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bw\u0010\u0010\u001a\u0004\bx\u0010\u0012\"\u0004\by\u0010\u0014R%\u0010{\u001a\u0004\u0018\u00010z8\u0000@\u0000X\u0080\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010W8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010Y\u001a\u0005\b\u0082\u0001\u0010[\"\u0005\b\u0083\u0001\u0010]R,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R3\u0010©\u0001\u001a\f\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010§\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R3\u0010°\u0001\u001a\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010§\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b°\u0001\u0010ª\u0001\u001a\u0006\b±\u0001\u0010¬\u0001\"\u0006\b²\u0001\u0010®\u0001R\u0018\u0010´\u0001\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010\u0012R\u0018\u0010¶\u0001\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bµ\u0001\u0010\u0019R\u0018\u0010¸\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010 R\u0018\u0010º\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010 R\u0018\u0010¼\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010 R\u0018\u0010¾\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b½\u0001\u0010 R\u0018\u0010À\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010 R\u0018\u0010Â\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010 R\u0018\u0010Ä\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010 R\u0018\u0010Æ\u0001\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010 R\u0018\u0010È\u0001\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010\u0019R\u0018\u0010Ê\u0001\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010?R\u0018\u0010Ì\u0001\u001a\u0004\u0018\u00010B8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u0010FR\u0018\u0010Î\u0001\u001a\u0004\u0018\u00010I8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010MR\u0018\u0010Ð\u0001\u001a\u0004\u0018\u00010P8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010TR\u0018\u0010Ò\u0001\u001a\u0004\u0018\u00010W8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010[R\u0018\u0010Ô\u0001\u001a\u0004\u0018\u00010d8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÓ\u0001\u0010hR\u0018\u0010Ö\u0001\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÕ\u0001\u0010\u0012R\u0018\u0010Ø\u0001\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b×\u0001\u0010\u0012R\u0018\u0010Ú\u0001\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÙ\u0001\u0010\u0012R\u0018\u0010Ü\u0001\u001a\u0004\u0018\u00010z8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÛ\u0001\u0010~R\u0018\u0010Þ\u0001\u001a\u0004\u0018\u00010W8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÝ\u0001\u0010[R\u001a\u0010à\u0001\u001a\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bß\u0001\u0010\u0088\u0001R\u001a\u0010â\u0001\u001a\u0005\u0018\u00010\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010\u008f\u0001R\u001a\u0010ä\u0001\u001a\u0005\u0018\u00010\u0092\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bã\u0001\u0010\u0096\u0001R\u001a\u0010æ\u0001\u001a\u0005\u0018\u00010\u0099\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bå\u0001\u0010\u009d\u0001R\u001a\u0010è\u0001\u001a\u0005\u0018\u00010 \u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bç\u0001\u0010¤\u0001R!\u0010ê\u0001\u001a\f\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010§\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010¬\u0001R!\u0010ì\u0001\u001a\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010§\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bë\u0001\u0010¬\u0001¨\u0006î\u0001"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$MutableAttributes;", "Lcom/google/home/matter/standard/ThermostatTrait$AttributesImpl;", "Lcom/google/home/matter/standard/ThermostatTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/matter/standard/ThermostatTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UByte;", "_hvacSystemTypeConfiguration", "Lkotlin/UByte;", "get_hvacSystemTypeConfiguration-7PGSa80$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UByte;", "set_hvacSystemTypeConfiguration-3swpYEE$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UByte;)V", "", "_localTemperatureCalibration", "Ljava/lang/Byte;", "get_localTemperatureCalibration$java_com_google_home_matter_standard_clusters_android", "()Ljava/lang/Byte;", "set_localTemperatureCalibration$java_com_google_home_matter_standard_clusters_android", "(Ljava/lang/Byte;)V", "", "_occupiedCoolingSetpoint", "Ljava/lang/Short;", "get_occupiedCoolingSetpoint$java_com_google_home_matter_standard_clusters_android", "()Ljava/lang/Short;", "set_occupiedCoolingSetpoint$java_com_google_home_matter_standard_clusters_android", "(Ljava/lang/Short;)V", "_occupiedHeatingSetpoint", "get_occupiedHeatingSetpoint$java_com_google_home_matter_standard_clusters_android", "set_occupiedHeatingSetpoint$java_com_google_home_matter_standard_clusters_android", "_unoccupiedCoolingSetpoint", "get_unoccupiedCoolingSetpoint$java_com_google_home_matter_standard_clusters_android", "set_unoccupiedCoolingSetpoint$java_com_google_home_matter_standard_clusters_android", "_unoccupiedHeatingSetpoint", "get_unoccupiedHeatingSetpoint$java_com_google_home_matter_standard_clusters_android", "set_unoccupiedHeatingSetpoint$java_com_google_home_matter_standard_clusters_android", "_minHeatSetpointLimit", "get_minHeatSetpointLimit$java_com_google_home_matter_standard_clusters_android", "set_minHeatSetpointLimit$java_com_google_home_matter_standard_clusters_android", "_maxHeatSetpointLimit", "get_maxHeatSetpointLimit$java_com_google_home_matter_standard_clusters_android", "set_maxHeatSetpointLimit$java_com_google_home_matter_standard_clusters_android", "_minCoolSetpointLimit", "get_minCoolSetpointLimit$java_com_google_home_matter_standard_clusters_android", "set_minCoolSetpointLimit$java_com_google_home_matter_standard_clusters_android", "_maxCoolSetpointLimit", "get_maxCoolSetpointLimit$java_com_google_home_matter_standard_clusters_android", "set_maxCoolSetpointLimit$java_com_google_home_matter_standard_clusters_android", "_minSetpointDeadBand", "get_minSetpointDeadBand$java_com_google_home_matter_standard_clusters_android", "set_minSetpointDeadBand$java_com_google_home_matter_standard_clusters_android", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "_remoteSensing", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "get_remoteSensing$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "set_remoteSensing$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;)V", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "_controlSequenceOfOperation", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "get_controlSequenceOfOperation$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "set_controlSequenceOfOperation$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;)V", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "_systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "get_systemMode$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "set_systemMode$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;)V", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "_temperatureSetpointHold", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "get_temperatureSetpointHold$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "set_temperatureSetpointHold$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;)V", "Lkotlin/UShort;", "_temperatureSetpointHoldDuration", "Lkotlin/UShort;", "get_temperatureSetpointHoldDuration-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UShort;", "set_temperatureSetpointHoldDuration-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UShort;)V", "_isTemperatureSetpointHoldDurationSet", "Z", "get_isTemperatureSetpointHoldDurationSet$java_com_google_home_matter_standard_clusters_android", "()Z", "set_isTemperatureSetpointHoldDurationSet$java_com_google_home_matter_standard_clusters_android", "(Z)V", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "_thermostatProgrammingOperationMode", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "get_thermostatProgrammingOperationMode$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "set_thermostatProgrammingOperationMode$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;)V", "_occupiedSetback", "get_occupiedSetback-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_occupiedSetback-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isOccupiedSetbackSet", "get_isOccupiedSetbackSet$java_com_google_home_matter_standard_clusters_android", "set_isOccupiedSetbackSet$java_com_google_home_matter_standard_clusters_android", "_unoccupiedSetback", "get_unoccupiedSetback-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_unoccupiedSetback-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isUnoccupiedSetbackSet", "get_isUnoccupiedSetbackSet$java_com_google_home_matter_standard_clusters_android", "set_isUnoccupiedSetbackSet$java_com_google_home_matter_standard_clusters_android", "_emergencyHeatDelta", "get_emergencyHeatDelta-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_emergencyHeatDelta-3swpYEE$java_com_google_home_matter_standard_clusters_android", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "_acType", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "get_acType$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "set_acType$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;)V", "_acCapacity", "get_acCapacity-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_acCapacity-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "_acRefrigerantType", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "get_acRefrigerantType$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "set_acRefrigerantType$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;)V", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "_acCompressorType", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "get_acCompressorType$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "set_acCompressorType$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;)V", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "_acErrorCode", "Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "get_acErrorCode$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;", "set_acErrorCode$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$AcErrorCodeBitmap;)V", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "_acLouverPosition", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "get_acLouverPosition$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "set_acLouverPosition$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;)V", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "_acCapacityformat", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "get_acCapacityformat$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "set_acCapacityformat$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;)V", "", "Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "_presets", "Ljava/util/List;", "get_presets$java_com_google_home_matter_standard_clusters_android", "()Ljava/util/List;", "set_presets$java_com_google_home_matter_standard_clusters_android", "(Ljava/util/List;)V", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "_schedules", "get_schedules$java_com_google_home_matter_standard_clusters_android", "set_schedules$java_com_google_home_matter_standard_clusters_android", "getHvacSystemTypeConfiguration-7PGSa80", "hvacSystemTypeConfiguration", "getLocalTemperatureCalibration", "localTemperatureCalibration", "getOccupiedCoolingSetpoint", "occupiedCoolingSetpoint", "getOccupiedHeatingSetpoint", "occupiedHeatingSetpoint", "getUnoccupiedCoolingSetpoint", "unoccupiedCoolingSetpoint", "getUnoccupiedHeatingSetpoint", "unoccupiedHeatingSetpoint", "getMinHeatSetpointLimit", "minHeatSetpointLimit", "getMaxHeatSetpointLimit", "maxHeatSetpointLimit", "getMinCoolSetpointLimit", "minCoolSetpointLimit", "getMaxCoolSetpointLimit", "maxCoolSetpointLimit", "getMinSetpointDeadBand", "minSetpointDeadBand", "getRemoteSensing", "remoteSensing", "getControlSequenceOfOperation", "controlSequenceOfOperation", "getSystemMode", "systemMode", "getTemperatureSetpointHold", "temperatureSetpointHold", "getTemperatureSetpointHoldDuration-XRpZGF0", "temperatureSetpointHoldDuration", "getThermostatProgrammingOperationMode", "thermostatProgrammingOperationMode", "getOccupiedSetback-7PGSa80", "occupiedSetback", "getUnoccupiedSetback-7PGSa80", "unoccupiedSetback", "getEmergencyHeatDelta-7PGSa80", "emergencyHeatDelta", "getAcType", "acType", "getAcCapacity-XRpZGF0", "acCapacity", "getAcRefrigerantType", "acRefrigerantType", "getAcCompressorType", "acCompressorType", "getAcErrorCode", "acErrorCode", "getAcLouverPosition", "acLouverPosition", "getAcCapacityformat", "acCapacityformat", "getPresets", "presets", "getSchedules", "schedules", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends AttributesImpl {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private UShort _acCapacity;
        private AcCapacityFormatEnum _acCapacityformat;
        private AcCompressorTypeEnum _acCompressorType;
        private AcErrorCodeBitmap _acErrorCode;
        private AcLouverPositionEnum _acLouverPosition;
        private AcRefrigerantTypeEnum _acRefrigerantType;
        private AcTypeEnum _acType;
        private ControlSequenceOfOperationEnum _controlSequenceOfOperation;
        private UByte _emergencyHeatDelta;
        private UByte _hvacSystemTypeConfiguration;
        private boolean _isOccupiedSetbackSet;
        private boolean _isTemperatureSetpointHoldDurationSet;
        private boolean _isUnoccupiedSetbackSet;
        private Byte _localTemperatureCalibration;
        private Short _maxCoolSetpointLimit;
        private Short _maxHeatSetpointLimit;
        private Short _minCoolSetpointLimit;
        private Short _minHeatSetpointLimit;
        private Byte _minSetpointDeadBand;
        private Short _occupiedCoolingSetpoint;
        private Short _occupiedHeatingSetpoint;
        private UByte _occupiedSetback;
        private List<PresetStruct> _presets;
        private RemoteSensingBitmap _remoteSensing;
        private List<ScheduleStruct> _schedules;
        private SystemModeEnum _systemMode;
        private TemperatureSetpointHoldEnum _temperatureSetpointHold;
        private UShort _temperatureSetpointHoldDuration;
        private ProgrammingOperationModeBitmap _thermostatProgrammingOperationMode;
        private Short _unoccupiedCoolingSetpoint;
        private Short _unoccupiedHeatingSetpoint;
        private UByte _unoccupiedSetback;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                ClusterPayloadWriterKt.wrapPayload(writer, ThermostatTrait.INSTANCE.getId());
                if (value.get_hvacSystemTypeConfiguration() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(9))) {
                        throw HomeException.INSTANCE.invalidArgument("hvacSystemTypeConfiguration");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(9, value.get_hvacSystemTypeConfiguration());
                }
                if (value.get_localTemperatureCalibration() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16))) {
                        throw HomeException.INSTANCE.invalidArgument("localTemperatureCalibration");
                    }
                    writer.getByte().mo554writeqim9Vi0(16, value.get_localTemperatureCalibration());
                }
                if (value.get_occupiedCoolingSetpoint() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                        throw HomeException.INSTANCE.invalidArgument("occupiedCoolingSetpoint");
                    }
                    writer.getShort().mo554writeqim9Vi0(17, value.get_occupiedCoolingSetpoint());
                }
                if (value.get_occupiedHeatingSetpoint() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(18))) {
                        throw HomeException.INSTANCE.invalidArgument("occupiedHeatingSetpoint");
                    }
                    writer.getShort().mo554writeqim9Vi0(18, value.get_occupiedHeatingSetpoint());
                }
                if (value.get_unoccupiedCoolingSetpoint() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(19))) {
                        throw HomeException.INSTANCE.invalidArgument("unoccupiedCoolingSetpoint");
                    }
                    writer.getShort().mo554writeqim9Vi0(19, value.get_unoccupiedCoolingSetpoint());
                }
                if (value.get_unoccupiedHeatingSetpoint() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(20))) {
                        throw HomeException.INSTANCE.invalidArgument("unoccupiedHeatingSetpoint");
                    }
                    writer.getShort().mo554writeqim9Vi0(20, value.get_unoccupiedHeatingSetpoint());
                }
                if (value.get_minHeatSetpointLimit() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(21))) {
                        throw HomeException.INSTANCE.invalidArgument("minHeatSetpointLimit");
                    }
                    writer.getShort().mo554writeqim9Vi0(21, value.get_minHeatSetpointLimit());
                }
                if (value.get_maxHeatSetpointLimit() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(22))) {
                        throw HomeException.INSTANCE.invalidArgument("maxHeatSetpointLimit");
                    }
                    writer.getShort().mo554writeqim9Vi0(22, value.get_maxHeatSetpointLimit());
                }
                if (value.get_minCoolSetpointLimit() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(23))) {
                        throw HomeException.INSTANCE.invalidArgument("minCoolSetpointLimit");
                    }
                    writer.getShort().mo554writeqim9Vi0(23, value.get_minCoolSetpointLimit());
                }
                if (value.get_maxCoolSetpointLimit() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(24))) {
                        throw HomeException.INSTANCE.invalidArgument("maxCoolSetpointLimit");
                    }
                    writer.getShort().mo554writeqim9Vi0(24, value.get_maxCoolSetpointLimit());
                }
                if (value.get_minSetpointDeadBand() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(25))) {
                        throw HomeException.INSTANCE.invalidArgument("minSetpointDeadBand");
                    }
                    writer.getByte().mo554writeqim9Vi0(25, value.get_minSetpointDeadBand());
                }
                if (value.get_remoteSensing() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(26))) {
                        throw HomeException.INSTANCE.invalidArgument("remoteSensing");
                    }
                    writer.bitmap(RemoteSensingBitmap.INSTANCE).mo554writeqim9Vi0(26, value.get_remoteSensing());
                }
                if (value.get_controlSequenceOfOperation() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(27))) {
                        throw HomeException.INSTANCE.invalidArgument("controlSequenceOfOperation");
                    }
                    writer.m552enum(ControlSequenceOfOperationEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(27, value.get_controlSequenceOfOperation());
                }
                if (value.get_systemMode() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(28))) {
                        throw HomeException.INSTANCE.invalidArgument("systemMode");
                    }
                    writer.m552enum(SystemModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(28, value.get_systemMode());
                }
                if (value.get_temperatureSetpointHold() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(35))) {
                        throw HomeException.INSTANCE.invalidArgument("temperatureSetpointHold");
                    }
                    writer.m552enum(TemperatureSetpointHoldEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(35, value.get_temperatureSetpointHold());
                }
                if (value.get_isTemperatureSetpointHoldDurationSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(36))) {
                        throw HomeException.INSTANCE.invalidArgument("temperatureSetpointHoldDuration");
                    }
                    writer.getUshort().mo554writeqim9Vi0(36, value.get_temperatureSetpointHoldDuration());
                }
                if (value.get_thermostatProgrammingOperationMode() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(37))) {
                        throw HomeException.INSTANCE.invalidArgument("thermostatProgrammingOperationMode");
                    }
                    writer.bitmap(ProgrammingOperationModeBitmap.INSTANCE).mo554writeqim9Vi0(37, value.get_thermostatProgrammingOperationMode());
                }
                if (value.get_isOccupiedSetbackSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(52))) {
                        throw HomeException.INSTANCE.invalidArgument("occupiedSetback");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(52, value.get_occupiedSetback());
                }
                if (value.get_isUnoccupiedSetbackSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(55))) {
                        throw HomeException.INSTANCE.invalidArgument("unoccupiedSetback");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(55, value.get_unoccupiedSetback());
                }
                if (value.get_emergencyHeatDelta() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(58))) {
                        throw HomeException.INSTANCE.invalidArgument("emergencyHeatDelta");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(58, value.get_emergencyHeatDelta());
                }
                if (value.get_acType() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(64))) {
                        throw HomeException.INSTANCE.invalidArgument("acType");
                    }
                    writer.m552enum(AcTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(64, value.get_acType());
                }
                if (value.get_acCapacity() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(65))) {
                        throw HomeException.INSTANCE.invalidArgument("acCapacity");
                    }
                    writer.getUshort().mo554writeqim9Vi0(65, value.get_acCapacity());
                }
                if (value.get_acRefrigerantType() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(66))) {
                        throw HomeException.INSTANCE.invalidArgument("acRefrigerantType");
                    }
                    writer.m552enum(AcRefrigerantTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(66, value.get_acRefrigerantType());
                }
                if (value.get_acCompressorType() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(67))) {
                        throw HomeException.INSTANCE.invalidArgument("acCompressorType");
                    }
                    writer.m552enum(AcCompressorTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(67, value.get_acCompressorType());
                }
                if (value.get_acErrorCode() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(68))) {
                        throw HomeException.INSTANCE.invalidArgument("acErrorCode");
                    }
                    writer.bitmap(AcErrorCodeBitmap.INSTANCE).mo554writeqim9Vi0(68, value.get_acErrorCode());
                }
                if (value.get_acLouverPosition() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(69))) {
                        throw HomeException.INSTANCE.invalidArgument("acLouverPosition");
                    }
                    writer.m552enum(AcLouverPositionEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(69, value.get_acLouverPosition());
                }
                if (value.get_acCapacityformat() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(71))) {
                        throw HomeException.INSTANCE.invalidArgument("acCapacityformat");
                    }
                    writer.m552enum(AcCapacityFormatEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(71, value.get_acCapacityformat());
                }
                if (value.get_presets$java_com_google_home_matter_standard_clusters_android() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(80))) {
                        throw HomeException.INSTANCE.invalidArgument("presets");
                    }
                    writer.struct(PresetStruct.INSTANCE).mo555writeListqim9Vi0(80, value.get_presets$java_com_google_home_matter_standard_clusters_android());
                }
                if (value.get_schedules$java_com_google_home_matter_standard_clusters_android() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(81))) {
                        throw HomeException.INSTANCE.invalidArgument("schedules");
                    }
                    writer.struct(ScheduleStruct.INSTANCE).mo555writeListqim9Vi0(81, value.get_schedules$java_com_google_home_matter_standard_clusters_android());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getLocalTemperature(), attributes.getOutdoorTemperature(), attributes.getOccupancy(), attributes.getAbsMinHeatSetpointLimit(), attributes.getAbsMaxHeatSetpointLimit(), attributes.getAbsMinCoolSetpointLimit(), attributes.getAbsMaxCoolSetpointLimit(), attributes.getPiCoolingDemand(), attributes.getPiHeatingDemand(), attributes.getHvacSystemTypeConfiguration(), attributes.getLocalTemperatureCalibration(), attributes.getOccupiedCoolingSetpoint(), attributes.getOccupiedHeatingSetpoint(), attributes.getUnoccupiedCoolingSetpoint(), attributes.getUnoccupiedHeatingSetpoint(), attributes.getMinHeatSetpointLimit(), attributes.getMaxHeatSetpointLimit(), attributes.getMinCoolSetpointLimit(), attributes.getMaxCoolSetpointLimit(), attributes.getMinSetpointDeadBand(), attributes.getRemoteSensing(), attributes.getControlSequenceOfOperation(), attributes.getSystemMode(), attributes.getThermostatRunningMode(), attributes.getStartOfWeek(), attributes.getNumberOfWeeklyTransitions(), attributes.getNumberOfDailyTransitions(), attributes.getTemperatureSetpointHold(), attributes.getTemperatureSetpointHoldDuration(), attributes.getThermostatProgrammingOperationMode(), attributes.getThermostatRunningState(), attributes.getSetpointChangeSource(), attributes.getSetpointChangeAmount(), attributes.getSetpointChangeSourceTimestamp(), attributes.getOccupiedSetback(), attributes.getOccupiedSetbackMin(), attributes.getOccupiedSetbackMax(), attributes.getUnoccupiedSetback(), attributes.getUnoccupiedSetbackMin(), attributes.getUnoccupiedSetbackMax(), attributes.getEmergencyHeatDelta(), attributes.getAcType(), attributes.getAcCapacity(), attributes.getAcRefrigerantType(), attributes.getAcCompressorType(), attributes.getAcErrorCode(), attributes.getAcLouverPosition(), attributes.getAcCoilTemperature(), attributes.getAcCapacityformat(), attributes.getPresetTypes(), attributes.getScheduleTypes(), attributes.getNumberOfPresets(), attributes.getNumberOfSchedules(), attributes.getNumberOfScheduleTransitions(), attributes.getNumberOfScheduleTransitionPerDay(), attributes.getActivePresetHandle(), attributes.getActiveScheduleHandle(), attributes.getPresets(), attributes.getSchedules(), attributes.getPresetsSchedulesEditable(), attributes.getTemperatureSetpointHoldPolicy(), attributes.getSetpointHoldExpiryTimestamp(), attributes.getQueuedPreset(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getAcCapacity-XRpZGF0 */
        public UShort getAcCapacity() {
            UShort uShort = this._acCapacity;
            return uShort == null ? super.getAcCapacity() : uShort;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcCapacityFormatEnum getAcCapacityformat() {
            AcCapacityFormatEnum acCapacityFormatEnum = this._acCapacityformat;
            return acCapacityFormatEnum == null ? super.getAcCapacityformat() : acCapacityFormatEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcCompressorTypeEnum getAcCompressorType() {
            AcCompressorTypeEnum acCompressorTypeEnum = this._acCompressorType;
            return acCompressorTypeEnum == null ? super.getAcCompressorType() : acCompressorTypeEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcErrorCodeBitmap getAcErrorCode() {
            AcErrorCodeBitmap acErrorCodeBitmap = this._acErrorCode;
            return acErrorCodeBitmap == null ? super.getAcErrorCode() : acErrorCodeBitmap;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcLouverPositionEnum getAcLouverPosition() {
            AcLouverPositionEnum acLouverPositionEnum = this._acLouverPosition;
            return acLouverPositionEnum == null ? super.getAcLouverPosition() : acLouverPositionEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcRefrigerantTypeEnum getAcRefrigerantType() {
            AcRefrigerantTypeEnum acRefrigerantTypeEnum = this._acRefrigerantType;
            return acRefrigerantTypeEnum == null ? super.getAcRefrigerantType() : acRefrigerantTypeEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public AcTypeEnum getAcType() {
            AcTypeEnum acTypeEnum = this._acType;
            return acTypeEnum == null ? super.getAcType() : acTypeEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public ControlSequenceOfOperationEnum getControlSequenceOfOperation() {
            ControlSequenceOfOperationEnum controlSequenceOfOperationEnum = this._controlSequenceOfOperation;
            return controlSequenceOfOperationEnum == null ? super.getControlSequenceOfOperation() : controlSequenceOfOperationEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getEmergencyHeatDelta-7PGSa80 */
        public UByte getEmergencyHeatDelta() {
            UByte uByte = this._emergencyHeatDelta;
            return uByte == null ? super.getEmergencyHeatDelta() : uByte;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getHvacSystemTypeConfiguration-7PGSa80 */
        public UByte getHvacSystemTypeConfiguration() {
            UByte uByte = this._hvacSystemTypeConfiguration;
            return uByte == null ? super.getHvacSystemTypeConfiguration() : uByte;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Byte getLocalTemperatureCalibration() {
            Byte b = this._localTemperatureCalibration;
            return b == null ? super.getLocalTemperatureCalibration() : b;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMaxCoolSetpointLimit() {
            Short sh = this._maxCoolSetpointLimit;
            return sh == null ? super.getMaxCoolSetpointLimit() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMaxHeatSetpointLimit() {
            Short sh = this._maxHeatSetpointLimit;
            return sh == null ? super.getMaxHeatSetpointLimit() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMinCoolSetpointLimit() {
            Short sh = this._minCoolSetpointLimit;
            return sh == null ? super.getMinCoolSetpointLimit() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getMinHeatSetpointLimit() {
            Short sh = this._minHeatSetpointLimit;
            return sh == null ? super.getMinHeatSetpointLimit() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Byte getMinSetpointDeadBand() {
            Byte b = this._minSetpointDeadBand;
            return b == null ? super.getMinSetpointDeadBand() : b;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getOccupiedCoolingSetpoint() {
            Short sh = this._occupiedCoolingSetpoint;
            return sh == null ? super.getOccupiedCoolingSetpoint() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getOccupiedHeatingSetpoint() {
            Short sh = this._occupiedHeatingSetpoint;
            return sh == null ? super.getOccupiedHeatingSetpoint() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getOccupiedSetback-7PGSa80 */
        public UByte getOccupiedSetback() {
            return this._isOccupiedSetbackSet ? this._occupiedSetback : super.getOccupiedSetback();
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<PresetStruct> getPresets() {
            List<PresetStruct> list = this._presets;
            return list == null ? super.getPresets() : list;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public RemoteSensingBitmap getRemoteSensing() {
            RemoteSensingBitmap remoteSensingBitmap = this._remoteSensing;
            return remoteSensingBitmap == null ? super.getRemoteSensing() : remoteSensingBitmap;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public List<ScheduleStruct> getSchedules() {
            List<ScheduleStruct> list = this._schedules;
            return list == null ? super.getSchedules() : list;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public SystemModeEnum getSystemMode() {
            SystemModeEnum systemModeEnum = this._systemMode;
            return systemModeEnum == null ? super.getSystemMode() : systemModeEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public TemperatureSetpointHoldEnum getTemperatureSetpointHold() {
            TemperatureSetpointHoldEnum temperatureSetpointHoldEnum = this._temperatureSetpointHold;
            return temperatureSetpointHoldEnum == null ? super.getTemperatureSetpointHold() : temperatureSetpointHoldEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getTemperatureSetpointHoldDuration-XRpZGF0 */
        public UShort getTemperatureSetpointHoldDuration() {
            return this._isTemperatureSetpointHoldDurationSet ? this._temperatureSetpointHoldDuration : super.getTemperatureSetpointHoldDuration();
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public ProgrammingOperationModeBitmap getThermostatProgrammingOperationMode() {
            ProgrammingOperationModeBitmap programmingOperationModeBitmap = this._thermostatProgrammingOperationMode;
            return programmingOperationModeBitmap == null ? super.getThermostatProgrammingOperationMode() : programmingOperationModeBitmap;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getUnoccupiedCoolingSetpoint() {
            Short sh = this._unoccupiedCoolingSetpoint;
            return sh == null ? super.getUnoccupiedCoolingSetpoint() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        public Short getUnoccupiedHeatingSetpoint() {
            Short sh = this._unoccupiedHeatingSetpoint;
            return sh == null ? super.getUnoccupiedHeatingSetpoint() : sh;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl, com.google.home.matter.standard.ThermostatTrait.Attributes
        /* JADX INFO: renamed from: getUnoccupiedSetback-7PGSa80 */
        public UByte getUnoccupiedSetback() {
            return this._isUnoccupiedSetbackSet ? this._unoccupiedSetback : super.getUnoccupiedSetback();
        }

        /* JADX INFO: renamed from: get_acCapacity-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_acCapacity() {
            return this._acCapacity;
        }

        /* JADX INFO: renamed from: get_acCapacityformat$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final AcCapacityFormatEnum get_acCapacityformat() {
            return this._acCapacityformat;
        }

        /* JADX INFO: renamed from: get_acCompressorType$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final AcCompressorTypeEnum get_acCompressorType() {
            return this._acCompressorType;
        }

        /* JADX INFO: renamed from: get_acErrorCode$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final AcErrorCodeBitmap get_acErrorCode() {
            return this._acErrorCode;
        }

        /* JADX INFO: renamed from: get_acLouverPosition$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final AcLouverPositionEnum get_acLouverPosition() {
            return this._acLouverPosition;
        }

        /* JADX INFO: renamed from: get_acRefrigerantType$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final AcRefrigerantTypeEnum get_acRefrigerantType() {
            return this._acRefrigerantType;
        }

        /* JADX INFO: renamed from: get_acType$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final AcTypeEnum get_acType() {
            return this._acType;
        }

        /* JADX INFO: renamed from: get_controlSequenceOfOperation$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final ControlSequenceOfOperationEnum get_controlSequenceOfOperation() {
            return this._controlSequenceOfOperation;
        }

        /* JADX INFO: renamed from: get_emergencyHeatDelta-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_emergencyHeatDelta() {
            return this._emergencyHeatDelta;
        }

        /* JADX INFO: renamed from: get_hvacSystemTypeConfiguration-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_hvacSystemTypeConfiguration() {
            return this._hvacSystemTypeConfiguration;
        }

        /* JADX INFO: renamed from: get_isOccupiedSetbackSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isOccupiedSetbackSet() {
            return this._isOccupiedSetbackSet;
        }

        /* JADX INFO: renamed from: get_isTemperatureSetpointHoldDurationSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isTemperatureSetpointHoldDurationSet() {
            return this._isTemperatureSetpointHoldDurationSet;
        }

        /* JADX INFO: renamed from: get_isUnoccupiedSetbackSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isUnoccupiedSetbackSet() {
            return this._isUnoccupiedSetbackSet;
        }

        /* JADX INFO: renamed from: get_localTemperatureCalibration$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Byte get_localTemperatureCalibration() {
            return this._localTemperatureCalibration;
        }

        /* JADX INFO: renamed from: get_maxCoolSetpointLimit$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_maxCoolSetpointLimit() {
            return this._maxCoolSetpointLimit;
        }

        /* JADX INFO: renamed from: get_maxHeatSetpointLimit$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_maxHeatSetpointLimit() {
            return this._maxHeatSetpointLimit;
        }

        /* JADX INFO: renamed from: get_minCoolSetpointLimit$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_minCoolSetpointLimit() {
            return this._minCoolSetpointLimit;
        }

        /* JADX INFO: renamed from: get_minHeatSetpointLimit$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_minHeatSetpointLimit() {
            return this._minHeatSetpointLimit;
        }

        /* JADX INFO: renamed from: get_minSetpointDeadBand$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Byte get_minSetpointDeadBand() {
            return this._minSetpointDeadBand;
        }

        /* JADX INFO: renamed from: get_occupiedCoolingSetpoint$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_occupiedCoolingSetpoint() {
            return this._occupiedCoolingSetpoint;
        }

        /* JADX INFO: renamed from: get_occupiedHeatingSetpoint$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_occupiedHeatingSetpoint() {
            return this._occupiedHeatingSetpoint;
        }

        /* JADX INFO: renamed from: get_occupiedSetback-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_occupiedSetback() {
            return this._occupiedSetback;
        }

        public final List<PresetStruct> get_presets$java_com_google_home_matter_standard_clusters_android() {
            return this._presets;
        }

        /* JADX INFO: renamed from: get_remoteSensing$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final RemoteSensingBitmap get_remoteSensing() {
            return this._remoteSensing;
        }

        public final List<ScheduleStruct> get_schedules$java_com_google_home_matter_standard_clusters_android() {
            return this._schedules;
        }

        /* JADX INFO: renamed from: get_systemMode$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final SystemModeEnum get_systemMode() {
            return this._systemMode;
        }

        /* JADX INFO: renamed from: get_temperatureSetpointHold$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final TemperatureSetpointHoldEnum get_temperatureSetpointHold() {
            return this._temperatureSetpointHold;
        }

        /* JADX INFO: renamed from: get_temperatureSetpointHoldDuration-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_temperatureSetpointHoldDuration() {
            return this._temperatureSetpointHoldDuration;
        }

        /* JADX INFO: renamed from: get_thermostatProgrammingOperationMode$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final ProgrammingOperationModeBitmap get_thermostatProgrammingOperationMode() {
            return this._thermostatProgrammingOperationMode;
        }

        /* JADX INFO: renamed from: get_unoccupiedCoolingSetpoint$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_unoccupiedCoolingSetpoint() {
            return this._unoccupiedCoolingSetpoint;
        }

        /* JADX INFO: renamed from: get_unoccupiedHeatingSetpoint$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final Short get_unoccupiedHeatingSetpoint() {
            return this._unoccupiedHeatingSetpoint;
        }

        /* JADX INFO: renamed from: get_unoccupiedSetback-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_unoccupiedSetback() {
            return this._unoccupiedSetback;
        }

        @Override // com.google.home.matter.standard.ThermostatTrait.AttributesImpl
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 30), "Thermostat.MutableAttributes(", string, ")");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "scheduleActive", "autoRecovery", "economy", "<init>", "(ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getScheduleActive", "()Z", "getAutoRecovery", "getEconomy", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ProgrammingOperationModeBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean autoRecovery;
        private final boolean economy;
        private final boolean scheduleActive;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ProgrammingOperationModeBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ProgrammingOperationModeBitmap;", "<init>", "()V", "SCHEDULE_ACTIVE_FLAG", "Lkotlin/ULong;", "J", "AUTO_RECOVERY_FLAG", "ECONOMY_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ProgrammingOperationModeBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ProgrammingOperationModeBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getScheduleActive());
                mutableBitmap.m564set4PLdz1A(2L, value.getAutoRecovery());
                mutableBitmap.m564set4PLdz1A(4L, value.getEconomy());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ProgrammingOperationModeBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new ProgrammingOperationModeBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ProgrammingOperationModeBitmap(boolean z, boolean z2, boolean z3) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ProgrammingOperationModeBitmap");
            this.scheduleActive = z;
            this.autoRecovery = z2;
            this.economy = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProgrammingOperationModeBitmap)) {
                return false;
            }
            ProgrammingOperationModeBitmap programmingOperationModeBitmap = (ProgrammingOperationModeBitmap) other;
            return this.scheduleActive == programmingOperationModeBitmap.scheduleActive && this.autoRecovery == programmingOperationModeBitmap.autoRecovery && this.economy == programmingOperationModeBitmap.economy;
        }

        public final boolean getAutoRecovery() {
            return this.autoRecovery;
        }

        public final boolean getEconomy() {
            return this.economy;
        }

        public final boolean getScheduleActive() {
            return this.scheduleActive;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.autoRecovery) + (Boolean.hashCode(this.scheduleActive) * 31);
            return Boolean.hashCode(this.economy) + (iHashCode * 31);
        }

        public String toString() {
            boolean z = this.scheduleActive;
            int length = String.valueOf(z).length();
            boolean z2 = this.autoRecovery;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.economy;
            return zzw.zza(z3, z2, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 61, length2, 10, String.valueOf(z3).length()) + 1), z, "ProgrammingOperationModeBitmap(scheduleActive=", ", autoRecovery=", ", economy=");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "heat", "cool", "fan", "heatStage2", "coolStage2", "fanStage2", "fanStage3", "<init>", "(ZZZZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHeat", "()Z", "getCool", "getFan", "getHeatStage2", "getCoolStage2", "getFanStage2", "getFanStage3", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class RelayStateBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean cool;
        private final boolean coolStage2;
        private final boolean fan;
        private final boolean fanStage2;
        private final boolean fanStage3;
        private final boolean heat;
        private final boolean heatStage2;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$RelayStateBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$RelayStateBitmap;", "<init>", "()V", "HEAT_FLAG", "Lkotlin/ULong;", "J", "COOL_FLAG", "FAN_FLAG", "HEAT_STAGE2_FLAG", "COOL_STAGE2_FLAG", "FAN_STAGE2_FLAG", "FAN_STAGE3_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<RelayStateBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(RelayStateBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getHeat());
                mutableBitmap.m564set4PLdz1A(2L, value.getCool());
                mutableBitmap.m564set4PLdz1A(4L, value.getFan());
                mutableBitmap.m564set4PLdz1A(8L, value.getHeatStage2());
                mutableBitmap.m564set4PLdz1A(16L, value.getCoolStage2());
                mutableBitmap.m564set4PLdz1A(32L, value.getFanStage2());
                mutableBitmap.m564set4PLdz1A(64L, value.getFanStage3());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public RelayStateBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new RelayStateBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L), value.m525getVKZWuLQ(16L), value.m525getVKZWuLQ(32L), value.m525getVKZWuLQ(64L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RelayStateBitmap(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "RelayStateBitmap");
            this.heat = z;
            this.cool = z2;
            this.fan = z3;
            this.heatStage2 = z4;
            this.coolStage2 = z5;
            this.fanStage2 = z6;
            this.fanStage3 = z7;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelayStateBitmap)) {
                return false;
            }
            RelayStateBitmap relayStateBitmap = (RelayStateBitmap) other;
            return this.heat == relayStateBitmap.heat && this.cool == relayStateBitmap.cool && this.fan == relayStateBitmap.fan && this.heatStage2 == relayStateBitmap.heatStage2 && this.coolStage2 == relayStateBitmap.coolStage2 && this.fanStage2 == relayStateBitmap.fanStage2 && this.fanStage3 == relayStateBitmap.fanStage3;
        }

        public final boolean getCool() {
            return this.cool;
        }

        public final boolean getCoolStage2() {
            return this.coolStage2;
        }

        public final boolean getFan() {
            return this.fan;
        }

        public final boolean getFanStage2() {
            return this.fanStage2;
        }

        public final boolean getFanStage3() {
            return this.fanStage3;
        }

        public final boolean getHeat() {
            return this.heat;
        }

        public final boolean getHeatStage2() {
            return this.heatStage2;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.cool) + (Boolean.hashCode(this.heat) * 31);
            int iHashCode2 = Boolean.hashCode(this.fan) + (iHashCode * 31);
            int iHashCode3 = Boolean.hashCode(this.heatStage2) + (iHashCode2 * 31);
            int iHashCode4 = Boolean.hashCode(this.coolStage2) + (iHashCode3 * 31);
            int iHashCode5 = Boolean.hashCode(this.fanStage2);
            return Boolean.hashCode(this.fanStage3) + ((iHashCode5 + (iHashCode4 * 31)) * 31);
        }

        public String toString() {
            boolean z = this.heat;
            int length = String.valueOf(z).length();
            boolean z2 = this.cool;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.fan;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.heatStage2;
            int length4 = String.valueOf(z4).length();
            boolean z5 = this.coolStage2;
            int length5 = String.valueOf(z5).length();
            boolean z6 = this.fanStage2;
            int length6 = String.valueOf(z6).length();
            boolean z7 = this.fanStage3;
            return zzad.zza(z7, z6, z5, z4, z3, new StringBuilder(length + 29 + length2 + 6 + length3 + 13 + length4 + 13 + length5 + 12 + length6 + 12 + String.valueOf(z7).length() + 1), z2, z, ", fan=", ", cool=", ", heatStage2=", ", coolStage2=", ", fanStage2=", ", fanStage3=", "RelayStateBitmap(heat=");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "localTemperature", "outdoorTemperature", "occupancy", "<init>", "(ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getLocalTemperature", "()Z", "getOutdoorTemperature", "getOccupancy", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class RemoteSensingBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean localTemperature;
        private final boolean occupancy;
        private final boolean outdoorTemperature;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$RemoteSensingBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$RemoteSensingBitmap;", "<init>", "()V", "LOCAL_TEMPERATURE_FLAG", "Lkotlin/ULong;", "J", "OUTDOOR_TEMPERATURE_FLAG", "OCCUPANCY_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<RemoteSensingBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(RemoteSensingBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getLocalTemperature());
                mutableBitmap.m564set4PLdz1A(2L, value.getOutdoorTemperature());
                mutableBitmap.m564set4PLdz1A(4L, value.getOccupancy());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public RemoteSensingBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new RemoteSensingBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RemoteSensingBitmap(boolean z, boolean z2, boolean z3) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "RemoteSensingBitmap");
            this.localTemperature = z;
            this.outdoorTemperature = z2;
            this.occupancy = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoteSensingBitmap)) {
                return false;
            }
            RemoteSensingBitmap remoteSensingBitmap = (RemoteSensingBitmap) other;
            return this.localTemperature == remoteSensingBitmap.localTemperature && this.outdoorTemperature == remoteSensingBitmap.outdoorTemperature && this.occupancy == remoteSensingBitmap.occupancy;
        }

        public final boolean getLocalTemperature() {
            return this.localTemperature;
        }

        public final boolean getOccupancy() {
            return this.occupancy;
        }

        public final boolean getOutdoorTemperature() {
            return this.outdoorTemperature;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.outdoorTemperature) + (Boolean.hashCode(this.localTemperature) * 31);
            return Boolean.hashCode(this.occupancy) + (iHashCode * 31);
        }

        public String toString() {
            boolean z = this.localTemperature;
            int length = String.valueOf(z).length();
            boolean z2 = this.outdoorTemperature;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.occupancy;
            return zzw.zza(z3, z2, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 58, length2, 12, String.valueOf(z3).length()) + 1), z, "RemoteSensingBitmap(localTemperature=", ", outdoorTemperature=", ", occupancy=");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleModeBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "heatSetpointPresent", "coolSetpointPresent", "<init>", "(ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHeatSetpointPresent", "()Z", "getCoolSetpointPresent", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ScheduleModeBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean coolSetpointPresent;
        private final boolean heatSetpointPresent;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ScheduleModeBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleModeBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleModeBitmap;", "<init>", "()V", "HEAT_SETPOINT_PRESENT_FLAG", "Lkotlin/ULong;", "J", "COOL_SETPOINT_PRESENT_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ScheduleModeBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ScheduleModeBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getHeatSetpointPresent());
                mutableBitmap.m564set4PLdz1A(2L, value.getCoolSetpointPresent());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ScheduleModeBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new ScheduleModeBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ScheduleModeBitmap(boolean z, boolean z2) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ScheduleModeBitmap");
            this.heatSetpointPresent = z;
            this.coolSetpointPresent = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduleModeBitmap)) {
                return false;
            }
            ScheduleModeBitmap scheduleModeBitmap = (ScheduleModeBitmap) other;
            return this.heatSetpointPresent == scheduleModeBitmap.heatSetpointPresent && this.coolSetpointPresent == scheduleModeBitmap.coolSetpointPresent;
        }

        public final boolean getCoolSetpointPresent() {
            return this.coolSetpointPresent;
        }

        public final boolean getHeatSetpointPresent() {
            return this.heatSetpointPresent;
        }

        public int hashCode() {
            return Boolean.hashCode(this.coolSetpointPresent) + (Boolean.hashCode(this.heatSetpointPresent) * 31);
        }

        public String toString() {
            return zzu.zza(this.coolSetpointPresent, this.heatSetpointPresent, (byte) 61, "ScheduleModeBitmap(heatSetpointPresent=", ", coolSetpointPresent=");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetActivePresetRequestCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetActivePresetRequestCommand implements CommandDescriptor {
        public static final SetActivePresetRequestCommand INSTANCE = new SetActivePresetRequestCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 6, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SetActivePresetRequestCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$SetActivePresetRequestCommand$Request$CommandFields thermostatTrait$SetActivePresetRequestCommand$Request$CommandFields : ThermostatTrait$SetActivePresetRequestCommand$Request$CommandFields.values()) {
                if (thermostatTrait$SetActivePresetRequestCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$SetActivePresetRequestCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$SetActivePresetRequestCommand$Request$CommandFields thermostatTrait$SetActivePresetRequestCommand$Request$CommandFields : ThermostatTrait$SetActivePresetRequestCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$SetActivePresetRequestCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$SetActivePresetRequestCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetActiveScheduleRequestCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetActiveScheduleRequestCommand implements CommandDescriptor {
        public static final SetActiveScheduleRequestCommand INSTANCE = new SetActiveScheduleRequestCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 5, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SetActiveScheduleRequestCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields thermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields : ThermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields.values()) {
                if (thermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields thermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields : ThermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$SetActiveScheduleRequestCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetTemperatureSetpointHoldPolicyCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetTemperatureSetpointHoldPolicyCommand implements CommandDescriptor {
        public static final SetTemperatureSetpointHoldPolicyCommand INSTANCE = new SetTemperatureSetpointHoldPolicyCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 11, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SetTemperatureSetpointHoldPolicyCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields thermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields : ThermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields.values()) {
                if (thermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields thermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields : ThermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$SetTemperatureSetpointHoldPolicyCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetWeeklyScheduleCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetWeeklyScheduleCommand implements CommandDescriptor {
        public static final SetWeeklyScheduleCommand INSTANCE = new SetWeeklyScheduleCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SetWeeklyScheduleCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields thermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields : ThermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields.values()) {
                if (thermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields thermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields : ThermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$SetWeeklyScheduleCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetpointRaiseLowerCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetpointRaiseLowerCommand implements CommandDescriptor {
        public static final SetpointRaiseLowerCommand INSTANCE = new SetpointRaiseLowerCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SetpointRaiseLowerCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields thermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields : ThermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields.values()) {
                if (thermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields thermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields : ThermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$SetpointRaiseLowerCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$StartPresetsSchedulesEditRequestCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StartPresetsSchedulesEditRequestCommand implements CommandDescriptor {
        public static final StartPresetsSchedulesEditRequestCommand INSTANCE = new StartPresetsSchedulesEditRequestCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ThermostatTrait.INSTANCE.getId(), 7, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StartPresetsSchedulesEditRequestCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ThermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields thermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields : ThermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields.values()) {
                if (thermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields.getTag() == tagId) {
                    return thermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ThermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields thermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields : ThermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(thermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields.name(), name)) {
                    return thermostatTrait$StartPresetsSchedulesEditRequestCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "holdDurationElapsed", "holdDurationElapsedOrPresetChanged", "<init>", "(ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHoldDurationElapsed", "()Z", "getHoldDurationElapsedOrPresetChanged", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class TemperatureSetpointHoldPolicyBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean holdDurationElapsed;
        private final boolean holdDurationElapsedOrPresetChanged;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$TemperatureSetpointHoldPolicyBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldPolicyBitmap;", "<init>", "()V", "HOLD_DURATION_ELAPSED_FLAG", "Lkotlin/ULong;", "J", "HOLD_DURATION_ELAPSED_OR_PRESET_CHANGED_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<TemperatureSetpointHoldPolicyBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(TemperatureSetpointHoldPolicyBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getHoldDurationElapsed());
                mutableBitmap.m564set4PLdz1A(2L, value.getHoldDurationElapsedOrPresetChanged());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public TemperatureSetpointHoldPolicyBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new TemperatureSetpointHoldPolicyBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public TemperatureSetpointHoldPolicyBitmap(boolean z, boolean z2) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "TemperatureSetpointHoldPolicyBitmap");
            this.holdDurationElapsed = z;
            this.holdDurationElapsedOrPresetChanged = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TemperatureSetpointHoldPolicyBitmap)) {
                return false;
            }
            TemperatureSetpointHoldPolicyBitmap temperatureSetpointHoldPolicyBitmap = (TemperatureSetpointHoldPolicyBitmap) other;
            return this.holdDurationElapsed == temperatureSetpointHoldPolicyBitmap.holdDurationElapsed && this.holdDurationElapsedOrPresetChanged == temperatureSetpointHoldPolicyBitmap.holdDurationElapsedOrPresetChanged;
        }

        public final boolean getHoldDurationElapsed() {
            return this.holdDurationElapsed;
        }

        public final boolean getHoldDurationElapsedOrPresetChanged() {
            return this.holdDurationElapsedOrPresetChanged;
        }

        public int hashCode() {
            return Boolean.hashCode(this.holdDurationElapsedOrPresetChanged) + (Boolean.hashCode(this.holdDurationElapsed) * 31);
        }

        public String toString() {
            return zzu.zza(this.holdDurationElapsedOrPresetChanged, this.holdDurationElapsed, (byte) 93, "TemperatureSetpointHoldPolicyBitmap(holdDurationElapsed=", ", holdDurationElapsedOrPresetChanged=");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$WeeklyScheduleTransitionStruct;", "", "transitionTime", "Lkotlin/UShort;", "heatSetpoint", "", "coolSetpoint", "<init>", "(SLjava/lang/Short;Ljava/lang/Short;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTransitionTime-Mh2AYeg", "()S", "S", "getHeatSetpoint", "()Ljava/lang/Short;", "Ljava/lang/Short;", "getCoolSetpoint", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WeeklyScheduleTransitionStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Short coolSetpoint;
        private final Short heatSetpoint;
        private final short transitionTime;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$WeeklyScheduleTransitionStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$WeeklyScheduleTransitionStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$WeeklyScheduleTransitionStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$WeeklyScheduleTransitionStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$WeeklyScheduleTransitionStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<WeeklyScheduleTransitionStruct>, StructDescriptor {
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
            public WeeklyScheduleTransitionStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new WeeklyScheduleTransitionStruct(payload$default.getUshort().mo546getqim9Vi0(0, "TransitionTime").getData(), payload$default.getShort().mo548getNullableqim9Vi0(1, "HeatSetpoint"), payload$default.getShort().mo548getNullableqim9Vi0(2, "CoolSetpoint"), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, WeeklyScheduleTransitionStruct value) {
                writer.getClass();
                value.getClass();
                writer.getUshort().mo554writeqim9Vi0(0, UShort.m2432boximpl(value.getTransitionTime()));
                writer.getShort().mo554writeqim9Vi0(1, value.getHeatSetpoint());
                writer.getShort().mo554writeqim9Vi0(2, value.getCoolSetpoint());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$WeeklyScheduleTransitionStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "transitionTime", "heatSetpoint", "coolSetpoint", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields coolSetpoint;
            public static final StructFields heatSetpoint;
            public static final StructFields transitionTime;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{transitionTime, heatSetpoint, coolSetpoint};
            }

            static {
                Type type = Type.UShort;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                transitionTime = new StructFields("transitionTime", 0, 0, "UShort", type, noOpDescriptor, false);
                Type type2 = Type.Short;
                heatSetpoint = new StructFields("heatSetpoint", 1, 1, "Short", type2, noOpDescriptor, true);
                coolSetpoint = new StructFields("coolSetpoint", 2, 2, "Short", type2, noOpDescriptor, true);
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

        private WeeklyScheduleTransitionStruct(short s, Short sh, Short sh2) {
            this.transitionTime = s;
            this.heatSetpoint = sh;
            this.coolSetpoint = sh2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WeeklyScheduleTransitionStruct)) {
                return false;
            }
            WeeklyScheduleTransitionStruct weeklyScheduleTransitionStruct = (WeeklyScheduleTransitionStruct) other;
            if (this.transitionTime != weeklyScheduleTransitionStruct.transitionTime) {
                return false;
            }
            Short sh = this.heatSetpoint;
            Integer numValueOf = sh != null ? Integer.valueOf(sh.shortValue()) : null;
            Short sh2 = weeklyScheduleTransitionStruct.heatSetpoint;
            if (!Intrinsics.areEqual(numValueOf, sh2 != null ? Integer.valueOf(sh2.shortValue()) : null)) {
                return false;
            }
            Short sh3 = this.coolSetpoint;
            Integer numValueOf2 = sh3 != null ? Integer.valueOf(sh3.shortValue()) : null;
            Short sh4 = weeklyScheduleTransitionStruct.coolSetpoint;
            return Intrinsics.areEqual(numValueOf2, sh4 != null ? Integer.valueOf(sh4.shortValue()) : null);
        }

        public final Short getCoolSetpoint() {
            return this.coolSetpoint;
        }

        public final Short getHeatSetpoint() {
            return this.heatSetpoint;
        }

        /* JADX INFO: renamed from: getTransitionTime-Mh2AYeg, reason: not valid java name and from getter */
        public final short getTransitionTime() {
            return this.transitionTime;
        }

        public int hashCode() {
            int iM2435hashCodeimpl = UShort.m2435hashCodeimpl(this.transitionTime) + 31;
            Short sh = this.heatSetpoint;
            int iM = zzba$$ExternalSyntheticOutline0.m(iM2435hashCodeimpl, 31, sh != null ? sh.hashCode() : 0, 31);
            Short sh2 = this.coolSetpoint;
            return iM + (sh2 != null ? sh2.hashCode() : 0);
        }

        public String toString() {
            String strM2436toStringimpl = UShort.m2436toStringimpl(this.transitionTime);
            int length = String.valueOf(strM2436toStringimpl).length();
            Short sh = this.heatSetpoint;
            int length2 = String.valueOf(sh).length();
            Short sh2 = this.coolSetpoint;
            return zzj.zza(sh2, sh, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 61, length2, 15, String.valueOf(sh2).length()) + 1), strM2436toStringimpl, "WeeklyScheduleTransitionStruct(transitionTime=", ", heatSetpoint=", ", coolSetpoint=");
        }

        public /* synthetic */ WeeklyScheduleTransitionStruct(short s, Short sh, Short sh2, DefaultConstructorMarker defaultConstructorMarker) {
            this(s, sh, sh2);
        }
    }

    private ThermostatTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "", "presetHandle", "", "transitionTimestamp", "Lkotlin/UInt;", "<init>", "([BLkotlin/UInt;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPresetHandle", "()[B", "getTransitionTimestamp-0hXNFcg", "()Lkotlin/UInt;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class QueuedPresetStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final byte[] presetHandle;
        private final UInt transitionTimestamp;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$QueuedPresetStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<QueuedPresetStruct>, StructDescriptor {
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
            public QueuedPresetStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new QueuedPresetStruct(payload$default.getBytearray().mo548getNullableqim9Vi0(0, "PresetHandle"), payload$default.getUint().mo548getNullableqim9Vi0(1, "TransitionTimestamp"), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, QueuedPresetStruct value) {
                writer.getClass();
                value.getClass();
                writer.getBytearray().mo554writeqim9Vi0(0, value.getPresetHandle());
                writer.getUint().mo554writeqim9Vi0(1, value.getTransitionTimestamp());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$QueuedPresetStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "presetHandle", "transitionTimestamp", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields presetHandle;
            public static final StructFields transitionTimestamp;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{presetHandle, transitionTimestamp};
            }

            static {
                Type type = Type.ByteArray;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                presetHandle = new StructFields("presetHandle", 0, 0, "ByteArray", type, noOpDescriptor, true);
                transitionTimestamp = new StructFields("transitionTimestamp", 1, 1, "UInt", Type.UInt, noOpDescriptor, true);
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

        public /* synthetic */ QueuedPresetStruct(byte[] bArr, UInt uInt, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? null : bArr, (i & 2) != 0 ? null : uInt, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueuedPresetStruct)) {
                return false;
            }
            QueuedPresetStruct queuedPresetStruct = (QueuedPresetStruct) other;
            return Arrays.equals(this.presetHandle, queuedPresetStruct.presetHandle) && Intrinsics.areEqual(this.transitionTimestamp, queuedPresetStruct.transitionTimestamp);
        }

        public final byte[] getPresetHandle() {
            return this.presetHandle;
        }

        /* JADX INFO: renamed from: getTransitionTimestamp-0hXNFcg, reason: not valid java name and from getter */
        public final UInt getTransitionTimestamp() {
            return this.transitionTimestamp;
        }

        public int hashCode() {
            byte[] bArr = this.presetHandle;
            int iHashCode = bArr != null ? Arrays.hashCode(bArr) : 0;
            UInt uInt = this.transitionTimestamp;
            return ((iHashCode + 31) * 31) + (uInt != null ? UInt.m2391hashCodeimpl(uInt.getData()) : 0);
        }

        public String toString() {
            return zze.zza(this.transitionTimestamp, this.presetHandle, (byte) 1, (byte) 54, "QueuedPresetStruct(presetHandle=", ", transitionTimestamp=", ")");
        }

        public /* synthetic */ QueuedPresetStruct(byte[] bArr, UInt uInt, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, uInt);
        }

        private QueuedPresetStruct(byte[] bArr, UInt uInt) {
            this.presetHandle = bArr;
            this.transitionTimestamp = uInt;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeFeaturesBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, "supportsNames", "<init>", "(ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAutomatic", "()Z", "getSupportsNames", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PresetTypeFeaturesBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean automatic;
        private final boolean supportsNames;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$PresetTypeFeaturesBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeFeaturesBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeFeaturesBitmap;", "<init>", "()V", "AUTOMATIC_FLAG", "Lkotlin/ULong;", "J", "SUPPORTS_NAMES_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<PresetTypeFeaturesBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(PresetTypeFeaturesBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getAutomatic());
                mutableBitmap.m564set4PLdz1A(2L, value.getSupportsNames());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public PresetTypeFeaturesBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new PresetTypeFeaturesBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ PresetTypeFeaturesBitmap(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == ((z ? 1 : 0) & ((i & 1) ^ 1)), z2 & ((i & 2) == 0));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresetTypeFeaturesBitmap)) {
                return false;
            }
            PresetTypeFeaturesBitmap presetTypeFeaturesBitmap = (PresetTypeFeaturesBitmap) other;
            return this.automatic == presetTypeFeaturesBitmap.automatic && this.supportsNames == presetTypeFeaturesBitmap.supportsNames;
        }

        public final boolean getAutomatic() {
            return this.automatic;
        }

        public final boolean getSupportsNames() {
            return this.supportsNames;
        }

        public int hashCode() {
            return Boolean.hashCode(this.supportsNames) + (Boolean.hashCode(this.automatic) * 31);
        }

        public String toString() {
            return zzu.zza(this.supportsNames, this.automatic, (byte) 51, "PresetTypeFeaturesBitmap(automatic=", ", supportsNames=");
        }

        public PresetTypeFeaturesBitmap(boolean z, boolean z2) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "PresetTypeFeaturesBitmap");
            this.automatic = z;
            this.supportsNames = z2;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;", "", "presetScenario", "Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;", "numberOfPresets", "Lkotlin/UByte;", "presetTypeFeatures", "Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeFeaturesBitmap;", "<init>", "(Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;BLcom/google/home/matter/standard/ThermostatTrait$PresetTypeFeaturesBitmap;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPresetScenario", "()Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;", "getNumberOfPresets-w2LRezQ", "()B", "B", "getPresetTypeFeatures", "()Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeFeaturesBitmap;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PresetTypeStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final byte numberOfPresets;
        private final PresetScenarioEnum presetScenario;
        private final PresetTypeFeaturesBitmap presetTypeFeatures;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$PresetTypeStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<PresetTypeStruct>, StructDescriptor {
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
            public PresetTypeStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new PresetTypeStruct((PresetScenarioEnum) payload$default.m545enum(PresetScenarioEnum.INSTANCE.getAdapter()).mo546getqim9Vi0(0, "PresetScenario"), payload$default.getUbyte().mo546getqim9Vi0(1, "NumberOfPresets").getData(), (PresetTypeFeaturesBitmap) payload$default.bitmap(PresetTypeFeaturesBitmap.INSTANCE).mo546getqim9Vi0(2, "PresetTypeFeatures"), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, PresetTypeStruct value) {
                writer.getClass();
                value.getClass();
                writer.m552enum(PresetScenarioEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(0, value.getPresetScenario());
                writer.getUbyte().mo554writeqim9Vi0(1, UByte.m2366boximpl(value.getNumberOfPresets()));
                writer.bitmap(PresetTypeFeaturesBitmap.INSTANCE).mo554writeqim9Vi0(2, value.getPresetTypeFeatures());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetTypeStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "presetScenario", "numberOfPresets", "presetTypeFeatures", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields numberOfPresets;
            public static final StructFields presetScenario;
            public static final StructFields presetTypeFeatures;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{presetScenario, numberOfPresets, presetTypeFeatures};
            }

            static {
                Type type = Type.Enum;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                presetScenario = new StructFields("presetScenario", 0, 0, "PresetScenarioEnum", type, noOpDescriptor, false);
                numberOfPresets = new StructFields("numberOfPresets", 1, 1, "UByte", Type.UByte, noOpDescriptor, false);
                presetTypeFeatures = new StructFields("presetTypeFeatures", 2, 2, "PresetTypeFeaturesBitmap", Type.Bitmap, noOpDescriptor, false);
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

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ PresetTypeStruct(PresetScenarioEnum presetScenarioEnum, byte b, PresetTypeFeaturesBitmap presetTypeFeaturesBitmap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            boolean z = false;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            this((i & 1) != 0 ? PresetScenarioEnum.Unspecified : presetScenarioEnum, (i & 2) != 0 ? (byte) 0 : b, (i & 4) != 0 ? new PresetTypeFeaturesBitmap(z, z, 3, defaultConstructorMarker2) : presetTypeFeaturesBitmap, defaultConstructorMarker2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresetTypeStruct)) {
                return false;
            }
            PresetTypeStruct presetTypeStruct = (PresetTypeStruct) other;
            return this.presetScenario == presetTypeStruct.presetScenario && this.numberOfPresets == presetTypeStruct.numberOfPresets && Intrinsics.areEqual(this.presetTypeFeatures, presetTypeStruct.presetTypeFeatures);
        }

        /* JADX INFO: renamed from: getNumberOfPresets-w2LRezQ, reason: not valid java name and from getter */
        public final byte getNumberOfPresets() {
            return this.numberOfPresets;
        }

        public final PresetScenarioEnum getPresetScenario() {
            return this.presetScenario;
        }

        public final PresetTypeFeaturesBitmap getPresetTypeFeatures() {
            return this.presetTypeFeatures;
        }

        public int hashCode() {
            int iHashCode = this.presetScenario.hashCode() + 31;
            int iM2369hashCodeimpl = UByte.m2369hashCodeimpl(this.numberOfPresets);
            return this.presetTypeFeatures.hashCode() + ((iM2369hashCodeimpl + (iHashCode * 31)) * 31);
        }

        public String toString() {
            String strM2370toStringimpl = UByte.m2370toStringimpl(this.numberOfPresets);
            PresetScenarioEnum presetScenarioEnum = this.presetScenario;
            int length = String.valueOf(presetScenarioEnum).length();
            int length2 = String.valueOf(strM2370toStringimpl).length();
            PresetTypeFeaturesBitmap presetTypeFeaturesBitmap = this.presetTypeFeatures;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 50, length2, 21, String.valueOf(presetTypeFeaturesBitmap).length()) + 1);
            sb.append("PresetTypeStruct(presetScenario=");
            sb.append(presetScenarioEnum);
            sb.append(", numberOfPresets=");
            sb.append(strM2370toStringimpl);
            sb.append(", presetTypeFeatures=");
            sb.append(presetTypeFeaturesBitmap);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ PresetTypeStruct(PresetScenarioEnum presetScenarioEnum, byte b, PresetTypeFeaturesBitmap presetTypeFeaturesBitmap, DefaultConstructorMarker defaultConstructorMarker) {
            this(presetScenarioEnum, b, presetTypeFeaturesBitmap);
        }

        private PresetTypeStruct(PresetScenarioEnum presetScenarioEnum, byte b, PresetTypeFeaturesBitmap presetTypeFeaturesBitmap) {
            presetScenarioEnum.getClass();
            presetTypeFeaturesBitmap.getClass();
            this.presetScenario = presetScenarioEnum;
            this.numberOfPresets = b;
            this.presetTypeFeatures = presetTypeFeaturesBitmap;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "BTUh", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AcCapacityFormatEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AcCapacityFormatEnum[] $VALUES;
        private static final EnumAdapter<AcCapacityFormatEnum> Adapter;
        public static final AcCapacityFormatEnum BTUh;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AcCapacityFormatEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$AcCapacityFormatEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<AcCapacityFormatEnum> getAdapter() {
                return AcCapacityFormatEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ AcCapacityFormatEnum[] $values() {
            return new AcCapacityFormatEnum[]{BTUh, UnknownValue};
        }

        static {
            String str = null;
            BTUh = new AcCapacityFormatEnum("BTUh", 0, 0L, null, str, 6, null);
            UnknownValue = new AcCapacityFormatEnum("UnknownValue", 1, -1L, str, null, 6, null);
            AcCapacityFormatEnum[] acCapacityFormatEnumArr$values = $values();
            $VALUES = acCapacityFormatEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(acCapacityFormatEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ AcCapacityFormatEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ACCapacityFormatEnum" : str3);
        }

        public static AcCapacityFormatEnum valueOf(String str) {
            return (AcCapacityFormatEnum) Enum.valueOf(AcCapacityFormatEnum.class, str);
        }

        public static AcCapacityFormatEnum[] values() {
            return (AcCapacityFormatEnum[]) $VALUES.clone();
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

        private AcCapacityFormatEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "T1", "T2", "T3", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AcCompressorTypeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AcCompressorTypeEnum[] $VALUES;
        private static final EnumAdapter<AcCompressorTypeEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AcCompressorTypeEnum T1;
        public static final AcCompressorTypeEnum T2;
        public static final AcCompressorTypeEnum T3;
        public static final AcCompressorTypeEnum Unknown;
        public static final AcCompressorTypeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$AcCompressorTypeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<AcCompressorTypeEnum> getAdapter() {
                return AcCompressorTypeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ AcCompressorTypeEnum[] $values() {
            return new AcCompressorTypeEnum[]{Unknown, T1, T2, T3, UnknownValue};
        }

        static {
            String str = null;
            Unknown = new AcCompressorTypeEnum(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0, 0L, null, str, 6, null);
            String str2 = null;
            T1 = new AcCompressorTypeEnum("T1", 1, 1L, str, str2, 6, null);
            String str3 = null;
            T2 = new AcCompressorTypeEnum("T2", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            T3 = new AcCompressorTypeEnum("T3", 3, 3L, str3, str4, 6, null);
            UnknownValue = new AcCompressorTypeEnum("UnknownValue", 4, -1L, str4, null, 6, null);
            AcCompressorTypeEnum[] acCompressorTypeEnumArr$values = $values();
            $VALUES = acCompressorTypeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(acCompressorTypeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ AcCompressorTypeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ACCompressorTypeEnum" : str3);
        }

        public static AcCompressorTypeEnum valueOf(String str) {
            return (AcCompressorTypeEnum) Enum.valueOf(AcCompressorTypeEnum.class, str);
        }

        public static AcCompressorTypeEnum[] values() {
            return (AcCompressorTypeEnum[]) $VALUES.clone();
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

        private AcCompressorTypeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0016B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Closed", "Open", "Quarter", "Half", "ThreeQuarters", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AcLouverPositionEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AcLouverPositionEnum[] $VALUES;
        private static final EnumAdapter<AcLouverPositionEnum> Adapter;
        public static final AcLouverPositionEnum Closed;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AcLouverPositionEnum Half;
        public static final AcLouverPositionEnum Open;
        public static final AcLouverPositionEnum Quarter;
        public static final AcLouverPositionEnum ThreeQuarters;
        public static final AcLouverPositionEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$AcLouverPositionEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<AcLouverPositionEnum> getAdapter() {
                return AcLouverPositionEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ AcLouverPositionEnum[] $values() {
            return new AcLouverPositionEnum[]{Closed, Open, Quarter, Half, ThreeQuarters, UnknownValue};
        }

        static {
            String str = null;
            Closed = new AcLouverPositionEnum("Closed", 0, 1L, null, str, 6, null);
            String str2 = null;
            Open = new AcLouverPositionEnum("Open", 1, 2L, str, str2, 6, null);
            String str3 = null;
            Quarter = new AcLouverPositionEnum("Quarter", 2, 3L, str2, str3, 6, null);
            String str4 = null;
            Half = new AcLouverPositionEnum("Half", 3, 4L, str3, str4, 6, null);
            String str5 = null;
            ThreeQuarters = new AcLouverPositionEnum("ThreeQuarters", 4, 5L, str4, str5, 6, null);
            UnknownValue = new AcLouverPositionEnum("UnknownValue", 5, -1L, str5, null, 6, null);
            AcLouverPositionEnum[] acLouverPositionEnumArr$values = $values();
            $VALUES = acLouverPositionEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(acLouverPositionEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ AcLouverPositionEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ACLouverPositionEnum" : str3);
        }

        public static AcLouverPositionEnum valueOf(String str) {
            return (AcLouverPositionEnum) Enum.valueOf(AcLouverPositionEnum.class, str);
        }

        public static AcLouverPositionEnum[] values() {
            return (AcLouverPositionEnum[]) $VALUES.clone();
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

        private AcLouverPositionEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "R22", "R410a", "R407c", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AcRefrigerantTypeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AcRefrigerantTypeEnum[] $VALUES;
        private static final EnumAdapter<AcRefrigerantTypeEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AcRefrigerantTypeEnum R22;
        public static final AcRefrigerantTypeEnum R407c;
        public static final AcRefrigerantTypeEnum R410a;
        public static final AcRefrigerantTypeEnum Unknown;
        public static final AcRefrigerantTypeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$AcRefrigerantTypeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<AcRefrigerantTypeEnum> getAdapter() {
                return AcRefrigerantTypeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ AcRefrigerantTypeEnum[] $values() {
            return new AcRefrigerantTypeEnum[]{Unknown, R22, R410a, R407c, UnknownValue};
        }

        static {
            String str = null;
            Unknown = new AcRefrigerantTypeEnum(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0, 0L, null, str, 6, null);
            String str2 = null;
            R22 = new AcRefrigerantTypeEnum("R22", 1, 1L, str, str2, 6, null);
            String str3 = null;
            R410a = new AcRefrigerantTypeEnum("R410a", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            R407c = new AcRefrigerantTypeEnum("R407c", 3, 3L, str3, str4, 6, null);
            UnknownValue = new AcRefrigerantTypeEnum("UnknownValue", 4, -1L, str4, null, 6, null);
            AcRefrigerantTypeEnum[] acRefrigerantTypeEnumArr$values = $values();
            $VALUES = acRefrigerantTypeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(acRefrigerantTypeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ AcRefrigerantTypeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ACRefrigerantTypeEnum" : str3);
        }

        public static AcRefrigerantTypeEnum valueOf(String str) {
            return (AcRefrigerantTypeEnum) Enum.valueOf(AcRefrigerantTypeEnum.class, str);
        }

        public static AcRefrigerantTypeEnum[] values() {
            return (AcRefrigerantTypeEnum[]) $VALUES.clone();
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

        private AcRefrigerantTypeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0016B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "CoolingFixed", "HeatPumpFixed", "CoolingInverter", "HeatPumpInverter", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AcTypeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AcTypeEnum[] $VALUES;
        private static final EnumAdapter<AcTypeEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AcTypeEnum CoolingFixed;
        public static final AcTypeEnum CoolingInverter;
        public static final AcTypeEnum HeatPumpFixed;
        public static final AcTypeEnum HeatPumpInverter;
        public static final AcTypeEnum Unknown;
        public static final AcTypeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$AcTypeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<AcTypeEnum> getAdapter() {
                return AcTypeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ AcTypeEnum[] $values() {
            return new AcTypeEnum[]{Unknown, CoolingFixed, HeatPumpFixed, CoolingInverter, HeatPumpInverter, UnknownValue};
        }

        static {
            String str = null;
            Unknown = new AcTypeEnum(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0, 0L, null, str, 6, null);
            String str2 = null;
            CoolingFixed = new AcTypeEnum("CoolingFixed", 1, 1L, str, str2, 6, null);
            String str3 = null;
            HeatPumpFixed = new AcTypeEnum("HeatPumpFixed", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            CoolingInverter = new AcTypeEnum("CoolingInverter", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            HeatPumpInverter = new AcTypeEnum("HeatPumpInverter", 4, 4L, str4, str5, 6, null);
            UnknownValue = new AcTypeEnum("UnknownValue", 5, -1L, str5, null, 6, null);
            AcTypeEnum[] acTypeEnumArr$values = $values();
            $VALUES = acTypeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(acTypeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ AcTypeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ACTypeEnum" : str3);
        }

        public static AcTypeEnum valueOf(String str) {
            return (AcTypeEnum) Enum.valueOf(AcTypeEnum.class, str);
        }

        public static AcTypeEnum[] values() {
            return (AcTypeEnum[]) $VALUES.clone();
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

        private AcTypeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0017B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "CoolingOnly", "CoolingWithReheat", "HeatingOnly", "HeatingWithReheat", "CoolingAndHeating", "CoolingAndHeatingWithReheat", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ControlSequenceOfOperationEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ControlSequenceOfOperationEnum[] $VALUES;
        private static final EnumAdapter<ControlSequenceOfOperationEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ControlSequenceOfOperationEnum CoolingAndHeating;
        public static final ControlSequenceOfOperationEnum CoolingAndHeatingWithReheat;
        public static final ControlSequenceOfOperationEnum CoolingOnly;
        public static final ControlSequenceOfOperationEnum CoolingWithReheat;
        public static final ControlSequenceOfOperationEnum HeatingOnly;
        public static final ControlSequenceOfOperationEnum HeatingWithReheat;
        public static final ControlSequenceOfOperationEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ControlSequenceOfOperationEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ControlSequenceOfOperationEnum> getAdapter() {
                return ControlSequenceOfOperationEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ControlSequenceOfOperationEnum[] $values() {
            return new ControlSequenceOfOperationEnum[]{CoolingOnly, CoolingWithReheat, HeatingOnly, HeatingWithReheat, CoolingAndHeating, CoolingAndHeatingWithReheat, UnknownValue};
        }

        static {
            String str = null;
            CoolingOnly = new ControlSequenceOfOperationEnum("CoolingOnly", 0, 0L, null, str, 6, null);
            String str2 = null;
            CoolingWithReheat = new ControlSequenceOfOperationEnum("CoolingWithReheat", 1, 1L, str, str2, 6, null);
            String str3 = null;
            HeatingOnly = new ControlSequenceOfOperationEnum("HeatingOnly", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            HeatingWithReheat = new ControlSequenceOfOperationEnum("HeatingWithReheat", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            CoolingAndHeating = new ControlSequenceOfOperationEnum("CoolingAndHeating", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            CoolingAndHeatingWithReheat = new ControlSequenceOfOperationEnum("CoolingAndHeatingWithReheat", 5, 5L, str5, str6, 6, null);
            UnknownValue = new ControlSequenceOfOperationEnum("UnknownValue", 6, -1L, str6, null, 6, null);
            ControlSequenceOfOperationEnum[] controlSequenceOfOperationEnumArr$values = $values();
            $VALUES = controlSequenceOfOperationEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(controlSequenceOfOperationEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ControlSequenceOfOperationEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ControlSequenceOfOperationEnum" : str3);
        }

        public static ControlSequenceOfOperationEnum valueOf(String str) {
            return (ControlSequenceOfOperationEnum) Enum.valueOf(ControlSequenceOfOperationEnum.class, str);
        }

        public static ControlSequenceOfOperationEnum[] values() {
            return (ControlSequenceOfOperationEnum[]) $VALUES.clone();
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

        private ControlSequenceOfOperationEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "Occupied", "Unoccupied", "Sleep", "Wake", "Vacation", "UserDefined", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PresetScenarioEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PresetScenarioEnum[] $VALUES;
        private static final EnumAdapter<PresetScenarioEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final PresetScenarioEnum Occupied;
        public static final PresetScenarioEnum Sleep;
        public static final PresetScenarioEnum UnknownValue;
        public static final PresetScenarioEnum Unoccupied;
        public static final PresetScenarioEnum Unspecified;
        public static final PresetScenarioEnum UserDefined;
        public static final PresetScenarioEnum Vacation;
        public static final PresetScenarioEnum Wake;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<PresetScenarioEnum> getAdapter() {
                return PresetScenarioEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ PresetScenarioEnum[] $values() {
            return new PresetScenarioEnum[]{Unspecified, Occupied, Unoccupied, Sleep, Wake, Vacation, UserDefined, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new PresetScenarioEnum("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            Occupied = new PresetScenarioEnum("Occupied", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Unoccupied = new PresetScenarioEnum("Unoccupied", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Sleep = new PresetScenarioEnum("Sleep", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Wake = new PresetScenarioEnum("Wake", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            Vacation = new PresetScenarioEnum("Vacation", 5, 5L, str5, str6, 6, null);
            String str7 = null;
            UserDefined = new PresetScenarioEnum("UserDefined", 6, 6L, str6, str7, 6, null);
            UnknownValue = new PresetScenarioEnum("UnknownValue", 7, -1L, str7, null, 6, null);
            PresetScenarioEnum[] presetScenarioEnumArr$values = $values();
            $VALUES = presetScenarioEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(presetScenarioEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ PresetScenarioEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "PresetScenarioEnum" : str3);
        }

        public static PresetScenarioEnum valueOf(String str) {
            return (PresetScenarioEnum) Enum.valueOf(PresetScenarioEnum.class, str);
        }

        public static PresetScenarioEnum[] values() {
            return (PresetScenarioEnum[]) $VALUES.clone();
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

        private PresetScenarioEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Manual", AppEventsConstants.EVENT_NAME_SCHEDULE, "External", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetpointChangeSourceEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SetpointChangeSourceEnum[] $VALUES;
        private static final EnumAdapter<SetpointChangeSourceEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SetpointChangeSourceEnum External;
        public static final SetpointChangeSourceEnum Manual;
        public static final SetpointChangeSourceEnum Schedule;
        public static final SetpointChangeSourceEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$SetpointChangeSourceEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SetpointChangeSourceEnum> getAdapter() {
                return SetpointChangeSourceEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SetpointChangeSourceEnum[] $values() {
            return new SetpointChangeSourceEnum[]{Manual, Schedule, External, UnknownValue};
        }

        static {
            String str = null;
            Manual = new SetpointChangeSourceEnum("Manual", 0, 0L, null, str, 6, null);
            String str2 = null;
            Schedule = new SetpointChangeSourceEnum(AppEventsConstants.EVENT_NAME_SCHEDULE, 1, 1L, str, str2, 6, null);
            String str3 = null;
            External = new SetpointChangeSourceEnum("External", 2, 2L, str2, str3, 6, null);
            UnknownValue = new SetpointChangeSourceEnum("UnknownValue", 3, -1L, str3, null, 6, null);
            SetpointChangeSourceEnum[] setpointChangeSourceEnumArr$values = $values();
            $VALUES = setpointChangeSourceEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(setpointChangeSourceEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SetpointChangeSourceEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SetpointChangeSourceEnum" : str3);
        }

        public static SetpointChangeSourceEnum valueOf(String str) {
            return (SetpointChangeSourceEnum) Enum.valueOf(SetpointChangeSourceEnum.class, str);
        }

        public static SetpointChangeSourceEnum[] values() {
            return (SetpointChangeSourceEnum[]) $VALUES.clone();
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

        private SetpointChangeSourceEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetpointRaiseLowerModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Heat", "Cool", "Both", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetpointRaiseLowerModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SetpointRaiseLowerModeEnum[] $VALUES;
        private static final EnumAdapter<SetpointRaiseLowerModeEnum> Adapter;
        public static final SetpointRaiseLowerModeEnum Both;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SetpointRaiseLowerModeEnum Cool;
        public static final SetpointRaiseLowerModeEnum Heat;
        public static final SetpointRaiseLowerModeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SetpointRaiseLowerModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$SetpointRaiseLowerModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SetpointRaiseLowerModeEnum> getAdapter() {
                return SetpointRaiseLowerModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SetpointRaiseLowerModeEnum[] $values() {
            return new SetpointRaiseLowerModeEnum[]{Heat, Cool, Both, UnknownValue};
        }

        static {
            String str = null;
            Heat = new SetpointRaiseLowerModeEnum("Heat", 0, 0L, null, str, 6, null);
            String str2 = null;
            Cool = new SetpointRaiseLowerModeEnum("Cool", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Both = new SetpointRaiseLowerModeEnum("Both", 2, 2L, str2, str3, 6, null);
            UnknownValue = new SetpointRaiseLowerModeEnum("UnknownValue", 3, -1L, str3, null, 6, null);
            SetpointRaiseLowerModeEnum[] setpointRaiseLowerModeEnumArr$values = $values();
            $VALUES = setpointRaiseLowerModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(setpointRaiseLowerModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SetpointRaiseLowerModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SetpointRaiseLowerModeEnum" : str3);
        }

        public static SetpointRaiseLowerModeEnum valueOf(String str) {
            return (SetpointRaiseLowerModeEnum) Enum.valueOf(SetpointRaiseLowerModeEnum.class, str);
        }

        public static SetpointRaiseLowerModeEnum[] values() {
            return (SetpointRaiseLowerModeEnum[]) $VALUES.clone();
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

        private SetpointRaiseLowerModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StartOfWeekEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StartOfWeekEnum[] $VALUES;
        private static final EnumAdapter<StartOfWeekEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final StartOfWeekEnum Friday;
        public static final StartOfWeekEnum Monday;
        public static final StartOfWeekEnum Saturday;
        public static final StartOfWeekEnum Sunday;
        public static final StartOfWeekEnum Thursday;
        public static final StartOfWeekEnum Tuesday;
        public static final StartOfWeekEnum UnknownValue;
        public static final StartOfWeekEnum Wednesday;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$StartOfWeekEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<StartOfWeekEnum> getAdapter() {
                return StartOfWeekEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ StartOfWeekEnum[] $values() {
            return new StartOfWeekEnum[]{Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, UnknownValue};
        }

        static {
            String str = null;
            Sunday = new StartOfWeekEnum("Sunday", 0, 0L, null, str, 6, null);
            String str2 = null;
            Monday = new StartOfWeekEnum("Monday", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Tuesday = new StartOfWeekEnum("Tuesday", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Wednesday = new StartOfWeekEnum("Wednesday", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Thursday = new StartOfWeekEnum("Thursday", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            Friday = new StartOfWeekEnum("Friday", 5, 5L, str5, str6, 6, null);
            String str7 = null;
            Saturday = new StartOfWeekEnum("Saturday", 6, 6L, str6, str7, 6, null);
            UnknownValue = new StartOfWeekEnum("UnknownValue", 7, -1L, str7, null, 6, null);
            StartOfWeekEnum[] startOfWeekEnumArr$values = $values();
            $VALUES = startOfWeekEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(startOfWeekEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ StartOfWeekEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "StartOfWeekEnum" : str3);
        }

        public static StartOfWeekEnum valueOf(String str) {
            return (StartOfWeekEnum) Enum.valueOf(StartOfWeekEnum.class, str);
        }

        public static StartOfWeekEnum[] values() {
            return (StartOfWeekEnum[]) $VALUES.clone();
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

        private StartOfWeekEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001aB%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Off", "Auto", "Cool", "Heat", "EmergencyHeat", "Precooling", "FanOnly", "Dry", "Sleep", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SystemModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SystemModeEnum[] $VALUES;
        private static final EnumAdapter<SystemModeEnum> Adapter;
        public static final SystemModeEnum Auto;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SystemModeEnum Cool;
        public static final SystemModeEnum Dry;
        public static final SystemModeEnum EmergencyHeat;
        public static final SystemModeEnum FanOnly;
        public static final SystemModeEnum Heat;
        public static final SystemModeEnum Off;
        public static final SystemModeEnum Precooling;
        public static final SystemModeEnum Sleep;
        public static final SystemModeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SystemModeEnum> getAdapter() {
                return SystemModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SystemModeEnum[] $values() {
            return new SystemModeEnum[]{Off, Auto, Cool, Heat, EmergencyHeat, Precooling, FanOnly, Dry, Sleep, UnknownValue};
        }

        static {
            String str = null;
            Off = new SystemModeEnum("Off", 0, 0L, null, str, 6, null);
            String str2 = null;
            Auto = new SystemModeEnum("Auto", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Cool = new SystemModeEnum("Cool", 2, 3L, str2, str3, 6, null);
            String str4 = null;
            Heat = new SystemModeEnum("Heat", 3, 4L, str3, str4, 6, null);
            String str5 = null;
            EmergencyHeat = new SystemModeEnum("EmergencyHeat", 4, 5L, str4, str5, 6, null);
            String str6 = null;
            Precooling = new SystemModeEnum("Precooling", 5, 6L, str5, str6, 6, null);
            String str7 = null;
            FanOnly = new SystemModeEnum("FanOnly", 6, 7L, str6, str7, 6, null);
            String str8 = null;
            Dry = new SystemModeEnum("Dry", 7, 8L, str7, str8, 6, null);
            String str9 = null;
            Sleep = new SystemModeEnum("Sleep", 8, 9L, str8, str9, 6, null);
            UnknownValue = new SystemModeEnum("UnknownValue", 9, -1L, str9, null, 6, null);
            SystemModeEnum[] systemModeEnumArr$values = $values();
            $VALUES = systemModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(systemModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SystemModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SystemModeEnum" : str3);
        }

        public static SystemModeEnum valueOf(String str) {
            return (SystemModeEnum) Enum.valueOf(SystemModeEnum.class, str);
        }

        public static SystemModeEnum[] values() {
            return (SystemModeEnum[]) $VALUES.clone();
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

        private SystemModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "SetpointHoldOff", "SetpointHoldOn", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TemperatureSetpointHoldEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TemperatureSetpointHoldEnum[] $VALUES;
        private static final EnumAdapter<TemperatureSetpointHoldEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final TemperatureSetpointHoldEnum SetpointHoldOff;
        public static final TemperatureSetpointHoldEnum SetpointHoldOn;
        public static final TemperatureSetpointHoldEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$TemperatureSetpointHoldEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<TemperatureSetpointHoldEnum> getAdapter() {
                return TemperatureSetpointHoldEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ TemperatureSetpointHoldEnum[] $values() {
            return new TemperatureSetpointHoldEnum[]{SetpointHoldOff, SetpointHoldOn, UnknownValue};
        }

        static {
            String str = null;
            SetpointHoldOff = new TemperatureSetpointHoldEnum("SetpointHoldOff", 0, 0L, null, str, 6, null);
            String str2 = null;
            SetpointHoldOn = new TemperatureSetpointHoldEnum("SetpointHoldOn", 1, 1L, str, str2, 6, null);
            UnknownValue = new TemperatureSetpointHoldEnum("UnknownValue", 2, -1L, str2, null, 6, null);
            TemperatureSetpointHoldEnum[] temperatureSetpointHoldEnumArr$values = $values();
            $VALUES = temperatureSetpointHoldEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(temperatureSetpointHoldEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ TemperatureSetpointHoldEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "TemperatureSetpointHoldEnum" : str3);
        }

        public static TemperatureSetpointHoldEnum valueOf(String str) {
            return (TemperatureSetpointHoldEnum) Enum.valueOf(TemperatureSetpointHoldEnum.class, str);
        }

        public static TemperatureSetpointHoldEnum[] values() {
            return (TemperatureSetpointHoldEnum[]) $VALUES.clone();
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

        private TemperatureSetpointHoldEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Off", "Cool", "Heat", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ThermostatRunningModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ThermostatRunningModeEnum[] $VALUES;
        private static final EnumAdapter<ThermostatRunningModeEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ThermostatRunningModeEnum Cool;
        public static final ThermostatRunningModeEnum Heat;
        public static final ThermostatRunningModeEnum Off;
        public static final ThermostatRunningModeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ThermostatRunningModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ThermostatRunningModeEnum> getAdapter() {
                return ThermostatRunningModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ThermostatRunningModeEnum[] $values() {
            return new ThermostatRunningModeEnum[]{Off, Cool, Heat, UnknownValue};
        }

        static {
            String str = null;
            Off = new ThermostatRunningModeEnum("Off", 0, 0L, null, str, 6, null);
            String str2 = null;
            Cool = new ThermostatRunningModeEnum("Cool", 1, 3L, str, str2, 6, null);
            String str3 = null;
            Heat = new ThermostatRunningModeEnum("Heat", 2, 4L, str2, str3, 6, null);
            UnknownValue = new ThermostatRunningModeEnum("UnknownValue", 3, -1L, str3, null, 6, null);
            ThermostatRunningModeEnum[] thermostatRunningModeEnumArr$values = $values();
            $VALUES = thermostatRunningModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(thermostatRunningModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ThermostatRunningModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ThermostatRunningModeEnum" : str3);
        }

        public static ThermostatRunningModeEnum valueOf(String str) {
            return (ThermostatRunningModeEnum) Enum.valueOf(ThermostatRunningModeEnum.class, str);
        }

        public static ThermostatRunningModeEnum[] values() {
            return (ThermostatRunningModeEnum[]) $VALUES.clone();
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

        private ThermostatRunningModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;", "", "systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "numberOfSchedules", "Lkotlin/UByte;", "scheduleTypeFeatures", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeFeaturesBitmap;", "<init>", "(Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;BLcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeFeaturesBitmap;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSystemMode", "()Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "getNumberOfSchedules-w2LRezQ", "()B", "B", "getScheduleTypeFeatures", "()Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeFeaturesBitmap;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ScheduleTypeStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final byte numberOfSchedules;
        private final ScheduleTypeFeaturesBitmap scheduleTypeFeatures;
        private final SystemModeEnum systemMode;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ScheduleTypeStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<ScheduleTypeStruct>, StructDescriptor {
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
            public ScheduleTypeStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new ScheduleTypeStruct((SystemModeEnum) payload$default.m545enum(SystemModeEnum.INSTANCE.getAdapter()).mo546getqim9Vi0(0, "SystemMode"), payload$default.getUbyte().mo546getqim9Vi0(1, "NumberOfSchedules").getData(), (ScheduleTypeFeaturesBitmap) payload$default.bitmap(ScheduleTypeFeaturesBitmap.INSTANCE).mo546getqim9Vi0(2, "ScheduleTypeFeatures"), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, ScheduleTypeStruct value) {
                writer.getClass();
                value.getClass();
                writer.m552enum(SystemModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(0, value.getSystemMode());
                writer.getUbyte().mo554writeqim9Vi0(1, UByte.m2366boximpl(value.getNumberOfSchedules()));
                writer.bitmap(ScheduleTypeFeaturesBitmap.INSTANCE).mo554writeqim9Vi0(2, value.getScheduleTypeFeatures());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "systemMode", "numberOfSchedules", "scheduleTypeFeatures", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields numberOfSchedules;
            public static final StructFields scheduleTypeFeatures;
            public static final StructFields systemMode;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{systemMode, numberOfSchedules, scheduleTypeFeatures};
            }

            static {
                Type type = Type.Enum;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                systemMode = new StructFields("systemMode", 0, 0, "SystemModeEnum", type, noOpDescriptor, false);
                numberOfSchedules = new StructFields("numberOfSchedules", 1, 1, "UByte", Type.UByte, noOpDescriptor, false);
                scheduleTypeFeatures = new StructFields("scheduleTypeFeatures", 2, 2, "ScheduleTypeFeaturesBitmap", Type.Bitmap, noOpDescriptor, false);
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

        public /* synthetic */ ScheduleTypeStruct(SystemModeEnum systemModeEnum, byte b, ScheduleTypeFeaturesBitmap scheduleTypeFeaturesBitmap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SystemModeEnum.Off : systemModeEnum, (i & 2) != 0 ? (byte) 0 : b, (i & 4) != 0 ? new ScheduleTypeFeaturesBitmap(false, false, false, false, 15, null) : scheduleTypeFeaturesBitmap, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduleTypeStruct)) {
                return false;
            }
            ScheduleTypeStruct scheduleTypeStruct = (ScheduleTypeStruct) other;
            return this.systemMode == scheduleTypeStruct.systemMode && this.numberOfSchedules == scheduleTypeStruct.numberOfSchedules && Intrinsics.areEqual(this.scheduleTypeFeatures, scheduleTypeStruct.scheduleTypeFeatures);
        }

        /* JADX INFO: renamed from: getNumberOfSchedules-w2LRezQ, reason: not valid java name and from getter */
        public final byte getNumberOfSchedules() {
            return this.numberOfSchedules;
        }

        public final ScheduleTypeFeaturesBitmap getScheduleTypeFeatures() {
            return this.scheduleTypeFeatures;
        }

        public final SystemModeEnum getSystemMode() {
            return this.systemMode;
        }

        public int hashCode() {
            int iHashCode = this.systemMode.hashCode() + 31;
            int iM2369hashCodeimpl = UByte.m2369hashCodeimpl(this.numberOfSchedules);
            return this.scheduleTypeFeatures.hashCode() + ((iM2369hashCodeimpl + (iHashCode * 31)) * 31);
        }

        public String toString() {
            String strM2370toStringimpl = UByte.m2370toStringimpl(this.numberOfSchedules);
            SystemModeEnum systemModeEnum = this.systemMode;
            int length = String.valueOf(systemModeEnum).length();
            int length2 = String.valueOf(strM2370toStringimpl).length();
            ScheduleTypeFeaturesBitmap scheduleTypeFeaturesBitmap = this.scheduleTypeFeatures;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 50, length2, 23, String.valueOf(scheduleTypeFeaturesBitmap).length()) + 1);
            sb.append("ScheduleTypeStruct(systemMode=");
            sb.append(systemModeEnum);
            sb.append(", numberOfSchedules=");
            sb.append(strM2370toStringimpl);
            sb.append(", scheduleTypeFeatures=");
            sb.append(scheduleTypeFeaturesBitmap);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ ScheduleTypeStruct(SystemModeEnum systemModeEnum, byte b, ScheduleTypeFeaturesBitmap scheduleTypeFeaturesBitmap, DefaultConstructorMarker defaultConstructorMarker) {
            this(systemModeEnum, b, scheduleTypeFeaturesBitmap);
        }

        private ScheduleTypeStruct(SystemModeEnum systemModeEnum, byte b, ScheduleTypeFeaturesBitmap scheduleTypeFeaturesBitmap) {
            systemModeEnum.getClass();
            scheduleTypeFeaturesBitmap.getClass();
            this.systemMode = systemModeEnum;
            this.numberOfSchedules = b;
            this.scheduleTypeFeatures = scheduleTypeFeaturesBitmap;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeFeaturesBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "supportsPresets", "supportsSetpoints", "supportsNames", "supportsOff", "<init>", "(ZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSupportsPresets", "()Z", "getSupportsSetpoints", "getSupportsNames", "getSupportsOff", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ScheduleTypeFeaturesBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean supportsNames;
        private final boolean supportsOff;
        private final boolean supportsPresets;
        private final boolean supportsSetpoints;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ScheduleTypeFeaturesBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeFeaturesBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTypeFeaturesBitmap;", "<init>", "()V", "SUPPORTS_PRESETS_FLAG", "Lkotlin/ULong;", "J", "SUPPORTS_SETPOINTS_FLAG", "SUPPORTS_NAMES_FLAG", "SUPPORTS_OFF_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ScheduleTypeFeaturesBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ScheduleTypeFeaturesBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getSupportsPresets());
                mutableBitmap.m564set4PLdz1A(2L, value.getSupportsSetpoints());
                mutableBitmap.m564set4PLdz1A(4L, value.getSupportsNames());
                mutableBitmap.m564set4PLdz1A(8L, value.getSupportsOff());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ScheduleTypeFeaturesBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new ScheduleTypeFeaturesBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ScheduleTypeFeaturesBitmap(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == ((z ? 1 : 0) & ((i & 1) ^ 1)), z2 & ((i & 2) == 0), z3 & ((i & 4) == 0), z4 & ((i & 8) == 0));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduleTypeFeaturesBitmap)) {
                return false;
            }
            ScheduleTypeFeaturesBitmap scheduleTypeFeaturesBitmap = (ScheduleTypeFeaturesBitmap) other;
            return this.supportsPresets == scheduleTypeFeaturesBitmap.supportsPresets && this.supportsSetpoints == scheduleTypeFeaturesBitmap.supportsSetpoints && this.supportsNames == scheduleTypeFeaturesBitmap.supportsNames && this.supportsOff == scheduleTypeFeaturesBitmap.supportsOff;
        }

        public final boolean getSupportsNames() {
            return this.supportsNames;
        }

        public final boolean getSupportsOff() {
            return this.supportsOff;
        }

        public final boolean getSupportsPresets() {
            return this.supportsPresets;
        }

        public final boolean getSupportsSetpoints() {
            return this.supportsSetpoints;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.supportsSetpoints) + (Boolean.hashCode(this.supportsPresets) * 31);
            int iHashCode2 = Boolean.hashCode(this.supportsNames);
            return Boolean.hashCode(this.supportsOff) + ((iHashCode2 + (iHashCode * 31)) * 31);
        }

        public String toString() {
            boolean z = this.supportsPresets;
            int length = String.valueOf(z).length();
            boolean z2 = this.supportsSetpoints;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.supportsNames;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.supportsOff;
            return zzs.zza(z4, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 63, length2, 16, length3, 14, String.valueOf(z4).length()) + 1), z3, z2, z, "ScheduleTypeFeaturesBitmap(supportsPresets=", ", supportsSetpoints=", ", supportsNames=", ", supportsOff=");
        }

        public ScheduleTypeFeaturesBitmap(boolean z, boolean z2, boolean z3, boolean z4) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ScheduleTypeFeaturesBitmap");
            this.supportsPresets = z;
            this.supportsSetpoints = z2;
            this.supportsNames = z3;
            this.supportsOff = z4;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002 !B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006\""}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "", "scheduleHandle", "", "systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "name", "Lcom/google/home/matter/serialization/OptionalValue;", "", "presetHandle", "transitions", "", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct;", "builtIn", "", "<init>", "([BLcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;Lcom/google/home/matter/serialization/OptionalValue;Lcom/google/home/matter/serialization/OptionalValue;Ljava/util/List;Lcom/google/home/matter/serialization/OptionalValue;)V", "getScheduleHandle", "()[B", "getSystemMode", "()Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "getName", "()Lcom/google/home/matter/serialization/OptionalValue;", "getPresetHandle", "getTransitions", "()Ljava/util/List;", "getBuiltIn", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ScheduleStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final OptionalValue<Boolean> builtIn;
        private final OptionalValue<String> name;
        private final OptionalValue<byte[]> presetHandle;
        private final byte[] scheduleHandle;
        private final SystemModeEnum systemMode;
        private final List<ScheduleTransitionStruct> transitions;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ScheduleStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<ScheduleStruct>, StructDescriptor {
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
            public ScheduleStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(4), ScheduleTransitionStruct.INSTANCE)));
                return new ScheduleStruct(payload.getBytearray().mo548getNullableqim9Vi0(0, "ScheduleHandle"), (SystemModeEnum) payload.m545enum(SystemModeEnum.INSTANCE.getAdapter()).mo546getqim9Vi0(1, "SystemMode"), payload.getString().m551getOptionalqim9Vi0(2, "Name"), payload.getBytearray().m551getOptionalqim9Vi0(3, "PresetHandle"), new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<ScheduleTransitionStruct>() { // from class: com.google.home.matter.standard.ThermostatTrait$ScheduleStruct$Adapter$read$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ThermostatTrait.ScheduleTransitionStruct invoke() {
                        return new ThermostatTrait.ScheduleTransitionStruct(null, (short) 0, null, null, null, null, 63, null);
                    }
                }, Reflection.getOrCreateKotlinClass(ScheduleTransitionStruct.class)).mo547getListqim9Vi0(4, "Transitions"), payload.getBoolean().mo549getOptionalNullableqim9Vi0(5, "BuiltIn"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, ScheduleStruct value) {
                writer.getClass();
                value.getClass();
                writer.getBytearray().mo554writeqim9Vi0(0, value.getScheduleHandle());
                writer.m552enum(SystemModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.getSystemMode());
                writer.getString().mo553writeqim9Vi0(2, value.getName());
                writer.getBytearray().mo553writeqim9Vi0(3, (OptionalValue<? extends byte[]>) value.getPresetHandle());
                writer.struct(ScheduleTransitionStruct.INSTANCE).mo555writeListqim9Vi0(4, value.getTransitions());
                writer.getBoolean().mo553writeqim9Vi0(5, value.getBuiltIn());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "scheduleHandle", "systemMode", "Name", "presetHandle", "transitions", "builtIn", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields Name;
            public static final StructFields builtIn;
            public static final StructFields presetHandle;
            public static final StructFields scheduleHandle;
            public static final StructFields systemMode;
            public static final StructFields transitions;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{scheduleHandle, systemMode, Name, presetHandle, transitions, builtIn};
            }

            static {
                Type type = Type.ByteArray;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                scheduleHandle = new StructFields("scheduleHandle", 0, 0, "ByteArray", type, noOpDescriptor, true);
                systemMode = new StructFields("systemMode", 1, 1, "SystemModeEnum", Type.Enum, noOpDescriptor, false);
                Name = new StructFields("Name", 2, 2, "String", Type.String, noOpDescriptor, false);
                presetHandle = new StructFields("presetHandle", 3, 3, "ByteArray", type, noOpDescriptor, false);
                transitions = new StructFields("transitions", 4, 4, "ScheduleTransitionStruct", Type.Struct, ScheduleTransitionStruct.INSTANCE, false);
                builtIn = new StructFields("builtIn", 5, 5, "Boolean", Type.Boolean, noOpDescriptor, true);
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

        public /* synthetic */ ScheduleStruct(byte[] bArr, SystemModeEnum systemModeEnum, OptionalValue optionalValue, OptionalValue optionalValue2, List list, OptionalValue optionalValue3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? null : bArr, (i & 2) != 0 ? SystemModeEnum.Off : systemModeEnum, (i & 4) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue, (i & 8) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue2, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduleStruct)) {
                return false;
            }
            ScheduleStruct scheduleStruct = (ScheduleStruct) other;
            return Arrays.equals(this.scheduleHandle, scheduleStruct.scheduleHandle) && this.systemMode == scheduleStruct.systemMode && Intrinsics.areEqual(this.name, scheduleStruct.name) && Intrinsics.areEqual(this.presetHandle, scheduleStruct.presetHandle) && Intrinsics.areEqual(this.transitions, scheduleStruct.transitions) && Intrinsics.areEqual(this.builtIn, scheduleStruct.builtIn);
        }

        public final OptionalValue<Boolean> getBuiltIn() {
            return this.builtIn;
        }

        public final OptionalValue<String> getName() {
            return this.name;
        }

        public final OptionalValue<byte[]> getPresetHandle() {
            return this.presetHandle;
        }

        public final byte[] getScheduleHandle() {
            return this.scheduleHandle;
        }

        public final SystemModeEnum getSystemMode() {
            return this.systemMode;
        }

        public final List<ScheduleTransitionStruct> getTransitions() {
            return this.transitions;
        }

        public int hashCode() {
            byte[] bArr = this.scheduleHandle;
            int iHashCode = this.presetHandle.hashCode() + ((this.name.hashCode() + ((this.systemMode.hashCode() + (((bArr != null ? Arrays.hashCode(bArr) : 0) + 31) * 31)) * 31)) * 31);
            return this.builtIn.hashCode() + ((this.transitions.hashCode() + (iHashCode * 31)) * 31);
        }

        public String toString() {
            byte[] bArr = this.scheduleHandle;
            int length = String.valueOf(bArr).length();
            SystemModeEnum systemModeEnum = this.systemMode;
            int length2 = String.valueOf(systemModeEnum).length();
            OptionalValue<String> optionalValue = this.name;
            int length3 = String.valueOf(optionalValue).length();
            OptionalValue<byte[]> optionalValue2 = this.presetHandle;
            int length4 = String.valueOf(optionalValue2).length();
            List<ScheduleTransitionStruct> list = this.transitions;
            int length5 = String.valueOf(list).length();
            OptionalValue<Boolean> optionalValue3 = this.builtIn;
            return zzh.zza(optionalValue3, list, optionalValue2, optionalValue, systemModeEnum, new StringBuilder(length + 43 + length2 + 7 + length3 + 15 + length4 + 14 + length5 + 10 + String.valueOf(optionalValue3).length() + 1), bArr, ", systemMode=", "ScheduleStruct(scheduleHandle=", ", name=", ", presetHandle=", ", transitions=", ", builtIn=", ")");
        }

        public ScheduleStruct(byte[] bArr, SystemModeEnum systemModeEnum, OptionalValue<String> optionalValue, OptionalValue<byte[]> optionalValue2, List<ScheduleTransitionStruct> list, OptionalValue<Boolean> optionalValue3) {
            systemModeEnum.getClass();
            optionalValue.getClass();
            optionalValue2.getClass();
            list.getClass();
            optionalValue3.getClass();
            this.scheduleHandle = bArr;
            this.systemMode = systemModeEnum;
            this.name = optionalValue;
            this.presetHandle = optionalValue2;
            this.transitions = list;
            this.builtIn = optionalValue3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002 !B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "", "presetHandle", "", "presetScenario", "Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;", "name", "Lcom/google/home/matter/serialization/OptionalValue;", "", "coolingSetpoint", "", "heatingSetpoint", "builtIn", "", "<init>", "([BLcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;Lcom/google/home/matter/serialization/OptionalValue;Lcom/google/home/matter/serialization/OptionalValue;Lcom/google/home/matter/serialization/OptionalValue;Ljava/lang/Boolean;)V", "getPresetHandle", "()[B", "getPresetScenario", "()Lcom/google/home/matter/standard/ThermostatTrait$PresetScenarioEnum;", "getName", "()Lcom/google/home/matter/serialization/OptionalValue;", "getCoolingSetpoint", "getHeatingSetpoint", "getBuiltIn", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PresetStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean builtIn;
        private final OptionalValue<Short> coolingSetpoint;
        private final OptionalValue<Short> heatingSetpoint;
        private final OptionalValue<String> name;
        private final byte[] presetHandle;
        private final PresetScenarioEnum presetScenario;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$PresetStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<PresetStruct>, StructDescriptor {
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
            public PresetStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new PresetStruct(payload$default.getBytearray().mo548getNullableqim9Vi0(0, "PresetHandle"), (PresetScenarioEnum) payload$default.m545enum(PresetScenarioEnum.INSTANCE.getAdapter()).mo546getqim9Vi0(1, "PresetScenario"), payload$default.getString().mo549getOptionalNullableqim9Vi0(2, "Name"), payload$default.getShort().m551getOptionalqim9Vi0(3, "CoolingSetpoint"), payload$default.getShort().m551getOptionalqim9Vi0(4, "HeatingSetpoint"), payload$default.getBoolean().mo548getNullableqim9Vi0(5, "BuiltIn"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, PresetStruct value) {
                writer.getClass();
                value.getClass();
                writer.getBytearray().mo554writeqim9Vi0(0, value.getPresetHandle());
                writer.m552enum(PresetScenarioEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.getPresetScenario());
                writer.getString().mo553writeqim9Vi0(2, value.getName());
                writer.getShort().mo553writeqim9Vi0(3, value.getCoolingSetpoint());
                writer.getShort().mo553writeqim9Vi0(4, value.getHeatingSetpoint());
                writer.getBoolean().mo554writeqim9Vi0(5, value.getBuiltIn());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$PresetStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "presetHandle", "presetScenario", "Name", "coolingSetpoint", "heatingSetpoint", "builtIn", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields Name;
            public static final StructFields builtIn;
            public static final StructFields coolingSetpoint;
            public static final StructFields heatingSetpoint;
            public static final StructFields presetHandle;
            public static final StructFields presetScenario;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{presetHandle, presetScenario, Name, coolingSetpoint, heatingSetpoint, builtIn};
            }

            static {
                Type type = Type.ByteArray;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                presetHandle = new StructFields("presetHandle", 0, 0, "ByteArray", type, noOpDescriptor, true);
                presetScenario = new StructFields("presetScenario", 1, 1, "PresetScenarioEnum", Type.Enum, noOpDescriptor, false);
                Name = new StructFields("Name", 2, 2, "String", Type.String, noOpDescriptor, true);
                Type type2 = Type.Short;
                coolingSetpoint = new StructFields("coolingSetpoint", 3, 3, "Short", type2, noOpDescriptor, false);
                heatingSetpoint = new StructFields("heatingSetpoint", 4, 4, "Short", type2, noOpDescriptor, false);
                builtIn = new StructFields("builtIn", 5, 5, "Boolean", Type.Boolean, noOpDescriptor, true);
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

        public /* synthetic */ PresetStruct(byte[] bArr, PresetScenarioEnum presetScenarioEnum, OptionalValue optionalValue, OptionalValue optionalValue2, OptionalValue optionalValue3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? null : bArr, (i & 2) != 0 ? PresetScenarioEnum.Unspecified : presetScenarioEnum, (i & 4) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue, (i & 8) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue2, (i & 16) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue3, (i & 32) != 0 ? null : bool);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresetStruct)) {
                return false;
            }
            PresetStruct presetStruct = (PresetStruct) other;
            return Arrays.equals(this.presetHandle, presetStruct.presetHandle) && this.presetScenario == presetStruct.presetScenario && Intrinsics.areEqual(this.name, presetStruct.name) && Intrinsics.areEqual(this.coolingSetpoint, presetStruct.coolingSetpoint) && Intrinsics.areEqual(this.heatingSetpoint, presetStruct.heatingSetpoint) && Intrinsics.areEqual(this.builtIn, presetStruct.builtIn);
        }

        public final Boolean getBuiltIn() {
            return this.builtIn;
        }

        public final OptionalValue<Short> getCoolingSetpoint() {
            return this.coolingSetpoint;
        }

        public final OptionalValue<Short> getHeatingSetpoint() {
            return this.heatingSetpoint;
        }

        public final OptionalValue<String> getName() {
            return this.name;
        }

        public final byte[] getPresetHandle() {
            return this.presetHandle;
        }

        public final PresetScenarioEnum getPresetScenario() {
            return this.presetScenario;
        }

        public int hashCode() {
            byte[] bArr = this.presetHandle;
            int iHashCode = this.heatingSetpoint.hashCode() + ((this.coolingSetpoint.hashCode() + ((this.name.hashCode() + ((this.presetScenario.hashCode() + (((bArr != null ? Arrays.hashCode(bArr) : 0) + 31) * 31)) * 31)) * 31)) * 31);
            Boolean bool = this.builtIn;
            return (iHashCode * 31) + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            byte[] bArr = this.presetHandle;
            int length = String.valueOf(bArr).length();
            PresetScenarioEnum presetScenarioEnum = this.presetScenario;
            int length2 = String.valueOf(presetScenarioEnum).length();
            OptionalValue<String> optionalValue = this.name;
            int length3 = String.valueOf(optionalValue).length();
            OptionalValue<Short> optionalValue2 = this.coolingSetpoint;
            int length4 = String.valueOf(optionalValue2).length();
            OptionalValue<Short> optionalValue3 = this.heatingSetpoint;
            int length5 = String.valueOf(optionalValue3).length();
            Boolean bool = this.builtIn;
            return zzh.zza(bool, optionalValue3, optionalValue2, optionalValue, presetScenarioEnum, new StringBuilder(length + 43 + length2 + 7 + length3 + 18 + length4 + 18 + length5 + 10 + String.valueOf(bool).length() + 1), bArr, ", presetScenario=", "PresetStruct(presetHandle=", ", name=", ", coolingSetpoint=", ", heatingSetpoint=", ", builtIn=", ")");
        }

        public PresetStruct(byte[] bArr, PresetScenarioEnum presetScenarioEnum, OptionalValue<String> optionalValue, OptionalValue<Short> optionalValue2, OptionalValue<Short> optionalValue3, Boolean bool) {
            presetScenarioEnum.getClass();
            optionalValue.getClass();
            optionalValue2.getClass();
            optionalValue3.getClass();
            this.presetHandle = bArr;
            this.presetScenario = presetScenarioEnum;
            this.name = optionalValue;
            this.coolingSetpoint = optionalValue2;
            this.heatingSetpoint = optionalValue3;
            this.builtIn = bool;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u0019¨\u0006\""}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleDayOfWeekBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "away", "<init>", "(ZZZZZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSunday", "()Z", "getMonday", "getTuesday", "getWednesday", "getThursday", "getFriday", "getSaturday", "getAway", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ScheduleDayOfWeekBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean away;
        private final boolean friday;
        private final boolean monday;
        private final boolean saturday;
        private final boolean sunday;
        private final boolean thursday;
        private final boolean tuesday;
        private final boolean wednesday;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ScheduleDayOfWeekBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleDayOfWeekBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleDayOfWeekBitmap;", "<init>", "()V", "SUNDAY_FLAG", "Lkotlin/ULong;", "J", "MONDAY_FLAG", "TUESDAY_FLAG", "WEDNESDAY_FLAG", "THURSDAY_FLAG", "FRIDAY_FLAG", "SATURDAY_FLAG", "AWAY_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ScheduleDayOfWeekBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ScheduleDayOfWeekBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getSunday());
                mutableBitmap.m564set4PLdz1A(2L, value.getMonday());
                mutableBitmap.m564set4PLdz1A(4L, value.getTuesday());
                mutableBitmap.m564set4PLdz1A(8L, value.getWednesday());
                mutableBitmap.m564set4PLdz1A(16L, value.getThursday());
                mutableBitmap.m564set4PLdz1A(32L, value.getFriday());
                mutableBitmap.m564set4PLdz1A(64L, value.getSaturday());
                mutableBitmap.m564set4PLdz1A(128L, value.getAway());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ScheduleDayOfWeekBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new ScheduleDayOfWeekBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L), value.m525getVKZWuLQ(16L), value.m525getVKZWuLQ(32L), value.m525getVKZWuLQ(64L), value.m525getVKZWuLQ(128L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ScheduleDayOfWeekBitmap(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == ((z ? 1 : 0) & ((i & 1) ^ 1)), z2 & ((i & 2) == 0), z3 & ((i & 4) == 0), z4 & ((i & 8) == 0), z5 & ((i & 16) == 0), z6 & ((i & 32) == 0), z7 & ((i & 64) == 0), z8 & ((i & 128) == 0));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduleDayOfWeekBitmap)) {
                return false;
            }
            ScheduleDayOfWeekBitmap scheduleDayOfWeekBitmap = (ScheduleDayOfWeekBitmap) other;
            return this.sunday == scheduleDayOfWeekBitmap.sunday && this.monday == scheduleDayOfWeekBitmap.monday && this.tuesday == scheduleDayOfWeekBitmap.tuesday && this.wednesday == scheduleDayOfWeekBitmap.wednesday && this.thursday == scheduleDayOfWeekBitmap.thursday && this.friday == scheduleDayOfWeekBitmap.friday && this.saturday == scheduleDayOfWeekBitmap.saturday && this.away == scheduleDayOfWeekBitmap.away;
        }

        public final boolean getAway() {
            return this.away;
        }

        public final boolean getFriday() {
            return this.friday;
        }

        public final boolean getMonday() {
            return this.monday;
        }

        public final boolean getSaturday() {
            return this.saturday;
        }

        public final boolean getSunday() {
            return this.sunday;
        }

        public final boolean getThursday() {
            return this.thursday;
        }

        public final boolean getTuesday() {
            return this.tuesday;
        }

        public final boolean getWednesday() {
            return this.wednesday;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.monday) + (Boolean.hashCode(this.sunday) * 31);
            int iHashCode2 = Boolean.hashCode(this.tuesday) + (iHashCode * 31);
            int iHashCode3 = Boolean.hashCode(this.wednesday) + (iHashCode2 * 31);
            int iHashCode4 = Boolean.hashCode(this.thursday) + (iHashCode3 * 31);
            int iHashCode5 = Boolean.hashCode(this.friday) + (iHashCode4 * 31);
            int iHashCode6 = Boolean.hashCode(this.saturday);
            return Boolean.hashCode(this.away) + ((iHashCode6 + (iHashCode5 * 31)) * 31);
        }

        public String toString() {
            boolean z = this.sunday;
            int length = String.valueOf(z).length();
            boolean z2 = this.monday;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.tuesday;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.wednesday;
            int length4 = String.valueOf(z4).length();
            boolean z5 = this.thursday;
            int length5 = String.valueOf(z5).length();
            boolean z6 = this.friday;
            int length6 = String.valueOf(z6).length();
            boolean z7 = this.saturday;
            int length7 = String.valueOf(z7).length();
            boolean z8 = this.away;
            StringBuilder sb = new StringBuilder(length + 40 + length2 + 10 + length3 + 12 + length4 + 11 + length5 + 9 + length6 + 11 + length7 + 7 + String.valueOf(z8).length() + 1);
            zza$$ExternalSyntheticOutline0.m(sb, "ScheduleDayOfWeekBitmap(sunday=", z, ", monday=", z2);
            zza$$ExternalSyntheticOutline0.m(sb, ", tuesday=", z3, ", wednesday=", z4);
            zza$$ExternalSyntheticOutline0.m(sb, ", thursday=", z5, ", friday=", z6);
            zza$$ExternalSyntheticOutline0.m(sb, ", saturday=", z7, ", away=", z8);
            sb.append(")");
            return sb.toString();
        }

        public ScheduleDayOfWeekBitmap(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
            super(zza$$ExternalSyntheticOutline0.m(513, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ScheduleDayOfWeekBitmap");
            this.sunday = z;
            this.monday = z2;
            this.tuesday = z3;
            this.wednesday = z4;
            this.thursday = z5;
            this.friday = z6;
            this.saturday = z7;
            this.away = z8;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002!\"B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006#"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct;", "", "dayOfWeek", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleDayOfWeekBitmap;", "transitionTime", "Lkotlin/UShort;", "presetHandle", "Lcom/google/home/matter/serialization/OptionalValue;", "", "systemMode", "Lcom/google/home/matter/standard/ThermostatTrait$SystemModeEnum;", "coolingSetpoint", "", "heatingSetpoint", "<init>", "(Lcom/google/home/matter/standard/ThermostatTrait$ScheduleDayOfWeekBitmap;SLcom/google/home/matter/serialization/OptionalValue;Lcom/google/home/matter/serialization/OptionalValue;Lcom/google/home/matter/serialization/OptionalValue;Lcom/google/home/matter/serialization/OptionalValue;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDayOfWeek", "()Lcom/google/home/matter/standard/ThermostatTrait$ScheduleDayOfWeekBitmap;", "getTransitionTime-Mh2AYeg", "()S", "S", "getPresetHandle", "()Lcom/google/home/matter/serialization/OptionalValue;", "getSystemMode", "getCoolingSetpoint", "getHeatingSetpoint", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "StructFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ScheduleTransitionStruct {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final OptionalValue<Short> coolingSetpoint;
        private final ScheduleDayOfWeekBitmap dayOfWeek;
        private final OptionalValue<Short> heatingSetpoint;
        private final OptionalValue<byte[]> presetHandle;
        private final OptionalValue<SystemModeEnum> systemMode;
        private final short transitionTime;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatTrait$ScheduleTransitionStruct$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<ScheduleTransitionStruct>, StructDescriptor {
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
            public ScheduleTransitionStruct read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new ScheduleTransitionStruct((ScheduleDayOfWeekBitmap) payload$default.bitmap(ScheduleDayOfWeekBitmap.INSTANCE).mo546getqim9Vi0(0, "DayOfWeek"), payload$default.getUshort().mo546getqim9Vi0(1, "TransitionTime").getData(), payload$default.getBytearray().m551getOptionalqim9Vi0(2, "PresetHandle"), payload$default.m545enum(SystemModeEnum.INSTANCE.getAdapter()).m551getOptionalqim9Vi0(3, "SystemMode"), payload$default.getShort().m551getOptionalqim9Vi0(4, "CoolingSetpoint"), payload$default.getShort().m551getOptionalqim9Vi0(5, "HeatingSetpoint"), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, ScheduleTransitionStruct value) {
                writer.getClass();
                value.getClass();
                writer.bitmap(ScheduleDayOfWeekBitmap.INSTANCE).mo554writeqim9Vi0(0, value.getDayOfWeek());
                writer.getUshort().mo554writeqim9Vi0(1, UShort.m2432boximpl(value.getTransitionTime()));
                writer.getBytearray().mo553writeqim9Vi0(2, (OptionalValue<? extends byte[]>) value.getPresetHandle());
                writer.m552enum(SystemModeEnum.INSTANCE.getAdapter()).mo553writeqim9Vi0(3, (OptionalValue) value.getSystemMode());
                writer.getShort().mo553writeqim9Vi0(4, value.getCoolingSetpoint());
                writer.getShort().mo553writeqim9Vi0(5, value.getHeatingSetpoint());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/google/home/matter/standard/ThermostatTrait$ScheduleTransitionStruct$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "dayOfWeek", "transitionTime", "presetHandle", "systemMode", "coolingSetpoint", "heatingSetpoint", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields coolingSetpoint;
            public static final StructFields dayOfWeek;
            public static final StructFields heatingSetpoint;
            public static final StructFields presetHandle;
            public static final StructFields systemMode;
            public static final StructFields transitionTime;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{dayOfWeek, transitionTime, presetHandle, systemMode, coolingSetpoint, heatingSetpoint};
            }

            static {
                Type type = Type.Bitmap;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                dayOfWeek = new StructFields("dayOfWeek", 0, 0, "ScheduleDayOfWeekBitmap", type, noOpDescriptor, false);
                transitionTime = new StructFields("transitionTime", 1, 1, "UShort", Type.UShort, noOpDescriptor, false);
                presetHandle = new StructFields("presetHandle", 2, 2, "ByteArray", Type.ByteArray, noOpDescriptor, false);
                systemMode = new StructFields("systemMode", 3, 3, "SystemModeEnum", Type.Enum, noOpDescriptor, false);
                Type type2 = Type.Short;
                coolingSetpoint = new StructFields("coolingSetpoint", 4, 4, "Short", type2, noOpDescriptor, false);
                heatingSetpoint = new StructFields("heatingSetpoint", 5, 5, "Short", type2, noOpDescriptor, false);
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

        public /* synthetic */ ScheduleTransitionStruct(ScheduleDayOfWeekBitmap scheduleDayOfWeekBitmap, short s, OptionalValue optionalValue, OptionalValue optionalValue2, OptionalValue optionalValue3, OptionalValue optionalValue4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ScheduleDayOfWeekBitmap(false, false, false, false, false, false, false, false, PHIpAddressSearchManager.END_IP_SCAN, null) : scheduleDayOfWeekBitmap, (i & 2) != 0 ? (short) 0 : s, (i & 4) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue, (i & 8) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue2, (i & 16) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue3, (i & 32) != 0 ? OptionalValue.INSTANCE.absent() : optionalValue4, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduleTransitionStruct)) {
                return false;
            }
            ScheduleTransitionStruct scheduleTransitionStruct = (ScheduleTransitionStruct) other;
            return Intrinsics.areEqual(this.dayOfWeek, scheduleTransitionStruct.dayOfWeek) && this.transitionTime == scheduleTransitionStruct.transitionTime && Intrinsics.areEqual(this.presetHandle, scheduleTransitionStruct.presetHandle) && Intrinsics.areEqual(this.systemMode, scheduleTransitionStruct.systemMode) && Intrinsics.areEqual(this.coolingSetpoint, scheduleTransitionStruct.coolingSetpoint) && Intrinsics.areEqual(this.heatingSetpoint, scheduleTransitionStruct.heatingSetpoint);
        }

        public final OptionalValue<Short> getCoolingSetpoint() {
            return this.coolingSetpoint;
        }

        public final ScheduleDayOfWeekBitmap getDayOfWeek() {
            return this.dayOfWeek;
        }

        public final OptionalValue<Short> getHeatingSetpoint() {
            return this.heatingSetpoint;
        }

        public final OptionalValue<byte[]> getPresetHandle() {
            return this.presetHandle;
        }

        public final OptionalValue<SystemModeEnum> getSystemMode() {
            return this.systemMode;
        }

        /* JADX INFO: renamed from: getTransitionTime-Mh2AYeg, reason: not valid java name and from getter */
        public final short getTransitionTime() {
            return this.transitionTime;
        }

        public int hashCode() {
            int iHashCode = this.dayOfWeek.hashCode() + 31;
            int iM2435hashCodeimpl = UShort.m2435hashCodeimpl(this.transitionTime) + (iHashCode * 31);
            int iHashCode2 = this.presetHandle.hashCode() + (iM2435hashCodeimpl * 31);
            int iHashCode3 = this.systemMode.hashCode() + (iHashCode2 * 31);
            int iHashCode4 = this.coolingSetpoint.hashCode();
            return this.heatingSetpoint.hashCode() + ((iHashCode4 + (iHashCode3 * 31)) * 31);
        }

        public String toString() {
            String strM2436toStringimpl = UShort.m2436toStringimpl(this.transitionTime);
            ScheduleDayOfWeekBitmap scheduleDayOfWeekBitmap = this.dayOfWeek;
            int length = String.valueOf(scheduleDayOfWeekBitmap).length();
            int length2 = String.valueOf(strM2436toStringimpl).length();
            OptionalValue<byte[]> optionalValue = this.presetHandle;
            int length3 = String.valueOf(optionalValue).length();
            OptionalValue<SystemModeEnum> optionalValue2 = this.systemMode;
            int length4 = String.valueOf(optionalValue2).length();
            OptionalValue<Short> optionalValue3 = this.coolingSetpoint;
            int length5 = String.valueOf(optionalValue3).length();
            OptionalValue<Short> optionalValue4 = this.heatingSetpoint;
            StringBuilder sb = new StringBuilder(length + 52 + length2 + 15 + length3 + 13 + length4 + 18 + length5 + 18 + String.valueOf(optionalValue4).length() + 1);
            sb.append("ScheduleTransitionStruct(dayOfWeek=");
            sb.append(scheduleDayOfWeekBitmap);
            sb.append(", transitionTime=");
            sb.append(strM2436toStringimpl);
            sb.append(", presetHandle=");
            sb.append(optionalValue);
            sb.append(", systemMode=");
            sb.append(optionalValue2);
            sb.append(", coolingSetpoint=");
            sb.append(optionalValue3);
            sb.append(", heatingSetpoint=");
            sb.append(optionalValue4);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ ScheduleTransitionStruct(ScheduleDayOfWeekBitmap scheduleDayOfWeekBitmap, short s, OptionalValue optionalValue, OptionalValue optionalValue2, OptionalValue optionalValue3, OptionalValue optionalValue4, DefaultConstructorMarker defaultConstructorMarker) {
            this(scheduleDayOfWeekBitmap, s, optionalValue, optionalValue2, optionalValue3, optionalValue4);
        }

        private ScheduleTransitionStruct(ScheduleDayOfWeekBitmap scheduleDayOfWeekBitmap, short s, OptionalValue<byte[]> optionalValue, OptionalValue<SystemModeEnum> optionalValue2, OptionalValue<Short> optionalValue3, OptionalValue<Short> optionalValue4) {
            scheduleDayOfWeekBitmap.getClass();
            optionalValue.getClass();
            optionalValue2.getClass();
            optionalValue3.getClass();
            optionalValue4.getClass();
            this.dayOfWeek = scheduleDayOfWeekBitmap;
            this.transitionTime = s;
            this.presetHandle = optionalValue;
            this.systemMode = optionalValue2;
            this.coolingSetpoint = optionalValue3;
            this.heatingSetpoint = optionalValue4;
        }
    }
}

package data;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class SensorDataLog$PbSensorDataLog extends GeneratedMessageLite<SensorDataLog$PbSensorDataLog, Builder> implements MessageLiteOrBuilder {
    public static final int ACCELERATION_LOG_ENABLED_FIELD_NUMBER = 2;
    public static final int AMBIENT_LIGHT_LOG_ENABLED_FIELD_NUMBER = 13;
    public static final int AMD_LOG_ENABLED_FIELD_NUMBER = 21;
    public static final int BAROMETER_LOG_ENABLED_FIELD_NUMBER = 9;
    public static final int CALORIES_LOG_ENABLED_FIELD_NUMBER = 3;
    public static final int CAPSENSE_LOG_ENABLED_FIELD_NUMBER = 17;
    public static final int COMPASS_LOG_ENABLED_FIELD_NUMBER = 23;
    private static final SensorDataLog$PbSensorDataLog DEFAULT_INSTANCE;
    public static final int FUSION_LOG_ENABLED_FIELD_NUMBER = 18;
    public static final int GPS_LOG_ENABLED_FIELD_NUMBER = 4;
    public static final int GPS_NMEA_LOG_ENABLED_FIELD_NUMBER = 5;
    public static final int GYROSCOPE_LOG_ENABLED_FIELD_NUMBER = 10;
    public static final int LOG_TRIGGER_FIELD_NUMBER = 1;
    public static final int MAGNETOMETER_LOG_ENABLED_FIELD_NUMBER = 7;
    public static final int MAGNETOMETER_LOG_FREQUENCY_FIELD_NUMBER = 50;
    public static final int MET_LOG_ENABLED_FIELD_NUMBER = 19;
    public static final int OHR_LOG_ENABLED_FIELD_NUMBER = 6;
    public static final int ONDEMAND_LOG_ENABLED_FIELD_NUMBER = 16;
    private static volatile Parser<SensorDataLog$PbSensorDataLog> PARSER = null;
    public static final int PPI_LOG_ENABLED_FIELD_NUMBER = 15;
    public static final int RETAIN_SETTINGS_OVER_BOOT_FIELD_NUMBER = 100;
    public static final int SKIN_TEMPERATURE_LOG_ENABLED_FIELD_NUMBER = 22;
    public static final int SLEEP_LOG_ENABLED_FIELD_NUMBER = 11;
    public static final int SLOPE_LOG_ENABLED_FIELD_NUMBER = 12;
    public static final int SPEED3D_LOG_ENABLED_FIELD_NUMBER = 24;
    public static final int TAP_LOG_ENABLED_FIELD_NUMBER = 8;
    public static final int TLR_LOG_ENABLED_FIELD_NUMBER = 14;
    public static final int VERTICAL_ACC_LOG_ENABLED_FIELD_NUMBER = 20;
    private boolean accelerationLogEnabled_;
    private boolean ambientLightLogEnabled_;
    private boolean amdLogEnabled_;
    private boolean barometerLogEnabled_;
    private int bitField0_;
    private boolean caloriesLogEnabled_;
    private boolean capsenseLogEnabled_;
    private boolean compassLogEnabled_;
    private boolean fusionLogEnabled_;
    private boolean gpsLogEnabled_;
    private boolean gpsNmeaLogEnabled_;
    private boolean gyroscopeLogEnabled_;
    private int logTrigger_;
    private boolean magnetometerLogEnabled_;
    private int magnetometerLogFrequency_ = 1;
    private boolean metLogEnabled_;
    private boolean ohrLogEnabled_;
    private boolean ondemandLogEnabled_;
    private boolean ppiLogEnabled_;
    private boolean retainSettingsOverBoot_;
    private boolean skinTemperatureLogEnabled_;
    private boolean sleepLogEnabled_;
    private boolean slopeLogEnabled_;
    private boolean speed3DLogEnabled_;
    private boolean tapLogEnabled_;
    private boolean tlrLogEnabled_;
    private boolean verticalAccLogEnabled_;

    public enum PbLogTrigger implements Internal.EnumLite {
        LOG_TRIGGER_SYSTEM(0),
        LOG_TRIGGER_FORCED(1),
        LOG_TRIGGER_EXERCISE(2);

        private static final Internal.EnumLiteMap<PbLogTrigger> internalValueMap = new Internal.EnumLiteMap<PbLogTrigger>() { // from class: data.SensorDataLog.PbSensorDataLog.PbLogTrigger.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbLogTrigger findValueByNumber(int i) {
                return PbLogTrigger.forNumber(i);
            }
        };
        private final int value;

        public static final class PbLogTriggerVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbLogTriggerVerifier();

            private PbLogTriggerVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbLogTrigger.forNumber(i) != null;
            }
        }

        PbLogTrigger(int i) {
            this.value = i;
        }

        public static PbLogTrigger forNumber(int i) {
            if (i == 0) {
                return LOG_TRIGGER_SYSTEM;
            }
            if (i == 1) {
                return LOG_TRIGGER_FORCED;
            }
            if (i != 2) {
                return null;
            }
            return LOG_TRIGGER_EXERCISE;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbLogTriggerVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum PbMagnetometerLogFrequency implements Internal.EnumLite {
        MAG_LOG_10HZ(1),
        MAG_LOG_50HZ(2),
        MAG_LOG_100HZ(3);

        private static final Internal.EnumLiteMap<PbMagnetometerLogFrequency> internalValueMap = new Internal.EnumLiteMap<PbMagnetometerLogFrequency>() { // from class: data.SensorDataLog.PbSensorDataLog.PbMagnetometerLogFrequency.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbMagnetometerLogFrequency findValueByNumber(int i) {
                return PbMagnetometerLogFrequency.forNumber(i);
            }
        };
        private final int value;

        public static final class PbMagnetometerLogFrequencyVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbMagnetometerLogFrequencyVerifier();

            private PbMagnetometerLogFrequencyVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbMagnetometerLogFrequency.forNumber(i) != null;
            }
        }

        PbMagnetometerLogFrequency(int i) {
            this.value = i;
        }

        public static PbMagnetometerLogFrequency forNumber(int i) {
            if (i == 1) {
                return MAG_LOG_10HZ;
            }
            if (i == 2) {
                return MAG_LOG_50HZ;
            }
            if (i != 3) {
                return null;
            }
            return MAG_LOG_100HZ;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbMagnetometerLogFrequencyVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        SensorDataLog$PbSensorDataLog sensorDataLog$PbSensorDataLog = new SensorDataLog$PbSensorDataLog();
        DEFAULT_INSTANCE = sensorDataLog$PbSensorDataLog;
        GeneratedMessageLite.registerDefaultInstance(SensorDataLog$PbSensorDataLog.class, sensorDataLog$PbSensorDataLog);
    }

    private SensorDataLog$PbSensorDataLog() {
    }

    private void clearAccelerationLogEnabled() {
        this.bitField0_ &= -3;
        this.accelerationLogEnabled_ = false;
    }

    private void clearAmbientLightLogEnabled() {
        this.bitField0_ &= -4097;
        this.ambientLightLogEnabled_ = false;
    }

    private void clearAmdLogEnabled() {
        this.bitField0_ &= -1048577;
        this.amdLogEnabled_ = false;
    }

    private void clearBarometerLogEnabled() {
        this.bitField0_ &= -257;
        this.barometerLogEnabled_ = false;
    }

    private void clearCaloriesLogEnabled() {
        this.bitField0_ &= -5;
        this.caloriesLogEnabled_ = false;
    }

    private void clearCapsenseLogEnabled() {
        this.bitField0_ &= -65537;
        this.capsenseLogEnabled_ = false;
    }

    private void clearCompassLogEnabled() {
        this.bitField0_ &= -4194305;
        this.compassLogEnabled_ = false;
    }

    private void clearFusionLogEnabled() {
        this.bitField0_ &= -131073;
        this.fusionLogEnabled_ = false;
    }

    private void clearGpsLogEnabled() {
        this.bitField0_ &= -9;
        this.gpsLogEnabled_ = false;
    }

    private void clearGpsNmeaLogEnabled() {
        this.bitField0_ &= -17;
        this.gpsNmeaLogEnabled_ = false;
    }

    private void clearGyroscopeLogEnabled() {
        this.bitField0_ &= -513;
        this.gyroscopeLogEnabled_ = false;
    }

    private void clearLogTrigger() {
        this.bitField0_ &= -2;
        this.logTrigger_ = 0;
    }

    private void clearMagnetometerLogEnabled() {
        this.bitField0_ &= -65;
        this.magnetometerLogEnabled_ = false;
    }

    private void clearMagnetometerLogFrequency() {
        this.bitField0_ &= -16777217;
        this.magnetometerLogFrequency_ = 1;
    }

    private void clearMetLogEnabled() {
        this.bitField0_ &= -262145;
        this.metLogEnabled_ = false;
    }

    private void clearOhrLogEnabled() {
        this.bitField0_ &= -33;
        this.ohrLogEnabled_ = false;
    }

    private void clearOndemandLogEnabled() {
        this.bitField0_ &= -32769;
        this.ondemandLogEnabled_ = false;
    }

    private void clearPpiLogEnabled() {
        this.bitField0_ &= -16385;
        this.ppiLogEnabled_ = false;
    }

    private void clearRetainSettingsOverBoot() {
        this.bitField0_ &= -33554433;
        this.retainSettingsOverBoot_ = false;
    }

    private void clearSkinTemperatureLogEnabled() {
        this.bitField0_ &= -2097153;
        this.skinTemperatureLogEnabled_ = false;
    }

    private void clearSleepLogEnabled() {
        this.bitField0_ &= -1025;
        this.sleepLogEnabled_ = false;
    }

    private void clearSlopeLogEnabled() {
        this.bitField0_ &= -2049;
        this.slopeLogEnabled_ = false;
    }

    private void clearSpeed3DLogEnabled() {
        this.bitField0_ &= -8388609;
        this.speed3DLogEnabled_ = false;
    }

    private void clearTapLogEnabled() {
        this.bitField0_ &= -129;
        this.tapLogEnabled_ = false;
    }

    private void clearTlrLogEnabled() {
        this.bitField0_ &= -8193;
        this.tlrLogEnabled_ = false;
    }

    private void clearVerticalAccLogEnabled() {
        this.bitField0_ &= -524289;
        this.verticalAccLogEnabled_ = false;
    }

    public static SensorDataLog$PbSensorDataLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SensorDataLog$PbSensorDataLog parseDelimitedFrom(InputStream inputStream) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(ByteBuffer byteBuffer) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SensorDataLog$PbSensorDataLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccelerationLogEnabled(boolean z) {
        this.bitField0_ |= 2;
        this.accelerationLogEnabled_ = z;
    }

    private void setAmbientLightLogEnabled(boolean z) {
        this.bitField0_ |= 4096;
        this.ambientLightLogEnabled_ = z;
    }

    private void setAmdLogEnabled(boolean z) {
        this.bitField0_ |= 1048576;
        this.amdLogEnabled_ = z;
    }

    private void setBarometerLogEnabled(boolean z) {
        this.bitField0_ |= 256;
        this.barometerLogEnabled_ = z;
    }

    private void setCaloriesLogEnabled(boolean z) {
        this.bitField0_ |= 4;
        this.caloriesLogEnabled_ = z;
    }

    private void setCapsenseLogEnabled(boolean z) {
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.capsenseLogEnabled_ = z;
    }

    private void setCompassLogEnabled(boolean z) {
        this.bitField0_ |= 4194304;
        this.compassLogEnabled_ = z;
    }

    private void setFusionLogEnabled(boolean z) {
        this.bitField0_ |= 131072;
        this.fusionLogEnabled_ = z;
    }

    private void setGpsLogEnabled(boolean z) {
        this.bitField0_ |= 8;
        this.gpsLogEnabled_ = z;
    }

    private void setGpsNmeaLogEnabled(boolean z) {
        this.bitField0_ |= 16;
        this.gpsNmeaLogEnabled_ = z;
    }

    private void setGyroscopeLogEnabled(boolean z) {
        this.bitField0_ |= 512;
        this.gyroscopeLogEnabled_ = z;
    }

    private void setLogTrigger(PbLogTrigger pbLogTrigger) {
        this.logTrigger_ = pbLogTrigger.getNumber();
        this.bitField0_ |= 1;
    }

    private void setMagnetometerLogEnabled(boolean z) {
        this.bitField0_ |= 64;
        this.magnetometerLogEnabled_ = z;
    }

    private void setMagnetometerLogFrequency(PbMagnetometerLogFrequency pbMagnetometerLogFrequency) {
        this.magnetometerLogFrequency_ = pbMagnetometerLogFrequency.getNumber();
        this.bitField0_ |= 16777216;
    }

    private void setMetLogEnabled(boolean z) {
        this.bitField0_ |= 262144;
        this.metLogEnabled_ = z;
    }

    private void setOhrLogEnabled(boolean z) {
        this.bitField0_ |= 32;
        this.ohrLogEnabled_ = z;
    }

    private void setOndemandLogEnabled(boolean z) {
        this.bitField0_ |= 32768;
        this.ondemandLogEnabled_ = z;
    }

    private void setPpiLogEnabled(boolean z) {
        this.bitField0_ |= 16384;
        this.ppiLogEnabled_ = z;
    }

    private void setRetainSettingsOverBoot(boolean z) {
        this.bitField0_ |= 33554432;
        this.retainSettingsOverBoot_ = z;
    }

    private void setSkinTemperatureLogEnabled(boolean z) {
        this.bitField0_ |= 2097152;
        this.skinTemperatureLogEnabled_ = z;
    }

    private void setSleepLogEnabled(boolean z) {
        this.bitField0_ |= 1024;
        this.sleepLogEnabled_ = z;
    }

    private void setSlopeLogEnabled(boolean z) {
        this.bitField0_ |= 2048;
        this.slopeLogEnabled_ = z;
    }

    private void setSpeed3DLogEnabled(boolean z) {
        this.bitField0_ |= 8388608;
        this.speed3DLogEnabled_ = z;
    }

    private void setTapLogEnabled(boolean z) {
        this.bitField0_ |= 128;
        this.tapLogEnabled_ = z;
    }

    private void setTlrLogEnabled(boolean z) {
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.tlrLogEnabled_ = z;
    }

    private void setVerticalAccLogEnabled(boolean z) {
        this.bitField0_ |= 524288;
        this.verticalAccLogEnabled_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (SensorDataLog$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SensorDataLog$PbSensorDataLog();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u001a\u0000\u0001\u0001d\u001a\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဇ\u000b\rဇ\f\u000eဇ\r\u000fဇ\u000e\u0010ဇ\u000f\u0011ဇ\u0010\u0012ဇ\u0011\u0013ဇ\u0012\u0014ဇ\u0013\u0015ဇ\u0014\u0016ဇ\u0015\u0017ဇ\u0016\u0018ဇ\u00172ဌ\u0018dဇ\u0019", new Object[]{"bitField0_", "logTrigger_", PbLogTrigger.internalGetVerifier(), "accelerationLogEnabled_", "caloriesLogEnabled_", "gpsLogEnabled_", "gpsNmeaLogEnabled_", "ohrLogEnabled_", "magnetometerLogEnabled_", "tapLogEnabled_", "barometerLogEnabled_", "gyroscopeLogEnabled_", "sleepLogEnabled_", "slopeLogEnabled_", "ambientLightLogEnabled_", "tlrLogEnabled_", "ppiLogEnabled_", "ondemandLogEnabled_", "capsenseLogEnabled_", "fusionLogEnabled_", "metLogEnabled_", "verticalAccLogEnabled_", "amdLogEnabled_", "skinTemperatureLogEnabled_", "compassLogEnabled_", "speed3DLogEnabled_", "magnetometerLogFrequency_", PbMagnetometerLogFrequency.internalGetVerifier(), "retainSettingsOverBoot_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SensorDataLog$PbSensorDataLog> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SensorDataLog$PbSensorDataLog.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public boolean getAccelerationLogEnabled() {
        return this.accelerationLogEnabled_;
    }

    public boolean getAmbientLightLogEnabled() {
        return this.ambientLightLogEnabled_;
    }

    public boolean getAmdLogEnabled() {
        return this.amdLogEnabled_;
    }

    public boolean getBarometerLogEnabled() {
        return this.barometerLogEnabled_;
    }

    public boolean getCaloriesLogEnabled() {
        return this.caloriesLogEnabled_;
    }

    public boolean getCapsenseLogEnabled() {
        return this.capsenseLogEnabled_;
    }

    public boolean getCompassLogEnabled() {
        return this.compassLogEnabled_;
    }

    public boolean getFusionLogEnabled() {
        return this.fusionLogEnabled_;
    }

    public boolean getGpsLogEnabled() {
        return this.gpsLogEnabled_;
    }

    public boolean getGpsNmeaLogEnabled() {
        return this.gpsNmeaLogEnabled_;
    }

    public boolean getGyroscopeLogEnabled() {
        return this.gyroscopeLogEnabled_;
    }

    public PbLogTrigger getLogTrigger() {
        PbLogTrigger pbLogTriggerForNumber = PbLogTrigger.forNumber(this.logTrigger_);
        return pbLogTriggerForNumber == null ? PbLogTrigger.LOG_TRIGGER_SYSTEM : pbLogTriggerForNumber;
    }

    public boolean getMagnetometerLogEnabled() {
        return this.magnetometerLogEnabled_;
    }

    public PbMagnetometerLogFrequency getMagnetometerLogFrequency() {
        PbMagnetometerLogFrequency pbMagnetometerLogFrequencyForNumber = PbMagnetometerLogFrequency.forNumber(this.magnetometerLogFrequency_);
        return pbMagnetometerLogFrequencyForNumber == null ? PbMagnetometerLogFrequency.MAG_LOG_10HZ : pbMagnetometerLogFrequencyForNumber;
    }

    public boolean getMetLogEnabled() {
        return this.metLogEnabled_;
    }

    public boolean getOhrLogEnabled() {
        return this.ohrLogEnabled_;
    }

    public boolean getOndemandLogEnabled() {
        return this.ondemandLogEnabled_;
    }

    public boolean getPpiLogEnabled() {
        return this.ppiLogEnabled_;
    }

    public boolean getRetainSettingsOverBoot() {
        return this.retainSettingsOverBoot_;
    }

    public boolean getSkinTemperatureLogEnabled() {
        return this.skinTemperatureLogEnabled_;
    }

    public boolean getSleepLogEnabled() {
        return this.sleepLogEnabled_;
    }

    public boolean getSlopeLogEnabled() {
        return this.slopeLogEnabled_;
    }

    public boolean getSpeed3DLogEnabled() {
        return this.speed3DLogEnabled_;
    }

    public boolean getTapLogEnabled() {
        return this.tapLogEnabled_;
    }

    public boolean getTlrLogEnabled() {
        return this.tlrLogEnabled_;
    }

    public boolean getVerticalAccLogEnabled() {
        return this.verticalAccLogEnabled_;
    }

    public boolean hasAccelerationLogEnabled() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasAmbientLightLogEnabled() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasAmdLogEnabled() {
        return (this.bitField0_ & 1048576) != 0;
    }

    public boolean hasBarometerLogEnabled() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasCaloriesLogEnabled() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCapsenseLogEnabled() {
        return (this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0;
    }

    public boolean hasCompassLogEnabled() {
        return (this.bitField0_ & 4194304) != 0;
    }

    public boolean hasFusionLogEnabled() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasGpsLogEnabled() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasGpsNmeaLogEnabled() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasGyroscopeLogEnabled() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasLogTrigger() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMagnetometerLogEnabled() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasMagnetometerLogFrequency() {
        return (this.bitField0_ & 16777216) != 0;
    }

    public boolean hasMetLogEnabled() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasOhrLogEnabled() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasOndemandLogEnabled() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasPpiLogEnabled() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasRetainSettingsOverBoot() {
        return (this.bitField0_ & 33554432) != 0;
    }

    public boolean hasSkinTemperatureLogEnabled() {
        return (this.bitField0_ & 2097152) != 0;
    }

    public boolean hasSleepLogEnabled() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasSlopeLogEnabled() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasSpeed3DLogEnabled() {
        return (this.bitField0_ & 8388608) != 0;
    }

    public boolean hasTapLogEnabled() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasTlrLogEnabled() {
        return (this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public boolean hasVerticalAccLogEnabled() {
        return (this.bitField0_ & 524288) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<SensorDataLog$PbSensorDataLog, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(SensorDataLog$PbSensorDataLog.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(SensorDataLog$PbSensorDataLog sensorDataLog$PbSensorDataLog) {
        return DEFAULT_INSTANCE.createBuilder(sensorDataLog$PbSensorDataLog);
    }

    public static SensorDataLog$PbSensorDataLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(ByteString byteString) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(byte[] bArr) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(InputStream inputStream) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(CodedInputStream codedInputStream) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SensorDataLog$PbSensorDataLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorDataLog$PbSensorDataLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}

package com.polar.sdk.api;

import com.polar.sdk.api.model.LedConfig;
import com.polar.sdk.api.model.PolarDeviceInfo;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u0002:\u0002\u001f B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/polar/sdk/api/PolarBleApi;", "Lcom/polar/sdk/api/PolarOnlineStreamingApi;", "", "", "Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "features", "<init>", "(Ljava/util/Set;)V", "", "shutDown", "()V", "Lcom/polar/sdk/api/PolarBleApiCallbackProvider;", "callback", "setApiCallback", "(Lcom/polar/sdk/api/PolarBleApiCallbackProvider;)V", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/sdk/api/model/PolarDeviceInfo;", "searchForDevice", "()Lio/reactivex/rxjava3/core/Flowable;", "", "identifier", "connectToDevice", "(Ljava/lang/String;)V", "Lcom/polar/sdk/api/model/LedConfig;", "ledConfig", "Lio/reactivex/rxjava3/core/Completable;", "setLedConfig", "(Ljava/lang/String;Lcom/polar/sdk/api/model/LedConfig;)Lio/reactivex/rxjava3/core/Completable;", "Ljava/util/Set;", "getFeatures", "()Ljava/util/Set;", "PolarBleSdkFeature", "PolarDeviceDataType", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PolarBleApi implements PolarOnlineStreamingApi {
    private final Set<PolarBleSdkFeature> features;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "", "(Ljava/lang/String;I)V", "FEATURE_HR", "FEATURE_DEVICE_INFO", "FEATURE_BATTERY_INFO", "FEATURE_POLAR_ONLINE_STREAMING", "FEATURE_POLAR_OFFLINE_RECORDING", "FEATURE_POLAR_H10_EXERCISE_RECORDING", "FEATURE_POLAR_DEVICE_TIME_SETUP", "FEATURE_POLAR_SDK_MODE", "FEATURE_POLAR_FILE_TRANSFER", "FEATURE_HTS", "FEATURE_POLAR_LED_ANIMATION", "FEATURE_POLAR_FIRMWARE_UPDATE", "FEATURE_POLAR_ACTIVITY_DATA", "FEATURE_POLAR_SLEEP_DATA", "FEATURE_POLAR_TEMPERATURE_DATA", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PolarBleSdkFeature {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PolarBleSdkFeature[] $VALUES;
        public static final PolarBleSdkFeature FEATURE_HR = new PolarBleSdkFeature("FEATURE_HR", 0);
        public static final PolarBleSdkFeature FEATURE_DEVICE_INFO = new PolarBleSdkFeature("FEATURE_DEVICE_INFO", 1);
        public static final PolarBleSdkFeature FEATURE_BATTERY_INFO = new PolarBleSdkFeature("FEATURE_BATTERY_INFO", 2);
        public static final PolarBleSdkFeature FEATURE_POLAR_ONLINE_STREAMING = new PolarBleSdkFeature("FEATURE_POLAR_ONLINE_STREAMING", 3);
        public static final PolarBleSdkFeature FEATURE_POLAR_OFFLINE_RECORDING = new PolarBleSdkFeature("FEATURE_POLAR_OFFLINE_RECORDING", 4);
        public static final PolarBleSdkFeature FEATURE_POLAR_H10_EXERCISE_RECORDING = new PolarBleSdkFeature("FEATURE_POLAR_H10_EXERCISE_RECORDING", 5);
        public static final PolarBleSdkFeature FEATURE_POLAR_DEVICE_TIME_SETUP = new PolarBleSdkFeature("FEATURE_POLAR_DEVICE_TIME_SETUP", 6);
        public static final PolarBleSdkFeature FEATURE_POLAR_SDK_MODE = new PolarBleSdkFeature("FEATURE_POLAR_SDK_MODE", 7);
        public static final PolarBleSdkFeature FEATURE_POLAR_FILE_TRANSFER = new PolarBleSdkFeature("FEATURE_POLAR_FILE_TRANSFER", 8);
        public static final PolarBleSdkFeature FEATURE_HTS = new PolarBleSdkFeature("FEATURE_HTS", 9);
        public static final PolarBleSdkFeature FEATURE_POLAR_LED_ANIMATION = new PolarBleSdkFeature("FEATURE_POLAR_LED_ANIMATION", 10);
        public static final PolarBleSdkFeature FEATURE_POLAR_FIRMWARE_UPDATE = new PolarBleSdkFeature("FEATURE_POLAR_FIRMWARE_UPDATE", 11);
        public static final PolarBleSdkFeature FEATURE_POLAR_ACTIVITY_DATA = new PolarBleSdkFeature("FEATURE_POLAR_ACTIVITY_DATA", 12);
        public static final PolarBleSdkFeature FEATURE_POLAR_SLEEP_DATA = new PolarBleSdkFeature("FEATURE_POLAR_SLEEP_DATA", 13);
        public static final PolarBleSdkFeature FEATURE_POLAR_TEMPERATURE_DATA = new PolarBleSdkFeature("FEATURE_POLAR_TEMPERATURE_DATA", 14);

        private static final /* synthetic */ PolarBleSdkFeature[] $values() {
            return new PolarBleSdkFeature[]{FEATURE_HR, FEATURE_DEVICE_INFO, FEATURE_BATTERY_INFO, FEATURE_POLAR_ONLINE_STREAMING, FEATURE_POLAR_OFFLINE_RECORDING, FEATURE_POLAR_H10_EXERCISE_RECORDING, FEATURE_POLAR_DEVICE_TIME_SETUP, FEATURE_POLAR_SDK_MODE, FEATURE_POLAR_FILE_TRANSFER, FEATURE_HTS, FEATURE_POLAR_LED_ANIMATION, FEATURE_POLAR_FIRMWARE_UPDATE, FEATURE_POLAR_ACTIVITY_DATA, FEATURE_POLAR_SLEEP_DATA, FEATURE_POLAR_TEMPERATURE_DATA};
        }

        static {
            PolarBleSdkFeature[] polarBleSdkFeatureArr$values = $values();
            $VALUES = polarBleSdkFeatureArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(polarBleSdkFeatureArr$values);
        }

        private PolarBleSdkFeature(String str, int i) {
        }

        public static PolarBleSdkFeature valueOf(String str) {
            return (PolarBleSdkFeature) Enum.valueOf(PolarBleSdkFeature.class, str);
        }

        public static PolarBleSdkFeature[] values() {
            return (PolarBleSdkFeature[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/polar/sdk/api/PolarBleApi$PolarDeviceDataType;", "", "(Ljava/lang/String;I)V", "HR", "ECG", "ACC", "PPG", "PPI", "GYRO", "MAGNETOMETER", "PRESSURE", "LOCATION", "TEMPERATURE", "SKIN_TEMPERATURE", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PolarDeviceDataType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PolarDeviceDataType[] $VALUES;
        public static final PolarDeviceDataType HR = new PolarDeviceDataType("HR", 0);
        public static final PolarDeviceDataType ECG = new PolarDeviceDataType("ECG", 1);
        public static final PolarDeviceDataType ACC = new PolarDeviceDataType("ACC", 2);
        public static final PolarDeviceDataType PPG = new PolarDeviceDataType("PPG", 3);
        public static final PolarDeviceDataType PPI = new PolarDeviceDataType("PPI", 4);
        public static final PolarDeviceDataType GYRO = new PolarDeviceDataType("GYRO", 5);
        public static final PolarDeviceDataType MAGNETOMETER = new PolarDeviceDataType("MAGNETOMETER", 6);
        public static final PolarDeviceDataType PRESSURE = new PolarDeviceDataType("PRESSURE", 7);
        public static final PolarDeviceDataType LOCATION = new PolarDeviceDataType("LOCATION", 8);
        public static final PolarDeviceDataType TEMPERATURE = new PolarDeviceDataType("TEMPERATURE", 9);
        public static final PolarDeviceDataType SKIN_TEMPERATURE = new PolarDeviceDataType("SKIN_TEMPERATURE", 10);

        private static final /* synthetic */ PolarDeviceDataType[] $values() {
            return new PolarDeviceDataType[]{HR, ECG, ACC, PPG, PPI, GYRO, MAGNETOMETER, PRESSURE, LOCATION, TEMPERATURE, SKIN_TEMPERATURE};
        }

        static {
            PolarDeviceDataType[] polarDeviceDataTypeArr$values = $values();
            $VALUES = polarDeviceDataTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(polarDeviceDataTypeArr$values);
        }

        private PolarDeviceDataType(String str, int i) {
        }

        public static PolarDeviceDataType valueOf(String str) {
            return (PolarDeviceDataType) Enum.valueOf(PolarDeviceDataType.class, str);
        }

        public static PolarDeviceDataType[] values() {
            return (PolarDeviceDataType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PolarBleApi(Set<? extends PolarBleSdkFeature> set) {
        set.getClass();
        this.features = set;
    }

    public abstract void connectToDevice(String identifier);

    public final Set<PolarBleSdkFeature> getFeatures() {
        return this.features;
    }

    public abstract Flowable<PolarDeviceInfo> searchForDevice();

    public abstract void setApiCallback(PolarBleApiCallbackProvider callback);

    public abstract Completable setLedConfig(String identifier, LedConfig ledConfig);

    public abstract void shutDown();
}

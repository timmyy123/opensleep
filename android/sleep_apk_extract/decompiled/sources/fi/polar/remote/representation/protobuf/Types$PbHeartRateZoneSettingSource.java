package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbHeartRateZoneSettingSource implements Internal.EnumLite {
    HEART_RATE_ZONE_SETTING_SOURCE_DEFAULT(0),
    HEART_RATE_ZONE_SETTING_SOURCE_THRESHOLD(1),
    HEART_RATE_ZONE_SETTING_SOURCE_FREE(2);

    private static final Internal.EnumLiteMap<Types$PbHeartRateZoneSettingSource> internalValueMap = new Internal.EnumLiteMap<Types$PbHeartRateZoneSettingSource>() { // from class: fi.polar.remote.representation.protobuf.Types$PbHeartRateZoneSettingSource.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbHeartRateZoneSettingSource findValueByNumber(int i) {
            return Types$PbHeartRateZoneSettingSource.forNumber(i);
        }
    };
    private final int value;

    public static final class PbHeartRateZoneSettingSourceVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbHeartRateZoneSettingSourceVerifier();

        private PbHeartRateZoneSettingSourceVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbHeartRateZoneSettingSource.forNumber(i) != null;
        }
    }

    Types$PbHeartRateZoneSettingSource(int i) {
        this.value = i;
    }

    public static Types$PbHeartRateZoneSettingSource forNumber(int i) {
        if (i == 0) {
            return HEART_RATE_ZONE_SETTING_SOURCE_DEFAULT;
        }
        if (i == 1) {
            return HEART_RATE_ZONE_SETTING_SOURCE_THRESHOLD;
        }
        if (i != 2) {
            return null;
        }
        return HEART_RATE_ZONE_SETTING_SOURCE_FREE;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbHeartRateZoneSettingSourceVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}

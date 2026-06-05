package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSpeedZoneSettingSource implements Internal.EnumLite {
    SPEED_ZONE_SETTING_SOURCE_DEFAULT(0),
    SPEED_ZONE_SETTING_SOURCE_FREE(1);

    private static final Internal.EnumLiteMap<Types$PbSpeedZoneSettingSource> internalValueMap = new Internal.EnumLiteMap<Types$PbSpeedZoneSettingSource>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSpeedZoneSettingSource.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSpeedZoneSettingSource findValueByNumber(int i) {
            return Types$PbSpeedZoneSettingSource.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSpeedZoneSettingSourceVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSpeedZoneSettingSourceVerifier();

        private PbSpeedZoneSettingSourceVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSpeedZoneSettingSource.forNumber(i) != null;
        }
    }

    Types$PbSpeedZoneSettingSource(int i) {
        this.value = i;
    }

    public static Types$PbSpeedZoneSettingSource forNumber(int i) {
        if (i == 0) {
            return SPEED_ZONE_SETTING_SOURCE_DEFAULT;
        }
        if (i != 1) {
            return null;
        }
        return SPEED_ZONE_SETTING_SOURCE_FREE;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSpeedZoneSettingSourceVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}

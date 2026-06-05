package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbPowerZoneSettingSource implements Internal.EnumLite {
    POWER_ZONE_SETTING_SOURCE_DEFAULT(0),
    POWER_ZONE_SETTING_SOURCE_FREE(1);

    private static final Internal.EnumLiteMap<Types$PbPowerZoneSettingSource> internalValueMap = new Internal.EnumLiteMap<Types$PbPowerZoneSettingSource>() { // from class: fi.polar.remote.representation.protobuf.Types$PbPowerZoneSettingSource.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbPowerZoneSettingSource findValueByNumber(int i) {
            return Types$PbPowerZoneSettingSource.forNumber(i);
        }
    };
    private final int value;

    public static final class PbPowerZoneSettingSourceVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbPowerZoneSettingSourceVerifier();

        private PbPowerZoneSettingSourceVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbPowerZoneSettingSource.forNumber(i) != null;
        }
    }

    Types$PbPowerZoneSettingSource(int i) {
        this.value = i;
    }

    public static Types$PbPowerZoneSettingSource forNumber(int i) {
        if (i == 0) {
            return POWER_ZONE_SETTING_SOURCE_DEFAULT;
        }
        if (i != 1) {
            return null;
        }
        return POWER_ZONE_SETTING_SOURCE_FREE;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbPowerZoneSettingSourceVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}

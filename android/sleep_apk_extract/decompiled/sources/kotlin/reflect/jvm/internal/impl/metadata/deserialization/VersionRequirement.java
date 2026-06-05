package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;

/* JADX INFO: loaded from: classes5.dex */
public final class VersionRequirement {
    public static final Companion Companion = new Companion(null);
    private final Integer errorCode;
    private final ProtoBuf$VersionRequirement.VersionKind kind;
    private final DeprecationLevel level;
    private final String message;
    private final Version version;

    public static final class Companion {

        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf$VersionRequirement.Level.values().length];
                try {
                    iArr[ProtoBuf$VersionRequirement.Level.WARNING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ProtoBuf$VersionRequirement.Level.ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ProtoBuf$VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VersionRequirement create(int i, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            DeprecationLevel deprecationLevel;
            nameResolver.getClass();
            versionRequirementTable.getClass();
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement = versionRequirementTable.get(i);
            if (protoBuf$VersionRequirement == null) {
                return null;
            }
            Version versionDecode = Version.Companion.decode(protoBuf$VersionRequirement.hasVersion() ? Integer.valueOf(protoBuf$VersionRequirement.getVersion()) : null, protoBuf$VersionRequirement.hasVersionFull() ? Integer.valueOf(protoBuf$VersionRequirement.getVersionFull()) : null);
            ProtoBuf$VersionRequirement.Level level = protoBuf$VersionRequirement.getLevel();
            level.getClass();
            int i2 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i2 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else {
                if (i2 != 3) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                deprecationLevel = DeprecationLevel.HIDDEN;
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer numValueOf = protoBuf$VersionRequirement.hasErrorCode() ? Integer.valueOf(protoBuf$VersionRequirement.getErrorCode()) : null;
            String string = protoBuf$VersionRequirement.hasMessage() ? nameResolver.getString(protoBuf$VersionRequirement.getMessage()) : null;
            ProtoBuf$VersionRequirement.VersionKind versionKind = protoBuf$VersionRequirement.getVersionKind();
            versionKind.getClass();
            return new VersionRequirement(versionDecode, versionKind, deprecationLevel2, numValueOf, string);
        }

        private Companion() {
        }
    }

    public static final class Version {
        public static final Companion Companion = new Companion(null);
        public static final Version INFINITY = new Version(256, 256, 256);
        private final int major;
        private final int minor;
        private final int patch;

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Version decode(Integer num, Integer num2) {
                return num2 != null ? new Version(num2.intValue() & PHIpAddressSearchManager.END_IP_SCAN, (num2.intValue() >> 8) & PHIpAddressSearchManager.END_IP_SCAN, (num2.intValue() >> 16) & PHIpAddressSearchManager.END_IP_SCAN) : num != null ? new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127) : Version.INFINITY;
            }

            private Companion() {
            }
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        public final String asString() {
            StringBuilder sb;
            int i;
            int i2 = this.patch;
            int i3 = this.major;
            if (i2 == 0) {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append('.');
                i = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append('.');
                sb.append(this.minor);
                sb.append('.');
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.patch;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return false;
            }
            Version version = (Version) obj;
            return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
        }

        public int hashCode() {
            return Integer.hashCode(this.patch) + FileInsert$$ExternalSyntheticOutline0.m(this.minor, Integer.hashCode(this.major) * 31, 31);
        }

        public String toString() {
            return asString();
        }
    }

    public VersionRequirement(Version version, ProtoBuf$VersionRequirement.VersionKind versionKind, DeprecationLevel deprecationLevel, Integer num, String str) {
        version.getClass();
        versionKind.getClass();
        deprecationLevel.getClass();
        this.version = version;
        this.kind = versionKind;
        this.level = deprecationLevel;
        this.errorCode = num;
        this.message = str;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final ProtoBuf$VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    public final DeprecationLevel getLevel() {
        return this.level;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Version getVersion() {
        return this.version;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("since ");
        sb.append(this.version);
        sb.append(' ');
        sb.append(this.level);
        String str2 = "";
        if (this.errorCode != null) {
            str = " error " + this.errorCode.intValue();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.message != null) {
            str2 = ": " + this.message;
        }
        sb.append(str2);
        return sb.toString();
    }
}

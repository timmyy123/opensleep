package org.eclipse.californium.scandium.dtls;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes5.dex */
public class ProtocolVersion implements Comparable<ProtocolVersion> {
    private final int major;
    private final int minor;
    public static final ProtocolVersion VERSION_DTLS_1_2 = new ProtocolVersion(254, 253);
    public static final ProtocolVersion VERSION_DTLS_1_0 = new ProtocolVersion(254, PHIpAddressSearchManager.END_IP_SCAN);

    @Deprecated
    public ProtocolVersion(int i, int i2) {
        this.minor = i2;
        this.major = i;
    }

    public static ProtocolVersion valueOf(int i, int i2) {
        return (i == 254 && i2 == 253) ? VERSION_DTLS_1_2 : (i == 254 && i2 == 255) ? VERSION_DTLS_1_0 : new ProtocolVersion(i, i2);
    }

    @Override // java.lang.Comparable
    public int compareTo(ProtocolVersion protocolVersion) {
        if (this == protocolVersion) {
            return 0;
        }
        if (this.major != protocolVersion.getMajor()) {
            return this.major < protocolVersion.getMajor() ? 1 : -1;
        }
        if (this.minor < protocolVersion.getMinor()) {
            return 1;
        }
        return this.minor > protocolVersion.getMinor() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProtocolVersion)) {
            return false;
        }
        ProtocolVersion protocolVersion = (ProtocolVersion) obj;
        return this.major == protocolVersion.major && this.minor == protocolVersion.minor;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        return ((this.major + 31) * 31) + this.minor;
    }

    public String toString() {
        return Integer.toString(255 - this.major) + "." + Integer.toString(255 - this.minor);
    }
}

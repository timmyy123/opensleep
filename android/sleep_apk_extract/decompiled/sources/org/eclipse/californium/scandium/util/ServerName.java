package org.eclipse.californium.scandium.util;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.StandardCharsets;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class ServerName {
    public static final Charset CHARSET = StandardCharsets.US_ASCII;
    private final int hashCode;
    private final byte[] name;
    private final NameType type;

    public enum NameType {
        HOST_NAME((byte) 0),
        UNDEFINED((byte) -1);

        private final byte code;

        NameType(byte b) {
            this.code = b;
        }

        public static NameType fromCode(byte b) {
            for (NameType nameType : values()) {
                if (nameType.code == b) {
                    return nameType;
                }
            }
            return UNDEFINED;
        }

        public byte getCode() {
            return this.code;
        }
    }

    private ServerName(NameType nameType, byte[] bArr) {
        if (nameType == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Name type must be provided!");
            throw null;
        }
        this.type = nameType;
        this.name = bArr;
        this.hashCode = nameType.hashCode() + (Arrays.hashCode(bArr) * 31);
    }

    public static ServerName from(NameType nameType, byte[] bArr) {
        if (nameType == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("type must not be null");
            return null;
        }
        if (bArr != null) {
            return nameType == NameType.HOST_NAME ? fromHostName(new String(bArr, CHARSET)) : new ServerName(nameType, bArr);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("name must not be null");
        return null;
    }

    public static ServerName fromHostName(String str) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("host name must not be null");
            return null;
        }
        if (StringUtil.isValidHostName(str)) {
            return new ServerName(NameType.HOST_NAME, str.toLowerCase().getBytes(CHARSET));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("not a valid host name");
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServerName serverName = (ServerName) obj;
        return Arrays.equals(this.name, serverName.name) && this.type == serverName.type;
    }

    public byte[] getName() {
        return this.name;
    }

    public String getNameAsString() {
        return new String(this.name, CHARSET);
    }

    public NameType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.hashCode;
    }
}

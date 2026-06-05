package org.eclipse.californium.elements.util;

import com.facebook.internal.NativeProtocol;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Asn1DerDecoder {
    private static final String[][] ALGORITHM_ALIASES;
    private static final String[] ED25519_ALIASES;
    private static final boolean ED25519_SUPPORT;
    private static final String[] ED448_ALIASES;
    private static final boolean ED448_SUPPORT;
    private static final Provider EDDSA_PROVIDER;
    private static final Logger LOGGER;
    private static final byte[] OID_RSA_PUBLIC_KEY = {42, -122, 72, -122, -9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 1, 1, 1};
    private static final byte[] OID_DH_PUBLIC_KEY = {42, -122, 72, -122, -9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 1, 3, 1};
    private static final byte[] OID_DSA_PUBLIC_KEY = {42, -122, 72, -50, 56, 4, 1};
    private static final byte[] OID_EC_PUBLIC_KEY = {42, -122, 72, -50, 61, 2, 1};
    private static final byte[] OID_ED25519_PUBLIC_KEY = {43, 101, 112};
    private static final byte[] OID_ED448_PUBLIC_KEY = {43, 101, 113};
    private static final EntityDefinition SEQUENCE = new EntityDefinition(48, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, "SEQUENCE");
    private static final OidEntityDefinition OID = new OidEntityDefinition();
    private static final IntegerEntityDefinition INTEGER = new IntegerEntityDefinition();
    private static final EntityDefinition BIT_STRING = new EntityDefinition(3, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, "BIT STRING");
    private static final EntityDefinition OCTET_STRING = new EntityDefinition(4, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, "OCTET STRING");
    private static final EntityDefinition CONTEXT_SPECIFIC_0 = new EntityDefinition(160, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, "CONTEXT SPECIFIC 0");
    private static final EntityDefinition CONTEXT_SPECIFIC_1 = new EntityDefinition(161, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, "CONTEXT SPECIFIC 1");

    public static class EntityDefinition {
        private final String description;
        private final int expectedTag;
        private final int maxLength;

        public EntityDefinition(int i, int i2, String str) {
            this.expectedTag = i;
            this.maxLength = i2;
            this.description = str;
        }

        public DatagramReader createRangeReader(DatagramReader datagramReader, boolean z) {
            return datagramReader.createRangeReader(readLength(datagramReader, z));
        }

        public byte[] read(DatagramReader datagramReader, boolean z) {
            return datagramReader.readBytes(readLength(datagramReader, z));
        }

        public int readLength(DatagramReader datagramReader, boolean z) {
            int iBitsLeft = datagramReader.bitsLeft() / 8;
            if (iBitsLeft < 2) {
                Home$$ExternalSyntheticBUOutline0.m("Not enough bytes for %s! Required %d, available %d.", new Object[]{this.description, 2, Integer.valueOf(iBitsLeft)});
                return 0;
            }
            if (z) {
                datagramReader.mark();
            }
            int i = datagramReader.read(8);
            if (i != this.expectedTag) {
                Home$$ExternalSyntheticBUOutline0.m("No %s, found %02x instead of %02x!", new Object[]{this.description, Integer.valueOf(i), Integer.valueOf(this.expectedTag)});
                return 0;
            }
            int i2 = datagramReader.read(8);
            int length = i2 + 2;
            if (i2 > 127) {
                int i3 = i2 & 127;
                if (i3 > 4) {
                    Home$$ExternalSyntheticBUOutline0.m("%s length-size %d too long!", new Object[]{this.description, Integer.valueOf(i3)});
                    return 0;
                }
                int iBitsLeft2 = datagramReader.bitsLeft() / 8;
                if (i3 > iBitsLeft2) {
                    Home$$ExternalSyntheticBUOutline0.m("%s length %d exceeds available bytes %d!", new Object[]{this.description, Integer.valueOf(i3), Integer.valueOf(iBitsLeft2)});
                    return 0;
                }
                byte[] bytes = datagramReader.readBytes(i3);
                int i4 = 0;
                for (byte b : bytes) {
                    i4 = (i4 << 8) + (b & 255);
                }
                int i5 = i4;
                length = bytes.length + i4 + 2;
                i2 = i5;
            }
            if (i2 > this.maxLength) {
                Home$$ExternalSyntheticBUOutline0.m("%s lenght %d too large! (supported maxium %d)", new Object[]{this.description, Integer.valueOf(i2), Integer.valueOf(this.maxLength)});
                return 0;
            }
            int iBitsLeft3 = datagramReader.bitsLeft() / 8;
            if (i2 > iBitsLeft3) {
                Home$$ExternalSyntheticBUOutline0.m("%s lengh %d exceeds available bytes %d!", new Object[]{this.description, Integer.valueOf(i2), Integer.valueOf(iBitsLeft3)});
                return 0;
            }
            if (!z) {
                return i2;
            }
            datagramReader.reset();
            return length;
        }

        public byte[] readValue(DatagramReader datagramReader) {
            return read(datagramReader, false);
        }
    }

    public static class IntegerEntityDefinition extends EntityDefinition {
        public IntegerEntityDefinition() {
            super(2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, "INTEGER");
        }
    }

    public static class OidEntityDefinition extends EntityDefinition {
        public OidEntityDefinition() {
            super(6, 32, "OID");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f3  */
    static {
        boolean z;
        boolean z2;
        Provider provider;
        String[] strArr = {"ED25519", "1.3.101.112", "OID.1.3.101.112", "EdDSA"};
        ED25519_ALIASES = strArr;
        String[] strArr2 = {"ED448", "1.3.101.113", "OID.1.3.101.113", "EdDSA"};
        ED448_ALIASES = strArr2;
        ALGORITHM_ALIASES = new String[][]{new String[]{"DH", "DiffieHellman"}, strArr, strArr2};
        Logger logger = LoggerFactory.getLogger((Class<?>) Asn1DerDecoder.class);
        LOGGER = logger;
        boolean z3 = true;
        boolean z4 = false;
        Object obj = null;
        try {
            provider = KeyFactory.getInstance("EdDSA").getProvider();
            try {
                logger.trace("EdDSA from jvm {}", provider.getName());
                z4 = true;
            } catch (NoSuchAlgorithmException unused) {
                z = true;
                z2 = true;
                try {
                    Provider provider2 = (Provider) Class.forName("net.i2p.crypto.eddsa.EdDSASecurityProvider").newInstance();
                    try {
                        Security.addProvider(provider2);
                        try {
                            LOGGER.trace("EdDSA from {}", "net.i2p.crypto.eddsa");
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                            obj = e;
                        }
                        provider = provider2;
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
                        obj = e2;
                        z4 = z2;
                        provider = provider2;
                        z3 = z;
                        if (provider == null) {
                        }
                        EDDSA_PROVIDER = provider;
                        ED25519_SUPPORT = z3;
                        ED448_SUPPORT = z4;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e3) {
                    obj = e3;
                    z4 = z2;
                }
                if (provider == null) {
                    LOGGER.trace("{} is not available!", "net.i2p.crypto.eddsa", obj);
                }
            }
        } catch (NoSuchAlgorithmException unused2) {
            z = false;
            z2 = false;
            provider = null;
        }
        EDDSA_PROVIDER = provider;
        ED25519_SUPPORT = z3;
        ED448_SUPPORT = z4;
    }

    private static boolean contains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static Provider getEdDsaProvider() {
        return EDDSA_PROVIDER;
    }

    public static String getEdDsaStandardAlgorithmName(String str, String str2) {
        return str.equalsIgnoreCase("EdDSA") ? "EdDSA" : contains(ED25519_ALIASES, str) ? "OID.1.3.101.112" : contains(ED448_ALIASES, str) ? "OID.1.3.101.113" : str2;
    }

    public static boolean isSupported(String str) {
        if ("EC".equalsIgnoreCase(str)) {
            return true;
        }
        String edDsaStandardAlgorithmName = getEdDsaStandardAlgorithmName(str, null);
        if ("OID.1.3.101.112".equals(edDsaStandardAlgorithmName)) {
            return ED25519_SUPPORT;
        }
        if ("OID.1.3.101.113".equals(edDsaStandardAlgorithmName)) {
            return ED448_SUPPORT;
        }
        if ("EdDSA".equalsIgnoreCase(str)) {
            return ED25519_SUPPORT || ED448_SUPPORT;
        }
        return false;
    }

    public static byte[] readOidValue(DatagramReader datagramReader) {
        return OID.readValue(datagramReader);
    }

    public static String readSubjectPublicKeyAlgorithm(byte[] bArr) {
        DatagramReader datagramReader = new DatagramReader(bArr, false);
        EntityDefinition entityDefinition = SEQUENCE;
        byte[] oidValue = readOidValue(entityDefinition.createRangeReader(entityDefinition.createRangeReader(datagramReader, false), false));
        if (Arrays.equals(oidValue, OID_EC_PUBLIC_KEY)) {
            return "EC";
        }
        if (Arrays.equals(oidValue, OID_RSA_PUBLIC_KEY)) {
            return "RSA";
        }
        if (Arrays.equals(oidValue, OID_DSA_PUBLIC_KEY)) {
            return "DSA";
        }
        if (Arrays.equals(oidValue, OID_DH_PUBLIC_KEY)) {
            return "DH";
        }
        if (Arrays.equals(oidValue, OID_ED25519_PUBLIC_KEY)) {
            return "ED25519";
        }
        if (Arrays.equals(oidValue, OID_ED448_PUBLIC_KEY)) {
            return "ED448";
        }
        return null;
    }
}

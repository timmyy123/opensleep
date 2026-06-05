package org.eclipse.californium.scandium.dtls.cipher;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class XECDHECryptography implements Destroyable {
    private static final Map<EllipticCurve, SupportedGroup> EC_CURVE_MAP_BY_CURVE;
    private static final Map<Integer, SupportedGroup> EC_CURVE_MAP_BY_ID;
    private static final Method NamedParameterSpecGetName;
    private static final Class<?> XECPublicKeyClass;
    private static final Method XECPublicKeyGetParams;
    private static final Method XECPublicKeyGetU;
    private static final Constructor<?> XECPublicKeySpecInit;
    private byte[] encodedPoint;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private final SupportedGroup supportedGroup;
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) XECDHECryptography.class);
    private static final ThreadLocalKeyPairGenerator EC_KEYPAIR_GENERATOR = new ThreadLocalKeyPairGenerator("EC");
    private static final ThreadLocalKeyPairGenerator XDH_KEYPAIR_GENERATOR = new ThreadLocalKeyPairGenerator("XDH");
    private static final ThreadLocalKeyFactory EC_KEY_FACTORY = new ThreadLocalKeyFactory("EC");
    private static final ThreadLocalKeyFactory XDH_KEY_FACTORY = new ThreadLocalKeyFactory("XDH");
    private static final ThreadLocalKeyAgreement ECDH_KEY_AGREEMENT = new ThreadLocalKeyAgreement("ECDH");
    private static final ThreadLocalKeyAgreement XDH_KEY_AGREEMENT = new ThreadLocalKeyAgreement("XDH");

    public static class Initialize {
        private static final SupportedGroup[] PREFERRED = {SupportedGroup.secp256r1, SupportedGroup.X25519, SupportedGroup.X448, SupportedGroup.secp384r1};
        private static final List<SupportedGroup> PREFERRED_GROUPS;
        private static final List<SupportedGroup> USABLE_GROUPS;

        static {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (SupportedGroup supportedGroup : SupportedGroup.values()) {
                if (supportedGroup.isUsable()) {
                    arrayList.add(supportedGroup);
                }
            }
            for (SupportedGroup supportedGroup2 : PREFERRED) {
                if (supportedGroup2.isUsable()) {
                    arrayList2.add(supportedGroup2);
                }
            }
            if (arrayList2.isEmpty() && !arrayList.isEmpty()) {
                arrayList2.add(arrayList.get(0));
            }
            USABLE_GROUPS = Collections.unmodifiableList(arrayList);
            PREFERRED_GROUPS = Collections.unmodifiableList(arrayList2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Class<?> cls;
        Constructor<?> constructor;
        Object method;
        Object method2;
        Method method3;
        Method method4;
        Method method5 = null;
        try {
            cls = Class.forName("java.security.spec.XECPublicKeySpec");
        } catch (Throwable unused) {
            cls = null;
            constructor = null;
        }
        try {
            constructor = cls.getConstructor(AlgorithmParameterSpec.class, BigInteger.class);
            try {
                cls = Class.forName("java.security.spec.NamedParameterSpec");
                method = cls.getMethod("getName", null);
                try {
                    cls = Class.forName("java.security.interfaces.XECPublicKey");
                    method2 = cls.getMethod("getU", null);
                    try {
                        method5 = cls.getMethod("getParams", null);
                        method4 = method;
                        method3 = method2;
                    } catch (Throwable unused2) {
                        LOGGER.info("X25519/X448 not supported!");
                        method4 = method;
                        method3 = method2;
                    }
                } catch (Throwable unused3) {
                    method2 = null;
                }
            } catch (Throwable unused4) {
                method = null;
                method2 = method;
                LOGGER.info("X25519/X448 not supported!");
                method4 = method;
                method3 = method2;
                XECPublicKeyClass = cls;
                XECPublicKeyGetU = method3;
                XECPublicKeyGetParams = method5;
                NamedParameterSpecGetName = method4;
                XECPublicKeySpecInit = constructor;
                EC_CURVE_MAP_BY_ID = new HashMap();
                EC_CURVE_MAP_BY_CURVE = new HashMap();
            }
        } catch (Throwable unused5) {
            constructor = null;
            method = constructor;
            method2 = method;
            LOGGER.info("X25519/X448 not supported!");
            method4 = method;
            method3 = method2;
            XECPublicKeyClass = cls;
            XECPublicKeyGetU = method3;
            XECPublicKeyGetParams = method5;
            NamedParameterSpecGetName = method4;
            XECPublicKeySpecInit = constructor;
            EC_CURVE_MAP_BY_ID = new HashMap();
            EC_CURVE_MAP_BY_CURVE = new HashMap();
        }
        XECPublicKeyClass = cls;
        XECPublicKeyGetU = method3;
        XECPublicKeyGetParams = method5;
        NamedParameterSpecGetName = method4;
        XECPublicKeySpecInit = constructor;
        EC_CURVE_MAP_BY_ID = new HashMap();
        EC_CURVE_MAP_BY_CURVE = new HashMap();
    }

    public XECDHECryptography(SupportedGroup supportedGroup) throws GeneralSecurityException {
        KeyPair keyPairGenerateKeyPair;
        if (supportedGroup.getAlgorithmName().equals("EC")) {
            KeyPairGenerator keyPairGeneratorCurrentWithCause = EC_KEYPAIR_GENERATOR.currentWithCause();
            keyPairGeneratorCurrentWithCause.initialize(new ECGenParameterSpec(supportedGroup.name()), RandomManager.currentSecureRandom());
            keyPairGenerateKeyPair = keyPairGeneratorCurrentWithCause.generateKeyPair();
        } else {
            if (!supportedGroup.getAlgorithmName().equals("XDH")) {
                throw new GeneralSecurityException(supportedGroup.name() + " not supported by KeyPairGenerator!");
            }
            KeyPairGenerator keyPairGeneratorCurrentWithCause2 = XDH_KEYPAIR_GENERATOR.currentWithCause();
            keyPairGeneratorCurrentWithCause2.initialize(new ECGenParameterSpec(supportedGroup.name()), RandomManager.currentSecureRandom());
            keyPairGenerateKeyPair = keyPairGeneratorCurrentWithCause2.generateKeyPair();
        }
        this.privateKey = keyPairGenerateKeyPair.getPrivate();
        this.publicKey = keyPairGenerateKeyPair.getPublic();
        this.supportedGroup = supportedGroup;
        this.encodedPoint = encodedPoint(keyPairGenerateKeyPair.getPublic());
    }

    private void check(String str, PublicKey publicKey, byte[] bArr) throws GeneralSecurityException {
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            byte[] encoded = publicKey.getEncoded();
            String strByteArray2Hex = StringUtil.byteArray2Hex(encoded);
            String strByteArray2Hex2 = StringUtil.byteArray2Hex(bArr);
            if (strByteArray2Hex2.length() < strByteArray2Hex.length()) {
                strByteArray2Hex2 = String.format("%" + strByteArray2Hex.length() + "s", strByteArray2Hex2);
            }
            logger.debug("{}ASN1 encoded '{}'", str, strByteArray2Hex);
            logger.debug("{}DHE  encoded '{}'", str, strByteArray2Hex2);
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[(bArr.length - i) - 1] != encoded[(encoded.length - i) - 1]) {
                    throw new GeneralSecurityException("DHE: failed to encoded point! " + this.supportedGroup.name() + ", position: " + i);
                }
            }
        }
    }

    private static byte[] encodePoint(ECPoint eCPoint, int i) {
        byte[] byteArray = eCPoint.getAffineX().toByteArray();
        byte[] byteArray2 = eCPoint.getAffineY().toByteArray();
        int iNoneZeroOffset = noneZeroOffset(byteArray);
        int length = byteArray.length - iNoneZeroOffset;
        int iNoneZeroOffset2 = noneZeroOffset(byteArray2);
        int length2 = byteArray2.length - iNoneZeroOffset2;
        if (length > i || length2 > i) {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(length, length2, "ec point exceeds size! ", ",", " > ");
            sbM.append(i);
            throw new IllegalArgumentException(sbM.toString());
        }
        int i2 = (i * 2) + 1;
        byte[] bArr = new byte[i2];
        bArr[0] = 4;
        System.arraycopy(byteArray, iNoneZeroOffset, bArr, (i + 1) - length, length);
        System.arraycopy(byteArray2, iNoneZeroOffset2, bArr, i2 - length2, length2);
        return bArr;
    }

    private byte[] encodedPoint(PublicKey publicKey) throws GeneralSecurityException {
        int keySizeInBytes = this.supportedGroup.getKeySizeInBytes();
        try {
            byte[] bArrEncodePoint = this.supportedGroup.getAlgorithmName().equals("EC") ? encodePoint(((ECPublicKey) publicKey).getW(), keySizeInBytes) : this.supportedGroup.getAlgorithmName().equals("XDH") ? revert(getXECPublicKeyU(publicKey).toByteArray(), keySizeInBytes) : null;
            if (bArrEncodePoint != null) {
                check("OUT: ", publicKey, bArrEncodePoint);
                return bArrEncodePoint;
            }
            throw new GeneralSecurityException("DHE: failed to encoded point! " + this.supportedGroup.name());
        } catch (RuntimeException e) {
            throw new GeneralSecurityException("DHE: failed to encoded point! " + this.supportedGroup.name(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getXECPublicKeyName(PublicKey publicKey) throws GeneralSecurityException {
        Method method;
        Method method2 = XECPublicKeyGetParams;
        if (method2 == null || (method = NamedParameterSpecGetName) == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("X25519/X448 not supported by JRE!");
            return null;
        }
        try {
            return (String) method.invoke(method2.invoke(publicKey, null), null);
        } catch (Exception unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m("X25519/X448 not supported by JRE!");
            return null;
        }
    }

    private KeySpec getXECPublicKeySpec(String str, BigInteger bigInteger) throws GeneralSecurityException {
        Constructor<?> constructor = XECPublicKeySpecInit;
        if (constructor == null) {
            throw new GeneralSecurityException(this.supportedGroup.name() + " not supported by JRE!");
        }
        try {
            return (KeySpec) constructor.newInstance(new ECGenParameterSpec(str), bigInteger);
        } catch (Exception e) {
            throw new GeneralSecurityException(this.supportedGroup.name() + " not supported by JRE!", e);
        }
    }

    private BigInteger getXECPublicKeyU(PublicKey publicKey) throws GeneralSecurityException {
        Method method = XECPublicKeyGetU;
        if (method == null) {
            throw new GeneralSecurityException(this.supportedGroup.name() + " not supported by JRE!");
        }
        try {
            return (BigInteger) method.invoke(publicKey, null);
        } catch (Exception e) {
            throw new GeneralSecurityException(this.supportedGroup.name() + " not supported by JRE!", e);
        }
    }

    private static int noneZeroOffset(byte[] bArr) {
        int i = 0;
        while (i < bArr.length && bArr[i] == 0) {
            i++;
        }
        return i;
    }

    private static byte[] revert(byte[] bArr, int i) {
        int iNoneZeroOffset = noneZeroOffset(bArr);
        int length = bArr.length - iNoneZeroOffset;
        if (length > i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(length, i, "big integer array exceeds size! ", " > "));
            return null;
        }
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[(length - 1) - i2] = bArr[i2 + iNoneZeroOffset];
        }
        return bArr2;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        this.privateKey = null;
    }

    public SecretKey generateSecret(byte[] bArr) throws GeneralSecurityException {
        PublicKey publicKeyGeneratePublic;
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("encoded point must not be null!");
            return null;
        }
        if (this.privateKey == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("private key must not be destroyed");
            return null;
        }
        int keySizeInBytes = this.supportedGroup.getKeySizeInBytes();
        if (this.supportedGroup.getAlgorithmName().equals("EC")) {
            int length = bArr.length - 1;
            if (bArr[0] != 4 || length % 2 != 0 || length / 2 != keySizeInBytes) {
                throw new GeneralSecurityException("DHE: failed to decoded point! " + this.supportedGroup.name());
            }
            byte[] bArr2 = new byte[keySizeInBytes];
            System.arraycopy(bArr, 1, bArr2, 0, keySizeInBytes);
            BigInteger bigInteger = new BigInteger(1, bArr2);
            System.arraycopy(bArr, keySizeInBytes + 1, bArr2, 0, keySizeInBytes);
            publicKeyGeneratePublic = EC_KEY_FACTORY.currentWithCause().generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, new BigInteger(1, bArr2)), ((ECPrivateKey) this.privateKey).getParams()));
        } else {
            publicKeyGeneratePublic = XDH_KEY_FACTORY.currentWithCause().generatePublic(getXECPublicKeySpec(this.supportedGroup.name(), new BigInteger(1, revert(bArr, keySizeInBytes))));
        }
        check("IN: ", publicKeyGeneratePublic, bArr);
        KeyAgreement keyAgreementCurrentWithCause = this.supportedGroup.getAlgorithmName().equals("EC") ? ECDH_KEY_AGREEMENT.currentWithCause() : this.supportedGroup.getAlgorithmName().equals("XDH") ? XDH_KEY_AGREEMENT.currentWithCause() : null;
        if (keyAgreementCurrentWithCause == null) {
            return null;
        }
        keyAgreementCurrentWithCause.init(this.privateKey);
        keyAgreementCurrentWithCause.doPhase(publicKeyGeneratePublic, true);
        byte[] bArrGenerateSecret = keyAgreementCurrentWithCause.generateSecret();
        SecretKey secretKeyCreate = SecretUtil.create(bArrGenerateSecret, "TlsPremasterSecret");
        Bytes.clear(bArrGenerateSecret);
        return secretKeyCreate;
    }

    public byte[] getEncodedPoint() {
        return this.encodedPoint;
    }

    public SupportedGroup getSupportedGroup() {
        return this.supportedGroup;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.privateKey == null;
    }

    public enum SupportedGroup {
        sect163k1(1, false),
        sect163r1(2, false),
        sect163r2(3, false),
        sect193r1(4, false),
        sect193r2(5, false),
        sect233k1(6, false),
        sect233r1(7, false),
        sect239k1(8, false),
        sect283k1(9, false),
        sect283r1(10, false),
        sect409k1(11, false),
        sect409r1(12, false),
        sect571k1(13, false),
        sect571r1(14, false),
        secp160k1(15, false),
        secp160r1(16, false),
        secp160r2(17, false),
        secp192k1(18, false),
        secp192r1(19, false),
        secp224k1(20, false),
        secp224r1(21, false),
        secp256k1(22, false),
        secp256r1(23, true),
        secp384r1(24, true),
        secp521r1(25, false),
        brainpoolP256r1(26, false),
        brainpoolP384r1(27, false),
        brainpoolP512r1(28, false),
        ffdhe2048(256, false),
        ffdhe3072(257, false),
        ffdhe4096(258, false),
        ffdhe6144(259, false),
        ffdhe8192(260, false),
        arbitrary_explicit_prime_curves(65281, false),
        arbitrary_explicit_char2_curves(65282, false),
        X25519(29, 32, "XDH", true),
        X448(30, 56, "XDH", true);

        private final String algorithmName;
        private final int id;
        private final int keySizeInBytes;
        private final boolean recommended;
        private final boolean usable;

        SupportedGroup(int i, boolean z) {
            int fieldSize;
            EllipticCurve curve;
            this.id = i;
            this.algorithmName = "EC";
            this.recommended = z;
            try {
                KeyPairGenerator keyPairGeneratorCurrentWithCause = XECDHECryptography.EC_KEYPAIR_GENERATOR.currentWithCause();
                keyPairGeneratorCurrentWithCause.initialize(new ECGenParameterSpec(name()));
                curve = ((ECPublicKey) keyPairGeneratorCurrentWithCause.generateKeyPair().getPublic()).getParams().getCurve();
                fieldSize = (curve.getField().getFieldSize() + 7) / 8;
                try {
                    XECDHECryptography.EC_CURVE_MAP_BY_CURVE.put(curve, this);
                } catch (Throwable th) {
                    th = th;
                    XECDHECryptography.LOGGER.trace("Group [{}] is not supported by JRE! {}", name(), th.getMessage());
                    curve = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fieldSize = 0;
            }
            this.keySizeInBytes = fieldSize;
            this.usable = curve != null;
            XECDHECryptography.EC_CURVE_MAP_BY_ID.put(Integer.valueOf(i), this);
        }

        public static SupportedGroup fromId(int i) {
            return (SupportedGroup) XECDHECryptography.EC_CURVE_MAP_BY_ID.get(Integer.valueOf(i));
        }

        public static SupportedGroup fromPublicKey(PublicKey publicKey) {
            if (publicKey != null) {
                if (publicKey instanceof ECPublicKey) {
                    return (SupportedGroup) XECDHECryptography.EC_CURVE_MAP_BY_CURVE.get(((ECPublicKey) publicKey).getParams().getCurve());
                }
                if (XECDHECryptography.XECPublicKeyClass == null || !XECDHECryptography.XECPublicKeyClass.isInstance(publicKey)) {
                    String edDsaStandardAlgorithmName = Asn1DerDecoder.getEdDsaStandardAlgorithmName(publicKey.getAlgorithm(), null);
                    if ("OID.1.3.101.112".equals(edDsaStandardAlgorithmName) || "EdDSA".equalsIgnoreCase(edDsaStandardAlgorithmName)) {
                        return X25519;
                    }
                    if ("OID.1.3.101.113".equals(edDsaStandardAlgorithmName)) {
                        return X448;
                    }
                    XECDHECryptography.LOGGER.warn("No supported curve {}/{}", publicKey.getAlgorithm(), edDsaStandardAlgorithmName);
                } else {
                    try {
                        return valueOf(XECDHECryptography.getXECPublicKeyName(publicKey));
                    } catch (GeneralSecurityException unused) {
                    }
                }
            }
            return null;
        }

        public static List<SupportedGroup> getPreferredGroups() {
            return Initialize.PREFERRED_GROUPS;
        }

        public static boolean isEcPublicKey(PublicKey publicKey) {
            if (publicKey instanceof ECPublicKey) {
                return true;
            }
            return XECDHECryptography.XECPublicKeyClass != null && XECDHECryptography.XECPublicKeyClass.isInstance(publicKey);
        }

        public static boolean isSupported(List<SupportedGroup> list, List<X509Certificate> list2) {
            SupportedGroup supportedGroupFromPublicKey;
            for (X509Certificate x509Certificate : list2) {
                if (isEcPublicKey(x509Certificate.getPublicKey()) && ((supportedGroupFromPublicKey = fromPublicKey(x509Certificate.getPublicKey())) == null || !supportedGroupFromPublicKey.isUsable() || !list.contains(supportedGroupFromPublicKey))) {
                    return false;
                }
            }
            return true;
        }

        public String getAlgorithmName() {
            return this.algorithmName;
        }

        public int getId() {
            return this.id;
        }

        public int getKeySizeInBytes() {
            return this.keySizeInBytes;
        }

        public boolean isRecommended() {
            return this.recommended;
        }

        public boolean isUsable() {
            return this.usable;
        }

        SupportedGroup(int i, int i2, String str, boolean z) {
            boolean z2;
            this.id = i;
            this.algorithmName = str;
            this.keySizeInBytes = i2;
            this.recommended = z;
            try {
                KeyPairGenerator keyPairGeneratorCurrentWithCause = XECDHECryptography.XDH_KEYPAIR_GENERATOR.currentWithCause();
                keyPairGeneratorCurrentWithCause.initialize(new ECGenParameterSpec(name()));
                keyPairGeneratorCurrentWithCause.generateKeyPair();
                z2 = true;
            } catch (Throwable th) {
                XECDHECryptography.LOGGER.trace("Group [{}] is not supported by JRE! {}", name(), th.getMessage());
                z2 = false;
            }
            this.usable = z2;
            XECDHECryptography.EC_CURVE_MAP_BY_ID.put(Integer.valueOf(i), this);
        }
    }
}

package org.eclipse.californium.scandium.dtls.cipher;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TLS_ECDHE_PSK_WITH_AES_128_GCM_SHA256' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
public final class CipherSuite {
    private static final /* synthetic */ CipherSuite[] $VALUES;
    private static final Logger LOGGER;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CCM;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CCM;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CCM_8_SHA256;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CCM_SHA256;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_GCM_SHA378;
    public static final CipherSuite TLS_NULL_WITH_NULL_NULL;
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_PSK_WITH_AES_128_CCM;
    public static final CipherSuite TLS_PSK_WITH_AES_128_CCM_8;
    public static final CipherSuite TLS_PSK_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_PSK_WITH_AES_256_CCM;
    public static final CipherSuite TLS_PSK_WITH_AES_256_CCM_8;
    public static final CipherSuite TLS_PSK_WITH_AES_256_GCM_SHA378;
    private static int overallMaxCipherTextExpansion;
    private final CertificateKeyAlgorithm certificateKeyAlgorithm;
    private final CipherSpec cipher;
    private final int code;
    private final KeyExchangeAlgorithm keyExchange;
    private final MACAlgorithm macAlgorithm;
    private final int maxCipherTextExpansion;
    private final PRFAlgorithm pseudoRandomFunction;
    private boolean recommendedCipherSuite;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.cipher.CipherSuite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType;

        static {
            int[] iArr = new int[CipherType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType = iArr;
            try {
                iArr[CipherType.BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType[CipherType.AEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum CertificateKeyAlgorithm {
        NONE,
        DSA,
        RSA,
        EC
    }

    public enum CipherType {
        NULL,
        STREAM,
        BLOCK,
        AEAD
    }

    public enum KeyExchangeAlgorithm {
        NULL,
        DHE_DSS,
        DHE_RSA,
        DH_ANON,
        RSA,
        DH_DSS,
        DH_RSA,
        PSK,
        ECDHE_PSK,
        EC_DIFFIE_HELLMAN
    }

    public enum MACAlgorithm {
        NULL(null, null, 0, 0, 0),
        HMAC_MD5("HmacMD5", "MD5", 16, 0, 0),
        HMAC_SHA1("HmacSHA1", "SHA-1", 20, 8, 64),
        HMAC_SHA256("HmacSHA256", "SHA-256", 32, 8, 64),
        HMAC_SHA384("HmacSHA384", "SHA-384", 48, 16, 128),
        HMAC_SHA512("HmacSHA512", "SHA-512", 64, 16, 128);

        private final ThreadLocalMac mac;
        private final ThreadLocalMessageDigest md;
        private final String mdName;
        private final int messageBlockLength;
        private final int messageLengthBytes;
        private final String name;
        private final int outputLength;
        private final boolean supported;

        MACAlgorithm(String str, String str2, int i, int i2, int i3) {
            this.name = str;
            this.mdName = str2;
            this.outputLength = i;
            this.messageLengthBytes = i2;
            this.messageBlockLength = i3;
            if (str == null && str2 == null) {
                this.supported = true;
                this.mac = null;
                this.md = null;
            } else {
                ThreadLocalMac threadLocalMac = new ThreadLocalMac(str);
                this.mac = threadLocalMac;
                ThreadLocalMessageDigest threadLocalMessageDigest = new ThreadLocalMessageDigest(str2);
                this.md = threadLocalMessageDigest;
                this.supported = threadLocalMac.isSupported() && threadLocalMessageDigest.isSupported();
            }
        }

        public int getKeyLength() {
            return this.outputLength;
        }

        public Mac getMac() {
            ThreadLocalMac threadLocalMac = this.mac;
            if (threadLocalMac != null) {
                return threadLocalMac.current();
            }
            return null;
        }

        public int getMessageBlockLength() {
            return this.messageBlockLength;
        }

        public MessageDigest getMessageDigest() {
            ThreadLocalMessageDigest threadLocalMessageDigest = this.md;
            if (threadLocalMessageDigest == null) {
                return null;
            }
            MessageDigest messageDigestCurrent = threadLocalMessageDigest.current();
            messageDigestCurrent.reset();
            return messageDigestCurrent;
        }

        public int getMessageLengthBytes() {
            return this.messageLengthBytes;
        }

        public String getName() {
            return this.name;
        }

        public int getOutputLength() {
            return this.outputLength;
        }

        public boolean isSupported() {
            return this.supported;
        }
    }

    public enum PRFAlgorithm {
        TLS_PRF_SHA256(MACAlgorithm.HMAC_SHA256),
        TLS_PRF_SHA384(MACAlgorithm.HMAC_SHA384);

        private final MACAlgorithm mac;

        PRFAlgorithm(MACAlgorithm mACAlgorithm) {
            this.mac = mACAlgorithm;
        }

        public MACAlgorithm getMacAlgorithm() {
            return this.mac;
        }
    }

    static {
        CertificateKeyAlgorithm certificateKeyAlgorithm = CertificateKeyAlgorithm.NONE;
        KeyExchangeAlgorithm keyExchangeAlgorithm = KeyExchangeAlgorithm.ECDHE_PSK;
        CipherSpec cipherSpec = CipherSpec.AES_128_GCM;
        MACAlgorithm mACAlgorithm = MACAlgorithm.NULL;
        CipherSuite cipherSuite = new CipherSuite("TLS_ECDHE_PSK_WITH_AES_128_GCM_SHA256", 0, 53249, certificateKeyAlgorithm, keyExchangeAlgorithm, cipherSpec, mACAlgorithm, true);
        TLS_ECDHE_PSK_WITH_AES_128_GCM_SHA256 = cipherSuite;
        CipherSpec cipherSpec2 = CipherSpec.AES_256_GCM;
        PRFAlgorithm pRFAlgorithm = PRFAlgorithm.TLS_PRF_SHA384;
        CipherSuite cipherSuite2 = new CipherSuite("TLS_ECDHE_PSK_WITH_AES_256_GCM_SHA378", 1, 53250, certificateKeyAlgorithm, keyExchangeAlgorithm, cipherSpec2, mACAlgorithm, true, pRFAlgorithm);
        TLS_ECDHE_PSK_WITH_AES_256_GCM_SHA378 = cipherSuite2;
        CipherSpec cipherSpec3 = CipherSpec.AES_128_CCM_8;
        CipherSuite cipherSuite3 = new CipherSuite("TLS_ECDHE_PSK_WITH_AES_128_CCM_8_SHA256", 2, 53251, certificateKeyAlgorithm, keyExchangeAlgorithm, cipherSpec3, mACAlgorithm, true);
        TLS_ECDHE_PSK_WITH_AES_128_CCM_8_SHA256 = cipherSuite3;
        CipherSpec cipherSpec4 = CipherSpec.AES_128_CCM;
        CipherSuite cipherSuite4 = new CipherSuite("TLS_ECDHE_PSK_WITH_AES_128_CCM_SHA256", 3, 53253, certificateKeyAlgorithm, keyExchangeAlgorithm, cipherSpec4, mACAlgorithm, true);
        TLS_ECDHE_PSK_WITH_AES_128_CCM_SHA256 = cipherSuite4;
        KeyExchangeAlgorithm keyExchangeAlgorithm2 = KeyExchangeAlgorithm.PSK;
        CipherSuite cipherSuite5 = new CipherSuite("TLS_PSK_WITH_AES_128_GCM_SHA256", 4, 168, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec, mACAlgorithm, true);
        TLS_PSK_WITH_AES_128_GCM_SHA256 = cipherSuite5;
        CipherSuite cipherSuite6 = new CipherSuite("TLS_PSK_WITH_AES_256_GCM_SHA378", 5, 169, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec2, mACAlgorithm, true, pRFAlgorithm);
        TLS_PSK_WITH_AES_256_GCM_SHA378 = cipherSuite6;
        CipherSuite cipherSuite7 = new CipherSuite("TLS_PSK_WITH_AES_128_CCM_8", 6, 49320, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec3, mACAlgorithm, true);
        TLS_PSK_WITH_AES_128_CCM_8 = cipherSuite7;
        CipherSpec cipherSpec5 = CipherSpec.AES_256_CCM_8;
        CipherSuite cipherSuite8 = new CipherSuite("TLS_PSK_WITH_AES_256_CCM_8", 7, 49321, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec5, mACAlgorithm, true);
        TLS_PSK_WITH_AES_256_CCM_8 = cipherSuite8;
        CipherSuite cipherSuite9 = new CipherSuite("TLS_PSK_WITH_AES_128_CCM", 8, 49316, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec4, mACAlgorithm, true);
        TLS_PSK_WITH_AES_128_CCM = cipherSuite9;
        CipherSpec cipherSpec6 = CipherSpec.AES_256_CCM;
        CipherSuite cipherSuite10 = new CipherSuite("TLS_PSK_WITH_AES_256_CCM", 9, 49317, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec6, mACAlgorithm, true);
        TLS_PSK_WITH_AES_256_CCM = cipherSuite10;
        CipherSpec cipherSpec7 = CipherSpec.AES_128_CBC;
        MACAlgorithm mACAlgorithm2 = MACAlgorithm.HMAC_SHA256;
        CipherSuite cipherSuite11 = new CipherSuite("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256", 10, 49207, certificateKeyAlgorithm, keyExchangeAlgorithm, cipherSpec7, mACAlgorithm2, false);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256 = cipherSuite11;
        CipherSuite cipherSuite12 = new CipherSuite("TLS_PSK_WITH_AES_128_CBC_SHA256", 11, 174, certificateKeyAlgorithm, keyExchangeAlgorithm2, cipherSpec7, mACAlgorithm2, false);
        TLS_PSK_WITH_AES_128_CBC_SHA256 = cipherSuite12;
        CertificateKeyAlgorithm certificateKeyAlgorithm2 = CertificateKeyAlgorithm.EC;
        KeyExchangeAlgorithm keyExchangeAlgorithm3 = KeyExchangeAlgorithm.EC_DIFFIE_HELLMAN;
        CipherSuite cipherSuite13 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 12, 49195, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec, mACAlgorithm, true);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = cipherSuite13;
        CipherSuite cipherSuite14 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 13, 49196, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec2, mACAlgorithm, true, pRFAlgorithm);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = cipherSuite14;
        CipherSuite cipherSuite15 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8", 14, 49326, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec3, mACAlgorithm, true);
        TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8 = cipherSuite15;
        CipherSuite cipherSuite16 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8", 15, 49327, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec5, mACAlgorithm, true);
        TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8 = cipherSuite16;
        CipherSuite cipherSuite17 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_CCM", 16, 49324, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec4, mACAlgorithm, true);
        TLS_ECDHE_ECDSA_WITH_AES_128_CCM = cipherSuite17;
        CipherSuite cipherSuite18 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CCM", 17, 49325, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec6, mACAlgorithm, true);
        TLS_ECDHE_ECDSA_WITH_AES_256_CCM = cipherSuite18;
        CipherSpec cipherSpec8 = CipherSpec.AES_256_CBC;
        CipherSuite cipherSuite19 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 18, 49162, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec8, MACAlgorithm.HMAC_SHA1, false);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = cipherSuite19;
        CipherSuite cipherSuite20 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 19, 49187, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec7, mACAlgorithm2, false);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = cipherSuite20;
        CipherSuite cipherSuite21 = new CipherSuite("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 20, 49188, certificateKeyAlgorithm2, keyExchangeAlgorithm3, cipherSpec8, MACAlgorithm.HMAC_SHA384, false, pRFAlgorithm);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = cipherSuite21;
        CipherSuite cipherSuite22 = new CipherSuite("TLS_NULL_WITH_NULL_NULL", 21, 0, certificateKeyAlgorithm, KeyExchangeAlgorithm.NULL, CipherSpec.NULL, mACAlgorithm, false);
        TLS_NULL_WITH_NULL_NULL = cipherSuite22;
        $VALUES = new CipherSuite[]{cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, cipherSuite12, cipherSuite13, cipherSuite14, cipherSuite15, cipherSuite16, cipherSuite17, cipherSuite18, cipherSuite19, cipherSuite20, cipherSuite21, cipherSuite22};
        LOGGER = LoggerFactory.getLogger((Class<?>) CipherSuite.class);
        overallMaxCipherTextExpansion = 0;
    }

    private CipherSuite(String str, int i, int i2, CertificateKeyAlgorithm certificateKeyAlgorithm, KeyExchangeAlgorithm keyExchangeAlgorithm, CipherSpec cipherSpec, MACAlgorithm mACAlgorithm, boolean z, PRFAlgorithm pRFAlgorithm) {
        this.code = i2;
        this.certificateKeyAlgorithm = certificateKeyAlgorithm;
        this.keyExchange = keyExchangeAlgorithm;
        this.cipher = cipherSpec;
        this.macAlgorithm = mACAlgorithm;
        this.recommendedCipherSuite = z;
        this.pseudoRandomFunction = pRFAlgorithm;
        int i3 = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType[cipherSpec.getType().ordinal()];
        if (i3 == 1) {
            this.maxCipherTextExpansion = cipherSpec.getRecordIvLength() + mACAlgorithm.getOutputLength() + cipherSpec.getRecordIvLength() + 1;
        } else if (i3 != 2) {
            this.maxCipherTextExpansion = 0;
        } else {
            this.maxCipherTextExpansion = cipherSpec.getRecordIvLength() + cipherSpec.getMacLength();
        }
    }

    public static boolean containsCipherSuiteRequiringCertExchange(List<CipherSuite> list) {
        if (list == null) {
            return false;
        }
        Iterator<CipherSuite> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().requiresServerCertificateMessage()) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsEccBasedCipherSuite(List<CipherSuite> list) {
        if (list == null) {
            return false;
        }
        Iterator<CipherSuite> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isEccBased()) {
                return true;
            }
        }
        return false;
    }

    public static List<CipherSuite> getCertificateCipherSuites(boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        for (CipherSuite cipherSuite : values()) {
            if (cipherSuite.isSupported() && cipherSuite.certificateKeyAlgorithm.name().equals(str) && (!z || cipherSuite.recommendedCipherSuite)) {
                arrayList.add(cipherSuite);
            }
        }
        return arrayList;
    }

    public static List<CipherSuite> getCipherSuitesByKeyExchangeAlgorithm(boolean z, boolean z2, List<KeyExchangeAlgorithm> list) {
        if (list == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("KeyExchangeAlgorithms must not be null!");
            return null;
        }
        if (list.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("KeyExchangeAlgorithms must not be empty!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (KeyExchangeAlgorithm keyExchangeAlgorithm : list) {
                for (CipherSuite cipherSuite : values()) {
                    if ((!z || cipherSuite.recommendedCipherSuite) && cipherSuite.isSupported() && keyExchangeAlgorithm.equals(cipherSuite.keyExchange)) {
                        arrayList.add(cipherSuite);
                    }
                }
            }
        } else {
            for (CipherSuite cipherSuite2 : values()) {
                if ((!z || cipherSuite2.recommendedCipherSuite) && cipherSuite2.isSupported() && list.contains(cipherSuite2.keyExchange)) {
                    arrayList.add(cipherSuite2);
                }
            }
        }
        return arrayList;
    }

    public static List<CipherSuite> getEcdsaCipherSuites(boolean z) {
        return getCertificateCipherSuites(z, CertificateKeyAlgorithm.EC.name());
    }

    public static int getOverallMaxCiphertextExpansion() {
        if (overallMaxCipherTextExpansion == 0) {
            int iMax = 0;
            for (CipherSuite cipherSuite : values()) {
                if (cipherSuite.isSupported()) {
                    iMax = Math.max(iMax, cipherSuite.getMaxCiphertextExpansion());
                }
            }
            overallMaxCipherTextExpansion = iMax;
        }
        return overallMaxCipherTextExpansion;
    }

    public static CipherSuite getTypeByCode(int i) {
        for (CipherSuite cipherSuite : values()) {
            if (cipherSuite.code == i) {
                return cipherSuite;
            }
        }
        Logger logger = LOGGER;
        if (!logger.isTraceEnabled()) {
            return null;
        }
        logger.trace("Cannot resolve cipher suite code [{}]", Integer.toHexString(i));
        return null;
    }

    public static List<CipherSuite> listFromReader(DatagramReader datagramReader) {
        ArrayList arrayList = new ArrayList();
        while (datagramReader.bytesAvailable()) {
            CipherSuite typeByCode = getTypeByCode(datagramReader.read(16));
            if (typeByCode != null) {
                arrayList.add(typeByCode);
            }
        }
        return arrayList;
    }

    public static byte[] listToByteArray(List<CipherSuite> list) {
        DatagramWriter datagramWriter = new DatagramWriter();
        Iterator<CipherSuite> it = list.iterator();
        while (it.hasNext()) {
            datagramWriter.write(it.next().getCode(), 16);
        }
        return datagramWriter.toByteArray();
    }

    public static CipherSuite valueOf(String str) {
        return (CipherSuite) Enum.valueOf(CipherSuite.class, str);
    }

    public static CipherSuite[] values() {
        return (CipherSuite[]) $VALUES.clone();
    }

    public CertificateKeyAlgorithm getCertificateKeyAlgorithm() {
        return this.certificateKeyAlgorithm;
    }

    public CipherType getCipherType() {
        return this.cipher.getType();
    }

    public int getCode() {
        return this.code;
    }

    public int getEncKeyLength() {
        return this.cipher.getKeyLength();
    }

    public int getFixedIvLength() {
        return this.cipher.getFixedIvLength();
    }

    public KeyExchangeAlgorithm getKeyExchange() {
        return this.keyExchange;
    }

    public int getMacKeyLength() {
        return this.macAlgorithm.getKeyLength();
    }

    public int getMacLength() {
        MACAlgorithm mACAlgorithm = this.macAlgorithm;
        return mACAlgorithm == MACAlgorithm.NULL ? this.cipher.getMacLength() : mACAlgorithm.getOutputLength();
    }

    public int getMacMessageBlockLength() {
        return this.macAlgorithm.getMessageBlockLength();
    }

    public int getMacMessageLengthBytes() {
        return this.macAlgorithm.getMessageLengthBytes();
    }

    public int getMaxCiphertextExpansion() {
        return this.maxCipherTextExpansion;
    }

    public String getPseudoRandomFunctionMacName() {
        return this.pseudoRandomFunction.getMacAlgorithm().getName();
    }

    public int getRecordIvLength() {
        return this.cipher.getRecordIvLength();
    }

    public Cipher getThreadLocalCipher() {
        return this.cipher.getCipher();
    }

    public Mac getThreadLocalMac() {
        return this.macAlgorithm.getMac();
    }

    public MessageDigest getThreadLocalMacMessageDigest() {
        return this.macAlgorithm.getMessageDigest();
    }

    public Mac getThreadLocalPseudoRandomFunctionMac() {
        return this.pseudoRandomFunction.getMacAlgorithm().getMac();
    }

    public MessageDigest getThreadLocalPseudoRandomFunctionMessageDigest() {
        return this.pseudoRandomFunction.getMacAlgorithm().getMessageDigest();
    }

    public String getTransformation() {
        return this.cipher.getTransformation();
    }

    public boolean isEccBased() {
        return CertificateKeyAlgorithm.EC.equals(this.certificateKeyAlgorithm) || KeyExchangeAlgorithm.ECDHE_PSK.equals(this.keyExchange) || KeyExchangeAlgorithm.EC_DIFFIE_HELLMAN.equals(this.keyExchange);
    }

    public boolean isPskBased() {
        return KeyExchangeAlgorithm.PSK.equals(this.keyExchange) || KeyExchangeAlgorithm.ECDHE_PSK.equals(this.keyExchange);
    }

    public boolean isSupported() {
        return this.pseudoRandomFunction.getMacAlgorithm().isSupported() && this.macAlgorithm.isSupported() && this.cipher.isSupported();
    }

    public boolean requiresServerCertificateMessage() {
        return !CertificateKeyAlgorithm.NONE.equals(this.certificateKeyAlgorithm);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'B_3DES_EDE_CBC' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class CipherSpec {
        private static final /* synthetic */ CipherSpec[] $VALUES;
        public static final CipherSpec AES_128_CBC;
        public static final CipherSpec AES_128_CCM;
        public static final CipherSpec AES_128_CCM_8;
        public static final CipherSpec AES_128_GCM;
        public static final CipherSpec AES_256_CBC;
        public static final CipherSpec AES_256_CCM;
        public static final CipherSpec AES_256_CCM_8;
        public static final CipherSpec AES_256_GCM;
        public static final CipherSpec B_3DES_EDE_CBC;
        public static final CipherSpec NULL;
        private final ThreadLocalCipher cipher;
        private final int fixedIvLength;
        private final int keyLength;
        private final int macLength;
        private final int recordIvLength;
        private final boolean supported;
        private final String transformation;
        private final CipherType type;

        static {
            CipherSpec cipherSpec = new CipherSpec("NULL", 0, "NULL", CipherType.NULL, 0, 0, 0);
            NULL = cipherSpec;
            CipherType cipherType = CipherType.BLOCK;
            CipherSpec cipherSpec2 = new CipherSpec("B_3DES_EDE_CBC", 1, "DESede/CBC/NoPadding", cipherType, 24, 4, 8);
            B_3DES_EDE_CBC = cipherSpec2;
            CipherSpec cipherSpec3 = new CipherSpec("AES_128_CBC", 2, "AES/CBC/NoPadding", cipherType, 16, 4, 16);
            AES_128_CBC = cipherSpec3;
            CipherSpec cipherSpec4 = new CipherSpec("AES_256_CBC", 3, "AES/CBC/NoPadding", cipherType, 32, 4, 16);
            AES_256_CBC = cipherSpec4;
            CipherType cipherType2 = CipherType.AEAD;
            CipherSpec cipherSpec5 = new CipherSpec("AES_128_CCM_8", 4, "AES/CCM", cipherType2, 16, 4, 8, 8);
            AES_128_CCM_8 = cipherSpec5;
            CipherSpec cipherSpec6 = new CipherSpec("AES_256_CCM_8", 5, "AES/CCM", cipherType2, 32, 4, 8, 8);
            AES_256_CCM_8 = cipherSpec6;
            CipherSpec cipherSpec7 = new CipherSpec("AES_128_CCM", 6, "AES/CCM", cipherType2, 16, 4, 8, 16);
            AES_128_CCM = cipherSpec7;
            CipherSpec cipherSpec8 = new CipherSpec("AES_256_CCM", 7, "AES/CCM", cipherType2, 32, 4, 8, 16);
            AES_256_CCM = cipherSpec8;
            CipherSpec cipherSpec9 = new CipherSpec("AES_128_GCM", 8, "AES/GCM/NoPadding", cipherType2, 16, 4, 8, 16);
            AES_128_GCM = cipherSpec9;
            CipherSpec cipherSpec10 = new CipherSpec("AES_256_GCM", 9, "AES/GCM/NoPadding", cipherType2, 32, 4, 8, 16);
            AES_256_GCM = cipherSpec10;
            $VALUES = new CipherSpec[]{cipherSpec, cipherSpec2, cipherSpec3, cipherSpec4, cipherSpec5, cipherSpec6, cipherSpec7, cipherSpec8, cipherSpec9, cipherSpec10};
        }

        private CipherSpec(String str, int i, String str2, CipherType cipherType, int i2, int i3, int i4, int i5) {
            this.transformation = str2;
            this.type = cipherType;
            this.keyLength = i2;
            this.fixedIvLength = i3;
            this.recordIvLength = i4;
            this.macLength = i5;
            boolean zIsSupported = (cipherType == CipherType.AEAD || cipherType == CipherType.BLOCK) ? AeadBlockCipher.isSupported(str2, i2) : true;
            if ("AES/CCM".equals(str2)) {
                this.cipher = null;
                this.supported = zIsSupported;
            } else {
                ThreadLocalCipher threadLocalCipher = zIsSupported ? new ThreadLocalCipher(str2) : null;
                this.cipher = threadLocalCipher;
                this.supported = threadLocalCipher == null ? false : threadLocalCipher.isSupported();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Cipher getCipher() {
            ThreadLocalCipher threadLocalCipher = this.cipher;
            if (threadLocalCipher == null) {
                return null;
            }
            return threadLocalCipher.current();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getFixedIvLength() {
            return this.fixedIvLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getKeyLength() {
            return this.keyLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getMacLength() {
            return this.macLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getRecordIvLength() {
            return this.recordIvLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getTransformation() {
            return this.transformation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CipherType getType() {
            return this.type;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isSupported() {
            return this.supported;
        }

        public static CipherSpec valueOf(String str) {
            return (CipherSpec) Enum.valueOf(CipherSpec.class, str);
        }

        public static CipherSpec[] values() {
            return (CipherSpec[]) $VALUES.clone();
        }

        private CipherSpec(String str, int i, String str2, CipherType cipherType, int i2, int i3, int i4) {
            this(str, i, str2, cipherType, i2, i3, i4, 0);
        }
    }

    private CipherSuite(String str, int i, int i2, CertificateKeyAlgorithm certificateKeyAlgorithm, KeyExchangeAlgorithm keyExchangeAlgorithm, CipherSpec cipherSpec, MACAlgorithm mACAlgorithm, boolean z) {
        this(str, i, i2, certificateKeyAlgorithm, keyExchangeAlgorithm, cipherSpec, mACAlgorithm, z, PRFAlgorithm.TLS_PRF_SHA256);
    }

    public static List<CipherSuite> getCipherSuitesByKeyExchangeAlgorithm(boolean z, KeyExchangeAlgorithm... keyExchangeAlgorithmArr) {
        if (keyExchangeAlgorithmArr != null) {
            if (keyExchangeAlgorithmArr.length != 0) {
                return getCipherSuitesByKeyExchangeAlgorithm(z, false, Arrays.asList(keyExchangeAlgorithmArr));
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("KeyExchangeAlgorithms must not be empty!");
            return null;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("KeyExchangeAlgorithms must not be null!");
        return null;
    }
}

package org.eclipse.californium.scandium.dtls;

import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalSignature;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class SignatureAndHashAlgorithm {
    public static List<SignatureAndHashAlgorithm> DEFAULT;
    public static SignatureAndHashAlgorithm INTRINSIC_WITH_ED25519;
    public static SignatureAndHashAlgorithm INTRINSIC_WITH_ED448;
    public static SignatureAndHashAlgorithm SHA1_WITH_ECDSA;
    public static SignatureAndHashAlgorithm SHA256_WITH_ECDSA;
    public static SignatureAndHashAlgorithm SHA256_WITH_RSA;
    public static SignatureAndHashAlgorithm SHA384_WITH_ECDSA;
    private final HashAlgorithm hash;
    private final int hashAlgorithmCode;
    private final String jcaName;
    private final SignatureAlgorithm signature;
    private final int signatureAlgorithmCode;
    private final boolean supported;

    public enum HashAlgorithm {
        NONE(0),
        MD5(1),
        SHA1(2),
        SHA224(3),
        SHA256(4),
        SHA384(5),
        SHA512(6),
        INTRINSIC(8);

        private int code;

        HashAlgorithm(int i) {
            this.code = i;
        }

        public static HashAlgorithm getAlgorithmByCode(int i) {
            switch (i) {
                case 0:
                    return NONE;
                case 1:
                    return MD5;
                case 2:
                    return SHA1;
                case 3:
                    return SHA224;
                case 4:
                    return SHA256;
                case 5:
                    return SHA384;
                case 6:
                    return SHA512;
                case 7:
                default:
                    return null;
                case 8:
                    return INTRINSIC;
            }
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum SignatureAlgorithm {
        ANONYMOUS(0, false),
        RSA(1, false),
        DSA(2, false),
        ECDSA(3, true),
        ED25519(7, true),
        ED448(8, true);

        private final int code;
        private final boolean isEcdsaCompatible;

        SignatureAlgorithm(int i, boolean z) {
            this.code = i;
            this.isEcdsaCompatible = z;
        }

        public static SignatureAlgorithm getAlgorithmByCode(int i) {
            if (i == 0) {
                return ANONYMOUS;
            }
            if (i == 1) {
                return RSA;
            }
            if (i == 2) {
                return DSA;
            }
            if (i == 3) {
                return ECDSA;
            }
            if (i == 7) {
                return ED25519;
            }
            if (i != 8) {
                return null;
            }
            return ED448;
        }

        public int getCode() {
            return this.code;
        }

        public boolean isEcdsaCompatible() {
            return this.isEcdsaCompatible;
        }
    }

    static {
        HashAlgorithm hashAlgorithm = HashAlgorithm.SHA1;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ECDSA;
        SHA1_WITH_ECDSA = new SignatureAndHashAlgorithm(hashAlgorithm, signatureAlgorithm);
        HashAlgorithm hashAlgorithm2 = HashAlgorithm.SHA256;
        SHA256_WITH_ECDSA = new SignatureAndHashAlgorithm(hashAlgorithm2, signatureAlgorithm);
        SHA384_WITH_ECDSA = new SignatureAndHashAlgorithm(HashAlgorithm.SHA384, signatureAlgorithm);
        SHA256_WITH_RSA = new SignatureAndHashAlgorithm(hashAlgorithm2, SignatureAlgorithm.RSA);
        HashAlgorithm hashAlgorithm3 = HashAlgorithm.INTRINSIC;
        INTRINSIC_WITH_ED25519 = new SignatureAndHashAlgorithm(hashAlgorithm3, SignatureAlgorithm.ED25519);
        INTRINSIC_WITH_ED448 = new SignatureAndHashAlgorithm(hashAlgorithm3, SignatureAlgorithm.ED448);
        DEFAULT = Collections.unmodifiableList(Arrays.asList(SHA256_WITH_ECDSA, SHA256_WITH_RSA));
    }

    public SignatureAndHashAlgorithm(HashAlgorithm hashAlgorithm, SignatureAlgorithm signatureAlgorithm) {
        if (hashAlgorithm == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Hash Algorithm must not be null!");
            throw null;
        }
        if (signatureAlgorithm == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Signature Algorithm must not be null!");
            throw null;
        }
        this.hash = hashAlgorithm;
        this.signature = signatureAlgorithm;
        this.hashAlgorithmCode = hashAlgorithm.getCode();
        this.signatureAlgorithmCode = signatureAlgorithm.getCode();
        String strBuildJcaName = buildJcaName();
        this.jcaName = strBuildJcaName;
        this.supported = strBuildJcaName != null && getThreadLocalSignature(strBuildJcaName).isSupported();
    }

    private String buildJcaName() {
        if (this.hash == null || this.signature == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        HashAlgorithm hashAlgorithm = this.hash;
        if (hashAlgorithm != HashAlgorithm.INTRINSIC) {
            sb.append(hashAlgorithm);
            sb.append("with");
        }
        sb.append(this.signature);
        return sb.toString();
    }

    public static List<SignatureAndHashAlgorithm> getCommonSignatureAlgorithms(List<SignatureAndHashAlgorithm> list, List<SignatureAndHashAlgorithm> list2) {
        ArrayList arrayList = new ArrayList();
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : list) {
            if (list2.contains(signatureAndHashAlgorithm)) {
                arrayList.add(signatureAndHashAlgorithm);
            }
        }
        return arrayList;
    }

    public static List<SignatureAndHashAlgorithm> getDefaultSignatureAlgorithms(PublicKey publicKey) {
        ArrayList arrayList = new ArrayList(DEFAULT);
        if (publicKey != null && getSupportedSignatureAlgorithm(arrayList, publicKey) == null) {
            loop0: for (HashAlgorithm hashAlgorithm : HashAlgorithm.values()) {
                if (!hashAlgorithm.equals(HashAlgorithm.NONE)) {
                    for (SignatureAlgorithm signatureAlgorithm : SignatureAlgorithm.values()) {
                        SignatureAndHashAlgorithm signatureAndHashAlgorithm = new SignatureAndHashAlgorithm(hashAlgorithm, signatureAlgorithm);
                        Signature signatureCurrent = signatureAndHashAlgorithm.getThreadLocalSignature().current();
                        if (signatureCurrent != null) {
                            try {
                                signatureCurrent.initVerify(publicKey);
                                if (!arrayList.contains(signatureAndHashAlgorithm)) {
                                    arrayList.add(signatureAndHashAlgorithm);
                                    break loop0;
                                }
                                break loop0;
                            } catch (InvalidKeyException unused) {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<SignatureAndHashAlgorithm> getEcdsaCompatibleSignatureAlgorithms(List<SignatureAndHashAlgorithm> list) {
        ArrayList arrayList = new ArrayList();
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : list) {
            if (signatureAndHashAlgorithm.getSignature().isEcdsaCompatible()) {
                arrayList.add(signatureAndHashAlgorithm);
            }
        }
        return arrayList;
    }

    public static SignatureAndHashAlgorithm getSupportedSignatureAlgorithm(List<SignatureAndHashAlgorithm> list, PublicKey publicKey) {
        if (publicKey == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Public key must not be null!");
            return null;
        }
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : list) {
            try {
                Signature signatureCurrent = signatureAndHashAlgorithm.getThreadLocalSignature().current();
                if (signatureCurrent != null) {
                    signatureCurrent.initVerify(publicKey);
                    return signatureAndHashAlgorithm;
                }
                continue;
            } catch (InvalidKeyException unused) {
            }
        }
        return null;
    }

    public static ThreadLocalSignature getThreadLocalSignature(String str) {
        if (str == null) {
            str = "UNKNOWN";
        }
        return (ThreadLocalSignature) ThreadLocalSignature.SIGNATURES.get(str);
    }

    private static boolean isSignedWithSupportedAlgorithm(List<SignatureAndHashAlgorithm> list, X509Certificate x509Certificate) {
        String sigAlgName = x509Certificate.getSigAlgName();
        Iterator<SignatureAndHashAlgorithm> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getJcaName().equalsIgnoreCase(sigAlgName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSignedWithSupportedAlgorithms(List<SignatureAndHashAlgorithm> list, List<X509Certificate> list2) {
        Iterator<X509Certificate> it = list2.iterator();
        while (it.hasNext()) {
            if (!isSignedWithSupportedAlgorithm(list, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static SignatureAndHashAlgorithm valueOf(String str) {
        int iIndexOf = str.indexOf("with");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf("WITH");
        }
        if (iIndexOf <= 0) {
            return null;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 4, str.length());
        HashAlgorithm hashAlgorithmValueOf = HashAlgorithm.valueOf(strSubstring);
        SignatureAlgorithm signatureAlgorithmValueOf = SignatureAlgorithm.valueOf(strSubstring2);
        if (hashAlgorithmValueOf == null || signatureAlgorithmValueOf == null) {
            return null;
        }
        return new SignatureAndHashAlgorithm(hashAlgorithmValueOf, signatureAlgorithmValueOf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SignatureAndHashAlgorithm.class != obj.getClass()) {
            return false;
        }
        SignatureAndHashAlgorithm signatureAndHashAlgorithm = (SignatureAndHashAlgorithm) obj;
        return this.signatureAlgorithmCode == signatureAndHashAlgorithm.signatureAlgorithmCode && this.hashAlgorithmCode == signatureAndHashAlgorithm.hashAlgorithmCode;
    }

    public HashAlgorithm getHash() {
        return this.hash;
    }

    public String getJcaName() {
        return this.jcaName;
    }

    public SignatureAlgorithm getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return (this.hashAlgorithmCode * 100) + this.signatureAlgorithmCode;
    }

    public String toString() {
        String str = this.jcaName;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        HashAlgorithm hashAlgorithm = this.hash;
        if (hashAlgorithm != null) {
            sb.append(hashAlgorithm);
        } else {
            sb.append(String.format("0x%02x", Integer.valueOf(this.hashAlgorithmCode)));
        }
        sb.append("with");
        SignatureAlgorithm signatureAlgorithm = this.signature;
        if (signatureAlgorithm != null) {
            sb.append(signatureAlgorithm);
        } else {
            sb.append(String.format("0x%02x", Integer.valueOf(this.signatureAlgorithmCode)));
        }
        return sb.toString();
    }

    public ThreadLocalSignature getThreadLocalSignature() {
        return getThreadLocalSignature(getJcaName());
    }

    public SignatureAndHashAlgorithm(int i, int i2) {
        this.hashAlgorithmCode = i;
        this.signatureAlgorithmCode = i2;
        this.signature = SignatureAlgorithm.getAlgorithmByCode(i2);
        this.hash = HashAlgorithm.getAlgorithmByCode(i);
        String strBuildJcaName = buildJcaName();
        this.jcaName = strBuildJcaName;
        this.supported = strBuildJcaName != null && getThreadLocalSignature(strBuildJcaName).isSupported();
    }

    public static List<SignatureAndHashAlgorithm> getDefaultSignatureAlgorithms(List<X509Certificate> list) {
        if (list != null && list.size() > 0) {
            List<SignatureAndHashAlgorithm> defaultSignatureAlgorithms = getDefaultSignatureAlgorithms(list.get(0).getPublicKey());
            Iterator<X509Certificate> it = list.iterator();
            while (it.hasNext()) {
                SignatureAndHashAlgorithm signatureAndHashAlgorithmValueOf = valueOf(it.next().getSigAlgName());
                if (signatureAndHashAlgorithmValueOf != null && !defaultSignatureAlgorithms.contains(signatureAndHashAlgorithmValueOf)) {
                    defaultSignatureAlgorithms.add(signatureAndHashAlgorithmValueOf);
                }
            }
            return defaultSignatureAlgorithms;
        }
        return new ArrayList(DEFAULT);
    }
}

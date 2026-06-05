package org.eclipse.californium.elements.util;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CertPathUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CertPathUtil.class);

    public static boolean canBeUsedForAuthentication(X509Certificate x509Certificate, boolean z) {
        if (x509Certificate.getKeyUsage() != null && !x509Certificate.getKeyUsage()[0]) {
            LOGGER.debug("certificate: {}, not for signing!", x509Certificate.getSubjectDN());
            return false;
        }
        try {
            List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
            if (extendedKeyUsage == null || extendedKeyUsage.isEmpty()) {
                LOGGER.debug("certificate: {}, no extkeyusage!", x509Certificate.getSubjectDN());
            } else {
                LOGGER.trace("certificate: {}", x509Certificate.getSubjectDN());
                String str = z ? "1.3.6.1.5.5.7.3.2" : "1.3.6.1.5.5.7.3.1";
                boolean z2 = false;
                for (String str2 : extendedKeyUsage) {
                    LOGGER.trace("   extkeyusage {}", str2);
                    if (str.equals(str2)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    LOGGER.debug("certificate: {}, not for {}!", x509Certificate.getSubjectDN(), z ? "client" : "server");
                    return false;
                }
            }
        } catch (CertificateParsingException e) {
            LOGGER.warn("x509 certificate:", (Throwable) e);
        }
        return true;
    }

    private static boolean contains(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) {
        for (X509Certificate x509Certificate2 : x509CertificateArr) {
            if (x509Certificate.equals(x509Certificate2)) {
                return true;
            }
        }
        return false;
    }

    public static CertPath generateCertPath(List<X509Certificate> list, int i) {
        X500Principal issuerX500Principal = null;
        if (list == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Certificate chain must not be null!");
            return null;
        }
        if (i > list.size()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("size must not be larger then certificate chain!");
            return null;
        }
        try {
            if (!list.isEmpty()) {
                int size = list.size() - 1;
                for (int i2 = 0; i2 <= size; i2++) {
                    X509Certificate x509Certificate = list.get(i2);
                    Logger logger = LOGGER;
                    logger.debug("Current Subject DN: {}", x509Certificate.getSubjectX500Principal().getName());
                    if (issuerX500Principal != null && !issuerX500Principal.equals(x509Certificate.getSubjectX500Principal())) {
                        logger.debug("Actual Issuer DN: {}", x509Certificate.getSubjectX500Principal().getName());
                        throw new IllegalArgumentException("Given certificates do not form a chain");
                    }
                    issuerX500Principal = x509Certificate.getIssuerX500Principal();
                    logger.debug("Expected Issuer DN: {}", issuerX500Principal.getName());
                    if (issuerX500Principal.equals(x509Certificate.getSubjectX500Principal()) && i2 != size) {
                        throw new IllegalArgumentException("Given certificates do not form a chain, root is not the last!");
                    }
                }
                if (i < list.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i; i3++) {
                        arrayList.add(list.get(i3));
                    }
                    list = arrayList;
                }
            }
            return CertificateFactory.getInstance("X.509").generateCertPath(list);
        } catch (CertificateException e) {
            throw new IllegalArgumentException("could not create X.509 certificate factory", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CertPath generateValidatableCertPath(List<X509Certificate> list, List<X500Principal> list2) {
        int i;
        if (list == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Certificate chain must not be null!");
            return null;
        }
        int size = list.size();
        if (size > 0) {
            if (list2 == null || list2.isEmpty()) {
                i = size;
            } else {
                i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (list2.contains(list.get(i2).getIssuerX500Principal())) {
                        i = i2 + 1;
                        break;
                    }
                    i2++;
                }
            }
            if (size <= 1 || i != size) {
                size = i;
            } else {
                size--;
                X509Certificate x509Certificate = list.get(size);
                if (!x509Certificate.getIssuerX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
                }
            }
        }
        return generateCertPath(list, size);
    }

    private static X509Certificate searchIssuer(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) {
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        X509Certificate x509Certificate2 = null;
        for (X509Certificate x509Certificate3 : x509CertificateArr) {
            if (x509Certificate3 != null && issuerX500Principal.equals(x509Certificate3.getSubjectX500Principal())) {
                if (x509Certificate2 != null && verifySignature(x509Certificate, x509Certificate2)) {
                    return x509Certificate2;
                }
                x509Certificate2 = x509Certificate3;
            }
        }
        return x509Certificate2;
    }

    public static List<X500Principal> toSubjects(List<X509Certificate> list) {
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<X509Certificate> it = list.iterator();
        while (it.hasNext()) {
            X500Principal subjectX500Principal = it.next().getSubjectX500Principal();
            if (!arrayList.contains(subjectX500Principal)) {
                arrayList.add(subjectX500Principal);
            }
        }
        return arrayList;
    }

    public static List<X509Certificate> toX509CertificatesList(List<? extends Certificate> list) {
        if (list == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Certificates list must not be null!");
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Certificate certificate : list) {
            if (!(certificate instanceof X509Certificate)) {
                Gson$$ExternalSyntheticBUOutline0.m("Given certificate is not X.509! ", certificate);
                return null;
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    public static CertPath validateCertificatePathWithIssuer(boolean z, CertPath certPath, X509Certificate[] x509CertificateArr) throws NoSuchAlgorithmException, CertPathValidatorException, InvalidAlgorithmParameterException {
        boolean z2;
        String str;
        String str2;
        boolean z3;
        X509Certificate x509Certificate;
        if (x509CertificateArr == null) {
            throw new CertPathValidatorException("certificates are not trusted!");
        }
        List<? extends Certificate> certificates = certPath.getCertificates();
        if (!certificates.isEmpty()) {
            List<X509Certificate> x509CertificatesList = toX509CertificatesList(certificates);
            int size = x509CertificatesList.size();
            int i = size - 1;
            X509Certificate x509Certificate2 = (X509Certificate) certificates.get(i);
            X509Certificate next = null;
            if (x509CertificateArr.length == 0) {
                if (i == 0) {
                    if (!x509Certificate2.getIssuerX500Principal().equals(x509Certificate2.getSubjectX500Principal())) {
                        LOGGER.debug("   trust all- single certificate {}", x509Certificate2.getSubjectX500Principal());
                        return certPath;
                    }
                    i = size;
                }
                str2 = "last";
                z2 = false;
                z3 = false;
            } else if (z) {
                int i2 = 1;
                while (true) {
                    if (i2 >= size) {
                        x509Certificate = null;
                        break;
                    }
                    x509Certificate = x509CertificatesList.get(i2);
                    if (!contains(x509Certificate, x509CertificateArr)) {
                        i2++;
                    } else if (i > i2) {
                        i = i2;
                        z2 = true;
                    }
                }
                z2 = false;
                z3 = z2;
                if (x509Certificate == null) {
                    X509Certificate x509CertificateSearchIssuer = searchIssuer(x509Certificate2, x509CertificateArr);
                    if (x509CertificateSearchIssuer != null) {
                        z2 = !x509Certificate2.equals(x509CertificateSearchIssuer);
                    }
                    x509Certificate2 = x509CertificateSearchIssuer;
                    i = size;
                } else {
                    x509Certificate2 = x509Certificate;
                }
                str2 = "anchor";
                if (x509Certificate2 == null) {
                    X509Certificate x509Certificate3 = x509CertificatesList.get(0);
                    if (contains(x509Certificate3, x509CertificateArr)) {
                        if (size <= 1) {
                            LOGGER.debug("   trust node - single certificate {}", x509Certificate3.getSubjectX500Principal());
                            return certPath;
                        }
                        x509Certificate2 = x509CertificatesList.get(1);
                        str2 = "node's issuer";
                        i = 1;
                        z3 = true;
                    }
                }
            } else {
                X509Certificate x509CertificateSearchIssuer2 = searchIssuer(x509Certificate2, x509CertificateArr);
                if (x509CertificateSearchIssuer2 == null && contains(x509Certificate2, x509CertificateArr)) {
                    str = "last's subject";
                    z2 = false;
                } else {
                    z2 = !x509Certificate2.equals(x509CertificateSearchIssuer2);
                    x509Certificate2 = x509CertificateSearchIssuer2;
                    str = "last's issuer";
                }
                str2 = str;
                z3 = false;
                i = size;
            }
            CertPath certPathGenerateCertPath = generateCertPath(x509CertificatesList, i);
            HashSet hashSet = new HashSet();
            if (x509Certificate2 == null) {
                x509Certificate2 = x509CertificateArr[0];
            }
            hashSet.add(new TrustAnchor(x509Certificate2, null));
            Logger logger = LOGGER;
            if (logger.isDebugEnabled()) {
                List<X509Certificate> x509CertificatesList2 = toX509CertificatesList(certPathGenerateCertPath.getCertificates());
                logger.debug("verify: certificate path {} (orig. {})", Integer.valueOf(i), Integer.valueOf(size));
                Iterator<X509Certificate> it = x509CertificatesList2.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    LOGGER.debug("   cert : {}", next.getSubjectX500Principal());
                }
                if (next != null) {
                    LOGGER.debug("   sign : {}", next.getIssuerX500Principal());
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    LOGGER.debug("   trust: {}, {}", str2, ((TrustAnchor) it2.next()).getTrustedCert().getSubjectX500Principal());
                }
            }
            CertPathValidator certPathValidator = CertPathValidator.getInstance(CertPathValidator.getDefaultType());
            PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
            pKIXParameters.setRevocationEnabled(false);
            certPathValidator.validate(certPathGenerateCertPath, pKIXParameters);
            if (z3 || z2) {
                if (!z2) {
                    return certPathGenerateCertPath;
                }
                if (!z3) {
                    x509CertificatesList.add(x509Certificate2);
                }
                return generateCertPath(x509CertificatesList, i + 1);
            }
        }
        return certPath;
    }

    private static boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.checkValidity();
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}

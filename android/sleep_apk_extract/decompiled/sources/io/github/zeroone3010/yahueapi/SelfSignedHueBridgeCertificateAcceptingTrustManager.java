package io.github.zeroone3010.yahueapi;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class SelfSignedHueBridgeCertificateAcceptingTrustManager implements X509TrustManager {
    public static final String PHILIPS_HUE_CERTIFICATE_ORGANIZATION = "O=Philips Hue,";
    private static final Logger logger = LoggerFactory.getLogger("io.github.zeroone3010.yahueapi");
    private final X509TrustManager trustManager;

    public SelfSignedHueBridgeCertificateAcceptingTrustManager(X509TrustManager x509TrustManager) {
        this.trustManager = x509TrustManager;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new UnsupportedOperationException("This trust manager does not work for validating client certificates.");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.trustManager.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
            if (e.getMessage() == null || !e.getMessage().contains("path")) {
                logger.debug("Certificate rejected, trust manager provided unknown exception");
                throw e;
            }
            if (x509CertificateArr == null || x509CertificateArr.length != 1) {
                logger.debug("Certificate rejected, chain does not contain exactly one certificate");
                throw e;
            }
            X509Certificate x509Certificate = x509CertificateArr[0];
            String lowerCase = x509Certificate.getSerialNumber().toString(16).toLowerCase();
            if (!x509Certificate.getIssuerDN().toString().contains(PHILIPS_HUE_CERTIFICATE_ORGANIZATION)) {
                logger.debug("Certificate rejected, issuer DN is wrong: {}", x509Certificate.getIssuerDN());
                throw e;
            }
            if (!x509Certificate.getIssuerDN().toString().contains(lowerCase)) {
                logger.debug("Certificate rejected, serial number {} does not match issuer DN {}", lowerCase, x509Certificate.getIssuerDN());
                throw e;
            }
            if (!x509Certificate.getSubjectDN().toString().contains(PHILIPS_HUE_CERTIFICATE_ORGANIZATION)) {
                logger.debug("Certificate rejected, subject DN is wrong: {}", x509Certificate.getSubjectDN());
                throw e;
            }
            if (x509Certificate.getSubjectDN().toString().contains(lowerCase)) {
                return;
            }
            logger.debug("Certificate rejected, serial number {} does not match subject DN {}", lowerCase, x509Certificate.getSubjectDN());
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

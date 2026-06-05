package org.eclipse.californium.elements.util;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SslContextUtil {
    private static final KeyManager ANONYMOUS;
    private static final TrustManager TRUST_ALL;
    public static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) SslContextUtil.class);
    private static final Map<String, String> KEY_STORE_TYPES = new ConcurrentHashMap();
    private static final Map<String, KeyStoreConfiguration> KEY_STORE_CONFIGS = new ConcurrentHashMap();
    private static final Map<String, Object> INPUT_STREAM_FACTORIES = new ConcurrentHashMap();

    public static class AnonymousX509ExtendedKeyManager extends X509ExtendedKeyManager {
        private AnonymousX509ExtendedKeyManager() {
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
            return null;
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
            return null;
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String str) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String str, Principal[] principalArr) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String str) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String str, Principal[] principalArr) {
            return null;
        }
    }

    public static class ClassLoaderInputStreamFactory {
        private ClassLoaderInputStreamFactory() {
        }
    }

    public static class KeyStoreConfiguration {
        public final SimpleKeyStore simpleStore;
        public final String type;

        public KeyStoreConfiguration(String str, SimpleKeyStore simpleKeyStore) {
            this.type = str;
            this.simpleStore = simpleKeyStore;
        }
    }

    public interface SimpleKeyStore {
    }

    public static class X509TrustAllManager implements X509TrustManager {
        private static final X509Certificate[] NO_ISSUERS = new X509Certificate[0];

        private X509TrustAllManager() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void validateChain(X509Certificate[] x509CertificateArr, boolean z) throws CertificateException {
            if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
                return;
            }
            Logger logger = SslContextUtil.LOGGER;
            logger.debug("check certificate {} for {}", x509CertificateArr[0].getSubjectDN(), z ? "client" : "server");
            if (!CertPathUtil.canBeUsedForAuthentication(x509CertificateArr[0], z)) {
                logger.debug("check certificate {} for {} failed on key-usage!", x509CertificateArr[0].getSubjectDN(), z ? "client" : "server");
                throw new CertificateException("Key usage not proper for ".concat(z ? "client" : "server"));
            }
            logger.trace("check certificate {} for {} succeeded on key-usage!", x509CertificateArr[0].getSubjectDN(), z ? "client" : "server");
            try {
                CertPathUtil.validateCertificatePathWithIssuer(false, CertPathUtil.generateValidatableCertPath(Arrays.asList(x509CertificateArr), null), NO_ISSUERS);
                logger.trace("check certificate {}[{}] for {} validated!", x509CertificateArr[0].getSubjectDN(), Integer.valueOf(x509CertificateArr.length), z ? "client" : "server");
            } catch (GeneralSecurityException e) {
                SslContextUtil.LOGGER.debug("check certificate {} for {} failed on {}!", x509CertificateArr[0].getSubjectDN(), z ? "client" : "server", e.getMessage());
                if (!(e instanceof CertificateException)) {
                    throw new CertificateException(e);
                }
                throw ((CertificateException) e);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            validateChain(x509CertificateArr, true);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            validateChain(x509CertificateArr, false);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return NO_ISSUERS;
        }
    }

    static {
        TrustManager x509TrustAllManager;
        ANONYMOUS = new AnonymousX509ExtendedKeyManager();
        Asn1DerDecoder.getEdDsaProvider();
        configureDefaults();
        try {
            x509TrustAllManager = new X509ExtendedTrustAllManager();
        } catch (NoClassDefFoundError unused) {
            x509TrustAllManager = new X509TrustAllManager();
        }
        TRUST_ALL = x509TrustAllManager;
    }

    public static X509Certificate[] asX509Certificates(Certificate[] certificateArr) {
        if (certificateArr == null || certificateArr.length == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("certificates missing!");
            return null;
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[certificateArr.length];
        for (int i = 0; certificateArr.length > i; i++) {
            Certificate certificate = certificateArr[i];
            if (certificate == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "[", "] is null!"));
                return null;
            }
            try {
                x509CertificateArr[i] = (X509Certificate) certificate;
            } catch (ClassCastException unused) {
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "[", "] is not a x509 certificate! Instead it's a ");
                sbM65m.append(certificateArr[i].getClass().getName());
                throw new IllegalArgumentException(sbM65m.toString());
            }
        }
        return x509CertificateArr;
    }

    public static void configureDefaults() {
        Map<String, String> map = KEY_STORE_TYPES;
        map.clear();
        map.put(".jks", "JKS");
        map.put(".bks", "BKS");
        map.put(".p12", "PKCS12");
        map.put(".pem", "PEM");
        map.put("*", KeyStore.getDefaultType());
        Map<String, KeyStoreConfiguration> map2 = KEY_STORE_CONFIGS;
        map2.put("JKS", new KeyStoreConfiguration("JKS", null));
        map2.put("BKS", new KeyStoreConfiguration("BKS", null));
        map2.put("PKCS12", new KeyStoreConfiguration("PKCS12", null));
        map2.put("PEM", new KeyStoreConfiguration("PEM", new SimpleKeyStore() { // from class: org.eclipse.californium.elements.util.SslContextUtil.1
        }));
        Map<String, Object> map3 = INPUT_STREAM_FACTORIES;
        map3.clear();
        map3.put("classpath://", new ClassLoaderInputStreamFactory());
    }

    public static void ensureUniqueCertificates(X509Certificate[] x509CertificateArr) {
        HashSet hashSet = new HashSet();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            if (!hashSet.add(x509Certificate)) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Truststore contains certificates duplicates with subject: ", x509Certificate.getSubjectX500Principal());
                return;
            }
        }
    }

    public static class X509ExtendedTrustAllManager extends X509ExtendedTrustManager {
        private X509ExtendedTrustAllManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            X509TrustAllManager.validateChain(x509CertificateArr, true);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            X509TrustAllManager.validateChain(x509CertificateArr, false);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return X509TrustAllManager.NO_ISSUERS;
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
            X509TrustAllManager.validateChain(x509CertificateArr, true);
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
            X509TrustAllManager.validateChain(x509CertificateArr, false);
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
            X509TrustAllManager.validateChain(x509CertificateArr, true);
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
            X509TrustAllManager.validateChain(x509CertificateArr, false);
        }
    }
}

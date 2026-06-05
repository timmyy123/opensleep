package io.github.zeroone3010.yahueapi;

import com.facebook.share.internal.ShareInternalUtility;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.urbandroid.common.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* JADX INFO: loaded from: classes5.dex */
public class SecureJsonFactory extends MappingJsonFactory {
    private String certificate = "-----BEGIN CERTIFICATE-----\nMIICMjCCAdigAwIBAgIUO7FSLbaxikuXAljzVaurLXWmFw4wCgYIKoZIzj0EAwIw\nOTELMAkGA1UEBhMCTkwxFDASBgNVBAoMC1BoaWxpcHMgSHVlMRQwEgYDVQQDDAty\nb290LWJyaWRnZTAiGA8yMDE3MDEwMTAwMDAwMFoYDzIwMzgwMTE5MDMxNDA3WjA5\nMQswCQYDVQQGEwJOTDEUMBIGA1UECgwLUGhpbGlwcyBIdWUxFDASBgNVBAMMC3Jv\nb3QtYnJpZGdlMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEjNw2tx2AplOf9x86\naTdvEcL1FU65QDxziKvBpW9XXSIcibAeQiKxegpq8Exbr9v6LBnYbna2VcaK0G22\njOKkTqOBuTCBtjAPBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBhjAdBgNV\nHQ4EFgQUZ2ONTFrDT6o8ItRnKfqWKnHFGmQwdAYDVR0jBG0wa4AUZ2ONTFrDT6o8\nItRnKfqWKnHFGmShPaQ7MDkxCzAJBgNVBAYTAk5MMRQwEgYDVQQKDAtQaGlsaXBz\nIEh1ZTEUMBIGA1UEAwwLcm9vdC1icmlkZ2WCFDuxUi22sYpLlwJY81Wrqy11phcO\nMAoGCCqGSM49BAMCA0gAMEUCIEBYYEOsa07TH7E5MJnGw557lVkORgit2Rm1h3B2\nsFgDAiEA1Fj/C3AN5psFMjo0//mrQebo0eKd3aWRx+pQY08mk48=\n-----END CERTIFICATE-----";
    private final HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory socketFactory;
    private X509TrustManager trustManager;

    public SecureJsonFactory(String str) {
        try {
            this.socketFactory = createHueSSLContext().getSocketFactory();
            this.hostnameVerifier = new SecureJsonFactory$$ExternalSyntheticLambda0(0);
        } catch (IOException | GeneralSecurityException e) {
            throw new HueApiException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(String str, SSLSession sSLSession) {
        return true;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public InputStream _optimizedStreamFromURL(URL url) throws IOException {
        String host;
        if (ShareInternalUtility.STAGING_PARAM.equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) {
            String path = url.getPath();
            if (path.indexOf(37) < 0) {
                return Files.newInputStream(new File(path).toPath(), new OpenOption[0]);
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.socketFactory);
            httpsURLConnection.setHostnameVerifier(this.hostnameVerifier);
        }
        httpURLConnection.connect();
        return httpURLConnection.getInputStream();
    }

    public SSLContext createHueSSLContext() throws NoSuchAlgorithmException, IOException, KeyStoreException, KeyManagementException {
        char[] cArr = new char[0];
        getClass().getClassLoader();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.certificate.getBytes());
        try {
            Logger.logInfo("Loading certificate");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, cArr);
            keyStore.setCertificateEntry("PhilipsHue", CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream));
            byteArrayInputStream.close();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            SSLContext sSLContext = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            trustManagerFactory.init(keyStore);
            SelfSignedHueBridgeCertificateAcceptingTrustManager selfSignedHueBridgeCertificateAcceptingTrustManager = new SelfSignedHueBridgeCertificateAcceptingTrustManager((X509TrustManager) trustManagerFactory.getTrustManagers()[0]);
            this.trustManager = selfSignedHueBridgeCertificateAcceptingTrustManager;
            sSLContext.init(null, new TrustManager[]{selfSignedHueBridgeCertificateAcceptingTrustManager}, null);
            return sSLContext;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public SSLSocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public X509TrustManager getTrustManager() {
        return this.trustManager;
    }
}

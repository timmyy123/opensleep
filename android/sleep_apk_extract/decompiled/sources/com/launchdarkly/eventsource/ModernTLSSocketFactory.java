package com.launchdarkly.eventsource;

import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* JADX INFO: loaded from: classes5.dex */
public class ModernTLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory defaultSocketFactory;

    public ModernTLSSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
        sSLContext.init(null, null, null);
        this.defaultSocketFactory = sSLContext.getSocketFactory();
    }

    public static Socket setModernTlsVersionsOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            List listAsList = Arrays.asList(sSLSocket.getSupportedProtocols());
            ArrayList arrayList = new ArrayList();
            if (listAsList.contains("TLSv1.2")) {
                arrayList.add("TLSv1.2");
            }
            if (listAsList.contains("TLSv1.1")) {
                arrayList.add("TLSv1.1");
            }
            if (listAsList.contains("TLSv1")) {
                arrayList.add("TLSv1");
            }
            if (arrayList.size() > 0) {
                sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.defaultSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.defaultSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }
}

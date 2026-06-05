package com.philips.lighting.hue.sdk.upnp;

import com.google.firebase.ai.common.util.KtorKt;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PHUpnpManager {
    private static final int DEFAULT_MX = 3;
    private static final int DEFAULT_SSDP_SEARCH_PORT = 1901;
    private static final int DEFAULT_TIMEOUT = 5000;
    private static final int DEFAULT_TTL = 4;
    private static final int PORT = 1900;
    private static final String SSDP_IP = "239.255.255.250";
    private static final String STRING_ROOT_DEVICE = "upnp:rootdevice";
    private static final String TAG = "PHUpnpManager";
    private DatagramPacket input;
    private boolean isRunning = true;
    private boolean isThreadStopped = false;
    private List<String> recv = new ArrayList();

    public void receive() throws IOException {
        final MulticastSocket multicastSocket = new MulticastSocket((SocketAddress) null);
        multicastSocket.bind(new InetSocketAddress(InetAddress.getByName("0.0.0.0"), DEFAULT_SSDP_SEARCH_PORT));
        multicastSocket.setTimeToLive(4);
        multicastSocket.setSoTimeout(5000);
        multicastSocket.joinGroup(InetAddress.getByName(SSDP_IP));
        this.input = new DatagramPacket(new byte[2048], 2048);
        new Thread() { // from class: com.philips.lighting.hue.sdk.upnp.PHUpnpManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PHUpnpManager.this.isRunning) {
                    PHLog.d(PHUpnpManager.TAG, "Bridge Search is Running ..");
                    try {
                        multicastSocket.receive(PHUpnpManager.this.input);
                        String str = new String(PHUpnpManager.this.input.getData(), PHUpnpManager.this.input.getOffset(), PHUpnpManager.this.input.getLength());
                        PHUpnpManager.this.recv.add(str);
                        PHLog.d(PHUpnpManager.TAG, "Search Response=" + str);
                    } catch (SocketTimeoutException e) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(PHUpnpManager.TAG, "SocketTimeoutException: " + e);
                        }
                    } catch (IOException e2) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(PHUpnpManager.TAG, "SocketTimeoutException: " + e2);
                        }
                    } catch (Exception e3) {
                        if (PHLog.isLoggable()) {
                            PHLog.e(PHUpnpManager.TAG, "SocketTimeoutException: " + e3);
                        }
                        PHUpnpManager.this.isRunning = false;
                    }
                }
                try {
                    multicastSocket.leaveGroup(InetAddress.getByName(PHUpnpManager.SSDP_IP));
                    multicastSocket.close();
                } catch (Exception e4) {
                    if (PHLog.isLoggable()) {
                        PHLog.e(PHUpnpManager.TAG, "SocketTimeoutException: " + e4);
                    }
                }
                PHUpnpManager.this.isThreadStopped = true;
            }
        }.start();
    }

    public void sendMessage(InetAddress inetAddress, int i, int i2, String str) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(SSDP_IP), PORT);
        MulticastSocket multicastSocket = new MulticastSocket((SocketAddress) null);
        multicastSocket.bind(new InetSocketAddress(inetAddress, DEFAULT_SSDP_SEARCH_PORT));
        multicastSocket.setTimeToLive(i);
        StringBuffer stringBuffer = new StringBuffer("M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nST: ");
        stringBuffer.append(str);
        stringBuffer.append("\r\nMAN: \"ssdp:discover\"\r\nMX: ");
        stringBuffer.append(i2);
        stringBuffer.append(KtorKt.SSE_SEPARATOR);
        PHLog.d(TAG, "Discovery Request=239.255.255.250:1900multicast address from ip " + inetAddress.getHostAddress() + ":\n" + stringBuffer.toString());
        byte[] bytes = stringBuffer.toString().getBytes();
        multicastSocket.send(new DatagramPacket(bytes, bytes.length, inetSocketAddress));
        multicastSocket.disconnect();
        multicastSocket.close();
    }

    public List<String> startSearch() {
        try {
            receive();
            startUpnpSendMessage();
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                PHLog.e(TAG, "InterruptedException: " + e);
            }
            this.isRunning = false;
            while (!this.isThreadStopped) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e2) {
                    PHLog.e(TAG, "InterruptedException: " + e2);
                }
            }
            PHLog.d(TAG, "Size of Bridge Search Response" + this.recv.size());
        } catch (Exception e3) {
            if (PHLog.isLoggable()) {
                PHLog.e(TAG, "InterruptedException: " + e3);
            }
        }
        return this.recv;
    }

    public void startUpnpSendMessage() throws IOException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                    sendMessage(inetAddressNextElement, 4, 3, STRING_ROOT_DEVICE);
                }
            }
        }
    }
}

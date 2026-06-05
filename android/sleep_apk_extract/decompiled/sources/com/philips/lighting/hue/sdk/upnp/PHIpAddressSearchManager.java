package com.philips.lighting.hue.sdk.upnp;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class PHIpAddressSearchManager {
    public static final int END_IP_SCAN = 255;
    public static final int START_IP_SCAN = 1;

    public String getHostIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (!networkInterfaceNextElement.isLoopback() && networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.getDisplayName().contains("rmnet")) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (inetAddressNextElement instanceof Inet4Address) {
                            return inetAddressNextElement.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            PHLog.e("PHIpAddressSearchManager", e.getMessage());
            return null;
        }
    }

    public IPAddressScanner getIPAddressScanner(String str) {
        return new IPAddressScanner(str);
    }

    public List<PHAccessPoint> scanIpRange(List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Future> arrayList2 = new ArrayList();
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(100);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Future futureSubmit = executorServiceNewFixedThreadPool.submit(getIPAddressScanner(it.next()));
            if (futureSubmit != null) {
                arrayList2.add(futureSubmit);
            }
        }
        try {
            executorServiceNewFixedThreadPool.shutdown();
            executorServiceNewFixedThreadPool.awaitTermination(15L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        for (Future future : arrayList2) {
            if (future != null) {
                try {
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                } catch (TimeoutException unused2) {
                }
                if (future.get(10L, TimeUnit.MILLISECONDS) != null) {
                    PHAccessPoint pHAccessPoint = new PHAccessPoint();
                    pHAccessPoint.setIpAddress(((PHAccessPoint) future.get()).getIpAddress());
                    pHAccessPoint.setMacAddress(((PHAccessPoint) future.get()).getMacAddress());
                    pHAccessPoint.setBridgeId(((PHAccessPoint) future.get()).getBridgeId());
                    pHAccessPoint.setUsername(((PHAccessPoint) future.get()).getUsername());
                    arrayList.add(pHAccessPoint);
                }
            }
            future.cancel(true);
        }
        return arrayList;
    }

    public List<PHAccessPoint> startIpAddressSearch() {
        String hostIp = getHostIp();
        if (hostIp != null && !hostIp.isEmpty()) {
            String strSubstring = hostIp.substring(0, hostIp.lastIndexOf(46) + 1);
            if (!strSubstring.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 1; i < 255; i++) {
                    arrayList.add(strSubstring + i);
                }
                return scanIpRange(arrayList);
            }
        }
        return new ArrayList();
    }
}

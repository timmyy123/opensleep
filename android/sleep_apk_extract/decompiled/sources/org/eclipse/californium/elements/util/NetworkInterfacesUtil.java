package org.eclipse.californium.elements.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NetworkInterfacesUtil {
    private static boolean anyIpv4;
    private static boolean anyIpv6;
    private static int anyMtu;
    private static Inet4Address broadcastIpv4;
    private static int ipv4Mtu;
    private static int ipv6Mtu;
    private static NetworkInterface multicastInterface;
    private static Inet4Address multicastInterfaceIpv4;
    private static Inet6Address multicastInterfaceIpv6;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) NetworkInterfacesUtil.class);
    private static final Set<InetAddress> broadcastAddresses = new HashSet();

    public static int getIPv4Mtu() {
        initialize();
        return ipv4Mtu;
    }

    public static int getIPv6Mtu() {
        initialize();
        return ipv6Mtu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c6 A[Catch: all -> 0x0028, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x001d, B:10:0x0023, B:15:0x002c, B:18:0x003b, B:20:0x0041, B:22:0x004d, B:25:0x0055, B:31:0x006d, B:35:0x0076, B:37:0x007c, B:39:0x0080, B:41:0x0084, B:45:0x008d, B:50:0x0096, B:51:0x0098, B:53:0x009c, B:54:0x009e, B:55:0x00a7, B:57:0x00ad, B:59:0x00b7, B:61:0x00bb, B:66:0x00c4, B:68:0x00ca, B:72:0x00d3, B:74:0x00d9, B:75:0x00dd, B:77:0x00e1, B:82:0x00ea, B:84:0x00f0, B:86:0x00f7, B:88:0x00fd, B:144:0x01b3, B:90:0x0102, B:91:0x010d, B:93:0x0113, B:95:0x011f, B:97:0x0125, B:99:0x012b, B:101:0x0131, B:103:0x0145, B:113:0x015e, B:116:0x0165, B:120:0x016c, B:111:0x015a, B:108:0x0154, B:121:0x016f, B:122:0x0173, B:124:0x0179, B:126:0x0183, B:130:0x018b, B:132:0x018f, B:145:0x01be, B:147:0x01c6, B:154:0x01da, B:155:0x01de, B:138:0x019c, B:139:0x01a3), top: B:162:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01da A[Catch: all -> 0x0028, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x001d, B:10:0x0023, B:15:0x002c, B:18:0x003b, B:20:0x0041, B:22:0x004d, B:25:0x0055, B:31:0x006d, B:35:0x0076, B:37:0x007c, B:39:0x0080, B:41:0x0084, B:45:0x008d, B:50:0x0096, B:51:0x0098, B:53:0x009c, B:54:0x009e, B:55:0x00a7, B:57:0x00ad, B:59:0x00b7, B:61:0x00bb, B:66:0x00c4, B:68:0x00ca, B:72:0x00d3, B:74:0x00d9, B:75:0x00dd, B:77:0x00e1, B:82:0x00ea, B:84:0x00f0, B:86:0x00f7, B:88:0x00fd, B:144:0x01b3, B:90:0x0102, B:91:0x010d, B:93:0x0113, B:95:0x011f, B:97:0x0125, B:99:0x012b, B:101:0x0131, B:103:0x0145, B:113:0x015e, B:116:0x0165, B:120:0x016c, B:111:0x015a, B:108:0x0154, B:121:0x016f, B:122:0x0173, B:124:0x0179, B:126:0x0183, B:130:0x018b, B:132:0x018f, B:145:0x01be, B:147:0x01c6, B:154:0x01da, B:155:0x01de, B:138:0x019c, B:139:0x01a3), top: B:162:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void initialize() {
        boolean z;
        int iMin;
        int i;
        int i2;
        Enumeration<NetworkInterface> networkInterfaces;
        Inet4Address inet4Address;
        Iterator<InterfaceAddress> it;
        InetAddress address;
        if (anyMtu == 0) {
            broadcastAddresses.clear();
            Inet4Address inet4Address2 = null;
            broadcastIpv4 = null;
            multicastInterfaceIpv4 = null;
            multicastInterfaceIpv6 = null;
            multicastInterface = null;
            String configuration = StringUtil.getConfiguration("COAP_NETWORK_INTERFACES");
            Pattern patternCompile = (configuration == null || configuration.isEmpty()) ? null : Pattern.compile(configuration);
            try {
                networkInterfaces = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException e) {
                e = e;
                z = true;
            }
            if (networkInterfaces == null) {
                z = true;
                try {
                    throw new SocketException("Network interfaces not available!");
                } catch (SocketException e2) {
                    e = e2;
                    iMin = 65535;
                    i = 65535;
                    i2 = 65535;
                    LOGGER.warn("discover the <any> interface failed!", (Throwable) e);
                    anyIpv4 = z;
                    anyIpv6 = z;
                    if (broadcastAddresses.isEmpty()) {
                    }
                    if (i == 65535) {
                    }
                    if (i2 == 65535) {
                    }
                    if (iMin == 65535) {
                    }
                    ipv4Mtu = i;
                    ipv6Mtu = i2;
                    anyMtu = iMin;
                }
            }
            iMin = 65535;
            i = 65535;
            i2 = 65535;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback() && (patternCompile == null || patternCompile.matcher(networkInterfaceNextElement.getName()).matches())) {
                        int mtu = networkInterfaceNextElement.getMTU();
                        if (mtu > 0 && mtu < iMin) {
                            iMin = mtu;
                        }
                        if (networkInterfaceNextElement.supportsMulticast() && ((inet4Address = multicastInterfaceIpv4) == null || multicastInterfaceIpv6 == null || broadcastIpv4 == null)) {
                            int i3 = broadcastIpv4 != null ? -1 : 0;
                            if (inet4Address != null) {
                                i3--;
                            }
                            if (multicastInterfaceIpv6 != null) {
                                i3--;
                            }
                            Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                            Inet4Address inet4Address3 = inet4Address2;
                            Inet4Address inet4Address4 = inet4Address3;
                            InetAddress inetAddress = inet4Address4;
                            InetAddress inetAddress2 = inetAddress;
                            InetAddress inetAddress3 = inetAddress;
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                                z = true;
                                try {
                                    if (inetAddressNextElement instanceof Inet4Address) {
                                        anyIpv4 = true;
                                        if (mtu > 0 && mtu < i) {
                                            i = mtu;
                                        }
                                        if (inet4Address3 == null) {
                                            if (inetAddressNextElement.isSiteLocalAddress()) {
                                                inet4Address3 = (Inet4Address) inetAddressNextElement;
                                            } else if (inet4Address4 == null && inetAddressNextElement.isLinkLocalAddress()) {
                                                inet4Address4 = (Inet4Address) inetAddressNextElement;
                                            }
                                        }
                                    } else if (inetAddressNextElement instanceof Inet6Address) {
                                        anyIpv6 = true;
                                        if (mtu > 0 && mtu < i2) {
                                            i2 = mtu;
                                        }
                                        if (inetAddress2 == null) {
                                            if (inetAddressNextElement.isSiteLocalAddress()) {
                                                inetAddress2 = (Inet6Address) inetAddressNextElement;
                                            } else if (inet4Address4 == null && inetAddressNextElement.isLinkLocalAddress()) {
                                                inetAddress3 = (Inet6Address) inetAddressNextElement;
                                            }
                                        }
                                    }
                                    inetAddress3 = inetAddress3;
                                    inetAddress2 = inetAddress2;
                                } catch (SocketException e3) {
                                    e = e3;
                                    LOGGER.warn("discover the <any> interface failed!", (Throwable) e);
                                    anyIpv4 = z;
                                    anyIpv6 = z;
                                    if (broadcastAddresses.isEmpty()) {
                                    }
                                    if (i == 65535) {
                                    }
                                    if (i2 == 65535) {
                                    }
                                    if (iMin == 65535) {
                                    }
                                    ipv4Mtu = i;
                                    ipv6Mtu = i2;
                                    anyMtu = iMin;
                                }
                            }
                            Iterator<InterfaceAddress> it2 = networkInterfaceNextElement.getInterfaceAddresses().iterator();
                            Inet4Address inet4Address5 = null;
                            while (it2.hasNext()) {
                                InterfaceAddress next = it2.next();
                                InetAddress broadcast = next.getBroadcast();
                                if (broadcast == null || broadcast.isAnyLocalAddress() || (address = next.getAddress()) == null || address.equals(broadcast)) {
                                    it = it2;
                                } else {
                                    broadcastAddresses.add(broadcast);
                                    it = it2;
                                    LOGGER.debug("Found broadcast address {} - {}.", broadcast, networkInterfaceNextElement.getName());
                                    if (inet4Address5 == null) {
                                        inet4Address5 = (Inet4Address) broadcast;
                                        i3++;
                                    }
                                }
                                it2 = it;
                            }
                            if (inet4Address4 != null || inet4Address3 != null) {
                                i3++;
                            }
                            if (inetAddress3 != null || inetAddress2 != null) {
                                i3++;
                            }
                            if (i3 > 0) {
                                multicastInterface = networkInterfaceNextElement;
                                broadcastIpv4 = inet4Address5;
                                if (inet4Address3 == null) {
                                    inet4Address3 = inet4Address4;
                                }
                                multicastInterfaceIpv4 = inet4Address3;
                                multicastInterfaceIpv6 = inetAddress2 == null ? inetAddress3 : inetAddress2;
                            }
                        } else {
                            Enumeration<InetAddress> inetAddresses2 = networkInterfaceNextElement.getInetAddresses();
                            while (inetAddresses2.hasMoreElements()) {
                                InetAddress inetAddressNextElement2 = inetAddresses2.nextElement();
                                if (inetAddressNextElement2 instanceof Inet4Address) {
                                    anyIpv4 = true;
                                    if (mtu > 0 && mtu < i) {
                                        i = mtu;
                                    }
                                } else if (inetAddressNextElement2 instanceof Inet6Address) {
                                    anyIpv6 = true;
                                    if (mtu > 0 && mtu < i2) {
                                        i2 = mtu;
                                    }
                                }
                            }
                        }
                    }
                    inet4Address2 = null;
                } catch (SocketException e4) {
                    e = e4;
                    z = true;
                }
            }
            if (broadcastAddresses.isEmpty()) {
                LOGGER.info("no broadcast address found!");
            }
            if (i == 65535) {
                i = 576;
            }
            if (i2 == 65535) {
                i2 = 1280;
            }
            if (iMin == 65535) {
                iMin = Math.min(i, i2);
            }
            ipv4Mtu = i;
            ipv6Mtu = i2;
            anyMtu = iMin;
        }
    }

    public static boolean isMultiAddress(InetAddress inetAddress) {
        initialize();
        if (inetAddress != null) {
            return inetAddress.isMulticastAddress() || broadcastAddresses.contains(inetAddress);
        }
        return false;
    }
}

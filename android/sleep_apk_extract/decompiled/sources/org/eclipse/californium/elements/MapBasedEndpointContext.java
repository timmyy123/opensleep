package org.eclipse.californium.elements;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.net.InetSocketAddress;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class MapBasedEndpointContext extends AddressEndpointContext {
    private final Map<String, String> entries;
    private final boolean hasCriticalEntries;

    public MapBasedEndpointContext(InetSocketAddress inetSocketAddress, String str, Principal principal, Map<String, String> map) {
        super(inetSocketAddress, str, principal);
        if (map == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("missing attributes map, must not be null!");
            throw null;
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap(map));
        this.entries = mapUnmodifiableMap;
        this.hasCriticalEntries = findCriticalEntries(mapUnmodifiableMap);
    }

    public static MapBasedEndpointContext addEntries(EndpointContext endpointContext, String... strArr) {
        Map<String, String> mapCreateMap = createMap(strArr);
        HashMap map = new HashMap(endpointContext.entries());
        map.putAll(mapCreateMap);
        return new MapBasedEndpointContext(endpointContext.getPeerAddress(), endpointContext.getVirtualHost(), endpointContext.getPeerIdentity(), map);
    }

    private static final Map<String, String> createMap(String... strArr) {
        if (strArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("attributes must not null!");
            return null;
        }
        if ((strArr.length & 1) != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(strArr.length, "!", new StringBuilder("number of attributes must be even, not ")));
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            int i2 = i + 1;
            String str2 = strArr[i2];
            if (str == null) {
                throw new NullPointerException((i2 / 2) + ". key is null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException((i2 / 2) + ". key is empty");
            }
            if (str2 == null) {
                if (!str.startsWith("*")) {
                    throw new NullPointerException((i2 / 2) + ". value is null");
                }
            } else if (((String) map.put(str, str2)) != null) {
                throw new IllegalArgumentException((i2 / 2) + ". key '" + str + "' is provided twice");
            }
        }
        return map;
    }

    private static final boolean findCriticalEntries(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!it.next().startsWith("*")) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.californium.elements.AddressEndpointContext, org.eclipse.californium.elements.EndpointContext
    public Map<String, String> entries() {
        return this.entries;
    }

    @Override // org.eclipse.californium.elements.AddressEndpointContext, org.eclipse.californium.elements.EndpointContext
    public String get(String str) {
        return this.entries.get(str);
    }

    @Override // org.eclipse.californium.elements.AddressEndpointContext, org.eclipse.californium.elements.EndpointContext
    public boolean hasCriticalEntries() {
        return this.hasCriticalEntries;
    }

    @Override // org.eclipse.californium.elements.AddressEndpointContext
    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("MAP(", getPeerAddressAsString(), ")");
    }

    public MapBasedEndpointContext(InetSocketAddress inetSocketAddress, String str, Principal principal, String... strArr) {
        this(inetSocketAddress, str, principal, createMap(strArr));
    }

    public MapBasedEndpointContext(InetSocketAddress inetSocketAddress, Principal principal, String... strArr) {
        this(inetSocketAddress, (String) null, principal, strArr);
    }
}

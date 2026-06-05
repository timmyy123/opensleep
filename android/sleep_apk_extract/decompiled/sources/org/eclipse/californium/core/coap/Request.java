package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.NetworkInterfacesUtil;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Request extends Message {
    private static final Pattern IP_PATTERN = Pattern.compile("(\\[[0-9a-fA-F:]+(%\\w+)?\\]|[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private final CoAP.Code code;

    @Deprecated
    private InetAddress destination;

    @Deprecated
    private int destinationPort;
    private boolean multicast;
    private boolean proxyUri;
    private boolean ready;
    private Response response;
    private volatile Throwable responseHandlingError;
    private String scheme;
    private boolean uri;
    private Map<String, String> userContext;

    public Request(CoAP.Code code) {
        this(code, CoAP.Type.CON);
    }

    private void checkURI(URI uri) {
        if (this.proxyUri) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Proxy URI is set!");
            return;
        }
        if (uri == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("URI must not be null");
            return;
        }
        if (!CoAP.isSupportedScheme(uri.getScheme())) {
            Gson$$ExternalSyntheticBUOutline0.m("URI scheme '", uri.getScheme(), "' is not supported!");
            return;
        }
        if (uri.getFragment() != null) {
            Gson$$ExternalSyntheticBUOutline0.m("URI must not contain a fragment '", uri.getFragment(), "'!");
        } else {
            if (uri.getSchemeSpecificPart() == null || uri.getHost() != null) {
                return;
            }
            Gson$$ExternalSyntheticBUOutline0.m("URI expected host '", uri.getSchemeSpecificPart(), "' is invalid!");
        }
    }

    private final boolean isObserveOption(int i) {
        Integer observe = getOptions().getObserve();
        return observe != null && observe.intValue() == i;
    }

    public static Request newGet() {
        return new Request(CoAP.Code.GET);
    }

    public static Request newPost() {
        return new Request(CoAP.Code.POST);
    }

    public static Request newPut() {
        return new Request(CoAP.Code.PUT);
    }

    private void setOptionsInternal(URI uri, InetSocketAddress inetSocketAddress, boolean z) {
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("destination address must not be null!");
            return;
        }
        OptionSet options = getOptions();
        boolean zHasExplicitUriOptions = options.hasExplicitUriOptions();
        String host = uri.getHost();
        if (host != null) {
            if (z) {
                try {
                    if (InetAddress.getByName(host).equals(inetSocketAddress.getAddress())) {
                        host = null;
                    }
                } catch (UnknownHostException unused) {
                    Message.LOGGER.warn("could not parse IP address of URI despite successful IP address pattern matching");
                }
            } else if (!StringUtil.isValidHostName(host)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("URI's hostname '", host, "' is invalid!'"));
                return;
            }
            if (host != null) {
                options.setUriHost(host.toLowerCase());
            }
        }
        if (host == null) {
            options.removeUriHost();
        }
        int port = uri.getPort();
        if (port <= 0) {
            port = CoAP.getDefaultPort(uri.getScheme());
        }
        if (port == inetSocketAddress.getPort()) {
            port = -1;
        }
        if (port > 0) {
            options.setUriPort(port);
        } else {
            options.removeUriPort();
        }
        String path = uri.getPath();
        if (path != null && path.length() > 1) {
            options.setUriPath(path);
        } else if (!zHasExplicitUriOptions) {
            options.clearUriPath();
        }
        String query = uri.getQuery();
        if (query != null) {
            options.setUriQuery(query);
        } else if (!zHasExplicitUriOptions) {
            options.clearUriQuery();
        }
        if (zHasExplicitUriOptions) {
            return;
        }
        options.resetExplicitUriOptions();
    }

    public CoAP.Code getCode() {
        return this.code;
    }

    @Deprecated
    public InetAddress getDestination() {
        EndpointContext destinationContext = getDestinationContext();
        return destinationContext != null ? destinationContext.getPeerAddress().getAddress() : this.destination;
    }

    @Deprecated
    public int getDestinationPort() {
        EndpointContext destinationContext = getDestinationContext();
        return destinationContext != null ? destinationContext.getPeerAddress().getPort() : this.destinationPort;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public int getRawCode() {
        CoAP.Code code = this.code;
        if (code == null) {
            return 0;
        }
        return code.value;
    }

    public String getScheme() {
        String str = this.scheme;
        return str == null ? "coap" : str;
    }

    public String getURI() {
        Integer num = -1;
        OptionSet options = getOptions();
        String uriHost = options.getUriHost();
        Integer uriPort = options.getUriPort();
        if (uriHost == null) {
            uriHost = getDestination() != null ? getDestination().getHostAddress() : "localhost";
        }
        String str = uriHost;
        if (uriPort == null) {
            uriPort = Integer.valueOf(getDestinationPort());
        }
        if (uriPort.intValue() > 0 && (!CoAP.isSupportedScheme(getScheme()) || CoAP.getDefaultPort(getScheme()) != uriPort.intValue())) {
            num = uriPort;
        }
        try {
            return new URI(getScheme(), null, str, num.intValue(), MqttTopic.TOPIC_LEVEL_SEPARATOR + options.getUriPathString(), options.getURIQueryCount() > 0 ? options.getUriQueryString() : null, null).toASCIIString();
        } catch (URISyntaxException e) {
            Types$$ExternalSyntheticBUOutline0.m("cannot create URI from request", e);
            return null;
        }
    }

    public Map<String, String> getUserContext() {
        return this.userContext;
    }

    public boolean hasProxyURI() {
        return this.proxyUri;
    }

    public boolean hasURI() {
        return this.uri;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public boolean isIntendedPayload() {
        CoAP.Code code = this.code;
        return (code == CoAP.Code.GET || code == CoAP.Code.DELETE) ? false : true;
    }

    public boolean isMulticast() {
        return this.multicast;
    }

    public final boolean isObserve() {
        return isObserveOption(0);
    }

    public final boolean isObserveCancel() {
        return isObserveOption(1);
    }

    @Deprecated
    public void prepareDestinationContext() {
        EndpointContext destinationContext = getDestinationContext();
        if (destinationContext == null) {
            if (this.destination == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("missing destination!");
                return;
            } else {
                destinationContext = new AddressEndpointContext(new InetSocketAddress(this.destination, this.destinationPort), getOptions().getUriHost(), null);
                super.setDestinationContext(destinationContext);
            }
        }
        this.multicast = NetworkInterfacesUtil.isMultiAddress(destinationContext.getPeerAddress().getAddress());
    }

    @Override // org.eclipse.californium.core.coap.Message
    public void setCanceled(boolean z) {
        super.setCanceled(z);
        if (z) {
            synchronized (this) {
                this.ready = true;
                notifyAll();
            }
        }
    }

    @Override // org.eclipse.californium.core.coap.Message
    public Request setDestinationContext(EndpointContext endpointContext) {
        InetAddress inetAddress = this.destination;
        if (inetAddress != null && !inetAddress.equals(endpointContext.getPeerAddress().getAddress())) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("different destination!");
            return null;
        }
        super.setRequestDestinationContext(endpointContext);
        this.multicast = (endpointContext == null || endpointContext.getPeerAddress().isUnresolved() || !NetworkInterfacesUtil.isMultiAddress(endpointContext.getPeerAddress().getAddress())) ? false : true;
        return this;
    }

    public void setOnResponseError(Throwable th) {
        this.responseHandlingError = th;
        if (this.responseHandlingError != null) {
            for (MessageObserver messageObserver : getMessageObservers()) {
                if (messageObserver instanceof MessageObserver2) {
                    ((MessageObserver2) messageObserver).onResponseHandlingError(this.responseHandlingError);
                }
            }
            synchronized (this) {
                this.ready = true;
                notifyAll();
            }
        }
    }

    @Override // org.eclipse.californium.core.coap.Message
    public void setRejected(boolean z) {
        super.setRejected(z);
        if (z) {
            synchronized (this) {
                this.ready = true;
                notifyAll();
            }
        }
    }

    public void setResponse(Response response) {
        synchronized (this) {
            this.response = response;
            notifyAll();
        }
        Iterator<MessageObserver> it = getMessageObservers().iterator();
        while (it.hasNext()) {
            it.next().onResponse(response);
        }
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public void setSendError(Throwable th) {
        super.setSendError(th);
        if (th != null) {
            synchronized (this) {
                this.ready = true;
                notifyAll();
            }
        }
    }

    @Override // org.eclipse.californium.core.coap.Message
    public void setTimedOut(boolean z) {
        super.setTimedOut(z);
        if (z) {
            synchronized (this) {
                this.ready = true;
                notifyAll();
            }
        }
    }

    public Request setURI(URI uri) {
        InetSocketAddress peerAddress;
        checkURI(uri);
        String host = uri.getHost() == null ? "localhost" : uri.getHost();
        String scheme = uri.getScheme();
        boolean zMatches = IP_PATTERN.matcher(host).matches();
        try {
            EndpointContext destinationContext = getDestinationContext();
            if (destinationContext == null) {
                int port = uri.getPort();
                InetAddress byName = InetAddress.getByName(host);
                String str = zMatches ? null : host;
                if (port <= 0) {
                    port = CoAP.getDefaultPort(scheme);
                }
                peerAddress = new InetSocketAddress(byName, port);
                destinationContext = new AddressEndpointContext(peerAddress, str, null);
            } else {
                peerAddress = destinationContext.getPeerAddress();
            }
            setOptionsInternal(uri, peerAddress, zMatches);
            setDestinationContext(destinationContext);
            this.scheme = scheme.toLowerCase();
            this.uri = true;
            return this;
        } catch (UnknownHostException unused) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("cannot resolve host name: ", host));
            return null;
        }
    }

    public Request setUserContext(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            this.userContext = Collections.EMPTY_MAP;
            return this;
        }
        this.userContext = Collections.unmodifiableMap(new HashMap(map));
        return this;
    }

    public String toString() {
        CoAP.Code code = getCode();
        return toTracingString(code == null ? "PING" : code.toString());
    }

    public Response waitForResponse(long j) {
        Response response;
        long nanos = TimeUnit.MILLISECONDS.toNanos(j) + ClockUtil.nanoRealtime();
        synchronized (this) {
            long j2 = j;
            while (!this.ready && this.response == null) {
                try {
                    wait(j2);
                    if (j > 0) {
                        long jNanoRealtime = nanos - ClockUtil.nanoRealtime();
                        if (jNanoRealtime <= 0) {
                            break;
                        }
                        j2 = (jNanoRealtime / 1000000) + 1;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            response = this.response;
            this.response = null;
        }
        return response;
    }

    public Request(CoAP.Code code, CoAP.Type type) {
        super(type);
        this.code = code;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public Request setPayload(String str) {
        super.setPayload(str);
        return this;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public Request setPayload(byte[] bArr) {
        super.setPayload(bArr);
        return this;
    }

    public Request setURI(String str) {
        String strConcat;
        if (str != null) {
            try {
                if (str.contains("://")) {
                    strConcat = str;
                } else {
                    strConcat = "coap://".concat(str);
                    Message.LOGGER.warn("update your code to supply an RFC 7252 compliant URI including a scheme");
                }
                return setURI(new URI(strConcat));
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("invalid uri: ".concat(str), e);
            }
        }
        Types$$ExternalSyntheticBUOutline0.m$1("URI must not be null");
        return null;
    }
}

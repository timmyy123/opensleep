package io.github.zeroone3010.yahueapi.discovery;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.zeroone3010.yahueapi.HueBridge;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
final class NUPnPDiscoverer implements HueBridgeDiscoverer {
    private static final String CONNECT_TIMEOUT_VARIABLE = "sun.net.client.defaultConnectTimeout";
    private static final String DEFAULT_TIMEOUT_MILLISECONDS = "4000";
    private static final String HUE_DISCOVERY_PORTAL = "https://discovery.meethue.com/";
    private static final String READ_TIMEOUT_VARIABLE = "sun.net.client.defaultReadTimeout";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NUPnPDiscoverer.class);
    private final Consumer<HueBridge> discoverer;
    private final String discoveryPortalUrl;

    /* JADX INFO: loaded from: classes3.dex */
    public static class NUPnPDeserializer extends StdDeserializer<HueBridge> {
        public NUPnPDeserializer() {
            super((Class<?>) HueBridge.class);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public HueBridge deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new HueBridge(((JsonNode) jsonParser.getCodec().readTree(jsonParser)).get("internalipaddress").textValue());
        }
    }

    public NUPnPDiscoverer(String str, Consumer<HueBridge> consumer) {
        this.discoveryPortalUrl = str;
        this.discoverer = consumer;
        if (toInt(System.getProperty(CONNECT_TIMEOUT_VARIABLE)) < 1) {
            System.setProperty(CONNECT_TIMEOUT_VARIABLE, DEFAULT_TIMEOUT_MILLISECONDS);
        }
        if (toInt(System.getProperty(READ_TIMEOUT_VARIABLE)) < 1) {
            System.setProperty(READ_TIMEOUT_VARIABLE, DEFAULT_TIMEOUT_MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$discoverBridges$0(ObjectMapper objectMapper, URL url) {
        try {
            Logger logger2 = logger;
            logger2.debug("Discovering Bridges using the Philips Hue Portal.");
            List list = (List) objectMapper.readValue(url, new TypeReference<ArrayList<HueBridge>>() { // from class: io.github.zeroone3010.yahueapi.discovery.NUPnPDiscoverer.1
            });
            logger2.info("{} Bridges found using the portal.", Integer.valueOf(list.size()));
            list.forEach(this.discoverer);
            return null;
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    private static int toInt(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            logger.warn("'{}' is not a valid timeout value", str);
            return -1;
        }
    }

    @Override // io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoverer
    public CompletableFuture<Void> discoverBridges() {
        try {
            final URL url = new URL(this.discoveryPortalUrl);
            final ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addDeserializer(HueBridge.class, new NUPnPDeserializer());
            objectMapper.registerModule(simpleModule);
            return CompletableFuture.supplyAsync(new Supplier() { // from class: io.github.zeroone3010.yahueapi.discovery.NUPnPDiscoverer$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$discoverBridges$0(objectMapper, url);
                }
            });
        } catch (MalformedURLException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public NUPnPDiscoverer(Consumer<HueBridge> consumer) {
        this(HUE_DISCOVERY_PORTAL, consumer);
    }
}

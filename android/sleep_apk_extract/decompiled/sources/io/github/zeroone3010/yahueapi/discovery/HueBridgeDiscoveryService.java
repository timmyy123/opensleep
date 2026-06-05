package io.github.zeroone3010.yahueapi.discovery;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.util.Log;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.HueBridge;
import io.github.zeroone3010.yahueapi.SecureJsonFactory;
import io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService;
import io.github.zeroone3010.yahueapi.v2.domain.BridgeConfig;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes5.dex */
public final class HueBridgeDiscoveryService {
    public static String TAG = "SmartLight yaHUE";

    public enum DiscoveryMethod {
        NUPNP(new HueBridgeDiscoveryService$$ExternalSyntheticLambda6(1)),
        MDNS(new HueBridgeDiscoveryService$$ExternalSyntheticLambda6(2));

        private final Function<Consumer<HueBridge>, HueBridgeDiscoverer> discovererCreator;

        DiscoveryMethod(Function function) {
            this.discovererCreator = function;
        }

        public Function<Consumer<HueBridge>, HueBridgeDiscoverer> getDiscovererCreator() {
            return this.discovererCreator;
        }
    }

    private BridgeConfig fetchBridgeConfiguration(ObjectMapper objectMapper, String str) {
        try {
            Log.i(TAG, "URL " + str + ": ");
            return (BridgeConfig) objectMapper.readValue(new URL("https://" + str + "/api/config"), BridgeConfig.class);
        } catch (IOException e) {
            Log.e(TAG, "yaHUE Unable to connect to a found Bridge at " + str + ": " + e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$discoverBridges$0(Collection collection, ObjectMapper objectMapper, Collection collection2, Consumer consumer, HueBridge hueBridge) {
        boolean zAdd;
        String ip = hueBridge.getIp();
        synchronized (collection) {
            zAdd = collection.add(ip);
        }
        if (zAdd) {
            BridgeConfig bridgeConfigFetchBridgeConfiguration = fetchBridgeConfiguration(objectMapper, ip);
            Log.i(TAG, "Config " + ip + ": " + bridgeConfigFetchBridgeConfiguration);
            if (bridgeConfigFetchBridgeConfiguration != null) {
                if ("BSB003".equals(bridgeConfigFetchBridgeConfiguration.getModelid())) {
                    HueBridge hueBridge2 = new HueBridge(ip, bridgeConfigFetchBridgeConfiguration.getName(), bridgeConfigFetchBridgeConfiguration.getMac());
                    synchronized (collection2) {
                        collection2.add(hueBridge2);
                    }
                    consumer.accept(hueBridge2);
                    return;
                }
                String str = TAG;
                StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Ignoring config for model ", ip, ": ");
                sbM5m.append(bridgeConfigFetchBridgeConfiguration.getModelid());
                Log.i(str, sbM5m.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HueBridgeDiscoverer lambda$discoverBridges$1(Consumer consumer, Function function) {
        return (HueBridgeDiscoverer) function.apply(consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletableFuture[] lambda$discoverBridges$2(int i) {
        return new CompletableFuture[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$discoverBridges$3(Collection collection, Void r1) {
        return new ArrayList(collection);
    }

    private List<DiscoveryMethod> parseMethods(DiscoveryMethod[] discoveryMethodArr) {
        final ArrayList arrayList = new ArrayList();
        if (discoveryMethodArr != null && discoveryMethodArr.length != 0) {
            final int i = 0;
            if (!Stream.of((Object[]) discoveryMethodArr).allMatch(new Predicate() { // from class: io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    HueBridgeDiscoveryService.DiscoveryMethod discoveryMethod = (HueBridgeDiscoveryService.DiscoveryMethod) obj;
                    switch (i) {
                        case 0:
                            return Objects.isNull(discoveryMethod);
                        default:
                            return Objects.nonNull(discoveryMethod);
                    }
                }
            })) {
                final int i2 = 1;
                Stream.of((Object[]) discoveryMethodArr).filter(new Predicate() { // from class: io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService$$ExternalSyntheticLambda0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        HueBridgeDiscoveryService.DiscoveryMethod discoveryMethod = (HueBridgeDiscoveryService.DiscoveryMethod) obj;
                        switch (i2) {
                            case 0:
                                return Objects.isNull(discoveryMethod);
                            default:
                                return Objects.nonNull(discoveryMethod);
                        }
                    }
                }).forEach(new Consumer() { // from class: io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService$$ExternalSyntheticLambda2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        arrayList.add((HueBridgeDiscoveryService.DiscoveryMethod) obj);
                    }
                });
                return arrayList;
            }
        }
        arrayList.addAll(Arrays.asList(DiscoveryMethod.values()));
        return arrayList;
    }

    public Future<List<HueBridge>> discoverBridges(final Consumer<HueBridge> consumer, DiscoveryMethod... discoveryMethodArr) {
        final ObjectMapper codec = new SecureJsonFactory(null).getCodec();
        final int i = 0;
        codec.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final Consumer consumer2 = new Consumer() { // from class: io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$discoverBridges$0(hashSet2, codec, hashSet, consumer, (HueBridge) obj);
            }
        };
        CompletableFuture<Void> completableFutureAllOf = CompletableFuture.allOf((CompletableFuture[]) parseMethods(discoveryMethodArr).stream().map(new HueBridgeDiscoveryService$$ExternalSyntheticLambda6(3)).map(new Function() { // from class: io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i2 = i;
                Object obj2 = consumer2;
                switch (i2) {
                    case 0:
                        return HueBridgeDiscoveryService.lambda$discoverBridges$1((HueBridgeDiscoveryService$$ExternalSyntheticLambda3) obj2, (Function) obj);
                    default:
                        return HueBridgeDiscoveryService.lambda$discoverBridges$3((HashSet) obj2, (Void) obj);
                }
            }
        }).map(new HueBridgeDiscoveryService$$ExternalSyntheticLambda6(i)).toArray(new HueBridgeDiscoveryService$$ExternalSyntheticLambda7()));
        final int i2 = 1;
        return completableFutureAllOf.thenApply(new Function() { // from class: io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i22 = i2;
                Object obj2 = hashSet;
                switch (i22) {
                    case 0:
                        return HueBridgeDiscoveryService.lambda$discoverBridges$1((HueBridgeDiscoveryService$$ExternalSyntheticLambda3) obj2, (Function) obj);
                    default:
                        return HueBridgeDiscoveryService.lambda$discoverBridges$3((HashSet) obj2, (Void) obj);
                }
            }
        });
    }
}

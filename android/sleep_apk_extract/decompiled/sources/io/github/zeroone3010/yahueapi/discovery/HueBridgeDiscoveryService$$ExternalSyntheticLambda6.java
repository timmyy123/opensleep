package io.github.zeroone3010.yahueapi.discovery;

import io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class HueBridgeDiscoveryService$$ExternalSyntheticLambda6 implements Function {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ HueBridgeDiscoveryService$$ExternalSyntheticLambda6(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return ((HueBridgeDiscoverer) obj).discoverBridges();
            case 1:
                return new NUPnPDiscoverer((Consumer) obj);
            case 2:
                return new MDNSDiscoverer((Consumer) obj);
            default:
                return ((HueBridgeDiscoveryService.DiscoveryMethod) obj).getDiscovererCreator();
        }
    }
}

package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.HueBridgeConnectionBuilder;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Hue$$ExternalSyntheticLambda43 implements Supplier {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Hue$$ExternalSyntheticLambda43(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return ((Hue) obj).lambda$searchForNewLights$34();
            default:
                return ((HueBridgeConnectionBuilder) obj).lambda$isHueBridgeEndpoint$0();
        }
    }
}

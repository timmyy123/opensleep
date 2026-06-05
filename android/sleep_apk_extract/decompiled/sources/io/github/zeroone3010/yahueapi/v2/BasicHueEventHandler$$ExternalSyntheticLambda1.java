package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.HueEvent;
import io.github.zeroone3010.yahueapi.v2.domain.HueEventData;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BasicHueEventHandler$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BasicHueEventHandler f$0;
    public final /* synthetic */ HueEvent f$1;

    public /* synthetic */ BasicHueEventHandler$$ExternalSyntheticLambda1(BasicHueEventHandler basicHueEventHandler, HueEvent hueEvent, int i) {
        this.$r8$classId = i;
        this.f$0 = basicHueEventHandler;
        this.f$1 = hueEvent;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        HueEvent hueEvent = this.f$1;
        BasicHueEventHandler basicHueEventHandler = this.f$0;
        HueEventData hueEventData = (HueEventData) obj;
        switch (i) {
            case 0:
                return basicHueEventHandler.lambda$parseAndAnnounceButtonEvents$1(hueEvent, hueEventData);
            default:
                return basicHueEventHandler.lambda$parseAndAnnounceButtonEvents$4(hueEvent, hueEventData);
        }
    }
}

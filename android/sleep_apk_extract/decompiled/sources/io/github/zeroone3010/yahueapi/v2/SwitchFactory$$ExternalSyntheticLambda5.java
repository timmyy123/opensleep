package io.github.zeroone3010.yahueapi.v2;

import com.polar.androidcommunications.api.ble.model.DisInfo;
import io.reactivex.rxjava3.core.FlowableEmitter;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SwitchFactory$$ExternalSyntheticLambda5 implements Consumer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SwitchFactory$$ExternalSyntheticLambda5(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                SwitchFactory.lambda$buildSwitch$3((SwitchImpl) obj2, (Button) obj);
                break;
            default:
                ((FlowableEmitter) obj2).onNext((DisInfo) obj);
                break;
        }
    }
}

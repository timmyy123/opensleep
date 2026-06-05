package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.HueBridgeConnectionBuilder;
import java.io.Serializable;
import java.net.URL;
import java.util.UUID;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LightFactory$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Serializable f$1;

    public /* synthetic */ LightFactory$$ExternalSyntheticLambda1(Object obj, Serializable serializable, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = serializable;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.$r8$classId;
        Serializable serializable = this.f$1;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return ((LightFactory) obj).lambda$createStateProvider$0((URL) serializable);
            case 1:
                return ((HueBridgeConnectionBuilder) obj).lambda$initializeApiConnection$1((String) serializable);
            case 2:
                return ((GroupFactory) obj).lambda$sceneStateSetter$12((UUID) serializable);
            case 3:
                return ((MotionSensorFactory) obj).lambda$createStateProvider$1((URL) serializable);
            case 4:
                return ((SwitchFactory) obj).lambda$createButtonStateProvider$4((UUID) serializable);
            default:
                return ((TemperatureSensorFactory) obj).lambda$createStateProvider$1((URL) serializable);
        }
    }
}

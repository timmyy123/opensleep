package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import java.net.URL;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Hue$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Hue$$ExternalSyntheticLambda2(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return ((Hue) obj3).lambda$refresh$9((List) obj2, (DeviceResource) obj);
            default:
                return ((LightFactory) obj3).lambda$stateSetter$1((URL) obj2, (UpdateLight) obj);
        }
    }
}

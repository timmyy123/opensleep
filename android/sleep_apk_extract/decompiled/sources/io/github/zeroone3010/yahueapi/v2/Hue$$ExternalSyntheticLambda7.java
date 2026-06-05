package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.GroupResource;
import io.github.zeroone3010.yahueapi.v2.domain.LightResource;
import java.net.URL;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Hue$$ExternalSyntheticLambda7 implements Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Hue f$0;

    public /* synthetic */ Hue$$ExternalSyntheticLambda7(Hue hue, int i) {
        this.$r8$classId = i;
        this.f$0 = hue;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        Hue hue = this.f$0;
        switch (i) {
            case 0:
                return hue.lambda$refresh$13((DeviceResource) obj);
            case 1:
                return hue.getResource((UUID) obj);
            case 2:
                return hue.getUrlConnection((URL) obj);
            case 3:
                return hue.lambda$refresh$17((DeviceResource) obj);
            case 4:
                return hue.buildGroup((GroupResource) obj);
            default:
                return hue.buildLight((LightResource) obj);
        }
    }
}

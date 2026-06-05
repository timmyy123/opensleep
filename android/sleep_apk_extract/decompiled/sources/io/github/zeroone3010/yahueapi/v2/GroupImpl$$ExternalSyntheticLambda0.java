package io.github.zeroone3010.yahueapi.v2;

import com.polar.androidcommunications.api.ble.model.DisInfo;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import io.github.zeroone3010.yahueapi.v2.domain.GroupResource;
import io.github.zeroone3010.yahueapi.v2.domain.SceneResource;
import java.util.UUID;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GroupImpl$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ GroupImpl$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return GroupImpl.lambda$removeLight$2((Light) obj2, (Light) obj);
            case 1:
                return BleDisClient.lambda$processServiceData$1((UUID) obj2, (DisInfo) obj);
            default:
                return GroupFactory.lambda$buildGroup$10((GroupResource) obj2, (SceneResource) obj);
        }
    }
}

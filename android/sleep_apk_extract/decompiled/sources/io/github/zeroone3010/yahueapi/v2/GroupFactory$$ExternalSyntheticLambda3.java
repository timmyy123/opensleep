package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.GroupResource;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import java.util.Collection;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GroupFactory$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GroupFactory f$0;
    public final /* synthetic */ GroupResource f$1;

    public /* synthetic */ GroupFactory$$ExternalSyntheticLambda3(GroupFactory groupFactory, GroupResource groupResource, int i) {
        this.$r8$classId = i;
        this.f$0 = groupFactory;
        this.f$1 = groupResource;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        GroupResource groupResource = this.f$1;
        GroupFactory groupFactory = this.f$0;
        switch (i) {
            case 0:
                return groupFactory.lambda$stateSetter$15(groupResource, (UpdateLight) obj);
            default:
                return groupFactory.lambda$groupLightsSetter$14(groupResource, (Collection) obj);
        }
    }
}

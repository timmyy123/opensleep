package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import io.github.zeroone3010.yahueapi.v2.domain.SceneResource;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GroupFactory$$ExternalSyntheticLambda9 implements Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GroupFactory f$0;

    public /* synthetic */ GroupFactory$$ExternalSyntheticLambda9(GroupFactory groupFactory, int i) {
        this.$r8$classId = i;
        this.f$0 = groupFactory;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        GroupFactory groupFactory = this.f$0;
        switch (i) {
            case 0:
                return groupFactory.lambda$buildGroup$11((SceneResource) obj);
            case 1:
                return groupFactory.lambda$buildGroup$4((ResourceIdentifier) obj);
            default:
                return groupFactory.lambda$buildGroup$6((UUID) obj);
        }
    }
}

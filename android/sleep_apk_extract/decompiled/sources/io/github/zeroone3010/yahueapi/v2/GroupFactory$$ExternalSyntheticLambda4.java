package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.GroupResource;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GroupFactory$$ExternalSyntheticLambda4 implements Supplier {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GroupFactory f$0;
    public final /* synthetic */ GroupResource f$1;

    public /* synthetic */ GroupFactory$$ExternalSyntheticLambda4(GroupFactory groupFactory, GroupResource groupResource, int i) {
        this.$r8$classId = i;
        this.f$0 = groupFactory;
        this.f$1 = groupResource;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.$r8$classId;
        GroupResource groupResource = this.f$1;
        GroupFactory groupFactory = this.f$0;
        switch (i) {
            case 0:
                return groupFactory.lambda$createStateProvider$13(groupResource);
            default:
                return groupFactory.lambda$buildGroup$7(groupResource);
        }
    }
}

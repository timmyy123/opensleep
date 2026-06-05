package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateSet$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Collection f$0;

    public /* synthetic */ SnapshotStateSet$$ExternalSyntheticLambda0(Collection collection, int i) {
        this.$r8$classId = i;
        this.f$0 = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zRetainAll$lambda$5;
        int i = this.$r8$classId;
        Collection collection = this.f$0;
        switch (i) {
            case 0:
                zRetainAll$lambda$5 = SnapshotStateSet.retainAll$lambda$5(collection, (Set) obj);
                break;
            case 1:
                zRetainAll$lambda$5 = collection.contains(obj);
                break;
            case 2:
                zRetainAll$lambda$5 = collection.contains(obj);
                break;
            default:
                zRetainAll$lambda$5 = SnapshotStateList.retainAll$lambda$10(collection, (List) obj);
                break;
        }
        return Boolean.valueOf(zRetainAll$lambda$5);
    }
}

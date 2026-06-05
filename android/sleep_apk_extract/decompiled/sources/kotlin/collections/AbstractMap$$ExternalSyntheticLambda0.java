package kotlin.collections;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AbstractMap$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ KMappedMarker f$0;

    public /* synthetic */ AbstractMap$$ExternalSyntheticLambda0(KMappedMarker kMappedMarker, int i) {
        this.$r8$classId = i;
        this.f$0 = kMappedMarker;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        KMappedMarker kMappedMarker = this.f$0;
        switch (i) {
            case 0:
                return AbstractMap.toString$lambda$0((AbstractMap) kMappedMarker, (Map.Entry) obj);
            default:
                return AbstractCollection.toString$lambda$0((AbstractCollection) kMappedMarker, obj);
        }
    }
}

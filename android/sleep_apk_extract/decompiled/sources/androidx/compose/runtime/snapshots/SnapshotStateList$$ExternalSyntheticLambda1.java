package androidx.compose.runtime.snapshots;

import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SnapshotStateList$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SnapshotStateList$$ExternalSyntheticLambda1(int i, Collection collection) {
        this.$r8$classId = 0;
        this.f$0 = i;
        this.f$1 = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        int i2 = this.f$0;
        Object obj2 = this.f$1;
        switch (i) {
            case 0:
                return Boolean.valueOf(SnapshotStateList.addAll$lambda$4(i2, (Collection) obj2, (List) obj));
            case 1:
                return ActivityRecognitionInitializer.Transition.initializeOld$lambda$0$0$0((ActivityRecognitionInitializer) obj2, i2, (Void) obj);
            default:
                return ActivityRecognitionInitializer.Update.initialize$lambda$0$0$1((ActivityRecognitionInitializer) obj2, i2, obj);
        }
    }

    public /* synthetic */ SnapshotStateList$$ExternalSyntheticLambda1(ActivityRecognitionInitializer activityRecognitionInitializer, int i, int i2) {
        this.$r8$classId = i2;
        this.f$1 = activityRecognitionInitializer;
        this.f$0 = i;
    }
}

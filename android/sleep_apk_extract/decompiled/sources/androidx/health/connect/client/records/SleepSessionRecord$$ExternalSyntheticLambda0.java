package androidx.health.connect.client.records;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SleepSessionRecord$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ SleepSessionRecord$$ExternalSyntheticLambda0(Function2 function2, int i) {
        this.$r8$classId = i;
        this.f$0 = function2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Function2 function2 = this.f$0;
        switch (i) {
            case 0:
                return SleepSessionRecord._init_$lambda$1(function2, obj, obj2);
            case 1:
                return ExerciseSessionRecord._init_$lambda$2(function2, obj, obj2);
            default:
                return ExerciseSessionRecord._init_$lambda$7(function2, obj, obj2);
        }
    }
}

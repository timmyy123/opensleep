package androidx.health.connect.client.records;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\u0013R\u001d\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006%"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseStep;", "", "", "exerciseType", "exercisePhase", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "completionGoal", "", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "performanceTargets", "", "description", "<init>", "(IILandroidx/health/connect/client/records/ExerciseCompletionGoal;Ljava/util/List;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getExerciseType", "getExerciseType$annotations", "()V", "getExercisePhase", "getExercisePhase$annotations", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "getCompletionGoal", "()Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "Ljava/util/List;", "getPerformanceTargets", "()Ljava/util/List;", "Ljava/lang/String;", "getDescription", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlannedExerciseStep {
    private final ExerciseCompletionGoal completionGoal;
    private final String description;
    private final int exercisePhase;
    private final int exerciseType;
    private final List<ExercisePerformanceTarget> performanceTargets;

    /* JADX WARN: Multi-variable type inference failed */
    public PlannedExerciseStep(int i, int i2, ExerciseCompletionGoal exerciseCompletionGoal, List<? extends ExercisePerformanceTarget> list, String str) {
        exerciseCompletionGoal.getClass();
        list.getClass();
        this.exerciseType = i;
        this.exercisePhase = i2;
        this.completionGoal = exerciseCompletionGoal;
        this.performanceTargets = list;
        this.description = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlannedExerciseStep)) {
            return false;
        }
        PlannedExerciseStep plannedExerciseStep = (PlannedExerciseStep) other;
        return this.exerciseType == plannedExerciseStep.exerciseType && this.exercisePhase == plannedExerciseStep.exercisePhase && Intrinsics.areEqual(this.description, plannedExerciseStep.description) && Intrinsics.areEqual(this.completionGoal, plannedExerciseStep.completionGoal) && Intrinsics.areEqual(this.performanceTargets, plannedExerciseStep.performanceTargets);
    }

    public final ExerciseCompletionGoal getCompletionGoal() {
        return this.completionGoal;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getExercisePhase() {
        return this.exercisePhase;
    }

    public final int getExerciseType() {
        return this.exerciseType;
    }

    public final List<ExercisePerformanceTarget> getPerformanceTargets() {
        return this.performanceTargets;
    }

    public int hashCode() {
        int i = ((this.exerciseType * 31) + this.exercisePhase) * 31;
        String str = this.description;
        return this.performanceTargets.hashCode() + ((this.completionGoal.hashCode() + ((i + (str != null ? str.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlannedExerciseStep(exerciseType=");
        sb.append(this.exerciseType);
        sb.append(", exerciseCategory=");
        sb.append(this.exercisePhase);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", completionGoal=");
        sb.append(this.completionGoal);
        sb.append(", performanceTargets=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.performanceTargets, ')');
    }
}

package androidx.health.connect.client.records;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseBlock;", "", "repetitions", "", "steps", "", "Landroidx/health/connect/client/records/PlannedExerciseStep;", "description", "", "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "getRepetitions", "()I", "getSteps", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlannedExerciseBlock {
    private final String description;
    private final int repetitions;
    private final List<PlannedExerciseStep> steps;

    public PlannedExerciseBlock(int i, List<PlannedExerciseStep> list, String str) {
        list.getClass();
        this.repetitions = i;
        this.steps = list;
        this.description = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlannedExerciseBlock)) {
            return false;
        }
        PlannedExerciseBlock plannedExerciseBlock = (PlannedExerciseBlock) other;
        return this.repetitions == plannedExerciseBlock.repetitions && Intrinsics.areEqual(this.description, plannedExerciseBlock.description) && Intrinsics.areEqual(this.steps, plannedExerciseBlock.steps);
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getRepetitions() {
        return this.repetitions;
    }

    public final List<PlannedExerciseStep> getSteps() {
        return this.steps;
    }

    public int hashCode() {
        int i = this.repetitions * 31;
        String str = this.description;
        return this.steps.hashCode() + ((i + (str != null ? str.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlannedExerciseBlock(repetitions=");
        sb.append(this.repetitions);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", steps=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.steps, ')');
    }
}

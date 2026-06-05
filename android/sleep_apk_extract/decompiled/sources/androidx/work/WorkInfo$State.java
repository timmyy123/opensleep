package androidx.work;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"androidx/work/WorkInfo$State", "", "Landroidx/work/WorkInfo$State;", "<init>", "(Ljava/lang/String;I)V", "", "isFinished", "()Z", "ENQUEUED", "RUNNING", "SUCCEEDED", "FAILED", "BLOCKED", "CANCELLED", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkInfo$State {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkInfo$State[] $VALUES;
    public static final WorkInfo$State ENQUEUED = new WorkInfo$State("ENQUEUED", 0);
    public static final WorkInfo$State RUNNING = new WorkInfo$State("RUNNING", 1);
    public static final WorkInfo$State SUCCEEDED = new WorkInfo$State("SUCCEEDED", 2);
    public static final WorkInfo$State FAILED = new WorkInfo$State("FAILED", 3);
    public static final WorkInfo$State BLOCKED = new WorkInfo$State("BLOCKED", 4);
    public static final WorkInfo$State CANCELLED = new WorkInfo$State("CANCELLED", 5);

    private static final /* synthetic */ WorkInfo$State[] $values() {
        return new WorkInfo$State[]{ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, CANCELLED};
    }

    static {
        WorkInfo$State[] workInfo$StateArr$values = $values();
        $VALUES = workInfo$StateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(workInfo$StateArr$values);
    }

    private WorkInfo$State(String str, int i) {
    }

    public static WorkInfo$State valueOf(String str) {
        return (WorkInfo$State) Enum.valueOf(WorkInfo$State.class, str);
    }

    public static WorkInfo$State[] values() {
        return (WorkInfo$State[]) $VALUES.clone();
    }

    public final boolean isFinished() {
        return this == SUCCEEDED || this == FAILED || this == CANCELLED;
    }
}

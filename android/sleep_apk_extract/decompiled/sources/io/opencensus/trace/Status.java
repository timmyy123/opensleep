package io.opencensus.trace;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Status {
    private final CanonicalCode canonicalCode;

    @Nullable
    private final String description;
    private static final List<Status> STATUS_LIST = buildStatusList();
    public static final Status OK = CanonicalCode.OK.toStatus();
    public static final Status CANCELLED = CanonicalCode.CANCELLED.toStatus();
    public static final Status UNKNOWN = CanonicalCode.UNKNOWN.toStatus();
    public static final Status INVALID_ARGUMENT = CanonicalCode.INVALID_ARGUMENT.toStatus();
    public static final Status DEADLINE_EXCEEDED = CanonicalCode.DEADLINE_EXCEEDED.toStatus();
    public static final Status NOT_FOUND = CanonicalCode.NOT_FOUND.toStatus();
    public static final Status ALREADY_EXISTS = CanonicalCode.ALREADY_EXISTS.toStatus();
    public static final Status PERMISSION_DENIED = CanonicalCode.PERMISSION_DENIED.toStatus();
    public static final Status UNAUTHENTICATED = CanonicalCode.UNAUTHENTICATED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = CanonicalCode.RESOURCE_EXHAUSTED.toStatus();
    public static final Status FAILED_PRECONDITION = CanonicalCode.FAILED_PRECONDITION.toStatus();
    public static final Status ABORTED = CanonicalCode.ABORTED.toStatus();
    public static final Status OUT_OF_RANGE = CanonicalCode.OUT_OF_RANGE.toStatus();
    public static final Status UNIMPLEMENTED = CanonicalCode.UNIMPLEMENTED.toStatus();
    public static final Status INTERNAL = CanonicalCode.INTERNAL.toStatus();
    public static final Status UNAVAILABLE = CanonicalCode.UNAVAILABLE.toStatus();
    public static final Status DATA_LOSS = CanonicalCode.DATA_LOSS.toStatus();

    public enum CanonicalCode {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;

        CanonicalCode(int i) {
            this.value = i;
        }

        public Status toStatus() {
            return (Status) Status.STATUS_LIST.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    private Status(CanonicalCode canonicalCode, @Nullable String str) {
        this.canonicalCode = (CanonicalCode) Utils.checkNotNull(canonicalCode, "canonicalCode");
        this.description = str;
    }

    private static List<Status> buildStatusList() {
        TreeMap treeMap = new TreeMap();
        for (CanonicalCode canonicalCode : CanonicalCode.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(canonicalCode.value()), new Status(canonicalCode, null));
            if (status != null) {
                Events$$ExternalSyntheticBUOutline0.m("Code value duplication between ", status.getCanonicalCode().name(), " & ", canonicalCode.name());
                return null;
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.canonicalCode == status.canonicalCode && Utils.equalsObjects(this.description, status.description);
    }

    public CanonicalCode getCanonicalCode() {
        return this.canonicalCode;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.canonicalCode, this.description});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Status{canonicalCode=");
        sb.append(this.canonicalCode);
        sb.append(", description=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.description, "}");
    }
}

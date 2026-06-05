package com.google.home.automation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/home/automation/ValidationIssueSeverity;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "UNKNOWN", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ValidationIssueSeverity {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ValidationIssueSeverity[] $VALUES;
    public static final ValidationIssueSeverity WARNING = new ValidationIssueSeverity("WARNING", 0);
    public static final ValidationIssueSeverity ERROR = new ValidationIssueSeverity("ERROR", 1);
    public static final ValidationIssueSeverity UNKNOWN = new ValidationIssueSeverity("UNKNOWN", 2);

    private static final /* synthetic */ ValidationIssueSeverity[] $values() {
        return new ValidationIssueSeverity[]{WARNING, ERROR, UNKNOWN};
    }

    static {
        ValidationIssueSeverity[] validationIssueSeverityArr$values = $values();
        $VALUES = validationIssueSeverityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(validationIssueSeverityArr$values);
    }

    private ValidationIssueSeverity(String str, int i) {
    }

    public static ValidationIssueSeverity valueOf(String str) {
        return (ValidationIssueSeverity) Enum.valueOf(ValidationIssueSeverity.class, str);
    }

    public static ValidationIssueSeverity[] values() {
        return (ValidationIssueSeverity[]) $VALUES.clone();
    }
}

package com.google.home.automation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/home/automation/JoinSemanticType;", "", "<init>", "(Ljava/lang/String;I)V", "JsWhenAllFinished", "JsUnspecified", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JoinSemanticType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ JoinSemanticType[] $VALUES;
    public static final JoinSemanticType JsWhenAllFinished = new JoinSemanticType("JsWhenAllFinished", 0);
    public static final JoinSemanticType JsUnspecified = new JoinSemanticType("JsUnspecified", 1);

    private static final /* synthetic */ JoinSemanticType[] $values() {
        return new JoinSemanticType[]{JsWhenAllFinished, JsUnspecified};
    }

    static {
        JoinSemanticType[] joinSemanticTypeArr$values = $values();
        $VALUES = joinSemanticTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(joinSemanticTypeArr$values);
    }

    private JoinSemanticType(String str, int i) {
    }

    public static JoinSemanticType valueOf(String str) {
        return (JoinSemanticType) Enum.valueOf(JoinSemanticType.class, str);
    }

    public static JoinSemanticType[] values() {
        return (JoinSemanticType[]) $VALUES.clone();
    }
}

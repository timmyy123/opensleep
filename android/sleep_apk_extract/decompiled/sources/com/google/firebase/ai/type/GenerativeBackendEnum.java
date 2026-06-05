package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/GenerativeBackendEnum;", "", "<init>", "(Ljava/lang/String;I)V", "GOOGLE_AI", "VERTEX_AI", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerativeBackendEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GenerativeBackendEnum[] $VALUES;
    public static final GenerativeBackendEnum GOOGLE_AI = new GenerativeBackendEnum("GOOGLE_AI", 0);
    public static final GenerativeBackendEnum VERTEX_AI = new GenerativeBackendEnum("VERTEX_AI", 1);

    private static final /* synthetic */ GenerativeBackendEnum[] $values() {
        return new GenerativeBackendEnum[]{GOOGLE_AI, VERTEX_AI};
    }

    static {
        GenerativeBackendEnum[] generativeBackendEnumArr$values = $values();
        $VALUES = generativeBackendEnumArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(generativeBackendEnumArr$values);
    }

    private GenerativeBackendEnum(String str, int i) {
    }

    public static EnumEntries<GenerativeBackendEnum> getEntries() {
        return $ENTRIES;
    }

    public static GenerativeBackendEnum valueOf(String str) {
        return (GenerativeBackendEnum) Enum.valueOf(GenerativeBackendEnum.class, str);
    }

    public static GenerativeBackendEnum[] values() {
        return (GenerativeBackendEnum[]) $VALUES.clone();
    }
}

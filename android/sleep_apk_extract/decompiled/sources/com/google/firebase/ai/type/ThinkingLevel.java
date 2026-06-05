package com.google.firebase.ai.type;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingLevel;", "", "ordinal", "", "<init>", "(I)V", "getOrdinal", "()I", "toInternal", "Lcom/google/firebase/ai/type/ThinkingLevel$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThinkingLevel {
    private final int ordinal;
    public static final ThinkingLevel MINIMAL = new ThinkingLevel(0);
    public static final ThinkingLevel LOW = new ThinkingLevel(1);
    public static final ThinkingLevel MEDIUM = new ThinkingLevel(2);
    public static final ThinkingLevel HIGH = new ThinkingLevel(3);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0081\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingLevel$Internal;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "MINIMAL", "LOW", "MEDIUM", "HIGH", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final class Internal {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Internal[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;

        @SerialName("THINKING_LEVEL_UNSPECIFIED")
        public static final Internal UNSPECIFIED = new Internal("UNSPECIFIED", 0);
        public static final Internal MINIMAL = new Internal("MINIMAL", 1);
        public static final Internal LOW = new Internal("LOW", 2);
        public static final Internal MEDIUM = new Internal("MEDIUM", 3);
        public static final Internal HIGH = new Internal("HIGH", 4);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingLevel$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ThinkingLevel$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Internal.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Internal> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ Internal[] $values() {
            return new Internal[]{UNSPECIFIED, MINIMAL, LOW, MEDIUM, HIGH};
        }

        static {
            Internal[] internalArr$values = $values();
            $VALUES = internalArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(internalArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Tool$$ExternalSyntheticLambda0(18));
        }

        private Internal(String str, int i) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("com.google.firebase.ai.type.ThinkingLevel.Internal", values(), new String[]{"THINKING_LEVEL_UNSPECIFIED", null, null, null, null}, new Annotation[][]{null, null, null, null, null}, null);
        }

        public static EnumEntries<Internal> getEntries() {
            return $ENTRIES;
        }

        public static Internal valueOf(String str) {
            return (Internal) Enum.valueOf(Internal.class, str);
        }

        public static Internal[] values() {
            return (Internal[]) $VALUES.clone();
        }
    }

    private ThinkingLevel(int i) {
        this.ordinal = i;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        if (Intrinsics.areEqual(this, MINIMAL)) {
            return Internal.MINIMAL;
        }
        if (Intrinsics.areEqual(this, LOW)) {
            return Internal.LOW;
        }
        if (Intrinsics.areEqual(this, MEDIUM)) {
            return Internal.MEDIUM;
        }
        if (Intrinsics.areEqual(this, HIGH)) {
            return Internal.HIGH;
        }
        throw ExceptionsKt.makeMissingCaseException("ThinkingLevel", this.ordinal);
    }
}

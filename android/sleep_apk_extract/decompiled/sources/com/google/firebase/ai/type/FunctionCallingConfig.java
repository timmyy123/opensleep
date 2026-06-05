package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.annotation.Annotation;
import java.util.List;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0003\r\u000e\u000fB#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig;", "", "mode", "Lcom/google/firebase/ai/type/FunctionCallingConfig$Mode;", "allowedFunctionNames", "", "", "<init>", "(Lcom/google/firebase/ai/type/FunctionCallingConfig$Mode;Ljava/util/List;)V", "getMode$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/FunctionCallingConfig$Mode;", "getAllowedFunctionNames$com_google_firebase_ai_logic_firebase_ai", "()Ljava/util/List;", "Mode", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionCallingConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> allowedFunctionNames;
    private final Mode mode;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig$Companion;", "", "<init>", "()V", "auto", "Lcom/google/firebase/ai/type/FunctionCallingConfig;", "any", "allowedFunctionNames", "", "", IntegrityManager.INTEGRITY_TYPE_NONE, "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FunctionCallingConfig any$default(Companion companion, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = null;
            }
            return companion.any(list);
        }

        public final FunctionCallingConfig any(List<String> allowedFunctionNames) {
            return new FunctionCallingConfig(Mode.ANY, allowedFunctionNames);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final FunctionCallingConfig auto() {
            return new FunctionCallingConfig(Mode.AUTO, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final FunctionCallingConfig none() {
            return new FunctionCallingConfig(Mode.NONE, null, 2, 0 == true ? 1 : 0);
        }

        private Companion() {
        }

        public final FunctionCallingConfig any() {
            return any$default(this, null, 1, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "ANY", "NONE", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode AUTO = new Mode("AUTO", 0);
        public static final Mode ANY = new Mode("ANY", 1);
        public static final Mode NONE = new Mode("NONE", 2);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{AUTO, ANY, NONE};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
        }

        private Mode(String str, int i) {
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public FunctionCallingConfig(Mode mode, List<String> list) {
        mode.getClass();
        this.mode = mode;
        this.allowedFunctionNames = list;
    }

    public static final FunctionCallingConfig any() {
        return INSTANCE.any();
    }

    public static final FunctionCallingConfig auto() {
        return INSTANCE.auto();
    }

    public static final FunctionCallingConfig none() {
        return INSTANCE.none();
    }

    public final List<String> getAllowedFunctionNames$com_google_firebase_ai_logic_firebase_ai() {
        return this.allowedFunctionNames;
    }

    /* JADX INFO: renamed from: getMode$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Mode getMode() {
        return this.mode;
    }

    public static final FunctionCallingConfig any(List<String> list) {
        return INSTANCE.any(list);
    }

    public /* synthetic */ FunctionCallingConfig(Mode mode, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mode, (i & 2) != 0 ? null : list);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0003$%&B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal;", "", "mode", "Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode;", "allowedFunctionNames", "", "", "<init>", "(Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMode", "()Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode;", "getAllowedFunctionNames$annotations", "()V", "getAllowedFunctionNames", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "Mode", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final List<String> allowedFunctionNames;
        private final Mode mode;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {Mode.INSTANCE.serializer(), new ArrayListSerializer(StringSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return FunctionCallingConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "AUTO", "ANY", "NONE", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final class Mode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Mode[] $VALUES;
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;

            @SerialName("MODE_UNSPECIFIED")
            public static final Mode UNSPECIFIED = new Mode("UNSPECIFIED", 0);
            public static final Mode AUTO = new Mode("AUTO", 1);
            public static final Mode ANY = new Mode("ANY", 2);
            public static final Mode NONE = new Mode("NONE", 3);

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionCallingConfig$Internal$Mode;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) Mode.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<Mode> serializer() {
                    return get$cachedSerializer();
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private static final /* synthetic */ Mode[] $values() {
                return new Mode[]{UNSPECIFIED, AUTO, ANY, NONE};
            }

            static {
                Mode[] modeArr$values = $values();
                $VALUES = modeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
                INSTANCE = new Companion(null);
                $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Tool$$ExternalSyntheticLambda0(15));
            }

            private Mode(String str, int i) {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return EnumsKt.createAnnotatedEnumSerializer("com.google.firebase.ai.type.FunctionCallingConfig.Internal.Mode", values(), new String[]{"MODE_UNSPECIFIED", null, null, null}, new Annotation[][]{null, null, null, null}, null);
            }

            public static EnumEntries<Mode> getEntries() {
                return $ENTRIES;
            }

            public static Mode valueOf(String str) {
                return (Mode) Enum.valueOf(Mode.class, str);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Internal(int i, Mode mode, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, FunctionCallingConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.mode = mode;
            if ((i & 2) == 0) {
                this.allowedFunctionNames = null;
            } else {
                this.allowedFunctionNames = list;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Mode mode, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                mode = internal.mode;
            }
            if ((i & 2) != 0) {
                list = internal.allowedFunctionNames;
            }
            return internal.copy(mode, list);
        }

        @SerialName("allowed_function_names")
        public static /* synthetic */ void getAllowedFunctionNames$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.mode);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.allowedFunctionNames == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.allowedFunctionNames);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Mode getMode() {
            return this.mode;
        }

        public final List<String> component2() {
            return this.allowedFunctionNames;
        }

        public final Internal copy(Mode mode, List<String> allowedFunctionNames) {
            mode.getClass();
            return new Internal(mode, allowedFunctionNames);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return this.mode == internal.mode && Intrinsics.areEqual(this.allowedFunctionNames, internal.allowedFunctionNames);
        }

        public final List<String> getAllowedFunctionNames() {
            return this.allowedFunctionNames;
        }

        public final Mode getMode() {
            return this.mode;
        }

        public int hashCode() {
            int iHashCode = this.mode.hashCode() * 31;
            List<String> list = this.allowedFunctionNames;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(mode=");
            sb.append(this.mode);
            sb.append(", allowedFunctionNames=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.allowedFunctionNames, ')');
        }

        public Internal(Mode mode, List<String> list) {
            mode.getClass();
            this.mode = mode;
            this.allowedFunctionNames = list;
        }

        public /* synthetic */ Internal(Mode mode, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(mode, (i & 2) != 0 ? null : list);
        }
    }
}

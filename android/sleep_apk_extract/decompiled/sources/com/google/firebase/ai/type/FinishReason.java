package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.common.util.FirstOrdinalSerializer;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/ai/type/FinishReason;", "", "name", "", "ordinal", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getOrdinal", "()I", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FinishReason {
    private final String name;
    private final int ordinal;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final FinishReason UNKNOWN = new FinishReason("UNKNOWN", 0);
    public static final FinishReason STOP = new FinishReason("STOP", 1);
    public static final FinishReason MAX_TOKENS = new FinishReason("MAX_TOKENS", 2);
    public static final FinishReason SAFETY = new FinishReason("SAFETY", 3);
    public static final FinishReason RECITATION = new FinishReason("RECITATION", 4);
    public static final FinishReason OTHER = new FinishReason("OTHER", 5);
    public static final FinishReason BLOCKLIST = new FinishReason("BLOCKLIST", 6);
    public static final FinishReason PROHIBITED_CONTENT = new FinishReason("PROHIBITED_CONTENT", 7);
    public static final FinishReason SPII = new FinishReason("SPII", 8);
    public static final FinishReason MALFORMED_FUNCTION_CALL = new FinishReason("MALFORMED_FUNCTION_CALL", 9);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/ai/type/FinishReason$Companion;", "", "<init>", "()V", "UNKNOWN", "Lcom/google/firebase/ai/type/FinishReason;", "STOP", "MAX_TOKENS", "SAFETY", "RECITATION", "OTHER", "BLOCKLIST", "PROHIBITED_CONTENT", "SPII", "MALFORMED_FUNCTION_CALL", "fromInterop", "reason", "Lcom/google/firebase/ai/ondevice/interop/FinishReason;", "fromInterop$com_google_firebase_ai_logic_firebase_ai", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FinishReason fromInterop$com_google_firebase_ai_logic_firebase_ai(com.google.firebase.ai.ondevice.interop.FinishReason reason) {
            reason.getClass();
            return Intrinsics.areEqual(reason, com.google.firebase.ai.ondevice.interop.FinishReason.STOP) ? FinishReason.STOP : Intrinsics.areEqual(reason, com.google.firebase.ai.ondevice.interop.FinishReason.MAX_TOKENS) ? FinishReason.MAX_TOKENS : FinishReason.OTHER;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/ai/type/FinishReason$Internal;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "UNSPECIFIED", "STOP", "MAX_TOKENS", "SAFETY", "RECITATION", "OTHER", "BLOCKLIST", "PROHIBITED_CONTENT", "SPII", "MALFORMED_FUNCTION_CALL", "toPublic", "Lcom/google/firebase/ai/type/FinishReason;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "Serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    public static final class Internal {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Internal[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Internal UNKNOWN = new Internal("UNKNOWN", 0);

        @SerialName("FINISH_REASON_UNSPECIFIED")
        public static final Internal UNSPECIFIED = new Internal("UNSPECIFIED", 1);
        public static final Internal STOP = new Internal("STOP", 2);
        public static final Internal MAX_TOKENS = new Internal("MAX_TOKENS", 3);
        public static final Internal SAFETY = new Internal("SAFETY", 4);
        public static final Internal RECITATION = new Internal("RECITATION", 5);
        public static final Internal OTHER = new Internal("OTHER", 6);
        public static final Internal BLOCKLIST = new Internal("BLOCKLIST", 7);
        public static final Internal PROHIBITED_CONTENT = new Internal("PROHIBITED_CONTENT", 8);
        public static final Internal SPII = new Internal("SPII", 9);
        public static final Internal MALFORMED_FUNCTION_CALL = new Internal("MALFORMED_FUNCTION_CALL", 10);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FinishReason$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FinishReason$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/FinishReason$Internal$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FinishReason$Internal;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Serializer implements KSerializer<Internal> {
            public static final Serializer INSTANCE = new Serializer();
            private final /* synthetic */ FirstOrdinalSerializer<Internal> $$delegate_0 = new FirstOrdinalSerializer<>(Reflection.getOrCreateKotlinClass(Internal.class));

            private Serializer() {
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public Internal deserialize(Decoder decoder) {
                decoder.getClass();
                return (Internal) this.$$delegate_0.deserialize(decoder);
            }

            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public SerialDescriptor getDescriptor() {
                return this.$$delegate_0.getDescriptor();
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public void serialize(Encoder encoder, Internal value) {
                encoder.getClass();
                value.getClass();
                this.$$delegate_0.serialize(encoder, value);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Internal.values().length];
                try {
                    iArr[Internal.MAX_TOKENS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Internal.RECITATION.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Internal.SAFETY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Internal.STOP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Internal.OTHER.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Internal.BLOCKLIST.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Internal.PROHIBITED_CONTENT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[Internal.SPII.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[Internal.MALFORMED_FUNCTION_CALL.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Internal[] $values() {
            return new Internal[]{UNKNOWN, UNSPECIFIED, STOP, MAX_TOKENS, SAFETY, RECITATION, OTHER, BLOCKLIST, PROHIBITED_CONTENT, SPII, MALFORMED_FUNCTION_CALL};
        }

        static {
            Internal[] internalArr$values = $values();
            $VALUES = internalArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(internalArr$values);
            INSTANCE = new Companion(null);
        }

        private Internal(String str, int i) {
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

        public final FinishReason toPublic$com_google_firebase_ai_logic_firebase_ai() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return FinishReason.MAX_TOKENS;
                case 2:
                    return FinishReason.RECITATION;
                case 3:
                    return FinishReason.SAFETY;
                case 4:
                    return FinishReason.STOP;
                case 5:
                    return FinishReason.OTHER;
                case 6:
                    return FinishReason.BLOCKLIST;
                case 7:
                    return FinishReason.PROHIBITED_CONTENT;
                case 8:
                    return FinishReason.SPII;
                case 9:
                    return FinishReason.MALFORMED_FUNCTION_CALL;
                default:
                    return FinishReason.UNKNOWN;
            }
        }
    }

    private FinishReason(String str, int i) {
        this.name = str;
        this.ordinal = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }
}

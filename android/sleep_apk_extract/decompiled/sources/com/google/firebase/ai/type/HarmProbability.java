package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.common.util.FirstOrdinalSerializer;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/HarmProbability;", "", "ordinal", "", "<init>", "(I)V", "getOrdinal", "()I", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HarmProbability {
    private final int ordinal;
    public static final HarmProbability UNKNOWN = new HarmProbability(0);
    public static final HarmProbability NEGLIGIBLE = new HarmProbability(1);
    public static final HarmProbability LOW = new HarmProbability(2);
    public static final HarmProbability MEDIUM = new HarmProbability(3);
    public static final HarmProbability HIGH = new HarmProbability(4);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/ai/type/HarmProbability$Internal;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "UNSPECIFIED", "NEGLIGIBLE", "LOW", "MEDIUM", "HIGH", "toPublic", "Lcom/google/firebase/ai/type/HarmProbability;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "Serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    public static final class Internal {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Internal[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Internal UNKNOWN = new Internal("UNKNOWN", 0);

        @SerialName("HARM_PROBABILITY_UNSPECIFIED")
        public static final Internal UNSPECIFIED = new Internal("UNSPECIFIED", 1);
        public static final Internal NEGLIGIBLE = new Internal("NEGLIGIBLE", 2);
        public static final Internal LOW = new Internal("LOW", 3);
        public static final Internal MEDIUM = new Internal("MEDIUM", 4);
        public static final Internal HIGH = new Internal("HIGH", 5);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/HarmProbability$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/HarmProbability$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/HarmProbability$Internal$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/HarmProbability$Internal;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                    iArr[Internal.HIGH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Internal.MEDIUM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Internal.LOW.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Internal.NEGLIGIBLE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Internal[] $values() {
            return new Internal[]{UNKNOWN, UNSPECIFIED, NEGLIGIBLE, LOW, MEDIUM, HIGH};
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

        public final HarmProbability toPublic$com_google_firebase_ai_logic_firebase_ai() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? HarmProbability.UNKNOWN : HarmProbability.NEGLIGIBLE : HarmProbability.LOW : HarmProbability.MEDIUM : HarmProbability.HIGH;
        }
    }

    private HarmProbability(int i) {
        this.ordinal = i;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }
}

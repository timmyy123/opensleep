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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/HarmCategory;", "", "ordinal", "", "<init>", "(I)V", "getOrdinal", "()I", "toInternal", "Lcom/google/firebase/ai/type/HarmCategory$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HarmCategory {
    private final int ordinal;
    public static final HarmCategory UNKNOWN = new HarmCategory(0);
    public static final HarmCategory HARASSMENT = new HarmCategory(1);
    public static final HarmCategory HATE_SPEECH = new HarmCategory(2);
    public static final HarmCategory SEXUALLY_EXPLICIT = new HarmCategory(3);
    public static final HarmCategory DANGEROUS_CONTENT = new HarmCategory(4);
    public static final HarmCategory CIVIC_INTEGRITY = new HarmCategory(5);
    public static final HarmCategory IMAGE_HATE = new HarmCategory(6);
    public static final HarmCategory IMAGE_DANGEROUS_CONTENT = new HarmCategory(7);
    public static final HarmCategory IMAGE_HARASSMENT = new HarmCategory(8);
    public static final HarmCategory IMAGE_SEXUALLY_EXPLICIT = new HarmCategory(9);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/ai/type/HarmCategory$Internal;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "HARASSMENT", "HATE_SPEECH", "SEXUALLY_EXPLICIT", "DANGEROUS_CONTENT", "CIVIC_INTEGRITY", "IMAGE_HATE", "IMAGE_DANGEROUS_CONTENT", "IMAGE_HARASSMENT", "IMAGE_SEXUALLY_EXPLICIT", "toPublic", "Lcom/google/firebase/ai/type/HarmCategory;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "Serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    public static final class Internal {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Internal[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Internal UNKNOWN = new Internal("UNKNOWN", 0);

        @SerialName("HARM_CATEGORY_HARASSMENT")
        public static final Internal HARASSMENT = new Internal("HARASSMENT", 1);

        @SerialName("HARM_CATEGORY_HATE_SPEECH")
        public static final Internal HATE_SPEECH = new Internal("HATE_SPEECH", 2);

        @SerialName("HARM_CATEGORY_SEXUALLY_EXPLICIT")
        public static final Internal SEXUALLY_EXPLICIT = new Internal("SEXUALLY_EXPLICIT", 3);

        @SerialName("HARM_CATEGORY_DANGEROUS_CONTENT")
        public static final Internal DANGEROUS_CONTENT = new Internal("DANGEROUS_CONTENT", 4);

        @SerialName("HARM_CATEGORY_CIVIC_INTEGRITY")
        public static final Internal CIVIC_INTEGRITY = new Internal("CIVIC_INTEGRITY", 5);

        @SerialName("HARM_CATEGORY_IMAGE_HATE")
        public static final Internal IMAGE_HATE = new Internal("IMAGE_HATE", 6);

        @SerialName("HARM_CATEGORY_IMAGE_DANGEROUS_CONTENT")
        public static final Internal IMAGE_DANGEROUS_CONTENT = new Internal("IMAGE_DANGEROUS_CONTENT", 7);

        @SerialName("HARM_CATEGORY_IMAGE_HARASSMENT")
        public static final Internal IMAGE_HARASSMENT = new Internal("IMAGE_HARASSMENT", 8);

        @SerialName("HARM_CATEGORY_IMAGE_SEXUALLY_EXPLICIT")
        public static final Internal IMAGE_SEXUALLY_EXPLICIT = new Internal("IMAGE_SEXUALLY_EXPLICIT", 9);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/HarmCategory$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/HarmCategory$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/HarmCategory$Internal$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/HarmCategory$Internal;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                    iArr[Internal.HARASSMENT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Internal.HATE_SPEECH.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Internal.SEXUALLY_EXPLICIT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Internal.DANGEROUS_CONTENT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Internal.CIVIC_INTEGRITY.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Internal.IMAGE_HATE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Internal.IMAGE_DANGEROUS_CONTENT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[Internal.IMAGE_HARASSMENT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[Internal.IMAGE_SEXUALLY_EXPLICIT.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Internal[] $values() {
            return new Internal[]{UNKNOWN, HARASSMENT, HATE_SPEECH, SEXUALLY_EXPLICIT, DANGEROUS_CONTENT, CIVIC_INTEGRITY, IMAGE_HATE, IMAGE_DANGEROUS_CONTENT, IMAGE_HARASSMENT, IMAGE_SEXUALLY_EXPLICIT};
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

        public final HarmCategory toPublic$com_google_firebase_ai_logic_firebase_ai() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return HarmCategory.HARASSMENT;
                case 2:
                    return HarmCategory.HATE_SPEECH;
                case 3:
                    return HarmCategory.SEXUALLY_EXPLICIT;
                case 4:
                    return HarmCategory.DANGEROUS_CONTENT;
                case 5:
                    return HarmCategory.CIVIC_INTEGRITY;
                case 6:
                    return HarmCategory.IMAGE_HATE;
                case 7:
                    return HarmCategory.IMAGE_DANGEROUS_CONTENT;
                case 8:
                    return HarmCategory.IMAGE_HARASSMENT;
                case 9:
                    return HarmCategory.IMAGE_SEXUALLY_EXPLICIT;
                default:
                    return HarmCategory.UNKNOWN;
            }
        }
    }

    private HarmCategory(int i) {
        this.ordinal = i;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        if (Intrinsics.areEqual(this, HARASSMENT)) {
            return Internal.HARASSMENT;
        }
        if (Intrinsics.areEqual(this, HATE_SPEECH)) {
            return Internal.HATE_SPEECH;
        }
        if (Intrinsics.areEqual(this, SEXUALLY_EXPLICIT)) {
            return Internal.SEXUALLY_EXPLICIT;
        }
        if (Intrinsics.areEqual(this, DANGEROUS_CONTENT)) {
            return Internal.DANGEROUS_CONTENT;
        }
        if (Intrinsics.areEqual(this, CIVIC_INTEGRITY)) {
            return Internal.CIVIC_INTEGRITY;
        }
        if (Intrinsics.areEqual(this, IMAGE_HATE)) {
            return Internal.IMAGE_HATE;
        }
        if (Intrinsics.areEqual(this, IMAGE_DANGEROUS_CONTENT)) {
            return Internal.IMAGE_DANGEROUS_CONTENT;
        }
        if (Intrinsics.areEqual(this, IMAGE_HARASSMENT)) {
            return Internal.IMAGE_HARASSMENT;
        }
        if (Intrinsics.areEqual(this, IMAGE_SEXUALLY_EXPLICIT)) {
            return Internal.IMAGE_SEXUALLY_EXPLICIT;
        }
        if (Intrinsics.areEqual(this, UNKNOWN)) {
            return Internal.UNKNOWN;
        }
        throw ExceptionsKt.makeMissingCaseException("HarmCategory", this.ordinal);
    }
}

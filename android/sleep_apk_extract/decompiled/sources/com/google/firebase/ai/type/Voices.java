package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0003\u000b\f\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/ai/type/Voices;", "", "ordinal", "", "<init>", "(I)V", "getOrdinal", "()I", "toInternal", "Lcom/google/firebase/ai/type/Voices$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "InternalEnum", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Voices {
    private final int ordinal;
    public static final Voices UNSPECIFIED = new Voices(0);
    public static final Voices CHARON = new Voices(1);
    public static final Voices AOEDE = new Voices(2);
    public static final Voices FENRIR = new Voices(3);
    public static final Voices KORE = new Voices(4);
    public static final Voices PUCK = new Voices(5);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/Voices$InternalEnum;", "", "<init>", "(Ljava/lang/String;I)V", "CHARON", "AOEDE", "FENRIR", "KORE", "PUCK", "toPublic", "Lcom/google/firebase/ai/type/Voices;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final class InternalEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InternalEnum[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final InternalEnum CHARON = new InternalEnum("CHARON", 0);
        public static final InternalEnum AOEDE = new InternalEnum("AOEDE", 1);
        public static final InternalEnum FENRIR = new InternalEnum("FENRIR", 2);
        public static final InternalEnum KORE = new InternalEnum("KORE", 3);
        public static final InternalEnum PUCK = new InternalEnum("PUCK", 4);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Voices$InternalEnum$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Voices$InternalEnum;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) InternalEnum.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<InternalEnum> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InternalEnum.values().length];
                try {
                    iArr[InternalEnum.CHARON.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InternalEnum.AOEDE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InternalEnum.FENRIR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[InternalEnum.KORE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ InternalEnum[] $values() {
            return new InternalEnum[]{CHARON, AOEDE, FENRIR, KORE, PUCK};
        }

        static {
            InternalEnum[] internalEnumArr$values = $values();
            $VALUES = internalEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(internalEnumArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Tool$$ExternalSyntheticLambda0(19));
        }

        private InternalEnum(String str, int i) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createSimpleEnumSerializer("com.google.firebase.ai.type.Voices.InternalEnum", values());
        }

        public static EnumEntries<InternalEnum> getEntries() {
            return $ENTRIES;
        }

        public static InternalEnum valueOf(String str) {
            return (InternalEnum) Enum.valueOf(InternalEnum.class, str);
        }

        public static InternalEnum[] values() {
            return (InternalEnum[]) $VALUES.clone();
        }

        public final Voices toPublic$com_google_firebase_ai_logic_firebase_ai() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Voices.PUCK : Voices.KORE : Voices.FENRIR : Voices.AOEDE : Voices.CHARON;
        }
    }

    private Voices(int i) {
        this.ordinal = i;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        return Intrinsics.areEqual(this, CHARON) ? new Internal("CHARON") : Intrinsics.areEqual(this, AOEDE) ? new Internal("AOEDE") : Intrinsics.areEqual(this, FENRIR) ? new Internal("FENRIR") : Intrinsics.areEqual(this, KORE) ? new Internal("KORE") : new Internal("PUCK");
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/google/firebase/ai/type/Voices$Internal;", "", "voiceName", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVoiceName$annotations", "()V", "getVoiceName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String voiceName;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Voices$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Voices$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Voices$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, Voices$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.voiceName = str;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.voiceName;
            }
            return internal.copy(str);
        }

        @SerialName("voice_name")
        public static /* synthetic */ void getVoiceName$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVoiceName() {
            return this.voiceName;
        }

        public final Internal copy(String voiceName) {
            voiceName.getClass();
            return new Internal(voiceName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internal) && Intrinsics.areEqual(this.voiceName, ((Internal) other).voiceName);
        }

        public final String getVoiceName() {
            return this.voiceName;
        }

        public int hashCode() {
            return this.voiceName.hashCode();
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Internal(voiceName="), this.voiceName, ')');
        }

        public Internal(String str) {
            str.getClass();
            this.voiceName = str;
        }
    }
}

package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/ContentModality;", "", "ordinal", "", "<init>", "(I)V", "getOrdinal", "()I", "toInternal", "", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentModality {
    private final int ordinal;
    public static final ContentModality UNSPECIFIED = new ContentModality(0);
    public static final ContentModality TEXT = new ContentModality(1);
    public static final ContentModality IMAGE = new ContentModality(2);
    public static final ContentModality VIDEO = new ContentModality(3);
    public static final ContentModality AUDIO = new ContentModality(4);
    public static final ContentModality DOCUMENT = new ContentModality(5);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/ai/type/ContentModality$Internal;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "TEXT", ShareConstants.IMAGE_URL, ShareConstants.VIDEO_URL, "AUDIO", "DOCUMENT", "toPublic", "Lcom/google/firebase/ai/type/ContentModality;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "Serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    public static final class Internal {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Internal[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;

        @SerialName("MODALITY_UNSPECIFIED")
        public static final Internal UNSPECIFIED = new Internal("UNSPECIFIED", 0);
        public static final Internal TEXT = new Internal("TEXT", 1);
        public static final Internal IMAGE = new Internal(ShareConstants.IMAGE_URL, 2);
        public static final Internal VIDEO = new Internal(ShareConstants.VIDEO_URL, 3);
        public static final Internal AUDIO = new Internal("AUDIO", 4);
        public static final Internal DOCUMENT = new Internal("DOCUMENT", 5);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ContentModality$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ContentModality$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/ContentModality$Internal$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ContentModality$Internal;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                    iArr[Internal.TEXT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Internal.IMAGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Internal.VIDEO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Internal.AUDIO.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Internal.DOCUMENT.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Internal[] $values() {
            return new Internal[]{UNSPECIFIED, TEXT, IMAGE, VIDEO, AUDIO, DOCUMENT};
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

        public final ContentModality toPublic$com_google_firebase_ai_logic_firebase_ai() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? ContentModality.UNSPECIFIED : ContentModality.DOCUMENT : ContentModality.AUDIO : ContentModality.VIDEO : ContentModality.IMAGE : ContentModality.TEXT;
        }
    }

    private ContentModality(int i) {
        this.ordinal = i;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }

    public final String toInternal$com_google_firebase_ai_logic_firebase_ai() {
        return Intrinsics.areEqual(this, TEXT) ? "TEXT" : Intrinsics.areEqual(this, IMAGE) ? ShareConstants.IMAGE_URL : Intrinsics.areEqual(this, VIDEO) ? ShareConstants.VIDEO_URL : Intrinsics.areEqual(this, AUDIO) ? "AUDIO" : Intrinsics.areEqual(this, DOCUMENT) ? "DOCUMENT" : "UNSPECIFIED";
    }
}

package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/ai/type/ImagenImageFormat;", "", "mimeType", "", "compressionQuality", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getMimeType", "()Ljava/lang/String;", "getCompressionQuality", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toInternal", "Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenImageFormat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer compressionQuality;
    private final String mimeType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/ImagenImageFormat$Companion;", "", "<init>", "()V", "jpeg", "Lcom/google/firebase/ai/type/ImagenImageFormat;", "compressionQuality", "", "(Ljava/lang/Integer;)Lcom/google/firebase/ai/type/ImagenImageFormat;", "png", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImagenImageFormat jpeg$default(Companion companion, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                num = null;
            }
            return companion.jpeg(num);
        }

        public final ImagenImageFormat jpeg(Integer compressionQuality) {
            return new ImagenImageFormat("image/jpeg", compressionQuality, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ImagenImageFormat png() {
            return new ImagenImageFormat("image/png", null, 0 == true ? 1 : 0);
        }

        private Companion() {
        }
    }

    private ImagenImageFormat(String str, Integer num) {
        this.mimeType = str;
        this.compressionQuality = num;
    }

    public static final ImagenImageFormat jpeg(Integer num) {
        return INSTANCE.jpeg(num);
    }

    public static final ImagenImageFormat png() {
        return INSTANCE.png();
    }

    public final Integer getCompressionQuality() {
        return this.compressionQuality;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        return new Internal(this.mimeType, this.compressionQuality);
    }

    public /* synthetic */ ImagenImageFormat(String str, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;", "", "mimeType", "", "compressionQuality", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMimeType", "()Ljava/lang/String;", "getCompressionQuality", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer compressionQuality;
        private final String mimeType;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ImagenImageFormat$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ImagenImageFormat$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ImagenImageFormat$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ImagenImageFormat$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.mimeType = str;
            this.compressionQuality = num;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.mimeType;
            }
            if ((i & 2) != 0) {
                num = internal.compressionQuality;
            }
            return internal.copy(str, num);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.mimeType);
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.compressionQuality);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getCompressionQuality() {
            return this.compressionQuality;
        }

        public final Internal copy(String mimeType, Integer compressionQuality) {
            mimeType.getClass();
            return new Internal(mimeType, compressionQuality);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.mimeType, internal.mimeType) && Intrinsics.areEqual(this.compressionQuality, internal.compressionQuality);
        }

        public final Integer getCompressionQuality() {
            return this.compressionQuality;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public int hashCode() {
            int iHashCode = this.mimeType.hashCode() * 31;
            Integer num = this.compressionQuality;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Internal(mimeType=" + this.mimeType + ", compressionQuality=" + this.compressionQuality + ')';
        }

        public Internal(String str, Integer num) {
            str.getClass();
            this.mimeType = str;
            this.compressionQuality = num;
        }
    }
}

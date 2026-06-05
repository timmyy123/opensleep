package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.ContentModality;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u0086\u0002J\t\u0010\r\u001a\u00020\u0005H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/ai/type/ModalityTokenCount;", "", "modality", "Lcom/google/firebase/ai/type/ContentModality;", "tokenCount", "", "<init>", "(Lcom/google/firebase/ai/type/ContentModality;I)V", "getModality", "()Lcom/google/firebase/ai/type/ContentModality;", "getTokenCount", "()I", "component1", "component2", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalityTokenCount {
    private final ContentModality modality;
    private final int tokenCount;

    private ModalityTokenCount(ContentModality contentModality, int i) {
        this.modality = contentModality;
        this.tokenCount = i;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContentModality getModality() {
        return this.modality;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTokenCount() {
        return this.tokenCount;
    }

    public final ContentModality getModality() {
        return this.modality;
    }

    public final int getTokenCount() {
        return this.tokenCount;
    }

    public /* synthetic */ ModalityTokenCount(ContentModality contentModality, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentModality, i);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/google/firebase/ai/type/ModalityTokenCount$Internal;", "", "modality", "Lcom/google/firebase/ai/type/ContentModality$Internal;", "tokenCount", "", "<init>", "(Lcom/google/firebase/ai/type/ContentModality$Internal;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/ContentModality$Internal;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModality", "()Lcom/google/firebase/ai/type/ContentModality$Internal;", "getTokenCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toPublic", "Lcom/google/firebase/ai/type/ModalityTokenCount;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "copy", "(Lcom/google/firebase/ai/type/ContentModality$Internal;Ljava/lang/Integer;)Lcom/google/firebase/ai/type/ModalityTokenCount$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ContentModality.Internal modality;
        private final Integer tokenCount;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ModalityTokenCount$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ModalityTokenCount$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ModalityTokenCount$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, ContentModality.Internal internal, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ModalityTokenCount$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.modality = internal;
            if ((i & 2) == 0) {
                this.tokenCount = null;
            } else {
                this.tokenCount = num;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, ContentModality.Internal internal2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.modality;
            }
            if ((i & 2) != 0) {
                num = internal.tokenCount;
            }
            return internal.copy(internal2, num);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, ContentModality.Internal.Serializer.INSTANCE, self.modality);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.tokenCount == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.tokenCount);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ContentModality.Internal getModality() {
            return this.modality;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTokenCount() {
            return this.tokenCount;
        }

        public final Internal copy(ContentModality.Internal modality, Integer tokenCount) {
            modality.getClass();
            return new Internal(modality, tokenCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return this.modality == internal.modality && Intrinsics.areEqual(this.tokenCount, internal.tokenCount);
        }

        public final ContentModality.Internal getModality() {
            return this.modality;
        }

        public final Integer getTokenCount() {
            return this.tokenCount;
        }

        public int hashCode() {
            int iHashCode = this.modality.hashCode() * 31;
            Integer num = this.tokenCount;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public final ModalityTokenCount toPublic$com_google_firebase_ai_logic_firebase_ai() {
            ContentModality public$com_google_firebase_ai_logic_firebase_ai = this.modality.toPublic$com_google_firebase_ai_logic_firebase_ai();
            Integer num = this.tokenCount;
            return new ModalityTokenCount(public$com_google_firebase_ai_logic_firebase_ai, num != null ? num.intValue() : 0, null);
        }

        public String toString() {
            return "Internal(modality=" + this.modality + ", tokenCount=" + this.tokenCount + ')';
        }

        public Internal(ContentModality.Internal internal, Integer num) {
            internal.getClass();
            this.modality = internal;
            this.tokenCount = num;
        }

        public /* synthetic */ Internal(ContentModality.Internal internal, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(internal, (i & 2) != 0 ? null : num);
        }
    }
}

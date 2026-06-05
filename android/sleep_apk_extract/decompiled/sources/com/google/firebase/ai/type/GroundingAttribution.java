package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Segment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/ai/type/GroundingAttribution;", "", "segment", "Lcom/google/firebase/ai/type/Segment;", "confidenceScore", "", "<init>", "(Lcom/google/firebase/ai/type/Segment;Ljava/lang/Float;)V", "getSegment", "()Lcom/google/firebase/ai/type/Segment;", "getConfidenceScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroundingAttribution {
    private final Float confidenceScore;
    private final Segment segment;

    public GroundingAttribution(Segment segment, Float f) {
        segment.getClass();
        this.segment = segment;
        this.confidenceScore = f;
    }

    public final Float getConfidenceScore() {
        return this.confidenceScore;
    }

    public final Segment getSegment() {
        return this.segment;
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J$\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Lcom/google/firebase/ai/type/GroundingAttribution$Internal;", "", "segment", "Lcom/google/firebase/ai/type/Segment$Internal;", "confidenceScore", "", "<init>", "(Lcom/google/firebase/ai/type/Segment$Internal;Ljava/lang/Float;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/Segment$Internal;Ljava/lang/Float;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSegment", "()Lcom/google/firebase/ai/type/Segment$Internal;", "getConfidenceScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "toPublic", "Lcom/google/firebase/ai/type/GroundingAttribution;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "copy", "(Lcom/google/firebase/ai/type/Segment$Internal;Ljava/lang/Float;)Lcom/google/firebase/ai/type/GroundingAttribution$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Float confidenceScore;
        private final Segment.Internal segment;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GroundingAttribution$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GroundingAttribution$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return GroundingAttribution$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Segment.Internal internal, Float f, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, GroundingAttribution$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.segment = internal;
            this.confidenceScore = f;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, Segment.Internal internal2, Float f, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.segment;
            }
            if ((i & 2) != 0) {
                f = internal.confidenceScore;
            }
            return internal.copy(internal2, f);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, Segment$Internal$$serializer.INSTANCE, self.segment);
            output.encodeNullableSerializableElement(serialDesc, 1, FloatSerializer.INSTANCE, self.confidenceScore);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Segment.Internal getSegment() {
            return this.segment;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Float getConfidenceScore() {
            return this.confidenceScore;
        }

        public final Internal copy(Segment.Internal segment, Float confidenceScore) {
            segment.getClass();
            return new Internal(segment, confidenceScore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.segment, internal.segment) && Intrinsics.areEqual((Object) this.confidenceScore, (Object) internal.confidenceScore);
        }

        public final Float getConfidenceScore() {
            return this.confidenceScore;
        }

        public final Segment.Internal getSegment() {
            return this.segment;
        }

        public int hashCode() {
            int iHashCode = this.segment.hashCode() * 31;
            Float f = this.confidenceScore;
            return iHashCode + (f == null ? 0 : f.hashCode());
        }

        public final GroundingAttribution toPublic$com_google_firebase_ai_logic_firebase_ai() {
            return new GroundingAttribution(this.segment.toPublic$com_google_firebase_ai_logic_firebase_ai(), this.confidenceScore);
        }

        public String toString() {
            return "Internal(segment=" + this.segment + ", confidenceScore=" + this.confidenceScore + ')';
        }

        public Internal(Segment.Internal internal, Float f) {
            internal.getClass();
            this.segment = internal;
            this.confidenceScore = f;
        }
    }
}

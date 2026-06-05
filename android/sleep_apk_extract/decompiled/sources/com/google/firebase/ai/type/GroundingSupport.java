package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Segment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\rB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/ai/type/GroundingSupport;", "", "segment", "Lcom/google/firebase/ai/type/Segment;", "groundingChunkIndices", "", "", "<init>", "(Lcom/google/firebase/ai/type/Segment;Ljava/util/List;)V", "getSegment", "()Lcom/google/firebase/ai/type/Segment;", "getGroundingChunkIndices", "()Ljava/util/List;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroundingSupport {
    private final List<Integer> groundingChunkIndices;
    private final Segment segment;

    public GroundingSupport(Segment segment, List<Integer> list) {
        segment.getClass();
        list.getClass();
        this.segment = segment;
        this.groundingChunkIndices = list;
    }

    public final List<Integer> getGroundingChunkIndices() {
        return this.groundingChunkIndices;
    }

    public final Segment getSegment() {
        return this.segment;
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002%&B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/google/firebase/ai/type/GroundingSupport$Internal;", "", "segment", "Lcom/google/firebase/ai/type/Segment$Internal;", "groundingChunkIndices", "", "", "<init>", "(Lcom/google/firebase/ai/type/Segment$Internal;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/Segment$Internal;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSegment", "()Lcom/google/firebase/ai/type/Segment$Internal;", "getGroundingChunkIndices", "()Ljava/util/List;", "toPublic", "Lcom/google/firebase/ai/type/GroundingSupport;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final List<Integer> groundingChunkIndices;
        private final Segment.Internal segment;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(IntSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GroundingSupport$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GroundingSupport$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return GroundingSupport$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Segment.Internal internal, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, GroundingSupport$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.segment = internal;
            this.groundingChunkIndices = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Segment.Internal internal2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.segment;
            }
            if ((i & 2) != 0) {
                list = internal.groundingChunkIndices;
            }
            return internal.copy(internal2, list);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeNullableSerializableElement(serialDesc, 0, Segment$Internal$$serializer.INSTANCE, self.segment);
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.groundingChunkIndices);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Segment.Internal getSegment() {
            return this.segment;
        }

        public final List<Integer> component2() {
            return this.groundingChunkIndices;
        }

        public final Internal copy(Segment.Internal segment, List<Integer> groundingChunkIndices) {
            return new Internal(segment, groundingChunkIndices);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.segment, internal.segment) && Intrinsics.areEqual(this.groundingChunkIndices, internal.groundingChunkIndices);
        }

        public final List<Integer> getGroundingChunkIndices() {
            return this.groundingChunkIndices;
        }

        public final Segment.Internal getSegment() {
            return this.segment;
        }

        public int hashCode() {
            Segment.Internal internal = this.segment;
            int iHashCode = (internal == null ? 0 : internal.hashCode()) * 31;
            List<Integer> list = this.groundingChunkIndices;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public final GroundingSupport toPublic$com_google_firebase_ai_logic_firebase_ai() {
            Segment.Internal internal = this.segment;
            if (internal == null) {
                return null;
            }
            Segment public$com_google_firebase_ai_logic_firebase_ai = internal.toPublic$com_google_firebase_ai_logic_firebase_ai();
            List<Integer> listEmptyList = this.groundingChunkIndices;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new GroundingSupport(public$com_google_firebase_ai_logic_firebase_ai, listEmptyList);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(segment=");
            sb.append(this.segment);
            sb.append(", groundingChunkIndices=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.groundingChunkIndices, ')');
        }

        public Internal(Segment.Internal internal, List<Integer> list) {
            this.segment = internal;
            this.groundingChunkIndices = list;
        }
    }
}

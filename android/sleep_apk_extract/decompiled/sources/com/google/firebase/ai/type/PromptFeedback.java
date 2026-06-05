package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.BlockReason;
import com.google.firebase.ai.type.SafetyRating;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0011B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/ai/type/PromptFeedback;", "", "blockReason", "Lcom/google/firebase/ai/type/BlockReason;", "safetyRatings", "", "Lcom/google/firebase/ai/type/SafetyRating;", "blockReasonMessage", "", "<init>", "(Lcom/google/firebase/ai/type/BlockReason;Ljava/util/List;Ljava/lang/String;)V", "getBlockReason", "()Lcom/google/firebase/ai/type/BlockReason;", "getSafetyRatings", "()Ljava/util/List;", "getBlockReasonMessage", "()Ljava/lang/String;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PromptFeedback {
    private final BlockReason blockReason;
    private final String blockReasonMessage;
    private final List<SafetyRating> safetyRatings;

    public PromptFeedback(BlockReason blockReason, List<SafetyRating> list, String str) {
        list.getClass();
        this.blockReason = blockReason;
        this.safetyRatings = list;
        this.blockReasonMessage = str;
    }

    public final BlockReason getBlockReason() {
        return this.blockReason;
    }

    public final String getBlockReasonMessage() {
        return this.blockReasonMessage;
    }

    public final List<SafetyRating> getSafetyRatings() {
        return this.safetyRatings;
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\fHÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Lcom/google/firebase/ai/type/PromptFeedback$Internal;", "", "blockReason", "Lcom/google/firebase/ai/type/BlockReason$Internal;", "safetyRatings", "", "Lcom/google/firebase/ai/type/SafetyRating$Internal;", "blockReasonMessage", "", "<init>", "(Lcom/google/firebase/ai/type/BlockReason$Internal;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/BlockReason$Internal;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBlockReason", "()Lcom/google/firebase/ai/type/BlockReason$Internal;", "getSafetyRatings", "()Ljava/util/List;", "getBlockReasonMessage", "()Ljava/lang/String;", "toPublic", "Lcom/google/firebase/ai/type/PromptFeedback;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final BlockReason.Internal blockReason;
        private final String blockReasonMessage;
        private final List<SafetyRating.Internal> safetyRatings;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(SafetyRating$Internal$$serializer.INSTANCE), null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/PromptFeedback$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/PromptFeedback$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return PromptFeedback$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, BlockReason.Internal internal, List list, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.blockReason = null;
            } else {
                this.blockReason = internal;
            }
            if ((i & 2) == 0) {
                this.safetyRatings = null;
            } else {
                this.safetyRatings = list;
            }
            if ((i & 4) == 0) {
                this.blockReasonMessage = null;
            } else {
                this.blockReasonMessage = str;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, BlockReason.Internal internal2, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.blockReason;
            }
            if ((i & 2) != 0) {
                list = internal.safetyRatings;
            }
            if ((i & 4) != 0) {
                str = internal.blockReasonMessage;
            }
            return internal.copy(internal2, list, str);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.blockReason != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BlockReason.Internal.Serializer.INSTANCE, self.blockReason);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.safetyRatings != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.safetyRatings);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.blockReasonMessage == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.blockReasonMessage);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BlockReason.Internal getBlockReason() {
            return this.blockReason;
        }

        public final List<SafetyRating.Internal> component2() {
            return this.safetyRatings;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBlockReasonMessage() {
            return this.blockReasonMessage;
        }

        public final Internal copy(BlockReason.Internal blockReason, List<SafetyRating.Internal> safetyRatings, String blockReasonMessage) {
            return new Internal(blockReason, safetyRatings, blockReasonMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return this.blockReason == internal.blockReason && Intrinsics.areEqual(this.safetyRatings, internal.safetyRatings) && Intrinsics.areEqual(this.blockReasonMessage, internal.blockReasonMessage);
        }

        public final BlockReason.Internal getBlockReason() {
            return this.blockReason;
        }

        public final String getBlockReasonMessage() {
            return this.blockReasonMessage;
        }

        public final List<SafetyRating.Internal> getSafetyRatings() {
            return this.safetyRatings;
        }

        public int hashCode() {
            BlockReason.Internal internal = this.blockReason;
            int iHashCode = (internal == null ? 0 : internal.hashCode()) * 31;
            List<SafetyRating.Internal> list = this.safetyRatings;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.blockReasonMessage;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final PromptFeedback toPublic$com_google_firebase_ai_logic_firebase_ai() {
            List listEmptyList;
            List<SafetyRating.Internal> list = this.safetyRatings;
            if (list != null) {
                listEmptyList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    SafetyRating public$com_google_firebase_ai_logic_firebase_ai = ((SafetyRating.Internal) it.next()).toPublic$com_google_firebase_ai_logic_firebase_ai();
                    if (public$com_google_firebase_ai_logic_firebase_ai != null) {
                        listEmptyList.add(public$com_google_firebase_ai_logic_firebase_ai);
                    }
                }
            } else {
                listEmptyList = null;
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            BlockReason.Internal internal = this.blockReason;
            return new PromptFeedback(internal != null ? internal.toPublic$com_google_firebase_ai_logic_firebase_ai() : null, listEmptyList, this.blockReasonMessage);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(blockReason=");
            sb.append(this.blockReason);
            sb.append(", safetyRatings=");
            sb.append(this.safetyRatings);
            sb.append(", blockReasonMessage=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.blockReasonMessage, ')');
        }

        public Internal() {
            this((BlockReason.Internal) null, (List) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public Internal(BlockReason.Internal internal, List<SafetyRating.Internal> list, String str) {
            this.blockReason = internal;
            this.safetyRatings = list;
            this.blockReasonMessage = str;
        }

        public /* synthetic */ Internal(BlockReason.Internal internal, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : internal, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str);
        }
    }
}

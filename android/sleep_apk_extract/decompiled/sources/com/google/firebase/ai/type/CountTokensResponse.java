package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.ModalityTokenCount;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0016B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0086\u0002¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/type/CountTokensResponse;", "", "totalTokens", "", "totalBillableCharacters", "promptTokensDetails", "", "Lcom/google/firebase/ai/type/ModalityTokenCount;", "<init>", "(ILjava/lang/Integer;Ljava/util/List;)V", "getTotalTokens", "()I", "getTotalBillableCharacters$annotations", "()V", "getTotalBillableCharacters", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPromptTokensDetails", "()Ljava/util/List;", "component1", "component2", "component3", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CountTokensResponse {
    private final List<ModalityTokenCount> promptTokensDetails;
    private final Integer totalBillableCharacters;
    private final int totalTokens;

    public /* synthetic */ CountTokensResponse(int i, Integer num, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static /* synthetic */ void getTotalBillableCharacters$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalTokens() {
        return this.totalTokens;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTotalBillableCharacters() {
        return this.totalBillableCharacters;
    }

    public final List<ModalityTokenCount> component3() {
        return this.promptTokensDetails;
    }

    public final List<ModalityTokenCount> getPromptTokensDetails() {
        return this.promptTokensDetails;
    }

    public final Integer getTotalBillableCharacters() {
        return this.totalBillableCharacters;
    }

    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public CountTokensResponse(int i, Integer num, List<ModalityTokenCount> list) {
        list.getClass();
        this.totalTokens = i;
        this.totalBillableCharacters = num;
        this.promptTokensDetails = list;
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J8\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Lcom/google/firebase/ai/type/CountTokensResponse$Internal;", "Lcom/google/firebase/ai/type/Response;", "totalTokens", "", "totalBillableCharacters", "promptTokensDetails", "", "Lcom/google/firebase/ai/type/ModalityTokenCount$Internal;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTotalTokens", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalBillableCharacters", "getPromptTokensDetails", "()Ljava/util/List;", "toPublic", "Lcom/google/firebase/ai/type/CountTokensResponse;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/google/firebase/ai/type/CountTokensResponse$Internal;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal implements Response {
        private final List<ModalityTokenCount.Internal> promptTokensDetails;
        private final Integer totalBillableCharacters;
        private final Integer totalTokens;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(ModalityTokenCount$Internal$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/CountTokensResponse$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/CountTokensResponse$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return CountTokensResponse$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Integer num, Integer num2, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.totalTokens = null;
            } else {
                this.totalTokens = num;
            }
            if ((i & 2) == 0) {
                this.totalBillableCharacters = null;
            } else {
                this.totalBillableCharacters = num2;
            }
            if ((i & 4) == 0) {
                this.promptTokensDetails = null;
            } else {
                this.promptTokensDetails = list;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Integer num, Integer num2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = internal.totalTokens;
            }
            if ((i & 2) != 0) {
                num2 = internal.totalBillableCharacters;
            }
            if ((i & 4) != 0) {
                list = internal.promptTokensDetails;
            }
            return internal.copy(num, num2, list);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.totalTokens != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.totalTokens);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.totalBillableCharacters != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.totalBillableCharacters);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.promptTokensDetails == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.promptTokensDetails);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getTotalTokens() {
            return this.totalTokens;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTotalBillableCharacters() {
            return this.totalBillableCharacters;
        }

        public final List<ModalityTokenCount.Internal> component3() {
            return this.promptTokensDetails;
        }

        public final Internal copy(Integer totalTokens, Integer totalBillableCharacters, List<ModalityTokenCount.Internal> promptTokensDetails) {
            return new Internal(totalTokens, totalBillableCharacters, promptTokensDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.totalTokens, internal.totalTokens) && Intrinsics.areEqual(this.totalBillableCharacters, internal.totalBillableCharacters) && Intrinsics.areEqual(this.promptTokensDetails, internal.promptTokensDetails);
        }

        public final List<ModalityTokenCount.Internal> getPromptTokensDetails() {
            return this.promptTokensDetails;
        }

        public final Integer getTotalBillableCharacters() {
            return this.totalBillableCharacters;
        }

        public final Integer getTotalTokens() {
            return this.totalTokens;
        }

        public int hashCode() {
            Integer num = this.totalTokens;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.totalBillableCharacters;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            List<ModalityTokenCount.Internal> list = this.promptTokensDetails;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
        public final CountTokensResponse toPublic$com_google_firebase_ai_logic_firebase_ai() {
            ?? EmptyList;
            Integer num = this.totalTokens;
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = this.totalBillableCharacters;
            Integer numValueOf = Integer.valueOf(num2 != null ? num2.intValue() : 0);
            List<ModalityTokenCount.Internal> list = this.promptTokensDetails;
            if (list != null) {
                List<ModalityTokenCount.Internal> list2 = list;
                EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    EmptyList.add(((ModalityTokenCount.Internal) it.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            return new CountTokensResponse(iIntValue, numValueOf, EmptyList);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(totalTokens=");
            sb.append(this.totalTokens);
            sb.append(", totalBillableCharacters=");
            sb.append(this.totalBillableCharacters);
            sb.append(", promptTokensDetails=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.promptTokensDetails, ')');
        }

        public Internal() {
            this((Integer) null, (Integer) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        public Internal(Integer num, Integer num2, List<ModalityTokenCount.Internal> list) {
            this.totalTokens = num;
            this.totalBillableCharacters = num2;
            this.promptTokensDetails = list;
        }

        public /* synthetic */ Internal(Integer num, Integer num2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : list);
        }
    }
}

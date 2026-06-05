package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.GroundingAttribution;
import com.google.firebase.ai.type.GroundingChunk;
import com.google.firebase.ai.type.GroundingSupport;
import com.google.firebase.ai.type.SearchEntryPoint;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u001aBW\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/google/firebase/ai/type/GroundingMetadata;", "", "webSearchQueries", "", "", "searchEntryPoint", "Lcom/google/firebase/ai/type/SearchEntryPoint;", "retrievalQueries", "groundingAttribution", "Lcom/google/firebase/ai/type/GroundingAttribution;", "groundingChunks", "Lcom/google/firebase/ai/type/GroundingChunk;", "groundingSupports", "Lcom/google/firebase/ai/type/GroundingSupport;", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/type/SearchEntryPoint;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getWebSearchQueries", "()Ljava/util/List;", "getSearchEntryPoint", "()Lcom/google/firebase/ai/type/SearchEntryPoint;", "getRetrievalQueries", "getGroundingAttribution$annotations", "()V", "getGroundingAttribution", "getGroundingChunks", "getGroundingSupports", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroundingMetadata {
    private final List<GroundingAttribution> groundingAttribution;
    private final List<GroundingChunk> groundingChunks;
    private final List<GroundingSupport> groundingSupports;
    private final List<String> retrievalQueries;
    private final SearchEntryPoint searchEntryPoint;
    private final List<String> webSearchQueries;

    public GroundingMetadata(List<String> list, SearchEntryPoint searchEntryPoint, List<String> list2, List<GroundingAttribution> list3, List<GroundingChunk> list4, List<GroundingSupport> list5) {
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        list5.getClass();
        this.webSearchQueries = list;
        this.searchEntryPoint = searchEntryPoint;
        this.retrievalQueries = list2;
        this.groundingAttribution = list3;
        this.groundingChunks = list4;
        this.groundingSupports = list5;
    }

    public static /* synthetic */ void getGroundingAttribution$annotations() {
    }

    public final List<GroundingAttribution> getGroundingAttribution() {
        return this.groundingAttribution;
    }

    public final List<GroundingChunk> getGroundingChunks() {
        return this.groundingChunks;
    }

    public final List<GroundingSupport> getGroundingSupports() {
        return this.groundingSupports;
    }

    public final List<String> getRetrievalQueries() {
        return this.retrievalQueries;
    }

    public final SearchEntryPoint getSearchEntryPoint() {
        return this.searchEntryPoint;
    }

    public final List<String> getWebSearchQueries() {
        return this.webSearchQueries;
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000267Ba\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fBu\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003HÆ\u0003Jo\u0010(\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0011HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u00068"}, d2 = {"Lcom/google/firebase/ai/type/GroundingMetadata$Internal;", "", "webSearchQueries", "", "", "searchEntryPoint", "Lcom/google/firebase/ai/type/SearchEntryPoint$Internal;", "retrievalQueries", "groundingAttribution", "Lcom/google/firebase/ai/type/GroundingAttribution$Internal;", "groundingChunks", "Lcom/google/firebase/ai/type/GroundingChunk$Internal;", "groundingSupports", "Lcom/google/firebase/ai/type/GroundingSupport$Internal;", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/type/SearchEntryPoint$Internal;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/google/firebase/ai/type/SearchEntryPoint$Internal;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWebSearchQueries", "()Ljava/util/List;", "getSearchEntryPoint", "()Lcom/google/firebase/ai/type/SearchEntryPoint$Internal;", "getRetrievalQueries", "getGroundingAttribution$annotations", "()V", "getGroundingAttribution", "getGroundingChunks", "getGroundingSupports", "toPublic", "Lcom/google/firebase/ai/type/GroundingMetadata;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<GroundingAttribution.Internal> groundingAttribution;
        private final List<GroundingChunk.Internal> groundingChunks;
        private final List<GroundingSupport.Internal> groundingSupports;
        private final List<String> retrievalQueries;
        private final SearchEntryPoint.Internal searchEntryPoint;
        private final List<String> webSearchQueries;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GroundingMetadata$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GroundingMetadata$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return GroundingMetadata$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), null, new ArrayListSerializer(stringSerializer), new ArrayListSerializer(GroundingAttribution$Internal$$serializer.INSTANCE), new ArrayListSerializer(GroundingChunk$Internal$$serializer.INSTANCE), new ArrayListSerializer(GroundingSupport$Internal$$serializer.INSTANCE)};
        }

        public /* synthetic */ Internal(int i, List list, SearchEntryPoint.Internal internal, List list2, List list3, List list4, List list5, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, GroundingMetadata$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.webSearchQueries = list;
            this.searchEntryPoint = internal;
            this.retrievalQueries = list2;
            this.groundingAttribution = list3;
            this.groundingChunks = list4;
            this.groundingSupports = list5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, List list, SearchEntryPoint.Internal internal2, List list2, List list3, List list4, List list5, int i, Object obj) {
            if ((i & 1) != 0) {
                list = internal.webSearchQueries;
            }
            if ((i & 2) != 0) {
                internal2 = internal.searchEntryPoint;
            }
            if ((i & 4) != 0) {
                list2 = internal.retrievalQueries;
            }
            if ((i & 8) != 0) {
                list3 = internal.groundingAttribution;
            }
            if ((i & 16) != 0) {
                list4 = internal.groundingChunks;
            }
            if ((i & 32) != 0) {
                list5 = internal.groundingSupports;
            }
            List list6 = list4;
            List list7 = list5;
            return internal.copy(list, internal2, list2, list3, list6, list7);
        }

        public static /* synthetic */ void getGroundingAttribution$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.webSearchQueries);
            output.encodeNullableSerializableElement(serialDesc, 1, SearchEntryPoint$Internal$$serializer.INSTANCE, self.searchEntryPoint);
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.retrievalQueries);
            output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.groundingAttribution);
            output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.groundingChunks);
            output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.groundingSupports);
        }

        public final List<String> component1() {
            return this.webSearchQueries;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SearchEntryPoint.Internal getSearchEntryPoint() {
            return this.searchEntryPoint;
        }

        public final List<String> component3() {
            return this.retrievalQueries;
        }

        public final List<GroundingAttribution.Internal> component4() {
            return this.groundingAttribution;
        }

        public final List<GroundingChunk.Internal> component5() {
            return this.groundingChunks;
        }

        public final List<GroundingSupport.Internal> component6() {
            return this.groundingSupports;
        }

        public final Internal copy(List<String> webSearchQueries, SearchEntryPoint.Internal searchEntryPoint, List<String> retrievalQueries, List<GroundingAttribution.Internal> groundingAttribution, List<GroundingChunk.Internal> groundingChunks, List<GroundingSupport.Internal> groundingSupports) {
            return new Internal(webSearchQueries, searchEntryPoint, retrievalQueries, groundingAttribution, groundingChunks, groundingSupports);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.webSearchQueries, internal.webSearchQueries) && Intrinsics.areEqual(this.searchEntryPoint, internal.searchEntryPoint) && Intrinsics.areEqual(this.retrievalQueries, internal.retrievalQueries) && Intrinsics.areEqual(this.groundingAttribution, internal.groundingAttribution) && Intrinsics.areEqual(this.groundingChunks, internal.groundingChunks) && Intrinsics.areEqual(this.groundingSupports, internal.groundingSupports);
        }

        public final List<GroundingAttribution.Internal> getGroundingAttribution() {
            return this.groundingAttribution;
        }

        public final List<GroundingChunk.Internal> getGroundingChunks() {
            return this.groundingChunks;
        }

        public final List<GroundingSupport.Internal> getGroundingSupports() {
            return this.groundingSupports;
        }

        public final List<String> getRetrievalQueries() {
            return this.retrievalQueries;
        }

        public final SearchEntryPoint.Internal getSearchEntryPoint() {
            return this.searchEntryPoint;
        }

        public final List<String> getWebSearchQueries() {
            return this.webSearchQueries;
        }

        public int hashCode() {
            List<String> list = this.webSearchQueries;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            SearchEntryPoint.Internal internal = this.searchEntryPoint;
            int iHashCode2 = (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31;
            List<String> list2 = this.retrievalQueries;
            int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<GroundingAttribution.Internal> list3 = this.groundingAttribution;
            int iHashCode4 = (iHashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
            List<GroundingChunk.Internal> list4 = this.groundingChunks;
            int iHashCode5 = (iHashCode4 + (list4 == null ? 0 : list4.hashCode())) * 31;
            List<GroundingSupport.Internal> list5 = this.groundingSupports;
            return iHashCode5 + (list5 != null ? list5.hashCode() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ArrayList] */
        public final GroundingMetadata toPublic$com_google_firebase_ai_logic_firebase_ai() {
            ?? EmptyList;
            ?? EmptyList2;
            List<String> listEmptyList = this.webSearchQueries;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<String> list = listEmptyList;
            SearchEntryPoint.Internal internal = this.searchEntryPoint;
            ?? EmptyList3 = 0;
            SearchEntryPoint public$com_google_firebase_ai_logic_firebase_ai = internal != null ? internal.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            List<String> listEmptyList2 = this.retrievalQueries;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            List<String> list2 = listEmptyList2;
            List<GroundingAttribution.Internal> list3 = this.groundingAttribution;
            if (list3 != null) {
                List<GroundingAttribution.Internal> list4 = list3;
                EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator it = list4.iterator();
                while (it.hasNext()) {
                    EmptyList.add(((GroundingAttribution.Internal) it.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList = 0;
            }
            if (EmptyList == 0) {
                EmptyList = CollectionsKt.emptyList();
            }
            List<GroundingChunk.Internal> list5 = this.groundingChunks;
            if (list5 != null) {
                List<GroundingChunk.Internal> list6 = list5;
                EmptyList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                Iterator it2 = list6.iterator();
                while (it2.hasNext()) {
                    EmptyList2.add(((GroundingChunk.Internal) it2.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList2 = 0;
            }
            if (EmptyList2 == 0) {
                EmptyList2 = CollectionsKt.emptyList();
            }
            List<GroundingSupport.Internal> list7 = this.groundingSupports;
            if (list7 != null) {
                List<GroundingSupport.Internal> list8 = list7;
                EmptyList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                Iterator it3 = list8.iterator();
                while (it3.hasNext()) {
                    EmptyList3.add(((GroundingSupport.Internal) it3.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            }
            if (EmptyList3 == 0) {
                EmptyList3 = CollectionsKt.emptyList();
            }
            return new GroundingMetadata(list, public$com_google_firebase_ai_logic_firebase_ai, list2, EmptyList, EmptyList2, CollectionsKt.filterNotNull((Iterable) EmptyList3));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(webSearchQueries=");
            sb.append(this.webSearchQueries);
            sb.append(", searchEntryPoint=");
            sb.append(this.searchEntryPoint);
            sb.append(", retrievalQueries=");
            sb.append(this.retrievalQueries);
            sb.append(", groundingAttribution=");
            sb.append(this.groundingAttribution);
            sb.append(", groundingChunks=");
            sb.append(this.groundingChunks);
            sb.append(", groundingSupports=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.groundingSupports, ')');
        }

        public Internal(List<String> list, SearchEntryPoint.Internal internal, List<String> list2, List<GroundingAttribution.Internal> list3, List<GroundingChunk.Internal> list4, List<GroundingSupport.Internal> list5) {
            this.webSearchQueries = list;
            this.searchEntryPoint = internal;
            this.retrievalQueries = list2;
            this.groundingAttribution = list3;
            this.groundingChunks = list4;
            this.groundingSupports = list5;
        }
    }
}

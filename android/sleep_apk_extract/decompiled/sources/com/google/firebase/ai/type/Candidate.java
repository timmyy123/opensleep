package com.google.firebase.ai.type;

import androidx.work.Data$$ExternalSyntheticLambda0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.ai.type.CitationMetadata;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.FinishReason;
import com.google.firebase.ai.type.GroundingMetadata;
import com.google.firebase.ai.type.SafetyRating;
import com.google.firebase.ai.type.UrlContextMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eBG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/ai/type/Candidate;", "", "content", "Lcom/google/firebase/ai/type/Content;", "safetyRatings", "", "Lcom/google/firebase/ai/type/SafetyRating;", "citationMetadata", "Lcom/google/firebase/ai/type/CitationMetadata;", "finishReason", "Lcom/google/firebase/ai/type/FinishReason;", "groundingMetadata", "Lcom/google/firebase/ai/type/GroundingMetadata;", "urlContextMetadata", "Lcom/google/firebase/ai/type/UrlContextMetadata;", "<init>", "(Lcom/google/firebase/ai/type/Content;Ljava/util/List;Lcom/google/firebase/ai/type/CitationMetadata;Lcom/google/firebase/ai/type/FinishReason;Lcom/google/firebase/ai/type/GroundingMetadata;Lcom/google/firebase/ai/type/UrlContextMetadata;)V", "getContent", "()Lcom/google/firebase/ai/type/Content;", "getSafetyRatings", "()Ljava/util/List;", "getCitationMetadata", "()Lcom/google/firebase/ai/type/CitationMetadata;", "getFinishReason", "()Lcom/google/firebase/ai/type/FinishReason;", "getGroundingMetadata", "()Lcom/google/firebase/ai/type/GroundingMetadata;", "getUrlContextMetadata", "()Lcom/google/firebase/ai/type/UrlContextMetadata;", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Candidate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CitationMetadata citationMetadata;
    private final Content content;
    private final FinishReason finishReason;
    private final GroundingMetadata groundingMetadata;
    private final List<SafetyRating> safetyRatings;
    private final UrlContextMetadata urlContextMetadata;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/ai/type/Candidate$Companion;", "", "<init>", "()V", "fromInterop", "Lcom/google/firebase/ai/type/Candidate;", "candidate", "Lcom/google/firebase/ai/ondevice/interop/Candidate;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final Unit fromInterop$lambda$0(com.google.firebase.ai.ondevice.interop.Candidate candidate, Content.Builder builder) {
            builder.getClass();
            throw null;
        }

        public final Candidate fromInterop(com.google.firebase.ai.ondevice.interop.Candidate candidate) {
            throw null;
        }

        private Companion() {
        }
    }

    public Candidate(Content content, List<SafetyRating> list, CitationMetadata citationMetadata, FinishReason finishReason, GroundingMetadata groundingMetadata, UrlContextMetadata urlContextMetadata) {
        content.getClass();
        list.getClass();
        this.content = content;
        this.safetyRatings = list;
        this.citationMetadata = citationMetadata;
        this.finishReason = finishReason;
        this.groundingMetadata = groundingMetadata;
        this.urlContextMetadata = urlContextMetadata;
    }

    public final CitationMetadata getCitationMetadata() {
        return this.citationMetadata;
    }

    public final Content getContent() {
        return this.content;
    }

    public final FinishReason getFinishReason() {
        return this.finishReason;
    }

    public final GroundingMetadata getGroundingMetadata() {
        return this.groundingMetadata;
    }

    public final List<SafetyRating> getSafetyRatings() {
        return this.safetyRatings;
    }

    public final UrlContextMetadata getUrlContextMetadata() {
        return this.urlContextMetadata;
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B]\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\r\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b$J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003JW\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0012HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006<"}, d2 = {"Lcom/google/firebase/ai/type/Candidate$Internal;", "", "content", "Lcom/google/firebase/ai/type/Content$Internal;", "finishReason", "Lcom/google/firebase/ai/type/FinishReason$Internal;", "safetyRatings", "", "Lcom/google/firebase/ai/type/SafetyRating$Internal;", "citationMetadata", "Lcom/google/firebase/ai/type/CitationMetadata$Internal;", "groundingMetadata", "Lcom/google/firebase/ai/type/GroundingMetadata$Internal;", "urlContextMetadata", "Lcom/google/firebase/ai/type/UrlContextMetadata$Internal;", "<init>", "(Lcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/FinishReason$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/CitationMetadata$Internal;Lcom/google/firebase/ai/type/GroundingMetadata$Internal;Lcom/google/firebase/ai/type/UrlContextMetadata$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/FinishReason$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/CitationMetadata$Internal;Lcom/google/firebase/ai/type/GroundingMetadata$Internal;Lcom/google/firebase/ai/type/UrlContextMetadata$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContent", "()Lcom/google/firebase/ai/type/Content$Internal;", "getFinishReason", "()Lcom/google/firebase/ai/type/FinishReason$Internal;", "getSafetyRatings", "()Ljava/util/List;", "getCitationMetadata", "()Lcom/google/firebase/ai/type/CitationMetadata$Internal;", "getGroundingMetadata", "()Lcom/google/firebase/ai/type/GroundingMetadata$Internal;", "getUrlContextMetadata", "()Lcom/google/firebase/ai/type/UrlContextMetadata$Internal;", "toPublic", "Lcom/google/firebase/ai/type/Candidate;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final CitationMetadata.Internal citationMetadata;
        private final Content.Internal content;
        private final FinishReason.Internal finishReason;
        private final GroundingMetadata.Internal groundingMetadata;
        private final List<SafetyRating.Internal> safetyRatings;
        private final UrlContextMetadata.Internal urlContextMetadata;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(SafetyRating$Internal$$serializer.INSTANCE), null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Candidate$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Candidate$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Candidate$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Content.Internal internal, FinishReason.Internal internal2, List list, CitationMetadata.Internal internal3, GroundingMetadata.Internal internal4, UrlContextMetadata.Internal internal5, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.content = null;
            } else {
                this.content = internal;
            }
            if ((i & 2) == 0) {
                this.finishReason = null;
            } else {
                this.finishReason = internal2;
            }
            if ((i & 4) == 0) {
                this.safetyRatings = null;
            } else {
                this.safetyRatings = list;
            }
            if ((i & 8) == 0) {
                this.citationMetadata = null;
            } else {
                this.citationMetadata = internal3;
            }
            if ((i & 16) == 0) {
                this.groundingMetadata = null;
            } else {
                this.groundingMetadata = internal4;
            }
            if ((i & 32) == 0) {
                this.urlContextMetadata = null;
            } else {
                this.urlContextMetadata = internal5;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Content.Internal internal2, FinishReason.Internal internal3, List list, CitationMetadata.Internal internal4, GroundingMetadata.Internal internal5, UrlContextMetadata.Internal internal6, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.content;
            }
            if ((i & 2) != 0) {
                internal3 = internal.finishReason;
            }
            if ((i & 4) != 0) {
                list = internal.safetyRatings;
            }
            if ((i & 8) != 0) {
                internal4 = internal.citationMetadata;
            }
            if ((i & 16) != 0) {
                internal5 = internal.groundingMetadata;
            }
            if ((i & 32) != 0) {
                internal6 = internal.urlContextMetadata;
            }
            GroundingMetadata.Internal internal7 = internal5;
            UrlContextMetadata.Internal internal8 = internal6;
            return internal.copy(internal2, internal3, list, internal4, internal7, internal8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit toPublic$lambda$1(Content.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.content != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, Content$Internal$$serializer.INSTANCE, self.content);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.finishReason != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, FinishReason.Internal.Serializer.INSTANCE, self.finishReason);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.safetyRatings != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.safetyRatings);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.citationMetadata != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, CitationMetadata$Internal$$serializer.INSTANCE, self.citationMetadata);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.groundingMetadata != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, GroundingMetadata$Internal$$serializer.INSTANCE, self.groundingMetadata);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.urlContextMetadata == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, UrlContextMetadata$Internal$$serializer.INSTANCE, self.urlContextMetadata);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Content.Internal getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FinishReason.Internal getFinishReason() {
            return this.finishReason;
        }

        public final List<SafetyRating.Internal> component3() {
            return this.safetyRatings;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CitationMetadata.Internal getCitationMetadata() {
            return this.citationMetadata;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final GroundingMetadata.Internal getGroundingMetadata() {
            return this.groundingMetadata;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final UrlContextMetadata.Internal getUrlContextMetadata() {
            return this.urlContextMetadata;
        }

        public final Internal copy(Content.Internal content, FinishReason.Internal finishReason, List<SafetyRating.Internal> safetyRatings, CitationMetadata.Internal citationMetadata, GroundingMetadata.Internal groundingMetadata, UrlContextMetadata.Internal urlContextMetadata) {
            return new Internal(content, finishReason, safetyRatings, citationMetadata, groundingMetadata, urlContextMetadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.content, internal.content) && this.finishReason == internal.finishReason && Intrinsics.areEqual(this.safetyRatings, internal.safetyRatings) && Intrinsics.areEqual(this.citationMetadata, internal.citationMetadata) && Intrinsics.areEqual(this.groundingMetadata, internal.groundingMetadata) && Intrinsics.areEqual(this.urlContextMetadata, internal.urlContextMetadata);
        }

        public final CitationMetadata.Internal getCitationMetadata() {
            return this.citationMetadata;
        }

        public final Content.Internal getContent() {
            return this.content;
        }

        public final FinishReason.Internal getFinishReason() {
            return this.finishReason;
        }

        public final GroundingMetadata.Internal getGroundingMetadata() {
            return this.groundingMetadata;
        }

        public final List<SafetyRating.Internal> getSafetyRatings() {
            return this.safetyRatings;
        }

        public final UrlContextMetadata.Internal getUrlContextMetadata() {
            return this.urlContextMetadata;
        }

        public int hashCode() {
            Content.Internal internal = this.content;
            int iHashCode = (internal == null ? 0 : internal.hashCode()) * 31;
            FinishReason.Internal internal2 = this.finishReason;
            int iHashCode2 = (iHashCode + (internal2 == null ? 0 : internal2.hashCode())) * 31;
            List<SafetyRating.Internal> list = this.safetyRatings;
            int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            CitationMetadata.Internal internal3 = this.citationMetadata;
            int iHashCode4 = (iHashCode3 + (internal3 == null ? 0 : internal3.hashCode())) * 31;
            GroundingMetadata.Internal internal4 = this.groundingMetadata;
            int iHashCode5 = (iHashCode4 + (internal4 == null ? 0 : internal4.hashCode())) * 31;
            UrlContextMetadata.Internal internal5 = this.urlContextMetadata;
            return iHashCode5 + (internal5 != null ? internal5.hashCode() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
        public final Candidate toPublic$com_google_firebase_ai_logic_firebase_ai() {
            ?? EmptyList;
            Content content;
            List<SafetyRating.Internal> list = this.safetyRatings;
            if (list != null) {
                EmptyList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    SafetyRating public$com_google_firebase_ai_logic_firebase_ai = ((SafetyRating.Internal) it.next()).toPublic$com_google_firebase_ai_logic_firebase_ai();
                    if (public$com_google_firebase_ai_logic_firebase_ai != null) {
                        EmptyList.add(public$com_google_firebase_ai_logic_firebase_ai);
                    }
                }
            } else {
                EmptyList = 0;
            }
            if (EmptyList == 0) {
                EmptyList = CollectionsKt.emptyList();
            }
            ?? r5 = EmptyList;
            CitationMetadata.Internal internal = this.citationMetadata;
            CitationMetadata public$com_google_firebase_ai_logic_firebase_ai2 = internal != null ? internal.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            FinishReason.Internal internal2 = this.finishReason;
            FinishReason public$com_google_firebase_ai_logic_firebase_ai3 = internal2 != null ? internal2.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            GroundingMetadata.Internal internal3 = this.groundingMetadata;
            GroundingMetadata public$com_google_firebase_ai_logic_firebase_ai4 = internal3 != null ? internal3.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            UrlContextMetadata.Internal internal4 = this.urlContextMetadata;
            UrlContextMetadata public$com_google_firebase_ai_logic_firebase_ai5 = internal4 != null ? internal4.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            Content.Internal internal5 = this.content;
            if (internal5 == null || (content = internal5.toPublic$com_google_firebase_ai_logic_firebase_ai()) == null) {
                content = ContentKt.content(DeviceRequestsHelper.DEVICE_INFO_MODEL, new Data$$ExternalSyntheticLambda0(18));
            }
            return new Candidate(content, r5, public$com_google_firebase_ai_logic_firebase_ai2, public$com_google_firebase_ai_logic_firebase_ai3, public$com_google_firebase_ai_logic_firebase_ai4, public$com_google_firebase_ai_logic_firebase_ai5);
        }

        public String toString() {
            return "Internal(content=" + this.content + ", finishReason=" + this.finishReason + ", safetyRatings=" + this.safetyRatings + ", citationMetadata=" + this.citationMetadata + ", groundingMetadata=" + this.groundingMetadata + ", urlContextMetadata=" + this.urlContextMetadata + ')';
        }

        public Internal() {
            this((Content.Internal) null, (FinishReason.Internal) null, (List) null, (CitationMetadata.Internal) null, (GroundingMetadata.Internal) null, (UrlContextMetadata.Internal) null, 63, (DefaultConstructorMarker) null);
        }

        public Internal(Content.Internal internal, FinishReason.Internal internal2, List<SafetyRating.Internal> list, CitationMetadata.Internal internal3, GroundingMetadata.Internal internal4, UrlContextMetadata.Internal internal5) {
            this.content = internal;
            this.finishReason = internal2;
            this.safetyRatings = list;
            this.citationMetadata = internal3;
            this.groundingMetadata = internal4;
            this.urlContextMetadata = internal5;
        }

        public /* synthetic */ Internal(Content.Internal internal, FinishReason.Internal internal2, List list, CitationMetadata.Internal internal3, GroundingMetadata.Internal internal4, UrlContextMetadata.Internal internal5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : internal, (i & 2) != 0 ? null : internal2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : internal3, (i & 16) != 0 ? null : internal4, (i & 32) != 0 ? null : internal5);
        }
    }
}

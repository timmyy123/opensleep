package com.google.firebase.ai.type;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.HarmCategory;
import com.google.firebase.ai.type.HarmProbability;
import com.google.firebase.ai.type.HarmSeverity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u001dBG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/ai/type/SafetyRating;", "", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "Lcom/google/firebase/ai/type/HarmCategory;", "probability", "Lcom/google/firebase/ai/type/HarmProbability;", "probabilityScore", "", "blocked", "", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/firebase/ai/type/HarmSeverity;", "severityScore", "<init>", "(Lcom/google/firebase/ai/type/HarmCategory;Lcom/google/firebase/ai/type/HarmProbability;FLjava/lang/Boolean;Lcom/google/firebase/ai/type/HarmSeverity;Ljava/lang/Float;)V", "getCategory", "()Lcom/google/firebase/ai/type/HarmCategory;", "getProbability", "()Lcom/google/firebase/ai/type/HarmProbability;", "getProbabilityScore", "()F", "getBlocked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSeverity", "()Lcom/google/firebase/ai/type/HarmSeverity;", "getSeverityScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SafetyRating {
    private final Boolean blocked;
    private final HarmCategory category;
    private final HarmProbability probability;
    private final float probabilityScore;
    private final HarmSeverity severity;
    private final Float severityScore;

    public /* synthetic */ SafetyRating(HarmCategory harmCategory, HarmProbability harmProbability, float f, Boolean bool, HarmSeverity harmSeverity, Float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(harmCategory, harmProbability, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : harmSeverity, (i & 32) != 0 ? null : f2);
    }

    public final Boolean getBlocked() {
        return this.blocked;
    }

    public final HarmCategory getCategory() {
        return this.category;
    }

    public final HarmProbability getProbability() {
        return this.probability;
    }

    public final float getProbabilityScore() {
        return this.probabilityScore;
    }

    public final HarmSeverity getSeverity() {
        return this.severity;
    }

    public final Float getSeverityScore() {
        return this.severityScore;
    }

    public SafetyRating(HarmCategory harmCategory, HarmProbability harmProbability, float f, Boolean bool, HarmSeverity harmSeverity, Float f2) {
        harmCategory.getClass();
        harmProbability.getClass();
        this.category = harmCategory;
        this.probability = harmProbability;
        this.probabilityScore = f;
        this.blocked = bool;
        this.severity = harmSeverity;
        this.severityScore = f2;
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 :2\u00020\u0001:\u00029:BQ\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010!\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0002\b#J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJV\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001c¨\u0006;"}, d2 = {"Lcom/google/firebase/ai/type/SafetyRating$Internal;", "", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "Lcom/google/firebase/ai/type/HarmCategory$Internal;", "probability", "Lcom/google/firebase/ai/type/HarmProbability$Internal;", "blocked", "", "probabilityScore", "", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/google/firebase/ai/type/HarmSeverity$Internal;", "severityScore", "<init>", "(Lcom/google/firebase/ai/type/HarmCategory$Internal;Lcom/google/firebase/ai/type/HarmProbability$Internal;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/google/firebase/ai/type/HarmSeverity$Internal;Ljava/lang/Float;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/HarmCategory$Internal;Lcom/google/firebase/ai/type/HarmProbability$Internal;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/google/firebase/ai/type/HarmSeverity$Internal;Ljava/lang/Float;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCategory", "()Lcom/google/firebase/ai/type/HarmCategory$Internal;", "getProbability", "()Lcom/google/firebase/ai/type/HarmProbability$Internal;", "getBlocked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProbabilityScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSeverity", "()Lcom/google/firebase/ai/type/HarmSeverity$Internal;", "getSeverityScore", "toPublic", "Lcom/google/firebase/ai/type/SafetyRating;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/google/firebase/ai/type/HarmCategory$Internal;Lcom/google/firebase/ai/type/HarmProbability$Internal;Ljava/lang/Boolean;Ljava/lang/Float;Lcom/google/firebase/ai/type/HarmSeverity$Internal;Ljava/lang/Float;)Lcom/google/firebase/ai/type/SafetyRating$Internal;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean blocked;
        private final HarmCategory.Internal category;
        private final HarmProbability.Internal probability;
        private final Float probabilityScore;
        private final HarmSeverity.Internal severity;
        private final Float severityScore;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/SafetyRating$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/SafetyRating$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return SafetyRating$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, HarmCategory.Internal internal, HarmProbability.Internal internal2, Boolean bool, Float f, HarmSeverity.Internal internal3, Float f2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.category = null;
            } else {
                this.category = internal;
            }
            if ((i & 2) == 0) {
                this.probability = null;
            } else {
                this.probability = internal2;
            }
            if ((i & 4) == 0) {
                this.blocked = null;
            } else {
                this.blocked = bool;
            }
            if ((i & 8) == 0) {
                this.probabilityScore = null;
            } else {
                this.probabilityScore = f;
            }
            if ((i & 16) == 0) {
                this.severity = null;
            } else {
                this.severity = internal3;
            }
            if ((i & 32) == 0) {
                this.severityScore = null;
            } else {
                this.severityScore = f2;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, HarmCategory.Internal internal2, HarmProbability.Internal internal3, Boolean bool, Float f, HarmSeverity.Internal internal4, Float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.category;
            }
            if ((i & 2) != 0) {
                internal3 = internal.probability;
            }
            if ((i & 4) != 0) {
                bool = internal.blocked;
            }
            if ((i & 8) != 0) {
                f = internal.probabilityScore;
            }
            if ((i & 16) != 0) {
                internal4 = internal.severity;
            }
            if ((i & 32) != 0) {
                f2 = internal.severityScore;
            }
            HarmSeverity.Internal internal5 = internal4;
            Float f3 = f2;
            return internal.copy(internal2, internal3, bool, f, internal5, f3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.category != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, HarmCategory.Internal.Serializer.INSTANCE, self.category);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.probability != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, HarmProbability.Internal.Serializer.INSTANCE, self.probability);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.blocked != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.blocked);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.probabilityScore != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, FloatSerializer.INSTANCE, self.probabilityScore);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.severity != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, HarmSeverity.Internal.Serializer.INSTANCE, self.severity);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.severityScore == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, FloatSerializer.INSTANCE, self.severityScore);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HarmCategory.Internal getCategory() {
            return this.category;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final HarmProbability.Internal getProbability() {
            return this.probability;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getBlocked() {
            return this.blocked;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Float getProbabilityScore() {
            return this.probabilityScore;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final HarmSeverity.Internal getSeverity() {
            return this.severity;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Float getSeverityScore() {
            return this.severityScore;
        }

        public final Internal copy(HarmCategory.Internal category, HarmProbability.Internal probability, Boolean blocked, Float probabilityScore, HarmSeverity.Internal severity, Float severityScore) {
            return new Internal(category, probability, blocked, probabilityScore, severity, severityScore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return this.category == internal.category && this.probability == internal.probability && Intrinsics.areEqual(this.blocked, internal.blocked) && Intrinsics.areEqual((Object) this.probabilityScore, (Object) internal.probabilityScore) && this.severity == internal.severity && Intrinsics.areEqual((Object) this.severityScore, (Object) internal.severityScore);
        }

        public final Boolean getBlocked() {
            return this.blocked;
        }

        public final HarmCategory.Internal getCategory() {
            return this.category;
        }

        public final HarmProbability.Internal getProbability() {
            return this.probability;
        }

        public final Float getProbabilityScore() {
            return this.probabilityScore;
        }

        public final HarmSeverity.Internal getSeverity() {
            return this.severity;
        }

        public final Float getSeverityScore() {
            return this.severityScore;
        }

        public int hashCode() {
            HarmCategory.Internal internal = this.category;
            int iHashCode = (internal == null ? 0 : internal.hashCode()) * 31;
            HarmProbability.Internal internal2 = this.probability;
            int iHashCode2 = (iHashCode + (internal2 == null ? 0 : internal2.hashCode())) * 31;
            Boolean bool = this.blocked;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Float f = this.probabilityScore;
            int iHashCode4 = (iHashCode3 + (f == null ? 0 : f.hashCode())) * 31;
            HarmSeverity.Internal internal3 = this.severity;
            int iHashCode5 = (iHashCode4 + (internal3 == null ? 0 : internal3.hashCode())) * 31;
            Float f2 = this.severityScore;
            return iHashCode5 + (f2 != null ? f2.hashCode() : 0);
        }

        public final SafetyRating toPublic$com_google_firebase_ai_logic_firebase_ai() {
            HarmCategory.Internal internal = this.category;
            if (internal == null || this.probability == null) {
                return null;
            }
            HarmCategory public$com_google_firebase_ai_logic_firebase_ai = internal.toPublic$com_google_firebase_ai_logic_firebase_ai();
            HarmProbability public$com_google_firebase_ai_logic_firebase_ai2 = this.probability.toPublic$com_google_firebase_ai_logic_firebase_ai();
            Float f = this.probabilityScore;
            float fFloatValue = f != null ? f.floatValue() : 0.0f;
            Boolean bool = this.blocked;
            HarmSeverity.Internal internal2 = this.severity;
            return new SafetyRating(public$com_google_firebase_ai_logic_firebase_ai, public$com_google_firebase_ai_logic_firebase_ai2, fFloatValue, bool, internal2 != null ? internal2.toPublic$com_google_firebase_ai_logic_firebase_ai() : null, this.severityScore);
        }

        public String toString() {
            return "Internal(category=" + this.category + ", probability=" + this.probability + ", blocked=" + this.blocked + ", probabilityScore=" + this.probabilityScore + ", severity=" + this.severity + ", severityScore=" + this.severityScore + ')';
        }

        public Internal(HarmCategory.Internal internal) {
            this(internal, (HarmProbability.Internal) null, (Boolean) null, (Float) null, (HarmSeverity.Internal) null, (Float) null, 62, (DefaultConstructorMarker) null);
        }

        public Internal(HarmCategory.Internal internal, HarmProbability.Internal internal2) {
            this(internal, internal2, (Boolean) null, (Float) null, (HarmSeverity.Internal) null, (Float) null, 60, (DefaultConstructorMarker) null);
        }

        public Internal(HarmCategory.Internal internal, HarmProbability.Internal internal2, Boolean bool) {
            this(internal, internal2, bool, (Float) null, (HarmSeverity.Internal) null, (Float) null, 56, (DefaultConstructorMarker) null);
        }

        public Internal(HarmCategory.Internal internal, HarmProbability.Internal internal2, Boolean bool, Float f) {
            this(internal, internal2, bool, f, (HarmSeverity.Internal) null, (Float) null, 48, (DefaultConstructorMarker) null);
        }

        public Internal(HarmCategory.Internal internal, HarmProbability.Internal internal2, Boolean bool, Float f, HarmSeverity.Internal internal3) {
            this(internal, internal2, bool, f, internal3, (Float) null, 32, (DefaultConstructorMarker) null);
        }

        public Internal() {
            this((HarmCategory.Internal) null, (HarmProbability.Internal) null, (Boolean) null, (Float) null, (HarmSeverity.Internal) null, (Float) null, 63, (DefaultConstructorMarker) null);
        }

        public Internal(HarmCategory.Internal internal, HarmProbability.Internal internal2, Boolean bool, Float f, HarmSeverity.Internal internal3, Float f2) {
            this.category = internal;
            this.probability = internal2;
            this.blocked = bool;
            this.probabilityScore = f;
            this.severity = internal3;
            this.severityScore = f2;
        }

        public /* synthetic */ Internal(HarmCategory.Internal internal, HarmProbability.Internal internal2, Boolean bool, Float f, HarmSeverity.Internal internal3, Float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : internal, (i & 2) != 0 ? null : internal2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : f, (i & 16) != 0 ? null : internal3, (i & 32) != 0 ? null : f2);
        }
    }
}

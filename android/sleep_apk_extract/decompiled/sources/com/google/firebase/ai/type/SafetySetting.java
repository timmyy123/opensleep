package com.google.firebase.ai.type;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.HarmBlockMethod;
import com.google.firebase.ai.type.HarmBlockThreshold;
import com.google.firebase.ai.type.HarmCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/ai/type/SafetySetting;", "", "harmCategory", "Lcom/google/firebase/ai/type/HarmCategory;", "threshold", "Lcom/google/firebase/ai/type/HarmBlockThreshold;", "method", "Lcom/google/firebase/ai/type/HarmBlockMethod;", "<init>", "(Lcom/google/firebase/ai/type/HarmCategory;Lcom/google/firebase/ai/type/HarmBlockThreshold;Lcom/google/firebase/ai/type/HarmBlockMethod;)V", "getHarmCategory$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/HarmCategory;", "getThreshold$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/HarmBlockThreshold;", "getMethod$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/HarmBlockMethod;", "toInternal", "Lcom/google/firebase/ai/type/SafetySetting$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SafetySetting {
    private final HarmCategory harmCategory;
    private final HarmBlockMethod method;
    private final HarmBlockThreshold threshold;

    public SafetySetting(HarmCategory harmCategory, HarmBlockThreshold harmBlockThreshold, HarmBlockMethod harmBlockMethod) {
        harmCategory.getClass();
        harmBlockThreshold.getClass();
        this.harmCategory = harmCategory;
        this.threshold = harmBlockThreshold;
        this.method = harmBlockMethod;
    }

    /* JADX INFO: renamed from: getHarmCategory$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final HarmCategory getHarmCategory() {
        return this.harmCategory;
    }

    /* JADX INFO: renamed from: getMethod$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final HarmBlockMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: getThreshold$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final HarmBlockThreshold getThreshold() {
        return this.threshold;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        HarmCategory.Internal internal$com_google_firebase_ai_logic_firebase_ai = this.harmCategory.toInternal$com_google_firebase_ai_logic_firebase_ai();
        HarmBlockThreshold.Internal internal$com_google_firebase_ai_logic_firebase_ai2 = this.threshold.toInternal$com_google_firebase_ai_logic_firebase_ai();
        HarmBlockMethod harmBlockMethod = this.method;
        return new Internal(internal$com_google_firebase_ai_logic_firebase_ai, internal$com_google_firebase_ai_logic_firebase_ai2, harmBlockMethod != null ? harmBlockMethod.toInternal$com_google_firebase_ai_logic_firebase_ai() : null);
    }

    public /* synthetic */ SafetySetting(HarmCategory harmCategory, HarmBlockThreshold harmBlockThreshold, HarmBlockMethod harmBlockMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(harmCategory, harmBlockThreshold, (i & 4) != 0 ? null : harmBlockMethod);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/google/firebase/ai/type/SafetySetting$Internal;", "", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "Lcom/google/firebase/ai/type/HarmCategory$Internal;", "threshold", "Lcom/google/firebase/ai/type/HarmBlockThreshold$Internal;", "method", "Lcom/google/firebase/ai/type/HarmBlockMethod$Internal;", "<init>", "(Lcom/google/firebase/ai/type/HarmCategory$Internal;Lcom/google/firebase/ai/type/HarmBlockThreshold$Internal;Lcom/google/firebase/ai/type/HarmBlockMethod$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/HarmCategory$Internal;Lcom/google/firebase/ai/type/HarmBlockThreshold$Internal;Lcom/google/firebase/ai/type/HarmBlockMethod$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCategory", "()Lcom/google/firebase/ai/type/HarmCategory$Internal;", "getThreshold", "()Lcom/google/firebase/ai/type/HarmBlockThreshold$Internal;", "getMethod", "()Lcom/google/firebase/ai/type/HarmBlockMethod$Internal;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final HarmCategory.Internal category;
        private final HarmBlockMethod.Internal method;
        private final HarmBlockThreshold.Internal threshold;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, HarmBlockThreshold.Internal.INSTANCE.serializer(), HarmBlockMethod.Internal.INSTANCE.serializer()};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/SafetySetting$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/SafetySetting$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return SafetySetting$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, HarmCategory.Internal internal, HarmBlockThreshold.Internal internal2, HarmBlockMethod.Internal internal3, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, SafetySetting$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.category = internal;
            this.threshold = internal2;
            if ((i & 4) == 0) {
                this.method = null;
            } else {
                this.method = internal3;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, HarmCategory.Internal internal2, HarmBlockThreshold.Internal internal3, HarmBlockMethod.Internal internal4, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.category;
            }
            if ((i & 2) != 0) {
                internal3 = internal.threshold;
            }
            if ((i & 4) != 0) {
                internal4 = internal.method;
            }
            return internal.copy(internal2, internal3, internal4);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, HarmCategory.Internal.Serializer.INSTANCE, self.category);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.threshold);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.method == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.method);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HarmCategory.Internal getCategory() {
            return this.category;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final HarmBlockThreshold.Internal getThreshold() {
            return this.threshold;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final HarmBlockMethod.Internal getMethod() {
            return this.method;
        }

        public final Internal copy(HarmCategory.Internal category, HarmBlockThreshold.Internal threshold, HarmBlockMethod.Internal method) {
            category.getClass();
            threshold.getClass();
            return new Internal(category, threshold, method);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return this.category == internal.category && this.threshold == internal.threshold && this.method == internal.method;
        }

        public final HarmCategory.Internal getCategory() {
            return this.category;
        }

        public final HarmBlockMethod.Internal getMethod() {
            return this.method;
        }

        public final HarmBlockThreshold.Internal getThreshold() {
            return this.threshold;
        }

        public int hashCode() {
            int iHashCode = (this.threshold.hashCode() + (this.category.hashCode() * 31)) * 31;
            HarmBlockMethod.Internal internal = this.method;
            return iHashCode + (internal == null ? 0 : internal.hashCode());
        }

        public String toString() {
            return "Internal(category=" + this.category + ", threshold=" + this.threshold + ", method=" + this.method + ')';
        }

        public Internal(HarmCategory.Internal internal, HarmBlockThreshold.Internal internal2, HarmBlockMethod.Internal internal3) {
            internal.getClass();
            internal2.getClass();
            this.category = internal;
            this.threshold = internal2;
            this.method = internal3;
        }

        public /* synthetic */ Internal(HarmCategory.Internal internal, HarmBlockThreshold.Internal internal2, HarmBlockMethod.Internal internal3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(internal, internal2, (i & 4) != 0 ? null : internal3);
        }
    }
}

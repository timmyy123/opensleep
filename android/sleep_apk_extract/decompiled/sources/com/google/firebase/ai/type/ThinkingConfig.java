package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.ThinkingLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B-\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingConfig;", "", "thinkingBudget", "", "includeThoughts", "", "thinkingLevel", "Lcom/google/firebase/ai/type/ThinkingLevel;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ThinkingLevel;)V", "getThinkingBudget$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIncludeThoughts$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThinkingLevel$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ThinkingLevel;", "toInternal", "Lcom/google/firebase/ai/type/ThinkingConfig$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Builder", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThinkingConfig {
    private final Boolean includeThoughts;
    private final Integer thinkingBudget;
    private final ThinkingLevel thinkingLevel;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingConfig$Builder;", "", "<init>", "()V", "thinkingBudget", "", "Ljava/lang/Integer;", "includeThoughts", "", "Ljava/lang/Boolean;", "thinkingLevel", "Lcom/google/firebase/ai/type/ThinkingLevel;", "setThinkingBudget", "setThinkingLevel", "setIncludeThoughts", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/ThinkingConfig;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public Boolean includeThoughts;
        public Integer thinkingBudget;
        public ThinkingLevel thinkingLevel;

        public final ThinkingConfig build() {
            Integer num = this.thinkingBudget;
            if (num == null || this.thinkingLevel == null) {
                return new ThinkingConfig(num, this.includeThoughts, this.thinkingLevel, null);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("`thinkingBudget` already set. Cannot set both `thinkingBudget` and `thinkingLevel`");
            return null;
        }

        public final Builder setIncludeThoughts(boolean includeThoughts) {
            this.includeThoughts = Boolean.valueOf(includeThoughts);
            return this;
        }

        public final Builder setThinkingBudget(int thinkingBudget) {
            this.thinkingBudget = Integer.valueOf(thinkingBudget);
            return this;
        }

        public final Builder setThinkingLevel(ThinkingLevel thinkingLevel) {
            thinkingLevel.getClass();
            this.thinkingLevel = thinkingLevel;
            return this;
        }
    }

    public /* synthetic */ ThinkingConfig(Integer num, Boolean bool, ThinkingLevel thinkingLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : thinkingLevel);
    }

    /* JADX INFO: renamed from: getIncludeThoughts$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Boolean getIncludeThoughts() {
        return this.includeThoughts;
    }

    /* JADX INFO: renamed from: getThinkingBudget$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getThinkingBudget() {
        return this.thinkingBudget;
    }

    /* JADX INFO: renamed from: getThinkingLevel$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ThinkingLevel getThinkingLevel() {
        return this.thinkingLevel;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        Integer num = this.thinkingBudget;
        Boolean bool = this.includeThoughts;
        ThinkingLevel thinkingLevel = this.thinkingLevel;
        return new Internal(num, bool, thinkingLevel != null ? thinkingLevel.toInternal$com_google_firebase_ai_logic_firebase_ai() : null);
    }

    private ThinkingConfig(Integer num, Boolean bool, ThinkingLevel thinkingLevel) {
        this.thinkingBudget = num;
        this.includeThoughts = bool;
        this.thinkingLevel = thinkingLevel;
    }

    public /* synthetic */ ThinkingConfig(Integer num, Boolean bool, ThinkingLevel thinkingLevel, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, bool, thinkingLevel);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingConfig$Internal;", "", "thinkingBudget", "", "includeThoughts", "", "thinkingLevel", "Lcom/google/firebase/ai/type/ThinkingLevel$Internal;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ThinkingLevel$Internal;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ThinkingLevel$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThinkingBudget$annotations", "()V", "getThinkingBudget", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIncludeThoughts", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThinkingLevel$annotations", "getThinkingLevel", "()Lcom/google/firebase/ai/type/ThinkingLevel$Internal;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/google/firebase/ai/type/ThinkingLevel$Internal;)Lcom/google/firebase/ai/type/ThinkingConfig$Internal;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final Boolean includeThoughts;
        private final Integer thinkingBudget;
        private final ThinkingLevel.Internal thinkingLevel;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, ThinkingLevel.Internal.INSTANCE.serializer()};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/ThinkingConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/ThinkingConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return ThinkingConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Integer num, Boolean bool, ThinkingLevel.Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.thinkingBudget = null;
            } else {
                this.thinkingBudget = num;
            }
            if ((i & 2) == 0) {
                this.includeThoughts = null;
            } else {
                this.includeThoughts = bool;
            }
            if ((i & 4) == 0) {
                this.thinkingLevel = null;
            } else {
                this.thinkingLevel = internal;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, Integer num, Boolean bool, ThinkingLevel.Internal internal2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = internal.thinkingBudget;
            }
            if ((i & 2) != 0) {
                bool = internal.includeThoughts;
            }
            if ((i & 4) != 0) {
                internal2 = internal.thinkingLevel;
            }
            return internal.copy(num, bool, internal2);
        }

        @SerialName("thinking_budget")
        public static /* synthetic */ void getThinkingBudget$annotations() {
        }

        @SerialName("thinking_level")
        public static /* synthetic */ void getThinkingLevel$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.thinkingBudget != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.thinkingBudget);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.includeThoughts != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.includeThoughts);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.thinkingLevel == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.thinkingLevel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getThinkingBudget() {
            return this.thinkingBudget;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIncludeThoughts() {
            return this.includeThoughts;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ThinkingLevel.Internal getThinkingLevel() {
            return this.thinkingLevel;
        }

        public final Internal copy(Integer thinkingBudget, Boolean includeThoughts, ThinkingLevel.Internal thinkingLevel) {
            return new Internal(thinkingBudget, includeThoughts, thinkingLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.thinkingBudget, internal.thinkingBudget) && Intrinsics.areEqual(this.includeThoughts, internal.includeThoughts) && this.thinkingLevel == internal.thinkingLevel;
        }

        public final Boolean getIncludeThoughts() {
            return this.includeThoughts;
        }

        public final Integer getThinkingBudget() {
            return this.thinkingBudget;
        }

        public final ThinkingLevel.Internal getThinkingLevel() {
            return this.thinkingLevel;
        }

        public int hashCode() {
            Integer num = this.thinkingBudget;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.includeThoughts;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            ThinkingLevel.Internal internal = this.thinkingLevel;
            return iHashCode2 + (internal != null ? internal.hashCode() : 0);
        }

        public String toString() {
            return "Internal(thinkingBudget=" + this.thinkingBudget + ", includeThoughts=" + this.includeThoughts + ", thinkingLevel=" + this.thinkingLevel + ')';
        }

        public Internal() {
            this((Integer) null, (Boolean) null, (ThinkingLevel.Internal) null, 7, (DefaultConstructorMarker) null);
        }

        public Internal(Integer num, Boolean bool, ThinkingLevel.Internal internal) {
            this.thinkingBudget = num;
            this.includeThoughts = bool;
            this.thinkingLevel = internal;
        }

        public /* synthetic */ Internal(Integer num, Boolean bool, ThinkingLevel.Internal internal, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : internal);
        }
    }
}

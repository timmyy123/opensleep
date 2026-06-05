package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.InlineData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0015B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/google/firebase/ai/type/InlineDataPart;", "Lcom/google/firebase/ai/type/Part;", "inlineData", "", "mimeType", "", "displayName", "isThought", "", "thoughtSignature", "<init>", "([BLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "([BLjava/lang/String;)V", "([BLjava/lang/String;Ljava/lang/String;)V", "getInlineData", "()[B", "getMimeType", "()Ljava/lang/String;", "getDisplayName", "()Z", "getThoughtSignature$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InlineDataPart implements Part {
    private final String displayName;
    private final byte[] inlineData;
    private final boolean isThought;
    private final String mimeType;
    private final String thoughtSignature;

    public InlineDataPart(byte[] bArr, String str, String str2, boolean z, String str3) {
        bArr.getClass();
        str.getClass();
        this.inlineData = bArr;
        this.mimeType = str;
        this.displayName = str2;
        this.isThought = z;
        this.thoughtSignature = str3;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final byte[] getInlineData() {
        return this.inlineData;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: getThoughtSignature$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getThoughtSignature() {
        return this.thoughtSignature;
    }

    @Override // com.google.firebase.ai.type.Part
    /* JADX INFO: renamed from: isThought, reason: from getter */
    public boolean getIsThought() {
        return this.isThought;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InlineDataPart(byte[] bArr, String str) {
        this(bArr, str, null, false, null);
        bArr.getClass();
        str.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InlineDataPart(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, false, null);
        bArr.getClass();
        str.getClass();
        str2.getClass();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/google/firebase/ai/type/InlineDataPart$Internal;", "Lcom/google/firebase/ai/type/InternalPart;", "inlineData", "Lcom/google/firebase/ai/type/InlineData$Internal;", "thought", "", "thoughtSignature", "", "<init>", "(Lcom/google/firebase/ai/type/InlineData$Internal;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/InlineData$Internal;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInlineData$annotations", "()V", "getInlineData", "()Lcom/google/firebase/ai/type/InlineData$Internal;", "getThought", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThoughtSignature", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/google/firebase/ai/type/InlineData$Internal;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/google/firebase/ai/type/InlineDataPart$Internal;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal implements InternalPart {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final InlineData.Internal inlineData;
        private final Boolean thought;
        private final String thoughtSignature;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/InlineDataPart$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/InlineDataPart$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return InlineDataPart$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, InlineData.Internal internal, Boolean bool, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, InlineDataPart$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.inlineData = internal;
            if ((i & 2) == 0) {
                this.thought = null;
            } else {
                this.thought = bool;
            }
            if ((i & 4) == 0) {
                this.thoughtSignature = null;
            } else {
                this.thoughtSignature = str;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, InlineData.Internal internal2, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.inlineData;
            }
            if ((i & 2) != 0) {
                bool = internal.thought;
            }
            if ((i & 4) != 0) {
                str = internal.thoughtSignature;
            }
            return internal.copy(internal2, bool, str);
        }

        @SerialName("inlineData")
        public static /* synthetic */ void getInlineData$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, InlineData$Internal$$serializer.INSTANCE, self.inlineData);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.thought != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.thought);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.thoughtSignature == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.thoughtSignature);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InlineData.Internal getInlineData() {
            return this.inlineData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getThought() {
            return this.thought;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public final Internal copy(InlineData.Internal inlineData, Boolean thought, String thoughtSignature) {
            inlineData.getClass();
            return new Internal(inlineData, thought, thoughtSignature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.inlineData, internal.inlineData) && Intrinsics.areEqual(this.thought, internal.thought) && Intrinsics.areEqual(this.thoughtSignature, internal.thoughtSignature);
        }

        public final InlineData.Internal getInlineData() {
            return this.inlineData;
        }

        public final Boolean getThought() {
            return this.thought;
        }

        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public int hashCode() {
            int iHashCode = this.inlineData.hashCode() * 31;
            Boolean bool = this.thought;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.thoughtSignature;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(inlineData=");
            sb.append(this.inlineData);
            sb.append(", thought=");
            sb.append(this.thought);
            sb.append(", thoughtSignature=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.thoughtSignature, ')');
        }

        public Internal(InlineData.Internal internal, Boolean bool, String str) {
            internal.getClass();
            this.inlineData = internal;
            this.thought = bool;
            this.thoughtSignature = str;
        }

        public /* synthetic */ Internal(InlineData.Internal internal, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(internal, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
        }
    }
}

package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/Segment;", "", "startIndex", "", "endIndex", "partIndex", "text", "", "<init>", "(IIILjava/lang/String;)V", "getStartIndex", "()I", "getEndIndex", "getPartIndex", "getText", "()Ljava/lang/String;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Segment {
    private final int endIndex;
    private final int partIndex;
    private final int startIndex;
    private final String text;

    public Segment(int i, int i2, int i3, String str) {
        str.getClass();
        this.startIndex = i;
        this.endIndex = i2;
        this.partIndex = i3;
        this.text = str;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getPartIndex() {
        return this.partIndex;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final String getText() {
        return this.text;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\r\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, d2 = {"Lcom/google/firebase/ai/type/Segment$Internal;", "", "startIndex", "", "endIndex", "partIndex", "text", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndIndex", "getPartIndex", "getText", "()Ljava/lang/String;", "toPublic", "Lcom/google/firebase/ai/type/Segment;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/google/firebase/ai/type/Segment$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer endIndex;
        private final Integer partIndex;
        private final Integer startIndex;
        private final String text;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Segment$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Segment$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Segment$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Integer num, Integer num2, Integer num3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, Segment$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.startIndex = num;
            this.endIndex = num2;
            this.partIndex = num3;
            this.text = str;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, Integer num, Integer num2, Integer num3, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = internal.startIndex;
            }
            if ((i & 2) != 0) {
                num2 = internal.endIndex;
            }
            if ((i & 4) != 0) {
                num3 = internal.partIndex;
            }
            if ((i & 8) != 0) {
                str = internal.text;
            }
            return internal.copy(num, num2, num3, str);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 0, intSerializer, self.startIndex);
            output.encodeNullableSerializableElement(serialDesc, 1, intSerializer, self.endIndex);
            output.encodeNullableSerializableElement(serialDesc, 2, intSerializer, self.partIndex);
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.text);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getStartIndex() {
            return this.startIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getEndIndex() {
            return this.endIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getPartIndex() {
            return this.partIndex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Internal copy(Integer startIndex, Integer endIndex, Integer partIndex, String text) {
            return new Internal(startIndex, endIndex, partIndex, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.startIndex, internal.startIndex) && Intrinsics.areEqual(this.endIndex, internal.endIndex) && Intrinsics.areEqual(this.partIndex, internal.partIndex) && Intrinsics.areEqual(this.text, internal.text);
        }

        public final Integer getEndIndex() {
            return this.endIndex;
        }

        public final Integer getPartIndex() {
            return this.partIndex;
        }

        public final Integer getStartIndex() {
            return this.startIndex;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            Integer num = this.startIndex;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.endIndex;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.partIndex;
            int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str = this.text;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public final Segment toPublic$com_google_firebase_ai_logic_firebase_ai() {
            Integer num = this.startIndex;
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = this.endIndex;
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            Integer num3 = this.partIndex;
            int iIntValue3 = num3 != null ? num3.intValue() : 0;
            String str = this.text;
            if (str == null) {
                str = "";
            }
            return new Segment(iIntValue, iIntValue2, iIntValue3, str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(startIndex=");
            sb.append(this.startIndex);
            sb.append(", endIndex=");
            sb.append(this.endIndex);
            sb.append(", partIndex=");
            sb.append(this.partIndex);
            sb.append(", text=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.text, ')');
        }

        public Internal(Integer num, Integer num2, Integer num3, String str) {
            this.startIndex = num;
            this.endIndex = num2;
            this.partIndex = num3;
            this.text = str;
        }
    }
}

package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/google/firebase/ai/type/GRpcErrorResponse;", "Lcom/google/firebase/ai/type/Response;", "error", "Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;", "<init>", "(Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getError", "()Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;", "component1", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "GRpcError", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final /* data */ class GRpcErrorResponse implements Response {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GRpcError error;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GRpcErrorResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GRpcErrorResponse;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GRpcErrorResponse> serializer() {
            return GRpcErrorResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GRpcErrorResponse(int i, GRpcError gRpcError, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, GRpcErrorResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.error = gRpcError;
    }

    public static /* synthetic */ GRpcErrorResponse copy$default(GRpcErrorResponse gRpcErrorResponse, GRpcError gRpcError, int i, Object obj) {
        if ((i & 1) != 0) {
            gRpcError = gRpcErrorResponse.error;
        }
        return gRpcErrorResponse.copy(gRpcError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GRpcError getError() {
        return this.error;
    }

    public final GRpcErrorResponse copy(GRpcError error) {
        error.getClass();
        return new GRpcErrorResponse(error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GRpcErrorResponse) && Intrinsics.areEqual(this.error, ((GRpcErrorResponse) other).error);
    }

    public final GRpcError getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public String toString() {
        return "GRpcErrorResponse(error=" + this.error + ')';
    }

    public GRpcErrorResponse(GRpcError gRpcError) {
        gRpcError.getClass();
        this.error = gRpcError;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0003&'(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;", "", "code", "", "message", "", "details", "", "Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError$GRpcErrorDetails;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "GRpcErrorDetails", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class GRpcError {
        private final int code;
        private final List<GRpcErrorDetails> details;
        private final String message;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(GRpcErrorResponse$GRpcError$GRpcErrorDetails$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<GRpcError> serializer() {
                return GRpcErrorResponse$GRpcError$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ GRpcError(int i, int i2, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, GRpcErrorResponse$GRpcError$$serializer.INSTANCE.getDescriptor());
            }
            this.code = i2;
            this.message = str;
            if ((i & 4) == 0) {
                this.details = null;
            } else {
                this.details = list;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GRpcError copy$default(GRpcError gRpcError, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = gRpcError.code;
            }
            if ((i2 & 2) != 0) {
                str = gRpcError.message;
            }
            if ((i2 & 4) != 0) {
                list = gRpcError.details;
            }
            return gRpcError.copy(i, str, list);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(GRpcError self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeIntElement(serialDesc, 0, self.code);
            output.encodeStringElement(serialDesc, 1, self.message);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.details == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.details);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final List<GRpcErrorDetails> component3() {
            return this.details;
        }

        public final GRpcError copy(int code, String message, List<GRpcErrorDetails> details) {
            message.getClass();
            return new GRpcError(code, message, details);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GRpcError)) {
                return false;
            }
            GRpcError gRpcError = (GRpcError) other;
            return this.code == gRpcError.code && Intrinsics.areEqual(this.message, gRpcError.message) && Intrinsics.areEqual(this.details, gRpcError.details);
        }

        public final int getCode() {
            return this.code;
        }

        public final List<GRpcErrorDetails> getDetails() {
            return this.details;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(Integer.hashCode(this.code) * 31, 31, this.message);
            List<GRpcErrorDetails> list = this.details;
            return iM + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("GRpcError(code=");
            sb.append(this.code);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(", details=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.details, ')');
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bBE\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError$GRpcErrorDetails;", "", "reason", "", "domain", "metadata", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReason", "()Ljava/lang/String;", "getDomain", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class GRpcErrorDetails {
            private static final KSerializer<Object>[] $childSerializers;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String domain;
            private final Map<String, String> metadata;
            private final String reason;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError$GRpcErrorDetails$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError$GRpcErrorDetails;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<GRpcErrorDetails> serializer() {
                    return GRpcErrorResponse$GRpcError$GRpcErrorDetails$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            static {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                $childSerializers = new KSerializer[]{null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
            }

            public /* synthetic */ GRpcErrorDetails(int i, String str, String str2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.reason = null;
                } else {
                    this.reason = str;
                }
                if ((i & 2) == 0) {
                    this.domain = null;
                } else {
                    this.domain = str2;
                }
                if ((i & 4) == 0) {
                    this.metadata = null;
                } else {
                    this.metadata = map;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ GRpcErrorDetails copy$default(GRpcErrorDetails gRpcErrorDetails, String str, String str2, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = gRpcErrorDetails.reason;
                }
                if ((i & 2) != 0) {
                    str2 = gRpcErrorDetails.domain;
                }
                if ((i & 4) != 0) {
                    map = gRpcErrorDetails.metadata;
                }
                return gRpcErrorDetails.copy(str, str2, map);
            }

            public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(GRpcErrorDetails self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.reason != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.reason);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.domain != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.domain);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.metadata == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.metadata);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getDomain() {
                return this.domain;
            }

            public final Map<String, String> component3() {
                return this.metadata;
            }

            public final GRpcErrorDetails copy(String reason, String domain, Map<String, String> metadata) {
                return new GRpcErrorDetails(reason, domain, metadata);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GRpcErrorDetails)) {
                    return false;
                }
                GRpcErrorDetails gRpcErrorDetails = (GRpcErrorDetails) other;
                return Intrinsics.areEqual(this.reason, gRpcErrorDetails.reason) && Intrinsics.areEqual(this.domain, gRpcErrorDetails.domain) && Intrinsics.areEqual(this.metadata, gRpcErrorDetails.metadata);
            }

            public final String getDomain() {
                return this.domain;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public final String getReason() {
                return this.reason;
            }

            public int hashCode() {
                String str = this.reason;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.domain;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                Map<String, String> map = this.metadata;
                return iHashCode2 + (map != null ? map.hashCode() : 0);
            }

            public String toString() {
                return "GRpcErrorDetails(reason=" + this.reason + ", domain=" + this.domain + ", metadata=" + this.metadata + ')';
            }

            public GRpcErrorDetails() {
                this((String) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
            }

            public GRpcErrorDetails(String str, String str2, Map<String, String> map) {
                this.reason = str;
                this.domain = str2;
                this.metadata = map;
            }

            public /* synthetic */ GRpcErrorDetails(String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map);
            }
        }

        public GRpcError(int i, String str, List<GRpcErrorDetails> list) {
            str.getClass();
            this.code = i;
            this.message = str;
            this.details = list;
        }

        public /* synthetic */ GRpcError(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : list);
        }
    }
}

package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fB1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallPart;", "Lcom/google/firebase/ai/type/Part;", "name", "", "args", "", "Lkotlinx/serialization/json/JsonElement;", "id", "isThought", "", "thoughtSignature", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZLjava/lang/String;)V", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getArgs", "()Ljava/util/Map;", "getId", "()Z", "getThoughtSignature$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionCallPart implements Part {
    private final Map<String, JsonElement> args;
    private final String id;
    private final boolean isThought;
    private final String name;
    private final String thoughtSignature;

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionCallPart(String str, Map<String, ? extends JsonElement> map, String str2, boolean z, String str3) {
        str.getClass();
        map.getClass();
        this.name = str;
        this.args = map;
        this.id = str2;
        this.isThought = z;
        this.thoughtSignature = str3;
    }

    public final Map<String, JsonElement> getArgs() {
        return this.args;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
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
    public FunctionCallPart(String str, Map<String, ? extends JsonElement> map) {
        this(str, map, (String) null, 4, (DefaultConstructorMarker) null);
        str.getClass();
        map.getClass();
    }

    public /* synthetic */ FunctionCallPart(String str, Map map, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (Map<String, ? extends JsonElement>) map, (i & 4) != 0 ? null : str2, z, str3);
    }

    public /* synthetic */ FunctionCallPart(String str, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunctionCallPart(String str, Map<String, ? extends JsonElement> map, String str2) {
        this(str, map, str2, false, (String) null);
        str.getClass();
        map.getClass();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0003()*B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallPart$Internal;", "Lcom/google/firebase/ai/type/InternalPart;", "functionCall", "Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;", "thought", "", "thoughtSignature", "", "<init>", "(Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFunctionCall", "()Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;", "getThought", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThoughtSignature", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/google/firebase/ai/type/FunctionCallPart$Internal;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "FunctionCall", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal implements InternalPart {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FunctionCall functionCall;
        private final Boolean thought;
        private final String thoughtSignature;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallPart$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionCallPart$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return FunctionCallPart$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, FunctionCall functionCall, Boolean bool, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, FunctionCallPart$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.functionCall = functionCall;
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

        public static /* synthetic */ Internal copy$default(Internal internal, FunctionCall functionCall, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                functionCall = internal.functionCall;
            }
            if ((i & 2) != 0) {
                bool = internal.thought;
            }
            if ((i & 4) != 0) {
                str = internal.thoughtSignature;
            }
            return internal.copy(functionCall, bool, str);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, FunctionCallPart$Internal$FunctionCall$$serializer.INSTANCE, self.functionCall);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.thought != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.thought);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.thoughtSignature == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.thoughtSignature);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FunctionCall getFunctionCall() {
            return this.functionCall;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getThought() {
            return this.thought;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public final Internal copy(FunctionCall functionCall, Boolean thought, String thoughtSignature) {
            functionCall.getClass();
            return new Internal(functionCall, thought, thoughtSignature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.functionCall, internal.functionCall) && Intrinsics.areEqual(this.thought, internal.thought) && Intrinsics.areEqual(this.thoughtSignature, internal.thoughtSignature);
        }

        public final FunctionCall getFunctionCall() {
            return this.functionCall;
        }

        public final Boolean getThought() {
            return this.thought;
        }

        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public int hashCode() {
            int iHashCode = this.functionCall.hashCode() * 31;
            Boolean bool = this.thought;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.thoughtSignature;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(functionCall=");
            sb.append(this.functionCall);
            sb.append(", thought=");
            sb.append(this.thought);
            sb.append(", thoughtSignature=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.thoughtSignature, ')');
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002%&B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBG\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006'"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;", "", "name", "", "args", "", "Lkotlinx/serialization/json/JsonElement;", "id", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getArgs", "()Ljava/util/Map;", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class FunctionCall {
            private final Map<String, JsonElement> args;
            private final String id;
            private final String name;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)), null};

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionCallPart$Internal$FunctionCall;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<FunctionCall> serializer() {
                    return FunctionCallPart$Internal$FunctionCall$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ FunctionCall(int i, String str, Map map, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, FunctionCallPart$Internal$FunctionCall$$serializer.INSTANCE.getDescriptor());
                }
                this.name = str;
                if ((i & 2) == 0) {
                    this.args = null;
                } else {
                    this.args = map;
                }
                if ((i & 4) == 0) {
                    this.id = null;
                } else {
                    this.id = str2;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FunctionCall copy$default(FunctionCall functionCall, String str, Map map, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = functionCall.name;
                }
                if ((i & 2) != 0) {
                    map = functionCall.args;
                }
                if ((i & 4) != 0) {
                    str2 = functionCall.id;
                }
                return functionCall.copy(str, map, str2);
            }

            public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(FunctionCall self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.name);
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.args != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.args);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.id == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.id);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Map<String, JsonElement> component2() {
                return this.args;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final FunctionCall copy(String name, Map<String, ? extends JsonElement> args, String id) {
                name.getClass();
                return new FunctionCall(name, args, id);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FunctionCall)) {
                    return false;
                }
                FunctionCall functionCall = (FunctionCall) other;
                return Intrinsics.areEqual(this.name, functionCall.name) && Intrinsics.areEqual(this.args, functionCall.args) && Intrinsics.areEqual(this.id, functionCall.id);
            }

            public final Map<String, JsonElement> getArgs() {
                return this.args;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                int iHashCode = this.name.hashCode() * 31;
                Map<String, JsonElement> map = this.args;
                int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
                String str = this.id;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("FunctionCall(name=");
                sb.append(this.name);
                sb.append(", args=");
                sb.append(this.args);
                sb.append(", id=");
                return FileInsert$$ExternalSyntheticOutline0.m(sb, this.id, ')');
            }

            /* JADX WARN: Multi-variable type inference failed */
            public FunctionCall(String str, Map<String, ? extends JsonElement> map, String str2) {
                str.getClass();
                this.name = str;
                this.args = map;
                this.id = str2;
            }

            public /* synthetic */ FunctionCall(String str, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str2);
            }
        }

        public Internal(FunctionCall functionCall, Boolean bool, String str) {
            functionCall.getClass();
            this.functionCall = functionCall;
            this.thought = bool;
            this.thoughtSignature = str;
        }

        public /* synthetic */ Internal(FunctionCall functionCall, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(functionCall, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
        }
    }
}

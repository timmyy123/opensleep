package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002\u001f BG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rB5\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0004\b\f\u0010\u000eJ\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006!"}, d2 = {"Lcom/google/firebase/ai/type/FunctionResponsePart;", "Lcom/google/firebase/ai/type/Part;", "name", "", "response", "Lkotlinx/serialization/json/JsonObject;", "id", "parts", "", "isThought", "", "thoughtSignature", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;)V", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getResponse", "()Lkotlinx/serialization/json/JsonObject;", "getId", "getParts", "()Ljava/util/List;", "()Z", "getThoughtSignature$com_google_firebase_ai_logic_firebase_ai", "toInternalFunctionResponse", "Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "toInternalFunctionResponse$com_google_firebase_ai_logic_firebase_ai", "normalizeAgainstCall", "call", "Lcom/google/firebase/ai/type/FunctionCallPart;", "normalizeAgainstCall$com_google_firebase_ai_logic_firebase_ai", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionResponsePart implements Part {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final boolean isThought;
    private final String name;
    private final List<Part> parts;
    private final JsonObject response;
    private final String thoughtSignature;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/ai/type/FunctionResponsePart$Companion;", "", "<init>", "()V", "from", "Lcom/google/firebase/ai/type/FunctionResponsePart;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "parts", "", "Lcom/google/firebase/ai/type/Part;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FunctionResponsePart from$default(Companion companion, JsonObject jsonObject, List list, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return companion.from(jsonObject, list);
        }

        public final FunctionResponsePart from(JsonObject jsonObject, List<? extends Part> parts) {
            jsonObject.getClass();
            parts.getClass();
            return new FunctionResponsePart("", jsonObject, null, parts);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionResponsePart(String str, JsonObject jsonObject, String str2, List<? extends Part> list, boolean z, String str3) {
        str.getClass();
        jsonObject.getClass();
        list.getClass();
        this.name = str;
        this.response = jsonObject;
        this.id = str2;
        this.parts = list;
        this.isThought = z;
        this.thoughtSignature = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Part> getParts() {
        return this.parts;
    }

    public final JsonObject getResponse() {
        return this.response;
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

    public final FunctionResponsePart normalizeAgainstCall$com_google_firebase_ai_logic_firebase_ai(FunctionCallPart call) {
        call.getClass();
        return new FunctionResponsePart(call.getName(), this.response, call.getId(), this.parts);
    }

    public final Internal.FunctionResponse toInternalFunctionResponse$com_google_firebase_ai_logic_firebase_ai() {
        String str = this.name;
        JsonObject jsonObject = this.response;
        String str2 = this.id;
        List<Part> list = this.parts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(PartKt.toInternal((Part) it.next(), true));
        }
        return new Internal.FunctionResponse(str, jsonObject, str2, arrayList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunctionResponsePart(String str, JsonObject jsonObject, String str2) {
        this(str, jsonObject, str2, (List) null, 8, (DefaultConstructorMarker) null);
        str.getClass();
        jsonObject.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunctionResponsePart(String str, JsonObject jsonObject) {
        this(str, jsonObject, (String) null, (List) null, 12, (DefaultConstructorMarker) null);
        str.getClass();
        jsonObject.getClass();
    }

    public /* synthetic */ FunctionResponsePart(String str, JsonObject jsonObject, String str2, List list, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonObject, (i & 4) != 0 ? null : str2, (List<? extends Part>) ((i & 8) != 0 ? CollectionsKt.emptyList() : list), z, str3);
    }

    public /* synthetic */ FunctionResponsePart(String str, JsonObject jsonObject, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonObject, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunctionResponsePart(String str, JsonObject jsonObject, String str2, List<? extends Part> list) {
        this(str, jsonObject, str2, list, false, (String) null);
        str.getClass();
        jsonObject.getClass();
        list.getClass();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0003()*B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lcom/google/firebase/ai/type/FunctionResponsePart$Internal;", "Lcom/google/firebase/ai/type/InternalPart;", "functionResponse", "Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "thought", "", "thoughtSignature", "", "<init>", "(Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFunctionResponse", "()Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "getThought", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThoughtSignature", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/google/firebase/ai/type/FunctionResponsePart$Internal;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "FunctionResponse", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal implements InternalPart {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FunctionResponse functionResponse;
        private final Boolean thought;
        private final String thoughtSignature;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionResponsePart$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return FunctionResponsePart$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, FunctionResponse functionResponse, Boolean bool, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, FunctionResponsePart$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.functionResponse = functionResponse;
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

        public static /* synthetic */ Internal copy$default(Internal internal, FunctionResponse functionResponse, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                functionResponse = internal.functionResponse;
            }
            if ((i & 2) != 0) {
                bool = internal.thought;
            }
            if ((i & 4) != 0) {
                str = internal.thoughtSignature;
            }
            return internal.copy(functionResponse, bool, str);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, FunctionResponsePart$Internal$FunctionResponse$$serializer.INSTANCE, self.functionResponse);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.thought != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.thought);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.thoughtSignature == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.thoughtSignature);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FunctionResponse getFunctionResponse() {
            return this.functionResponse;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getThought() {
            return this.thought;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public final Internal copy(FunctionResponse functionResponse, Boolean thought, String thoughtSignature) {
            functionResponse.getClass();
            return new Internal(functionResponse, thought, thoughtSignature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.functionResponse, internal.functionResponse) && Intrinsics.areEqual(this.thought, internal.thought) && Intrinsics.areEqual(this.thoughtSignature, internal.thoughtSignature);
        }

        public final FunctionResponse getFunctionResponse() {
            return this.functionResponse;
        }

        public final Boolean getThought() {
            return this.thought;
        }

        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public int hashCode() {
            int iHashCode = this.functionResponse.hashCode() * 31;
            Boolean bool = this.thought;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.thoughtSignature;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(functionResponse=");
            sb.append(this.functionResponse);
            sb.append(", thought=");
            sb.append(this.thought);
            sb.append(", thoughtSignature=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.thoughtSignature, ')');
        }

        public Internal(FunctionResponse functionResponse, Boolean bool, String str) {
            functionResponse.getClass();
            this.functionResponse = functionResponse;
            this.thought = bool;
            this.thoughtSignature = str;
        }

        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\rHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "", "name", "", "response", "Lkotlinx/serialization/json/JsonObject;", "id", "parts", "", "Lcom/google/firebase/ai/type/InternalPart;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getResponse", "()Lkotlinx/serialization/json/JsonObject;", "getId", "getParts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class FunctionResponse {
            private final String id;
            private final String name;
            private final List<InternalPart> parts;
            private final JsonObject response;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(PartSerializer.INSTANCE)};

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<FunctionResponse> serializer() {
                    return FunctionResponsePart$Internal$FunctionResponse$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ FunctionResponse(int i, String str, JsonObject jsonObject, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, FunctionResponsePart$Internal$FunctionResponse$$serializer.INSTANCE.getDescriptor());
                }
                this.name = str;
                this.response = jsonObject;
                if ((i & 4) == 0) {
                    this.id = null;
                } else {
                    this.id = str2;
                }
                if ((i & 8) == 0) {
                    this.parts = null;
                } else {
                    this.parts = list;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FunctionResponse copy$default(FunctionResponse functionResponse, String str, JsonObject jsonObject, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = functionResponse.name;
                }
                if ((i & 2) != 0) {
                    jsonObject = functionResponse.response;
                }
                if ((i & 4) != 0) {
                    str2 = functionResponse.id;
                }
                if ((i & 8) != 0) {
                    list = functionResponse.parts;
                }
                return functionResponse.copy(str, jsonObject, str2, list);
            }

            public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(FunctionResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.name);
                output.encodeSerializableElement(serialDesc, 1, JsonObjectSerializer.INSTANCE, self.response);
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.id != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.id);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.parts == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.parts);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final JsonObject getResponse() {
                return this.response;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final List<InternalPart> component4() {
                return this.parts;
            }

            public final FunctionResponse copy(String name, JsonObject response, String id, List<? extends InternalPart> parts) {
                name.getClass();
                response.getClass();
                return new FunctionResponse(name, response, id, parts);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FunctionResponse)) {
                    return false;
                }
                FunctionResponse functionResponse = (FunctionResponse) other;
                return Intrinsics.areEqual(this.name, functionResponse.name) && Intrinsics.areEqual(this.response, functionResponse.response) && Intrinsics.areEqual(this.id, functionResponse.id) && Intrinsics.areEqual(this.parts, functionResponse.parts);
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public final List<InternalPart> getParts() {
                return this.parts;
            }

            public final JsonObject getResponse() {
                return this.response;
            }

            public int hashCode() {
                int iHashCode = (this.response.hashCode() + (this.name.hashCode() * 31)) * 31;
                String str = this.id;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                List<InternalPart> list = this.parts;
                return iHashCode2 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("FunctionResponse(name=");
                sb.append(this.name);
                sb.append(", response=");
                sb.append(this.response);
                sb.append(", id=");
                sb.append(this.id);
                sb.append(", parts=");
                return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.parts, ')');
            }

            /* JADX WARN: Multi-variable type inference failed */
            public FunctionResponse(String str, JsonObject jsonObject, String str2, List<? extends InternalPart> list) {
                str.getClass();
                jsonObject.getClass();
                this.name = str;
                this.response = jsonObject;
                this.id = str2;
                this.parts = list;
            }

            public /* synthetic */ FunctionResponse(String str, JsonObject jsonObject, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, jsonObject, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list);
            }
        }

        public /* synthetic */ Internal(FunctionResponse functionResponse, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(functionResponse, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
        }
    }
}

package com.google.firebase.ai.common;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.Content$Internal$$serializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/google/firebase/ai/common/TemplateGenerateContentRequest;", "Lcom/google/firebase/ai/common/Request;", "inputs", "Lkotlinx/serialization/json/JsonObject;", "history", "", "Lcom/google/firebase/ai/type/Content$Internal;", "<init>", "(Lkotlinx/serialization/json/JsonObject;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonObject;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInputs", "()Lkotlinx/serialization/json/JsonObject;", "getHistory", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final /* data */ class TemplateGenerateContentRequest implements Request {
    private final List<Content.Internal> history;
    private final JsonObject inputs;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(Content$Internal$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/common/TemplateGenerateContentRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/common/TemplateGenerateContentRequest;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TemplateGenerateContentRequest> serializer() {
            return TemplateGenerateContentRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TemplateGenerateContentRequest(int i, JsonObject jsonObject, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, TemplateGenerateContentRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.inputs = jsonObject;
        this.history = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateGenerateContentRequest copy$default(TemplateGenerateContentRequest templateGenerateContentRequest, JsonObject jsonObject, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonObject = templateGenerateContentRequest.inputs;
        }
        if ((i & 2) != 0) {
            list = templateGenerateContentRequest.history;
        }
        return templateGenerateContentRequest.copy(jsonObject, list);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(TemplateGenerateContentRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, JsonObjectSerializer.INSTANCE, self.inputs);
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.history);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JsonObject getInputs() {
        return this.inputs;
    }

    public final List<Content.Internal> component2() {
        return this.history;
    }

    public final TemplateGenerateContentRequest copy(JsonObject inputs, List<Content.Internal> history) {
        inputs.getClass();
        return new TemplateGenerateContentRequest(inputs, history);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateGenerateContentRequest)) {
            return false;
        }
        TemplateGenerateContentRequest templateGenerateContentRequest = (TemplateGenerateContentRequest) other;
        return Intrinsics.areEqual(this.inputs, templateGenerateContentRequest.inputs) && Intrinsics.areEqual(this.history, templateGenerateContentRequest.history);
    }

    public final List<Content.Internal> getHistory() {
        return this.history;
    }

    public final JsonObject getInputs() {
        return this.inputs;
    }

    public int hashCode() {
        int iHashCode = this.inputs.hashCode() * 31;
        List<Content.Internal> list = this.history;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TemplateGenerateContentRequest(inputs=");
        sb.append(this.inputs);
        sb.append(", history=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.history, ')');
    }

    public TemplateGenerateContentRequest(JsonObject jsonObject, List<Content.Internal> list) {
        jsonObject.getClass();
        this.inputs = jsonObject;
        this.history = list;
    }
}

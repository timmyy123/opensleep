package com.google.firebase.ai.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.ai.common.util.UtilKt;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.Content$Internal$$serializer;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerationConfig$Internal$$serializer;
import com.google.firebase.ai.type.Tool;
import com.google.firebase.ai.type.Tool$Internal$$serializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000278B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fBc\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0011HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00069"}, d2 = {"Lcom/google/firebase/ai/common/CountTokensRequest;", "Lcom/google/firebase/ai/common/Request;", "generateContentRequest", "Lcom/google/firebase/ai/common/GenerateContentRequest;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "contents", "", "Lcom/google/firebase/ai/type/Content$Internal;", "tools", "Lcom/google/firebase/ai/type/Tool$Internal;", "systemInstruction", "generationConfig", "Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "<init>", "(Lcom/google/firebase/ai/common/GenerateContentRequest;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/GenerationConfig$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/common/GenerateContentRequest;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/GenerationConfig$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGenerateContentRequest", "()Lcom/google/firebase/ai/common/GenerateContentRequest;", "getModel", "()Ljava/lang/String;", "getContents", "()Ljava/util/List;", "getTools", "getSystemInstruction$annotations", "()V", "getSystemInstruction", "()Lcom/google/firebase/ai/type/Content$Internal;", "getGenerationConfig", "()Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "Companion", "$serializer", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final /* data */ class CountTokensRequest implements Request {
    private final List<Content.Internal> contents;
    private final GenerateContentRequest generateContentRequest;
    private final GenerationConfig.Internal generationConfig;
    private final String model;
    private final Content.Internal systemInstruction;
    private final List<Tool.Internal> tools;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(Content$Internal$$serializer.INSTANCE), new ArrayListSerializer(Tool$Internal$$serializer.INSTANCE), null, null};

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/ai/common/CountTokensRequest$Companion;", "", "<init>", "()V", "forGoogleAI", "Lcom/google/firebase/ai/common/CountTokensRequest;", "generateContentRequest", "Lcom/google/firebase/ai/common/GenerateContentRequest;", "forVertexAI", "serializer", "Lkotlinx/serialization/KSerializer;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CountTokensRequest forGoogleAI(GenerateContentRequest generateContentRequest) {
            GenerateContentRequest generateContentRequest2;
            GenerateContentRequest generateContentRequest3;
            generateContentRequest.getClass();
            String model = generateContentRequest.getModel();
            if (model != null) {
                generateContentRequest2 = generateContentRequest;
                GenerateContentRequest generateContentRequestCopy$default = GenerateContentRequest.copy$default(generateContentRequest2, UtilKt.fullModelName(UtilKt.trimmedModelName(model)), null, null, null, null, null, null, 126, null);
                if (generateContentRequestCopy$default != null) {
                    generateContentRequest3 = generateContentRequestCopy$default;
                }
                return new CountTokensRequest(generateContentRequest3, (String) null, (List) null, (List) null, (Content.Internal) null, (GenerationConfig.Internal) null, 62, (DefaultConstructorMarker) null);
            }
            generateContentRequest2 = generateContentRequest;
            generateContentRequest3 = generateContentRequest2;
            return new CountTokensRequest(generateContentRequest3, (String) null, (List) null, (List) null, (Content.Internal) null, (GenerationConfig.Internal) null, 62, (DefaultConstructorMarker) null);
        }

        public final CountTokensRequest forVertexAI(GenerateContentRequest generateContentRequest) {
            generateContentRequest.getClass();
            String model = generateContentRequest.getModel();
            return new CountTokensRequest((GenerateContentRequest) null, model != null ? UtilKt.fullModelName(model) : null, generateContentRequest.getContents(), generateContentRequest.getTools(), generateContentRequest.getSystemInstruction(), generateContentRequest.getGenerationConfig(), 1, (DefaultConstructorMarker) null);
        }

        public final KSerializer<CountTokensRequest> serializer() {
            return CountTokensRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CountTokensRequest(int i, GenerateContentRequest generateContentRequest, String str, List list, List list2, Content.Internal internal, GenerationConfig.Internal internal2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.generateContentRequest = null;
        } else {
            this.generateContentRequest = generateContentRequest;
        }
        if ((i & 2) == 0) {
            this.model = null;
        } else {
            this.model = str;
        }
        if ((i & 4) == 0) {
            this.contents = null;
        } else {
            this.contents = list;
        }
        if ((i & 8) == 0) {
            this.tools = null;
        } else {
            this.tools = list2;
        }
        if ((i & 16) == 0) {
            this.systemInstruction = null;
        } else {
            this.systemInstruction = internal;
        }
        if ((i & 32) == 0) {
            this.generationConfig = null;
        } else {
            this.generationConfig = internal2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountTokensRequest copy$default(CountTokensRequest countTokensRequest, GenerateContentRequest generateContentRequest, String str, List list, List list2, Content.Internal internal, GenerationConfig.Internal internal2, int i, Object obj) {
        if ((i & 1) != 0) {
            generateContentRequest = countTokensRequest.generateContentRequest;
        }
        if ((i & 2) != 0) {
            str = countTokensRequest.model;
        }
        if ((i & 4) != 0) {
            list = countTokensRequest.contents;
        }
        if ((i & 8) != 0) {
            list2 = countTokensRequest.tools;
        }
        if ((i & 16) != 0) {
            internal = countTokensRequest.systemInstruction;
        }
        if ((i & 32) != 0) {
            internal2 = countTokensRequest.generationConfig;
        }
        Content.Internal internal3 = internal;
        GenerationConfig.Internal internal4 = internal2;
        return countTokensRequest.copy(generateContentRequest, str, list, list2, internal3, internal4);
    }

    @SerialName("system_instruction")
    public static /* synthetic */ void getSystemInstruction$annotations() {
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(CountTokensRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.generateContentRequest != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, GenerateContentRequest$$serializer.INSTANCE, self.generateContentRequest);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.model != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.contents != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.contents);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tools != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.tools);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.systemInstruction != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, Content$Internal$$serializer.INSTANCE, self.systemInstruction);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.generationConfig == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, GenerationConfig$Internal$$serializer.INSTANCE, self.generationConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GenerateContentRequest getGenerateContentRequest() {
        return this.generateContentRequest;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    public final List<Content.Internal> component3() {
        return this.contents;
    }

    public final List<Tool.Internal> component4() {
        return this.tools;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Content.Internal getSystemInstruction() {
        return this.systemInstruction;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GenerationConfig.Internal getGenerationConfig() {
        return this.generationConfig;
    }

    public final CountTokensRequest copy(GenerateContentRequest generateContentRequest, String model, List<Content.Internal> contents, List<Tool.Internal> tools, Content.Internal systemInstruction, GenerationConfig.Internal generationConfig) {
        return new CountTokensRequest(generateContentRequest, model, contents, tools, systemInstruction, generationConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountTokensRequest)) {
            return false;
        }
        CountTokensRequest countTokensRequest = (CountTokensRequest) other;
        return Intrinsics.areEqual(this.generateContentRequest, countTokensRequest.generateContentRequest) && Intrinsics.areEqual(this.model, countTokensRequest.model) && Intrinsics.areEqual(this.contents, countTokensRequest.contents) && Intrinsics.areEqual(this.tools, countTokensRequest.tools) && Intrinsics.areEqual(this.systemInstruction, countTokensRequest.systemInstruction) && Intrinsics.areEqual(this.generationConfig, countTokensRequest.generationConfig);
    }

    public final List<Content.Internal> getContents() {
        return this.contents;
    }

    public final GenerateContentRequest getGenerateContentRequest() {
        return this.generateContentRequest;
    }

    public final GenerationConfig.Internal getGenerationConfig() {
        return this.generationConfig;
    }

    public final String getModel() {
        return this.model;
    }

    public final Content.Internal getSystemInstruction() {
        return this.systemInstruction;
    }

    public final List<Tool.Internal> getTools() {
        return this.tools;
    }

    public int hashCode() {
        GenerateContentRequest generateContentRequest = this.generateContentRequest;
        int iHashCode = (generateContentRequest == null ? 0 : generateContentRequest.hashCode()) * 31;
        String str = this.model;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Content.Internal> list = this.contents;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Tool.Internal> list2 = this.tools;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Content.Internal internal = this.systemInstruction;
        int iHashCode5 = (iHashCode4 + (internal == null ? 0 : internal.hashCode())) * 31;
        GenerationConfig.Internal internal2 = this.generationConfig;
        return iHashCode5 + (internal2 != null ? internal2.hashCode() : 0);
    }

    public String toString() {
        return "CountTokensRequest(generateContentRequest=" + this.generateContentRequest + ", model=" + this.model + ", contents=" + this.contents + ", tools=" + this.tools + ", systemInstruction=" + this.systemInstruction + ", generationConfig=" + this.generationConfig + ')';
    }

    public CountTokensRequest() {
        this((GenerateContentRequest) null, (String) null, (List) null, (List) null, (Content.Internal) null, (GenerationConfig.Internal) null, 63, (DefaultConstructorMarker) null);
    }

    public CountTokensRequest(GenerateContentRequest generateContentRequest, String str, List<Content.Internal> list, List<Tool.Internal> list2, Content.Internal internal, GenerationConfig.Internal internal2) {
        this.generateContentRequest = generateContentRequest;
        this.model = str;
        this.contents = list;
        this.tools = list2;
        this.systemInstruction = internal;
        this.generationConfig = internal2;
    }

    public /* synthetic */ CountTokensRequest(GenerateContentRequest generateContentRequest, String str, List list, List list2, Content.Internal internal, GenerationConfig.Internal internal2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : generateContentRequest, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : internal, (i & 32) != 0 ? null : internal2);
    }
}

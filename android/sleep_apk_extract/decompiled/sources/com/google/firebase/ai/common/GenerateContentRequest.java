package com.google.firebase.ai.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.Content$Internal$$serializer;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerationConfig$Internal$$serializer;
import com.google.firebase.ai.type.SafetySetting;
import com.google.firebase.ai.type.SafetySetting$Internal$$serializer;
import com.google.firebase.ai.type.Tool;
import com.google.firebase.ai.type.Tool$Internal$$serializer;
import com.google.firebase.ai.type.ToolConfig;
import com.google.firebase.ai.type.ToolConfig$Internal$$serializer;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 A2\u00020\u0001:\u0002@ABi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011Bs\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jm\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0013HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR&\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)¨\u0006B"}, d2 = {"Lcom/google/firebase/ai/common/GenerateContentRequest;", "Lcom/google/firebase/ai/common/Request;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "contents", "", "Lcom/google/firebase/ai/type/Content$Internal;", "safetySettings", "Lcom/google/firebase/ai/type/SafetySetting$Internal;", "generationConfig", "Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "tools", "Lcom/google/firebase/ai/type/Tool$Internal;", "toolConfig", "Lcom/google/firebase/ai/type/ToolConfig$Internal;", "systemInstruction", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/GenerationConfig$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/ToolConfig$Internal;Lcom/google/firebase/ai/type/Content$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/GenerationConfig$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/ToolConfig$Internal;Lcom/google/firebase/ai/type/Content$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModel", "()Ljava/lang/String;", "getContents", "()Ljava/util/List;", "getSafetySettings$annotations", "()V", "getSafetySettings", "getGenerationConfig$annotations", "getGenerationConfig", "()Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "getTools", "getToolConfig$annotations", "getToolConfig", "()Lcom/google/firebase/ai/type/ToolConfig$Internal;", "setToolConfig", "(Lcom/google/firebase/ai/type/ToolConfig$Internal;)V", "getSystemInstruction$annotations", "getSystemInstruction", "()Lcom/google/firebase/ai/type/Content$Internal;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final /* data */ class GenerateContentRequest implements Request {
    private final List<Content.Internal> contents;
    private final GenerationConfig.Internal generationConfig;
    private final String model;
    private final List<SafetySetting.Internal> safetySettings;
    private final Content.Internal systemInstruction;
    private ToolConfig.Internal toolConfig;
    private final List<Tool.Internal> tools;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(Content$Internal$$serializer.INSTANCE), new ArrayListSerializer(SafetySetting$Internal$$serializer.INSTANCE), null, new ArrayListSerializer(Tool$Internal$$serializer.INSTANCE), null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/common/GenerateContentRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/common/GenerateContentRequest;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GenerateContentRequest> serializer() {
            return GenerateContentRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GenerateContentRequest(int i, String str, List list, List list2, GenerationConfig.Internal internal, List list3, ToolConfig.Internal internal2, Content.Internal internal3, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2, GenerateContentRequest$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.model = null;
        } else {
            this.model = str;
        }
        this.contents = list;
        if ((i & 4) == 0) {
            this.safetySettings = null;
        } else {
            this.safetySettings = list2;
        }
        if ((i & 8) == 0) {
            this.generationConfig = null;
        } else {
            this.generationConfig = internal;
        }
        if ((i & 16) == 0) {
            this.tools = null;
        } else {
            this.tools = list3;
        }
        if ((i & 32) == 0) {
            this.toolConfig = null;
        } else {
            this.toolConfig = internal2;
        }
        if ((i & 64) == 0) {
            this.systemInstruction = null;
        } else {
            this.systemInstruction = internal3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenerateContentRequest copy$default(GenerateContentRequest generateContentRequest, String str, List list, List list2, GenerationConfig.Internal internal, List list3, ToolConfig.Internal internal2, Content.Internal internal3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = generateContentRequest.model;
        }
        if ((i & 2) != 0) {
            list = generateContentRequest.contents;
        }
        if ((i & 4) != 0) {
            list2 = generateContentRequest.safetySettings;
        }
        if ((i & 8) != 0) {
            internal = generateContentRequest.generationConfig;
        }
        if ((i & 16) != 0) {
            list3 = generateContentRequest.tools;
        }
        if ((i & 32) != 0) {
            internal2 = generateContentRequest.toolConfig;
        }
        if ((i & 64) != 0) {
            internal3 = generateContentRequest.systemInstruction;
        }
        ToolConfig.Internal internal4 = internal2;
        Content.Internal internal5 = internal3;
        List list4 = list3;
        List list5 = list2;
        return generateContentRequest.copy(str, list, list5, internal, list4, internal4, internal5);
    }

    @SerialName("generation_config")
    public static /* synthetic */ void getGenerationConfig$annotations() {
    }

    @SerialName("safety_settings")
    public static /* synthetic */ void getSafetySettings$annotations() {
    }

    @SerialName("system_instruction")
    public static /* synthetic */ void getSystemInstruction$annotations() {
    }

    @SerialName("tool_config")
    public static /* synthetic */ void getToolConfig$annotations() {
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(GenerateContentRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.model != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.model);
        }
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.contents);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.safetySettings != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.safetySettings);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.generationConfig != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, GenerationConfig$Internal$$serializer.INSTANCE, self.generationConfig);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.tools != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.tools);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.toolConfig != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ToolConfig$Internal$$serializer.INSTANCE, self.toolConfig);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.systemInstruction == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, Content$Internal$$serializer.INSTANCE, self.systemInstruction);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    public final List<Content.Internal> component2() {
        return this.contents;
    }

    public final List<SafetySetting.Internal> component3() {
        return this.safetySettings;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GenerationConfig.Internal getGenerationConfig() {
        return this.generationConfig;
    }

    public final List<Tool.Internal> component5() {
        return this.tools;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ToolConfig.Internal getToolConfig() {
        return this.toolConfig;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Content.Internal getSystemInstruction() {
        return this.systemInstruction;
    }

    public final GenerateContentRequest copy(String model, List<Content.Internal> contents, List<SafetySetting.Internal> safetySettings, GenerationConfig.Internal generationConfig, List<Tool.Internal> tools, ToolConfig.Internal toolConfig, Content.Internal systemInstruction) {
        contents.getClass();
        return new GenerateContentRequest(model, contents, safetySettings, generationConfig, tools, toolConfig, systemInstruction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateContentRequest)) {
            return false;
        }
        GenerateContentRequest generateContentRequest = (GenerateContentRequest) other;
        return Intrinsics.areEqual(this.model, generateContentRequest.model) && Intrinsics.areEqual(this.contents, generateContentRequest.contents) && Intrinsics.areEqual(this.safetySettings, generateContentRequest.safetySettings) && Intrinsics.areEqual(this.generationConfig, generateContentRequest.generationConfig) && Intrinsics.areEqual(this.tools, generateContentRequest.tools) && Intrinsics.areEqual(this.toolConfig, generateContentRequest.toolConfig) && Intrinsics.areEqual(this.systemInstruction, generateContentRequest.systemInstruction);
    }

    public final List<Content.Internal> getContents() {
        return this.contents;
    }

    public final GenerationConfig.Internal getGenerationConfig() {
        return this.generationConfig;
    }

    public final String getModel() {
        return this.model;
    }

    public final List<SafetySetting.Internal> getSafetySettings() {
        return this.safetySettings;
    }

    public final Content.Internal getSystemInstruction() {
        return this.systemInstruction;
    }

    public final ToolConfig.Internal getToolConfig() {
        return this.toolConfig;
    }

    public final List<Tool.Internal> getTools() {
        return this.tools;
    }

    public int hashCode() {
        String str = this.model;
        int iM = FileInsert$$ExternalSyntheticOutline0.m((List) this.contents, (str == null ? 0 : str.hashCode()) * 31, 31);
        List<SafetySetting.Internal> list = this.safetySettings;
        int iHashCode = (iM + (list == null ? 0 : list.hashCode())) * 31;
        GenerationConfig.Internal internal = this.generationConfig;
        int iHashCode2 = (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31;
        List<Tool.Internal> list2 = this.tools;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        ToolConfig.Internal internal2 = this.toolConfig;
        int iHashCode4 = (iHashCode3 + (internal2 == null ? 0 : internal2.hashCode())) * 31;
        Content.Internal internal3 = this.systemInstruction;
        return iHashCode4 + (internal3 != null ? internal3.hashCode() : 0);
    }

    public final void setToolConfig(ToolConfig.Internal internal) {
        this.toolConfig = internal;
    }

    public String toString() {
        return "GenerateContentRequest(model=" + this.model + ", contents=" + this.contents + ", safetySettings=" + this.safetySettings + ", generationConfig=" + this.generationConfig + ", tools=" + this.tools + ", toolConfig=" + this.toolConfig + ", systemInstruction=" + this.systemInstruction + ')';
    }

    public GenerateContentRequest(String str, List<Content.Internal> list, List<SafetySetting.Internal> list2, GenerationConfig.Internal internal, List<Tool.Internal> list3, ToolConfig.Internal internal2, Content.Internal internal3) {
        list.getClass();
        this.model = str;
        this.contents = list;
        this.safetySettings = list2;
        this.generationConfig = internal;
        this.tools = list3;
        this.toolConfig = internal2;
        this.systemInstruction = internal3;
    }

    public /* synthetic */ GenerateContentRequest(String str, List list, List list2, GenerationConfig.Internal internal, List list3, ToolConfig.Internal internal2, Content.Internal internal3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : internal, (i & 16) != 0 ? null : list3, (i & 32) != 0 ? null : internal2, (i & 64) != 0 ? null : internal3);
    }
}

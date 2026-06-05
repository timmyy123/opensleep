package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.ai.type.AudioTranscriptionConfig;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.LiveGenerationConfig;
import com.google.firebase.ai.type.Tool;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001dBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/ai/type/LiveClientSetupMessage;", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "generationConfig", "Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "tools", "", "Lcom/google/firebase/ai/type/Tool$Internal;", "systemInstruction", "Lcom/google/firebase/ai/type/Content$Internal;", "inputAudioTranscription", "Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;", "outputAudioTranscription", "<init>", "(Ljava/lang/String;Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;)V", "getModel", "()Ljava/lang/String;", "getGenerationConfig", "()Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "getTools", "()Ljava/util/List;", "getSystemInstruction", "()Lcom/google/firebase/ai/type/Content$Internal;", "getInputAudioTranscription", "()Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;", "getOutputAudioTranscription", "toInternal", "Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveClientSetupMessage {
    private final LiveGenerationConfig.Internal generationConfig;
    private final AudioTranscriptionConfig.Internal inputAudioTranscription;
    private final String model;
    private final AudioTranscriptionConfig.Internal outputAudioTranscription;
    private final Content.Internal systemInstruction;
    private final List<Tool.Internal> tools;

    public LiveClientSetupMessage(String str, LiveGenerationConfig.Internal internal, List<Tool.Internal> list, Content.Internal internal2, AudioTranscriptionConfig.Internal internal3, AudioTranscriptionConfig.Internal internal4) {
        str.getClass();
        this.model = str;
        this.generationConfig = internal;
        this.tools = list;
        this.systemInstruction = internal2;
        this.inputAudioTranscription = internal3;
        this.outputAudioTranscription = internal4;
    }

    public final LiveGenerationConfig.Internal getGenerationConfig() {
        return this.generationConfig;
    }

    public final AudioTranscriptionConfig.Internal getInputAudioTranscription() {
        return this.inputAudioTranscription;
    }

    public final String getModel() {
        return this.model;
    }

    public final AudioTranscriptionConfig.Internal getOutputAudioTranscription() {
        return this.outputAudioTranscription;
    }

    public final Content.Internal getSystemInstruction() {
        return this.systemInstruction;
    }

    public final List<Tool.Internal> getTools() {
        return this.tools;
    }

    public final Internal toInternal() {
        return new Internal(new Internal.LiveClientSetup(this.model, this.generationConfig, this.tools, this.systemInstruction, this.inputAudioTranscription, this.outputAudioTranscription));
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal;", "", "setup", "Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;", "<init>", "(Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSetup", "()Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "LiveClientSetup", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final LiveClientSetup setup;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return LiveClientSetupMessage$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, LiveClientSetup liveClientSetup, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, LiveClientSetupMessage$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.setup = liveClientSetup;
        }

        public final LiveClientSetup getSetup() {
            return this.setup;
        }

        public Internal(LiveClientSetup liveClientSetup) {
            liveClientSetup.getClass();
            this.setup = liveClientSetup;
        }

        @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 52\u00020\u0001:\u000245BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB]\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003JU\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0011HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00066"}, d2 = {"Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "generationConfig", "Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "tools", "", "Lcom/google/firebase/ai/type/Tool$Internal;", "systemInstruction", "Lcom/google/firebase/ai/type/Content$Internal;", "inputAudioTranscription", "Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;", "outputAudioTranscription", "<init>", "(Ljava/lang/String;Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;Ljava/util/List;Lcom/google/firebase/ai/type/Content$Internal;Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModel", "()Ljava/lang/String;", "getGenerationConfig", "()Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "getTools", "()Ljava/util/List;", "getSystemInstruction", "()Lcom/google/firebase/ai/type/Content$Internal;", "getInputAudioTranscription", "()Lcom/google/firebase/ai/type/AudioTranscriptionConfig$Internal;", "getOutputAudioTranscription", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class LiveClientSetup {
            private static final KSerializer<Object>[] $childSerializers;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final LiveGenerationConfig.Internal generationConfig;
            private final AudioTranscriptionConfig.Internal inputAudioTranscription;
            private final String model;
            private final AudioTranscriptionConfig.Internal outputAudioTranscription;
            private final Content.Internal systemInstruction;
            private final List<Tool.Internal> tools;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<LiveClientSetup> serializer() {
                    return LiveClientSetupMessage$Internal$LiveClientSetup$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            static {
                ArrayListSerializer arrayListSerializer = new ArrayListSerializer(Tool$Internal$$serializer.INSTANCE);
                AudioTranscriptionConfig.Internal internal = AudioTranscriptionConfig.Internal.INSTANCE;
                $childSerializers = new KSerializer[]{null, null, arrayListSerializer, null, new ObjectSerializer("com.google.firebase.ai.type.AudioTranscriptionConfig.Internal", internal, new Annotation[0]), new ObjectSerializer("com.google.firebase.ai.type.AudioTranscriptionConfig.Internal", internal, new Annotation[0])};
            }

            public /* synthetic */ LiveClientSetup(int i, String str, LiveGenerationConfig.Internal internal, List list, Content.Internal internal2, AudioTranscriptionConfig.Internal internal3, AudioTranscriptionConfig.Internal internal4, SerializationConstructorMarker serializationConstructorMarker) {
                if (63 != (i & 63)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 63, LiveClientSetupMessage$Internal$LiveClientSetup$$serializer.INSTANCE.getDescriptor());
                }
                this.model = str;
                this.generationConfig = internal;
                this.tools = list;
                this.systemInstruction = internal2;
                this.inputAudioTranscription = internal3;
                this.outputAudioTranscription = internal4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LiveClientSetup copy$default(LiveClientSetup liveClientSetup, String str, LiveGenerationConfig.Internal internal, List list, Content.Internal internal2, AudioTranscriptionConfig.Internal internal3, AudioTranscriptionConfig.Internal internal4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = liveClientSetup.model;
                }
                if ((i & 2) != 0) {
                    internal = liveClientSetup.generationConfig;
                }
                if ((i & 4) != 0) {
                    list = liveClientSetup.tools;
                }
                if ((i & 8) != 0) {
                    internal2 = liveClientSetup.systemInstruction;
                }
                if ((i & 16) != 0) {
                    internal3 = liveClientSetup.inputAudioTranscription;
                }
                if ((i & 32) != 0) {
                    internal4 = liveClientSetup.outputAudioTranscription;
                }
                AudioTranscriptionConfig.Internal internal5 = internal3;
                AudioTranscriptionConfig.Internal internal6 = internal4;
                return liveClientSetup.copy(str, internal, list, internal2, internal5, internal6);
            }

            public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(LiveClientSetup self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.model);
                output.encodeNullableSerializableElement(serialDesc, 1, LiveGenerationConfig$Internal$$serializer.INSTANCE, self.generationConfig);
                output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.tools);
                output.encodeNullableSerializableElement(serialDesc, 3, Content$Internal$$serializer.INSTANCE, self.systemInstruction);
                output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.inputAudioTranscription);
                output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.outputAudioTranscription);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getModel() {
                return this.model;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final LiveGenerationConfig.Internal getGenerationConfig() {
                return this.generationConfig;
            }

            public final List<Tool.Internal> component3() {
                return this.tools;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Content.Internal getSystemInstruction() {
                return this.systemInstruction;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final AudioTranscriptionConfig.Internal getInputAudioTranscription() {
                return this.inputAudioTranscription;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final AudioTranscriptionConfig.Internal getOutputAudioTranscription() {
                return this.outputAudioTranscription;
            }

            public final LiveClientSetup copy(String model, LiveGenerationConfig.Internal generationConfig, List<Tool.Internal> tools, Content.Internal systemInstruction, AudioTranscriptionConfig.Internal inputAudioTranscription, AudioTranscriptionConfig.Internal outputAudioTranscription) {
                model.getClass();
                return new LiveClientSetup(model, generationConfig, tools, systemInstruction, inputAudioTranscription, outputAudioTranscription);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LiveClientSetup)) {
                    return false;
                }
                LiveClientSetup liveClientSetup = (LiveClientSetup) other;
                return Intrinsics.areEqual(this.model, liveClientSetup.model) && Intrinsics.areEqual(this.generationConfig, liveClientSetup.generationConfig) && Intrinsics.areEqual(this.tools, liveClientSetup.tools) && Intrinsics.areEqual(this.systemInstruction, liveClientSetup.systemInstruction) && Intrinsics.areEqual(this.inputAudioTranscription, liveClientSetup.inputAudioTranscription) && Intrinsics.areEqual(this.outputAudioTranscription, liveClientSetup.outputAudioTranscription);
            }

            public final LiveGenerationConfig.Internal getGenerationConfig() {
                return this.generationConfig;
            }

            public final AudioTranscriptionConfig.Internal getInputAudioTranscription() {
                return this.inputAudioTranscription;
            }

            public final String getModel() {
                return this.model;
            }

            public final AudioTranscriptionConfig.Internal getOutputAudioTranscription() {
                return this.outputAudioTranscription;
            }

            public final Content.Internal getSystemInstruction() {
                return this.systemInstruction;
            }

            public final List<Tool.Internal> getTools() {
                return this.tools;
            }

            public int hashCode() {
                int iHashCode = this.model.hashCode() * 31;
                LiveGenerationConfig.Internal internal = this.generationConfig;
                int iHashCode2 = (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31;
                List<Tool.Internal> list = this.tools;
                int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                Content.Internal internal2 = this.systemInstruction;
                int iHashCode4 = (iHashCode3 + (internal2 == null ? 0 : internal2.hashCode())) * 31;
                AudioTranscriptionConfig.Internal internal3 = this.inputAudioTranscription;
                int iHashCode5 = (iHashCode4 + (internal3 == null ? 0 : internal3.hashCode())) * 31;
                AudioTranscriptionConfig.Internal internal4 = this.outputAudioTranscription;
                return iHashCode5 + (internal4 != null ? internal4.hashCode() : 0);
            }

            public String toString() {
                return "LiveClientSetup(model=" + this.model + ", generationConfig=" + this.generationConfig + ", tools=" + this.tools + ", systemInstruction=" + this.systemInstruction + ", inputAudioTranscription=" + this.inputAudioTranscription + ", outputAudioTranscription=" + this.outputAudioTranscription + ')';
            }

            public LiveClientSetup(String str, LiveGenerationConfig.Internal internal, List<Tool.Internal> list, Content.Internal internal2, AudioTranscriptionConfig.Internal internal3, AudioTranscriptionConfig.Internal internal4) {
                str.getClass();
                this.model = str;
                this.generationConfig = internal;
                this.tools = list;
                this.systemInstruction = internal2;
                this.inputAudioTranscription = internal3;
                this.outputAudioTranscription = internal4;
            }
        }
    }
}

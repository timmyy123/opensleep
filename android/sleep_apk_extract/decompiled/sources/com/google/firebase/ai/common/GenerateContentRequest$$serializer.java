package com.google.firebase.ai.common;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.Content$Internal$$serializer;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerationConfig$Internal$$serializer;
import com.google.firebase.ai.type.ToolConfig;
import com.google.firebase.ai.type.ToolConfig$Internal$$serializer;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/common/GenerateContentRequest.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/common/GenerateContentRequest;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class GenerateContentRequest$$serializer implements GeneratedSerializer<GenerateContentRequest> {
    public static final GenerateContentRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GenerateContentRequest$$serializer generateContentRequest$$serializer = new GenerateContentRequest$$serializer();
        INSTANCE = generateContentRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.common.GenerateContentRequest", generateContentRequest$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(DeviceRequestsHelper.DEVICE_INFO_MODEL, true);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("safety_settings", true);
        pluginGeneratedSerialDescriptor.addElement("generation_config", true);
        pluginGeneratedSerialDescriptor.addElement("tools", true);
        pluginGeneratedSerialDescriptor.addElement("tool_config", true);
        pluginGeneratedSerialDescriptor.addElement("system_instruction", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GenerateContentRequest$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = GenerateContentRequest.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[1], BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(GenerationConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(ToolConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Content$Internal$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final GenerateContentRequest deserialize(Decoder decoder) {
        List list;
        List list2;
        List list3;
        String str;
        Content.Internal internal;
        ToolConfig.Internal internal2;
        GenerationConfig.Internal internal3;
        int i;
        int i2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = GenerateContentRequest.$childSerializers;
        int i3 = 6;
        int i4 = 1;
        List list4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            GenerationConfig.Internal internal4 = (GenerationConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, GenerationConfig$Internal$$serializer.INSTANCE, null);
            List list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            ToolConfig.Internal internal5 = (ToolConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ToolConfig$Internal$$serializer.INSTANCE, null);
            list = list7;
            str = str2;
            internal = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Content$Internal$$serializer.INSTANCE, null);
            internal2 = internal5;
            internal3 = internal4;
            i = 127;
            list3 = list6;
            list2 = list5;
        } else {
            boolean z = true;
            int i5 = 0;
            List list8 = null;
            List list9 = null;
            String str3 = null;
            Content.Internal internal6 = null;
            ToolConfig.Internal internal7 = null;
            GenerationConfig.Internal internal8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 6;
                        break;
                    case 0:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                        i5 |= 1;
                        i3 = 6;
                        i4 = 1;
                        break;
                    case 1:
                        int i6 = i4;
                        list9 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i6, kSerializerArr[i6], list9);
                        i5 |= 2;
                        i4 = i6;
                        i3 = 6;
                        break;
                    case 2:
                        i2 = i4;
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], list4);
                        i5 |= 4;
                        i4 = i2;
                        break;
                    case 3:
                        i2 = i4;
                        internal8 = (GenerationConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, GenerationConfig$Internal$$serializer.INSTANCE, internal8);
                        i5 |= 8;
                        i4 = i2;
                        break;
                    case 4:
                        i2 = i4;
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], list8);
                        i5 |= 16;
                        i4 = i2;
                        break;
                    case 5:
                        i2 = i4;
                        internal7 = (ToolConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ToolConfig$Internal$$serializer.INSTANCE, internal7);
                        i5 |= 32;
                        i4 = i2;
                        break;
                    case 6:
                        i2 = i4;
                        internal6 = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, Content$Internal$$serializer.INSTANCE, internal6);
                        i5 |= 64;
                        i4 = i2;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list8;
            list2 = list9;
            list3 = list4;
            str = str3;
            internal = internal6;
            internal2 = internal7;
            internal3 = internal8;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GenerateContentRequest(i, str, list2, list3, internal3, list, internal2, internal, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GenerateContentRequest value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        GenerateContentRequest.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

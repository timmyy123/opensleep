package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.Schema;
import com.google.firebase.ai.type.ThinkingConfig;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/GenerationConfig.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class GenerationConfig$Internal$$serializer implements GeneratedSerializer<GenerationConfig.Internal> {
    public static final GenerationConfig$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GenerationConfig$Internal$$serializer generationConfig$Internal$$serializer = new GenerationConfig$Internal$$serializer();
        INSTANCE = generationConfig$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.GenerationConfig.Internal", generationConfig$Internal$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("temperature", false);
        pluginGeneratedSerialDescriptor.addElement("top_p", false);
        pluginGeneratedSerialDescriptor.addElement("top_k", false);
        pluginGeneratedSerialDescriptor.addElement("candidate_count", false);
        pluginGeneratedSerialDescriptor.addElement("max_output_tokens", false);
        pluginGeneratedSerialDescriptor.addElement("stop_sequences", false);
        pluginGeneratedSerialDescriptor.addElement("response_mime_type", true);
        pluginGeneratedSerialDescriptor.addElement("presence_penalty", true);
        pluginGeneratedSerialDescriptor.addElement("frequency_penalty", true);
        pluginGeneratedSerialDescriptor.addElement("response_schema", true);
        pluginGeneratedSerialDescriptor.addElement("response_json_schema", true);
        pluginGeneratedSerialDescriptor.addElement("response_modalities", true);
        pluginGeneratedSerialDescriptor.addElement("thinking_config", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GenerationConfig$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = GenerationConfig.Internal.$childSerializers;
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(floatSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(floatSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(Schema$InternalOpenAPI$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[10]), BuiltinSerializersKt.getNullable(kSerializerArr[11]), BuiltinSerializersKt.getNullable(ThinkingConfig$Internal$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final GenerationConfig.Internal deserialize(Decoder decoder) {
        Float f;
        List list;
        Integer num;
        Integer num2;
        String str;
        Integer num3;
        Schema.InternalJson internalJson;
        Float f2;
        Float f3;
        List list2;
        int i;
        Schema.InternalOpenAPI internalOpenAPI;
        Float f4;
        ThinkingConfig.Internal internal;
        ThinkingConfig.Internal internal2;
        Float f5;
        KSerializer[] kSerializerArr;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr2 = GenerationConfig.Internal.$childSerializers;
        int i2 = 9;
        int i3 = 7;
        char c = 6;
        int i4 = 8;
        Float f6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            Float f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, floatSerializer, null);
            Float f8 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, floatSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, intSerializer, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, intSerializer, null);
            Integer num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, intSerializer, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr2[5], null);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            Float f9 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, floatSerializer, null);
            Float f10 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, floatSerializer, null);
            Schema.InternalOpenAPI internalOpenAPI2 = (Schema.InternalOpenAPI) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, Schema$InternalOpenAPI$$serializer.INSTANCE, null);
            Schema.InternalJson internalJson2 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, kSerializerArr2[10], null);
            f = f7;
            list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, kSerializerArr2[11], null);
            f3 = f10;
            internal = (ThinkingConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ThinkingConfig$Internal$$serializer.INSTANCE, null);
            internalOpenAPI = internalOpenAPI2;
            f2 = f9;
            str = str2;
            num2 = num5;
            internalJson = internalJson2;
            num = num6;
            num3 = num4;
            i = 8191;
            list = list3;
            f4 = f8;
        } else {
            int i5 = 12;
            String str3 = null;
            Schema.InternalJson internalJson3 = null;
            Float f11 = null;
            List list4 = null;
            Float f12 = null;
            Integer num7 = null;
            Integer num8 = null;
            Integer num9 = null;
            List list5 = null;
            Float f13 = null;
            int i6 = 5;
            boolean z = true;
            int i7 = 0;
            ThinkingConfig.Internal internal3 = null;
            Schema.InternalOpenAPI internalOpenAPI3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        internal2 = internal3;
                        f5 = f12;
                        z = false;
                        kSerializerArr2 = kSerializerArr2;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        i4 = 8;
                        i6 = 5;
                        f12 = f5;
                        internal3 = internal2;
                        break;
                    case 0:
                        internal2 = internal3;
                        f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, f12);
                        i7 |= 1;
                        f13 = f13;
                        kSerializerArr2 = kSerializerArr2;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        c = 6;
                        i4 = 8;
                        i6 = 5;
                        f12 = f5;
                        internal3 = internal2;
                        break;
                    case 1:
                        kSerializerArr = kSerializerArr2;
                        f13 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FloatSerializer.INSTANCE, f13);
                        i7 |= 2;
                        internal3 = internal3;
                        kSerializerArr2 = kSerializerArr;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        c = 6;
                        i4 = 8;
                        i6 = 5;
                        break;
                    case 2:
                        kSerializerArr = kSerializerArr2;
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num9);
                        i7 |= 4;
                        kSerializerArr2 = kSerializerArr;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        c = 6;
                        i4 = 8;
                        i6 = 5;
                        break;
                    case 3:
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num7);
                        i7 |= 8;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        c = 6;
                        i4 = 8;
                        i6 = 5;
                        break;
                    case 4:
                        num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num8);
                        i7 |= 16;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        c = 6;
                        i6 = 5;
                        break;
                    case 5:
                        list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, kSerializerArr2[i6], list5);
                        i7 |= 32;
                        i5 = 12;
                        i2 = 9;
                        c = 6;
                        break;
                    case 6:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str3);
                        i7 |= 64;
                        c = 6;
                        i5 = 12;
                        break;
                    case 7:
                        f11 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, FloatSerializer.INSTANCE, f11);
                        i7 |= 128;
                        i5 = 12;
                        c = 6;
                        break;
                    case 8:
                        f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, FloatSerializer.INSTANCE, f6);
                        i7 |= 256;
                        i5 = 12;
                        c = 6;
                        break;
                    case 9:
                        internalOpenAPI3 = (Schema.InternalOpenAPI) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, Schema$InternalOpenAPI$$serializer.INSTANCE, internalOpenAPI3);
                        i7 |= 512;
                        i5 = 12;
                        c = 6;
                        break;
                    case 10:
                        internalJson3 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, kSerializerArr2[10], internalJson3);
                        i7 |= 1024;
                        i5 = 12;
                        c = 6;
                        break;
                    case 11:
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, kSerializerArr2[11], list4);
                        i7 |= 2048;
                        i5 = 12;
                        c = 6;
                        break;
                    case 12:
                        internal3 = (ThinkingConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, ThinkingConfig$Internal$$serializer.INSTANCE, internal3);
                        i7 |= 4096;
                        c = 6;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            f = f12;
            list = list5;
            num = num8;
            num2 = num7;
            str = str3;
            num3 = num9;
            internalJson = internalJson3;
            f2 = f11;
            f3 = f6;
            list2 = list4;
            i = i7;
            internalOpenAPI = internalOpenAPI3;
            f4 = f13;
            internal = internal3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GenerationConfig.Internal(i, f, f4, num3, num2, num, list, str, f2, f3, internalOpenAPI, internalJson, list2, internal, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GenerationConfig.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        GenerationConfig.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

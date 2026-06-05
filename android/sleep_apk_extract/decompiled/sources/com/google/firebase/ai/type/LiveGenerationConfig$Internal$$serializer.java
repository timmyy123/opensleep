package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.LiveGenerationConfig;
import com.google.firebase.ai.type.SpeechConfig;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/LiveGenerationConfig.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class LiveGenerationConfig$Internal$$serializer implements GeneratedSerializer<LiveGenerationConfig.Internal> {
    public static final LiveGenerationConfig$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LiveGenerationConfig$Internal$$serializer liveGenerationConfig$Internal$$serializer = new LiveGenerationConfig$Internal$$serializer();
        INSTANCE = liveGenerationConfig$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.LiveGenerationConfig.Internal", liveGenerationConfig$Internal$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("temperature", false);
        pluginGeneratedSerialDescriptor.addElement("top_p", false);
        pluginGeneratedSerialDescriptor.addElement("top_k", false);
        pluginGeneratedSerialDescriptor.addElement("max_output_tokens", false);
        pluginGeneratedSerialDescriptor.addElement("presence_penalty", true);
        pluginGeneratedSerialDescriptor.addElement("frequency_penalty", true);
        pluginGeneratedSerialDescriptor.addElement("speech_config", true);
        pluginGeneratedSerialDescriptor.addElement("response_modalities", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LiveGenerationConfig$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = LiveGenerationConfig.Internal.$childSerializers;
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(floatSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(floatSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(SpeechConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[7])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LiveGenerationConfig.Internal deserialize(Decoder decoder) {
        List list;
        Float f;
        Float f2;
        Integer num;
        Float f3;
        Integer num2;
        Float f4;
        SpeechConfig.Internal internal;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = LiveGenerationConfig.Internal.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        int i4 = 3;
        char c = 2;
        Integer num3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            Float f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, floatSerializer, null);
            Float f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, floatSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, intSerializer, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, intSerializer, null);
            Float f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, floatSerializer, null);
            Float f8 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, floatSerializer, null);
            SpeechConfig.Internal internal2 = (SpeechConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, SpeechConfig$Internal$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, kSerializerArr[7], null);
            f4 = f8;
            internal = internal2;
            i = 255;
            num2 = num5;
            f3 = f7;
            num = num4;
            f = f6;
            f2 = f5;
        } else {
            boolean z = true;
            int i5 = 0;
            List list2 = null;
            Integer num6 = null;
            Float f9 = null;
            Float f10 = null;
            SpeechConfig.Internal internal3 = null;
            Float f11 = null;
            Float f12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 6;
                        i3 = 5;
                        i4 = 3;
                        continue;
                    case 0:
                        f12 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, f12);
                        i5 |= 1;
                        i2 = 6;
                        i3 = 5;
                        i4 = 3;
                        break;
                    case 1:
                        f11 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FloatSerializer.INSTANCE, f11);
                        i5 |= 2;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 2:
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num6);
                        i5 |= 4;
                        c = 2;
                        i2 = 6;
                        continue;
                    case 3:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, IntSerializer.INSTANCE, num3);
                        i5 |= 8;
                        break;
                    case 4:
                        f9 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, f9);
                        i5 |= 16;
                        break;
                    case 5:
                        f10 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, FloatSerializer.INSTANCE, f10);
                        i5 |= 32;
                        break;
                    case 6:
                        internal3 = (SpeechConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, SpeechConfig$Internal$$serializer.INSTANCE, internal3);
                        i5 |= 64;
                        break;
                    case 7:
                        list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, kSerializerArr[7], list2);
                        i5 |= 128;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                c = 2;
            }
            list = list2;
            f = f11;
            f2 = f12;
            num = num6;
            f3 = f9;
            num2 = num3;
            f4 = f10;
            internal = internal3;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LiveGenerationConfig.Internal(i, f2, f, num, num2, f3, f4, internal, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LiveGenerationConfig.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        LiveGenerationConfig.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

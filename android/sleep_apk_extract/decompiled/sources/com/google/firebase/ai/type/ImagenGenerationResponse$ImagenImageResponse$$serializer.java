package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.ImagenGenerationResponse;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/ImagenGenerationResponse.ImagenImageResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$ImagenImageResponse;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class ImagenGenerationResponse$ImagenImageResponse$$serializer implements GeneratedSerializer<ImagenGenerationResponse.ImagenImageResponse> {
    public static final ImagenGenerationResponse$ImagenImageResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ImagenGenerationResponse$ImagenImageResponse$$serializer imagenGenerationResponse$ImagenImageResponse$$serializer = new ImagenGenerationResponse$ImagenImageResponse$$serializer();
        INSTANCE = imagenGenerationResponse$ImagenImageResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.ImagenGenerationResponse.ImagenImageResponse", imagenGenerationResponse$ImagenImageResponse$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("bytesBase64Encoded", true);
        pluginGeneratedSerialDescriptor.addElement("gcsUri", true);
        pluginGeneratedSerialDescriptor.addElement("mimeType", true);
        pluginGeneratedSerialDescriptor.addElement("raiFilteredReason", true);
        pluginGeneratedSerialDescriptor.addElement("safetyAttributes", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImagenGenerationResponse$ImagenImageResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(ImagenGenerationResponse$ImagenSafetyAttributes$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ImagenGenerationResponse.ImagenImageResponse deserialize(Decoder decoder) {
        String str;
        ImagenGenerationResponse.ImagenSafetyAttributes imagenSafetyAttributes;
        int i;
        String str2;
        String str3;
        String str4;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        ImagenGenerationResponse.ImagenImageResponse imagenImageResponse = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            imagenSafetyAttributes = (ImagenGenerationResponse.ImagenSafetyAttributes) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ImagenGenerationResponse$ImagenSafetyAttributes$$serializer.INSTANCE, null);
            i = 31;
            str2 = str7;
            str3 = str6;
            str4 = str5;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            ImagenGenerationResponse.ImagenSafetyAttributes imagenSafetyAttributes2 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                ImagenGenerationResponse.ImagenImageResponse imagenImageResponse2 = imagenImageResponse;
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str10);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                            return imagenImageResponse2;
                        }
                        imagenSafetyAttributes2 = (ImagenGenerationResponse.ImagenSafetyAttributes) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ImagenGenerationResponse$ImagenSafetyAttributes$$serializer.INSTANCE, imagenSafetyAttributes2);
                        i2 |= 16;
                    }
                    imagenImageResponse = imagenImageResponse2;
                } else {
                    imagenImageResponse = imagenImageResponse2;
                    z = false;
                }
            }
            imagenSafetyAttributes = imagenSafetyAttributes2;
            i = i2;
            str2 = str8;
            str3 = str9;
            str4 = str10;
        }
        String str11 = str;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ImagenGenerationResponse.ImagenImageResponse(i, str4, str3, str2, str11, imagenSafetyAttributes, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ImagenGenerationResponse.ImagenImageResponse value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ImagenGenerationResponse.ImagenImageResponse.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

package com.google.firebase.ai.common;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.common.GenerateImageRequest;
import com.google.firebase.ai.type.ImagenEditingConfig;
import com.google.firebase.ai.type.ImagenEditingConfig$Internal$$serializer;
import com.google.firebase.ai.type.ImagenImageFormat;
import com.google.firebase.ai.type.ImagenImageFormat$Internal$$serializer;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/common/GenerateImageRequest.ImagenParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/common/GenerateImageRequest$ImagenParameters;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class GenerateImageRequest$ImagenParameters$$serializer implements GeneratedSerializer<GenerateImageRequest.ImagenParameters> {
    public static final GenerateImageRequest$ImagenParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GenerateImageRequest$ImagenParameters$$serializer generateImageRequest$ImagenParameters$$serializer = new GenerateImageRequest$ImagenParameters$$serializer();
        INSTANCE = generateImageRequest$ImagenParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.common.GenerateImageRequest.ImagenParameters", generateImageRequest$ImagenParameters$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("sampleCount", false);
        pluginGeneratedSerialDescriptor.addElement("includeRaiReason", false);
        pluginGeneratedSerialDescriptor.addElement("includeSafetyAttributes", false);
        pluginGeneratedSerialDescriptor.addElement("storageUri", false);
        pluginGeneratedSerialDescriptor.addElement("negativePrompt", false);
        pluginGeneratedSerialDescriptor.addElement("aspectRatio", false);
        pluginGeneratedSerialDescriptor.addElement("safetySetting", false);
        pluginGeneratedSerialDescriptor.addElement("personGeneration", false);
        pluginGeneratedSerialDescriptor.addElement("addWatermark", false);
        pluginGeneratedSerialDescriptor.addElement("imageOutputOptions", false);
        pluginGeneratedSerialDescriptor.addElement("editMode", false);
        pluginGeneratedSerialDescriptor.addElement("editConfig", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GenerateImageRequest$ImagenParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{IntSerializer.INSTANCE, booleanSerializer, booleanSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(ImagenImageFormat$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(ImagenEditingConfig$Internal$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final GenerateImageRequest.ImagenParameters deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        int i2;
        ImagenEditingConfig.Internal internal;
        String str3;
        String str4;
        String str5;
        ImagenImageFormat.Internal internal2;
        String str6;
        Boolean bool;
        boolean z;
        boolean z2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i3 = 10;
        int i4 = 9;
        char c = 7;
        Boolean bool2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, null);
            ImagenImageFormat.Internal internal3 = (ImagenImageFormat.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, ImagenImageFormat$Internal$$serializer.INSTANCE, null);
            i = iDecodeIntElement;
            bool = bool3;
            str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, stringSerializer, null);
            internal2 = internal3;
            str5 = str11;
            str3 = str10;
            str4 = str9;
            str2 = str7;
            internal = (ImagenEditingConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, ImagenEditingConfig$Internal$$serializer.INSTANCE, null);
            str = str8;
            z = zDecodeBooleanElement2;
            z2 = zDecodeBooleanElement;
            i2 = 4095;
        } else {
            int i5 = 11;
            boolean z3 = true;
            int iDecodeIntElement2 = 0;
            int i6 = 0;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            ImagenEditingConfig.Internal internal4 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            ImagenImageFormat.Internal internal5 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i5 = 11;
                        i3 = 10;
                        i4 = 9;
                        c = 7;
                        break;
                    case 0:
                        i6 |= 1;
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i5 = 11;
                        i3 = 10;
                        i4 = 9;
                        c = 7;
                        break;
                    case 1:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i6 |= 2;
                        i5 = 11;
                        i3 = 10;
                        i4 = 9;
                        c = 7;
                        break;
                    case 2:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i6 |= 4;
                        i5 = 11;
                        i3 = 10;
                        i4 = 9;
                        c = 7;
                        break;
                    case 3:
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str16);
                        i6 |= 8;
                        i5 = 11;
                        i3 = 10;
                        i4 = 9;
                        c = 7;
                        break;
                    case 4:
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str17);
                        i6 |= 16;
                        i5 = 11;
                        i3 = 10;
                        c = 7;
                        break;
                    case 5:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str13);
                        i6 |= 32;
                        i5 = 11;
                        c = 7;
                        break;
                    case 6:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str12);
                        i6 |= 64;
                        i5 = 11;
                        c = 7;
                        break;
                    case 7:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str14);
                        i6 |= 128;
                        c = 7;
                        i5 = 11;
                        break;
                    case 8:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool2);
                        i6 |= 256;
                        c = 7;
                        break;
                    case 9:
                        internal5 = (ImagenImageFormat.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, ImagenImageFormat$Internal$$serializer.INSTANCE, internal5);
                        i6 |= 512;
                        c = 7;
                        break;
                    case 10:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str15);
                        i6 |= 1024;
                        c = 7;
                        break;
                    case 11:
                        internal4 = (ImagenEditingConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, ImagenEditingConfig$Internal$$serializer.INSTANCE, internal4);
                        i6 |= 2048;
                        c = 7;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str17;
            i = iDecodeIntElement2;
            str2 = str16;
            i2 = i6;
            internal = internal4;
            str3 = str12;
            str4 = str13;
            str5 = str14;
            internal2 = internal5;
            str6 = str15;
            bool = bool2;
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GenerateImageRequest.ImagenParameters(i2, i, z2, z, str2, str, str4, str3, str5, bool, internal2, str6, internal, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GenerateImageRequest.ImagenParameters value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        GenerateImageRequest.ImagenParameters.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

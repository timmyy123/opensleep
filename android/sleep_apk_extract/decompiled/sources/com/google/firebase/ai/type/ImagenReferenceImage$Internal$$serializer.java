package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.common.GenerateImageRequest;
import com.google.firebase.ai.type.ImagenControlConfig;
import com.google.firebase.ai.type.ImagenInlineImage;
import com.google.firebase.ai.type.ImagenMaskConfig;
import com.google.firebase.ai.type.ImagenReferenceImage;
import com.google.firebase.ai.type.ImagenStyleConfig;
import com.google.firebase.ai.type.ImagenSubjectConfig;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/ImagenReferenceImage.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/ImagenReferenceImage$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class ImagenReferenceImage$Internal$$serializer implements GeneratedSerializer<ImagenReferenceImage.Internal> {
    public static final ImagenReferenceImage$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ImagenReferenceImage$Internal$$serializer imagenReferenceImage$Internal$$serializer = new ImagenReferenceImage$Internal$$serializer();
        INSTANCE = imagenReferenceImage$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.ImagenReferenceImage.Internal", imagenReferenceImage$Internal$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("referenceType", false);
        pluginGeneratedSerialDescriptor.addElement("referenceImage", false);
        pluginGeneratedSerialDescriptor.addElement("referenceId", false);
        pluginGeneratedSerialDescriptor.addElement("subjectImageConfig", false);
        pluginGeneratedSerialDescriptor.addElement("maskImageConfig", false);
        pluginGeneratedSerialDescriptor.addElement("styleImageConfig", false);
        pluginGeneratedSerialDescriptor.addElement("controlConfig", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImagenReferenceImage$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ImagenReferenceImage.Internal.$childSerializers[0], BuiltinSerializersKt.getNullable(ImagenInlineImage$Internal$$serializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(ImagenSubjectConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ImagenMaskConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ImagenStyleConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ImagenControlConfig$Internal$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ImagenReferenceImage.Internal deserialize(Decoder decoder) {
        GenerateImageRequest.ReferenceType referenceType;
        ImagenMaskConfig.Internal internal;
        ImagenInlineImage.Internal internal2;
        ImagenControlConfig.Internal internal3;
        ImagenStyleConfig.Internal internal4;
        ImagenSubjectConfig.Internal internal5;
        int i;
        int i2;
        int i3;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = ImagenReferenceImage.Internal.$childSerializers;
        int i4 = 6;
        int i5 = 0;
        ImagenMaskConfig.Internal internal6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            GenerateImageRequest.ReferenceType referenceType2 = (GenerateImageRequest.ReferenceType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            ImagenInlineImage.Internal internal7 = (ImagenInlineImage.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ImagenInlineImage$Internal$$serializer.INSTANCE, null);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
            ImagenSubjectConfig.Internal internal8 = (ImagenSubjectConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ImagenSubjectConfig$Internal$$serializer.INSTANCE, null);
            ImagenMaskConfig.Internal internal9 = (ImagenMaskConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ImagenMaskConfig$Internal$$serializer.INSTANCE, null);
            ImagenStyleConfig.Internal internal10 = (ImagenStyleConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ImagenStyleConfig$Internal$$serializer.INSTANCE, null);
            referenceType = referenceType2;
            internal2 = internal7;
            internal3 = (ImagenControlConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ImagenControlConfig$Internal$$serializer.INSTANCE, null);
            internal4 = internal10;
            internal5 = internal8;
            internal = internal9;
            i = iDecodeIntElement;
            i2 = 127;
        } else {
            int i6 = 1;
            int iDecodeIntElement2 = 0;
            int i7 = 0;
            GenerateImageRequest.ReferenceType referenceType3 = null;
            ImagenInlineImage.Internal internal11 = null;
            ImagenControlConfig.Internal internal12 = null;
            ImagenStyleConfig.Internal internal13 = null;
            ImagenSubjectConfig.Internal internal14 = null;
            while (i6 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        i6 = i5;
                        i4 = 6;
                        break;
                    case 0:
                        int i8 = i5;
                        referenceType3 = (GenerateImageRequest.ReferenceType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i8, kSerializerArr[i8], referenceType3);
                        i7 |= 1;
                        i5 = i8;
                        i4 = 6;
                        break;
                    case 1:
                        i3 = i5;
                        internal11 = (ImagenInlineImage.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ImagenInlineImage$Internal$$serializer.INSTANCE, internal11);
                        i7 |= 2;
                        i5 = i3;
                        break;
                    case 2:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i7 |= 4;
                        break;
                    case 3:
                        i3 = i5;
                        internal14 = (ImagenSubjectConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ImagenSubjectConfig$Internal$$serializer.INSTANCE, internal14);
                        i7 |= 8;
                        i5 = i3;
                        break;
                    case 4:
                        i3 = i5;
                        internal6 = (ImagenMaskConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ImagenMaskConfig$Internal$$serializer.INSTANCE, internal6);
                        i7 |= 16;
                        i5 = i3;
                        break;
                    case 5:
                        i3 = i5;
                        internal13 = (ImagenStyleConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ImagenStyleConfig$Internal$$serializer.INSTANCE, internal13);
                        i7 |= 32;
                        i5 = i3;
                        break;
                    case 6:
                        i3 = i5;
                        internal12 = (ImagenControlConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, ImagenControlConfig$Internal$$serializer.INSTANCE, internal12);
                        i7 |= 64;
                        i5 = i3;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            referenceType = referenceType3;
            internal = internal6;
            internal2 = internal11;
            internal3 = internal12;
            internal4 = internal13;
            internal5 = internal14;
            i = iDecodeIntElement2;
            i2 = i7;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ImagenReferenceImage.Internal(i2, referenceType, internal2, i, internal5, internal, internal4, internal3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ImagenReferenceImage.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ImagenReferenceImage.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

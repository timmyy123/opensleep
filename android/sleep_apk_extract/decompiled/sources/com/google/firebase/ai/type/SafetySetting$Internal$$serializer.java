package com.google.firebase.ai.type;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.HarmBlockMethod;
import com.google.firebase.ai.type.HarmBlockThreshold;
import com.google.firebase.ai.type.HarmCategory;
import com.google.firebase.ai.type.SafetySetting;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/SafetySetting.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/SafetySetting$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SafetySetting$Internal$$serializer implements GeneratedSerializer<SafetySetting.Internal> {
    public static final SafetySetting$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SafetySetting$Internal$$serializer safetySetting$Internal$$serializer = new SafetySetting$Internal$$serializer();
        INSTANCE = safetySetting$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.SafetySetting.Internal", safetySetting$Internal$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, false);
        pluginGeneratedSerialDescriptor.addElement("threshold", false);
        pluginGeneratedSerialDescriptor.addElement("method", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SafetySetting$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = SafetySetting.Internal.$childSerializers;
        return new KSerializer[]{HarmCategory.Internal.Serializer.INSTANCE, kSerializerArr[1], BuiltinSerializersKt.getNullable(kSerializerArr[2])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SafetySetting.Internal deserialize(Decoder decoder) {
        HarmBlockMethod.Internal internal;
        HarmCategory.Internal internal2;
        int i;
        HarmBlockThreshold.Internal internal3;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = SafetySetting.Internal.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            HarmCategory.Internal internal4 = (HarmCategory.Internal) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, HarmCategory.Internal.Serializer.INSTANCE, null);
            HarmBlockThreshold.Internal internal5 = (HarmBlockThreshold.Internal) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            internal = (HarmBlockMethod.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            internal2 = internal4;
            i = 7;
            internal3 = internal5;
        } else {
            boolean z = true;
            int i2 = 0;
            HarmBlockMethod.Internal internal6 = null;
            HarmCategory.Internal internal7 = null;
            HarmBlockThreshold.Internal internal8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    internal7 = (HarmCategory.Internal) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, HarmCategory.Internal.Serializer.INSTANCE, internal7);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    internal8 = (HarmBlockThreshold.Internal) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], internal8);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    internal6 = (HarmBlockMethod.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], internal6);
                    i2 |= 4;
                }
            }
            internal = internal6;
            internal2 = internal7;
            i = i2;
            internal3 = internal8;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SafetySetting.Internal(i, internal2, internal3, internal, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SafetySetting.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SafetySetting.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

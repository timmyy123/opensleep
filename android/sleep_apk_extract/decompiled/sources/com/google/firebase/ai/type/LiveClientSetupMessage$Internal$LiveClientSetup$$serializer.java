package com.google.firebase.ai.type;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.AudioTranscriptionConfig;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.LiveClientSetupMessage;
import com.google.firebase.ai.type.LiveGenerationConfig;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/LiveClientSetupMessage.Internal.LiveClientSetup.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/LiveClientSetupMessage$Internal$LiveClientSetup;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class LiveClientSetupMessage$Internal$LiveClientSetup$$serializer implements GeneratedSerializer<LiveClientSetupMessage.Internal.LiveClientSetup> {
    public static final LiveClientSetupMessage$Internal$LiveClientSetup$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LiveClientSetupMessage$Internal$LiveClientSetup$$serializer liveClientSetupMessage$Internal$LiveClientSetup$$serializer = new LiveClientSetupMessage$Internal$LiveClientSetup$$serializer();
        INSTANCE = liveClientSetupMessage$Internal$LiveClientSetup$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.LiveClientSetupMessage.Internal.LiveClientSetup", liveClientSetupMessage$Internal$LiveClientSetup$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(DeviceRequestsHelper.DEVICE_INFO_MODEL, false);
        pluginGeneratedSerialDescriptor.addElement("generationConfig", false);
        pluginGeneratedSerialDescriptor.addElement("tools", false);
        pluginGeneratedSerialDescriptor.addElement("systemInstruction", false);
        pluginGeneratedSerialDescriptor.addElement("inputAudioTranscription", false);
        pluginGeneratedSerialDescriptor.addElement("outputAudioTranscription", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LiveClientSetupMessage$Internal$LiveClientSetup$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = LiveClientSetupMessage.Internal.LiveClientSetup.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LiveGenerationConfig$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(Content$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LiveClientSetupMessage.Internal.LiveClientSetup deserialize(Decoder decoder) {
        AudioTranscriptionConfig.Internal internal;
        LiveGenerationConfig.Internal internal2;
        String str;
        Content.Internal internal3;
        int i;
        AudioTranscriptionConfig.Internal internal4;
        List list;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = LiveClientSetupMessage.Internal.LiveClientSetup.$childSerializers;
        int i2 = 0;
        LiveGenerationConfig.Internal internal5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            LiveGenerationConfig.Internal internal6 = (LiveGenerationConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LiveGenerationConfig$Internal$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            Content.Internal internal7 = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Content$Internal$$serializer.INSTANCE, null);
            AudioTranscriptionConfig.Internal internal8 = (AudioTranscriptionConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            internal = (AudioTranscriptionConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            str = strDecodeStringElement;
            internal3 = internal7;
            i = 63;
            internal4 = internal8;
            list = list2;
            internal2 = internal6;
        } else {
            int i3 = 1;
            int i4 = 0;
            AudioTranscriptionConfig.Internal internal9 = null;
            String strDecodeStringElement2 = null;
            Content.Internal internal10 = null;
            AudioTranscriptionConfig.Internal internal11 = null;
            List list3 = null;
            while (i3 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        i3 = i2;
                        continue;
                    case 0:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i2);
                        i4 |= 1;
                        continue;
                    case 1:
                        internal5 = (LiveGenerationConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LiveGenerationConfig$Internal$$serializer.INSTANCE, internal5);
                        i4 |= 2;
                        break;
                    case 2:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], list3);
                        i4 |= 4;
                        break;
                    case 3:
                        internal10 = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Content$Internal$$serializer.INSTANCE, internal10);
                        i4 |= 8;
                        break;
                    case 4:
                        internal11 = (AudioTranscriptionConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], internal11);
                        i4 |= 16;
                        break;
                    case 5:
                        internal9 = (AudioTranscriptionConfig.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], internal9);
                        i4 |= 32;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 0;
            }
            internal = internal9;
            internal2 = internal5;
            str = strDecodeStringElement2;
            internal3 = internal10;
            i = i4;
            internal4 = internal11;
            list = list3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LiveClientSetupMessage.Internal.LiveClientSetup(i, str, internal2, list, internal3, internal4, internal, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LiveClientSetupMessage.Internal.LiveClientSetup value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        LiveClientSetupMessage.Internal.LiveClientSetup.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

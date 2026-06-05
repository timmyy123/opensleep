package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.LiveServerContent;
import com.google.firebase.ai.type.Transcription;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/LiveServerContent.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/LiveServerContent$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class LiveServerContent$Internal$$serializer implements GeneratedSerializer<LiveServerContent.Internal> {
    public static final LiveServerContent$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LiveServerContent$Internal$$serializer liveServerContent$Internal$$serializer = new LiveServerContent$Internal$$serializer();
        INSTANCE = liveServerContent$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.LiveServerContent.Internal", liveServerContent$Internal$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("modelTurn", false);
        pluginGeneratedSerialDescriptor.addElement("interrupted", false);
        pluginGeneratedSerialDescriptor.addElement("turnComplete", false);
        pluginGeneratedSerialDescriptor.addElement("generationComplete", false);
        pluginGeneratedSerialDescriptor.addElement("inputTranscription", false);
        pluginGeneratedSerialDescriptor.addElement("outputTranscription", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LiveServerContent$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(Content$Internal$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(booleanSerializer);
        Transcription$Internal$$serializer transcription$Internal$$serializer = Transcription$Internal$$serializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, BuiltinSerializersKt.getNullable(transcription$Internal$$serializer), BuiltinSerializersKt.getNullable(transcription$Internal$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LiveServerContent.Internal deserialize(Decoder decoder) {
        Content.Internal internal;
        Transcription.Internal internal2;
        Boolean bool;
        Transcription.Internal internal3;
        Boolean bool2;
        Boolean bool3;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        LiveServerContent.Internal internal4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            internal = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Content$Internal$$serializer.INSTANCE, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, booleanSerializer, null);
            Boolean bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, booleanSerializer, null);
            Boolean bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, booleanSerializer, null);
            Transcription$Internal$$serializer transcription$Internal$$serializer = Transcription$Internal$$serializer.INSTANCE;
            Transcription.Internal internal5 = (Transcription.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, transcription$Internal$$serializer, null);
            internal2 = (Transcription.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, transcription$Internal$$serializer, null);
            bool = bool6;
            internal3 = internal5;
            bool2 = bool5;
            bool3 = bool4;
            i = 63;
        } else {
            boolean z = true;
            int i2 = 0;
            internal = null;
            Transcription.Internal internal6 = null;
            Boolean bool7 = null;
            Transcription.Internal internal7 = null;
            Boolean bool8 = null;
            Boolean bool9 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        internal = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Content$Internal$$serializer.INSTANCE, internal);
                        i2 |= 1;
                        break;
                    case 1:
                        bool9 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool9);
                        i2 |= 2;
                        break;
                    case 2:
                        bool8 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool8);
                        i2 |= 4;
                        break;
                    case 3:
                        bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool7);
                        i2 |= 8;
                        break;
                    case 4:
                        internal7 = (Transcription.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Transcription$Internal$$serializer.INSTANCE, internal7);
                        i2 |= 16;
                        break;
                    case 5:
                        internal6 = (Transcription.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Transcription$Internal$$serializer.INSTANCE, internal6);
                        i2 |= 32;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return internal4;
                }
                internal4 = null;
            }
            internal2 = internal6;
            bool = bool7;
            internal3 = internal7;
            bool2 = bool8;
            bool3 = bool9;
            i = i2;
        }
        Content.Internal internal8 = internal;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LiveServerContent.Internal(i, internal8, bool3, bool2, bool, internal3, internal2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LiveServerContent.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        LiveServerContent.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

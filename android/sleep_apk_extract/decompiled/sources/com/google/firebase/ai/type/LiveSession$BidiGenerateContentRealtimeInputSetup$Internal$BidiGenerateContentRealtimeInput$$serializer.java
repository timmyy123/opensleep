package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.ai.type.InlineData;
import com.google.firebase.ai.type.LiveSession;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer implements GeneratedSerializer<LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput> {
    public static final LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer liveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer = new LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer();
        INSTANCE = liveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput", liveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("mediaChunks", false);
        pluginGeneratedSerialDescriptor.addElement("audio", false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, false);
        pluginGeneratedSerialDescriptor.addElement("text", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput.$childSerializers[0]);
        InlineData$Internal$$serializer inlineData$Internal$$serializer = InlineData$Internal$$serializer.INSTANCE;
        return new KSerializer[]{nullable, BuiltinSerializersKt.getNullable(inlineData$Internal$$serializer), BuiltinSerializersKt.getNullable(inlineData$Internal$$serializer), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput deserialize(Decoder decoder) {
        List list;
        InlineData.Internal internal;
        String str;
        int i;
        InlineData.Internal internal2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            InlineData$Internal$$serializer inlineData$Internal$$serializer = InlineData$Internal$$serializer.INSTANCE;
            InlineData.Internal internal3 = (InlineData.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, inlineData$Internal$$serializer, null);
            list = list2;
            internal = (InlineData.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, inlineData$Internal$$serializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            i = 15;
            internal2 = internal3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            InlineData.Internal internal4 = null;
            String str2 = null;
            InlineData.Internal internal5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    internal5 = (InlineData.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, InlineData$Internal$$serializer.INSTANCE, internal5);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    internal4 = (InlineData.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, InlineData$Internal$$serializer.INSTANCE, internal4);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str2);
                    i2 |= 8;
                }
            }
            list = list3;
            internal = internal4;
            str = str2;
            i = i2;
            internal2 = internal5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput(i, list, internal2, internal, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.BidiGenerateContentRealtimeInput.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

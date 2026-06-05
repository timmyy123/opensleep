package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.Candidate;
import com.google.firebase.ai.type.CitationMetadata;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.FinishReason;
import com.google.firebase.ai.type.GroundingMetadata;
import com.google.firebase.ai.type.UrlContextMetadata;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/Candidate.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/Candidate$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class Candidate$Internal$$serializer implements GeneratedSerializer<Candidate.Internal> {
    public static final Candidate$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Candidate$Internal$$serializer candidate$Internal$$serializer = new Candidate$Internal$$serializer();
        INSTANCE = candidate$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.Candidate.Internal", candidate$Internal$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("content", true);
        pluginGeneratedSerialDescriptor.addElement("finishReason", true);
        pluginGeneratedSerialDescriptor.addElement("safetyRatings", true);
        pluginGeneratedSerialDescriptor.addElement("citationMetadata", true);
        pluginGeneratedSerialDescriptor.addElement("groundingMetadata", true);
        pluginGeneratedSerialDescriptor.addElement("urlContextMetadata", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Candidate$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(Content$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FinishReason.Internal.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(Candidate.Internal.$childSerializers[2]), BuiltinSerializersKt.getNullable(CitationMetadata$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(GroundingMetadata$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(UrlContextMetadata$Internal$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Candidate.Internal deserialize(Decoder decoder) {
        List list;
        FinishReason.Internal internal;
        Content.Internal internal2;
        UrlContextMetadata.Internal internal3;
        CitationMetadata.Internal internal4;
        GroundingMetadata.Internal internal5;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Candidate.Internal.$childSerializers;
        int i2 = 5;
        boolean z = false;
        FinishReason.Internal internal6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Content.Internal internal7 = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Content$Internal$$serializer.INSTANCE, null);
            FinishReason.Internal internal8 = (FinishReason.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FinishReason.Internal.Serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            CitationMetadata.Internal internal9 = (CitationMetadata.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, CitationMetadata$Internal$$serializer.INSTANCE, null);
            GroundingMetadata.Internal internal10 = (GroundingMetadata.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GroundingMetadata$Internal$$serializer.INSTANCE, null);
            list = list2;
            internal2 = internal7;
            internal3 = (UrlContextMetadata.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, UrlContextMetadata$Internal$$serializer.INSTANCE, null);
            internal4 = internal9;
            internal5 = internal10;
            i = 63;
            internal = internal8;
        } else {
            boolean z2 = true;
            int i3 = 0;
            List list3 = null;
            Content.Internal internal11 = null;
            UrlContextMetadata.Internal internal12 = null;
            CitationMetadata.Internal internal13 = null;
            GroundingMetadata.Internal internal14 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = z;
                        i2 = 5;
                        break;
                    case 0:
                        internal11 = (Content.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Content$Internal$$serializer.INSTANCE, internal11);
                        i3 |= 1;
                        z = false;
                        i2 = 5;
                        break;
                    case 1:
                        internal6 = (FinishReason.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FinishReason.Internal.Serializer.INSTANCE, internal6);
                        i3 |= 2;
                        z = false;
                        break;
                    case 2:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], list3);
                        i3 |= 4;
                        z = false;
                        break;
                    case 3:
                        internal13 = (CitationMetadata.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, CitationMetadata$Internal$$serializer.INSTANCE, internal13);
                        i3 |= 8;
                        z = false;
                        break;
                    case 4:
                        internal14 = (GroundingMetadata.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GroundingMetadata$Internal$$serializer.INSTANCE, internal14);
                        i3 |= 16;
                        z = false;
                        break;
                    case 5:
                        internal12 = (UrlContextMetadata.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, UrlContextMetadata$Internal$$serializer.INSTANCE, internal12);
                        i3 |= 32;
                        z = false;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list3;
            internal = internal6;
            internal2 = internal11;
            internal3 = internal12;
            internal4 = internal13;
            internal5 = internal14;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Candidate.Internal(i, internal2, internal, list, internal4, internal5, internal3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Candidate.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Candidate.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

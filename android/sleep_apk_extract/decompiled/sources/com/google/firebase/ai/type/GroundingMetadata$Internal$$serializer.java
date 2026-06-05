package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.GroundingMetadata;
import com.google.firebase.ai.type.SearchEntryPoint;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/GroundingMetadata.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/GroundingMetadata$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class GroundingMetadata$Internal$$serializer implements GeneratedSerializer<GroundingMetadata.Internal> {
    public static final GroundingMetadata$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GroundingMetadata$Internal$$serializer groundingMetadata$Internal$$serializer = new GroundingMetadata$Internal$$serializer();
        INSTANCE = groundingMetadata$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.GroundingMetadata.Internal", groundingMetadata$Internal$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("webSearchQueries", false);
        pluginGeneratedSerialDescriptor.addElement("searchEntryPoint", false);
        pluginGeneratedSerialDescriptor.addElement("retrievalQueries", false);
        pluginGeneratedSerialDescriptor.addElement("groundingAttribution", false);
        pluginGeneratedSerialDescriptor.addElement("groundingChunks", false);
        pluginGeneratedSerialDescriptor.addElement("groundingSupports", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GroundingMetadata$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = GroundingMetadata.Internal.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(kSerializerArr[0]), BuiltinSerializersKt.getNullable(SearchEntryPoint$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final GroundingMetadata.Internal deserialize(Decoder decoder) {
        List list;
        SearchEntryPoint.Internal internal;
        List list2;
        int i;
        List list3;
        List list4;
        List list5;
        int i2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = GroundingMetadata.Internal.$childSerializers;
        int i3 = 5;
        int i4 = 0;
        SearchEntryPoint.Internal internal2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            SearchEntryPoint.Internal internal3 = (SearchEntryPoint.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SearchEntryPoint$Internal$$serializer.INSTANCE, null);
            List list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            List list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            List list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            list2 = list6;
            i = 63;
            list3 = list8;
            list4 = list9;
            list5 = list7;
            internal = internal3;
        } else {
            int i5 = 1;
            int i6 = 0;
            List list10 = null;
            List list11 = null;
            List list12 = null;
            List list13 = null;
            List list14 = null;
            while (i5 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        i5 = i4;
                        i3 = 5;
                        break;
                    case 0:
                        int i7 = i4;
                        list11 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i7, kSerializerArr[i7], list11);
                        i6 |= 1;
                        i4 = i7;
                        i3 = 5;
                        break;
                    case 1:
                        i2 = i4;
                        internal2 = (SearchEntryPoint.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SearchEntryPoint$Internal$$serializer.INSTANCE, internal2);
                        i6 |= 2;
                        i4 = i2;
                        break;
                    case 2:
                        i2 = i4;
                        list14 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], list14);
                        i6 |= 4;
                        i4 = i2;
                        break;
                    case 3:
                        i2 = i4;
                        list12 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], list12);
                        i6 |= 8;
                        i4 = i2;
                        break;
                    case 4:
                        i2 = i4;
                        list13 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], list13);
                        i6 |= 16;
                        i4 = i2;
                        break;
                    case 5:
                        i2 = i4;
                        list10 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, kSerializerArr[i3], list10);
                        i6 |= 32;
                        i4 = i2;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list10;
            internal = internal2;
            list2 = list11;
            i = i6;
            list3 = list12;
            list4 = list13;
            list5 = list14;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GroundingMetadata.Internal(i, list2, internal, list5, list3, list4, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GroundingMetadata.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        GroundingMetadata.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

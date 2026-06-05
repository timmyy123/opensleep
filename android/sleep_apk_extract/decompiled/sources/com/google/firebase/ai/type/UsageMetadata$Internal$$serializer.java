package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.UsageMetadata;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/UsageMetadata.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/UsageMetadata$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class UsageMetadata$Internal$$serializer implements GeneratedSerializer<UsageMetadata.Internal> {
    public static final UsageMetadata$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UsageMetadata$Internal$$serializer usageMetadata$Internal$$serializer = new UsageMetadata$Internal$$serializer();
        INSTANCE = usageMetadata$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.UsageMetadata.Internal", usageMetadata$Internal$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("promptTokenCount", true);
        pluginGeneratedSerialDescriptor.addElement("candidatesTokenCount", true);
        pluginGeneratedSerialDescriptor.addElement("totalTokenCount", true);
        pluginGeneratedSerialDescriptor.addElement("cachedContentTokenCount", true);
        pluginGeneratedSerialDescriptor.addElement("promptTokensDetails", true);
        pluginGeneratedSerialDescriptor.addElement("candidatesTokensDetails", true);
        pluginGeneratedSerialDescriptor.addElement("cacheTokensDetails", true);
        pluginGeneratedSerialDescriptor.addElement("thoughtsTokenCount", true);
        pluginGeneratedSerialDescriptor.addElement("toolUsePromptTokenCount", true);
        pluginGeneratedSerialDescriptor.addElement("toolUsePromptTokensDetails", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UsageMetadata$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = UsageMetadata.Internal.$childSerializers;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[9])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final UsageMetadata.Internal deserialize(Decoder decoder) {
        List list;
        List list2;
        List list3;
        Integer num;
        List list4;
        Integer num2;
        Integer num3;
        int i;
        Integer num4;
        Integer num5;
        Integer num6;
        int i2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = UsageMetadata.Internal.$childSerializers;
        int i3 = 7;
        int i4 = 8;
        int i5 = 9;
        int i6 = 6;
        int i7 = 5;
        int i8 = 4;
        Integer num7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, intSerializer, null);
            Integer num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, intSerializer, null);
            Integer num10 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, intSerializer, null);
            Integer num11 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, intSerializer, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            List list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            Integer num12 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, intSerializer, null);
            Integer num13 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, intSerializer, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, kSerializerArr[9], null);
            num6 = num13;
            num5 = num12;
            num4 = num11;
            i = 1023;
            num = num10;
            list4 = list7;
            list3 = list6;
            list2 = list5;
            num2 = num9;
            num3 = num8;
        } else {
            boolean z = true;
            int i9 = 0;
            List list8 = null;
            List list9 = null;
            List list10 = null;
            Integer num14 = null;
            Integer num15 = null;
            Integer num16 = null;
            List list11 = null;
            Integer num17 = null;
            Integer num18 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 7;
                        i4 = 8;
                        i5 = 9;
                        i6 = 6;
                        i7 = 5;
                        break;
                    case 0:
                        num18 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num18);
                        i9 |= 1;
                        i3 = 7;
                        i4 = 8;
                        i5 = 9;
                        i6 = 6;
                        i7 = 5;
                        i8 = 4;
                        break;
                    case 1:
                        num17 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num17);
                        i9 |= 2;
                        i3 = 7;
                        i4 = 8;
                        i5 = 9;
                        i6 = 6;
                        i8 = 4;
                        break;
                    case 2:
                        i9 |= 4;
                        num16 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num16);
                        i3 = 7;
                        i4 = 8;
                        i5 = 9;
                        i8 = 4;
                        break;
                    case 3:
                        num14 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num14);
                        i9 |= 8;
                        i3 = 7;
                        i4 = 8;
                        i8 = 4;
                        break;
                    case 4:
                        int i10 = i8;
                        i9 |= 16;
                        list11 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i10, kSerializerArr[i10], list11);
                        i8 = i10;
                        i3 = 7;
                        i4 = 8;
                        break;
                    case 5:
                        i2 = i8;
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i7, kSerializerArr[i7], list9);
                        i9 |= 32;
                        i8 = i2;
                        break;
                    case 6:
                        i2 = i8;
                        list10 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, kSerializerArr[i6], list10);
                        i9 |= 64;
                        i8 = i2;
                        break;
                    case 7:
                        i2 = i8;
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, IntSerializer.INSTANCE, num7);
                        i9 |= 128;
                        i8 = i2;
                        break;
                    case 8:
                        i2 = i8;
                        num15 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, IntSerializer.INSTANCE, num15);
                        i9 |= 256;
                        i8 = i2;
                        break;
                    case 9:
                        i2 = i8;
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, kSerializerArr[i5], list8);
                        i9 |= 512;
                        i8 = i2;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list8;
            list2 = list11;
            list3 = list9;
            num = num16;
            list4 = list10;
            num2 = num17;
            num3 = num18;
            i = i9;
            num4 = num14;
            num5 = num7;
            num6 = num15;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new UsageMetadata.Internal(i, num3, num2, num, num4, list2, list3, list4, num5, num6, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, UsageMetadata.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        UsageMetadata.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

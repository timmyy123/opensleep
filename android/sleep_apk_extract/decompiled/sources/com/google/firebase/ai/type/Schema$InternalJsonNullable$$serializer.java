package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.Schema;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/Schema.InternalJsonNullable.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalJsonNullable;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class Schema$InternalJsonNullable$$serializer implements GeneratedSerializer<Schema.InternalJsonNullable> {
    public static final Schema$InternalJsonNullable$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Schema$InternalJsonNullable$$serializer schema$InternalJsonNullable$$serializer = new Schema$InternalJsonNullable$$serializer();
        INSTANCE = schema$InternalJsonNullable$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.Schema.InternalJsonNullable", schema$InternalJsonNullable$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("format", true);
        pluginGeneratedSerialDescriptor.addElement("enum", true);
        pluginGeneratedSerialDescriptor.addElement("properties", true);
        pluginGeneratedSerialDescriptor.addElement("required", true);
        pluginGeneratedSerialDescriptor.addElement("items", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("minItems", true);
        pluginGeneratedSerialDescriptor.addElement("maxItems", true);
        pluginGeneratedSerialDescriptor.addElement("minimum", true);
        pluginGeneratedSerialDescriptor.addElement("maximum", true);
        pluginGeneratedSerialDescriptor.addElement("anyOf", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Schema$InternalJsonNullable$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = Schema.InternalJsonNullable.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(kSerializerArr[0]);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(kSerializerArr[3]);
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(kSerializerArr[4]);
        KSerializer<?> nullable6 = BuiltinSerializersKt.getNullable(kSerializerArr[5]);
        KSerializer<?> nullable7 = BuiltinSerializersKt.getNullable(kSerializerArr[6]);
        KSerializer<?> nullable8 = BuiltinSerializersKt.getNullable(stringSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        KSerializer<?> nullable9 = BuiltinSerializersKt.getNullable(intSerializer);
        KSerializer<?> nullable10 = BuiltinSerializersKt.getNullable(intSerializer);
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, nullable5, nullable6, nullable7, nullable8, nullable9, nullable10, BuiltinSerializersKt.getNullable(doubleSerializer), BuiltinSerializersKt.getNullable(doubleSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[12])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Schema.InternalJsonNullable deserialize(Decoder decoder) {
        String str;
        List list;
        List list2;
        Map map;
        String str2;
        List list3;
        Double d;
        Schema.InternalJson internalJson;
        Integer num;
        int i;
        String str3;
        Double d2;
        Integer num2;
        Integer num3;
        Double d3;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Schema.InternalJsonNullable.$childSerializers;
        int i2 = 9;
        char c = 7;
        int i3 = 8;
        List list4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            Map map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            Schema.InternalJson internalJson2 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, intSerializer, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, intSerializer, null);
            DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
            Double d4 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, doubleSerializer, null);
            Double d5 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, doubleSerializer, null);
            list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, kSerializerArr[12], null);
            str = str4;
            d2 = d5;
            list = list5;
            list3 = list6;
            num2 = num5;
            str2 = str6;
            num = num4;
            str3 = str5;
            i = 8191;
            internalJson = internalJson2;
            list2 = list7;
            map = map2;
            d = d4;
        } else {
            int i4 = 12;
            boolean z = true;
            Integer num6 = null;
            Double d6 = null;
            List list8 = null;
            String str7 = null;
            String str8 = null;
            List list9 = null;
            Map map3 = null;
            String str9 = null;
            int i5 = 6;
            int i6 = 5;
            int i7 = 3;
            int i8 = 4;
            List list10 = null;
            Double d7 = null;
            Schema.InternalJson internalJson3 = null;
            Integer num7 = null;
            int i9 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        d6 = d6;
                        num6 = num6;
                        i2 = 9;
                        i3 = 8;
                        i4 = 12;
                        i7 = 3;
                        i8 = 4;
                        i6 = 5;
                        i5 = 6;
                        break;
                    case 0:
                        num3 = num6;
                        d3 = d6;
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], list8);
                        i9 |= 1;
                        d6 = d3;
                        num6 = num3;
                        i2 = 9;
                        c = 7;
                        i3 = 8;
                        i4 = 12;
                        i7 = 3;
                        i8 = 4;
                        i6 = 5;
                        i5 = 6;
                        break;
                    case 1:
                        num3 = num6;
                        d3 = d6;
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i9 |= 2;
                        d6 = d3;
                        num6 = num3;
                        i2 = 9;
                        c = 7;
                        i3 = 8;
                        i4 = 12;
                        i7 = 3;
                        i8 = 4;
                        i6 = 5;
                        i5 = 6;
                        break;
                    case 2:
                        num3 = num6;
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i9 |= 4;
                        num6 = num3;
                        i2 = 9;
                        c = 7;
                        i3 = 8;
                        i4 = 12;
                        i7 = 3;
                        i8 = 4;
                        i6 = 5;
                        i5 = 6;
                        break;
                    case 3:
                        list10 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i7, kSerializerArr[i7], list10);
                        i9 |= 8;
                        i2 = 9;
                        c = 7;
                        i3 = 8;
                        i4 = 12;
                        i8 = 4;
                        i6 = 5;
                        i5 = 6;
                        break;
                    case 4:
                        map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i8, kSerializerArr[i8], map3);
                        i9 |= 16;
                        i2 = 9;
                        c = 7;
                        i3 = 8;
                        i4 = 12;
                        i6 = 5;
                        i5 = 6;
                        break;
                    case 5:
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, kSerializerArr[i6], list9);
                        i9 |= 32;
                        i2 = 9;
                        c = 7;
                        i3 = 8;
                        i4 = 12;
                        i5 = 6;
                        break;
                    case 6:
                        internalJson3 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, kSerializerArr[i5], internalJson3);
                        i9 |= 64;
                        i2 = 9;
                        c = 7;
                        i4 = 12;
                        break;
                    case 7:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str7);
                        i9 |= 128;
                        c = 7;
                        i2 = 9;
                        i4 = 12;
                        break;
                    case 8:
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, IntSerializer.INSTANCE, num7);
                        i9 |= 256;
                        c = 7;
                        i4 = 12;
                        break;
                    case 9:
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, IntSerializer.INSTANCE, num6);
                        i9 |= 512;
                        c = 7;
                        i4 = 12;
                        break;
                    case 10:
                        d7 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DoubleSerializer.INSTANCE, d7);
                        i9 |= 1024;
                        c = 7;
                        i4 = 12;
                        break;
                    case 11:
                        d6 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, DoubleSerializer.INSTANCE, d6);
                        i9 |= 2048;
                        c = 7;
                        i4 = 12;
                        break;
                    case 12:
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, kSerializerArr[i4], list4);
                        i9 |= 4096;
                        c = 7;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str9;
            list = list8;
            list2 = list9;
            map = map3;
            str2 = str7;
            list3 = list10;
            d = d7;
            internalJson = internalJson3;
            num = num7;
            i = i9;
            str3 = str8;
            d2 = d6;
            num2 = num6;
        }
        List list11 = list4;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Schema.InternalJsonNullable(i, list, str, str3, list3, map, list2, internalJson, str2, num, num2, d, d2, list11, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Schema.InternalJsonNullable value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Schema.InternalJsonNullable.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

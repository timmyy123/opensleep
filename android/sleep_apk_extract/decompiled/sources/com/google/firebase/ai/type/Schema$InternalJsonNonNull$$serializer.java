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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/Schema.InternalJsonNonNull.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalJsonNonNull;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class Schema$InternalJsonNonNull$$serializer implements GeneratedSerializer<Schema.InternalJsonNonNull> {
    public static final Schema$InternalJsonNonNull$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Schema$InternalJsonNonNull$$serializer schema$InternalJsonNonNull$$serializer = new Schema$InternalJsonNonNull$$serializer();
        INSTANCE = schema$InternalJsonNonNull$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.Schema.InternalJsonNonNull", schema$InternalJsonNonNull$$serializer, 13);
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

    private Schema$InternalJsonNonNull$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = Schema.InternalJsonNonNull.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
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
    public final Schema.InternalJsonNonNull deserialize(Decoder decoder) {
        String str;
        String str2;
        List list;
        Map map;
        String str3;
        int i;
        String str4;
        Double d;
        Integer num;
        Schema.InternalJson internalJson;
        Integer num2;
        Double d2;
        List list2;
        List list3;
        int i2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Schema.InternalJsonNonNull.$childSerializers;
        int i3 = 9;
        int i4 = 7;
        int i5 = 8;
        int i6 = 6;
        List list4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            Map map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            Schema.InternalJson internalJson2 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, intSerializer, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, intSerializer, null);
            DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
            Double d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, doubleSerializer, null);
            Double d4 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, doubleSerializer, null);
            list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, kSerializerArr[12], null);
            str = str5;
            d2 = d4;
            str2 = str8;
            list2 = list5;
            num2 = num4;
            i = 8191;
            num = num3;
            str3 = str7;
            internalJson = internalJson2;
            list = list6;
            map = map2;
            d = d3;
            str4 = str6;
        } else {
            int i7 = 12;
            int i8 = 0;
            List list7 = null;
            Double d5 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            List list8 = null;
            Map map3 = null;
            String str12 = null;
            int i9 = 5;
            int i10 = 3;
            int i11 = 4;
            boolean z = true;
            Double d6 = null;
            Integer num5 = null;
            Schema.InternalJson internalJson3 = null;
            Integer num6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        d5 = d5;
                        list7 = list7;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        i10 = 3;
                        i11 = 4;
                        i9 = 5;
                        break;
                    case 0:
                        list3 = list7;
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str11);
                        i8 |= 1;
                        d5 = d5;
                        list7 = list3;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        i6 = 6;
                        i10 = 3;
                        i11 = 4;
                        i9 = 5;
                        break;
                    case 1:
                        list3 = list7;
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str12);
                        i8 |= 2;
                        list7 = list3;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        i6 = 6;
                        i10 = 3;
                        i11 = 4;
                        i9 = 5;
                        break;
                    case 2:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str10);
                        i8 |= 4;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        i6 = 6;
                        i10 = 3;
                        i11 = 4;
                        i9 = 5;
                        break;
                    case 3:
                        list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i10, kSerializerArr[i10], list7);
                        i8 |= 8;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        i6 = 6;
                        i11 = 4;
                        i9 = 5;
                        break;
                    case 4:
                        map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i11, kSerializerArr[i11], map3);
                        i8 |= 16;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        i6 = 6;
                        i9 = 5;
                        break;
                    case 5:
                        i8 |= 32;
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i9, kSerializerArr[i9], list8);
                        i3 = 9;
                        i4 = 7;
                        i7 = 12;
                        i6 = 6;
                        break;
                    case 6:
                        int i12 = i6;
                        internalJson3 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i12, kSerializerArr[i12], internalJson3);
                        i8 |= 64;
                        i6 = i12;
                        i3 = 9;
                        i7 = 12;
                        break;
                    case 7:
                        i2 = i6;
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str9);
                        i8 |= 128;
                        i6 = i2;
                        i7 = 12;
                        break;
                    case 8:
                        i2 = i6;
                        num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, IntSerializer.INSTANCE, num5);
                        i8 |= 256;
                        i6 = i2;
                        i7 = 12;
                        break;
                    case 9:
                        i2 = i6;
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, IntSerializer.INSTANCE, num6);
                        i8 |= 512;
                        i6 = i2;
                        i7 = 12;
                        break;
                    case 10:
                        i2 = i6;
                        d6 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DoubleSerializer.INSTANCE, d6);
                        i8 |= 1024;
                        i6 = i2;
                        i7 = 12;
                        break;
                    case 11:
                        i2 = i6;
                        d5 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, DoubleSerializer.INSTANCE, d5);
                        i8 |= 2048;
                        i6 = i2;
                        i7 = 12;
                        break;
                    case 12:
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i7, kSerializerArr[i7], list4);
                        i8 |= 4096;
                        i6 = i6;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str11;
            str2 = str9;
            list = list8;
            map = map3;
            str3 = str10;
            i = i8;
            str4 = str12;
            d = d6;
            num = num5;
            internalJson = internalJson3;
            num2 = num6;
            d2 = d5;
            list2 = list7;
        }
        List list9 = list4;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Schema.InternalJsonNonNull(i, str, str4, str3, list2, map, list, internalJson, str2, num, num2, d, d2, list9, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Schema.InternalJsonNonNull value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Schema.InternalJsonNonNull.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/Schema.InternalOpenAPI.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class Schema$InternalOpenAPI$$serializer implements GeneratedSerializer<Schema.InternalOpenAPI> {
    public static final Schema$InternalOpenAPI$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Schema$InternalOpenAPI$$serializer schema$InternalOpenAPI$$serializer = new Schema$InternalOpenAPI$$serializer();
        INSTANCE = schema$InternalOpenAPI$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.Schema.InternalOpenAPI", schema$InternalOpenAPI$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("format", true);
        pluginGeneratedSerialDescriptor.addElement("nullable", true);
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

    private Schema$InternalOpenAPI$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = Schema.InternalOpenAPI.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE);
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(kSerializerArr[4]);
        Schema$InternalOpenAPI$$serializer schema$InternalOpenAPI$$serializer = INSTANCE;
        KSerializer<?> nullable6 = BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(stringSerializer, schema$InternalOpenAPI$$serializer));
        KSerializer<?> nullable7 = BuiltinSerializersKt.getNullable(kSerializerArr[6]);
        KSerializer<?> nullable8 = BuiltinSerializersKt.getNullable(schema$InternalOpenAPI$$serializer);
        KSerializer<?> nullable9 = BuiltinSerializersKt.getNullable(stringSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        KSerializer<?> nullable10 = BuiltinSerializersKt.getNullable(intSerializer);
        KSerializer<?> nullable11 = BuiltinSerializersKt.getNullable(intSerializer);
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, nullable5, nullable6, nullable7, nullable8, nullable9, nullable10, nullable11, BuiltinSerializersKt.getNullable(doubleSerializer), BuiltinSerializersKt.getNullable(doubleSerializer), BuiltinSerializersKt.getNullable(new ArrayListSerializer(schema$InternalOpenAPI$$serializer))};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Schema.InternalOpenAPI deserialize(Decoder decoder) {
        Integer num;
        String str;
        List list;
        String str2;
        String str3;
        Double d;
        Double d2;
        Integer num2;
        int i;
        List list2;
        Boolean bool;
        Schema.InternalOpenAPI internalOpenAPI;
        String str4;
        List list3;
        Map map;
        KSerializer[] kSerializerArr;
        List list4;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr2 = Schema.InternalOpenAPI.$childSerializers;
        char c = 7;
        String str5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr2[4], null);
            Schema$InternalOpenAPI$$serializer schema$InternalOpenAPI$$serializer = INSTANCE;
            Map map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, new LinkedHashMapSerializer(stringSerializer, schema$InternalOpenAPI$$serializer), null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr2[6], null);
            Schema.InternalOpenAPI internalOpenAPI2 = (Schema.InternalOpenAPI) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, schema$InternalOpenAPI$$serializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, intSerializer, null);
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, intSerializer, null);
            DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
            Double d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, doubleSerializer, null);
            d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, doubleSerializer, null);
            str3 = str9;
            str2 = str7;
            str = str6;
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, new ArrayListSerializer(schema$InternalOpenAPI$$serializer), null);
            bool = bool2;
            i = 16383;
            internalOpenAPI = internalOpenAPI2;
            map = map2;
            list2 = list5;
            num2 = num3;
            str4 = str8;
            d = d3;
            list3 = list6;
        } else {
            boolean z = true;
            int i2 = 0;
            List list7 = null;
            List list8 = null;
            String str10 = null;
            Double d4 = null;
            Double d5 = null;
            Integer num4 = null;
            Boolean bool3 = null;
            String str11 = null;
            Map map3 = null;
            List list9 = null;
            String str12 = null;
            int i3 = 6;
            int i4 = 4;
            num = null;
            Schema.InternalOpenAPI internalOpenAPI3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        list7 = list7;
                        kSerializerArr2 = kSerializerArr2;
                        i4 = 4;
                        i3 = 6;
                        break;
                    case 0:
                        kSerializerArr = kSerializerArr2;
                        list4 = list7;
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str11);
                        i2 |= 1;
                        str12 = str12;
                        list7 = list4;
                        kSerializerArr2 = kSerializerArr;
                        c = 7;
                        i4 = 4;
                        i3 = 6;
                        break;
                    case 1:
                        kSerializerArr = kSerializerArr2;
                        list4 = list7;
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str10);
                        i2 |= 2;
                        list7 = list4;
                        kSerializerArr2 = kSerializerArr;
                        c = 7;
                        i4 = 4;
                        i3 = 6;
                        break;
                    case 2:
                        kSerializerArr = kSerializerArr2;
                        list4 = list7;
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str12);
                        i2 |= 4;
                        list7 = list4;
                        kSerializerArr2 = kSerializerArr;
                        c = 7;
                        i4 = 4;
                        i3 = 6;
                        break;
                    case 3:
                        kSerializerArr = kSerializerArr2;
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 8;
                        kSerializerArr2 = kSerializerArr;
                        c = 7;
                        i4 = 4;
                        i3 = 6;
                        break;
                    case 4:
                        KSerializer[] kSerializerArr3 = kSerializerArr2;
                        int i5 = i4;
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, kSerializerArr3[i4], list9);
                        i2 |= 16;
                        map3 = map3;
                        c = 7;
                        i3 = 6;
                        i4 = i5;
                        kSerializerArr2 = kSerializerArr3;
                        break;
                    case 5:
                        map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, new LinkedHashMapSerializer(StringSerializer.INSTANCE, INSTANCE), map3);
                        i2 |= 32;
                        kSerializerArr2 = kSerializerArr2;
                        c = 7;
                        i3 = 6;
                        break;
                    case 6:
                        list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, kSerializerArr2[i3], list7);
                        i2 |= 64;
                        c = 7;
                        break;
                    case 7:
                        internalOpenAPI3 = (Schema.InternalOpenAPI) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, INSTANCE, internalOpenAPI3);
                        i2 |= 128;
                        c = 7;
                        break;
                    case 8:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str5);
                        i2 |= 256;
                        c = 7;
                        break;
                    case 9:
                        num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, num);
                        i2 |= 512;
                        c = 7;
                        break;
                    case 10:
                        num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num4);
                        i2 |= 1024;
                        c = 7;
                        break;
                    case 11:
                        d4 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, DoubleSerializer.INSTANCE, d4);
                        i2 |= 2048;
                        c = 7;
                        break;
                    case 12:
                        d5 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DoubleSerializer.INSTANCE, d5);
                        i2 |= 4096;
                        c = 7;
                        break;
                    case 13:
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, new ArrayListSerializer(INSTANCE), list8);
                        i2 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        c = 7;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str11;
            list = list8;
            str2 = str10;
            str3 = str5;
            d = d4;
            d2 = d5;
            num2 = num4;
            i = i2;
            list2 = list9;
            bool = bool3;
            internalOpenAPI = internalOpenAPI3;
            str4 = str12;
            list3 = list7;
            map = map3;
        }
        Integer num5 = num;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Schema.InternalOpenAPI(i, str, str2, str4, bool, list2, map, list3, internalOpenAPI, str3, num5, num2, d, d2, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Schema.InternalOpenAPI value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Schema.InternalOpenAPI.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

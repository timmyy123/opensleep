package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.GoogleSearch;
import com.google.firebase.ai.type.Tool;
import com.google.firebase.ai.type.UrlContext;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/Tool.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/Tool$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class Tool$Internal$$serializer implements GeneratedSerializer<Tool.Internal> {
    public static final Tool$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Tool$Internal$$serializer tool$Internal$$serializer = new Tool$Internal$$serializer();
        INSTANCE = tool$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.Tool.Internal", tool$Internal$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("functionDeclarations", true);
        pluginGeneratedSerialDescriptor.addElement("googleSearch", true);
        pluginGeneratedSerialDescriptor.addElement("codeExecution", true);
        pluginGeneratedSerialDescriptor.addElement("urlContext", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Tool$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(Tool.Internal.$childSerializers[0]), BuiltinSerializersKt.getNullable(GoogleSearch$Internal$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(UrlContext$Internal$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Tool.Internal deserialize(Decoder decoder) {
        List list;
        GoogleSearch.Internal internal;
        UrlContext.Internal internal2;
        JsonObject jsonObject;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Tool.Internal.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            GoogleSearch.Internal internal3 = (GoogleSearch.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, GoogleSearch$Internal$$serializer.INSTANCE, null);
            JsonObject jsonObject2 = (JsonObject) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, JsonObjectSerializer.INSTANCE, null);
            list = list2;
            internal = internal3;
            internal2 = (UrlContext.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, UrlContext$Internal$$serializer.INSTANCE, null);
            jsonObject = jsonObject2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            GoogleSearch.Internal internal4 = null;
            UrlContext.Internal internal5 = null;
            JsonObject jsonObject3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    internal4 = (GoogleSearch.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, GoogleSearch$Internal$$serializer.INSTANCE, internal4);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    jsonObject3 = (JsonObject) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, JsonObjectSerializer.INSTANCE, jsonObject3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    internal5 = (UrlContext.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, UrlContext$Internal$$serializer.INSTANCE, internal5);
                    i2 |= 8;
                }
            }
            list = list3;
            internal = internal4;
            internal2 = internal5;
            jsonObject = jsonObject3;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Tool.Internal(i, list, internal, jsonObject, internal2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Tool.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Tool.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

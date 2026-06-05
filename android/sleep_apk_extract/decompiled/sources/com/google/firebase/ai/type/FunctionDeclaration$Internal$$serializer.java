package com.google.firebase.ai.type;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.FunctionDeclaration;
import com.google.firebase.ai.type.Schema;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/FunctionDeclaration.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/FunctionDeclaration$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FunctionDeclaration$Internal$$serializer implements GeneratedSerializer<FunctionDeclaration.Internal> {
    public static final FunctionDeclaration$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        FunctionDeclaration$Internal$$serializer functionDeclaration$Internal$$serializer = new FunctionDeclaration$Internal$$serializer();
        INSTANCE = functionDeclaration$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.FunctionDeclaration.Internal", functionDeclaration$Internal$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, true);
        pluginGeneratedSerialDescriptor.addElement("parametersJsonSchema", true);
        pluginGeneratedSerialDescriptor.addElement("responseJsonSchema", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FunctionDeclaration$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = FunctionDeclaration.Internal.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(Schema$InternalOpenAPI$$serializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(kSerializerArr[3]);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(kSerializerArr[4]);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, nullable, nullable2, nullable3};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final FunctionDeclaration.Internal deserialize(Decoder decoder) {
        Schema.InternalJson internalJson;
        String str;
        Schema.InternalOpenAPI internalOpenAPI;
        Schema.InternalJson internalJson2;
        int i;
        String str2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = FunctionDeclaration.Internal.$childSerializers;
        FunctionDeclaration.Internal internal = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            Schema.InternalOpenAPI internalOpenAPI2 = (Schema.InternalOpenAPI) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Schema$InternalOpenAPI$$serializer.INSTANCE, null);
            Schema.InternalJson internalJson3 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            internalJson = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            str = strDecodeStringElement;
            internalOpenAPI = internalOpenAPI2;
            internalJson2 = internalJson3;
            i = 31;
            str2 = strDecodeStringElement2;
        } else {
            boolean z = true;
            int i2 = 0;
            Schema.InternalJson internalJson4 = null;
            String strDecodeStringElement3 = null;
            Schema.InternalOpenAPI internalOpenAPI3 = null;
            Schema.InternalJson internalJson5 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                FunctionDeclaration.Internal internal2 = internal;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    internal = internal2;
                    z = false;
                } else if (iDecodeElementIndex != 0) {
                    if (iDecodeElementIndex == 1) {
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        internalOpenAPI3 = (Schema.InternalOpenAPI) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Schema$InternalOpenAPI$$serializer.INSTANCE, internalOpenAPI3);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        internalJson5 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], internalJson5);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                            return internal2;
                        }
                        internalJson4 = (Schema.InternalJson) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], internalJson4);
                        i2 |= 16;
                    }
                    internal = internal2;
                } else {
                    strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                    internal = internal2;
                }
            }
            internalJson = internalJson4;
            str = strDecodeStringElement3;
            internalOpenAPI = internalOpenAPI3;
            internalJson2 = internalJson5;
            i = i2;
            str2 = strDecodeStringElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new FunctionDeclaration.Internal(i, str, str2, internalOpenAPI, internalJson2, internalJson, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, FunctionDeclaration.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        FunctionDeclaration.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

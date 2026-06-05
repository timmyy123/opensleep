package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.CodeExecutionResultPart;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/CodeExecutionResultPart.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/CodeExecutionResultPart$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class CodeExecutionResultPart$Internal$$serializer implements GeneratedSerializer<CodeExecutionResultPart.Internal> {
    public static final CodeExecutionResultPart$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CodeExecutionResultPart$Internal$$serializer codeExecutionResultPart$Internal$$serializer = new CodeExecutionResultPart$Internal$$serializer();
        INSTANCE = codeExecutionResultPart$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.CodeExecutionResultPart.Internal", codeExecutionResultPart$Internal$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("codeExecutionResult", false);
        pluginGeneratedSerialDescriptor.addElement("thought", true);
        pluginGeneratedSerialDescriptor.addElement("thoughtSignature", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CodeExecutionResultPart$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{CodeExecutionResultPart$Internal$CodeExecutionResult$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CodeExecutionResultPart.Internal deserialize(Decoder decoder) {
        CodeExecutionResultPart.Internal.CodeExecutionResult codeExecutionResult;
        String str;
        Boolean bool;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            codeExecutionResult = (CodeExecutionResultPart.Internal.CodeExecutionResult) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, CodeExecutionResultPart$Internal$CodeExecutionResult$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            bool = bool2;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            codeExecutionResult = null;
            String str2 = null;
            Boolean bool3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    codeExecutionResult = (CodeExecutionResultPart.Internal.CodeExecutionResult) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, CodeExecutionResultPart$Internal$CodeExecutionResult$$serializer.INSTANCE, codeExecutionResult);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str2);
                    i2 |= 4;
                }
            }
            str = str2;
            bool = bool3;
            i = i2;
        }
        CodeExecutionResultPart.Internal.CodeExecutionResult codeExecutionResult2 = codeExecutionResult;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CodeExecutionResultPart.Internal(i, codeExecutionResult2, bool, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CodeExecutionResultPart.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        CodeExecutionResultPart.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

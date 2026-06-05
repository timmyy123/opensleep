package com.google.firebase.ai.type;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.type.HarmCategory;
import com.google.firebase.ai.type.HarmProbability;
import com.google.firebase.ai.type.HarmSeverity;
import com.google.firebase.ai.type.SafetyRating;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/google/firebase/ai/type/SafetyRating.Internal.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/google/firebase/ai/type/SafetyRating$Internal;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SafetyRating$Internal$$serializer implements GeneratedSerializer<SafetyRating.Internal> {
    public static final SafetyRating$Internal$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SafetyRating$Internal$$serializer safetyRating$Internal$$serializer = new SafetyRating$Internal$$serializer();
        INSTANCE = safetyRating$Internal$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.ai.type.SafetyRating.Internal", safetyRating$Internal$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, true);
        pluginGeneratedSerialDescriptor.addElement("probability", true);
        pluginGeneratedSerialDescriptor.addElement("blocked", true);
        pluginGeneratedSerialDescriptor.addElement("probabilityScore", true);
        pluginGeneratedSerialDescriptor.addElement(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, true);
        pluginGeneratedSerialDescriptor.addElement("severityScore", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SafetyRating$Internal$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(HarmCategory.Internal.Serializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(HarmProbability.Internal.Serializer.INSTANCE);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE);
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(HarmSeverity.Internal.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(floatSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SafetyRating.Internal deserialize(Decoder decoder) {
        HarmCategory.Internal internal;
        Float f;
        Float f2;
        HarmSeverity.Internal internal2;
        Boolean bool;
        HarmProbability.Internal internal3;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        SafetyRating.Internal internal4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            internal = (HarmCategory.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, HarmCategory.Internal.Serializer.INSTANCE, null);
            HarmProbability.Internal internal5 = (HarmProbability.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, HarmProbability.Internal.Serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, null);
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            Float f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, floatSerializer, null);
            HarmSeverity.Internal internal6 = (HarmSeverity.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, HarmSeverity.Internal.Serializer.INSTANCE, null);
            f = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, floatSerializer, null);
            f2 = f3;
            internal2 = internal6;
            bool = bool2;
            internal3 = internal5;
            i = 63;
        } else {
            boolean z = true;
            int i2 = 0;
            internal = null;
            Float f4 = null;
            Float f5 = null;
            HarmSeverity.Internal internal7 = null;
            Boolean bool3 = null;
            HarmProbability.Internal internal8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        internal = (HarmCategory.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, HarmCategory.Internal.Serializer.INSTANCE, internal);
                        i2 |= 1;
                        break;
                    case 1:
                        internal8 = (HarmProbability.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, HarmProbability.Internal.Serializer.INSTANCE, internal8);
                        i2 |= 2;
                        break;
                    case 2:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 4;
                        break;
                    case 3:
                        f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, f5);
                        i2 |= 8;
                        break;
                    case 4:
                        internal7 = (HarmSeverity.Internal) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, HarmSeverity.Internal.Serializer.INSTANCE, internal7);
                        i2 |= 16;
                        break;
                    case 5:
                        f4 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, FloatSerializer.INSTANCE, f4);
                        i2 |= 32;
                        break;
                    default:
                        Events$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return internal4;
                }
                internal4 = null;
            }
            f = f4;
            f2 = f5;
            internal2 = internal7;
            bool = bool3;
            internal3 = internal8;
            i = i2;
        }
        HarmCategory.Internal internal9 = internal;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SafetyRating.Internal(i, internal9, internal3, bool, f2, internal2, f, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SafetyRating.Internal value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SafetyRating.Internal.write$Self$com_google_firebase_ai_logic_firebase_ai(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

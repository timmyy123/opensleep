package com.google.firebase.ai.common.util;

import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001d\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/ai/common/util/FirstOrdinalSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "enumClass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "printWarning", "", "name", "", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", SDKConstants.PARAM_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirstOrdinalSerializer<T extends Enum<T>> implements KSerializer<T> {
    private final SerialDescriptor descriptor;
    private final KClass<T> enumClass;

    public FirstOrdinalSerializer(KClass<T> kClass) {
        kClass.getClass();
        this.enumClass = kClass;
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("FirstOrdinalSerializer", new SerialDescriptor[0], new CodecsKt$$ExternalSyntheticLambda2(this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(FirstOrdinalSerializer firstOrdinalSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        classSerialDescriptorBuilder.getClass();
        for (Enum r0 : SerializationKt.enumValues(firstOrdinalSerializer.enumClass)) {
            classSerialDescriptorBuilder.element(r0.toString(), StringSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        }
        return Unit.INSTANCE;
    }

    private final void printWarning(String name) {
        Log.e("FirstOrdinalSerializer", StringsKt__IndentKt.trimMargin$default("\n        |Unknown enum value found: " + name + "\"\n        |This usually means the backend was updated, and the SDK needs to be updated to match it.\n        |Check if there's a new version for the SDK, otherwise please open an issue on our\n        |GitHub to bring it to our attention:\n        |https://github.com/google/google-ai-android\n       ", null, 1, null));
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        T t;
        decoder.getClass();
        String strDecodeString = decoder.decodeString();
        Enum[] enumArrEnumValues = SerializationKt.enumValues(this.enumClass);
        int length = enumArrEnumValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                t = null;
                break;
            }
            t = (T) enumArrEnumValues[i];
            if (Intrinsics.areEqual(SerializationKt.getSerialName(t), strDecodeString)) {
                break;
            }
            i++;
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ArraysKt.first(enumArrEnumValues);
        printWarning(strDecodeString);
        return t2;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        encoder.getClass();
        value.getClass();
        encoder.encodeString(SerializationKt.getSerialName(value));
    }
}

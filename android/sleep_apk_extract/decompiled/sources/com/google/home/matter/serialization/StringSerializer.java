package com.google.home.matter.serialization;

import com.google.home.platform.traits.Value;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/serialization/StringSerializer;", "Lcom/google/home/matter/serialization/ValueSerializer;", "", "<init>", "()V", "Lcom/google/home/platform/traits/Value;", "valueProto", "deserialize", "(Lcom/google/home/platform/traits/Value;)Ljava/lang/String;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StringSerializer implements ValueSerializer<String> {
    public static final StringSerializer INSTANCE = new StringSerializer();

    private StringSerializer() {
    }

    @Override // com.google.home.matter.serialization.ValueSerializer
    public String deserialize(Value valueProto) {
        valueProto.getClass();
        String stringValue = valueProto.getStringValue();
        stringValue.getClass();
        return stringValue;
    }
}

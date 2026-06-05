package com.google.home.matter.serialization;

import com.google.home.platform.traits.Value;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/serialization/ValueSerializer;", "", "T", "Lcom/google/home/platform/traits/Value;", "valueProto", "deserialize", "(Lcom/google/home/platform/traits/Value;)Ljava/lang/Object;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ValueSerializer<T> {
    T deserialize(Value valueProto);
}

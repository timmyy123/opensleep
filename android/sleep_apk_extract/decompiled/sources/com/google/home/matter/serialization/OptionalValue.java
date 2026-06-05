package com.google.home.matter.serialization;

import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: renamed from: com.google.home.matter.serialization.OptionalPresent, reason: from toString */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u000fH\u0016J(\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0002\"\u0004\b\u0001\u0010\u00112\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002R\u0016\u0010\u0003\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/google/home/matter/serialization/OptionalPresent;", "T", "Lcom/google/home/matter/serialization/OptionalValue;", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isPresent", "", "()Z", "doWhenPresent", "", UserDataStore.FIRST_NAME, "Lkotlin/Function1;", "map", "O", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "equals", "other", "", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OptionalValue<T> implements com.google.home.matter.serialization.OptionalValue<T> {
    private final T value;

    public OptionalValue(T t) {
        this.value = t;
        if (getValue() != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
        throw null;
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public void doWhenPresent(Function1<? super T, Unit> fn) {
        fn.getClass();
        fn.invoke(getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.google.home.matter.serialization.OptionalValue)) {
            return false;
        }
        com.google.home.matter.serialization.OptionalValue optionalValue = (com.google.home.matter.serialization.OptionalValue) other;
        if (!optionalValue.isPresent()) {
            return false;
        }
        Object value = optionalValue.getValue();
        return ((getValue() instanceof byte[]) && (value instanceof byte[])) ? Arrays.equals((byte[]) getValue(), (byte[]) value) : ((getValue() instanceof Object[]) && (value instanceof Object[])) ? ArraysKt.contentDeepEquals((Object[]) getValue(), (Object[]) value) : ((getValue() instanceof List) && (value instanceof List)) ? ArraysKt.contentDeepEquals(((Collection) getValue()).toArray(new Object[0]), ((Collection) value).toArray(new Object[0])) : Intrinsics.areEqual(getValue(), optionalValue.getValue());
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public T getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        T value = getValue();
        if (value instanceof byte[]) {
            return Arrays.hashCode((byte[]) getValue());
        }
        if (value instanceof Object[]) {
            return ArraysKt.contentDeepHashCode((Object[]) getValue());
        }
        boolean z = value instanceof List;
        T value2 = getValue();
        if (z) {
            return ArraysKt.contentDeepHashCode(((Collection) value2).toArray(new Object[0]));
        }
        if (value2 == null) {
            return 0;
        }
        return value2.hashCode();
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public <O> com.google.home.matter.serialization.OptionalValue<O> map(Function1<? super T, ? extends O> fn) {
        fn.getClass();
        return com.google.home.matter.serialization.OptionalValue.INSTANCE.present(fn.invoke(getValue()));
    }

    public String toString() {
        T value = getValue();
        StringBuilder sb = new StringBuilder(String.valueOf(value).length() + 15);
        sb.append("OptionalValue(");
        sb.append(value);
        sb.append(")");
        return sb.toString();
    }
}

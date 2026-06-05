package com.google.home.matter.serialization;

import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/google/home/matter/serialization/OptionalAbsent;", "Lcom/google/home/matter/serialization/OptionalValue;", "", "<init>", "()V", "Lkotlin/Function1;", "", UserDataStore.FIRST_NAME, "doWhenPresent", "(Lkotlin/jvm/functions/Function1;)V", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "O", "map", "(Lkotlin/jvm/functions/Function1;)Lcom/google/home/matter/serialization/OptionalValue;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", SDKConstants.PARAM_VALUE, "isPresent", "()Z", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OptionalAbsent implements OptionalValue<Object> {
    public static final OptionalAbsent INSTANCE = new OptionalAbsent();

    private OptionalAbsent() {
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public void doWhenPresent(Function1<? super Object, Unit> fn) {
        fn.getClass();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OptionalValue) && !((OptionalValue) other).isPresent();
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public Object getValue() {
        throw new IllegalStateException("Value not present");
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.home.matter.serialization.OptionalValue
    public <O> OptionalValue<O> map(Function1<Object, ? extends O> fn) {
        fn.getClass();
        OptionalAbsent optionalAbsent = INSTANCE;
        optionalAbsent.getClass();
        return optionalAbsent;
    }

    public String toString() {
        return "OptionalValue()";
    }
}

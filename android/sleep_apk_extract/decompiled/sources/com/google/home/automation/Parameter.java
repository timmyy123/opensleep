package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Field;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/home/automation/Parameter;", "", "Lkotlin/Pair;", "Lcom/google/home/Field;", "param", "<init>", "(Lkotlin/Pair;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/Pair;", "getParam", "()Lkotlin/Pair;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Parameter {
    private final Pair<Field, Object> param;

    /* JADX WARN: Multi-variable type inference failed */
    public Parameter(Pair<? extends Field, ? extends Object> pair) {
        pair.getClass();
        this.param = pair;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Parameter) {
            return Intrinsics.areEqual(this.param, ((Parameter) other).param);
        }
        return false;
    }

    public int hashCode() {
        return this.param.hashCode();
    }

    public String toString() {
        Pair<Field, Object> pair = this.param;
        return zza.zza(pair, pair, (byte) 8, (byte) 28, "Parameter(key=", ".first, value=", ".second)");
    }
}

package com.google.home.automation;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.Number;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/home/automation/NumberRangeConstraint;", "", "T", "Lcom/google/home/automation/Constraint;", "lowerBound", "upperBound", "step", "Lcom/google/home/automation/ConstraintUnit;", "unit", "<init>", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Lcom/google/home/automation/ConstraintUnit;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/Number;", "getLowerBound", "()Ljava/lang/Number;", "getUpperBound", "getStep", "Lcom/google/home/automation/ConstraintUnit;", "getUnit", "()Lcom/google/home/automation/ConstraintUnit;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NumberRangeConstraint<T extends Number> implements Constraint {
    private final T lowerBound;
    private final T step;
    private final ConstraintUnit unit;
    private final T upperBound;

    public NumberRangeConstraint(T t, T t2, T t3, ConstraintUnit constraintUnit) {
        t.getClass();
        t2.getClass();
        t3.getClass();
        this.lowerBound = t;
        this.upperBound = t2;
        this.step = t3;
        this.unit = constraintUnit;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumberRangeConstraint)) {
            return false;
        }
        NumberRangeConstraint numberRangeConstraint = (NumberRangeConstraint) other;
        return this.lowerBound.doubleValue() == numberRangeConstraint.lowerBound.doubleValue() && this.upperBound.doubleValue() == numberRangeConstraint.upperBound.doubleValue() && this.step.doubleValue() == numberRangeConstraint.step.doubleValue() && Intrinsics.areEqual(this.unit, numberRangeConstraint.unit);
    }

    public int hashCode() {
        int iHashCode = this.step.hashCode() + ((this.upperBound.hashCode() + (this.lowerBound.hashCode() * 31)) * 31);
        ConstraintUnit constraintUnit = this.unit;
        return (iHashCode * 31) + (constraintUnit != null ? constraintUnit.hashCode() : 0);
    }

    public String toString() {
        T t = this.lowerBound;
        int length = String.valueOf(t).length();
        T t2 = this.upperBound;
        int length2 = String.valueOf(t2).length();
        T t3 = this.step;
        int length3 = String.valueOf(t3).length();
        ConstraintUnit constraintUnit = this.unit;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 46, length2, 7, length3, 7, String.valueOf(constraintUnit).length()) + 1);
        sb.append("NumberRangeConstraint(lowerBound=");
        sb.append(t);
        sb.append(", upperBound=");
        sb.append(t2);
        sb.append(", step=");
        sb.append(t3);
        sb.append(", unit=");
        sb.append(constraintUnit);
        sb.append(")");
        return sb.toString();
    }
}

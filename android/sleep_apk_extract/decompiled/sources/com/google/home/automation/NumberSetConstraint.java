package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.Number;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/google/home/automation/NumberSetConstraint;", "", "T", "Lcom/google/home/automation/Constraint;", "", "allowedSet", "Lcom/google/home/automation/ConstraintUnit;", "unit", "<init>", "(Ljava/util/Set;Lcom/google/home/automation/ConstraintUnit;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Set;", "getAllowedSet", "()Ljava/util/Set;", "Lcom/google/home/automation/ConstraintUnit;", "getUnit", "()Lcom/google/home/automation/ConstraintUnit;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NumberSetConstraint<T extends Number> implements Constraint {
    private final Set<T> allowedSet;
    private final ConstraintUnit unit;

    /* JADX WARN: Multi-variable type inference failed */
    public NumberSetConstraint(Set<? extends T> set, ConstraintUnit constraintUnit) {
        set.getClass();
        this.allowedSet = set;
        this.unit = constraintUnit;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumberSetConstraint)) {
            return false;
        }
        NumberSetConstraint numberSetConstraint = (NumberSetConstraint) other;
        if (!Intrinsics.areEqual(this.unit, numberSetConstraint.unit) || this.allowedSet.size() != numberSetConstraint.allowedSet.size()) {
            return false;
        }
        Set<T> set = numberSetConstraint.allowedSet;
        if (set != null && set.isEmpty()) {
            return true;
        }
        for (T t : set) {
            Set<T> set2 = this.allowedSet;
            if (set2 != null && set2.isEmpty()) {
                return false;
            }
            Iterator<T> it = set2.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).doubleValue() == t.doubleValue()) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = this.allowedSet.hashCode() * 31;
        ConstraintUnit constraintUnit = this.unit;
        return iHashCode + (constraintUnit != null ? constraintUnit.hashCode() : 0);
    }

    public String toString() {
        return zza.zza(this.unit, this.allowedSet, (byte) 1, (byte) 38, "NumberSetConstraint(allowedSet=", ", unit=", ")");
    }
}

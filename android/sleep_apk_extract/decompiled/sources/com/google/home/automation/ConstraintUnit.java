package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/google/home/automation/ConstraintUnit;", "", "Lcom/google/home/automation/BaseUnit;", "baseUnit", "", "scale", "<init>", "(Lcom/google/home/automation/BaseUnit;Ljava/lang/Number;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/automation/BaseUnit;", "getBaseUnit", "()Lcom/google/home/automation/BaseUnit;", "Ljava/lang/Number;", "getScale", "()Ljava/lang/Number;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConstraintUnit {
    private final BaseUnit baseUnit;
    private final Number scale;

    public ConstraintUnit(BaseUnit baseUnit, Number number) {
        baseUnit.getClass();
        number.getClass();
        this.baseUnit = baseUnit;
        this.scale = number;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConstraintUnit)) {
            return false;
        }
        ConstraintUnit constraintUnit = (ConstraintUnit) other;
        return this.baseUnit == constraintUnit.baseUnit && this.scale.doubleValue() == constraintUnit.scale.doubleValue();
    }

    public int hashCode() {
        return this.scale.hashCode() + (this.baseUnit.hashCode() * 31);
    }

    public String toString() {
        return zza.zza(this.scale, this.baseUnit, (byte) 1, (byte) 32, "ConstraintUnit(baseUnit=", ", scale=", ")");
    }
}

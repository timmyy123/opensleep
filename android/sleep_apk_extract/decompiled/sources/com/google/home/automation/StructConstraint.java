package com.google.home.automation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/google/home/automation/StructConstraint;", "Lcom/google/home/automation/Constraint;", "", "Lcom/google/home/Field;", "fieldConstraints", "<init>", "(Ljava/util/Map;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Map;", "getFieldConstraints", "()Ljava/util/Map;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StructConstraint implements Constraint {
    private final Map<Field, Constraint> fieldConstraints;

    /* JADX WARN: Multi-variable type inference failed */
    public StructConstraint(Map<Field, ? extends Constraint> map) {
        map.getClass();
        this.fieldConstraints = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof StructConstraint) {
            return Intrinsics.areEqual(this.fieldConstraints, ((StructConstraint) other).fieldConstraints);
        }
        return false;
    }

    public int hashCode() {
        return this.fieldConstraints.hashCode();
    }

    public String toString() {
        return zzb.zza(this.fieldConstraints, "StructConstraint(fieldConstraints=", (byte) 35);
    }
}

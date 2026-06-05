package com.google.android.gms.internal.serialization;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.platform.traits.Value;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/home/automation/serialization/ConstantWithType;", "Lcom/google/home/automation/serialization/OperandWithType;", "constant", "Lcom/google/home/platform/traits/Value;", "<init>", "(Lcom/google/home/platform/traits/Value;)V", "getConstant", "()Lcom/google/home/platform/traits/Value;", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzme extends OperandWithType {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final Value constant;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzme(Value value) {
        super(null, null, null);
        value.getClass();
        this.constant = value;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final String toString() {
        String string = super.toString();
        int length = string.length();
        Value value = this.constant;
        StringBuilder sb = new StringBuilder(length + 27 + String.valueOf(value).length() + 2);
        sb.append(string);
        sb.append(":ConstantWithType(constant=");
        sb.append(value);
        sb.append("})");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final Value getConstant() {
        return this.constant;
    }
}

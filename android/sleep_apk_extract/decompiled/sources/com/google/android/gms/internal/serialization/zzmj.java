package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/home/automation/serialization/FieldNameWithType;", "Lcom/google/home/automation/serialization/OperandWithType;", "fieldName", "", "<init>", "(Ljava/lang/String;)V", "getFieldName", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmj extends OperandWithType {
    private final String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmj(String str) {
        super(null, null, null);
        str.getClass();
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final String toString() {
        String string = super.toString();
        int length = string.length();
        String str = this.zza;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(length + 28 + String.valueOf(str).length() + 1), string, "FieldNameWithType(fieldName=", str, ")");
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getZza() {
        return this.zza;
    }
}

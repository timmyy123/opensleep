package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/google/home/automation/serialization/FieldIdWithType;", "Lcom/google/home/automation/serialization/OperandWithType;", "fieldId", "Lkotlin/UInt;", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFieldId-pVg5ArA", "()I", "I", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmi extends OperandWithType {
    private final int zza;

    public /* synthetic */ zzmi(int i, DefaultConstructorMarker defaultConstructorMarker) {
        super(null, null, null);
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.serialization.OperandWithType
    public final String toString() {
        String string = super.toString();
        int length = string.length();
        String strM2392toStringimpl = UInt.m2392toStringimpl(this.zza);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(length + 25 + String.valueOf(strM2392toStringimpl).length() + 1), string, ":FieldIdWithType(fieldId=", strM2392toStringimpl, ")");
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final int getZza() {
        return this.zza;
    }
}

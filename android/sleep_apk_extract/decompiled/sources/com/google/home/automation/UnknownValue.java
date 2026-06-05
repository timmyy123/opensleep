package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.serialization.zzvo;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/home/automation/UnknownValue;", "", "byteArray", "", "<init>", "([B)V", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnknownValue {
    private final byte[] byteArray;

    public UnknownValue(byte[] bArr) {
        bArr.getClass();
        this.byteArray = bArr;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnknownValue) {
            return Arrays.equals(this.byteArray, ((UnknownValue) other).byteArray);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.byteArray);
    }

    public String toString() {
        String strZzb = zzvo.zzb(this.byteArray);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strZzb).length() + 24), "UnknownValue(byteArray=", strZzb, ")");
    }
}

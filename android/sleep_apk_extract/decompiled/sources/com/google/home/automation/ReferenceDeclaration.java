package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/automation/ReferenceDeclaration;", "", "variable", "", "<init>", "(Ljava/lang/String;)V", "getVariable", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReferenceDeclaration {
    private final String variable;

    public ReferenceDeclaration(String str) {
        str.getClass();
        this.variable = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReferenceDeclaration) && Intrinsics.areEqual(this.variable, ((ReferenceDeclaration) other).variable);
    }

    public final String getVariable() {
        return this.variable;
    }

    public int hashCode() {
        return this.variable.hashCode();
    }

    public String toString() {
        String str = this.variable;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 31), "ReferenceDeclaration(variable=", str, ")");
    }
}

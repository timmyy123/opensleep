package com.urbandroid.sleep.hr;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/hr/Capability;", "T", "", "", "name", "Ljava/lang/Class;", "valueType", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/String;", "getName", "Ljava/lang/Class;", "getValueType", "()Ljava/lang/Class;", "Lcom/urbandroid/sleep/hr/AccelCapability;", "Lcom/urbandroid/sleep/hr/HRCapability;", "Lcom/urbandroid/sleep/hr/RRCapability;", "Lcom/urbandroid/sleep/hr/SPO2Capability;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Capability<T> {
    private final String name;
    private final Class<T> valueType;

    private Capability(String str, Class<T> cls) {
        this.name = str;
        this.valueType = cls;
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getName() {
        return this.name;
    }

    public /* synthetic */ Capability(String str, Class cls, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cls);
    }
}

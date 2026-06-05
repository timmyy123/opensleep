package com.urbandroid.smartlight.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Blinder;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", DeviceRequestsHelper.DEVICE_INFO_MODEL, "getModel", "setModel", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Blinder {
    private final String id;
    private String model;
    private final String name;
    private String version;

    public Blinder(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.name = str2;
    }

    public static /* synthetic */ Blinder copy$default(Blinder blinder, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blinder.id;
        }
        if ((i & 2) != 0) {
            str2 = blinder.name;
        }
        return blinder.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Blinder copy(String id, String name) {
        id.getClass();
        name.getClass();
        return new Blinder(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Blinder.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        return Intrinsics.areEqual(this.id, ((Light) other).getId());
    }

    public final String getId() {
        return this.id;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Blinder(id=");
        sb.append(this.id);
        sb.append(", name=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, ')');
    }

    public /* synthetic */ Blinder(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? str : str2);
    }
}

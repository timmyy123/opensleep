package com.polar.sdk.api.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\t\u0010\u001cR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/polar/sdk/api/model/PolarDeviceInfo;", "", "", "deviceId", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "rssi", "name", "", "isConnectable", "hasHeartRateService", "hasFileSystemService", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZ)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAddress", "I", "getRssi", "getName", "Z", "()Z", "getHasHeartRateService", "getHasFileSystemService", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PolarDeviceInfo {
    private final String address;
    private final String deviceId;
    private final boolean hasFileSystemService;
    private final boolean hasHeartRateService;
    private final boolean isConnectable;
    private final String name;
    private final int rssi;

    public PolarDeviceInfo(String str, String str2, int i, String str3, boolean z, boolean z2, boolean z3) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        this.deviceId = str;
        this.address = str2;
        this.rssi = i;
        this.name = str3;
        this.isConnectable = z;
        this.hasHeartRateService = z2;
        this.hasFileSystemService = z3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolarDeviceInfo)) {
            return false;
        }
        PolarDeviceInfo polarDeviceInfo = (PolarDeviceInfo) other;
        return Intrinsics.areEqual(this.deviceId, polarDeviceInfo.deviceId) && Intrinsics.areEqual(this.address, polarDeviceInfo.address) && this.rssi == polarDeviceInfo.rssi && Intrinsics.areEqual(this.name, polarDeviceInfo.name) && this.isConnectable == polarDeviceInfo.isConnectable && this.hasHeartRateService == polarDeviceInfo.hasHeartRateService && this.hasFileSystemService == polarDeviceInfo.hasFileSystemService;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hasFileSystemService) + FileInsert$$ExternalSyntheticOutline0.m(this.hasHeartRateService, FileInsert$$ExternalSyntheticOutline0.m(this.isConnectable, FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.rssi, FileInsert$$ExternalSyntheticOutline0.m(this.deviceId.hashCode() * 31, 31, this.address), 31), 31, this.name), 31), 31);
    }

    /* JADX INFO: renamed from: isConnectable, reason: from getter */
    public final boolean getIsConnectable() {
        return this.isConnectable;
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.address;
        int i = this.rssi;
        String str3 = this.name;
        boolean z = this.isConnectable;
        boolean z2 = this.hasHeartRateService;
        boolean z3 = this.hasFileSystemService;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("PolarDeviceInfo(deviceId=", str, ", address=", str2, ", rssi=");
        sbM6m.append(i);
        sbM6m.append(", name=");
        sbM6m.append(str3);
        sbM6m.append(", isConnectable=");
        sbM6m.append(z);
        sbM6m.append(", hasHeartRateService=");
        sbM6m.append(z2);
        sbM6m.append(", hasFileSystemService=");
        sbM6m.append(z3);
        sbM6m.append(")");
        return sbM6m.toString();
    }

    public /* synthetic */ PolarDeviceInfo(String str, String str2, int i, String str3, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, z, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? false : z3);
    }
}

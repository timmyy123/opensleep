package com.polar.androidcommunications.api.ble.model.advertisement;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8F@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/advertisement/BlePolarHrAdvertisement;", "", "<init>", "()V", "", "data", "", "processPolarManufacturerData", "([B)V", "resetToDefault", "currentData", "[B", "", "<set-?>", "advFrameCounter", "I", "getAdvFrameCounter", "()I", "getAdvFrameCounter$annotations", "previousAdvFrameCounter", "", "isPresent", "()Z", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BlePolarHrAdvertisement {
    private int previousAdvFrameCounter;
    private byte[] currentData = new byte[0];
    private int advFrameCounter = -1;

    public final int getAdvFrameCounter() {
        byte[] bArr = this.currentData;
        if (bArr.length == 0) {
            return -1;
        }
        return (bArr[0] & 28) >> 2;
    }

    public final boolean isPresent() {
        return !(this.currentData.length == 0);
    }

    public final void processPolarManufacturerData(byte[] data2) {
        data2.getClass();
        this.previousAdvFrameCounter = getAdvFrameCounter();
        this.currentData = data2;
    }

    public final void resetToDefault() {
        this.currentData = new byte[0];
        this.advFrameCounter = -1;
    }
}

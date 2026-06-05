package com.polar.androidcommunications.api.ble.exceptions;

import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdControlPointResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/polar/androidcommunications/api/ble/exceptions/BleControlPointCommandError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", "error", "<init>", "(Ljava/lang/String;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;)V", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", "getError", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointResponse$PmdControlPointResponseCode;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BleControlPointCommandError extends Exception {
    private final PmdControlPointResponse.PmdControlPointResponseCode error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BleControlPointCommandError(String str, PmdControlPointResponse.PmdControlPointResponseCode pmdControlPointResponseCode) {
        super(str + " " + pmdControlPointResponseCode);
        str.getClass();
        pmdControlPointResponseCode.getClass();
        this.error = pmdControlPointResponseCode;
    }
}

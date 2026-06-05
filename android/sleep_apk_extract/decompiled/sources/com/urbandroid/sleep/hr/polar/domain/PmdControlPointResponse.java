package com.urbandroid.sleep.hr.polar.domain;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class PmdControlPointResponse {
    public byte measurementType;
    public boolean more;
    public PmdControlPointCommand opCode;
    public ByteArrayOutputStream parameters = new ByteArrayOutputStream();
    public byte responseCode;
    public PmdControlPointResponseCode status;

    /* JADX INFO: loaded from: classes4.dex */
    public enum PmdControlPointResponseCode {
        SUCCESS(0),
        ERROR_INVALID_OP_CODE(1),
        ERROR_INVALID_MEASUREMENT_TYPE(2),
        ERROR_NOT_SUPPORTED(3),
        ERROR_INVALID_LENGTH(4),
        ERROR_INVALID_PARAMETER(5),
        ERROR_INVALID_STATE(6),
        ERROR_INVALID_RESOLUTION(7),
        ERROR_INVALID_SAMPLE_RATE(8),
        ERROR_INVALID_RANGE(9),
        ERROR_INVALID_MTU(10),
        ERROR_INVALID_NUMBER_OF_CHANNELS(11);

        private int numVal;

        PmdControlPointResponseCode(int i) {
            this.numVal = i;
        }
    }

    public PmdControlPointResponse(byte[] bArr) {
        boolean z = false;
        this.responseCode = bArr[0];
        this.opCode = PmdControlPointCommand.values()[bArr[1]];
        this.measurementType = bArr[2];
        PmdControlPointResponseCode pmdControlPointResponseCode = PmdControlPointResponseCode.values()[bArr[3]];
        this.status = pmdControlPointResponseCode;
        if (pmdControlPointResponseCode == PmdControlPointResponseCode.SUCCESS) {
            if (bArr.length > 4 && bArr[4] != 0) {
                z = true;
            }
            this.more = z;
            if (bArr.length > 5) {
                this.parameters.write(bArr, 5, bArr.length - 5);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PmdControlPointResponse{responseCode=");
        sb.append((int) this.responseCode);
        sb.append(", opCode=");
        sb.append(this.opCode);
        sb.append(", measurementType=");
        sb.append((int) this.measurementType);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", parameters=");
        sb.append(BLEUtilKt.toHexString(this.parameters.toByteArray()));
        sb.append(", more=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.more, '}');
    }
}

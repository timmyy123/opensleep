package com.google.zxing.qrcode.encoder;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* JADX INFO: loaded from: classes4.dex */
public final class QRCode {
    private ErrorCorrectionLevel ecLevel;
    private int maskPattern = -1;
    private ByteMatrix matrix;
    private Mode mode;
    private Version version;

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }

    public ByteMatrix getMatrix() {
        return this.matrix;
    }

    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    public void setMaskPattern(int i) {
        this.maskPattern = i;
    }

    public void setMatrix(ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String toString() {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(200, "<<\n mode: ");
        sbM.append(this.mode);
        sbM.append("\n ecLevel: ");
        sbM.append(this.ecLevel);
        sbM.append("\n version: ");
        sbM.append(this.version);
        sbM.append("\n maskPattern: ");
        sbM.append(this.maskPattern);
        if (this.matrix == null) {
            sbM.append("\n matrix: null\n");
        } else {
            sbM.append("\n matrix:\n");
            sbM.append(this.matrix);
        }
        sbM.append(">>\n");
        return sbM.toString();
    }
}

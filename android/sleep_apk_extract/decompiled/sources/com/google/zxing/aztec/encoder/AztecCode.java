package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes4.dex */
public final class AztecCode {
    private int codeWords;
    private boolean compact;
    private int layers;
    private BitMatrix matrix;
    private int size;

    public BitMatrix getMatrix() {
        return this.matrix;
    }

    public void setCodeWords(int i) {
        this.codeWords = i;
    }

    public void setCompact(boolean z) {
        this.compact = z;
    }

    public void setLayers(int i) {
        this.layers = i;
    }

    public void setMatrix(BitMatrix bitMatrix) {
        this.matrix = bitMatrix;
    }

    public void setSize(int i) {
        this.size = i;
    }
}

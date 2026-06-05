package com.ftdi.j2xx;

/* JADX INFO: loaded from: classes3.dex */
class FtVidPid {
    private int mProductId;
    private int mVendorId;

    public FtVidPid(int i, int i2) {
        this.mVendorId = i;
        this.mProductId = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtVidPid)) {
            return false;
        }
        FtVidPid ftVidPid = (FtVidPid) obj;
        return this.mVendorId == ftVidPid.mVendorId && this.mProductId == ftVidPid.mProductId;
    }

    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "Vendor: " + String.format("%04x", Integer.valueOf(this.mVendorId)) + ", Product: " + String.format("%04x", Integer.valueOf(this.mProductId));
    }
}

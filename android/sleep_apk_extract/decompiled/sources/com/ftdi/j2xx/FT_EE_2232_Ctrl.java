package com.ftdi.j2xx;

/* JADX INFO: loaded from: classes3.dex */
class FT_EE_2232_Ctrl extends FT_EE_Ctrl {
    public FT_EE_2232_Ctrl(FT_Device fT_Device) {
        super(fT_Device);
        getEepromSize((byte) 10);
    }
}

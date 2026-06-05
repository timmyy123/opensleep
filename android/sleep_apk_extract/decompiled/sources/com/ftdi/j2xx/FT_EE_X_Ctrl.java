package com.ftdi.j2xx;

/* JADX INFO: loaded from: classes3.dex */
class FT_EE_X_Ctrl extends FT_EE_Ctrl {
    private static FT_Device ft_device;

    public FT_EE_X_Ctrl(FT_Device fT_Device) {
        super(fT_Device);
        ft_device = fT_Device;
        this.mEepromSize = 128;
        this.mEepromType = (short) 1;
    }
}

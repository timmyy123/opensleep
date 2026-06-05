package com.ftdi.j2xx;

/* JADX INFO: loaded from: classes3.dex */
class FT_EE_245R_Ctrl extends FT_EE_Ctrl {
    private static FT_Device ft_device;

    public FT_EE_245R_Ctrl(FT_Device fT_Device) {
        super(fT_Device);
        ft_device = fT_Device;
    }

    @Override // com.ftdi.j2xx.FT_EE_Ctrl
    public boolean writeWord(short s, short s2) {
        int i = s2 & 65535;
        int i2 = s & 65535;
        if (s >= 1024) {
            return false;
        }
        byte latencyTimer = ft_device.getLatencyTimer();
        ft_device.setLatencyTimer((byte) 119);
        boolean z = ft_device.getConnection().controlTransfer(64, 145, i, i2, null, 0, 0) == 0;
        ft_device.setLatencyTimer(latencyTimer);
        return z;
    }
}

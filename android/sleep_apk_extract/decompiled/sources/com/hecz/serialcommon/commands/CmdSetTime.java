package com.hecz.serialcommon.commands;

import com.hecz.serialcommon.commands.Command;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class CmdSetTime extends Command {
    private boolean isOn;
    private double time;

    public CmdSetTime(IHEDevice iHEDevice, double d, boolean z) {
        super(iHEDevice);
        this.time = d;
        setOn(z);
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void setOn(boolean z) {
        this.isOn = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017 A[Catch: IOException -> 0x008a, PHI: r3
      0x0017: PHI (r3v10 com.hecz.serialcommon.commands.IHEDevice) = (r3v0 com.hecz.serialcommon.commands.IHEDevice), (r3v2 com.hecz.serialcommon.commands.IHEDevice) binds: [B:5:0x0015, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {IOException -> 0x008a, blocks: (B:3:0x000a, B:6:0x0017, B:14:0x0038, B:16:0x007c, B:20:0x0084, B:19:0x0081, B:7:0x001f, B:9:0x0026, B:13:0x002f), top: B:24:0x000a, inners: #1 }] */
    @Override // com.hecz.serialcommon.commands.Command
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void start() {
        long tConst = (long) (this.flex.getTConst() * this.time);
        try {
            int hWVersion = this.flex.getHWVersion();
            IHEDevice iHEDevice = this.flex;
            if (hWVersion != 2) {
                if (iHEDevice.getHWVersion() == 1) {
                    boolean zIsOn = isOn();
                    iHEDevice = this.flex;
                    if (zIsOn) {
                        iHEDevice.getOs().write(110);
                    } else {
                        iHEDevice.getOs().write(109);
                    }
                }
            }
            this.flex.getOs().write(((int) (tConst >> 24)) & PHIpAddressSearchManager.END_IP_SCAN);
            this.flex.getOs().write(((int) (tConst >> 16)) & PHIpAddressSearchManager.END_IP_SCAN);
            this.flex.getOs().write(((int) (tConst >> 8)) & PHIpAddressSearchManager.END_IP_SCAN);
            this.flex.getOs().write((int) (tConst & 255));
            this.flex.flush();
            try {
                Thread.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setStatus(Command.Status.DONE);
        } catch (IOException unused) {
            setStatus(Command.Status.ERROR);
        }
    }
}

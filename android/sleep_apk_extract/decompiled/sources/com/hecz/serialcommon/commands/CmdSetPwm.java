package com.hecz.serialcommon.commands;

import com.hecz.common.logging.Log;
import com.hecz.serialcommon.commands.Command;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class CmdSetPwm extends Command {
    private final int pwm;

    public CmdSetPwm(IHEDevice iHEDevice, int i) {
        super(iHEDevice);
        this.pwm = i;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        Log.logger.log(Level.INFO, "CmdSetPwm = " + this.pwm);
        try {
            this.flex.getOs().write(112);
            this.flex.getOs().write(this.pwm >> 8);
            this.flex.getOs().write(this.pwm & PHIpAddressSearchManager.END_IP_SCAN);
            this.flex.getOs().flush();
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setStatus(Command.Status.DONE);
        } catch (IOException unused) {
            setStatus(Command.Status.ERROR);
        }
    }
}

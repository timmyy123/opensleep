package com.hecz.serialcommon.commands;

import com.hecz.common.logging.Log;
import com.hecz.serialcommon.commands.Command;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class CmdGetAD extends Command {
    private int ad;
    private int iad;
    private int iter;

    public CmdGetAD(IHEDevice iHEDevice) {
        super(iHEDevice);
    }

    @Override // com.hecz.serialcommon.commands.Command, com.hecz.serialcommon.commands.IReceiveCommandHandler
    public void handle(Object obj) {
        for (byte b : (byte[]) obj) {
            int i = this.iter + 1;
            this.iter = i;
            if (i > 20) {
                Log.logger.log(Level.WARNING, "AD read error");
            }
            if (b >= 48 && b <= 57) {
                this.ad = (b - 48) + (this.ad * 10);
                this.iad++;
            } else if (this.iad > 0) {
                this.iter = 0;
                this.flex.setAd(this.ad);
                int ad = this.flex.getAd();
                IHEDevice iHEDevice = this.flex;
                if (ad == 1023) {
                    iHEDevice.setGsrStr(" <107 kohm");
                } else {
                    int ad2 = iHEDevice.getAd();
                    IHEDevice iHEDevice2 = this.flex;
                    if (ad2 == 0) {
                        iHEDevice2.setGsr(0);
                    } else {
                        iHEDevice2.setGsr((int) (((5.0d / ((((double) iHEDevice2.getAd()) / 1023.0d) * 1.1d)) * 33.0d) - 43.0d));
                    }
                    this.flex.setGsrStr(this.flex.getGSR() + " kohm");
                }
                if (this.flex.getAd() < 50 && this.flex.getAdMode() == 0) {
                    Log.logger.log(Level.WARNING, "change ADMODE -> 1");
                    this.flex.setAdMode((short) 1);
                }
                if (this.flex.getAd() > 300 && this.flex.getAdMode() == 1) {
                    Log.logger.log(Level.WARNING, "change ADMODE -> 0");
                    this.flex.setAdMode((short) 0);
                }
                setStatus(Command.Status.DONE);
                this.flex.setCommnandHandler(null);
            }
        }
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        this.flex.setCommnandHandler(this);
        try {
            short adMode = this.flex.getAdMode();
            IHEDevice iHEDevice = this.flex;
            if (adMode == 0) {
                iHEDevice.getOs().write(88);
                this.flex.getOs().write(119);
            } else {
                iHEDevice.getOs().write(120);
                this.flex.getOs().write(87);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.iter = 0;
        this.iad = 0;
        this.ad = 0;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public String toString() {
        return "cmdReset";
    }
}

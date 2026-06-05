package com.hecz.serialcommon.commands;

import com.hecz.serialcommon.commands.Command;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class CmdSetRGB extends Command {
    private final int blue;
    private final int green;
    private final int red;

    public CmdSetRGB(IHEDevice iHEDevice, int i, int i2, int i3) {
        super(iHEDevice);
        this.red = i;
        this.blue = i2;
        this.green = i3;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        try {
            this.flex.getOs().write(99);
            this.flex.getOs().write(this.red);
            this.flex.getOs().write(this.blue);
            this.flex.getOs().write(this.green);
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

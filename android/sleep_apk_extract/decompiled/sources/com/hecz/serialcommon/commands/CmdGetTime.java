package com.hecz.serialcommon.commands;

import com.hecz.serialcommon.commands.Command;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class CmdGetTime extends Command {
    private int iter;
    private int time;

    public CmdGetTime(IHEDevice iHEDevice) {
        super(iHEDevice);
    }

    @Override // com.hecz.serialcommon.commands.Command, com.hecz.serialcommon.commands.IReceiveCommandHandler
    public void handle(Object obj) {
        for (byte b : (byte[]) obj) {
            if (b >= 48 && b <= 57) {
                this.time = ((this.time * 10) + b) - 48;
                this.iter++;
            } else if (this.iter > 0) {
                this.flex.setFlexTime(this.time, this.startReceiveTime);
                setStatus(Command.Status.DONE);
                this.flex.setCommnandHandler(null);
            }
        }
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        this.flex.setCommnandHandler(this);
        try {
            this.flex.getOs().write(103);
            this.flex.flush();
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.iter = 0;
        this.time = 0;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public String toString() {
        return "cmdReset";
    }
}

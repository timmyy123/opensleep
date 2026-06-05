package com.hecz.serialcommon.commands;

import com.hecz.common.logging.Log;
import com.hecz.serialcommon.commands.Command;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class CmdStart extends Command {
    private char cSend;

    public CmdStart(IHEDevice iHEDevice, char c) {
        super(iHEDevice);
        this.cSend = c;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        Log.logger.log(Level.INFO, "CmdStart");
        try {
            this.flex.getOs().write(this.cSend);
            this.flex.flush();
            this.flex.setStartTime(this.startReceiveTime);
            setStatus(Command.Status.DONE);
        } catch (IOException unused) {
            setStatus(Command.Status.ERROR);
        }
    }
}

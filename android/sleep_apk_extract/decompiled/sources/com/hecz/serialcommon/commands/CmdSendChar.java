package com.hecz.serialcommon.commands;

import com.hecz.serialcommon.commands.Command;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class CmdSendChar extends Command {
    private char cSend;

    public CmdSendChar(IHEDevice iHEDevice, char c) {
        super(iHEDevice);
        setcSend(c);
    }

    public void setcSend(char c) {
        this.cSend = c;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        try {
            this.flex.getOs().write(this.cSend);
            this.flex.flush();
            this.flex.flush();
        } catch (IOException unused) {
            setStatus(Command.Status.ERROR);
        }
    }

    @Override // com.hecz.serialcommon.commands.Command
    public String toString() {
        return super.toString() + " - " + this.cSend;
    }
}

package com.hecz.serialcommon.commands;

import com.hecz.serialcommon.commands.Command;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class CmdSetAdMode extends Command {
    private final short adMode;

    public CmdSetAdMode(IHEDevice iHEDevice, short s) {
        super(iHEDevice);
        this.adMode = s;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        try {
            if (this.adMode == 0) {
                this.flex.getOs().write(88);
            }
            if (this.adMode == 1) {
                this.flex.getOs().write(120);
            }
            this.flex.flush();
            setStatus(Command.Status.DONE);
        } catch (IOException unused) {
            setStatus(Command.Status.ERROR);
        }
    }
}

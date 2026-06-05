package com.hecz.serialcommon.commands;

/* JADX INFO: loaded from: classes4.dex */
public class CmdSetTypeGlasses extends Command {
    private Glasses glasses;

    public CmdSetTypeGlasses(IHEDevice iHEDevice) {
        super(iHEDevice);
        this.glasses = Glasses.RGB;
    }

    public void setTypeOfGlasses(Glasses glasses) {
        this.glasses = glasses;
    }

    @Override // com.hecz.serialcommon.commands.Command
    public void start() {
        this.flex.sendChar(this.glasses == Glasses.RGB ? 'u' : 'U');
    }

    @Override // com.hecz.serialcommon.commands.Command
    public String toString() {
        return "cmdReset";
    }
}

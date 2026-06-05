package com.hecz.serialcommon.commands;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Command implements IReceiveCommandHandler {
    protected long TIMEOUTMS = 200;
    protected long endTime;
    protected final IHEDevice flex;
    protected long startReceiveTime;
    private Status status;

    public enum Status {
        DONE,
        PROCESSING,
        TIMEOUT,
        ERROR
    }

    public Command(IHEDevice iHEDevice) {
        this.flex = iHEDevice;
        setStatus(Status.PROCESSING);
    }

    public void execute() {
        setStatus(Status.PROCESSING);
        this.startReceiveTime = System.currentTimeMillis();
        start();
        this.endTime = System.currentTimeMillis();
    }

    public Status getStatus() {
        if (this.status == Status.PROCESSING && System.currentTimeMillis() - this.startReceiveTime > this.TIMEOUTMS) {
            this.status = Status.TIMEOUT;
        }
        return this.status;
    }

    @Override // com.hecz.serialcommon.commands.IReceiveCommandHandler
    public void handle(Object obj) {
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void start() {
    }

    public String toString() {
        return getClass().getName();
    }
}

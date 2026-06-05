package com.hecz.serialcommon.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class FlexCommandQueue extends Thread {
    private static final Command SHUTDOWN_REQ = new CmdShutDown(null);
    private BufferedWriter bwDebug;
    private boolean isDebug;
    private volatile boolean loggerTerminated;
    private volatile boolean shuttingDown;
    private long timeStartInMs;
    private BlockingQueue priorityCommandsToExecute = new ArrayBlockingQueue(100);
    private BlockingQueue commandsToExecute = new ArrayBlockingQueue(100);

    public FlexCommandQueue() {
        this.bwDebug = null;
        this.isDebug = false;
        if (this.isDebug) {
            this.timeStartInMs = System.currentTimeMillis();
            try {
                this.bwDebug = new BufferedWriter(new FileWriter("flex.log"));
            } catch (IOException e) {
                this.bwDebug = null;
                this.isDebug = false;
                e.printStackTrace();
            }
        }
        start();
    }

    public void addCommand(Command command, boolean z) {
        if (this.shuttingDown || this.loggerTerminated) {
            return;
        }
        try {
            (z ? this.priorityCommandsToExecute : this.commandsToExecute).put(command);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Types$$ExternalSyntheticBUOutline0.m$2("Unexpected interruption");
        }
    }

    public boolean isEmpty() {
        return this.commandsToExecute.isEmpty() && this.priorityCommandsToExecute.isEmpty();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Command command;
        do {
            try {
                command = (Command) (this.priorityCommandsToExecute.isEmpty() ? this.commandsToExecute : this.priorityCommandsToExecute).take();
                if (this.isDebug) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis() - this.timeStartInMs;
                        this.bwDebug.write(jCurrentTimeMillis + ": " + command + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                command.execute();
            } catch (InterruptedException unused) {
                if (this.isDebug) {
                    try {
                        this.bwDebug.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (this.isDebug) {
                    try {
                        this.bwDebug.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                this.loggerTerminated = true;
                throw th;
            }
        } while (!command.getClass().equals(CmdShutDown.class));
        if (this.isDebug) {
            try {
                this.bwDebug.close();
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
            }
        }
        this.loggerTerminated = true;
    }

    public void addCommand(Command command) {
        addCommand(command, false);
    }
}

package com.hecz.serialcommon.flex;

import com.hecz.common.logging.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class FlashTab {
    private static FlashTab instance;
    private BlockingQueue<Double> flashQueue = new LinkedBlockingQueue(500);
    private BlockingQueue<Double> flexEmulatorQueue = new LinkedBlockingQueue(60);
    private double currentFlexTime = 0.0d;
    private Double flashTime = null;
    private int size = 0;

    private FlashTab() {
        Log.logger.log(Level.INFO, "FlashTab::FlashTab");
    }

    public static FlashTab getInstance() {
        if (instance == null) {
            instance = new FlashTab();
        }
        return instance;
    }

    public double getCurrentFlexTime() {
        return this.currentFlexTime;
    }

    public Double getFlashTime() {
        Logger logger;
        Level level;
        StringBuilder sb;
        if (!this.flashQueue.isEmpty()) {
            if (this.flashTime == null) {
                try {
                    this.flashTime = this.flashQueue.take();
                    this.size--;
                } catch (InterruptedException e) {
                    e = e;
                    logger = Log.logger;
                    level = Level.WARNING;
                    sb = new StringBuilder("flashtime - ");
                    sb.append(e);
                    logger.log(level, sb.toString());
                    return null;
                }
            }
            if (this.flexEmulatorQueue.remainingCapacity() > 0) {
                try {
                    this.flexEmulatorQueue.put(this.flashTime);
                    Double d = this.flashTime;
                    this.flashTime = null;
                    return d;
                } catch (InterruptedException e2) {
                    e = e2;
                    logger = Log.logger;
                    level = Level.WARNING;
                    sb = new StringBuilder("flashtime - ");
                    sb.append(e);
                    logger.log(level, sb.toString());
                    return null;
                }
            }
        }
        return null;
    }

    public int getPcmmNData() {
        return this.size;
    }

    public void insert2flashTab(double d) {
        try {
            this.flashQueue.put(Double.valueOf(d));
            this.size++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean readPcmmBuffer2Time(double d) {
        while (!this.flexEmulatorQueue.isEmpty() && getCurrentFlexTime() < d) {
            try {
                setCurrentFlexTime(this.flexEmulatorQueue.take().doubleValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return !this.flexEmulatorQueue.isEmpty();
    }

    public void resetFlashTab() {
        Log.logger.log(Level.INFO, "reset");
        this.flashQueue.clear();
        this.flexEmulatorQueue.clear();
        this.flashTime = null;
        this.size = 0;
        this.currentFlexTime = 0.0d;
    }

    public void setCurrentFlexTime(double d) {
        this.currentFlexTime = d;
    }
}

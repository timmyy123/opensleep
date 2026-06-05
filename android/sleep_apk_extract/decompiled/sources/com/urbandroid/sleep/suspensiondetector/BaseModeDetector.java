package com.urbandroid.sleep.suspensiondetector;

import android.os.Handler;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.AccelManager;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseModeDetector implements ISingleModeDetector {
    private final AccelManager accelManager;
    private boolean isScreenOn;
    protected Thread measureThread;
    private int nonZeroChanges = 0;
    private int totalChanges = 0;
    private Boolean currentModeSupported = null;
    private boolean isAccelStarted = false;
    private boolean interrupted = false;
    private Handler h = new Handler();

    public BaseModeDetector(AccelManager accelManager) {
        this.accelManager = accelManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onNewData(float f) {
        try {
            if (this.interrupted) {
                return;
            }
            if (this.totalChanges >= 11) {
                setResultAndFinish(false);
            }
            Logger.logInfo("Detector [" + getName() + "]: Data added: " + f + " NZ: " + this.nonZeroChanges + " TC: " + this.totalChanges);
            if (f != 0.0f) {
                this.nonZeroChanges++;
            }
            this.totalChanges++;
            if (this.nonZeroChanges >= 4) {
                setResultAndFinish(true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void setResultAndFinish(boolean z) {
        if (this.currentModeSupported != null) {
            return;
        }
        this.currentModeSupported = Boolean.valueOf(z);
        stopAccelerometer();
        Thread thread = this.measureThread;
        if (thread != null) {
            thread.interrupt();
            this.measureThread = null;
        }
    }

    public abstract void doStart();

    public Handler getHandler() {
        return this.h;
    }

    public abstract String getName();

    public int getSensorDelay() {
        return 1;
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public final synchronized void interrupt() {
        try {
            Logger.logInfo("Interrupting detector: " + getName());
            this.interrupted = true;
            Thread thread = this.measureThread;
            if (thread != null) {
                thread.interrupt();
                this.measureThread = null;
            }
            if (this.isAccelStarted) {
                this.accelManager.stop();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isAccelStarted() {
        return this.isAccelStarted;
    }

    public synchronized boolean isScreenOn() {
        return this.isScreenOn;
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public synchronized Boolean isSupported() {
        return this.currentModeSupported;
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public synchronized void onScreenOff() {
        this.isScreenOn = false;
        if (this.interrupted) {
            return;
        }
        if (this.isAccelStarted) {
            startNewMeasuring();
        }
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public synchronized void onScreenOn() {
        this.isScreenOn = true;
        if (this.interrupted) {
            return;
        }
        Thread thread = this.measureThread;
        if (thread != null) {
            thread.interrupt();
            this.measureThread = null;
        }
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public final synchronized void start(boolean z) {
        Logger.logInfo("Starting detector: " + getName());
        this.isScreenOn = z;
        doStart();
    }

    public synchronized void startAccelerometer() {
        if (this.currentModeSupported != null) {
            Logger.logDebug("Ignoring accel start request. Result is already known: " + this.currentModeSupported);
        } else {
            if (this.interrupted) {
                return;
            }
            if (!this.isAccelStarted) {
                this.accelManager.start(getSensorDelay());
                this.isAccelStarted = true;
            }
        }
    }

    public synchronized void startNewMeasuring() {
        int i = 0;
        this.nonZeroChanges = 0;
        this.totalChanges = 0;
        if (this.measureThread == null) {
            Thread thread = new Thread(new MeasureRunnable(this, i));
            this.measureThread = thread;
            thread.start();
        }
    }

    public synchronized void stopAccelerometer() {
        try {
            if (this.isAccelStarted) {
                this.accelManager.stop();
            }
            this.isAccelStarted = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public class MeasureRunnable implements Runnable {
        private MeasureRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.logInfo("Measure runnable started [" + BaseModeDetector.this.getName() + "]");
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(10000L);
                    BaseModeDetector baseModeDetector = BaseModeDetector.this;
                    baseModeDetector.onNewData(baseModeDetector.accelManager.resetChangeNonBatched());
                } catch (InterruptedException unused) {
                    Logger.logInfo("Interrupted measuring of suspension support.");
                    return;
                }
            }
        }

        public /* synthetic */ MeasureRunnable(BaseModeDetector baseModeDetector, int i) {
            this();
        }
    }
}

package com.hecz.player.flex;

import com.hecz.common.tools.Log;
import com.hecz.flex.FlexManager;
import com.hecz.player.GenerateBuffer4Pcmm;
import com.hecz.player.Status;
import com.hecz.serialcommon.commands.CmdGetAD;
import com.hecz.serialcommon.commands.CmdGetTime;
import com.hecz.serialcommon.commands.Command;
import com.hecz.serialcommon.commands.Glasses;
import com.hecz.serialcommon.flex.FlashTab;
import com.hecz.serialcommon.flex.IFlex;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class PcmmPlayer {
    private long actualTime;
    private CmdGetTime cmdGetTime;
    private long endPauseTime;
    private int nextState;
    private long startPauseTime;
    private boolean isGSRMeasuring = true;
    private double nextTime = 0.0d;
    private boolean isLogging = false;
    private int gsrMsInterval = 500;
    private long nextTimeLogging = 0;
    private volatile Status state = new Status();
    private Status prepareStatus = new Status();
    private boolean isComplete = true;
    private CmdGetAD cmdGetAd = null;
    private Measure measure = Measure.AD;
    private int iterRunOnce = 0;
    private double lastftd = 0.0d;
    private boolean isMaxLogging = false;
    private double softLevel = 0.0d;
    private double softDelta = 0.0d;

    /* JADX INFO: renamed from: com.hecz.player.flex.PcmmPlayer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hecz$player$flex$PcmmPlayer$Measure;

        static {
            int[] iArr = new int[Measure.values().length];
            $SwitchMap$com$hecz$player$flex$PcmmPlayer$Measure = iArr;
            try {
                iArr[Measure.AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hecz$player$flex$PcmmPlayer$Measure[Measure.TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum Measure {
        AD,
        TIME
    }

    private void finishFadeOut() {
        this.state.setState(this.nextState);
        Log log = Log.logger;
        Level level = Level.INFO;
        log.log(level, "end of fade out, state = " + this.state);
        IFlex flex = FlexManager.getFlex();
        if (this.state.getState() == 4) {
            flex.sendPause();
        } else if (this.isComplete) {
            flex.sendStop();
        }
        this.isComplete = true;
        this.startPauseTime = System.currentTimeMillis();
        Log.logger.log(level, "startPauseTime = " + this.startPauseTime);
    }

    private boolean isLight() {
        return true;
    }

    private void setFadeOut() {
        this.state.setState(3);
        Log.logger.log(Level.INFO, "state = " + this.state);
    }

    public void pPause() {
        Log.logger.log(Level.INFO, "state = " + this.state);
        setFadeOut();
        this.nextState = 4;
        finishFadeOut();
    }

    public void pPrepare() {
        Double flashTime;
        IFlex flex = FlexManager.getFlex();
        if (flex == null) {
            this.state.setState(0);
            return;
        }
        flex.getFlashTab();
        flex.clearOutStream();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Glasses glasses = Glasses.RGB;
        flex.setTypeOfGlasses(glasses);
        flex.setTypeOfGlasses(glasses);
        flex.setTypeOfGlasses(glasses);
        flex.setTypeOfGlasses(glasses);
        Log.logger.log(Level.INFO, "RGB");
        flex.sendStop();
        flex.sendStop();
        if (this.isLogging) {
            try {
                new DataOutputStream(new FileOutputStream("gsr.dat"));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        int i = 0;
        while (i < 70 && (flashTime = flex.getFlashTab().getFlashTime()) != null) {
            flex.setTime(flashTime.doubleValue() * flex.getDelta(), false);
            i++;
        }
        flex.flush();
        Log log = Log.logger;
        Level level = Level.INFO;
        log.log(level, "write n times from flashtab = " + i);
        this.prepareStatus.setState(1);
        Log.logger.log(level, "state = " + this.prepareStatus);
    }

    public void pStart() {
        Log log = Log.logger;
        Level level = Level.INFO;
        log.log(level, "pStart from " + this.state);
        this.nextTime = 0.0d;
        IFlex flex = FlexManager.getFlex();
        int state = this.state.getState();
        if (state != 0) {
            if (state == 4) {
                this.endPauseTime = System.currentTimeMillis();
                Log.logger.log(level, "endPauseTime=" + this.endPauseTime + ", startPauseTime" + this.startPauseTime + ", FlexManager.startTime=" + flex.getStartTime());
                flex.start('S');
                this.nextState = 2;
                this.state.setState(1);
            } else {
                if (state != 5) {
                    Log.logger.log(Level.WARNING, "undefined status - " + this.state);
                    return;
                }
                if (this.prepareStatus.getState() == 0) {
                    Log.logger.log(Level.WARNING, "STOP - Need to prepare!");
                    return;
                }
                if (isLight() && flex != null) {
                    Log.logger.log(level, "LIGHT SUPER RESTART");
                }
                flex.start('s');
                this.state.setState(this.prepareStatus.getState());
                runOnce();
            }
        } else if (this.prepareStatus.getState() == 0) {
            Log.logger.log(Level.WARNING, "POWER_OFF - Need to prepare!");
            return;
        } else {
            flex.start('s');
            this.state.setState(this.prepareStatus.getState());
            runOnce();
        }
        this.prepareStatus.setState(0);
        Log.logger.log(level, "new state = " + this.state);
        if (!isLight() || flex == null) {
            return;
        }
        Log.logger.log(level, "waker.start() - LIGHT START");
    }

    public void pStop() {
        IFlex flex = FlexManager.getFlex();
        flex.getFlashTab();
        this.state.setState(3);
        runOnce();
        this.state.setState(5);
        flex.sendStop();
    }

    public void runOnce() {
        Double flashTime;
        IFlex flex = FlexManager.getFlex();
        StringBuilder sb = new StringBuilder("");
        int i = this.iterRunOnce;
        this.iterRunOnce = i + 1;
        sb.append(i);
        flex.showValue("runIter", sb.toString());
        FlashTab flashTab = flex.getFlashTab();
        if (this.state.getState() == 3) {
            this.state.setState(7);
            Log.logger.log(Level.INFO, "end of fade out, state = " + this.state);
        }
        if (this.state.getState() == 1) {
            this.state.setState(2);
            Log.logger.log(Level.INFO, "end of fade in, state = " + this.state);
        }
        this.actualTime = System.currentTimeMillis();
        double d = ((-flex.getStartTime()) + this.actualTime) / 1000.0d;
        if (flex.getStartTime() == 0) {
            d = 0.0d;
        }
        flex.showValue("flex.getStartTime()", "" + flex.getStartTime());
        flex.showValue("actualTime", "" + this.actualTime);
        flex.showValue("flex.getDeltaSec()", "" + flex.getDeltaSec());
        if (GenerateBuffer4Pcmm.getInstance() != null && !flashTab.readPcmmBuffer2Time(d)) {
            Log.logger.log(Level.INFO, "dosly data, konec, currTime = " + d);
        }
        for (int i2 = 0; i2 < 70 && (flashTime = flex.getFlashTab().getFlashTime()) != null; i2++) {
            double dDoubleValue = flashTime.doubleValue() * flex.getDelta();
            flex.showValue("flashTime", "" + dDoubleValue);
            flex.setTime(dDoubleValue, false);
        }
        if (this.isGSRMeasuring) {
            if (this.nextTime < this.actualTime) {
                this.nextTime = r6 + ((long) this.gsrMsInterval);
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.actualTime = jCurrentTimeMillis;
                if (this.nextTimeLogging < jCurrentTimeMillis && this.isMaxLogging) {
                    flex.runLogging();
                }
                int i3 = AnonymousClass1.$SwitchMap$com$hecz$player$flex$PcmmPlayer$Measure[this.measure.ordinal()];
                if (i3 == 1) {
                    CmdGetAD cmdGetAD = this.cmdGetAd;
                    if (cmdGetAD == null) {
                        this.cmdGetAd = flex.startReceiveAD();
                        return;
                    } else {
                        if (cmdGetAD == null || cmdGetAD.getStatus() == Command.Status.PROCESSING) {
                            return;
                        }
                        this.cmdGetAd = null;
                        this.measure = Measure.TIME;
                        return;
                    }
                }
                if (i3 != 2) {
                    return;
                }
                CmdGetTime cmdGetTime = this.cmdGetTime;
                if (cmdGetTime == null) {
                    this.cmdGetTime = flex.startReceiveTime();
                } else {
                    if (cmdGetTime == null || cmdGetTime.getStatus() == Command.Status.PROCESSING) {
                        return;
                    }
                    this.cmdGetTime = null;
                    this.measure = Measure.AD;
                }
            }
        }
    }
}

package com.hecz.serialcommon.flex;

import com.hecz.common.logging.Log;
import com.hecz.serialcommon.ISerialConnection;
import com.hecz.serialcommon.SerialDevice;
import com.hecz.serialcommon.commands.CmdGetAD;
import com.hecz.serialcommon.commands.CmdGetTime;
import com.hecz.serialcommon.commands.CmdSendChar;
import com.hecz.serialcommon.commands.CmdSetAdMode;
import com.hecz.serialcommon.commands.CmdSetPwm;
import com.hecz.serialcommon.commands.CmdSetRGB;
import com.hecz.serialcommon.commands.CmdSetTime;
import com.hecz.serialcommon.commands.CmdSetTypeGlasses;
import com.hecz.serialcommon.commands.CmdStart;
import com.hecz.serialcommon.commands.FlexCommandQueue;
import com.hecz.serialcommon.commands.Glasses;
import com.hecz.serialcommon.commands.IHEDevice;
import com.hecz.serialcommon.commands.IReceiveCommandHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class Flex extends SerialDevice implements IFlex, Observer, IHEDevice {
    private static IntensityTab intensityTab = new IntensityTab();
    public static int pulseCounter = 0;
    private double actFr;
    private int ad;
    private short adMode;
    private IReceiveCommandHandler cmdHandler;
    private CmdSetTime cmdSetTime;
    private ISerialConnection connection;
    private IFlexControl controlHandler;
    private int gsr;
    private String gsrStr;
    private int pwm2;
    private double[] deltaArray = new double[10];
    private int nDelta = 0;
    private int iDelta = 0;
    private double delta = 1.0d;
    private double corrDelta = 0.9999674d;
    private double newDelta = 1.0d;
    private double correctTimeInSec = 0.0d;
    private int red = 100;
    private int blue = 100;
    private int green = 100;
    private int lastLightIntensity = 1;
    private TypeOfGlasses typeOfGlasses = TypeOfGlasses.RGB;
    private long startTime = 0;
    private double deltaSec = 0.0d;
    private double pcmmTimeSec = 0.0d;
    private double soundTimeRation = 1.0d;
    private int version = 78;
    private FlexCommandQueue commandQueue = new FlexCommandQueue();

    public enum TypeOfGlasses {
        CC,
        CA,
        RGB
    }

    public Flex(IFlexControl iFlexControl) {
        this.controlHandler = iFlexControl;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void clearOutStream() {
    }

    @Override // com.hecz.serialcommon.flex.IFlex, com.hecz.serialcommon.commands.IHEDevice
    public void flush() {
        try {
            this.connection.getOs().flush();
        } catch (IOException unused) {
            this.connection.close();
        }
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public int getAd() {
        return this.ad;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public short getAdMode() {
        return this.adMode;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public double getDelta() {
        if (Math.abs(this.delta - (this.newDelta / this.soundTimeRation)) > 1.0E-8d) {
            double dAbs = Math.abs(this.delta - (this.newDelta / this.soundTimeRation));
            double d = this.newDelta / this.soundTimeRation;
            if (dAbs > 1.0E-5d) {
                double d2 = this.delta;
                double d3 = 5.0E-4d / (this.pcmmTimeSec + 1.0d);
                if (d > d2) {
                    this.delta = d3 + d2;
                } else {
                    this.delta = d2 - d3;
                }
            } else {
                this.delta = d;
            }
        }
        return this.delta;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public double getDeltaSec() {
        return this.deltaSec;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public FlashTab getFlashTab() {
        return FlashTab.getInstance();
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public int getGSR() {
        return this.gsr;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public int getHWVersion() {
        return this.connection.getVersionInt();
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public OutputStream getOs() {
        return this.connection.getOs();
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public double getTConst() {
        return 9765.625d;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void insert2flashTab(double d, double d2, double d3) {
        FlashTab.getInstance().insert2flashTab(d);
        intensityTab.insert2intensityTab(d, d3);
        setFr(d2);
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public boolean isCommandQueueEmpty() {
        return this.commandQueue.isEmpty();
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void runLogging() {
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void sendChar(char c) {
        this.commandQueue.addCommand(new CmdSendChar(this, c));
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void sendPause() {
        this.commandQueue.addCommand(this.connection.getVersionInt() == 1 ? new CmdSendChar(this, 'P') : new CmdSendChar(this, 'P'), true);
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void sendStop() {
        if (this.connection.getVersionInt() == 1) {
            this.commandQueue.addCommand(new CmdSendChar(this, 'p'), true);
        } else {
            this.commandQueue.addCommand(new CmdSendChar(this, 't'), true);
            this.commandQueue.addCommand(new CmdSendChar(this, '1'), true);
            Log.logger.log(Level.INFO, "send STOP");
        }
        this.startTime = 0L;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setAd(int i) {
        this.ad = i;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setAdMode(short s) {
        if (getAdMode() == s) {
            return;
        }
        this.commandQueue.addCommand(new CmdSetAdMode(this, s));
        this.adMode = s;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setCommnandHandler(IReceiveCommandHandler iReceiveCommandHandler) {
        this.cmdHandler = iReceiveCommandHandler;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void setConnection(ISerialConnection iSerialConnection) {
        this.connection = iSerialConnection;
        iSerialConnection.addSerialEventObserver(this);
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setFlexTime(int i, double d) {
        this.pcmmTimeSec = ((double) i) / getTConst();
        double d2 = ((-getStartTime()) + d) / 1000.0d;
        if (d2 > 30.0d) {
            Log.logger.log(Level.INFO, "correcting");
            double[] dArr = this.deltaArray;
            int i2 = this.iDelta;
            int i3 = i2 + 1;
            this.iDelta = i3;
            dArr[i2] = this.pcmmTimeSec / d2;
            int i4 = 0;
            if (i3 >= 10) {
                this.iDelta = 0;
            }
            int i5 = this.nDelta;
            if (i5 == 10) {
                double d3 = 0.0d;
                double d4 = 100.0d;
                double d5 = 0.0d;
                while (true) {
                    double[] dArr2 = this.deltaArray;
                    if (i4 >= dArr2.length) {
                        break;
                    }
                    double d6 = dArr2[i4];
                    if (d4 > d6) {
                        d4 = d6;
                    }
                    if (d3 < d6) {
                        d3 = d6;
                    }
                    d5 += d6;
                    i4++;
                }
                if (d3 - d4 < 5.0E-5d) {
                    this.newDelta = (this.corrDelta * d5) / 10.0d;
                }
            } else {
                this.nDelta = i5 + 1;
            }
        }
        Math.abs(getDeltaSec() - this.correctTimeInSec);
    }

    public void setFr(double d) {
        this.actFr = d;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setGsr(int i) {
        this.gsr = i;
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setGsrStr(String str) {
        this.gsrStr = str;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void setPwm(int i) {
        if (this.pwm2 != i) {
            this.commandQueue.addCommand(new CmdSetPwm(this, i));
            this.pwm2 = i;
        }
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void setRgb(int i, int i2, int i3) {
        this.red = i;
        this.blue = i3;
        this.green = i2;
        this.commandQueue.addCommand(new CmdSetRGB(this, i, i3, i2));
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void setSoundTimeRatio(double d) {
        if (d > 0.0d) {
            this.soundTimeRation = d;
        }
    }

    @Override // com.hecz.serialcommon.commands.IHEDevice
    public void setStartTime(long j) {
        this.startTime = j;
        Log.logger.log(Level.INFO, "startTime:" + this.startTime);
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void setTime(double d, boolean z) {
        pulseCounter++;
        CmdSetTime cmdSetTime = new CmdSetTime(this, d, z);
        this.cmdSetTime = cmdSetTime;
        this.commandQueue.addCommand(cmdSetTime);
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void setTypeOfGlasses(Glasses glasses) {
        CmdSetTypeGlasses cmdSetTypeGlasses = new CmdSetTypeGlasses(this);
        cmdSetTypeGlasses.setTypeOfGlasses(glasses);
        this.commandQueue.addCommand(cmdSetTypeGlasses);
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void showValue(String str, String str2) {
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public void start(char c) {
        this.commandQueue.addCommand(new CmdStart(this, c), true);
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public CmdGetAD startReceiveAD() {
        CmdGetAD cmdGetAD = new CmdGetAD(this);
        this.commandQueue.addCommand(cmdGetAD);
        return cmdGetAD;
    }

    @Override // com.hecz.serialcommon.flex.IFlex
    public CmdGetTime startReceiveTime() {
        CmdGetTime cmdGetTime = new CmdGetTime(this);
        this.commandQueue.addCommand(cmdGetTime);
        return cmdGetTime;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IReceiveCommandHandler iReceiveCommandHandler = this.cmdHandler;
        if (iReceiveCommandHandler != null) {
            iReceiveCommandHandler.handle(obj);
        }
    }
}

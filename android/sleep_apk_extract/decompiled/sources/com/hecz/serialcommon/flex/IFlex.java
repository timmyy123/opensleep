package com.hecz.serialcommon.flex;

import com.hecz.serialcommon.ISerialConnection;
import com.hecz.serialcommon.commands.CmdGetAD;
import com.hecz.serialcommon.commands.CmdGetTime;
import com.hecz.serialcommon.commands.Glasses;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlex {
    void clearOutStream();

    void flush();

    double getDelta();

    double getDeltaSec();

    FlashTab getFlashTab();

    long getStartTime();

    void insert2flashTab(double d, double d2, double d3);

    boolean isCommandQueueEmpty();

    void runLogging();

    void sendPause();

    void sendStop();

    void setConnection(ISerialConnection iSerialConnection);

    void setPwm(int i);

    void setRgb(int i, int i2, int i3);

    void setSoundTimeRatio(double d);

    void setTime(double d, boolean z);

    void setTypeOfGlasses(Glasses glasses);

    void showValue(String str, String str2);

    void start(char c);

    CmdGetAD startReceiveAD();

    CmdGetTime startReceiveTime();
}

package com.hecz.serialcommon.commands;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public interface IHEDevice {
    void flush();

    int getAd();

    short getAdMode();

    int getGSR();

    int getHWVersion();

    OutputStream getOs();

    double getTConst();

    void sendChar(char c);

    void setAd(int i);

    void setAdMode(short s);

    void setCommnandHandler(IReceiveCommandHandler iReceiveCommandHandler);

    void setFlexTime(int i, double d);

    void setGsr(int i);

    void setGsrStr(String str);

    void setStartTime(long j);
}

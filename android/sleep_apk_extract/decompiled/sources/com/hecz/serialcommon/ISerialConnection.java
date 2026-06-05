package com.hecz.serialcommon;

import java.io.OutputStream;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public interface ISerialConnection {
    void addSerialEventObserver(Observer observer);

    void close();

    OutputStream getOs();

    int getVersionInt();
}

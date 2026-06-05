package com.urbandroid.sleep.service;

import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlashlightService {
    boolean isTurnedOn();

    void surfaceCreated(SurfaceHolder surfaceHolder);

    void surfaceDestroyed();

    void turnOff();

    void turnOn();
}

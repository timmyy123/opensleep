package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorEnvironmentInfo {
    private final String handlerQueue;
    private final int hardKeyboardHidden;
    private final boolean isEmulator;
    private final int keyboardHidden;
    private final String localeName;
    private final int mcc;
    private final int mnc;
    private final int orientation;

    public ErrorEnvironmentInfo(String str, int i, int i2, int i3, int i4, int i5, String str2, boolean z) {
        this.localeName = str;
        this.orientation = i;
        this.keyboardHidden = i2;
        this.hardKeyboardHidden = i3;
        this.mnc = i4;
        this.mcc = i5;
        this.handlerQueue = str2;
        this.isEmulator = z;
    }

    public String getHandlerQueue() {
        return this.handlerQueue;
    }

    public int getHardKeyboardHidden() {
        return this.hardKeyboardHidden;
    }

    public int getKeyboardHidden() {
        return this.keyboardHidden;
    }

    public String getLocaleName() {
        return this.localeName;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isEmulator() {
        return this.isEmulator;
    }
}

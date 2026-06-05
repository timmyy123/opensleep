package com.urbandroid.sleep.smartwatch.phaser.protocol;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Status {
    public final int status;

    public Status(int i) {
        this.status = i;
    }

    public boolean isActigraphyOn() {
        return (this.status & 1) > 0;
    }

    public boolean isLightOn() {
        return (this.status & 4) > 0;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(this.status, "}", new StringBuilder("Status{status="));
    }
}

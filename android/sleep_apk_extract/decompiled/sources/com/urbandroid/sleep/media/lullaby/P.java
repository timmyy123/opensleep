package com.urbandroid.sleep.media.lullaby;

/* JADX INFO: loaded from: classes.dex */
public class P {
    public int from;
    public int repeat;
    public int to;

    public P(int i, int i2, int i3) {
        this.from = i;
        this.to = i2;
        this.repeat = i3;
    }

    public static P f(int i, int i2, int i3) {
        return new P(i, i2, i3);
    }

    public static P f(int i, int i2) {
        return new P(i, i, i2);
    }
}

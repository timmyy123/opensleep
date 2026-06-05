package com.urbandroid.sleep.snoring.feature;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Interval {
    public final int endExcl;
    public final int start;

    public Interval(int i, int i2) {
        if (i >= i2) {
            Events$$ExternalSyntheticBUOutline0.m$1(i, i2, ">");
            throw null;
        }
        this.start = i;
        this.endExcl = i2;
    }

    public int length() {
        return this.endExcl - this.start;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.start);
        sb.append(",");
        return FileInsert$$ExternalSyntheticOutline0.m(this.endExcl, ")", sb);
    }
}

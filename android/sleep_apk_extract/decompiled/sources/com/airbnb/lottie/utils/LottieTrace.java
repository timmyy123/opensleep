package com.airbnb.lottie.utils;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.core.os.TraceCompat;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class LottieTrace {
    private final String[] sections = new String[5];
    private final long[] startTimeNs = new long[5];
    private int traceDepth = 0;
    private int depthPastMaxDepth = 0;

    public void beginSection(String str) {
        int i = this.traceDepth;
        if (i == 5) {
            this.depthPastMaxDepth++;
            return;
        }
        this.sections[i] = str;
        this.startTimeNs[i] = System.nanoTime();
        TraceCompat.beginSection(str);
        this.traceDepth++;
    }

    public float endSection(String str) {
        int i = this.depthPastMaxDepth;
        if (i > 0) {
            this.depthPastMaxDepth = i - 1;
            return 0.0f;
        }
        int i2 = this.traceDepth - 1;
        this.traceDepth = i2;
        if (i2 == -1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Can't end trace section. There are none.");
            return 0.0f;
        }
        if (str.equals(this.sections[i2])) {
            TraceCompat.endSection();
            return (System.nanoTime() - this.startTimeNs[this.traceDepth]) / 1000000.0f;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m5m("Unbalanced trace call ", str, ". Expected "), this.sections[this.traceDepth], "."));
        return 0.0f;
    }
}

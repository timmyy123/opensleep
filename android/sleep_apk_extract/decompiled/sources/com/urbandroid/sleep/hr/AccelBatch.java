package com.urbandroid.sleep.hr;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/hr/AccelBatch;", "", "", "sampleRate", "", "deviceTimestampMillis", "localTimestampMillis", "", "Lcom/urbandroid/sleep/hr/AccelBatch$Point;", "points", "<init>", "(IJJLjava/util/List;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getSampleRate", "()I", "J", "getDeviceTimestampMillis", "()J", "getLocalTimestampMillis", "Ljava/util/List;", "getPoints", "()Ljava/util/List;", "Point", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AccelBatch {
    private final long deviceTimestampMillis;
    private final long localTimestampMillis;
    private final List<Point> points;
    private final int sampleRate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/hr/AccelBatch$Point;", "", "x", "", "y", "z", "<init>", "(FFF)V", "getX", "()F", "getY", "getZ", InAppPurchaseConstants.METHOD_TO_STRING, "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Point {
        private final float x;
        private final float y;
        private final float z;

        public Point(float f, float f2, float f3) {
            this.x = f;
            this.y = f2;
            this.z = f3;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public final float getZ() {
            return this.z;
        }

        public String toString() {
            return "[" + this.x + ", " + this.y + ", " + this.z + "]";
        }
    }

    public AccelBatch(int i, long j, long j2, List<Point> list) {
        list.getClass();
        this.sampleRate = i;
        this.deviceTimestampMillis = j;
        this.localTimestampMillis = j2;
        this.points = list;
    }

    public final long getLocalTimestampMillis() {
        return this.localTimestampMillis;
    }

    public final List<Point> getPoints() {
        return this.points;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public String toString() {
        int i = this.sampleRate;
        long j = this.deviceTimestampMillis;
        long j2 = this.localTimestampMillis;
        List<Point> list = this.points;
        StringBuilder sb = new StringBuilder("AccelBatch(sampleRate=");
        sb.append(i);
        sb.append(", deviceTimestampMillis=");
        sb.append(j);
        zzba$$ExternalSyntheticOutline0.m(sb, ", localTimestampMillis=", j2, ", points=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }
}

package com.polar.sdk.api.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/polar/sdk/api/model/PolarAccelerometerData;", "", "", "Lcom/polar/sdk/api/model/PolarAccelerometerData$PolarAccelerometerDataSample;", "samples", "<init>", "(Ljava/util/List;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSamples", "()Ljava/util/List;", "PolarAccelerometerDataSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PolarAccelerometerData {
    private final List<PolarAccelerometerDataSample> samples;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/polar/sdk/api/model/PolarAccelerometerData$PolarAccelerometerDataSample;", "", "", "timeStamp", "", "x", "y", "z", "<init>", "(JIII)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp", "()J", "I", "getX", "getY", "getZ", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PolarAccelerometerDataSample {
        private final long timeStamp;
        private final int x;
        private final int y;
        private final int z;

        public PolarAccelerometerDataSample(long j, int i, int i2, int i3) {
            this.timeStamp = j;
            this.x = i;
            this.y = i2;
            this.z = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PolarAccelerometerDataSample)) {
                return false;
            }
            PolarAccelerometerDataSample polarAccelerometerDataSample = (PolarAccelerometerDataSample) other;
            return this.timeStamp == polarAccelerometerDataSample.timeStamp && this.x == polarAccelerometerDataSample.x && this.y == polarAccelerometerDataSample.y && this.z == polarAccelerometerDataSample.z;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }

        public final int getZ() {
            return this.z;
        }

        public int hashCode() {
            return Integer.hashCode(this.z) + FileInsert$$ExternalSyntheticOutline0.m(this.y, FileInsert$$ExternalSyntheticOutline0.m(this.x, Long.hashCode(this.timeStamp) * 31, 31), 31);
        }

        public String toString() {
            long j = this.timeStamp;
            int i = this.x;
            int i2 = this.y;
            int i3 = this.z;
            StringBuilder sb = new StringBuilder("PolarAccelerometerDataSample(timeStamp=");
            sb.append(j);
            sb.append(", x=");
            sb.append(i);
            Fragment$$ExternalSyntheticOutline1.m(sb, ", y=", i2, ", z=", i3);
            sb.append(")");
            return sb.toString();
        }
    }

    public PolarAccelerometerData(List<PolarAccelerometerDataSample> list) {
        list.getClass();
        this.samples = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PolarAccelerometerData) && Intrinsics.areEqual(this.samples, ((PolarAccelerometerData) other).samples);
    }

    public final List<PolarAccelerometerDataSample> getSamples() {
        return this.samples;
    }

    public int hashCode() {
        return this.samples.hashCode();
    }

    public String toString() {
        return "PolarAccelerometerData(samples=" + this.samples + ")";
    }
}

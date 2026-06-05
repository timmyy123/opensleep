package com.polar.sdk.api.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/polar/sdk/api/model/PolarHrData;", "", "", "Lcom/polar/sdk/api/model/PolarHrData$PolarHrSample;", "samples", "<init>", "(Ljava/util/List;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSamples", "()Ljava/util/List;", "PolarHrSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PolarHrData {
    private final List<PolarHrSample> samples;

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b!\u0010\u001f¨\u0006\""}, d2 = {"Lcom/polar/sdk/api/model/PolarHrData$PolarHrSample;", "", "", "hr", "correctedHr", "ppgQuality", "", "rrsMs", "", "rrAvailable", "contactStatus", "contactStatusSupported", "<init>", "(IIILjava/util/List;ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getHr", "getCorrectedHr", "getPpgQuality", "Ljava/util/List;", "getRrsMs", "()Ljava/util/List;", "Z", "getRrAvailable", "()Z", "getContactStatus", "getContactStatusSupported", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PolarHrSample {
        private final boolean contactStatus;
        private final boolean contactStatusSupported;
        private final int correctedHr;
        private final int hr;
        private final int ppgQuality;
        private final boolean rrAvailable;
        private final List<Integer> rrsMs;

        public PolarHrSample(int i, int i2, int i3, List<Integer> list, boolean z, boolean z2, boolean z3) {
            list.getClass();
            this.hr = i;
            this.correctedHr = i2;
            this.ppgQuality = i3;
            this.rrsMs = list;
            this.rrAvailable = z;
            this.contactStatus = z2;
            this.contactStatusSupported = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PolarHrSample)) {
                return false;
            }
            PolarHrSample polarHrSample = (PolarHrSample) other;
            return this.hr == polarHrSample.hr && this.correctedHr == polarHrSample.correctedHr && this.ppgQuality == polarHrSample.ppgQuality && Intrinsics.areEqual(this.rrsMs, polarHrSample.rrsMs) && this.rrAvailable == polarHrSample.rrAvailable && this.contactStatus == polarHrSample.contactStatus && this.contactStatusSupported == polarHrSample.contactStatusSupported;
        }

        public final boolean getContactStatus() {
            return this.contactStatus;
        }

        public final boolean getContactStatusSupported() {
            return this.contactStatusSupported;
        }

        public final int getHr() {
            return this.hr;
        }

        public final List<Integer> getRrsMs() {
            return this.rrsMs;
        }

        public int hashCode() {
            return Boolean.hashCode(this.contactStatusSupported) + FileInsert$$ExternalSyntheticOutline0.m(this.contactStatus, FileInsert$$ExternalSyntheticOutline0.m(this.rrAvailable, FileInsert$$ExternalSyntheticOutline0.m((List) this.rrsMs, FileInsert$$ExternalSyntheticOutline0.m(this.ppgQuality, FileInsert$$ExternalSyntheticOutline0.m(this.correctedHr, Integer.hashCode(this.hr) * 31, 31), 31), 31), 31), 31);
        }

        public String toString() {
            int i = this.hr;
            int i2 = this.correctedHr;
            int i3 = this.ppgQuality;
            List<Integer> list = this.rrsMs;
            boolean z = this.rrAvailable;
            boolean z2 = this.contactStatus;
            boolean z3 = this.contactStatusSupported;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "PolarHrSample(hr=", ", correctedHr=", ", ppgQuality=");
            sbM.append(i3);
            sbM.append(", rrsMs=");
            sbM.append(list);
            sbM.append(", rrAvailable=");
            sbM.append(z);
            sbM.append(", contactStatus=");
            sbM.append(z2);
            sbM.append(", contactStatusSupported=");
            sbM.append(z3);
            sbM.append(")");
            return sbM.toString();
        }
    }

    public PolarHrData(List<PolarHrSample> list) {
        list.getClass();
        this.samples = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PolarHrData) && Intrinsics.areEqual(this.samples, ((PolarHrData) other).samples);
    }

    public final List<PolarHrSample> getSamples() {
        return this.samples;
    }

    public int hashCode() {
        return this.samples.hashCode();
    }

    public String toString() {
        return "PolarHrData(samples=" + this.samples + ")";
    }
}

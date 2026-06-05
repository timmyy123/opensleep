package com.polar.sdk.api.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/polar/sdk/api/model/PolarPpiData;", "", "", "Lcom/polar/sdk/api/model/PolarPpiData$PolarPpiSample;", "samples", "<init>", "(Ljava/util/List;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSamples", "()Ljava/util/List;", "PolarPpiSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PolarPpiData {
    private final List<PolarPpiSample> samples;

    public PolarPpiData(List<PolarPpiSample> list) {
        list.getClass();
        this.samples = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PolarPpiData) && Intrinsics.areEqual(this.samples, ((PolarPpiData) other).samples);
    }

    public final List<PolarPpiSample> getSamples() {
        return this.samples;
    }

    public int hashCode() {
        return this.samples.hashCode();
    }

    public String toString() {
        return "PolarPpiData(samples=" + this.samples + ")";
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001d\u0010\u000b\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Lcom/polar/sdk/api/model/PolarPpiData$PolarPpiSample;", "", "", "ppi", "errorEstimate", "hr", "", "blockerBit", "skinContactStatus", "skinContactSupported", "Lkotlin/ULong;", "timeStamp", "<init>", "(IIIZZZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getPpi", "getErrorEstimate", "getHr", "Z", "getBlockerBit", "()Z", "getSkinContactStatus", "getSkinContactSupported", "J", "getTimeStamp-s-VKNKU", "()J", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PolarPpiSample {
        private final boolean blockerBit;
        private final int errorEstimate;
        private final int hr;
        private final int ppi;
        private final boolean skinContactStatus;
        private final boolean skinContactSupported;
        private final long timeStamp;

        private PolarPpiSample(int i, int i2, int i3, boolean z, boolean z2, boolean z3, long j) {
            this.ppi = i;
            this.errorEstimate = i2;
            this.hr = i3;
            this.blockerBit = z;
            this.skinContactStatus = z2;
            this.skinContactSupported = z3;
            this.timeStamp = j;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PolarPpiSample)) {
                return false;
            }
            PolarPpiSample polarPpiSample = (PolarPpiSample) other;
            return this.ppi == polarPpiSample.ppi && this.errorEstimate == polarPpiSample.errorEstimate && this.hr == polarPpiSample.hr && this.blockerBit == polarPpiSample.blockerBit && this.skinContactStatus == polarPpiSample.skinContactStatus && this.skinContactSupported == polarPpiSample.skinContactSupported && this.timeStamp == polarPpiSample.timeStamp;
        }

        public final int getPpi() {
            return this.ppi;
        }

        public final boolean getSkinContactStatus() {
            return this.skinContactStatus;
        }

        public final boolean getSkinContactSupported() {
            return this.skinContactSupported;
        }

        public int hashCode() {
            return ULong.m2413hashCodeimpl(this.timeStamp) + FileInsert$$ExternalSyntheticOutline0.m(this.skinContactSupported, FileInsert$$ExternalSyntheticOutline0.m(this.skinContactStatus, FileInsert$$ExternalSyntheticOutline0.m(this.blockerBit, FileInsert$$ExternalSyntheticOutline0.m(this.hr, FileInsert$$ExternalSyntheticOutline0.m(this.errorEstimate, Integer.hashCode(this.ppi) * 31, 31), 31), 31), 31), 31);
        }

        public String toString() {
            int i = this.ppi;
            int i2 = this.errorEstimate;
            int i3 = this.hr;
            boolean z = this.blockerBit;
            boolean z2 = this.skinContactStatus;
            boolean z3 = this.skinContactSupported;
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "PolarPpiSample(ppi=", ", errorEstimate=", ", hr=");
            sbM.append(i3);
            sbM.append(", blockerBit=");
            sbM.append(z);
            sbM.append(", skinContactStatus=");
            sbM.append(z2);
            sbM.append(", skinContactSupported=");
            sbM.append(z3);
            sbM.append(", timeStamp=");
            return FileInsert$$ExternalSyntheticOutline0.m(sbM, strM2414toStringimpl, ")");
        }

        public /* synthetic */ PolarPpiSample(int i, int i2, int i3, boolean z, boolean z2, boolean z3, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3, z, z2, z3, j);
        }
    }
}

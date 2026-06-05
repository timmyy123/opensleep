package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import com.polar.androidcommunications.common.ble.TypeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData;", "", "()V", "ppiSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData$PpiSample;", "getPpiSamples", "()Ljava/util/List;", "Companion", "PpiSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PpiData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<PpiSample> ppiSamples = new ArrayList();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData$Companion;", "", "()V", "dataFromType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PmdDataFrame.PmdDataFrameType.values().length];
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_0.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PpiData dataFromType0(PmdDataFrame frame) {
            PpiData ppiData = new PpiData();
            int i = 0;
            while (i < frame.getDataContent().length) {
                int i2 = i + 6;
                byte[] bArrCopyOfRange = ArraysKt.copyOfRange(frame.getDataContent(), i, i2);
                int i3 = bArrCopyOfRange[0] & 255;
                TypeUtils typeUtils = TypeUtils.INSTANCE;
                int iM899convertArrayToUnsignedLongqJGtvoU = (int) typeUtils.m899convertArrayToUnsignedLongqJGtvoU(bArrCopyOfRange, 1, 2);
                int iM899convertArrayToUnsignedLongqJGtvoU2 = (int) typeUtils.m899convertArrayToUnsignedLongqJGtvoU(bArrCopyOfRange, 3, 2);
                byte b = bArrCopyOfRange[5];
                ppiData.getPpiSamples().add(new PpiSample(i3, iM899convertArrayToUnsignedLongqJGtvoU, iM899convertArrayToUnsignedLongqJGtvoU2, b & 1, (b & 2) >> 1, (b & 4) >> 2, 0L, null));
                i = i2;
            }
            if (frame.getTimeStamp() != 0) {
                long timeStamp = frame.getTimeStamp();
                int size = ppiData.getPpiSamples().size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i4 = size - 1;
                        ppiData.getPpiSamples().get(size).m892setTimeStampVKZWuLQ(timeStamp);
                        timeStamp = ULong.m2411constructorimpl(timeStamp - ULong.m2411constructorimpl(ULong.m2411constructorimpl(r15.getPpInMs()) * 1000000));
                        if (i4 < 0) {
                            break;
                        }
                        size = i4;
                    }
                }
            }
            return ppiData;
        }

        public final PpiData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (frame.getIsCompressedFrame()) {
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by PPI data parser"));
            }
            if (WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()] == 1) {
                return dataFromType0(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by PPI data parser"));
        }

        private Companion() {
        }
    }

    public final List<PpiSample> getPpiSamples() {
        return this.ppiSamples;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0016\u0010\u0016\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000eJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b$\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b%\u0010\u000eR(\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010)\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData$PpiSample;", "", "", "hr", "ppInMs", "ppErrorEstimate", "blockerBit", "skinContactStatus", "skinContactSupported", "Lkotlin/ULong;", "timeStamp", "<init>", "(IIIIIIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1", "()I", "component2", "component3", "component4", "component5", "component6", "component7-s-VKNKU", "()J", "component7", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getHr", "getPpInMs", "getPpErrorEstimate", "getBlockerBit", "getSkinContactStatus", "getSkinContactSupported", "J", "getTimeStamp-s-VKNKU", "setTimeStamp-VKZWuLQ", "(J)V", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpiSample {
        private final int blockerBit;
        private final int hr;
        private final int ppErrorEstimate;
        private final int ppInMs;
        private final int skinContactStatus;
        private final int skinContactSupported;
        private long timeStamp;

        private PpiSample(int i, int i2, int i3, int i4, int i5, int i6, long j) {
            this.hr = i;
            this.ppInMs = i2;
            this.ppErrorEstimate = i3;
            this.blockerBit = i4;
            this.skinContactStatus = i5;
            this.skinContactSupported = i6;
            this.timeStamp = j;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getHr() {
            return this.hr;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPpInMs() {
            return this.ppInMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPpErrorEstimate() {
            return this.ppErrorEstimate;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getBlockerBit() {
            return this.blockerBit;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getSkinContactStatus() {
            return this.skinContactStatus;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getSkinContactSupported() {
            return this.skinContactSupported;
        }

        /* JADX INFO: renamed from: component7-s-VKNKU, reason: not valid java name and from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpiSample)) {
                return false;
            }
            PpiSample ppiSample = (PpiSample) other;
            return this.hr == ppiSample.hr && this.ppInMs == ppiSample.ppInMs && this.ppErrorEstimate == ppiSample.ppErrorEstimate && this.blockerBit == ppiSample.blockerBit && this.skinContactStatus == ppiSample.skinContactStatus && this.skinContactSupported == ppiSample.skinContactSupported && this.timeStamp == ppiSample.timeStamp;
        }

        public final int getPpInMs() {
            return this.ppInMs;
        }

        public int hashCode() {
            return ULong.m2413hashCodeimpl(this.timeStamp) + FileInsert$$ExternalSyntheticOutline0.m(this.skinContactSupported, FileInsert$$ExternalSyntheticOutline0.m(this.skinContactStatus, FileInsert$$ExternalSyntheticOutline0.m(this.blockerBit, FileInsert$$ExternalSyntheticOutline0.m(this.ppErrorEstimate, FileInsert$$ExternalSyntheticOutline0.m(this.ppInMs, Integer.hashCode(this.hr) * 31, 31), 31), 31), 31), 31);
        }

        /* JADX INFO: renamed from: setTimeStamp-VKZWuLQ, reason: not valid java name */
        public final void m892setTimeStampVKZWuLQ(long j) {
            this.timeStamp = j;
        }

        public String toString() {
            int i = this.hr;
            int i2 = this.ppInMs;
            int i3 = this.ppErrorEstimate;
            int i4 = this.blockerBit;
            int i5 = this.skinContactStatus;
            int i6 = this.skinContactSupported;
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "PpiSample(hr=", ", ppInMs=", ", ppErrorEstimate=");
            Fragment$$ExternalSyntheticOutline1.m(sbM, i3, ", blockerBit=", i4, ", skinContactStatus=");
            Fragment$$ExternalSyntheticOutline1.m(sbM, i5, ", skinContactSupported=", i6, ", timeStamp=");
            return FileInsert$$ExternalSyntheticOutline0.m(sbM, strM2414toStringimpl, ")");
        }

        public /* synthetic */ PpiSample(int i, int i2, int i3, int i4, int i5, int i6, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3, i4, i5, i6, j);
        }
    }
}

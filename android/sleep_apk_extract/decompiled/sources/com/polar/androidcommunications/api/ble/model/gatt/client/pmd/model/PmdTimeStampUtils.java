package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.exceptions.NegativeTimeStampError;
import com.polar.androidcommunications.api.ble.exceptions.SampleSizeMissingError;
import com.polar.androidcommunications.api.ble.exceptions.TimeStampAndFrequencyZeroError;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PmdTimeStampUtils;", "", "()V", "deltaFromSamplingRate", "", "samplingRate", "", "deltaFromTimeStamps", "previousTimeStamp", "Lkotlin/ULong;", "timeStamp", "samples", "deltaFromTimeStamps-twO9MuI", "(JJI)D", "firstSampleTimeFromSampleRate", "lastSampleTimeStamp", "timeStampDelta", "samplesSize", "firstSampleTimeFromSampleRate-E0BElUM", "(JDI)D", "firstSampleTimeFromTimeStamps", "firstSampleTimeFromTimeStamps-4PLdz1A", "(JD)D", "getTimeStampDelta", "previousFrameTimeStamp", "sampleRate", "getTimeStampDelta-x53JL5M", "(JJII)D", "getTimeStamps", "", "frameTimeStamp", "getTimeStamps-x53JL5M", "(JJII)Ljava/util/List;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdTimeStampUtils {
    public static final PmdTimeStampUtils INSTANCE = new PmdTimeStampUtils();

    private PmdTimeStampUtils() {
    }

    /* JADX INFO: renamed from: firstSampleTimeFromSampleRate-E0BElUM, reason: not valid java name */
    private final double m886firstSampleTimeFromSampleRateE0BElUM(long lastSampleTimeStamp, double timeStampDelta, int samplesSize) throws NegativeTimeStampError {
        if (samplesSize <= 0) {
            String strM2414toStringimpl = ULong.m2414toStringimpl(lastSampleTimeStamp);
            StringBuilder sb = new StringBuilder("Failed to estimate first sample timestamp when timeStamp: ");
            sb.append(strM2414toStringimpl);
            sb.append(" delta: ");
            sb.append(timeStampDelta);
            throw new NegativeTimeStampError(zzba$$ExternalSyntheticOutline0.m(samplesSize, " size: ", sb));
        }
        double dUlongToDouble = UnsignedKt.ulongToDouble(lastSampleTimeStamp) - (((double) (samplesSize - 1)) * timeStampDelta);
        if (dUlongToDouble > 0.0d) {
            return dUlongToDouble;
        }
        String strM2414toStringimpl2 = ULong.m2414toStringimpl(lastSampleTimeStamp);
        StringBuilder sb2 = new StringBuilder("Failed to estimate first sample timestamp when timeStamp: ");
        sb2.append(strM2414toStringimpl2);
        sb2.append(" delta: ");
        sb2.append(timeStampDelta);
        throw new NegativeTimeStampError(zzba$$ExternalSyntheticOutline0.m(samplesSize, " size: ", sb2));
    }

    /* JADX INFO: renamed from: firstSampleTimeFromTimeStamps-4PLdz1A, reason: not valid java name */
    private final double m887firstSampleTimeFromTimeStamps4PLdz1A(long previousTimeStamp, double timeStampDelta) {
        return UnsignedKt.ulongToDouble(previousTimeStamp) + timeStampDelta;
    }

    /* JADX INFO: renamed from: getTimeStampDelta-x53JL5M, reason: not valid java name */
    private final double m888getTimeStampDeltax53JL5M(long previousFrameTimeStamp, long timeStamp, int samplesSize, int sampleRate) throws TimeStampAndFrequencyZeroError {
        if (previousFrameTimeStamp != 0 || sampleRate > 0) {
            return previousFrameTimeStamp == 0 ? deltaFromSamplingRate(sampleRate) : m889deltaFromTimeStampstwO9MuI(previousFrameTimeStamp, timeStamp, samplesSize);
        }
        throw new TimeStampAndFrequencyZeroError("Timestamp delta cannot be calculated for the frame, because previousTimeStamp " + ULong.m2414toStringimpl(previousFrameTimeStamp) + " and sampleRate " + sampleRate);
    }

    public final double deltaFromSamplingRate(int samplingRate) {
        return (1.0d / ((double) samplingRate)) * 1000.0d * 1000.0d * 1000.0d;
    }

    /* JADX INFO: renamed from: deltaFromTimeStamps-twO9MuI, reason: not valid java name */
    public final double m889deltaFromTimeStampstwO9MuI(long previousTimeStamp, long timeStamp, int samples) throws NegativeTimeStampError {
        long jM2411constructorimpl = ULong.m2411constructorimpl(timeStamp - previousTimeStamp);
        if (Long.compare(jM2411constructorimpl ^ Long.MIN_VALUE, ULong.m2411constructorimpl(0L) ^ Long.MIN_VALUE) > 0) {
            return UnsignedKt.ulongToDouble(jM2411constructorimpl) / ((double) samples);
        }
        throw new NegativeTimeStampError(Fragment$$ExternalSyntheticOutline1.m("Failed to decide delta from when previous timestamp: ", ULong.m2414toStringimpl(previousTimeStamp), " timestamp: ", ULong.m2414toStringimpl(timeStamp)));
    }

    /* JADX INFO: renamed from: getTimeStamps-x53JL5M, reason: not valid java name */
    public final List<ULong> m890getTimeStampsx53JL5M(long previousFrameTimeStamp, long frameTimeStamp, int samplesSize, int sampleRate) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
        double d;
        double dM887firstSampleTimeFromTimeStamps4PLdz1A;
        if (samplesSize <= 0) {
            throw SampleSizeMissingError.INSTANCE;
        }
        double dM888getTimeStampDeltax53JL5M = m888getTimeStampDeltax53JL5M(previousFrameTimeStamp, frameTimeStamp, samplesSize, sampleRate);
        double d2 = ((double) samplesSize) * dM888getTimeStampDeltax53JL5M;
        if (UnsignedKt.ulongToDouble(frameTimeStamp) < d2) {
            throw new NegativeTimeStampError("Sample time stamp calculation fails. The timestamps are negative, since frameTimeStamp " + ULong.m2414toStringimpl(frameTimeStamp) + " minus " + d2 + " is negative");
        }
        if (previousFrameTimeStamp == 0) {
            d = dM888getTimeStampDeltax53JL5M;
            dM887firstSampleTimeFromTimeStamps4PLdz1A = m886firstSampleTimeFromSampleRateE0BElUM(frameTimeStamp, d, samplesSize);
        } else {
            d = dM888getTimeStampDeltax53JL5M;
            dM887firstSampleTimeFromTimeStamps4PLdz1A = m887firstSampleTimeFromTimeStamps4PLdz1A(previousFrameTimeStamp, d);
        }
        int i = samplesSize - 1;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(ULong.m2410boximpl(UnsignedKt.doubleToULong(Math.rint((((double) i2) * d) + dM887firstSampleTimeFromTimeStamps4PLdz1A))));
        }
        arrayList.add(ULong.m2410boximpl(frameTimeStamp));
        return arrayList;
    }
}

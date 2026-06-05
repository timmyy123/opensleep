package com.urbandroid.sleep.sensor.respiration.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.newfftresult.FftResultRaw;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.jtransforms.fft.FloatFFT_1D;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001MB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\u001cJ\u001f\u0010\"\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010#\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010(R\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010*R\u0014\u00100\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u0010*R\u0014\u00101\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u0010*R\u0014\u00102\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u0010*R\u0014\u00103\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u0010*R\u0014\u00104\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b4\u0010*R\u0014\u00105\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010*R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0017068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0017068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108R\u001f\u0010<\u001a\n ;*\u0004\u0018\u00010:0:8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010%\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0017\u0010F\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010J\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010IR\u001c\u0010L\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010=¨\u0006N"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/v2/RespiratoryDetectorV21;", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "", "sampleRate", "Lcom/urbandroid/sleep/sensor/respiration/v2/Clock;", "clock", "Lcom/urbandroid/sleep/sensor/respiration/v2/BreathLogger;", "breathLog", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$RespiratoryListener;", "listener", "<init>", "(FLcom/urbandroid/sleep/sensor/respiration/v2/Clock;Lcom/urbandroid/sleep/sensor/respiration/v2/BreathLogger;Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$RespiratoryListener;)V", "", "data", "", "activity", "", "processFirstData", "([FI)V", "processNextData", "doProcess", "removePeaks", "([F)[F", "Lcom/urbandroid/sleep/sensor/respiration/v2/RespiratoryDetectorV21$BreathEvent;", "event", "detectHighActivity", "(Lcom/urbandroid/sleep/sensor/respiration/v2/RespiratoryDetectorV21$BreathEvent;[F)V", "detectBreath", "()V", "detectApnea", "Lcom/urbandroid/sleep/snoring/newfftresult/FftResult;", "fft", "([F)Lcom/urbandroid/sleep/snoring/newfftresult/FftResult;", "logDetailedResults", "detect", "dataBroken", "trackingFinished", "F", "Lcom/urbandroid/sleep/sensor/respiration/v2/Clock;", "Lcom/urbandroid/sleep/sensor/respiration/v2/BreathLogger;", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$RespiratoryListener;", "RESP_RATE_FROM", "I", "RESP_RATE_TO", "", "firstCall", "Z", "expectedDataSize", "BREATH_HISTORY", "BREATH_QUORUM_1", "BREATH_QUORUM_2", "APNEA_HISTORY", "APNEA_BREATH_QUORUM", "MAX_HISTORY", "", "history", "Ljava/util/List;", "allHistory", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "kotlin.jvm.PlatformType", "avgSignalToNoiseRatio", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "getAvgSignalToNoiseRatio", "()Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "currentAvgSignalToNoiseRatio", "getCurrentAvgSignalToNoiseRatio", "()F", "setCurrentAvgSignalToNoiseRatio", "(F)V", "Lcom/urbandroid/sleep/sensor/respiration/v2/FloatArrayBuffer;", "medianBuffer", "Lcom/urbandroid/sleep/sensor/respiration/v2/FloatArrayBuffer;", "getMedianBuffer", "()Lcom/urbandroid/sleep/sensor/respiration/v2/FloatArrayBuffer;", "thresholdBuffer", "getThresholdBuffer", "lowActivity", "BreathEvent", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RespiratoryDetectorV21 implements RespiratoryDetector {
    private final int APNEA_BREATH_QUORUM;
    private final int APNEA_HISTORY;
    private final int BREATH_HISTORY;
    private final int BREATH_QUORUM_1;
    private final int BREATH_QUORUM_2;
    private final int MAX_HISTORY;
    private final int RESP_RATE_FROM;
    private final int RESP_RATE_TO;
    private final List<BreathEvent> allHistory;
    private final FloatFunction avgSignalToNoiseRatio;
    private final BreathLogger breathLog;
    private final Clock clock;
    private float currentAvgSignalToNoiseRatio;
    private int expectedDataSize;
    private boolean firstCall;
    private final List<BreathEvent> history;
    private final RespiratoryDetector.RespiratoryListener listener;
    private final FloatFunction lowActivity;
    private final FloatArrayBuffer medianBuffer;
    private final float sampleRate;
    private final FloatArrayBuffer thresholdBuffer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/v2/RespiratoryDetectorV21$BreathEvent;", "", "timestamp", "", "respRate", "", "<init>", "(JI)V", "getTimestamp", "()J", "getRespRate", "()I", "isHighActivity", "", "()Z", "setHighActivity", "(Z)V", "resolvedAsBreath", "getResolvedAsBreath", "setResolvedAsBreath", "resolvedAsApnea", "getResolvedAsApnea", "setResolvedAsApnea", "isValidRespRate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BreathEvent {
        private boolean isHighActivity;
        private boolean resolvedAsApnea;
        private boolean resolvedAsBreath;
        private final int respRate;
        private final long timestamp;

        public BreathEvent(long j, int i) {
            this.timestamp = j;
            this.respRate = i;
        }

        public final boolean getResolvedAsApnea() {
            return this.resolvedAsApnea;
        }

        public final boolean getResolvedAsBreath() {
            return this.resolvedAsBreath;
        }

        public final int getRespRate() {
            return this.respRate;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: isHighActivity, reason: from getter */
        public final boolean getIsHighActivity() {
            return this.isHighActivity;
        }

        public final boolean isValidRespRate() {
            return this.respRate > 0;
        }

        public final void setHighActivity(boolean z) {
            this.isHighActivity = z;
        }

        public final void setResolvedAsApnea(boolean z) {
            this.resolvedAsApnea = z;
        }

        public final void setResolvedAsBreath(boolean z) {
            this.resolvedAsBreath = z;
        }
    }

    public RespiratoryDetectorV21(float f, Clock clock, BreathLogger breathLogger, RespiratoryDetector.RespiratoryListener respiratoryListener) {
        clock.getClass();
        this.sampleRate = f;
        this.clock = clock;
        this.breathLog = breathLogger;
        this.listener = respiratoryListener;
        this.RESP_RATE_FROM = 8;
        this.RESP_RATE_TO = 20;
        this.firstCall = true;
        this.BREATH_HISTORY = 10;
        this.BREATH_QUORUM_1 = 6;
        this.BREATH_QUORUM_2 = 6;
        this.APNEA_HISTORY = 20;
        this.APNEA_BREATH_QUORUM = 15;
        this.MAX_HISTORY = Math.max(10, 20);
        this.history = new ArrayList();
        this.allHistory = new ArrayList();
        this.avgSignalToNoiseRatio = Moving.avg(10);
        this.medianBuffer = new FloatArrayBuffer(10000);
        this.thresholdBuffer = new FloatArrayBuffer(10000);
        this.lowActivity = Moving.min(5);
    }

    private final void detectApnea() {
        if (this.history.size() < this.APNEA_HISTORY) {
            return;
        }
        List<BreathEvent> list = this.history;
        List listSlice = CollectionsKt.slice(list, RangesKt.until(Math.max(0, list.size() - this.APNEA_HISTORY), this.history.size()));
        if (!((BreathEvent) FileInsert$$ExternalSyntheticOutline0.m(listSlice, 1)).getResolvedAsBreath() || ((BreathEvent) FileInsert$$ExternalSyntheticOutline0.m(listSlice, 2)).getResolvedAsBreath() || ((BreathEvent) FileInsert$$ExternalSyntheticOutline0.m(listSlice, 2)).getIsHighActivity()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSlice) {
            if (((BreathEvent) obj).getResolvedAsBreath()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() > this.APNEA_BREATH_QUORUM) {
            Logger.logInfo("RespiratoryDetectorV21 apnea candidate, signalStrength=" + this.currentAvgSignalToNoiseRatio);
            if (this.currentAvgSignalToNoiseRatio > 4.0d) {
                BreathEvent breathEvent = (BreathEvent) FileInsert$$ExternalSyntheticOutline0.m(listSlice, 2);
                breathEvent.setResolvedAsApnea(true);
                RespiratoryDetector.RespiratoryListener respiratoryListener = this.listener;
                if (respiratoryListener != null) {
                    respiratoryListener.onApneaDetected(breathEvent.getTimestamp(), 1);
                }
            }
        }
    }

    private final void detectBreath() {
        List<BreathEvent> list = this.history;
        List listSlice = CollectionsKt.slice(list, RangesKt.until(Math.max(0, list.size() - this.BREATH_HISTORY), this.history.size()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSlice) {
            if (((BreathEvent) obj).isValidRespRate()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((BreathEvent) it.next()).getRespRate()));
        }
        if (((Float[]) arrayList2.toArray(new Float[0])).length < this.BREATH_QUORUM_1) {
            return;
        }
        int iRint = (int) Math.rint(ScienceUtil.percentile(r1, 50.0f));
        int i = iRint - 1;
        int i2 = iRint + 1;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listSlice) {
            int respRate = ((BreathEvent) obj2).getRespRate();
            if (i <= respRate && respRate <= i2) {
                arrayList3.add(obj2);
            }
        }
        if (arrayList3.size() < this.BREATH_QUORUM_2) {
            return;
        }
        ArrayList<BreathEvent> arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            if (!((BreathEvent) obj3).getResolvedAsBreath()) {
                arrayList4.add(obj3);
            }
        }
        for (BreathEvent breathEvent : arrayList4) {
            breathEvent.setResolvedAsBreath(true);
            RespiratoryDetector.RespiratoryListener respiratoryListener = this.listener;
            if (respiratoryListener != null) {
                respiratoryListener.onBreathDetected(breathEvent.getTimestamp(), breathEvent.getRespRate());
            }
        }
    }

    private final void detectHighActivity(BreathEvent event, float[] data2) {
        float fPercentile = ScienceUtil.percentile(data2, 50.0f);
        ArrayList arrayList = new ArrayList(data2.length);
        for (float f : data2) {
            arrayList.add(Float.valueOf(Math.abs(f - fPercentile)));
        }
        float fSumOfFloat = CollectionsKt___CollectionsKt.sumOfFloat(arrayList);
        event.setHighActivity(fSumOfFloat > this.lowActivity.apply(fSumOfFloat) * 1.75f);
    }

    private final void doProcess(float[] data2, int activity) {
        FftResult fftResultFft = fft(removePeaks(data2));
        BreathLogger breathLogger = this.breathLog;
        if (breathLogger != null) {
            float[] energies = fftResultFft.getEnergies();
            energies.getClass();
            breathLogger.log(ArraysKt___ArraysKt.joinToString$default(energies, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n");
        }
        double d = (((double) this.RESP_RATE_FROM) / 60.0d) * 0.5d;
        double d2 = (((double) this.RESP_RATE_TO) / 60.0d) * 4.0d;
        int maxEnergyBin = fftResultFft.getMaxEnergyBin(d, d2);
        int iRound = (int) Math.round(fftResultFft.getFrequency(maxEnergyBin) * 60.0d);
        int i = this.RESP_RATE_TO;
        if (iRound > i) {
            iRound /= 2;
        }
        boolean z = iRound <= i && this.RESP_RATE_FROM <= iRound;
        long time = this.clock.getTime();
        if (!z) {
            iRound = 0;
        }
        BreathEvent breathEvent = new BreathEvent(time, iRound);
        this.history.add(breathEvent);
        if (this.breathLog != null) {
            this.allHistory.add(breathEvent);
        }
        while (this.history.size() > this.MAX_HISTORY) {
            this.history.remove(0);
        }
        detectHighActivity(breathEvent, data2);
        detectBreath();
        this.currentAvgSignalToNoiseRatio = this.avgSignalToNoiseRatio.apply(breathEvent.getResolvedAsBreath() ? (float) (((double) fftResultFft.getEnergy(maxEnergyBin)) / (fftResultFft.getEnergySum(d, d2) / ((double) ((fftResultFft.getBinByFrequency(d2) - fftResultFft.getBinByFrequency(d)) + 1)))) : 2.0f);
        detectApnea();
    }

    private final FftResult fft(float[] data2) {
        float[] fArrCopyOf = Arrays.copyOf(data2, data2.length);
        new FloatFFT_1D(fArrCopyOf.length).realForward(fArrCopyOf);
        return new FftResultRaw(fArrCopyOf, this.sampleRate);
    }

    private final void logDetailedResults() {
        if (this.breathLog != null) {
            List<BreathEvent> list = this.allHistory;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((BreathEvent) it.next()).getRespRate()));
            }
            this.breathLog.log(CollectionsKt.joinToString$default(arrayList, ",", null, null, null, 62) + "\n");
            List<BreathEvent> list2 = this.allHistory;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (BreathEvent breathEvent : list2) {
                arrayList2.add(Integer.valueOf(breathEvent.getResolvedAsBreath() ? breathEvent.getRespRate() : 0));
            }
            this.breathLog.log(CollectionsKt.joinToString$default(arrayList2, ",", null, null, null, 62) + "\n");
            List<BreathEvent> list3 = this.allHistory;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((BreathEvent) it2.next()).getResolvedAsApnea() ? 1 : 0));
            }
            this.breathLog.log(CollectionsKt.joinToString$default(arrayList3, ",", null, null, null, 62) + "\n");
            List<BreathEvent> list4 = this.allHistory;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList4.add(Integer.valueOf(((BreathEvent) it3.next()).getIsHighActivity() ? 1 : 0));
            }
            this.breathLog.log(CollectionsKt.joinToString$default(arrayList4, ",", null, null, null, 62) + "\n");
        }
    }

    private final void processFirstData(float[] data2, int activity) {
        if (data2.length >= 240) {
            this.expectedDataSize = data2.length;
            this.firstCall = false;
            doProcess(data2, activity);
        } else {
            Logger.logWarning("RespiratoryDetectorV21: weird small first data. Skipping. " + data2.length + " " + activity);
        }
    }

    private final void processNextData(float[] data2, int activity) {
        int length = data2.length;
        int i = this.expectedDataSize;
        if (length == i) {
            doProcess(data2, activity);
            return;
        }
        Logger.logWarning("RespiratoryDetectorV21: unexpected data size: " + data2.length + " " + i);
    }

    private final float[] removePeaks(float[] data2) {
        this.medianBuffer.add(data2);
        float fPercentile = ScienceUtil.percentile(this.medianBuffer.getArray(), 50.0f);
        ArrayList arrayList = new ArrayList(data2.length);
        for (float f : data2) {
            arrayList.add(Float.valueOf(fPercentile - f));
        }
        this.thresholdBuffer.add(CollectionsKt.toFloatArray(arrayList));
        float fMax = Math.max(1.0f, ScienceUtil.percentile(this.thresholdBuffer.getArray(), 50.0f));
        ArrayList arrayList2 = new ArrayList(data2.length);
        for (float f2 : data2) {
            arrayList2.add(Float.valueOf(Math.min(Math.max(f2 - fPercentile, -fMax), fMax)));
        }
        return CollectionsKt.toFloatArray(arrayList2);
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector
    public void dataBroken() {
        this.history.clear();
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector
    public void detect(float[] data2, int activity) {
        data2.getClass();
        if (this.firstCall) {
            processFirstData(data2, activity);
        } else {
            processNextData(data2, activity);
        }
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector
    public void trackingFinished() {
        logDetailedResults();
    }
}

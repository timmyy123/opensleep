package com.urbandroid.sleep.sensor.respiration.v1;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.mic.RawAudioWriter;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.newfftresult.FftResultEnergyOnly;
import com.urbandroid.sleep.snoring.newfftresult.FftResultRaw;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.jtransforms.fft.FloatFFT_1D;

/* JADX INFO: loaded from: classes4.dex */
public class RespiratoryDetectorV1 implements RespiratoryDetector {
    private float dataSampleRate;
    private int expectedDataSize;
    private RespiratoryDetector.RespiratoryListener listener;
    private FftResult prevFftResult;
    private boolean firstCall = true;
    private boolean persist = Experiments.getInstance().isRespiratoryDetailsPersistentExperiment();

    public RespiratoryDetectorV1(float f, RespiratoryDetector.RespiratoryListener respiratoryListener) {
        this.dataSampleRate = f;
        this.listener = respiratoryListener;
    }

    private FftResult blur(FftResult fftResult, FftResult fftResult2) {
        float[] energies = fftResult.getEnergies();
        float[] energies2 = fftResult2.getEnergies();
        int length = energies.length;
        float[] fArr = new float[length];
        fArr[0] = (energies[0] + energies2[0]) / 2.0f;
        for (int i = 1; i < length; i++) {
            int i2 = i - 1;
            fArr[i] = (((energies[i] + energies[i2]) + energies2[i]) + energies2[i2]) / 4.0f;
        }
        return new FftResultEnergyOnly(fArr, this.dataSampleRate);
    }

    private boolean detectApnea(float[] fArr, float[] fArr2) {
        float fPercentile = ScienceUtil.percentile(fArr, 35.0f);
        ScienceUtil.max(fArr);
        byte b = 0;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fArr.length; i3++) {
            float f = fArr[i3];
            if (f < fPercentile && b > -1) {
                if (i > 0) {
                    float f2 = i2;
                    if (f2 > this.dataSampleRate * 18.0f) {
                        Logger.logInfo("Respiration: APNEA " + (f2 / this.dataSampleRate) + "s at " + i3);
                        RespiratoryDetector.RespiratoryListener respiratoryListener = this.listener;
                        if (respiratoryListener != null) {
                            respiratoryListener.onApneaDetected(System.currentTimeMillis(), 1);
                        }
                        StringBuilder sb = new StringBuilder();
                        for (float f3 : fArr2) {
                            sb.append(Math.round(f3 * 100.0f));
                            sb.append(" ");
                        }
                        Logger.logInfo(sb.toString());
                        if (this.persist) {
                            RawAudioWriter rawAudioWriter = new RawAudioWriter(SharedApplicationContext.getInstance().getContext(), "Apnea_" + System.currentTimeMillis());
                            rawAudioWriter.write(sb.toString());
                            rawAudioWriter.close();
                        }
                        return true;
                    }
                }
                i2 = 0;
                b = -1;
            } else if (f < fPercentile && b == -1) {
                i2++;
            } else if (f > fPercentile && b < 1) {
                i = 0;
                b = 1;
            } else if (f > fPercentile && b == 1) {
                i++;
            }
        }
        return false;
    }

    private FftResult fft(float[] fArr) {
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        new FloatFFT_1D(fArrCopyOf.length).realForward(fArrCopyOf);
        return new FftResultRaw(fArrCopyOf, this.dataSampleRate);
    }

    private FftResult getBlurredFft(float[] fArr) {
        FftResult fftResultFft = fft(fArr);
        FftResult fftResultBlur = blur(this.prevFftResult, fftResultFft);
        this.prevFftResult = fftResultFft;
        return fftResultBlur;
    }

    public static void postProcessRespiratoryEvents(SleepRecord sleepRecord) {
        Logger.logInfo("RespiratoryDetectorV1: postProcessRespiratoryEvents");
        HashMap map = new HashMap();
        int i = 0;
        for (Event event : sleepRecord.getEvents().getCopiedEvents()) {
            if (event.getLabel().equals(EventLabel.RR)) {
                i++;
                float value = event.getValue();
                if (map.containsKey(Float.valueOf(value))) {
                    map.put(Float.valueOf(value), Integer.valueOf(((Integer) map.get(Float.valueOf(value))).intValue() + 1));
                } else {
                    map.put(Float.valueOf(value), 1);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(map.values());
        Collections.sort(arrayList);
        int iIntValue = arrayList.size() >= 1 ? ((Integer) arrayList.get(arrayList.size() - 1)).intValue() : 0;
        if (arrayList.size() >= 2) {
            iIntValue += ((Integer) arrayList.get(arrayList.size() - 2)).intValue();
        }
        double d = i;
        double sleepLengthMinutes = d / ((double) sleepRecord.getSleepLengthMinutes());
        double d2 = ((double) iIntValue) / d;
        Logger.logDebug("SleepRecord: RR event stats " + i + " " + sleepLengthMinutes + " " + d2);
        if (i < 50 || sleepLengthMinutes < 0.5d || d2 < 0.98d) {
            return;
        }
        Logger.logWarning("Deleting RR events, they are probably fake. " + i + " " + sleepLengthMinutes + " " + d2);
        sleepRecord.getEvents().clearLabels(EventLabel.RR, EventLabel.APNEA);
    }

    private void processFirstData(float[] fArr, int i) {
        if (fArr.length >= 50) {
            this.expectedDataSize = fArr.length;
            this.prevFftResult = fft(fArr);
            this.firstCall = false;
        } else {
            Logger.logWarning("RespiratoryDetectorV1: weird small first data. Skipping. " + fArr.length + " " + i);
        }
    }

    private void processNextData(float[] fArr, int i) {
        RespiratoryDetector.RespiratoryListener respiratoryListener;
        if (fArr.length != this.expectedDataSize) {
            Logger.logWarning("RespiratoryDetectorV1: unexpected data size: " + fArr.length + " " + this.expectedDataSize);
            return;
        }
        FftResult blurredFft = getBlurredFft(fArr);
        double energySum = blurredFft.getEnergySum(0.075d, 2.0d) / ((double) ((blurredFft.getBinByFrequency(2.0d) - blurredFft.getBinByFrequency(0.075d)) + 1));
        double d = 3.0d * energySum;
        int maxEnergyBin = blurredFft.getMaxEnergyBin(0.15d, 0.8d);
        double energy = blurredFft.getEnergy(maxEnergyBin);
        int iRound = (int) Math.round(energy / energySum);
        int iRound2 = (int) Math.round(blurredFft.getFrequency(maxEnergyBin) * 60.0d);
        int iRound3 = Math.round((fArr.length / iRound2) / 2.5f);
        ArrayList arrayList = new ArrayList();
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        for (int i2 = 0; i2 < 3; i2++) {
            ScienceUtil.inPlaceMovingAverage(fArrCopyOf, iRound3);
        }
        if (i == 0) {
            detectApnea(fArrCopyOf, fArr);
        }
        float fMax = 0.0f;
        fArrCopyOf[0] = 0.0f;
        ScienceUtil.detectPeaksAdvance(Arrays.copyOf(fArrCopyOf, fArrCopyOf.length), Math.round(iRound3 * 1.0f), arrayList, null, ScienceUtil.percentile(fArrCopyOf, 10.0f));
        int size = arrayList.size();
        for (int i3 = size - 2; i3 < size + 2; i3++) {
            if (i3 > 10) {
                fMax = Math.max(blurredFft.getEnergy(blurredFft.getBinByFrequency(i3 / 60.0f)), fMax);
            }
        }
        if (iRound2 > 20 || size > 20) {
            iRound2 /= 2;
            size /= 2;
        }
        int i4 = (size + iRound2) / 2;
        boolean z = energy >= d && (Math.abs(iRound2 - size) <= iRound || ((double) fMax) >= d) && i4 >= 8 && i4 <= 21;
        if (z && (respiratoryListener = this.listener) != null) {
            respiratoryListener.onBreathDetected(System.currentTimeMillis(), i4);
        }
        if (this.persist && z) {
            StringBuilder sb = new StringBuilder();
            for (float f : fArr) {
                sb.append(f + "\n");
            }
            RawAudioWriter rawAudioWriter = new RawAudioWriter(SharedApplicationContext.getInstance().getContext(), "Respiration_" + System.currentTimeMillis() + "_" + iRound2 + "_" + size + "_" + z);
            rawAudioWriter.write(sb.toString());
            rawAudioWriter.close();
        }
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector
    public void dataBroken() {
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector
    public void detect(float[] fArr, int i) {
        if (this.firstCall) {
            processFirstData(fArr, i);
        } else {
            processNextData(fArr, i);
        }
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector
    public void trackingFinished() {
    }
}

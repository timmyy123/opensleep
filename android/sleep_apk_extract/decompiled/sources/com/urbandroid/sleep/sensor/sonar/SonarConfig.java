package com.urbandroid.sleep.sensor.sonar;

import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SonarConfig {
    public static final int RECORDING_INPUT = getRecordingInput();

    private static int getRecordingInput() {
        if (SharedApplicationContext.getSettings().getNoiseInput() > 0) {
            int noiseInput = SharedApplicationContext.getSettings().getNoiseInput();
            if (noiseInput == 1) {
                return 0;
            }
            if (noiseInput == 2) {
                return 1;
            }
            if (noiseInput == 3) {
                return 6;
            }
            if (noiseInput == 4) {
                return 9;
            }
        }
        return Experiments.getInstance().isAnyTensorflow() ? 6 : 1;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public enum SonarMethod {
        CHIRP_18_20(18000, 22000),
        CHIRP_18_20_REALLY(18000, 20000),
        MONO_18(18000),
        MONO_19(19000),
        MONO_20(20000);

        private int freqFrom;
        private int freqTo;

        SonarMethod(int i, int i2) {
            this.freqFrom = i;
            this.freqTo = i2;
        }

        public int getFreqFrom() {
            return this.freqFrom;
        }

        public int getFreqTo() {
            return this.freqTo;
        }

        public boolean isMonoFreq() {
            return this.freqFrom == this.freqTo;
        }

        @Override // java.lang.Enum
        public String toString() {
            return name() + " " + this.freqFrom + " - " + this.freqTo;
        }

        SonarMethod(int i) {
            this.freqFrom = i;
            this.freqTo = i;
        }
    }
}

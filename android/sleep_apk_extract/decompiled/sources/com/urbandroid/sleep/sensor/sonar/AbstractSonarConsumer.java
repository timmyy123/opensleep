package com.urbandroid.sleep.sensor.sonar;

import android.content.Context;
import android.os.Handler;
import com.facebook.internal.Utility;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.UltrasoundPlayer;
import com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetectorFactoryKt;
import com.urbandroid.sleep.sensor.sonar.ILowLevelActivityAggregator;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import com.urbandroid.sleep.sensor.sonar.SonarProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ScienceUtil;
import com.urbandroid.util.StringBufferPersister;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractSonarConsumer extends ChunkedAudioConsumer implements UltrasoundPlayer, SonarConsumer {
    private float[] activity;
    private ILowLevelActivityAggregator activityAggregator;
    private int[] activityDuringRespirationWindow;
    private StringBufferPersister bufferPersister;
    private int count;
    private int dataCounter;
    private float dataSampleRate;
    private int dataWindowLongSize;
    private int dataWindowSize;
    private Handler h;
    private float lastMax;
    private AtomicBoolean producerInitialized;
    private AtomicBoolean producerStarted;
    private int progressCount;
    private int respiratoryCounter;
    private RespiratoryDetector respiratoryDetector;
    private double signalStrength;
    private double signalSumAfterChirp;
    private double signalSumBeforeChirp;
    private double signalSumInProgress;
    private SonarConfig.SonarMethod sonarMethod;
    private SonarProducer sonarProducer;
    private int sonarStream;
    private volatile Boolean ultrasoundSupported;

    public class ConsumerResult {
        private float activity;
        private double signal;

        public ConsumerResult(double d, float f) {
            this.signal = d;
            this.activity = f;
        }

        public float getActivity() {
            return this.activity;
        }

        public double getSignal() {
            return this.signal;
        }
    }

    public AbstractSonarConsumer(Context context, SonarConfig.SonarMethod sonarMethod) {
        super(context, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        this.activityDuringRespirationWindow = new int[2];
        this.respiratoryCounter = 0;
        this.progressCount = 0;
        this.signalStrength = -1.0d;
        this.sonarStream = 3;
        this.h = new Handler();
        this.sonarMethod = sonarMethod;
    }

    private boolean isEndOfTracking() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(SleepService.getServiceClass(this.context).getName()) && stackTraceElement.getMethodName().equals("onDestroy")) {
                return true;
            }
        }
        return false;
    }

    private void startChirp() {
        if (this.sonarProducer != null) {
            Logger.logInfo("Sonar: starting chirp");
            this.sonarProducer.setSoundStartListener(new SonarProducer.SoundStartListener() { // from class: com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer.1
                @Override // com.urbandroid.sleep.sensor.sonar.SonarProducer.SoundStartListener
                public void onSoundStarted() {
                    Logger.logInfo("Sonar: chirp started");
                    AbstractSonarConsumer.this.producerStarted.set(true);
                }
            });
            this.sonarProducer.play();
            this.producerInitialized.set(true);
            this.count = 0;
        }
    }

    public abstract SonarProducer createSonarProducer(Context context, SonarConfig.SonarMethod sonarMethod, int i);

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doClose() {
        Logger.logInfo("SonarConsumer: stopping chirp producer");
        SonarProducer sonarProducer = this.sonarProducer;
        if (sonarProducer != null) {
            sonarProducer.stop();
            this.sonarProducer = null;
            Logger.logInfo("SonarConsumer: chirp stopped");
        }
        if (this.respiratoryDetector != null) {
            boolean zIsEndOfTracking = isEndOfTracking();
            RespiratoryDetector respiratoryDetector = this.respiratoryDetector;
            if (zIsEndOfTracking) {
                respiratoryDetector.trackingFinished();
            } else {
                respiratoryDetector.dataBroken();
            }
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doOpen(AudioRecorderContext audioRecorderContext) {
        Logger.logInfo("Sonar: consumer open ".concat(getClass().getSimpleName()));
        float sampleRate = audioRecorderContext.getSampleRate() / this.chunkSize;
        this.dataSampleRate = sampleRate;
        int i = (int) (60.0f * sampleRate);
        this.dataWindowSize = i;
        this.dataWindowLongSize = (int) (600.0f * sampleRate);
        this.activity = new float[i];
        this.respiratoryDetector = RespiratoryDetectorFactoryKt.createRespiratoryDetector(sampleRate);
        int sonarStream = new Settings(this.context).getSonarStream();
        this.sonarStream = sonarStream;
        this.sonarProducer = createSonarProducer(this.context, this.sonarMethod, sonarStream);
        this.producerStarted = new AtomicBoolean(false);
        this.producerInitialized = new AtomicBoolean(false);
        this.dataCounter = 0;
        this.count = 0;
        this.ultrasoundSupported = null;
        this.signalSumBeforeChirp = 0.0d;
        this.signalSumAfterChirp = 0.0d;
        this.activityAggregator = new LowLevelActivityAggregator(audioRecorderContext.getSampleRate());
        setLastMax(0.0f);
        if (Experiments.getInstance().isRawActigraphyPersistentExperiment()) {
            this.bufferPersister = new StringBufferPersister("Sonar_activity_", DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doPause() {
        SonarProducer sonarProducer = this.sonarProducer;
        if (sonarProducer != null) {
            sonarProducer.stop();
            Logger.logInfo("SonarConsumer: chirp stopped");
        }
        RespiratoryDetector respiratoryDetector = this.respiratoryDetector;
        if (respiratoryDetector != null) {
            respiratoryDetector.dataBroken();
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doResume() {
        startChirp();
    }

    public synchronized float getLastMax() {
        return this.lastMax;
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarConsumer
    public double getSignalStrength() {
        return this.signalStrength;
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarConsumer
    public Boolean getUltrasoundSupported() {
        return this.ultrasoundSupported;
    }

    public abstract ConsumerResult processAndGetResult(float[] fArr);

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public void processChunk(float[] fArr) {
        RespiratoryDetector respiratoryDetector;
        ConsumerResult consumerResultProcessAndGetResult = processAndGetResult(fArr);
        double signal = consumerResultProcessAndGetResult.getSignal();
        if (!this.producerStarted.get()) {
            if (this.producerInitialized.get()) {
                return;
            }
            int i = this.count;
            if (i < 15) {
                this.signalSumBeforeChirp += signal;
                this.count = i + 1;
            }
            if (this.count == 15) {
                startChirp();
                return;
            }
            return;
        }
        int i2 = this.count;
        if (i2 == -1) {
            int i3 = this.progressCount + 1;
            this.progressCount = i3;
            double d = this.signalSumInProgress + signal;
            this.signalSumInProgress = d;
            if (i3 > 60) {
                double d2 = (d / 60.0d) / (this.signalSumBeforeChirp / 15.0d);
                this.signalStrength = d2;
                this.signalSumInProgress = 0.0d;
                this.progressCount = 0;
                this.ultrasoundSupported = Boolean.valueOf(d2 >= 60.0d);
            }
        } else if (i2 < 60) {
            this.signalSumAfterChirp += signal;
            this.count = i2 + 1;
        } else {
            double d3 = this.signalSumBeforeChirp / 15.0d;
            double d4 = this.signalSumAfterChirp / 60.0d;
            Logger.logInfo("Sonar: signal before chirp " + d3 + " / after " + d4);
            this.signalStrength = d4 / d3;
            Settings settings = new Settings(this.context);
            double sonarSignalStrength = (double) settings.getSonarSignalStrength();
            double d5 = this.signalStrength;
            if (sonarSignalStrength != d5) {
                settings.setSonarSignalStrength(Math.round((float) d5));
            }
            if (this.signalStrength >= 60.0d) {
                Logger.logInfo("Sonar: ultrasound supported");
                this.ultrasoundSupported = Boolean.TRUE;
                new Settings(this.context).setSonarStream(this.sonarStream);
            } else {
                zza$$ExternalSyntheticOutline0.m(new StringBuilder("Sonar: ultrasound NOT supported for stream "), this.sonarStream);
                this.ultrasoundSupported = Boolean.FALSE;
            }
            this.count = -1;
        }
        float activity = consumerResultProcessAndGetResult.getActivity();
        ScienceUtil.shiftRight(this.activity);
        this.activity[0] = activity;
        ILowLevelActivityAggregator.Result resultUpdate = this.activityAggregator.update(activity);
        StringBufferPersister stringBufferPersister = this.bufferPersister;
        if (stringBufferPersister != null) {
            stringBufferPersister.update(activity + "," + resultUpdate.actigraph + "," + resultUpdate.isHighActivity + "\n");
        }
        boolean z = resultUpdate.isHighActivity;
        this.dataCounter++;
        if (activity > getLastMax()) {
            setLastMax(activity);
        }
        if (z) {
            int[] iArr = this.activityDuringRespirationWindow;
            int i4 = this.respiratoryCounter % 2;
            iArr[i4] = iArr[i4] + 1;
        }
        if (this.dataCounter > this.dataWindowSize / 2) {
            int[] iArr2 = this.activityDuringRespirationWindow;
            int i5 = iArr2[0] + iArr2[1];
            if (this.respiratoryCounter >= 2 && i5 <= 2 && (respiratoryDetector = this.respiratoryDetector) != null) {
                respiratoryDetector.detect(this.activity, i5);
            }
            this.dataCounter = 0;
            int i6 = this.respiratoryCounter + 1;
            this.respiratoryCounter = i6;
            this.activityDuringRespirationWindow[i6 % 2] = 0;
        }
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarConsumer
    public synchronized float resetLastActivity() {
        ILowLevelActivityAggregator iLowLevelActivityAggregator = this.activityAggregator;
        if (iLowLevelActivityAggregator != null) {
            return Math.max(0.0f, iLowLevelActivityAggregator.getAggregatedActivity());
        }
        Logger.logWarning("Sonar: No activity aggregator");
        return -1.0f;
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarConsumer
    public synchronized float resetLastMax() {
        float f;
        f = this.lastMax;
        this.lastMax = 0.0f;
        return f;
    }

    @Override // com.urbandroid.sleep.sensor.sonar.SonarConsumer
    public void resetSignalStrength() {
        this.signalStrength = -1.0d;
        this.signalSumInProgress = 0.0d;
        this.progressCount = 0;
    }

    public synchronized void setLastMax(float f) {
        this.lastMax = f;
    }
}

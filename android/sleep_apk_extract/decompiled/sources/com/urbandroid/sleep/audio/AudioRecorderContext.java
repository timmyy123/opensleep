package com.urbandroid.sleep.audio;

import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.sleep.audio.writer.AudioWriterCreator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000e¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorderContext;", "Lcom/urbandroid/sleep/audio/writer/AudioWriterCreator;", "baseSampleRate", "", "getBaseSampleRate", "()I", "sampleRate", "getSampleRate", "lastReadStartTime", "", "getLastReadStartTime", "()J", "isPaused", "", "()Z", "floatBufferSize", "getFloatBufferSize", "fftFactory", "Lcom/urbandroid/sleep/audio/transform/AudioTransformer$FftFactory;", "getFftFactory", "()Lcom/urbandroid/sleep/audio/transform/AudioTransformer$FftFactory;", "iirFilterFactory", "Lcom/urbandroid/sleep/audio/transform/AudioTransformer$IirFilterFactory;", "getIirFilterFactory", "()Lcom/urbandroid/sleep/audio/transform/AudioTransformer$IirFilterFactory;", "isExplicitRecording", "hasFeature", "feature", "Lcom/urbandroid/sleep/audio/AudioRecorderContext$Feature;", "resetExplicitRecording", "", "Feature", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AudioRecorderContext extends AudioWriterCreator {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorderContext$Feature;", "", "<init>", "(Ljava/lang/String;I)V", "STEREO", "SNORING_DETECTION", "ULTRASOUND_PLAYER", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Feature {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Feature[] $VALUES;
        public static final Feature STEREO = new Feature("STEREO", 0);
        public static final Feature SNORING_DETECTION = new Feature("SNORING_DETECTION", 1);
        public static final Feature ULTRASOUND_PLAYER = new Feature("ULTRASOUND_PLAYER", 2);

        private static final /* synthetic */ Feature[] $values() {
            return new Feature[]{STEREO, SNORING_DETECTION, ULTRASOUND_PLAYER};
        }

        static {
            Feature[] featureArr$values = $values();
            $VALUES = featureArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(featureArr$values);
        }

        private Feature(String str, int i) {
        }

        public static Feature valueOf(String str) {
            return (Feature) Enum.valueOf(Feature.class, str);
        }

        public static Feature[] values() {
            return (Feature[]) $VALUES.clone();
        }
    }

    int getBaseSampleRate();

    AudioTransformer.FftFactory getFftFactory();

    int getFloatBufferSize();

    AudioTransformer.IirFilterFactory getIirFilterFactory();

    long getLastReadStartTime();

    int getSampleRate();

    boolean hasFeature(Feature feature);

    boolean isExplicitRecording();

    boolean isPaused();

    void resetExplicitRecording();
}

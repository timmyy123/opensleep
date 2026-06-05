package com.urbandroid.sleep.audio;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.AsyncContext;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.headset.HeadsetPlugChecker;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.amplitude.MaxAmplitudeResolver;
import com.urbandroid.sleep.audio.consumer.RecordingAudioConsumer;
import com.urbandroid.sleep.audio.consumer.SnoringDetectionAudioConsumer;
import com.urbandroid.sleep.audio.consumer.SoundDetectionAudioConsumer;
import com.urbandroid.sleep.audio.transform.CachedFftFactory;
import com.urbandroid.sleep.audio.transform.CachedIirFilterFactory;
import com.urbandroid.sleep.audio.writer.AudioWriterCreator;
import com.urbandroid.sleep.audio.writer.AudioWriterCreatorFactory;
import com.urbandroid.sleep.mic.IRecordingWriter;
import com.urbandroid.sleep.sensor.sonar.AbstractSonarConsumer;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0005klmnoB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010\tJ\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b'\u0010(J%\u0010,\u001a\u00020\u00072\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010%\u001a\u00020\u0007*\f\u0012\b\u0012\u00060/R\u00020\u00000.H\u0002¢\u0006\u0004\b%\u00100J\u001d\u0010\u0010\u001a\u00020\u0007*\f\u0012\b\u0012\u00060/R\u00020\u00000.H\u0002¢\u0006\u0004\b\u0010\u00100J\u001d\u0010\u0012\u001a\u00020\u0007*\f\u0012\b\u0012\u00060/R\u00020\u00000.H\u0002¢\u0006\u0004\b\u0012\u00100R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00101R\u001a\u00103\u001a\u0002028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R8\u0010@\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00010\f0\f >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010\f0\f\u0018\u00010?0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010B\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020&0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010JR\u0016\u0010K\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010<R\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR$\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u00130Oj\b\u0012\u0004\u0012\u00020\u0013`P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001e\u0010T\u001a\f\u0012\b\u0012\u00060/R\u00020\u00000S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u0004\u0018\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0017\u0010Z\u001a\u00020Y8\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010<R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020e0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010IR\u0016\u0010g\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010<R\u0014\u0010h\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010[R\u0011\u0010i\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\bi\u0010DR\u0014\u0010j\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010D¨\u0006p"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder;", "Ljava/lang/Runnable;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "run", "()V", "explicitRecording", "stop", "Lcom/urbandroid/sleep/audio/AudioRecorder$PauseReason;", "pauseReason", "pauseAsync", "(Lcom/urbandroid/sleep/audio/AudioRecorder$PauseReason;)V", "pause", "resumeAsync", "resume", "Lcom/urbandroid/sleep/audio/NoiseLevelRecorder;", "noiseLevelRecorder", "addNoiseLevelRecorder", "(Lcom/urbandroid/sleep/audio/NoiseLevelRecorder;)Lcom/urbandroid/sleep/audio/AudioRecorder;", "Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;", "consumer", "", "sampleRate", "addConsumer", "(Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;I)Lcom/urbandroid/sleep/audio/AudioRecorder;", "addAndOpenConsumerIfPossible", "removeAndCloseConsumerIfPossible", "(Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;)V", "Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;", "onStopListener", "timeoutInSeconds", "destroy", "(Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;I)V", "close", "Landroid/media/AudioRecord;", "initialize", "()Landroid/media/AudioRecord;", "Lkotlin/Function1;", "", "isApplicable", "openConsumers", "(Lkotlin/jvm/functions/Function1;)V", "", "Lcom/urbandroid/sleep/audio/AudioRecorder$ConsumerHolder;", "(Ljava/util/List;)V", "Landroid/content/Context;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Ljava/util/concurrent/locks/ReentrantLock;", "recorderLock", "Ljava/util/concurrent/locks/ReentrantLock;", "pauseLock", "running", "Z", "", "kotlin.jvm.PlatformType", "", "activePauseReasons", "Ljava/util/Set;", "explicitRecordingRequested", "getExplicitRecordingRequested", "()Z", "setExplicitRecordingRequested", "(Z)V", "Ljava/util/concurrent/atomic/AtomicReference;", "recorder", "Ljava/util/concurrent/atomic/AtomicReference;", "I", "stereo", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "noiseLevelRecorders", "Ljava/util/ArrayList;", "", "consumers", "Ljava/util/List;", "Lcom/urbandroid/sleep/audio/writer/AudioWriterCreator;", "audioWriterCreator", "Lcom/urbandroid/sleep/audio/writer/AudioWriterCreator;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastReadStartTime", "Ljava/util/concurrent/atomic/AtomicLong;", "getLastReadStartTime", "()Ljava/util/concurrent/atomic/AtomicLong;", "ultrasoundPlayerEngaged", "Lcom/urbandroid/sleep/audio/transform/CachedFftFactory;", "fftFactory", "Lcom/urbandroid/sleep/audio/transform/CachedFftFactory;", "Lcom/urbandroid/sleep/audio/transform/CachedIirFilterFactory;", "iirFilterFactory", "Lcom/urbandroid/sleep/audio/transform/CachedIirFilterFactory;", "Lcom/urbandroid/common/headset/HeadsetPlugChecker;", "headsetPlugChecker", "initialized", "lastLogTimestamp", "isPaused", "isLoggingAllowed", "PauseReason", "Consumer", "ConsumerHolder", "OnDestroyListener", "DestroyChecker", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioRecorder implements Runnable, FeatureLogger {
    private final Set<PauseReason> activePauseReasons;
    private final AudioWriterCreator audioWriterCreator;
    private final List<ConsumerHolder> consumers;
    private final Context context;
    private volatile boolean explicitRecordingRequested;
    private final CachedFftFactory fftFactory;
    private final AtomicReference<HeadsetPlugChecker> headsetPlugChecker;
    private final CachedIirFilterFactory iirFilterFactory;
    private volatile boolean initialized;
    private final AtomicLong lastLogTimestamp;
    private final AtomicLong lastReadStartTime;
    private final ArrayList<NoiseLevelRecorder> noiseLevelRecorders;
    private final ReentrantLock pauseLock;
    private final AtomicReference<AudioRecord> recorder;
    private final ReentrantLock recorderLock;
    private volatile boolean running;
    private int sampleRate;
    private final Settings settings;
    private boolean stereo;
    private final String tag;
    private volatile boolean ultrasoundPlayerEngaged;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer$State;", "getState", "()Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer$State;", "open", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/audio/AudioRecorderContext;", "process", "readBuffer", "Lcom/urbandroid/sleep/audio/AudioReadBuffer;", "close", "pause", "resume", "State", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Consumer {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer$State;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "PAUSED", "CLOSED", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class State {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ State[] $VALUES;
            public static final State OPEN = new State("OPEN", 0);
            public static final State PAUSED = new State("PAUSED", 1);
            public static final State CLOSED = new State("CLOSED", 2);

            private static final /* synthetic */ State[] $values() {
                return new State[]{OPEN, PAUSED, CLOSED};
            }

            static {
                State[] stateArr$values = $values();
                $VALUES = stateArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
            }

            private State(String str, int i) {
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }
        }

        void close();

        State getState();

        void open(AudioRecorderContext context);

        void pause();

        void process(AudioReadBuffer readBuffer);

        void resume();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder$ConsumerHolder;", "", "consumer", "Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;", "sampleRate", "", "<init>", "(Lcom/urbandroid/sleep/audio/AudioRecorder;Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;I)V", "getConsumer", "()Lcom/urbandroid/sleep/audio/AudioRecorder$Consumer;", "getSampleRate", "()I", "open", "", "audioWriterCreator", "Lcom/urbandroid/sleep/audio/writer/AudioWriterCreator;", "process", "data", "Lcom/urbandroid/sleep/audio/AudioReadBuffer;", "timeLoggerLatch", "Ljava/util/concurrent/CountDownLatch;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class ConsumerHolder {
        private final Consumer consumer;
        private final int sampleRate;
        final /* synthetic */ AudioRecorder this$0;

        public ConsumerHolder(AudioRecorder audioRecorder, Consumer consumer, int i) {
            consumer.getClass();
            this.this$0 = audioRecorder;
            this.consumer = consumer;
            this.sampleRate = i;
        }

        public final Consumer getConsumer() {
            return this.consumer;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final void open(final AudioWriterCreator audioWriterCreator) {
            audioWriterCreator.getClass();
            Consumer consumer = this.consumer;
            final AudioRecorder audioRecorder = this.this$0;
            consumer.open(new AudioRecorderContext() { // from class: com.urbandroid.sleep.audio.AudioRecorder$ConsumerHolder$open$1

                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[AudioRecorderContext.Feature.values().length];
                        try {
                            iArr[AudioRecorderContext.Feature.ULTRASOUND_PLAYER.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[AudioRecorderContext.Feature.STEREO.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[AudioRecorderContext.Feature.SNORING_DETECTION.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // com.urbandroid.sleep.audio.writer.AudioWriterCreator
                public IRecordingWriter createWriter(AudioRecorderContext recorderContext) {
                    recorderContext.getClass();
                    return audioWriterCreator.createWriter(recorderContext);
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public int getBaseSampleRate() {
                    return audioRecorder.sampleRate;
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public CachedFftFactory getFftFactory() {
                    return audioRecorder.fftFactory;
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public int getFloatBufferSize() {
                    return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public CachedIirFilterFactory getIirFilterFactory() {
                    return audioRecorder.iirFilterFactory;
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public long getLastReadStartTime() {
                    return audioRecorder.getLastReadStartTime().get();
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public int getSampleRate() {
                    return this.getSampleRate() == -1 ? getBaseSampleRate() : this.getSampleRate();
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public boolean hasFeature(AudioRecorderContext.Feature feature) {
                    feature.getClass();
                    int i = WhenMappings.$EnumSwitchMapping$0[feature.ordinal()];
                    if (i == 1) {
                        return audioRecorder.ultrasoundPlayerEngaged;
                    }
                    if (i == 2) {
                        return audioRecorder.stereo;
                    }
                    if (i == 3) {
                        return audioRecorder.settings.isSnoringDetection();
                    }
                    Home$$ExternalSyntheticBUOutline0.m();
                    return false;
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public boolean isExplicitRecording() {
                    return audioRecorder.getExplicitRecordingRequested();
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public boolean isPaused() {
                    return audioRecorder.isPaused();
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorderContext
                public void resetExplicitRecording() {
                    audioRecorder.setExplicitRecordingRequested(false);
                }
            });
        }

        public final void process(AudioReadBuffer data2, CountDownLatch timeLoggerLatch) {
            data2.getClass();
            Consumer.State state = this.consumer.getState();
            Consumer consumer = this.consumer;
            if (consumer instanceof SnoringDetectionAudioConsumer) {
                if (state == Consumer.State.OPEN) {
                    AudioThreadManager.processConsumer(consumer, data2, timeLoggerLatch);
                    return;
                } else {
                    if (timeLoggerLatch != null) {
                        timeLoggerLatch.countDown();
                        return;
                    }
                    return;
                }
            }
            if (state != Consumer.State.OPEN) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.consumer.process(data2);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (this.this$0.isLoggingAllowed() || jCurrentTimeMillis2 > 500) {
                AudioRecorder audioRecorder = this.this$0;
                String str = "\t--- " + this.consumer.getClass().getSimpleName() + " " + jCurrentTimeMillis2;
                Logger.logDebug(Logger.defaultTag, audioRecorder.getTag() + ": " + str, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;", "", "destroyed", "", "timeouted", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnDestroyListener {
        void destroyed();

        void timeouted();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder$PauseReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_PAUSED", "ALARM", "SCREEN_OFF", "LULLABY", "PHONE_CALL", "BATTERY_SAVING_MODE", "TERMINATING", "LUCID", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PauseReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PauseReason[] $VALUES;
        public static final PauseReason USER_PAUSED = new PauseReason("USER_PAUSED", 0);
        public static final PauseReason ALARM = new PauseReason("ALARM", 1);
        public static final PauseReason SCREEN_OFF = new PauseReason("SCREEN_OFF", 2);
        public static final PauseReason LULLABY = new PauseReason("LULLABY", 3);
        public static final PauseReason PHONE_CALL = new PauseReason("PHONE_CALL", 4);
        public static final PauseReason BATTERY_SAVING_MODE = new PauseReason("BATTERY_SAVING_MODE", 5);
        public static final PauseReason TERMINATING = new PauseReason("TERMINATING", 6);
        public static final PauseReason LUCID = new PauseReason("LUCID", 7);

        private static final /* synthetic */ PauseReason[] $values() {
            return new PauseReason[]{USER_PAUSED, ALARM, SCREEN_OFF, LULLABY, PHONE_CALL, BATTERY_SAVING_MODE, TERMINATING, LUCID};
        }

        static {
            PauseReason[] pauseReasonArr$values = $values();
            $VALUES = pauseReasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pauseReasonArr$values);
        }

        private PauseReason(String str, int i) {
        }

        public static PauseReason valueOf(String str) {
            return (PauseReason) Enum.valueOf(PauseReason.class, str);
        }

        public static PauseReason[] values() {
            return (PauseReason[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PauseReason.values().length];
            try {
                iArr[PauseReason.LULLABY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PauseReason.LUCID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PauseReason.BATTERY_SAVING_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PauseReason.USER_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Consumer.State.values().length];
            try {
                iArr2[Consumer.State.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.audio.AudioRecorder$pauseAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/audio/AudioRecorder;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.audio.AudioRecorder$pauseAsync$1", f = "AudioRecorder.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<AsyncContext<AudioRecorder>, Continuation<? super Unit>, Object> {
        final /* synthetic */ PauseReason $pauseReason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PauseReason pauseReason, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pauseReason = pauseReason;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioRecorder.this.new AnonymousClass1(this.$pauseReason, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<AudioRecorder> asyncContext, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            AudioRecorder.this.pause(this.$pauseReason);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.audio.AudioRecorder$resumeAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/audio/AudioRecorder;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.audio.AudioRecorder$resumeAsync$1", f = "AudioRecorder.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C20861 extends SuspendLambda implements Function2<AsyncContext<AudioRecorder>, Continuation<? super Unit>, Object> {
        final /* synthetic */ PauseReason $pauseReason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20861(PauseReason pauseReason, Continuation<? super C20861> continuation) {
            super(2, continuation);
            this.$pauseReason = pauseReason;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioRecorder.this.new C20861(this.$pauseReason, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<AudioRecorder> asyncContext, Continuation<? super Unit> continuation) {
            return ((C20861) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            AudioRecorder.this.resume(this.$pauseReason);
            return Unit.INSTANCE;
        }
    }

    public AudioRecorder(Context context) {
        context.getClass();
        this.context = context;
        this.tag = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "AudioRecorder_");
        this.recorderLock = new ReentrantLock();
        this.pauseLock = new ReentrantLock();
        this.running = true;
        this.activePauseReasons = Collections.newSetFromMap(new ConcurrentHashMap());
        this.recorder = new AtomicReference<>();
        this.settings = ContextExtKt.getSettings(context);
        this.noiseLevelRecorders = new ArrayList<>();
        this.consumers = new ArrayList();
        this.audioWriterCreator = AudioWriterCreatorFactory.detect();
        this.lastReadStartTime = new AtomicLong();
        this.fftFactory = new CachedFftFactory();
        this.iirFilterFactory = new CachedIirFilterFactory();
        this.headsetPlugChecker = new AtomicReference<>();
        this.lastLogTimestamp = new AtomicLong(0L);
    }

    public static /* synthetic */ AudioRecorder addAndOpenConsumerIfPossible$default(AudioRecorder audioRecorder, Consumer consumer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return audioRecorder.addAndOpenConsumerIfPossible(consumer, i);
    }

    public static /* synthetic */ AudioRecorder addConsumer$default(AudioRecorder audioRecorder, Consumer consumer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return audioRecorder.addConsumer(consumer, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.urbandroid.common.FeatureLogger, com.urbandroid.sleep.audio.AudioRecorder] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.concurrent.atomic.AtomicReference, java.util.concurrent.atomic.AtomicReference<android.media.AudioRecord>] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.concurrent.atomic.AtomicReference, java.util.concurrent.atomic.AtomicReference<android.media.AudioRecord>] */
    private final void close() {
        this.initialized = false;
        String strM = FileInsert$$ExternalSyntheticOutline0.m(this.consumers.size(), " Closing Audio Consumers ... ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        ReentrantLock reentrantLock = this.recorderLock;
        reentrantLock.lock();
        try {
            close(this.consumers);
            HeadsetPlugChecker headsetPlugChecker = this.headsetPlugChecker.get();
            if (headsetPlugChecker != null) {
                headsetPlugChecker.close();
            }
            AudioRecord audioRecord = this.recorder.get();
            try {
                if (audioRecord != null) {
                    try {
                        audioRecord.release();
                        try {
                            try {
                                AudioRecord audioRecord2 = this.recorder.get();
                                if (audioRecord2 != null) {
                                    audioRecord2.release();
                                }
                            } catch (Exception e) {
                                Logger.logSevere(Logger.defaultTag, getTag(), e);
                            }
                        } finally {
                        }
                    } catch (Exception e2) {
                        Logger.logSevere(Logger.defaultTag, getTag(), e2);
                        try {
                            try {
                                AudioRecord audioRecord3 = this.recorder.get();
                                if (audioRecord3 != null) {
                                    audioRecord3.release();
                                }
                            } catch (Exception e3) {
                                Logger.logSevere(Logger.defaultTag, getTag(), e3);
                            }
                        } finally {
                        }
                    }
                    this = this.recorder;
                    this.set(null);
                    Unit unit = Unit.INSTANCE;
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                try {
                    try {
                        AudioRecord audioRecord4 = this.recorder.get();
                        if (audioRecord4 != null) {
                            audioRecord4.release();
                        }
                    } finally {
                    }
                } catch (Exception e4) {
                    Logger.logSevere(Logger.defaultTag, this.getTag(), e4);
                }
                this = this.recorder;
                this.set(null);
                throw th;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    private final AudioRecord initialize() {
        AudioRecordBuilder audioRecordBuilder = new AudioRecordBuilder(2, 3, 0, 262144, new int[]{48000, 44100}, 4, null);
        AudioRecord audioRecordBuild = audioRecordBuilder.build();
        if (audioRecordBuild == null) {
            return null;
        }
        this.sampleRate = audioRecordBuilder.getSampleRate();
        this.stereo = audioRecordBuilder.getIsStereo();
        return audioRecordBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLoggingAllowed() {
        return System.currentTimeMillis() - this.lastLogTimestamp.get() > Utils.getMinutesInMillis(10);
    }

    private final void openConsumers(Function1<? super Consumer, Boolean> isApplicable) {
        String strM = Fragment$$ExternalSyntheticOutline1.m(this.consumers.size(), "opening ", " consumers");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        List<ConsumerHolder> list = this.consumers;
        ArrayList<ConsumerHolder> arrayList = new ArrayList();
        for (Object obj : list) {
            if (isApplicable.invoke(((ConsumerHolder) obj).getConsumer()).booleanValue()) {
                arrayList.add(obj);
            }
        }
        for (ConsumerHolder consumerHolder : arrayList) {
            if (this.headsetPlugChecker.get() == null || !this.headsetPlugChecker.get().isPlugged() || !(consumerHolder.getConsumer() instanceof AbstractSonarConsumer)) {
                AudioWriterCreator audioWriterCreator = this.audioWriterCreator;
                if (audioWriterCreator != null) {
                    consumerHolder.open(audioWriterCreator);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openConsumers$default(AudioRecorder audioRecorder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new AiPrompt$$ExternalSyntheticLambda0(5);
        }
        audioRecorder.openConsumers(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean openConsumers$lambda$0(Consumer consumer) {
        consumer.getClass();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeAndCloseConsumerIfPossible$lambda$0$2(Consumer consumer, ConsumerHolder consumerHolder) {
        consumerHolder.getClass();
        return Intrinsics.areEqual(consumerHolder.getConsumer(), consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resume$lambda$0$1(Consumer consumer) {
        consumer.getClass();
        return ((consumer instanceof RecordingAudioConsumer) || (consumer instanceof SoundDetectionAudioConsumer)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resume$lambda$0$2(Consumer consumer) {
        consumer.getClass();
        return ((consumer instanceof RecordingAudioConsumer) || (consumer instanceof SoundDetectionAudioConsumer)) ? false : true;
    }

    public final AudioRecorder addAndOpenConsumerIfPossible(Consumer consumer, int sampleRate) {
        consumer.getClass();
        AudioWriterCreator audioWriterCreator = this.audioWriterCreator;
        if (audioWriterCreator != null) {
            ConsumerHolder consumerHolder = new ConsumerHolder(this, consumer, sampleRate);
            consumerHolder.open(audioWriterCreator);
            this.consumers.add(consumerHolder);
            if (consumer instanceof UltrasoundPlayer) {
                this.ultrasoundPlayerEngaged = true;
            }
        }
        return this;
    }

    public final AudioRecorder addConsumer(Consumer consumer, int sampleRate) {
        consumer.getClass();
        this.consumers.add(new ConsumerHolder(this, consumer, sampleRate));
        if (consumer instanceof UltrasoundPlayer) {
            this.ultrasoundPlayerEngaged = true;
        }
        return this;
    }

    public final AudioRecorder addNoiseLevelRecorder(NoiseLevelRecorder noiseLevelRecorder) {
        noiseLevelRecorder.getClass();
        this.noiseLevelRecorders.add(noiseLevelRecorder);
        return this;
    }

    public final void destroy(OnDestroyListener onStopListener, int timeoutInSeconds) {
        onStopListener.getClass();
        DestroyChecker destroyChecker = new DestroyChecker(this, this.recorder.get(), onStopListener, new Handler(Looper.getMainLooper()), 0, 8, null);
        stop();
        destroyChecker.check(timeoutInSeconds);
    }

    public final void explicitRecording() {
        this.explicitRecordingRequested = true;
    }

    public final boolean getExplicitRecordingRequested() {
        return this.explicitRecordingRequested;
    }

    public final AtomicLong getLastReadStartTime() {
        return this.lastReadStartTime;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final boolean isPaused() {
        this.activePauseReasons.getClass();
        return !r0.isEmpty();
    }

    public final void pause(PauseReason pauseReason) {
        pauseReason.getClass();
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("pause " + pauseReason), null);
        if (this.activePauseReasons.contains(pauseReason)) {
            String str2 = "pause ignored since " + pauseReason + " is already in activeReasons: " + this.activePauseReasons;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ReentrantLock reentrantLock = this.pauseLock;
        reentrantLock.lock();
        try {
            this.activePauseReasons.add(pauseReason);
            String str3 = "Recording paused (" + pauseReason + ") active reasons size: " + this.activePauseReasons.size();
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + str3, null);
            if (!this.initialized) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": pause ignored since audioRecorder not initialized", null);
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[pauseReason.ordinal()];
            if (i == 1) {
                List<ConsumerHolder> list = this.consumers;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    ConsumerHolder consumerHolder = (ConsumerHolder) obj;
                    if ((consumerHolder.getConsumer() instanceof RecordingAudioConsumer) || (consumerHolder.getConsumer() instanceof SoundDetectionAudioConsumer)) {
                        arrayList.add(obj);
                    }
                }
                close(arrayList);
            } else if (i == 2) {
                List<ConsumerHolder> list2 = this.consumers;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    ConsumerHolder consumerHolder2 = (ConsumerHolder) obj2;
                    if ((consumerHolder2.getConsumer() instanceof RecordingAudioConsumer) || (consumerHolder2.getConsumer() instanceof SoundDetectionAudioConsumer)) {
                        arrayList2.add(obj2);
                    }
                }
                close(arrayList2);
            } else if (i != 3) {
                List<ConsumerHolder> list3 = this.consumers;
                if (i != 4) {
                    close(list3);
                } else {
                    close(list3);
                }
            } else {
                AudioRecord audioRecord = this.recorder.get();
                if (audioRecord != null) {
                    if (audioRecord.getRecordingState() != 3) {
                        audioRecord = null;
                    }
                    if (audioRecord != null) {
                        audioRecord.stop();
                    }
                }
                close(this.consumers);
            }
            String str4 = "pause done in " + (System.currentTimeMillis() - jCurrentTimeMillis);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str4, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void pauseAsync(PauseReason pauseReason) {
        pauseReason.getClass();
        Utils.doAsyncThrowOnUI(this, new AnonymousClass1(pauseReason, null));
    }

    public final void removeAndCloseConsumerIfPossible(final Consumer consumer) {
        if (consumer != null) {
            List<ConsumerHolder> list = this.consumers;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Intrinsics.areEqual(((ConsumerHolder) obj).getConsumer(), consumer)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ConsumerHolder) it.next()).getConsumer().close();
            }
            CollectionsKt__MutableCollectionsKt.removeAll(this.consumers, new Function1() { // from class: com.urbandroid.sleep.audio.AudioRecorder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(AudioRecorder.removeAndCloseConsumerIfPossible$lambda$0$2(consumer, (AudioRecorder.ConsumerHolder) obj2));
                }
            });
        }
    }

    public final void resume(PauseReason pauseReason) {
        AudioRecord audioRecord;
        pauseReason.getClass();
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("resume " + pauseReason), null);
        if (!this.initialized) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": resume ignored since audioRecorder not initialized", null);
            return;
        }
        if (!this.activePauseReasons.contains(pauseReason)) {
            String str2 = "resume ignored since " + pauseReason + " not in activeReasons: " + this.activePauseReasons;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ReentrantLock reentrantLock = this.pauseLock;
        reentrantLock.lock();
        try {
            this.activePauseReasons.remove(pauseReason);
            String str3 = "Recording resumed (" + pauseReason + "): " + this.activePauseReasons.size();
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + str3, null);
            if (pauseReason == PauseReason.BATTERY_SAVING_MODE && (audioRecord = this.recorder.get()) != null) {
                if (audioRecord.getRecordingState() != 1) {
                    audioRecord = null;
                }
                if (audioRecord != null) {
                    audioRecord.startRecording();
                }
            }
            if (this.activePauseReasons.contains(PauseReason.LULLABY) && this.activePauseReasons.size() == 1) {
                openConsumers(new AiPrompt$$ExternalSyntheticLambda0(3));
            } else if (this.activePauseReasons.contains(PauseReason.LUCID) && this.activePauseReasons.size() == 1) {
                openConsumers(new AiPrompt$$ExternalSyntheticLambda0(4));
            } else if (this.activePauseReasons.size() == 0) {
                openConsumers$default(this, null, 1, null);
            }
            String str4 = "resume pause done in " + (System.currentTimeMillis() - jCurrentTimeMillis);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str4, null);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void resumeAsync(PauseReason pauseReason) {
        pauseReason.getClass();
        Utils.doAsyncThrowOnUI(this, new C20861(pauseReason, null));
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicReference<AudioRecord> atomicReference;
        int i;
        Process.setThreadPriority(-19);
        Logger.logInfo(Logger.defaultTag, getTag() + ":  run ...", null);
        Thread.currentThread().setName("consAudioRecorder");
        if (this.audioWriterCreator == null) {
            Logger.logInfo(Logger.defaultTag, getTag() + ":  warn ... audioWriterCreator is null", null);
            ContextExtKt.sendExplicitBroadcast$default(this.context, new Intent("recording_initialization_failed"), null, 2, null);
        }
        this.recorderLock.lock();
        try {
            this.recorder.set(initialize());
            if (this.recorder.get() == null) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": New recording not supported.", null);
                ContextExtKt.sendExplicitBroadcast$default(this.context, new Intent("recording_initialization_failed"), null, 2, null);
                return;
            }
            int i2 = 0;
            while (true) {
                atomicReference = this.recorder;
                if (i2 >= 400) {
                    break;
                }
                if (atomicReference.get().getRecordingState() != 3) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(50L);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
                i2++;
            }
            if (atomicReference.get().getRecordingState() != 3) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": not in recording state", null);
                ContextExtKt.sendExplicitBroadcast$default(this.context, new Intent("recording_initialization_failed"), null, 2, null);
                if (this.ultrasoundPlayerEngaged) {
                    ContextExtKt.sendExplicitBroadcast$default(this.context, new Intent("ultrasound_recording_initialization_failed"), null, 2, null);
                }
                return;
            }
            Unit unit = Unit.INSTANCE;
            try {
                MaxAmplitudeResolver maxAmplitudeResolver = new MaxAmplitudeResolver(this.ultrasoundPlayerEngaged, this.iirFilterFactory);
                String str = Logger.defaultTag;
                Logger.logInfo(str, getTag() + ": " + ("using MaxAmplitudeResolver"), null);
                boolean zContains = this.activePauseReasons.contains(PauseReason.USER_PAUSED);
                String str2 = Logger.defaultTag;
                Logger.logInfo(str2, getTag() + ": " + ("isUserPaused " + zContains), null);
                if (!zContains) {
                    ReentrantLock reentrantLock = this.pauseLock;
                    reentrantLock.lock();
                    try {
                        openConsumers$default(this, null, 1, null);
                        reentrantLock.unlock();
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                this.initialized = true;
                this.headsetPlugChecker.set(HeadsetPlugChecker.from(this.context).start(new HeadsetPlugChecker.Listener() { // from class: com.urbandroid.sleep.audio.AudioRecorder.run.3
                    @Override // com.urbandroid.common.headset.HeadsetPlugChecker.Listener
                    public void headsetPlugged() {
                        AudioRecorder audioRecorder = AudioRecorder.this;
                        Logger.logInfo(Logger.defaultTag, audioRecorder.getTag() + ": Headset plugged - pausing SonarConsumer", null);
                        AudioRecorder audioRecorder2 = AudioRecorder.this;
                        List list = audioRecorder2.consumers;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((ConsumerHolder) obj).getConsumer() instanceof AbstractSonarConsumer) {
                                arrayList.add(obj);
                            }
                        }
                        audioRecorder2.pause(arrayList);
                    }

                    @Override // com.urbandroid.common.headset.HeadsetPlugChecker.Listener
                    public void headsetUnplugged() {
                        AudioRecorder audioRecorder = AudioRecorder.this;
                        Logger.logInfo(Logger.defaultTag, audioRecorder.getTag() + ": Headset unplugged - resuming SonarConsumer", null);
                        AudioRecorder audioRecorder2 = AudioRecorder.this;
                        List list = audioRecorder2.consumers;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((ConsumerHolder) obj).getConsumer() instanceof AbstractSonarConsumer) {
                                arrayList.add(obj);
                            }
                        }
                        audioRecorder2.resume(arrayList);
                    }
                }));
                this.lastReadStartTime.set(0L);
                long j = (long) (6.5536E7f / this.sampleRate);
                String str3 = Logger.defaultTag;
                Logger.logInfo(str3, getTag() + ": " + ("audioProcessingThresholdTime: " + j), null);
                while (true) {
                    if (!this.running) {
                        break;
                    }
                    this.recorderLock.lock();
                    try {
                        if (this.recorder.get() == null) {
                            break;
                        }
                        int recordingState = this.recorder.get().getRecordingState();
                        ReentrantLock reentrantLock2 = this.recorderLock;
                        if (recordingState == 1) {
                            reentrantLock2.unlock();
                        } else {
                            reentrantLock2.unlock();
                            byte[] bArr = new byte[131072];
                            this.lastReadStartTime.set(System.currentTimeMillis());
                            ReentrantLock reentrantLock3 = this.recorderLock;
                            reentrantLock3.lock();
                            try {
                                AudioRecord audioRecord = this.recorder.get();
                                if (audioRecord != null) {
                                    i = audioRecord.read(bArr, 0, 131072) / 2;
                                    if (i < 0) {
                                        i = 0;
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    i = 0;
                                }
                                reentrantLock3.unlock();
                                AudioReadBuffer audioReadBuffer = new AudioReadBuffer(bArr, i, System.currentTimeMillis());
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                float amplitude = maxAmplitudeResolver.getAmplitude(audioReadBuffer, this.sampleRate);
                                Iterator<T> it = this.noiseLevelRecorders.iterator();
                                while (it.hasNext()) {
                                    ((NoiseLevelRecorder) it.next()).addNoiseLevel(!isPaused() ? amplitude : 0.0f);
                                }
                                Iterator<T> it2 = this.consumers.iterator();
                                while (it2.hasNext()) {
                                    ((ConsumerHolder) it2.next()).process(audioReadBuffer, null);
                                }
                                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                if (isLoggingAllowed() || jCurrentTimeMillis2 >= j - 100) {
                                    String str4 = Logger.defaultTag;
                                    Logger.logInfo(str4, getTag() + ": " + ("Audio Processing took: " + jCurrentTimeMillis2 + " ms"), null);
                                    this.lastLogTimestamp.set(System.currentTimeMillis());
                                    if (jCurrentTimeMillis2 > j) {
                                        AudioThreadManager.dumpThreads();
                                    }
                                }
                            } finally {
                            }
                        }
                    } finally {
                        this.recorderLock.unlock();
                    }
                }
                String str5 = "running: " + this.running + " - stopping ...";
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str5, null);
            } catch (Throwable th2) {
                try {
                    Logger.logSevere(Logger.defaultTag, getTag(), th2);
                    ErrorReporter.getInstance().generateAssertionError(AssertionType.NEW_RECORDER_FAILURE, "Failure in new recording.");
                } finally {
                    close();
                }
            }
        } finally {
        }
    }

    public final void setExplicitRecordingRequested(boolean z) {
        this.explicitRecordingRequested = z;
    }

    public final void stop() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": stop called", null);
        this.running = false;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B-\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/audio/AudioRecorder$DestroyChecker;", "Ljava/lang/Runnable;", "Landroid/media/AudioRecord;", "audioRecord", "Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;", "onDestroyListener", "Landroid/os/Handler;", "handler", "", "leftSeconds", "<init>", "(Lcom/urbandroid/sleep/audio/AudioRecorder;Landroid/media/AudioRecord;Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;Landroid/os/Handler;I)V", "", "run", "()V", "check", "(I)V", "Landroid/media/AudioRecord;", "getAudioRecord", "()Landroid/media/AudioRecord;", "Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;", "getOnDestroyListener", "()Lcom/urbandroid/sleep/audio/AudioRecorder$OnDestroyListener;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "I", "getLeftSeconds", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class DestroyChecker implements Runnable {
        private final AudioRecord audioRecord;
        private final Handler handler;
        private final int leftSeconds;
        private final OnDestroyListener onDestroyListener;
        final /* synthetic */ AudioRecorder this$0;

        public DestroyChecker(AudioRecorder audioRecorder, AudioRecord audioRecord, OnDestroyListener onDestroyListener, Handler handler, int i) {
            onDestroyListener.getClass();
            handler.getClass();
            this.this$0 = audioRecorder;
            this.audioRecord = audioRecord;
            this.onDestroyListener = onDestroyListener;
            this.handler = handler;
            this.leftSeconds = i;
        }

        public final void check(int leftSeconds) {
            Handler handler = this.handler;
            handler.postDelayed(new DestroyChecker(this.this$0, this.audioRecord, this.onDestroyListener, handler, leftSeconds), 1000L);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.leftSeconds > 0) {
                AudioRecord audioRecord = this.audioRecord;
                if (audioRecord != null && audioRecord.getState() != 0) {
                    check(this.leftSeconds - 1);
                    return;
                }
                AudioRecorder audioRecorder = this.this$0;
                Logger.logInfo(Logger.defaultTag, audioRecorder.getTag() + ": AudioRecorder fully destroyed", null);
                this.onDestroyListener.destroyed();
                return;
            }
            AudioRecorder audioRecorder2 = this.this$0;
            AudioRecord audioRecord2 = this.audioRecord;
            String str = "AudioRecorder destroy timeout - state is " + (audioRecord2 != null ? Integer.valueOf(audioRecord2.getState()) : null);
            Logger.logInfo(Logger.defaultTag, audioRecorder2.getTag() + ": " + str, null);
            this.onDestroyListener.timeouted();
        }

        public /* synthetic */ DestroyChecker(AudioRecorder audioRecorder, AudioRecord audioRecord, OnDestroyListener onDestroyListener, Handler handler, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(audioRecorder, audioRecord, onDestroyListener, handler, (i2 & 8) != 0 ? 0 : i);
        }
    }

    public final AudioRecorder addConsumer(Consumer consumer) {
        consumer.getClass();
        return addConsumer$default(this, consumer, 0, 2, null);
    }

    private final void close(List<ConsumerHolder> list) {
        String strM = Fragment$$ExternalSyntheticOutline1.m(list.size(), "closing ", " consumers ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        ArrayList<ConsumerHolder> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConsumerHolder) obj).getConsumer().getState() != Consumer.State.CLOSED) {
                arrayList.add(obj);
            }
        }
        for (ConsumerHolder consumerHolder : arrayList) {
            try {
                consumerHolder.getConsumer().close();
            } catch (Exception e) {
                String strM2 = FileInsert$$ExternalSyntheticOutline0.m("Closing ", consumerHolder.getConsumer().getClass().getSimpleName(), " failure");
                Logger.logSevere(Logger.defaultTag, getTag() + ": " + strM2, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resume(List<ConsumerHolder> list) {
        String strM = Fragment$$ExternalSyntheticOutline1.m(list.size(), "resuming ", " consumers ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        for (ConsumerHolder consumerHolder : list) {
            if (WhenMappings.$EnumSwitchMapping$1[consumerHolder.getConsumer().getState().ordinal()] == 1) {
                AudioWriterCreator audioWriterCreator = this.audioWriterCreator;
                if (audioWriterCreator != null) {
                    consumerHolder.open(audioWriterCreator);
                }
            } else {
                consumerHolder.getConsumer().resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pause(List<ConsumerHolder> list) {
        String strM = Fragment$$ExternalSyntheticOutline1.m(list.size(), "pausing ", " consumers ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ConsumerHolder) it.next()).getConsumer().pause();
        }
    }
}

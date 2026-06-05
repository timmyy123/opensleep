package com.google.firebase.ai.type;

import android.media.AudioRecord;
import android.media.AudioTrack;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cBy\b\u0002\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R,\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/ai/type/LiveAudioConversationConfig;", "", "functionCallHandler", "Lkotlin/Function1;", "Lcom/google/firebase/ai/type/FunctionCallPart;", "Lcom/google/firebase/ai/type/FunctionResponsePart;", "initializationHandler", "Lkotlin/Function2;", "Landroid/media/AudioRecord$Builder;", "Landroid/media/AudioTrack$Builder;", "", "transcriptHandler", "Lcom/google/firebase/ai/type/Transcription;", "goAwayHandler", "Lcom/google/firebase/ai/type/LiveServerGoAway;", "enableInterruptions", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Z)V", "getFunctionCallHandler$com_google_firebase_ai_logic_firebase_ai", "()Lkotlin/jvm/functions/Function1;", "getInitializationHandler$com_google_firebase_ai_logic_firebase_ai", "()Lkotlin/jvm/functions/Function2;", "getTranscriptHandler$com_google_firebase_ai_logic_firebase_ai", "getGoAwayHandler$com_google_firebase_ai_logic_firebase_ai", "getEnableInterruptions$com_google_firebase_ai_logic_firebase_ai", "()Z", "Builder", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveAudioConversationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean enableInterruptions;
    private final Function1<FunctionCallPart, FunctionResponsePart> functionCallHandler;
    private final Function1<LiveServerGoAway, Unit> goAwayHandler;
    private final Function2<AudioRecord.Builder, AudioTrack.Builder, Unit> initializationHandler;
    private final Function2<Transcription, Transcription, Unit> transcriptHandler;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005J\"\u0010\u0014\u001a\u00020\u00002\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tJ&\u0010\u0015\u001a\u00020\u00002\u001e\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\tJ\u001c\u0010\u0016\u001a\u00020\u00002\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0019R \u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/ai/type/LiveAudioConversationConfig$Builder;", "", "<init>", "()V", "functionCallHandler", "Lkotlin/Function1;", "Lcom/google/firebase/ai/type/FunctionCallPart;", "Lcom/google/firebase/ai/type/FunctionResponsePart;", "initializationHandler", "Lkotlin/Function2;", "Landroid/media/AudioRecord$Builder;", "Landroid/media/AudioTrack$Builder;", "", "transcriptHandler", "Lcom/google/firebase/ai/type/Transcription;", "goAwayHandler", "Lcom/google/firebase/ai/type/LiveServerGoAway;", "enableInterruptions", "", "setFunctionCallHandler", "setInitializationHandler", "setTranscriptHandler", "setGoAwayHandler", "setEnableInterruptions", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/LiveAudioConversationConfig;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public boolean enableInterruptions;
        public Function1<? super FunctionCallPart, FunctionResponsePart> functionCallHandler;
        public Function1<? super LiveServerGoAway, Unit> goAwayHandler;
        public Function2<? super AudioRecord.Builder, ? super AudioTrack.Builder, Unit> initializationHandler;
        public Function2<? super Transcription, ? super Transcription, Unit> transcriptHandler;

        public final LiveAudioConversationConfig build() {
            return new LiveAudioConversationConfig(this.functionCallHandler, this.initializationHandler, this.transcriptHandler, this.goAwayHandler, this.enableInterruptions, null);
        }

        public final Builder setEnableInterruptions(boolean enableInterruptions) {
            this.enableInterruptions = enableInterruptions;
            return this;
        }

        public final Builder setFunctionCallHandler(Function1<? super FunctionCallPart, FunctionResponsePart> functionCallHandler) {
            this.functionCallHandler = functionCallHandler;
            return this;
        }

        public final Builder setGoAwayHandler(Function1<? super LiveServerGoAway, Unit> goAwayHandler) {
            this.goAwayHandler = goAwayHandler;
            return this;
        }

        public final Builder setInitializationHandler(Function2<? super AudioRecord.Builder, ? super AudioTrack.Builder, Unit> initializationHandler) {
            this.initializationHandler = initializationHandler;
            return this;
        }

        public final Builder setTranscriptHandler(Function2<? super Transcription, ? super Transcription, Unit> transcriptHandler) {
            this.transcriptHandler = transcriptHandler;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/LiveAudioConversationConfig$Companion;", "", "<init>", "()V", "builder", "Lcom/google/firebase/ai/type/LiveAudioConversationConfig$Builder;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LiveAudioConversationConfig(Function1<? super FunctionCallPart, FunctionResponsePart> function1, Function2<? super AudioRecord.Builder, ? super AudioTrack.Builder, Unit> function2, Function2<? super Transcription, ? super Transcription, Unit> function22, Function1<? super LiveServerGoAway, Unit> function12, boolean z) {
        this.functionCallHandler = function1;
        this.initializationHandler = function2;
        this.transcriptHandler = function22;
        this.goAwayHandler = function12;
        this.enableInterruptions = z;
    }

    /* JADX INFO: renamed from: getEnableInterruptions$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final boolean getEnableInterruptions() {
        return this.enableInterruptions;
    }

    public final Function1<FunctionCallPart, FunctionResponsePart> getFunctionCallHandler$com_google_firebase_ai_logic_firebase_ai() {
        return this.functionCallHandler;
    }

    public final Function1<LiveServerGoAway, Unit> getGoAwayHandler$com_google_firebase_ai_logic_firebase_ai() {
        return this.goAwayHandler;
    }

    public final Function2<AudioRecord.Builder, AudioTrack.Builder, Unit> getInitializationHandler$com_google_firebase_ai_logic_firebase_ai() {
        return this.initializationHandler;
    }

    public final Function2<Transcription, Transcription, Unit> getTranscriptHandler$com_google_firebase_ai_logic_firebase_ai() {
        return this.transcriptHandler;
    }

    public /* synthetic */ LiveAudioConversationConfig(Function1 function1, Function2 function2, Function2 function22, Function1 function12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, function22, function12, z);
    }
}

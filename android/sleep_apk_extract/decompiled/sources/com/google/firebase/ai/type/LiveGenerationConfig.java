package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.SpeechConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0003'()Bm\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"¨\u0006*"}, d2 = {"Lcom/google/firebase/ai/type/LiveGenerationConfig;", "", "temperature", "", "topK", "", "topP", "maxOutputTokens", "presencePenalty", "frequencyPenalty", "responseModality", "Lcom/google/firebase/ai/type/ResponseModality;", "speechConfig", "Lcom/google/firebase/ai/type/SpeechConfig;", "inputAudioTranscription", "Lcom/google/firebase/ai/type/AudioTranscriptionConfig;", "outputAudioTranscription", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/ResponseModality;Lcom/google/firebase/ai/type/SpeechConfig;Lcom/google/firebase/ai/type/AudioTranscriptionConfig;Lcom/google/firebase/ai/type/AudioTranscriptionConfig;)V", "getTemperature$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopK$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopP$com_google_firebase_ai_logic_firebase_ai", "getMaxOutputTokens$com_google_firebase_ai_logic_firebase_ai", "getPresencePenalty$com_google_firebase_ai_logic_firebase_ai", "getFrequencyPenalty$com_google_firebase_ai_logic_firebase_ai", "getResponseModality$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ResponseModality;", "getSpeechConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/SpeechConfig;", "getInputAudioTranscription$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/AudioTranscriptionConfig;", "getOutputAudioTranscription$com_google_firebase_ai_logic_firebase_ai", "toInternal", "Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Builder", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveGenerationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Float frequencyPenalty;
    private final AudioTranscriptionConfig inputAudioTranscription;
    private final Integer maxOutputTokens;
    private final AudioTranscriptionConfig outputAudioTranscription;
    private final Float presencePenalty;
    private final ResponseModality responseModality;
    private final SpeechConfig speechConfig;
    private final Float temperature;
    private final Integer topK;
    private final Float topP;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0013J\u0010\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0013J\u0006\u0010\"\u001a\u00020#R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/google/firebase/ai/type/LiveGenerationConfig$Builder;", "", "<init>", "()V", "temperature", "", "Ljava/lang/Float;", "topK", "", "Ljava/lang/Integer;", "topP", "maxOutputTokens", "presencePenalty", "frequencyPenalty", "responseModality", "Lcom/google/firebase/ai/type/ResponseModality;", "speechConfig", "Lcom/google/firebase/ai/type/SpeechConfig;", "inputAudioTranscription", "Lcom/google/firebase/ai/type/AudioTranscriptionConfig;", "outputAudioTranscription", "setTemperature", "(Ljava/lang/Float;)Lcom/google/firebase/ai/type/LiveGenerationConfig$Builder;", "setTopK", "(Ljava/lang/Integer;)Lcom/google/firebase/ai/type/LiveGenerationConfig$Builder;", "setTopP", "setMaxOutputTokens", "setPresencePenalty", "setFrequencyPenalty", "setResponseModality", "setSpeechConfig", "setInputAudioTranscription", "config", "setOutputAudioTranscription", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/LiveGenerationConfig;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public Float frequencyPenalty;
        public AudioTranscriptionConfig inputAudioTranscription;
        public Integer maxOutputTokens;
        public AudioTranscriptionConfig outputAudioTranscription;
        public Float presencePenalty;
        public ResponseModality responseModality;
        public SpeechConfig speechConfig;
        public Float temperature;
        public Integer topK;
        public Float topP;

        public final LiveGenerationConfig build() {
            return new LiveGenerationConfig(this.temperature, this.topK, this.topP, this.maxOutputTokens, this.presencePenalty, this.frequencyPenalty, this.responseModality, this.speechConfig, this.inputAudioTranscription, this.outputAudioTranscription, null);
        }

        public final Builder setFrequencyPenalty(Float frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        public final Builder setInputAudioTranscription(AudioTranscriptionConfig config) {
            this.inputAudioTranscription = config;
            return this;
        }

        public final Builder setMaxOutputTokens(Integer maxOutputTokens) {
            this.maxOutputTokens = maxOutputTokens;
            return this;
        }

        public final Builder setOutputAudioTranscription(AudioTranscriptionConfig config) {
            this.outputAudioTranscription = config;
            return this;
        }

        public final Builder setPresencePenalty(Float presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        public final Builder setResponseModality(ResponseModality responseModality) {
            this.responseModality = responseModality;
            return this;
        }

        public final Builder setSpeechConfig(SpeechConfig speechConfig) {
            this.speechConfig = speechConfig;
            return this;
        }

        public final Builder setTemperature(Float temperature) {
            this.temperature = temperature;
            return this;
        }

        public final Builder setTopK(Integer topK) {
            this.topK = topK;
            return this;
        }

        public final Builder setTopP(Float topP) {
            this.topP = topP;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/LiveGenerationConfig$Companion;", "", "<init>", "()V", "builder", "Lcom/google/firebase/ai/type/LiveGenerationConfig$Builder;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    private LiveGenerationConfig(Float f, Integer num, Float f2, Integer num2, Float f3, Float f4, ResponseModality responseModality, SpeechConfig speechConfig, AudioTranscriptionConfig audioTranscriptionConfig, AudioTranscriptionConfig audioTranscriptionConfig2) {
        this.temperature = f;
        this.topK = num;
        this.topP = f2;
        this.maxOutputTokens = num2;
        this.presencePenalty = f3;
        this.frequencyPenalty = f4;
        this.responseModality = responseModality;
        this.speechConfig = speechConfig;
        this.inputAudioTranscription = audioTranscriptionConfig;
        this.outputAudioTranscription = audioTranscriptionConfig2;
    }

    /* JADX INFO: renamed from: getFrequencyPenalty$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    /* JADX INFO: renamed from: getInputAudioTranscription$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final AudioTranscriptionConfig getInputAudioTranscription() {
        return this.inputAudioTranscription;
    }

    /* JADX INFO: renamed from: getMaxOutputTokens$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getMaxOutputTokens() {
        return this.maxOutputTokens;
    }

    /* JADX INFO: renamed from: getOutputAudioTranscription$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final AudioTranscriptionConfig getOutputAudioTranscription() {
        return this.outputAudioTranscription;
    }

    /* JADX INFO: renamed from: getPresencePenalty$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getPresencePenalty() {
        return this.presencePenalty;
    }

    /* JADX INFO: renamed from: getResponseModality$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ResponseModality getResponseModality() {
        return this.responseModality;
    }

    /* JADX INFO: renamed from: getSpeechConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final SpeechConfig getSpeechConfig() {
        return this.speechConfig;
    }

    /* JADX INFO: renamed from: getTemperature$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: renamed from: getTopK$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getTopK() {
        return this.topK;
    }

    /* JADX INFO: renamed from: getTopP$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getTopP() {
        return this.topP;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        Float f = this.temperature;
        Float f2 = this.topP;
        Integer num = this.topK;
        Integer num2 = this.maxOutputTokens;
        Float f3 = this.frequencyPenalty;
        Float f4 = this.presencePenalty;
        SpeechConfig speechConfig = this.speechConfig;
        SpeechConfig.Internal internal$com_google_firebase_ai_logic_firebase_ai = speechConfig != null ? speechConfig.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        ResponseModality responseModality = this.responseModality;
        return new Internal(f, f2, num, num2, f4, f3, internal$com_google_firebase_ai_logic_firebase_ai, responseModality != null ? CollectionsKt.listOf(responseModality.toInternal$com_google_firebase_ai_logic_firebase_ai()) : null);
    }

    public /* synthetic */ LiveGenerationConfig(Float f, Integer num, Float f2, Integer num2, Float f3, Float f4, ResponseModality responseModality, SpeechConfig speechConfig, AudioTranscriptionConfig audioTranscriptionConfig, AudioTranscriptionConfig audioTranscriptionConfig2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, num, f2, num2, f3, f4, responseModality, speechConfig, audioTranscriptionConfig, audioTranscriptionConfig2);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 C2\u00020\u0001:\u0002BCBe\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010Bq\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jt\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020\u000eHÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001dR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010'R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010*¨\u0006D"}, d2 = {"Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "", "temperature", "", "topP", "topK", "", "maxOutputTokens", "presencePenalty", "frequencyPenalty", "speechConfig", "Lcom/google/firebase/ai/type/SpeechConfig$Internal;", "responseModalities", "", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/SpeechConfig$Internal;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/SpeechConfig$Internal;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTemperature", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopP$annotations", "()V", "getTopP", "getTopK$annotations", "getTopK", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxOutputTokens$annotations", "getMaxOutputTokens", "getPresencePenalty$annotations", "getPresencePenalty", "getFrequencyPenalty$annotations", "getFrequencyPenalty", "getSpeechConfig$annotations", "getSpeechConfig", "()Lcom/google/firebase/ai/type/SpeechConfig$Internal;", "getResponseModalities$annotations", "getResponseModalities", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/SpeechConfig$Internal;Ljava/util/List;)Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final Float frequencyPenalty;
        private final Integer maxOutputTokens;
        private final Float presencePenalty;
        private final List<String> responseModalities;
        private final SpeechConfig.Internal speechConfig;
        private final Float temperature;
        private final Integer topK;
        private final Float topP;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveGenerationConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return LiveGenerationConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, Float f, Float f2, Integer num, Integer num2, Float f3, Float f4, SpeechConfig.Internal internal, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, LiveGenerationConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.temperature = f;
            this.topP = f2;
            this.topK = num;
            this.maxOutputTokens = num2;
            if ((i & 16) == 0) {
                this.presencePenalty = null;
            } else {
                this.presencePenalty = f3;
            }
            if ((i & 32) == 0) {
                this.frequencyPenalty = null;
            } else {
                this.frequencyPenalty = f4;
            }
            if ((i & 64) == 0) {
                this.speechConfig = null;
            } else {
                this.speechConfig = internal;
            }
            if ((i & 128) == 0) {
                this.responseModalities = null;
            } else {
                this.responseModalities = list;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Float f, Float f2, Integer num, Integer num2, Float f3, Float f4, SpeechConfig.Internal internal2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                f = internal.temperature;
            }
            if ((i & 2) != 0) {
                f2 = internal.topP;
            }
            if ((i & 4) != 0) {
                num = internal.topK;
            }
            if ((i & 8) != 0) {
                num2 = internal.maxOutputTokens;
            }
            if ((i & 16) != 0) {
                f3 = internal.presencePenalty;
            }
            if ((i & 32) != 0) {
                f4 = internal.frequencyPenalty;
            }
            if ((i & 64) != 0) {
                internal2 = internal.speechConfig;
            }
            if ((i & 128) != 0) {
                list = internal.responseModalities;
            }
            SpeechConfig.Internal internal3 = internal2;
            List list2 = list;
            Float f5 = f3;
            Float f6 = f4;
            return internal.copy(f, f2, num, num2, f5, f6, internal3, list2);
        }

        @SerialName("frequency_penalty")
        public static /* synthetic */ void getFrequencyPenalty$annotations() {
        }

        @SerialName("max_output_tokens")
        public static /* synthetic */ void getMaxOutputTokens$annotations() {
        }

        @SerialName("presence_penalty")
        public static /* synthetic */ void getPresencePenalty$annotations() {
        }

        @SerialName("response_modalities")
        public static /* synthetic */ void getResponseModalities$annotations() {
        }

        @SerialName("speech_config")
        public static /* synthetic */ void getSpeechConfig$annotations() {
        }

        @SerialName("top_k")
        public static /* synthetic */ void getTopK$annotations() {
        }

        @SerialName("top_p")
        public static /* synthetic */ void getTopP$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 0, floatSerializer, self.temperature);
            output.encodeNullableSerializableElement(serialDesc, 1, floatSerializer, self.topP);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 2, intSerializer, self.topK);
            output.encodeNullableSerializableElement(serialDesc, 3, intSerializer, self.maxOutputTokens);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.presencePenalty != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, floatSerializer, self.presencePenalty);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.frequencyPenalty != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, floatSerializer, self.frequencyPenalty);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.speechConfig != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, SpeechConfig$Internal$$serializer.INSTANCE, self.speechConfig);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.responseModalities == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.responseModalities);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Float getTemperature() {
            return this.temperature;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Float getTopP() {
            return this.topP;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTopK() {
            return this.topK;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getMaxOutputTokens() {
            return this.maxOutputTokens;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Float getPresencePenalty() {
            return this.presencePenalty;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Float getFrequencyPenalty() {
            return this.frequencyPenalty;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final SpeechConfig.Internal getSpeechConfig() {
            return this.speechConfig;
        }

        public final List<String> component8() {
            return this.responseModalities;
        }

        public final Internal copy(Float temperature, Float topP, Integer topK, Integer maxOutputTokens, Float presencePenalty, Float frequencyPenalty, SpeechConfig.Internal speechConfig, List<String> responseModalities) {
            return new Internal(temperature, topP, topK, maxOutputTokens, presencePenalty, frequencyPenalty, speechConfig, responseModalities);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual((Object) this.temperature, (Object) internal.temperature) && Intrinsics.areEqual((Object) this.topP, (Object) internal.topP) && Intrinsics.areEqual(this.topK, internal.topK) && Intrinsics.areEqual(this.maxOutputTokens, internal.maxOutputTokens) && Intrinsics.areEqual((Object) this.presencePenalty, (Object) internal.presencePenalty) && Intrinsics.areEqual((Object) this.frequencyPenalty, (Object) internal.frequencyPenalty) && Intrinsics.areEqual(this.speechConfig, internal.speechConfig) && Intrinsics.areEqual(this.responseModalities, internal.responseModalities);
        }

        public final Float getFrequencyPenalty() {
            return this.frequencyPenalty;
        }

        public final Integer getMaxOutputTokens() {
            return this.maxOutputTokens;
        }

        public final Float getPresencePenalty() {
            return this.presencePenalty;
        }

        public final List<String> getResponseModalities() {
            return this.responseModalities;
        }

        public final SpeechConfig.Internal getSpeechConfig() {
            return this.speechConfig;
        }

        public final Float getTemperature() {
            return this.temperature;
        }

        public final Integer getTopK() {
            return this.topK;
        }

        public final Float getTopP() {
            return this.topP;
        }

        public int hashCode() {
            Float f = this.temperature;
            int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
            Float f2 = this.topP;
            int iHashCode2 = (iHashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
            Integer num = this.topK;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.maxOutputTokens;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Float f3 = this.presencePenalty;
            int iHashCode5 = (iHashCode4 + (f3 == null ? 0 : f3.hashCode())) * 31;
            Float f4 = this.frequencyPenalty;
            int iHashCode6 = (iHashCode5 + (f4 == null ? 0 : f4.hashCode())) * 31;
            SpeechConfig.Internal internal = this.speechConfig;
            int iHashCode7 = (iHashCode6 + (internal == null ? 0 : internal.hashCode())) * 31;
            List<String> list = this.responseModalities;
            return iHashCode7 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(temperature=");
            sb.append(this.temperature);
            sb.append(", topP=");
            sb.append(this.topP);
            sb.append(", topK=");
            sb.append(this.topK);
            sb.append(", maxOutputTokens=");
            sb.append(this.maxOutputTokens);
            sb.append(", presencePenalty=");
            sb.append(this.presencePenalty);
            sb.append(", frequencyPenalty=");
            sb.append(this.frequencyPenalty);
            sb.append(", speechConfig=");
            sb.append(this.speechConfig);
            sb.append(", responseModalities=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.responseModalities, ')');
        }

        public Internal(Float f, Float f2, Integer num, Integer num2, Float f3, Float f4, SpeechConfig.Internal internal, List<String> list) {
            this.temperature = f;
            this.topP = f2;
            this.topK = num;
            this.maxOutputTokens = num2;
            this.presencePenalty = f3;
            this.frequencyPenalty = f4;
            this.speechConfig = internal;
            this.responseModalities = list;
        }

        public /* synthetic */ Internal(Float f, Float f2, Integer num, Integer num2, Float f3, Float f4, SpeechConfig.Internal internal, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, num, num2, (i & 16) != 0 ? null : f3, (i & 32) != 0 ? null : f4, (i & 64) != 0 ? null : internal, (i & 128) != 0 ? null : list);
        }
    }
}

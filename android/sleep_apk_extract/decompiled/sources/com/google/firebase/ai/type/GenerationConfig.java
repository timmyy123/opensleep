package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.Schema;
import com.google.firebase.ai.type.ThinkingConfig;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u0003456B\u009b\u0001\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010/\u001a\u000200J\r\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u001aR\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00067"}, d2 = {"Lcom/google/firebase/ai/type/GenerationConfig;", "", "temperature", "", "topK", "", "topP", "candidateCount", "maxOutputTokens", "presencePenalty", "frequencyPenalty", "stopSequences", "", "", "responseMimeType", "responseSchema", "Lcom/google/firebase/ai/type/Schema;", "responseJsonSchema", "Lcom/google/firebase/ai/type/JsonSchema;", "responseModalities", "Lcom/google/firebase/ai/type/ResponseModality;", "thinkingConfig", "Lcom/google/firebase/ai/type/ThinkingConfig;", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Lcom/google/firebase/ai/type/Schema;Lcom/google/firebase/ai/type/JsonSchema;Ljava/util/List;Lcom/google/firebase/ai/type/ThinkingConfig;)V", "getTemperature$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopK$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopP$com_google_firebase_ai_logic_firebase_ai", "getCandidateCount$com_google_firebase_ai_logic_firebase_ai", "getMaxOutputTokens$com_google_firebase_ai_logic_firebase_ai", "getPresencePenalty$com_google_firebase_ai_logic_firebase_ai", "getFrequencyPenalty$com_google_firebase_ai_logic_firebase_ai", "getStopSequences$com_google_firebase_ai_logic_firebase_ai", "()Ljava/util/List;", "getResponseMimeType$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "getResponseSchema$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/Schema;", "getResponseJsonSchema$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/JsonSchema;", "getResponseModalities$com_google_firebase_ai_logic_firebase_ai", "getThinkingConfig$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ThinkingConfig;", "toBuilder", "Lcom/google/firebase/ai/type/GenerationConfig$Builder;", "toInternal", "Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Builder", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer candidateCount;
    private final Float frequencyPenalty;
    private final Integer maxOutputTokens;
    private final Float presencePenalty;
    private final JsonSchema<?> responseJsonSchema;
    private final String responseMimeType;
    private final List<ResponseModality> responseModalities;
    private final Schema responseSchema;
    private final List<String> stopSequences;
    private final Float temperature;
    private final ThinkingConfig thinkingConfig;
    private final Integer topK;
    private final Float topP;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/GenerationConfig$Companion;", "", "<init>", "()V", "builder", "Lcom/google/firebase/ai/type/GenerationConfig$Builder;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    private GenerationConfig(Float f, Integer num, Float f2, Integer num2, Integer num3, Float f3, Float f4, List<String> list, String str, Schema schema, JsonSchema<?> jsonSchema, List<ResponseModality> list2, ThinkingConfig thinkingConfig) {
        this.temperature = f;
        this.topK = num;
        this.topP = f2;
        this.candidateCount = num2;
        this.maxOutputTokens = num3;
        this.presencePenalty = f3;
        this.frequencyPenalty = f4;
        this.stopSequences = list;
        this.responseMimeType = str;
        this.responseSchema = schema;
        this.responseJsonSchema = jsonSchema;
        this.responseModalities = list2;
        this.thinkingConfig = thinkingConfig;
    }

    public static final Builder builder() {
        return INSTANCE.builder();
    }

    /* JADX INFO: renamed from: getCandidateCount$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getCandidateCount() {
        return this.candidateCount;
    }

    /* JADX INFO: renamed from: getFrequencyPenalty$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    /* JADX INFO: renamed from: getMaxOutputTokens$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getMaxOutputTokens() {
        return this.maxOutputTokens;
    }

    /* JADX INFO: renamed from: getPresencePenalty$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getPresencePenalty() {
        return this.presencePenalty;
    }

    public final JsonSchema<?> getResponseJsonSchema$com_google_firebase_ai_logic_firebase_ai() {
        return this.responseJsonSchema;
    }

    /* JADX INFO: renamed from: getResponseMimeType$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getResponseMimeType() {
        return this.responseMimeType;
    }

    public final List<ResponseModality> getResponseModalities$com_google_firebase_ai_logic_firebase_ai() {
        return this.responseModalities;
    }

    /* JADX INFO: renamed from: getResponseSchema$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Schema getResponseSchema() {
        return this.responseSchema;
    }

    public final List<String> getStopSequences$com_google_firebase_ai_logic_firebase_ai() {
        return this.stopSequences;
    }

    /* JADX INFO: renamed from: getTemperature$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: renamed from: getThinkingConfig$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ThinkingConfig getThinkingConfig() {
        return this.thinkingConfig;
    }

    /* JADX INFO: renamed from: getTopK$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Integer getTopK() {
        return this.topK;
    }

    /* JADX INFO: renamed from: getTopP$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final Float getTopP() {
        return this.topP;
    }

    public final Builder toBuilder() {
        return new Builder(this.temperature, this.topK, this.topP, this.candidateCount, this.maxOutputTokens, this.presencePenalty, this.frequencyPenalty, this.stopSequences, this.responseMimeType, this.responseSchema, this.responseJsonSchema, this.responseModalities, this.thinkingConfig);
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        ArrayList arrayList;
        Float f = this.temperature;
        Float f2 = this.topP;
        Integer num = this.topK;
        Integer num2 = this.candidateCount;
        Integer num3 = this.maxOutputTokens;
        List<String> list = this.stopSequences;
        Float f3 = this.frequencyPenalty;
        Float f4 = this.presencePenalty;
        String str = this.responseMimeType;
        Schema schema = this.responseSchema;
        Schema.InternalOpenAPI internalOpenApi$com_google_firebase_ai_logic_firebase_ai = schema != null ? schema.toInternalOpenApi$com_google_firebase_ai_logic_firebase_ai() : null;
        JsonSchema<?> jsonSchema = this.responseJsonSchema;
        Schema.InternalJson internalJson$com_google_firebase_ai_logic_firebase_ai = jsonSchema != null ? jsonSchema.toInternalJson$com_google_firebase_ai_logic_firebase_ai() : null;
        List<ResponseModality> list2 = this.responseModalities;
        if (list2 != null) {
            List<ResponseModality> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ResponseModality) it.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        ThinkingConfig thinkingConfig = this.thinkingConfig;
        return new Internal(f, f2, num, num2, num3, list, str, f4, f3, internalOpenApi$com_google_firebase_ai_logic_firebase_ai, internalJson$com_google_firebase_ai_logic_firebase_ai, arrayList, thinkingConfig != null ? thinkingConfig.toInternal$com_google_firebase_ai_logic_firebase_ai() : null);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u009b\u0001\b\u0010\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0002\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u0015\u0010!\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001fJ\u0015\u0010#\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u0015\u0010$\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u0016\u0010%\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0010\u0010&\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0014\u0010(\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014J\u0016\u0010*\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000eJ\u0010\u0010+\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010,\u001a\u00020-R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/google/firebase/ai/type/GenerationConfig$Builder;", "", "<init>", "()V", "temperature", "", "topK", "", "topP", "candidateCount", "maxOutputTokens", "presencePenalty", "frequencyPenalty", "stopSequences", "", "", "responseMimeType", "responseSchema", "Lcom/google/firebase/ai/type/Schema;", "responseJsonSchema", "Lcom/google/firebase/ai/type/JsonSchema;", "responseModalities", "Lcom/google/firebase/ai/type/ResponseModality;", "thinkingConfig", "Lcom/google/firebase/ai/type/ThinkingConfig;", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Lcom/google/firebase/ai/type/Schema;Lcom/google/firebase/ai/type/JsonSchema;Ljava/util/List;Lcom/google/firebase/ai/type/ThinkingConfig;)V", "Ljava/lang/Float;", "Ljava/lang/Integer;", "setTemperature", "(Ljava/lang/Float;)Lcom/google/firebase/ai/type/GenerationConfig$Builder;", "setTopK", "(Ljava/lang/Integer;)Lcom/google/firebase/ai/type/GenerationConfig$Builder;", "setTopP", "setCandidateCount", "setMaxOutputTokens", "setPresencePenalty", "setFrequencyPenalty", "setStopSequences", "setResponseMimeType", "setResponseSchema", "setResponseSchemaJson", "responseSchemaJson", "setResponseModalities", "setThinkingConfig", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/GenerationConfig;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public Integer candidateCount;
        public Float frequencyPenalty;
        public Integer maxOutputTokens;
        public Float presencePenalty;
        public JsonSchema<?> responseJsonSchema;
        public String responseMimeType;
        public List<ResponseModality> responseModalities;
        public Schema responseSchema;
        public List<String> stopSequences;
        public Float temperature;
        public ThinkingConfig thinkingConfig;
        public Integer topK;
        public Float topP;

        public Builder(Float f, Integer num, Float f2, Integer num2, Integer num3, Float f3, Float f4, List<String> list, String str, Schema schema, JsonSchema<?> jsonSchema, List<ResponseModality> list2, ThinkingConfig thinkingConfig) {
            this.temperature = f;
            this.topK = num;
            this.topP = f2;
            this.candidateCount = num2;
            this.maxOutputTokens = num3;
            this.stopSequences = list;
            this.presencePenalty = f3;
            this.frequencyPenalty = f4;
            this.responseMimeType = str;
            this.responseSchema = schema;
            this.responseJsonSchema = jsonSchema;
            this.responseModalities = list2;
            this.thinkingConfig = thinkingConfig;
        }

        public final GenerationConfig build() {
            Schema schema = this.responseSchema;
            if (schema != null && this.responseJsonSchema != null) {
                throw new InvalidStateException("responseSchema and responseJsonSchema are mutually exclusive.", null, 2, null);
            }
            return new GenerationConfig(this.temperature, this.topK, this.topP, this.candidateCount, this.maxOutputTokens, this.presencePenalty, this.frequencyPenalty, this.stopSequences, this.responseMimeType, schema, this.responseJsonSchema, this.responseModalities, this.thinkingConfig, null);
        }

        public final Builder setCandidateCount(Integer candidateCount) {
            this.candidateCount = candidateCount;
            return this;
        }

        public final Builder setFrequencyPenalty(Float frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        public final Builder setMaxOutputTokens(Integer maxOutputTokens) {
            this.maxOutputTokens = maxOutputTokens;
            return this;
        }

        public final Builder setPresencePenalty(Float presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        public final Builder setResponseMimeType(String responseMimeType) {
            this.responseMimeType = responseMimeType;
            return this;
        }

        public final Builder setResponseModalities(List<ResponseModality> responseModalities) {
            this.responseModalities = responseModalities;
            return this;
        }

        public final Builder setResponseSchema(Schema responseSchema) {
            this.responseSchema = responseSchema;
            return this;
        }

        public final Builder setResponseSchemaJson(JsonSchema<?> responseSchemaJson) {
            this.responseJsonSchema = responseSchemaJson;
            return this;
        }

        public final Builder setStopSequences(List<String> stopSequences) {
            this.stopSequences = stopSequences;
            return this;
        }

        public final Builder setTemperature(Float temperature) {
            this.temperature = temperature;
            return this;
        }

        public final Builder setThinkingConfig(ThinkingConfig thinkingConfig) {
            this.thinkingConfig = thinkingConfig;
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

        public Builder() {
        }
    }

    public /* synthetic */ GenerationConfig(Float f, Integer num, Float f2, Integer num2, Integer num3, Float f3, Float f4, List list, String str, Schema schema, JsonSchema jsonSchema, List list2, ThinkingConfig thinkingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, num, f2, num2, num3, f3, f4, list, str, schema, jsonSchema, list2, thinkingConfig);
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \\2\u00020\u0001:\u0002[\\B£\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017B©\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010H\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0015HÆ\u0003J¶\u0001\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u0006HÖ\u0001J\t\u0010R\u001a\u00020\u000bHÖ\u0001J%\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0001¢\u0006\u0002\bZR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001dR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b\"\u0010 \u001a\u0004\b#\u0010$R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b&\u0010 \u001a\u0004\b'\u0010$R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010$R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010 \u001a\u0004\b+\u0010,R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010 \u001a\u0004\b.\u0010/R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b0\u0010 \u001a\u0004\b1\u0010\u001dR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b2\u0010 \u001a\u0004\b3\u0010\u001dR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010 \u001a\u0004\b5\u00106R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010 \u001a\u0004\b8\u00109R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010 \u001a\u0004\b;\u0010,R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010 \u001a\u0004\b=\u0010>¨\u0006]"}, d2 = {"Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "", "temperature", "", "topP", "topK", "", "candidateCount", "maxOutputTokens", "stopSequences", "", "", "responseMimeType", "presencePenalty", "frequencyPenalty", "responseSchema", "Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "responseJsonSchema", "Lcom/google/firebase/ai/type/Schema$InternalJson;", "responseModalities", "thinkingConfig", "Lcom/google/firebase/ai/type/ThinkingConfig$Internal;", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/util/List;Lcom/google/firebase/ai/type/ThinkingConfig$Internal;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/util/List;Lcom/google/firebase/ai/type/ThinkingConfig$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTemperature", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopP$annotations", "()V", "getTopP", "getTopK$annotations", "getTopK", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCandidateCount$annotations", "getCandidateCount", "getMaxOutputTokens$annotations", "getMaxOutputTokens", "getStopSequences$annotations", "getStopSequences", "()Ljava/util/List;", "getResponseMimeType$annotations", "getResponseMimeType", "()Ljava/lang/String;", "getPresencePenalty$annotations", "getPresencePenalty", "getFrequencyPenalty$annotations", "getFrequencyPenalty", "getResponseSchema$annotations", "getResponseSchema", "()Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;", "getResponseJsonSchema$annotations", "getResponseJsonSchema", "()Lcom/google/firebase/ai/type/Schema$InternalJson;", "getResponseModalities$annotations", "getResponseModalities", "getThinkingConfig$annotations", "getThinkingConfig", "()Lcom/google/firebase/ai/type/ThinkingConfig$Internal;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Lcom/google/firebase/ai/type/Schema$InternalOpenAPI;Lcom/google/firebase/ai/type/Schema$InternalJson;Ljava/util/List;Lcom/google/firebase/ai/type/ThinkingConfig$Internal;)Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer candidateCount;
        private final Float frequencyPenalty;
        private final Integer maxOutputTokens;
        private final Float presencePenalty;
        private final Schema.InternalJson responseJsonSchema;
        private final String responseMimeType;
        private final List<String> responseModalities;
        private final Schema.InternalOpenAPI responseSchema;
        private final List<String> stopSequences;
        private final Float temperature;
        private final ThinkingConfig.Internal thinkingConfig;
        private final Integer topK;
        private final Float topP;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GenerationConfig$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GenerationConfig$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return GenerationConfig$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, null, null, null, null, new ArrayListSerializer(stringSerializer), null, null, null, null, new SealedClassSerializer("com.google.firebase.ai.type.Schema.InternalJson", Reflection.getOrCreateKotlinClass(Schema.InternalJson.class), new KClass[]{Reflection.getOrCreateKotlinClass(Schema.InternalJsonNonNull.class), Reflection.getOrCreateKotlinClass(Schema.InternalJsonNullable.class)}, new KSerializer[]{Schema$InternalJsonNonNull$$serializer.INSTANCE, Schema$InternalJsonNullable$$serializer.INSTANCE}, new Annotation[0]), new ArrayListSerializer(stringSerializer), null};
        }

        public /* synthetic */ Internal(int i, Float f, Float f2, Integer num, Integer num2, Integer num3, List list, String str, Float f3, Float f4, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, List list2, ThinkingConfig.Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, GenerationConfig$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.temperature = f;
            this.topP = f2;
            this.topK = num;
            this.candidateCount = num2;
            this.maxOutputTokens = num3;
            this.stopSequences = list;
            if ((i & 64) == 0) {
                this.responseMimeType = null;
            } else {
                this.responseMimeType = str;
            }
            if ((i & 128) == 0) {
                this.presencePenalty = null;
            } else {
                this.presencePenalty = f3;
            }
            if ((i & 256) == 0) {
                this.frequencyPenalty = null;
            } else {
                this.frequencyPenalty = f4;
            }
            if ((i & 512) == 0) {
                this.responseSchema = null;
            } else {
                this.responseSchema = internalOpenAPI;
            }
            if ((i & 1024) == 0) {
                this.responseJsonSchema = null;
            } else {
                this.responseJsonSchema = internalJson;
            }
            if ((i & 2048) == 0) {
                this.responseModalities = null;
            } else {
                this.responseModalities = list2;
            }
            if ((i & 4096) == 0) {
                this.thinkingConfig = null;
            } else {
                this.thinkingConfig = internal;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Float f, Float f2, Integer num, Integer num2, Integer num3, List list, String str, Float f3, Float f4, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, List list2, ThinkingConfig.Internal internal2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = internal.temperature;
            }
            return internal.copy(f, (i & 2) != 0 ? internal.topP : f2, (i & 4) != 0 ? internal.topK : num, (i & 8) != 0 ? internal.candidateCount : num2, (i & 16) != 0 ? internal.maxOutputTokens : num3, (i & 32) != 0 ? internal.stopSequences : list, (i & 64) != 0 ? internal.responseMimeType : str, (i & 128) != 0 ? internal.presencePenalty : f3, (i & 256) != 0 ? internal.frequencyPenalty : f4, (i & 512) != 0 ? internal.responseSchema : internalOpenAPI, (i & 1024) != 0 ? internal.responseJsonSchema : internalJson, (i & 2048) != 0 ? internal.responseModalities : list2, (i & 4096) != 0 ? internal.thinkingConfig : internal2);
        }

        @SerialName("candidate_count")
        public static /* synthetic */ void getCandidateCount$annotations() {
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

        @SerialName("response_json_schema")
        public static /* synthetic */ void getResponseJsonSchema$annotations() {
        }

        @SerialName("response_mime_type")
        public static /* synthetic */ void getResponseMimeType$annotations() {
        }

        @SerialName("response_modalities")
        public static /* synthetic */ void getResponseModalities$annotations() {
        }

        @SerialName("response_schema")
        public static /* synthetic */ void getResponseSchema$annotations() {
        }

        @SerialName("stop_sequences")
        public static /* synthetic */ void getStopSequences$annotations() {
        }

        @SerialName("thinking_config")
        public static /* synthetic */ void getThinkingConfig$annotations() {
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
            output.encodeNullableSerializableElement(serialDesc, 3, intSerializer, self.candidateCount);
            output.encodeNullableSerializableElement(serialDesc, 4, intSerializer, self.maxOutputTokens);
            output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.stopSequences);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.responseMimeType != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.responseMimeType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.presencePenalty != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, floatSerializer, self.presencePenalty);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.frequencyPenalty != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, floatSerializer, self.frequencyPenalty);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.responseSchema != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, Schema$InternalOpenAPI$$serializer.INSTANCE, self.responseSchema);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.responseJsonSchema != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, kSerializerArr[10], self.responseJsonSchema);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.responseModalities != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, kSerializerArr[11], self.responseModalities);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.thinkingConfig == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 12, ThinkingConfig$Internal$$serializer.INSTANCE, self.thinkingConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Float getTemperature() {
            return this.temperature;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Schema.InternalOpenAPI getResponseSchema() {
            return this.responseSchema;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Schema.InternalJson getResponseJsonSchema() {
            return this.responseJsonSchema;
        }

        public final List<String> component12() {
            return this.responseModalities;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final ThinkingConfig.Internal getThinkingConfig() {
            return this.thinkingConfig;
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
        public final Integer getCandidateCount() {
            return this.candidateCount;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getMaxOutputTokens() {
            return this.maxOutputTokens;
        }

        public final List<String> component6() {
            return this.stopSequences;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getResponseMimeType() {
            return this.responseMimeType;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Float getPresencePenalty() {
            return this.presencePenalty;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Float getFrequencyPenalty() {
            return this.frequencyPenalty;
        }

        public final Internal copy(Float temperature, Float topP, Integer topK, Integer candidateCount, Integer maxOutputTokens, List<String> stopSequences, String responseMimeType, Float presencePenalty, Float frequencyPenalty, Schema.InternalOpenAPI responseSchema, Schema.InternalJson responseJsonSchema, List<String> responseModalities, ThinkingConfig.Internal thinkingConfig) {
            return new Internal(temperature, topP, topK, candidateCount, maxOutputTokens, stopSequences, responseMimeType, presencePenalty, frequencyPenalty, responseSchema, responseJsonSchema, responseModalities, thinkingConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual((Object) this.temperature, (Object) internal.temperature) && Intrinsics.areEqual((Object) this.topP, (Object) internal.topP) && Intrinsics.areEqual(this.topK, internal.topK) && Intrinsics.areEqual(this.candidateCount, internal.candidateCount) && Intrinsics.areEqual(this.maxOutputTokens, internal.maxOutputTokens) && Intrinsics.areEqual(this.stopSequences, internal.stopSequences) && Intrinsics.areEqual(this.responseMimeType, internal.responseMimeType) && Intrinsics.areEqual((Object) this.presencePenalty, (Object) internal.presencePenalty) && Intrinsics.areEqual((Object) this.frequencyPenalty, (Object) internal.frequencyPenalty) && Intrinsics.areEqual(this.responseSchema, internal.responseSchema) && Intrinsics.areEqual(this.responseJsonSchema, internal.responseJsonSchema) && Intrinsics.areEqual(this.responseModalities, internal.responseModalities) && Intrinsics.areEqual(this.thinkingConfig, internal.thinkingConfig);
        }

        public final Integer getCandidateCount() {
            return this.candidateCount;
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

        public final Schema.InternalJson getResponseJsonSchema() {
            return this.responseJsonSchema;
        }

        public final String getResponseMimeType() {
            return this.responseMimeType;
        }

        public final List<String> getResponseModalities() {
            return this.responseModalities;
        }

        public final Schema.InternalOpenAPI getResponseSchema() {
            return this.responseSchema;
        }

        public final List<String> getStopSequences() {
            return this.stopSequences;
        }

        public final Float getTemperature() {
            return this.temperature;
        }

        public final ThinkingConfig.Internal getThinkingConfig() {
            return this.thinkingConfig;
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
            Integer num2 = this.candidateCount;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.maxOutputTokens;
            int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            List<String> list = this.stopSequences;
            int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.responseMimeType;
            int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
            Float f3 = this.presencePenalty;
            int iHashCode8 = (iHashCode7 + (f3 == null ? 0 : f3.hashCode())) * 31;
            Float f4 = this.frequencyPenalty;
            int iHashCode9 = (iHashCode8 + (f4 == null ? 0 : f4.hashCode())) * 31;
            Schema.InternalOpenAPI internalOpenAPI = this.responseSchema;
            int iHashCode10 = (iHashCode9 + (internalOpenAPI == null ? 0 : internalOpenAPI.hashCode())) * 31;
            Schema.InternalJson internalJson = this.responseJsonSchema;
            int iHashCode11 = (iHashCode10 + (internalJson == null ? 0 : internalJson.hashCode())) * 31;
            List<String> list2 = this.responseModalities;
            int iHashCode12 = (iHashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
            ThinkingConfig.Internal internal = this.thinkingConfig;
            return iHashCode12 + (internal != null ? internal.hashCode() : 0);
        }

        public String toString() {
            return "Internal(temperature=" + this.temperature + ", topP=" + this.topP + ", topK=" + this.topK + ", candidateCount=" + this.candidateCount + ", maxOutputTokens=" + this.maxOutputTokens + ", stopSequences=" + this.stopSequences + ", responseMimeType=" + this.responseMimeType + ", presencePenalty=" + this.presencePenalty + ", frequencyPenalty=" + this.frequencyPenalty + ", responseSchema=" + this.responseSchema + ", responseJsonSchema=" + this.responseJsonSchema + ", responseModalities=" + this.responseModalities + ", thinkingConfig=" + this.thinkingConfig + ')';
        }

        public Internal(Float f, Float f2, Integer num, Integer num2, Integer num3, List<String> list, String str, Float f3, Float f4, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, List<String> list2, ThinkingConfig.Internal internal) {
            this.temperature = f;
            this.topP = f2;
            this.topK = num;
            this.candidateCount = num2;
            this.maxOutputTokens = num3;
            this.stopSequences = list;
            this.responseMimeType = str;
            this.presencePenalty = f3;
            this.frequencyPenalty = f4;
            this.responseSchema = internalOpenAPI;
            this.responseJsonSchema = internalJson;
            this.responseModalities = list2;
            this.thinkingConfig = internal;
        }

        public /* synthetic */ Internal(Float f, Float f2, Integer num, Integer num2, Integer num3, List list, String str, Float f3, Float f4, Schema.InternalOpenAPI internalOpenAPI, Schema.InternalJson internalJson, List list2, ThinkingConfig.Internal internal, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, num, num2, num3, list, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : f3, (i & 256) != 0 ? null : f4, (i & 512) != 0 ? null : internalOpenAPI, (i & 1024) != 0 ? null : internalJson, (i & 2048) != 0 ? null : list2, (i & 4096) != 0 ? null : internal);
        }
    }
}

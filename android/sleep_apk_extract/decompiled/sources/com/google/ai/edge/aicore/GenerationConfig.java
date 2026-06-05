package com.google.ai.edge.aicore;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.aicore.zzat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a¨\u0006!"}, d2 = {"Lcom/google/ai/edge/aicore/GenerationConfig;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/concurrent/ExecutorService;", "workerExecutor", "Ljava/util/concurrent/ExecutorService;", "getWorkerExecutor", "()Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/Executor;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "getCallbackExecutor", "()Ljava/util/concurrent/Executor;", "", "temperature", "Ljava/lang/Float;", "getTemperature", "()Ljava/lang/Float;", "", "topK", "Ljava/lang/Integer;", "getTopK", "()Ljava/lang/Integer;", "candidateCount", "getCandidateCount", "maxOutputTokens", "getMaxOutputTokens", "Companion", "Builder", "java.com.google.android.apps.aicore.client_client"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenerationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Executor callbackExecutor;
    private final Integer candidateCount;
    private final Context context;
    private final Integer maxOutputTokens;
    private final Float temperature;
    private final Integer topK;
    private final ExecutorService workerExecutor;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u0010-\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)¨\u00060"}, d2 = {"Lcom/google/ai/edge/aicore/GenerationConfig$Builder;", "", "<init>", "()V", "Lcom/google/ai/edge/aicore/GenerationConfig;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/google/ai/edge/aicore/GenerationConfig;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Ljava/util/concurrent/ExecutorService;", "workerExecutor", "Ljava/util/concurrent/ExecutorService;", "getWorkerExecutor", "()Ljava/util/concurrent/ExecutorService;", "setWorkerExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "Ljava/util/concurrent/Executor;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "getCallbackExecutor", "()Ljava/util/concurrent/Executor;", "setCallbackExecutor", "(Ljava/util/concurrent/Executor;)V", "", "temperature", "Ljava/lang/Float;", "getTemperature", "()Ljava/lang/Float;", "setTemperature", "(Ljava/lang/Float;)V", "", "topK", "Ljava/lang/Integer;", "getTopK", "()Ljava/lang/Integer;", "setTopK", "(Ljava/lang/Integer;)V", "candidateCount", "getCandidateCount", "setCandidateCount", "maxOutputTokens", "getMaxOutputTokens", "setMaxOutputTokens", "java.com.google.android.apps.aicore.client_client"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private Executor callbackExecutor;
        private Integer candidateCount;
        private Context context;
        private Integer maxOutputTokens;
        private Float temperature;
        private Integer topK;
        private ExecutorService workerExecutor;

        public Builder() {
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
            executorServiceNewCachedThreadPool.getClass();
            this.workerExecutor = executorServiceNewCachedThreadPool;
            zzat zzatVar = zzat.zza;
            zzatVar.getClass();
            this.callbackExecutor = zzatVar;
        }

        public final GenerationConfig build() {
            Context context = this.context;
            if (context != null) {
                return new GenerationConfig(context, this.workerExecutor, this.callbackExecutor, this.temperature, this.topK, this.candidateCount, this.maxOutputTokens, null);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Context is required");
            return null;
        }

        public final void setContext(Context context) {
            this.context = context;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/ai/edge/aicore/GenerationConfig$Companion;", "", "Lcom/google/ai/edge/aicore/GenerationConfig$Builder;", "builder", "()Lcom/google/ai/edge/aicore/GenerationConfig$Builder;", "java.com.google.android.apps.aicore.client_client"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Builder builder() {
            return new Builder();
        }
    }

    public /* synthetic */ GenerationConfig(Context context, ExecutorService executorService, Executor executor, Float f, Integer num, Integer num2, Integer num3, DefaultConstructorMarker defaultConstructorMarker) {
        this.context = context;
        this.workerExecutor = executorService;
        this.callbackExecutor = executor;
        this.temperature = f;
        this.topK = num;
        this.candidateCount = num2;
        this.maxOutputTokens = num3;
    }

    public final Executor getCallbackExecutor() {
        return this.callbackExecutor;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ExecutorService getWorkerExecutor() {
        return this.workerExecutor;
    }
}

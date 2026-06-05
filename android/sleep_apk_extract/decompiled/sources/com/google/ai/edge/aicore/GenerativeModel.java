package com.google.ai.edge.aicore;

import com.google.android.gms.internal.aicore.zzar;
import com.google.android.gms.internal.aicore.zzas;
import com.google.android.gms.internal.aicore.zzau;
import com.google.android.gms.internal.aicore.zzcg;
import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u00014B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/google/ai/edge/aicore/GenerativeModel;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lcom/google/ai/edge/aicore/GenerationConfig;", "generationConfig", "Lcom/google/ai/edge/aicore/DownloadConfig;", "downloadConfig", "<init>", "(Lcom/google/ai/edge/aicore/GenerationConfig;Lcom/google/ai/edge/aicore/DownloadConfig;)V", "", "close", "()V", "Lcom/google/ai/edge/aicore/DownloadCallback;", "downloadCallback", "Lcom/google/android/apps/aicore/client/api/DownloadCallback;", "createAiCoreDownloadCallback", "(Lcom/google/ai/edge/aicore/DownloadCallback;)Lcom/google/android/apps/aicore/client/api/DownloadCallback;", "Lcom/google/android/apps/aicore/client/api/AiCoreClient;", "createAiCoreClient", "()Lcom/google/android/apps/aicore/client/api/AiCoreClient;", "", "", "prompt", "Lcom/google/android/apps/aicore/client/api/llm/LlmStreamingCallback;", "streamingCallback", "Lcom/google/android/apps/aicore/client/api/llm/LlmRequest;", "createLlmRequest", "(Ljava/lang/Object;Lcom/google/android/apps/aicore/client/api/llm/LlmStreamingCallback;)Lcom/google/android/apps/aicore/client/api/llm/LlmRequest;", "Lcom/google/android/apps/aicore/client/api/llm/LlmResult;", "llmResult", "", "createCandidateList", "(Lcom/google/android/apps/aicore/client/api/llm/LlmResult;)Ljava/util/List;", "Lcom/google/android/apps/aicore/client/api/AiFeature;", "aiFeature", "", "isSideloadedFeature", "(Lcom/google/android/apps/aicore/client/api/AiFeature;)Z", "Lcom/google/ai/edge/aicore/GenerationConfig;", "getGenerationConfig", "()Lcom/google/ai/edge/aicore/GenerationConfig;", "Lcom/google/ai/edge/aicore/DownloadConfig;", "getDownloadConfig", "()Lcom/google/ai/edge/aicore/DownloadConfig;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "aicoreClient", "Lcom/google/android/apps/aicore/client/api/AiCoreClient;", "Lcom/google/android/apps/aicore/client/api/llm/LlmService;", "llmService", "Lcom/google/android/apps/aicore/client/api/llm/LlmService;", "Companion", "java.com.google.android.apps.aicore.client_client"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenerativeModel implements AutoCloseable {
    private final zzar aicoreClient;
    private final DownloadConfig downloadConfig;
    private final GenerationConfig generationConfig;
    private final Mutex mutex;

    public GenerativeModel(GenerationConfig generationConfig, DownloadConfig downloadConfig) {
        generationConfig.getClass();
        downloadConfig.getClass();
        this.generationConfig = generationConfig;
        this.downloadConfig = downloadConfig;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        zzas zzasVarZze = zzau.zze(generationConfig.getContext());
        zzasVarZze.zza(generationConfig.getWorkerExecutor());
        zzasVarZze.zzb(generationConfig.getCallbackExecutor());
        this.aicoreClient = new zzcg(zzasVarZze.zzd());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.aicoreClient.close();
    }
}

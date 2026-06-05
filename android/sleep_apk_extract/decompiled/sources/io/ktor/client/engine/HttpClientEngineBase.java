package io.ktor.client.engine;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.util.CoroutinesUtilsKt;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/HttpClientEngine;", "", "engineName", "<init>", "(Ljava/lang/String;)V", "", "close", "()V", "Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$delegate", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class HttpClientEngineBase implements HttpClientEngine {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    private volatile /* synthetic */ int closed;

    /* JADX INFO: renamed from: coroutineContext$delegate, reason: from kotlin metadata */
    private final Lazy coroutineContext;

    /* JADX INFO: renamed from: dispatcher$delegate, reason: from kotlin metadata */
    private final Lazy dispatcher;
    private final String engineName;

    public HttpClientEngineBase(String str) {
        str.getClass();
        this.engineName = str;
        final int i = 0;
        this.closed = 0;
        this.dispatcher = LazyKt.lazy(new Function0(this) { // from class: io.ktor.client.engine.HttpClientEngineBase$$ExternalSyntheticLambda0
            public final /* synthetic */ HttpClientEngineBase f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                HttpClientEngineBase httpClientEngineBase = this.f$0;
                switch (i2) {
                    case 0:
                        return HttpClientEngineBase.dispatcher_delegate$lambda$0(httpClientEngineBase);
                    default:
                        return HttpClientEngineBase.coroutineContext_delegate$lambda$1(httpClientEngineBase);
                }
            }
        });
        final int i2 = 1;
        this.coroutineContext = LazyKt.lazy(new Function0(this) { // from class: io.ktor.client.engine.HttpClientEngineBase$$ExternalSyntheticLambda0
            public final /* synthetic */ HttpClientEngineBase f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                HttpClientEngineBase httpClientEngineBase = this.f$0;
                switch (i22) {
                    case 0:
                        return HttpClientEngineBase.dispatcher_delegate$lambda$0(httpClientEngineBase);
                    default:
                        return HttpClientEngineBase.coroutineContext_delegate$lambda$1(httpClientEngineBase);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext coroutineContext_delegate$lambda$1(HttpClientEngineBase httpClientEngineBase) {
        return CoroutinesUtilsKt.SilentSupervisor$default(null, 1, null).plus(httpClientEngineBase.getDispatcher()).plus(new CoroutineName(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), httpClientEngineBase.engineName, "-context")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineDispatcher dispatcher_delegate$lambda$0(HttpClientEngineBase httpClientEngineBase) {
        CoroutineDispatcher dispatcher = httpClientEngineBase.getConfig().getDispatcher();
        return dispatcher == null ? HttpClientEngineBase_jvmKt.ioDispatcher() : dispatcher;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            CoroutineContext.Element element = getCoroutineContext().get(Job.INSTANCE);
            CompletableJob completableJob = element instanceof CompletableJob ? (CompletableJob) element : null;
            if (completableJob == null) {
                return;
            }
            completableJob.complete();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.coroutineContext.getValue();
    }

    public CoroutineDispatcher getDispatcher() {
        return (CoroutineDispatcher) this.dispatcher.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return HttpClientEngine.DefaultImpls.getSupportedCapabilities(this);
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public void install(HttpClient httpClient) {
        HttpClientEngine.DefaultImpls.install(this, httpClient);
    }
}

package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class HttpRequestLifecycleKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ HttpRequestLifecycleKt$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return HttpRequestLifecycleKt.attachToClientEngineJob$lambda$1((CompletableJob) obj2, (Throwable) obj);
            case 1:
                return HttpTimeoutKt$HttpTimeout$2$1.invokeSuspend$lambda$1$lambda$0((Job) obj2, (Throwable) obj);
            case 2:
                return DefaultResponseValidationKt.addDefaultResponseValidation$lambda$0((HttpClientConfig) obj2, (HttpCallValidatorConfig) obj);
            default:
                return HttpRequestLifecycleKt.attachToClientEngineJob$lambda$2((DisposableHandle) obj2, (Throwable) obj);
        }
    }
}

package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003J%\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "", "Lkotlin/Function1;", "", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HttpClientEngine create$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i, Object obj) {
            if (obj != null) {
                Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: create");
                return null;
            }
            if ((i & 1) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0(12);
            }
            return httpClientEngineFactory.create(function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit create$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
            httpClientEngineConfig.getClass();
            return Unit.INSTANCE;
        }
    }

    HttpClientEngine create(Function1<? super T, Unit> block);
}

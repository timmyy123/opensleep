package androidx.appsearch.platformstorage.util;

import android.app.appsearch.BatchResultCallback;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.platformstorage.converter.AppSearchResultToPlatformConverter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class BatchResultCallbackAdapter<K, PlatformValue, JetpackValue> implements BatchResultCallback {
    private final ResolvableFuture<AppSearchBatchResult<K, JetpackValue>> mFuture;
    private final Function<AppSearchBatchResult<K, JetpackValue>, AppSearchBatchResult<K, JetpackValue>> mResultTransformer;
    private final Function<PlatformValue, JetpackValue> mValueMapper;

    public BatchResultCallbackAdapter(ResolvableFuture<AppSearchBatchResult<K, JetpackValue>> resolvableFuture, Function<PlatformValue, JetpackValue> function, Function<AppSearchBatchResult<K, JetpackValue>, AppSearchBatchResult<K, JetpackValue>> function2) {
        this.mFuture = (ResolvableFuture) Preconditions.checkNotNull(resolvableFuture);
        this.mValueMapper = (Function) Preconditions.checkNotNull(function);
        this.mResultTransformer = function2;
    }

    public void onResult(android.app.appsearch.AppSearchBatchResult<K, PlatformValue> appSearchBatchResult) {
        AppSearchBatchResult<K, JetpackValue> appSearchBatchResultPlatformAppSearchBatchResultToJetpack = AppSearchResultToPlatformConverter.platformAppSearchBatchResultToJetpack(appSearchBatchResult, this.mValueMapper);
        Function<AppSearchBatchResult<K, JetpackValue>, AppSearchBatchResult<K, JetpackValue>> function = this.mResultTransformer;
        if (function != null) {
            appSearchBatchResultPlatformAppSearchBatchResultToJetpack = function.apply(appSearchBatchResultPlatformAppSearchBatchResultToJetpack);
        }
        this.mFuture.set(appSearchBatchResultPlatformAppSearchBatchResultToJetpack);
    }

    public void onSystemError(Throwable th) {
        this.mFuture.setException(th);
    }

    public BatchResultCallbackAdapter(ResolvableFuture<AppSearchBatchResult<K, JetpackValue>> resolvableFuture, Function<PlatformValue, JetpackValue> function) {
        this(resolvableFuture, function, null);
    }
}

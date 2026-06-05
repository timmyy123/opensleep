package androidx.appsearch.platformstorage.converter;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.AppSearchResult;
import androidx.core.util.Preconditions;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppSearchResultToPlatformConverter {
    public static <K, PlatformValue, JetpackValue> AppSearchBatchResult<K, JetpackValue> platformAppSearchBatchResultToJetpack(android.app.appsearch.AppSearchBatchResult<K, PlatformValue> appSearchBatchResult, Function<PlatformValue, JetpackValue> function) {
        Preconditions.checkNotNull(appSearchBatchResult);
        Preconditions.checkNotNull(function);
        AppSearchBatchResult.Builder builder = new AppSearchBatchResult.Builder();
        for (Map.Entry<K, PlatformValue> entry : appSearchBatchResult.getSuccesses().entrySet()) {
            try {
                builder.setSuccess(entry.getKey(), function.apply(entry.getValue()));
            } catch (Throwable th) {
                builder.setResult(entry.getKey(), AppSearchResult.throwableToFailedResult(th));
            }
        }
        for (Map.Entry<K, android.app.appsearch.AppSearchResult<PlatformValue>> entry2 : appSearchBatchResult.getFailures().entrySet()) {
            builder.setFailure(entry2.getKey(), OggIO$$ExternalSyntheticBUOutline0.m0m((Object) entry2.getValue()).getResultCode(), OggIO$$ExternalSyntheticBUOutline0.m0m((Object) entry2.getValue()).getErrorMessage());
        }
        return builder.build();
    }
}

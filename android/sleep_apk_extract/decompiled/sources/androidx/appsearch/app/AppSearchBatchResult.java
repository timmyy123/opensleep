package androidx.appsearch.app;

import androidx.collection.ArrayMap;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AppSearchBatchResult<KeyType, ValueType> {
    private final Map<KeyType, AppSearchResult<ValueType>> mAll;
    private final Map<KeyType, AppSearchResult<ValueType>> mFailures;
    private final Map<KeyType, ValueType> mSuccesses;

    public static final class Builder<KeyType, ValueType> {
        private ArrayMap<KeyType, ValueType> mSuccesses = new ArrayMap<>();
        private ArrayMap<KeyType, AppSearchResult<ValueType>> mFailures = new ArrayMap<>();
        private ArrayMap<KeyType, AppSearchResult<ValueType>> mAll = new ArrayMap<>();
        private boolean mBuilt = false;

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mSuccesses = new ArrayMap<>(this.mSuccesses);
                this.mFailures = new ArrayMap<>(this.mFailures);
                this.mAll = new ArrayMap<>(this.mAll);
                this.mBuilt = false;
            }
        }

        public AppSearchBatchResult<KeyType, ValueType> build() {
            this.mBuilt = true;
            return new AppSearchBatchResult<>(this.mSuccesses, this.mFailures, this.mAll);
        }

        public Builder<KeyType, ValueType> setFailure(KeyType keytype, int i, String str) {
            Preconditions.checkNotNull(keytype);
            resetIfBuilt();
            return setResult(keytype, AppSearchResult.newFailedResult(i, str));
        }

        public Builder<KeyType, ValueType> setResult(KeyType keytype, AppSearchResult<ValueType> appSearchResult) {
            Preconditions.checkNotNull(keytype);
            Preconditions.checkNotNull(appSearchResult);
            resetIfBuilt();
            if (appSearchResult.isSuccess()) {
                this.mSuccesses.put(keytype, appSearchResult.getResultValue());
                this.mFailures.remove(keytype);
            } else {
                this.mFailures.put(keytype, appSearchResult);
                this.mSuccesses.remove(keytype);
            }
            this.mAll.put(keytype, appSearchResult);
            return this;
        }

        public Builder<KeyType, ValueType> setSuccess(KeyType keytype, ValueType valuetype) {
            Preconditions.checkNotNull(keytype);
            resetIfBuilt();
            return setResult(keytype, AppSearchResult.newSuccessfulResult(valuetype));
        }
    }

    public AppSearchBatchResult(Map<KeyType, ValueType> map, Map<KeyType, AppSearchResult<ValueType>> map2, Map<KeyType, AppSearchResult<ValueType>> map3) {
        this.mSuccesses = (Map) Preconditions.checkNotNull(map);
        this.mFailures = (Map) Preconditions.checkNotNull(map2);
        this.mAll = (Map) Preconditions.checkNotNull(map3);
    }

    public Map<KeyType, ValueType> getSuccesses() {
        return Collections.unmodifiableMap(this.mSuccesses);
    }

    public String toString() {
        return "{\n  successes: " + this.mSuccesses + "\n  failures: " + this.mFailures + "\n}";
    }
}

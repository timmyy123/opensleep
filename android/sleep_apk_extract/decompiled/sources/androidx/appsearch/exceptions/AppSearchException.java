package androidx.appsearch.exceptions;

import androidx.appsearch.app.AppSearchResult;

/* JADX INFO: loaded from: classes.dex */
public class AppSearchException extends Exception {
    private final int mResultCode;

    public AppSearchException(int i, String str, Throwable th) {
        super(str, th);
        this.mResultCode = i;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public <T> AppSearchResult<T> toAppSearchResult() {
        return AppSearchResult.newFailedResult(this.mResultCode, getMessage());
    }

    public AppSearchException(int i, String str) {
        this(i, str, null);
    }
}

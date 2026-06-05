package androidx.appsearch.app;

import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.observer.ObserverSpec;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface GlobalSearchSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest);

    void registerObserverCallback(String str, ObserverSpec observerSpec, Executor executor, ObserverCallback observerCallback);

    SearchResults search(String str, SearchSpec searchSpec);

    void unregisterObserverCallback(String str, ObserverCallback observerCallback);
}

package androidx.appsearch.app;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SearchResults extends Closeable {
    ListenableFuture<List<SearchResult>> getNextPageAsync();
}

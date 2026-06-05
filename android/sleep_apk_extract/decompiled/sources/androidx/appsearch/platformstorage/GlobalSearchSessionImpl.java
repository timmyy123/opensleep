package androidx.appsearch.platformstorage;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.BatchResultCallback;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.exceptions.AppSearchException;
import android.app.appsearch.observer.DocumentChangeInfo;
import android.app.appsearch.observer.ObserverSpec;
import android.app.appsearch.observer.SchemaChangeInfo;
import android.content.Context;
import android.os.Build;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.Features;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.platformstorage.converter.ObserverSpecToPlatformConverter;
import androidx.appsearch.platformstorage.converter.RequestToPlatformConverter;
import androidx.appsearch.platformstorage.converter.SearchSpecToPlatformConverter;
import androidx.appsearch.platformstorage.util.BatchResultCallbackAdapter;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
class GlobalSearchSessionImpl implements GlobalSearchSession {
    private final Context mContext;
    private final Executor mExecutor;
    private final Features mFeatures;
    private final Map<ObserverCallback, android.app.appsearch.observer.ObserverCallback> mObserverCallbacksLocked = new ArrayMap();
    private final android.app.appsearch.GlobalSearchSession mPlatformSession;

    public static class ApiHelperForT {
        public static void getByDocumentId(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest, Executor executor, BatchResultCallback batchResultCallback) {
            globalSearchSession.getByDocumentId(str, str2, getByDocumentIdRequest, executor, batchResultCallback);
        }

        public static void getSchema(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, String str2, Executor executor, Consumer<AppSearchResult<GetSchemaResponse>> consumer) {
            globalSearchSession.getSchema(str, str2, executor, consumer);
        }

        public static void registerObserverCallback(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, ObserverSpec observerSpec, Executor executor, android.app.appsearch.observer.ObserverCallback observerCallback) throws AppSearchException {
            globalSearchSession.registerObserverCallback(str, observerSpec, executor, observerCallback);
        }

        public static void unregisterObserverCallback(android.app.appsearch.GlobalSearchSession globalSearchSession, String str, android.app.appsearch.observer.ObserverCallback observerCallback) throws AppSearchException {
            globalSearchSession.unregisterObserverCallback(str, observerCallback);
        }
    }

    public GlobalSearchSessionImpl(android.app.appsearch.GlobalSearchSession globalSearchSession, Executor executor, Context context) {
        this.mPlatformSession = OggIO$$ExternalSyntheticBUOutline0.m1m(Preconditions.checkNotNull(globalSearchSession));
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        Context context2 = (Context) Preconditions.checkNotNull(context);
        this.mContext = context2;
        this.mFeatures = new FeaturesImpl(context2);
    }

    @Override // androidx.appsearch.app.GlobalSearchSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mPlatformSession.close();
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public ListenableFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentIdAsync(String str, String str2, androidx.appsearch.app.GetByDocumentIdRequest getByDocumentIdRequest) {
        if (Build.VERSION.SDK_INT < 33) {
            Utf8$$ExternalSyntheticBUOutline0.m("GLOBAL_SEARCH_SESSION_GET_BY_ID is not supported on this AppSearch implementation.");
            return null;
        }
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(getByDocumentIdRequest);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        ApiHelperForT.getByDocumentId(this.mPlatformSession, str, str2, RequestToPlatformConverter.toPlatformGetByDocumentIdRequest(getByDocumentIdRequest), this.mExecutor, new BatchResultCallbackAdapter(resolvableFutureCreate, new GlobalSearchSessionImpl$$ExternalSyntheticLambda2()));
        return resolvableFutureCreate;
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public void registerObserverCallback(String str, androidx.appsearch.observer.ObserverSpec observerSpec, Executor executor, final ObserverCallback observerCallback) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(observerSpec);
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(observerCallback);
        if (Build.VERSION.SDK_INT < 33) {
            Utf8$$ExternalSyntheticBUOutline0.m("GLOBAL_SEARCH_SESSION_REGISTER_OBSERVER_CALLBACK is not supported on this AppSearch implementation");
            return;
        }
        synchronized (this.mObserverCallbacksLocked) {
            android.app.appsearch.observer.ObserverCallback observerCallbackM3m = OggIO$$ExternalSyntheticBUOutline0.m3m((Object) this.mObserverCallbacksLocked.get(observerCallback));
            if (observerCallbackM3m == null) {
                observerCallbackM3m = new android.app.appsearch.observer.ObserverCallback() { // from class: androidx.appsearch.platformstorage.GlobalSearchSessionImpl.1
                    public void onDocumentChanged(DocumentChangeInfo documentChangeInfo) {
                        observerCallback.onDocumentChanged(ObserverSpecToPlatformConverter.toJetpackDocumentChangeInfo(documentChangeInfo));
                    }

                    public void onSchemaChanged(SchemaChangeInfo schemaChangeInfo) {
                        observerCallback.onSchemaChanged(ObserverSpecToPlatformConverter.toJetpackSchemaChangeInfo(schemaChangeInfo));
                    }
                };
            }
            try {
                ApiHelperForT.registerObserverCallback(this.mPlatformSession, str, ObserverSpecToPlatformConverter.toPlatformObserverSpec(observerSpec), executor, observerCallbackM3m);
                this.mObserverCallbacksLocked.put(observerCallback, observerCallbackM3m);
            } catch (AppSearchException e) {
                throw new androidx.appsearch.exceptions.AppSearchException(e.getResultCode(), e.getMessage(), e.getCause());
            }
        }
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public SearchResults search(String str, SearchSpec searchSpec) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(searchSpec);
        return new SearchResultsImpl(this.mPlatformSession.search(str, SearchSpecToPlatformConverter.toPlatformSearchSpec(this.mContext, searchSpec)), searchSpec, this.mExecutor, this.mContext);
    }

    @Override // androidx.appsearch.app.GlobalSearchSession
    public void unregisterObserverCallback(String str, ObserverCallback observerCallback) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(observerCallback);
        if (Build.VERSION.SDK_INT < 33) {
            Utf8$$ExternalSyntheticBUOutline0.m("GLOBAL_SEARCH_SESSION_REGISTER_OBSERVER_CALLBACK is not supported on this AppSearch implementation");
            return;
        }
        synchronized (this.mObserverCallbacksLocked) {
            android.app.appsearch.observer.ObserverCallback observerCallbackM3m = OggIO$$ExternalSyntheticBUOutline0.m3m((Object) this.mObserverCallbacksLocked.get(observerCallback));
            if (observerCallbackM3m == null) {
                return;
            }
            try {
                ApiHelperForT.unregisterObserverCallback(this.mPlatformSession, str, observerCallbackM3m);
                this.mObserverCallbacksLocked.remove(observerCallback);
            } catch (AppSearchException e) {
                throw new androidx.appsearch.exceptions.AppSearchException(e.getResultCode(), e.getMessage(), e.getCause());
            }
        }
    }
}

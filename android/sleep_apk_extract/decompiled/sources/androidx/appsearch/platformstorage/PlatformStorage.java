package androidx.appsearch.platformstorage;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.content.Context;
import androidx.appsearch.app.AppSearchEnvironmentFactory;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformStorage {
    static final Executor EXECUTOR = AppSearchEnvironmentFactory.getEnvironmentInstance().createCachedThreadPoolExecutor();

    public static final class GlobalSearchContext {
        final Context mContext;
        final Executor mExecutor;

        public static final class Builder {
            private final Context mContext;
            private Executor mExecutor;

            public Builder(Context context) {
                this.mContext = (Context) Preconditions.checkNotNull(context);
            }

            public GlobalSearchContext build() {
                if (this.mExecutor == null) {
                    this.mExecutor = PlatformStorage.EXECUTOR;
                }
                return new GlobalSearchContext(this.mContext, this.mExecutor);
            }

            public Builder setWorkerExecutor(Executor executor) {
                Preconditions.checkNotNull(executor);
                this.mExecutor = executor;
                return this;
            }
        }

        public GlobalSearchContext(Context context, Executor executor) {
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }
    }

    public static ListenableFuture<GlobalSearchSession> createGlobalSearchSessionAsync(GlobalSearchContext globalSearchContext) {
        Preconditions.checkNotNull(globalSearchContext);
        AppSearchManager appSearchManager = (AppSearchManager) globalSearchContext.mContext.getSystemService(AppSearchManager.class);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        appSearchManager.createGlobalSearchSession(globalSearchContext.mExecutor, new PlatformStorage$$ExternalSyntheticLambda2(resolvableFutureCreate, globalSearchContext));
        return resolvableFutureCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createGlobalSearchSessionAsync$1(ResolvableFuture resolvableFuture, GlobalSearchContext globalSearchContext, AppSearchResult appSearchResult) {
        if (appSearchResult.isSuccess()) {
            resolvableFuture.set(new GlobalSearchSessionImpl(OggIO$$ExternalSyntheticBUOutline0.m1m(appSearchResult.getResultValue()), globalSearchContext.mExecutor, globalSearchContext.mContext));
        } else {
            resolvableFuture.setException(new AppSearchException(appSearchResult.getResultCode(), appSearchResult.getErrorMessage()));
        }
    }
}

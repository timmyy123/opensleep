package androidx.appsearch.platformstorage;

import android.app.appsearch.AppSearchResult;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlatformStorage$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ ResolvableFuture f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ PlatformStorage$$ExternalSyntheticLambda2(SearchResultsImpl searchResultsImpl, ResolvableFuture resolvableFuture) {
        this.f$1 = searchResultsImpl;
        this.f$0 = resolvableFuture;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.$r8$classId;
        ResolvableFuture resolvableFuture = this.f$0;
        Object obj2 = this.f$1;
        switch (i) {
            case 0:
                PlatformStorage.lambda$createGlobalSearchSessionAsync$1(resolvableFuture, (PlatformStorage.GlobalSearchContext) obj2, (AppSearchResult) obj);
                break;
            default:
                ((SearchResultsImpl) obj2).lambda$getNextPageAsync$0(resolvableFuture, (AppSearchResult) obj);
                break;
        }
    }

    public /* synthetic */ PlatformStorage$$ExternalSyntheticLambda2(ResolvableFuture resolvableFuture, PlatformStorage.GlobalSearchContext globalSearchContext) {
        this.f$0 = resolvableFuture;
        this.f$1 = globalSearchContext;
    }
}

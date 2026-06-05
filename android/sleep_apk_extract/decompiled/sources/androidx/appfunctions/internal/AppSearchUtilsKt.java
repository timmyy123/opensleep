package androidx.appfunctions.internal;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.guava.ListenableFutureKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0081@¢\u0006\u0002\u0010\u0004\u001a:\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\b*\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u000bH\u0087@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"createSearchSession", "Landroidx/appsearch/app/GlobalSearchSession;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAll", "", "T", "", "Landroidx/appsearch/app/SearchResults;", "transformToDocumentClassOrNull", "Lkotlin/Function1;", "Landroidx/appsearch/app/SearchResult;", "(Landroidx/appsearch/app/SearchResults;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appfunctions"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AppSearchUtilsKt {

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchUtilsKt$createSearchSession$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchUtilsKt", f = "AppSearchUtils.kt", l = {42}, m = "createSearchSession", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchUtilsKt.createSearchSession(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchUtilsKt$readAll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchUtilsKt", f = "AppSearchUtils.kt", l = {60, 63}, m = "readAll", v = 1)
    public static final class C00851<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C00851(Continuation<? super C00851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchUtilsKt.readAll(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object createSearchSession(Context context, Continuation<? super GlobalSearchSession> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            ListenableFuture<GlobalSearchSession> listenableFutureCreateGlobalSearchSessionAsync = PlatformStorage.createGlobalSearchSessionAsync(new PlatformStorage.GlobalSearchContext.Builder(context).setWorkerExecutor(new ArchTaskExecutor$$ExternalSyntheticLambda0(1)).build());
            listenableFutureCreateGlobalSearchSessionAsync.getClass();
            anonymousClass1.label = 1;
            objAwait = ListenableFutureKt.await(listenableFutureCreateGlobalSearchSessionAsync, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objAwait);
        }
        objAwait.getClass();
        return objAwait;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00dc -> B:35:0x00df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object readAll(SearchResults searchResults, Function1<? super SearchResult, ? extends T> function1, Continuation<? super List<? extends T>> continuation) {
        C00851 c00851;
        List listCreateListBuilder;
        Object obj;
        Function1<? super SearchResult, ? extends T> function12;
        List list;
        List list2;
        SearchResults searchResults2;
        List list3;
        if (continuation instanceof C00851) {
            c00851 = (C00851) continuation;
            int i = c00851.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00851.label = i - Integer.MIN_VALUE;
            } else {
                c00851 = new C00851(continuation);
            }
        }
        Object obj2 = c00851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c00851.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            listCreateListBuilder = CollectionsKt.createListBuilder();
            ListenableFuture<List<SearchResult>> nextPageAsync = searchResults.getNextPageAsync();
            nextPageAsync.getClass();
            c00851.L$0 = searchResults;
            c00851.L$1 = function1;
            c00851.L$2 = listCreateListBuilder;
            c00851.L$3 = listCreateListBuilder;
            c00851.label = 1;
            Object objAwait = ListenableFutureKt.await(nextPageAsync, c00851);
            if (objAwait != coroutine_suspended) {
                obj = objAwait;
                function12 = function1;
                list = listCreateListBuilder;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            List list4 = (List) c00851.L$3;
            list = (List) c00851.L$2;
            function12 = (Function1) c00851.L$1;
            SearchResults searchResults3 = (SearchResults) c00851.L$0;
            ResultKt.throwOnFailure(obj2);
            listCreateListBuilder = list4;
            searchResults = searchResults3;
            obj = obj2;
        } else {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list3 = (List) c00851.L$3;
            list = (List) c00851.L$2;
            function12 = (Function1) c00851.L$1;
            SearchResults searchResults4 = (SearchResults) c00851.L$0;
            ResultKt.throwOnFailure(obj2);
            SearchResults searchResults5 = searchResults4;
            list2 = (List) obj2;
            searchResults2 = searchResults5;
            list2.getClass();
            if (!list2.isEmpty()) {
                List list5 = list2;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                Iterator<T> it = list5.iterator();
                while (it.hasNext()) {
                    arrayList.add(function12.invoke(it.next()));
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    list3.add(it2.next());
                }
                ListenableFuture<List<SearchResult>> nextPageAsync2 = searchResults2.getNextPageAsync();
                nextPageAsync2.getClass();
                c00851.L$0 = searchResults2;
                c00851.L$1 = function12;
                c00851.L$2 = list;
                c00851.L$3 = list3;
                c00851.label = 2;
                Object objAwait2 = ListenableFutureKt.await(nextPageAsync2, c00851);
                if (objAwait2 != coroutine_suspended) {
                    searchResults4 = searchResults2;
                    obj2 = objAwait2;
                    SearchResults searchResults52 = searchResults4;
                    list2 = (List) obj2;
                    searchResults2 = searchResults52;
                    list2.getClass();
                    if (!list2.isEmpty()) {
                        return CollectionsKt.build(list);
                    }
                }
                return coroutine_suspended;
            }
        }
        list2 = (List) obj;
        List list6 = listCreateListBuilder;
        searchResults2 = searchResults;
        list3 = list6;
        list2.getClass();
        if (!list2.isEmpty()) {
        }
    }
}

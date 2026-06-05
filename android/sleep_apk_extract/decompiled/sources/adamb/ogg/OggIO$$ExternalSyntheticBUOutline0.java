package adamb.ogg;

import android.app.appfunctions.AppFunctionManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.GlobalSearchSession;
import android.app.appsearch.SearchResult;
import android.app.appsearch.observer.ObserverCallback;
import android.window.OnBackInvokedDispatcher;
import java.io.IOException;
import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OggIO$$ExternalSyntheticBUOutline0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(int i, String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i));
    }

    public static /* bridge */ /* synthetic */ AppFunctionManager m(Object obj) {
        return (AppFunctionManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AppSearchResult m0m(Object obj) {
        return (AppSearchResult) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GlobalSearchSession m1m(Object obj) {
        return (GlobalSearchSession) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SearchResult m2m(Object obj) {
        return (SearchResult) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ObserverCallback m3m(Object obj) {
        return (ObserverCallback) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher m4m(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    public static /* synthetic */ void m() {
        throw new ConcurrentModificationException();
    }

    public static /* synthetic */ void m(Object obj, Object obj2, Object obj3) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(Object obj, Object obj2, Object obj3, Object obj4, String str) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void m(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void m(String str, Object obj) {
        throw new IllegalStateException(str + obj + '.');
    }

    public static /* synthetic */ void m(Throwable th) {
        throw new IllegalArgumentException(th);
    }
}

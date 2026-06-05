package retrofit;

import java.util.concurrent.Executor;
import rx.Observable;

/* JADX INFO: loaded from: classes5.dex */
final class RxSupport {
    private final ErrorHandler errorHandler;
    private final Executor executor;
    private final RequestInterceptor requestInterceptor;

    public interface Invoker {
    }

    public RxSupport(Executor executor, ErrorHandler errorHandler, RequestInterceptor requestInterceptor) {
        this.executor = executor;
        this.errorHandler = errorHandler;
        this.requestInterceptor = requestInterceptor;
    }

    public Observable createRequestObservable(final Invoker invoker) {
        return Observable.create(new Observable.OnSubscribe<Object>() { // from class: retrofit.RxSupport.1
        });
    }
}

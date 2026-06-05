package androidx.appfunctions.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/appfunctions/internal/Dispatchers;", "", "<init>", "()V", "Main", "Lkotlinx/coroutines/CoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Main$delegate", "Lkotlin/Lazy;", "Worker", "getWorker", "Worker$delegate", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();

    /* JADX INFO: renamed from: Main$delegate, reason: from kotlin metadata */
    private static final Lazy Main = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(6));

    /* JADX INFO: renamed from: Worker$delegate, reason: from kotlin metadata */
    private static final Lazy Worker = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(7));

    private Dispatchers() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HandlerDispatcher Main_delegate$lambda$0() {
        return HandlerDispatcherKt.from$default(new Handler(Looper.getMainLooper()), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExecutorCoroutineDispatcher Worker_delegate$lambda$0() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executorServiceNewSingleThreadExecutor.getClass();
        return ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    public final CoroutineDispatcher getMain() {
        return (CoroutineDispatcher) Main.getValue();
    }

    public final CoroutineDispatcher getWorker() {
        return (CoroutineDispatcher) Worker.getValue();
    }
}

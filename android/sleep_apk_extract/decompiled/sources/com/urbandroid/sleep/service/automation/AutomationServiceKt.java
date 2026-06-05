package com.urbandroid.sleep.service.automation;

import com.urbandroid.util.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class AutomationServiceKt {
    private static final ExecutorCoroutineDispatcher dispatcher;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("automation"));
        executorServiceNewSingleThreadExecutor.getClass();
        dispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }
}

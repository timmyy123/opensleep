package com.urbandroid.sleep.nearby.core;

import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\rR.\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/MyLogger;", "", "Lkotlin/Function3;", "", "", "", "", "interceptor", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "message", "throwable", "logInfo", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "logWarning", "Lkotlin/jvm/functions/Function3;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyLogger {
    private final Function3<Integer, String, Throwable, Unit> interceptor;

    public /* synthetic */ MyLogger(Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MyLogger$$ExternalSyntheticLambda0() : function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(int i, String str, Throwable th) {
        str.getClass();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void logInfo$default(MyLogger myLogger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        myLogger.logInfo(str, th);
    }

    public static /* synthetic */ void logWarning$default(MyLogger myLogger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        myLogger.logWarning(str, th);
    }

    public final void logInfo(String message, Throwable throwable) {
        message.getClass();
        this.interceptor.invoke(2, message, throwable);
        Logger.logInfo(message, throwable);
    }

    public final void logWarning(String message, Throwable throwable) {
        message.getClass();
        this.interceptor.invoke(3, message, throwable);
        Logger.logWarning(message, throwable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MyLogger(Function3<? super Integer, ? super String, ? super Throwable, Unit> function3) {
        function3.getClass();
        this.interceptor = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MyLogger() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}

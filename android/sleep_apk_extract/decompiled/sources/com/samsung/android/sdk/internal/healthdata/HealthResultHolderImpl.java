package com.samsung.android.sdk.internal.healthdata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult;
import java.util.concurrent.CountDownLatch;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class HealthResultHolderImpl<T extends HealthResultHolder.BaseResult> implements HealthResultHolder<T>, RemoteResultListener<T> {
    private final a<T> b;
    private HealthResultHolder.ResultListener<T> d;
    private volatile T e;
    private volatile boolean f;
    private boolean g;
    private boolean h;
    private final Object a = new Object();
    private final CountDownLatch c = new CountDownLatch(1);

    public static class a<T extends HealthResultHolder.BaseResult> extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(HealthResultHolder.ResultListener<T> resultListener, T t) {
            sendMessage(obtainMessage(1, new Pair(resultListener, t)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                Log.d("Health.ResultHolder", "No default handler");
                return;
            }
            Pair pair = (Pair) message.obj;
            HealthResultHolder.ResultListener resultListener = (HealthResultHolder.ResultListener) pair.first;
            HealthResultHolder.BaseResult baseResult = (HealthResultHolder.BaseResult) pair.second;
            if (resultListener != 0) {
                resultListener.onResult(baseResult);
            }
        }
    }

    public HealthResultHolderImpl(Looper looper) {
        this.b = new a<>(looper);
    }

    private T a() {
        T t;
        synchronized (this.a) {
            c();
            b();
            t = this.e;
            clearStatus();
        }
        return t;
    }

    private void b() {
        if (this.f) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Result has already been processed");
        }
    }

    private void c() {
        if (isReady()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Result is not ready");
    }

    public static <T extends HealthResultHolder.BaseResult> HealthResultHolderImpl<T> createAndSetResult(T t, Looper looper) {
        HealthResultHolderImpl<T> healthResultHolderImpl = new HealthResultHolderImpl<>(looper);
        healthResultHolderImpl.setResult(t);
        return healthResultHolderImpl;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder
    public final T await() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("await() must not be called on the main thread");
            return null;
        }
        b();
        try {
            this.c.await();
        } catch (InterruptedException unused) {
            synchronized (this.a) {
                try {
                    if (!isReady()) {
                        this.h = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        c();
        return (T) a();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder
    public final void cancel() {
        synchronized (this.a) {
            if (this.g || this.f) {
                return;
            }
            try {
                cancelResult();
            } catch (RemoteException e) {
                Log.d("Health.ResultHolder", e.toString());
            }
            this.d = null;
            this.g = true;
        }
    }

    public void cancelResult() {
    }

    public void clearStatus() {
        this.f = true;
        this.e = null;
        this.d = null;
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this.a) {
            z = this.g;
        }
        return z;
    }

    public final boolean isReady() {
        return this.c.getCount() == 0;
    }

    @Override // com.samsung.android.sdk.internal.healthdata.RemoteResultListener
    public void onReceiveHealthResult(int i, T t) {
        setResult(t);
    }

    public final void setResult(T t) {
        synchronized (this.a) {
            try {
                if (!this.h && !this.g) {
                    if (isReady()) {
                        throw new IllegalStateException("Result have been set already");
                    }
                    b();
                    this.e = t;
                    this.c.countDown();
                    HealthResultHolder.ResultListener<T> resultListener = this.d;
                    if (resultListener != null && !this.g) {
                        this.b.a(resultListener, a());
                    }
                }
            } finally {
            }
        }
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder
    public final void setResultListener(HealthResultHolder.ResultListener<T> resultListener) {
        b();
        synchronized (this.a) {
            try {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.b.a(resultListener, a());
                } else {
                    this.d = resultListener;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

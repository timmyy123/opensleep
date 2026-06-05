package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import java.util.HashMap;
import java.util.Random;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxa {
    static {
        Math.abs(new Random().nextInt());
        new HashMap();
    }

    public static final Runnable zza(Runnable runnable) {
        runnable.getClass();
        return new zzwz(new Ref$ObjectRef(), zzvy.zzb(false), runnable);
    }

    public static final AsyncCallable zzb(AsyncCallable asyncCallable) {
        asyncCallable.getClass();
        return new zzwx(zzvy.zzb(false), asyncCallable);
    }

    public static final AsyncFunction zzc(AsyncFunction asyncFunction) {
        asyncFunction.getClass();
        return new zzwy(zzvy.zzb(false), asyncFunction);
    }
}

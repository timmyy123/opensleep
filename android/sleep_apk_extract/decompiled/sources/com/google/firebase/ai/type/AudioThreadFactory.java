package com.google.firebase.ai.type;

import android.os.Process;
import android.os.StrictMode;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda9;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/AudioThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "<init>", "()V", "threadCount", "Ljava/util/concurrent/atomic/AtomicLong;", "policy", "Landroid/os/StrictMode$ThreadPolicy;", "newThread", "Ljava/lang/Thread;", "task", "Ljava/lang/Runnable;", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AudioThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThreadFactory DEFAULT;
    private final AtomicLong threadCount = new AtomicLong();
    private final StrictMode.ThreadPolicy policy = INSTANCE.audioPolicy();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/AudioThreadFactory$Companion;", "", "<init>", "()V", "DEFAULT", "Ljava/util/concurrent/ThreadFactory;", "getDEFAULT", "()Ljava/util/concurrent/ThreadFactory;", "audioPolicy", "Landroid/os/StrictMode$ThreadPolicy;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final StrictMode.ThreadPolicy audioPolicy() {
            StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
            builderDetectNetwork.getClass();
            StrictMode.ThreadPolicy threadPolicyBuild = builderDetectNetwork.penaltyLog().build();
            threadPolicyBuild.getClass();
            return threadPolicyBuild;
        }

        public final ThreadFactory getDEFAULT() {
            return AudioThreadFactory.DEFAULT;
        }

        private Companion() {
        }
    }

    static {
        ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        threadFactoryDefaultThreadFactory.getClass();
        DEFAULT = threadFactoryDefaultThreadFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newThread$lambda$0(AudioThreadFactory audioThreadFactory, Runnable runnable) {
        Process.setThreadPriority(-16);
        StrictMode.setThreadPolicy(audioThreadFactory.policy);
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable task) {
        Thread threadNewThread = DEFAULT.newThread(new FacebookSdk$$ExternalSyntheticLambda9(this, task, 25));
        threadNewThread.setName("Firebase Audio Thread #" + this.threadCount.getAndIncrement());
        return threadNewThread;
    }
}

package androidx.work.impl;

import androidx.work.ListenableWorker;
import com.google.firebase.ai.type.LiveAudioConversationConfig;
import com.google.firebase.ai.type.LiveSession;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkerWrapper$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ WorkerWrapper$$ExternalSyntheticLambda1(ListenableWorker listenableWorker, boolean z, String str, WorkerWrapper workerWrapper) {
        this.f$0 = listenableWorker;
        this.f$1 = z;
        this.f$2 = str;
        this.f$3 = workerWrapper;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        boolean z = this.f$1;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                return WorkerWrapper.runWorker$lambda$4((ListenableWorker) obj4, z, (String) obj3, (WorkerWrapper) obj2, (Throwable) obj);
            default:
                return LiveSession.startAudioConversation$lambda$1((Function1) obj4, (Function2) obj3, (Function1) obj2, z, (LiveAudioConversationConfig.Builder) obj);
        }
    }

    public /* synthetic */ WorkerWrapper$$ExternalSyntheticLambda1(Function1 function1, Function2 function2, Function1 function12, boolean z) {
        this.f$0 = function1;
        this.f$2 = function2;
        this.f$3 = function12;
        this.f$1 = z;
    }
}

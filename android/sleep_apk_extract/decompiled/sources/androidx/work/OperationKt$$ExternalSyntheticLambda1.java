package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.view.MutableLiveData;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OperationKt$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ OperationKt$$ExternalSyntheticLambda1(Tracer tracer, String str, Function0 function0, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = tracer;
        this.f$1 = str;
        this.f$2 = function0;
        this.f$3 = mutableLiveData;
        this.f$4 = completer;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        int i = this.$r8$classId;
        Object obj = this.f$4;
        Object obj2 = this.f$3;
        String str = this.f$1;
        Object obj3 = this.f$2;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                OperationKt.launchOperation$lambda$2$lambda$1((Tracer) obj4, str, (Function0) obj3, (MutableLiveData) obj2, (CallbackToFutureAdapter.Completer) obj);
                break;
            default:
                OidcSecurityUtil.getRawKeyFromEndPoint$lambda$1((URL) obj4, (Ref$ObjectRef) obj3, str, (ReentrantLock) obj2, (Condition) obj);
                break;
        }
    }

    public /* synthetic */ OperationKt$$ExternalSyntheticLambda1(URL url, Ref$ObjectRef ref$ObjectRef, String str, ReentrantLock reentrantLock, Condition condition) {
        this.f$0 = url;
        this.f$2 = ref$ObjectRef;
        this.f$1 = str;
        this.f$3 = reentrantLock;
        this.f$4 = condition;
    }
}

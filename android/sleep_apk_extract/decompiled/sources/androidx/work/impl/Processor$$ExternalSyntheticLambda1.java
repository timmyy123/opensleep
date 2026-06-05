package androidx.work.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.work.WorkerParameters;
import com.facebook.appevents.iap.InAppPurchaseAutoLogger;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.NativeAppLoginMethodHandler;
import com.google.common.util.concurrent.ListenableFuture;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.trial.JavaBilling;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Processor$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                ((Processor) obj3).lambda$startWork$1((ListenableFuture) obj2, (WorkerWrapper) obj);
                break;
            case 1:
                WorkLauncherImpl.startWork$lambda$0((WorkLauncherImpl) obj3, (StartStopToken) obj2, (WorkerParameters.RuntimeExtras) obj);
                break;
            case 2:
                InAppPurchaseAutoLogger.startIapLogging$lambda$1((Ref$ObjectRef) obj3, (InAppPurchaseUtils.BillingClientVersion) obj2, (Context) obj);
                break;
            case 3:
                Task.Companion.call$lambda$2((CancellationToken) obj3, (TaskCompletionSource) obj2, (Callable) obj);
                break;
            case 4:
                CustomTabLoginMethodHandler.onCustomTabComplete$lambda$0((CustomTabLoginMethodHandler) obj3, (LoginClient.Request) obj2, (Bundle) obj);
                break;
            case 5:
                NativeAppLoginMethodHandler.processSuccessResponse$lambda$0((NativeAppLoginMethodHandler) obj3, (LoginClient.Request) obj2, (Bundle) obj);
                break;
            case 6:
                ((UnlockFlow) obj3).lambda$loadPrices$21((List) obj2, (JavaBilling) obj);
                break;
            default:
                ((DashboardCard) obj3).lambda$getViewHolder$0((DashboardCard) obj2, (List) obj);
                break;
        }
    }
}

package androidx.work;

import android.view.View;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.health.platform.client.impl.ServiceBackedHealthDataClient;
import androidx.health.platform.client.impl.ipc.RemoteFutureOperation;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.request.DeleteDataRangeRequest;
import androidx.health.platform.client.request.DeleteDataRequest;
import androidx.health.platform.client.request.ReadDataRangeRequest;
import androidx.health.platform.client.request.ReadDataRequest;
import androidx.health.platform.client.service.IHealthDataService;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.common.util.concurrent.SettableFuture;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity;
import com.urbandroid.sleep.gui.IOnBindListener;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.MediaListAdapter;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.functions.Action;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkerKt$$ExternalSyntheticLambda0 implements RemoteFutureOperation, CallbackToFutureAdapter.Resolver, ViewIndexingTrigger.OnShakeListener, FileDownloadTask.Callback, SynchronizationGuard.CriticalSection, RxUtils.Emitter, Action, IOnBindListener, MediaListActivity.LoadAlbumListener, OnFailureListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ WorkerKt$$ExternalSyntheticLambda0(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.$r8$classId) {
            case 0:
                return WorkerKt.future$lambda$2((Executor) this.f$0, (Function0) this.f$1, completer);
            default:
                return CoroutineAdapterKt.asListenableFuture$lambda$0((Deferred) this.f$0, this.f$1, completer);
        }
    }

    @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
    public void execute(Object obj, SettableFuture settableFuture) {
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        ServiceBackedHealthDataClient serviceBackedHealthDataClient = (ServiceBackedHealthDataClient) this.f$0;
        switch (i) {
            case 1:
                ServiceBackedHealthDataClient.getChanges$lambda$13(serviceBackedHealthDataClient, (RequestProto.GetChangesRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 2:
                ServiceBackedHealthDataClient.getChangesToken$lambda$12(serviceBackedHealthDataClient, (RequestProto.GetChangesTokenRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 3:
                ServiceBackedHealthDataClient.aggregate$lambda$11(serviceBackedHealthDataClient, (RequestProto.AggregateDataRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 4:
                ServiceBackedHealthDataClient.deleteData$lambda$7(serviceBackedHealthDataClient, (DeleteDataRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 5:
                ServiceBackedHealthDataClient.deleteDataRange$lambda$8(serviceBackedHealthDataClient, (DeleteDataRangeRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 6:
                ServiceBackedHealthDataClient.registerForDataNotifications$lambda$14(serviceBackedHealthDataClient, (RequestProto.RegisterForDataNotificationsRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 7:
                ServiceBackedHealthDataClient.readDataRange$lambda$10(serviceBackedHealthDataClient, (ReadDataRangeRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            case 8:
                ServiceBackedHealthDataClient.unregisterFromDataNotifications$lambda$15(serviceBackedHealthDataClient, (RequestProto.UnregisterFromDataNotificationsRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
            default:
                ServiceBackedHealthDataClient.readData$lambda$9(serviceBackedHealthDataClient, (ReadDataRequest) obj2, (IHealthDataService) obj, settableFuture);
                break;
        }
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.LoadAlbumListener
    public void finished() {
        ((MediaListAdapter) this.f$0).lambda$getView$0((View) this.f$1);
    }

    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
    public void item(Object obj) {
        ((BleDisClient) this.f$0).lambda$processServiceData$2((UUID) this.f$1, (FlowableEmitter) obj);
    }

    @Override // com.urbandroid.sleep.gui.IOnBindListener
    public void onBind() {
        ((CaptchaSettingsActivity) this.f$0).lambda$refresh$1((PreferenceActivity) this.f$1);
    }

    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
    public void onComplete(File file) {
        ModelManager.TaskHandler.Companion.execute$lambda$1$lambda$0((ModelManager.TaskHandler) this.f$0, (Model) this.f$1, file);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        GoogleFitApiFactory.disconnectAppFromFit$lambda$2((GoogleFitApiFactory.DisconnectAppFromFitListener) this.f$0, (GoogleFitApiFactory) this.f$1, exc);
    }

    @Override // com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener
    public void onShake() {
        CodelessManager.onActivityResumed$lambda$0((FetchedAppSettings) this.f$0, (String) this.f$1);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        RxUtils.lambda$monitorNotifications$1((AtomicSet) this.f$0, (FlowableEmitter[]) this.f$1);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Uploader uploader = (Uploader) this.f$0;
        switch (i) {
            case 13:
                return uploader.lambda$logAndUpdateState$5((Iterable) obj);
            default:
                return uploader.lambda$logAndUpdateState$7((HashMap) obj);
        }
    }
}

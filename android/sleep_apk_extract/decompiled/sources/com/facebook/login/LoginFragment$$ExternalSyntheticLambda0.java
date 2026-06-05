package com.facebook.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda1;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.health.platform.client.impl.ServiceBackedHealthDataClient;
import androidx.health.platform.client.impl.ipc.RemoteFutureOperation;
import androidx.health.platform.client.service.IHealthDataService;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.work.impl.WorkDatabase;
import com.facebook.GraphResponse;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.gamingservices.ContextChooseDialog;
import com.facebook.gamingservices.ContextCreateDialog;
import com.facebook.gamingservices.ContextSwitchDialog;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.login.LoginClient;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.slider.LabelFormatter;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.polar.androidcommunications.api.ble.model.gatt.client.BlePsdClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandler;
import com.spotify.android.appremote.api.Connector;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.ErrorCallback;
import com.urbandroid.common.error.IErrorDialogAction;
import com.urbandroid.sleep.async.ExportDataAsyncTask;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda3;
import com.urbandroid.sleep.persistence.Export;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.functions.Action;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LoginFragment$$ExternalSyntheticLambda0 implements InputConnectionCompat.OnCommitContentListener, RemoteFutureOperation, SupportSQLiteOpenHelper.Factory, FileDownloadTask.Callback, DaemonRequest.Callback, LoginClient.OnCompletedListener, ActivityResultCallback, ImageRequest.Callback, SynchronizationGuard.CriticalSection, MaterialShapeDrawable.OnCornerSizeChangeListener, CanvasCompat.CanvasOperation, ObjectConstructor, RxUtils.Emitter, Action, ErrorCallback, OnSuccessListener, Export.ProgressListener, LabelFormatter, IErrorDialogAction, CallResult.ResultCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LoginFragment$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 16:
                return ConstructorConstructor.lambda$newDefaultConstructor$2((Constructor) obj);
            default:
                return ConstructorConstructor.lambda$newUnsafeAllocator$4((Class) obj);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0((Context) this.f$0, configuration);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 10:
                return ((ClientHealthMetricsStore) obj).loadClientMetrics();
            case 11:
                return Integer.valueOf(((EventStore) obj).cleanUp());
            case 12:
                return ((Uploader) obj).lambda$logAndUpdateState$6();
            default:
                return ((WorkInitializer) obj).lambda$ensureContextsScheduled$0();
        }
    }

    @Override // com.google.android.material.slider.LabelFormatter
    public String getFormattedValue(float f) {
        return ((SeekBarPreference) this.f$0).lambda$initPreference$1(f);
    }

    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
    public void item(Object obj) {
        BlePsdClient.lambda$processServiceData$0((byte[]) this.f$0, (FlowableEmitter) obj);
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        LoginFragment.onCreate$lambda$1((Function1) this.f$0, (ActivityResult) obj);
    }

    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
    public void onComplete(File file) {
        ModelManager.TaskHandler.Companion.execute$lambda$1((List) this.f$0, file);
    }

    @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 5:
                ContextChooseDialog.showForCloud$lambda$2((ContextChooseDialog) obj, graphResponse);
                break;
            case 6:
                ContextCreateDialog.showForCloud$lambda$2((ContextCreateDialog) obj, graphResponse);
                break;
            default:
                ContextSwitchDialog.showForCloud$lambda$2((ContextSwitchDialog) obj, graphResponse);
                break;
        }
    }

    public void onError(Throwable th) {
        ((Connector.ConnectionListener) this.f$0).onFailure(th);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 22:
                ((CodecsKt$$ExternalSyntheticLambda2) obj2).invoke(obj);
                break;
            case 23:
                ((SnapshotStateList$$ExternalSyntheticLambda1) obj2).invoke(obj);
                break;
            case 24:
                ((SnapshotStateList$$ExternalSyntheticLambda1) obj2).invoke(obj);
                break;
            default:
                ((Endpoint$$ExternalSyntheticLambda3) obj2).invoke(obj);
                break;
        }
    }

    @Override // com.urbandroid.sleep.persistence.Export.ProgressListener
    public void recordProcessed(int i, SleepRecord sleepRecord) {
        ((ExportDataAsyncTask) this.f$0).lambda$performInBackground$0(i, sleepRecord);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 19:
                BlePMDClient.stopMeasurement$lambda$21((BlePMDClient) obj);
                break;
            default:
                ConnectionHandler.connecting$lambda$1((BDDeviceSessionImpl) obj);
                break;
        }
    }

    @Override // com.urbandroid.common.error.IErrorDialogAction
    public void execute(DialogInterface dialogInterface, String str) {
        DocItemDialogFragment.AnonymousClass2.onClick$lambda$0((Activity) this.f$0, dialogInterface, str);
    }

    @Override // com.facebook.internal.ImageRequest.Callback
    public void onCompleted(ImageResponse imageResponse) {
        ProfilePictureView.sendImageRequest$lambda$2((ProfilePictureView) this.f$0, imageResponse);
    }

    public void run(Canvas canvas) {
        ((NavigationView) this.f$0).lambda$dispatchDraw$0(canvas);
    }

    @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
    public void execute(Object obj, SettableFuture settableFuture) {
        ServiceBackedHealthDataClient.revokeAllPermissions$lambda$4((ServiceBackedHealthDataClient) this.f$0, (IHealthDataService) obj, settableFuture);
    }

    @Override // com.facebook.login.LoginClient.OnCompletedListener
    public void onCompleted(LoginClient.Result result) {
        LoginFragment.onCreate$lambda$0((LoginFragment) this.f$0, result);
    }
}

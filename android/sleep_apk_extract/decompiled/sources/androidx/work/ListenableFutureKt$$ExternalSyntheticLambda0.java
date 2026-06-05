package androidx.work;

import android.content.Context;
import android.view.View;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.CancellationSignal;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdControlPointCommandClientToService;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpClient;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.urbandroid.sleep.fragment.dashboard.card.WeatherCard;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.refferer.ReferrerCheck;
import com.urbandroid.sleep.trial.eu.LocationUtils;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import java.io.ByteArrayInputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ListenableFutureKt$$ExternalSyntheticLambda0 implements CancellationSignal.OnCancelListener, CallbackToFutureAdapter.Resolver, SynchronizationGuard.CriticalSection, RxUtils.Emitter, SingleOnSubscribe, FlowableOnSubscribe, LocationService.LocationCallback, LocationUtils.CountryCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ListenableFutureKt$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.$r8$classId) {
            case 0:
                return ListenableFutureKt.launchFuture$lambda$1((CoroutineContext) this.f$0, (CoroutineStart) this.f$1, (Function2) this.f$2, completer);
            default:
                return ListenableFutureKt.executeAsync$lambda$4((Executor) this.f$0, (String) this.f$1, (Function0) this.f$2, completer);
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return ((DefaultScheduler) this.f$0).lambda$schedule$0((TransportContext) this.f$1, (EventInternal) this.f$2);
    }

    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
    public void item(Object obj) {
        ((BleDisClient) this.f$0).lambda$processServiceData$0((UUID) this.f$1, (byte[]) this.f$2, (FlowableEmitter) obj);
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.f$0, (Transition) this.f$1, (Runnable) this.f$2);
    }

    public void onCountryResolved(String str) {
        ReferrerCheck.checkReferrer$lambda$0((ReferrerCheck) this.f$0, (Context) this.f$1, (Settings) this.f$2, str);
    }

    @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
    public void subscribe(FlowableEmitter flowableEmitter) {
        ((BlePsFtpClient) this.f$0).lambda$write$2((byte[]) this.f$1, (ByteArrayInputStream) this.f$2, flowableEmitter);
    }

    @Override // com.urbandroid.sleep.location.LocationService.LocationCallback
    public void updateLocation(Location location) {
        WeatherCard.requestWeather$lambda$0((WeatherCard) this.f$0, (View) this.f$1, (Context) this.f$2, location);
    }

    @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
    public void subscribe(SingleEmitter singleEmitter) {
        BlePMDClient.sendControlPointCommand$lambda$15((BlePMDClient) this.f$0, (byte[]) this.f$1, (PmdControlPointCommandClientToService) this.f$2, singleEmitter);
    }
}

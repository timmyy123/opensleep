package com.google.android.gms.common.api.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.GmsClientFlags;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleApiManager implements Handler.Callback {
    private static GoogleApiManager zah;
    private TelemetryData zaf;
    private TelemetryLoggingClient zag;
    private final Context zaj;
    private final GoogleApiAvailability zak;
    private final com.google.android.gms.common.internal.zaq zal;
    private final Handler zas;
    private volatile boolean zat;
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zae = new Object();
    private static volatile boolean zai = false;
    private long zac = 10000;
    private boolean zad = false;
    private final AtomicInteger zam = new AtomicInteger(1);
    private final AtomicInteger zan = new AtomicInteger(0);
    private final Map zao = new ConcurrentHashMap(5, 0.75f, 1);
    private zaab zap = null;
    private final Set zaq = new ArraySet();
    private final Set zar = new ArraySet();

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zat = true;
        this.zaj = context;
        com.google.android.gms.internal.base.zar zarVar = new com.google.android.gms.internal.base.zar(looper, this);
        this.zas = zarVar;
        this.zak = googleApiAvailability;
        this.zal = new com.google.android.gms.common.internal.zaq(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zat = false;
        }
        zarVar.sendMessage(zarVar.obtainMessage(6));
    }

    public static void reportSignOut() {
        synchronized (zae) {
            try {
                GoogleApiManager googleApiManager = zah;
                if (googleApiManager != null) {
                    googleApiManager.zan.incrementAndGet();
                    Handler handler = googleApiManager.zas;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final zabk zaH(GoogleApi googleApi) {
        Map map = this.zao;
        ApiKey apiKey = googleApi.getApiKey();
        zabk zabkVar = (zabk) map.get(apiKey);
        if (zabkVar == null) {
            zabkVar = new zabk(this, googleApi);
            map.put(apiKey, zabkVar);
        }
        if (zabkVar.zap()) {
            this.zar.add(apiKey);
        }
        zabkVar.zam();
        return zabkVar;
    }

    private final void zaI(TaskCompletionSource taskCompletionSource, int i, GoogleApi googleApi) {
        zabx zabxVarZaa;
        if (i == 0 || (zabxVarZaa = zabx.zaa(this, i, googleApi.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        final Handler handler = this.zas;
        Objects.requireNonNull(handler);
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabo
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zabxVarZaa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zaJ(ApiKey apiKey, ConnectionResult connectionResult) {
        String strZaa = apiKey.zaa();
        String strValueOf = String.valueOf(connectionResult);
        return new Status(connectionResult, Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strZaa).length() + 63 + strValueOf.length()), "API: ", strZaa, " is not available on this device. Connection failed with: ", strValueOf));
    }

    private final void zaK() {
        TelemetryData telemetryData = this.zaf;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zam()) {
                zaL().log(telemetryData);
            }
            this.zaf = null;
        }
    }

    private final TelemetryLoggingClient zaL() {
        if (this.zag == null) {
            this.zag = TelemetryLogging.getClient(this.zaj);
        }
        return this.zag;
    }

    public static GoogleApiManager zaa(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zae) {
            try {
                if (zah == null) {
                    Looper looper = GmsClientSupervisor.getOrStartHandlerThread().getLooper();
                    boolean zIsBindServiceOptimizationEnabled = GmsClientFlags.isBindServiceOptimizationEnabled(context.getPackageName());
                    zai = zIsBindServiceOptimizationEnabled;
                    GoogleApiManager googleApiManager2 = new GoogleApiManager(context.getApplicationContext(), looper, GoogleApiAvailability.getInstance());
                    if (zIsBindServiceOptimizationEnabled) {
                        GmsClient.zag(com.google.android.gms.common.internal.zan.zaa(googleApiManager2.zaj));
                    }
                    zah = googleApiManager2;
                }
                googleApiManager = zah;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zabk zabkVar;
        int i = message.what;
        switch (i) {
            case 1:
                this.zac = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                Handler handler = this.zas;
                handler.removeMessages(12);
                Iterator it = this.zao.keySet().iterator();
                while (it.hasNext()) {
                    handler.sendMessageDelayed(handler.obtainMessage(12, (ApiKey) it.next()), this.zac);
                }
                return true;
            case 2:
                throw FileInsert$$ExternalSyntheticOutline0.m(message.obj);
            case 3:
                for (zabk zabkVar2 : this.zao.values()) {
                    zabkVar2.zah();
                    zabkVar2.zam();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zacb zacbVar = (zacb) message.obj;
                Map map = this.zao;
                GoogleApi googleApi = zacbVar.zac;
                zabk zabkVarZaH = (zabk) map.get(googleApi.getApiKey());
                if (zabkVarZaH == null) {
                    zabkVarZaH = zaH(googleApi);
                }
                if (!zabkVarZaH.zap() || this.zan.get() == zacbVar.zab) {
                    zabkVarZaH.zad(zacbVar.zaa);
                    return true;
                }
                zacbVar.zaa.zad(zaa);
                zabkVarZaH.zae();
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.zao.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabkVar = (zabk) it2.next();
                        if (zabkVar.zaq() == i2) {
                        }
                    } else {
                        zabkVar = null;
                    }
                }
                if (zabkVar == null) {
                    Log.wtf("GoogleApiManager", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i2).length() + 65), "Could not find API instance ", i2, " while trying to fail enqueued calls."), new Exception());
                    return true;
                }
                if (connectionResult.getErrorCode() != 13) {
                    zabkVar.zav(zaJ(zabkVar.zaA(), connectionResult));
                    return true;
                }
                String errorString = this.zak.getErrorString(connectionResult.getErrorCode());
                String errorMessage = connectionResult.getErrorMessage();
                zabkVar.zav(new Status(17, Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length()), "Error resolution was canceled by the user, original error message: ", errorString, ": ", errorMessage)));
                return true;
            case 6:
                Context context = this.zaj;
                if (context.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) context.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabf(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zac = 300000L;
                        return true;
                    }
                }
                return true;
            case 7:
                zaH((GoogleApi) message.obj);
                return true;
            case 9:
                Map map2 = this.zao;
                if (map2.containsKey(message.obj)) {
                    ((zabk) map2.get(message.obj)).zaj();
                    return true;
                }
                return true;
            case 10:
                Set set = this.zar;
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    zabk zabkVar3 = (zabk) this.zao.remove((ApiKey) it3.next());
                    if (zabkVar3 != null) {
                        zabkVar3.zae();
                    }
                }
                set.clear();
                return true;
            case 11:
                Map map3 = this.zao;
                if (map3.containsKey(message.obj)) {
                    ((zabk) map3.get(message.obj)).zak();
                    return true;
                }
                return true;
            case 12:
                Map map4 = this.zao;
                if (map4.containsKey(message.obj)) {
                    ((zabk) map4.get(message.obj)).zal();
                    return true;
                }
                return true;
            case 14:
                zaac zaacVar = (zaac) message.obj;
                ApiKey apiKeyZaa = zaacVar.zaa();
                Map map5 = this.zao;
                if (map5.containsKey(apiKeyZaa)) {
                    zaacVar.zab().setResult(Boolean.valueOf(((zabk) map5.get(apiKeyZaa)).zaw(false)));
                    return true;
                }
                zaacVar.zab().setResult(Boolean.FALSE);
                return true;
            case 15:
                zabl zablVar = (zabl) message.obj;
                Map map6 = this.zao;
                if (map6.containsKey(zablVar.zaa())) {
                    ((zabk) map6.get(zablVar.zaa())).zax(zablVar);
                    return true;
                }
                return true;
            case 16:
                zabl zablVar2 = (zabl) message.obj;
                Map map7 = this.zao;
                if (map7.containsKey(zablVar2.zaa())) {
                    ((zabk) map7.get(zablVar2.zaa())).zay(zablVar2);
                    return true;
                }
                return true;
            case 17:
                zaK();
                return true;
            case 18:
                zaby zabyVar = (zaby) message.obj;
                long j = zabyVar.zac;
                if (j == 0) {
                    zaL().log(new TelemetryData(zabyVar.zab, Arrays.asList(zabyVar.zaa)));
                    return true;
                }
                TelemetryData telemetryData = this.zaf;
                if (telemetryData != null) {
                    List listZab = telemetryData.zab();
                    if (telemetryData.zaa() != zabyVar.zab || (listZab != null && listZab.size() >= zabyVar.zad)) {
                        this.zas.removeMessages(17);
                        zaK();
                    } else {
                        this.zaf.zac(zabyVar.zaa);
                    }
                }
                if (this.zaf == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(zabyVar.zaa);
                    this.zaf = new TelemetryData(zabyVar.zab, arrayList);
                    Handler handler2 = this.zas;
                    handler2.sendMessageDelayed(handler2.obtainMessage(17), j);
                    return true;
                }
                return true;
            case 19:
                this.zad = false;
                return true;
            default:
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                sb.append("Unknown message id: ");
                sb.append(i);
                Log.w("GoogleApiManager", sb.toString());
                return false;
        }
    }

    public final /* synthetic */ GoogleApiAvailability zaA() {
        return this.zak;
    }

    public final /* synthetic */ com.google.android.gms.common.internal.zaq zaB() {
        return this.zal;
    }

    public final /* synthetic */ Map zaC() {
        return this.zao;
    }

    public final /* synthetic */ zaab zaD() {
        return this.zap;
    }

    public final /* synthetic */ Set zaE() {
        return this.zaq;
    }

    public final /* synthetic */ Handler zaF() {
        return this.zas;
    }

    public final /* synthetic */ boolean zaG() {
        return this.zat;
    }

    public final int zac() {
        return this.zam.getAndIncrement();
    }

    public final void zad(GoogleApi googleApi) {
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zae(zaab zaabVar) {
        synchronized (zae) {
            try {
                if (this.zap != zaabVar) {
                    this.zap = zaabVar;
                    this.zaq.clear();
                }
                this.zaq.addAll(zaabVar.zab());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zaf(zaab zaabVar) {
        synchronized (zae) {
            try {
                if (this.zap == zaabVar) {
                    this.zap = null;
                    this.zaq.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zabk zag(ApiKey apiKey) {
        return (zabk) this.zao.get(apiKey);
    }

    public final void zai() {
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final Task zaj(GoogleApi googleApi) {
        zaac zaacVar = new zaac(googleApi.getApiKey());
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(14, zaacVar));
        return zaacVar.zab().getTask();
    }

    public final void zak(GoogleApi googleApi, int i, BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        zacb zacbVar = new zacb(new zae(i, baseImplementation$ApiMethodImpl), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(4, zacbVar));
    }

    public final void zal(GoogleApi googleApi, int i, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaI(taskCompletionSource, taskApiCall.zab(), googleApi);
        zacb zacbVar = new zacb(new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(4, zacbVar));
    }

    public final boolean zam() {
        if (this.zad) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int iZab = this.zal.zab(this.zaj, 203400000);
        return iZab == -1 || iZab == 0;
    }

    public final Task zan(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaI(taskCompletionSource, registerListenerMethod.zab(), googleApi);
        zacb zacbVar = new zacb(new zaf(new zacc(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(8, zacbVar));
        return taskCompletionSource.getTask();
    }

    public final Task zao(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaI(taskCompletionSource, i, googleApi);
        zacb zacbVar = new zacb(new zah(listenerKey, taskCompletionSource), this.zan.get(), googleApi);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(13, zacbVar));
        return taskCompletionSource.getTask();
    }

    public final Handler zap() {
        return this.zas;
    }

    public final boolean zaq(ConnectionResult connectionResult, int i) {
        GoogleApiAvailability googleApiAvailability = this.zak;
        if (googleApiAvailability.zaj(connectionResult.getErrorCode())) {
            return googleApiAvailability.zad(this.zaj, connectionResult, i);
        }
        Log.w("GoogleApiManager", "Not showing notification since connectionResult is not user-facing: ".concat(String.valueOf(connectionResult)));
        return false;
    }

    public final void zar(ConnectionResult connectionResult, int i) {
        if (zaq(connectionResult, i)) {
            return;
        }
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void zas(MethodInvocation methodInvocation, int i, long j, int i2) {
        zaby zabyVar = new zaby(methodInvocation, i, j, i2);
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(18, zabyVar));
    }

    public final /* synthetic */ long zaw() {
        return this.zac;
    }

    public final /* synthetic */ void zax(boolean z) {
        this.zad = true;
    }

    public final /* synthetic */ Context zaz() {
        return this.zaj;
    }
}

package io.rebble.pebblekit2.client;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.os.BundleKt;
import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import io.rebble.pebblekit2.common.model.PebbleDictionarySerializationKt;
import io.rebble.pebblekit2.common.model.ReceiveResult;
import io.rebble.pebblekit2.common.model.ReceiveResultSerializationKt;
import io.rebble.pebblekit2.common.model.WatchIdentifier;
import io.rebble.pebblekit2.common.util.UniversalRequestResponseSuspending;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006("}, d2 = {"Lio/rebble/pebblekit2/client/BasePebbleListenerService;", "Landroid/app/Service;", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onMessageReceived", "Lio/rebble/pebblekit2/common/model/ReceiveResult;", "watchappUUID", "Ljava/util/UUID;", "data", "", "Lkotlin/UInt;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lio/rebble/pebblekit2/common/model/PebbleDictionary;", "watch", "Lio/rebble/pebblekit2/common/model/WatchIdentifier;", "onMessageReceived-PjNdOfI", "(Ljava/util/UUID;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAppOpened", "", "onAppOpened-kxV8hDc", "(Ljava/util/UUID;Ljava/lang/String;)V", "onAppClosed", "onAppClosed-kxV8hDc", "onBind", "Landroid/os/IBinder;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "handleReceiveData", "Landroid/os/Bundle;", "input", "callingPackage", "", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAppOpened", "handleAppClosed", "Binder", "client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BasePebbleListenerService extends Service {
    private final CoroutineScope coroutineScope = CoroutineScopeKt.MainScope();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0094@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lio/rebble/pebblekit2/client/BasePebbleListenerService$Binder;", "Lio/rebble/pebblekit2/common/util/UniversalRequestResponseSuspending;", "<init>", "(Lio/rebble/pebblekit2/client/BasePebbleListenerService;)V", "request", "Landroid/os/Bundle;", "data", "callingPackage", "", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class Binder extends UniversalRequestResponseSuspending {
        public Binder() {
            super(BasePebbleListenerService.this, BasePebbleListenerService.this.getCoroutineScope());
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // io.rebble.pebblekit2.common.util.UniversalRequestResponseSuspending
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object request(Bundle bundle, String str, Continuation<? super Bundle> continuation) {
            BasePebbleListenerService$Binder$request$1 basePebbleListenerService$Binder$request$1;
            if (continuation instanceof BasePebbleListenerService$Binder$request$1) {
                basePebbleListenerService$Binder$request$1 = (BasePebbleListenerService$Binder$request$1) continuation;
                int i = basePebbleListenerService$Binder$request$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    basePebbleListenerService$Binder$request$1.label = i - Integer.MIN_VALUE;
                } else {
                    basePebbleListenerService$Binder$request$1 = new BasePebbleListenerService$Binder$request$1(this, continuation);
                }
            }
            Object currentlySelectedApp = basePebbleListenerService$Binder$request$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = basePebbleListenerService$Binder$request$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(currentlySelectedApp);
                PebbleAndroidAppPicker companion = DefaultPebbleAndroidAppPicker.INSTANCE.getInstance(BasePebbleListenerService.this);
                basePebbleListenerService$Binder$request$1.L$0 = bundle;
                basePebbleListenerService$Binder$request$1.L$1 = str;
                basePebbleListenerService$Binder$request$1.label = 1;
                currentlySelectedApp = companion.getCurrentlySelectedApp(basePebbleListenerService$Binder$request$1);
                if (currentlySelectedApp != coroutine_suspended) {
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(currentlySelectedApp);
                return currentlySelectedApp;
            }
            str = (String) basePebbleListenerService$Binder$request$1.L$1;
            bundle = (Bundle) basePebbleListenerService$Binder$request$1.L$0;
            ResultKt.throwOnFailure(currentlySelectedApp);
            String str2 = (String) currentlySelectedApp;
            if (!Intrinsics.areEqual(str2, str)) {
                Logger logger = BasePebbleListenerServiceKt.LOGGER;
                String tag = logger.getTag();
                Severity severity = Severity.Warn;
                if (logger.getConfig().get_minSeverity().compareTo(severity) <= 0) {
                    if (str == null) {
                        str = "UNKNOWN";
                    }
                    if (str2 == null) {
                        str2 = "NONE";
                    }
                    logger.processLog(severity, tag, null, FileInsert$$ExternalSyntheticOutline0.m("Got message from non-selected app: ", str, ". Selected app: ", str2, "."));
                }
                return new Bundle();
            }
            String string = bundle.getString(ShareConstants.ACTION);
            if (string != null) {
                int iHashCode = string.hashCode();
                if (iHashCode != -360758934) {
                    if (iHashCode != -13817753) {
                        if (iHashCode == 809130762 && string.equals("ACTION_RECEIVE_DATA_FROM_WATCH")) {
                            BasePebbleListenerService basePebbleListenerService = BasePebbleListenerService.this;
                            basePebbleListenerService$Binder$request$1.L$0 = SpillingKt.nullOutSpilledVariable(bundle);
                            basePebbleListenerService$Binder$request$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                            basePebbleListenerService$Binder$request$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                            basePebbleListenerService$Binder$request$1.L$3 = SpillingKt.nullOutSpilledVariable(string);
                            basePebbleListenerService$Binder$request$1.label = 2;
                            Object objHandleReceiveData = basePebbleListenerService.handleReceiveData(bundle, str, basePebbleListenerService$Binder$request$1);
                            return objHandleReceiveData == coroutine_suspended ? coroutine_suspended : objHandleReceiveData;
                        }
                    } else if (string.equals("APP_OPENED")) {
                        return BasePebbleListenerService.this.handleAppOpened(bundle, str);
                    }
                } else if (string.equals("APP_CLOSED")) {
                    return BasePebbleListenerService.this.handleAppClosed(bundle, str);
                }
            }
            Logger logger2 = BasePebbleListenerServiceKt.LOGGER;
            String tag2 = logger2.getTag();
            Severity severity2 = Severity.Warn;
            if (logger2.getConfig().get_minSeverity().compareTo(severity2) <= 0) {
                if (string == null) {
                    string = "UNKNOWN";
                }
                if (str == null) {
                    str = "UNKNOWN";
                }
                logger2.processLog(severity2, tag2, null, FileInsert$$ExternalSyntheticOutline0.m("Got unknown action ", string, " from ", str, ". Ignoring event..."));
            }
            return new Bundle();
        }
    }

    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.BasePebbleListenerService$handleReceiveData$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.client.BasePebbleListenerService", f = "BasePebbleListenerService.kt", l = {123}, m = "handleReceiveData", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BasePebbleListenerService.this.handleReceiveData(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle handleAppClosed(Bundle input, String callingPackage) {
        String string = input.getString("WATCHAPP_UUID");
        UUID uuidFromString = string != null ? UUID.fromString(string) : null;
        if (uuidFromString == null) {
            Logger logger = BasePebbleListenerServiceKt.LOGGER;
            String tag = logger.getTag();
            Severity severity = Severity.Warn;
            if (logger.getConfig().get_minSeverity().compareTo(severity) <= 0) {
                if (callingPackage == null) {
                    callingPackage = "UNKNOWN";
                }
                logger.processLog(severity, tag, null, FileInsert$$ExternalSyntheticOutline0.m("Got a missing watchapp UUID from ", callingPackage, ". Ignoring event..."));
            }
            return new Bundle();
        }
        String string2 = input.getString("WATCH_ID");
        String strM2350constructorimpl = string2 != null ? WatchIdentifier.m2350constructorimpl(string2) : null;
        if (strM2350constructorimpl != null) {
            mo2137onAppClosedkxV8hDc(uuidFromString, strM2350constructorimpl);
            return new Bundle();
        }
        Logger logger2 = BasePebbleListenerServiceKt.LOGGER;
        String tag2 = logger2.getTag();
        Severity severity2 = Severity.Warn;
        if (logger2.getConfig().get_minSeverity().compareTo(severity2) <= 0) {
            if (callingPackage == null) {
                callingPackage = "UNKNOWN";
            }
            logger2.processLog(severity2, tag2, null, FileInsert$$ExternalSyntheticOutline0.m("Got a missing watch ID from ", callingPackage, ". Ignoring event..."));
        }
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle handleAppOpened(Bundle input, String callingPackage) {
        String string = input.getString("WATCHAPP_UUID");
        UUID uuidFromString = string != null ? UUID.fromString(string) : null;
        if (uuidFromString == null) {
            Logger logger = BasePebbleListenerServiceKt.LOGGER;
            String tag = logger.getTag();
            Severity severity = Severity.Warn;
            if (logger.getConfig().get_minSeverity().compareTo(severity) <= 0) {
                if (callingPackage == null) {
                    callingPackage = "UNKNOWN";
                }
                logger.processLog(severity, tag, null, FileInsert$$ExternalSyntheticOutline0.m("Got a missing watchapp UUID from ", callingPackage, ". Ignoring event..."));
            }
            return new Bundle();
        }
        String string2 = input.getString("WATCH_ID");
        String strM2350constructorimpl = string2 != null ? WatchIdentifier.m2350constructorimpl(string2) : null;
        if (strM2350constructorimpl != null) {
            mo2138onAppOpenedkxV8hDc(uuidFromString, strM2350constructorimpl);
            return new Bundle();
        }
        Logger logger2 = BasePebbleListenerServiceKt.LOGGER;
        String tag2 = logger2.getTag();
        Severity severity2 = Severity.Warn;
        if (logger2.getConfig().get_minSeverity().compareTo(severity2) <= 0) {
            if (callingPackage == null) {
                callingPackage = "UNKNOWN";
            }
            logger2.processLog(severity2, tag2, null, FileInsert$$ExternalSyntheticOutline0.m("Got a missing watch ID from ", callingPackage, ". Ignoring event..."));
        }
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleReceiveData(Bundle bundle, String str, Continuation<? super Bundle> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objMo2139onMessageReceivedPjNdOfI = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo2139onMessageReceivedPjNdOfI);
            String string = bundle.getString("WATCHAPP_UUID");
            UUID uuidFromString = string != null ? UUID.fromString(string) : null;
            if (uuidFromString == null) {
                Logger logger = BasePebbleListenerServiceKt.LOGGER;
                String tag = logger.getTag();
                Severity severity = Severity.Warn;
                if (logger.getConfig().get_minSeverity().compareTo(severity) <= 0) {
                    if (str == null) {
                        str = "UNKNOWN";
                    }
                    logger.processLog(severity, tag, null, FileInsert$$ExternalSyntheticOutline0.m("Got a missing watchapp UUID from ", str, ". Ignoring event..."));
                }
                return new Bundle();
            }
            String string2 = bundle.getString("WATCH_ID");
            String strM2350constructorimpl = string2 != null ? WatchIdentifier.m2350constructorimpl(string2) : null;
            if (strM2350constructorimpl == null) {
                Logger logger2 = BasePebbleListenerServiceKt.LOGGER;
                String tag2 = logger2.getTag();
                Severity severity2 = Severity.Warn;
                if (logger2.getConfig().get_minSeverity().compareTo(severity2) <= 0) {
                    if (str == null) {
                        str = "UNKNOWN";
                    }
                    logger2.processLog(severity2, tag2, null, FileInsert$$ExternalSyntheticOutline0.m("Got a missing watch ID from ", str, ". Ignoring event..."));
                }
                return new Bundle();
            }
            Bundle bundle2 = bundle.getBundle("DATA_DICTIONARY");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Map<UInt, ? extends PebbleDictionaryItem> mapMapFromBundle = PebbleDictionarySerializationKt.mapFromBundle(PebbleDictionaryItem.INSTANCE, bundle2);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(bundle);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uuidFromString);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(strM2350constructorimpl);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(bundle2);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(mapMapFromBundle);
            anonymousClass1.label = 1;
            objMo2139onMessageReceivedPjNdOfI = mo2139onMessageReceivedPjNdOfI(uuidFromString, mapMapFromBundle, strM2350constructorimpl, anonymousClass1);
            if (objMo2139onMessageReceivedPjNdOfI == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objMo2139onMessageReceivedPjNdOfI);
        }
        return BundleKt.bundleOf(TuplesKt.to("TRANSMISSION_RESULTS", ReceiveResultSerializationKt.toBundle((ReceiveResult) objMo2139onMessageReceivedPjNdOfI)));
    }

    /* JADX INFO: renamed from: onMessageReceived-PjNdOfI$suspendImpl, reason: not valid java name */
    public static /* synthetic */ Object m2339onMessageReceivedPjNdOfI$suspendImpl(BasePebbleListenerService basePebbleListenerService, UUID uuid, Map<UInt, ? extends PebbleDictionaryItem> map, String str, Continuation<? super ReceiveResult> continuation) {
        return ReceiveResult.Nack.INSTANCE;
    }

    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* JADX INFO: renamed from: onAppClosed-kxV8hDc */
    public abstract void mo2137onAppClosedkxV8hDc(UUID watchappUUID, String watch);

    /* JADX INFO: renamed from: onAppOpened-kxV8hDc */
    public abstract void mo2138onAppOpenedkxV8hDc(UUID watchappUUID, String watch);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Binder().asBinder();
    }

    /* JADX INFO: renamed from: onMessageReceived-PjNdOfI */
    public Object mo2139onMessageReceivedPjNdOfI(UUID uuid, Map<UInt, ? extends PebbleDictionaryItem> map, String str, Continuation<? super ReceiveResult> continuation) {
        return m2339onMessageReceivedPjNdOfI$suspendImpl(this, uuid, map, str, continuation);
    }
}

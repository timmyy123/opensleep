package io.rebble.pebblekit2.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/rebble/pebblekit2/client/DefaultPebbleAndroidAppPicker;", "Lio/rebble/pebblekit2/client/PebbleAndroidAppPicker;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "createOrGetDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "", "getCurrentlySelectedApp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getAllEligibleApps", "()Ljava/util/List;", "Landroid/content/Context;", "", "enableAutoSelect", "Z", "getEnableAutoSelect", "()Z", "setEnableAutoSelect", "(Z)V", "preferences", "Landroidx/datastore/core/DataStore;", "Companion", "client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultPebbleAndroidAppPicker implements PebbleAndroidAppPicker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PebbleAndroidAppPicker instance;
    private final Context context;
    private boolean enableAutoSelect;
    private DataStore<Preferences> preferences;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/rebble/pebblekit2/client/DefaultPebbleAndroidAppPicker$Companion;", "", "<init>", "()V", "instance", "Lio/rebble/pebblekit2/client/PebbleAndroidAppPicker;", "getInstance", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PebbleAndroidAppPicker getInstance(Context context) {
            context.getClass();
            PebbleAndroidAppPicker pebbleAndroidAppPicker = DefaultPebbleAndroidAppPicker.instance;
            if (pebbleAndroidAppPicker != null) {
                return pebbleAndroidAppPicker;
            }
            synchronized (this) {
                PebbleAndroidAppPicker pebbleAndroidAppPicker2 = DefaultPebbleAndroidAppPicker.instance;
                if (pebbleAndroidAppPicker2 != null) {
                    return pebbleAndroidAppPicker2;
                }
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                DefaultPebbleAndroidAppPicker defaultPebbleAndroidAppPicker = new DefaultPebbleAndroidAppPicker(applicationContext, null);
                DefaultPebbleAndroidAppPicker.instance = defaultPebbleAndroidAppPicker;
                return defaultPebbleAndroidAppPicker;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleAndroidAppPicker$getCurrentlySelectedApp$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleAndroidAppPicker", f = "DefaultPebbleAndroidAppPicker.kt", l = {38}, m = "getCurrentlySelectedApp", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultPebbleAndroidAppPicker.this.getCurrentlySelectedApp(this);
        }
    }

    private DefaultPebbleAndroidAppPicker(Context context) {
        this.context = context;
        this.enableAutoSelect = true;
    }

    private final DataStore<Preferences> createOrGetDataStore(Context context) {
        DataStore<Preferences> dataStoreCreate$default;
        DataStore<Preferences> dataStore = this.preferences;
        if (dataStore != null) {
            return dataStore;
        }
        synchronized (this) {
            try {
                dataStoreCreate$default = this.preferences;
                if (dataStoreCreate$default == null) {
                    dataStoreCreate$default = PreferenceDataStoreFactory.create$default(PreferenceDataStoreFactory.INSTANCE, null, null, CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new DefaultPebbleAndroidAppPicker$$ExternalSyntheticLambda0(context, 0), 3, null);
                }
                this.preferences = dataStoreCreate$default;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStoreCreate$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File createOrGetDataStore$lambda$1$0(Context context) {
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, "pebblekit_android_app_picker");
    }

    public List<String> getAllEligibleApps() {
        List<ResolveInfo> listQueryIntentServices = this.context.getPackageManager().queryIntentServices(new Intent("io.rebble.pebblekit2.SEND_DATA_TO_WATCH"), 0);
        listQueryIntentServices.getClass();
        List<ResolveInfo> list = listQueryIntentServices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).serviceInfo.packageName);
        }
        return CollectionsKt.distinct(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.rebble.pebblekit2.client.PebbleAndroidAppPicker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getCurrentlySelectedApp(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        List<String> list;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<String> allEligibleApps = getAllEligibleApps();
            if (allEligibleApps.isEmpty()) {
                return null;
            }
            Flow<Preferences> data2 = createOrGetDataStore(this.context).getData();
            anonymousClass1.L$0 = allEligibleApps;
            anonymousClass1.label = 1;
            Object objFirst = FlowKt.first(data2, anonymousClass1);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = allEligibleApps;
            obj = objFirst;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list = (List) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Object obj2 = ((Preferences) obj).get(DefaultPebbleAndroidAppPickerKt.SELECTED_APP_KEY);
        String str = (String) (CollectionsKt.contains(list, (String) obj2) ? obj2 : null);
        return (str == null && getEnableAutoSelect()) ? (String) CollectionsKt.first((List) list) : str;
    }

    public boolean getEnableAutoSelect() {
        return this.enableAutoSelect;
    }

    public /* synthetic */ DefaultPebbleAndroidAppPicker(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }
}

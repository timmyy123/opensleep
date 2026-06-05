package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.health.connect.client.PermissionController;
import androidx.view.result.ActivityResultLauncher;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.api.Status;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.string.Joiner;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionPermission;
import com.urbandroid.sleep.async.IHasProgressContext;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.media.spotify.SpotifyManager;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarChangeReceiver;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarSyncJobService;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.google.fit.GoogleFitAuthorizationActivity;
import com.urbandroid.sleep.service.google.fit.GoogleFitSyncJobService;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncJobService;
import com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthAuthorizationActivity;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSyncJobService;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010!\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J)\u0010&\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0014¢\u0006\u0004\b(\u0010\u0006J\u001f\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u00198\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001bR\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010AR#\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190C0B8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020H8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/ServicesSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/async/IHasProgressContext;", "<init>", "()V", "", "getSettings", "()I", "getTitleResource", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/urbandroid/sleep/async/ProgressContext;", "getProgressContext", "()Lcom/urbandroid/sleep/async/ProgressContext;", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "preferenceActivity", "", "searchMode", "refresh", "(Lcom/urbandroid/sleep/gui/PreferenceActivity;Z)V", "", "getDocumentationUrl", "()Ljava/lang/String;", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "Lcom/urbandroid/sleep/service/Settings;", "settings", "refreshSyncNow", "(Lcom/urbandroid/sleep/service/Settings;Lcom/urbandroid/sleep/gui/PreferenceActivity;)V", "tag", "Ljava/lang/String;", "getTag", "Landroid/preference/Preference;", "syncPreference", "Landroid/preference/Preference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "spotifyAuthenticateFinished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroid/preference/CheckBoxPreference;", "healthConnectPref", "Landroid/preference/CheckBoxPreference;", "getHealthConnectPref", "()Landroid/preference/CheckBoxPreference;", "setHealthConnectPref", "(Landroid/preference/CheckBoxPreference;)V", "progressContextInstance", "Lcom/urbandroid/sleep/async/ProgressContext;", "getProgressContextInstance", "setProgressContextInstance", "(Lcom/urbandroid/sleep/async/ProgressContext;)V", "Landroidx/activity/result/ActivityResultLauncher;", "", "requestPermissions", "Landroidx/activity/result/ActivityResultLauncher;", "getRequestPermissions", "()Landroidx/activity/result/ActivityResultLauncher;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "SyncableServices", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServicesSettingsActivity extends SimpleSettingsActivity implements CoroutineScope, FeatureLogger, IHasProgressContext {
    private CheckBoxPreference healthConnectPref;
    private ProgressContext progressContextInstance;
    private Preference syncPreference;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final String tag = "services-settings";
    private final AtomicBoolean spotifyAuthenticateFinished = new AtomicBoolean(false);
    private final ActivityResultLauncher<Set<String>> requestPermissions = registerForActivityResult(PermissionController.Companion.createRequestPermissionResultContract$default(PermissionController.INSTANCE, null, 1, null), new ServicesSettingsActivity$$ExternalSyntheticLambda10(this));

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\u0016R\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\u0016¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/ServicesSettingsActivity$SyncableServices;", "", "Lcom/urbandroid/sleep/service/Settings;", "settings", "<init>", "(Lcom/urbandroid/sleep/service/Settings;)V", "", "reevaluate", "()V", "", "anyEnabled", "()Z", "", "enabledToString", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/service/Settings;", "getSettings", "()Lcom/urbandroid/sleep/service/Settings;", "fit", "Z", "getFit", "setFit", "(Z)V", "healthConnect", "getHealthConnect", "setHealthConnect", "sHealth", "getSHealth", "setSHealth", "calendar", "getCalendar", "setCalendar", "sleepcloud", "getSleepcloud", "setSleepcloud", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SyncableServices {
        private boolean calendar;
        private boolean fit;
        private boolean healthConnect;
        private boolean sHealth;
        private final Settings settings;
        private boolean sleepcloud;

        public SyncableServices(Settings settings) {
            settings.getClass();
            this.settings = settings;
            reevaluate();
        }

        private final void reevaluate() {
            this.fit = this.settings.isGoogleFit();
            this.healthConnect = this.settings.isHealthConnect();
            this.sHealth = this.settings.isSamsungSHealth();
            this.calendar = this.settings.isGoogleCalendar() && this.settings.isGoogleCalendarSync();
            TrialFilter.getInstance().reevaluate();
            this.sleepcloud = TrialFilter.getInstance().isAddonImport();
            Settings settings = this.settings;
            Achievement.Type type = Achievement.Type.CLOUD;
            Boolean[] boolArr = {Boolean.valueOf(this.fit), Boolean.valueOf(this.healthConnect), Boolean.valueOf(this.sHealth), Boolean.valueOf(this.calendar), Boolean.valueOf(this.sleepcloud)};
            ArrayList arrayList = new ArrayList(5);
            for (int i = 0; i < 5; i++) {
                arrayList.add(Integer.valueOf(boolArr[i].booleanValue() ? 1 : 0));
            }
            settings.setAchievement(type, (this.settings.isGoogleCalendar() ? 1 : 0) + (this.settings.isTasker() ? 1 : 0) + (this.settings.isSpotify() ? 1 : 0) + CollectionsKt___CollectionsKt.sumOfInt(arrayList));
        }

        public final boolean anyEnabled() {
            reevaluate();
            return this.fit || this.healthConnect || this.sHealth || this.calendar || this.sleepcloud;
        }

        public final String enabledToString() {
            reevaluate();
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            if (this.fit) {
                Context context = SharedApplicationContext.getInstance().getContext();
                context.getClass();
                String string = context.getString(R.string.google_fit);
                string.getClass();
                listCreateListBuilder.add(string);
            }
            if (this.healthConnect) {
                Context context2 = SharedApplicationContext.getInstance().getContext();
                context2.getClass();
                String string2 = context2.getString(R.string.health_connect);
                string2.getClass();
                listCreateListBuilder.add(string2);
            }
            if (this.sHealth) {
                Context context3 = SharedApplicationContext.getInstance().getContext();
                context3.getClass();
                String string3 = context3.getString(R.string.samsung_shealth);
                string3.getClass();
                listCreateListBuilder.add(string3);
            }
            if (this.calendar) {
                Context context4 = SharedApplicationContext.getInstance().getContext();
                context4.getClass();
                String string4 = context4.getString(R.string.google_calendar);
                string4.getClass();
                listCreateListBuilder.add(string4);
            }
            if (this.sleepcloud) {
                Context context5 = SharedApplicationContext.getInstance().getContext();
                context5.getClass();
                String string5 = context5.getString(R.string.addons_backup_title);
                string5.getClass();
                listCreateListBuilder.add(string5);
            }
            String strJoin = Joiner.on(", ").join(CollectionsKt.build(listCreateListBuilder));
            strJoin.getClass();
            return strJoin;
        }

        public final boolean getCalendar() {
            return this.calendar;
        }

        public final boolean getFit() {
            return this.fit;
        }

        public final boolean getHealthConnect() {
            return this.healthConnect;
        }

        public final boolean getSHealth() {
            return this.sHealth;
        }

        public final boolean getSleepcloud() {
            return this.sleepcloud;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$onActivityResult$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$onActivityResult$2", f = "ServicesSettingsActivity.kt", l = {608}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ServicesSettingsActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CachedCalendarProviderApi.Companion companion = CachedCalendarProviderApi.INSTANCE;
                Context applicationContext = ServicesSettingsActivity.this.getApplicationContext();
                applicationContext.getClass();
                this.label = 1;
                if (companion.clean(applicationContext, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$onActivityResult$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$onActivityResult$3", f = "ServicesSettingsActivity.kt", l = {618}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CalendarProviderApi $api;
        final /* synthetic */ Settings $settings;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CalendarProviderApi calendarProviderApi, Settings settings, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$api = calendarProviderApi;
            this.$settings = settings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ServicesSettingsActivity.this.new AnonymousClass3(this.$api, this.$settings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicesSettingsActivity servicesSettingsActivity = ServicesSettingsActivity.this;
                    Logger.logWarning(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: show consent", null);
                    CalendarProviderApi calendarProviderApi = this.$api;
                    this.label = 1;
                    obj = ServicesSettingsActivity.onActivityResult$showConsentScreenIfNeeded(calendarProviderApi, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (GoogleJsonResponseException e) {
                ServicesSettingsActivity servicesSettingsActivity2 = ServicesSettingsActivity.this;
                Logger.logWarning(Logger.defaultTag, servicesSettingsActivity2.getTag() + ": failure getting calendars", e);
            }
            if (((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            ServicesSettingsActivity servicesSettingsActivity3 = ServicesSettingsActivity.this;
            Logger.logWarning(Logger.defaultTag, servicesSettingsActivity3.getTag() + ": Google Calendar: launch settings", null);
            ServicesSettingsActivity.onActivityResult$showGoogleCalendarSettings(ServicesSettingsActivity.this, this.$settings);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object onActivityResult$showConsentScreenIfNeeded(CalendarProviderApi calendarProviderApi, Continuation<? super Boolean> continuation) {
        ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1 servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1;
        if (continuation instanceof ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1) {
            servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1 = (ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1) continuation;
            int i = servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1.label = i - Integer.MIN_VALUE;
            } else {
                servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1 = new ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1(continuation);
            }
        }
        Object primaryCalendar = servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(primaryCalendar);
            servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1.L$0 = SpillingKt.nullOutSpilledVariable(calendarProviderApi);
            servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1.label = 1;
            primaryCalendar = calendarProviderApi.getPrimaryCalendar(servicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1);
            if (primaryCalendar == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(primaryCalendar);
        }
        return Boxing.boxBoolean(primaryCalendar == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$showGoogleCalendarSettings(ServicesSettingsActivity servicesSettingsActivity, Settings settings) {
        Logger.logWarning(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: showSettings", null);
        settings.setGoogleCalendar(true);
        GoogleCalendarChangeReceiver.Companion companion = GoogleCalendarChangeReceiver.INSTANCE;
        Context applicationContext = servicesSettingsActivity.getApplicationContext();
        applicationContext.getClass();
        companion.setEnabled(applicationContext, true);
        servicesSettingsActivity.startActivity(new Intent(servicesSettingsActivity.getApplicationContext(), (Class<?>) GoogleCalendarSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(ServicesSettingsActivity servicesSettingsActivity, Preference preference) {
        ViewIntent.url(servicesSettingsActivity, "https://sleep.urbandroid.org/docs//services/0parent.html");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1(ServicesSettingsActivity servicesSettingsActivity, Preference preference) {
        servicesSettingsActivity.startActivity(new Intent(servicesSettingsActivity, (Class<?>) GoogleHomeAutomationSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) AutomationSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$3(ServicesSettingsActivity servicesSettingsActivity, Preference preference) {
        BackupItemDialogFragment.INSTANCE.newInstance().show(servicesSettingsActivity.getSupportFragmentManager(), "backup");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$4(Context context, PreferenceActivity preferenceActivity, Settings settings, ServicesSettingsActivity servicesSettingsActivity, Preference preference, Object obj) {
        Logger.logInfo("HealthConnect: prefChange " + obj);
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            Logger.logInfo("HealthConnect: revoke all");
            try {
                new HealthConnectApi(context).revokeAllPermissions();
                return true;
            } catch (Exception e) {
                Logger.logSevere(e);
                return true;
            }
        }
        HealthConnectApi.Companion companion = HealthConnectApi.INSTANCE;
        if (!companion.isAvailable(context)) {
            Logger.logInfo("HealthConnect: no Api starting Play Store");
            ViewIntent.market(preferenceActivity, "com.google.android.apps.healthdata");
            return false;
        }
        Logger.logInfo("HealthConnect: prefChange avail");
        Set<String> requiredHealthConnectPermission = companion.getRequiredHealthConnectPermission();
        if (requiredHealthConnectPermission == null || !requiredHealthConnectPermission.isEmpty()) {
            Iterator<T> it = requiredHealthConnectPermission.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (ContextCompat.checkSelfPermission(context, (String) it.next()) != 0) {
                    if (Build.VERSION.SDK_INT > 33) {
                        Logger.logInfo("HealthConnect: ask for permissions");
                        servicesSettingsActivity.requestPermissions.launch(HealthConnectApi.INSTANCE.getHealthConnectAllPermissions());
                        return true;
                    }
                }
            }
        }
        Logger.logInfo("HealthConnect: required granted");
        try {
            preferenceActivity.startActivity(new Intent(context, (Class<?>) HealthConnectSyncActivity.class));
        } catch (Exception e2) {
            Logger.logSevere(e2);
        }
        settings.setHealthConnect(false);
        CheckBoxPreference checkBoxPreference = servicesSettingsActivity.healthConnectPref;
        if (checkBoxPreference == null) {
            return true;
        }
        checkBoxPreference.setChecked(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$5$0(ServicesSettingsActivity servicesSettingsActivity, Settings settings, Context context, CheckBoxPreference checkBoxPreference, PreferenceActivity preferenceActivity, CheckBoxPreference checkBoxPreference2, Preference preference, Object obj) {
        String str = "FIT: Setting Checked " + settings.isGoogleFit() + " new value: " + obj;
        Logger.logInfo(Logger.defaultTag, servicesSettingsActivity.getTag() + ": " + str, null);
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            checkBoxPreference.setSummary("");
            settings.setGoogleFit(false);
            settings.setGoogleFitRecordCount(0);
            new GoogleFitApiFactory().disconnectAppFromFit(context, new ServicesSettingsActivity$$ExternalSyntheticLambda10(servicesSettingsActivity));
            servicesSettingsActivity.refreshSyncNow(settings, preferenceActivity);
            return true;
        }
        Context applicationContext = servicesSettingsActivity.getApplicationContext();
        applicationContext.getClass();
        if (!ContextExtKt.hasConnectivity(applicationContext)) {
            String string = servicesSettingsActivity.getResources().getString(R.string.share_disconnected, "Internet");
            string.getClass();
            Toast.makeText(servicesSettingsActivity, string, 1).show();
            return false;
        }
        if (!ActivityRecognitionPermission.Companion.request$default(ActivityRecognitionPermission.INSTANCE, servicesSettingsActivity, 0, 2, null)) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
            TextView textView = new TextView(context);
            ScrollView scrollView = new ScrollView(context);
            int dip = ActivityUtils.getDip(context, 20);
            scrollView.setPadding(dip, dip, dip, dip);
            scrollView.addView(textView);
            textView.setText(R.string.privacy_policy_fit);
            materialAlertDialogBuilder.setView((View) scrollView);
            materialAlertDialogBuilder.setTitle(R.string.privacy);
            materialAlertDialogBuilder.setPositiveButton(R.string.agree, (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(preferenceActivity, context, 4));
            materialAlertDialogBuilder.setNeutralButton(servicesSettingsActivity.getResources().getText(R.string.button_cancel), (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(checkBoxPreference2, 6));
            materialAlertDialogBuilder.show();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$5$0$0(PreferenceActivity preferenceActivity, Context context, DialogInterface dialogInterface, int i) {
        preferenceActivity.startActivity(new Intent(context, (Class<?>) GoogleFitAuthorizationActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$5$0$3(ServicesSettingsActivity servicesSettingsActivity, Status status) {
        String strM = Fragment$$ExternalSyntheticOutline1.m("Google Fit - disconnected app from fit: ", status != null ? Boolean.valueOf(status.isSuccess()) : "null");
        Logger.logInfo(Logger.defaultTag, servicesSettingsActivity.getTag() + ": " + strM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$6(ServicesSettingsActivity servicesSettingsActivity, Preference preference) {
        DocItemDialogFragment.INSTANCE.newInstance("menu", servicesSettingsActivity.getString(R.string.support), null).show(servicesSettingsActivity.getSupportFragmentManager(), "help");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$7(ServicesSettingsActivity servicesSettingsActivity, Settings settings, PreferenceActivity preferenceActivity, Context context, Preference preference, Object obj) {
        String str = "SHEALTH Preference Preference: Setting Checked " + settings.isSamsungSHealth() + " new value: " + obj;
        Logger.logInfo(Logger.defaultTag, servicesSettingsActivity.getTag() + ": " + str, null);
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            preferenceActivity.startActivity(new Intent(context, (Class<?>) SamsungSHealthAuthorizationActivity.class));
            return true;
        }
        servicesSettingsActivity.refreshSyncNow(settings, preferenceActivity);
        settings.setSamsungSHealth(false);
        servicesSettingsActivity.refreshSyncNow(settings, preferenceActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$8$0(ServicesSettingsActivity servicesSettingsActivity, Settings settings, Context context, PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        String str = "Google Calendar Preference change : " + settings.isGoogleCalendar() + " new value " + obj;
        Logger.logInfo(Logger.defaultTag, servicesSettingsActivity.getTag() + ": " + str, null);
        if (!ContextExtKt.hasConnectivity(servicesSettingsActivity)) {
            Logger.logWarning(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: no connectivity", null);
            String string = servicesSettingsActivity.getResources().getString(R.string.share_disconnected, "Internet");
            string.getClass();
            Toast.makeText(servicesSettingsActivity, string, 1).show();
            return false;
        }
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            Intent intentNewChooseAccountIntent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"}, false, null, null, null, null);
            intentNewChooseAccountIntent.getClass();
            servicesSettingsActivity.startActivityForResult(intentNewChooseAccountIntent, 1);
            Logger.logWarning(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: start account picker", null);
            return true;
        }
        GoogleCalendarChangeReceiver.INSTANCE.setEnabled(context, false);
        settings.setGoogleCalendar(false);
        servicesSettingsActivity.refreshSyncNow(settings, preferenceActivity);
        settings.setGoogleCalendarAccountPrevious(settings.getGoogleCalendarAccount());
        settings.setGoogleCalendarAccount(null);
        Logger.logSevere(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: reset", null);
        BuildersKt__Builders_commonKt.launch$default(servicesSettingsActivity, null, null, new ServicesSettingsActivity$refresh$9$1$1(context, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$9$0(Context context, CheckBoxPreference checkBoxPreference, PreferenceActivity preferenceActivity, ServicesSettingsActivity servicesSettingsActivity, Settings settings, Preference preference, Object obj) {
        obj.getClass();
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = 1;
        if (zBooleanValue && !TrialFilter.getInstance().isSpotify()) {
            ViewIntent.market(context, "com.spotify.music");
        } else if (zBooleanValue) {
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            if (((ConnectivityManager) systemService).getActiveNetworkInfo() == null) {
                checkBoxPreference.setChecked(false);
                Toast.makeText(preferenceActivity, R.string.no_connection, 0).show();
                return false;
            }
            servicesSettingsActivity.spotifyAuthenticateFinished.set(false);
            SpotifyManager.from(preferenceActivity).authenticate();
            new Handler().postDelayed(new StartTrackActivity$$ExternalSyntheticLambda0(servicesSettingsActivity, checkBoxPreference, i), 30000L);
            return false;
        }
        settings.setSpotify(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$9$0$0(ServicesSettingsActivity servicesSettingsActivity, CheckBoxPreference checkBoxPreference) {
        if (servicesSettingsActivity.spotifyAuthenticateFinished.get()) {
            return;
        }
        try {
            checkBoxPreference.setChecked(false);
        } catch (Exception unused) {
        }
    }

    private final void refreshSyncNow(Settings settings, PreferenceActivity preferenceActivity) {
        Preference preferenceFindPreference;
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        if (this.syncPreference == null) {
            Preference preferenceFindPreference2 = preferenceScreen != null ? preferenceScreen.findPreference("services_sync_now") : null;
            this.syncPreference = preferenceFindPreference2;
            if (preferenceFindPreference2 != null) {
                preferenceFindPreference2.setOnPreferenceClickListener(new ServicesSettingsActivity$$ExternalSyntheticLambda11(settings, preferenceActivity, this, 0));
            }
        }
        SyncableServices syncableServices = new SyncableServices(settings);
        String strM = FileInsert$$ExternalSyntheticOutline0.m("syncable services ", syncableServices.enabledToString());
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        boolean zAnyEnabled = syncableServices.anyEnabled();
        Preference preference = this.syncPreference;
        if (!zAnyEnabled) {
            if (preference != null) {
                preferenceFindPreference = preferenceScreen != null ? preferenceScreen.findPreference("settings_category_services") : null;
                preferenceFindPreference.getClass();
                ((PreferenceGroup) preferenceFindPreference).removePreference(this.syncPreference);
                return;
            }
            return;
        }
        if (preference != null && findPreference("services_sync_now") == null) {
            preferenceFindPreference = preferenceScreen != null ? preferenceScreen.findPreference("settings_category_services") : null;
            preferenceFindPreference.getClass();
            ((PreferenceGroup) preferenceFindPreference).addPreference(this.syncPreference);
        }
        Preference preference2 = this.syncPreference;
        if (preference2 != null) {
            preference2.setSummary(syncableServices.enabledToString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refreshSyncNow$lambda$0(Settings settings, PreferenceActivity preferenceActivity, ServicesSettingsActivity servicesSettingsActivity, Preference preference) {
        PreferenceActivity preferenceActivity2;
        SyncableServices syncableServices = new SyncableServices(settings);
        Logger.logInfo("Sync now started. fit: " + syncableServices.getFit() + ", calendar: " + syncableServices.getCalendar() + ", sHealth: " + syncableServices.getSHealth() + ", healthConnnect: " + syncableServices.getHealthConnect() + ", sleepcloud: " + syncableServices.getSleepcloud());
        if (!syncableServices.anyEnabled()) {
            return true;
        }
        Toast.makeText(preferenceActivity, R.string.in_progress, 0).show();
        if (!syncableServices.getFit() || ActivityRecognitionPermission.INSTANCE.request(servicesSettingsActivity, 230)) {
            preferenceActivity2 = preferenceActivity;
        } else {
            preferenceActivity2 = preferenceActivity;
            GoogleFitSyncJobService.Companion.start$default(GoogleFitSyncJobService.INSTANCE, preferenceActivity2, true, false, 4, null);
        }
        if (syncableServices.getCalendar()) {
            GoogleCalendarSyncJobService.INSTANCE.start(preferenceActivity2);
        }
        if (syncableServices.getSHealth()) {
            SamsungSHealthSyncJobService.Companion.start$default(SamsungSHealthSyncJobService.INSTANCE, preferenceActivity2, false, 2, null);
        }
        if (syncableServices.getHealthConnect()) {
            HealthConnectSyncJobService.Companion.start$default(HealthConnectSyncJobService.INSTANCE, preferenceActivity2, false, 2, null);
        }
        if (syncableServices.getSleepcloud()) {
            BackupItemDialogFragment.INSTANCE.startUploadToCloud(servicesSettingsActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissions$lambda$0(ServicesSettingsActivity servicesSettingsActivity, Set set) {
        set.getClass();
        Logger.logInfo("HealthConnect: after grant");
        servicesSettingsActivity.startActivity(new Intent(servicesSettingsActivity, (Class<?>) HealthConnectSyncActivity.class));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//services/0parent.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.async.IHasProgressContext
    /* JADX INFO: renamed from: getProgressContext, reason: from getter */
    public ProgressContext getProgressContextInstance() {
        return this.progressContextInstance;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_service;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.category_services;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);
        String strM = Fragment$$ExternalSyntheticOutline1.m(requestCode, resultCode, "Google Calendar: onActivityResult ", " ");
        Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, null);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        final Settings settings = ContextExtKt.getSettings(applicationContext);
        if (requestCode == 1003) {
            if (resultCode == -1) {
                onActivityResult$showGoogleCalendarSettings(this, settings);
                return;
            }
            settings.setGoogleCalendar(false);
            settings.setGoogleCalendarAccount(null);
            refresh();
            return;
        }
        if (requestCode != 1) {
            if (requestCode == 229) {
                return;
            }
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("spotify");
            if (requestCode != 1337 || checkBoxPreference == null) {
                return;
            }
            SpotifyManager.from(this).onAuthenticateResult(requestCode, resultCode, data2, new SpotifyManager.ResultListener() { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity.onActivityResult.4
                @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
                public void fail(int reason) {
                    zza$$ExternalSyntheticOutline0.m(reason, "Spotify: fail ");
                    ServicesSettingsActivity.this.spotifyAuthenticateFinished.set(true);
                    checkBoxPreference.setChecked(false);
                }

                @Override // com.urbandroid.sleep.media.spotify.SpotifyManager.ResultListener
                public void success(String accessToken) {
                    accessToken.getClass();
                    ServicesSettingsActivity.this.spotifyAuthenticateFinished.set(true);
                    SpotifyApi spotifyApi = new SpotifyApi();
                    spotifyApi.setAccessToken(accessToken);
                    SpotifyService service = spotifyApi.getService();
                    service.getClass();
                    SpotifyServiceExecutor spotifyServiceExecutor = new SpotifyServiceExecutor(service);
                    spotifyServiceExecutor.getUser(new ServicesSettingsActivity$onActivityResult$4$success$1(ServicesSettingsActivity.this, checkBoxPreference, settings, spotifyServiceExecutor));
                }
            });
            return;
        }
        Logger.logWarning(Logger.defaultTag, getTag() + ": Google Calendar: onActivityResult isRequestAccount", null);
        if (resultCode != -1 || data2 == null) {
            return;
        }
        String stringExtra = data2.getStringExtra("authAccount");
        if (stringExtra == null) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": Google Calendar: no account name found in data intent", null);
            return;
        }
        String googleCalendarAccountPrevious = settings.getGoogleCalendarAccountPrevious();
        settings.setGoogleCalendarAccount(stringExtra);
        String strConcat = "Google Calendar: onActivityResult account ".concat(stringExtra);
        Logger.logWarning(Logger.defaultTag, getTag() + ": " + strConcat, null);
        if (googleCalendarAccountPrevious == null || !Intrinsics.areEqual(stringExtra, googleCalendarAccountPrevious)) {
            settings.setGoogleCalendarAccount(stringExtra);
            settings.setGoogleCalendarAccountPrevious(stringExtra);
            Logger.logWarning(Logger.defaultTag, getTag() + ": Google Calendar: reset options", null);
            settings.resetGoogleCalendarOptions();
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass2(null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass3(new CalendarProviderApi(this, stringExtra), settings, null), 3, null);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        if (ContextExtKt.getSettings(applicationContext).isGoogleFit()) {
            ActivityRecognitionPermission.INSTANCE.request(this, 231);
        }
        this.progressContextInstance = new ProgressContext(this);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        ServicesSettingsActivity servicesSettingsActivity;
        permissions.getClass();
        grantResults.getClass();
        if (permissions.length == 0) {
            return;
        }
        String str = permissions[0];
        String str2 = "Permissions: activity recognition: " + str + " grantResult: " + grantResults[0];
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
        switch (requestCode) {
            case 229:
                servicesSettingsActivity = this;
                if (grantResults[0] != 0) {
                    SharedApplicationContext.getSettings().setGoogleFit(false);
                    Preference preferenceFindPreference = servicesSettingsActivity.findPreference("google_fit");
                    if (preferenceFindPreference != null) {
                        ((CheckBoxPreference) preferenceFindPreference).setChecked(false);
                    }
                    ViewIntent.getPermissionDenyDialogBuilder(servicesSettingsActivity, str, R.string.google_fit).show();
                } else {
                    servicesSettingsActivity.startActivity(new Intent(servicesSettingsActivity, (Class<?>) GoogleFitAuthorizationActivity.class));
                }
                break;
            case 230:
                if (grantResults[0] != 0) {
                    servicesSettingsActivity = this;
                    ViewIntent.getPermissionDenyDialogBuilder(servicesSettingsActivity, str, R.string.google_fit).show();
                } else {
                    servicesSettingsActivity = this;
                    GoogleFitSyncJobService.Companion.start$default(GoogleFitSyncJobService.INSTANCE, servicesSettingsActivity, true, false, 4, null);
                    SharedApplicationContext.getSettings().setPairTracking(true);
                    Preference preferenceFindPreference2 = servicesSettingsActivity.findPreference("pair_tracking_enabled");
                    if (preferenceFindPreference2 != null) {
                        ((CheckBoxPreference) preferenceFindPreference2).setChecked(true);
                    }
                }
                break;
            case 231:
                if (grantResults[0] == -1) {
                    SharedApplicationContext.getSettings().setGoogleFit(false);
                    Preference preferenceFindPreference3 = findPreference("google_fit");
                    if (preferenceFindPreference3 != null) {
                        ((CheckBoxPreference) preferenceFindPreference3).setChecked(false);
                    }
                    break;
                }
            default:
                servicesSettingsActivity = this;
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean searchMode) {
        Preference preferenceFindPreference;
        Preference preferenceFindPreference2;
        CheckBoxPreference checkBoxPreference;
        final CheckBoxPreference checkBoxPreference2;
        final ServicesSettingsActivity servicesSettingsActivity;
        final PreferenceActivity preferenceActivity2;
        Preference preferenceFindPreference3;
        CheckBoxPreference checkBoxPreference3;
        CheckBoxPreference checkBoxPreference4;
        PreferenceGroup preferenceGroup;
        int googleCalendarRecordCount;
        int samsungSHealthRecordCount;
        int googleFitRecordCount;
        CheckBoxPreference checkBoxPreference5;
        PreferenceGroup preferenceGroup2;
        Preference preferenceFindPreference4;
        Preference preferenceFindPreference5;
        preferenceActivity.getClass();
        super.refresh(preferenceActivity, searchMode);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        final int i = 0;
        if (preferenceScreen != null && (preferenceFindPreference5 = preferenceScreen.findPreference("services_expl")) != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ ServicesSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i2 = i;
                    ServicesSettingsActivity servicesSettingsActivity2 = this.f$0;
                    switch (i2) {
                        case 0:
                            return ServicesSettingsActivity.refresh$lambda$0(servicesSettingsActivity2, preference);
                        case 1:
                            return ServicesSettingsActivity.refresh$lambda$1(servicesSettingsActivity2, preference);
                        case 2:
                            return ServicesSettingsActivity.refresh$lambda$3(servicesSettingsActivity2, preference);
                        default:
                            return ServicesSettingsActivity.refresh$lambda$6(servicesSettingsActivity2, preference);
                    }
                }
            });
        }
        PreferenceScreen preferenceScreen2 = getPreferenceScreen();
        if (preferenceScreen2 != null && (preferenceFindPreference4 = preferenceScreen2.findPreference("settings_google_home_automation")) != null) {
            final int i2 = 1;
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ ServicesSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i2;
                    ServicesSettingsActivity servicesSettingsActivity2 = this.f$0;
                    switch (i22) {
                        case 0:
                            return ServicesSettingsActivity.refresh$lambda$0(servicesSettingsActivity2, preference);
                        case 1:
                            return ServicesSettingsActivity.refresh$lambda$1(servicesSettingsActivity2, preference);
                        case 2:
                            return ServicesSettingsActivity.refresh$lambda$3(servicesSettingsActivity2, preference);
                        default:
                            return ServicesSettingsActivity.refresh$lambda$6(servicesSettingsActivity2, preference);
                    }
                }
            });
        }
        PreferenceScreen preferenceScreen3 = preferenceActivity.getPreferenceScreen();
        final Settings settings = ContextExtKt.getSettings(preferenceActivity);
        if (preferenceScreen3 == null || (preferenceFindPreference = preferenceScreen3.findPreference("settings_category_automation")) == null) {
            preferenceFindPreference = null;
        }
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 16));
        }
        if (preferenceScreen3 == null || (preferenceFindPreference2 = preferenceScreen3.findPreference("settings_category_backup_local")) == null) {
            preferenceFindPreference2 = null;
        }
        if (preferenceFindPreference2 != null) {
            final int i3 = 2;
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ ServicesSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i3;
                    ServicesSettingsActivity servicesSettingsActivity2 = this.f$0;
                    switch (i22) {
                        case 0:
                            return ServicesSettingsActivity.refresh$lambda$0(servicesSettingsActivity2, preference);
                        case 1:
                            return ServicesSettingsActivity.refresh$lambda$1(servicesSettingsActivity2, preference);
                        case 2:
                            return ServicesSettingsActivity.refresh$lambda$3(servicesSettingsActivity2, preference);
                        default:
                            return ServicesSettingsActivity.refresh$lambda$6(servicesSettingsActivity2, preference);
                    }
                }
            });
        }
        if (preferenceScreen3 == null) {
            checkBoxPreference = null;
        } else {
            Preference preferenceFindPreference6 = preferenceScreen3.findPreference("health_connect");
            if (!(preferenceFindPreference6 instanceof CheckBoxPreference)) {
                preferenceFindPreference6 = null;
            }
            checkBoxPreference = (CheckBoxPreference) preferenceFindPreference6;
        }
        this.healthConnectPref = checkBoxPreference;
        if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(settings.isHealthConnect());
        }
        if (this.healthConnectPref != null && Build.VERSION.SDK_INT < 28) {
            if (preferenceScreen3 == null) {
                preferenceGroup2 = null;
            } else {
                Preference preferenceFindPreference7 = preferenceScreen3.findPreference("settings_category_services");
                if (!(preferenceFindPreference7 instanceof PreferenceGroup)) {
                    preferenceFindPreference7 = null;
                }
                preferenceGroup2 = (PreferenceGroup) preferenceFindPreference7;
            }
            if (preferenceGroup2 != null) {
                preferenceGroup2.removePreference(this.healthConnectPref);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (checkBoxPreference5 = this.healthConnectPref) != null) {
            checkBoxPreference5.setOnPreferenceChangeListener(new ServicesSettingsActivity$$ExternalSyntheticLambda4(preferenceActivity, preferenceActivity, settings, this));
        }
        if (preferenceScreen3 == null) {
            checkBoxPreference2 = null;
        } else {
            Preference preferenceFindPreference8 = preferenceScreen3.findPreference("google_fit");
            if (!(preferenceFindPreference8 instanceof CheckBoxPreference)) {
                preferenceFindPreference8 = null;
            }
            checkBoxPreference2 = (CheckBoxPreference) preferenceFindPreference8;
        }
        if (checkBoxPreference2 != null && settings.isGoogleFit() && (googleFitRecordCount = settings.getGoogleFitRecordCount()) >= 0) {
            checkBoxPreference2.setSummary(preferenceActivity.getString(R.string.displaying_records_count, Integer.valueOf(googleFitRecordCount)));
        }
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setChecked(settings.isGoogleFit());
            checkBoxPreference2.setTitle(preferenceActivity.getString(R.string.google_fit));
            final CheckBoxPreference checkBoxPreference6 = checkBoxPreference2;
            servicesSettingsActivity = this;
            preferenceActivity2 = preferenceActivity;
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda5
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return ServicesSettingsActivity.refresh$lambda$5$0(this.f$0, settings, preferenceActivity2, checkBoxPreference2, preferenceActivity, checkBoxPreference6, preference, obj);
                }
            });
        } else {
            servicesSettingsActivity = this;
            preferenceActivity2 = preferenceActivity;
        }
        if (preferenceScreen3 == null || (preferenceFindPreference3 = preferenceScreen3.findPreference("settings_category_support")) == null) {
            preferenceFindPreference3 = null;
        }
        if (preferenceFindPreference3 != null) {
            StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(servicesSettingsActivity.getString(R.string.send_on_demand_error), ". ", servicesSettingsActivity.getString(R.string.forum), ". ", servicesSettingsActivity.getString(R.string.faq));
            sbM66m.append("...");
            preferenceFindPreference3.setSummary(sbM66m.toString());
            final int i4 = 3;
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(servicesSettingsActivity) { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ ServicesSettingsActivity f$0;

                {
                    this.f$0 = servicesSettingsActivity;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i4;
                    ServicesSettingsActivity servicesSettingsActivity2 = this.f$0;
                    switch (i22) {
                        case 0:
                            return ServicesSettingsActivity.refresh$lambda$0(servicesSettingsActivity2, preference);
                        case 1:
                            return ServicesSettingsActivity.refresh$lambda$1(servicesSettingsActivity2, preference);
                        case 2:
                            return ServicesSettingsActivity.refresh$lambda$3(servicesSettingsActivity2, preference);
                        default:
                            return ServicesSettingsActivity.refresh$lambda$6(servicesSettingsActivity2, preference);
                    }
                }
            });
        }
        if (preferenceScreen3 == null) {
            checkBoxPreference3 = null;
        } else {
            Preference preferenceFindPreference9 = preferenceScreen3.findPreference("samsung_shealth");
            if (!(preferenceFindPreference9 instanceof CheckBoxPreference)) {
                preferenceFindPreference9 = null;
            }
            checkBoxPreference3 = (CheckBoxPreference) preferenceFindPreference9;
        }
        if (checkBoxPreference3 != null && settings.isSamsungSHealth() && (samsungSHealthRecordCount = settings.getSamsungSHealthRecordCount()) >= 0) {
            checkBoxPreference3.setSummary(preferenceActivity2.getString(R.string.displaying_records_count, Integer.valueOf(samsungSHealthRecordCount)));
        }
        if (checkBoxPreference3 != null) {
            if (TrialFilter.getInstance().isSamsungSHealth()) {
                Preference preferenceFindPreference10 = preferenceScreen3 != null ? preferenceScreen3.findPreference("settings_category_services") : null;
                preferenceFindPreference10.getClass();
                ((PreferenceGroup) preferenceFindPreference10).addPreference(checkBoxPreference3);
                checkBoxPreference3.setChecked(settings.isSamsungSHealth());
                checkBoxPreference3.setTitle(preferenceActivity2.getString(R.string.samsung_shealth));
                checkBoxPreference3.setOnPreferenceChangeListener(new ServicesSettingsActivity$$ExternalSyntheticLambda4(servicesSettingsActivity, settings, preferenceActivity2, preferenceActivity2, 1));
            } else {
                if ((preferenceScreen3 != null ? preferenceScreen3.findPreference(checkBoxPreference3.getKey()) : null) != null) {
                    Preference preferenceFindPreference11 = preferenceScreen3.findPreference("settings_category_services");
                    preferenceFindPreference11.getClass();
                    ((PreferenceGroup) preferenceFindPreference11).removePreference(checkBoxPreference3);
                }
            }
        }
        if (preferenceScreen3 == null) {
            checkBoxPreference4 = null;
        } else {
            Preference preferenceFindPreference12 = preferenceScreen3.findPreference("google_calendar");
            if (!(preferenceFindPreference12 instanceof CheckBoxPreference)) {
                preferenceFindPreference12 = null;
            }
            checkBoxPreference4 = (CheckBoxPreference) preferenceFindPreference12;
        }
        if (checkBoxPreference4 != null) {
            if (Experiments.getInstance().showBetaDialogBecauseOfPermission()) {
                checkBoxPreference4.setSummary(preferenceActivity2.getString(R.string.beta_only));
            }
            boolean zIsGoogleCalendar = TrialFilter.getInstance().isGoogleCalendar();
            if (settings.isGoogleCalendar() && (googleCalendarRecordCount = SharedApplicationContext.getSettings().getGoogleCalendarRecordCount()) >= 0) {
                checkBoxPreference4.setSummary(preferenceActivity2.getString(R.string.displaying_records_count, Integer.valueOf(googleCalendarRecordCount)));
            }
            if (zIsGoogleCalendar || !Experiments.getInstance().isGoogleCalendarExperiment()) {
                Logger.logInfo(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: installed", null);
                if (preferenceScreen3 == null) {
                    preferenceGroup = null;
                } else {
                    Preference preferenceFindPreference13 = preferenceScreen3.findPreference("settings_category_services");
                    if (!(preferenceFindPreference13 instanceof PreferenceGroup)) {
                        preferenceFindPreference13 = null;
                    }
                    preferenceGroup = (PreferenceGroup) preferenceFindPreference13;
                }
                if (preferenceGroup != null) {
                    preferenceGroup.addPreference(checkBoxPreference4);
                }
                checkBoxPreference4.setChecked(settings.isGoogleCalendar());
                checkBoxPreference4.setTitle(preferenceActivity2.getString(R.string.google_calendar));
                checkBoxPreference4.setOnPreferenceChangeListener(new ServicesSettingsActivity$$ExternalSyntheticLambda4(servicesSettingsActivity, settings, preferenceActivity2, preferenceActivity2, 2));
            } else {
                Logger.logInfo(Logger.defaultTag, servicesSettingsActivity.getTag() + ": Google Calendar: not installed", null);
                checkBoxPreference4.setSummary(preferenceActivity2.getString(R.string.google_calendar) + " not installed");
                checkBoxPreference4.setChecked(false);
                checkBoxPreference4.setEnabled(false);
                settings.setGoogleCalendar(false);
                GoogleCalendarChangeReceiver.INSTANCE.setEnabled(preferenceActivity2, false);
            }
        }
        if (preferenceScreen3 != null) {
            Preference preferenceFindPreference14 = preferenceScreen3.findPreference("spotify");
            final CheckBoxPreference checkBoxPreference7 = (CheckBoxPreference) (preferenceFindPreference14 instanceof CheckBoxPreference ? preferenceFindPreference14 : null);
            if (checkBoxPreference7 != null) {
                final ServicesSettingsActivity servicesSettingsActivity2 = servicesSettingsActivity;
                final PreferenceActivity preferenceActivity3 = preferenceActivity2;
                Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda9
                    @Override // android.preference.Preference.OnPreferenceChangeListener
                    public final boolean onPreferenceChange(Preference preference, Object obj) {
                        return ServicesSettingsActivity.refresh$lambda$9$0(preferenceActivity3, checkBoxPreference7, preferenceActivity2, servicesSettingsActivity2, settings, preference, obj);
                    }
                };
                servicesSettingsActivity = servicesSettingsActivity2;
                settings = settings;
                checkBoxPreference7.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
        }
        servicesSettingsActivity.refreshSyncNow(settings, preferenceActivity2);
    }
}

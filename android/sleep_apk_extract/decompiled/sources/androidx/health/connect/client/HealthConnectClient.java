package androidx.health.connect.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.UserManager;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.impl.HealthConnectClientImpl;
import androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.HealthDataService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eJ\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\r\u001a\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH¦@¢\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\b\b\u0000\u0010\u000f*\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H¦@¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00022\u0006\u0010\u0011\u001a\u00020\u0015H¦@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient;", "", "", "Landroidx/health/connect/client/records/Record;", "records", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "insertRecords", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/reflect/KClass;", "recordType", "Landroidx/health/connect/client/time/TimeRangeFilter;", "timeRangeFilter", "", "deleteRecords", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "request", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "readRecords", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "aggregateGroupByDuration", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/PermissionController;", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "permissionController", "Companion", "Api34Impl", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HealthConnectClient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient$Api34Impl;", "", "<init>", "()V", "getSdkStatus", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "isProfile", "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        public static final int getSdkStatus(Context context) {
            context.getClass();
            return (INSTANCE.isProfile(context) || context.getSystemService("healthconnect") == null) ? 1 : 3;
        }

        private final boolean isProfile(Context context) {
            Object systemService = context.getSystemService("user");
            systemService.getClass();
            return ((UserManager) systemService).isProfile();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u00020\u00068GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient$Companion;", "", "<init>", "()V", "Landroid/content/pm/PackageManager;", "packageManager", "", "packageName", "", "versionCode", "", "isPackageInstalled", "(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Z", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "providerPackageName", "getSdkStatus", "(Landroid/content/Context;Ljava/lang/String;)I", "Landroidx/health/connect/client/HealthConnectClient;", "getOrCreate", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/health/connect/client/HealthConnectClient;", "hasBindableService$connect_client_release", "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z", "hasBindableService", "ACTION_HEALTH_CONNECT_SETTINGS", "Ljava/lang/String;", "getHealthConnectSettingsAction", "()Ljava/lang/String;", "getHealthConnectSettingsAction$annotations", "ACTION_HEALTH_CONNECT_MANAGE_DATA", "getACTION_HEALTH_CONNECT_MANAGE_DATA$connect_client_release", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String ACTION_HEALTH_CONNECT_MANAGE_DATA;
        private static final String ACTION_HEALTH_CONNECT_SETTINGS;

        static {
            int i = Build.VERSION.SDK_INT;
            ACTION_HEALTH_CONNECT_SETTINGS = i >= 34 ? "android.health.connect.action.HEALTH_HOME_SETTINGS" : "androidx.health.ACTION_HEALTH_CONNECT_SETTINGS";
            ACTION_HEALTH_CONNECT_MANAGE_DATA = i >= 34 ? "android.health.connect.action.MANAGE_HEALTH_DATA" : "androidx.health.ACTION_MANAGE_HEALTH_DATA";
        }

        private Companion() {
        }

        public static /* synthetic */ HealthConnectClient getOrCreate$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "com.google.android.apps.healthdata";
            }
            return companion.getOrCreate(context, str);
        }

        private final boolean isPackageInstalled(PackageManager packageManager, String packageName, int versionCode) {
            PackageInfo packageInfo;
            ApplicationInfo applicationInfo;
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 0);
                packageInfo.getClass();
                applicationInfo = packageInfo.applicationInfo;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return applicationInfo != null && applicationInfo.enabled && (!Intrinsics.areEqual(packageName, "com.google.android.apps.healthdata") || PackageInfoCompat.getLongVersionCode(packageInfo) >= ((long) versionCode)) && hasBindableService$connect_client_release(packageManager, packageName);
        }

        public static /* synthetic */ boolean isPackageInstalled$default(Companion companion, PackageManager packageManager, String str, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 68623;
            }
            return companion.isPackageInstalled(packageManager, str, i);
        }

        public final String getHealthConnectSettingsAction() {
            return ACTION_HEALTH_CONNECT_SETTINGS;
        }

        public final HealthConnectClient getOrCreate(Context context, String providerPackageName) {
            context.getClass();
            providerPackageName.getClass();
            int sdkStatus = getSdkStatus(context, providerPackageName);
            if (sdkStatus == 1) {
                Utf8$$ExternalSyntheticBUOutline0.m("SDK version too low or running in a profile");
                return null;
            }
            if (sdkStatus != 2) {
                return Build.VERSION.SDK_INT >= 34 ? new HealthConnectClientUpsideDownImpl(context) : new HealthConnectClientImpl(context, providerPackageName);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Service not available");
            return null;
        }

        public final int getSdkStatus(Context context, String providerPackageName) {
            context.getClass();
            providerPackageName.getClass();
            int i = Build.VERSION.SDK_INT;
            if (34 <= i) {
                return Api34Impl.getSdkStatus(context);
            }
            if (28 > i || i >= 34) {
                return 1;
            }
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            return isPackageInstalled$default(this, packageManager, providerPackageName, 0, 4, null) ? 3 : 2;
        }

        public final boolean hasBindableService$connect_client_release(PackageManager packageManager, String packageName) {
            packageManager.getClass();
            packageName.getClass();
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(HealthDataService.ANDROID_HEALTH_PLATFORM_SERVICE_BIND_ACTION);
            packageManager.queryIntentServices(intent, 0).getClass();
            return !r0.isEmpty();
        }
    }

    Object aggregateGroupByDuration(AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDuration>> continuation);

    Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation);

    PermissionController getPermissionController();

    Object insertRecords(List<? extends Record> list, Continuation<? super InsertRecordsResponse> continuation);

    <T extends Record> Object readRecords(ReadRecordsRequest<T> readRecordsRequest, Continuation<? super ReadRecordsResponse<T>> continuation);
}

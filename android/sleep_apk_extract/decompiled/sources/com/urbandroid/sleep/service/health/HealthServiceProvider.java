package com.urbandroid.sleep.service.health;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001e\u001f !\u001dB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\tR\u0014\u0010\u0018\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\u00020\u00158&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001b\u0082\u0001\u0004\"#$%¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "", "<init>", "()V", "Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "toIntegration", "()Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "isGoogleFit", "()Z", "isSamsungSHealth", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "(Landroid/content/Context;)Z", "name", "Ljava/lang/String;", "getName", "", "getTitleRes", "()I", "titleRes", "getCachedRecordCount", "setCachedRecordCount", "(I)V", "cachedRecordCount", "Companion", "GoogleFit", "HealthConnect", "GoogleCalendar", "SamsungSHealth", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider$GoogleCalendar;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider$GoogleFit;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider$HealthConnect;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider$SamsungSHealth;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class HealthServiceProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthServiceProvider$Companion;", "", "<init>", "()V", "findOrNull", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "name", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HealthServiceProvider findOrNull(String name) {
            if (Intrinsics.areEqual(name, SamsungSHealth.class.getSimpleName())) {
                return SamsungSHealth.INSTANCE;
            }
            if (Intrinsics.areEqual(name, GoogleCalendar.class.getSimpleName())) {
                return GoogleCalendar.INSTANCE;
            }
            if (Intrinsics.areEqual(name, GoogleFit.class.getSimpleName())) {
                return GoogleFit.INSTANCE;
            }
            if (Intrinsics.areEqual(name, HealthConnect.class.getSimpleName())) {
                return HealthConnect.INSTANCE;
            }
            return null;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthServiceProvider$GoogleCalendar;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "(Landroid/content/Context;)Z", "Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "toIntegration", "()Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "", "titleRes", "I", "getTitleRes", "()I", SDKConstants.PARAM_VALUE, "getCachedRecordCount", "setCachedRecordCount", "(I)V", "cachedRecordCount", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class GoogleCalendar extends HealthServiceProvider {
        public static final GoogleCalendar INSTANCE = new GoogleCalendar();
        private static final int titleRes = R.string.google_calendar;

        private GoogleCalendar() {
            super(null);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public int getTitleRes() {
            return titleRes;
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public boolean isEnabled(Context context) {
            context.getClass();
            return ContextExtKt.getSettings(context).isGoogleCalendar();
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public void setCachedRecordCount(int i) {
            SharedApplicationContext.getSettings().setGoogleCalendarRecordCount(i);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public FirebaseAnalyticsManager.Integration toIntegration() {
            return FirebaseAnalyticsManager.Integration.GOOGLE_CALENDAR;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthServiceProvider$GoogleFit;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "(Landroid/content/Context;)Z", "Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "toIntegration", "()Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "", "titleRes", "I", "getTitleRes", "()I", SDKConstants.PARAM_VALUE, "getCachedRecordCount", "setCachedRecordCount", "(I)V", "cachedRecordCount", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class GoogleFit extends HealthServiceProvider {
        public static final GoogleFit INSTANCE = new GoogleFit();
        private static final int titleRes = R.string.google_fit;

        private GoogleFit() {
            super(null);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public int getTitleRes() {
            return titleRes;
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public boolean isEnabled(Context context) {
            context.getClass();
            return ContextExtKt.getSettings(context).isGoogleFit();
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public void setCachedRecordCount(int i) {
            SharedApplicationContext.getSettings().setGoogleFitRecordCount(i);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public FirebaseAnalyticsManager.Integration toIntegration() {
            return FirebaseAnalyticsManager.Integration.GOOGLE_FIT;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthServiceProvider$HealthConnect;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "(Landroid/content/Context;)Z", "Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "toIntegration", "()Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "", "titleRes", "I", "getTitleRes", "()I", SDKConstants.PARAM_VALUE, "getCachedRecordCount", "setCachedRecordCount", "(I)V", "cachedRecordCount", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class HealthConnect extends HealthServiceProvider {
        public static final HealthConnect INSTANCE = new HealthConnect();
        private static final int titleRes = R.string.health_connect;

        private HealthConnect() {
            super(null);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public int getTitleRes() {
            return titleRes;
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public boolean isEnabled(Context context) {
            context.getClass();
            return ContextExtKt.getSettings(context).isHealthConnect();
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public void setCachedRecordCount(int i) {
            SharedApplicationContext.getSettings().setHealthConnectRecordCount(i);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public FirebaseAnalyticsManager.Integration toIntegration() {
            return FirebaseAnalyticsManager.Integration.HEALTH_CONNECT;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthServiceProvider$SamsungSHealth;", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "(Landroid/content/Context;)Z", "Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "toIntegration", "()Lcom/urbandroid/sleep/share/analytics/FirebaseAnalyticsManager$Integration;", "", "titleRes", "I", "getTitleRes", "()I", SDKConstants.PARAM_VALUE, "getCachedRecordCount", "setCachedRecordCount", "(I)V", "cachedRecordCount", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SamsungSHealth extends HealthServiceProvider {
        public static final SamsungSHealth INSTANCE = new SamsungSHealth();
        private static final int titleRes = R.string.samsung_shealth;

        private SamsungSHealth() {
            super(null);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public int getTitleRes() {
            return titleRes;
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public boolean isEnabled(Context context) {
            context.getClass();
            return ContextExtKt.getSettings(context).isSamsungSHealth();
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public void setCachedRecordCount(int i) {
            SharedApplicationContext.getSettings().setSamsungSHealthRecordCount(i);
        }

        @Override // com.urbandroid.sleep.service.health.HealthServiceProvider
        public FirebaseAnalyticsManager.Integration toIntegration() {
            return FirebaseAnalyticsManager.Integration.SAMSUNG_S_HEALTH;
        }
    }

    private HealthServiceProvider() {
        this.name = getClass().getSimpleName();
    }

    public final String getName() {
        return this.name;
    }

    public abstract int getTitleRes();

    public abstract boolean isEnabled(Context context);

    public final boolean isGoogleFit() {
        return Intrinsics.areEqual(this, GoogleFit.INSTANCE);
    }

    public final boolean isSamsungSHealth() {
        return Intrinsics.areEqual(this, SamsungSHealth.INSTANCE);
    }

    public abstract void setCachedRecordCount(int i);

    public abstract FirebaseAnalyticsManager.Integration toIntegration();

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m$1(this.name, " Provider");
    }

    public /* synthetic */ HealthServiceProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.urbandroid.sleep;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 %2\u00020\u0001:\u0002&%B-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\rJ\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\rJ\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\rJ\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b$\u0010 ¨\u0006'"}, d2 = {"Lcom/urbandroid/sleep/PendingIntentBuilder;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "requestCode", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "flags", "<init>", "(Landroid/content/Context;ILandroid/content/Intent;I)V", "Landroid/app/PendingIntent;", "getAlwaysExplicitBroadcast", "()Landroid/app/PendingIntent;", "Lcom/urbandroid/sleep/PendingIntentBuilder$Type;", "type", "", "cancelAlarm", "(Lcom/urbandroid/sleep/PendingIntentBuilder$Type;)V", "getBroadcast", "getExplicitBroadcast", "getService", "getActivity", "getForegroundService", "cancelAlarmBroadcast", "()V", "cancelAlarmService", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "I", "getRequestCode", "()I", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "getFlags", "Companion", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PendingIntentBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final int flags;
    private final Intent intent;
    private final int requestCode;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/PendingIntentBuilder$Companion;", "", "<init>", "()V", "get", "Lcom/urbandroid/sleep/PendingIntentBuilder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "requestCode", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "flags", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PendingIntentBuilder get(Context context, int requestCode, Intent intent, int flags) {
            context.getClass();
            intent.getClass();
            return new PendingIntentBuilder(context, requestCode, intent, flags);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/PendingIntentBuilder$Type;", "", "<init>", "(Ljava/lang/String;I)V", "BROADCAST", "SERVICE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type BROADCAST = new Type("BROADCAST", 0);
        public static final Type SERVICE = new Type("SERVICE", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{BROADCAST, SERVICE};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.BROADCAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PendingIntentBuilder(Context context, int i, Intent intent, int i2) {
        context.getClass();
        intent.getClass();
        this.context = context;
        this.requestCode = i;
        this.intent = intent;
        if (Build.VERSION.SDK_INT >= 31 && (i2 & 67108864) != 67108864 && (i2 & 33554432) != 33554432) {
            i2 |= 67108864;
        }
        this.flags = i2;
    }

    private final void cancelAlarm(Type type) {
        AlarmManager alarmManager = ContextExtKt.getAlarmManager(this.context);
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            alarmManager.cancel(getAlwaysExplicitBroadcast());
            alarmManager.cancel(getBroadcast());
            return;
        }
        if (i != 2) {
            Home$$ExternalSyntheticBUOutline0.m();
            return;
        }
        alarmManager.cancel(getService());
        alarmManager.cancel(getForegroundService());
        if (ContextExtKt.hasNoPackage(this.intent)) {
            Intent intent = this.intent;
            String packageName = this.context.getPackageName();
            packageName.getClass();
            Intent intentCopy = ContextExtKt.copy(intent, packageName);
            Companion companion = INSTANCE;
            alarmManager.cancel(companion.get(this.context, this.requestCode, intentCopy, this.flags).getService());
            if (Build.VERSION.SDK_INT >= 26) {
                alarmManager.cancel(companion.get(this.context, this.requestCode, intentCopy, this.flags).getForegroundService());
            }
        }
    }

    public static final PendingIntentBuilder get(Context context, int i, Intent intent, int i2) {
        return INSTANCE.get(context, i, intent, i2);
    }

    private final PendingIntent getAlwaysExplicitBroadcast() {
        Intent intent = this.intent;
        String packageName = this.context.getPackageName();
        packageName.getClass();
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context, this.requestCode, ContextExtKt.copy(intent, packageName), this.flags);
        broadcast.getClass();
        return broadcast;
    }

    public final void cancelAlarmBroadcast() {
        cancelAlarm(Type.BROADCAST);
    }

    public final void cancelAlarmService() {
        cancelAlarm(Type.SERVICE);
    }

    public final PendingIntent getActivity() {
        PendingIntent activity = PendingIntent.getActivity(this.context, this.requestCode, this.intent, this.flags);
        activity.getClass();
        return activity;
    }

    public final PendingIntent getBroadcast() {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context, this.requestCode, this.intent, this.flags);
        broadcast.getClass();
        return broadcast;
    }

    public final PendingIntent getExplicitBroadcast() {
        return ContextExtKt.hasNoPackage(this.intent) ? getAlwaysExplicitBroadcast() : getBroadcast();
    }

    public final PendingIntent getForegroundService() {
        if (Build.VERSION.SDK_INT < 26) {
            return getService();
        }
        PendingIntent foregroundService = PendingIntent.getForegroundService(this.context, this.requestCode, this.intent, this.flags);
        foregroundService.getClass();
        return foregroundService;
    }

    public final PendingIntent getService() {
        PendingIntent service = PendingIntent.getService(this.context, this.requestCode, this.intent, this.flags);
        service.getClass();
        return service;
    }
}

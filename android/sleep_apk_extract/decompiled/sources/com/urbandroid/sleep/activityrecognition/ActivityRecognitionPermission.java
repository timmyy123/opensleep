package com.urbandroid.sleep.activityrecognition;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.util.SleepPermissionCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0015*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0003\u0016\u0017\u0015B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission;", "Landroid/content/Context;", "T", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "name", "getName", "", "isGranted", "Z", "()Z", "Companion", "Access", "Request", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission$Access;", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission$Request;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ActivityRecognitionPermission<T extends Context> implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T context;
    private final boolean isGranted;
    private final String name;
    private final String tag;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission$Access;", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Access extends ActivityRecognitionPermission<Context> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Access(Context context) {
            super(context, null);
            context.getClass();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission$Companion;", "", "<init>", "()V", "isGranted", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "name", "", "request", "activity", "Landroid/app/Activity;", "requestCode", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ boolean request$default(Companion companion, Activity activity, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 229;
            }
            return companion.request(activity, i);
        }

        public final boolean isGranted(Context context) {
            context.getClass();
            return new Access(context).getIsGranted();
        }

        public final String name(Context context) {
            context.getClass();
            return new Access(context).getName();
        }

        public final boolean request(Activity activity, int requestCode) {
            activity.getClass();
            return new Request(activity).request(requestCode);
        }

        private Companion() {
        }

        public final boolean request(Activity activity) {
            activity.getClass();
            return request$default(this, activity, 0, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission$Request;", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionPermission;", "Landroid/content/Context;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "requestCode", "", "request", "(I)Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Request extends ActivityRecognitionPermission<Context> {
        private final Activity activity;

        /* JADX WARN: Illegal instructions before constructor call */
        public Request(Activity activity) {
            activity.getClass();
            Context applicationContext = activity.getApplicationContext();
            applicationContext.getClass();
            super(applicationContext, null);
            this.activity = activity;
        }

        public final boolean request(int requestCode) {
            String name = getName();
            if (name == null) {
                return false;
            }
            if (getIsGranted()) {
                name = null;
            }
            if (name == null) {
                return false;
            }
            PermissionCompat.requestPermission(this.activity, name, requestCode);
            return true;
        }
    }

    private ActivityRecognitionPermission(T t) {
        boolean zIsPermissionGranted;
        this.context = t;
        this.tag = "activity-recognition";
        int i = Build.VERSION.SDK_INT;
        String str = i >= 29 ? "android.permission.ACTIVITY_RECOGNITION" : i == 28 ? "com.google.android.gms.permission.ACTIVITY_RECOGNITION" : null;
        this.name = str;
        if (str != null) {
            zIsPermissionGranted = SleepPermissionCompat.INSTANCE.isPermissionGranted(t, str);
            String str2 = "SDK " + i + " " + str + " granted: " + zIsPermissionGranted;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
        } else {
            String strM = Fragment$$ExternalSyntheticOutline1.m(i, "SDK ", " activity recognition permission not needed for API 27 and less");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            zIsPermissionGranted = true;
        }
        this.isGranted = zIsPermissionGranted;
    }

    public static final boolean isGranted(Context context) {
        return INSTANCE.isGranted(context);
    }

    public static final String name(Context context) {
        return INSTANCE.name(context);
    }

    public static final boolean request(Activity activity) {
        return INSTANCE.request(activity);
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: isGranted, reason: from getter */
    public final boolean getIsGranted() {
        return this.isGranted;
    }

    public /* synthetic */ ActivityRecognitionPermission(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }
}

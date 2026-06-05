package com.urbandroid.sleep.autostart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.urbandroid.common.AsyncContext;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.autostart.AutoTrackingProcessor;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0007J&\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "addActivityAndProcessStages", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "durationInMillis", "", "range", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "stageFilter", "Lkotlin/Function1;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "", "processStages", "expectedTrackingRange", "doAfter", "Lkotlin/Function0;", "Activity", "Stage", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoTrackingProcessor implements FeatureLogger {
    public static final AutoTrackingProcessor INSTANCE = new AutoTrackingProcessor();
    private static final String tag = "AutoTracking:Processor";

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\b\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000eR\u0011\u0010\u001f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000eR\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010&\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "", "", "from", "to", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "awakeIntervals", "<init>", "(JJLcom/urbandroid/sleep/activityrecognition/ActivityIntervals;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFrom", "()J", "getTo", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "getAwakeIntervals", "()Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "getTotalTime", "totalTime", "getCumulativeTime", "cumulativeTime", "getIntervalsWithActivity", "intervalsWithActivity", "", "getPercentage", "()D", "percentage", "getNoActivity", "()Z", "noActivity", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Activity {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ActivityIntervals awakeIntervals;
        private final long from;
        private final long to;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity$Companion;", "", "<init>", "()V", "of", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "from", "", "to", "stillIntervals", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Activity of(long from, long to, ActivityIntervals stillIntervals) {
                stillIntervals.getClass();
                return new Activity(from, to, stillIntervals.invert(from, to));
            }

            private Companion() {
            }
        }

        public Activity(long j, long j2, ActivityIntervals activityIntervals) {
            activityIntervals.getClass();
            this.from = j;
            this.to = j2;
            this.awakeIntervals = activityIntervals;
        }

        private final int getCumulativeTime() {
            return this.awakeIntervals.cumulativeTime();
        }

        private final long getTotalTime() {
            return this.to - this.from;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Activity)) {
                return false;
            }
            Activity activity = (Activity) other;
            return this.from == activity.from && this.to == activity.to && Intrinsics.areEqual(this.awakeIntervals, activity.awakeIntervals);
        }

        public final ActivityIntervals getAwakeIntervals() {
            return this.awakeIntervals;
        }

        public final int getIntervalsWithActivity() {
            return this.awakeIntervals.size();
        }

        public final boolean getNoActivity() {
            return this.awakeIntervals.isEmpty() || getIntervalsWithActivity() == 0;
        }

        public final double getPercentage() {
            if (this.awakeIntervals.isEmpty()) {
                return 0.0d;
            }
            return ((double) getCumulativeTime()) / getTotalTime();
        }

        public int hashCode() {
            return this.awakeIntervals.hashCode() + ((Long.hashCode(this.to) + (Long.hashCode(this.from) * 31)) * 31);
        }

        public String toString() {
            long j = this.from;
            long j2 = this.to;
            ActivityIntervals activityIntervals = this.awakeIntervals;
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Activity(from=", ", to=", j);
            sbM.append(j2);
            sbM.append(", awakeIntervals=");
            sbM.append(activityIntervals);
            sbM.append(")");
            return sbM.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00020\u0001:\u0006\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "", "<init>", "()V", "lastActivity", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getLastActivity", "()Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "NotTracking", "Beginning", "Tracking", "CloseToEnd", "TooLongTracking", "Companion", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$Beginning;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$CloseToEnd;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$NotTracking;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$TooLongTracking;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$Tracking;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Stage {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$Beginning;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "lastActivity", "", "progress", "<init>", "(Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;F)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getLastActivity", "()Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "F", "getProgress", "()F", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Beginning extends Stage {
            private final Activity lastActivity;
            private final float progress;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Beginning(Activity activity, float f) {
                super(null);
                activity.getClass();
                this.lastActivity = activity;
                this.progress = f;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Beginning)) {
                    return false;
                }
                Beginning beginning = (Beginning) other;
                return Intrinsics.areEqual(this.lastActivity, beginning.lastActivity) && Float.compare(this.progress, beginning.progress) == 0;
            }

            @Override // com.urbandroid.sleep.autostart.AutoTrackingProcessor.Stage
            public Activity getLastActivity() {
                return this.lastActivity;
            }

            public final float getProgress() {
                return this.progress;
            }

            public int hashCode() {
                return Float.hashCode(this.progress) + (this.lastActivity.hashCode() * 31);
            }

            public String toString() {
                return "Beginning(lastActivity=" + this.lastActivity + ", progress=" + this.progress + ")";
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$CloseToEnd;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "lastActivity", "", "progress", "<init>", "(Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;F)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getLastActivity", "()Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "F", "getProgress", "()F", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class CloseToEnd extends Stage {
            private final Activity lastActivity;
            private final float progress;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CloseToEnd(Activity activity, float f) {
                super(null);
                activity.getClass();
                this.lastActivity = activity;
                this.progress = f;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CloseToEnd)) {
                    return false;
                }
                CloseToEnd closeToEnd = (CloseToEnd) other;
                return Intrinsics.areEqual(this.lastActivity, closeToEnd.lastActivity) && Float.compare(this.progress, closeToEnd.progress) == 0;
            }

            @Override // com.urbandroid.sleep.autostart.AutoTrackingProcessor.Stage
            public Activity getLastActivity() {
                return this.lastActivity;
            }

            public final float getProgress() {
                return this.progress;
            }

            public int hashCode() {
                return Float.hashCode(this.progress) + (this.lastActivity.hashCode() * 31);
            }

            public String toString() {
                return "CloseToEnd(lastActivity=" + this.lastActivity + ", progress=" + this.progress + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$Companion;", "", "<init>", "()V", "detect", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "range", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "stillIntervals", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Stage detect(ExpectedTrackingRange range, ActivityIntervals stillIntervals) {
                range.getClass();
                stillIntervals.getClass();
                final String tag = AutoTrackingProcessor.INSTANCE.getTag();
                FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.autostart.AutoTrackingProcessor$Stage$Companion$detect$$inlined$featureLog$default$1
                    @Override // com.urbandroid.common.FeatureLogger
                    public String getTag() {
                        String str = tag;
                        boolean z = z;
                        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str);
                        String strConcat = "";
                        if (z) {
                            String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                            if (strM == null) {
                                strConcat = null;
                            } else if (!StringsKt.isBlank(strM)) {
                                strConcat = ":".concat(strM);
                            }
                        }
                        sbM.append(strConcat);
                        return sbM.toString();
                    }
                };
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strM = FileInsert$$ExternalSyntheticOutline0.m("still intervals: ", stillIntervals.toString(true, 5));
                Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
                Activity.Companion companion = Activity.INSTANCE;
                Activity activityOf = companion.of(jCurrentTimeMillis - 900000, jCurrentTimeMillis, stillIntervals);
                String strM2 = FileInsert$$ExternalSyntheticOutline0.m("last 15 min activity: ", activityOf.getAwakeIntervals().toString(true, 5));
                Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + strM2, null);
                boolean zIsInProcessTracking = CurrentSleepRecord.getInstance().isInProcessTracking();
                StringBuilder sb = new StringBuilder("tracking running ");
                sb.append(zIsInProcessTracking);
                String string = sb.toString();
                Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + string, null);
                if (!zIsInProcessTracking) {
                    return new NotTracking(activityOf);
                }
                SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
                if (record == null) {
                    return new NotTracking(activityOf);
                }
                long fromTime = record.getFromTime();
                long fromTime2 = (jCurrentTimeMillis - record.getFromTime()) / 60000;
                String str = "tracking running from " + Utils.getPrettyDate(fromTime) + " for " + fromTime2 + " minutes";
                Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + str, null);
                long margin = range.getMargin() - 1;
                z = jCurrentTimeMillis >= range.getEnd() - margin;
                float fMax = Math.max(jCurrentTimeMillis - (range.getEnd() - margin), 0L) / margin;
                if (fromTime2 <= 45) {
                    return new Beginning(activityOf, fromTime2 / 45.0f);
                }
                if (jCurrentTimeMillis <= Utils.getHoursInMillis(2) + range.getEnd()) {
                    long j = fromTime2 / 60;
                    if (j <= 10) {
                        return (j < 4 || !z) ? new Tracking(activityOf, companion.of(fromTime, jCurrentTimeMillis, stillIntervals)) : new CloseToEnd(activityOf, fMax);
                    }
                }
                return new TooLongTracking(activityOf);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$NotTracking;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "lastActivity", "<init>", "(Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getLastActivity", "()Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class NotTracking extends Stage {
            private final Activity lastActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotTracking(Activity activity) {
                super(null);
                activity.getClass();
                this.lastActivity = activity;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NotTracking) && Intrinsics.areEqual(this.lastActivity, ((NotTracking) other).lastActivity);
            }

            @Override // com.urbandroid.sleep.autostart.AutoTrackingProcessor.Stage
            public Activity getLastActivity() {
                return this.lastActivity;
            }

            public int hashCode() {
                return this.lastActivity.hashCode();
            }

            public String toString() {
                return "NotTracking(lastActivity=" + this.lastActivity + ")";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$TooLongTracking;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "lastActivity", "<init>", "(Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getLastActivity", "()Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class TooLongTracking extends Stage {
            private final Activity lastActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TooLongTracking(Activity activity) {
                super(null);
                activity.getClass();
                this.lastActivity = activity;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TooLongTracking) && Intrinsics.areEqual(this.lastActivity, ((TooLongTracking) other).lastActivity);
            }

            @Override // com.urbandroid.sleep.autostart.AutoTrackingProcessor.Stage
            public Activity getLastActivity() {
                return this.lastActivity;
            }

            public int hashCode() {
                return this.lastActivity.hashCode();
            }

            public String toString() {
                return "TooLongTracking(lastActivity=" + this.lastActivity + ")";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage$Tracking;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Stage;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "lastActivity", "fullActivity", "<init>", "(Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getLastActivity", "()Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor$Activity;", "getFullActivity", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Tracking extends Stage {
            private final Activity fullActivity;
            private final Activity lastActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Tracking(Activity activity, Activity activity2) {
                super(null);
                activity.getClass();
                activity2.getClass();
                this.lastActivity = activity;
                this.fullActivity = activity2;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Tracking)) {
                    return false;
                }
                Tracking tracking = (Tracking) other;
                return Intrinsics.areEqual(this.lastActivity, tracking.lastActivity) && Intrinsics.areEqual(this.fullActivity, tracking.fullActivity);
            }

            public final Activity getFullActivity() {
                return this.fullActivity;
            }

            @Override // com.urbandroid.sleep.autostart.AutoTrackingProcessor.Stage
            public Activity getLastActivity() {
                return this.lastActivity;
            }

            public int hashCode() {
                return this.fullActivity.hashCode() + (this.lastActivity.hashCode() * 31);
            }

            public String toString() {
                return "Tracking(lastActivity=" + this.lastActivity + ", fullActivity=" + this.fullActivity + ")";
            }
        }

        public /* synthetic */ Stage(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Activity getLastActivity();

        private Stage() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.autostart.AutoTrackingProcessor$addActivityAndProcessStages$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.autostart.AutoTrackingProcessor$addActivityAndProcessStages$1", f = "AutoTrackingProcessor.kt", l = {124}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<AsyncContext<AutoTrackingProcessor>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $durationInMillis;
        final /* synthetic */ ExpectedTrackingRange $range;
        final /* synthetic */ Function1<Stage, Boolean> $stageFilter;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Context context, Function1<? super Stage, Boolean> function1, ExpectedTrackingRange expectedTrackingRange, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$stageFilter = function1;
            this.$range = expectedTrackingRange;
            this.$durationInMillis = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Ref$BooleanRef ref$BooleanRef, Context context, ExpectedTrackingRange expectedTrackingRange, AutoTrackingProcessor autoTrackingProcessor) {
            if (ref$BooleanRef.element) {
                AutoTrackingProcessor.processStages$default(AutoTrackingProcessor.INSTANCE, context, expectedTrackingRange, null, 4, null);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$stageFilter, this.$range, this.$durationInMillis, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<AutoTrackingProcessor> asyncContext, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AsyncContext asyncContext;
            Object obj2;
            AsyncContext asyncContext2 = (AsyncContext) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                Context context = this.$context;
                Function1<Stage, Boolean> function1 = this.$stageFilter;
                ExpectedTrackingRange expectedTrackingRange = this.$range;
                long j = this.$durationInMillis;
                ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
                ReentrantLock lock = companion.getLOCK();
                lock.lock();
                try {
                    File storageFile = companion.getStorageFile(context);
                    ActivityIntervals activityIntervalsFrom = companion.from(storageFile);
                    boolean z = function1 == null || function1.invoke(Stage.INSTANCE.detect(expectedTrackingRange, activityIntervalsFrom)).booleanValue();
                    ref$BooleanRef.element = z;
                    if (z) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000000;
                        asyncContext = asyncContext2;
                        obj2 = coroutine_suspended;
                        activityIntervalsFrom.add(new ActivityTransitionEvent(3, 1, jElapsedRealtime - TimeUnit.MILLISECONDS.toNanos(j)));
                        activityIntervalsFrom.add(new ActivityTransitionEvent(3, 0, jElapsedRealtime));
                        String str = "AutoTracking: adding activity " + j + "ms " + activityIntervalsFrom.toString(true, Boxing.boxInt(5));
                        Logger.logDebug(Logger.defaultTag, activityIntervalsFrom.getTag() + ": " + str, null);
                    } else {
                        asyncContext = asyncContext2;
                        obj2 = coroutine_suspended;
                    }
                    activityIntervalsFrom.export(storageFile);
                    lock.unlock();
                    final Context context2 = this.$context;
                    final ExpectedTrackingRange expectedTrackingRange2 = this.$range;
                    Function1 function12 = new Function1() { // from class: com.urbandroid.sleep.autostart.AutoTrackingProcessor$addActivityAndProcessStages$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return AutoTrackingProcessor.AnonymousClass1.invokeSuspend$lambda$1(ref$BooleanRef, context2, expectedTrackingRange2, (AutoTrackingProcessor) obj3);
                        }
                    };
                    this.L$0 = SpillingKt.nullOutSpilledVariable(asyncContext);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(ref$BooleanRef);
                    this.label = 1;
                    Object obj3 = obj2;
                    if (Utils.uiThread(asyncContext, function12, this) == obj3) {
                        return obj3;
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.autostart.AutoTrackingProcessor$processStages$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/autostart/AutoTrackingProcessor;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.autostart.AutoTrackingProcessor$processStages$2", f = "AutoTrackingProcessor.kt", l = {143}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<AsyncContext<AutoTrackingProcessor>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function0<Unit> $doAfter;
        final /* synthetic */ ExpectedTrackingRange $expectedTrackingRange;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, ExpectedTrackingRange expectedTrackingRange, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$expectedTrackingRange = expectedTrackingRange;
            this.$doAfter = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:30:0x01ec A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:3:0x003f, B:6:0x0081, B:8:0x00bd, B:10:0x00cc, B:13:0x00fa, B:15:0x0105, B:16:0x0148, B:18:0x014e, B:22:0x0189, B:36:0x0263, B:23:0x0192, B:25:0x019f, B:29:0x01b4, B:30:0x01ec, B:32:0x01f6, B:34:0x01fc, B:35:0x0240, B:37:0x026c, B:38:0x02ac, B:39:0x02ec, B:41:0x02f3, B:42:0x032a, B:44:0x0330, B:46:0x0336, B:47:0x035a, B:49:0x03ca, B:51:0x03fc, B:52:0x0405, B:53:0x0418, B:54:0x043c, B:57:0x0442, B:60:0x0461, B:61:0x04d9, B:62:0x053d, B:64:0x0541, B:66:0x0590, B:68:0x0606, B:67:0x05c9, B:71:0x0613, B:72:0x0618), top: B:75:0x003f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final Unit invokeSuspend$lambda$1(Stage stage, ExpectedTrackingRange expectedTrackingRange, Context context, int i, boolean z, ActivityIntervals activityIntervals, Function0 function0, AutoTrackingProcessor autoTrackingProcessor) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                AutoTrackingProcessor autoTrackingProcessor2 = AutoTrackingProcessor.INSTANCE;
                String str = Logger.defaultTag;
                Logger.logInfo(str, autoTrackingProcessor2.getTag() + ": " + ("detected " + stage), null);
                Activity lastActivity = stage.getLastActivity();
                if (stage instanceof Stage.NotTracking) {
                    String str2 = "Not tracking " + expectedTrackingRange.pretty();
                    Logger.logWarning(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str2, null);
                    if (!expectedTrackingRange.plus(Utils.getMinutesInMillis(15L)).contains(jCurrentTimeMillis)) {
                        String str3 = "Not in range " + expectedTrackingRange.pretty();
                        Logger.logWarning(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str3, null);
                        AutoTrackingScheduler.schedule(context, Long.valueOf(expectedTrackingRange.getEnd() + Utils.getHoursInMillis(2)));
                    } else if (Utils.getMinutesInMillis(150) + jCurrentTimeMillis > expectedTrackingRange.getEnd()) {
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": Very close to range end -> scheduling next day", null);
                        AutoTrackingScheduler.schedule(context, Long.valueOf(expectedTrackingRange.getEnd() + Utils.getHoursInMillis(2)));
                    } else if (i >= ConstantsKt.getSUFFICIENT_TRACKING_DURATION()) {
                        String str4 = "We already tracked for " + ConstantsKt.getSUFFICIENT_TRACKING_DURATION() + " -> scheduling next day";
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str4, null);
                        AutoTrackingScheduler.schedule(context, Long.valueOf(expectedTrackingRange.getEnd() + Utils.getHoursInMillis(2)));
                    } else if (lastActivity.getNoActivity()) {
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": no activity - starting sleep tracking", null);
                        long nextSleepTrackingRestartTimestamp = ContextExtKt.getSettings(context).getNextSleepTrackingRestartTimestamp();
                        LongRange longRange = new LongRange(jCurrentTimeMillis, Utils.getMinutesInMillis(15L) + jCurrentTimeMillis);
                        long first = longRange.getFirst();
                        if (nextSleepTrackingRestartTimestamp > longRange.getLast() || first > nextSleepTrackingRestartTimestamp) {
                            Object systemService = context.getSystemService("batterymanager");
                            systemService.getClass();
                            BatteryManager batteryManager = (BatteryManager) systemService;
                            if (z) {
                                long start = expectedTrackingRange.getStart();
                                if (jCurrentTimeMillis <= expectedTrackingRange.getStart() + Utils.getHoursInMillis(1) && start <= jCurrentTimeMillis) {
                                    String str5 = "Not starting - user present: " + Utils.getPrettyDate(expectedTrackingRange.getStart());
                                    Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str5, null);
                                    AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                                } else if (!SharedApplicationContext.getSettings().shouldBeOnChargerWhenAutoStart() || batteryManager.isCharging()) {
                                    Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": Starting...", null);
                                    new SleepStarter().autoStartSleep(context, expectedTrackingRange);
                                } else {
                                    String str6 = "Not starting - not charging, should: " + SharedApplicationContext.getSettings().shouldBeOnChargerWhenAutoStart() + " charging " + batteryManager.isCharging();
                                    Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str6, null);
                                    AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                                }
                            }
                        } else {
                            ContextExtKt.getSettings(context).resetNextSleepTrackingRestartTimestamp();
                        }
                        AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                    } else {
                        String str7 = "activity found " + ((Stage.NotTracking) stage).getLastActivity().getIntervalsWithActivity() + " - tracking not started check after 15";
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str7, null);
                        AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                    }
                } else if (stage instanceof Stage.TooLongTracking) {
                    Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": tracking too long (more than 10 hours - stopping", null);
                    new SleepStarter().autoStopSleep(context, false, activityIntervals);
                    AutoTrackingScheduler.schedule(context, Long.valueOf(expectedTrackingRange.getEnd() + Utils.getHoursInMillis(2)));
                } else if (stage instanceof Stage.Beginning) {
                    if (lastActivity.getNoActivity()) {
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": no activity found - continue with tracking", null);
                        AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                    } else {
                        double dMax = Math.max(0.0d, ((double) ((Stage.Beginning) stage).getProgress()) - 0.3d) * 0.2d;
                        String str8 = "activity found " + lastActivity.getPercentage() + " > " + dMax + " " + lastActivity.getIntervalsWithActivity() + " length " + ((Stage.Beginning) stage).getProgress();
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str8, null);
                        if (lastActivity.getPercentage() > dMax) {
                            Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": high activity - stopping tracking", null);
                            new SleepStarter().autoStopSleep(context, true, activityIntervals);
                            if (jCurrentTimeMillis <= expectedTrackingRange.getEnd() - Utils.getHoursInMillis(2)) {
                                AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                            } else {
                                AutoTrackingScheduler.schedule(context, Long.valueOf(expectedTrackingRange.getEnd() + Utils.getHoursInMillis(3)));
                            }
                        } else {
                            Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": weak activity - continue with tracking", null);
                            AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                        }
                    }
                } else if (stage instanceof Stage.CloseToEnd) {
                    double progress = ((double) (1.0f - ((Stage.CloseToEnd) stage).getProgress())) * 0.065d;
                    if (lastActivity.getPercentage() > progress) {
                        String str9 = "activity found count=" + lastActivity.getIntervalsWithActivity() + " percentage=" + lastActivity.getPercentage() + " progress=" + ((Stage.CloseToEnd) stage).getProgress() + " threshold=" + progress + " expectedTrackingRange.margin=" + expectedTrackingRange.getMargin() + " - tracking stop & save";
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str9, null);
                        new SleepStarter().autoStopSleep(context, false, activityIntervals);
                        AutoTrackingScheduler.schedule(context, Long.valueOf(expectedTrackingRange.getEnd() + Utils.getHoursInMillis(2)));
                    } else {
                        String str10 = "activity found =" + lastActivity.getIntervalsWithActivity() + " percentage=" + lastActivity.getPercentage() + " progress=" + ((Stage.CloseToEnd) stage).getProgress() + " threshold=" + progress + " expectedTrackingRange.margin=" + expectedTrackingRange.getMargin() + " - but continue tracking ";
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str10, null);
                        AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                    }
                } else {
                    if (!(stage instanceof Stage.Tracking)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    double percentage = ((Stage.Tracking) stage).getFullActivity().getPercentage();
                    String str11 = "allAwakeIntervals: " + ((Stage.Tracking) stage).getFullActivity().getAwakeIntervals().toString(true, 5);
                    Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str11, null);
                    if (percentage >= 0.5d) {
                        String str12 = "whole record has " + percentage + " activity - deleting tracking if not manually started";
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str12, null);
                        new SleepStarter().autoStopSleep(context, true, activityIntervals);
                    } else {
                        String str13 = "activity " + lastActivity.getIntervalsWithActivity() + " percentage=" + lastActivity.getPercentage() + " - anyway continue tracking ";
                        Logger.logInfo(Logger.defaultTag, autoTrackingProcessor2.getTag() + ": " + str13, null);
                    }
                    AutoTrackingScheduler.INSTANCE.scheduleNextAlarm(context, expectedTrackingRange, 15L);
                }
                function0.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                function0.invoke();
                throw th;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$context, this.$expectedTrackingRange, this.$doAfter, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<AutoTrackingProcessor> asyncContext, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AsyncContext asyncContext = (AsyncContext) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = this.$context;
                ActivityIntervals.Companion companion = ActivityIntervals.INSTANCE;
                ReentrantLock lock = companion.getLOCK();
                lock.lock();
                try {
                    File storageFile = companion.getStorageFile(context);
                    final ActivityIntervals activityIntervalsExport = companion.from(storageFile).export(storageFile);
                    lock.unlock();
                    final Stage stageDetect = Stage.INSTANCE.detect(this.$expectedTrackingRange, activityIntervalsExport);
                    List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(this.$expectedTrackingRange.getStart() - Utils.getHoursInMillis(1), this.$expectedTrackingRange.getEnd(), false);
                    sleepRecords.getClass();
                    Iterator<T> it = sleepRecords.iterator();
                    final int measurementLength = 0;
                    while (it.hasNext()) {
                        measurementLength += ((SleepRecord) it.next()).getMeasurementLength();
                    }
                    PowerManager powerManager = (PowerManager) this.$context.getSystemService("power");
                    final boolean zIsInteractive = powerManager != null ? powerManager.isInteractive() : false;
                    final ExpectedTrackingRange expectedTrackingRange = this.$expectedTrackingRange;
                    final Context context2 = this.$context;
                    final Function0<Unit> function0 = this.$doAfter;
                    Function1 function1 = new Function1() { // from class: com.urbandroid.sleep.autostart.AutoTrackingProcessor$processStages$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AutoTrackingProcessor.AnonymousClass2.invokeSuspend$lambda$1(stageDetect, expectedTrackingRange, context2, measurementLength, zIsInteractive, activityIntervalsExport, function0, (AutoTrackingProcessor) obj2);
                        }
                    };
                    this.L$0 = SpillingKt.nullOutSpilledVariable(asyncContext);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(activityIntervalsExport);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(stageDetect);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(sleepRecords);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(powerManager);
                    this.I$0 = measurementLength;
                    this.I$1 = zIsInteractive ? 1 : 0;
                    this.label = 1;
                    if (Utils.uiThread(asyncContext, function1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
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

    private AutoTrackingProcessor() {
    }

    public static final void addActivityAndProcessStages(Context context, long durationInMillis, ExpectedTrackingRange range, Function1<? super Stage, Boolean> stageFilter) {
        context.getClass();
        range.getClass();
        Utils.doAsyncThrowOnUI(INSTANCE, new AnonymousClass1(context, stageFilter, range, durationInMillis, null));
    }

    public static /* synthetic */ void addActivityAndProcessStages$default(Context context, long j, ExpectedTrackingRange expectedTrackingRange, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        addActivityAndProcessStages(context, j, expectedTrackingRange, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void processStages$default(AutoTrackingProcessor autoTrackingProcessor, Context context, ExpectedTrackingRange expectedTrackingRange, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Tool$$ExternalSyntheticLambda0(25);
        }
        autoTrackingProcessor.processStages(context, expectedTrackingRange, function0);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return tag;
    }

    public final void processStages(Context context, ExpectedTrackingRange expectedTrackingRange, Function0<Unit> doAfter) {
        context.getClass();
        expectedTrackingRange.getClass();
        doAfter.getClass();
        Utils.doAsyncThrowOnUI(this, new AnonymousClass2(context, expectedTrackingRange, doAfter, null));
    }

    public static final void addActivityAndProcessStages(Context context, long j, ExpectedTrackingRange expectedTrackingRange) {
        context.getClass();
        expectedTrackingRange.getClass();
        addActivityAndProcessStages$default(context, j, expectedTrackingRange, null, 8, null);
    }
}

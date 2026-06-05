package com.urbandroid.sleep.activityrecognition;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.DetectedActivity;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Hours;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 :2\u00020\u0001:\u0002;:B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001f\u0010 \u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0003¢\u0006\u0004\b \u0010%J!\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020\u00142\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b)\u0010*R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u00109\u001a\b\u0012\u0004\u0012\u000203028F¢\u0006\u0006\u001a\u0004\b8\u00107¨\u0006<"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlin/Function0;", "", "currentTime", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/urbandroid/common/Hours;", "keep", "cleanUp-iUqB2lg", "(JLkotlin/jvm/functions/Function0;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "cleanUp", "from", "to", "invert", "(JJ)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "", "size", "()I", "cumulativeTime", "", "isEmpty", "()Z", "Ljava/io/File;", ShareInternalUtility.STAGING_PARAM, "export", "(Ljava/io/File;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Ljava/io/OutputStream;", "os", "(Ljava/io/OutputStream;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Lcom/google/android/gms/location/ActivityTransitionEvent;", "transition", "add", "(Lcom/google/android/gms/location/ActivityTransitionEvent;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Lcom/google/android/gms/location/DetectedActivity;", "activity", "time", "(Lcom/google/android/gms/location/DetectedActivity;J)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "userFriendly", "takeLast", "", InAppPurchaseConstants.METHOD_TO_STRING, "(ZLjava/lang/Integer;)Ljava/lang/String;", "Lkotlin/jvm/functions/Function0;", "getCurrentTime", "()Lkotlin/jvm/functions/Function0;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "unsafeIntervals", "Ljava/util/List;", "getUnsafeIntervals", "()Ljava/util/List;", "getIntervals", "intervals", "Companion", "Interval", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ActivityIntervals implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock LOCK = new ReentrantLock();
    private final Function0<Long> currentTime;
    private final String tag;
    private final List<Interval> unsafeIntervals;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010\u0003\u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00188\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00188\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010%R\u0014\u0010+\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010%R\u0014\u0010,\u001a\u00020\u00188\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010%R\u0014\u0010.\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010/¨\u00061"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Companion;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Ljava/io/File;", "getStorageFile", "(Landroid/content/Context;)Ljava/io/File;", "", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "intervals", "Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "from", "(Ljava/util/List;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "Ljava/io/InputStream;", "input", "fromInputStream", "(Ljava/io/InputStream;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "(Ljava/io/File;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals;", "", "date", "", "is24HourFormat", "", "formatWithDay", "(JZ)Ljava/lang/String;", "previous", "format", "(JJZ)Ljava/lang/String;", "Ljava/util/concurrent/locks/ReentrantLock;", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "getLOCK", "()Ljava/util/concurrent/locks/ReentrantLock;", "getLOCK$annotations", "TAG", "Ljava/lang/String;", "EXPORT_FILE", "TIME_FORMAT_24", "TIME_FORMAT_12", "FULL_FORMAT", "DAY_TIME_FORMAT_24", "DAY_TIME_FORMAT_12", "DAY_TIME_SECOND_FORMAT", "", "MINIMAL_CONFIDENCE", "I", "BUFFER_SIZE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String format$default(Companion companion, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = -1;
            }
            long j3 = j2;
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.format(j, j3, z);
        }

        public final String format(long date, long previous, boolean is24HourFormat) {
            Context context = SharedApplicationContext.getInstance().getContext();
            if (date == -1) {
                return "-";
            }
            DateFormat hoursFormat = DateUtil.getHoursFormat(context);
            DateFormat shortDateLongerWeekInstanceWithoutYears = DateUtil.getShortDateLongerWeekInstanceWithoutYears(context);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(previous);
            if (previous == -1 || calendar.get(6) != calendar2.get(6)) {
                return FileInsert$$ExternalSyntheticOutline0.m$1(shortDateLongerWeekInstanceWithoutYears.format(calendar.getTime()), " ", hoursFormat.format(calendar.getTime()));
            }
            String str = hoursFormat.format(calendar.getTime());
            str.getClass();
            return str;
        }

        public final String formatWithDay(long date, boolean is24HourFormat) {
            return format(date, date - 172800000, is24HourFormat);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ActivityIntervals from(File input) {
            ActivityIntervals activityIntervals;
            input.getClass();
            ReentrantLock lock = getLOCK();
            lock.lock();
            try {
                Companion companion = ActivityIntervals.INSTANCE;
                final String str = "activity";
                final boolean z = false;
                FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.activityrecognition.ActivityIntervals$Companion$from$lambda$1$$inlined$featureLog$default$1
                    @Override // com.urbandroid.common.FeatureLogger
                    public String getTag() {
                        String str2 = str;
                        boolean z2 = z;
                        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                        String strConcat = "";
                        if (z2) {
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
                int i = 1;
                Function0 function0 = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                if (input.exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(input);
                        try {
                            ActivityIntervals activityIntervalsFromInputStream = ActivityIntervals.INSTANCE.fromInputStream(fileInputStream);
                            CloseableKt.closeFinally(fileInputStream, null);
                            activityIntervals = ActivityIntervals.m1162cleanUpiUqB2lg$default(activityIntervalsFromInputStream, 0L, null, 3, null);
                        } finally {
                        }
                    } catch (IOException e) {
                        String str2 = "corrupted file: " + input.getAbsolutePath() + " " + e;
                        Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": " + str2, null);
                        try {
                            input.delete();
                        } catch (Exception unused) {
                        }
                        activityIntervals = new ActivityIntervals(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
                    }
                } else {
                    String str3 = "not found file: " + input.getAbsolutePath();
                    Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": " + str3, null);
                    activityIntervals = new ActivityIntervals(function0, i, objArr3 == true ? 1 : 0);
                }
                lock.unlock();
                return activityIntervals;
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ActivityIntervals fromInputStream(InputStream input) {
            input.getClass();
            ActivityIntervals activityIntervals = new ActivityIntervals(null, 1, 0 == true ? 1 : 0);
            activityIntervals.getIntervals().clear();
            try {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(input);
                    while (true) {
                        activityIntervals.getIntervals().add(new Interval(objectInputStream.readLong(), objectInputStream.readLong()));
                    }
                } catch (Exception unused) {
                    return activityIntervals;
                }
            } catch (EOFException unused2) {
                input.close();
                return activityIntervals;
            } catch (Throwable th) {
                try {
                    input.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        }

        public final ReentrantLock getLOCK() {
            return ActivityIntervals.LOCK;
        }

        public final File getStorageFile(Context context) {
            context.getClass();
            return new File(context.getCacheDir(), "activity-recognition.dat");
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ActivityIntervals from(List<Interval> intervals) {
            intervals.getClass();
            ActivityIntervals activityIntervals = new ActivityIntervals(null, 1, 0 == true ? 1 : 0);
            activityIntervals.getIntervals().addAll(intervals);
            return activityIntervals;
        }
    }

    public ActivityIntervals(Function0<Long> function0) {
        function0.getClass();
        this.currentTime = function0;
        this.tag = "activity";
        this.unsafeIntervals = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: cleanUp-iUqB2lg$default, reason: not valid java name */
    public static /* synthetic */ ActivityIntervals m1162cleanUpiUqB2lg$default(ActivityIntervals activityIntervals, long j, Function0 function0, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: cleanUp-iUqB2lg");
            return null;
        }
        if ((i & 1) != 0) {
            j = Utils.getHours(48);
        }
        if ((i & 2) != 0) {
            function0 = new Tool$$ExternalSyntheticLambda0(21);
        }
        return activityIntervals.m1163cleanUpiUqB2lg(j, function0);
    }

    public static /* synthetic */ String toString$default(ActivityIntervals activityIntervals, boolean z, Integer num, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: toString");
            return null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        return activityIntervals.toString(z, num);
    }

    public final ActivityIntervals add(DetectedActivity activity, long time) {
        Integer num;
        Object next;
        Pair<Interval, Interval> pairSplitBy;
        Object next2;
        activity.getClass();
        int i = 0;
        boolean z = activity.getType() == 3;
        if (activity.getConfidence() >= 75) {
            Iterator<T> it = getIntervals().iterator();
            while (true) {
                num = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Interval) next).contains(time)) {
                    break;
                }
            }
            Interval interval = (Interval) next;
            if (interval == null) {
                if (!z) {
                    Interval interval2 = (Interval) CollectionsKt.lastOrNull((List) getIntervals());
                    long to = interval2 != null ? interval2.getTo() : -1L;
                    if (to != -1 && time > to && (time - to) / 60000 >= 1) {
                        getIntervals().add(new Interval(time - 60000, time));
                        return this;
                    }
                    if (Experiments.getInstance().isOurExperimentalPhone()) {
                        String str = "Discarding " + activity + " since no interval found containing " + Companion.format$default(INSTANCE, time, 0L, false, 6, null) + " \n " + toString(true, 4);
                        Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
                        return this;
                    }
                } else {
                    if (getIntervals().isEmpty() || (((Interval) CollectionsKt.last((List) getIntervals())).isClosed() && ((Interval) CollectionsKt.last((List) getIntervals())).getTo() < time)) {
                        getIntervals().add(new Interval(time, 0L, 2, null));
                        return this;
                    }
                    Iterator<T> it2 = getIntervals().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        if (((Interval) next2).getFrom() > time) {
                            break;
                        }
                    }
                    Interval interval3 = (Interval) next2;
                    if (!getIntervals().isEmpty() && interval3 != null) {
                        List<Interval> intervals = getIntervals();
                        Interval intervalCopy$default = Interval.copy$default(interval3, time, 0L, 2, null);
                        Iterator<Integer> it3 = CollectionsKt.getIndices(getIntervals()).iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            Integer next3 = it3.next();
                            if (Intrinsics.areEqual(getIntervals().get(next3.intValue()), interval3)) {
                                num = next3;
                                break;
                            }
                        }
                        Integer num2 = num;
                        if (num2 != null) {
                            intervals.remove(num2.intValue());
                            intervals.add(num2.intValue(), intervalCopy$default);
                            return this;
                        }
                    }
                }
            } else if (interval.isOpen()) {
                if (!z) {
                    getIntervals().remove(interval);
                    getIntervals().add(Interval.copy$default(interval, 0L, time, 1, null));
                    return this;
                }
            } else if (!z) {
                Iterator<Interval> it4 = getIntervals().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(it4.next(), interval)) {
                        break;
                    }
                    i++;
                }
                if (i != -1 && (pairSplitBy = interval.splitBy(time)) != null) {
                    List<Interval> intervals2 = getIntervals();
                    intervals2.remove(i);
                    intervals2.add(i, pairSplitBy.getFirst());
                    intervals2.add(i + 1, pairSplitBy.getSecond());
                }
            } else if (((Interval) CollectionsKt.last((List) getIntervals())).isClosed() && ((Interval) CollectionsKt.last((List) getIntervals())).getTo() < time) {
                getIntervals().add(new Interval(time, 0L, 2, null));
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: cleanUp-iUqB2lg, reason: not valid java name */
    public final ActivityIntervals m1163cleanUpiUqB2lg(long keep, Function0<Long> currentTime) {
        currentTime.getClass();
        try {
            long jLongValue = currentTime.invoke().longValue() - Hours.m967getMillisimpl(keep);
            long jLongValue2 = currentTime.invoke().longValue() + Hours.m967getMillisimpl(Utils.getHours(2));
            Iterator<Interval> it = getIntervals().iterator();
            while (it.hasNext()) {
                Interval next = it.next();
                long from = next.getFrom();
                long to = next.getTo();
                if ((from < jLongValue && to < jLongValue) || from > jLongValue2) {
                    it.remove();
                }
            }
            return this;
        } catch (Exception e) {
            Logger.logSevere(e);
            return this;
        }
    }

    public final int cumulativeTime() {
        List<Interval> intervals = getIntervals();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intervals, 10));
        for (Interval intervalCopy$default : intervals) {
            if (intervalCopy$default.isOpen()) {
                intervalCopy$default = Interval.copy$default(intervalCopy$default, 0L, System.currentTimeMillis(), 1, null);
            }
            arrayList.add(intervalCopy$default);
        }
        Iterator it = arrayList.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += (int) ((Interval) it.next()).length(TimeUnit.MILLISECONDS);
        }
        return length;
    }

    public final ActivityIntervals export(OutputStream os) {
        os.getClass();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
                try {
                    for (Interval interval : getIntervals()) {
                        objectOutputStream.writeLong(interval.getFrom());
                        objectOutputStream.writeLong(interval.getTo());
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(objectOutputStream, null);
                } finally {
                }
            } catch (Exception e) {
                Logger.logWarning(Logger.defaultTag, getTag() + ": export failure", e);
            }
            return this;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final List<Interval> getIntervals() {
        List<Interval> list = this.unsafeIntervals;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        final String str = "activity";
        final boolean z = false;
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.activityrecognition.ActivityIntervals$_get_intervals_$lambda$0$$inlined$featureLog$default$1
            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                String str2 = str;
                boolean z2 = z;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                String strConcat = "";
                if (z2) {
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
        String str2 = "!!!!!!!! safeInterval is " + this.unsafeIntervals;
        Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + str2, null);
        return arrayList;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.urbandroid.sleep.activityrecognition.ActivityIntervals$Companion] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final ActivityIntervals invert(long from, long to) {
        ?? ListOf;
        if (getIntervals().isEmpty()) {
            return INSTANCE.from(CollectionsKt.emptyList());
        }
        List<Interval> intervals = (!((Interval) CollectionsKt.last((List) getIntervals())).isClosed() || ((Interval) CollectionsKt.last((List) getIntervals())).getTo() >= to) ? getIntervals() : CollectionsKt.plus((Collection<? extends Interval>) getIntervals(), new Interval(to, to));
        ArrayList arrayList = new ArrayList();
        for (Object obj : intervals) {
            Interval interval = (Interval) obj;
            if (interval.contains(from) || interval.contains(to) || (from < interval.getFrom() && to > interval.getTo())) {
                arrayList.add(obj);
            }
        }
        ?? r5 = INSTANCE;
        if (arrayList.isEmpty() || (((Interval) CollectionsKt.first((List) arrayList)).getFrom() == to && ((Interval) CollectionsKt.first((List) arrayList)).getTo() == to)) {
            ListOf = CollectionsKt.listOf(new Interval(from, to));
        } else {
            List listWindowed$default = CollectionsKt___CollectionsKt.windowed$default(arrayList, 2, 1, false, 4, null);
            ArrayList<List> arrayList2 = new ArrayList();
            for (Object obj2 : listWindowed$default) {
                if (((List) obj2).size() == 2) {
                    arrayList2.add(obj2);
                }
            }
            ListOf = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (List list : arrayList2) {
                ListOf.add(new Interval(((Interval) list.get(0)).getTo(), ((Interval) list.get(1)).getFrom()));
            }
        }
        return r5.from(ListOf);
    }

    public final boolean isEmpty() {
        return getIntervals().isEmpty();
    }

    public final int size() {
        return getIntervals().size();
    }

    public final String toString(boolean userFriendly, Integer takeLast) {
        List<Interval> intervals;
        StringBuilder sb = new StringBuilder();
        if (takeLast == null || (intervals = CollectionsKt.takeLast(getIntervals(), takeLast.intValue())) == null) {
            intervals = getIntervals();
        }
        long to = -1;
        for (Interval interval : intervals) {
            if (userFriendly) {
                Companion companion = INSTANCE;
                sb.append(FileInsert$$ExternalSyntheticOutline0.m("[", Companion.format$default(companion, interval.getFrom(), to, false, 4, null), ",", Companion.format$default(companion, interval.getTo(), interval.getFrom(), false, 4, null), "]"));
                to = interval.getTo();
            } else {
                long from = interval.getFrom();
                long to2 = interval.getTo();
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("[", ",", from);
                sbM.append(to2);
                sbM.append("]");
                sb.append(sbM.toString());
            }
        }
        return sb.toString();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J$\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010 \u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0019R\u0011\u0010%\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b'\u0010&¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "", "", "from", "to", "<init>", "(JJ)V", "Ljava/util/concurrent/TimeUnit;", "unit", "length", "(Ljava/util/concurrent/TimeUnit;)J", "other", "intersection", "(Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "time", "", "contains", "(J)Z", "Lkotlin/Pair;", "splitBy", "(J)Lkotlin/Pair;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "component1", "()J", "component2", "copy", "(JJ)Lcom/urbandroid/sleep/activityrecognition/ActivityIntervals$Interval;", "", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "J", "getFrom", "getTo", "isOpen", "()Z", "isClosed", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Interval {
        private final long from;
        private final long to;

        public /* synthetic */ Interval(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? -1L : j2);
        }

        public static /* synthetic */ Interval copy$default(Interval interval, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = interval.from;
            }
            if ((i & 2) != 0) {
                j2 = interval.to;
            }
            return interval.copy(j, j2);
        }

        public static /* synthetic */ long length$default(Interval interval, TimeUnit timeUnit, int i, Object obj) {
            if ((i & 1) != 0) {
                timeUnit = TimeUnit.HOURS;
            }
            return interval.length(timeUnit);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTo() {
            return this.to;
        }

        public final boolean contains(long time) {
            long j = this.to;
            long j2 = this.from;
            return j == -1 ? time >= j2 : time <= j && j2 <= time;
        }

        public final Interval copy(long from, long to) {
            return new Interval(from, to);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) other;
            return this.from == interval.from && this.to == interval.to;
        }

        public final long getFrom() {
            return this.from;
        }

        public final long getTo() {
            return this.to;
        }

        public int hashCode() {
            return Long.hashCode(this.to) + (Long.hashCode(this.from) * 31);
        }

        public final Interval intersection(Interval other) {
            other.getClass();
            long j = this.from;
            long j2 = other.from;
            if (j >= j2 && this.to <= other.to) {
                return this;
            }
            if (j2 >= j && other.to <= this.to) {
                return other;
            }
            if (j >= j2) {
                long j3 = other.to;
                if (j <= j3) {
                    return new Interval(j, j3);
                }
            }
            long j4 = this.to;
            if (j > j2 || j2 > j4) {
                return null;
            }
            return new Interval(j2, j4);
        }

        public final boolean isClosed() {
            return !isOpen();
        }

        public final boolean isOpen() {
            return this.to == -1;
        }

        public final long length(TimeUnit unit) {
            unit.getClass();
            return unit.convert(this.to - this.from, TimeUnit.MILLISECONDS);
        }

        public final Pair<Interval, Interval> splitBy(long time) {
            if (contains(time)) {
                return TuplesKt.to(new Interval(this.from, time), new Interval(time + 1, this.to));
            }
            return null;
        }

        public String toString() {
            Companion companion = ActivityIntervals.INSTANCE;
            return FileInsert$$ExternalSyntheticOutline0.m("[", Companion.format$default(companion, this.from, -1L, false, 4, null), ",", Companion.format$default(companion, this.to, this.from, false, 4, null), "]");
        }

        public Interval(long j, long j2) {
            this.from = j;
            this.to = j2;
        }
    }

    public /* synthetic */ ActivityIntervals(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Tool$$ExternalSyntheticLambda0(20) : function0);
    }

    public final ActivityIntervals export(File file) {
        file.getClass();
        return m1162cleanUpiUqB2lg$default(this, 0L, null, 3, null).export(new FileOutputStream(file));
    }

    public final ActivityIntervals add(ActivityTransitionEvent transition) {
        DetectedActivity detectedActivity;
        ActivityIntervals activityIntervalsAdd;
        transition.getClass();
        if (ActivitityrecognitionKt.isEnter(transition)) {
            detectedActivity = new DetectedActivity(transition.getActivityType(), 100);
        } else if (!ActivitityrecognitionKt.isExit(transition)) {
            String str = Logger.defaultTag;
            Logger.logWarning(str, getTag() + ": " + ("invalid state for transition type " + transition), null);
            detectedActivity = null;
        } else if (transition.getActivityType() == 3) {
            detectedActivity = new DetectedActivity(5, 100);
        } else {
            detectedActivity = new DetectedActivity(3, 100);
        }
        return (detectedActivity == null || (activityIntervalsAdd = add(detectedActivity, ActivitityrecognitionKt.getTimestamp(transition))) == null) ? this : activityIntervalsAdd;
    }
}

package com.urbandroid.sleep.activityrecognition.calculator;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Build;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Millis;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeOverlapCalculator;", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator;", "Lcom/urbandroid/common/FeatureLogger;", "active", "", "maxOverlapSleepLengthInHours", "", "recordProvider", "Lkotlin/Function0;", "", "Lcom/urbandroid/sleep/domain/interval/Interval;", "<init>", "(ZILkotlin/jvm/functions/Function0;)V", "tag", "", "getTag", "()Ljava/lang/String;", "estimate", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeOverlapCalculator implements SleepTimeCalculator, FeatureLogger {
    private final boolean active;
    private final int maxOverlapSleepLengthInHours;
    private final Function0<List<Interval>> recordProvider;
    private final String tag;

    public /* synthetic */ SleepTimeOverlapCalculator(boolean z, int i, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 4 : i, (i2 & 4) != 0 ? new Tool$$ExternalSyntheticLambda0(24) : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _init_$lambda$0() {
        final boolean z = false;
        List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(0, 4, false);
        final String str = "activity:estimate";
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.activityrecognition.calculator.SleepTimeOverlapCalculator$_init_$lambda$0$0$$inlined$featureLog$default$1
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
        String str2 = Logger.defaultTag;
        Logger.logDebug(str2, featureLogger.getTag() + ": " + ("SleepTimeOverlapCalculator: last records: " + sleepRecords), null);
        sleepRecords.getClass();
        ArrayList<SleepRecord> arrayList = new ArrayList();
        for (Object obj : sleepRecords) {
            SleepRecord sleepRecord = (SleepRecord) obj;
            if (sleepRecord.getFrom() != null && sleepRecord.getTo() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (SleepRecord sleepRecord2 : arrayList) {
            Date to = sleepRecord2.getTo();
            Interval interval = to != null ? new Interval(sleepRecord2.getFrom().getTime(), to.getTime()) : null;
            if (interval != null) {
                arrayList2.add(interval);
            }
        }
        return arrayList2;
    }

    public SleepTimeCalculator.Estimate estimate(SleepTimeCalculator.Estimate estimate) {
        Object next;
        estimate.getClass();
        if (!this.active) {
            return estimate;
        }
        Interval interval = new Interval(estimate.getFrom().getTimeInMillis(), estimate.getTo().getTimeInMillis());
        List<Interval> listInvoke = this.recordProvider.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listInvoke) {
            if (interval.hasIntersection((Interval) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            String str = Logger.defaultTag;
            Logger.logInfo(str, getTag() + ": " + ("SleepTimeOverlapCalculator: good - no overlap records for " + estimate), null);
            return estimate;
        }
        if (arrayList.size() > 1) {
            String str2 = "SleepTimeOverlapCalculator: found " + arrayList.size() + " overlap records " + arrayList;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
            return null;
        }
        Interval interval2 = (Interval) CollectionsKt.first((List) arrayList);
        long length = interval2.getLength() / 3600000;
        if (length >= this.maxOverlapSleepLengthInHours) {
            String strM = zzba$$ExternalSyntheticOutline0.m("SleepTimeOverlapCalculator: Overlap record too long ", " - no estimate suggested", length);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            return null;
        }
        Interval intersection = interval2.getIntersection(estimate.toInterval());
        String str3 = "SleepTimeOverlapCalculator: overlapInterval=" + interval2 + " intersection=" + intersection + " lenInMinutes=" + Millis.m976getMinutesimpl(Utils.getMillis(intersection.getLength()));
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + str3, null);
        if (Millis.m975getHoursimpl(Utils.getMillis(intersection.getLength())) > 2) {
            return null;
        }
        Collection<Interval> collectionSubtract = estimate.toInterval().subtract(interval2);
        collectionSubtract.getClass();
        Iterator<T> it = collectionSubtract.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long length2 = ((Interval) next).getLength();
                do {
                    Object next2 = it.next();
                    long length3 = ((Interval) next2).getLength();
                    if (length2 < length3) {
                        next = next2;
                        length2 = length3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Interval interval3 = (Interval) next;
        if (interval3 == null) {
            return null;
        }
        String str4 = Logger.defaultTag;
        Logger.logInfo(str4, getTag() + ": " + ("SleepTimeOverlapCalculator: cutout=" + interval3), null);
        if (Millis.m975getHoursimpl(Utils.getMillis(interval3.getLength())) >= 2) {
            return SleepTimeCalculator.Estimate.copy$default(estimate, null, Utils.getCalendar(interval3.getFrom()), Utils.getCalendar(interval3.getTo()), null, 9, null);
        }
        return null;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SleepTimeOverlapCalculator(boolean z, int i, Function0<? extends List<? extends Interval>> function0) {
        function0.getClass();
        this.active = z;
        this.maxOverlapSleepLengthInHours = i;
        this.recordProvider = function0;
        this.tag = "activity:estimate";
    }
}

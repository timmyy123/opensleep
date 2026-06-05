package com.urbandroid.sleep.sensor.extra;

import android.os.Build;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "add", "", SDKConstants.PARAM_VALUE, "", "timestamp", "", "Buffered", "SingleValue", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$Buffered;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$SingleValue;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ExtraDataCollector implements FeatureLogger {
    private final String tag;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$Buffered;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "<init>", "()V", "data", "", "Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "needsSort", "", "add", "", SDKConstants.PARAM_VALUE, "", "timestamp", "", "consume", "", "till", "(Ljava/lang/Long;)Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Buffered extends ExtraDataCollector {
        private final List<ExtraValue> data;
        private boolean needsSort;

        public Buffered() {
            super(null);
            this.data = new ArrayList();
        }

        public static /* synthetic */ List consume$default(Buffered buffered, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            return buffered.consume(l);
        }

        @Override // com.urbandroid.sleep.sensor.extra.ExtraDataCollector
        public void add(float value, long timestamp) {
            synchronized (this.data) {
                this.data.add(new ExtraValue(value, timestamp));
                this.needsSort = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final List<ExtraValue> consume(Long till) {
            synchronized (this.data) {
                if (this.data.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if (this.needsSort) {
                    List<ExtraValue> list = this.data;
                    if (list.size() > 1) {
                        CollectionsKt.sortWith(list, new Comparator() { // from class: com.urbandroid.sleep.sensor.extra.ExtraDataCollector$Buffered$consume$lambda$0$$inlined$sortBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(Long.valueOf(((ExtraValue) t).getTimestamp()), Long.valueOf(((ExtraValue) t2).getTimestamp()));
                            }
                        });
                    }
                    this.needsSort = false;
                }
                List<ExtraValue> list2 = this.data;
                if (till == null) {
                    List<ExtraValue> list3 = CollectionsKt.toList(list2);
                    this.data.clear();
                    return list3;
                }
                if (((ExtraValue) CollectionsKt.first((List) list2)).getTimestamp() > till.longValue()) {
                    return CollectionsKt.emptyList();
                }
                List<ExtraValue> list4 = this.data;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list4) {
                    if (((ExtraValue) obj).getTimestamp() <= till.longValue()) {
                        arrayList.add(obj);
                    } else {
                        arrayList2.add(obj);
                    }
                }
                Pair pair = new Pair(arrayList, arrayList2);
                List<ExtraValue> list5 = this.data;
                list5.clear();
                list5.addAll((Collection) pair.getSecond());
                return (List) pair.getFirst();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$SingleValue;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "", "minValue", "<init>", "(F)V", SDKConstants.PARAM_VALUE, "", "timestamp", "", "add", "(FJ)V", "consume", "()F", "F", "getMinValue", "data", "J", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SingleValue extends ExtraDataCollector {
        private float data;
        private final float minValue;
        private long timestamp;

        public SingleValue(float f) {
            super(null);
            this.minValue = f;
            this.data = -1.0f;
            this.timestamp = -1L;
        }

        @Override // com.urbandroid.sleep.sensor.extra.ExtraDataCollector
        public synchronized void add(float value, long timestamp) {
            if (value >= this.minValue) {
                long j = this.timestamp;
                if (j == -1 || j <= timestamp) {
                    this.data = value;
                    this.timestamp = timestamp;
                }
            }
        }

        public final synchronized float consume() {
            return this.data;
        }
    }

    private ExtraDataCollector() {
        StringBuilder sb = new StringBuilder("DataCollector");
        String strConcat = null;
        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
        if (strM != null) {
            strConcat = StringsKt.isBlank(strM) ? "" : ":".concat(strM);
        }
        sb.append(strConcat);
        this.tag = sb.toString();
    }

    public abstract void add(float value, long timestamp);

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public /* synthetic */ ExtraDataCollector(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

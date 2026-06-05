package com.urbandroid.sleep.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.getpebble.android.kit.Constants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.merger.SameDateMerger;
import com.urbandroid.sleep.addon.stats.model.merger.ShortGapMerger;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B3\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJK\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u001fJ\u0017\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0017¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\u001fJ\u0015\u0010*\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u001fJ\u0015\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\u001fR\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/urbandroid/sleep/gui/view/PieView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "layout", Constants.CUST_ICON, "", SDKConstants.PARAM_VALUE, "secondValue", "desc", "", "progress", "", "white", "fill", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;FZ)Lcom/urbandroid/sleep/gui/view/PieView;", "", "setThemeWhite", "(Z)V", "setValue", "(Ljava/lang/String;)Lcom/urbandroid/sleep/gui/view/PieView;", "setSecondValue", "color", "setSecondValueColor", "(I)Lcom/urbandroid/sleep/gui/view/PieView;", "colorRes", "setValueColorRes", "descRes", "setDesc", "(Ljava/lang/Integer;)Lcom/urbandroid/sleep/gui/view/PieView;", "hideDesc", "()V", "setProgress", "(F)Lcom/urbandroid/sleep/gui/view/PieView;", "setColorRes", "setValueColor", "res", "setIcon", "Landroid/view/View;", "root", "Landroid/view/View;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PieView extends RelativeLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View root;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ{\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0082\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b \u0010!Jn\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\"2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b#\u0010$Jn\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\"2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0087@¢\u0006\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/gui/view/PieView$Companion;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/View;", "v", "", "chartTitle", "", "addChartLink", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V", "", "layout", "Lcom/urbandroid/sleep/domain/SleepRecord;", "record", "", "records", "Lcom/urbandroid/sleep/addon/stats/SleepScore$ScoreMeasure;", "measures", "max", "shrinkAfter", "", "themeWhite", "scorePieLayout", "Lcom/urbandroid/sleep/addon/stats/SleepScore;", "score", "Lcom/urbandroid/sleep/gui/view/PieView;", "getViewsForSleepRecord", "(ILandroid/content/Context;Lcom/urbandroid/sleep/domain/SleepRecord;Ljava/util/List;Ljava/util/List;IIZILcom/urbandroid/sleep/addon/stats/SleepScore;)Ljava/util/List;", "recordsForRegularity", "viewsForSleepRecord", "(ILandroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIZILcom/urbandroid/sleep/addon/stats/SleepScore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;", "viewsForStatRecord", "(ILandroid/content/Context;Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;Ljava/util/List;IIZILcom/urbandroid/sleep/addon/stats/SleepScore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getViewsForStatRecord", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ List getViewsForSleepRecord$default(Companion companion, int i, Context context, SleepRecord sleepRecord, List list, List list2, int i2, int i3, boolean z, int i4, SleepScore sleepScore, int i5, Object obj) {
            if ((i5 & 32) != 0) {
                i2 = -1;
            }
            if ((i5 & 64) != 0) {
                i3 = -1;
            }
            if ((i5 & 128) != 0) {
                z = false;
            }
            if ((i5 & 256) != 0) {
                i4 = -1;
            }
            if ((i5 & 512) != 0) {
                sleepScore = new SleepScore();
            }
            return companion.getViewsForSleepRecord(i, context, sleepRecord, list, list2, i2, i3, z, i4, sleepScore);
        }

        public static /* synthetic */ Object viewsForSleepRecord$default(Companion companion, int i, Context context, List list, List list2, List list3, int i2, int i3, boolean z, int i4, SleepScore sleepScore, Continuation continuation, int i5, Object obj) {
            if ((i5 & 32) != 0) {
                i2 = -1;
            }
            if ((i5 & 64) != 0) {
                i3 = -1;
            }
            if ((i5 & 128) != 0) {
                z = false;
            }
            if ((i5 & 256) != 0) {
                i4 = -1;
            }
            if ((i5 & 512) != 0) {
                sleepScore = new SleepScore();
            }
            return companion.viewsForSleepRecord(i, context, list, list2, list3, i2, i3, z, i4, sleepScore, continuation);
        }

        public static /* synthetic */ Object viewsForStatRecord$default(Companion companion, int i, Context context, IMeasureRecord iMeasureRecord, List list, int i2, int i3, boolean z, int i4, SleepScore sleepScore, Continuation continuation, int i5, Object obj) {
            if ((i5 & 16) != 0) {
                i2 = -1;
            }
            if ((i5 & 32) != 0) {
                i3 = -1;
            }
            if ((i5 & 64) != 0) {
                z = false;
            }
            if ((i5 & 128) != 0) {
                i4 = -1;
            }
            if ((i5 & 256) != 0) {
                sleepScore = new SleepScore();
            }
            return companion.viewsForStatRecord(i, context, iMeasureRecord, list, i2, i3, z, i4, sleepScore, continuation);
        }

        public final void addChartLink(Context context, View v, String chartTitle) {
            context.getClass();
            v.getClass();
            chartTitle.getClass();
            v.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(context, chartTitle, 20));
        }

        public final List<PieView> getViewsForSleepRecord(int layout, Context context, SleepRecord record, List<? extends SleepRecord> records, List<? extends SleepScore.ScoreMeasure> measures, int max, int shrinkAfter, boolean themeWhite, int scorePieLayout, SleepScore score) {
            context.getClass();
            record.getClass();
            records.getClass();
            measures.getClass();
            score.getClass();
            List<? extends SleepRecord> list = records;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(StatRecord.fromSleepRecord((SleepRecord) it.next()));
            }
            List<StatRecord> listMerge = new SameDateMerger().merge(new ShortGapMerger().merge(arrayList));
            if (listMerge.size() > 0) {
                for (StatRecord statRecord : listMerge) {
                    if (DateUtil.isSameDate(statRecord.getToDate(), record.getTo())) {
                        new SleepRegularityIndexUtil2(records).fillSleepRegularityIndex(statRecord);
                        return (List) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new PieView$Companion$getViewsForSleepRecord$1$1(layout, context, statRecord, measures, max, shrinkAfter, themeWhite, scorePieLayout, score, null), 1, null);
                    }
                }
            }
            return CollectionsKt.emptyList();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:17|(2:143|19)(1:23)|20|138|24|25|(4:42|(2:44|(1:46))|41|116)(3:(2:28|(2:30|(2:32|(2:35|(1:37)))))|41|116)|113|15|(3:117|(6:141|119|(1:121)(1:122)|123|(2:(1:126)(1:127)|128)(1:131)|140)|(2:135|136)(1:137))(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x02b9, code lost:
        
            if (r0 == com.urbandroid.sleep.addon.stats.SleepScore.ScoreMeasure.RATING) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x02bb, code lost:
        
            r9.progressFloat();
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x02be, code lost:
        
            if (r38 == 0) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x02c0, code lost:
        
            r14.hideDesc();
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x02c5, code lost:
        
            if (r13 > r6) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x02c7, code lost:
        
            r22.add(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x02ca, code lost:
        
            r12.L$0 = r10;
            r12.L$1 = r5;
            r12.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r44);
            r12.L$3 = r11;
            r12.L$4 = r23;
            r12.L$5 = r22;
            r12.L$6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17);
            r9 = r16;
            r12.L$7 = r9;
            r12.L$8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0);
            r12.L$9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26);
            r12.L$10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3);
            r12.L$11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21);
            r12.L$12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27);
            r12.L$13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9);
            r12.L$14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14);
            r12.I$0 = r2;
            r12.I$1 = r6;
            r12.I$2 = r8;
            r12.Z$0 = r43;
            r14 = r25;
            r12.I$3 = r14;
            r12.Z$1 = r24;
            r12.I$4 = r13;
            r16 = r8;
            r12.D$0 = r33;
            r12.I$5 = r38;
            r12.I$6 = r3;
            r12.I$7 = com.urbandroid.sleep.R.color.negative_light;
            r3 = 1;
            r12.label = 1;
            r7 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x033c, code lost:
        
            if (kotlinx.coroutines.YieldKt.yield(r12) != r7) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x033e, code lost:
        
            return r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x033f, code lost:
        
            r0 = r13;
            r13 = r22;
            r1 = r11;
            r11 = r16;
            r16 = r9;
            r9 = r43;
            r15 = r23;
            r4 = r0;
            r0 = r44;
            r8 = r24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x035f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x0360, code lost:
        
            r15 = r43;
            r24 = r7;
            r14 = r10;
            r9 = r16;
            r7 = r20;
            r1 = r22;
            r10 = r4;
            r16 = r8;
            r4 = r23;
            com.urbandroid.common.logging.Logger.logSevere(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0186, code lost:
        
            if (r14 <= 100.0d) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x01b1, code lost:
        
            if (java.lang.Double.isInfinite(r14) == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x01b4, code lost:
        
            if (r8 == (-1)) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x01b8, code lost:
        
            if (r13 <= (r8 - 1)) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x01ba, code lost:
        
            r7 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01bc, code lost:
        
            r7 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x01bd, code lost:
        
            r10 = r9.getValuePresentation(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x01c1, code lost:
        
            if (r0 != r4) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x01c3, code lost:
        
            if (r21 == 0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x01c5, code lost:
        
            r26 = r9;
            r27 = r10;
            r9 = (float) r21.doubleValue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x01ce, code lost:
        
            r9 = r11.updateMeasure(r0, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x01d3, code lost:
        
            r26 = r9;
            r27 = r10;
            r9 = (float) r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x01d9, code lost:
        
            r10 = new com.urbandroid.sleep.gui.view.PieView(r37, null, 0, 0, 14, null);
            r10 = r37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x01f8, code lost:
        
            if (r7 == 0) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x01fa, code lost:
        
            r29 = com.urbandroid.sleep.R.layout.view_pie_small;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x01fe, code lost:
        
            r29 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0200, code lost:
        
            if (r43 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0202, code lost:
        
            r30 = r0.getIconWhite();
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0207, code lost:
        
            r30 = r0.getIcon();
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x020b, code lost:
        
            r27.getClass();
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x020e, code lost:
        
            if (r3 == null) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0210, code lost:
        
            if (r21 == 0) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0212, code lost:
        
            r31 = r21.doubleValue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0216, code lost:
        
            r33 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x021b, code lost:
        
            r31 = 0.0d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x021e, code lost:
        
            r14 = r3.getValuePresentation(r31);
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0223, code lost:
        
            r33 = r14;
            r14 = r45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0227, code lost:
        
            r14 = r10.fill(r29, r30, r27, r14, null, r9.progressFloat(), r43);
            r14.setTag(r0.name());
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0249, code lost:
        
            switch(r2) {
                case 2131558964: goto L78;
                case 2131558965: goto L78;
                case 2131558966: goto L82;
                case 2131558967: goto L78;
                default: goto L82;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x024d, code lost:
        
            r14.setDesc(kotlin.coroutines.jvm.internal.Boxing.boxInt(r0.getLabel()));
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x025a, code lost:
        
            if (r0 != com.urbandroid.sleep.addon.stats.SleepScore.ScoreMeasure.DURATION) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x025c, code lost:
        
            r3 = r3.getMeasureName();
            r3.getClass();
            r1.addChartLink(r10, r14, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0267, code lost:
        
            r3 = r26.getMeasureName();
            r3.getClass();
            r1.addChartLink(r10, r14, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0271, code lost:
        
            if (r24 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0273, code lost:
        
            r19 = r0.getColorScore();
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0277, code lost:
        
            if (r43 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0279, code lost:
        
            if (r24 == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x027b, code lost:
        
            r18 = r0.getColorScore();
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x027f, code lost:
        
            r3 = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0282, code lost:
        
            r3 = r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0284, code lost:
        
            r1 = r9.color;
            r38 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x028f, code lost:
        
            if (r1 != com.urbandroid.sleep.addon.stats.SleepScore.ScoreResult.Type.POSITIVE) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0291, code lost:
        
            r14.setValueColorRes(r3);
            r14.setColorRes(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x029a, code lost:
        
            if (r1 != com.urbandroid.sleep.addon.stats.SleepScore.ScoreResult.Type.NEGATIVE) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x029c, code lost:
        
            r14.setValueColorRes(com.urbandroid.sleep.R.color.negative_light);
            r14.setColorRes(com.urbandroid.sleep.R.color.negative_light);
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x02a3, code lost:
        
            r14.setColorRes(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x02a6, code lost:
        
            if (r43 == false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x02a8, code lost:
        
            r14.setValueColorRes(com.urbandroid.sleep.R.color.white);
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x02af, code lost:
        
            r14.setValueColorRes(com.urbandroid.sleep.R.color.primary);
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x02b5, code lost:
        
            if (r0 == r4) goto L103;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0381  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x033f -> B:112:0x034d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0374 -> B:113:0x035b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getViewsForStatRecord(int i, Context context, IMeasureRecord iMeasureRecord, List<? extends SleepScore.ScoreMeasure> list, int i2, int i3, boolean z, int i4, SleepScore sleepScore, Continuation<? super List<? extends PieView>> continuation) {
            PieView$Companion$getViewsForStatRecord$1 pieView$Companion$getViewsForStatRecord$1;
            String str;
            int i5;
            Settings settings;
            PieView$Companion$getViewsForStatRecord$1 pieView$Companion$getViewsForStatRecord$12;
            List list2;
            SleepScore sleepScore2;
            List<? extends SleepScore.ScoreMeasure> list3;
            List<SleepScore.ScoreMeasure> list4;
            Iterator<SleepScore.ScoreMeasure> it;
            int i6;
            int i7;
            IMeasureRecord iMeasureRecord2;
            int i8;
            int i9;
            boolean z2;
            boolean z3;
            Context context2;
            boolean zHasNext;
            boolean z4;
            List list5;
            Iterator<SleepScore.ScoreMeasure> it2;
            Object obj;
            int i10;
            int i11;
            Context context3;
            Settings settings2;
            boolean z5;
            Double dBoxDouble;
            Companion companion = this;
            if (continuation instanceof PieView$Companion$getViewsForStatRecord$1) {
                pieView$Companion$getViewsForStatRecord$1 = (PieView$Companion$getViewsForStatRecord$1) continuation;
                int i12 = pieView$Companion$getViewsForStatRecord$1.label;
                if ((i12 & Integer.MIN_VALUE) != 0) {
                    pieView$Companion$getViewsForStatRecord$1.label = i12 - Integer.MIN_VALUE;
                } else {
                    pieView$Companion$getViewsForStatRecord$1 = new PieView$Companion$getViewsForStatRecord$1(companion, continuation);
                }
            }
            Object obj2 = pieView$Companion$getViewsForStatRecord$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i13 = pieView$Companion$getViewsForStatRecord$1.label;
            if (i13 == 0) {
                str = null;
                ResultKt.throwOnFailure(obj2);
                Settings settings3 = ContextExtKt.getSettings(context);
                boolean zIsSleepScoreColored = settings3.isSleepScoreColored();
                sleepScore.setAge(settings3.getAge());
                ArrayList arrayList = new ArrayList();
                List<SleepScore.ScoreMeasure> listOrderMeasures = settings3.orderMeasures((List<SleepScore.ScoreMeasure>) list);
                i5 = i4;
                settings = settings3;
                pieView$Companion$getViewsForStatRecord$12 = pieView$Companion$getViewsForStatRecord$1;
                list2 = arrayList;
                sleepScore2 = sleepScore;
                list3 = list;
                list4 = listOrderMeasures;
                it = listOrderMeasures.iterator();
                i6 = 0;
                i7 = i;
                iMeasureRecord2 = iMeasureRecord;
                i8 = i2;
                i9 = i3;
                z2 = z;
                z3 = zIsSleepScoreColored;
                context2 = context;
                zHasNext = it.hasNext();
                int colorScore = R.color.positive_light;
                int colorScore2 = R.color.positive;
                if (zHasNext) {
                }
            } else {
                if (i13 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i14 = pieView$Companion$getViewsForStatRecord$1.I$4;
                boolean z6 = pieView$Companion$getViewsForStatRecord$1.Z$1;
                int i15 = pieView$Companion$getViewsForStatRecord$1.I$3;
                boolean z7 = pieView$Companion$getViewsForStatRecord$1.Z$0;
                int i16 = pieView$Companion$getViewsForStatRecord$1.I$2;
                int i17 = pieView$Companion$getViewsForStatRecord$1.I$1;
                int i18 = pieView$Companion$getViewsForStatRecord$1.I$0;
                Iterator<SleepScore.ScoreMeasure> it3 = (Iterator) pieView$Companion$getViewsForStatRecord$1.L$7;
                List<SleepScore.ScoreMeasure> list6 = (List) pieView$Companion$getViewsForStatRecord$1.L$6;
                str = null;
                List list7 = (List) pieView$Companion$getViewsForStatRecord$1.L$5;
                Settings settings4 = (Settings) pieView$Companion$getViewsForStatRecord$1.L$4;
                SleepScore sleepScore3 = (SleepScore) pieView$Companion$getViewsForStatRecord$1.L$3;
                List<? extends SleepScore.ScoreMeasure> list8 = (List) pieView$Companion$getViewsForStatRecord$1.L$2;
                IMeasureRecord iMeasureRecord3 = (IMeasureRecord) pieView$Companion$getViewsForStatRecord$1.L$1;
                Context context4 = (Context) pieView$Companion$getViewsForStatRecord$1.L$0;
                ResultKt.throwOnFailure(obj2);
                SleepScore sleepScore4 = sleepScore3;
                it = it3;
                list4 = list6;
                Object obj3 = coroutine_suspended;
                settings = settings4;
                int i19 = i15;
                z2 = z7;
                i8 = i17;
                int i20 = 1;
                Context context5 = context4;
                pieView$Companion$getViewsForStatRecord$12 = pieView$Companion$getViewsForStatRecord$1;
                i7 = i18;
                List<? extends SleepScore.ScoreMeasure> list9 = list8;
                List list10 = list7;
                iMeasureRecord2 = iMeasureRecord3;
                List list11 = list10;
                i6 = i14 + i20;
                context2 = context5;
                i5 = i19;
                list2 = list11;
                list3 = list9;
                coroutine_suspended = obj3;
                z3 = z6;
                i9 = i16;
                sleepScore2 = sleepScore4;
                companion = this;
                zHasNext = it.hasNext();
                int colorScore3 = R.color.positive_light;
                int colorScore22 = R.color.positive;
                if (zHasNext) {
                    SleepScore.ScoreMeasure next = it.next();
                    boolean z8 = z2;
                    IValueExtractor extractor = next.getMeasure().getExtractor(context2);
                    Object obj4 = coroutine_suspended;
                    IValueExtractor secondaryExtractor = next.getMeasure().getSecondaryExtractor(context2);
                    if (secondaryExtractor != null) {
                        try {
                        } catch (Exception e) {
                            Logger.logSevere(e);
                            z4 = z3;
                            list5 = list2;
                            it2 = it;
                            obj = obj4;
                            i10 = i9;
                            i11 = i5;
                            context3 = context2;
                            settings2 = settings;
                            z5 = z8;
                        }
                        dBoxDouble = Boxing.boxDouble(secondaryExtractor.getValue(iMeasureRecord2));
                    } else {
                        dBoxDouble = str;
                    }
                    List list12 = list2;
                    Settings settings5 = settings;
                    double value = extractor.getValue(iMeasureRecord2);
                    Context context6 = context2;
                    z4 = z3;
                    int i21 = i5;
                    Logger.logInfo("Pie: " + next.name() + " " + value);
                    SleepScore.ScoreMeasure scoreMeasure = SleepScore.ScoreMeasure.HRV;
                    if (next != scoreMeasure) {
                        if (value > 1.0E-4d) {
                            if (!Double.isNaN(value)) {
                            }
                        }
                        context3 = context6;
                        z5 = z8;
                        it2 = it;
                        obj = obj4;
                        list5 = list12;
                        settings2 = settings5;
                        i11 = i21;
                        i10 = i9;
                        coroutine_suspended = obj;
                        i9 = i10;
                        z3 = z4;
                        it = it2;
                        z2 = z5;
                        settings = settings2;
                        context2 = context3;
                        i5 = i11;
                        list2 = list5;
                    } else {
                        if (dBoxDouble != 0) {
                            if (dBoxDouble.doubleValue() > 0.001d) {
                                if (!Double.isNaN(dBoxDouble.doubleValue())) {
                                    if (!Double.isInfinite(dBoxDouble.doubleValue())) {
                                        if (value >= -100.0d) {
                                        }
                                    }
                                }
                            }
                        }
                        context3 = context6;
                        z5 = z8;
                        it2 = it;
                        obj = obj4;
                        list5 = list12;
                        settings2 = settings5;
                        i11 = i21;
                        i10 = i9;
                        coroutine_suspended = obj;
                        i9 = i10;
                        z3 = z4;
                        it = it2;
                        z2 = z5;
                        settings = settings2;
                        context2 = context3;
                        i5 = i11;
                        list2 = list5;
                    }
                    companion = this;
                    zHasNext = it.hasNext();
                    int colorScore32 = R.color.positive_light;
                    int colorScore222 = R.color.positive;
                    if (zHasNext) {
                        List list13 = list2;
                        int i22 = i5;
                        Context context7 = context2;
                        Settings settings6 = settings;
                        boolean z9 = z2;
                        if (i22 != -1) {
                            try {
                                PieView pieViewFill = new PieView(context7, null, 0, 0, 14, null).fill(i22, R.drawable.empty, String.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(100.0f * sleepScore2.getScorePercentage()), 0)), null, Boxing.boxInt(R.string.score_short), sleepScore2.getScorePercentage(), z9);
                                pieViewFill.setColorRes(z9 ? R.color.positive_light : R.color.positive);
                                int measuresPosition = settings6.getMeasuresPosition(SleepScore.ScoreMeasure.SCORE);
                                if (i8 == 3) {
                                    list13.add(measuresPosition < 3 ? 1 : measuresPosition, pieViewFill);
                                } else {
                                    list13.add(measuresPosition, pieViewFill);
                                }
                            } catch (Exception e2) {
                                Logger.logSevere(e2);
                            }
                        }
                        return i8 > 0 ? CollectionsKt.take(list13, i8) : list13;
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object viewsForSleepRecord(int i, Context context, List<? extends SleepRecord> list, List<? extends SleepRecord> list2, List<? extends SleepScore.ScoreMeasure> list3, int i2, int i3, boolean z, int i4, SleepScore sleepScore, Continuation<? super List<? extends PieView>> continuation) {
            PieView$Companion$viewsForSleepRecord$1 pieView$Companion$viewsForSleepRecord$1;
            Companion companion;
            List<? extends SleepRecord> list4;
            Context context2;
            List<? extends SleepScore.ScoreMeasure> list5;
            SleepScore sleepScore2;
            int i5;
            boolean z2;
            List<? extends SleepRecord> list6;
            int i6;
            int i7;
            int i8;
            int i9;
            if (continuation instanceof PieView$Companion$viewsForSleepRecord$1) {
                pieView$Companion$viewsForSleepRecord$1 = (PieView$Companion$viewsForSleepRecord$1) continuation;
                int i10 = pieView$Companion$viewsForSleepRecord$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    pieView$Companion$viewsForSleepRecord$1.label = i10 - Integer.MIN_VALUE;
                    companion = this;
                } else {
                    companion = this;
                    pieView$Companion$viewsForSleepRecord$1 = new PieView$Companion$viewsForSleepRecord$1(companion, continuation);
                }
            }
            Object objWithContext = pieView$Companion$viewsForSleepRecord$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = pieView$Companion$viewsForSleepRecord$1.label;
            if (i11 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                list4 = list;
                PieView$Companion$viewsForSleepRecord$merged$1 pieView$Companion$viewsForSleepRecord$merged$1 = new PieView$Companion$viewsForSleepRecord$merged$1(list4, null);
                context2 = context;
                pieView$Companion$viewsForSleepRecord$1.L$0 = context2;
                pieView$Companion$viewsForSleepRecord$1.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                pieView$Companion$viewsForSleepRecord$1.L$2 = list2;
                list5 = list3;
                pieView$Companion$viewsForSleepRecord$1.L$3 = list5;
                sleepScore2 = sleepScore;
                pieView$Companion$viewsForSleepRecord$1.L$4 = sleepScore2;
                pieView$Companion$viewsForSleepRecord$1.I$0 = i;
                i5 = i2;
                pieView$Companion$viewsForSleepRecord$1.I$1 = i5;
                pieView$Companion$viewsForSleepRecord$1.I$2 = i3;
                z2 = z;
                pieView$Companion$viewsForSleepRecord$1.Z$0 = z2;
                pieView$Companion$viewsForSleepRecord$1.I$3 = i4;
                pieView$Companion$viewsForSleepRecord$1.label = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, pieView$Companion$viewsForSleepRecord$merged$1, pieView$Companion$viewsForSleepRecord$1);
                if (objWithContext != coroutine_suspended) {
                    list6 = list2;
                    i6 = i;
                    i7 = i4;
                    i8 = i3;
                }
            }
            if (i11 != 1) {
                if (i11 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            i7 = pieView$Companion$viewsForSleepRecord$1.I$3;
            boolean z3 = pieView$Companion$viewsForSleepRecord$1.Z$0;
            i8 = pieView$Companion$viewsForSleepRecord$1.I$2;
            int i12 = pieView$Companion$viewsForSleepRecord$1.I$1;
            i6 = pieView$Companion$viewsForSleepRecord$1.I$0;
            SleepScore sleepScore3 = (SleepScore) pieView$Companion$viewsForSleepRecord$1.L$4;
            List<? extends SleepScore.ScoreMeasure> list7 = (List) pieView$Companion$viewsForSleepRecord$1.L$3;
            list6 = (List) pieView$Companion$viewsForSleepRecord$1.L$2;
            List<? extends SleepRecord> list8 = (List) pieView$Companion$viewsForSleepRecord$1.L$1;
            Context context3 = (Context) pieView$Companion$viewsForSleepRecord$1.L$0;
            ResultKt.throwOnFailure(objWithContext);
            i5 = i12;
            list4 = list8;
            sleepScore2 = sleepScore3;
            list5 = list7;
            z2 = z3;
            context2 = context3;
            List list9 = (List) objWithContext;
            list9.getClass();
            if (list9.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            if (list6.isEmpty()) {
                i9 = 0;
            } else {
                SleepRegularityIndexUtil2 sleepRegularityIndexUtil2 = new SleepRegularityIndexUtil2(list6);
                Object obj = list9.get(0);
                obj.getClass();
                sleepRegularityIndexUtil2.fillSleepRegularityIndex((StatRecord) obj);
                i9 = 0;
            }
            Object obj2 = list9.get(i9);
            obj2.getClass();
            pieView$Companion$viewsForSleepRecord$1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
            pieView$Companion$viewsForSleepRecord$1.L$1 = SpillingKt.nullOutSpilledVariable(list4);
            pieView$Companion$viewsForSleepRecord$1.L$2 = SpillingKt.nullOutSpilledVariable(list6);
            pieView$Companion$viewsForSleepRecord$1.L$3 = SpillingKt.nullOutSpilledVariable(list5);
            pieView$Companion$viewsForSleepRecord$1.L$4 = SpillingKt.nullOutSpilledVariable(sleepScore2);
            pieView$Companion$viewsForSleepRecord$1.L$5 = SpillingKt.nullOutSpilledVariable(list9);
            pieView$Companion$viewsForSleepRecord$1.I$0 = i6;
            pieView$Companion$viewsForSleepRecord$1.I$1 = i5;
            pieView$Companion$viewsForSleepRecord$1.I$2 = i8;
            pieView$Companion$viewsForSleepRecord$1.Z$0 = z2;
            pieView$Companion$viewsForSleepRecord$1.I$3 = i7;
            pieView$Companion$viewsForSleepRecord$1.label = 2;
            Object viewsForStatRecord = companion.getViewsForStatRecord(i6, context2, (IMeasureRecord) obj2, list5, i5, i8, z2, i7, sleepScore2, pieView$Companion$viewsForSleepRecord$1);
            return viewsForStatRecord == coroutine_suspended ? coroutine_suspended : viewsForStatRecord;
        }

        public final Object viewsForStatRecord(int i, Context context, IMeasureRecord iMeasureRecord, List<? extends SleepScore.ScoreMeasure> list, int i2, int i3, boolean z, int i4, SleepScore sleepScore, Continuation<? super List<? extends PieView>> continuation) {
            return getViewsForStatRecord(i, context, iMeasureRecord, list, i2, i3, z, i4, sleepScore, continuation);
        }

        private Companion() {
        }

        public final List<PieView> getViewsForSleepRecord(int i, Context context, SleepRecord sleepRecord, List<? extends SleepRecord> list, List<? extends SleepScore.ScoreMeasure> list2, int i2, int i3, boolean z, int i4) {
            context.getClass();
            sleepRecord.getClass();
            list.getClass();
            list2.getClass();
            return getViewsForSleepRecord$default(this, i, context, sleepRecord, list, list2, i2, i3, z, i4, null, 512, null);
        }

        public final List<PieView> getViewsForSleepRecord(int i, Context context, SleepRecord sleepRecord, List<? extends SleepRecord> list, List<? extends SleepScore.ScoreMeasure> list2, int i2) {
            context.getClass();
            sleepRecord.getClass();
            list.getClass();
            list2.getClass();
            return getViewsForSleepRecord$default(this, i, context, sleepRecord, list, list2, i2, 0, false, 0, null, 960, null);
        }
    }

    public /* synthetic */ PieView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final PieView fill(int layout, int icon, String value, String secondValue, Integer desc, float progress, boolean white) {
        value.getClass();
        InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
        Context context = getContext();
        context.getClass();
        LayoutInflater layoutInflater = companion.get(context);
        int i = (layout != R.layout.view_pie || ((double) getResources().getConfiguration().fontScale) <= 1.15d) ? layout : R.layout.view_pie_large_font;
        if (layout == R.layout.view_pie_small && getResources().getConfiguration().fontScale > 1.15d) {
            i = R.layout.view_pie_small_large_font;
        }
        View viewInflate = layoutInflater.inflate(i, this);
        viewInflate.getClass();
        this.root = viewInflate;
        setValue(value);
        if (secondValue != null) {
            setSecondValue(secondValue);
        } else {
            View view = this.root;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            }
            view.findViewById(R.id.pie_value_second).setVisibility(4);
        }
        setIcon(icon);
        setDesc(desc);
        setProgress(progress);
        setThemeWhite(white);
        return this;
    }

    public final void hideDesc() {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        view.findViewById(R.id.pie_desc).setVisibility(8);
    }

    public final PieView setColorRes(int color) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_progress);
        viewFindViewById.getClass();
        ((ProgressRingView) viewFindViewById).setProgressColor(ColorUtil.i(getContext(), color));
        return this;
    }

    public final PieView setDesc(Integer descRes) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_desc);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        if (descRes == null || descRes.intValue() == -1) {
            textView.setVisibility(8);
            return this;
        }
        textView.setText(descRes.intValue());
        textView.setVisibility(0);
        return this;
    }

    public final PieView setIcon(int res) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_icon);
        viewFindViewById.getClass();
        ((ImageView) viewFindViewById).setImageResource(res);
        return this;
    }

    public final PieView setProgress(float progress) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_progress);
        viewFindViewById.getClass();
        ((ProgressRingView) viewFindViewById).setProgress(RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(progress, 1.0f), 1.0E-5f));
        return this;
    }

    public final PieView setSecondValue(String value) {
        value.getClass();
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_value_second);
        viewFindViewById.getClass();
        ((TextView) viewFindViewById).setText(value);
        return this;
    }

    public final PieView setSecondValueColor(int color) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_value_second);
        viewFindViewById.getClass();
        ((TextView) viewFindViewById).setTextColor(color);
        return this;
    }

    public final void setThemeWhite(boolean white) {
        View view = this.root;
        View view2 = null;
        if (white) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            }
            View viewFindViewById = view.findViewById(R.id.pie_desc);
            viewFindViewById.getClass();
            ((TextView) viewFindViewById).setTextColor(ColorUtil.i(getContext(), R.color.white));
            setValueColor(ColorUtil.i(getContext(), R.color.white));
            setSecondValueColor(ColorUtil.i(getContext(), R.color.white_secondary));
            View view3 = this.root;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            } else {
                view2 = view3;
            }
            View viewFindViewById2 = view2.findViewById(R.id.pie_progress);
            viewFindViewById2.getClass();
            ((ProgressRingView) viewFindViewById2).setBackgroundProgressColor(ColorUtil.i(getContext(), R.color.separator_white));
            return;
        }
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById3 = view.findViewById(R.id.pie_desc);
        viewFindViewById3.getClass();
        ((TextView) viewFindViewById3).setTextColor(ColorUtil.i(getContext(), R.color.primary));
        setValueColor(ColorUtil.i(getContext(), R.color.primary));
        setSecondValueColor(ColorUtil.i(getContext(), R.color.secondary));
        View view4 = this.root;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            view2 = view4;
        }
        View viewFindViewById4 = view2.findViewById(R.id.pie_progress);
        viewFindViewById4.getClass();
        ((ProgressRingView) viewFindViewById4).setBackgroundProgressColor(ColorUtil.i(getContext(), R.color.shade));
    }

    public final PieView setValue(String value) {
        value.getClass();
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_value);
        viewFindViewById.getClass();
        ((TextView) viewFindViewById).setText(value);
        return this;
    }

    public final PieView setValueColor(int color) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_value);
        viewFindViewById.getClass();
        ((TextView) viewFindViewById).setTextColor(color);
        return this;
    }

    public final PieView setValueColorRes(int colorRes) {
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View viewFindViewById = view.findViewById(R.id.pie_value);
        viewFindViewById.getClass();
        ((TextView) viewFindViewById).setTextColor(ColorUtil.i(getContext(), colorRes));
        return this;
    }

    public PieView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}

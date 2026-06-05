package com.urbandroid.sleep.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcelable;
import android.util.SizeF;
import android.util.TypedValue;
import android.view.View;
import android.widget.RemoteViews;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.merger.SameDateMerger;
import com.urbandroid.sleep.addon.stats.model.merger.ShortGapMerger;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SleepRegularityIndexUtil2;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.GraphViewMap;
import com.urbandroid.sleep.gui.ImageCreator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/appwidget/GraphWidget;", "Landroid/appwidget/AppWidgetProvider;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "refreshWidget", "updateViews", "views", "Landroid/widget/RemoteViews;", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "statRecord", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "recordHasNonDefaultTimeZone", "", "onEnabled", "onDisabled", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GraphWidget extends AppWidgetProvider implements CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();

    /* JADX INFO: renamed from: com.urbandroid.sleep.appwidget.GraphWidget$refreshWidget$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.appwidget.GraphWidget$refreshWidget$1", f = "GraphWidget.kt", l = {80}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ GraphWidget this$0;

        /* JADX INFO: renamed from: com.urbandroid.sleep.appwidget.GraphWidget$refreshWidget$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.appwidget.GraphWidget$refreshWidget$1$1", f = "GraphWidget.kt", l = {105}, m = "invokeSuspend", v = 2)
        public static final class C00351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ RemoteViews $viewsBig;
            final /* synthetic */ RemoteViews $viewsSmall;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;
            final /* synthetic */ GraphWidget this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00351(GraphWidget graphWidget, Context context, RemoteViews remoteViews, RemoteViews remoteViews2, Continuation<? super C00351> continuation) {
                super(2, continuation);
                this.this$0 = graphWidget;
                this.$context = context;
                this.$viewsSmall = remoteViews;
                this.$viewsBig = remoteViews2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00351(this.this$0, this.$context, this.$viewsSmall, this.$viewsBig, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r6v13, types: [T, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(0, 2, false);
                    if (sleepRecords != null && !sleepRecords.isEmpty()) {
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        ?? r6 = sleepRecords.get(0);
                        ref$ObjectRef.element = r6;
                        if (r6 != 0 && !((SleepRecord) r6).isFinished() && sleepRecords.size() > 1) {
                            ref$ObjectRef.element = sleepRecords.get(1);
                        }
                        SleepRecord sleepRecord = (SleepRecord) ref$ObjectRef.element;
                        if (sleepRecord != null) {
                            GraphWidget graphWidget = this.this$0;
                            Context context = this.$context;
                            RemoteViews remoteViews = this.$viewsSmall;
                            RemoteViews remoteViews2 = this.$viewsBig;
                            List<SleepRecord> prevNextSleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getPrevNextSleepRecords((SleepRecord) ref$ObjectRef.element);
                            prevNextSleepRecords.getClass();
                            ArrayList arrayList = new ArrayList();
                            for (Object obj2 : prevNextSleepRecords) {
                                if (((SleepRecord) obj2).isFinished()) {
                                    arrayList.add(obj2);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(StatRecord.fromSleepRecord((SleepRecord) it.next()));
                            }
                            List<StatRecord> listMerge = new ShortGapMerger().merge(arrayList2);
                            List<StatRecord> listMerge2 = new SameDateMerger().merge(listMerge);
                            if (listMerge2.size() > 0) {
                                for (StatRecord statRecord : listMerge2) {
                                    List<SleepRecord> list = prevNextSleepRecords;
                                    if (DateUtil.isSameDate(statRecord.getToDate(), ((SleepRecord) ref$ObjectRef.element).getTo())) {
                                        new SleepRegularityIndexUtil2(sleepRecords).fillSleepRegularityIndex(statRecord);
                                    }
                                    prevNextSleepRecords = list;
                                }
                                MainCoroutineDispatcher main = Dispatchers.getMain();
                                GraphWidget$refreshWidget$1$1$1$2 graphWidget$refreshWidget$1$1$1$2 = new GraphWidget$refreshWidget$1$1$1$2(listMerge2, graphWidget, context, remoteViews, sleepRecord, remoteViews2, null);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(sleepRecords);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(ref$ObjectRef);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(sleepRecord);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(prevNextSleepRecords);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(listMerge);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(listMerge2);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                this.I$0 = 0;
                                this.label = 1;
                                if (BuildersKt.withContext(main, graphWidget$refreshWidget$1$1$1$2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, GraphWidget graphWidget, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = graphWidget;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AppWidgetManager appWidgetManager;
            ComponentName componentName;
            RemoteViews remoteViews;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ComponentName componentName2 = new ComponentName(this.$context.getApplicationContext(), (Class<?>) GraphWidget.class);
                appWidgetManager = AppWidgetManager.getInstance(this.$context.getApplicationContext());
                HashMap map = new HashMap();
                RemoteViews remoteViews2 = new RemoteViews(this.$context.getPackageName(), R.layout.widget_graph);
                RemoteViews remoteViews3 = new RemoteViews(this.$context.getPackageName(), R.layout.widget_graph_big);
                map.put(new SizeF(120.0f, 120.0f), remoteViews3);
                map.put(new SizeF(120.0f, 40.0f), remoteViews2);
                RemoteViews remoteViewsM = Build.VERSION.SDK_INT >= 31 ? TypefaceCompat$$ExternalSyntheticApiModelOutline0.m(map) : remoteViews2;
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C00351 c00351 = new C00351(this.this$0, this.$context, remoteViews2, remoteViews3, null);
                this.L$0 = componentName2;
                this.L$1 = appWidgetManager;
                this.L$2 = SpillingKt.nullOutSpilledVariable(map);
                this.L$3 = SpillingKt.nullOutSpilledVariable(remoteViews2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(remoteViews3);
                this.L$5 = remoteViewsM;
                this.label = 1;
                if (BuildersKt.withContext(io2, c00351, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                componentName = componentName2;
                remoteViews = remoteViewsM;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                remoteViews = (RemoteViews) this.L$5;
                appWidgetManager = (AppWidgetManager) this.L$1;
                componentName = (ComponentName) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            appWidgetManager.updateAppWidget(componentName, remoteViews);
            return Unit.INSTANCE;
        }
    }

    private final boolean recordHasNonDefaultTimeZone(SleepRecord record) {
        return (TimeZone.getDefault() == null || record.getTimezone() == null || Intrinsics.areEqual(TimeZone.getDefault().getID(), record.getTimezone())) ? false : true;
    }

    private final void refreshWidget(Context context) {
        GlobalInitializator.initializeIfRequired(context);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(context, this, null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        context.getClass();
        super.onDisabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        context.getClass();
        super.onEnabled(context);
        refreshWidget(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context, true);
        if (DroidWidget.widgetsInstalled(context, GraphWidget.class) != 0) {
            if (Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STOPPED") || Intrinsics.areEqual(intent.getAction(), "android.appwidget.action.APPWIDGET_UPDATE") || Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.ACTION_GRAPH_CHANGED")) {
                refreshWidget(context);
            }
        }
    }

    public final void updateViews(Context context, RemoteViews views, SleepRecord record, StatRecord statRecord) {
        context.getClass();
        views.getClass();
        record.getClass();
        statRecord.getClass();
        Resources resources = context.getResources();
        float fApplyDimension = TypedValue.applyDimension(1, 320.0f, resources.getDisplayMetrics());
        float fApplyDimension2 = TypedValue.applyDimension(1, 80.0f, resources.getDisplayMetrics());
        int color = ContextCompat.getColor(context, R.color.transparent);
        GraphView graphView = new GraphView(context, null);
        int i = (int) fApplyDimension;
        int i2 = (int) fApplyDimension2;
        graphView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        graphView.layout(0, 0, i, i2);
        GraphViewMap graphViewMap = new GraphViewMap();
        if (record.hasHypnogram()) {
            graphViewMap.add(R.id.hypnogram, graphView);
        } else {
            graphViewMap.add(R.id.graph, graphView);
        }
        new SleepGraphInitializer(context).init(graphViewMap, record);
        graphView.setCardColor(color);
        graphView.setGradientFullColor(color);
        graphView.setGradientTransColor(color);
        graphView.setDoGradient(true);
        graphView.setDoLeftRightGradient(false);
        graphView.setDrawTimeSeries(false);
        graphView.setDoTrimming(false);
        graphView.setDrawYAxis(false);
        graphView.setDrawXAxis(false);
        views.setImageViewBitmap(R.id.graph, ImageCreator.convertViewIntoBitmap(i, i2, graphView));
        Intent intent = new Intent(context, (Class<?>) SleepDetailActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.addFlags(67108864);
        intent.putExtra("SleepRecord", (Parcelable) record);
        views.setOnClickPendingIntent(R.id.parent, PendingIntentBuilder.INSTANCE.get(context, -9809663, intent, 134217728).getActivity());
        DateFormat hoursFormat = recordHasNonDefaultTimeZone(record) ? com.urbandroid.common.util.DateUtil.getHoursFormat(context, record.getTimeZone()) : com.urbandroid.common.util.DateUtil.getHoursFormat(context);
        int[] iArr = {R.id.title1, R.id.title2, R.id.title3, R.id.title4, R.id.title5, R.id.title6, R.id.title7};
        int[] iArr2 = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7};
        Measure[] measureArrOrderMeasures = Measure.ALL_MEASURES;
        try {
            measureArrOrderMeasures = SharedApplicationContext.getSettings().orderMeasures(Measure.ALL_MEASURES);
        } catch (Exception unused) {
        }
        for (int i3 = 0; i3 < 7 && i3 < measureArrOrderMeasures.length; i3++) {
            Measure measure = measureArrOrderMeasures[i3];
            IValueExtractor extractor = measure.getExtractor(context);
            if (extractor == null) {
                views.setViewVisibility(iArr[i3], 8);
                views.setViewVisibility(iArr2[i3], 8);
            } else if (extractor.getValue(statRecord) < 0.009999999776482582d) {
                views.setViewVisibility(iArr[i3], 8);
                views.setViewVisibility(iArr2[i3], 8);
            } else if (measure.mapToScoreMeasure() != null) {
                views.setViewVisibility(iArr[i3], 0);
                views.setViewVisibility(iArr2[i3], 0);
                views.setTextViewText(iArr[i3], extractor.getValuePresentation(extractor.getValue(statRecord)));
                views.setImageViewResource(iArr2[i3], measure.mapToScoreMeasure().getIcon());
            } else {
                views.setViewVisibility(iArr[i3], 8);
                views.setViewVisibility(iArr2[i3], 8);
            }
        }
        views.setTextViewText(R.id.from, hoursFormat.format(record.getFrom()));
        views.setTextViewText(R.id.to, hoursFormat.format(record.getTo()));
    }
}

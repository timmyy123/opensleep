package com.urbandroid.sleep.addon.stats.chart;

import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.GraphicalView;
import org.mp4parser.boxes.apple.TrackLoadSettingsAtom;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/ChartLoader;", "", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/ViewGroup;", "chartView", "", "viewCount", "Landroid/widget/ProgressBar;", "progressBar", "Lkotlin/Function2;", "Landroid/view/View;", "viewCreator", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;ILandroid/widget/ProgressBar;Lkotlin/jvm/functions/Function2;)V", SDKConstants.PARAM_VALUE, "", "progressUpdate", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", TrackLoadSettingsAtom.TYPE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/app/Activity;", "Landroid/view/ViewGroup;", "I", "Landroid/widget/ProgressBar;", "Lkotlin/jvm/functions/Function2;", "", "charts", "Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChartLoader {
    private final ViewGroup chartView;
    private List<View> charts;
    private final Activity context;
    private final ProgressBar progressBar;
    private final int viewCount;
    private final Function2<ChartLoader, Integer, View> viewCreator;

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.chart.ChartLoader", f = "ChartLoader.kt", l = {42, 52, 65}, m = TrackLoadSettingsAtom.TYPE, v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChartLoader.this.load(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$2", f = "ChartLoader.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChartLoader.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ProgressBar progressBar = ChartLoader.this.progressBar;
            ChartLoader chartLoader = ChartLoader.this;
            progressBar.setVisibility(0);
            progressBar.setProgress(0);
            progressBar.setIndeterminate(true);
            progressBar.setMax(chartLoader.viewCount);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$3", f = "ChartLoader.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<View> $views;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(List<View> list, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$views = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChartLoader.this.new AnonymousClass3(this.$views, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ChartLoader.this.chartView.removeAllViews();
            Display defaultDisplay = ChartLoader.this.context.getWindowManager().getDefaultDisplay();
            defaultDisplay.getClass();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            if (this.$views.size() > 1) {
                ScrollView scrollView = new ScrollView(ChartLoader.this.context);
                scrollView.setVerticalFadingEdgeEnabled(false);
                LinearLayout linearLayout = new LinearLayout(ChartLoader.this.context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                for (View view : this.$views) {
                    GraphicalView graphicalView = view instanceof GraphicalView ? (GraphicalView) view : null;
                    if (graphicalView != null) {
                        graphicalView.setMinimumWidth(width);
                        graphicalView.setMinimumHeight((height * 5) / 8);
                    }
                    LinearLayout linearLayout2 = new LinearLayout(ChartLoader.this.context);
                    linearLayout2.addView(view, new LinearLayout.LayoutParams(-2, -2));
                    linearLayout.addView(linearLayout2);
                }
                scrollView.addView(linearLayout, layoutParams);
                ChartLoader.this.chartView.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
            } else if (this.$views.size() == 1) {
                ChartLoader.this.chartView.addView((View) CollectionsKt.first((List) this.$views));
            }
            ChartLoader.this.progressBar.setVisibility(8);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.chart.ChartLoader$progressUpdate$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.chart.ChartLoader$progressUpdate$2", f = "ChartLoader.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C20812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20812(int i, Continuation<? super C20812> continuation) {
            super(2, continuation);
            this.$value = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChartLoader.this.new C20812(this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C20812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ProgressBar progressBar = ChartLoader.this.progressBar;
            int i = this.$value;
            progressBar.setIndeterminate(false);
            progressBar.setProgress(i);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChartLoader(Activity activity, ViewGroup viewGroup, int i, ProgressBar progressBar, Function2<? super ChartLoader, ? super Integer, ? extends View> function2) {
        activity.getClass();
        viewGroup.getClass();
        progressBar.getClass();
        function2.getClass();
        this.context = activity;
        this.chartView = viewGroup;
        this.viewCount = i;
        this.progressBar = progressBar;
        this.viewCreator = function2;
        this.charts = new ArrayList();
        progressBar.setMax(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object progressUpdate(int i, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C20812(i, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0) != r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(main, anonymousClass2, anonymousClass1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objWithContext);
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objWithContext);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objWithContext);
            List list = (List) objWithContext;
            MainCoroutineDispatcher main2 = Dispatchers.getMain();
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(list, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
            anonymousClass1.label = 3;
        }
        CoroutineDispatcher io2 = Dispatchers.getIO();
        ChartLoader$load$views$1 chartLoader$load$views$1 = new ChartLoader$load$views$1(this, null);
        anonymousClass1.label = 2;
        objWithContext = BuildersKt.withContext(io2, chartLoader$load$views$1, anonymousClass1);
        if (objWithContext != coroutine_suspended) {
            List list2 = (List) objWithContext;
            MainCoroutineDispatcher main22 = Dispatchers.getMain();
            AnonymousClass3 anonymousClass32 = new AnonymousClass3(list2, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list2);
            anonymousClass1.label = 3;
        }
        return coroutine_suspended;
    }
}

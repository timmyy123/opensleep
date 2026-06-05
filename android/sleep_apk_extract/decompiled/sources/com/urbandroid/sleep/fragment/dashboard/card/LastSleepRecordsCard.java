package com.urbandroid.sleep.fragment.dashboard.card;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.platform.traits.ValidationIssue;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.ContextScope;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoaderKt;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.sleep.gui.view.PieView;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001BB%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0012\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0011H\u0016¢\u0006\u0004\b(\u0010\u001dJ\u000f\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0010\u001a\u00020\u0011H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u001dJ\u000f\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b+\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b1\u00102R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00103R\u0016\u00104\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u001a\u00106\u001a\u0002058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020;0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00100R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/LastSleepRecordsCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/PageAwareDashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LastSleepRecordsCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/ContextScope;", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecords", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;)V", "allSleepRecords", "viewHolder", "", "next", "", "bindSleepRecordToView", "(Ljava/util/List;Ljava/util/List;Lcom/urbandroid/sleep/fragment/dashboard/card/LastSleepRecordsCard$SleepRecordViewHolder;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/sleep/graph/TimeAxisLabels;", "toTimeAxisLabels", "(Lcom/urbandroid/sleep/domain/SleepRecord;)Lcom/urbandroid/sleep/graph/TimeAxisLabels;", "", SpotifyService.OFFSET, "", "getCurrentRecords", "(I)Ljava/util/List;", "loadRecord", "()V", "init", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/LastSleepRecordsCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/LastSleepRecordsCard$SleepRecordViewHolder;)V", "onCardDestroyed", "getNameResource", "()I", "prev", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/List;", "getSleepRecords", "()Ljava/util/List;", "I", "backgroundOffset", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "Lcom/urbandroid/sleep/domain/interval/Interval;", "dayRecordMap", "Ljava/util/Map;", "intervalList", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LastSleepRecordsCard extends PageAwareDashboardCard<SleepRecordViewHolder> implements ContextScope {
    private final Activity activity;
    private int backgroundOffset;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final Map<Interval, List<SleepRecord>> dayRecordMap;
    private final List<Interval> intervalList;
    private Job job;
    private int offset;
    private final List<SleepRecord> sleepRecords;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/LastSleepRecordsCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "subtitle", "getSubtitle", "setSubtitle", "Landroid/widget/LinearLayout;", "graphs", "Landroid/widget/LinearLayout;", "getGraphs", "()Landroid/widget/LinearLayout;", "setGraphs", "(Landroid/widget/LinearLayout;)V", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "setCard", "(Landroidx/cardview/widget/CardView;)V", "Landroid/view/ViewGroup;", "pieFlow", "Landroid/view/ViewGroup;", "getPieFlow", "()Landroid/view/ViewGroup;", "setPieFlow", "(Landroid/view/ViewGroup;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private CardView card;
        private LinearLayout graphs;
        private ViewGroup pieFlow;
        private TextView subtitle;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.row_graph_subtitle);
            viewFindViewById2.getClass();
            this.subtitle = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.graph_layout);
            viewFindViewById3.getClass();
            this.graphs = (LinearLayout) viewFindViewById3;
            this.card = (CardView) view.findViewById(R.id.foreground);
            this.pieFlow = (ViewGroup) view.findViewById(R.id.pie_flow);
        }

        public final CardView getCard() {
            return this.card;
        }

        public final LinearLayout getGraphs() {
            return this.graphs;
        }

        public final ViewGroup getPieFlow() {
            return this.pieFlow;
        }

        public final TextView getSubtitle() {
            return this.subtitle;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final void setCard(CardView cardView) {
            this.card = cardView;
        }

        public final void setGraphs(LinearLayout linearLayout) {
            linearLayout.getClass();
            this.graphs = linearLayout;
        }

        public final void setSubtitle(TextView textView) {
            textView.getClass();
            this.subtitle = textView;
        }

        public final void setTitle(TextView textView) {
            textView.getClass();
            this.title = textView;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.dashboard.card.LastSleepRecordsCard$bindSleepRecordToView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.card.LastSleepRecordsCard", f = "LastSleepRecordsCard.kt", l = {89}, m = "bindSleepRecordToView", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LastSleepRecordsCard.this.bindSleepRecordToView(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.dashboard.card.LastSleepRecordsCard$bindView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.card.LastSleepRecordsCard$bindView$1", f = "LastSleepRecordsCard.kt", l = {ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER, 215}, m = "invokeSuspend", v = 2)
    public static final class C21021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SleepRecordViewHolder $viewHolder;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21021(SleepRecordViewHolder sleepRecordViewHolder, Continuation<? super C21021> continuation) {
            super(2, continuation);
            this.$viewHolder = sleepRecordViewHolder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LastSleepRecordsCard.this.new C21021(this.$viewHolder, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x00a4, code lost:
        
            if (r4.bindSleepRecordToView(r5, r6, r7, true, r9) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            C21021 c21021;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LastSleepRecordsCard lastSleepRecordsCard = LastSleepRecordsCard.this;
                List currentRecords = lastSleepRecordsCard.getCurrentRecords(lastSleepRecordsCard.offset);
                List<SleepRecord> sleepRecords = LastSleepRecordsCard.this.getSleepRecords();
                SleepRecordViewHolder sleepRecordViewHolder = this.$viewHolder;
                this.label = 1;
                c21021 = this;
                if (LastSleepRecordsCard.bindSleepRecordToView$default(lastSleepRecordsCard, currentRecords, sleepRecords, sleepRecordViewHolder, false, c21021, 8, null) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            c21021 = this;
            View view = c21021.$viewHolder.itemView;
            view.getClass();
            SleepRecordViewHolder sleepRecordViewHolder2 = new SleepRecordViewHolder(view);
            SleepRecordViewHolder sleepRecordViewHolder3 = c21021.$viewHolder;
            sleepRecordViewHolder2.setCard(null);
            View view2 = sleepRecordViewHolder3.itemView;
            View viewFindViewById = view2.findViewById(R.id.titleTextGraphBackground);
            viewFindViewById.getClass();
            sleepRecordViewHolder2.setTitle((TextView) viewFindViewById);
            View viewFindViewById2 = view2.findViewById(R.id.graph_layout_background);
            viewFindViewById2.getClass();
            sleepRecordViewHolder2.setGraphs((LinearLayout) viewFindViewById2);
            View viewFindViewById3 = view2.findViewById(R.id.row_graph_subtitle_background);
            viewFindViewById3.getClass();
            sleepRecordViewHolder2.setSubtitle((TextView) viewFindViewById3);
            LastSleepRecordsCard lastSleepRecordsCard2 = LastSleepRecordsCard.this;
            List currentRecords2 = lastSleepRecordsCard2.getCurrentRecords(lastSleepRecordsCard2.backgroundOffset);
            List<SleepRecord> sleepRecords2 = LastSleepRecordsCard.this.getSleepRecords();
            c21021.L$0 = SpillingKt.nullOutSpilledVariable(sleepRecordViewHolder2);
            c21021.label = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LastSleepRecordsCard(Activity activity, CoroutineScope coroutineScope, List<? extends SleepRecord> list) {
        super(activity, DashboardCard.Type.LATEST_GRAPH, R.layout.card_sleep_records);
        activity.getClass();
        coroutineScope.getClass();
        list.getClass();
        this.activity = activity;
        this.coroutineScope = coroutineScope;
        this.sleepRecords = list;
        this.backgroundOffset = 1;
        this.context = activity;
        this.dayRecordMap = new LinkedHashMap();
        this.intervalList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bindSleepRecordToView(List<? extends SleepRecord> list, List<? extends SleepRecord> list2, SleepRecordViewHolder sleepRecordViewHolder, boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        LinearLayout graphs;
        Object next;
        Object next2;
        List<? extends SleepRecord> list3;
        SleepRecordViewHolder sleepRecordViewHolder2;
        SleepRecordViewHolder sleepRecordViewHolder3;
        LinearLayout linearLayout;
        String timeNoAmPm;
        ArrayList arrayList;
        List<? extends SleepRecord> list4 = list;
        SleepRecordViewHolder sleepRecordViewHolder4 = sleepRecordViewHolder;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object objViewsForSleepRecord$default = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objViewsForSleepRecord$default);
            graphs = sleepRecordViewHolder4.getGraphs();
            graphs.removeAllViews();
            if (list4.isEmpty()) {
                graphs.setVisibility(4);
                sleepRecordViewHolder4.getTitle().setText(R.string.no_history_records);
                return Unit.INSTANCE;
            }
            graphs.setVisibility(0);
            List<? extends SleepRecord> list5 = list4;
            Iterator<T> it = list5.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long fromTime = ((SleepRecord) next).getFromTime();
                    while (true) {
                        Object next3 = it.next();
                        long fromTime2 = ((SleepRecord) next3).getFromTime();
                        if (fromTime > fromTime2) {
                            next = next3;
                            fromTime = fromTime2;
                        }
                        if (!it.hasNext()) {
                            break;
                        }
                        list4 = list;
                        sleepRecordViewHolder4 = sleepRecordViewHolder;
                    }
                }
            } else {
                next = null;
            }
            SleepRecord sleepRecord = (SleepRecord) next;
            Long lBoxLong = sleepRecord != null ? Boxing.boxLong(sleepRecord.getFromTime()) : null;
            Iterator<T> it2 = list5.iterator();
            if (it2.hasNext()) {
                next2 = it2.next();
                if (it2.hasNext()) {
                    long toTime = ((SleepRecord) next2).getToTime();
                    while (true) {
                        Object next4 = it2.next();
                        long toTime2 = ((SleepRecord) next4).getToTime();
                        if (toTime < toTime2) {
                            next2 = next4;
                            toTime = toTime2;
                        }
                        if (!it2.hasNext()) {
                            break;
                        }
                        list4 = list;
                        sleepRecordViewHolder4 = sleepRecordViewHolder;
                    }
                }
            } else {
                next2 = null;
            }
            SleepRecord sleepRecord2 = (SleepRecord) next2;
            Long lBoxLong2 = sleepRecord2 != null ? Boxing.boxLong(sleepRecord2.getToTime()) : null;
            TextView subtitle = sleepRecordViewHolder4.getSubtitle();
            String str = "";
            String strM$1 = lBoxLong != null ? FileInsert$$ExternalSyntheticOutline0.m$1(getTimeNoAmPm(lBoxLong.longValue()), " — ") : "";
            if (lBoxLong2 != null && (timeNoAmPm = getTimeNoAmPm(lBoxLong2.longValue())) != null) {
                str = timeNoAmPm;
            }
            subtitle.setText(strM$1.concat(str));
            if (sleepRecordViewHolder4.getCard() == null) {
                list3 = list;
                sleepRecordViewHolder2 = sleepRecordViewHolder;
                arrayList = new ArrayList();
                for (Object obj : list3) {
                    if (((SleepRecord) obj).getMeasurementLength() > 10) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list3 = arrayList;
                }
                int i3 = 0;
                for (SleepRecord sleepRecord3 : CollectionsKt.asReversed(list3)) {
                    int i4 = i3 + 1;
                    if (sleepRecord3.getTo() != null) {
                        GraphView graphView = new GraphView(getContext(), null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getDip(88), RangesKt.coerceAtLeast(sleepRecord3.getMeasurementLength(), 1.0f));
                        layoutParams.setMargins(0, 0, i3 < list3.size() - 1 ? getDip(16) : 0, 0);
                        graphView.setLayoutParams(layoutParams);
                        graphView.setEquidistantValues(new float[0], sleepRecord3.shouldUseExactFitView());
                        graphView.setRotateYAxisLabels(false);
                        SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(getContext());
                        if (sleepRecord3.hasHypnogram()) {
                            sleepGraphInitializer.initHypnogram(graphView, sleepRecord3);
                            sleepGraphInitializer.populateHypnogramOrPhases(getContext(), graphView, sleepRecord3);
                            graphView.setDrawXAxisBars(true);
                        } else {
                            sleepGraphInitializer.initActigraph(graphView, sleepRecord3);
                        }
                        sleepRecordViewHolder2.getTitle().setText(SleepRecordStringBuilder.getTitle(getContext(), sleepRecord3));
                        graphView.setXAxisLabels(toTimeAxisLabels(sleepRecord3));
                        graphView.setDrawXAxis(false);
                        graphView.setGradientFullColor(getArgb(R.color.bg_card_dashboard));
                        graphView.setGradientTransColor(getArgb(R.color.bg_card_dashboard_trans));
                        graphView.setCardColor(getArgb(R.color.graph_time_segments));
                        graphView.setBackgroundResource(R.drawable.card_dashboard);
                        graphs.addView(graphView);
                    }
                    i3 = i4;
                }
                return Unit.INSTANCE;
            }
            PieView.Companion companion = PieView.INSTANCE;
            Long l = lBoxLong2;
            Context context = getContext();
            List<SleepScore.ScoreMeasure> all_measures = StatsRepoLoaderKt.getALL_MEASURES();
            anonymousClass12.L$0 = list4;
            anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(list2);
            anonymousClass12.L$2 = sleepRecordViewHolder4;
            anonymousClass12.L$3 = graphs;
            anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(lBoxLong);
            anonymousClass12.L$5 = SpillingKt.nullOutSpilledVariable(l);
            anonymousClass12.L$6 = sleepRecordViewHolder4;
            anonymousClass12.Z$0 = z;
            anonymousClass12.I$0 = 0;
            anonymousClass12.label = 1;
            objViewsForSleepRecord$default = PieView.Companion.viewsForSleepRecord$default(companion, R.layout.view_pie_small, context, list4, list2, all_measures, 3, -1, false, R.layout.view_pie_score_middle, null, anonymousClass12, 512, null);
            if (objViewsForSleepRecord$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            list3 = list;
            sleepRecordViewHolder3 = sleepRecordViewHolder;
            sleepRecordViewHolder2 = sleepRecordViewHolder3;
            linearLayout = graphs;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sleepRecordViewHolder3 = (SleepRecordViewHolder) anonymousClass12.L$6;
            linearLayout = (LinearLayout) anonymousClass12.L$3;
            sleepRecordViewHolder2 = (SleepRecordViewHolder) anonymousClass12.L$2;
            list3 = (List) anonymousClass12.L$0;
            ResultKt.throwOnFailure(objViewsForSleepRecord$default);
        }
        List<PieView> list6 = (List) objViewsForSleepRecord$default;
        ViewGroup pieFlow = sleepRecordViewHolder3.getPieFlow();
        if (pieFlow != null) {
            pieFlow.removeAllViews();
        }
        for (PieView pieView : list6) {
            ViewGroup pieFlow2 = sleepRecordViewHolder3.getPieFlow();
            if (pieFlow2 != null) {
                pieFlow2.addView(pieView);
            }
        }
        graphs = linearLayout;
        arrayList = new ArrayList();
        while (r2.hasNext()) {
        }
        if (arrayList.isEmpty()) {
        }
        if (arrayList != null) {
        }
        int i32 = 0;
        while (r2.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object bindSleepRecordToView$default(LastSleepRecordsCard lastSleepRecordsCard, List list, List list2, SleepRecordViewHolder sleepRecordViewHolder, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return lastSleepRecordsCard.bindSleepRecordToView(list, list2, sleepRecordViewHolder, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SleepRecord> getCurrentRecords(int offset) {
        if (offset < this.intervalList.size()) {
            List<SleepRecord> list = this.dayRecordMap.get(this.intervalList.get(offset));
            if (list != null) {
                return list;
            }
        }
        return new ArrayList();
    }

    private final void loadRecord() {
        if (Math.abs(this.offset) >= this.intervalList.size()) {
            this.offset = 0;
        }
        int iAbs = Math.abs(this.offset) + 1;
        this.backgroundOffset = iAbs;
        if (iAbs >= this.intervalList.size()) {
            this.backgroundOffset = 0;
        }
        refresh();
    }

    private final TimeAxisLabels toTimeAxisLabels(SleepRecord sleepRecord) {
        if (sleepRecord.getTo() != null) {
            return new TimeAxisLabels(getContext(), sleepRecord.getFrom(), sleepRecord.getTo(), sleepRecord.getTimezone(), sleepRecord.getHistory().size());
        }
        return null;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        if (this.intervalList.isEmpty()) {
            init();
        }
        Job job = this.job;
        if (job != null) {
            Job.cancel$default(job, null, 1, null);
        }
        this.job = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C21021(viewHolder, null), 3, null);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ int getArgb(int i) {
        return super.getArgb(i);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ ColorStateList getAsColorStateList(int i) {
        return super.getAsColorStateList(i);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public Context getContext() {
        return this.context;
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ int getDip(int i) {
        return super.getDip(i);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.graphs;
    }

    public final List<SleepRecord> getSleepRecords() {
        return this.sleepRecords;
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ String getTimeNoAmPm(long j) {
        return super.getTimeNoAmPm(j);
    }

    @Override // com.urbandroid.sleep.ContextScope
    public /* bridge */ String getValue(int i) {
        return super.getValue(i);
    }

    public final void init() {
        this.dayRecordMap.clear();
        this.intervalList.clear();
        int dayCutOffHour = new Settings(getContext()).getDayCutOffHour();
        for (SleepRecord sleepRecord : this.sleepRecords) {
            Interval cutOffInterval = DateUtil.getCutOffInterval(sleepRecord.getTo(), dayCutOffHour);
            if (this.intervalList.contains(cutOffInterval)) {
                List<SleepRecord> list = this.dayRecordMap.get(cutOffInterval);
                if (list != null) {
                    list.add(sleepRecord);
                }
            } else {
                List<Interval> list2 = this.intervalList;
                cutOffInterval.getClass();
                list2.add(cutOffInterval);
                this.dayRecordMap.put(cutOffInterval, CollectionsKt.mutableListOf(sleepRecord));
            }
        }
        if (this.backgroundOffset >= this.intervalList.size()) {
            this.backgroundOffset = 0;
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void next() {
        prev();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        List<SleepRecord> currentRecords = getCurrentRecords(this.offset);
        if (currentRecords.size() > 0) {
            SleepDetailActivity.Companion.start$default(SleepDetailActivity.INSTANCE, getContext(), SleepRecords.getLongestRecord(currentRecords), false, 4, null);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardDestroyed() {
        Job job = this.job;
        if (job != null) {
            Job.cancel$default(job, null, 1, null);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void prev() {
        this.offset++;
        loadRecord();
    }
}

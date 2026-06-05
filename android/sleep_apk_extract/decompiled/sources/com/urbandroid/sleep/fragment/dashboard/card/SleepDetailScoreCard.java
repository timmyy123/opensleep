package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.graph.GraphDetailsActivity;
import com.urbandroid.sleep.gui.view.PieView;
import com.urbandroid.sleep.gui.view.ProgressRingView;
import com.urbandroid.sleep.service.Settings;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001%B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailScoreCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailScoreCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "", "sleepRecords", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;Ljava/util/List;)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailScoreCard$SleepRecordViewHolder;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailScoreCard$SleepRecordViewHolder;", "", "getLayout", "()I", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailScoreCard$SleepRecordViewHolder;)V", "getNameResource", "", "canBeSwiped", "()Z", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Ljava/util/List;", "getSleepRecords", "()Ljava/util/List;", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailScoreCard extends DashboardCard<SleepRecordViewHolder> {
    private final SleepRecord sleepRecord;
    private final List<SleepRecord> sleepRecords;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailScoreCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "setCard", "(Landroidx/cardview/widget/CardView;)V", "Landroid/view/ViewGroup;", "scoreLayout", "Landroid/view/ViewGroup;", "getScoreLayout", "()Landroid/view/ViewGroup;", "setScoreLayout", "(Landroid/view/ViewGroup;)V", "scoreValue", "getScoreValue", "setScoreValue", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private CardView card;
        private ViewGroup scoreLayout;
        private ViewGroup scoreValue;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.foreground);
            viewFindViewById.getClass();
            this.card = (CardView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.score_flow);
            viewFindViewById2.getClass();
            this.scoreLayout = (ViewGroup) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.score_value);
            viewFindViewById3.getClass();
            this.scoreValue = (ViewGroup) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.title);
            viewFindViewById4.getClass();
            this.title = (TextView) viewFindViewById4;
        }

        public final ViewGroup getScoreLayout() {
            return this.scoreLayout;
        }

        public final ViewGroup getScoreValue() {
            return this.scoreValue;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SleepDetailScoreCard(Activity activity, SleepRecord sleepRecord, List<? extends SleepRecord> list) {
        super(activity, DashboardCard.Type.SLEEP_DETAIL_SCORE, R.layout.card_sleep_detail_score_noscroll);
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
        this.sleepRecords = list;
    }

    private final void bindSleepRecordToView(SleepRecord sleepRecord, SleepRecordViewHolder viewHolder) {
        ViewGroup scoreLayout = viewHolder.getScoreLayout();
        scoreLayout.removeAllViews();
        viewHolder.getScoreValue().removeAllViews();
        viewHolder.getTitle().setText(getNameResource());
        Settings settings = new Settings(getContext());
        PieView.Companion companion = PieView.INSTANCE;
        Activity context = getContext();
        context.getClass();
        sleepRecord.getClass();
        List<SleepRecord> list = this.sleepRecords;
        list.getClass();
        SleepScore.ScoreMeasure[] scoreMeasureArr = GraphDetailsActivity.ALL_MEASURES;
        int i = 0;
        for (Object obj : PieView.Companion.getViewsForSleepRecord$default(companion, R.layout.view_pie_noanim, context, sleepRecord, list, CollectionsKt.listOf(Arrays.copyOf(scoreMeasureArr, scoreMeasureArr.length)), scoreMeasureArr.length, -1, false, R.layout.view_pie_score_card, null, 512, null)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PieView pieView = (PieView) obj;
            ((ProgressRingView) pieView.findViewById(R.id.pie_progress)).setAnimated(false);
            if (i == settings.getMeasuresPosition(SleepScore.ScoreMeasure.SCORE)) {
                viewHolder.getScoreValue().addView(pieView);
            } else {
                scoreLayout.addView(pieView);
            }
            i = i2;
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        bindSleepRecordToView(this.sleepRecord, viewHolder);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean canBeSwiped() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getLayout() {
        return isScreenshot() ? R.layout.card_sleep_detail_score_noscroll : R.layout.card_sleep_detail_score;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.score_short;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
    }
}

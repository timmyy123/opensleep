package com.urbandroid.sleep.addon.stats.goal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getpebble.android.kit.Constants;
import com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalItem;", "Lcom/urbandroid/sleep/addon/stats/goal/AbstractGoalItem;", "Lcom/urbandroid/sleep/addon/stats/goal/GoalItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/goal/Goal;", "goal", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/addon/stats/goal/GoalItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/addon/stats/goal/GoalItem$ViewHolder;)V", "onItemClicked", "()V", "Lcom/urbandroid/sleep/domain/goal/Goal;", "getGoal", "()Lcom/urbandroid/sleep/domain/goal/Goal;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoalItem extends AbstractGoalItem<ViewHolder> {
    private final Goal goal;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "summary", "getSummary", "setSummary", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "heading", "getHeading", "setHeading", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private TextView heading;
        private ImageView icon;
        private TextView summary;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.summary);
            viewFindViewById2.getClass();
            this.summary = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.icon);
            viewFindViewById3.getClass();
            this.icon = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(com.urbandroid.sleep.R.id.heading);
            viewFindViewById4.getClass();
            this.heading = (TextView) viewFindViewById4;
        }

        public final TextView getHeading() {
            return this.heading;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final TextView getSummary() {
            return this.summary;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalItem(Context context, Goal goal) {
        super(context, com.urbandroid.sleep.R.layout.row_goal_card, AbstractGoalItem.Type.GOAL);
        context.getClass();
        goal.getClass();
        this.goal = goal;
    }

    @Override // com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        Goal.Companion companion = Goal.INSTANCE;
        IValueExtractor iValueExtractorCreateExtractor = companion.createExtractor(getContext(), this.goal.type);
        viewHolder.getTitle().setText(iValueExtractorCreateExtractor.getMeasureName());
        viewHolder.getHeading().setText(getContext().getString(companion.getGoalFunnyName(this.goal.type)));
        viewHolder.getIcon().setImageResource(companion.getGoalIcon(this.goal.type));
        TextView summary = viewHolder.getSummary();
        Context context = getContext();
        int i = this.goal.getMode() < 0 ? com.urbandroid.sleep.R.string.advice_text_measure_more : com.urbandroid.sleep.R.string.advice_text_measure_less;
        String measureName = iValueExtractorCreateExtractor.getMeasureName();
        String valuePresentation = iValueExtractorCreateExtractor.getValuePresentation(this.goal.base);
        String unit = iValueExtractorCreateExtractor.getUnit();
        unit.getClass();
        String lowerCase = unit.toLowerCase(Locale.ROOT);
        summary.setText(context.getString(i, measureName, FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, valuePresentation, " ", lowerCase)));
    }

    @Override // com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem
    public void onItemClicked() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
        GoalDetailActivity.INSTANCE.start(getContext(), this.goal.type);
    }
}

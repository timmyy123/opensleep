package com.urbandroid.sleep.addon.stats.goal;

import android.R;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalExplanation;", "Lcom/urbandroid/sleep/addon/stats/goal/AbstractGoalItem;", "Lcom/urbandroid/sleep/addon/stats/goal/GoalExplanation$ViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "onItemClicked", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoalExplanation extends AbstractGoalItem<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalExplanation$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "summary", "Landroid/widget/TextView;", "getSummary", "()Landroid/widget/TextView;", "setSummary", "(Landroid/widget/TextView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private TextView summary;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.summary);
            viewFindViewById.getClass();
            this.summary = (TextView) viewFindViewById;
        }

        public final TextView getSummary() {
            return this.summary;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalExplanation(Context context) {
        super(context, com.urbandroid.sleep.R.layout.row_goal_expl, AbstractGoalItem.Type.EXPL);
        context.getClass();
    }

    @Override // com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getSummary().setText(Html.fromHtml(getContext().getString(com.urbandroid.sleep.R.string.goal_summary)));
    }

    @Override // com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.addon.stats.goal.AbstractGoalItem
    public void onItemClicked() {
    }
}

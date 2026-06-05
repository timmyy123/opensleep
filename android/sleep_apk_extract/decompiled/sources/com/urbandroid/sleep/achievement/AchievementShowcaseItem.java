package com.urbandroid.sleep.achievement;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.achievement.AbstractAchievementItem;
import com.urbandroid.sleep.achievement.AchievementItem;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/achievement/AchievementShowcaseItem;", "Lcom/urbandroid/sleep/achievement/AbstractAchievementItem;", "Lcom/urbandroid/sleep/achievement/AchievementShowcaseItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "Lcom/urbandroid/sleep/domain/achievement/Achievement;", "achievements", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/achievement/AchievementShowcaseItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/achievement/AchievementShowcaseItem$ViewHolder;)V", "onItemClicked", "()V", "Ljava/util/List;", "getAchievements", "()Ljava/util/List;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AchievementShowcaseItem extends AbstractAchievementItem<ViewHolder> {
    private final List<Achievement> achievements;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/achievement/AchievementShowcaseItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/view/ViewGroup;", "badges", "Landroid/view/ViewGroup;", "getBadges", "()Landroid/view/ViewGroup;", "setBadges", "(Landroid/view/ViewGroup;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private ViewGroup badges;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.badges);
            viewFindViewById.getClass();
            this.badges = (ViewGroup) viewFindViewById;
        }

        public final ViewGroup getBadges() {
            return this.badges;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AchievementShowcaseItem(Context context, List<Achievement> list) {
        super(context, R.layout.row_achievement_showcase, AbstractAchievementItem.Type.SHOWCASE);
        context.getClass();
        list.getClass();
        this.achievements = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0$0(AchievementShowcaseItem achievementShowcaseItem, Achievement achievement, View view) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(achievementShowcaseItem.getContext());
        FrameLayout frameLayout = new FrameLayout(achievementShowcaseItem.getContext());
        Achievement.INSTANCE.bindView(achievementShowcaseItem.getContext(), R.layout.row_achievement_plain, frameLayout, achievement, achievement.getProgressString());
        new AchievementItem(achievementShowcaseItem.getContext(), achievement).bindView(new AchievementItem.ViewHolder(frameLayout));
        materialAlertDialogBuilder.setView((View) frameLayout);
        materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(1));
        materialAlertDialogBuilder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0$0$0(DialogInterface dialogInterface, int i) {
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getBadges().removeAllViews();
        for (Achievement achievement : this.achievements) {
            Achievement.INSTANCE.bindView(getContext(), R.layout.row_achievement_badge_title, viewHolder.getBadges(), achievement, achievement.getProgressString()).setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, achievement, 3));
        }
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public void onItemClicked() {
    }
}

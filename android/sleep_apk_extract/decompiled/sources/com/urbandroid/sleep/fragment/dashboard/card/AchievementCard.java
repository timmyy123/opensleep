package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.achievement.AchievementActivity;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/AchievementCard;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AchievementCard$AchievementViewHolder;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "onCardClicked", "(Landroid/view/View;)V", "", "getNameResource", "()I", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/AchievementCard$AchievementViewHolder;)V", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/AchievementCard$AchievementViewHolder;", "", "isThemeCard", "()Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "", "getTag", "()Ljava/lang/String;", "tag", "AchievementViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AchievementCard extends DashboardCard<AchievementViewHolder> implements FeatureLogger {
    private final Activity activity;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/AchievementCard$AchievementViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "badges", "Landroid/view/ViewGroup;", "getBadges", "()Landroid/view/ViewGroup;", "th1", "Landroid/widget/TextView;", "getTh1", "()Landroid/widget/TextView;", "th2", "getTh2", "th3", "getTh3", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AchievementViewHolder extends LayeredViewHolder {
        private final ViewGroup badges;
        private final TextView th1;
        private final TextView th2;
        private final TextView th3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AchievementViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.badges);
            viewFindViewById.getClass();
            this.badges = (ViewGroup) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.th1);
            viewFindViewById2.getClass();
            this.th1 = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.th2);
            viewFindViewById3.getClass();
            this.th2 = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.th3);
            viewFindViewById4.getClass();
            this.th3 = (TextView) viewFindViewById4;
        }

        public final ViewGroup getBadges() {
            return this.badges;
        }

        public final TextView getTh1() {
            return this.th1;
        }

        public final TextView getTh2() {
            return this.th2;
        }

        public final TextView getTh3() {
            return this.th3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AchievementCard(Activity activity) {
        super(activity, DashboardCard.Type.ACHIEVEMENTS, R.layout.card_achievement);
        activity.getClass();
        this.activity = activity;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(AchievementViewHolder viewHolder) {
        viewHolder.getClass();
        getContext();
        List<Achievement> listLoadAchievements = new Settings(getContext()).loadAchievements();
        listLoadAchievements.getClass();
        List listReversed = CollectionsKt.reversed(listLoadAchievements);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listReversed) {
            if (((Achievement) obj).isLevel1()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listReversed) {
            if (((Achievement) obj2).isLevel2()) {
                arrayList2.add(obj2);
            }
        }
        int size2 = arrayList2.size();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listReversed) {
            if (((Achievement) obj3).isLevel3()) {
                arrayList3.add(obj3);
            }
        }
        int size3 = arrayList3.size();
        int length = Achievement.Type.values().length;
        viewHolder.getTh1().setText(size + " / " + length);
        viewHolder.getTh2().setText(size2 + " / " + length);
        viewHolder.getTh3().setText(size3 + " / " + length);
        viewHolder.getBadges().removeAllViews();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : listReversed) {
            if (((Achievement) obj4).earned()) {
                arrayList4.add(obj4);
            }
        }
        for (Achievement achievement : CollectionsKt.take(arrayList4, 3)) {
            Achievement.Companion companion = Achievement.INSTANCE;
            Activity context = getContext();
            context.getClass();
            ViewGroup badges = viewHolder.getBadges();
            achievement.getClass();
            Achievement.Companion.bindView$default(companion, context, R.layout.row_achievement_badge, badges, achievement, null, 16, null);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public AchievementViewHolder createViewHolder(View v) {
        v.getClass();
        return new AchievementViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.achievements;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "Achievement";
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        this.activity.startActivity(new Intent(this.activity, (Class<?>) AchievementActivity.class));
    }
}

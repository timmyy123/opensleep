package com.urbandroid.sleep.achievement;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.achievement.AbstractAchievementItem;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/achievement/AchievementSummaryItem;", "Lcom/urbandroid/sleep/achievement/AbstractAchievementItem;", "Lcom/urbandroid/sleep/achievement/AchievementSummaryItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "Lcom/urbandroid/sleep/domain/achievement/Achievement;", "achievements", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/achievement/AchievementSummaryItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/achievement/AchievementSummaryItem$ViewHolder;)V", "onItemClicked", "()V", "Ljava/util/List;", "getAchievements", "()Ljava/util/List;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AchievementSummaryItem extends AbstractAchievementItem<ViewHolder> {
    private final List<Achievement> achievements;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/achievement/AchievementSummaryItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "th1", "Landroid/widget/TextView;", "getTh1", "()Landroid/widget/TextView;", "setTh1", "(Landroid/widget/TextView;)V", "th2", "getTh2", "setTh2", "th3", "getTh3", "setTh3", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private TextView th1;
        private TextView th2;
        private TextView th3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.th1);
            viewFindViewById.getClass();
            this.th1 = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.th2);
            viewFindViewById2.getClass();
            this.th2 = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.th3);
            viewFindViewById3.getClass();
            this.th3 = (TextView) viewFindViewById3;
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
    public AchievementSummaryItem(Context context, List<Achievement> list) {
        super(context, R.layout.row_achievement_header, AbstractAchievementItem.Type.SUMMARY);
        context.getClass();
        list.getClass();
        this.achievements = list;
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        List<Achievement> list = this.achievements;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Achievement) obj).isLevel1()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        List<Achievement> list2 = this.achievements;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (((Achievement) obj2).isLevel2()) {
                arrayList2.add(obj2);
            }
        }
        int size2 = arrayList2.size();
        List<Achievement> list3 = this.achievements;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list3) {
            if (((Achievement) obj3).isLevel3()) {
                arrayList3.add(obj3);
            }
        }
        int size3 = arrayList3.size();
        int length = Achievement.Type.values().length;
        viewHolder.getTh1().setText(size + " / " + length);
        viewHolder.getTh2().setText(size2 + " / " + length);
        viewHolder.getTh3().setText(size3 + " / " + length);
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

package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0014\u0010\r\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u0000H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/ShowCaseCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/ShowCaseCard$ShowCaseViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "createViewHolder", "v", "Landroid/view/View;", "onCardClicked", "", ViewHierarchyConstants.VIEW_KEY, "bindView", "viewHolder", "isPinned", "", "getNameResource", "", "isThemeCard", "ShowCaseViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShowCaseCard extends DashboardCard<ShowCaseViewHolder> {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/ShowCaseCard$ShowCaseViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/ShowCaseCard;Landroid/view/View;)V", "image", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImage", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "desc", "getDesc", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class ShowCaseViewHolder extends LayeredViewHolder {
        private final TextView desc;
        private final ImageView image;
        final /* synthetic */ ShowCaseCard this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowCaseViewHolder(ShowCaseCard showCaseCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = showCaseCard;
            this.image = (ImageView) view.findViewById(R.id.image);
            this.title = (TextView) view.findViewById(R.id.title);
            this.desc = (TextView) view.findViewById(R.id.desc);
        }

        public final TextView getDesc() {
            return this.desc;
        }

        public final ImageView getImage() {
            return this.image;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowCaseCard(Activity activity) {
        super(activity, DashboardCard.Type.SHOW_CASE, R.layout.card_showcase);
        activity.getClass();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(ShowCaseViewHolder viewHolder) {
        viewHolder.getClass();
        if (isPinned()) {
            viewHolder.getTitle().setText(R.string.dashboard_card_showcase_long_press);
            viewHolder.getDesc().setText(R.string.dashboard_card_showcase_long_press_tip);
            viewHolder.getImage().setImageResource(R.drawable.hint_press);
        } else {
            viewHolder.getTitle().setText(R.string.dashboard_card_showcase_swipe);
            viewHolder.getDesc().setText(R.string.dashboard_card_showcase_swipe_tip);
            viewHolder.getImage().setImageResource(R.drawable.hint_slide);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public ShowCaseViewHolder createViewHolder(View v) {
        v.getClass();
        return new ShowCaseViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.menu_about;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isPinned() {
        return PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean(getPinnedSettingKey(), true);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        ViewIntent.urlCustomTab(getContext(), "https://sleep.urbandroid.org/docs//ux/homescreen.html#dashboard");
    }
}

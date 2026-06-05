package com.urbandroid.sleep.fragment.dashboard.card;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.alarmclock.AddonActivity;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.fragment.addon.AddOnBinder;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/AddOnCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AddOnCard$AddOnViewHolder;", "Landroid/app/Activity;", "activity", "Lcom/urbandroid/sleep/domain/addon/AddonApp;", "app", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/addon/AddonApp;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/AddOnCard$AddOnViewHolder;", ViewHierarchyConstants.VIEW_KEY, "", "onCardClicked", "(Landroid/view/View;)V", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/AddOnCard$AddOnViewHolder;)V", "", "getNameResource", "()I", "Lcom/urbandroid/sleep/domain/addon/AddonApp;", "getApp", "()Lcom/urbandroid/sleep/domain/addon/AddonApp;", "iconSize", "I", "padding", "AddOnViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AddOnCard extends DashboardCard<AddOnViewHolder> {
    private final AddonApp app;
    private final int iconSize;
    private final int padding;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/AddOnCard$AddOnViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/AddOnCard;Landroid/view/View;)V", "image", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImage", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "desc", "getDesc", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class AddOnViewHolder extends LayeredViewHolder {
        private final Button button;
        private final TextView desc;
        private final ImageView image;
        final /* synthetic */ AddOnCard this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddOnViewHolder(AddOnCard addOnCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = addOnCard;
            this.image = (ImageView) view.findViewById(R.id.icon);
            this.title = (TextView) view.findViewById(R.id.title);
            this.desc = (TextView) view.findViewById(R.id.summary);
            this.button = (Button) view.findViewById(com.urbandroid.sleep.R.id.button);
        }

        public final Button getButton() {
            return this.button;
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
    public AddOnCard(Activity activity, AddonApp addonApp) {
        super(activity, DashboardCard.Type.ADD_ON, com.urbandroid.sleep.R.layout.card_addon);
        activity.getClass();
        addonApp.getClass();
        this.app = addonApp;
        int iMin = Math.min(Math.max(ActivityUtils.getDip(getContext(), 36), 64), 144);
        this.iconSize = iMin;
        this.padding = (iMin - ActivityUtils.getDip(getContext(), 24)) / 2;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(AddOnViewHolder viewHolder) {
        viewHolder.getClass();
        AddOnBinder addOnBinder = new AddOnBinder();
        Activity context = getContext();
        context.getClass();
        AddonApp addonApp = this.app;
        ImageView image = viewHolder.getImage();
        image.getClass();
        TextView title = viewHolder.getTitle();
        title.getClass();
        TextView desc = viewHolder.getDesc();
        desc.getClass();
        Button button = viewHolder.getButton();
        button.getClass();
        addOnBinder.bind(context, addonApp, image, title, desc, button, this.iconSize, this.padding);
        viewHolder.getButton().setVisibility(8);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public AddOnViewHolder createViewHolder(View v) {
        v.getClass();
        return new AddOnViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return com.urbandroid.sleep.R.string.addon;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        getContext().startActivity(new Intent(getContext(), (Class<?>) AddonActivity.class));
    }
}

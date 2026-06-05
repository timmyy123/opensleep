package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getpebble.android.kit.Constants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/AiCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AiCard$AiViewHolder;", "Landroid/app/Activity;", "activity", "", "summary", "prompt", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/AiCard$AiViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/AiCard$AiViewHolder;)V", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "", "getNameResource", "()I", "", "isRemovable", "()Z", "isThemeCard", "Ljava/lang/String;", "getSummary", "()Ljava/lang/String;", "getPrompt", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "AiViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AiCard extends DashboardCard<AiViewHolder> {
    private final String prompt;
    private final Settings settings;
    private final String summary;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/AiCard$AiViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/AiCard;Landroid/view/View;)V", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "desc", "getDesc", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class AiViewHolder extends LayeredViewHolder {
        private final TextView desc;
        private ImageView icon;
        final /* synthetic */ AiCard this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AiViewHolder(AiCard aiCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = aiCard;
            View viewFindViewById = view.findViewById(R.id.icon);
            viewFindViewById.getClass();
            this.icon = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.title);
            viewFindViewById2.getClass();
            this.title = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.summary);
            viewFindViewById3.getClass();
            this.desc = (TextView) viewFindViewById3;
        }

        public final TextView getDesc() {
            return this.desc;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiCard(Activity activity, String str, String str2) {
        super(activity, DashboardCard.Type.AI, R.layout.card_ai);
        activity.getClass();
        str.getClass();
        this.summary = str;
        this.prompt = str2;
        this.settings = new Settings(activity);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(AiViewHolder viewHolder) {
        viewHolder.getClass();
        viewHolder.getDesc().setText(this.summary);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public AiViewHolder createViewHolder(View v) {
        v.getClass();
        return new AiViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.sleep_assistant;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        Activity context = getContext();
        Intent intent = new Intent(getContext(), (Class<?>) AiActivity.class);
        intent.putExtra(AiActivity.INSTANCE.getEXTRA_PROMPT(), this.prompt);
        context.startActivity(intent);
    }

    public /* synthetic */ AiCard(Activity activity, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, (i & 4) != 0 ? null : str2);
    }
}

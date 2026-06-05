package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.chip.Chip;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.shortcut.ShortcutActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/ShortcutCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/ShortcutCard$ShortcutViewHolder;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "onCardClicked", "(Landroid/view/View;)V", "settings", "()V", "", "getNameResource", "()I", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/ShortcutCard$ShortcutViewHolder;)V", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/ShortcutCard$ShortcutViewHolder;", "", "isThemeCard", "()Z", "expanded", "Z", "getExpanded", "setExpanded", "(Z)V", "ShortcutViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShortcutCard extends DashboardCard<ShortcutViewHolder> {
    private boolean expanded;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/ShortcutCard$ShortcutViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/view/ViewGroup;", "flow", "Landroid/view/ViewGroup;", "getFlow", "()Landroid/view/ViewGroup;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "Landroid/widget/ImageButton;", "settings", "Landroid/widget/ImageButton;", "getSettings", "()Landroid/widget/ImageButton;", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ShortcutViewHolder extends LayeredViewHolder {
        private final CardView card;
        private final ViewGroup flow;
        private final ImageButton settings;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShortcutViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.badges);
            viewFindViewById.getClass();
            this.flow = (ViewGroup) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.title);
            viewFindViewById2.getClass();
            this.title = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.settings);
            viewFindViewById3.getClass();
            this.settings = (ImageButton) viewFindViewById3;
            this.card = (CardView) view.findViewById(R.id.foreground);
        }

        public final ViewGroup getFlow() {
            return this.flow;
        }

        public final ImageButton getSettings() {
            return this.settings;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortcutCard(Activity activity) {
        super(activity, DashboardCard.Type.SHORTCUT, R.layout.card_shortcut);
        activity.getClass();
        this.expanded = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1$0(Shortcut shortcut, ShortcutCard shortcutCard, View view) {
        Activity context = shortcutCard.getContext();
        context.getClass();
        shortcut.execute(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2(ShortcutCard shortcutCard, View view) {
        shortcutCard.getContext().startActivity(new Intent(shortcutCard.getContext(), (Class<?>) NewAddRecordActivity.class));
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(ShortcutViewHolder viewHolder) {
        String name;
        viewHolder.getClass();
        getContext();
        Settings settings = new Settings(getContext());
        viewHolder.getTitle().setText(R.string.shortcut);
        InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
        Activity context = getContext();
        context.getClass();
        LayoutInflater layoutInflater = companion.get(context);
        final int i = 0;
        viewHolder.getSettings().setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.fragment.dashboard.card.ShortcutCard$$ExternalSyntheticLambda0
            public final /* synthetic */ ShortcutCard f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                ShortcutCard shortcutCard = this.f$0;
                switch (i2) {
                    case 0:
                        shortcutCard.settings();
                        break;
                    default:
                        ShortcutCard.bindView$lambda$2(shortcutCard, view);
                        break;
                }
            }
        });
        viewHolder.getFlow().removeAllViews();
        List<Shortcut> listLoadShortcuts = settings.loadShortcuts();
        listLoadShortcuts.getClass();
        for (Shortcut shortcut : CollectionsKt.reversed(listLoadShortcuts)) {
            View viewInflate = layoutInflater.inflate(R.layout.card_shortcut_button, viewHolder.getFlow(), false);
            viewInflate.getClass();
            Chip chip = (Chip) viewInflate;
            if (Intrinsics.areEqual(shortcut.getName(), Shortcut.INSTANCE.getDEFAULT_NAME())) {
                Activity context2 = getContext();
                context2.getClass();
                name = shortcut.getDisplayName(context2);
            } else {
                name = shortcut.getName();
            }
            chip.setText(name);
            Activity context3 = getContext();
            context3.getClass();
            chip.setChipIconResource(shortcut.getIconSmall(context3));
            chip.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(shortcut, this, 14));
            viewHolder.getFlow().addView(chip);
        }
        View viewInflate2 = layoutInflater.inflate(R.layout.card_shortcut_button, viewHolder.getFlow(), false);
        viewInflate2.getClass();
        Chip chip2 = (Chip) viewInflate2;
        chip2.setText(getContext().getString(R.string.add_record_title));
        chip2.setChipIconResource(R.drawable.ic_plus);
        final int i2 = 1;
        chip2.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.fragment.dashboard.card.ShortcutCard$$ExternalSyntheticLambda0
            public final /* synthetic */ ShortcutCard f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                ShortcutCard shortcutCard = this.f$0;
                switch (i22) {
                    case 0:
                        shortcutCard.settings();
                        break;
                    default:
                        ShortcutCard.bindView$lambda$2(shortcutCard, view);
                        break;
                }
            }
        });
        viewHolder.getFlow().addView(chip2);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public ShortcutViewHolder createViewHolder(View v) {
        v.getClass();
        return new ShortcutViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.shortcut;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
    }

    public final void settings() {
        getContext().startActivity(new Intent(getContext(), (Class<?>) ShortcutActivity.class));
    }
}

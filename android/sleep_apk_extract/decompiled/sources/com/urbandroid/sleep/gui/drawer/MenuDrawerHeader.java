package com.urbandroid.sleep.gui.drawer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.PopulationChronoStats;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.gui.drawer.IMenuDrawerItem;
import com.urbandroid.sleep.service.CalculateChronotypeService;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerHeader;", "Lcom/urbandroid/sleep/gui/drawer/IMenuDrawerItem;", "Lcom/urbandroid/sleep/gui/drawer/MenuDrawerHeader$ViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MenuDrawerHeader extends IMenuDrawerItem<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerHeader$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuDrawerHeader(Context context) {
        super(context, R.layout.header_main_drawer, IMenuDrawerItem.Type.HEADER);
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0$0(MenuDrawerHeader menuDrawerHeader, View view) {
        SleepStats.startChronotype(menuDrawerHeader.getContext());
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        CalculateChronotypeService.calculateChronotype(getContext());
        View viewFindViewById = viewHolder.itemView.findViewById(R.id.chronotype);
        if (viewFindViewById != null) {
            float chronotype = new Settings(getContext()).getChronotype();
            if (chronotype < 0.0f) {
                return;
            }
            Logger.logInfo("Chronotype " + chronotype);
            int chronotypeRank = PopulationChronoStats.getChronotypeRank(chronotype);
            if (chronotypeRank <= 0) {
                viewFindViewById.setVisibility(8);
                return;
            }
            viewFindViewById.setVisibility(0);
            ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.chronotype_badge);
            if (imageView != null) {
                imageView.setImageResource(chronotype < 0.5f ? R.drawable.lark : R.drawable.owl);
            }
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.chronotype_score);
            if (textView != null) {
                textView.setText(String.valueOf(chronotypeRank));
            }
            viewFindViewById.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 22));
        }
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }
}

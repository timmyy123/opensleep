package com.urbandroid.sleep.gui.drawer;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.gui.drawer.IMenuDrawerItem;
import com.urbandroid.util.Experiments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerAppTitle;", "Lcom/urbandroid/sleep/gui/drawer/IMenuDrawerItem;", "Lcom/urbandroid/sleep/gui/drawer/MenuDrawerAppTitle$ViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MenuDrawerAppTitle extends IMenuDrawerItem<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerAppTitle$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuDrawerAppTitle(Context context) {
        super(context, com.urbandroid.sleep.R.layout.menu_drawer_app_title, IMenuDrawerItem.Type.APP_TITLE);
        context.getClass();
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getTitle().setText(getContext().getString(com.urbandroid.sleep.R.string.app_name_long) + (Experiments.getInstance().isBeta() ? " β" : ""));
        if (TrialFilter.getInstance().isUnknownSource()) {
            viewHolder.getTitle().setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, com.urbandroid.sleep.R.drawable.ic_pirate, 0);
        } else if (TrialFilter.getInstance().isTrial()) {
            viewHolder.getTitle().setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            viewHolder.getTitle().setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, com.urbandroid.sleep.R.drawable.ic_crown, 0);
        }
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }
}

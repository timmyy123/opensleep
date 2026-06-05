package com.urbandroid.sleep.gui.drawer;

import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.gui.drawer.IMenuDrawerItem;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerHomeScreen;", "Lcom/urbandroid/sleep/gui/drawer/IMenuDrawerItem;", "Lcom/urbandroid/sleep/gui/drawer/MenuDrawerHomeScreen$ViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "onClick", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MenuDrawerHomeScreen extends IMenuDrawerItem<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerHomeScreen$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuDrawerHomeScreen(Context context) {
        super(context, R.layout.menu_drawer_home_screen, IMenuDrawerItem.Type.HOME_SCREEN_TOGGLE);
        context.getClass();
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        Settings settings = new Settings(getContext());
        MaterialButton materialButton = (MaterialButton) viewHolder.itemView.findViewById(R.id.chip_1);
        MaterialButton materialButton2 = (MaterialButton) viewHolder.itemView.findViewById(R.id.chip_2);
        MaterialButton materialButton3 = (MaterialButton) viewHolder.itemView.findViewById(R.id.title);
        if (settings.isDashboard()) {
            materialButton2.setText(R.string.tabs);
            materialButton.setText(R.string.dashboard);
            materialButton3.setIconResource(R.drawable.ic_dashboard);
        } else if (settings.isTabs()) {
            materialButton2.setText(R.string.dashboard);
            materialButton.setText(R.string.tabs);
            materialButton3.setIconResource(R.drawable.ic_tab);
        } else if (settings.isAlarmOnly()) {
            materialButton2.setText(R.string.dashboard);
            materialButton.setText(R.string.alarms_only);
            materialButton3.setIconResource(R.drawable.ic_alarm);
        }
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public void onClick() {
        super.onClick();
        if (getContext() instanceof AlarmClock) {
            ((AlarmClock) getContext()).startHomeScreenSelectionDialog();
        }
    }
}

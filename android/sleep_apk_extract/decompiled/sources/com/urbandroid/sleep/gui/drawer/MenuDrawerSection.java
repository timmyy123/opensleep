package com.urbandroid.sleep.gui.drawer;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.gui.drawer.IMenuDrawerItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerSection;", "Lcom/urbandroid/sleep/gui/drawer/IMenuDrawerItem;", "Lcom/urbandroid/sleep/gui/drawer/MenuDrawerSection$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "text", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/gui/drawer/MenuDrawerSection$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/gui/drawer/MenuDrawerSection$ViewHolder;)V", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MenuDrawerSection extends IMenuDrawerItem<ViewHolder> {
    private final String text;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/gui/drawer/MenuDrawerSection$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    public MenuDrawerSection(Context context, String str) {
        super(context, com.urbandroid.sleep.R.layout.menu_drawer_section, IMenuDrawerItem.Type.SECTION);
        context.getClass();
        str.getClass();
        this.text = str;
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getTitle().setText(this.text);
    }

    @Override // com.urbandroid.sleep.gui.drawer.IMenuDrawerItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }
}

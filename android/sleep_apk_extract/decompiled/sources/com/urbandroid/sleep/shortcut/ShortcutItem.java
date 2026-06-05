package com.urbandroid.sleep.shortcut;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.getpebble.android.kit.Constants;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.shortcut.AbstractShortcutItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/shortcut/ShortcutItem;", "Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem;", "Lcom/urbandroid/sleep/shortcut/ShortcutItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/shortcut/Shortcut;", "shortcut", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/shortcut/Shortcut;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/shortcut/ShortcutItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/shortcut/ShortcutItem$ViewHolder;)V", "onItemClicked", "()V", "Lcom/urbandroid/sleep/domain/shortcut/Shortcut;", "getShortcut", "()Lcom/urbandroid/sleep/domain/shortcut/Shortcut;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShortcutItem extends AbstractShortcutItem<ViewHolder> {
    private final Shortcut shortcut;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/shortcut/ShortcutItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "summary", "getSummary", "setSummary", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/Button;", "play", "Landroid/widget/Button;", "getPlay", "()Landroid/widget/Button;", "setPlay", "(Landroid/widget/Button;)V", "level", "getLevel", "setLevel", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private ImageView icon;
        private ImageView level;
        private Button play;
        private TextView summary;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.summary);
            viewFindViewById2.getClass();
            this.summary = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.icon);
            viewFindViewById3.getClass();
            this.icon = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(com.urbandroid.sleep.R.id.play);
            viewFindViewById4.getClass();
            this.play = (Button) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(com.urbandroid.sleep.R.id.level);
            viewFindViewById5.getClass();
            this.level = (ImageView) viewFindViewById5;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final Button getPlay() {
            return this.play;
        }

        public final TextView getSummary() {
            return this.summary;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortcutItem(Context context, Shortcut shortcut) {
        super(context, com.urbandroid.sleep.R.layout.row_shortcut, AbstractShortcutItem.Type.SHORTCUT);
        context.getClass();
        shortcut.getClass();
        this.shortcut = shortcut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(ShortcutItem shortcutItem, View view) {
        shortcutItem.shortcut.execute(shortcutItem.getContext());
    }

    @Override // com.urbandroid.sleep.shortcut.AbstractShortcutItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        if (Intrinsics.areEqual(this.shortcut.getName(), Shortcut.INSTANCE.getDEFAULT_NAME())) {
            viewHolder.getSummary().setText("");
            viewHolder.getTitle().setText(this.shortcut.getDisplayName(getContext()));
            viewHolder.getSummary().setVisibility(8);
        } else {
            viewHolder.getTitle().setText(this.shortcut.getName());
            viewHolder.getSummary().setVisibility(0);
            viewHolder.getSummary().setText(this.shortcut.getDisplayName(getContext()));
        }
        viewHolder.getIcon().setImageResource(this.shortcut.getIcon(getContext()));
        viewHolder.getPlay().setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 28));
    }

    @Override // com.urbandroid.sleep.shortcut.AbstractShortcutItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.shortcut.AbstractShortcutItem
    public void onItemClicked() {
        Intent intent = new Intent(getContext(), (Class<?>) AddShortcutActivity.class);
        intent.putExtra(Shortcut.INSTANCE.getEXTRA_SHORTCUT(), this.shortcut.toString());
        getContext().startActivity(intent);
    }
}

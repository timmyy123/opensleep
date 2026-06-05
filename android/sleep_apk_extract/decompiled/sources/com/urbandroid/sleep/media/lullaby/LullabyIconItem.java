package com.urbandroid.sleep.media.lullaby;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getpebble.android.kit.Constants;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;
import com.urbandroid.sleep.media.lullaby.LullabyItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyIconItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyIconItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "text", "lullabyName", "summary", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/media/lullaby/LullabyIconItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/media/lullaby/LullabyIconItem$ViewHolder;)V", "onItemClicked", "()V", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "getLullabyName", "getSummary", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Landroid/widget/ProgressBar;", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyIconItem extends LullabyItem<ViewHolder> {
    private final Drawable drawable;
    private final String lullabyName;
    private ProgressBar progress;
    private final String summary;
    private final String text;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyIconItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "summary", "getSummary", "setSummary", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/ProgressBar;", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private ImageView icon;
        private ProgressBar progress;
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
            View viewFindViewById4 = view.findViewById(com.urbandroid.sleep.R.id.progress);
            viewFindViewById4.getClass();
            this.progress = (ProgressBar) viewFindViewById4;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final ProgressBar getProgress() {
            return this.progress;
        }

        public final TextView getSummary() {
            return this.summary;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LullabyIconItem(Context context, String str, String str2, String str3, Drawable drawable) {
        super(context, com.urbandroid.sleep.R.layout.fragment_lullaby_item, LullabyItem.Type.LULLABY);
        context.getClass();
        str.getClass();
        str2.getClass();
        drawable.getClass();
        this.text = str;
        this.lullabyName = str2;
        this.summary = str3;
        this.drawable = drawable;
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getTitle().setText(this.text);
        viewHolder.getIcon().setImageDrawable(this.drawable);
        this.progress = viewHolder.getProgress();
        if (this.summary == null) {
            viewHolder.getSummary().setVisibility(8);
            viewHolder.getSummary().setText((CharSequence) null);
        } else {
            viewHolder.getSummary().setText(this.summary);
            viewHolder.getSummary().setVisibility(0);
        }
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void onItemClicked() {
        LullabyDialogFragment.startPlayingLullaby(getContext(), this.lullabyName, this.progress);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        LullabyActivity.Companion companion = LullabyActivity.INSTANCE;
        localBroadcastManager.sendBroadcast(new Intent(companion.getACTION_REFRESH()));
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent(companion.getACTION_CLOSE()));
    }
}

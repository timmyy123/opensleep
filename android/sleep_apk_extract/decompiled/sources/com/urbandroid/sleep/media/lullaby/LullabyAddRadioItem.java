package com.urbandroid.sleep.media.lullaby;

import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.lullaby.LullabyFragment;
import com.urbandroid.sleep.media.lullaby.LullabyItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyAddRadioItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyAddRadioItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "adapter", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/media/lullaby/LullabyAddRadioItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/media/lullaby/LullabyAddRadioItem$ViewHolder;)V", "onItemClicked", "()V", "Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "getAdapter", "()Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyAddRadioItem extends LullabyItem<ViewHolder> {
    private final LullabyRecyclerViewAdapter adapter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyAddRadioItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LullabyAddRadioItem(Context context, LullabyRecyclerViewAdapter lullabyRecyclerViewAdapter) {
        super(context, R.layout.fragment_lullaby_add_radio, LullabyItem.Type.ADD_RADIO);
        context.getClass();
        lullabyRecyclerViewAdapter.getClass();
        this.adapter = lullabyRecyclerViewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onItemClicked$lambda$0(LullabyAddRadioItem lullabyAddRadioItem) {
        lullabyAddRadioItem.adapter.changeSection(LullabyFragment.Section.RADIO);
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void onItemClicked() {
        MediaListActivity.createAddRadioDialog(getContext(), new LullabyAddRadioItem$$ExternalSyntheticLambda0(this)).show();
    }
}

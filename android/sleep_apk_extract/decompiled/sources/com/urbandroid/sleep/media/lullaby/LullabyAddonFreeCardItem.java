package com.urbandroid.sleep.media.lullaby;

import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.media.lullaby.LullabyItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyAddonFreeCardItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyAddonFreeCardItem$ViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "onItemClicked", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyAddonFreeCardItem extends LullabyItem<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyAddonFreeCardItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LullabyAddonFreeCardItem(Context context) {
        super(context, R.layout.fragment_lullaby_addon_free_card, LullabyItem.Type.CARD_ADDON_FREE);
        context.getClass();
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
        ViewIntent.market(getContext(), "com.urbandroid.sleep.lullaby");
    }
}

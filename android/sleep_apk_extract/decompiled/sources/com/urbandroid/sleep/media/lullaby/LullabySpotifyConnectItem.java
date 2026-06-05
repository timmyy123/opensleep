package com.urbandroid.sleep.media.lullaby;

import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.media.lullaby.LullabyItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyConnectItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyConnectItem$ViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabySpotifyConnectItem extends LullabyItem<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyConnectItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Lcom/google/android/material/button/MaterialButton;", "button", "Lcom/google/android/material/button/MaterialButton;", "getButton", "()Lcom/google/android/material/button/MaterialButton;", "setButton", "(Lcom/google/android/material/button/MaterialButton;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private MaterialButton button;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.buttonConnect);
            viewFindViewById.getClass();
            this.button = (MaterialButton) viewFindViewById;
        }

        public final MaterialButton getButton() {
            return this.button;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LullabySpotifyConnectItem(Context context) {
        super(context, R.layout.fragment_lullaby_spotify_connect, LullabyItem.Type.SPOTIFY_CONNECT);
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(LullabySpotifyConnectItem lullabySpotifyConnectItem, View view) {
        SimpleSettingsActivity.startHighlight(lullabySpotifyConnectItem.getContext(), ServicesSettingsActivity.class, "spotify");
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getButton().setOnClickListener(new LullabyItem$$ExternalSyntheticLambda0(this, 3));
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }
}

package com.urbandroid.sleep.media.lullaby;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.getpebble.android.kit.Constants;
import com.squareup.picasso.Picasso;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.media.lullaby.LullabyDialogFragment;
import com.urbandroid.sleep.media.lullaby.LullabyItem;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.RoundCornersTransform;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(BA\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "text", ShareConstants.MEDIA_URI, "artist", "imgUri", "", "bgColorRes", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyItem$ViewHolder;)V", "onItemClicked", "()V", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "getUri", "getArtist", "getImgUri", "Ljava/lang/Integer;", "getBgColorRes", "()Ljava/lang/Integer;", "Landroid/widget/ProgressBar;", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabySpotifyItem extends LullabyItem<ViewHolder> {
    private final String artist;
    private final Integer bgColorRes;
    private final String imgUri;
    private ProgressBar progress;
    private final String text;
    private final String uri;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0005¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabySpotifyItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "summary", "getSummary", "setSummary", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "iconBg", "getIconBg", "setIconBg", "Landroid/widget/ProgressBar;", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "refresh", "Landroid/view/View;", "getRefresh", "()Landroid/view/View;", "setRefresh", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private ImageView icon;
        private ImageView iconBg;
        private ProgressBar progress;
        private View refresh;
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
            View viewFindViewById4 = view.findViewById(com.urbandroid.sleep.R.id.icon_bg);
            viewFindViewById4.getClass();
            this.iconBg = (ImageView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(com.urbandroid.sleep.R.id.progress);
            viewFindViewById5.getClass();
            this.progress = (ProgressBar) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(com.urbandroid.sleep.R.id.refresh);
            viewFindViewById6.getClass();
            this.refresh = viewFindViewById6;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final ImageView getIconBg() {
            return this.iconBg;
        }

        public final ProgressBar getProgress() {
            return this.progress;
        }

        public final View getRefresh() {
            return this.refresh;
        }

        public final TextView getSummary() {
            return this.summary;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LullabySpotifyItem(Context context, String str, String str2, String str3, String str4, Integer num) {
        super(context, com.urbandroid.sleep.R.layout.fragment_lullaby_spotify_item, LullabyItem.Type.LULLABY_SPOTIFY);
        context.getClass();
        str.getClass();
        str2.getClass();
        this.text = str;
        this.uri = str2;
        this.artist = str3;
        this.imgUri = str4;
        this.bgColorRes = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(LullabySpotifyItem lullabySpotifyItem, Handler handler, View view) {
        Logger.logInfo("Lullaby: Spotify refresh");
        view.startAnimation(AnimationUtils.loadAnimation(lullabySpotifyItem.getContext(), com.urbandroid.sleep.R.anim.rotate_twice));
        handler.postDelayed(new LullabySpotifyItem$$ExternalSyntheticLambda1(lullabySpotifyItem, 0), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0$0(LullabySpotifyItem lullabySpotifyItem) {
        LocalBroadcastManager.getInstance(lullabySpotifyItem.getContext()).sendBroadcast(new Intent(LullabyActivity.INSTANCE.getACTION_REFRESH_SPOTIFY()));
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getTitle().setText(this.text);
        this.progress = viewHolder.getProgress();
        Handler handler = new Handler();
        String str = this.artist;
        if (str == null || StringsKt.trim(str).toString().length() == 0) {
            viewHolder.getSummary().setVisibility(8);
            viewHolder.getSummary().setText("");
        } else {
            viewHolder.getSummary().setVisibility(0);
            viewHolder.getSummary().setText(this.artist);
        }
        viewHolder.getRefresh().setVisibility(8);
        viewHolder.getIcon().setImageResource(com.urbandroid.sleep.R.drawable.preview_empty);
        viewHolder.getIconBg().setImageResource(com.urbandroid.sleep.R.drawable.circle_bg_accent);
        String str2 = this.imgUri;
        if (str2 != null && str2.length() > 0) {
            Picasso.with(getContext().getApplicationContext()).load(this.imgUri).resize(48, 48).transform(new RoundCornersTransform(ActivityUtils.getDip(getContext(), 48))).into(viewHolder.getIcon());
            return;
        }
        if (Intrinsics.areEqual("spotify-play-last-song", this.uri)) {
            viewHolder.getIcon().setImageResource(com.urbandroid.sleep.R.drawable.ic_lullaby_spotify_color);
            if (SharedApplicationContext.getSettings().isSpotify()) {
                viewHolder.getRefresh().setVisibility(0);
                viewHolder.getRefresh().setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, handler, 22));
                return;
            }
            return;
        }
        viewHolder.getIcon().setImageResource(com.urbandroid.sleep.R.drawable.ic_lullaby_spotify_overlay);
        if (this.bgColorRes != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            gradientDrawable.setColor(ColorUtil.i(getContext(), this.bgColorRes.intValue()));
            viewHolder.getIconBg().setImageDrawable(gradientDrawable);
        }
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void onItemClicked() {
        LullabyDialogFragment.startPlayingLullaby(getContext(), new LullabyDialogFragment.RadioItem(this.text, this.uri), this.progress);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent(LullabyActivity.INSTANCE.getACTION_CLOSE()));
    }

    public /* synthetic */ LullabySpotifyItem(Context context, String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, (i & 8) != 0 ? null : str3, str4, (i & 32) != 0 ? null : num);
    }
}

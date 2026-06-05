package com.urbandroid.sleep.fragment.dashboard.card;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.Experiments;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\tJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\n2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010\"R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/NewsCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/NewsCard$NewsViewHolder;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "getCurrentNewsNumber", "()I", "", "setCurrentNewsAsShown", "()V", "getLastShownCard", "", "shouldShowCurrentNews", "()Z", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/NewsCard$NewsViewHolder;", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/NewsCard$NewsViewHolder;)V", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "getNameResource", "isRemovable", "isThemeCard", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "currentNewsNumber", "I", "currentNewsText", "currentNewsTitle", "Landroid/content/Intent;", "currentNewsIntent", "Landroid/content/Intent;", "currentNewsDrawableRes", "Ljava/text/SimpleDateFormat;", "sdf", "Ljava/text/SimpleDateFormat;", "getSdf", "()Ljava/text/SimpleDateFormat;", "setSdf", "(Ljava/text/SimpleDateFormat;)V", "", "currentNewsExpiration", "J", "NewsViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NewsCard extends DashboardCard<NewsViewHolder> {
    private final int currentNewsDrawableRes;
    private long currentNewsExpiration;
    private Intent currentNewsIntent;
    private final int currentNewsNumber;
    private final int currentNewsText;
    private final int currentNewsTitle;
    private SimpleDateFormat sdf;
    private final Settings settings;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/NewsCard$NewsViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/NewsCard;Landroid/view/View;)V", "Landroid/widget/ImageView;", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "setImage", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "desc", "getDesc", "news", "getNews", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class NewsViewHolder extends LayeredViewHolder {
        private final TextView desc;
        private ImageView image;
        private final TextView news;
        final /* synthetic */ NewsCard this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewsViewHolder(NewsCard newsCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = newsCard;
            View viewFindViewById = view.findViewById(R.id.image);
            viewFindViewById.getClass();
            this.image = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.title);
            viewFindViewById2.getClass();
            this.title = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.desc);
            viewFindViewById3.getClass();
            this.desc = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.news);
            viewFindViewById4.getClass();
            this.news = (TextView) viewFindViewById4;
        }

        public final TextView getDesc() {
            return this.desc;
        }

        public final ImageView getImage() {
            return this.image;
        }

        public final TextView getNews() {
            return this.news;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsCard(Activity activity) throws ParseException {
        super(activity, DashboardCard.Type.NEWS, R.layout.card_news);
        activity.getClass();
        this.settings = new Settings(activity);
        this.currentNewsNumber = 27;
        this.currentNewsText = R.string.video_news;
        this.currentNewsTitle = R.string.watch_video;
        Intent urlIntent = ViewIntent.getUrlIntent(activity, "https://youtu.be/whUibMSqkO4");
        urlIntent.getClass();
        this.currentNewsIntent = urlIntent;
        this.currentNewsDrawableRes = R.drawable.preview_movie;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm", Locale.ENGLISH);
        this.sdf = simpleDateFormat;
        Date date = simpleDateFormat.parse("Aug 25 2025 12:00");
        date.getClass();
        this.currentNewsExpiration = date.getTime();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(NewsViewHolder viewHolder) {
        viewHolder.getClass();
        if (!shouldShowCurrentNews()) {
            Activity context = getContext();
            View view = viewHolder.itemView;
            view.getClass();
            setCardVisibility(context, (ViewGroup) view, false);
            Logger.logInfo("NewsCard: bind not now");
            return;
        }
        Logger.logInfo("NewsCard: binding");
        viewHolder.getTitle().setText(getContext().getString(this.currentNewsTitle));
        viewHolder.getDesc().setText(getContext().getString(this.currentNewsText));
        if (this.currentNewsNumber == 20) {
            viewHolder.getTitle().setText(getContext().getString(R.string.ringtone_sleepyheads_ALL) + "! " + getContext().getString(R.string.generic_new_feature));
            viewHolder.getDesc().setText(getContext().getString(R.string.settings_wake_up_check) + ": " + getContext().getString(R.string.wake_up_check_expl));
        }
        if (this.currentNewsNumber == 18) {
            viewHolder.getTitle().setText(getContext().getString(R.string.morning_briefing) + " + " + getContext().getString(R.string.graphs));
            viewHolder.getDesc().setText(getContext().getString(R.string.dashboard_card_showcase_long_press_tip) + " " + getContext().getString(R.string.dashboard_card_showcase_swipe) + ".");
        }
        if (this.currentNewsNumber == 25 && TrialFilter.getInstance().isTrial()) {
            viewHolder.getTitle().setText("12 " + getContext().getString(R.string.addons_lullaby_more_short));
            TextView desc = viewHolder.getDesc();
            String string = getContext().getString(R.string.lullaby_name_JACUZZI);
            String string2 = getContext().getString(R.string.lullaby_name_MEDIEVAL);
            String string3 = getContext().getString(R.string.lullaby_name_EXPLORATION);
            String string4 = getContext().getString(R.string.lullaby_name_VIKING);
            String string5 = getContext().getString(R.string.lullaby_name_SOLFEGGIO);
            String string6 = getContext().getString(R.string.lullaby_name_MEDITATION);
            String string7 = getContext().getString(R.string.lullaby_name_GREGORIAN);
            String string8 = getContext().getString(R.string.lullaby_name_DEEP);
            String string9 = getContext().getString(R.string.lullaby_name_SHAMAN);
            String string10 = getContext().getString(R.string.lullaby_name_DIDGE);
            String string11 = getContext().getString(R.string.lullaby_name_PLANET);
            StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(string, ", ", string2, ", ", string3);
            FileInsert$$ExternalSyntheticOutline0.m(sbM66m, ", ", string4, ", ", string5);
            FileInsert$$ExternalSyntheticOutline0.m(sbM66m, ", ", string6, ", ", string7);
            FileInsert$$ExternalSyntheticOutline0.m(sbM66m, ", ", string8, ", ", string9);
            FileInsert$$ExternalSyntheticOutline0.m(sbM66m, ", ", string10, ", ", string11);
            sbM66m.append("...");
            desc.setText(sbM66m.toString());
        }
        if (this.currentNewsNumber == 24) {
            TextView title = viewHolder.getTitle();
            String string12 = getContext().getString(R.string.lullaby);
            String string13 = getContext().getString(R.string.alert_playlist);
            string13.getClass();
            String lowerCase = string13.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            title.setText(string12 + " " + lowerCase);
        }
        TextView news = viewHolder.getNews();
        String string14 = getContext().getString(R.string.news);
        string14.getClass();
        String upperCase = string14.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        news.setText(upperCase);
        if (this.currentNewsDrawableRes == -1) {
            viewHolder.getImage().setVisibility(8);
        } else {
            viewHolder.getImage().setVisibility(0);
            viewHolder.getImage().setImageResource(this.currentNewsDrawableRes);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public NewsViewHolder createViewHolder(View v) {
        v.getClass();
        return new NewsViewHolder(this, v);
    }

    public final int getCurrentNewsNumber() {
        return this.currentNewsNumber;
    }

    public final int getLastShownCard() {
        return this.settings.getNewsShown();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.news;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        setCurrentNewsAsShown();
        removeForNow();
        try {
            if (this.currentNewsNumber == 23 && TrialFilter.getInstance().isTrial()) {
                getContext().startActivity(ViewIntent.getUrlIntent(getContext(), "market://details?id=com.urbandroid.sleep.addon.lullaby"));
            } else {
                getContext().startActivity(this.currentNewsIntent);
            }
        } catch (Exception e) {
            Logger.logSevere(e);
            getContext().sendBroadcast(this.currentNewsIntent);
        }
    }

    public final void setCurrentNewsAsShown() {
        this.settings.setNewsShown(this.currentNewsNumber);
    }

    public final boolean shouldShowCurrentNews() {
        if (this.currentNewsNumber == 2 && !this.settings.isDashboardUninitialized()) {
            setCurrentNewsAsShown();
            return false;
        }
        if (System.currentTimeMillis() > this.currentNewsExpiration) {
            setCurrentNewsAsShown();
            return false;
        }
        zza$$ExternalSyntheticOutline0.m(this.currentNewsNumber, this.settings.getNewsShown(), "NewsCard: ", " ?> ");
        boolean z = this.currentNewsNumber > this.settings.getNewsShown();
        if (this.currentNewsNumber == 10 && !this.settings.isSpotify()) {
            Logger.logInfo("NewsCard: not shown - spotify not enabled");
            return false;
        }
        if (this.currentNewsNumber == 10 && this.settings.isSpotify() && this.settings.isSpotifyAppRemoteScopeAllowed()) {
            Logger.logInfo("NewsCard: not shown - spotify app-remote scope already enabled");
            return false;
        }
        if (this.currentNewsNumber == 10 && this.settings.isSpotify() && !ISpotifyPlayer.INSTANCE.isSpotifyPremium()) {
            Logger.logInfo("NewsCard: not shown - spotify not premium");
            return false;
        }
        if (this.currentNewsNumber == 9 && !Experiments.getInstance().isSMSExperiment()) {
            Logger.logInfo("NewsCard: not shown US only");
            return false;
        }
        if (this.currentNewsNumber == 25 && (TrialFilter.getInstance().isAddonLullabyFree() || TrialFilter.getInstance().isAddonLullaby())) {
            Logger.logInfo("NewsCard: not shown has lullaby or in trial");
            return false;
        }
        zza$$ExternalSyntheticOutline0.m("NewsCard: should show ", z);
        return z;
    }
}

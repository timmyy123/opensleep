package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.text.HtmlCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00072\n\u0010\u0011\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\fR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010 R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100¨\u00063"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/PromoCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/PromoCard$PromoViewHolder;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "setCurrentPromoAsShown", "()V", "", "shouldShowCurrentPromo", "()Z", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/PromoCard$PromoViewHolder;", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/PromoCard$PromoViewHolder;)V", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "", "getNameResource", "()I", "isRemovable", "isThemeCard", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "currentPromoNumber", "I", "currentPromoTitle", "currentPromoText", "Landroid/content/Intent;", "currentPromoIntent", "Landroid/content/Intent;", "currentPromoDrawableRes", "Ljava/text/SimpleDateFormat;", "sdf", "Ljava/text/SimpleDateFormat;", "getSdf", "()Ljava/text/SimpleDateFormat;", "setSdf", "(Ljava/text/SimpleDateFormat;)V", "", "currentPromoExpiration", "J", "currentPromoStart", "PromoViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PromoCard extends DashboardCard<PromoViewHolder> {
    private final int currentPromoDrawableRes;
    private long currentPromoExpiration;
    private final Intent currentPromoIntent;
    private final int currentPromoNumber;
    private long currentPromoStart;
    private final int currentPromoText;
    private final int currentPromoTitle;
    private SimpleDateFormat sdf;
    private final Settings settings;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/PromoCard$PromoViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/PromoCard;Landroid/view/View;)V", "Landroid/widget/ImageView;", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "setImage", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "desc", "getDesc", "news", "getNews", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class PromoViewHolder extends LayeredViewHolder {
        private final TextView desc;
        private ImageView image;
        private final TextView news;
        final /* synthetic */ PromoCard this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PromoViewHolder(PromoCard promoCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = promoCard;
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
    public PromoCard(Activity activity) throws ParseException {
        super(activity, DashboardCard.Type.PROMO, R.layout.card_promo);
        activity.getClass();
        this.settings = new Settings(activity);
        this.currentPromoNumber = 1;
        this.currentPromoTitle = R.string.featured_fitify_title;
        this.currentPromoText = R.string.featured_fitify_desc;
        Intent urlIntent = ViewIntent.getUrlIntent(activity, getContext().getString(R.string.featured_fitify_link));
        urlIntent.getClass();
        this.currentPromoIntent = urlIntent;
        this.currentPromoDrawableRes = R.drawable.featured_fitify_icon;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm", Locale.ENGLISH);
        this.sdf = simpleDateFormat;
        Date date = simpleDateFormat.parse("Oct 31 2022 12:00");
        date.getClass();
        this.currentPromoExpiration = date.getTime();
        Date date2 = this.sdf.parse("Aug 1 2022 12:00");
        date2.getClass();
        this.currentPromoStart = date2.getTime();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(PromoViewHolder viewHolder) {
        viewHolder.getClass();
        if (!shouldShowCurrentPromo()) {
            Activity context = getContext();
            View view = viewHolder.itemView;
            view.getClass();
            setCardVisibility(context, (ViewGroup) view, false);
            removeForNow();
            Logger.logInfo("PromoCard: bind not now");
            return;
        }
        Logger.logInfo("PromoCard: binding");
        viewHolder.getTitle().setText(getContext().getString(this.currentPromoTitle));
        String string = getContext().getString(this.currentPromoText);
        string.getClass();
        viewHolder.getDesc().setText(HtmlCompat.fromHtml(string, 63));
        TextView news = viewHolder.getNews();
        String string2 = getContext().getString(R.string.news);
        string2.getClass();
        String upperCase = string2.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        news.setText(upperCase);
        if (this.currentPromoDrawableRes == -1) {
            viewHolder.getImage().setVisibility(8);
        } else {
            viewHolder.getImage().setVisibility(0);
            viewHolder.getImage().setImageResource(this.currentPromoDrawableRes);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public PromoViewHolder createViewHolder(View v) {
        v.getClass();
        return new PromoViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.promo;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        setCurrentPromoAsShown();
        removeForNow();
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventPromoCard();
        try {
            getContext().startActivity(this.currentPromoIntent);
        } catch (Exception e) {
            Logger.logSevere(e);
            Toast.makeText(getContext(), R.string.general_unspecified_error, 0).show();
        }
    }

    public final void setCurrentPromoAsShown() {
        this.settings.setPromoShown(this.currentPromoNumber);
    }

    public final boolean shouldShowCurrentPromo() {
        if (System.currentTimeMillis() < this.currentPromoStart) {
            return false;
        }
        if (System.currentTimeMillis() > this.currentPromoExpiration) {
            setCurrentPromoAsShown();
            return false;
        }
        boolean z = this.currentPromoNumber > this.settings.getPromoShown();
        zza$$ExternalSyntheticOutline0.m("PromoCard: should show ", z);
        return z;
    }
}

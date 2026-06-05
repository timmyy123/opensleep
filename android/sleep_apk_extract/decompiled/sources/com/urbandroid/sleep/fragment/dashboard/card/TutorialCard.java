package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.FirstUsePreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.gui.AnimationEndListener;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.List;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0001(B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/PageAwareDashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialCard$TutorialViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialItem;", "items", "<init>", "(Landroid/app/Activity;Ljava/util/List;)V", "", "fixOffset", "()V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialCard$TutorialViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialCard$TutorialViewHolder;)V", "activity", "startTutorial", "(Landroid/app/Activity;Landroid/view/View;)V", "", "getNameResource", "()I", "", "isThemeCard", "()Z", "next", "prev", "Ljava/util/List;", "getItems", "()Ljava/util/List;", SpotifyService.OFFSET, "I", "backgroundOffset", "TutorialViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialCard extends PageAwareDashboardCard<TutorialViewHolder> {
    private int backgroundOffset;
    private final List<TutorialItem> items;
    private int offset;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialCard$TutorialViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialCard;Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class TutorialViewHolder extends LayeredViewHolder {
        public TutorialViewHolder(View view) {
            super(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialCard(Activity activity, List<TutorialItem> list) {
        super(activity, DashboardCard.Type.NO_GRAPHS, R.layout.card_tutorial);
        list.getClass();
        this.items = list;
        this.backgroundOffset = list.size() <= 1 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(TutorialCard tutorialCard, TutorialViewHolder tutorialViewHolder) {
        Logger.logInfo("AlarmClock: set tutorial shown");
        Activity context = tutorialCard.getContext();
        context.getClass();
        View view = tutorialViewHolder.itemView;
        view.getClass();
        tutorialCard.startTutorial(context, view);
    }

    private final void fixOffset() {
        if (this.offset < 0) {
            this.offset = 0;
        }
        if (this.offset >= this.items.size()) {
            this.offset = 0;
            new Settings(getContext()).addShowCaseShown("sc_tutorial_tap_on_card");
        }
        int i = this.offset + 1;
        this.backgroundOffset = i;
        if (i >= this.items.size()) {
            this.backgroundOffset = 0;
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(final TutorialViewHolder viewHolder) {
        viewHolder.getClass();
        this.offset = new Settings(getContext()).getTutorialPage();
        fixOffset();
        ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText(this.items.get(this.offset).getTitle());
        ((TextView) viewHolder.itemView.findViewById(R.id.summary)).setText(this.items.get(this.offset).getSummary());
        ((ImageView) viewHolder.itemView.findViewById(R.id.image)).setImageResource(this.items.get(this.offset).getImageRes());
        int imageRes = this.items.get(this.offset).getImageRes();
        View view = viewHolder.itemView;
        if (imageRes == 0) {
            ((ImageView) view.findViewById(R.id.image)).setVisibility(8);
        } else {
            ((ImageView) view.findViewById(R.id.image)).setVisibility(0);
        }
        ((TextView) viewHolder.itemView.findViewById(R.id.titleBackground)).setText(this.items.get(this.backgroundOffset).getTitle());
        ((TextView) viewHolder.itemView.findViewById(R.id.summaryBackground)).setText(this.items.get(this.backgroundOffset).getSummary());
        ((CardView) viewHolder.itemView.findViewById(R.id.foreground)).setCardBackgroundColor(this.items.get(this.offset).getColor());
        ((TextView) viewHolder.itemView.findViewById(R.id.slideHint)).setText(R.string.next);
        ((TextView) viewHolder.itemView.findViewById(R.id.tapHint)).setText(R.string.hint_tap);
        int i = this.offset;
        View view2 = viewHolder.itemView;
        if (i == 0) {
            ((TextView) view2.findViewById(R.id.slideHint)).setVisibility(0);
            ((TextView) viewHolder.itemView.findViewById(R.id.slideHint)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_left_loop));
        } else {
            ((TextView) view2.findViewById(R.id.slideHint)).setVisibility(8);
        }
        int i2 = this.offset;
        View view3 = viewHolder.itemView;
        if (i2 > 0) {
            ((TextView) view3.findViewById(R.id.tapHint)).setVisibility(0);
            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.tapHint);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.click_hint);
            animationLoadAnimation.setAnimationListener(new AnimationEndListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.TutorialCard$bindView$1$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation p0) {
                    ((TextView) viewHolder.itemView.findViewById(R.id.tapHint)).setVisibility(8);
                }
            });
            textView.startAnimation(animationLoadAnimation);
        } else {
            ((TextView) view3.findViewById(R.id.tapHint)).setVisibility(8);
        }
        ((ViewGroup) viewHolder.itemView.findViewById(R.id.background)).setVisibility(0);
        ((ViewGroup) viewHolder.itemView.findViewById(R.id.backgroundHide)).setVisibility(8);
        if (this.items.get(this.offset).getLast()) {
            ((TextView) viewHolder.itemView.findViewById(R.id.tapHint)).setText(R.string.restart);
            ((ViewGroup) viewHolder.itemView.findViewById(R.id.background)).setVisibility(8);
            ((ViewGroup) viewHolder.itemView.findViewById(R.id.backgroundHide)).setVisibility(0);
            ((TextView) viewHolder.itemView.findViewById(R.id.slideHint)).setVisibility(0);
            ((TextView) viewHolder.itemView.findViewById(R.id.slideHint)).setText(R.string.hide);
            ((TextView) viewHolder.itemView.findViewById(R.id.slideHint)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_left_loop));
        }
        if (!TrialFilter.getInstance().isFirstUsage() || SharedApplicationContext.getSettings().isShowCaseShown(FirstUsePreviewActivity.SHOWN_TUTORIAL)) {
            return;
        }
        new Handler().postDelayed(new StartTrackActivity$$ExternalSyntheticLambda0(this, viewHolder, 5), 1000L);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public TutorialViewHolder createViewHolder(View v) {
        v.getClass();
        return new TutorialViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.menu_about;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void next() {
        fixOffset();
        if (this.items.get(this.offset).getLast()) {
            new Settings(getContext()).setTutorialPage(0);
            this.offset = 0;
            removeForNow();
            setRemovedBySwipe();
            return;
        }
        this.offset++;
        fixOffset();
        refresh();
        new Settings(getContext()).setTutorialPage(this.offset);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        if (!this.items.get(this.offset).getLast()) {
            this.items.get(this.offset).show();
            return;
        }
        this.offset = 0;
        new Settings(getContext()).setTutorialPage(this.offset);
        refresh();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void prev() {
        next();
    }

    public final void startTutorial(Activity activity, View view) {
        activity.getClass();
        view.getClass();
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialStarted("FirstUsePreviewActivity");
        Intent intent = new Intent(getContext(), (Class<?>) FirstUsePreviewActivity.class);
        intent.addFlags(536870912);
        if (!new Settings(getContext()).isTransitionAnimation()) {
            getContext().startActivity(intent);
            return;
        }
        Pair pairCreate = Pair.create(view.findViewById(R.id.paddingBox), "box");
        pairCreate.getClass();
        ActivityOptionsCompat activityOptionsCompatMakeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairCreate);
        activityOptionsCompatMakeSceneTransitionAnimation.getClass();
        ContextCompat.startActivity(getContext(), intent, activityOptionsCompatMakeSceneTransitionAnimation.toBundle());
    }
}

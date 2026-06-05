package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.DashboardCardBuilder$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001<B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u00103R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u001aR\u0014\u0010;\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;)V", "", "refresh", "save", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;Z)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;)V", "", "getNameResource", "()I", "canBeSwiped", "()Z", "startRecogition", "isScreenReady", "()V", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Landroid/speech/SpeechRecognizer;", "speech$delegate", "Lkotlin/Lazy;", "getSpeech", "()Landroid/speech/SpeechRecognizer;", "speech", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "doRefresh", "Z", "getDoRefresh", "setDoRefresh", "(Z)V", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;", "getViewHolder", "()Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;", "setViewHolder", "", "getTag", "()Ljava/lang/String;", "tag", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailCommentCard extends DashboardCard<SleepRecordViewHolder> implements FeatureLogger {
    private boolean doRefresh;
    private final Handler handler;
    private final SleepRecord sleepRecord;

    /* JADX INFO: renamed from: speech$delegate, reason: from kotlin metadata */
    private final Lazy speech;
    private SleepRecordViewHolder viewHolder;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailCommentCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/RatingBar;", "rating", "Landroid/widget/RatingBar;", "getRating", "()Landroid/widget/RatingBar;", "setRating", "(Landroid/widget/RatingBar;)V", "Lcom/google/android/material/textfield/TextInputEditText;", "comment", "Lcom/google/android/material/textfield/TextInputEditText;", "getComment", "()Lcom/google/android/material/textfield/TextInputEditText;", "setComment", "(Lcom/google/android/material/textfield/TextInputEditText;)V", "Lcom/google/android/material/textfield/TextInputLayout;", "commentLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getCommentLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "setCommentLayout", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "setCard", "(Landroidx/cardview/widget/CardView;)V", "Landroid/view/ViewGroup;", "tags", "Landroid/view/ViewGroup;", "getTags", "()Landroid/view/ViewGroup;", "setTags", "(Landroid/view/ViewGroup;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private CardView card;
        private TextInputEditText comment;
        private TextInputLayout commentLayout;
        private RatingBar rating;
        private ViewGroup tags;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.foreground);
            viewFindViewById.getClass();
            this.card = (CardView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.sleep_rating_comment);
            viewFindViewById2.getClass();
            this.comment = (TextInputEditText) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.sleep_rating_comment_layout);
            viewFindViewById3.getClass();
            this.commentLayout = (TextInputLayout) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.sleep_rating_bar);
            viewFindViewById4.getClass();
            this.rating = (RatingBar) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.tags);
            viewFindViewById5.getClass();
            this.tags = (ViewGroup) viewFindViewById5;
        }

        public final TextInputEditText getComment() {
            return this.comment;
        }

        public final TextInputLayout getCommentLayout() {
            return this.commentLayout;
        }

        public final RatingBar getRating() {
            return this.rating;
        }

        public final ViewGroup getTags() {
            return this.tags;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepDetailCommentCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.SLEEP_COMMENT, R.layout.card_sleep_detail_comment);
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
        this.speech = LazyKt.lazy(new DashboardCardBuilder$$ExternalSyntheticLambda2(activity, 18));
        this.handler = new Handler();
    }

    private final void bindSleepRecordToView(SleepRecord sleepRecord, final SleepRecordViewHolder viewHolder) {
        this.viewHolder = viewHolder;
        final StartTrackActivity$$ExternalSyntheticLambda0 startTrackActivity$$ExternalSyntheticLambda0 = new StartTrackActivity$$ExternalSyntheticLambda0(this, viewHolder, 4);
        if (sleepRecord != null) {
            Logger.logInfo("SleepCommentCard: load " + sleepRecord.getComment() + " " + sleepRecord.getRating());
            viewHolder.getRating().setRating(sleepRecord.getRating());
            viewHolder.getRating().setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard$$ExternalSyntheticLambda1
                @Override // android.widget.RatingBar.OnRatingBarChangeListener
                public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                    SleepDetailCommentCard.bindSleepRecordToView$lambda$1$0(this.f$0, startTrackActivity$$ExternalSyntheticLambda0, ratingBar, f, z);
                }
            });
            viewHolder.getComment().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard$$ExternalSyntheticLambda2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SleepDetailCommentCard.bindSleepRecordToView$lambda$1$1(this.f$0, startTrackActivity$$ExternalSyntheticLambda0, viewHolder, textView, i, keyEvent);
                }
            });
            viewHolder.getCommentLayout().setEndIconOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, viewHolder, 15));
            viewHolder.getCommentLayout().setStartIconOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, sleepRecord, 16));
            viewHolder.getComment().setText(sleepRecord.getComment());
            viewHolder.getTags().removeAllViews();
            EditActivity.createTags(getContext(), viewHolder.getTags(), viewHolder.getComment());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSleepRecordToView$lambda$0(SleepDetailCommentCard sleepDetailCommentCard, SleepRecordViewHolder sleepRecordViewHolder) {
        sleepDetailCommentCard.save(sleepRecordViewHolder, sleepDetailCommentCard.doRefresh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSleepRecordToView$lambda$1$0(SleepDetailCommentCard sleepDetailCommentCard, Runnable runnable, RatingBar ratingBar, float f, boolean z) {
        if (z) {
            Logger.logInfo("SleepCommentCard: rating " + f);
            sleepDetailCommentCard.handler.removeCallbacks(runnable);
            sleepDetailCommentCard.handler.postDelayed(runnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindSleepRecordToView$lambda$1$1(SleepDetailCommentCard sleepDetailCommentCard, Runnable runnable, SleepRecordViewHolder sleepRecordViewHolder, TextView textView, int i, KeyEvent keyEvent) {
        zza$$ExternalSyntheticOutline0.m(i, "SleepCommentCard: action ");
        if (i == 0) {
            sleepDetailCommentCard.doRefresh = false;
            runnable.run();
            Editable text = sleepRecordViewHolder.getComment().getText();
            if (text != null) {
                sleepRecordViewHolder.getComment().setSelection(text.length());
            }
            return true;
        }
        if (i != 6) {
            return false;
        }
        sleepDetailCommentCard.doRefresh = true;
        runnable.run();
        Editable text2 = sleepRecordViewHolder.getComment().getText();
        if (text2 != null) {
            sleepRecordViewHolder.getComment().setSelection(text2.length());
        }
        Object systemService = sleepDetailCommentCard.getContext().getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(sleepRecordViewHolder.getComment().getApplicationWindowToken(), 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSleepRecordToView$lambda$1$2(SleepDetailCommentCard sleepDetailCommentCard, SleepRecordViewHolder sleepRecordViewHolder, View view) {
        try {
            sleepDetailCommentCard.startRecogition(sleepRecordViewHolder);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(sleepDetailCommentCard.getContext(), sleepDetailCommentCard.getContext().getResources().getString(R.string.speech_recognizer_not_present), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSleepRecordToView$lambda$1$3(SleepDetailCommentCard sleepDetailCommentCard, SleepRecord sleepRecord, View view) {
        EditActivity.showRatingForResult(sleepDetailCommentCard.getContext(), sleepRecord, false);
    }

    private final SpeechRecognizer getSpeech() {
        Object value = this.speech.getValue();
        value.getClass();
        return (SpeechRecognizer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void save(SleepRecordViewHolder viewHolder, boolean refresh) {
        SleepRecord sleepRecord = new SleepRecord(this.sleepRecord, false);
        SleepRecord sleepRecord2 = new SleepRecord(this.sleepRecord, false);
        float rating = viewHolder.getRating().getRating();
        String strValueOf = String.valueOf(viewHolder.getComment().getText());
        boolean zAreEqual = Intrinsics.areEqual(strValueOf, this.sleepRecord.getComment());
        boolean z = rating == this.sleepRecord.getRating();
        if (zAreEqual && z) {
            return;
        }
        sleepRecord.rateAndComment(!zAreEqual ? strValueOf : this.sleepRecord.getComment(), rating);
        this.sleepRecord.rateAndComment(strValueOf, rating);
        Logger.logInfo("SleepCommentCard: save " + strValueOf + " " + rating);
        SharedApplicationContext.getInstance().getSleepRecordRepository().recordRatingUpdated(sleepRecord2, sleepRecord, null);
        if (sleepRecord.isNiceRecord() && (rating <= 0.0f || rating >= 4.0f)) {
            Settings.setGoodTimeToRate(true);
        }
        if (refresh) {
            LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent("com.urbandroid.sleep.ACTION_GRAPH_CHANGED"));
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        bindSleepRecordToView(this.sleepRecord, viewHolder);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean canBeSwiped() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.rating_comment_label;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return "SleepCommentCard";
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isScreenReady() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
    }

    public final void startRecogition(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        if (SpeechRecognizer.isRecognitionAvailable(getContext())) {
            getSpeech().setRecognitionListener(new SleepDetailCommentCard$startRecogition$listener$1(viewHolder, this));
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
            intent.putExtra("calling_package", getContext().getPackageName());
            intent.putExtra("android.speech.extra.PREFER_OFFLINE", false);
            getSpeech().startListening(intent);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void save() {
        super.save();
        SleepRecordViewHolder sleepRecordViewHolder = this.viewHolder;
        if (sleepRecordViewHolder != null) {
            save(sleepRecordViewHolder, false);
        }
    }
}

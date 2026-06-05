package com.urbandroid.sleep.fragment.dashboard.card;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u001eB!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailAdviceRdiCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailAdviceRdiCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "", "rdi", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;I)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailAdviceRdiCard$SleepRecordViewHolder;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailAdviceRdiCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "getNameResource", "()I", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "I", "getRdi", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailAdviceRdiCard extends DashboardCard<SleepRecordViewHolder> {
    private final int rdi;
    private final SleepRecord sleepRecord;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailAdviceRdiCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", SDKConstants.PARAM_A2U_BODY, "Landroid/widget/TextView;", "getBody", "()Landroid/widget/TextView;", "setBody", "(Landroid/widget/TextView;)V", "stripe", "Landroid/view/View;", "getStripe", "()Landroid/view/View;", "setStripe", "title", "getTitle", "setTitle", "Landroid/widget/ImageView;", "score", "Landroid/widget/ImageView;", "getScore", "()Landroid/widget/ImageView;", "setScore", "(Landroid/widget/ImageView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private TextView body;
        private ImageView score;
        private View stripe;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.body);
            viewFindViewById.getClass();
            this.body = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.stripe);
            viewFindViewById2.getClass();
            this.stripe = viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.title);
            viewFindViewById3.getClass();
            this.title = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.score);
            viewFindViewById4.getClass();
            this.score = (ImageView) viewFindViewById4;
        }

        public final TextView getBody() {
            return this.body;
        }

        public final ImageView getScore() {
            return this.score;
        }

        public final View getStripe() {
            return this.stripe;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepDetailAdviceRdiCard(Activity activity, SleepRecord sleepRecord, int i) {
        super(activity, DashboardCard.Type.SLEEP_DETAIL_ADVICE_RDI, R.layout.card_advice);
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
        this.rdi = i;
    }

    private final void bindSleepRecordToView(SleepRecordViewHolder viewHolder) {
        Activity context;
        int i;
        String string;
        Activity context2;
        int i2;
        StringBuilder sb = new StringBuilder(" ~");
        sb.append(this.rdi);
        sb.append(" (");
        int i3 = this.rdi;
        int i4 = 15;
        if (i3 < 10) {
            context2 = getContext();
            if (context2 != null) {
                i2 = R.string.condition_normal;
                string = context2.getString(i2);
            }
            string = null;
        } else {
            if (i3 < 15) {
                context2 = getContext();
                if (context2 != null) {
                    i2 = R.string.condition_mild;
                    string = context2.getString(i2);
                }
            } else if (i3 < 30) {
                context = getContext();
                if (context != null) {
                    i = R.string.condition_moderate;
                    string = context.getString(i);
                }
            } else {
                context = getContext();
                if (context != null) {
                    i = R.string.condition_severe;
                    string = context.getString(i);
                }
            }
            string = null;
        }
        sb.append(string);
        sb.append(")");
        TextView body = viewHolder.getBody();
        Activity context3 = getContext();
        String string2 = context3 != null ? context3.getString(R.string.apnea_result, sb.toString()) : null;
        String strM = " ";
        if (this.rdi >= 10) {
            Activity context4 = getContext();
            strM = FileInsert$$ExternalSyntheticOutline0.m(" ", context4 != null ? context4.getString(R.string.advice_sleep_lab) : null, ".");
        }
        body.setText(string2 + strM);
        viewHolder.getBody().setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, i4));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtil.addAlpha(ColorUtil.i(getContext(), R.color.negative_light), 99), ColorUtil.i(getContext(), R.color.transparent)});
        TextView title = viewHolder.getTitle();
        Activity context5 = getContext();
        title.setText(context5 != null ? context5.getString(R.string.advice_caution) : null);
        viewHolder.getStripe().setBackground(gradientDrawable);
        Activity context6 = getContext();
        if (context6 != null) {
            viewHolder.getScore().setImageDrawable(ContextCompat.getDrawable(context6, R.drawable.ic_advice_down));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSleepRecordToView$lambda$0(SleepDetailAdviceRdiCard sleepDetailAdviceRdiCard, View view) {
        ViewIntent.url(sleepDetailAdviceRdiCard.getContext(), "https://sleep.urbandroid.org/docs//sleep/sleep_apnea.html");
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        bindSleepRecordToView(viewHolder);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.rr_disturbace;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        ViewIntent.url(getContext(), "https://sleep.urbandroid.org/docs//sleep/sleep_apnea.html");
    }
}

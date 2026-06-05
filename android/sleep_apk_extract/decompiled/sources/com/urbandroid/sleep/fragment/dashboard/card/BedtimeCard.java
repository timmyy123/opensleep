package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import com.urbandroid.sleep.domain.Bedtime;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.TimeFormatUtil;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000  2\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0002\u001f B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u0000H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/BedtimeCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/BedtimeCard$BedtimeViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "parentView", "Landroid/view/ViewGroup;", "bedtime", "Lcom/urbandroid/sleep/domain/Bedtime;", "h", "Landroid/os/Handler;", "createViewHolder", "v", "Landroid/view/View;", "bindView", "", "viewHolder", "updateTime", "Landroid/content/Context;", "parent", "refreshBedtime", "updateBedtime", "Ljava/lang/Runnable;", "onCardClicked", ViewHierarchyConstants.VIEW_KEY, "getNameResource", "", "isThemeCard", "", "BedtimeViewHolder", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BedtimeCard extends DashboardCard<BedtimeViewHolder> {
    private Bedtime bedtime;
    private final Handler h;
    private ViewGroup parentView;
    private final Runnable updateBedtime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/BedtimeCard$BedtimeViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/BedtimeCard;Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "bedtimeText", "getBedtimeText", "setBedtimeText", "Landroid/widget/ImageView;", "droid", "Landroid/widget/ImageView;", "getDroid", "()Landroid/widget/ImageView;", "setDroid", "(Landroid/widget/ImageView;)V", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "setCard", "(Landroidx/cardview/widget/CardView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class BedtimeViewHolder extends LayeredViewHolder {
        private TextView bedtimeText;
        private CardView card;
        private ImageView droid;
        final /* synthetic */ BedtimeCard this$0;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BedtimeViewHolder(BedtimeCard bedtimeCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = bedtimeCard;
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.summary);
            viewFindViewById2.getClass();
            this.bedtimeText = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.droid_icon);
            viewFindViewById3.getClass();
            this.droid = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.foreground);
            viewFindViewById4.getClass();
            this.card = (CardView) viewFindViewById4;
        }

        public final CardView getCard() {
            return this.card;
        }
    }

    public BedtimeCard(Activity activity) {
        super(activity, DashboardCard.Type.BEDTIME, R.layout.card_bedtime);
        this.h = new Handler();
        this.updateBedtime = new Runnable() { // from class: com.urbandroid.sleep.fragment.dashboard.card.BedtimeCard$updateBedtime$1
            @Override // java.lang.Runnable
            public void run() {
                Bedtime bedtime = this.this$0.bedtime;
                Long alarm = bedtime != null ? bedtime.getAlarm() : null;
                Bedtime bedtime2 = this.this$0.bedtime;
                Long bedtime3 = bedtime2 != null ? bedtime2.getBedtime() : null;
                this.this$0.refreshBedtime();
                BedtimeCard bedtimeCard = this.this$0;
                Activity context = bedtimeCard.getContext();
                context.getClass();
                bedtimeCard.updateTime(context, this.this$0.parentView);
                this.this$0.h.removeCallbacks(this);
                this.this$0.h.postDelayed(this, 60000L);
                Bedtime bedtime4 = this.this$0.bedtime;
                if (Intrinsics.areEqual(bedtime4 != null ? bedtime4.getAlarm() : null, alarm)) {
                    Bedtime bedtime5 = this.this$0.bedtime;
                    if (Intrinsics.areEqual(bedtime5 != null ? bedtime5.getBedtime() : null, bedtime3)) {
                        return;
                    }
                }
                this.this$0.refresh();
            }
        };
        refreshBedtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCardClicked$lambda$0$0$0(MaterialAlertDialogBuilder materialAlertDialogBuilder, DialogInterface dialogInterface, int i) {
        Alarms.allInOneDismissWithCaptcha(materialAlertDialogBuilder.getContext());
        Context context = materialAlertDialogBuilder.getContext();
        context.getClass();
        ContextExtKt.sendExplicitBroadcast$default(context, new Intent("com.urbandroid.sleep.ACTION_DASHBOARD_REFRESH"), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshBedtime() {
        Settings settings = new Settings(getContext());
        this.bedtime = new Bedtime(settings.getNextTimeToBed(), settings.getNextAlarm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTime(Context context, ViewGroup parent) {
        Bedtime bedtime;
        if (parent == null || (bedtime = this.bedtime) == null) {
            return;
        }
        bedtime.updateTime(context, parent, null);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(BedtimeViewHolder viewHolder) {
        viewHolder.getClass();
        refreshBedtime();
        Bedtime bedtime = this.bedtime;
        if (bedtime == null || !(bedtime == null || bedtime.isBedtime())) {
            Activity context = getContext();
            View view = viewHolder.itemView;
            view.getClass();
            setCardVisibility(context, (ViewGroup) view, false);
            return;
        }
        viewHolder.getCard().setCardBackgroundColor(ColorUtil.i(getContext(), R.color.tint_background_bedtime));
        Activity context2 = getContext();
        View view2 = viewHolder.itemView;
        view2.getClass();
        setCardVisibility(context2, (ViewGroup) view2, true);
        View view3 = viewHolder.itemView;
        view3.getClass();
        this.parentView = (ViewGroup) view3;
        Activity context3 = getContext();
        context3.getClass();
        View view4 = viewHolder.itemView;
        view4.getClass();
        updateTime(context3, (ViewGroup) view4);
        this.h.removeCallbacks(this.updateBedtime);
        this.h.postDelayed(this.updateBedtime, 60000L);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public BedtimeViewHolder createViewHolder(View v) {
        v.getClass();
        return new BedtimeViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.time_to_bed_title;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        Alarm alarmCalculateNextAlertIncludingSnooze;
        view.getClass();
        getContext();
        if (new Settings(getContext()).getNextAlarm() == null || (alarmCalculateNextAlertIncludingSnooze = Alarms.calculateNextAlertIncludingSnooze(getContext())) == null) {
            return;
        }
        if (!Alarms.isSnoozing(getContext())) {
            SetAlarm.showSetAlarmActivity(getContext(), alarmCalculateNextAlertIncludingSnooze.id, false);
            return;
        }
        MaterialAlertDialogBuilder title = new MaterialAlertDialogBuilder(getContext()).setTitle((CharSequence) getContext().getString(R.string.step_alarm_snoozing, TimeFormatUtil.getTimeFormatWithoutAmPm(getContext()).format(Long.valueOf(alarmCalculateNextAlertIncludingSnooze.time))));
        title.setPositiveButton(R.string.alarm_alert_dismiss_text, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(title, 9));
        title.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        title.show();
    }
}

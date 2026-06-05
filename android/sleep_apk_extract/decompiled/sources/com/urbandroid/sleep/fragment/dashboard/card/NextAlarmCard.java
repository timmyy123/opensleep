package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Spannable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmActivity;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.DigitalClock;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import com.urbandroid.sleep.fragment.AlarmFragment;
import com.urbandroid.sleep.fragment.AlarmPopupHandler;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class NextAlarmCard extends DashboardCard<NextAlarmViewHolder> {
    private Alarm alarm;
    private TextView alarmListHint;
    private View fab;
    private Animation flyUp;
    private Handler h;
    private Animation hideAnim;

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard$4, reason: invalid class name */
    public class AnonymousClass4 implements View.OnLongClickListener {
        final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PopupMenu popupMenu = new PopupMenu(this.val$context, view, 8388613);
            Menu menu = popupMenu.getMenu();
            popupMenu.getMenuInflater().inflate(R.menu.context_menu, menu);
            boolean z = false;
            menu.findItem(R.id.copy_alarm).setVisible(false);
            menu.findItem(R.id.delete_all_disabled).setVisible(false);
            menu.findItem(R.id.enable_alarm).setVisible(false);
            MenuItem menuItemFindItem = menu.findItem(R.id.enable_alarm_for_today);
            if (NextAlarmCard.this.alarm != null && NextAlarmCard.this.alarm.getDaysOfWeek() != null && NextAlarmCard.this.alarm.getDaysOfWeek().isRepeatSet() && NextAlarmCard.this.alarm.enabled && AlarmFragment.isNextAlarmDisabled(NextAlarmCard.this.alarm)) {
                z = true;
            }
            menuItemFindItem.setVisible(z);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.4.1
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    new AlarmPopupHandler(AnonymousClass4.this.val$context, new AlarmPopupHandler.Refresher() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.4.1.2
                        @Override // com.urbandroid.sleep.fragment.AlarmPopupHandler.Refresher
                        public void refresh() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            NextAlarmCard.this.alarm = Alarms.calculateNextAlert(anonymousClass4.val$context);
                            NextAlarmCard.this.refresh();
                        }
                    }).handle(menuItem, new AlarmPopupHandler.AlarmRetriever() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.4.1.1
                        @Override // com.urbandroid.sleep.fragment.AlarmPopupHandler.AlarmRetriever
                        public Alarm getAlarm() {
                            return NextAlarmCard.this.alarm;
                        }
                    }, NextAlarmCard.this.alarm.id);
                    return true;
                }
            });
            popupMenu.show();
            return true;
        }
    }

    public class NextAlarmViewHolder extends NoSwipeViewHolder {
        public ImageButton addAlarm;
        public ViewGroup alarmParent;
        public TextView alarmTime;
        public TextView ampm;
        public TextView days;
        public TextView label;
        public ViewGroup noAlarm;
        public TextView placeholder;
        public TextView prefs;
        public ImageButton rightIcon;
        public CompoundButton switchOnOff;
        public DigitalClock time;
        public TextView title;

        public NextAlarmViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.titleText);
            this.time = (DigitalClock) view.findViewById(R.id.digitalClock);
            this.days = (TextView) view.findViewById(R.id.daysOfWeek);
            this.switchOnOff = (CompoundButton) view.findViewById(R.id.switchOnOff);
            this.noAlarm = (ViewGroup) view.findViewById(R.id.no_alarm);
            this.alarmParent = (ViewGroup) view.findViewById(R.id.row_alarm);
            this.rightIcon = (ImageButton) view.findViewById(R.id.icon_right);
            this.alarmTime = (TextView) view.findViewById(R.id.timeDisplay);
            this.placeholder = (TextView) view.findViewById(R.id.placeholder);
            this.addAlarm = (ImageButton) view.findViewById(R.id.add_alarm);
            this.ampm = (TextView) view.findViewById(R.id.am_pm);
            this.label = (TextView) view.findViewById(R.id.label);
            this.prefs = (TextView) view.findViewById(R.id.prefs);
        }
    }

    public NextAlarmCard(Activity activity, Alarm alarm, View view) {
        super(activity, DashboardCard.Type.NEXT_ALARM, R.layout.card_alarm);
        this.alarm = alarm;
        this.hideAnim = AnimationUtils.loadAnimation(activity, R.anim.shake_left_hide);
        this.flyUp = AnimationUtils.loadAnimation(activity, R.anim.fly_up);
        this.fab = view;
        this.h = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animAlarmActivity(final View view) {
        this.h.post(new Runnable() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent(NextAlarmCard.this.getContext(), (Class<?>) AlarmActivity.class);
                intent.addFlags(67108864);
                if (!new Settings(NextAlarmCard.this.getContext()).isTransitionAnimation()) {
                    view.getContext().startActivity(intent);
                    return;
                }
                Alarm alarm = NextAlarmCard.this.alarm;
                View view2 = view;
                if (alarm == null) {
                    ContextCompat.startActivity(NextAlarmCard.this.getContext(), intent, ActivityOptionsCompat.makeSceneTransitionAnimation(NextAlarmCard.this.getContext(), Pair.create(view2.findViewById(R.id.add_alarm), "add_alarm")).toBundle());
                } else {
                    ContextCompat.startActivity(NextAlarmCard.this.getContext(), intent, ActivityOptionsCompat.makeSceneTransitionAnimation(NextAlarmCard.this.getContext(), Pair.create(view2.findViewById(R.id.box_alarm), "box"), Pair.create(view.findViewById(R.id.icon_right), "add_alarm")).toBundle());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindView$0(Context context, View view) {
        if (this.alarm != null) {
            SetAlarm.showSetAlarmActivity(context, r4.id, true);
        } else {
            getContext().startActivity(new Intent(context, (Class<?>) AlarmActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindView$1(Context context, View view) {
        context.startActivity(new Intent(context, (Class<?>) SetAlarm.class));
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(final NextAlarmViewHolder nextAlarmViewHolder) {
        final Activity context = getContext();
        Settings settings = new Settings(context);
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context);
        this.alarm = alarmCalculateNextAlert;
        if (alarmCalculateNextAlert == null) {
            this.alarmListHint = (TextView) nextAlarmViewHolder.itemView.findViewById(R.id.setAlarmTextView);
            nextAlarmViewHolder.noAlarm.setVisibility(0);
            boolean zIsGraphColorThemeDefault = settings.isGraphColorThemeDefault();
            ViewGroup viewGroup = nextAlarmViewHolder.noAlarm;
            if (zIsGraphColorThemeDefault) {
                viewGroup.setBackgroundColor(ColorUtil.i(context, R.color.tint));
            } else {
                viewGroup.setBackgroundColor(ColorUtil.i(context, R.color.tint_background));
            }
            nextAlarmViewHolder.alarmParent.setVisibility(8);
            nextAlarmViewHolder.noAlarm.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NextAlarmCard.this.animAlarmActivity(view);
                }
            });
            nextAlarmViewHolder.addAlarm.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!new Settings(NextAlarmCard.this.getContext()).showShowCaseIfNotShown("sc_alarm_list_on_add")) {
                        context.startActivity(new Intent(context, (Class<?>) SetAlarm.class));
                        return;
                    }
                    boolean zDaysUsed = TrialFilter.getInstance().daysUsed(0, 14);
                    Context context2 = context;
                    if (zDaysUsed) {
                        context2.startActivity(new Intent(context, (Class<?>) AlarmActivity.class));
                    } else {
                        context2.startActivity(new Intent(context, (Class<?>) SetAlarm.class));
                    }
                }
            });
            return;
        }
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(context);
        nextAlarmViewHolder.alarmParent.setOnLongClickListener(anonymousClass4);
        nextAlarmViewHolder.alarmTime.setOnLongClickListener(anonymousClass4);
        nextAlarmViewHolder.rightIcon.setOnLongClickListener(anonymousClass4);
        nextAlarmViewHolder.alarmParent.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NextAlarmCard.this.animAlarmActivity(nextAlarmViewHolder.itemView);
            }
        });
        nextAlarmViewHolder.alarmParent.setVisibility(0);
        nextAlarmViewHolder.noAlarm.setVisibility(8);
        nextAlarmViewHolder.switchOnOff.setOnCheckedChangeListener(null);
        nextAlarmViewHolder.switchOnOff.setChecked(true);
        Calendar calendar = Calendar.getInstance();
        int datestampNumber = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.add(5, 1);
        int datestampNumber2 = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.setTimeInMillis(this.alarm.time);
        calendar.set(11, this.alarm.getOffsetHour(context));
        calendar.set(12, this.alarm.getOffsetMinutes(context));
        int datestampNumber3 = DateUtil.getDatestampNumber(calendar.getTime());
        int i = calendar.get(7);
        if (datestampNumber3 == datestampNumber) {
            nextAlarmViewHolder.title.setText(getContext().getString(R.string.today));
        } else if (datestampNumber3 == datestampNumber2) {
            nextAlarmViewHolder.title.setText(getContext().getString(R.string.tomorrow));
        } else {
            long j = this.alarm.time;
            long jCurrentTimeMillis = System.currentTimeMillis() + 604800000;
            TextView textView = nextAlarmViewHolder.title;
            if (j > jCurrentTimeMillis) {
                textView.setText(DateUtil.getShortDateLongerWeekInstanceWithoutYears(context).format(new Date(this.alarm.time)));
            } else {
                textView.setText(AlarmFragment.capitalizeFirstLetter(DateUtil.getLongWeekdayNames()[i]));
            }
        }
        boolean z = this.alarm.silent;
        TextView textView2 = nextAlarmViewHolder.prefs;
        if (z) {
            textView2.setText(getContext().getString(R.string.silent_alarm_summary));
        } else {
            textView2.setText("");
        }
        int offset = this.alarm.getOffset();
        TextView textView3 = nextAlarmViewHolder.alarmTime;
        if (offset != 0) {
            textView3.setTextColor(ColorUtil.i(context, R.color.tint));
        } else {
            textView3.setTextColor(ColorUtil.i(context, R.color.primary));
        }
        if (this.alarm.getOffset() != 0) {
            Alarm alarm = this.alarm;
            Calendar calendarCalculateAlarm = Alarms.calculateAlarm(context, alarm.hour, alarm.minutes, alarm.getDaysOfWeek());
            if (Alarm.isPowerNap(this.alarm)) {
                calendarCalculateAlarm.add(12, -59);
            }
            if (calendarCalculateAlarm != null) {
                nextAlarmViewHolder.placeholder.setText(DateUtil.formatTime(context, calendarCalculateAlarm.getTimeInMillis()) + " ");
                nextAlarmViewHolder.placeholder.setVisibility(0);
            }
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        if (Alarm.isPowerNap(this.alarm)) {
            calendar2.add(12, -59);
        }
        nextAlarmViewHolder.time.setLive(false);
        nextAlarmViewHolder.time.updateTime(calendar2);
        Alarm alarm2 = this.alarm;
        boolean z2 = alarm2.suspendTime > 0 && Alarms.isSkipped(alarm2);
        int i2 = ColorUtil.i(getContext(), R.color.tertiary);
        int i3 = ColorUtil.i(getContext(), R.color.primary);
        int i4 = ColorUtil.i(getContext(), R.color.secondary);
        TextView textView4 = nextAlarmViewHolder.label;
        String str = this.alarm.label;
        if (str == null || str.length() == 0) {
            textView4.setVisibility(4);
        } else {
            if (z2) {
                textView4.setText(context.getString(R.string.disable_alarm_for_today));
            } else {
                textView4.setText(this.alarm.label);
            }
            textView4.setVisibility(0);
            textView4.setTextColor((!this.alarm.enabled || z2) ? i2 : i4);
        }
        nextAlarmViewHolder.ampm.setTextColor((!this.alarm.enabled || z2) ? i2 : i3);
        TextView textView5 = nextAlarmViewHolder.alarmTime;
        if (!this.alarm.enabled || z2) {
            i3 = i2;
        }
        textView5.setTextColor(i3);
        Alarm alarm3 = this.alarm;
        if (alarm3.enabled) {
            int offset2 = alarm3.getOffset();
            TextView textView6 = nextAlarmViewHolder.alarmTime;
            if (offset2 != 0) {
                textView6.setTextColor(ColorUtil.i(context, R.color.tint));
            } else {
                textView6.setTextColor(ColorUtil.i(context, R.color.primary));
            }
        }
        calendar.setTimeInMillis(this.alarm.time);
        Spannable spanneble = this.alarm.getDaysOfWeek().toSpanneble(context, calendar.get(7), ColorUtil.i(context, R.color.tint));
        if (spanneble == null || spanneble.length() == 0) {
            nextAlarmViewHolder.days.setVisibility(8);
        } else {
            nextAlarmViewHolder.days.setVisibility(0);
            nextAlarmViewHolder.days.setText(spanneble);
            TextView textView7 = nextAlarmViewHolder.days;
            if (this.alarm.enabled && !z2) {
                i2 = i4;
            }
            textView7.setTextColor(i2);
        }
        nextAlarmViewHolder.alarmTime.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, context, 13));
        nextAlarmViewHolder.rightIcon.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(context, 14));
        nextAlarmViewHolder.switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                zza$$ExternalSyntheticOutline0.m("Dashboard: switch ", z3);
                if (NextAlarmCard.this.alarm != null) {
                    Alarms.disableAlarmOrShowCaptcha(context, NextAlarmCard.this.alarm);
                }
                NextAlarmCard.this.alarm = Alarms.calculateNextAlert(context);
                NextAlarmCard.this.hideAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard.6.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Logger.logInfo("Dashboard: anim end");
                        NextAlarmCard.this.refresh();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                Logger.logInfo("Dashboard: anim start");
                nextAlarmViewHolder.itemView.startAnimation(NextAlarmCard.this.hideAnim);
                nextAlarmViewHolder.itemView.setVisibility(4);
            }
        });
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean canBeSwiped() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public NextAlarmViewHolder createViewHolder(View view) {
        return new NextAlarmViewHolder(view);
    }

    public TextView getAlarmListHint() {
        return this.alarmListHint;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.default_label;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isPinnable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        Logger.logInfo("Dashboard: view " + view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void refresh() {
        int position = getPosition();
        if (getAdapter() != null) {
            getAdapter().notifyItemChanged(position);
            if (position > 0) {
                getAdapter().notifyItemChanged(position - 1);
            }
        }
    }
}

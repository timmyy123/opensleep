package com.urbandroid.sleep.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.style.StrikethroughSpan;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmActivity;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.DigitalClock;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.alarmclock.ToastMaster;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.fragment.AlarmPopupHandler;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.ProgressCircle;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.gui.icon.IconProvider;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda3;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmFragment extends LazyFragment implements AdapterView.OnItemClickListener {
    private static final StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
    static boolean firstCreate = true;
    private AlarmTimeAdapter adapter;
    private Animation animDisable;
    private Animation animDisableAfter;
    private Animation animEnable;
    private Animation animEnableAfter;
    private Animation animFadeIn;
    private ViewGroup bedtimeView;
    private View clock;
    private ImageView droidLayout;
    private MaterialButton fab;
    private Handler h;
    private ListView mAlarmsList;
    private Cursor mCursor;
    private LayoutInflater mFactory;
    private Alarm nextAlarm;
    private View noData;
    private BroadcastReceiver receiver = null;
    private Set<View> fabs = new HashSet();
    private int firstVisibleItem = 0;
    private ProgressCircle progressCircle = new ProgressCircle(120);
    private boolean sortByDay = true;
    private boolean alarmOnly = false;
    private ScrollAnimator scrollAnimator = null;
    Runnable updateBedtime = new Runnable() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.9
        @Override // java.lang.Runnable
        public void run() {
            if (AlarmFragment.this.bedtimeView != null) {
                ImageView imageView = (ImageView) AlarmFragment.this.bedtimeView.findViewById(R.id.bedtime_indicator_icon);
                TextView textView = (TextView) AlarmFragment.this.bedtimeView.findViewById(R.id.bedtime_indicator_text);
                if (AlarmFragment.this.nextAlarm != null) {
                    if (AlarmFragment.this.animFadeIn == null) {
                        AlarmFragment alarmFragment = AlarmFragment.this;
                        alarmFragment.animFadeIn = AnimationUtils.loadAnimation(alarmFragment.getActivity(), R.anim.unfade);
                    }
                    Date nextTimeToBed = SharedApplicationContext.getSettings().getNextTimeToBed();
                    long time = nextTimeToBed != null ? (nextTimeToBed.getTime() - System.currentTimeMillis()) / 60000 : 10080L;
                    if (time < -9) {
                        time = SharedApplicationContext.getSettings().getMinutesToAlarm();
                        imageView.setImageResource(R.drawable.ic_action_time_small_trans);
                    } else {
                        imageView.setImageResource(R.drawable.ic_action_bedtime_small_trans);
                    }
                    if (time > 720) {
                        textView.setText("");
                        imageView.setImageResource(R.drawable.empty_ab);
                        AlarmFragment.this.bedtimeView.setVisibility(8);
                    } else {
                        textView.setText(AlarmFragment.this.buildBedtimeText(Long.valueOf(time)));
                        AlarmFragment alarmFragment2 = AlarmFragment.this;
                        alarmFragment2.setVisibleAnim(alarmFragment2.bedtimeView, AlarmFragment.this.animFadeIn);
                    }
                } else if (!"   ".equals(textView.getText())) {
                    textView.setText("");
                    imageView.setImageResource(R.drawable.empty_ab);
                    AlarmFragment.this.bedtimeView.setVisibility(8);
                }
            }
            AlarmFragment.this.h.removeCallbacks(AlarmFragment.this.updateBedtime);
            AlarmFragment.this.h.postDelayed(AlarmFragment.this.updateBedtime, 60000L);
        }
    };

    public static class AlarmTimeAdapter extends CursorAdapter implements IFilterListAdapter {
        private AlarmFragment af;
        private Context context;
        private DigitalClock digitalClock;
        private LayoutInflater mFactory;
        private int nextAlarmDay;
        private Alarm nextAlarmInList;
        private boolean sortByDay;

        public AlarmTimeAdapter(Context context, Cursor cursor, AlarmFragment alarmFragment, boolean z) {
            super(context, cursor);
            this.nextAlarmDay = -1;
            this.mFactory = InflatorUtil.get(context);
            this.af = alarmFragment;
            this.context = context;
            this.sortByDay = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$bindView$0(CompoundButton compoundButton, Alarm alarm, View view) {
            compoundButton.setChecked(!compoundButton.isChecked());
            this.af.switchSwitch(alarm, compoundButton);
        }

        @Override // android.widget.CursorAdapter
        public void bindView(View view, Context context, Cursor cursor) {
            Alarm alarm;
            Alarm alarm2;
            if (cursor.isFirst() || !cursor.moveToPrevious()) {
                alarm = null;
            } else {
                Alarm alarm3 = new Alarm(cursor);
                cursor.moveToNext();
                alarm = alarm3;
            }
            Alarm alarm4 = new Alarm(cursor);
            if (cursor.moveToNext()) {
                Alarm alarm5 = new Alarm(cursor);
                cursor.moveToPrevious();
                alarm2 = alarm5;
            } else {
                alarm2 = null;
            }
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.switchOnOffLayout);
            CompoundButton compoundButton = (CompoundButton) view.findViewById(R.id.switchOnOff);
            compoundButton.setClickable(false);
            compoundButton.setOnCheckedChangeListener(null);
            AlarmFragment.mapAlarmToView(context, view, compoundButton, alarm4, this.nextAlarmInList, this.nextAlarmDay, alarm, this.sortByDay, null, alarm2);
            if (this.af != null) {
                viewGroup.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda3(this, compoundButton, alarm4, 3));
            }
            Logger.logInfo("Alarm: current " + alarm4.hour + ":" + alarm4.minutes + " next " + this.nextAlarmDay + " " + this.nextAlarmInList + " " + alarm2);
            if (alarm2 == null) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), ActivityUtils.getDip(context, 120));
            } else {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
            }
        }

        @Override // com.urbandroid.sleep.gui.IFilterListAdapter
        public void filter(IFilterListAdapter.IFilter iFilter) {
            changeCursor(Alarms.getAlarmsCursor(this.context, iFilter.getFilterString()));
            notifyChanged();
        }

        @Override // android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View viewInflate = this.mFactory.inflate(R.layout.row_alarm_time, viewGroup, false);
            DigitalClock digitalClock = (DigitalClock) viewInflate.findViewById(R.id.digitalClock);
            this.digitalClock = digitalClock;
            digitalClock.setLive(false);
            return viewInflate;
        }

        @Override // com.urbandroid.sleep.gui.IFilterListAdapter
        public void notifyChanged() {
            notifyDataSetChanged();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SetAlarm.showSetAlarmActivity(this.context, ((Integer) view.getTag()).intValue(), false);
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            return false;
        }

        @Override // com.urbandroid.sleep.gui.IFilterListAdapter
        public void pause() {
        }

        public void setNextAlarm(Alarm alarm) {
            this.nextAlarmInList = alarm;
            if (alarm != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(alarm.time);
                this.nextAlarmDay = calendar.get(7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildBedtimeText(Long l) {
        if (this.bedtimeView == null) {
            return "";
        }
        if (l.longValue() > 720) {
            return DateUtil.formatHoursPositiveRound(l) + this.bedtimeView.getContext().getResources().getString(R.string.h_without_min) + this.bedtimeView.getContext().getResources().getString(R.string.leave_empty_time_after);
        }
        if (l.longValue() <= 99) {
            return l + this.bedtimeView.getContext().getResources().getString(R.string.bed_time_min) + this.bedtimeView.getContext().getResources().getString(R.string.leave_empty_time_after);
        }
        if (l.longValue() % 60 == 0) {
            return DateUtil.formatHoursPositive(l) + this.bedtimeView.getContext().getResources().getString(R.string.h) + this.bedtimeView.getContext().getResources().getString(R.string.leave_empty_time_after);
        }
        return DateUtil.formatHoursPositive(l) + this.bedtimeView.getContext().getString(R.string.h) + " " + (l.longValue() % 60) + this.bedtimeView.getContext().getResources().getString(R.string.bed_time_min) + this.bedtimeView.getContext().getResources().getString(R.string.leave_empty_time_after);
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private Context getActivityIfAvailable() {
        return getActivity() != null ? getActivity() : getContext();
    }

    private void hideDroidIfConfigured() {
        if (this.droidLayout != null) {
            if (SharedApplicationContext.getSettings().isHideDroid() || SharedApplicationContext.getSettings().isAlarmOnly()) {
                this.droidLayout.setTag("inactive");
                this.droidLayout.setVisibility(8);
                this.fabs.remove(this.droidLayout);
            } else {
                this.droidLayout.setTag(null);
                this.fabs.remove(this.droidLayout);
                this.fabs.add(this.droidLayout);
            }
        }
    }

    public static boolean isNextAlarmDisabled(Alarm alarm) {
        return Alarms.isSkipped(alarm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mapAlarmToView$0(Context context, AlarmFragment alarmFragment, View view) {
        new AlarmPopupHandler(context, new AlarmPopupHandler.Refresher() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.3
            @Override // com.urbandroid.sleep.fragment.AlarmPopupHandler.Refresher
            public void refresh() {
                AlarmFragment alarmFragment2 = AlarmFragment.this;
                if (alarmFragment2 != null) {
                    alarmFragment2.refreshAlarm();
                }
            }
        }).deleteAllDisabledAlarms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mapAlarmToView$1(Context context, Alarm alarm, View view) {
        SetAlarm.showSetAlarmActivity(context, alarm.id, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mapAlarmToView$2(View view) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Alarm lambda$onContextItemSelected$3(AdapterView.AdapterContextMenuInfo adapterContextMenuInfo) {
        return new Alarm((Cursor) this.mAlarmsList.getAdapter().getItem(adapterContextMenuInfo.position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateLayout$4(View view) {
        startActivity(new Intent(getActivity(), (Class<?>) SetAlarm.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0634  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void mapAlarmToView(Context context, View view, CompoundButton compoundButton, Alarm alarm, Alarm alarm2, int i, Alarm alarm3, boolean z, AlarmFragment alarmFragment, Alarm alarm4) {
        int i2;
        CaptchaInfo defaultCaptcha;
        int length;
        int length2;
        int i3;
        compoundButton.setChecked(alarm.enabled);
        view.setTag(Integer.valueOf(alarm.id));
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.textColorPrimary, typedValue, true);
        int color = context.getResources().getColor(typedValue.resourceId);
        context.getTheme().resolveAttribute(android.R.attr.textColorSecondary, typedValue, true);
        int color2 = context.getResources().getColor(typedValue.resourceId);
        int i4 = ColorUtil.i(context, R.color.quaternary_alarm);
        DigitalClock digitalClock = (DigitalClock) view.findViewById(R.id.digitalClock);
        TextView textView = (TextView) view.findViewById(R.id.timeDisplay);
        view.findViewById(R.id.next_alarm).setVisibility(8);
        view.findViewById(R.id.bedtime).setOnClickListener(null);
        view.findViewById(R.id.bedtime).setVisibility(8);
        if (alarm3 == null) {
        }
        Calendar calendar = Calendar.getInstance();
        int datestampNumber = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.add(5, 1);
        int datestampNumber2 = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.get(5);
        long j = alarm.suspendTime;
        if (j > alarm.time) {
            Alarms.setSuspendTime(alarm, j);
        }
        calendar.setTimeInMillis(alarm.time);
        int datestampNumber3 = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.get(3);
        int i5 = calendar.get(7);
        int datestampNumber4 = datestampNumber3 - 1;
        if (alarm3 != null) {
            calendar.setTimeInMillis(alarm3.time);
            datestampNumber4 = DateUtil.getDatestampNumber(calendar.getTime());
            calendar.get(3);
            calendar.get(7);
        }
        int i6 = datestampNumber4;
        view.findViewById(R.id.title).setVisibility(8);
        ((TextView) view.findViewById(R.id.titleText)).setText("");
        digitalClock.setBackgroundResource(R.drawable.card);
        if (!alarm.enabled) {
            digitalClock.setBackgroundResource(R.drawable.card_inactive);
        }
        digitalClock.setPadding((int) context.getResources().getDimension(R.dimen.card_padding_horizontal), (int) context.getResources().getDimension(R.dimen.card_padding_vertical), (int) context.getResources().getDimension(R.dimen.card_padding_horizontal), (int) context.getResources().getDimension(R.dimen.card_padding_vertical));
        int i7 = 0;
        view.findViewById(R.id.footer).setBackgroundResource(0);
        view.findViewById(R.id.footer).setBackgroundColor(ColorUtil.i(context, R.color.bg_main_legacy));
        if (z) {
            view.findViewById(R.id.title).setBackgroundColor(ColorUtil.i(context, R.color.bg_card_dashboard));
            if ((alarm3 == null && !alarm.enabled) || (alarm3 != null && alarm3.enabled != alarm.enabled)) {
                view.findViewById(R.id.title).setVisibility(0);
                view.findViewById(R.id.title).setBackgroundColor(ColorUtil.i(context, R.color.bg_main_legacy));
                ((TextView) view.findViewById(R.id.titleText)).setText(context.getString(R.string.disabled));
                ((ImageButton) view.findViewById(R.id.bedtime)).setImageResource(R.drawable.ic_action_discard_small_trans);
                view.findViewById(R.id.bedtime).setOnClickListener(new AlarmFragment$$ExternalSyntheticLambda3(context, alarmFragment, i7));
                view.setFocusable(false);
                view.findViewById(R.id.bedtime).setVisibility(0);
            } else if (alarm.enabled) {
                if (alarm4 == null || !alarm4.enabled) {
                    view.findViewById(R.id.footer).setBackgroundResource(R.drawable.card_alarm_title_last);
                } else {
                    view.findViewById(R.id.footer).setBackgroundResource(R.drawable.card_alarm_gap);
                }
                view.findViewById(R.id.row).setTransitionName(null);
                if (i6 != datestampNumber3) {
                    view.findViewById(R.id.title).setVisibility(0);
                    if (alarm3 == null) {
                        view.findViewById(R.id.row).setTransitionName("box");
                        view.findViewById(R.id.title).setBackgroundResource(R.drawable.card_alarm_title_first);
                    } else {
                        view.findViewById(R.id.title).setBackgroundResource(R.drawable.card_alarm_title);
                    }
                    if (datestampNumber3 == datestampNumber) {
                        ((TextView) view.findViewById(R.id.titleText)).setText(context.getString(R.string.today));
                    } else if (datestampNumber3 == datestampNumber2) {
                        ((TextView) view.findViewById(R.id.titleText)).setText(context.getString(R.string.tomorrow));
                    } else if (alarm.time > System.currentTimeMillis() + 604800000) {
                        ((TextView) view.findViewById(R.id.titleText)).setText(DateUtil.getShortDateLongerWeekInstanceWithoutYears(context).format(new Date(alarm.time)));
                    } else {
                        ((TextView) view.findViewById(R.id.titleText)).setText(capitalizeFirstLetter(DateUtil.getLongWeekdayNames()[i5]));
                    }
                }
            }
        } else {
            view.findViewById(R.id.title).setBackgroundColor(ColorUtil.i(context, R.color.bg_card_dashboard));
            if (alarm.enabled) {
                if (alarm4 == null || !alarm4.enabled) {
                    view.findViewById(R.id.footer).setBackgroundResource(R.drawable.card_alarm_title_last);
                } else {
                    view.findViewById(R.id.footer).setBackgroundResource(R.drawable.card_alarm_gap);
                }
                view.findViewById(R.id.row).setTransitionName(null);
                view.findViewById(R.id.title).setVisibility(0);
                if (alarm3 == null || !alarm3.enabled) {
                    view.findViewById(R.id.row).setTransitionName("box");
                    view.findViewById(R.id.title).setBackgroundResource(R.drawable.card_alarm_title_first);
                } else {
                    view.findViewById(R.id.title).setBackgroundResource(R.drawable.card_alarm_title);
                }
                if (datestampNumber3 == datestampNumber) {
                    ((TextView) view.findViewById(R.id.titleText)).setText(context.getString(R.string.today));
                } else if (datestampNumber3 == datestampNumber2) {
                    ((TextView) view.findViewById(R.id.titleText)).setText(context.getString(R.string.tomorrow));
                } else if (alarm.time > System.currentTimeMillis() + 604800000) {
                    ((TextView) view.findViewById(R.id.titleText)).setText(DateUtil.getShortDateLongerWeekInstanceWithoutYears(context).format(new Date(alarm.time)));
                } else {
                    ((TextView) view.findViewById(R.id.titleText)).setText(capitalizeFirstLetter(DateUtil.getLongWeekdayNames()[i5]));
                }
            }
        }
        boolean z2 = alarm.suspendTime > 0 && isNextAlarmDisabled(alarm);
        DigitalClock digitalClock2 = (DigitalClock) view.findViewById(R.id.digitalClock);
        ImageView imageView = (ImageView) digitalClock2.findViewById(R.id.alarm_icon);
        if (alarm.extendedConfig.isSelfDisposable().booleanValue()) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.ic_action_discard_small_secondary);
            i2 = 8;
        } else {
            i2 = 8;
            imageView.setVisibility(8);
        }
        if (!alarm.enabled) {
            imageView.setVisibility(i2);
        }
        int i8 = ColorUtil.i(context, R.color.quaternary_alarm);
        textView.setOnClickListener(new AlarmFragment$$ExternalSyntheticLambda3(context, alarm, 2));
        textView.setOnLongClickListener(new AlarmFragment$$ExternalSyntheticLambda5());
        ((TextView) view.findViewById(R.id.am_pm)).setTextColor((!alarm.enabled || z2) ? i4 : color);
        textView.setTextColor((!alarm.enabled || z2) ? i4 : color);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(alarm.time);
        calendar2.set(11, alarm.getOffsetHour(context));
        calendar2.set(12, alarm.getOffsetMinutes(context));
        if (Alarm.isPowerNap(alarm)) {
            calendar2.add(12, -59);
        }
        digitalClock2.updateTime(calendar2);
        TextView textView2 = (TextView) digitalClock2.findViewById(R.id.daysOfWeek);
        Spannable spanneble = alarm.getDaysOfWeek().toSpanneble(context, (alarm2 == null || alarm.id != alarm2.id) ? -1 : i, (!alarm.enabled || z2) ? i8 : ColorUtil.i(context, R.color.tint));
        ((TextView) digitalClock2.findViewById(R.id.placeholder)).setText(" ");
        if (spanneble == null || spanneble.length() == 0) {
            textView2.setVisibility(8);
            digitalClock2.findViewById(R.id.placeholder).setVisibility(0);
        } else {
            textView2.setText(spanneble);
            textView2.setVisibility(0);
            digitalClock2.findViewById(R.id.placeholder).setVisibility(8);
            textView2.setTextColor((!alarm.enabled || z2) ? i8 : color2);
        }
        if (alarm.getOffset() != 0) {
            Calendar calendarCalculateAlarm = Alarms.calculateAlarm(context, alarm.hour, alarm.minutes, alarm.getDaysOfWeek());
            if (Alarm.isPowerNap(alarm)) {
                calendarCalculateAlarm.add(12, -59);
            }
            if (calendarCalculateAlarm != null) {
                ((TextView) digitalClock2.findViewById(R.id.placeholder)).setText(DateUtil.formatTime(context, calendarCalculateAlarm.getTimeInMillis()) + " ");
                digitalClock2.findViewById(R.id.placeholder).setVisibility(0);
            }
        }
        if (alarm.enabled) {
            if (alarm.getOffset() != 0) {
                textView.setTextColor(ColorUtil.i(context, R.color.tint));
                ((TextView) view.findViewById(R.id.am_pm)).setTextColor(ColorUtil.i(context, R.color.tint));
            } else {
                textView.setTextColor(ColorUtil.i(context, R.color.primary));
                ((TextView) view.findViewById(R.id.am_pm)).setTextColor(ColorUtil.i(context, R.color.primary));
            }
        }
        TextView textView3 = (TextView) view.findViewById(R.id.label);
        String str = alarm.label;
        if (str == null || str.length() == 0) {
            textView3.setVisibility(4);
        } else {
            textView3.setText(alarm.label);
            textView3.setVisibility(0);
            textView3.setTextColor((!alarm.enabled || z2) ? i8 : color2);
        }
        TextView textView4 = (TextView) view.findViewById(R.id.prefs);
        StringBuilder sb = new StringBuilder();
        Uri uri = alarm.alert;
        if (uri == null || uri.equals("")) {
            sb.append(context.getString(R.string.silent_alarm_summary));
        }
        int i9 = alarm.captcha;
        if (i9 <= 0) {
            if (i9 == 0 && (defaultCaptcha = SharedApplicationContext.getSettings().getDefaultCaptcha()) != null) {
                String label = defaultCaptcha.getLabel();
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                length = sb.length();
                length2 = label.length() + sb.length();
                sb.append(label);
            }
            i3 = alarm.nonDeepsleepWakeupWindow;
            if (i3 >= 0 && i3 != SharedApplicationContext.getSettings().getSmartWakeupMinutes()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                if (Alarm.isPowerNap(alarm)) {
                    sb.append(DateUtil.formatMinutes(Integer.valueOf(alarm.nonDeepsleepWakeupWindow)));
                    sb.append(" ");
                    sb.append(context.getResources().getString(R.string.non_deep_sleep_window_title));
                } else {
                    sb.append(context.getResources().getString(R.string.power_nap));
                }
            }
            if (sb.length() > 0) {
                textView4.setVisibility(8);
                return;
            }
            sb.append("  ");
            textView4.setText(sb.toString());
            textView4.setVisibility(0);
            if (alarm.enabled) {
                i8 = i4;
            }
            textView4.setTextColor(i8);
            if (length > -1) {
                textView4.setText(sb.toString(), TextView.BufferType.SPANNABLE);
                ((Spannable) textView4.getText()).setSpan(STRIKE_THROUGH_SPAN, length, length2, 33);
                return;
            }
            return;
        }
        CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(alarm.captcha);
        if (captchaInfo != null) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(captchaInfo.getLabel());
        }
        length = -1;
        length2 = -1;
        i3 = alarm.nonDeepsleepWakeupWindow;
        if (i3 >= 0) {
            if (sb.length() > 0) {
            }
            if (Alarm.isPowerNap(alarm)) {
            }
        }
        if (sb.length() > 0) {
        }
    }

    private boolean menuAction(int i) {
        if (i != R.id.menu_item_settings) {
            return false;
        }
        startActivity(new Intent(getActivity(), (Class<?>) SimpleSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAlarm() {
        Alarms.setNextAlert(getActivity());
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(getActivity());
        this.nextAlarm = alarmCalculateNextAlert;
        AlarmTimeAdapter alarmTimeAdapter = this.adapter;
        if (alarmTimeAdapter != null) {
            alarmTimeAdapter.setNextAlarm(alarmCalculateNextAlert);
        }
        updateDroidIcon();
        updateBedtime();
    }

    private void refreshAlarmList() {
        if (this.sortByDay != SharedApplicationContext.getSettings().isAlarmSortByDay()) {
            this.sortByDay = !this.sortByDay;
            Logger.logInfo("AlarmFragment: Refreshing alarm sorting");
            this.mCursor = Alarms.getAlarmsCursor(getActivity());
            AlarmTimeAdapter alarmTimeAdapter = new AlarmTimeAdapter(getActivity(), this.mCursor, this, this.sortByDay);
            this.adapter = alarmTimeAdapter;
            this.mAlarmsList.setAdapter((ListAdapter) alarmTimeAdapter);
            this.adapter.notifyDataSetChanged();
        }
        AlarmTimeAdapter alarmTimeAdapter2 = this.adapter;
        if (alarmTimeAdapter2 != null) {
            alarmTimeAdapter2.setNextAlarm(this.nextAlarm);
            this.adapter.notifyDataSetChanged();
        }
        this.updateBedtime.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibleAnim(View view, Animation animation) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
            view.startAnimation(animation);
        }
    }

    private void showBatteryOverheatDialogIfRequired() {
        final String andResetBatteryErrorReport = SharedApplicationContext.getInstance().getAndResetBatteryErrorReport();
        if (andResetBatteryErrorReport != null) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
            materialAlertDialogBuilder.setMessage(R.string.battery_overheat_dialog_text).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ErrorReporter.getInstance().generateOnDemandReport(null, "Battery overheat report", andResetBatteryErrorReport);
                }
            }).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            materialAlertDialogBuilder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchSwitch(final Alarm alarm, final CompoundButton compoundButton) {
        final boolean zIsChecked = compoundButton.isChecked();
        if (!Environment.isIcsOrGreater()) {
            updateAlarm(zIsChecked, alarm);
            updateDroidIcon();
        } else {
            Animation animation = zIsChecked ? this.animEnable : this.animDisable;
            final Animation animation2 = zIsChecked ? this.animEnableAfter : this.animDisableAfter;
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    AlarmFragment.this.updateAlarm(zIsChecked, alarm);
                    AlarmFragment.this.updateDroidIcon();
                    ((View) compoundButton.getParent().getParent().getParent()).startAnimation(animation2);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation3) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation3) {
                }
            });
            ((View) compoundButton.getParent().getParent().getParent()).startAnimation(animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAlarm(boolean z, Alarm alarm) {
        FragmentActivity activity;
        if (z) {
            Alarms.enableAlarm(getActivity(), alarm.id, z);
        } else if (!Alarms.disableAlarmOrShowCaptcha(getActivity(), alarm)) {
            return;
        }
        if (z && (activity = getActivity()) != null) {
            SetAlarm.popAlarmSetToast(activity, alarm, Alarm.isPowerNap(alarm));
        }
        refreshAlarm();
    }

    private void updateBedtime() {
        this.h.removeCallbacks(this.updateBedtime);
        this.h.postDelayed(this.updateBedtime, 100L);
    }

    private void updateLayout(View view) {
        View viewFindViewById = view.findViewById(R.id.clock);
        this.clock = viewFindViewById;
        viewFindViewById.setVisibility(8);
        ListView listView = (ListView) view.findViewById(R.id.alarms_list);
        this.mAlarmsList = listView;
        int i = 0;
        listView.setVerticalScrollBarEnabled(false);
        this.mAlarmsList.setVerticalFadingEdgeEnabled(false);
        this.mAlarmsList.setOnItemClickListener(this);
        this.mAlarmsList.setOnCreateContextMenuListener(this);
        final Button button = (Button) view.findViewById(R.id.sleep_button_fallback);
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.show);
        final Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.hide);
        final Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), android.R.anim.fade_in);
        final Animation animationLoadAnimation4 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade_fast);
        if (this.mAlarmsList.getHeaderViewsCount() == 0) {
            if (SharedApplicationContext.getSettings().isDashboard() || SharedApplicationContext.getSettings().isAlarmOnly()) {
                this.mAlarmsList.addHeaderView(new View(this.mAlarmsList.getContext()));
            } else {
                ViewGroup viewGroup = (ViewGroup) InflatorUtil.get(this.mAlarmsList.getContext()).inflate(R.layout.add_alarm_header, (ViewGroup) null, false);
                viewGroup.findViewById(R.id.add_alarm_button).setOnClickListener(new AlarmFragment$$ExternalSyntheticLambda0(this, i));
                this.mAlarmsList.addHeaderView(viewGroup);
            }
        }
        this.mAlarmsList.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                if (AlarmFragment.this.isFramentVisible()) {
                    for (View view2 : AlarmFragment.this.fabs) {
                        if (i2 > AlarmFragment.this.firstVisibleItem && view2.getVisibility() != 8) {
                            view2.startAnimation(animationLoadAnimation2);
                            view2.setVisibility(8);
                            if (view2 == AlarmFragment.this.fab) {
                                button.setVisibility(0);
                                button.startAnimation(animationLoadAnimation);
                            }
                        } else if (i2 < AlarmFragment.this.firstVisibleItem && view2.getVisibility() == 8) {
                            Logger.logInfo("AlarmClock: setting droid visible on scroll");
                            view2.setVisibility(0);
                            view2.startAnimation(animationLoadAnimation);
                            if (view2 == AlarmFragment.this.fab) {
                                button.startAnimation(animationLoadAnimation2);
                                button.setVisibility(8);
                            }
                        }
                    }
                    AlarmFragment.this.firstVisibleItem = i2;
                    if (AlarmFragment.this.scrollAnimator == null) {
                        AlarmFragment.this.scrollAnimator = new ScrollAnimator(AlarmFragment.this.getActivity(), AlarmFragment.this.fab);
                    }
                    AlarmFragment.this.scrollAnimator.scroll(i2);
                    if (AlarmFragment.this.bedtimeView != null) {
                        if (i2 > 0 && AlarmFragment.this.bedtimeView.getVisibility() != 8) {
                            AlarmFragment.this.bedtimeView.startAnimation(animationLoadAnimation4);
                            AlarmFragment.this.bedtimeView.setVisibility(8);
                        } else if (i2 == 0 && AlarmFragment.this.bedtimeView.getVisibility() == 8 && AlarmFragment.this.nextAlarm != null) {
                            AlarmFragment.this.bedtimeView.setVisibility(0);
                            AlarmFragment.this.bedtimeView.startAnimation(animationLoadAnimation3);
                        }
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
            }
        });
        AlarmTimeAdapter alarmTimeAdapter = new AlarmTimeAdapter(getActivityIfAvailable(), this.mCursor, this, this.sortByDay);
        this.adapter = alarmTimeAdapter;
        this.mAlarmsList.setAdapter((ListAdapter) alarmTimeAdapter);
        View view2 = new View(getContext());
        view2.setBackgroundColor(ColorUtil.i(getContext(), R.color.bg_main_legacy));
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, ActivityUtils.getDip(getContext(), 48)));
        this.mAlarmsList.addFooterView(view2, null, false);
        refreshAlarm();
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public View createBaseView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        GlobalInitializator.initializeIfRequired(getActivity());
        if (this.h == null) {
            this.h = new Handler();
        }
        return layoutInflater.inflate(R.layout.fragment_alarm_clock, viewGroup, false);
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public boolean eagerLoad() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        final AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        return new AlarmPopupHandler(getActivity(), new AlarmPopupHandler.Refresher() { // from class: com.urbandroid.sleep.fragment.AlarmFragment$$ExternalSyntheticLambda1
            @Override // com.urbandroid.sleep.fragment.AlarmPopupHandler.Refresher
            public final void refresh() {
                this.f$0.refreshAlarm();
            }
        }).handle(menuItem, new AlarmPopupHandler.AlarmRetriever() { // from class: com.urbandroid.sleep.fragment.AlarmFragment$$ExternalSyntheticLambda2
            @Override // com.urbandroid.sleep.fragment.AlarmPopupHandler.AlarmRetriever
            public final Alarm getAlarm() {
                return this.f$0.lambda$onContextItemSelected$3(adapterContextMenuInfo);
            }
        }, (int) adapterContextMenuInfo.id) || super.onContextItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        View viewFindViewById;
        if (getActivity() != null) {
            getActivity().getMenuInflater().inflate(R.menu.context_menu, contextMenu);
            if (Environment.isHoneycombOrGreater() && view != null) {
                try {
                    int identifier = getActivity().getResources().getIdentifier("android:id/titleDivider", null, null);
                    if (identifier > 0 && (viewFindViewById = view.findViewById(identifier)) != null) {
                        viewFindViewById.setBackgroundColor(ColorUtil.i(getActivityIfAvailable(), R.color.tint));
                    }
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
        }
        Cursor cursor = (Cursor) this.mAlarmsList.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (cursor == null) {
            return;
        }
        Alarm alarm = new Alarm(cursor);
        contextMenu.findItem(R.id.enable_alarm_for_today).setVisible(alarm.getDaysOfWeek() != null && alarm.getDaysOfWeek().isRepeatSet() && alarm.enabled && isNextAlarmDisabled(alarm));
        if (alarm.enabled) {
            contextMenu.findItem(R.id.enable_alarm).setTitle(R.string.turn_off);
            contextMenu.findItem(R.id.delete_all_disabled).setVisible(false);
        } else {
            contextMenu.findItem(R.id.enable_alarm_for_today).setVisible(false);
            contextMenu.findItem(R.id.disable_alarm_for_today).setVisible(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ToastMaster.cancelToast();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        SetAlarm.showSetAlarmActivity(getActivity(), j, false);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return menuAction(menuItem.getItemId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.logInfo("AlarmClock: alarm fragment pause");
        if (this.receiver != null) {
            getActivityIfAvailable().unregisterReceiver(this.receiver);
            this.receiver = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ListView listView;
        super.onResume();
        Logger.logInfo("AlarmClock: alarm fragment resume");
        this.receiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.5
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (!intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_TIME_TO_BED_UPDATE")) {
                    if (intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED")) {
                        AlarmFragment.this.refreshAlarm();
                    }
                } else {
                    if (!AlarmFragment.this.isAdded() || AlarmFragment.this.getActivity() == null) {
                        return;
                    }
                    AlarmFragment.this.updateDroidIcon();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.alarmclock.ALARM_TIME_TO_BED_UPDATE");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED");
        ContextCompat.registerReceiver(getActivityIfAvailable(), this.receiver, intentFilter, 2);
        if (isAlreadyLoaded()) {
            refreshAlarmList();
            refreshAlarm();
            updateDroidIcon();
            showBatteryOverheatDialogIfRequired();
            SharedApplicationContext.getSettings().resetSnoozeRepeatIfNoSnoozeScheduled();
            hideDroidIfConfigured();
            View view = this.noData;
            if (view == null || (listView = this.mAlarmsList) == null) {
                return;
            }
            view.setVisibility(listView.getAdapter().getCount() < 3 ? 0 : 8);
            this.noData.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlarmFragment.this.startActivity(new Intent(AlarmFragment.this.getActivity(), (Class<?>) SetAlarm.class));
                }
            });
        }
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void onSetVisible() {
        super.onSetVisible();
        if (this.h == null) {
            this.h = new Handler();
        }
        this.h.removeCallbacks(this.updateBedtime);
        this.h.postDelayed(this.updateBedtime, 1000L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void populateBaseView(View view, LayoutInflater layoutInflater, Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (view.findViewById(R.id.alarms_list) != null) {
            if (activity instanceof AlarmClock) {
                view.findViewById(R.id.alarms_list).setPadding(0, ActivityUtils.getDip(activity, 8), 0, 0);
            } else if (activity instanceof AlarmActivity) {
                view.findViewById(R.id.alarms_list).setPadding(0, 0, 0, 0);
            }
        }
        this.noData = view.findViewById(R.id.no_data);
        Logger.logInfo("AlarmClock: populateBaseView");
        Settings settings = new Settings(getActivity());
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.bedtime_indicator);
        this.bedtimeView = viewGroup;
        if (viewGroup == null || getActivity() == null || !(getActivity() instanceof AlarmActivity)) {
            this.bedtimeView.setPadding(ActivityUtils.getDip(getContext(), 36), ActivityUtils.getDip(getContext(), 22), ActivityUtils.getDip(getContext(), 36), 0);
        } else {
            this.bedtimeView.setPadding(ActivityUtils.getDip(getContext(), 36), ActivityUtils.getDip(getContext(), 14), ActivityUtils.getDip(getContext(), 36), 0);
        }
        setRetainInstance(true);
        this.mFactory = InflatorUtil.get(getActivity());
        this.sortByDay = SharedApplicationContext.getSettings().isAlarmSortByDay();
        this.alarmOnly = SharedApplicationContext.getSettings().isAlarmOnly();
        Cursor alarmsCursor = Alarms.getAlarmsCursor(getActivity());
        this.mCursor = alarmsCursor;
        if (alarmsCursor == null) {
            Logger.logSevere("AlarmClock: MCursor is empty!");
        }
        this.fab = (MaterialButton) getActivity().findViewById(R.id.fab);
        boolean zIsDashboard = settings.isDashboard();
        MaterialButton materialButton = this.fab;
        if (zIsDashboard) {
            materialButton.setIconResource(R.drawable.ic_alarm_plus_white);
            this.fab.setText(R.string.add_alarm);
        } else {
            materialButton.setIconResource(R.drawable.ic_action_track_white);
            this.fab.setText(R.string.start_sleep_tracking);
        }
        view.findViewById(R.id.sleep_button_fallback).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.AlarmFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new SleepStarter().startSleep(AlarmFragment.this.getActivity().getApplicationContext());
            }
        });
        if (this.droidLayout == null) {
            ImageView imageView = (ImageView) getActivity().findViewById(R.id.droid);
            this.droidLayout = imageView;
            EdgeToEdgeUtil.insetsBottom(imageView);
        }
        updateLayout(view);
        this.animDisable = AnimationUtils.loadAnimation(getActivity(), R.anim.shake_left_hide);
        this.animEnable = AnimationUtils.loadAnimation(getActivity(), R.anim.shake_right_hide);
        this.animDisableAfter = AnimationUtils.loadAnimation(getActivity(), R.anim.shake_right_show);
        this.animEnableAfter = AnimationUtils.loadAnimation(getActivity(), R.anim.shake_left_show);
        if (firstCreate) {
            SuspensionSupportDetector.initializeSuspensionDetectionIfRequired(getActivity().getApplicationContext());
            firstCreate = false;
        }
        hideDroidIfConfigured();
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment, com.urbandroid.sleep.fragment.ILazyFragment
    public void setInvisible() {
        super.setInvisible();
        if (this.h == null) {
            this.h = new Handler();
        }
        this.h.removeCallbacks(this.updateBedtime);
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment, com.urbandroid.sleep.fragment.ILazyFragment
    public void setVisible() {
        super.setVisible();
        hideDroidIfConfigured();
    }

    public void updateDroidIcon() {
        if (!isAdded() || getActivity() == null || (getActivity() instanceof AlarmActivity)) {
            return;
        }
        this.updateBedtime.run();
        Date nextTimeToBed = SharedApplicationContext.getSettings().getNextTimeToBed();
        int resource = IconProvider.getResource(getActivityIfAvailable(), Calendar.getInstance(), nextTimeToBed != null ? (nextTimeToBed.getTime() - System.currentTimeMillis()) / 60000 : 10080L, "droid");
        ImageView imageView = this.droidLayout;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(getActivityIfAvailable(), resource));
        }
        if (getActivity() != null) {
            this.fab = (MaterialButton) getActivity().findViewById(R.id.fab);
        }
    }
}

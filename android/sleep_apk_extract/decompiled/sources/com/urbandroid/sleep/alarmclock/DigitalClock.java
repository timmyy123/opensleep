package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import android.provider.Settings;
import android.text.Html;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class DigitalClock extends LinearLayout {
    private AmPm mAmPm;
    private boolean mAttached;
    private Calendar mCalendar;
    private String mFormat;
    private ContentObserver mFormatChangeObserver;
    private final Handler mHandler;
    private final BroadcastReceiver mIntentReceiver;
    private boolean mLive;
    private TextView mTimeDisplay;
    private TextView mTimeToBedDisplay;

    public static class AmPm {
        private TextView mAmPm;
        private String mAmString;
        private String mPmString;
        private boolean show = false;

        public AmPm(View view) {
            this.mAmPm = (TextView) view.findViewById(R.id.am_pm);
            String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
            this.mAmString = amPmStrings[0];
            this.mPmString = amPmStrings[1];
        }

        public void setIsMorning(boolean z) {
            boolean z2 = this.show;
            TextView textView = this.mAmPm;
            if (z2) {
                if (textView != null) {
                    textView.setText(z ? this.mAmString : this.mPmString);
                }
            } else if (textView != null) {
                textView.setText("");
            }
        }

        public void setShowAmPm(boolean z) {
            this.show = z;
        }
    }

    public class FormatChangeObserver extends ContentObserver {
        public FormatChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            DigitalClock.this.setDateFormat();
            DigitalClock.this.updateTime();
        }
    }

    public DigitalClock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLive = true;
        this.mHandler = new Handler();
        this.mIntentReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.DigitalClock.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DigitalClock.this.mLive && intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                    DigitalClock.this.mCalendar = Calendar.getInstance();
                }
                DigitalClock.this.mHandler.post(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.DigitalClock.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DigitalClock.this.updateTime();
                    }
                });
            }
        };
    }

    private void assignAllUnassignedViews() {
        if (this.mTimeDisplay == null) {
            this.mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
        }
        if (this.mTimeDisplay == null) {
            this.mTimeDisplay = (TextView) findViewById(R.id.timeDisplayDim);
        }
        if (this.mTimeToBedDisplay == null) {
            this.mTimeToBedDisplay = (TextView) findViewById(R.id.timeToBedDisplay);
        }
        if (this.mAmPm == null) {
            this.mAmPm = new AmPm(this);
        }
        if (this.mCalendar == null) {
            this.mCalendar = Calendar.getInstance();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDateFormat() {
        String str = Alarms.get24HourMode(getContext()) ? "kk:mm" : "h:mm";
        this.mFormat = str;
        this.mAmPm.setShowAmPm(str == "h:mm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTime() {
        Calendar calendar = this.mCalendar;
        if (calendar == null || this.mFormat == null) {
            return;
        }
        if (this.mLive) {
            calendar.setTimeInMillis(System.currentTimeMillis());
        }
        CharSequence charSequence = DateFormat.format(this.mFormat, this.mCalendar);
        TextView textView = this.mTimeDisplay;
        if (textView != null) {
            textView.setText(charSequence);
        }
        AmPm amPm = this.mAmPm;
        if (amPm != null) {
            amPm.setIsMorning(this.mCalendar.get(9) == 0);
        }
        if (this.mTimeToBedDisplay != null) {
            Date nextAlarm = SharedApplicationContext.getSettings().getNextAlarm();
            if (nextAlarm == null) {
                this.mTimeToBedDisplay.setVisibility(8);
                return;
            }
            Date nextTimeToBed = SharedApplicationContext.getSettings().getNextTimeToBed();
            long time = nextTimeToBed != null ? ((nextTimeToBed.getTime() - System.currentTimeMillis()) / 60000) + 1 : 10080L;
            if (time < -9) {
                time = SharedApplicationContext.getSettings().getMinutesToAlarm();
                this.mTimeToBedDisplay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_time, 0);
            } else {
                this.mTimeToBedDisplay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_bedtime, 0);
            }
            if (time > 720) {
                String strReplace = DateUtil.formatTime(getContext(), nextAlarm.getTime()).replace(" am", "<small>am</small>").replace(" AM", "<small>am</small>").replace(" PM", "<small>pm</small>").replace(" pm", "<small>pm</small>");
                this.mTimeToBedDisplay.setText(Html.fromHtml("<big>" + DateUtil.formatDay(nextAlarm.getTime()) + " " + strReplace + "</big>"));
                this.mTimeToBedDisplay.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.mTimeToBedDisplay.setVisibility(0);
                return;
            }
            TextView textView2 = this.mTimeToBedDisplay;
            if (time > 99) {
                textView2.setText(Html.fromHtml("<big>" + DateUtil.formatMinutesPositive(Long.valueOf(time)) + "</big>→"));
                this.mTimeToBedDisplay.setVisibility(0);
                return;
            }
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("<big>", "</big><small>", time);
            sbM.append(getContext().getResources().getString(R.string.bed_time_min));
            sbM.append("</small>→");
            textView2.setText(Html.fromHtml(sbM.toString()), TextView.BufferType.SPANNABLE);
            this.mTimeToBedDisplay.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAttached) {
            return;
        }
        this.mAttached = true;
        if (this.mLive) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_TIME_TO_BED_UPDATE");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            ContextCompat.registerReceiver(getContext(), this.mIntentReceiver, intentFilter, 2);
        }
        this.mFormatChangeObserver = new FormatChangeObserver();
        getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.mFormatChangeObserver);
        updateTime();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAttached) {
            this.mAttached = false;
            if (this.mLive) {
                getContext().unregisterReceiver(this.mIntentReceiver);
            }
            getContext().getContentResolver().unregisterContentObserver(this.mFormatChangeObserver);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        assignAllUnassignedViews();
        setDateFormat();
        updateTime();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        assignAllUnassignedViews();
        setDateFormat();
        updateTime();
    }

    public void setLive(boolean z) {
        this.mLive = z;
    }

    public void setTypeface(Typeface typeface) {
        TextView textView = this.mTimeDisplay;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void updateTime(Calendar calendar) {
        this.mCalendar = calendar;
        updateTime();
    }
}

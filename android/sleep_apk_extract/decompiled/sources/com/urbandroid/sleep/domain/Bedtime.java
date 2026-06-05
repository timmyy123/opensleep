package com.urbandroid.sleep.domain;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.gui.icon.IconProvider;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001d¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/domain/Bedtime;", "", "", "bedtime", "alarm", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Ljava/util/Date;", "(Ljava/util/Date;Ljava/util/Date;)V", "timeInMillies", "", "getRemainingMinutes", "(Ljava/lang/Long;)I", "", "isBedtime", "()Z", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/ViewGroup;", ViewHierarchyConstants.VIEW_KEY, "Landroid/widget/RemoteViews;", "remoteViews", "", "updateTime", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/widget/RemoteViews;)V", "Ljava/lang/Long;", "getBedtime", "()Ljava/lang/Long;", "setBedtime", "(Ljava/lang/Long;)V", "getAlarm", "setAlarm", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Bedtime {
    private Long alarm;
    private Long bedtime;

    public Bedtime(Date date, Date date2) {
        this(date != null ? Long.valueOf(date.getTime()) : null, date2 != null ? Long.valueOf(date2.getTime()) : null);
    }

    private final int getRemainingMinutes(Long timeInMillies) {
        if (timeInMillies == null) {
            return -1;
        }
        return MathKt.roundToInt((timeInMillies.longValue() - System.currentTimeMillis()) / 60000.0f);
    }

    public final Long getAlarm() {
        return this.alarm;
    }

    public final Long getBedtime() {
        return this.bedtime;
    }

    public final boolean isBedtime() {
        int remainingMinutes = getRemainingMinutes(this.bedtime);
        int remainingMinutes2 = getRemainingMinutes(this.alarm);
        if (remainingMinutes < 0 || remainingMinutes >= 240) {
            return remainingMinutes2 >= 0 && remainingMinutes2 < 600 && remainingMinutes < 0;
        }
        return true;
    }

    public final void updateTime(Context context, ViewGroup view, RemoteViews remoteViews) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        TextView textView4;
        TextView textView5;
        ImageView imageView2;
        TextView textView6;
        TextView textView7;
        context.getClass();
        int remainingMinutes = getRemainingMinutes(this.alarm);
        int remainingMinutes2 = getRemainingMinutes(this.bedtime);
        if (remainingMinutes < 0 && (remainingMinutes2 < 0 || remainingMinutes2 > 240)) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 21);
            if (calendar.getTime().before(new Date())) {
                calendar.add(5, 1);
            }
            if (view != null && (textView7 = (TextView) view.findViewById(R.id.title)) != null) {
                textView7.setText(R.string.instructions_no_alarm);
            }
            if (remoteViews != null) {
                remoteViews.setTextViewText(R.id.title, context.getString(R.string.instructions_no_alarm));
            }
            if (view != null && (textView6 = (TextView) view.findViewById(R.id.summary)) != null) {
                textView6.setText("...");
            }
            if (remoteViews != null) {
                remoteViews.setTextViewText(R.id.summary, "...");
            }
            int resource = IconProvider.getResource(context, Calendar.getInstance(), remainingMinutes2 < 0 ? getRemainingMinutes(Long.valueOf(calendar.getTimeInMillis())) : remainingMinutes2, "droid");
            if (resource > -1) {
                if (view != null && (imageView2 = (ImageView) view.findViewById(R.id.droid_icon)) != null) {
                    imageView2.setImageResource(resource);
                }
                if (remoteViews != null) {
                    remoteViews.setImageViewResource(R.id.droid_icon, resource);
                    return;
                }
                return;
            }
            return;
        }
        if ((remainingMinutes2 < 0 || remainingMinutes2 >= 240) && remainingMinutes >= 0 && remainingMinutes < 600 && remainingMinutes2 < 0) {
            remainingMinutes2 = -1;
        }
        int i = remainingMinutes2 >= 0 ? R.string.time_to_bed_title : Alarms.isSnoozing(context) ? R.string.alarm_alert_snooze_text : R.string.default_label;
        if (view != null && (textView5 = (TextView) view.findViewById(R.id.title)) != null) {
            textView5.setText(i);
        }
        if (remoteViews != null) {
            remoteViews.setTextViewText(R.id.title, context.getString(i));
        }
        String minutesInHumanLanguageHtml = DateUtil.formatMinutesInHumanLanguageHtml(context, Integer.valueOf(remainingMinutes2 >= 0 ? remainingMinutes2 : remainingMinutes));
        if (view != null && (textView4 = (TextView) view.findViewById(R.id.summary)) != null) {
            textView4.setText(Html.fromHtml(minutesInHumanLanguageHtml));
        }
        if (remoteViews != null) {
            remoteViews.setTextViewText(R.id.summary, Html.fromHtml(minutesInHumanLanguageHtml));
        }
        if (remainingMinutes2 < 0 || remainingMinutes2 > 239) {
            long j = remainingMinutes;
            if (j > 720 && this.alarm != null) {
                if (view != null && (textView3 = (TextView) view.findViewById(R.id.title)) != null) {
                    textView3.setText(R.string.default_label);
                }
                if (remoteViews != null) {
                    remoteViews.setTextViewText(R.id.title, context.getString(R.string.default_label));
                }
                if (view != null && (textView2 = (TextView) view.findViewById(R.id.summary)) != null) {
                    Long l = this.alarm;
                    l.getClass();
                    textView2.setText(DateUtil.formatTimeNeverAmPm(context, l.longValue()));
                }
                if (remoteViews != null) {
                    Long l2 = this.alarm;
                    l2.getClass();
                    remoteViews.setTextViewText(R.id.summary, DateUtil.formatTimeNeverAmPm(context, l2.longValue()));
                }
                Long l3 = this.alarm;
                l3.getClass();
                String day = DateUtil.formatDay(l3.longValue());
                if (!day.equals(DateUtil.formatDay(System.currentTimeMillis())) || j > 1440) {
                    if (view != null && (textView = (TextView) view.findViewById(R.id.title)) != null) {
                        textView.setText(day);
                    }
                    if (remoteViews != null) {
                        remoteViews.setTextViewText(R.id.title, day);
                    }
                }
            }
        }
        int resource2 = IconProvider.getResource(context, Calendar.getInstance(), remainingMinutes2 < 0 ? -1L : remainingMinutes2, "droid");
        if (resource2 > -1) {
            if (view != null && (imageView = (ImageView) view.findViewById(R.id.droid_icon)) != null) {
                imageView.setImageResource(resource2);
            }
            if (remoteViews != null) {
                remoteViews.setImageViewResource(R.id.droid_icon, resource2);
            }
        }
    }

    public Bedtime(Long l, Long l2) {
        this.bedtime = l;
        this.alarm = l2;
    }
}

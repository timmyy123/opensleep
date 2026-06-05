package com.urbandroid.sleep.service.google.calendar.alarm;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.getpebble.android.kit.Constants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.util.ColorUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "notifyCalendar", "", "mode", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier$Mode;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "alarm", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "currentTime", "Ljava/util/Calendar;", "Mode", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarNotifier implements FeatureLogger {
    private final String tag = "calendar:notify";

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void notifyCalendar(Mode mode, Context context, Alarm alarm, GoogleCalendar.Event event, Calendar currentTime) {
        mode.getClass();
        context.getClass();
        alarm.getClass();
        event.getClass();
        currentTime.getClass();
        Intent intent = new Intent(context, (Class<?>) Sleep.class);
        intent.setFlags(268566528);
        int i = alarm.id;
        String eventId = event.getEventId();
        int iCharAt = 0;
        for (int i2 = 0; i2 < eventId.length(); i2++) {
            iCharAt += eventId.charAt(i2);
        }
        int i3 = i * iCharAt * 13;
        PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
        PendingIntent activity = companion.get(context, 0, intent, 0).getActivity();
        Intent intent2 = new Intent(context, mode.getActionActivity());
        intent2.setAction(mode.getAction());
        intent2.putExtra("alarm_id", alarm.id);
        intent2.putExtra("notification_id", i3);
        PendingIntent activity2 = companion.get(context, i3, intent2, 134217728).getActivity();
        String contentText = mode.getContentText(context, alarm, currentTime);
        Resources resources = context.getResources();
        resources.getClass();
        String contentTitle = mode.getContentTitle(resources, event);
        String strM = Fragment$$ExternalSyntheticOutline1.m("title: ", contentTitle, "\ttext: ", contentText);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        NotificationManagerCompat.from(context).getClass();
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, "calendarChannel").setContentIntent(activity).setColor(ColorUtil.i(context, R.color.tint_notification)).setAutoCancel(true).addAction(0, context.getString(mode.getActionText()), activity2).setAutoCancel(true).setContentTitle(contentTitle).setContentText(contentText).setSmallIcon(mode.getIcon());
        smallIcon.getClass();
        Notification notificationBuild = smallIcon.build();
        notificationBuild.getClass();
        NotificationsKt.notify(context, i3, notificationBuild);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001'B?\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u0018\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001d\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0015\u0010&\u001a\u00020\u0002*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b$\u0010%j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006,"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier$Mode;", "", "", "action", "", Constants.CUST_ICON, "contentText", "actionText", "Ljava/lang/Class;", "actionActivity", "<init>", "(Ljava/lang/String;ILjava/lang/String;IIILjava/lang/Class;)V", "Landroid/content/res/Resources;", "resources", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "event", "getContentTitle", "(Landroid/content/res/Resources;Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)Ljava/lang/String;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/alarmclock/Alarm;", "alarm", "Ljava/util/Calendar;", "currentTime", "getContentText", "(Landroid/content/Context;Lcom/urbandroid/sleep/alarmclock/Alarm;Ljava/util/Calendar;)Ljava/lang/String;", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "I", "getIcon", "()I", "getActionText", "Ljava/lang/Class;", "getActionActivity", "()Ljava/lang/Class;", "getNotifyTitle", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)Ljava/lang/String;", "notifyTitle", "Companion", "HOLIDAY_NOTIFY", "HOLIDAY_SKIP", "EVENT", "EVENT_RESCHEDULE_ALARM", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        private static final SimpleDateFormat formatTime;
        private final String action;
        private final Class<?> actionActivity;
        private final int actionText;
        private final int contentText;
        private final int icon;
        public static final Mode HOLIDAY_NOTIFY = new HOLIDAY_NOTIFY("HOLIDAY_NOTIFY", 0);
        public static final Mode HOLIDAY_SKIP = new HOLIDAY_SKIP("HOLIDAY_SKIP", 1);
        public static final Mode EVENT = new EVENT("EVENT", 2);
        public static final Mode EVENT_RESCHEDULE_ALARM = new EVENT_RESCHEDULE_ALARM("EVENT_RESCHEDULE_ALARM", 3);

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier.Mode.EVENT", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier$Mode;", "getContentTitle", "", "resources", "Landroid/content/res/Resources;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class EVENT extends Mode {
            public EVENT(String str, int i) {
                super(str, i, "com.urbandroid.sleep.ACTION_REVERT_CALENDAR_OFFSET", R.drawable.ic_alarm_white, R.string.alarm_offset, 0, null, 24, null);
            }

            @Override // com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifier.Mode
            public String getContentTitle(Resources resources, GoogleCalendar.Event event) {
                resources.getClass();
                event.getClass();
                return getNotifyTitle(event);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier.Mode.EVENT_RESCHEDULE_ALARM", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier$Mode;", "getContentTitle", "", "resources", "Landroid/content/res/Resources;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class EVENT_RESCHEDULE_ALARM extends Mode {
            public EVENT_RESCHEDULE_ALARM(String str, int i) {
                super(str, i, "com.urbandroid.sleep.ACTION_RESCHEDULE_ALARM", R.drawable.ic_alarm_white, R.string.alarm_offset, R.string.calendar_event_preference_title, SetAlarm.class, null);
            }

            @Override // com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifier.Mode
            public String getContentTitle(Resources resources, GoogleCalendar.Event event) {
                resources.getClass();
                event.getClass();
                return getNotifyTitle(event);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier.Mode.HOLIDAY_NOTIFY", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier$Mode;", "getContentTitle", "", "resources", "Landroid/content/res/Resources;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class HOLIDAY_NOTIFY extends Mode {
            public HOLIDAY_NOTIFY(String str, int i) {
                super(str, i, "com.urbandroid.sleep.ACTION_CALENDAR_SKIP_NEXT", R.drawable.ic_alarm_x_white, 0, R.string.disable_alarm_for_today, SkipNextActivity.class, null);
            }

            @Override // com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifier.Mode
            public String getContentTitle(Resources resources, GoogleCalendar.Event event) {
                resources.getClass();
                event.getClass();
                return event.getTitle();
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier.Mode.HOLIDAY_SKIP", "Lcom/urbandroid/sleep/service/google/calendar/alarm/GoogleCalendarNotifier$Mode;", "getContentTitle", "", "resources", "Landroid/content/res/Resources;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class HOLIDAY_SKIP extends Mode {
            public HOLIDAY_SKIP(String str, int i) {
                super(str, i, "com.urbandroid.sleep.ACTION_REVERT_CALENDAR_SKIP_NEXT", R.drawable.ic_alarm_x_white, R.string.alarm_skip, 0, null, 24, null);
            }

            @Override // com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifier.Mode
            public String getContentTitle(Resources resources, GoogleCalendar.Event event) {
                resources.getClass();
                event.getClass();
                return event.getTitle();
            }
        }

        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                try {
                    iArr[Mode.HOLIDAY_SKIP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Mode.EVENT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Mode.HOLIDAY_NOTIFY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Mode.EVENT_RESCHEDULE_ALARM.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{HOLIDAY_NOTIFY, HOLIDAY_SKIP, EVENT, EVENT_RESCHEDULE_ALARM};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
            INSTANCE = new Companion(null);
            formatTime = new SimpleDateFormat("HH:mm");
        }

        public /* synthetic */ Mode(String str, int i, String str2, int i2, int i3, int i4, Class cls, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, i2, i3, (i5 & 8) != 0 ? R.string.revert : i4, (i5 & 16) != 0 ? RevertActivity.class : cls);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final Class<?> getActionActivity() {
            return this.actionActivity;
        }

        public final int getActionText() {
            return this.actionText;
        }

        public final String getContentText(Context context, Alarm alarm, Calendar currentTime) {
            context.getClass();
            alarm.getClass();
            currentTime.getClass();
            Object objClone = currentTime.clone();
            objClone.getClass();
            Calendar calendar = (Calendar) objClone;
            calendar.setTimeInMillis(Alarms.calculateAlarm(context, alarm, currentTime.getTimeInMillis()));
            String timeDay = DateUtil.formatTimeDay(context, calendar.getTimeInMillis());
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1 || i == 2) {
                String string = context.getString(this.contentText, timeDay);
                string.getClass();
                return string;
            }
            if (i == 3) {
                return FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.default_label), " ", timeDay);
            }
            if (i != 4) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            String string2 = context.getString(R.string.action_required);
            string2.getClass();
            String upperCase = string2.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            String string3 = context.getString(R.string.default_label);
            return Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(upperCase, ": ", string3, " - ", timeDay), ". ", context.getString(this.actionText), "?");
        }

        public abstract String getContentTitle(Resources resources, GoogleCalendar.Event event);

        public final int getIcon() {
            return this.icon;
        }

        public final String getNotifyTitle(GoogleCalendar.Event event) {
            event.getClass();
            SimpleDateFormat simpleDateFormat = formatTime;
            String str = simpleDateFormat.format(new Date(event.getStart()));
            String str2 = simpleDateFormat.format(new Date(event.getEnd()));
            String title = event.getTitle();
            if (title == null) {
                title = "";
            }
            return Fragment$$ExternalSyntheticOutline1.m(str, "-", str2, " ", title);
        }

        private Mode(String str, int i, String str2, int i2, int i3, int i4, Class cls) {
            this.action = str2;
            this.icon = i2;
            this.contentText = i3;
            this.actionText = i4;
            this.actionActivity = cls;
        }

        public /* synthetic */ Mode(String str, int i, String str2, int i2, int i3, int i4, Class cls, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, i2, i3, i4, cls);
        }
    }
}

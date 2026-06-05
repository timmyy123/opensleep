package com.urbandroid.sleep.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.MenuItem;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmPopupHandler {
    private final Context context;
    private final Refresher refresher;

    public interface AlarmRetriever {
        Alarm getAlarm();
    }

    public interface Refresher {
        void refresh();
    }

    public AlarmPopupHandler(Context context, Refresher refresher) {
        this.context = context;
        this.refresher = refresher;
    }

    public void deleteAllDisabledAlarms() {
        if (this.context != null) {
            new MaterialAlertDialogBuilder(this.context).setTitle((CharSequence) this.context.getString(R.string.delete_all_disabled)).setMessage((CharSequence) this.context.getString(R.string.realy_delete_confirm_generic)).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.AlarmPopupHandler.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Logger.logInfo("Deleting all disabled alarms ");
                    Cursor alarmsCursor = Alarms.getAlarmsCursor(AlarmPopupHandler.this.context);
                    while (alarmsCursor.moveToNext()) {
                        Alarm alarm = new Alarm(alarmsCursor);
                        if (!alarm.enabled) {
                            Alarms.deleteAlarmOrShowCaptcha(AlarmPopupHandler.this.context, alarm);
                        }
                    }
                    AlarmPopupHandler.this.refresher.refresh();
                }
            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    public boolean handle(MenuItem menuItem, AlarmRetriever alarmRetriever, int i) {
        switch (menuItem.getItemId()) {
            case R.id.copy_alarm /* 2131362128 */:
                Alarm alarm = alarmRetriever.getAlarm();
                alarm.id = -1;
                alarm.enabled = false;
                Alarms.addAlarm(this.context, alarm);
                return true;
            case R.id.delete_alarm /* 2131362156 */:
                final Alarm alarm2 = alarmRetriever.getAlarm();
                Logger.logInfo("Deleting alarm " + alarm2);
                new MaterialAlertDialogBuilder(this.context).setTitle((CharSequence) this.context.getString(R.string.delete_alarm)).setMessage((CharSequence) this.context.getString(R.string.delete_alarm_confirm)).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.AlarmPopupHandler.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Alarms.deleteAlarmOrShowCaptcha(AlarmPopupHandler.this.context, alarm2);
                        AlarmPopupHandler.this.refresher.refresh();
                    }
                }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                return true;
            case R.id.delete_all_disabled /* 2131362158 */:
                deleteAllDisabledAlarms();
                return true;
            case R.id.disable_alarm_for_today /* 2131362178 */:
                Logger.logInfo("Disable for today");
                break;
            case R.id.edit_alarm /* 2131362217 */:
                SetAlarm.showSetAlarmActivity(this.context, i, false);
                return true;
            case R.id.enable_alarm /* 2131362225 */:
                Alarm alarm3 = alarmRetriever.getAlarm();
                boolean z = alarm3.enabled;
                Context context = this.context;
                if (z) {
                    Alarms.disableAlarmOrShowCaptcha(context, alarm3);
                    return true;
                }
                Alarms.enableAlarm(context, alarm3.id, true);
                SetAlarm.popAlarmSetToast(this.context, alarm3, Alarm.isPowerNap(alarm3));
                return true;
            case R.id.enable_alarm_for_today /* 2131362226 */:
                break;
            default:
                return false;
        }
        Logger.logInfo("Enable for today");
        Alarm alarm4 = alarmRetriever.getAlarm();
        Alarms.setSkipNext(this.context, alarm4, menuItem.getItemId() == R.id.disable_alarm_for_today);
        new Alarm.DaysOfWeek(alarm4.getDaysOfWeek().getCoded(), alarm4.getWeekRepeat()).set((Calendar.getInstance().get(7) + 5) % 7, false);
        this.refresher.refresh();
        return true;
    }
}

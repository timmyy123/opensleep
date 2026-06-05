package com.urbandroid.sleep.alarmclock.timepicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartlight.DiscoveryActivity$$ExternalSyntheticLambda5;
import com.urbandroid.util.Experiments;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J'\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/timepicker/RoundTimePicker;", "Landroidx/fragment/app/DialogFragment;", "Lcom/urbandroid/sleep/alarmclock/timepicker/TimePicker;", "<init>", "()V", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/alarmclock/timepicker/TimePickerActivity;", "timePickerActivity", "Landroid/app/Dialog;", "createTimePickerDialog", "(Landroid/app/Activity;Lcom/urbandroid/sleep/alarmclock/timepicker/TimePickerActivity;)Landroid/app/Dialog;", "", "hour24", "convert24to12", "(I)I", "hour12", "", "pm", "convert12to24", "(IZ)I", "Landroid/os/Bundle;", "savedInstanceState", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "", "onResume", "hour", "minute", "is24", "setState", "(IIZ)V", "getHour", "()I", "getMinute", "isShown", "()Z", "Landroidx/fragment/app/FragmentActivity;", "activity", "show", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/urbandroid/sleep/alarmclock/timepicker/ITimePickerWrapper;", "timePickerMember", "Lcom/urbandroid/sleep/alarmclock/timepicker/ITimePickerWrapper;", "getTimePickerMember", "()Lcom/urbandroid/sleep/alarmclock/timepicker/ITimePickerWrapper;", "setTimePickerMember", "(Lcom/urbandroid/sleep/alarmclock/timepicker/ITimePickerWrapper;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RoundTimePicker extends DialogFragment implements TimePicker {
    private ITimePickerWrapper timePickerMember;

    /* JADX INFO: Access modifiers changed from: private */
    public final int convert12to24(int hour12, boolean pm) {
        if (pm) {
            if (hour12 == 12) {
                return 12;
            }
            return hour12 + 12;
        }
        if (hour12 == 12) {
            return 0;
        }
        return hour12;
    }

    private final int convert24to12(int hour24) {
        if (hour24 == 0) {
            return 12;
        }
        return hour24 > 12 ? hour24 - 12 : hour24;
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$createTimePickerDialog$watcher$1] */
    private final Dialog createTimePickerDialog(Activity context, final TimePickerActivity timePickerActivity) {
        Logger.logInfo("createTimePicker");
        context.isInMultiWindowMode();
        View viewInflate = InflatorUtil.INSTANCE.get(context).inflate(timePickerActivity.isAlarmMode() ? R.layout.time_picker_ics : R.layout.time_picker_ics_nap, (ViewGroup) null);
        viewInflate.getClass();
        Button button = (Button) viewInflate.findViewById(R.id.button_set);
        Button button2 = (Button) viewInflate.findViewById(R.id.button_cancel);
        Button button3 = (Button) viewInflate.findViewById(R.id.button_nap);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        materialAlertDialogBuilder.setView(viewInflate);
        materialAlertDialogBuilder.setCancelable(true);
        final IcsTimePickerWrapper icsTimePickerWrapper = new IcsTimePickerWrapper(context, (android.widget.TimePicker) viewInflate.findViewById(R.id.timepicker));
        this.timePickerMember = icsTimePickerWrapper;
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.getClass();
        final int i = 0;
        ((ImageButton) viewInflate.findViewById(R.id.fullscreen)).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                TimePickerActivity timePickerActivity2 = timePickerActivity;
                switch (i2) {
                    case 0:
                        timePickerActivity2.startSpeechRecognition();
                        break;
                    default:
                        timePickerActivity2.scheduleSunrise();
                        break;
                }
            }
        });
        final NumberPicker numberPicker = (NumberPicker) viewInflate.findViewById(R.id.nap_wheel);
        if (numberPicker != null) {
            numberPicker.setDisplayedValues(getResources().getStringArray(R.array.nap_entries));
            String[] stringArray = getResources().getStringArray(R.array.nap_values);
            stringArray.getClass();
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(stringArray.length - 1);
            int latestNapMinutes = SharedApplicationContext.getSettings().getLatestNapMinutes();
            int length = stringArray.length;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = stringArray[i];
                String[] strArr = stringArray;
                StringBuilder sb = new StringBuilder();
                sb.append(latestNapMinutes);
                if (Intrinsics.areEqual(str, sb.toString())) {
                    numberPicker.setValue(i2);
                    break;
                }
                i2++;
                i++;
                stringArray = strArr;
            }
        }
        final boolean z = Alarms.get24HourMode(context);
        final int i3 = 1;
        ((ImageButton) viewInflate.findViewById(R.id.sunrise)).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i3;
                TimePickerActivity timePickerActivity2 = timePickerActivity;
                switch (i22) {
                    case 0:
                        timePickerActivity2.startSpeechRecognition();
                        break;
                    default:
                        timePickerActivity2.scheduleSunrise();
                        break;
                }
            }
        });
        viewInflate.findViewById(R.id.scheduleIdealAlarm).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoundTimePicker.createTimePickerDialog$lambda$2(timePickerActivity, icsTimePickerWrapper, z, view);
            }
        });
        Calendar calendar = Calendar.getInstance();
        int i4 = calendar.get(13);
        if (Experiments.getInstance().isOurExperimentalPhone() && timePickerActivity.getHour() == -1) {
            calendar.add(12, i4 >= 55 ? 2 : 1);
            timePickerActivity.updateTime(-1, -1);
        }
        icsTimePickerWrapper.setState(timePickerActivity.getHour() == -1 ? calendar.get(11) : timePickerActivity.getHour(), timePickerActivity.getMinute() == -1 ? calendar.get(12) : timePickerActivity.getMinute(), z);
        final ?? r8 = new TextWatcher() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$createTimePickerDialog$watcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                editable.getClass();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i5, int i1, int i22) {
                charSequence.getClass();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i5, int i1, int i22) {
                int iConvert12to24;
                charSequence.getClass();
                boolean z2 = Alarms.get24HourMode(this.this$0.getActivity());
                Matcher matcher = (z2 ? Pattern.compile("([0-1][0-9]|2[0-3]|[0-9])([0-5]?[0-9])") : Pattern.compile("(1[0-2]|0?[1-9])([0-5]?[0-9])")).matcher(charSequence);
                if (matcher.matches()) {
                    if (matcher.group(1) == null || matcher.group(2) == null) {
                        return;
                    }
                    try {
                        String strGroup = matcher.group(1);
                        strGroup.getClass();
                        int i6 = Integer.parseInt(strGroup);
                        String strGroup2 = matcher.group(2);
                        strGroup2.getClass();
                        int i7 = Integer.parseInt(strGroup2);
                        Logger.logInfo(i6 + " " + i7);
                        int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(i7, 59), 0);
                        if (Alarms.get24HourMode(this.this$0.getActivity())) {
                            iConvert12to24 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i6, 23), 0);
                        } else {
                            Logger.logInfo(i6 + " " + i7);
                            iConvert12to24 = this.this$0.convert12to24(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i6, 12), 1), icsTimePickerWrapper.getHour() > 11);
                        }
                        icsTimePickerWrapper.setState(iConvert12to24, iCoerceAtLeast, z2);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        };
        final EditText editText = (EditText) viewInflate.findViewById(R.id.time_edit);
        int i5 = 10;
        if (editText != null) {
            editText.setInputType(2);
            Object systemService = context.getSystemService("input_method");
            systemService.getClass();
            ((InputMethodManager) systemService).showSoftInput(editText, 1);
            int hour = Alarms.get24HourMode(context) ? icsTimePickerWrapper.getHour() : convert24to12(icsTimePickerWrapper.getHour());
            String str2 = icsTimePickerWrapper.getMinute() < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "";
            editText.setHint(hour + str2 + icsTimePickerWrapper.getMinute());
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$$ExternalSyntheticLambda3
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    RoundTimePicker.createTimePickerDialog$lambda$3(editText, r8, view, z2);
                }
            });
            editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$$ExternalSyntheticLambda4
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
                    return RoundTimePicker.createTimePickerDialog$lambda$4(timePickerActivity, icsTimePickerWrapper, this, view, i6, keyEvent);
                }
            });
        }
        button2.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 8));
        button3.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(timePickerActivity, this, i5));
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                RoundTimePicker.createTimePickerDialog$lambda$7(icsTimePickerWrapper, timePickerActivity, this, numberPicker, dialogInterface);
            }
        });
        button.setOnClickListener(new DiscoveryActivity$$ExternalSyntheticLambda5(icsTimePickerWrapper, timePickerActivity, this, numberPicker, 2));
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTimePickerDialog$lambda$2(TimePickerActivity timePickerActivity, IcsTimePickerWrapper icsTimePickerWrapper, boolean z, View view) {
        int perAlarmIdealSleepMinutes = SharedApplicationContext.getSettings().getPerAlarmIdealSleepMinutes(timePickerActivity.mapToAlarm());
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, perAlarmIdealSleepMinutes);
        icsTimePickerWrapper.setState(calendar.get(11), calendar.get(12), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTimePickerDialog$lambda$3(EditText editText, RoundTimePicker$createTimePickerDialog$watcher$1 roundTimePicker$createTimePickerDialog$watcher$1, View view, boolean z) {
        if (z) {
            editText.addTextChangedListener(roundTimePicker$createTimePickerDialog$watcher$1);
        } else {
            editText.removeTextChangedListener(roundTimePicker$createTimePickerDialog$watcher$1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createTimePickerDialog$lambda$4(TimePickerActivity timePickerActivity, IcsTimePickerWrapper icsTimePickerWrapper, RoundTimePicker roundTimePicker, View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        timePickerActivity.updateTime(icsTimePickerWrapper.getHour(), icsTimePickerWrapper.getMinute());
        roundTimePicker.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTimePickerDialog$lambda$6(TimePickerActivity timePickerActivity, RoundTimePicker roundTimePicker, View view) {
        timePickerActivity.switchMode();
        roundTimePicker.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTimePickerDialog$lambda$7(IcsTimePickerWrapper icsTimePickerWrapper, TimePickerActivity timePickerActivity, RoundTimePicker roundTimePicker, NumberPicker numberPicker, DialogInterface dialogInterface) {
        icsTimePickerWrapper.confirm();
        if (timePickerActivity.isAlarmMode()) {
            timePickerActivity.updateTime(icsTimePickerWrapper.getHour(), icsTimePickerWrapper.getMinute());
        } else {
            String str = roundTimePicker.getResources().getStringArray(R.array.nap_values)[numberPicker.getValue()];
            str.getClass();
            int i = Integer.parseInt(str);
            Calendar calendar = Calendar.getInstance();
            calendar.add(12, i);
            timePickerActivity.updateTime(calendar.get(11), calendar.get(12));
            SharedApplicationContext.getSettings().setLastNapMinutes(i);
        }
        roundTimePicker.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTimePickerDialog$lambda$8(IcsTimePickerWrapper icsTimePickerWrapper, TimePickerActivity timePickerActivity, RoundTimePicker roundTimePicker, NumberPicker numberPicker, View view) {
        icsTimePickerWrapper.confirm();
        if (timePickerActivity.isAlarmMode()) {
            timePickerActivity.updateTime(icsTimePickerWrapper.getHour(), icsTimePickerWrapper.getMinute());
        } else {
            String str = roundTimePicker.getResources().getStringArray(R.array.nap_values)[numberPicker.getValue()];
            str.getClass();
            int i = Integer.parseInt(str);
            Calendar calendar = Calendar.getInstance();
            calendar.add(12, i);
            timePickerActivity.updateTime(calendar.get(11), calendar.get(12));
            SharedApplicationContext.getSettings().setLastNapMinutes(i);
        }
        roundTimePicker.dismiss();
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public int getHour() {
        ITimePickerWrapper iTimePickerWrapper = this.timePickerMember;
        if (iTimePickerWrapper != null) {
            return iTimePickerWrapper.getHour();
        }
        return -1;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public int getMinute() {
        ITimePickerWrapper iTimePickerWrapper = this.timePickerMember;
        if (iTimePickerWrapper != null) {
            return iTimePickerWrapper.getMinute();
        }
        return -1;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public boolean isShown() {
        return isAdded();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        return createTimePickerDialog(activity, (TimePickerActivity) activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public void setState(int hour, int minute, boolean is24) {
        ITimePickerWrapper iTimePickerWrapper = this.timePickerMember;
        if (iTimePickerWrapper != null) {
            iTimePickerWrapper.setState(hour, minute, is24);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public void show(FragmentActivity activity) {
        activity.getClass();
        show(activity.getSupportFragmentManager(), "timepicker");
    }
}

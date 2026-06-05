package com.urbandroid.sleep.gui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.prefs.NonDialogPreference;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\nJ\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010:R\u0014\u0010;\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010<\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b<\u00107R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0017\u0010A\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/urbandroid/sleep/gui/NextAlarmPreference;", "Lcom/urbandroid/sleep/prefs/NonDialogPreference;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "openTimepicker", "()V", "", "pickerHour", "pickerMinute", "setOffsetFromPicker", "(II)V", "updateButtonsVisibility", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "onCreateView", "(Landroid/view/ViewGroup;)Landroid/view/View;", "offsetChangedRecently", "setOffsetText", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "alarm", "setOffset", "(Lcom/urbandroid/sleep/alarmclock/Alarm;)V", "resetOffset", "getOffset", "()I", "", "visible", "setAdjustTimeVisible", "(Z)V", "Landroid/content/Context;", "Lcom/google/android/material/button/MaterialButton;", "btnMinus", "Lcom/google/android/material/button/MaterialButton;", "btnPlus", "btnReset", "timeTextView", "timeTextViewOriginalColor", "Ljava/lang/Integer;", "timeAdjust", "Landroid/view/ViewGroup;", "timeAdjustVisibility", "Z", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", SDKConstants.PARAM_VALUE, "offsetMinutes", "I", "setOffsetMinutes", "(I)V", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "MIN_OFFSET_MINUTES", "MAX_OFFSET_MINUTES", "", "lastPlusMinusTime", "J", "Ljava/lang/Runnable;", "updateOffsetTextRunnable", "Ljava/lang/Runnable;", "getUpdateOffsetTextRunnable", "()Ljava/lang/Runnable;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NextAlarmPreference extends NonDialogPreference {
    private final int MAX_OFFSET_MINUTES;
    private final int MIN_OFFSET_MINUTES;
    private Alarm alarm;
    private MaterialButton btnMinus;
    private MaterialButton btnPlus;
    private MaterialButton btnReset;
    private final Context ctx;
    private final Handler h;
    private long lastPlusMinusTime;
    private int offsetMinutes;
    private ViewGroup timeAdjust;
    private boolean timeAdjustVisibility;
    private MaterialButton timeTextView;
    private Integer timeTextViewOriginalColor;
    private final Runnable updateOffsetTextRunnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NextAlarmPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        this.ctx = context;
        this.h = new Handler();
        this.MIN_OFFSET_MINUTES = -180;
        this.MAX_OFFSET_MINUTES = 180;
        this.lastPlusMinusTime = -1L;
        setPersistent(false);
        setLayoutResource(R.layout.preference_next_alarm);
        this.updateOffsetTextRunnable = new Endpoint$$ExternalSyntheticLambda0(this, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(NextAlarmPreference nextAlarmPreference, View view) {
        MaterialButton materialButton = nextAlarmPreference.timeTextView;
        if (materialButton != null) {
            materialButton.setChecked(false);
        }
        nextAlarmPreference.openTimepicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(NextAlarmPreference nextAlarmPreference, View view) {
        MaterialButton materialButton = nextAlarmPreference.btnMinus;
        if (materialButton != null) {
            materialButton.setChecked(false);
        }
        int i = nextAlarmPreference.offsetMinutes;
        if (i > -180) {
            nextAlarmPreference.setOffsetMinutes(i - 5);
        }
        nextAlarmPreference.callChangeListener(Integer.valueOf(nextAlarmPreference.offsetMinutes));
        nextAlarmPreference.offsetChangedRecently();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(NextAlarmPreference nextAlarmPreference, View view) {
        MaterialButton materialButton = nextAlarmPreference.btnPlus;
        if (materialButton != null) {
            materialButton.setChecked(false);
        }
        int i = nextAlarmPreference.offsetMinutes;
        if (i < 180) {
            nextAlarmPreference.setOffsetMinutes(i + 5);
        }
        nextAlarmPreference.callChangeListener(Integer.valueOf(nextAlarmPreference.offsetMinutes));
        nextAlarmPreference.offsetChangedRecently();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$4(NextAlarmPreference nextAlarmPreference, View view) {
        MaterialButton materialButton = nextAlarmPreference.btnMinus;
        if (materialButton != null) {
            materialButton.setChecked(false);
        }
        int i = nextAlarmPreference.offsetMinutes;
        if (i > -180) {
            nextAlarmPreference.setOffsetMinutes(i - 30);
        }
        nextAlarmPreference.offsetChangedRecently();
        return nextAlarmPreference.callChangeListener(Integer.valueOf(nextAlarmPreference.offsetMinutes));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$5(NextAlarmPreference nextAlarmPreference, View view) {
        MaterialButton materialButton = nextAlarmPreference.btnPlus;
        if (materialButton != null) {
            materialButton.setChecked(false);
        }
        int i = nextAlarmPreference.offsetMinutes;
        if (i < 180) {
            nextAlarmPreference.setOffsetMinutes(i + 30);
        }
        nextAlarmPreference.offsetChangedRecently();
        return nextAlarmPreference.callChangeListener(Integer.valueOf(nextAlarmPreference.offsetMinutes));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(NextAlarmPreference nextAlarmPreference, View view) {
        nextAlarmPreference.setOffsetMinutes(0);
        nextAlarmPreference.callChangeListener(Integer.valueOf(nextAlarmPreference.offsetMinutes));
    }

    private final void openTimepicker() {
        if (this.alarm != null) {
            boolean z = Alarms.get24HourMode(this.ctx);
            MaterialTimePicker.Builder builder = new MaterialTimePicker.Builder();
            Alarm alarm = this.alarm;
            alarm.getClass();
            builder.setHour(alarm.getOffsetHour(this.ctx));
            Alarm alarm2 = this.alarm;
            alarm2.getClass();
            builder.setMinute(alarm2.getOffsetMinutes(this.ctx));
            builder.setInputMode(!SharedApplicationContext.getSettings().isNewTimepicker() ? 1 : 0);
            builder.setTitleText(R.string.alarm_offset_title);
            builder.setTimeFormat(z ? 1 : 0);
            MaterialTimePicker materialTimePickerBuild = builder.build();
            materialTimePickerBuild.getClass();
            Context context = this.ctx;
            context.getClass();
            materialTimePickerBuild.show(((FragmentActivity) context).getSupportFragmentManager(), "offsetTimepicker");
            materialTimePickerBuild.addOnPositiveButtonClickListener(new AiActivity$$ExternalSyntheticLambda6(this, materialTimePickerBuild, 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openTimepicker$lambda$1(NextAlarmPreference nextAlarmPreference, MaterialTimePicker materialTimePicker, View view) {
        nextAlarmPreference.offsetChangedRecently();
        nextAlarmPreference.setOffsetFromPicker(materialTimePicker.getHour(), materialTimePicker.getMinute());
    }

    private final void setOffsetFromPicker(int pickerHour, int pickerMinute) {
        Integer numValueOf;
        Alarm alarm = this.alarm;
        if (alarm != null) {
            numValueOf = Integer.valueOf(alarm.minutes + (alarm != null ? alarm.hour * 60 : 0));
        } else {
            numValueOf = null;
        }
        int i = (pickerHour * 60) + pickerMinute;
        if (numValueOf != null) {
            int iIntValue = i - numValueOf.intValue();
            int i2 = this.MIN_OFFSET_MINUTES;
            if (iIntValue < i2 || iIntValue > (i2 = this.MAX_OFFSET_MINUTES)) {
                iIntValue = i2;
            }
            if (iIntValue != this.offsetMinutes) {
                setOffsetMinutes(iIntValue);
                callChangeListener(Integer.valueOf(this.offsetMinutes));
            }
            updateButtonsVisibility();
        }
        Logger.logDebug("offsetMinutes set from picker " + this.offsetMinutes, null);
    }

    private final void setOffsetMinutes(int i) {
        this.offsetMinutes = i;
        updateButtonsVisibility();
    }

    private final void updateButtonsVisibility() {
        int i = this.offsetMinutes;
        if (i <= this.MIN_OFFSET_MINUTES) {
            MaterialButton materialButton = this.btnMinus;
            if (materialButton != null) {
                materialButton.setVisibility(4);
            }
        } else {
            int i2 = this.MAX_OFFSET_MINUTES;
            MaterialButton materialButton2 = this.btnPlus;
            if (i < i2) {
                if (materialButton2 != null) {
                    materialButton2.setVisibility(0);
                }
                MaterialButton materialButton3 = this.btnMinus;
                if (materialButton3 != null) {
                    materialButton3.setVisibility(0);
                }
            } else if (materialButton2 != null) {
                materialButton2.setVisibility(4);
            }
        }
        if (this.offsetMinutes != 0) {
            MaterialButton materialButton4 = this.timeTextView;
            if (materialButton4 != null) {
                materialButton4.setTextColor(this.ctx.getColor(R.color.tint));
            }
            MaterialButton materialButton5 = this.btnReset;
            if (materialButton5 != null) {
                materialButton5.setVisibility(0);
                return;
            }
            return;
        }
        Integer num = this.timeTextViewOriginalColor;
        if (num != null) {
            int iIntValue = num.intValue();
            MaterialButton materialButton6 = this.timeTextView;
            if (materialButton6 != null) {
                materialButton6.setTextColor(iIntValue);
            }
        }
        MaterialButton materialButton7 = this.btnReset;
        if (materialButton7 != null) {
            materialButton7.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: getOffset, reason: from getter */
    public final int getOffsetMinutes() {
        return this.offsetMinutes;
    }

    public final void offsetChangedRecently() {
        this.lastPlusMinusTime = System.currentTimeMillis();
        this.h.removeCallbacks(this.updateOffsetTextRunnable);
        this.h.postDelayed(this.updateOffsetTextRunnable, 3500L);
    }

    @Override // com.urbandroid.sleep.prefs.NonDialogPreference, android.preference.Preference
    public View onCreateView(ViewGroup parent) {
        Logger.logDebug("AlarmOffsetPreference onCreateView", null);
        setView(super.onCreateView(parent));
        View view = getView();
        this.btnMinus = view != null ? (MaterialButton) view.findViewById(R.id.btnMinus) : null;
        View view2 = getView();
        this.btnPlus = view2 != null ? (MaterialButton) view2.findViewById(R.id.btnPlus) : null;
        View view3 = getView();
        MaterialButton materialButton = view3 != null ? (MaterialButton) view3.findViewById(R.id.btnReset) : null;
        this.btnReset = materialButton;
        if (materialButton != null) {
            materialButton.setVisibility(8);
        }
        View view4 = getView();
        this.timeTextView = view4 != null ? (MaterialButton) view4.findViewById(R.id.time) : null;
        View view5 = getView();
        ViewGroup viewGroup = view5 != null ? (ViewGroup) view5.findViewById(R.id.time_adjust) : null;
        this.timeAdjust = viewGroup;
        final int i = 0;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.timeAdjustVisibility ? 0 : 8);
        }
        ViewGroup viewGroup2 = this.timeAdjust;
        if (viewGroup2 != null) {
            viewGroup2.setOnTouchListener(new NextAlarmPreference$$ExternalSyntheticLambda1(i));
        }
        MaterialButton materialButton2 = this.timeTextView;
        if (materialButton2 != null) {
            Alarm alarm = this.alarm;
            materialButton2.setText(alarm != null ? alarm.getTimeWithOffsetAsString(this.ctx) : null);
        }
        setOffsetText();
        MaterialButton materialButton3 = this.timeTextView;
        this.timeTextViewOriginalColor = materialButton3 != null ? Integer.valueOf(materialButton3.getCurrentTextColor()) : null;
        MaterialButton materialButton4 = this.timeTextView;
        if (materialButton4 != null) {
            materialButton4.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda2
                public final /* synthetic */ NextAlarmPreference f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    int i2 = i;
                    NextAlarmPreference nextAlarmPreference = this.f$0;
                    switch (i2) {
                        case 0:
                            NextAlarmPreference.onCreateView$lambda$1(nextAlarmPreference, view6);
                            break;
                        case 1:
                            NextAlarmPreference.onCreateView$lambda$2(nextAlarmPreference, view6);
                            break;
                        case 2:
                            NextAlarmPreference.onCreateView$lambda$3(nextAlarmPreference, view6);
                            break;
                        default:
                            NextAlarmPreference.onCreateView$lambda$6(nextAlarmPreference, view6);
                            break;
                    }
                }
            });
        }
        MaterialButton materialButton5 = this.btnMinus;
        final int i2 = 1;
        if (materialButton5 != null) {
            materialButton5.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda2
                public final /* synthetic */ NextAlarmPreference f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    int i22 = i2;
                    NextAlarmPreference nextAlarmPreference = this.f$0;
                    switch (i22) {
                        case 0:
                            NextAlarmPreference.onCreateView$lambda$1(nextAlarmPreference, view6);
                            break;
                        case 1:
                            NextAlarmPreference.onCreateView$lambda$2(nextAlarmPreference, view6);
                            break;
                        case 2:
                            NextAlarmPreference.onCreateView$lambda$3(nextAlarmPreference, view6);
                            break;
                        default:
                            NextAlarmPreference.onCreateView$lambda$6(nextAlarmPreference, view6);
                            break;
                    }
                }
            });
        }
        MaterialButton materialButton6 = this.btnPlus;
        if (materialButton6 != null) {
            final int i3 = 2;
            materialButton6.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda2
                public final /* synthetic */ NextAlarmPreference f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    int i22 = i3;
                    NextAlarmPreference nextAlarmPreference = this.f$0;
                    switch (i22) {
                        case 0:
                            NextAlarmPreference.onCreateView$lambda$1(nextAlarmPreference, view6);
                            break;
                        case 1:
                            NextAlarmPreference.onCreateView$lambda$2(nextAlarmPreference, view6);
                            break;
                        case 2:
                            NextAlarmPreference.onCreateView$lambda$3(nextAlarmPreference, view6);
                            break;
                        default:
                            NextAlarmPreference.onCreateView$lambda$6(nextAlarmPreference, view6);
                            break;
                    }
                }
            });
        }
        MaterialButton materialButton7 = this.btnMinus;
        if (materialButton7 != null) {
            materialButton7.setOnLongClickListener(new NextAlarmPreference$$ExternalSyntheticLambda5(this, i));
        }
        MaterialButton materialButton8 = this.btnPlus;
        if (materialButton8 != null) {
            materialButton8.setOnLongClickListener(new NextAlarmPreference$$ExternalSyntheticLambda5(this, i2));
        }
        MaterialButton materialButton9 = this.btnReset;
        if (materialButton9 != null) {
            final int i4 = 3;
            materialButton9.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda2
                public final /* synthetic */ NextAlarmPreference f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    int i22 = i4;
                    NextAlarmPreference nextAlarmPreference = this.f$0;
                    switch (i22) {
                        case 0:
                            NextAlarmPreference.onCreateView$lambda$1(nextAlarmPreference, view6);
                            break;
                        case 1:
                            NextAlarmPreference.onCreateView$lambda$2(nextAlarmPreference, view6);
                            break;
                        case 2:
                            NextAlarmPreference.onCreateView$lambda$3(nextAlarmPreference, view6);
                            break;
                        default:
                            NextAlarmPreference.onCreateView$lambda$6(nextAlarmPreference, view6);
                            break;
                    }
                }
            });
        }
        updateButtonsVisibility();
        View view6 = getView();
        view6.getClass();
        return view6;
    }

    public final void resetOffset(Alarm alarm) {
        alarm.getClass();
        this.alarm = alarm;
        setOffsetMinutes(0);
        MaterialButton materialButton = this.timeTextView;
        if (materialButton != null) {
            materialButton.setText(alarm.getTimeWithoutOffsetAsString());
        }
    }

    public final void setAdjustTimeVisible(boolean visible) {
        this.timeAdjustVisibility = visible;
        ViewGroup viewGroup = this.timeAdjust;
        if (viewGroup != null) {
            viewGroup.setVisibility(visible ? 0 : 8);
        }
    }

    public final void setOffset(Alarm alarm) {
        alarm.getClass();
        this.alarm = alarm;
        setOffsetMinutes(alarm.getOffset());
        setOffsetText();
    }

    public final void setOffsetText() {
        MaterialButton materialButton = this.timeTextView;
        if (materialButton != null) {
            Alarm alarm = this.alarm;
            materialButton.setText(String.valueOf(alarm != null ? alarm.getTimeWithOffsetAsString(this.ctx) : null));
        }
    }
}

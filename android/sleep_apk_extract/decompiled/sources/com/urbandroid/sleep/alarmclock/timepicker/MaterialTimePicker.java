package com.urbandroid.sleep.alarmclock.timepicker;

import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentActivity;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda1;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.ColorUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Calendar;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001f\u00100\u001a\n /*\u0004\u0018\u00010.0.8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/timepicker/MaterialTimePicker;", "Lcom/urbandroid/sleep/alarmclock/timepicker/TimePicker;", "Landroidx/fragment/app/FragmentActivity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/alarmclock/timepicker/TimePickerActivity;", "timePickerActivity", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/urbandroid/sleep/alarmclock/timepicker/TimePickerActivity;)V", "", "show", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/google/android/material/timepicker/MaterialTimePicker$Builder;", "builder", "(Lcom/google/android/material/timepicker/MaterialTimePicker$Builder;Landroidx/fragment/app/FragmentActivity;)V", "", "isShown", "()Z", "dismiss", "()V", "", "hour", "minute", "is24", "setState", "(IIZ)V", "getHour", "()I", "getMinute", "Landroidx/fragment/app/FragmentActivity;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "Lcom/urbandroid/sleep/alarmclock/timepicker/TimePickerActivity;", "getTimePickerActivity", "()Lcom/urbandroid/sleep/alarmclock/timepicker/TimePickerActivity;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Lcom/google/android/material/timepicker/MaterialTimePicker;", "timePicker", "Lcom/google/android/material/timepicker/MaterialTimePicker;", "getTimePicker", "()Lcom/google/android/material/timepicker/MaterialTimePicker;", "setTimePicker", "(Lcom/google/android/material/timepicker/MaterialTimePicker;)V", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "anim", "Landroid/view/animation/Animation;", "getAnim", "()Landroid/view/animation/Animation;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MaterialTimePicker implements TimePicker {
    private final Animation anim;
    private final FragmentActivity context;
    private final Handler handler;
    private com.google.android.material.timepicker.MaterialTimePicker timePicker;
    private final TimePickerActivity timePickerActivity;

    public MaterialTimePicker(FragmentActivity fragmentActivity, TimePickerActivity timePickerActivity) {
        fragmentActivity.getClass();
        timePickerActivity.getClass();
        this.context = fragmentActivity;
        this.timePickerActivity = timePickerActivity;
        this.handler = new Handler();
        this.anim = AnimationUtils.loadAnimation(fragmentActivity, R.anim.fade_fast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setState$lambda$1(com.google.android.material.timepicker.MaterialTimePicker materialTimePicker) {
        if (materialTimePicker != null) {
            materialTimePicker.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1(MaterialTimePicker materialTimePicker, View view) {
        materialTimePicker.timePickerActivity.switchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(MaterialTimePicker materialTimePicker, View view) {
        materialTimePicker.timePickerActivity.scheduleSunrise();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3(MaterialTimePicker materialTimePicker, boolean z, View view) {
        int perAlarmIdealSleepMinutes = SharedApplicationContext.getSettings().getPerAlarmIdealSleepMinutes(materialTimePicker.timePickerActivity.mapToAlarm());
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, perAlarmIdealSleepMinutes);
        materialTimePicker.setState(calendar.get(11), calendar.get(12), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$4(MaterialTimePicker materialTimePicker, View view) {
        materialTimePicker.timePickerActivity.startSpeechRecognition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5(MaterialTimePicker materialTimePicker, View view, View view2, FragmentActivity fragmentActivity) {
        View view3;
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker2 = materialTimePicker.timePicker;
        if (materialTimePicker2 == null || (view3 = materialTimePicker2.getView()) == null) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view3;
        constraintLayout.addView(view);
        constraintLayout.addView(view2);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(R.id.alarm_mode_switch, 6, 0, 6, 0);
        constraintSet.connect(R.id.alarm_mode_switch, 3, 0, 3, 0);
        constraintSet.connect(R.id.alarm_controls, 7, 0, 7, 0);
        constraintSet.applyTo(constraintLayout);
        try {
            View viewFindViewById = view3.findViewById(R.id.header_title);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            View viewFindViewById2 = view3.findViewById(R.id.material_timepicker_view);
            ViewGroup.LayoutParams layoutParams = viewFindViewById2 != null ? viewFindViewById2.getLayoutParams() : null;
            layoutParams.getClass();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ActivityUtils.getDip(fragmentActivity, 64);
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        Button button = (Button) view3.findViewById(R.id.material_timepicker_ok_button);
        if (button != null) {
            button.setText(R.string.set_time);
        }
        Button button2 = (Button) view3.findViewById(R.id.material_timepicker_ok_button);
        if (button2 != null) {
            button2.setIncludeFontPadding(false);
        }
        Button button3 = (Button) view3.findViewById(R.id.material_timepicker_ok_button);
        if (button3 != null) {
            button3.setMinWidth(ActivityUtils.getDip(fragmentActivity, 120));
        }
        Button button4 = (Button) view3.findViewById(R.id.material_timepicker_ok_button);
        if (button4 != null) {
            button4.setBackgroundColor(ColorUtil.i(fragmentActivity, R.color.tint));
        }
        Button button5 = (Button) view3.findViewById(R.id.material_timepicker_ok_button);
        if (button5 != null) {
            button5.setTextColor(ColorUtil.i(fragmentActivity, R.color.white));
        }
        Button button6 = (Button) view3.findViewById(R.id.material_timepicker_ok_button);
        ViewGroup.LayoutParams layoutParams3 = button6 != null ? button6.getLayoutParams() : null;
        layoutParams3.getClass();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        if (layoutParams4 != null) {
            layoutParams4.setMarginEnd(ActivityUtils.getDip(fragmentActivity, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$6$0(MaterialTimePicker materialTimePicker, com.google.android.material.timepicker.MaterialTimePicker materialTimePicker2, View view) {
        materialTimePicker.timePickerActivity.updateTime(materialTimePicker2.getHour(), materialTimePicker2.getMinute());
        materialTimePicker2.dismiss();
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public void dismiss() {
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = this.timePicker;
        if (materialTimePicker != null) {
            materialTimePicker.dismiss();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public int getHour() {
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = this.timePicker;
        if (materialTimePicker != null) {
            return materialTimePicker.getHour();
        }
        return 0;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public int getMinute() {
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = this.timePicker;
        if (materialTimePicker != null) {
            return materialTimePicker.getMinute();
        }
        return 0;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public boolean isShown() {
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = this.timePicker;
        if (materialTimePicker != null) {
            return materialTimePicker.isAdded();
        }
        return false;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public void setState(int hour, int minute, boolean is24) {
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = this.timePicker;
        boolean z = Alarms.get24HourMode(this.context);
        MaterialTimePicker.Builder builder = new MaterialTimePicker.Builder();
        builder.setHour(hour);
        builder.setMinute(minute);
        builder.setInputMode(0);
        builder.setTitleText(R.string.default_label);
        builder.setTimeFormat(z ? 1 : 0);
        show(builder, this.context);
        this.handler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(materialTimePicker, 29), 100L);
    }

    public final void show(MaterialTimePicker.Builder builder, FragmentActivity context) {
        Dialog dialog;
        builder.getClass();
        context.getClass();
        com.google.android.material.timepicker.MaterialTimePicker materialTimePickerBuild = builder.build();
        this.timePicker = materialTimePickerBuild;
        final int i = 0;
        if (materialTimePickerBuild != null && (dialog = materialTimePickerBuild.getDialog()) != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        final boolean z = Alarms.get24HourMode(context);
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = this.timePicker;
        if (materialTimePicker != null) {
            materialTimePicker.show(context.getSupportFragmentManager(), "timepicker");
        }
        View viewInflate = context.getLayoutInflater().inflate(R.layout.time_picker_addon_controls, (ViewGroup) null);
        viewInflate.getClass();
        View viewInflate2 = context.getLayoutInflater().inflate(R.layout.time_picker_addon_controls_all, (ViewGroup) null);
        viewInflate2.getClass();
        viewInflate2.findViewById(R.id.button_nap).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker$$ExternalSyntheticLambda1
            public final /* synthetic */ MaterialTimePicker f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                MaterialTimePicker materialTimePicker2 = this.f$0;
                switch (i2) {
                    case 0:
                        MaterialTimePicker.show$lambda$1(materialTimePicker2, view);
                        break;
                    case 1:
                        MaterialTimePicker.show$lambda$2(materialTimePicker2, view);
                        break;
                    default:
                        MaterialTimePicker.show$lambda$4(materialTimePicker2, view);
                        break;
                }
            }
        });
        final int i2 = 1;
        viewInflate.findViewById(R.id.scheduleSunrise).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker$$ExternalSyntheticLambda1
            public final /* synthetic */ MaterialTimePicker f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                MaterialTimePicker materialTimePicker2 = this.f$0;
                switch (i22) {
                    case 0:
                        MaterialTimePicker.show$lambda$1(materialTimePicker2, view);
                        break;
                    case 1:
                        MaterialTimePicker.show$lambda$2(materialTimePicker2, view);
                        break;
                    default:
                        MaterialTimePicker.show$lambda$4(materialTimePicker2, view);
                        break;
                }
            }
        });
        viewInflate.findViewById(R.id.scheduleIdeal).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker.show$lambda$3(this.f$0, z, view);
            }
        });
        final int i3 = 2;
        viewInflate.findViewById(R.id.scheduleSpeech).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker$$ExternalSyntheticLambda1
            public final /* synthetic */ MaterialTimePicker f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i3;
                MaterialTimePicker materialTimePicker2 = this.f$0;
                switch (i22) {
                    case 0:
                        MaterialTimePicker.show$lambda$1(materialTimePicker2, view);
                        break;
                    case 1:
                        MaterialTimePicker.show$lambda$2(materialTimePicker2, view);
                        break;
                    default:
                        MaterialTimePicker.show$lambda$4(materialTimePicker2, view);
                        break;
                }
            }
        });
        this.handler.post(new Schedulers$$ExternalSyntheticLambda1(this, viewInflate2, viewInflate, context, 6));
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker2 = this.timePicker;
        if (materialTimePicker2 != null) {
            materialTimePicker2.addOnPositiveButtonClickListener(new AiActivity$$ExternalSyntheticLambda6(this, materialTimePicker2, 9));
            materialTimePicker2.addOnNegativeButtonClickListener(new WebDialog$$ExternalSyntheticLambda1(materialTimePicker2, 7));
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePicker
    public void show(FragmentActivity context) {
        context.getClass();
        boolean z = Alarms.get24HourMode(context);
        MaterialTimePicker.Builder builder = new MaterialTimePicker.Builder();
        builder.setHour(this.timePickerActivity.getHour());
        builder.setMinute(this.timePickerActivity.getMinute());
        builder.setInputMode(0);
        builder.setPositiveButtonText(R.string.set_time);
        builder.setNegativeButtonText(R.string.cancel);
        builder.setTitleText(R.string.default_label);
        builder.setTimeFormat(z ? 1 : 0);
        show(builder, context);
    }
}

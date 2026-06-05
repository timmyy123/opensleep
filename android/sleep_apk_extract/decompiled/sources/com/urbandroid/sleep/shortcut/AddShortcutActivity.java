package com.urbandroid.sleep.shortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.ColorUtil;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.ILullabySelect;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.domain.shortcut.ShortcutSleep;
import com.urbandroid.sleep.gui.MaterialDialogListPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.SeekBarCardPreference;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener;
import com.urbandroid.sleep.media.lullaby.LullabyDialogFragment;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.EdgeToEdgeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0081\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001b\u0010\u0005J\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u0005J'\u0010!\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0014R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u0010\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010<\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010G\u001a\u0004\b[\u0010I\"\u0004\b\\\u0010KR$\u0010]\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010G\u001a\u0004\b^\u0010I\"\u0004\b_\u0010KR$\u0010`\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010G\u001a\u0004\ba\u0010I\"\u0004\bb\u0010KR$\u0010c\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010G\u001a\u0004\bd\u0010I\"\u0004\be\u0010KR$\u0010f\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010G\u001a\u0004\bg\u0010I\"\u0004\bh\u0010KR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010q\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010w\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010r\u001a\u0004\bx\u0010t\"\u0004\by\u0010vR$\u0010z\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010r\u001a\u0004\b{\u0010t\"\u0004\b|\u0010vR\u0018\u0010\u0019\u001a\u00020}8\u0006¢\u0006\r\n\u0004\b\u0019\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0082\u0001"}, d2 = {"Lcom/urbandroid/sleep/shortcut/AddShortcutActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/alarmclock/settings/ILullabySelect;", "<init>", "()V", "Landroid/os/Bundle;", "paramBundle", "", "onCreatePreference", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "", "getContentLayout", "()I", "getSettings", "getTitleResource", "", "getDocumentationUrl", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "preferenceActivity", "", "searchMode", "refresh", "(Lcom/urbandroid/sleep/gui/PreferenceActivity;Z)V", "onPause", "mapToShortcut", "Landroid/app/Activity;", "Lcom/urbandroid/sleep/media/lullaby/LullabyPlayer$Lullaby;", "lullabyValue", "lullabyName", "onLullabySelected", "(Landroid/app/Activity;Lcom/urbandroid/sleep/media/lullaby/LullabyPlayer$Lullaby;Ljava/lang/String;)V", "tag", "Ljava/lang/String;", "getTag", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "()Lcom/urbandroid/sleep/service/Settings;", "Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep;", "shortcut", "Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep;", "getShortcut", "()Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep;", "setShortcut", "(Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep;)V", "newShortcut", "getNewShortcut", "setNewShortcut", "Lcom/google/android/material/textfield/TextInputEditText;", "label", "Lcom/google/android/material/textfield/TextInputEditText;", "getLabel", "()Lcom/google/android/material/textfield/TextInputEditText;", "setLabel", "(Lcom/google/android/material/textfield/TextInputEditText;)V", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", "verticalOffset", "I", "Lcom/urbandroid/sleep/gui/toolbar/AppBarStateChangeListener$State;", "appbarState", "Lcom/urbandroid/sleep/gui/toolbar/AppBarStateChangeListener$State;", "Landroid/preference/CheckBoxPreference;", "prefLullaby", "Landroid/preference/CheckBoxPreference;", "getPrefLullaby", "()Landroid/preference/CheckBoxPreference;", "setPrefLullaby", "(Landroid/preference/CheckBoxPreference;)V", "Lcom/urbandroid/sleep/gui/SeekBarPreference;", "prefIdealAdjust", "Lcom/urbandroid/sleep/gui/SeekBarPreference;", "getPrefIdealAdjust", "()Lcom/urbandroid/sleep/gui/SeekBarPreference;", "setPrefIdealAdjust", "(Lcom/urbandroid/sleep/gui/SeekBarPreference;)V", "Lcom/urbandroid/sleep/gui/SeekBarCardPreference;", "prefAlarmInMin", "Lcom/urbandroid/sleep/gui/SeekBarCardPreference;", "getPrefAlarmInMin", "()Lcom/urbandroid/sleep/gui/SeekBarCardPreference;", "setPrefAlarmInMin", "(Lcom/urbandroid/sleep/gui/SeekBarCardPreference;)V", "prefStartTrack", "getPrefStartTrack", "setPrefStartTrack", "prefSafeBattery", "getPrefSafeBattery", "setPrefSafeBattery", "prefAddAlarm", "getPrefAddAlarm", "setPrefAddAlarm", "prefUseIdeal", "getPrefUseIdeal", "setPrefUseIdeal", "prefMeditation", "getPrefMeditation", "setPrefMeditation", "Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "prefLullabyTurnOff", "Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "getPrefLullabyTurnOff", "()Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;", "setPrefLullabyTurnOff", "(Lcom/urbandroid/sleep/gui/MaterialDialogListPreference;)V", "Landroid/preference/PreferenceCategory;", "prefCategoryAlarm", "Landroid/preference/PreferenceCategory;", "getPrefCategoryAlarm", "()Landroid/preference/PreferenceCategory;", "setPrefCategoryAlarm", "(Landroid/preference/PreferenceCategory;)V", "prefCategoryTrack", "getPrefCategoryTrack", "setPrefCategoryTrack", "prefCategoryLullaby", "getPrefCategoryLullaby", "setPrefCategoryLullaby", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getRefresh", "()Ljava/lang/Runnable;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AddShortcutActivity extends SimpleSettingsActivity implements FeatureLogger, ILullabySelect {
    private static final int IDEAL_ADJUST_MIN = 180;
    private AppBarStateChangeListener.State appbarState;
    private TextInputEditText label;
    private CheckBoxPreference prefAddAlarm;
    private SeekBarCardPreference prefAlarmInMin;
    private PreferenceCategory prefCategoryAlarm;
    private PreferenceCategory prefCategoryLullaby;
    private PreferenceCategory prefCategoryTrack;
    private SeekBarPreference prefIdealAdjust;
    private CheckBoxPreference prefLullaby;
    private MaterialDialogListPreference prefLullabyTurnOff;
    private CheckBoxPreference prefMeditation;
    private CheckBoxPreference prefSafeBattery;
    private CheckBoxPreference prefStartTrack;
    private CheckBoxPreference prefUseIdeal;
    private final String tag = "AddShortcut";
    private final Settings settings = new Settings(this);
    private ShortcutSleep shortcut = new ShortcutSleep();
    private ShortcutSleep newShortcut = new ShortcutSleep();
    private final Handler h = new Handler();
    private int verticalOffset = -1;
    private final Runnable refresh = new Runnable() { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity.refresh.5
        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            AddShortcutActivity addShortcutActivity;
            TextInputEditText label;
            TextInputEditText label2 = AddShortcutActivity.this.getLabel();
            if ((label2 != null ? label2.getText() : null) == null) {
                AddShortcutActivity.this.mapToShortcut();
                ShortcutSleep newShortcut = AddShortcutActivity.this.getNewShortcut();
                if (newShortcut != null && (label = (addShortcutActivity = AddShortcutActivity.this).getLabel()) != null) {
                    label.setHint(newShortcut.getDisplayName(addShortcutActivity));
                }
            } else {
                TextInputEditText label3 = AddShortcutActivity.this.getLabel();
                if (String.valueOf(label3 != null ? label3.getText() : null).length() == 0) {
                }
            }
            AddShortcutActivity.this.getH().postDelayed(this, 1000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(AddShortcutActivity addShortcutActivity, View view, boolean z) {
        if (z) {
            TextInputEditText textInputEditText = addShortcutActivity.label;
            if (textInputEditText != null) {
                textInputEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            return;
        }
        TextInputEditText textInputEditText2 = addShortcutActivity.label;
        if (textInputEditText2 != null) {
            textInputEditText2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_pencil, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(AddShortcutActivity addShortcutActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            TextInputEditText textInputEditText = addShortcutActivity.label;
            if (textInputEditText != null) {
                textInputEditText.clearFocus();
            }
            TextInputEditText textInputEditText2 = addShortcutActivity.label;
            if (textInputEditText2 != null) {
                textInputEditText2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_pencil, 0);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(AddShortcutActivity addShortcutActivity, View view, MotionEvent motionEvent) {
        TextInputEditText textInputEditText;
        if (addShortcutActivity.appbarState != AppBarStateChangeListener.State.COLLAPSED || (textInputEditText = (TextInputEditText) addShortcutActivity.findViewById(R.id.label)) == null) {
            return true;
        }
        textInputEditText.dispatchTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$0(AddShortcutActivity addShortcutActivity, Preference preference, Object obj) {
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            PreferenceCategory preferenceCategory = addShortcutActivity.prefCategoryTrack;
            if (preferenceCategory == null) {
                return true;
            }
            preferenceCategory.addPreference(addShortcutActivity.prefSafeBattery);
            return true;
        }
        PreferenceCategory preferenceCategory2 = addShortcutActivity.prefCategoryTrack;
        if (preferenceCategory2 == null) {
            return true;
        }
        preferenceCategory2.removePreference(addShortcutActivity.prefSafeBattery);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$1(AddShortcutActivity addShortcutActivity, ShortcutSleep shortcutSleep, Preference preference, Object obj) {
        PreferenceCategory preferenceCategory;
        ShortcutSleep shortcutSleep2;
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            PreferenceCategory preferenceCategory2 = addShortcutActivity.prefCategoryAlarm;
            if (preferenceCategory2 != null) {
                preferenceCategory2.addPreference(addShortcutActivity.prefIdealAdjust);
            }
            PreferenceCategory preferenceCategory3 = addShortcutActivity.prefCategoryAlarm;
            if (preferenceCategory3 != null) {
                preferenceCategory3.removePreference(addShortcutActivity.prefAlarmInMin);
            }
            SeekBarCardPreference seekBarCardPreference = addShortcutActivity.prefAlarmInMin;
            if (seekBarCardPreference != null) {
                seekBarCardPreference.setCurrentValue(shortcutSleep.getAlarmInMin() == -1 ? addShortcutActivity.settings.getIdealSleepMinutes() : shortcutSleep.getAlarmInMin());
            }
        } else {
            if ((shortcutSleep.hasAlarm() || ((shortcutSleep2 = addShortcutActivity.newShortcut) != null && shortcutSleep2.hasAlarm())) && (preferenceCategory = addShortcutActivity.prefCategoryAlarm) != null) {
                preferenceCategory.addPreference(addShortcutActivity.prefAlarmInMin);
            }
            PreferenceCategory preferenceCategory4 = addShortcutActivity.prefCategoryAlarm;
            if (preferenceCategory4 != null) {
                preferenceCategory4.removePreference(addShortcutActivity.prefIdealAdjust);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$2(AddShortcutActivity addShortcutActivity, Preference.OnPreferenceChangeListener onPreferenceChangeListener, Preference preference, Object obj) {
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            PreferenceCategory preferenceCategory = addShortcutActivity.prefCategoryAlarm;
            if (preferenceCategory != null) {
                preferenceCategory.removePreference(addShortcutActivity.prefAlarmInMin);
            }
            PreferenceCategory preferenceCategory2 = addShortcutActivity.prefCategoryAlarm;
            if (preferenceCategory2 != null) {
                preferenceCategory2.removePreference(addShortcutActivity.prefIdealAdjust);
            }
            PreferenceCategory preferenceCategory3 = addShortcutActivity.prefCategoryAlarm;
            if (preferenceCategory3 != null) {
                preferenceCategory3.removePreference(addShortcutActivity.prefUseIdeal);
            }
            ShortcutSleep shortcutSleep = addShortcutActivity.newShortcut;
            if (shortcutSleep != null) {
                shortcutSleep.setUseIdeal(false);
            }
            ShortcutSleep shortcutSleep2 = addShortcutActivity.newShortcut;
            if (shortcutSleep2 == null) {
                return true;
            }
            shortcutSleep2.setAlarmInMin(-1);
            return true;
        }
        PreferenceCategory preferenceCategory4 = addShortcutActivity.prefCategoryAlarm;
        if (preferenceCategory4 != null) {
            preferenceCategory4.addPreference(addShortcutActivity.prefAlarmInMin);
        }
        PreferenceCategory preferenceCategory5 = addShortcutActivity.prefCategoryAlarm;
        if (preferenceCategory5 != null) {
            preferenceCategory5.addPreference(addShortcutActivity.prefIdealAdjust);
        }
        PreferenceCategory preferenceCategory6 = addShortcutActivity.prefCategoryAlarm;
        if (preferenceCategory6 != null) {
            preferenceCategory6.addPreference(addShortcutActivity.prefUseIdeal);
        }
        ShortcutSleep shortcutSleep3 = addShortcutActivity.newShortcut;
        if (shortcutSleep3 != null) {
            shortcutSleep3.setAlarmInMin(addShortcutActivity.settings.getIdealSleepMinutes());
        }
        SeekBarCardPreference seekBarCardPreference = addShortcutActivity.prefAlarmInMin;
        if (seekBarCardPreference != null) {
            seekBarCardPreference.setCurrentValue(addShortcutActivity.settings.getIdealSleepMinutes());
        }
        CheckBoxPreference checkBoxPreference = addShortcutActivity.prefUseIdeal;
        onPreferenceChangeListener.onPreferenceChange(checkBoxPreference, checkBoxPreference != null ? Boolean.valueOf(checkBoxPreference.isChecked()) : null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String refresh$lambda$1$3(PreferenceActivity preferenceActivity, int i) {
        return DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(i - IDEAL_ADJUST_MIN), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String refresh$lambda$1$4(PreferenceActivity preferenceActivity, int i) {
        return DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$6(AddShortcutActivity addShortcutActivity, Preference preference, Object obj) {
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            preference.setSummary("");
            ShortcutSleep shortcutSleep = addShortcutActivity.newShortcut;
            if (shortcutSleep != null) {
                shortcutSleep.setLullaby(null);
            }
            Logger.logInfo("Shortcut: lullaby null ");
            PreferenceCategory preferenceCategory = addShortcutActivity.prefCategoryLullaby;
            if (preferenceCategory != null) {
                preferenceCategory.removePreference(addShortcutActivity.prefMeditation);
            }
            PreferenceCategory preferenceCategory2 = addShortcutActivity.prefCategoryLullaby;
            if (preferenceCategory2 != null) {
                preferenceCategory2.removePreference(addShortcutActivity.prefLullabyTurnOff);
            }
            return true;
        }
        LullabyDialogFragment lullabyDialogFragment = new LullabyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("select", true);
        lullabyDialogFragment.setArguments(bundle);
        lullabyDialogFragment.show(addShortcutActivity.getSupportFragmentManager(), "lullaby");
        PreferenceCategory preferenceCategory3 = addShortcutActivity.prefCategoryLullaby;
        if (preferenceCategory3 != null) {
            preferenceCategory3.addPreference(addShortcutActivity.prefMeditation);
        }
        PreferenceCategory preferenceCategory4 = addShortcutActivity.prefCategoryLullaby;
        if (preferenceCategory4 == null) {
            return false;
        }
        preferenceCategory4.addPreference(addShortcutActivity.prefLullabyTurnOff);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$2(AddShortcutActivity addShortcutActivity, View view) {
        addShortcutActivity.settings.removeShortcut(addShortcutActivity.shortcut);
        addShortcutActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$3(AddShortcutActivity addShortcutActivity, View view) {
        ShortcutSleep shortcutSleep;
        addShortcutActivity.mapToShortcut();
        if (Intrinsics.areEqual(addShortcutActivity.shortcut, addShortcutActivity.newShortcut) || (shortcutSleep = addShortcutActivity.newShortcut) == null || !shortcutSleep.doesAnything()) {
            Logger.logInfo("Shortcut: doing nothing " + addShortcutActivity.shortcut + " = " + addShortcutActivity.newShortcut);
        } else {
            Logger.logInfo("Shortcut: add " + addShortcutActivity.newShortcut);
            addShortcutActivity.settings.addShortcut(addShortcutActivity.newShortcut);
            Logger.logInfo("Shortcut: remove " + addShortcutActivity.shortcut);
            addShortcutActivity.settings.removeShortcut(addShortcutActivity.shortcut);
        }
        addShortcutActivity.finish();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public int getContentLayout() {
        return R.layout.activity_settings_shortcut;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/shortcut.html";
    }

    public final Handler getH() {
        return this.h;
    }

    public final TextInputEditText getLabel() {
        return this.label;
    }

    public final ShortcutSleep getNewShortcut() {
        return this.newShortcut;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.shortcut;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.empty_string;
    }

    public final void mapToShortcut() {
        SeekBarPreference seekBarPreference;
        SeekBarCardPreference seekBarCardPreference;
        Editable text;
        ShortcutSleep shortcutSleep = this.newShortcut;
        if (shortcutSleep != null) {
            TextInputEditText textInputEditText = this.label;
            Logger.logInfo("Shortcut: label '" + ((Object) (textInputEditText != null ? textInputEditText.getText() : null)) + "'");
            TextInputEditText textInputEditText2 = this.label;
            if (textInputEditText2 != null && (text = textInputEditText2.getText()) != null && text.toString().length() > 0) {
                shortcutSleep.setName(text.toString());
                zza$$ExternalSyntheticOutline0.m("Shortcut: label ", shortcutSleep.getName());
            }
            CheckBoxPreference checkBoxPreference = this.prefStartTrack;
            if (checkBoxPreference != null) {
                shortcutSleep.setStartTracking(checkBoxPreference.isChecked());
            }
            CheckBoxPreference checkBoxPreference2 = this.prefSafeBattery;
            if (checkBoxPreference2 != null) {
                shortcutSleep.setSaveBattery(checkBoxPreference2.isChecked());
            }
            CheckBoxPreference checkBoxPreference3 = this.prefMeditation;
            if (checkBoxPreference3 != null) {
                shortcutSleep.setMeditation(checkBoxPreference3.isChecked());
            }
            MaterialDialogListPreference materialDialogListPreference = this.prefLullabyTurnOff;
            if (materialDialogListPreference != null) {
                String value = materialDialogListPreference.getValue();
                value.getClass();
                shortcutSleep.setLullabyTurnOff(Integer.parseInt(value));
            }
            CheckBoxPreference checkBoxPreference4 = this.prefUseIdeal;
            if (checkBoxPreference4 != null) {
                shortcutSleep.setUseIdeal(checkBoxPreference4.isChecked());
            }
            CheckBoxPreference checkBoxPreference5 = this.prefAddAlarm;
            if (checkBoxPreference5 != null && checkBoxPreference5.isChecked() && (seekBarCardPreference = this.prefAlarmInMin) != null) {
                shortcutSleep.setAlarmInMin(seekBarCardPreference.getCurrentValue());
            }
            CheckBoxPreference checkBoxPreference6 = this.prefUseIdeal;
            if (checkBoxPreference6 == null || !checkBoxPreference6.isChecked() || (seekBarPreference = this.prefIdealAdjust) == null) {
                return;
            }
            shortcutSleep.setIdealAdjust(seekBarPreference.getCurrentValue() - IDEAL_ADJUST_MIN);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        TextInputEditText textInputEditText;
        super.onCreate(savedInstanceState);
        TextInputEditText textInputEditText2 = (TextInputEditText) findViewById(R.id.label);
        this.label = textInputEditText2;
        int i = 0;
        if (textInputEditText2 != null) {
            textInputEditText2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_pencil, 0);
        }
        TextInputEditText textInputEditText3 = this.label;
        if (textInputEditText3 != null) {
            textInputEditText3.setOnFocusChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda0(this, i));
        }
        TextInputEditText textInputEditText4 = this.label;
        if (textInputEditText4 != null) {
            textInputEditText4.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return AddShortcutActivity.onCreate$lambda$1(this.f$0, textView, i2, keyEvent);
                }
            });
        }
        Intent intent = getIntent();
        Shortcut.Companion companion = Shortcut.INSTANCE;
        String stringExtra = intent.getStringExtra(companion.getEXTRA_SHORTCUT());
        if (stringExtra != null) {
            ShortcutSleep shortcutSleepFromString = ShortcutSleep.INSTANCE.fromString(stringExtra);
            this.shortcut = shortcutSleepFromString;
            Logger.logInfo("Shortcut: extra " + shortcutSleepFromString);
            TextInputEditText textInputEditText5 = this.label;
            if (textInputEditText5 != null) {
                ShortcutSleep shortcutSleep = this.shortcut;
                textInputEditText5.setHint(shortcutSleep != null ? shortcutSleep.getDisplayName(this) : null);
            }
            ShortcutSleep shortcutSleep2 = this.shortcut;
            if (!Intrinsics.areEqual(shortcutSleep2 != null ? shortcutSleep2.getName() : null, companion.getDEFAULT_NAME()) && (textInputEditText = this.label) != null) {
                ShortcutSleep shortcutSleep3 = this.shortcut;
                textInputEditText.setText(shortcutSleep3 != null ? shortcutSleep3.getName() : null);
            }
        }
        this.newShortcut = new ShortcutSleep();
        ShortcutSleep shortcutSleepFromString2 = ShortcutSleep.INSTANCE.fromString(String.valueOf(this.shortcut));
        this.newShortcut = shortcutSleepFromString2;
        Logger.logInfo("Shortcut: new shortcut init " + shortcutSleepFromString2);
        ((Toolbar) findViewById(R.id.toolbar)).setOnTouchListener(new View.OnTouchListener() { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AddShortcutActivity.onCreate$lambda$3(this.f$0, view, motionEvent);
            }
        });
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        final View viewFindViewById = findViewById(R.id.label_parent);
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateChangeListener() { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity.onCreate.5

            /* JADX INFO: renamed from: com.urbandroid.sleep.shortcut.AddShortcutActivity$onCreate$5$WhenMappings */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[AppBarStateChangeListener.State.values().length];
                    try {
                        iArr[AppBarStateChangeListener.State.EXPANDED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AppBarStateChangeListener.State.COLLAPSED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AppBarStateChangeListener.State.IDLE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout2, int i2) {
                appBarLayout2.getClass();
                super.onOffsetChanged(appBarLayout2, i2);
                if (AddShortcutActivity.this.verticalOffset != i2) {
                    AddShortcutActivity.this.verticalOffset = i2;
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.getClass();
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = ActivityUtils.getDip(this, (int) Math.min(48.0d, Math.abs(AddShortcutActivity.this.verticalOffset / 2)));
                    layoutParams2.rightMargin = ActivityUtils.getDip(this, (int) Math.min(48.0d, Math.abs(AddShortcutActivity.this.verticalOffset / 2)));
                    viewFindViewById.setLayoutParams(layoutParams2);
                }
            }

            @Override // com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener
            public void onStateChanged(AppBarLayout appBarLayout2, AppBarStateChangeListener.State state) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                layoutParams.getClass();
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                int i2 = state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i2 != -1) {
                    if (i2 == 1) {
                        AddShortcutActivity.this.appbarState = state;
                        layoutParams2.leftMargin = 0;
                        layoutParams2.rightMargin = 0;
                        viewFindViewById.setLayoutParams(layoutParams2);
                        return;
                    }
                    if (i2 == 2) {
                        AddShortcutActivity.this.appbarState = state;
                    } else if (i2 == 3) {
                        AddShortcutActivity.this.appbarState = state;
                    } else {
                        Home$$ExternalSyntheticBUOutline0.m();
                    }
                }
            }
        });
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle paramBundle) {
        super.onCreatePreference(paramBundle);
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.surface_variant));
        ToolbarUtil.apply(this);
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, findViewById(R.id.button_panel), 0, false, 6, null);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.ILullabySelect
    public void onLullabySelected(Activity preferenceActivity, LullabyPlayer.Lullaby lullabyValue, String lullabyName) {
        preferenceActivity.getClass();
        lullabyValue.getClass();
        lullabyName.getClass();
        CheckBoxPreference checkBoxPreference = this.prefLullaby;
        Preference.OnPreferenceChangeListener onPreferenceChangeListener = checkBoxPreference != null ? checkBoxPreference.getOnPreferenceChangeListener() : null;
        CheckBoxPreference checkBoxPreference2 = this.prefLullaby;
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setOnPreferenceChangeListener(null);
        }
        LullabyPlayer.Lullaby lullaby = LullabyPlayer.Lullaby.NONE;
        CheckBoxPreference checkBoxPreference3 = this.prefLullaby;
        if (lullabyValue == lullaby) {
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setChecked(false);
            }
            CheckBoxPreference checkBoxPreference4 = this.prefLullaby;
            if (checkBoxPreference4 != null) {
                checkBoxPreference4.setSummary((CharSequence) null);
            }
            ShortcutSleep shortcutSleep = this.newShortcut;
            if (shortcutSleep != null) {
                shortcutSleep.setLullaby(null);
            }
            Logger.logInfo("Shortcut: lullaby null ");
        } else {
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setChecked(true);
            }
            CheckBoxPreference checkBoxPreference5 = this.prefLullaby;
            if (checkBoxPreference5 != null) {
                checkBoxPreference5.setSummary(lullabyName);
            }
            ShortcutSleep shortcutSleep2 = this.newShortcut;
            if (shortcutSleep2 != null) {
                shortcutSleep2.setLullaby(lullabyValue.toString());
            }
        }
        CheckBoxPreference checkBoxPreference6 = this.prefLullaby;
        if (checkBoxPreference6 != null) {
            checkBoxPreference6.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.refresh);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        MaterialDialogListPreference materialDialogListPreference;
        CheckBoxPreference checkBoxPreference;
        SeekBarPreference seekBarPreference;
        CharSequence[] entries;
        preferenceActivity.getClass();
        super.refresh(preferenceActivity, searchMode);
        Logger.logInfo("Shortcut: refresh() ");
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        if (this.prefCategoryAlarm == null) {
            this.prefCategoryAlarm = (PreferenceCategory) (preferenceScreen != null ? preferenceScreen.findPreference("settings_category_alarm") : null);
        }
        if (this.prefCategoryTrack == null) {
            this.prefCategoryTrack = (PreferenceCategory) (preferenceScreen != null ? preferenceScreen.findPreference("settings_category_track") : null);
        }
        if (this.prefCategoryLullaby == null) {
            this.prefCategoryLullaby = (PreferenceCategory) (preferenceScreen != null ? preferenceScreen.findPreference("settings_category_lullaby") : null);
        }
        if (this.prefSafeBattery == null) {
            this.prefStartTrack = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("startTrack") : null);
        }
        CheckBoxPreference checkBoxPreference2 = this.prefSafeBattery;
        if (checkBoxPreference2 == null) {
            this.prefSafeBattery = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("saveBattery") : null);
        } else {
            PreferenceCategory preferenceCategory = this.prefCategoryTrack;
            if (preferenceCategory != null) {
                preferenceCategory.addPreference(checkBoxPreference2);
            }
        }
        if (this.prefAddAlarm == null) {
            this.prefAddAlarm = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("addAlarm") : null);
        }
        CheckBoxPreference checkBoxPreference3 = this.prefUseIdeal;
        if (checkBoxPreference3 == null) {
            this.prefUseIdeal = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("useIdeal") : null);
        } else {
            PreferenceCategory preferenceCategory2 = this.prefCategoryAlarm;
            if (preferenceCategory2 != null) {
                preferenceCategory2.addPreference(checkBoxPreference3);
            }
        }
        SeekBarPreference seekBarPreference2 = this.prefIdealAdjust;
        if (seekBarPreference2 == null) {
            SeekBarPreference seekBarPreference3 = (SeekBarPreference) (preferenceScreen != null ? preferenceScreen.findPreference("idealAdjust") : null);
            this.prefIdealAdjust = seekBarPreference3;
            if (seekBarPreference3 != null) {
                seekBarPreference3.setTitle("(+/–) " + getString(R.string.axis_minute));
            }
        } else {
            PreferenceCategory preferenceCategory3 = this.prefCategoryAlarm;
            if (preferenceCategory3 != null) {
                preferenceCategory3.addPreference(seekBarPreference2);
            }
        }
        SeekBarCardPreference seekBarCardPreference = this.prefAlarmInMin;
        if (seekBarCardPreference == null) {
            this.prefAlarmInMin = (SeekBarCardPreference) (preferenceScreen != null ? preferenceScreen.findPreference("alarmInMin") : null);
        } else {
            PreferenceCategory preferenceCategory4 = this.prefCategoryAlarm;
            if (preferenceCategory4 != null) {
                preferenceCategory4.addPreference(seekBarCardPreference);
            }
        }
        if (this.prefLullaby == null) {
            this.prefLullaby = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("lullaby") : null);
        }
        CheckBoxPreference checkBoxPreference4 = this.prefMeditation;
        if (checkBoxPreference4 == null) {
            this.prefMeditation = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("meditation") : null);
        } else {
            PreferenceCategory preferenceCategory5 = this.prefCategoryLullaby;
            if (preferenceCategory5 != null) {
                preferenceCategory5.addPreference(checkBoxPreference4);
            }
        }
        MaterialDialogListPreference materialDialogListPreference2 = this.prefLullabyTurnOff;
        final int i = 0;
        if (materialDialogListPreference2 == null) {
            MaterialDialogListPreference materialDialogListPreference3 = (MaterialDialogListPreference) (preferenceScreen != null ? preferenceScreen.findPreference("lullabyTurnOff") : null);
            this.prefLullabyTurnOff = materialDialogListPreference3;
            if (materialDialogListPreference3 != null && (entries = materialDialogListPreference3.getEntries()) != null) {
                entries[0] = getString(R.string.default_ringtone_name);
                MaterialDialogListPreference materialDialogListPreference4 = this.prefLullabyTurnOff;
                if (materialDialogListPreference4 != null) {
                    materialDialogListPreference4.setEntries(entries);
                }
            }
        } else {
            PreferenceCategory preferenceCategory6 = this.prefCategoryLullaby;
            if (preferenceCategory6 != null) {
                preferenceCategory6.addPreference(materialDialogListPreference2);
            }
        }
        ShortcutSleep shortcutSleep = this.shortcut;
        final int i2 = 1;
        if (shortcutSleep != null) {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener(this) { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda3
                public final /* synthetic */ AddShortcutActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i3 = i;
                    AddShortcutActivity addShortcutActivity = this.f$0;
                    switch (i3) {
                        case 0:
                            return AddShortcutActivity.refresh$lambda$1$0(addShortcutActivity, preference, obj);
                        default:
                            return AddShortcutActivity.refresh$lambda$1$6(addShortcutActivity, preference, obj);
                    }
                }
            };
            CheckBoxPreference checkBoxPreference5 = this.prefStartTrack;
            if (checkBoxPreference5 != null) {
                checkBoxPreference5.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            CheckBoxPreference checkBoxPreference6 = this.prefStartTrack;
            if (checkBoxPreference6 != null) {
                checkBoxPreference6.setChecked(shortcutSleep.getStartTracking());
            }
            onPreferenceChangeListener.onPreferenceChange(this.prefStartTrack, Boolean.valueOf(shortcutSleep.getStartTracking()));
            CheckBoxPreference checkBoxPreference7 = this.prefSafeBattery;
            if (checkBoxPreference7 != null) {
                checkBoxPreference7.setChecked(shortcutSleep.getSaveBattery());
            }
            AddShortcutActivity$$ExternalSyntheticLambda4 addShortcutActivity$$ExternalSyntheticLambda4 = new AddShortcutActivity$$ExternalSyntheticLambda4(this, shortcutSleep, i);
            AddShortcutActivity$$ExternalSyntheticLambda4 addShortcutActivity$$ExternalSyntheticLambda42 = new AddShortcutActivity$$ExternalSyntheticLambda4(this, addShortcutActivity$$ExternalSyntheticLambda4, 11);
            CheckBoxPreference checkBoxPreference8 = this.prefAddAlarm;
            if (checkBoxPreference8 != null) {
                checkBoxPreference8.setOnPreferenceChangeListener(addShortcutActivity$$ExternalSyntheticLambda42);
            }
            CheckBoxPreference checkBoxPreference9 = this.prefAddAlarm;
            if (checkBoxPreference9 != null) {
                checkBoxPreference9.setChecked(shortcutSleep.hasAlarm());
            }
            addShortcutActivity$$ExternalSyntheticLambda42.onPreferenceChange(this.prefAddAlarm, Boolean.valueOf(shortcutSleep.hasAlarm()));
            CheckBoxPreference checkBoxPreference10 = this.prefUseIdeal;
            if (checkBoxPreference10 != null) {
                checkBoxPreference10.setChecked(shortcutSleep.getUseIdeal());
            }
            boolean useIdeal = shortcutSleep.getUseIdeal();
            CheckBoxPreference checkBoxPreference11 = this.prefUseIdeal;
            Logger.logInfo("Shortcut: useIdeal " + useIdeal + " -> " + (checkBoxPreference11 != null ? Boolean.valueOf(checkBoxPreference11.isChecked()) : null));
            addShortcutActivity$$ExternalSyntheticLambda4.onPreferenceChange(this.prefUseIdeal, Boolean.valueOf(shortcutSleep.getUseIdeal()));
            CheckBoxPreference checkBoxPreference12 = this.prefUseIdeal;
            if (checkBoxPreference12 != null) {
                checkBoxPreference12.setOnPreferenceChangeListener(addShortcutActivity$$ExternalSyntheticLambda4);
            }
            SeekBarPreference seekBarPreference4 = this.prefIdealAdjust;
            if (seekBarPreference4 != null) {
                seekBarPreference4.setFormatter(new AddShortcutActivity$$ExternalSyntheticLambda6(preferenceActivity, i));
            }
            SeekBarCardPreference seekBarCardPreference2 = this.prefAlarmInMin;
            if (seekBarCardPreference2 != null) {
                seekBarCardPreference2.setFormatter(new AddShortcutActivity$$ExternalSyntheticLambda6(preferenceActivity, 2));
            }
            SeekBarCardPreference seekBarCardPreference3 = this.prefAlarmInMin;
            if (seekBarCardPreference3 != null) {
                seekBarCardPreference3.setCurrentValue(shortcutSleep.getAlarmInMin() == -1 ? this.settings.getIdealSleepMinutes() : shortcutSleep.getAlarmInMin());
            }
            if (shortcutSleep.getIdealAdjust() != -1 && (seekBarPreference = this.prefIdealAdjust) != null) {
                seekBarPreference.setCurrentValue(shortcutSleep.getIdealAdjust() + IDEAL_ADJUST_MIN);
            }
            String strM1635getLullaby = shortcutSleep.getLullaby();
            if (strM1635getLullaby != null && (checkBoxPreference = this.prefLullaby) != null) {
                checkBoxPreference.setSummary(LullabyPlayer.Lullaby.valueOf(strM1635getLullaby).getDisplayName(this));
            }
            CheckBoxPreference checkBoxPreference13 = this.prefLullaby;
            if (checkBoxPreference13 != null) {
                checkBoxPreference13.setChecked(shortcutSleep.hasLullaby());
            }
            boolean zHasLullaby = shortcutSleep.hasLullaby();
            PreferenceCategory preferenceCategory7 = this.prefCategoryLullaby;
            if (zHasLullaby) {
                if (preferenceCategory7 != null) {
                    preferenceCategory7.addPreference(this.prefMeditation);
                }
                PreferenceCategory preferenceCategory8 = this.prefCategoryLullaby;
                if (preferenceCategory8 != null) {
                    preferenceCategory8.addPreference(this.prefLullabyTurnOff);
                }
            } else {
                if (preferenceCategory7 != null) {
                    preferenceCategory7.removePreference(this.prefMeditation);
                }
                PreferenceCategory preferenceCategory9 = this.prefCategoryLullaby;
                if (preferenceCategory9 != null) {
                    preferenceCategory9.removePreference(this.prefLullabyTurnOff);
                }
            }
            CheckBoxPreference checkBoxPreference14 = this.prefLullaby;
            if (checkBoxPreference14 != null) {
                checkBoxPreference14.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener(this) { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda3
                    public final /* synthetic */ AddShortcutActivity f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // android.preference.Preference.OnPreferenceChangeListener
                    public final boolean onPreferenceChange(Preference preference, Object obj) {
                        int i3 = i2;
                        AddShortcutActivity addShortcutActivity = this.f$0;
                        switch (i3) {
                            case 0:
                                return AddShortcutActivity.refresh$lambda$1$0(addShortcutActivity, preference, obj);
                            default:
                                return AddShortcutActivity.refresh$lambda$1$6(addShortcutActivity, preference, obj);
                        }
                    }
                });
            }
            CheckBoxPreference checkBoxPreference15 = this.prefMeditation;
            if (checkBoxPreference15 != null) {
                checkBoxPreference15.setChecked(shortcutSleep.getMeditation());
            }
            MaterialDialogListPreference materialDialogListPreference5 = this.prefLullabyTurnOff;
            if (materialDialogListPreference5 != null) {
                materialDialogListPreference5.setValue(String.valueOf(shortcutSleep.getLullabyTurnOff()));
            }
            if (shortcutSleep.getLullabyTurnOff() == -1 && (materialDialogListPreference = this.prefLullabyTurnOff) != null) {
                materialDialogListPreference.setSummary(getString(R.string.default_ringtone_name));
            }
        }
        findViewById(R.id.add_record_button_cancel).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda9
            public final /* synthetic */ AddShortcutActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                AddShortcutActivity addShortcutActivity = this.f$0;
                switch (i3) {
                    case 0:
                        AddShortcutActivity.refresh$lambda$2(addShortcutActivity, view);
                        break;
                    default:
                        AddShortcutActivity.refresh$lambda$3(addShortcutActivity, view);
                        break;
                }
            }
        });
        findViewById(R.id.add_record_button).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda9
            public final /* synthetic */ AddShortcutActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                AddShortcutActivity addShortcutActivity = this.f$0;
                switch (i3) {
                    case 0:
                        AddShortcutActivity.refresh$lambda$2(addShortcutActivity, view);
                        break;
                    default:
                        AddShortcutActivity.refresh$lambda$3(addShortcutActivity, view);
                        break;
                }
            }
        });
        this.h.removeCallbacks(this.refresh);
        this.h.postDelayed(this.refresh, 1000L);
    }
}

package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.TextValidator;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.automation.AutomationEventMapping;
import com.urbandroid.sleep.service.automation.ifttt.IftttActivity;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/AutomationSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getSettings", "", "getTitleResource", "getDocumentationUrl", "urlValidatingEditTextPreferenceClickListener", "Landroid/preference/Preference$OnPreferenceClickListener;", "mqttValidatingEditTextPreferenceClickListener", "refresh", "", "preferenceActivity", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "searchMode", "", "onDestroy", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutomationSettingsActivity extends SimpleSettingsActivity implements FeatureLogger, CoroutineScope {
    private final Preference.OnPreferenceClickListener mqttValidatingEditTextPreferenceClickListener;
    private final Preference.OnPreferenceClickListener urlValidatingEditTextPreferenceClickListener;
    private final String tag = "automation-settings";
    private final CoroutineContext coroutineContext = Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new AutomationSettingsActivity$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));

    public AutomationSettingsActivity() {
        final int i = 0;
        this.urlValidatingEditTextPreferenceClickListener = new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$$ExternalSyntheticLambda10
            public final /* synthetic */ AutomationSettingsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public final boolean onPreferenceClick(Preference preference) {
                int i2 = i;
                AutomationSettingsActivity automationSettingsActivity = this.f$0;
                switch (i2) {
                    case 0:
                        return AutomationSettingsActivity.urlValidatingEditTextPreferenceClickListener$lambda$0(automationSettingsActivity, preference);
                    default:
                        return AutomationSettingsActivity.mqttValidatingEditTextPreferenceClickListener$lambda$0(automationSettingsActivity, preference);
                }
            }
        };
        final int i2 = 1;
        this.mqttValidatingEditTextPreferenceClickListener = new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$$ExternalSyntheticLambda10
            public final /* synthetic */ AutomationSettingsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public final boolean onPreferenceClick(Preference preference) {
                int i22 = i2;
                AutomationSettingsActivity automationSettingsActivity = this.f$0;
                switch (i22) {
                    case 0:
                        return AutomationSettingsActivity.urlValidatingEditTextPreferenceClickListener$lambda$0(automationSettingsActivity, preference);
                    default:
                        return AutomationSettingsActivity.mqttValidatingEditTextPreferenceClickListener$lambda$0(automationSettingsActivity, preference);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mqttValidatingEditTextPreferenceClickListener$lambda$0(final AutomationSettingsActivity automationSettingsActivity, Preference preference) {
        preference.getClass();
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (editTextPreference.getDialog() == null) {
            return true;
        }
        Dialog dialog = editTextPreference.getDialog();
        dialog.getClass();
        final Button button = ((AlertDialog) dialog).getButton(-1);
        button.setEnabled(false);
        button.setTextColor(automationSettingsActivity.getColor(R.color.disabled));
        final EditText editText = editTextPreference.getEditText();
        editText.addTextChangedListener(new TextValidator(editText, button, automationSettingsActivity) { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$mqttValidatingEditTextPreferenceClickListener$1$1$1
            final /* synthetic */ Button $positiveButton;
            final /* synthetic */ AutomationSettingsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(editText);
                this.$positiveButton = button;
                this.this$0 = automationSettingsActivity;
                editText.getClass();
            }

            @Override // com.urbandroid.common.util.TextValidator
            public void validate(TextView textView, String text) {
                textView.getClass();
                text.getClass();
                if (text.length() == 0 || StringsKt.startsWith$default(text, "ssl://") || StringsKt.startsWith$default(text, "tcp://")) {
                    this.$positiveButton.setEnabled(true);
                    this.$positiveButton.setTextColor(this.this$0.getColor(R.color.primary));
                } else {
                    this.$positiveButton.setEnabled(false);
                    this.$positiveButton.setTextColor(this.this$0.getColor(R.color.disabled));
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(PreferenceActivity preferenceActivity, Preference preference) {
        ViewIntent.urlCustomTab(preferenceActivity, "https://sleep.urbandroid.org/docs//automation/");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$4(MultiSelectListPreference multiSelectListPreference, AutomationSettingsActivity automationSettingsActivity, Preference preference, Object obj) {
        Set set = obj instanceof Set ? (Set) obj : null;
        Integer numValueOf = set != null ? Integer.valueOf(set.size()) : null;
        multiSelectListPreference.setSummary(numValueOf + " " + automationSettingsActivity.getString(R.string.enabled));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2(PreferenceActivity preferenceActivity, Preference preference) {
        ViewIntent.urlCustomTab(preferenceActivity, "https://sleep.urbandroid.org/docs//devs/intent_api.html");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$3(EditTextPreference editTextPreference, Preference preference, Object obj) {
        editTextPreference.setSummary((CharSequence) obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$4(AutomationSettingsActivity automationSettingsActivity, Context context, Preference preference) {
        if (ContextExtKt.hasConnectivity(automationSettingsActivity)) {
            BuildersKt__Builders_commonKt.launch$default(automationSettingsActivity, null, null, new AutomationSettingsActivity$refresh$5$1(automationSettingsActivity, context, null), 3, null);
            return true;
        }
        Toast.makeText(automationSettingsActivity, R.string.no_connection, 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$5(EditTextPreference editTextPreference, Preference preference, Object obj) {
        editTextPreference.setSummary((CharSequence) obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$6(EditTextPreference editTextPreference, Preference preference, Object obj) {
        editTextPreference.setSummary((CharSequence) obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$7(AutomationSettingsActivity automationSettingsActivity, Settings settings, PreferenceActivity preferenceActivity, Context context, Preference preference, Object obj) {
        String str = "IFTTT Preference: " + settings.isIfttt();
        Logger.logInfo(Logger.defaultTag, automationSettingsActivity.getTag() + ": " + str, null);
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            settings.setIfttt(false);
            return true;
        }
        preferenceActivity.startActivity(new Intent(context, (Class<?>) IftttActivity.class));
        settings.setIfttt(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$8(AutomationSettingsActivity automationSettingsActivity, EditTextPreference editTextPreference, Preference preference, Object obj) {
        String strM = Fragment$$ExternalSyntheticOutline1.m("Webhooks: ", obj);
        Logger.logInfo(Logger.defaultTag, automationSettingsActivity.getTag() + ": " + strM, null);
        editTextPreference.setSummary((CharSequence) obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$9(Settings settings, AutomationSettingsActivity automationSettingsActivity, Preference preference, Object obj) {
        obj.getClass();
        settings.setTasker(((Boolean) obj).booleanValue());
        String str = "Tasker Preference: " + settings.isTasker();
        Logger.logInfo(Logger.defaultTag, automationSettingsActivity.getTag() + ": " + str, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean urlValidatingEditTextPreferenceClickListener$lambda$0(final AutomationSettingsActivity automationSettingsActivity, Preference preference) {
        preference.getClass();
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (editTextPreference.getDialog() == null) {
            return true;
        }
        Dialog dialog = editTextPreference.getDialog();
        dialog.getClass();
        final Button button = ((AlertDialog) dialog).getButton(-1);
        button.setEnabled(false);
        button.setTextColor(automationSettingsActivity.getColor(R.color.disabled));
        final EditText editText = editTextPreference.getEditText();
        editText.addTextChangedListener(new TextValidator(editText, automationSettingsActivity, button) { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$urlValidatingEditTextPreferenceClickListener$1$1$1
            final /* synthetic */ Button $positiveButton;
            final /* synthetic */ AutomationSettingsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(editText);
                this.this$0 = automationSettingsActivity;
                this.$positiveButton = button;
                editText.getClass();
            }

            @Override // com.urbandroid.common.util.TextValidator
            public void validate(TextView textView, String text) {
                textView.getClass();
                text.getClass();
                AutomationSettingsActivity automationSettingsActivity2 = this.this$0;
                String strConcat = "Preference: TextChanged = ".concat(text);
                Logger.logInfo(Logger.defaultTag, automationSettingsActivity2.getTag() + ": " + strConcat, null);
                if (text.length() == 0 || StringsKt.contains$default(text, ":/")) {
                    this.$positiveButton.setEnabled(true);
                    this.$positiveButton.setTextColor(this.this$0.getColor(R.color.primary));
                } else {
                    this.$positiveButton.setEnabled(false);
                    this.$positiveButton.setTextColor(this.this$0.getColor(R.color.disabled));
                }
            }
        });
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//automation/";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_automation;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.automation;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0282  */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        Preference preferenceFindPreference;
        preferenceActivity.getClass();
        Logger.logDebug(Logger.defaultTag, getTag() + ": refresh", null);
        super.refresh(preferenceActivity, searchMode);
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Settings settings = ContextExtKt.getSettings(preferenceActivity);
        if (preferenceScreen != null && (preferenceFindPreference = preferenceScreen.findPreference("automation_doc")) != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 5));
        }
        settings.resetAutomationEvents();
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) (preferenceScreen != null ? preferenceScreen.findPreference("automation_events_list") : null);
        final int i = 2;
        final int i2 = 0;
        if (multiSelectListPreference != null) {
            AutomationEventMapping[] automationEventMappingArrValues = AutomationEventMapping.values();
            ArrayList<AutomationEventMapping> arrayList = new ArrayList();
            for (AutomationEventMapping automationEventMapping : automationEventMappingArrValues) {
                if (automationEventMapping != AutomationEventMapping.UNKNOWN) {
                    arrayList.add(automationEventMapping);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (AutomationEventMapping automationEventMapping2 : arrayList) {
                arrayList2.add(automationEventMapping2.name() + "\n" + automationEventMapping2.getLabel(preferenceActivity) + "\n");
            }
            multiSelectListPreference.setEntries((CharSequence[]) arrayList2.toArray(new String[0]));
            AutomationEventMapping[] automationEventMappingArrValues2 = AutomationEventMapping.values();
            ArrayList arrayList3 = new ArrayList();
            for (AutomationEventMapping automationEventMapping3 : automationEventMappingArrValues2) {
                if (automationEventMapping3 != AutomationEventMapping.UNKNOWN) {
                    arrayList3.add(automationEventMapping3);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(((AutomationEventMapping) it.next()).getAction());
            }
            multiSelectListPreference.setEntryValues((CharSequence[]) arrayList4.toArray(new String[0]));
            multiSelectListPreference.setSummary(settings.getAutomationEvents().size() + " " + getString(R.string.enabled));
            multiSelectListPreference.setDefaultValue(AutomationEventMapping.INSTANCE.getActionSet());
            multiSelectListPreference.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(multiSelectListPreference, this, i));
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("intent_api") : null);
        if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(settings.isIntentApi());
        }
        Preference preferenceFindPreference2 = preferenceScreen != null ? preferenceScreen.findPreference("intent_api_read_more") : null;
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 6));
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("mqtt") : null);
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setChecked(settings.isMqtt());
        }
        final EditTextPreference editTextPreference = (EditTextPreference) (preferenceScreen != null ? preferenceScreen.findPreference("mqtt_server_url") : null);
        if (editTextPreference != null) {
            editTextPreference.setDialogTitle(preferenceActivity.getString(R.string.mqtt) + " " + preferenceActivity.getString(R.string.url));
            editTextPreference.setSummary(settings.getMqttServerUrl());
            editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$$ExternalSyntheticLambda3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i3 = i2;
                    EditTextPreference editTextPreference2 = editTextPreference;
                    switch (i3) {
                        case 0:
                            return AutomationSettingsActivity.refresh$lambda$3(editTextPreference2, preference, obj);
                        case 1:
                            return AutomationSettingsActivity.refresh$lambda$5(editTextPreference2, preference, obj);
                        default:
                            return AutomationSettingsActivity.refresh$lambda$6(editTextPreference2, preference, obj);
                    }
                }
            });
            editTextPreference.setOnPreferenceClickListener(this.mqttValidatingEditTextPreferenceClickListener);
        }
        Preference preferenceFindPreference3 = preferenceScreen != null ? preferenceScreen.findPreference("mqtt_test") : null;
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, i));
        }
        final EditTextPreference editTextPreference2 = (EditTextPreference) (preferenceScreen != null ? preferenceScreen.findPreference("mqtt_client_id") : null);
        final int i3 = 1;
        if (editTextPreference2 != null) {
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + FileInsert$$ExternalSyntheticOutline0.m("mqtt client summary ->", settings.getMqttClientId(), "<-"), null);
            editTextPreference2.setSummary(settings.getMqttClientId());
            editTextPreference2.setText(settings.getMqttClientId());
            editTextPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$$ExternalSyntheticLambda3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i32 = i3;
                    EditTextPreference editTextPreference22 = editTextPreference2;
                    switch (i32) {
                        case 0:
                            return AutomationSettingsActivity.refresh$lambda$3(editTextPreference22, preference, obj);
                        case 1:
                            return AutomationSettingsActivity.refresh$lambda$5(editTextPreference22, preference, obj);
                        default:
                            return AutomationSettingsActivity.refresh$lambda$6(editTextPreference22, preference, obj);
                    }
                }
            });
        }
        final EditTextPreference editTextPreference3 = (EditTextPreference) (preferenceScreen != null ? preferenceScreen.findPreference("mqtt_topic") : null);
        if (editTextPreference3 != null) {
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + FileInsert$$ExternalSyntheticOutline0.m("mqtt client summary ->", settings.getMqttClientId(), "<-"), null);
            editTextPreference3.setSummary(settings.getMqttTopic());
            editTextPreference3.setText(settings.getMqttTopic());
            editTextPreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity$$ExternalSyntheticLambda3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i32 = i;
                    EditTextPreference editTextPreference22 = editTextPreference3;
                    switch (i32) {
                        case 0:
                            return AutomationSettingsActivity.refresh$lambda$3(editTextPreference22, preference, obj);
                        case 1:
                            return AutomationSettingsActivity.refresh$lambda$5(editTextPreference22, preference, obj);
                        default:
                            return AutomationSettingsActivity.refresh$lambda$6(editTextPreference22, preference, obj);
                    }
                }
            });
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("ifttt") : null);
        if (checkBoxPreference3 != null) {
            if (settings.isIfttt()) {
                String iftttKey = settings.getIftttKey();
                iftttKey.getClass();
                boolean z = iftttKey.length() > 0;
                settings.setIfttt(z);
                checkBoxPreference3.setChecked(z);
                checkBoxPreference3.setTitle(preferenceActivity.getString(R.string.ifttt));
                checkBoxPreference3.setOnPreferenceChangeListener(new AutomationSettingsActivity$$ExternalSyntheticLambda7(this, settings, preferenceActivity, preferenceActivity, 0));
            }
        }
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("webhooks_enabled") : null);
        if (checkBoxPreference4 != null) {
            checkBoxPreference4.setChecked(settings.isWebhooks());
        }
        EditTextPreference editTextPreference4 = (EditTextPreference) (preferenceScreen != null ? preferenceScreen.findPreference("webhooks_url") : null);
        if (editTextPreference4 != null) {
            editTextPreference4.setDialogTitle(preferenceActivity.getString(R.string.webhooks) + " " + preferenceActivity.getString(R.string.url));
            editTextPreference4.setSummary(settings.getWebhooksUrl());
            editTextPreference4.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(this, editTextPreference4, 3));
            editTextPreference4.setOnPreferenceClickListener(this.urlValidatingEditTextPreferenceClickListener);
        }
        CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) (preferenceScreen != null ? preferenceScreen.findPreference("tasker2") : null);
        if (checkBoxPreference5 != null) {
            checkBoxPreference5.setChecked(settings.isTasker());
            checkBoxPreference5.setTitle(preferenceActivity.getString(R.string.tasker));
            checkBoxPreference5.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(settings, this, 4));
        }
    }
}

package com.urbandroid.sleep.captcha;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class DreamDiaryCaptcha extends AbstractCaptchaActivity {
    private Button buttonOk;
    private SleepRecord currentSleepRecord;
    private ProgressBar progress;
    private TextView progressText;
    private EditText text;
    private int count = 0;
    private int offset = 0;
    private int max = 10;

    private int getMax() {
        return this.max + this.offset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(AtomicBoolean atomicBoolean, View view) {
        findViewById(R.id.add_record_seekbar).setEnabled(!atomicBoolean.get());
        atomicBoolean.set(!atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        try {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.PROMPT", R.string.text_to_speech_title);
            startActivityForResult(intent, 1234);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, getResources().getString(R.string.speech_recognizer_not_present), 0).show();
        }
    }

    private void save() {
        SleepRecord sleepRecord;
        if (getCaptchaSupport().isOperationalMode()) {
            if (CurrentSleepRecord.getInstance().getRecord() != null) {
                CurrentSleepRecord.getInstance().getRecord().setComment("" + ((Object) this.text.getText()));
                return;
            }
            SleepRecord relatedSleepRecord = getRelatedSleepRecord();
            if (relatedSleepRecord != null) {
                SleepRecord sleepRecord2 = new SleepRecord(relatedSleepRecord, false);
                relatedSleepRecord.rateAndComment("" + ((Object) this.text.getText()), sleepRecord2.getRating());
                SharedApplicationContext.getInstance().recordRatingUpdated(sleepRecord2, new SleepRecord(relatedSleepRecord, false), new UndoOperationGroup("IGNORED", null));
                return;
            }
            if (((CheckBox) findViewById(R.id.add_record_switch)).isChecked() && (sleepRecord = this.currentSleepRecord) != null) {
                sleepRecord.setComment("" + ((Object) this.text.getText()));
                SharedApplicationContext.getInstance().saveNewSleepRecord(this.currentSleepRecord, null);
                return;
            }
            ((ClipboardManager) getSystemService("clipboard")).setText("" + ((Object) this.text.getText()));
            Toast.makeText(this, getString(R.string.no_history_records) + " (" + getString(R.string.copy_record) + ")", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDuration() {
        ((TextView) findViewById(R.id.add_record_switch)).setText(getString(R.string.add_record_title) + " (" + getString(R.string.stats_caption_sleep) + " " + DateUtil.formatMinutes(Integer.valueOf(this.currentSleepRecord.getSleepLengthMinutes())) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        this.count = this.text.getText() == null ? 0 : Tag.collapseTags(this.text.getText().toString()).length();
        this.progress.setMax(Math.max(getMax(), 1));
        this.progress.setProgress(this.count);
        this.progressText.setText(String.format("%d / %d", Integer.valueOf(this.count), Integer.valueOf(getMax())));
        int max = getMax() - this.count;
        Button button = this.buttonOk;
        if (max >= 1) {
            button.setText(getString(R.string.xmore, Integer.valueOf(getMax() - this.count)));
        } else {
            button.setText(getString(R.string.done));
        }
        int i = this.count;
        int max2 = getMax();
        Button button2 = this.buttonOk;
        if (i >= max2) {
            if (button2.isEnabled()) {
                return;
            }
            this.buttonOk.setEnabled(true);
        } else if (button2.isEnabled()) {
            this.buttonOk.setEnabled(false);
        }
    }

    public void checkSolved() {
        if (this.count < getMax() || this.text.getText() == null) {
            return;
        }
        save();
        solved();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (i == 1234 && i2 == -1 && (stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS")) != null) {
            Iterator<String> it = stringArrayListExtra.iterator();
            if (it.hasNext()) {
                String next = it.next();
                this.text.setText(((Object) this.text.getText()) + next + " ");
            }
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.captcha_dream_diary);
        this.progress = (ProgressBar) findViewById(R.id.progress);
        View viewInflate = InflatorUtil.get(this).inflate(R.layout.title, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 21);
        TextView textView = (TextView) viewInflate.findViewById(android.R.id.title);
        this.progressText = textView;
        textView.setPadding(ActivityUtils.getDip(this, 4), ActivityUtils.getDip(this, 4), ActivityUtils.getDip(this, 4), ActivityUtils.getDip(this, 4));
        int i = 1;
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(viewInflate, layoutParams);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.captcha_preferene_title);
            String string = getResources().getString(R.string.captcha_dream_diary_title);
            ActionBar supportActionBar = getSupportActionBar();
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(string, " ");
            sbM.append(DateUtil.getShortDateWeekInstanceWithoutYears(this).format(new Date()));
            supportActionBar.setTitle(sbM.toString());
        }
        this.max = Math.max(getDifficulty() * 10, 10);
        Button button = (Button) findViewById(R.id.buttonOk);
        this.buttonOk = button;
        button.setEnabled(false);
        this.buttonOk.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.DreamDiaryCaptcha.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DreamDiaryCaptcha.this.checkSolved();
            }
        });
        EditText editText = (EditText) findViewById(R.id.text);
        this.text = editText;
        editText.requestFocus();
        this.text.addTextChangedListener(new TextWatcher() { // from class: com.urbandroid.sleep.captcha.DreamDiaryCaptcha.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                DreamDiaryCaptcha dreamDiaryCaptcha = DreamDiaryCaptcha.this;
                dreamDiaryCaptcha.count = dreamDiaryCaptcha.text.getText() == null ? 0 : Tag.collapseTags(DreamDiaryCaptcha.this.text.getText().toString()).length();
                DreamDiaryCaptcha.this.updateProgress();
                DreamDiaryCaptcha.this.userInteraction();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (bundle != null) {
            this.currentSleepRecord = (SleepRecord) bundle.getParcelable("SleepRecord");
            this.text.setText(bundle.getString("text"));
            updateProgress();
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tags);
        viewGroup.removeAllViews();
        EditText editText2 = this.text;
        Tag tag = Tag.GOODDREAM;
        Tag tag2 = Tag.BADDREAM;
        EditActivity.createTags(this, viewGroup, editText2, true, tag, tag2);
        Tag.handleTag(this, tag2.getTagName(), this.text, viewGroup, true, 1, true);
        Tag.handleTag(this, tag.getTagName(), this.text, viewGroup, true, 1, true);
        updateProgress();
        if (getRelatedSleepRecord() == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            findViewById(R.id.add_record_layout).setVisibility(0);
            ((CheckBox) findViewById(R.id.add_record_switch)).setChecked(true);
            findViewById(R.id.add_record_switch).setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, atomicBoolean, 11));
            final Calendar calendar = Calendar.getInstance();
            if (this.currentSleepRecord == null) {
                Date time = calendar.getTime();
                calendar.add(12, -SharedApplicationContext.getSettings().getIdealSleepMinutes());
                SleepRecord sleepRecord = new SleepRecord(calendar.getTimeZone().getID(), calendar.getTime(), time);
                this.currentSleepRecord = sleepRecord;
                sleepRecord.setTo(time);
                this.currentSleepRecord.setFinished(true);
            }
            updateDuration();
            ((SeekBar) findViewById(R.id.add_record_seekbar)).setProgress(this.currentSleepRecord.getSleepLengthMinutes());
            ((SeekBar) findViewById(R.id.add_record_seekbar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.urbandroid.sleep.captcha.DreamDiaryCaptcha.3
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                    calendar.setTime(DreamDiaryCaptcha.this.currentSleepRecord.getNotNullTo());
                    calendar.add(12, -i2);
                    DreamDiaryCaptcha.this.currentSleepRecord.setFrom(calendar.getTime());
                    DreamDiaryCaptcha.this.updateDuration();
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        } else if (this.text.getText() == null || this.text.getText().toString().length() == 0) {
            SleepRecord relatedSleepRecord = getRelatedSleepRecord();
            this.text.setText(relatedSleepRecord.getComment());
            this.offset = Tag.collapseTags(relatedSleepRecord.getComment()).length();
            updateProgress();
        }
        findViewById(R.id.tts).setOnClickListener(new LOLCaptcha$$ExternalSyntheticLambda0(this, i));
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            SleepRecord sleepRecord = this.currentSleepRecord;
            if (sleepRecord != null) {
                bundle.putParcelable("SleepRecord", sleepRecord);
            }
            EditText editText = this.text;
            if (editText != null && editText.getText() != null) {
                bundle.putString("text", this.text.getText().toString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        save();
    }
}

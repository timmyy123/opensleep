package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.tag.TagMap;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EditActivity extends BaseActivity {
    private EditText comment;
    private boolean eveningMode = false;
    private SleepRecord record;

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.EditActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends AsyncTask<Void, Void, List<String>> {
        final /* synthetic */ EditText val$comment;
        final /* synthetic */ Activity val$context;
        final /* synthetic */ boolean val$dark;
        final /* synthetic */ Tag[] val$excludeTags;
        final /* synthetic */ ProgressBar val$loading;
        final /* synthetic */ ViewGroup val$tagsGroup;

        public AnonymousClass1(ViewGroup viewGroup, ProgressBar progressBar, Activity activity, boolean z, EditText editText, Tag[] tagArr) {
            this.val$tagsGroup = viewGroup;
            this.val$loading = progressBar;
            this.val$context = activity;
            this.val$dark = z;
            this.val$comment = editText;
            this.val$excludeTags = tagArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPostExecute$0(EditText editText, EditText editText2, DialogInterface dialogInterface, int i) {
            if (editText.getText() == null) {
                editText.setText("");
            }
            if (editText2 == null || editText2.getText() == null || editText2.getText().toString() == null || editText2.getText().toString().length() <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append((Object) editText.getText());
            sb.append(editText2.getText().toString().startsWith("#") ? " " : " #");
            sb.append(editText2.getText().toString());
            editText.setText(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPostExecute$1(Activity activity, EditText editText, View view) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity);
            materialAlertDialogBuilder.setTitle(R.string.custom_tag);
            View viewInflate = InflatorUtil.get(activity).inflate(R.layout.dialog_edit_text, (ViewGroup) activity.findViewById(R.id.root), false);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.edit);
            materialAlertDialogBuilder.setView(viewInflate);
            materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new AlarmClock$$ExternalSyntheticLambda21(editText, editText2, 1));
            materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
            DialogUtil.fixDivider(materialAlertDialogBuilder.show());
        }

        @Override // android.os.AsyncTask
        public List<String> doInBackground(Void... voidArr) {
            return SharedApplicationContext.getInstance().getSleepRecordRepository().getLastComments(50);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(List<String> list) {
            this.val$tagsGroup.removeView(this.val$loading);
            TagMap tagMap = new TagMap();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                tagMap.putTags(Tag.getTags(it.next()));
            }
            View viewInflate = InflatorUtil.get(this.val$context).inflate(this.val$dark ? R.layout.tag_button_plus_dark : R.layout.tag_button_plus, (ViewGroup) this.val$context.findViewById(R.id.root), false);
            this.val$tagsGroup.addView(viewInflate);
            viewInflate.setOnClickListener(new SetAlarm$$ExternalSyntheticLambda11(this.val$context, this.val$comment, 1));
            for (String str : tagMap.getSortedWithBuildIn()) {
                Tag[] tagArr = this.val$excludeTags;
                if (tagArr != null) {
                    for (Tag tag : tagArr) {
                        if (tag.getTagName().equals(str)) {
                            break;
                        }
                    }
                }
                Tag.handleTag((Context) this.val$context, str, this.val$comment, this.val$tagsGroup, true, this.val$dark);
            }
        }
    }

    private void buildActivityFromIntent(Intent intent) {
        if (intent == null) {
            Logger.logSevere("No intent cannot determine sleep record");
            finish();
            return;
        }
        if (intent.hasExtra("evening_mode")) {
            Logger.logInfo("Evening mode");
            this.eveningMode = true;
        }
        if (this.eveningMode || SleepService.isRunning()) {
            getDelegate().setLocalNightMode(2);
            KeyguardUtil.disable(this);
        }
        SleepRecord sleepRecord = (SleepRecord) intent.getParcelableExtra("SleepRecord");
        this.record = sleepRecord;
        if (sleepRecord == null) {
            finish();
            return;
        }
        Logger.logInfo("Edit activity, record: " + this.record);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.sleep_rating_bar);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tags);
        ((TextInputLayout) findViewById(R.id.sleep_rating_comment_layout)).setEndIconOnClickListener(new EditActivity$$ExternalSyntheticLambda0(this, 0));
        this.comment.setText(this.record.getComment());
        ratingBar.setRating(this.record.getRating());
        viewGroup.removeAllViews();
        createTags(this, viewGroup, this.comment, this.eveningMode, new Tag[0]);
        findViewById(R.id.done).setOnClickListener(new SetAlarm$$ExternalSyntheticLambda11(this, ratingBar, 3));
    }

    public static void createTags(Activity activity, ViewGroup viewGroup, EditText editText, boolean z, Tag... tagArr) {
        ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setIndeterminate(true);
        viewGroup.addView(progressBar);
        new AnonymousClass1(viewGroup, progressBar, activity, z, editText, tagArr).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$0(View view) {
        try {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.PROMPT", "Speech to text");
            startActivityForResult(intent, 1234);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, getResources().getString(R.string.speech_recognizer_not_present), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$1(RatingBar ratingBar, View view) {
        SleepRecord sleepRecord = new SleepRecord(this.record, false);
        float rating = ratingBar.getRating();
        String string = this.comment.getText().toString();
        if (!this.record.isNiceRecord() || rating < 4.0f || sleepRecord.getRating() >= rating) {
            Settings.setGoodTimeToRate(false);
        } else {
            Settings.setGoodTimeToRate(true);
        }
        this.record.rateAndComment(string, rating);
        Logger.logInfo("Rating " + string + " " + rating);
        if (!this.eveningMode) {
            SharedApplicationContext.getInstance().recordRatingUpdated(sleepRecord, new SleepRecord(this.record, false), null);
        }
        Intent intent = new Intent();
        intent.putExtra("SleepRecord", (Parcelable) this.record);
        setResult(1, intent);
        finish();
    }

    public static void showRatingForResult(Activity activity, SleepRecord sleepRecord, boolean z) {
        Intent intent = new Intent(activity, (Class<?>) EditActivity.class);
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
        intent.putExtra("keyguard", z);
        activity.startActivityForResult(intent, 1);
    }

    public static void showRatingInTracking(Activity activity, SleepRecord sleepRecord) {
        Intent intent = new Intent(activity, (Class<?>) EditActivity.class);
        intent.putExtra("evening_mode", true);
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
        activity.startActivityForResult(intent, 1);
    }

    public int getLayout() {
        return R.layout.dialog_edit;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        zza$$ExternalSyntheticOutline0.m(i, i2, "EditActivity: onResult ", " ");
        if (i != 1234 || i2 != -1 || (stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS")) == null || stringArrayListExtra.size() <= 0) {
            return;
        }
        Logger.logInfo("EditActivity: matches " + stringArrayListExtra.get(0));
        this.comment.setText(((Object) this.comment.getText()) + " " + stringArrayListExtra.get(0));
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(getLayout());
        getWindow().setLayout(-1, -2);
        this.comment = (EditText) findViewById(R.id.sleep_rating_comment);
        buildActivityFromIntent(getIntent());
        if (bundle == null || bundle.getString("comment") == null) {
            return;
        }
        this.comment.setText(bundle.getString("comment"));
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        buildActivityFromIntent(intent);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        EditText editText = this.comment;
        if (editText == null || editText.toString() == null) {
            return;
        }
        bundle.putString("comment", this.comment.toString());
    }

    public static void showRatingForResult(Activity activity, SleepRecord sleepRecord) {
        showRatingForResult(activity, sleepRecord, false);
    }

    public static void createTags(Activity activity, ViewGroup viewGroup, EditText editText, Tag... tagArr) {
        createTags(activity, viewGroup, editText, false, tagArr);
    }

    public static void createTags(Activity activity, ViewGroup viewGroup, EditText editText) {
        createTags(activity, viewGroup, editText, new Tag[0]);
    }
}

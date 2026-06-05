package com.urbandroid.sleep;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.activityrecognition.calculator.NewRecordSleepTimeSuggestion;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.GraphActivity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.Experiments;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public class NewAddRecordActivity extends BaseActivity {
    private RangeSlider bar;
    private boolean changedTimes;
    private Chip day;
    private Chip from;
    private Calendar fromCalendar;
    private long lastMax;
    private long lastMin;
    private long maxEntry;
    private long minEntry;
    private long originalMinutes;
    private Chip to;
    private Calendar toCalendar;
    private SleepTimeCalculator.Estimate yesterdayBasicEstimate;

    public NewAddRecordActivity() {
        SleepTimeCalculator.Estimate estimateLastNightBasicEstimate = SleepTimeCalculator.INSTANCE.lastNightBasicEstimate();
        this.yesterdayBasicEstimate = estimateLastNightBasicEstimate;
        this.fromCalendar = estimateLastNightBasicEstimate.getFrom();
        this.toCalendar = this.yesterdayBasicEstimate.getTo();
        this.changedTimes = false;
        this.originalMinutes = -1L;
        this.lastMax = -1L;
        this.lastMin = -1L;
    }

    private boolean addRecord(Calendar calendar, Calendar calendar2) {
        SleepRecord sleepRecord = new SleepRecord(TimeZone.getDefault().getID(), calendar.getTime(), calendar2.getTime());
        sleepRecord.updateLatestTo(calendar2.getTime());
        sleepRecord.setTo(calendar2.getTime());
        final int i = 1;
        sleepRecord.setFinished(true);
        sleepRecord.rateAndComment(getString(R.string.add_manually), 0.0f);
        zza$$ExternalSyntheticOutline0.m((int) Math.abs(((long) sleepRecord.getMeasurementLength()) - this.originalMinutes), "NewAddRecordActivity: Correction ");
        SleepRecord sleepRecordFindOverlap = findOverlap(sleepRecord);
        if (sleepRecordFindOverlap == null) {
            ArrayList arrayList = new ArrayList();
            if (Experiments.getInstance().isRandomSleepDataExperiment()) {
                generateRandomData(sleepRecord.getFrom(), sleepRecord.getTo(), arrayList);
            } else {
                arrayList.add(Float.valueOf(0.0f));
            }
            sleepRecord.setHistory(arrayList);
            int iAbs = (int) Math.abs(((long) sleepRecord.getMeasurementLength()) - this.originalMinutes);
            Logger.logInfo("NewAddRecordActivity: Correction " + iAbs);
            UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.add_manually), null);
            SharedApplicationContext.getInstance().getSleepRecordRepository().addNewSleepRecord(sleepRecord, undoOperationGroup);
            SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
            new Settings(getApplicationContext()).incRecordsCount();
            if (getIntent() != null && getIntent().hasExtra("sleep_suggestion")) {
                new SleepTimeSuggestionManager(getApplicationContext()).cancel(getIntent().getIntExtra("sleep_suggestion", 2442));
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventManualRecordAddedFromSuggestion();
                if (SharedApplicationContext.getSettings().isActivityRecognitionNewSleepApi()) {
                    SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSleepApiSegmentAdded();
                    if (this.originalMinutes != -1 && iAbs > 0) {
                        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSleepApiSegmentCorrection(iAbs);
                    }
                }
            }
            Logger.logInfo("SYNC data changed broadcast");
            zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
            try {
                if (SharedApplicationContext.getSettings().isTimeToBackup()) {
                    new BackupManager(this).dataChanged();
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            finish();
            if (getIntent().hasExtra("next_class") && getIntent().getStringExtra("next_class").equals("graphs")) {
                startActivity(new Intent(this, (Class<?>) GraphActivity.class));
            }
            return true;
        }
        Interval interval = sleepRecordFindOverlap.getInterval();
        Interval interval2 = sleepRecord.getInterval();
        Logger.logInfo("AddRecord: overlap existing " + interval + " new " + interval2);
        final ArrayList arrayList2 = new ArrayList(interval2.subtract(interval));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Logger.logInfo("AddRecord: BEFORE resolution " + ((Interval) it.next()));
        }
        Collections.reverse(arrayList2);
        final int i2 = 0;
        if (arrayList2.size() < 2) {
            if (arrayList2.size() == 0) {
                arrayList2.add(0, new Interval(interval.getFrom(), interval.getFrom() - interval2.getLength()));
                arrayList2.add(1, new Interval(interval.getTo(), interval2.getLength() + interval.getTo()));
            } else if (((Interval) arrayList2.get(0)).getTo() > interval.getTo()) {
                arrayList2.add(0, new Interval(interval.getFrom(), interval.getFrom() - interval2.getLength()));
            } else if (((Interval) arrayList2.get(0)).getFrom() < interval.getFrom()) {
                arrayList2.add(1, new Interval(interval.getTo(), interval2.getLength() + interval.getTo()));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Logger.logInfo("AddRecord: AFTER resolution " + ((Interval) it2.next()));
        }
        MaterialAlertDialogBuilder negativeButton = new MaterialAlertDialogBuilder(this).setMessage((CharSequence) (getString(R.string.dialog_record_overlap) + " (" + DateUtil.formatTime(this, sleepRecordFindOverlap.getFromTime()) + " - " + DateUtil.formatTime(this, sleepRecordFindOverlap.getToTime()) + ")")).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        negativeButton.setTitle(R.string.resolve);
        if (arrayList2.size() == 2) {
            negativeButton.setNeutralButton((CharSequence) (getString(R.string.menu_add) + " " + getString(R.string.before)), new DialogInterface.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda2
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    int i4 = i2;
                    ArrayList arrayList3 = arrayList2;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i4) {
                        case 0:
                            newAddRecordActivity.lambda$addRecord$9(arrayList3, dialogInterface, i3);
                            break;
                        default:
                            newAddRecordActivity.lambda$addRecord$10(arrayList3, dialogInterface, i3);
                            break;
                    }
                }
            });
            negativeButton.setPositiveButton((CharSequence) (getString(R.string.menu_add) + " " + getString(R.string.after_time, "")), new DialogInterface.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda2
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    int i4 = i;
                    ArrayList arrayList3 = arrayList2;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i4) {
                        case 0:
                            newAddRecordActivity.lambda$addRecord$9(arrayList3, dialogInterface, i3);
                            break;
                        default:
                            newAddRecordActivity.lambda$addRecord$10(arrayList3, dialogInterface, i3);
                            break;
                    }
                }
            });
        }
        try {
            DialogUtil.fixDivider(negativeButton.show());
            return false;
        } catch (Exception e2) {
            Logger.logSevere(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncEstimateTimes() {
        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.NewAddRecordActivity.3
            /* JADX WARN: Removed duplicated region for block: B:35:0x0247  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0271  */
            @Override // android.os.AsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Void doInBackground(Void... voidArr) {
                long j;
                SleepTimeCalculator.Estimate estimate = new SleepTimeCalculator.Estimate(SleepTimeCalculator.Estimate.Type.BASIC, NewAddRecordActivity.this.fromCalendar, NewAddRecordActivity.this.toCalendar);
                SleepTimeCalculator.Estimate estimateCalculate = new NewRecordSleepTimeSuggestion().calculate(NewAddRecordActivity.this.getApplicationContext(), estimate);
                if (estimateCalculate != null) {
                    estimate = estimateCalculate;
                }
                NewAddRecordActivity.this.fromCalendar = estimate.getFrom();
                NewAddRecordActivity.this.toCalendar = estimate.getTo();
                SleepRecord sleepRecord = new SleepRecord(TimeZone.getDefault().getID(), NewAddRecordActivity.this.fromCalendar.getTime(), NewAddRecordActivity.this.toCalendar.getTime());
                sleepRecord.setTo(NewAddRecordActivity.this.toCalendar.getTime());
                sleepRecord.setFinished(true);
                SleepRecord sleepRecordFindOverlap = NewAddRecordActivity.this.findOverlap(sleepRecord);
                if (sleepRecordFindOverlap != null) {
                    long time = sleepRecordFindOverlap.getFrom().getTime();
                    long time2 = sleepRecordFindOverlap.getTo().getTime();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Logger.logInfo("AddRecord: Overlap " + sleepRecordFindOverlap + " FROM " + NewAddRecordActivity.this.fromCalendar.getTime() + " TO " + NewAddRecordActivity.this.toCalendar.getTime());
                    if (NewAddRecordActivity.this.fromCalendar.getTimeInMillis() < time || NewAddRecordActivity.this.toCalendar.getTimeInMillis() > time2) {
                        if (NewAddRecordActivity.this.fromCalendar.getTimeInMillis() < time || NewAddRecordActivity.this.fromCalendar.getTimeInMillis() > time2) {
                            j = 1800000;
                            if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() >= time && NewAddRecordActivity.this.toCalendar.getTimeInMillis() <= time2) {
                                Logger.logInfo("AddRecord: Overlap before ");
                                NewAddRecordActivity.this.toCalendar.setTimeInMillis(time);
                                NewAddRecordActivity.this.toCalendar.add(12, -5);
                                if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() - NewAddRecordActivity.this.fromCalendar.getTimeInMillis() < 1800000) {
                                    NewAddRecordActivity.this.fromCalendar.setTimeInMillis(NewAddRecordActivity.this.toCalendar.getTimeInMillis());
                                    NewAddRecordActivity.this.fromCalendar.add(12, -30);
                                }
                            }
                        } else {
                            Logger.logInfo("AddRecord: Overlap after ");
                            NewAddRecordActivity.this.fromCalendar.setTimeInMillis(time2);
                            NewAddRecordActivity.this.fromCalendar.add(12, 5);
                            if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() - NewAddRecordActivity.this.fromCalendar.getTimeInMillis() < 1800000) {
                                j = 1800000;
                                NewAddRecordActivity.this.toCalendar.setTimeInMillis(NewAddRecordActivity.this.fromCalendar.getTimeInMillis());
                                NewAddRecordActivity.this.toCalendar.add(12, 30);
                            }
                        }
                        if (time > NewAddRecordActivity.this.fromCalendar.getTimeInMillis() && time2 < NewAddRecordActivity.this.toCalendar.getTimeInMillis()) {
                            Logger.logInfo("Overlap inside reversed ");
                            NewAddRecordActivity.this.fromCalendar.setTimeInMillis(time2);
                            NewAddRecordActivity.this.fromCalendar.add(12, 5);
                            NewAddRecordActivity.this.toCalendar.setTimeInMillis(NewAddRecordActivity.this.toCalendar.getTimeInMillis());
                            if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() - NewAddRecordActivity.this.fromCalendar.getTimeInMillis() < j) {
                                NewAddRecordActivity.this.toCalendar.setTimeInMillis(NewAddRecordActivity.this.fromCalendar.getTimeInMillis());
                                NewAddRecordActivity.this.toCalendar.add(12, 30);
                            }
                        }
                        if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() > jCurrentTimeMillis) {
                            NewAddRecordActivity.this.toCalendar.setTimeInMillis(jCurrentTimeMillis);
                            if (NewAddRecordActivity.this.fromCalendar.getTimeInMillis() >= jCurrentTimeMillis) {
                                NewAddRecordActivity.this.fromCalendar.setTimeInMillis(jCurrentTimeMillis);
                            }
                        }
                    } else {
                        Logger.logInfo("AddRecord: Overlap inside ");
                        NewAddRecordActivity.this.fromCalendar.setTimeInMillis(time2);
                        NewAddRecordActivity.this.fromCalendar.add(12, 5);
                        NewAddRecordActivity.this.toCalendar.setTimeInMillis(time2);
                        NewAddRecordActivity.this.toCalendar.add(11, 1);
                    }
                    j = 1800000;
                    if (time > NewAddRecordActivity.this.fromCalendar.getTimeInMillis()) {
                        Logger.logInfo("Overlap inside reversed ");
                        NewAddRecordActivity.this.fromCalendar.setTimeInMillis(time2);
                        NewAddRecordActivity.this.fromCalendar.add(12, 5);
                        NewAddRecordActivity.this.toCalendar.setTimeInMillis(NewAddRecordActivity.this.toCalendar.getTimeInMillis());
                        if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() - NewAddRecordActivity.this.fromCalendar.getTimeInMillis() < j) {
                        }
                    }
                    if (NewAddRecordActivity.this.toCalendar.getTimeInMillis() > jCurrentTimeMillis) {
                    }
                }
                return null;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Void r2) {
                NewAddRecordActivity.this.findViewById(R.id.progress).setVisibility(8);
                NewAddRecordActivity.this.refresh();
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                NewAddRecordActivity.this.findViewById(R.id.progress).setVisibility(0);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SleepRecord findOverlap(SleepRecord sleepRecord) {
        SleepRecords sleepRecords = new SleepRecords();
        List<SleepRecord> sleepRecords2 = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(sleepRecord.getFrom().getTime() - TimeChart.DAY, TimeChart.DAY + sleepRecord.getTo().getTime(), false);
        if (sleepRecords2 == null) {
            return null;
        }
        for (SleepRecord sleepRecord2 : sleepRecords2) {
            if (sleepRecords.isOverlap(sleepRecord2, sleepRecord)) {
                return sleepRecord2;
            }
        }
        return null;
    }

    private void generateRandomData(Date date, Date date2, List<Float> list) {
        Random random = new Random();
        long time = ((date2.getTime() - date.getTime()) / ((long) SleepService.FRAMERATE)) + ((long) (random.nextInt() % 33));
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < time; i++) {
            if (random.nextFloat() > 0.9999f) {
                list.add(Float.valueOf((random.nextFloat() * 2.0f) + 0.5f));
            } else if (random.nextFloat() > 0.995f) {
                list.add(Float.valueOf(random.nextFloat() * 2.0f));
            } else {
                list.add(Float.valueOf(random.nextFloat() * 0.8f));
            }
        }
    }

    private int getInterval(long j, long j2) {
        int minutes = getMinutes(j2) - getMinutes(j);
        return minutes < 0 ? minutes + 1440 : minutes;
    }

    private int getMinutes(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(12) + (calendar.get(11) * 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecord$10(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        Interval interval = (Interval) arrayList.get(1);
        this.fromCalendar.setTimeInMillis(interval.getFrom() + 1);
        this.toCalendar.setTimeInMillis(interval.getTo());
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecord$9(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        Interval interval = (Interval) arrayList.get(0);
        this.fromCalendar.setTimeInMillis(interval.getFrom());
        this.toCalendar.setTimeInMillis(interval.getTo() - 1);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Long l) {
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTF"));
        calendar.setTimeInMillis(l.longValue());
        Logger.logInfo("NewAddRecordActivity: DatePicker tz " + calendar.getTimeZone().getID());
        Logger.logInfo("NewAddRecordActivity: DatePicker day " + calendar.getTime());
        this.toCalendar.set(1, calendar.get(1));
        this.toCalendar.set(2, calendar.get(2));
        this.toCalendar.set(5, calendar.get(5));
        setDate(this.fromCalendar, this.toCalendar);
        if (isChangedTimes()) {
            return;
        }
        asyncEstimateTimes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        try {
            MaterialDatePicker.Builder<Long> builderDatePicker = MaterialDatePicker.Builder.datePicker();
            builderDatePicker.setTitleText(R.string.category_wake_up);
            builderDatePicker.setCalendarConstraints(new CalendarConstraints.Builder().setValidator(DateValidatorPointBackward.now()).build());
            MaterialDatePicker<Long> materialDatePickerBuild = builderDatePicker.build();
            materialDatePickerBuild.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda11
                @Override // com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
                public final void onPositiveButtonClick(Object obj) {
                    this.f$0.lambda$onCreate$0((Long) obj);
                }
            });
            materialDatePickerBuild.show(getSupportFragmentManager(), builderDatePicker.toString());
        } catch (Throwable unused) {
            View viewInflate = InflatorUtil.get(this).inflate(R.layout.dialog_simple_date_picker, (ViewGroup) null);
            final EditText editText = (EditText) viewInflate.findViewById(R.id.edit);
            editText.setText(DateFormat.getDateFormat(this).format(new Date()));
            new MaterialAlertDialogBuilder(this).setView(viewInflate).setTitle(R.string.stats_caption_day).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.NewAddRecordActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        NewAddRecordActivity.this.toCalendar.setTime(DateFormat.getDateFormat(NewAddRecordActivity.this).parse(editText.getText().toString()));
                        NewAddRecordActivity newAddRecordActivity = NewAddRecordActivity.this;
                        newAddRecordActivity.setDate(newAddRecordActivity.fromCalendar, NewAddRecordActivity.this.toCalendar);
                        if (NewAddRecordActivity.this.isChangedTimes()) {
                            return;
                        }
                        NewAddRecordActivity.this.asyncEstimateTimes();
                    } catch (ParseException e) {
                        Logger.logSevere(e);
                    }
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(MaterialTimePicker materialTimePicker, View view) {
        this.fromCalendar.set(11, materialTimePicker.getHour());
        this.fromCalendar.set(12, materialTimePicker.getMinute());
        this.fromCalendar.set(13, 0);
        Logger.logInfo("NewAddRecordActivity: Picker FROM " + this.fromCalendar.getTime());
        setDate(this.fromCalendar, this.toCalendar);
        setBar(this.bar, this.fromCalendar.getTimeInMillis(), this.toCalendar.getTimeInMillis(), false);
        setChangedTimes(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        MaterialTimePicker materialTimePickerBuild = new MaterialTimePicker.Builder().setHour(this.fromCalendar.get(11)).setMinute(this.fromCalendar.get(12)).setInputMode(0).setTimeFormat(Alarms.get24HourMode(this) ? 1 : 0).build();
        materialTimePickerBuild.addOnPositiveButtonClickListener(new NewAddRecordActivity$$ExternalSyntheticLambda10(this, materialTimePickerBuild, 0));
        materialTimePickerBuild.show(getSupportFragmentManager(), "fromPicker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(MaterialTimePicker materialTimePicker, View view) {
        this.toCalendar.set(11, materialTimePicker.getHour());
        this.toCalendar.set(12, materialTimePicker.getMinute());
        this.toCalendar.set(13, 0);
        Logger.logInfo("NewAddRecordActivity: Picker TO " + this.toCalendar.getTime());
        setDate(this.fromCalendar, this.toCalendar);
        setBar(this.bar, this.fromCalendar.getTimeInMillis(), this.toCalendar.getTimeInMillis(), false);
        setChangedTimes(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        MaterialTimePicker materialTimePickerBuild = new MaterialTimePicker.Builder().setHour(this.toCalendar.get(11)).setMinute(this.toCalendar.get(12)).setInputMode(0).setTimeFormat(Alarms.get24HourMode(this) ? 1 : 0).build();
        materialTimePickerBuild.addOnPositiveButtonClickListener(new NewAddRecordActivity$$ExternalSyntheticLambda10(this, materialTimePickerBuild, 1));
        materialTimePickerBuild.show(getSupportFragmentManager(), "toPicker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        addRecord(this.fromCalendar, this.toCalendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(RangeSlider rangeSlider, float f, boolean z) {
        if (z) {
            setChangedTimes(true);
            long j = this.minEntry;
            long j2 = this.maxEntry;
            long jLongValue = rangeSlider.getValues().get(0).longValue();
            long jLongValue2 = rangeSlider.getValues().get(1).longValue();
            if (jLongValue2 - jLongValue <= 5) {
                Logger.logInfo("Range too close ");
                setBar(this.bar, j, j2, true);
                return;
            }
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Range ", " - ", jLongValue);
            sbM.append(jLongValue2);
            Logger.logInfo(sbM.toString());
            long j3 = this.lastMin;
            if (jLongValue != j3) {
                j += (jLongValue - j3) * 60000;
            } else {
                long j4 = this.lastMax;
                if (jLongValue2 != j4) {
                    j2 += (jLongValue2 - j4) * 60000;
                }
            }
            setBar(this.bar, j, j2, true);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(roundTime(j));
            this.fromCalendar.set(11, calendar.get(11));
            this.fromCalendar.set(12, calendar.get(12));
            calendar.setTimeInMillis(roundTime(j2));
            this.toCalendar.set(11, calendar.get(11));
            this.toCalendar.set(12, calendar.get(12));
            setDate(this.fromCalendar, this.toCalendar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.fromCalendar.getTimeInMillis() > jCurrentTimeMillis) {
            this.fromCalendar.setTimeInMillis(jCurrentTimeMillis);
        }
        if (this.toCalendar.getTimeInMillis() > jCurrentTimeMillis) {
            this.toCalendar.setTimeInMillis(jCurrentTimeMillis);
        }
        Logger.logInfo("AddRecord: refresh " + this.fromCalendar.getTime() + " - " + this.toCalendar.getTime());
        setDate(this.fromCalendar, this.toCalendar);
        setBar(this.bar, this.fromCalendar.getTimeInMillis(), this.toCalendar.getTimeInMillis(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long roundTime(long j) {
        long j2 = j % 300000;
        return j + (j2 > 150000 ? 300000 - j2 : -j2);
    }

    private void setBar(RangeSlider rangeSlider, long j, long j2, boolean z) {
        float valueTo = (rangeSlider.getValueTo() - getInterval(j, j2)) / 2.0f;
        rangeSlider.setValues(Float.valueOf(valueTo), Float.valueOf(rangeSlider.getValueTo() - valueTo));
        this.lastMin = (int) valueTo;
        this.lastMax = (int) r0;
        this.minEntry = j;
        this.maxEntry = j2;
        updateBar(rangeSlider, j, j2, z);
    }

    private void setDate(Calendar calendar, Calendar calendar2, boolean z) {
        Calendar calendar3 = Calendar.getInstance();
        if (z) {
            calendar.set(1, calendar2.get(1));
            calendar.set(2, calendar2.get(2));
            calendar.set(5, calendar2.get(5));
            Logger.logInfo("NewAddRecordActivity: Set FROM " + calendar.getTime());
            Logger.logInfo("NewAddRecordActivity: Set TO " + calendar2.getTime());
            if (calendar2.get(11) < calendar.get(11) || (calendar2.get(11) == calendar.get(11) && calendar2.get(12) <= calendar.get(12))) {
                Logger.logInfo("NewAddRecordActivity: day -1 toHour " + calendar2.get(11) + " fromHour " + calendar.get(11) + " tz " + calendar.getTimeZone().getID() + " " + calendar2.getTimeZone().getID());
                calendar.add(5, -1);
            }
            Logger.logInfo("NewAddRecordActivity: Set FROM " + calendar.getTime());
            Logger.logInfo("NewAddRecordActivity: Set TO " + calendar2.getTime());
            if (calendar2.getTimeInMillis() > calendar3.getTimeInMillis()) {
                calendar.set(5, calendar3.get(5) - (calendar2.get(5) - calendar.get(5)));
                calendar2.set(5, calendar3.get(5));
                findViewById(R.id.error).setVisibility(0);
            } else {
                findViewById(R.id.error).setVisibility(4);
            }
        }
        this.day.setText(DateUtil.getShortDateWeekInstanceWithoutYears(this).format(calendar2.getTime()));
        this.from.setText(DateUtil.formatTime(this, calendar.getTime().getTime()));
        this.to.setText(DateUtil.formatTime(this, calendar2.getTime().getTime()));
    }

    public static void start(Activity activity, long j, long j2) {
        Intent intent = new Intent(activity, (Class<?>) NewAddRecordActivity.class);
        intent.putExtra("rangeFrom", j);
        intent.putExtra("rangeTo", j2);
        intent.putExtra("next_class", "graphs");
        activity.startActivity(intent);
    }

    private void updateBar(RangeSlider rangeSlider, long j, long j2, boolean z) {
        rangeSlider.invalidate();
    }

    public boolean isChangedTimes() {
        return this.changedTimes;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x01d0  */
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        setContentView(R.layout.activity_add_record_new);
        ToolbarUtil.apply(this);
        final int i = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((Toolbar) findViewById(R.id.toolbar)).setNavigationIcon(R.drawable.ic_action_accept);
        EdgeToEdgeUtil.insetsTop(findViewById(R.id.toolbar));
        EdgeToEdgeUtil.insetsBottom(findViewById(R.id.button_panel));
        final int i2 = 0;
        if (bundle == null) {
            if (getIntent() != null) {
                long longExtra = getIntent().getLongExtra("rangeFrom", -1L);
                if (longExtra != -1) {
                    this.fromCalendar.setTimeInMillis(longExtra);
                    z = true;
                } else {
                    z = false;
                }
                long longExtra2 = getIntent().getLongExtra("rangeTo", -1L);
                if (longExtra2 != -1) {
                    this.toCalendar.setTimeInMillis(Math.min(longExtra2, System.currentTimeMillis()));
                    z = true;
                }
                Logger.logInfo("NewAddRecordActivity: getIntent() from " + new Date(longExtra) + " to " + new Date(longExtra2));
                this.originalMinutes = Math.abs(longExtra2 - longExtra) / 60000;
            }
            this.day = (Chip) findViewById(R.id.day);
            this.from = (Chip) findViewById(R.id.from);
            this.to = (Chip) findViewById(R.id.to);
            Logger.logInfo("NewAddRecordActivity: range " + Utils.format(this.fromCalendar) + " -> " + Utils.format(this.toCalendar));
            setDate(this.fromCalendar, this.toCalendar, z ^ true);
            Logger.logInfo("NewAddRecordActivity: range " + Utils.format(this.fromCalendar) + " -> " + Utils.format(this.toCalendar));
            RangeSlider rangeSlider = new RangeSlider(this);
            this.bar = rangeSlider;
            rangeSlider.setValueFrom(0.0f);
            this.bar.setTrackHeight(ActivityUtils.getDip(this, 24));
            this.bar.setThumbHeight(ActivityUtils.getDip(this, 36));
            this.bar.setValueTo(1439.0f);
            final int i3 = 3;
            this.bar.setLabelBehavior(3);
            this.bar.setLabelFormatter(new LabelFormatter() { // from class: com.urbandroid.sleep.NewAddRecordActivity.1
                @Override // com.google.android.material.slider.LabelFormatter
                public String getFormattedValue(float f) {
                    float fFloatValue = NewAddRecordActivity.this.bar.getValues().get(0).floatValue();
                    NewAddRecordActivity newAddRecordActivity = NewAddRecordActivity.this;
                    if (fFloatValue == f) {
                        Context applicationContext = newAddRecordActivity.getApplicationContext();
                        NewAddRecordActivity newAddRecordActivity2 = NewAddRecordActivity.this;
                        return DateUtil.formatTime(applicationContext, newAddRecordActivity2.roundTime(newAddRecordActivity2.minEntry));
                    }
                    if (newAddRecordActivity.bar.getValues().get(1).floatValue() != f) {
                        return "";
                    }
                    Context applicationContext2 = NewAddRecordActivity.this.getApplicationContext();
                    NewAddRecordActivity newAddRecordActivity3 = NewAddRecordActivity.this;
                    return DateUtil.formatTime(applicationContext2, newAddRecordActivity3.roundTime(newAddRecordActivity3.maxEntry));
                }
            });
            ComponentColorUtilKt.color(this.bar);
            this.day.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i4 = i2;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i4) {
                        case 0:
                            newAddRecordActivity.lambda$onCreate$1(view);
                            break;
                        case 1:
                            newAddRecordActivity.lambda$onCreate$3(view);
                            break;
                        case 2:
                            newAddRecordActivity.lambda$onCreate$5(view);
                            break;
                        case 3:
                            newAddRecordActivity.lambda$onCreate$6(view);
                            break;
                        default:
                            newAddRecordActivity.lambda$onCreate$7(view);
                            break;
                    }
                }
            });
            this.from.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i4 = i;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i4) {
                        case 0:
                            newAddRecordActivity.lambda$onCreate$1(view);
                            break;
                        case 1:
                            newAddRecordActivity.lambda$onCreate$3(view);
                            break;
                        case 2:
                            newAddRecordActivity.lambda$onCreate$5(view);
                            break;
                        case 3:
                            newAddRecordActivity.lambda$onCreate$6(view);
                            break;
                        default:
                            newAddRecordActivity.lambda$onCreate$7(view);
                            break;
                    }
                }
            });
            final int i4 = 2;
            this.to.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i42 = i4;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i42) {
                        case 0:
                            newAddRecordActivity.lambda$onCreate$1(view);
                            break;
                        case 1:
                            newAddRecordActivity.lambda$onCreate$3(view);
                            break;
                        case 2:
                            newAddRecordActivity.lambda$onCreate$5(view);
                            break;
                        case 3:
                            newAddRecordActivity.lambda$onCreate$6(view);
                            break;
                        default:
                            newAddRecordActivity.lambda$onCreate$7(view);
                            break;
                    }
                }
            });
            findViewById(R.id.add_record_button).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i42 = i3;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i42) {
                        case 0:
                            newAddRecordActivity.lambda$onCreate$1(view);
                            break;
                        case 1:
                            newAddRecordActivity.lambda$onCreate$3(view);
                            break;
                        case 2:
                            newAddRecordActivity.lambda$onCreate$5(view);
                            break;
                        case 3:
                            newAddRecordActivity.lambda$onCreate$6(view);
                            break;
                        default:
                            newAddRecordActivity.lambda$onCreate$7(view);
                            break;
                    }
                }
            });
            final int i5 = 4;
            findViewById(R.id.add_record_button_cancel).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
                public final /* synthetic */ NewAddRecordActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i42 = i5;
                    NewAddRecordActivity newAddRecordActivity = this.f$0;
                    switch (i42) {
                        case 0:
                            newAddRecordActivity.lambda$onCreate$1(view);
                            break;
                        case 1:
                            newAddRecordActivity.lambda$onCreate$3(view);
                            break;
                        case 2:
                            newAddRecordActivity.lambda$onCreate$5(view);
                            break;
                        case 3:
                            newAddRecordActivity.lambda$onCreate$6(view);
                            break;
                        default:
                            newAddRecordActivity.lambda$onCreate$7(view);
                            break;
                    }
                }
            });
            if ((getResources().getConfiguration().screenLayout & 15) < 2) {
                findViewById(R.id.button_panel).setVisibility(8);
            }
            setBar(this.bar, this.fromCalendar.getTimeInMillis(), this.toCalendar.getTimeInMillis(), true);
            ((ViewGroup) findViewById(R.id.content)).removeAllViews();
            ((ViewGroup) findViewById(R.id.content)).addView(this.bar);
            this.bar.addOnChangeListener(new NewAddRecordActivity$$ExternalSyntheticLambda9(this));
            if (!isChangedTimes() || z) {
            }
            asyncEstimateTimes();
            return;
        }
        this.changedTimes = bundle.getBoolean("changed_time", false);
        if (bundle.containsKey("saved_from")) {
            this.fromCalendar.setTimeInMillis(bundle.getLong("saved_from"));
        }
        if (bundle.containsKey("saved_to")) {
            this.toCalendar.setTimeInMillis(bundle.getLong("saved_to"));
        }
        z = false;
        this.day = (Chip) findViewById(R.id.day);
        this.from = (Chip) findViewById(R.id.from);
        this.to = (Chip) findViewById(R.id.to);
        Logger.logInfo("NewAddRecordActivity: range " + Utils.format(this.fromCalendar) + " -> " + Utils.format(this.toCalendar));
        setDate(this.fromCalendar, this.toCalendar, z ^ true);
        Logger.logInfo("NewAddRecordActivity: range " + Utils.format(this.fromCalendar) + " -> " + Utils.format(this.toCalendar));
        RangeSlider rangeSlider2 = new RangeSlider(this);
        this.bar = rangeSlider2;
        rangeSlider2.setValueFrom(0.0f);
        this.bar.setTrackHeight(ActivityUtils.getDip(this, 24));
        this.bar.setThumbHeight(ActivityUtils.getDip(this, 36));
        this.bar.setValueTo(1439.0f);
        final int i32 = 3;
        this.bar.setLabelBehavior(3);
        this.bar.setLabelFormatter(new LabelFormatter() { // from class: com.urbandroid.sleep.NewAddRecordActivity.1
            @Override // com.google.android.material.slider.LabelFormatter
            public String getFormattedValue(float f) {
                float fFloatValue = NewAddRecordActivity.this.bar.getValues().get(0).floatValue();
                NewAddRecordActivity newAddRecordActivity = NewAddRecordActivity.this;
                if (fFloatValue == f) {
                    Context applicationContext = newAddRecordActivity.getApplicationContext();
                    NewAddRecordActivity newAddRecordActivity2 = NewAddRecordActivity.this;
                    return DateUtil.formatTime(applicationContext, newAddRecordActivity2.roundTime(newAddRecordActivity2.minEntry));
                }
                if (newAddRecordActivity.bar.getValues().get(1).floatValue() != f) {
                    return "";
                }
                Context applicationContext2 = NewAddRecordActivity.this.getApplicationContext();
                NewAddRecordActivity newAddRecordActivity3 = NewAddRecordActivity.this;
                return DateUtil.formatTime(applicationContext2, newAddRecordActivity3.roundTime(newAddRecordActivity3.maxEntry));
            }
        });
        ComponentColorUtilKt.color(this.bar);
        this.day.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ NewAddRecordActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i42 = i2;
                NewAddRecordActivity newAddRecordActivity = this.f$0;
                switch (i42) {
                    case 0:
                        newAddRecordActivity.lambda$onCreate$1(view);
                        break;
                    case 1:
                        newAddRecordActivity.lambda$onCreate$3(view);
                        break;
                    case 2:
                        newAddRecordActivity.lambda$onCreate$5(view);
                        break;
                    case 3:
                        newAddRecordActivity.lambda$onCreate$6(view);
                        break;
                    default:
                        newAddRecordActivity.lambda$onCreate$7(view);
                        break;
                }
            }
        });
        this.from.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ NewAddRecordActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i42 = i;
                NewAddRecordActivity newAddRecordActivity = this.f$0;
                switch (i42) {
                    case 0:
                        newAddRecordActivity.lambda$onCreate$1(view);
                        break;
                    case 1:
                        newAddRecordActivity.lambda$onCreate$3(view);
                        break;
                    case 2:
                        newAddRecordActivity.lambda$onCreate$5(view);
                        break;
                    case 3:
                        newAddRecordActivity.lambda$onCreate$6(view);
                        break;
                    default:
                        newAddRecordActivity.lambda$onCreate$7(view);
                        break;
                }
            }
        });
        final int i42 = 2;
        this.to.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ NewAddRecordActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i422 = i42;
                NewAddRecordActivity newAddRecordActivity = this.f$0;
                switch (i422) {
                    case 0:
                        newAddRecordActivity.lambda$onCreate$1(view);
                        break;
                    case 1:
                        newAddRecordActivity.lambda$onCreate$3(view);
                        break;
                    case 2:
                        newAddRecordActivity.lambda$onCreate$5(view);
                        break;
                    case 3:
                        newAddRecordActivity.lambda$onCreate$6(view);
                        break;
                    default:
                        newAddRecordActivity.lambda$onCreate$7(view);
                        break;
                }
            }
        });
        findViewById(R.id.add_record_button).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ NewAddRecordActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i422 = i32;
                NewAddRecordActivity newAddRecordActivity = this.f$0;
                switch (i422) {
                    case 0:
                        newAddRecordActivity.lambda$onCreate$1(view);
                        break;
                    case 1:
                        newAddRecordActivity.lambda$onCreate$3(view);
                        break;
                    case 2:
                        newAddRecordActivity.lambda$onCreate$5(view);
                        break;
                    case 3:
                        newAddRecordActivity.lambda$onCreate$6(view);
                        break;
                    default:
                        newAddRecordActivity.lambda$onCreate$7(view);
                        break;
                }
            }
        });
        final int i52 = 4;
        findViewById(R.id.add_record_button_cancel).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.NewAddRecordActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ NewAddRecordActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i422 = i52;
                NewAddRecordActivity newAddRecordActivity = this.f$0;
                switch (i422) {
                    case 0:
                        newAddRecordActivity.lambda$onCreate$1(view);
                        break;
                    case 1:
                        newAddRecordActivity.lambda$onCreate$3(view);
                        break;
                    case 2:
                        newAddRecordActivity.lambda$onCreate$5(view);
                        break;
                    case 3:
                        newAddRecordActivity.lambda$onCreate$6(view);
                        break;
                    default:
                        newAddRecordActivity.lambda$onCreate$7(view);
                        break;
                }
            }
        });
        if ((getResources().getConfiguration().screenLayout & 15) < 2) {
        }
        setBar(this.bar, this.fromCalendar.getTimeInMillis(), this.toCalendar.getTimeInMillis(), true);
        ((ViewGroup) findViewById(R.id.content)).removeAllViews();
        ((ViewGroup) findViewById(R.id.content)).addView(this.bar);
        this.bar.addOnChangeListener(new NewAddRecordActivity$$ExternalSyntheticLambda9(this));
        if (isChangedTimes()) {
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        MenuUtil.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (addRecord(this.fromCalendar, this.toCalendar)) {
                finish();
            }
            return true;
        }
        if (itemId != R.id.menu_item_delete) {
            return true;
        }
        finish();
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putLong("saved_from", this.fromCalendar.getTime().getTime());
        bundle.putLong("saved_to", this.toCalendar.getTime().getTime());
        bundle.putBoolean("changed_time", isChangedTimes());
        super.onSaveInstanceState(bundle);
    }

    public void setChangedTimes(boolean z) {
        this.changedTimes = z;
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) NewAddRecordActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(Calendar calendar, Calendar calendar2) {
        setDate(calendar, calendar2, true);
    }
}

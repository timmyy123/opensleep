package com.urbandroid.sleep;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.NumberPicker;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public class AddRecordActivity extends BaseActivity implements View.OnClickListener {
    private Button add;
    private Gallery calendarGallery;
    private Button cancel;
    private NumberPicker fromHour;
    private int selectedDay = 1;
    private NumberPicker toHour;

    public class CalendarAdapter extends BaseAdapter {
        private Context context;
        private List<String> items = new ArrayList();

        public CalendarAdapter(Context context) {
            this.context = context;
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 30; i++) {
                this.items.add(DateUtil.getShortDateInstanceWithoutYears(this.context, null).format(calendar.getTime()) + "\n" + DateUtil.getLongWeekdayNames()[calendar.get(7)]);
                calendar.add(5, -1);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.items.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.items.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calendar_day, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.itemtext)).setText(this.items.get(i));
            return viewInflate;
        }
    }

    private void addRecord(Calendar calendar, Calendar calendar2) {
        SleepRecord sleepRecord = new SleepRecord(TimeZone.getDefault().getID(), calendar.getTime(), calendar2.getTime());
        sleepRecord.updateLatestTo(calendar2.getTime());
        sleepRecord.setTo(calendar2.getTime());
        sleepRecord.setFinished(true);
        sleepRecord.rateAndComment(getString(R.string.add_manually), 0.0f);
        SleepRecords sleepRecords = new SleepRecords();
        List<SleepRecord> sleepRecords2 = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(sleepRecord.getFrom().getTime() - TimeChart.DAY, TimeChart.DAY + sleepRecord.getTo().getTime(), false);
        if (sleepRecords2 != null) {
            Iterator<SleepRecord> it = sleepRecords2.iterator();
            while (it.hasNext()) {
                if (sleepRecords.isOverlap(it.next(), sleepRecord)) {
                    new MaterialAlertDialogBuilder(this).setMessage((CharSequence) getString(R.string.dialog_record_overlap)).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
                    return;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (Experiments.getInstance().isRandomSleepDataExperiment()) {
            generateRandomData(sleepRecord.getFrom(), sleepRecord.getTo(), arrayList);
        } else {
            arrayList.add(Float.valueOf(0.0f));
        }
        sleepRecord.setHistory(arrayList);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addNewSleepRecord(sleepRecord, null);
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.REQUEST_SYNC"));
        finish();
    }

    private void generateRandomData(Date date, Date date2, List<Float> list) {
        Random random = new Random();
        long time = ((date2.getTime() - date.getTime()) / ((long) SleepService.FRAMERATE)) + ((long) (random.nextInt() % 33));
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < time; i++) {
            if (random.nextFloat() > 0.99f) {
                list.add(Float.valueOf((random.nextFloat() * 10.0f) + 0.5f));
                Logger.logInfo("SUPERHIGH: " + list.get(list.size() - 1));
            } else if (random.nextFloat() > 0.97f) {
                list.add(Float.valueOf(random.nextFloat() * 15.0f));
                Logger.logInfo("HIGH: " + list.get(list.size() - 1));
            } else {
                list.add(Float.valueOf(random.nextFloat() * 0.01f));
                Logger.logInfo("LOW: " + list.get(list.size() - 1));
            }
        }
    }

    private void save() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.fromHour.getValue() / 12);
        calendar.set(12, (this.fromHour.getValue() % 12) * 5);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, this.toHour.getValue() / 12);
        calendar2.set(12, (this.toHour.getValue() % 12) * 5);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        calendar2.add(5, -this.selectedDay);
        calendar.add(5, -this.selectedDay);
        if (calendar.getTime().after(calendar2.getTime())) {
            calendar2.add(5, 1);
        }
        addRecord(calendar, calendar2);
    }

    public void initializeWheel(NumberPicker numberPicker) {
        String str = Alarms.get24HourMode(this) ? "k:mm" : "h:mma";
        Calendar calendar = Calendar.getInstance();
        String[] strArr = new String[288];
        for (int i = 0; i < 288; i++) {
            calendar.set(11, i / 12);
            calendar.set(12, (i % 12) * 5);
            strArr[i] = (String) DateFormat.format(str, calendar.getTime());
        }
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(287);
        numberPicker.setDisplayedValues(strArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.add)) {
            save();
        }
        finish();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        setContentView(R.layout.activity_add_record);
        this.add = (Button) findViewById(R.id.add_record_button);
        this.cancel = (Button) findViewById(R.id.add_record_button_cancel);
        this.add.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        ToolbarUtil.apply(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((Toolbar) findViewById(R.id.toolbar)).setNavigationIcon(R.drawable.ic_action_accept);
        this.fromHour = (NumberPicker) findViewById(R.id.add_day);
        this.toHour = (NumberPicker) findViewById(R.id.add_hour);
        Gallery gallery = (Gallery) findViewById(R.id.add_length);
        this.calendarGallery = gallery;
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.AddRecordActivity.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                AddRecordActivity.this.selectedDay = i;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.calendarGallery.setAdapter((SpinnerAdapter) new CalendarAdapter(this));
        initializeWheel(this.fromHour);
        initializeWheel(this.toHour);
        this.fromHour.setValue(264);
        this.toHour.setValue(84);
        if ((getResources().getConfiguration().screenLayout & 15) < 2) {
            findViewById(R.id.button_panel).setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuUtil.showIcons(menu);
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            save();
            finish();
            return true;
        }
        if (itemId != R.id.menu_item_delete) {
            return true;
        }
        finish();
        return true;
    }
}

package com.urbandroid.sleep.gui;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.NoiseActivity;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.media.PlayAudioActivity;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.persistence.IPersistentReadOperation;
import com.urbandroid.sleep.service.DeleteObsoleteNoisesService;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseListCursorAdapter extends CursorAdapter implements IFilterListAdapter {
    private static boolean autoDelete = true;
    private final Context context;
    private final DbSleepRecordRepository dbSleepRecordRepository;
    private NoiseFilter filter;
    private final ListView listView;
    private final ViewGroup noRecords;
    private final View root;

    public NoiseListCursorAdapter(Activity activity, DbSleepRecordRepository dbSleepRecordRepository, ViewGroup viewGroup, NoiseFilter noiseFilter, ListView listView, View view) {
        super(activity, openCursor(dbSleepRecordRepository, noiseFilter));
        this.filter = noiseFilter;
        this.context = activity;
        this.dbSleepRecordRepository = dbSleepRecordRepository;
        this.noRecords = viewGroup;
        this.listView = listView;
        this.root = view;
    }

    private static Cursor openCursor(DbSleepRecordRepository dbSleepRecordRepository, final NoiseFilter noiseFilter) {
        final long j = 2000;
        Cursor cursorExecuteRead = dbSleepRecordRepository.executeRead(new IPersistentReadOperation() { // from class: com.urbandroid.sleep.gui.NoiseListCursorAdapter.1
            @Override // com.urbandroid.sleep.persistence.IPersistentReadOperation
            public Cursor execute(SQLiteDatabase sQLiteDatabase) {
                boolean z;
                Cursor cursorQuery;
                SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
                sQLiteQueryBuilder.setTables("noise");
                boolean z2 = true;
                if (noiseFilter.getFrom() > 0) {
                    sQLiteQueryBuilder.appendWhere("startTime >= " + noiseFilter.getFrom());
                    z = true;
                } else {
                    z = false;
                }
                if (noiseFilter.getTo() > 0) {
                    if (z) {
                        sQLiteQueryBuilder.appendWhere(" AND ");
                    }
                    sQLiteQueryBuilder.appendWhere("toStime <= " + (noiseFilter.getTo() + j));
                } else {
                    z2 = z;
                }
                if (noiseFilter.isStarred()) {
                    if (z2) {
                        sQLiteQueryBuilder.appendWhere(" AND ");
                    }
                    sQLiteQueryBuilder.appendWhere("starred > 0");
                }
                SharedApplicationContext.getInstance().incPendingDbOperations();
                if (noiseFilter.getFilterString() == null || noiseFilter.getFilterString().trim().length() <= 0) {
                    cursorQuery = sQLiteQueryBuilder.query(sQLiteDatabase, null, null, null, null, null, "startTime".concat(noiseFilter.getFrom() >= 0 ? " ASC" : " DESC"));
                } else {
                    cursorQuery = sQLiteQueryBuilder.query(sQLiteDatabase, null, "comment like ?", new String[]{"%" + noiseFilter.getFilterString() + "%"}, null, null, "startTime".concat(noiseFilter.getFrom() >= 0 ? " ASC" : " DESC"));
                }
                return new CursorWrapper(cursorQuery) { // from class: com.urbandroid.sleep.gui.NoiseListCursorAdapter.1.1
                    @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        if (!isClosed()) {
                            SharedApplicationContext.getInstance().decPendingDbOperations();
                        }
                        super.close();
                    }

                    @Override // android.database.CursorWrapper, android.database.Cursor
                    public int getCount() {
                        try {
                            return super.getCount();
                        } catch (Exception e) {
                            Logger.logWarning("Failed to get cursor count..", e);
                            return 0;
                        }
                    }
                };
            }
        });
        autoDelete = SharedApplicationContext.getSettings().isAutoDeleteNoise();
        return cursorExecuteRead;
    }

    public static void populateView(Context context, Noise noise, View view, boolean z) {
        GraphView graphView = (GraphView) view.findViewById(R.id.row_noise_graph);
        graphView.setDoGradient(false);
        graphView.setDrawYAxis(false);
        graphView.setDrawAverage(false);
        graphView.setDoTrimming(false);
        graphView.setDoDrawGraphLine(false);
        graphView.setDrawXAxisBars(false);
        graphView.setForceXAxisOffset(false);
        graphView.setDoMirrorGraph(true);
        graphView.setCardColor(ContextCompat.getColor(context, R.color.bg_card));
        graphView.setGradientFullColor(ColorUtil.i(graphView.getContext(), R.color.bg_card));
        graphView.setGradientTransColor(ColorUtil.i(graphView.getContext(), R.color.bg_card_trans));
        graphView.setEquidistantValues(noise.getData(), false);
        TextView textView = (TextView) view.findViewById(R.id.titleText);
        TextView textView2 = (TextView) view.findViewById(R.id.row_noise_subtitle);
        TextView textView3 = (TextView) view.findViewById(R.id.row_noise_duration);
        if (z) {
            view.findViewById(R.id.title).setVisibility(8);
        } else {
            view.findViewById(R.id.title).setVisibility(0);
        }
        if (DeleteObsoleteNoisesService.TO_BE_DELETED_DATE.equals(noise.getFrom())) {
            textView.setText(context.getString(R.string.delete_noise_auto_title));
        } else {
            SleepRecord sleepRecord = new SleepRecord(noise.getTimezone(), noise.getFrom(), noise.getFrom(), -1);
            sleepRecord.setTo(noise.getTo());
            textView.setText(new SleepRecordStringBuilder(context).setAppendYearIfOld(true).setAppendWeekDay(true).setAppendRange(false).build(sleepRecord));
            String time = DateUtil.formatTime(context, noise.getFromTime());
            if (noise.getTo().getTime() - noise.getFrom().getTime() > 1000) {
                textView3.setText(DateUtil.formatMinutesAndSecondsFromMsShort(context, (int) (noise.getTo().getTime() - noise.getFrom().getTime())));
                textView3.setVisibility(0);
            } else {
                textView3.setText("");
                textView3.setVisibility(8);
            }
            textView2.setText(time);
        }
        TextView textView4 = (TextView) view.findViewById(R.id.row_noise_comment);
        if (noise.isStarred()) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_star_color_24, 0, 0, 0);
            textView4.setText("");
            textView4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (autoDelete) {
                int iMax = Math.max(0, 7 - DateUtil.dateDifferenceDays(noise.getFrom(), new Date()));
                if (iMax > 1) {
                    textView4.setText(context.getResources().getString(R.string.days, FileInsert$$ExternalSyntheticOutline0.m(iMax, "")));
                } else if (iMax == 1) {
                    textView4.setText(context.getResources().getString(R.string.day));
                } else {
                    textView4.setText("");
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_discard_small_trans, 0);
            } else {
                textView4.setText("");
                textView4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        TextView textView5 = (TextView) view.findViewById(R.id.row_noise_tags);
        Set<String> tags = noise.getTags();
        if (tags != null) {
            textView5.setVisibility(Tag.tagTextView(context, textView5, tags, true, true) ? 0 : 8);
        }
        if (noise.getTagFilteredComment() == null || noise.getTagFilteredComment().trim().isEmpty()) {
            return;
        }
        textView4.setText(noise.getTagFilteredComment());
    }

    private void updateHeader() {
        View viewFindViewById;
        if (this.noRecords != null) {
            if (getCursor().getCount() != 0 || this.filter.isStarred() || (this.filter.getFilterString() != null && !"".equals(this.filter.getFilterString()))) {
                this.noRecords.setVisibility(8);
                Logger.logInfo("updateHeader VISIBLE");
                this.listView.setVisibility(0);
                if (this.root.findViewById(R.id.controlBar) != null) {
                    this.root.findViewById(R.id.controlBar).setVisibility(0);
                    return;
                }
                return;
            }
            this.noRecords.setVisibility(0);
            this.listView.setVisibility(8);
            if (this.root.findViewById(R.id.controlBar) != null) {
                this.root.findViewById(R.id.controlBar).setVisibility(8);
            }
            Context context = this.context;
            if (!(context instanceof NoiseActivity) || (viewFindViewById = ((NoiseActivity) context).findViewById(R.id.fab)) == null) {
                return;
            }
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        boolean zIsSameDate;
        Noise noiseCursorToNoise = DbSleepRecordRepository.cursorToNoise(cursor, true);
        if (cursor.isFirst() || !cursor.moveToPrevious()) {
            zIsSameDate = false;
        } else {
            Date date = new Date(cursor.getLong(2));
            String string = cursor.getString(8);
            zIsSameDate = com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(date, string == null ? TimeZone.getDefault() : DesugarTimeZone.getTimeZone(string), noiseCursorToNoise.getFrom(), string == null ? TimeZone.getDefault() : DesugarTimeZone.getTimeZone(noiseCursorToNoise.getTimezone()));
            cursor.moveToNext();
        }
        populateView(context, noiseCursorToNoise, view, zIsSameDate);
        view.setTag(noiseCursorToNoise);
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void filter(IFilterListAdapter.IFilter iFilter) {
        if (!(iFilter instanceof NoiseFilter)) {
            Types$$ExternalSyntheticBUOutline0.m$2("Instance of NoiseFilter needed to filter noises");
            return;
        }
        NoiseFilter noiseFilter = (NoiseFilter) iFilter;
        this.filter = noiseFilter;
        changeCursor(openCursor(this.dbSleepRecordRepository, noiseFilter));
        updateHeader();
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return View.inflate(context, R.layout.row_noise, null);
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void notifyChanged() {
        changeCursor(openCursor(this.dbSleepRecordRepository, this.filter));
        updateHeader();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Noise noise = (Noise) view.getTag();
        Intent intent = new Intent(this.context, (Class<?>) PlayAudioActivity.class);
        intent.putExtra("noise_ids", new long[]{noise.getId().longValue()});
        intent.putExtra("start_playback", true);
        this.context.startActivity(intent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void pause() {
        if (getCursor().isClosed()) {
            return;
        }
        getCursor().close();
    }
}

package com.urbandroid.sleep.gui;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.BoundedLinkedList;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.persistence.IPersistentReadOperation;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class GraphListCursorAdapter extends CursorAdapter implements IFilterListAdapter, AbsListView.OnScrollListener {
    private final GraphListClickHandler clickHandler;
    private final Context context;
    private int cutOffHour;
    private final DbSleepRecordRepository dbSleepRecordRepository;
    private String filterString;
    private BoundedLinkedList<ViewRefreshTask> pendingRefreshTasks;
    private int recordsCount;
    private LinkedList<ViewRefreshTask> refreshTasksInProgress;
    private final ViewGroup rootView;
    private int scrollState;
    private Date selectedDay;

    public class ViewRefreshTask extends AsyncTask<Object, Integer, Void> {
        TimeAxisLabels axis;
        final Context context;
        final Cursor cursor;
        GraphView graph;
        List<Float> history;
        Spanned htmlTags;
        SleepRecord record;
        TextView starText;
        TextView subtitle;
        String subtitleText;
        Drawable tagBitmap;
        String tagFilteredComment;
        ImageView tagView;
        Set<String> tags;
        TextView title;
        String titleText;
        final View v;

        public ViewRefreshTask(View view, Cursor cursor, Context context) {
            this.v = view;
            this.cursor = cursor;
            this.context = context;
            initializeOnUiThread();
        }

        private void initializeOnUiThread() {
            this.record = DbSleepRecordRepository.cursorToRecord(this.cursor, true, false, false);
            if (this.cursor.isFirst()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.v.findViewById(R.id.foreground).getLayoutParams();
                layoutParams.topMargin = ActivityUtils.getDip(this.context, 8);
                this.v.findViewById(R.id.foreground).setLayoutParams(layoutParams);
            } else {
                if (this.cursor.moveToPrevious()) {
                    Cursor cursor = this.cursor;
                    DateUtil.getCutOffInterval(new Date(cursor.getLong(cursor.getColumnIndex("toTime"))), GraphListCursorAdapter.this.cutOffHour).isIn(this.record.getTo().getTime());
                    this.cursor.moveToNext();
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.v.findViewById(R.id.foreground).getLayoutParams();
                layoutParams2.topMargin = ActivityUtils.getDip(this.context, 2);
                this.v.findViewById(R.id.foreground).setLayoutParams(layoutParams2);
            }
            ((TextView) this.v.findViewById(R.id.titleTextGraph)).setTextColor(ColorUtil.i(this.context, R.color.primary));
            if (GraphListCursorAdapter.this.selectedDay != null && com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(this.record.getTo(), GraphListCursorAdapter.this.selectedDay)) {
                ((TextView) this.v.findViewById(R.id.titleTextGraph)).setTextColor(ColorUtil.i(this.context, R.color.tint));
            }
            this.v.setTag(this.record);
            this.history = this.record.getFilteredHistoryForCharting();
            TextView textView = (TextView) this.v.findViewById(R.id.titleTextGraph);
            this.title = textView;
            textView.setText("");
            TextView textView2 = (TextView) this.v.findViewById(R.id.row_graph_subtitle);
            this.subtitle = textView2;
            textView2.setText("");
            this.starText = (TextView) this.v.findViewById(R.id.star);
            float rating = this.record.getRating();
            TextView textView3 = this.starText;
            if (rating > 0.0f) {
                textView3.setVisibility(0);
                this.starText.setText(String.valueOf(Math.round(this.record.getRating())));
            } else {
                textView3.setVisibility(8);
            }
            this.graph = (GraphView) this.v.findViewById(R.id.row_graph);
            SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(this.context);
            this.graph.resetIntervals();
            this.graph.setRotateYAxisLabels(false);
            this.graph.setDrawXAxis(false);
            if ((SharedApplicationContext.getSettings().isHypnogramOverActigraph() || !this.record.hasActigraph()) && this.record.hasHypnogram()) {
                this.graph.setEquidistantValues(new float[0], this.record.shouldUseExactFitView());
                sleepGraphInitializer.initHypnogram(this.graph, this.record);
                sleepGraphInitializer.populateHypnogramOrPhases(this.context, this.graph, this.record);
            } else {
                sleepGraphInitializer.initActigraph(this.graph, this.record);
                this.graph.setDrawAverage(false);
                this.graph.setDrawYAxis(false);
                this.graph.setDoDrawGraphLine(false);
                this.graph.setDrawGraph(true);
                this.graph.setEquidistantValues(this.history, false);
                this.graph.setXAxisLabels(null);
                this.graph.setDrawXAxis(false);
            }
            ImageView imageView = (ImageView) this.v.findViewById(R.id.row_graph_tags);
            this.tagView = imageView;
            imageView.setVisibility(4);
            this.tagView.setImageResource(R.drawable.empty_ab);
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            this.axis = this.record.getTo() != null ? new TimeAxisLabels(this.context, this.record.getFrom(), this.record.getTo(), this.record.getTimezone(), this.history.size()) : null;
            this.titleText = new SleepRecordStringBuilder(this.context).setAppendWeekDay(true).setAppendRange(false).setAppendYearIfOld(true).setAppendDuration(false).build(this.record);
            this.subtitleText = new SleepRecordStringBuilder(this.context).setAppendDay(false).setAppendLength(true).appendSpaceAfterDuration(true).setAppendRange(true).build(this.record);
            Set<String> tags = this.record.getTags(Tag.TAG_QUANTITY_VALUE_PATTERN);
            this.tags = tags;
            this.tagBitmap = Tag.tagToBitmap(this.context, tags, true, false);
            String tagFilteredComment = this.record.getTagFilteredComment();
            this.tagFilteredComment = tagFilteredComment;
            if (tagFilteredComment != null) {
                this.tagFilteredComment = tagFilteredComment.trim();
            }
            String str = this.tagFilteredComment;
            this.htmlTags = (str == null || str.length() == 0) ? null : Html.fromHtml(this.tagFilteredComment);
            return null;
        }

        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r5) {
            if (!GraphListCursorAdapter.this.refreshTasksInProgress.remove(this)) {
                Logger.logSevere("Inconsistent refresh task queue!!");
            }
            if (this.v.getTag() != this.record) {
                return;
            }
            this.graph = (GraphView) this.v.findViewById(R.id.row_graph);
            if (this.record.getTo() != null) {
                this.graph.setXAxisLabels(this.axis);
                this.graph.setDrawXAxis(false);
            }
            TextView textView = (TextView) this.v.findViewById(R.id.titleTextGraph);
            this.title = textView;
            textView.setText(this.titleText);
            this.subtitle = (TextView) this.v.findViewById(R.id.row_graph_subtitle);
            String str = this.tagFilteredComment;
            if (str == null || str.length() <= 0) {
                this.subtitle.setText(this.subtitleText);
            } else {
                this.subtitle.setText(this.subtitleText + "   " + this.tagFilteredComment);
            }
            this.tagView = (ImageView) this.v.findViewById(R.id.row_graph_tags);
            Set<String> set = this.tags;
            if (set == null || set.size() <= 0) {
                this.tagView.setVisibility(4);
                this.tagView.setImageResource(R.drawable.empty_ab);
                return;
            }
            Drawable drawable = this.tagBitmap;
            ImageView imageView = this.tagView;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.tagView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
                this.tagView.setImageResource(R.drawable.empty_ab);
            }
        }
    }

    public GraphListCursorAdapter(Activity activity, DbSleepRecordRepository dbSleepRecordRepository, ViewGroup viewGroup) {
        super((Context) activity, openCursor(dbSleepRecordRepository, ""), false);
        this.selectedDay = null;
        this.scrollState = 0;
        this.recordsCount = -1;
        this.refreshTasksInProgress = new LinkedList<>();
        this.pendingRefreshTasks = new BoundedLinkedList<>(10);
        this.context = activity;
        this.dbSleepRecordRepository = dbSleepRecordRepository;
        this.rootView = viewGroup;
        this.clickHandler = new GraphListClickHandler(activity, this) { // from class: com.urbandroid.sleep.gui.GraphListCursorAdapter.1
            @Override // com.urbandroid.sleep.gui.GraphListClickHandler
            public SleepRecord getRecordFromItem(View view, int i) {
                return (SleepRecord) view.getTag();
            }
        };
        this.cutOffHour = new Settings(activity).getDayCutOffHour();
    }

    private static Cursor openCursor(DbSleepRecordRepository dbSleepRecordRepository, final String str) {
        return dbSleepRecordRepository.executeRead(new IPersistentReadOperation() { // from class: com.urbandroid.sleep.gui.GraphListCursorAdapter.2
            @Override // com.urbandroid.sleep.persistence.IPersistentReadOperation
            public Cursor execute(SQLiteDatabase sQLiteDatabase) {
                SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
                sQLiteQueryBuilder.setTables("records");
                SharedApplicationContext.getInstance().incPendingDbOperations();
                String str2 = str;
                return new CursorWrapper((str2 == null || str2.trim().length() <= 0) ? sQLiteQueryBuilder.query(sQLiteDatabase, null, null, null, null, null, "startTime DESC") : sQLiteQueryBuilder.query(sQLiteDatabase, null, "comment like ?", new String[]{FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("%"), str, "%")}, null, null, "startTime DESC")) { // from class: com.urbandroid.sleep.gui.GraphListCursorAdapter.2.1
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
    }

    private void updateHeader() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.no_records);
            View viewFindViewById = this.rootView.findViewById(R.id.history_list_parent);
            String str = this.filterString;
            boolean z = str == null || "".equals(str);
            int count = getCursor().getCount();
            if (count == 0 && z) {
                viewGroup2.setVisibility(0);
                viewFindViewById.setVisibility(8);
                return;
            }
            viewGroup2.setVisibility(8);
            viewFindViewById.setVisibility(0);
            if (this.recordsCount == -1 && z) {
                this.recordsCount = count;
                Logger.logInfo("GraphListCursorAdapter: setting records count " + count);
                SharedApplicationContext.getSettings().setRecordsCount(count);
            }
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        populateViewWithSleepRecordOptimized(context, view, cursor);
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void filter(IFilterListAdapter.IFilter iFilter) {
        String filterString = iFilter.getFilterString();
        this.filterString = filterString;
        changeCursor(openCursor(this.dbSleepRecordRepository, filterString));
        updateHeader();
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return View.inflate(context, R.layout.row_card_sleep_record, null);
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void notifyChanged() {
        changeCursor(openCursor(this.dbSleepRecordRepository, this.filterString));
        updateHeader();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.clickHandler.onItemClick(adapterView, view, i, j);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.clickHandler.onItemLongClick(adapterView, view, i, j);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.scrollState == 2 && i != 2) {
            for (ViewRefreshTask viewRefreshTask : this.pendingRefreshTasks) {
                this.refreshTasksInProgress.add(viewRefreshTask);
                viewRefreshTask.execute(new Object[0]);
            }
            this.pendingRefreshTasks.clear();
        }
        this.scrollState = i;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void pause() {
        if (getCursor().isClosed()) {
            return;
        }
        getCursor().close();
    }

    public void populateViewWithSleepRecordOptimized(Context context, View view, Cursor cursor) {
        if (view != null) {
            ViewRefreshTask viewRefreshTask = new ViewRefreshTask(view, cursor, context);
            if (this.scrollState == 2 && this.refreshTasksInProgress.size() >= 5) {
                this.pendingRefreshTasks.add(viewRefreshTask);
            } else {
                this.refreshTasksInProgress.add(viewRefreshTask);
                viewRefreshTask.execute(new Object[0]);
            }
        }
    }
}

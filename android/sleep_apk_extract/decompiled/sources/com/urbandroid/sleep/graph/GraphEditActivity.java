package com.urbandroid.sleep.graph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.view.ActionMode;
import com.google.android.material.snackbar.Snackbar;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.NoiseActivity;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.domain.undo.BaseUndoOperation;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.graph.IntervalStyle;
import com.urbandroid.sleep.gui.ImageCreator;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.gui.view.PieView;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.media.PlayAudioActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.Experiments;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class GraphEditActivity extends BaseActivity implements View.OnTouchListener, MediaPlayer.OnCompletionListener {
    private ActionMode actionMode;
    MenuItem awakeMenuItem;
    MenuItem cutMenuItem;
    private SleepRecord displayedRecord;
    private GraphElementToggleSection graphElementToggleSection;
    private Handler handler;
    private ViewGroup mainLayout;
    private Collection<Interval> noiseIntervals;
    private List<Noise> noisesToBePlayed;
    MenuItem playMenuItem;
    private String shareFileName;
    private GraphViewMap graphs = new GraphViewMap();
    private boolean editMode = false;
    private boolean noKeyguard = false;
    private Runnable zoomInRunnable = new Runnable() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            GraphView firstVisible = GraphEditActivity.this.graphs.getFirstVisible();
            if (firstVisible.isSelection()) {
                float selectPoint1Percent = firstVisible.getSelectPoint1Percent();
                float selectPoint2Percent = firstVisible.getSelectPoint2Percent();
                float fMin = Math.min(firstVisible.getSelectPoint1(), firstVisible.getSelectPoint2());
                float fMax = Math.max(firstVisible.getSelectPoint1(), firstVisible.getSelectPoint2());
                boolean z2 = true;
                if (firstVisible.getZoomPoint1() == -1.0f) {
                    GraphEditActivity.this.graphs.setZoomPoint1(0.0f);
                    z = true;
                } else {
                    z = false;
                }
                if (firstVisible.getZoomPoint2() == -1.0f) {
                    GraphEditActivity.this.graphs.setZoomPoint2(firstVisible.getWidth());
                    z = true;
                }
                if (fMin - ActivityUtils.getDip(GraphEditActivity.this, 64) > firstVisible.getZoomPoint1()) {
                    GraphEditActivity.this.graphs.setZoomPoint1(firstVisible.getZoomPoint1() + ActivityUtils.getDip(GraphEditActivity.this, 24));
                    z = true;
                }
                if (fMax + ActivityUtils.getDip(GraphEditActivity.this, 64) < firstVisible.getZoomPoint2()) {
                    GraphEditActivity.this.graphs.setZoomPoint2(firstVisible.getZoomPoint2() - ActivityUtils.getDip(GraphEditActivity.this, 24));
                } else {
                    z2 = z;
                }
                GraphEditActivity.this.graphs.setSelectionPoint1Percentage(selectPoint1Percent);
                GraphEditActivity.this.graphs.setSelectionPoint2Percentage(selectPoint2Percent);
                GraphEditActivity.this.graphs.invalidate();
                if (firstVisible.getZoomPercentage() >= 0.3f ? z2 : false) {
                    GraphEditActivity.this.handler.postDelayed(this, 20L);
                }
            }
        }
    };
    private ViewGroup titleTime = null;
    private boolean refreshAfterResume = false;
    private MediaPlayer player = null;
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.7
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return GraphEditActivity.this.handleMenuAction(menuItem.getItemId());
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.detail_select_menu, menu);
            GraphEditActivity.this.cutMenuItem = menu.findItem(R.id.menu_delete_selected);
            GraphEditActivity.this.playMenuItem = menu.findItem(R.id.menu_play_selected);
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_add_awake_selected);
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_delete_awake_selected);
            GraphEditActivity.this.awakeMenuItem = menu.findItem(R.id.menu_awake);
            menuItemFindItem.setTitle(GraphEditActivity.this.getString(R.string.menu_add) + " " + GraphEditActivity.this.getString(R.string.awake).toLowerCase());
            menuItemFindItem2.setTitle(GraphEditActivity.this.getString(R.string.delete) + " " + GraphEditActivity.this.getString(R.string.awake).toLowerCase());
            GraphEditActivity.this.playMenuItem.setVisible(false);
            GraphEditActivity.this.cutMenuItem.setVisible(false);
            GraphEditActivity.this.awakeMenuItem.setVisible(false);
            actionMode.setTitle(R.string.graph_edit_hint);
            GraphEditActivity.this.showAddSleep(false);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            GraphEditActivity.this.cancelSelect();
            GraphEditActivity.this.showAddSleep(true);
            View viewFindViewById = GraphEditActivity.this.findViewById(R.id.topGap);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            View viewFindViewById2 = GraphEditActivity.this.findViewById(R.id.bottomGap);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(0);
            }
            GraphEditActivity.this.actionMode = null;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    };

    public static class GraphDetailViewInitializer {
        private Context context;
        private boolean showNoises = true;
        private boolean dbUpdateAllowed = true;
        private boolean doDpi = true;

        public GraphDetailViewInitializer(Context context) {
            this.context = context;
        }

        private void initGraphs(ViewGroup viewGroup, SleepRecord sleepRecord, GraphViewMap graphViewMap, Collection<Noise> collection, boolean z) {
            float quality = sleepRecord.getQuality();
            float noiseLevel = sleepRecord.getNoiseLevel();
            float size = sleepRecord.getEvents().size();
            sleepRecord.computeAll();
            sleepRecord.computeNoiseLevel();
            boolean z2 = false;
            if (((quality != sleepRecord.getQuality() && sleepRecord.getQuality() > 0.0f) || ((noiseLevel != sleepRecord.getNoiseLevel() && sleepRecord.getNoiseLevel() > 0.0f) || size != sleepRecord.getEvents().size())) && z) {
                SharedApplicationContext.getInstance().getSleepRecordRepository().recordDataUpdated(sleepRecord, new SleepRecord(sleepRecord, false), new UndoOperationGroup("IGNORE", null));
            }
            GraphView graphView = graphViewMap.get(R.id.graph);
            GraphView graphView2 = graphViewMap.get(R.id.noise_graph);
            graphView2.setForceXAxisOffset(false);
            graphView2.setDoMirrorGraph(true);
            SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(this.context);
            sleepGraphInitializer.init(graphViewMap, sleepRecord);
            sleepGraphInitializer.getGraphs().get(R.id.hypnogram).setDoGradient(false);
            try {
                Logger.logInfo("add sun label " + sleepRecord.getGeo() + " " + sleepRecord.getTimezone());
                if (sleepRecord.getGeo() != null && sleepRecord.getTimezone() != null) {
                    Location locationComputeLocation = LocationService.computeLocation(sleepRecord.getGeo());
                    Logger.logInfo("add sun label " + locationComputeLocation);
                    if (locationComputeLocation != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(sleepRecord.getTo());
                        GraphEditActivity.addSunLabel(graphView, sleepRecord, new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(locationComputeLocation.getLat(), locationComputeLocation.getLon()), DesugarTimeZone.getTimeZone(sleepRecord.getTimezone())).getOfficialSunriseCalendarForDate(calendar));
                        calendar.setTime(sleepRecord.getFrom());
                        GraphEditActivity.addSunLabel(graphView, sleepRecord, new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(locationComputeLocation.getLat(), locationComputeLocation.getLon()), DesugarTimeZone.getTimeZone(sleepRecord.getTimezone())).getOfficialSunsetCalendarForDate(calendar));
                    }
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            if (this.showNoises && collection != null && collection.size() > 0) {
                if (sleepRecord.getFilteredNoiseHistory() != null && sleepRecord.getFilteredNoiseHistory().size() != 0) {
                    z2 = true;
                }
                ArrayList arrayList = new ArrayList();
                for (Noise noise : collection) {
                    arrayList.add(new Interval(noise.getFrom().getTime(), noise.getTo().getTime()));
                }
                Context context = this.context;
                if (context instanceof GraphEditActivity) {
                    ((GraphEditActivity) context).setNoiseIntervals(arrayList);
                }
                if (z2) {
                    graphView2.setSelectableIntervals(arrayList);
                    graphView2.addIntervalPresentation(new IntervalStyle(GraphLegend.NOISE_RECORDING.eventLabelName(), arrayList).setDrawable(R.drawable.ic_action_mic).setStroke(2).setOffset(30).setStyle(IntervalStyle.Style.LINE).setColor(ColorUtil.i(viewGroup.getContext(), R.color.primary_icon_solid)));
                } else {
                    graphView.setSelectableIntervals(arrayList);
                    graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.NOISE_RECORDING.eventLabelName(), arrayList).setDrawable(R.drawable.ic_action_mic).setStroke(2).setOffset(30).setStyle(IntervalStyle.Style.LINE).setColor(ColorUtil.i(viewGroup.getContext(), R.color.primary_icon_solid)));
                }
            }
            GraphEditActivity.loadPieForSameDayRecord(this.context, sleepRecord, SharedApplicationContext.getSettings().getDayCutOffHour(), (ViewGroup) viewGroup.findViewById(R.id.major_measures));
        }

        public void initialize(ViewGroup viewGroup, SleepRecord sleepRecord, GraphViewMap graphViewMap) {
            if (sleepRecord == null) {
                Logger.logWarning("HS1753 issue - for some reason record is null");
                return;
            }
            Collection<Noise> noisesForRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoisesForRecord(sleepRecord, null);
            graphViewMap.resetIntervals();
            graphViewMap.setDoDpi(this.doDpi);
            initGraphs(viewGroup, sleepRecord, graphViewMap, noisesForRecord, this.dbUpdateAllowed);
        }
    }

    private void addAwakeSelected() {
        if (this.displayedRecord.getTo() == null) {
            Logger.logSevere("GraphDetailActivity: no TO for record " + this.displayedRecord);
            return;
        }
        Interval selectionTimes = getSelectionTimes();
        Logger.logInfo("GraphDetailActivity: add awake " + selectionTimes);
        if (selectionTimes == null) {
            return;
        }
        if (selectionTimes.getLength() <= 0) {
            Logger.logSevere("Delete selection is empty");
            return;
        }
        Logger.logInfo("Add awake to selection from " + selectionTimes.getFrom() + " to " + selectionTimes.getTo() + " record " + this.displayedRecord.getFrom().getTime() + " - " + this.displayedRecord.getTo().getTime());
        SleepRecord sleepRecord = new SleepRecord(this.displayedRecord, false);
        ArrayList<Interval> arrayList = new ArrayList();
        List<Event> copiedEvents = this.displayedRecord.getEvents().getCopiedEvents();
        EventLabel eventLabel = EventLabel.AWAKE_START;
        EventLabel eventLabel2 = EventLabel.AWAKE_END;
        List<EventInterval> eventIntervals = EventsUtil.getEventIntervals(copiedEvents, eventLabel, eventLabel2);
        this.displayedRecord.getEvents().clearLabels(eventLabel, eventLabel2);
        this.displayedRecord.getEvents().addEvent(this.displayedRecord.getFromTime(), EventLabel.NO_AWAKE);
        boolean z = false;
        for (EventInterval eventInterval : eventIntervals) {
            Interval union = eventInterval.toInterval().getUnion(selectionTimes);
            if (union != null) {
                arrayList.add(union);
                z = true;
            } else {
                arrayList.add(eventInterval.toInterval());
            }
        }
        if (!z) {
            arrayList.add(selectionTimes);
        }
        for (Interval interval : arrayList) {
            this.displayedRecord.addEventLabel(EventLabel.AWAKE_START, interval.getFrom());
            this.displayedRecord.addEventLabel(EventLabel.AWAKE_END, interval.getTo());
        }
        this.displayedRecord.mergeAwakeOverlaps();
        this.displayedRecord.computeLenAdjust();
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.menu_add) + " " + getString(R.string.awake).toLowerCase(), sleepRecord);
        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.4
            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
            public boolean undo() {
                zza$$ExternalSyntheticOutline0.m(GraphEditActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
                return true;
            }
        });
        SharedApplicationContext.getInstance().recordDataUpdated(sleepRecord, new SleepRecord(this.displayedRecord, false), undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        showUndoToast();
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_GRAPH_CHANGED");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addSunLabel(GraphView graphView, SleepRecord sleepRecord, Calendar calendar) {
        Interval interval = new Interval(sleepRecord.getFrom().getTime(), sleepRecord.getTo().getTime());
        Logger.logInfo("add sun label interval " + interval + " " + calendar.getTime() + " is in " + interval.isIn(calendar.getTimeInMillis()));
        if (interval.isIn(calendar.getTimeInMillis())) {
            Logger.logInfo("add sun label " + calendar.getTime());
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.SUNRISE.eventLabelName(), new Interval(calendar.getTime().getTime(), calendar.getTime().getTime())).setDrawable(R.drawable.ic_action_sunrise).setStroke(2).setStyle(IntervalStyle.Style.MARKER).setOffset(45));
        }
    }

    private void buildFromIntent(Intent intent) {
        this.displayedRecord = (SleepRecord) getIntent().getParcelableExtra("SleepRecord");
        if (getIntent() != null && getIntent().hasExtra("keyguard")) {
            KeyguardUtil.disable(this);
            this.noKeyguard = true;
        }
        if (this.displayedRecord == null) {
            Logger.logWarning("No record in GDA");
            setResultAndFinish(null);
            return;
        }
        SleepRecord sleepRecordLoadFullRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().loadFullRecord(this.displayedRecord.getFrom().getTime());
        if (sleepRecordLoadFullRecord != null) {
            this.displayedRecord = sleepRecordLoadFullRecord;
        }
        if ((getResources().getConfiguration().screenLayout & 15) != 3) {
        }
        int i = getResources().getConfiguration().orientation;
        GraphViewMap graphViewMap = new GraphViewMap();
        this.graphs = graphViewMap;
        graphViewMap.add(R.id.hypnogram, (GraphView) findViewById(R.id.hypnogram));
        this.graphs.add(R.id.noise_graph, (GraphView) findViewById(R.id.noise_graph));
        this.graphs.add(R.id.sensor_graph, (GraphView) findViewById(R.id.sensor_graph));
        this.graphs.add(R.id.graph, (GraphView) findViewById(R.id.graph));
        this.graphs.setOnTouchListener(this);
        this.mainLayout = (ViewGroup) findViewById(R.id.root);
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
        if (this.displayedRecord.getTo() == null) {
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Graph with NULL TO: " + this.displayedRecord);
        }
        showAddSleep(true);
        this.handler.postDelayed(new GraphEditActivity$$ExternalSyntheticLambda0(this, 0), 800L);
        if (TrialFilter.getInstance().isHideSleepAnalysis(this.displayedRecord)) {
            UnlockFlow.showUnlockDialog(this, true);
        }
        GraphElementToggleSection graphElementToggleSection = new GraphElementToggleSection(this, this.displayedRecord, this.graphs);
        this.graphElementToggleSection = graphElementToggleSection;
        graphElementToggleSection.setMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelSelect() {
        this.graphs.clearSelect();
        if (this.displayedRecord.getTo() != null) {
            this.graphs.setXAxisLabels(new TimeAxisLabels(getContext(), this.displayedRecord.getFrom(), this.displayedRecord.getTo(), this.displayedRecord.getTimezone(), this.displayedRecord.getHistory().size()));
        }
    }

    private void delete() {
        new Settings(getApplicationContext()).decRecordsCount();
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.deleted), new SleepRecord(this.displayedRecord, false));
        SharedApplicationContext.getInstance().deleteRecord(this.displayedRecord, undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        setResultAndFinish(null);
    }

    private void deleteAwakeSelected() {
        if (this.displayedRecord.getTo() == null) {
            Logger.logSevere("GraphDetailActivity: no TO for record " + this.displayedRecord);
            return;
        }
        Interval selectionTimes = getSelectionTimes();
        Logger.logInfo("GraphDetailActivity: add awake " + selectionTimes);
        if (selectionTimes == null) {
            return;
        }
        if (selectionTimes.getLength() <= 0) {
            Logger.logSevere("Delete selection is empty");
            return;
        }
        Logger.logInfo("Delete awake to selection from " + selectionTimes.getFrom() + " to " + selectionTimes.getTo() + " record " + this.displayedRecord.getFrom().getTime() + " - " + this.displayedRecord.getTo().getTime());
        SleepRecord sleepRecord = new SleepRecord(this.displayedRecord, false);
        ArrayList<Interval> arrayList = new ArrayList();
        List<Event> copiedEvents = this.displayedRecord.getEvents().getCopiedEvents();
        EventLabel eventLabel = EventLabel.AWAKE_START;
        EventLabel eventLabel2 = EventLabel.AWAKE_END;
        List<EventInterval> eventIntervals = EventsUtil.getEventIntervals(copiedEvents, eventLabel, eventLabel2);
        this.displayedRecord.getEvents().clearLabels(eventLabel, eventLabel2);
        this.displayedRecord.getEvents().addEvent(this.displayedRecord.getFromTime(), EventLabel.NO_AWAKE);
        Iterator<EventInterval> it = eventIntervals.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().toInterval().subtract(selectionTimes));
        }
        for (Interval interval : arrayList) {
            this.displayedRecord.addEventLabel(EventLabel.AWAKE_START, interval.getFrom());
            this.displayedRecord.addEventLabel(EventLabel.AWAKE_END, interval.getTo());
        }
        this.displayedRecord.mergeAwakeOverlaps();
        this.displayedRecord.computeLenAdjust();
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.delete) + " " + getString(R.string.awake).toLowerCase(), sleepRecord);
        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.3
            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
            public boolean undo() {
                zza$$ExternalSyntheticOutline0.m(GraphEditActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
                return true;
            }
        });
        SharedApplicationContext.getInstance().recordDataUpdated(sleepRecord, new SleepRecord(this.displayedRecord, false), undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        showUndoToast();
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_GRAPH_CHANGED");
    }

    private void deleteSelected() {
        if (this.displayedRecord.getTo() == null) {
            Logger.logSevere("no TO for record " + this.displayedRecord);
            return;
        }
        Interval selectionTimes = getSelectionTimes();
        if (selectionTimes == null) {
            return;
        }
        if (selectionTimes.getFrom() <= this.displayedRecord.getFrom().getTime() && selectionTimes.getTo() >= this.displayedRecord.getTo().getTime()) {
            delete();
            return;
        }
        if (selectionTimes.getLength() <= 0) {
            Logger.logSevere("Delete selection is empty");
            return;
        }
        Logger.logInfo("Delete selection from " + selectionTimes.getFrom() + " to " + selectionTimes.getTo() + " record " + this.displayedRecord.getFrom().getTime() + " - " + this.displayedRecord.getTo().getTime());
        SleepRecord sleepRecord = new SleepRecord(this.displayedRecord, false);
        this.displayedRecord.deleteSelection(selectionTimes.getFrom(), selectionTimes.getTo());
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.deleted), sleepRecord);
        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.2
            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
            public boolean undo() {
                zza$$ExternalSyntheticOutline0.m(GraphEditActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
                return true;
            }
        });
        SharedApplicationContext.getInstance().recordDataUpdated(sleepRecord, new SleepRecord(this.displayedRecord, false), undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        showUndoToast();
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_GRAPH_CHANGED"));
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
    }

    private void finishActionMode() {
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.titleTime = null;
            this.actionMode = null;
        }
    }

    private long fixSelectionRange(SleepRecord sleepRecord, long j) {
        long time = sleepRecord.getFrom().getTime();
        long time2 = sleepRecord.getTo().getTime();
        if (j - time < 120000) {
            j = time;
        } else if (time2 - j < 120000) {
            j = time2;
        }
        return Math.min(Math.max(j, time), time2);
    }

    private Context getContext() {
        return this;
    }

    private Interval getInterval(float f, float f2) {
        if (f == -1.0f || f2 == -1.0f) {
            return null;
        }
        long time = this.displayedRecord.getTo().getTime() - this.displayedRecord.getFrom().getTime();
        SleepRecord sleepRecord = this.displayedRecord;
        float f3 = time;
        long jFixSelectionRange = fixSelectionRange(sleepRecord, sleepRecord.getFrom().getTime() + ((long) Math.round(f * f3)));
        SleepRecord sleepRecord2 = this.displayedRecord;
        return new Interval(jFixSelectionRange, fixSelectionRange(sleepRecord2, sleepRecord2.getFrom().getTime() + ((long) Math.round(f2 * f3))));
    }

    private Interval getSelectionTimes() {
        return getInterval(Math.min(this.graphs.getFirstVisible().getSelectPoint1Percent(), this.graphs.getFirstVisible().getSelectPoint2Percent()), Math.max(this.graphs.getFirstVisible().getSelectPoint1Percent(), this.graphs.getFirstVisible().getSelectPoint2Percent()));
    }

    public static Intent getStartIntent(Context context, SleepRecord sleepRecord, boolean z) {
        Intent intent = new Intent(context, (Class<?>) GraphEditActivity.class);
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        if (z) {
            intent.putExtra("keyguard", true);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMenuAction(int i) {
        switch (i) {
            case android.R.id.home:
                Logger.logSevere("SleepDetailActivity: Back " + this.displayedRecord);
                setResultAndFinish(this.displayedRecord);
                return true;
            case R.id.menu_add_awake_selected /* 2131362509 */:
                Logger.logInfo("Adding awake to graph");
                addAwakeSelected();
                refresh();
                return true;
            case R.id.menu_copy_record /* 2131362518 */:
                String strSerialize = this.displayedRecord.serialize();
                if (strSerialize != null) {
                    ((ClipboardManager) getSystemService("clipboard")).setText(strSerialize);
                }
                return true;
            case R.id.menu_noise /* 2131362541 */:
                if (this.displayedRecord.getTo() != null) {
                    Intent intent = new Intent(this, (Class<?>) NoiseActivity.class);
                    intent.putExtra("noise_from", this.displayedRecord.getFrom().getTime());
                    intent.putExtra("noise_to", this.displayedRecord.getTo().getTime());
                    intent.putExtra("noise_timezone", this.displayedRecord.getTimezone());
                    startActivity(intent);
                }
                return true;
            case R.id.menu_play_selected /* 2131362544 */:
                Interval selectionTimes = getSelectionTimes();
                if (selectionTimes == null) {
                    return false;
                }
                List<Noise> noises = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, selectionTimes.getFrom(), selectionTimes.getTo());
                if (noises.size() > 0) {
                    int size = noises.size();
                    long[] jArr = new long[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        jArr[i2] = noises.get(i2).getId().longValue();
                    }
                    Intent intent2 = new Intent(this, (Class<?>) PlayAudioActivity.class);
                    intent2.putExtra("noise_ids", jArr);
                    startActivity(intent2);
                } else {
                    Toast.makeText(this, R.string.no_recordings, 0).show();
                }
                return true;
            case R.id.menu_undo /* 2131362558 */:
                performUndo();
                return true;
            case R.id.share_action_provider /* 2131362928 */:
                this.shareFileName = "graph_detail_" + DateUtil.getDatetimestamp(this.displayedRecord.getFrom()) + ".png";
                try {
                    ShareDataUtil.saveData(this, this.shareFileName, ImageCreator.convertBitmapIntoPNGBytes(ImageCreator.createBitmapWithLogo(findViewById(R.id.graph_wrapper), R.color.bg_card)));
                    startActivity(ShareDataUtil.createIntent(this, this.shareFileName, new SleepRecordStringBuilder(getApplicationContext()).setPrependSleep(true).setAppendAppName(true).setAppendMeasures(true, Measure.ALL_MEASURES).build(this.displayedRecord)));
                    break;
                } catch (IOException e) {
                    Logger.logSevere(e);
                    Toast.makeText(this, R.string.save_to_card_failed, 0).show();
                }
                return true;
            default:
                switch (i) {
                    case R.id.menu_delete /* 2131362520 */:
                        delete();
                        return true;
                    case R.id.menu_delete_awake /* 2131362521 */:
                        SleepRecord sleepRecord = new SleepRecord(this.displayedRecord, false);
                        this.displayedRecord.getEvents().clearLabels(EventLabel.AWAKE_START, EventLabel.AWAKE_END);
                        this.displayedRecord.getEvents().clearLabels(EventLabel.WALKING_START, EventLabel.WALKING_END);
                        this.displayedRecord.getEvents().clearLabels(EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED);
                        this.displayedRecord.getEvents().addEvent(this.displayedRecord.getFromTime(), EventLabel.NO_AWAKE);
                        this.displayedRecord.computeLenAdjust();
                        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.delete) + " " + getString(R.string.awake), sleepRecord);
                        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.6
                            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
                            public boolean undo() {
                                zza$$ExternalSyntheticOutline0.m(GraphEditActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
                                return true;
                            }
                        });
                        SharedApplicationContext.getInstance().recordDataUpdated(sleepRecord, new SleepRecord(this.displayedRecord, false), undoOperationGroup);
                        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
                        showUndoToast();
                        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
                        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_GRAPH_CHANGED"));
                        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
                        return true;
                    case R.id.menu_delete_awake_selected /* 2131362522 */:
                        Logger.logInfo("Deleting awake to graph");
                        deleteAwakeSelected();
                        refresh();
                        return true;
                    case R.id.menu_delete_location /* 2131362523 */:
                        SleepRecord sleepRecord2 = new SleepRecord(this.displayedRecord, false);
                        sleepRecord2.setGeo(null);
                        UndoOperationGroup undoOperationGroup2 = new UndoOperationGroup(getString(R.string.delete_location), this.displayedRecord);
                        SharedApplicationContext.getInstance().recordDataUpdated(this.displayedRecord, sleepRecord2, undoOperationGroup2);
                        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup2);
                        showUndoToast();
                        setResultAndFinish(sleepRecord2);
                        return true;
                    case R.id.menu_delete_selected /* 2131362524 */:
                        Logger.logInfo("Deleting selected portion of graph");
                        deleteSelected();
                        refresh();
                        finishActionMode();
                        return true;
                    case R.id.menu_doc /* 2131362525 */:
                        DocItemDialogFragment.newInstance("graph", null, null).show(getSupportFragmentManager(), "help");
                        return true;
                    case R.id.menu_edit_record /* 2131362526 */:
                        EditActivity.showRatingForResult(this, this.displayedRecord, this.noKeyguard);
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAddSleep$0(View view) {
        NewAddRecordActivity.start(this, this.displayedRecord.getFromTime() - 3600000, this.displayedRecord.getFromTime() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAddSleep$1(View view) {
        NewAddRecordActivity.start(this, this.displayedRecord.getToTime() + 1, this.displayedRecord.getToTime() + 3600000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUndoToast$4(View view) {
        performUndo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$startActionMode$2(TextView textView, int i, KeyEvent keyEvent) {
        updateSelectionFromTitleTime();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$startActionMode$3(TextView textView, int i, KeyEvent keyEvent) {
        updateSelectionFromTitleTime();
        return true;
    }

    public static void loadPieForSameDayRecord(final Context context, final SleepRecord sleepRecord, int i, final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        new AsyncTask<Void, Void, List<SleepRecord>>() { // from class: com.urbandroid.sleep.graph.GraphEditActivity.5
            @Override // android.os.AsyncTask
            public List<SleepRecord> doInBackground(Void... voidArr) {
                return SharedApplicationContext.getInstance().getSleepRecordRepository().getPrevNextSleepRecords(sleepRecord);
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(List<SleepRecord> list) {
                super.onPostExecute(list);
                ViewGroup viewGroup2 = viewGroup;
                viewGroup2.removeAllViews();
                PieView.Companion companion = PieView.INSTANCE;
                Context context2 = context;
                SleepRecord sleepRecord2 = sleepRecord;
                SleepScore.ScoreMeasure[] scoreMeasureArr = GraphDetailsActivity.ALL_MEASURES;
                Iterator<PieView> it = companion.getViewsForSleepRecord(R.layout.view_pie_small, context2, sleepRecord2, list, Arrays.asList(scoreMeasureArr), scoreMeasureArr.length, -1, false, R.layout.view_pie_score_small).iterator();
                while (it.hasNext()) {
                    viewGroup2.addView(it.next());
                }
            }
        }.execute(new Void[0]);
    }

    private void performUndo() {
        SleepRecord sleepRecordPerformUndo = SharedApplicationContext.getInstance().getSleepRecordRepository().performUndo();
        if (sleepRecordPerformUndo == null) {
            setResultAndFinish(null);
        } else {
            this.displayedRecord = sleepRecordPerformUndo;
            new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
            this.graphs.invalidate();
        }
        refresh();
    }

    private void refresh() {
        loadPieForSameDayRecord(this, this.displayedRecord, SharedApplicationContext.getSettings().getDayCutOffHour(), (ViewGroup) findViewById(R.id.major_measures));
    }

    private void removeGraphEditOnboarding() {
        new Settings(this).addShowCaseShown("sc_graph_detail_edit");
        View viewFindViewById = findViewById(R.id.slide_hint);
        if (viewFindViewById == null || viewFindViewById.getVisibility() != 0) {
            return;
        }
        viewFindViewById.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade));
        viewFindViewById.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSelectHint() {
        View viewFindViewById = findViewById(R.id.select_hint);
        if (viewFindViewById == null || viewFindViewById.getVisibility() != 0) {
            return;
        }
        viewFindViewById.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade));
        viewFindViewById.setVisibility(8);
    }

    private void setResultAndFinish(SleepRecord sleepRecord) {
        Intent intent = new Intent();
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
        setResult(1, intent);
        Logger.logSevere("SleepDetailActivity: Set result and finish " + this.displayedRecord);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAddSleep(boolean z) {
        findViewById(R.id.add_button_before).setVisibility(z ? 0 : 8);
        findViewById(R.id.add_button_before).setOnClickListener(new GraphEditActivity$$ExternalSyntheticLambda3(this, 1));
        findViewById(R.id.add_button_after).setVisibility(z ? 0 : 8);
        findViewById(R.id.add_button_after).setOnClickListener(new GraphEditActivity$$ExternalSyntheticLambda3(this, 2));
    }

    private void showUndoToast() {
        UndoOperationGroup currentUndoOperation = SharedApplicationContext.getInstance().getSleepRecordRepository().getCurrentUndoOperation();
        if (currentUndoOperation == null) {
            return;
        }
        Snackbar.make(findViewById(R.id.root), currentUndoOperation.getName(), getResources().getString(R.string.delete).equals(currentUndoOperation.getName()) ? -2 : 0).setAction(R.string.undo, new GraphEditActivity$$ExternalSyntheticLambda3(this, 0)).show();
    }

    private void startActionMode() {
        if (this.actionMode != null || this.graphs.get(R.id.graph).isZoom()) {
            return;
        }
        this.actionMode = startSupportActionMode(this.actionModeCallback);
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.title_edit_times, (ViewGroup) null);
        this.titleTime = viewGroup;
        final int i = 0;
        ((EditText) viewGroup.findViewById(R.id.title_time_from)).setOnEditorActionListener(new TextView.OnEditorActionListener(this) { // from class: com.urbandroid.sleep.graph.GraphEditActivity$$ExternalSyntheticLambda1
            public final /* synthetic */ GraphEditActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                int i3 = i;
                GraphEditActivity graphEditActivity = this.f$0;
                switch (i3) {
                    case 0:
                        return graphEditActivity.lambda$startActionMode$2(textView, i2, keyEvent);
                    default:
                        return graphEditActivity.lambda$startActionMode$3(textView, i2, keyEvent);
                }
            }
        });
        final int i2 = 1;
        ((EditText) this.titleTime.findViewById(R.id.title_time_to)).setOnEditorActionListener(new TextView.OnEditorActionListener(this) { // from class: com.urbandroid.sleep.graph.GraphEditActivity$$ExternalSyntheticLambda1
            public final /* synthetic */ GraphEditActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i22, KeyEvent keyEvent) {
                int i3 = i2;
                GraphEditActivity graphEditActivity = this.f$0;
                switch (i3) {
                    case 0:
                        return graphEditActivity.lambda$startActionMode$2(textView, i22, keyEvent);
                    default:
                        return graphEditActivity.lambda$startActionMode$3(textView, i22, keyEvent);
                }
            }
        });
        ((TextView) this.titleTime.findViewById(R.id.title_time_duration)).setText(R.string.graph_edit_hint);
        ((TextView) this.titleTime.findViewById(R.id.title_time_duration)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.hint_touch_dn, 0);
        this.actionMode.setCustomView(this.titleTime);
    }

    public static void startForResult(Activity activity, SleepRecord sleepRecord, boolean z) {
        if (TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord)) {
            UnlockFlow.showUnlockDialog(activity, false);
            return;
        }
        Intent startIntent = getStartIntent(activity, sleepRecord, z);
        startIntent.setFlags(0);
        activity.startActivityForResult(startIntent, 1);
    }

    private void updateSelection() {
        Interval selectionTimes;
        if (getSupportActionBar() == null || this.displayedRecord.getTo() == null || (selectionTimes = getSelectionTimes()) == null || this.actionMode == null) {
            return;
        }
        ViewGroup viewGroup = this.titleTime;
        if (viewGroup != null) {
            ((TextView) viewGroup.findViewById(R.id.title_time_from)).setText(DateUtil.formatTimeNeverAmPm(this, selectionTimes.getFrom()));
            ((TextView) this.titleTime.findViewById(R.id.title_time_to)).setText(DateUtil.formatTimeNeverAmPm(this, selectionTimes.getTo()));
            ((TextView) this.titleTime.findViewById(R.id.title_time_duration)).setText(DateUtil.formatMinutes(Integer.valueOf((int) (selectionTimes.getLength() / 60000))));
            ((TextView) this.titleTime.findViewById(R.id.title_time_duration)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        MenuItem menuItem = this.cutMenuItem;
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
        MenuItem menuItem2 = this.awakeMenuItem;
        if (menuItem2 != null) {
            menuItem2.setVisible(true);
        }
        MenuItem menuItem3 = this.playMenuItem;
        if (menuItem3 != null) {
            menuItem3.setVisible(false);
            Collection<Interval> collection = this.noiseIntervals;
            if (collection != null) {
                Iterator<Interval> it = collection.iterator();
                while (it.hasNext()) {
                    if (it.next().hasIntersection(selectionTimes)) {
                        this.playMenuItem.setVisible(true);
                        return;
                    }
                }
            }
        }
    }

    private void updateSelectionFromTitleTime() {
        float f;
        try {
            ViewGroup viewGroup = this.titleTime;
            if (viewGroup != null) {
                String string = ((EditText) viewGroup.findViewById(R.id.title_time_from)).getText().toString();
                String string2 = ((EditText) this.titleTime.findViewById(R.id.title_time_to)).getText().toString();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(this.displayedRecord.getFrom());
                float toTime = (this.displayedRecord.getToTime() - this.displayedRecord.getFromTime()) / 1000.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = -1.0f;
                do {
                    if (calendar.getTimeInMillis() >= this.displayedRecord.getToTime() + 60000) {
                        break;
                    }
                    String timeNeverAmPm = DateUtil.formatTimeNeverAmPm(this, calendar.getTimeInMillis());
                    Logger.logInfo("......... " + timeNeverAmPm + " ? " + string + " | " + string2 + " " + f3 + " / " + toTime);
                    if (string.equals(timeNeverAmPm)) {
                        f4 = f3 / toTime;
                        Logger.logInfo("..... f% " + f4);
                    }
                    if (string2.equals(timeNeverAmPm)) {
                        f = f3 / toTime;
                        Logger.logInfo("..... t% " + f);
                        break;
                    }
                    calendar.add(13, 10);
                    f3 += 10.0f;
                } while (f3 <= 72000.0f);
                f = -1.0f;
                if (f4 > -1.0f && f == -1.0f) {
                    f = 1.0f;
                }
                if (f <= -1.0f || f4 != -1.0f) {
                    f2 = f4;
                }
                Logger.logInfo("..... f% " + f2);
                Logger.logInfo("..... t% " + f);
                if (f2 > -1.0f && f > -1.0f) {
                    this.graphs.clearSelect();
                    this.graphs.setSelectionPoint1Percentage(f2);
                    this.graphs.setSelectionPoint2Percentage(f);
                    this.graphs.invalidate();
                }
                updateSelection();
            }
        } catch (Exception e) {
            Logger.logSevere(e);
            updateSelection();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || !intent.hasExtra("SleepRecord")) {
            return;
        }
        this.displayedRecord = (SleepRecord) intent.getParcelableExtra("SleepRecord");
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        playNoise();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.bg_card));
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.graph_time_segments));
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_graph_edit);
        this.handler = new Handler();
        TintUtil.tint(this, ColorUtil.i(this, R.color.bg_card));
        ToolbarUtil.apply(this);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_card)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.edit_record);
        EdgeToEdgeUtil.insetsTop(findViewById(R.id.toolbar));
        EdgeToEdgeUtil.insetsBottom(findViewById(R.id.add_button_before));
        EdgeToEdgeUtil.insetsBottom(findViewById(R.id.add_button_after));
        buildFromIntent(getIntent());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        MenuUtil.showIcons(menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_delete_awake);
        menuItemFindItem.setTitle(getResources().getString(R.string.delete) + " " + getResources().getString(R.string.awake).toLowerCase());
        menuItemFindItem.setVisible(this.displayedRecord.getEvents().hasLabel(EventLabel.TRACKING_PAUSED) || this.displayedRecord.getEvents().hasLabel(EventLabel.AWAKE_START) || this.displayedRecord.getEvents().hasLabel(EventLabel.WALKING_START));
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_copy_record);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(Experiments.getInstance().isOurExperimentalPhone());
        }
        MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_delete_location);
        SleepRecord sleepRecord = this.displayedRecord;
        if (sleepRecord != null && sleepRecord.getGeo() != null) {
            menuItemFindItem3.setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        try {
            if (getSelectionTimes() == null) {
                return super.onKeyDown(i, keyEvent);
            }
            this.graphs.clearSelect();
            return true;
        } catch (Exception e) {
            Logger.logSevere(e);
            return true;
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        buildFromIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return handleMenuAction(menuItem.getItemId());
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        removeGraphEditOnboarding();
        stopPlayer();
        this.noisesToBePlayed = null;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        UndoOperationGroup currentUndoOperation = SharedApplicationContext.getInstance().getSleepRecordRepository().getCurrentUndoOperation();
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_undo);
        if (currentUndoOperation != null) {
            menuItemFindItem.setVisible(true);
            menuItemFindItem.setTitle(getString(R.string.undo) + " (" + currentUndoOperation.getName() + ")");
        } else {
            menuItemFindItem.setVisible(false);
        }
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.logInfo("GRAPHS: Resume set callback");
        if (this.refreshAfterResume) {
            this.refreshAfterResume = false;
            recreate();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("editMode", this.editMode);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (findViewById(R.id.scroll) != null) {
                findViewById(R.id.scroll).getClass();
                Events$$ExternalSyntheticBUOutline0.m();
                return false;
            }
            if (getSelectionTimes() == null) {
                startActionMode();
            }
            removeGraphEditOnboarding();
            this.graphs.selectDown(motionEvent.getX());
            updateSelection();
            return true;
        }
        if (motionEvent.getAction() == 2) {
            this.graphs.selectMove(motionEvent.getX());
            updateSelection();
            return true;
        }
        if (motionEvent.getAction() == 1) {
            if (!this.graphs.isZoom() && this.graphs.isSelection() && getSelectionTimes() != null && getSelectionTimes().getLength() > 60000) {
                if (getSelectionTimes() != null) {
                    View viewFindViewById = findViewById(R.id.topGap);
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                    View viewFindViewById2 = findViewById(R.id.bottomGap);
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(8);
                    }
                }
                if (this.displayedRecord.getTo() != null) {
                    this.graphs.setXAxisLabels(new TimeAxisLabels(getContext(), this.displayedRecord.getFrom(), this.displayedRecord.getTo(), this.displayedRecord.getTimezone(), this.displayedRecord.getHistory().size(), (getSelectionTimes().getLength() <= 0 || getSelectionTimes().getLength() >= 2700000) ? 30 : 15));
                }
                this.handler.removeCallbacks(this.zoomInRunnable);
                this.handler.post(this.zoomInRunnable);
                return true;
            }
            if (getSelectionTimes() != null && getSelectionTimes().getLength() <= 60000) {
                finishActionMode();
            }
        }
        return true;
    }

    public void playNoise() {
        List<Noise> list = this.noisesToBePlayed;
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            stopPlayer();
            MediaPlayer mediaPlayerCreate = MediaPlayer.create(this, Uri.parse(this.noisesToBePlayed.remove(0).getUri()));
            this.player = mediaPlayerCreate;
            mediaPlayerCreate.setOnCompletionListener(this);
            this.player.start();
        } catch (Throwable th) {
            Logger.logSevere(th);
        }
    }

    public void setNoiseIntervals(Collection<Interval> collection) {
        this.noiseIntervals = collection;
    }

    public void stopPlayer() {
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.player.stop();
            this.player.release();
        } catch (Exception e) {
            Logger.logSevere("" + e.getClass());
            Logger.logSevere(e);
        }
    }
}

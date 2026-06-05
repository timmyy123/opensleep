package com.urbandroid.sleep.graph;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.text.Html;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.material.snackbar.Snackbar;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.GraphActivity;
import com.urbandroid.sleep.alarmclock.NoiseActivity;
import com.urbandroid.sleep.alarmclock.settings.SocialSettingsActivity;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.undo.BaseUndoOperation;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.graph.IntervalStyle;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.gui.view.PieView;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.media.PlayAudioActivity;
import com.urbandroid.sleep.persistence.SleepRecordCsvMapper;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.ShareAfterDismissService;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import com.urbandroid.util.ColorUtil;
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
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class GraphDetailsActivity extends BaseActivity implements View.OnTouchListener, MediaPlayer.OnCompletionListener, RatingBar.OnRatingBarChangeListener {
    public static final SleepScore.ScoreMeasure[] ALL_MEASURES = {SleepScore.ScoreMeasure.DURATION, SleepScore.ScoreMeasure.DEEP_SLEEP, SleepScore.ScoreMeasure.IRREGULARITY, SleepScore.ScoreMeasure.EFFICIENCY, SleepScore.ScoreMeasure.SNORE, SleepScore.ScoreMeasure.HR, SleepScore.ScoreMeasure.HRV, SleepScore.ScoreMeasure.RDI, SleepScore.ScoreMeasure.RATING};
    private ActionMode actionMode;
    MenuItem awakeMenuItem;
    private EditText comment;
    MenuItem cutMenuItem;
    private SleepRecord displayedRecord;
    View editAreaWrapper;
    Button fab;
    private GraphElementToggleSection graphElementToggleSection;
    private Handler handler;
    private ViewGroup mainLayout;
    private SleepRecord nextSleepRecord;
    private Collection<Interval> noiseIntervals;
    private List<Noise> noisesToBePlayed;
    MenuItem playMenuItem;
    private String shareFileName;
    private GraphViewMap graphs = new GraphViewMap();
    private boolean lackOfSpace = false;
    private boolean editMode = false;
    private boolean noKeyguard = false;
    private Runnable zoomInRunnable = new Runnable() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.6
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            GraphView firstVisible = GraphDetailsActivity.this.graphs.getFirstVisible();
            if (firstVisible.isSelection()) {
                float selectPoint1Percent = firstVisible.getSelectPoint1Percent();
                float selectPoint2Percent = firstVisible.getSelectPoint2Percent();
                float fMin = Math.min(firstVisible.getSelectPoint1(), firstVisible.getSelectPoint2());
                float fMax = Math.max(firstVisible.getSelectPoint1(), firstVisible.getSelectPoint2());
                boolean z2 = true;
                if (firstVisible.getZoomPoint1() == -1.0f) {
                    GraphDetailsActivity.this.graphs.setZoomPoint1(0.0f);
                    z = true;
                } else {
                    z = false;
                }
                if (firstVisible.getZoomPoint2() == -1.0f) {
                    GraphDetailsActivity.this.graphs.setZoomPoint2(firstVisible.getWidth());
                    z = true;
                }
                if (fMin - ActivityUtils.getDip(GraphDetailsActivity.this, 64) > firstVisible.getZoomPoint1()) {
                    GraphDetailsActivity.this.graphs.setZoomPoint1(firstVisible.getZoomPoint1() + ActivityUtils.getDip(GraphDetailsActivity.this, 24));
                    z = true;
                }
                if (fMax + ActivityUtils.getDip(GraphDetailsActivity.this, 64) < firstVisible.getZoomPoint2()) {
                    GraphDetailsActivity.this.graphs.setZoomPoint2(firstVisible.getZoomPoint2() - ActivityUtils.getDip(GraphDetailsActivity.this, 24));
                } else {
                    z2 = z;
                }
                GraphDetailsActivity.this.graphs.setSelectionPoint1Percentage(selectPoint1Percent);
                GraphDetailsActivity.this.graphs.setSelectionPoint2Percentage(selectPoint2Percent);
                GraphDetailsActivity.this.graphs.invalidate();
                if (firstVisible.getZoomPercentage() >= 0.3f ? z2 : false) {
                    GraphDetailsActivity.this.handler.postDelayed(this, 20L);
                }
            }
        }
    };
    private ViewGroup titleTime = null;
    private boolean refreshAfterResume = false;
    private MediaPlayer player = null;
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.15
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return GraphDetailsActivity.this.handleMenuAction(menuItem.getItemId());
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.detail_select_menu, menu);
            GraphDetailsActivity.this.cutMenuItem = menu.findItem(R.id.menu_delete_selected);
            GraphDetailsActivity.this.playMenuItem = menu.findItem(R.id.menu_play_selected);
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_add_awake_selected);
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_delete_awake_selected);
            GraphDetailsActivity.this.awakeMenuItem = menu.findItem(R.id.menu_awake);
            menuItemFindItem.setTitle(GraphDetailsActivity.this.getString(R.string.menu_add) + " " + GraphDetailsActivity.this.getString(R.string.awake).toLowerCase());
            menuItemFindItem2.setTitle(GraphDetailsActivity.this.getString(R.string.delete) + " " + GraphDetailsActivity.this.getString(R.string.awake).toLowerCase());
            GraphDetailsActivity.this.playMenuItem.setVisible(false);
            GraphDetailsActivity.this.cutMenuItem.setVisible(false);
            GraphDetailsActivity.this.awakeMenuItem.setVisible(false);
            actionMode.setTitle(R.string.graph_edit_hint);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            GraphDetailsActivity.this.cancelSelect();
            boolean z = GraphDetailsActivity.this.editMode;
            GraphDetailsActivity graphDetailsActivity = GraphDetailsActivity.this;
            if (z) {
                graphDetailsActivity.setEditMode(Boolean.FALSE);
            } else {
                graphDetailsActivity.showBottomSheet();
            }
            View viewFindViewById = GraphDetailsActivity.this.findViewById(R.id.major_measures);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            View viewFindViewById2 = GraphDetailsActivity.this.findViewById(R.id.navigation);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(0);
            }
            View viewFindViewById3 = GraphDetailsActivity.this.findViewById(R.id.major_scroll_land);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(0);
            }
            View viewFindViewById4 = GraphDetailsActivity.this.findViewById(R.id.scroll);
            GraphDetailsActivity graphDetailsActivity2 = GraphDetailsActivity.this;
            if (viewFindViewById4 != null) {
                graphDetailsActivity2.findViewById(R.id.scroll).getClass();
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                final ScrollView scrollView = (ScrollView) graphDetailsActivity2.findViewById(R.id.scroll);
                if (scrollView != null) {
                    ((BaseActivity) GraphDetailsActivity.this).h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            scrollView.fullScroll(33);
                        }
                    }, 500L);
                }
                GraphDetailsActivity.this.actionMode = null;
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    };

    /* JADX INFO: renamed from: com.urbandroid.sleep.graph.GraphDetailsActivity$7, reason: invalid class name */
    public class AnonymousClass7 extends AsyncTask<Void, Void, SleepRecord[]> {
        public AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$0(SleepRecord sleepRecord, View view) {
            Intent startIntent = GraphDetailsActivity.getStartIntent(GraphDetailsActivity.this.getContext(), sleepRecord);
            startIntent.putExtra("prev", true);
            startIntent.putExtra("keyguard", GraphDetailsActivity.this.noKeyguard);
            GraphDetailsActivity.this.startActivity(startIntent);
            GraphDetailsActivity.this.overridePendingTransition(R.anim.prev_enter, R.anim.prev_exit);
            GraphDetailsActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$1(View view) {
            Intent startIntent = GraphDetailsActivity.getStartIntent(GraphDetailsActivity.this.getContext(), GraphDetailsActivity.this.nextSleepRecord);
            startIntent.putExtra("next", true);
            startIntent.putExtra("keyguard", GraphDetailsActivity.this.noKeyguard);
            GraphDetailsActivity.this.startActivity(startIntent);
            GraphDetailsActivity.this.overridePendingTransition(R.anim.next_enter, R.anim.next_exit);
            GraphDetailsActivity.this.finish();
        }

        @Override // android.os.AsyncTask
        public SleepRecord[] doInBackground(Void... voidArr) {
            if (GraphDetailsActivity.this.displayedRecord == null) {
                return null;
            }
            return new SleepRecord[]{SharedApplicationContext.getInstance().getSleepRecordRepository().getPrevRecord(GraphDetailsActivity.this.displayedRecord.getFromTime(), true), SharedApplicationContext.getInstance().getSleepRecordRepository().getNextRecord(GraphDetailsActivity.this.displayedRecord.getFromTime(), true)};
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(SleepRecord[] sleepRecordArr) {
            super.onPostExecute(sleepRecordArr);
            GraphDetailsActivity.this.nextSleepRecord = sleepRecordArr[1];
            final SleepRecord sleepRecord = sleepRecordArr[0];
            View viewFindViewById = GraphDetailsActivity.this.findViewById(R.id.prev);
            if (viewFindViewById != null) {
                if (sleepRecord != null) {
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity$7$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onPostExecute$0(sleepRecord, view);
                        }
                    });
                } else {
                    viewFindViewById.setEnabled(false);
                }
            }
            View viewFindViewById2 = GraphDetailsActivity.this.findViewById(R.id.next);
            if (viewFindViewById2 != null) {
                if (GraphDetailsActivity.this.nextSleepRecord != null) {
                    viewFindViewById2.setOnClickListener(new GraphEditActivity$$ExternalSyntheticLambda3(this, 3));
                } else {
                    viewFindViewById2.setEnabled(false);
                }
            }
        }
    }

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
                        GraphDetailsActivity.addSunLabel(graphView, sleepRecord, new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(locationComputeLocation.getLat(), locationComputeLocation.getLon()), DesugarTimeZone.getTimeZone(sleepRecord.getTimezone())).getOfficialSunriseCalendarForDate(calendar));
                        calendar.setTime(sleepRecord.getFrom());
                        GraphDetailsActivity.addSunLabel(graphView, sleepRecord, new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(locationComputeLocation.getLat(), locationComputeLocation.getLon()), DesugarTimeZone.getTimeZone(sleepRecord.getTimezone())).getOfficialSunsetCalendarForDate(calendar));
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
                if (context instanceof GraphDetailsActivity) {
                    ((GraphDetailsActivity) context).setNoiseIntervals(arrayList);
                }
                if (z2) {
                    graphView2.setSelectableIntervals(arrayList);
                    graphView2.addIntervalPresentation(new IntervalStyle(GraphLegend.NOISE_RECORDING.eventLabelName(), arrayList).setDrawable(R.drawable.ic_action_mic).setStroke(2).setOffset(30).setStyle(IntervalStyle.Style.LINE).setColor(ColorUtil.i(viewGroup.getContext(), R.color.primary_icon_solid)));
                } else {
                    graphView.setSelectableIntervals(arrayList);
                    graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.NOISE_RECORDING.eventLabelName(), arrayList).setDrawable(R.drawable.ic_action_mic).setStroke(2).setOffset(30).setStyle(IntervalStyle.Style.LINE).setColor(ColorUtil.i(viewGroup.getContext(), R.color.primary_icon_solid)));
                }
            }
            GraphDetailsActivity.loadPieForSameDayRecord(this.context, sleepRecord, SharedApplicationContext.getSettings().getDayCutOffHour(), (ViewGroup) viewGroup.findViewById(R.id.major_measures));
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
            refreshComments(sleepRecord, viewGroup);
        }

        public void refreshComments(SleepRecord sleepRecord, ViewGroup viewGroup) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.graph_comment);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.graph_tag);
            Set<String> tags = Tag.getTags(Tag.TAG_QUANTITY_VALUE_PATTERN, sleepRecord.getComment());
            if (tags == null || tags.size() <= 0) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                Tag.tagTextView(viewGroup.getContext(), textView2, tags, this.doDpi, false);
            }
            if (sleepRecord.getTagFilteredComment() == null || sleepRecord.getTagFilteredComment().trim().length() == 0) {
                textView.setVisibility(4);
            } else {
                textView.setVisibility(0);
                textView.setText(Html.fromHtml(Tag.highlightTags(sleepRecord.getTagFilteredComment())));
            }
        }

        public GraphDetailViewInitializer setDbUpdateAllowed(boolean z) {
            this.dbUpdateAllowed = z;
            return this;
        }

        public GraphDetailViewInitializer setDoDpi(boolean z) {
            this.doDpi = z;
            return this;
        }

        public GraphDetailViewInitializer setShowNoises(boolean z) {
            this.showNoises = z;
            return this;
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
        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.12
            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
            public boolean undo() {
                zza$$ExternalSyntheticOutline0.m(GraphDetailsActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
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

    private void bindGraphNavigation() {
        new AnonymousClass7().execute(new Void[0]);
    }

    private void buildFromIntent(Intent intent) {
        View viewFindViewById;
        this.displayedRecord = (SleepRecord) getIntent().getParcelableExtra("SleepRecord");
        int i = 1;
        if (getIntent() != null && getIntent().hasExtra("keyguard")) {
            KeyguardUtil.disable(this);
            this.noKeyguard = true;
        }
        try {
            Logger.logInfo("SleepRecord: " + SleepRecordCsvMapper.sleepRecordToCsv(this.displayedRecord));
            String asciiHypnogram = SleeprecordExtKt.toAsciiHypnogram(this.displayedRecord, 5);
            if (asciiHypnogram != null) {
                Logger.logInfo("Hypnogram: ".concat(asciiHypnogram));
            }
            EventsUtil.logInterval(this.displayedRecord.getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END);
            EventsUtil.logInterval(this.displayedRecord.getEvents().getCopiedEvents(), EventLabel.WALKING_START, EventLabel.WALKING_END);
            EventsUtil.logInterval(this.displayedRecord.getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED);
        } catch (Exception unused) {
        }
        if (this.displayedRecord == null) {
            Logger.logWarning("No record in GDA");
            finish();
            return;
        }
        SleepRecord sleepRecordLoadFullRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().loadFullRecord(this.displayedRecord.getFrom().getTime());
        if (sleepRecordLoadFullRecord != null) {
            this.displayedRecord = sleepRecordLoadFullRecord;
        }
        resolveRdi();
        ((TextView) findViewById(R.id.graph_tag)).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GraphDetailsActivity.this.setEditMode(Boolean.TRUE);
            }
        });
        ((TextView) findViewById(R.id.graph_comment)).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GraphDetailsActivity.this.setEditMode(Boolean.TRUE);
            }
        });
        int i2 = getResources().getConfiguration().screenLayout & 15;
        if (i2 != 3) {
        }
        int i3 = 0;
        boolean z = i2 == 1;
        int i4 = 2;
        boolean z2 = getResources().getConfiguration().orientation == 2;
        this.lackOfSpace = z || z2;
        GraphViewMap graphViewMap = new GraphViewMap();
        this.graphs = graphViewMap;
        graphViewMap.add(R.id.hypnogram, (GraphView) findViewById(R.id.hypnogram));
        this.graphs.add(R.id.noise_graph, (GraphView) findViewById(R.id.noise_graph));
        this.graphs.add(R.id.sensor_graph, (GraphView) findViewById(R.id.sensor_graph));
        this.graphs.add(R.id.graph, (GraphView) findViewById(R.id.graph));
        this.graphs.setOnTouchListener(this);
        this.mainLayout = (ViewGroup) findViewById(R.id.root);
        if (!this.displayedRecord.hasActigraph() && this.displayedRecord.hasHypnogram() && (viewFindViewById = findViewById(R.id.rating_graph)) != null && !z2) {
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, ActivityUtils.getDip(this, 32), z2 ? 0.0f : 1.0f));
        }
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
        if (this.displayedRecord.getTo() == null) {
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Graph with NULL TO: " + this.displayedRecord);
        }
        updateTitle();
        Button button = (Button) findViewById(R.id.fab);
        this.fab = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GraphDetailsActivity.this.setEditMode(Boolean.TRUE);
            }
        });
        ComponentColorUtilKt.color(this.fab);
        this.editAreaWrapper = findViewById(R.id.editAreaWrapper);
        final EditText editText = (EditText) findViewById(R.id.sleep_rating_comment);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                if (i5 != 6) {
                    return false;
                }
                GraphDetailsActivity.this.setEditMode(Boolean.FALSE);
                ((InputMethodManager) GraphDetailsActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
                return true;
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tags);
        ((ImageButton) findViewById(R.id.fullscreen)).setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, i3));
        EditText editText2 = (EditText) findViewById(R.id.sleep_rating_comment);
        this.comment = editText2;
        editText2.setText(this.displayedRecord.getComment());
        viewGroup.removeAllViews();
        EditActivity.createTags(this, viewGroup, this.comment);
        Logger.logInfo("GraphDetailsActivity: record version " + this.displayedRecord.getVersion());
        bindGraphNavigation();
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.major_scroll);
        ScrollView scrollView = (ScrollView) findViewById(R.id.major_scroll_land);
        Logger.logInfo("GraphDetailsActivity: scroll " + horizontalScrollView);
        if (horizontalScrollView != null) {
            this.handler.post(new GraphEditActivity$$ExternalSyntheticLambda0(horizontalScrollView, i));
            Logger.logInfo("GraphDetailsActivity: start " + horizontalScrollView);
            this.handler.postDelayed(new GraphEditActivity$$ExternalSyntheticLambda0(horizontalScrollView, i4), 750L);
        }
        if (scrollView != null) {
            this.handler.post(new GraphDetailsActivity$$ExternalSyntheticLambda5(scrollView, i3));
            Logger.logInfo("GraphDetailsActivity: start " + horizontalScrollView);
            this.handler.postDelayed(new GraphDetailsActivity$$ExternalSyntheticLambda5(scrollView, i), 750L);
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

    private void collapseBottomSheet() {
    }

    private void delete() {
        new Settings(getApplicationContext()).decRecordsCount();
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.deleted), new SleepRecord(this.displayedRecord, false));
        SharedApplicationContext.getInstance().deleteRecord(this.displayedRecord, undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        SleepRecord sleepRecord = this.nextSleepRecord;
        if (sleepRecord != null) {
            start(this, sleepRecord);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
        finish();
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
        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.11
            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
            public boolean undo() {
                zza$$ExternalSyntheticOutline0.m(GraphDetailsActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
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
        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.10
            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
            public boolean undo() {
                zza$$ExternalSyntheticOutline0.m(GraphDetailsActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
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

    private void displayRdi(int i) {
        View viewFindViewById;
        Resources resources;
        int i2;
        if (isLandscapeLayout() || (viewFindViewById = findViewById(R.id.rdi_section)) == null) {
            return;
        }
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, " ~", " (");
        if (i < 10) {
            resources = getResources();
            i2 = R.string.condition_normal;
        } else if (i < 15) {
            resources = getResources();
            i2 = R.string.condition_mild;
        } else if (i < 30) {
            resources = getResources();
            i2 = R.string.condition_moderate;
        } else {
            resources = getResources();
            i2 = R.string.condition_severe;
        }
        sbM65m.append(resources.getString(i2));
        sbM65m.append(")");
        Logger.logInfo("SPO2 RDI " + i);
        Logger.logInfo("SPO2 Condition ".concat(sbM65m.toString()));
        viewFindViewById.setVisibility(0);
        findViewById(R.id.rdi_cancel).setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, 1));
        findViewById(R.id.rdi_read_more).setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, 2));
        TextView textView = (TextView) findViewById(R.id.rdi_text);
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.apnea_result, sbM65m.toString()));
            String str = " ";
            if (i >= 10) {
                str = " " + getResources().getString(R.string.advice_sleep_lab) + ".";
            }
            sb.append(str);
            textView.setText(sb.toString());
            textView.setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, 3));
        }
        View viewFindViewById2 = findViewById(R.id.bottom_tag_bar);
        viewFindViewById2.setPaddingRelative(viewFindViewById2.getPaddingStart(), (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), viewFindViewById2.getPaddingEnd(), viewFindViewById2.getPaddingBottom());
    }

    private void finishActionMode() {
        if (this.actionMode != null) {
            showBottomSheet();
            this.actionMode.finish();
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

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
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
        Intent intent = new Intent(context, (Class<?>) GraphDetailsActivity.class);
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
                if (this.editMode) {
                    setEditMode(Boolean.FALSE);
                } else {
                    finish();
                }
                return true;
            case R.id.menu_add_awake_selected /* 2131362509 */:
                Logger.logInfo("Adding awake to graph");
                addAwakeSelected();
                return true;
            case R.id.menu_copy_record /* 2131362518 */:
                String strSerialize = this.displayedRecord.serialize();
                if (strSerialize != null) {
                    ((ClipboardManager) getSystemService("clipboard")).setText(strSerialize);
                }
                return true;
            case R.id.menu_graphs_list /* 2131362529 */:
                finish();
                Intent intent = new Intent(this, (Class<?>) GraphActivity.class);
                intent.putExtra("date", this.displayedRecord.getTo().getTime());
                startActivity(intent);
                return true;
            case R.id.menu_noise /* 2131362541 */:
                if (this.displayedRecord.getTo() != null) {
                    Intent intent2 = new Intent(this, (Class<?>) NoiseActivity.class);
                    intent2.putExtra("noise_from", this.displayedRecord.getFrom().getTime());
                    intent2.putExtra("noise_to", this.displayedRecord.getTo().getTime());
                    intent2.putExtra("noise_timezone", this.displayedRecord.getTimezone());
                    startActivity(intent2);
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
                    Intent intent3 = new Intent(this, (Class<?>) PlayAudioActivity.class);
                    intent3.putExtra("noise_ids", jArr);
                    startActivity(intent3);
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
                    saveRecord(this.displayedRecord);
                    startActivity(ShareDataUtil.createIntent(this, this.shareFileName, new SleepRecordStringBuilder(getApplicationContext()).setPrependSleep(true).setAppendAppName(true).build(this.displayedRecord)));
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
                        undoOperationGroup.addOperation(new BaseUndoOperation() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.13
                            @Override // com.urbandroid.sleep.domain.undo.UndoOperation
                            public boolean undo() {
                                zza$$ExternalSyntheticOutline0.m(GraphDetailsActivity.this.getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
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
                        return true;
                    case R.id.menu_delete_location /* 2131362523 */:
                        SleepRecord sleepRecord2 = new SleepRecord(this.displayedRecord, false);
                        sleepRecord2.setGeo(null);
                        UndoOperationGroup undoOperationGroup2 = new UndoOperationGroup(getString(R.string.delete_location), this.displayedRecord);
                        SharedApplicationContext.getInstance().recordDataUpdated(this.displayedRecord, sleepRecord2, undoOperationGroup2);
                        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup2);
                        showUndoToast();
                        finish();
                        return true;
                    case R.id.menu_delete_selected /* 2131362524 */:
                        Logger.logInfo("Deleting selected portion of graph");
                        deleteSelected();
                        return true;
                    case R.id.menu_doc /* 2131362525 */:
                        DocItemDialogFragment.newInstance("graph", null, null).show(getSupportFragmentManager(), "help");
                        return true;
                    case R.id.menu_edit_record /* 2131362526 */:
                        EditActivity.showRatingForResult(this, this.displayedRecord, this.noKeyguard);
                        return true;
                    default:
                        switch (i) {
                            case R.id.menu_share_facebook /* 2131362553 */:
                                if (SharedApplicationContext.getInstance().getShareService().isConnected(this)) {
                                    ShareAfterDismissService.shareExplicit(this, this.displayedRecord);
                                    Intent intent4 = new Intent(this, (Class<?>) SocialSettingsActivity.class);
                                    intent4.setFlags(ClientDefaults.MAX_MSG_SIZE);
                                    startActivity(intent4);
                                }
                                return true;
                            case R.id.menu_show_map /* 2131362554 */:
                                Location locationComputeLocation = LocationService.computeLocation(this.displayedRecord.getGeo());
                                try {
                                    Uri uri = Uri.parse("geo:" + locationComputeLocation.getLat() + "," + locationComputeLocation.getLon() + "?q=" + locationComputeLocation.getLat() + "," + locationComputeLocation.getLon() + "(" + new SleepRecordStringBuilder(this).build(this.displayedRecord) + MqttTopic.SINGLE_LEVEL_WILDCARD + getString(R.string.app_name) + ")");
                                    StringBuilder sb = new StringBuilder("Map URL ");
                                    sb.append(uri.toString());
                                    Logger.logInfo(sb.toString());
                                    startActivity(new Intent("android.intent.action.VIEW", uri));
                                    break;
                                } catch (ActivityNotFoundException unused) {
                                    Toast.makeText(this, R.string.message_missing_feature, 0).show();
                                }
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    private void hideBottomSheet() {
    }

    private boolean isLandscapeLayout() {
        return findViewById(R.id.major_scroll_land) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildFromIntent$0(View view) {
        setEditMode(Boolean.FALSE);
        EditActivity.showRatingForResult(this, this.displayedRecord, this.noKeyguard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildFromIntent$1(HorizontalScrollView horizontalScrollView) {
        horizontalScrollView.fullScroll(66);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildFromIntent$2(HorizontalScrollView horizontalScrollView) {
        horizontalScrollView.smoothScrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildFromIntent$3(ScrollView scrollView) {
        scrollView.fullScroll(130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildFromIntent$4(ScrollView scrollView) {
        scrollView.smoothScrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayRdi$10(View view) {
        findViewById(R.id.rdi_section).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayRdi$11(View view) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/sleep_apnea.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayRdi$12(View view) {
        if (!Experiments.getInstance().isSMSExperiment()) {
            ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/sleep_apnea.html");
        } else {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSmsLink();
            ViewIntent.url(this, "https://sleepmastersolutions.com/sleepasandroid/");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEditMode$5(View view) {
        NewAddRecordActivity.start(this, this.displayedRecord.getFromTime() - 3600000, this.displayedRecord.getFromTime() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEditMode$6(View view) {
        NewAddRecordActivity.start(this, this.displayedRecord.getToTime() + 1, this.displayedRecord.getToTime() + 3600000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setEditMode$7(ScrollView scrollView) {
        scrollView.fullScroll(130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$startActionMode$8(TextView textView, int i, KeyEvent keyEvent) {
        updateSelectionFromTitleTime();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$startActionMode$9(TextView textView, int i, KeyEvent keyEvent) {
        updateSelectionFromTitleTime();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTitle$13(View view) {
        Intent intent = new Intent(this, (Class<?>) GraphActivity.class);
        intent.putExtra("date", this.displayedRecord.getFromTime());
        intent.addFlags(603979776);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit);
    }

    public static void loadPieForSameDayRecord(final Context context, final SleepRecord sleepRecord, int i, final ViewGroup viewGroup) {
        new AsyncTask<Void, Void, List<SleepRecord>>() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.1
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
                Iterator<PieView> it = companion.getViewsForSleepRecord(R.layout.view_pie, context2, sleepRecord2, list, Arrays.asList(scoreMeasureArr), scoreMeasureArr.length, -1, false, R.layout.view_pie_score).iterator();
                while (it.hasNext()) {
                    viewGroup2.addView(it.next());
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performUndo() {
        SleepRecord sleepRecordPerformUndo = SharedApplicationContext.getInstance().getSleepRecordRepository().performUndo();
        if (sleepRecordPerformUndo == null) {
            finish();
            return;
        }
        this.displayedRecord = sleepRecordPerformUndo;
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
        this.graphs.invalidate();
        refreshRatingBar();
    }

    private void refreshRatingBar() {
        RatingBar ratingBar = (RatingBar) findViewById(R.id.sleep_rating_bar);
        if (ratingBar != null) {
            ratingBar.setOnRatingBarChangeListener(null);
            ratingBar.setRating(this.displayedRecord.getRating());
            ratingBar.setOnRatingBarChangeListener(this);
            ratingBar.setVisibility(0);
        }
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

    private void resolveRdi() {
        int iResolveRdi = this.displayedRecord.resolveRdi();
        if (iResolveRdi <= 10 || !this.displayedRecord.getEvents().hasLabel(EventLabel.APNEA)) {
            return;
        }
        displayRdi(iResolveRdi);
    }

    private void saveCommentWithUndoOperation(SleepRecord sleepRecord, String str) {
        SleepRecord sleepRecord2 = new SleepRecord(sleepRecord, false);
        if (str == null || str.equals(sleepRecord.getComment())) {
            return;
        }
        sleepRecord.saveComment(str);
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.edit_record), new SleepRecord(sleepRecord, false));
        SharedApplicationContext.getInstance().recordRatingUpdated(sleepRecord2, new SleepRecord(sleepRecord, false), undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
    }

    private void saveRecord(SleepRecord sleepRecord) {
        ShareDataUtil.saveData(this, this.shareFileName, SleepGraphImageGenerator.generateSleepGraph((Context) this, findViewById(R.id.root), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditMode(Boolean bool) {
        View viewFindViewById = findViewById(R.id.bottom_tag_bar);
        if (!bool.booleanValue() || this.editMode) {
            if (bool.booleanValue() || !this.editMode) {
                return;
            }
            this.editMode = false;
            findViewById(R.id.add_button_before).setVisibility(8);
            findViewById(R.id.add_button_after).setVisibility(8);
            finishActionMode();
            removeGraphEditOnboarding();
            saveCommentWithUndoOperation(this.displayedRecord, this.comment.getText().toString());
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.show);
            this.editAreaWrapper.setVisibility(8);
            viewFindViewById.setVisibility(0);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    new GraphDetailViewInitializer(GraphDetailsActivity.this).refreshComments(GraphDetailsActivity.this.displayedRecord, (ViewGroup) GraphDetailsActivity.this.findViewById(R.id.root));
                    GraphDetailsActivity.this.fab.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.fab.startAnimation(animationLoadAnimation);
            return;
        }
        this.editMode = true;
        if (this.actionMode == null) {
            startActionMode();
        }
        findViewById(R.id.add_button_before).setVisibility(0);
        findViewById(R.id.add_button_before).setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, 5));
        findViewById(R.id.add_button_after).setVisibility(0);
        findViewById(R.id.add_button_after).setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, 6));
        showGraphEditOnboarding(this.graphs);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hide);
        this.editAreaWrapper.setVisibility(0);
        viewFindViewById.setVisibility(8);
        animationLoadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GraphDetailsActivity.this.fab.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.fab.startAnimation(animationLoadAnimation2);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll);
        if (scrollView != null) {
            this.h.postDelayed(new GraphDetailsActivity$$ExternalSyntheticLambda5(scrollView, 2), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomSheet() {
    }

    private void showGraphEditOnboarding(GraphViewMap graphViewMap) {
        if (new Settings(this).showShowCaseIfNotShown("sc_graph_detail_edit")) {
            View viewFindViewById = findViewById(R.id.slide_hint);
            if (viewFindViewById != null) {
                viewFindViewById.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.unfade_slow));
                viewFindViewById.setVisibility(0);
            }
            for (GraphView graphView : graphViewMap.getAllGraphViews()) {
                graphView.setSelectPoint1Percentage(0.2f);
                graphView.setSelectPoint2Percentage(0.8f);
            }
        }
    }

    private void showUndoToast() {
        UndoOperationGroup currentUndoOperation = SharedApplicationContext.getInstance().getSleepRecordRepository().getCurrentUndoOperation();
        if (currentUndoOperation == null) {
            return;
        }
        Snackbar.make(findViewById(R.id.root), currentUndoOperation.getName(), getResources().getString(R.string.delete).equals(currentUndoOperation.getName()) ? -2 : 0).setAction(R.string.undo, new View.OnClickListener() { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GraphDetailsActivity.this.performUndo();
            }
        }).show();
    }

    public static void start(Context context, SleepRecord sleepRecord, boolean z) {
        context.startActivity(getStartIntent(context, sleepRecord, z));
    }

    private void startActionMode() {
        if (this.actionMode != null || this.graphs.get(R.id.graph).isZoom()) {
            return;
        }
        hideBottomSheet();
        this.actionMode = startSupportActionMode(this.actionModeCallback);
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.title_edit_times, (ViewGroup) null);
        this.titleTime = viewGroup;
        final int i = 0;
        ((EditText) viewGroup.findViewById(R.id.title_time_from)).setOnEditorActionListener(new TextView.OnEditorActionListener(this) { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ GraphDetailsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                int i3 = i;
                GraphDetailsActivity graphDetailsActivity = this.f$0;
                switch (i3) {
                    case 0:
                        return graphDetailsActivity.lambda$startActionMode$8(textView, i2, keyEvent);
                    default:
                        return graphDetailsActivity.lambda$startActionMode$9(textView, i2, keyEvent);
                }
            }
        });
        final int i2 = 1;
        ((EditText) this.titleTime.findViewById(R.id.title_time_to)).setOnEditorActionListener(new TextView.OnEditorActionListener(this) { // from class: com.urbandroid.sleep.graph.GraphDetailsActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ GraphDetailsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i22, KeyEvent keyEvent) {
                int i3 = i2;
                GraphDetailsActivity graphDetailsActivity = this.f$0;
                switch (i3) {
                    case 0:
                        return graphDetailsActivity.lambda$startActionMode$8(textView, i22, keyEvent);
                    default:
                        return graphDetailsActivity.lambda$startActionMode$9(textView, i22, keyEvent);
                }
            }
        });
        ((TextView) this.titleTime.findViewById(R.id.title_time_duration)).setText(R.string.graph_edit_hint);
        ((TextView) this.titleTime.findViewById(R.id.title_time_duration)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.hint_touch_dn, 0);
        this.actionMode.setCustomView(this.titleTime);
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

    private void updateTitle() {
        setTitle((CharSequence) null);
        TextView textView = (TextView) findViewById(R.id.title);
        if (getIntent() == null || !getIntent().hasExtra("title")) {
            textView.setText(new SleepRecordStringBuilder(this).setAppendDay(true).setAppendWeekDay(true).setAppendRange(false).build(this.displayedRecord));
        } else {
            textView.setText(getIntent().getStringExtra("title"));
        }
        textView.setOnClickListener(new GraphDetailsActivity$$ExternalSyntheticLambda2(this, 4));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Logger.logInfo("onActivityResult " + intent);
        if (intent == null || !intent.hasExtra("SleepRecord")) {
            return;
        }
        SleepRecord sleepRecord = (SleepRecord) intent.getParcelableExtra("SleepRecord");
        Logger.logInfo("onActivityResult " + sleepRecord.getComment() + " " + sleepRecord.getRating());
        this.displayedRecord = sleepRecord;
        saveCommentWithUndoOperation(sleepRecord, sleepRecord.getComment());
        this.comment.setText(this.displayedRecord.getComment());
        new GraphDetailViewInitializer(this).initialize(this.mainLayout, this.displayedRecord, this.graphs);
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
        setContentView(R.layout.activity_graph_details);
        this.handler = new Handler();
        TintUtil.tint(this, ColorUtil.i(this, R.color.bg_card));
        ToolbarUtil.apply(this);
        ToolbarUtil.fixTitle(this, 20);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_card)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buildFromIntent(getIntent());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        MenuUtil.showIcons(menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_delete_awake);
        menuItemFindItem.setTitle(getResources().getString(R.string.delete) + " " + getResources().getString(R.string.awake).toLowerCase());
        menuItemFindItem.setVisible(this.displayedRecord.getEvents().hasLabel(EventLabel.TRACKING_PAUSED) || this.displayedRecord.getEvents().hasLabel(EventLabel.AWAKE_START) || this.displayedRecord.getEvents().hasLabel(EventLabel.WALKING_START));
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_share_facebook);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setTitle(getString(R.string.share_facebook) + " (" + SharedApplicationContext.getInstance().getShareService().getName(this) + ")");
            menuItemFindItem2.setVisible(SharedApplicationContext.getInstance().getShareService().isConnected(this));
        }
        MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_copy_record);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setVisible(Experiments.getInstance().isOurExperimentalPhone());
        }
        MenuItem menuItemFindItem4 = menu.findItem(R.id.menu_show_map);
        MenuItem menuItemFindItem5 = menu.findItem(R.id.menu_delete_location);
        SleepRecord sleepRecord = this.displayedRecord;
        if (sleepRecord != null && sleepRecord.getGeo() != null) {
            menuItemFindItem4.setVisible(true);
            menuItemFindItem5.setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        try {
            if (getSelectionTimes() != null) {
                this.graphs.clearSelect();
                z = true;
            } else {
                z = false;
            }
            if (this.editMode) {
                setEditMode(Boolean.FALSE);
                z = true;
            }
            if (z) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
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
        if (this.editMode) {
            saveCommentWithUndoOperation(this.displayedRecord, this.comment.getText().toString());
        }
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

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        Logger.logInfo("Rating: " + f + " " + z);
        float rating = ratingBar.getRating();
        if (rating == this.displayedRecord.getRating()) {
            return;
        }
        SleepRecord sleepRecord = new SleepRecord(this.displayedRecord, false);
        sleepRecord.rateAndComment(this.displayedRecord.getComment(), rating);
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(getString(R.string.axis_rating), this.displayedRecord);
        SharedApplicationContext.getInstance().getSleepRecordRepository().recordRatingUpdated(this.displayedRecord, sleepRecord, undoOperationGroup);
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        if (!this.displayedRecord.isNiceRecord() || rating < 4.0f || rating <= this.displayedRecord.getRating()) {
            Settings.setGoodTimeToRate(false);
        } else {
            Settings.setGoodTimeToRate(true);
        }
        this.displayedRecord = sleepRecord;
        loadPieForSameDayRecord(this, sleepRecord, SharedApplicationContext.getSettings().getDayCutOffHour(), (ViewGroup) findViewById(R.id.major_measures));
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle.getBoolean("editMode")) {
            setEditMode(Boolean.TRUE);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshRatingBar();
        Logger.logInfo("GRAPHS: Resume set callback");
        collapseBottomSheet();
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
                if (getSelectionTimes() != null && findViewById(R.id.major_scroll_land) == null) {
                    View viewFindViewById = findViewById(R.id.navigation);
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                    View viewFindViewById2 = findViewById(R.id.major_measures);
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

    public static void start(Context context, SleepRecord sleepRecord) {
        start(context, sleepRecord, false);
    }

    public static Intent getStartIntent(Context context, SleepRecord sleepRecord) {
        return getStartIntent(context, sleepRecord, false);
    }
}

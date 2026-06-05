package com.urbandroid.sleep.domain;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.graph.GraphLegend;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.GraphViewMap;
import com.urbandroid.sleep.graph.IntervalStyle;
import com.urbandroid.sleep.graph.MinMaxAxisLabels;
import com.urbandroid.sleep.graph.NewSleepGraphYDescriptionAxisLabels;
import com.urbandroid.sleep.graph.NoYDescriptionAxisLabels;
import com.urbandroid.sleep.graph.NoiseYDescriptionAxisLabels;
import com.urbandroid.sleep.graph.SensorAxisLabels;
import com.urbandroid.sleep.graph.SleepGraphYDescriptionAxisLabels;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.sleep.graph.TimeSeries;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;
import com.urbandroid.util.ColorUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SleepGraphInitializer {
    private Context context;
    private GraphViewMap graphs;
    private boolean doGraphIntervals = true;
    private boolean doAnimations = false;

    public SleepGraphInitializer(Context context) {
        this.context = context;
    }

    private void addEventIcons(Context context, GraphView graphView, GraphView graphView2, List<Event> list, EventLabel eventLabel, int i) {
        IntervalStyle offset = new IntervalStyle(GraphLegend.INSTANCE.findByEventLabel(eventLabel).eventLabelName(), EventsUtil.getIntervals(list, eventLabel)).setDrawable(i).setColor(ColorUtil.i(context, R.color.primary_html)).setStyle(IntervalStyle.Style.POINT).setOffset(60);
        if (graphView2 != null) {
            graphView2.addIntervalPresentation(offset);
        } else if (graphView != null) {
            graphView.addIntervalPresentation(offset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHypnogram$0(View view) {
        Intent intent = new Intent(this.context, (Class<?>) AlarmClock.class);
        intent.putExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE", true);
        this.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$populateHypnogramOrPhases$1(SleepRecord sleepRecord) {
        return "";
    }

    private void setVisibility(View view, boolean z, int i, boolean z2) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public GraphViewMap getGraphs() {
        return this.graphs;
    }

    public void init(GraphView graphView, GraphView graphView2, GraphView graphView3, GraphView graphView4, SleepRecord sleepRecord) {
        GraphView graphView5 = graphView;
        List<Float> filteredHistoryForCharting = sleepRecord.getFilteredHistoryForCharting();
        if (graphView2 != null) {
            graphView2.setDoDrawHandles(true);
        } else if (graphView5 != null) {
            graphView5.setDoDrawHandles(true);
        }
        if (graphView5 != graphView2) {
            initActigraph(graphView5, sleepRecord);
        }
        initSensorGraph(graphView4, sleepRecord);
        initNoiseGraph(graphView3, sleepRecord);
        initHypnogram(graphView2, sleepRecord);
        TimeAxisLabels timeAxisLabels = new TimeAxisLabels(graphView5 == null ? graphView2.getContext() : graphView5.getContext(), sleepRecord.getFrom(), sleepRecord.getTo() != null ? sleepRecord.getTo() : new Date(), sleepRecord.getTimezone(), filteredHistoryForCharting.size());
        if (graphView5 != null) {
            graphView5.setXAxisLabels(timeAxisLabels);
            graphView5.setYAxisLabels(new NoYDescriptionAxisLabels(graphView5.getContext()));
        }
        if (graphView2 != null) {
            graphView2.setXAxisLabels(timeAxisLabels);
            graphView2.setRotateYAxisLabels(false);
            if (sleepRecord.getVersion() >= 10007) {
                graphView2.setYAxisLabels(new NewSleepGraphYDescriptionAxisLabels(graphView2.getContext()));
            } else {
                graphView2.setYAxisLabels(new SleepGraphYDescriptionAxisLabels(graphView2.getContext()));
            }
        }
        if (graphView3 != null) {
            graphView3.setBackgroundColor(ColorUtil.i(this.context, R.color.graph_time_segments));
        }
        if (graphView4 != null) {
            graphView4.setXAxisLabels(timeAxisLabels);
            graphView4.setBackgroundColor(ColorUtil.i(this.context, R.color.graph_time_segments));
        }
        if (sleepRecord.getEvents().isEmpty()) {
            return;
        }
        if (graphView2 != null && graphView2.getVisibility() == 0) {
            populateHypnogramOrPhases(this.context, graphView2, sleepRecord);
        } else if (graphView5 != null) {
            graphView5.setDoDrawHandles(true);
        }
        if (this.doGraphIntervals && graphView5 != null) {
            List<Event> copiedEvents = sleepRecord.getEvents().getCopiedEvents();
            IntervalStyle stroke = new IntervalStyle(GraphLegend.LUCID_DREAMING.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.LUCID_CUE)).setDrawable(R.drawable.ic_action_dream).setStroke(2);
            IntervalStyle.Style style = IntervalStyle.Style.MARKER;
            graphView5.addIntervalPresentation(stroke.setStyle(style).setOffset(45));
            graphView5.addIntervalPresentation(new IntervalStyle(GraphLegend.ANTI_SNORING.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.ANTISNORE)).setDrawable(R.drawable.ic_anti_snoring).setStroke(2).setStyle(style).setOffset(45));
            graphView5.addIntervalPresentation(new IntervalStyle(GraphLegend.RESPIRATORY_DISTURBANCE.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.APNEA)).setDrawable(R.drawable.ic_action_cpap).setStroke(2).setStyle(style).setOnlyInZoom(true).setOffset(45));
            addEventIcons(this.context, graphView5, graphView3, copiedEvents, EventLabel.SNORING, R.drawable.ic_action_noise);
            graphView5 = graphView;
            addEventIcons(this.context, graphView5, graphView3, copiedEvents, EventLabel.TALK, R.drawable.ic_action_talk);
            addEventIcons(this.context, graphView5, graphView3, copiedEvents, EventLabel.BABY, R.drawable.ic_action_baby);
            addEventIcons(this.context, graphView5, graphView3, copiedEvents, EventLabel.SICK, R.drawable.ic_action_sick);
            addEventIcons(this.context, graphView5, graphView3, copiedEvents, EventLabel.LAUGH, R.drawable.ic_action_laugh);
            IntervalStyle drawable = new IntervalStyle(GraphLegend.WALK.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.WALKING_START)).setDrawable(R.drawable.ic_walk);
            IntervalStyle.Style style2 = IntervalStyle.Style.POINT;
            graphView5.addIntervalPresentation(drawable.setStyle(style2).setOffset(60));
            graphView5.addIntervalPresentation(new IntervalStyle(GraphLegend.ALARM.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.ALARM_STARTED)).setDrawable(R.drawable.ic_action_time).setStroke(2).setStyle(style).setOffset(45));
            IntervalStyle stroke2 = new IntervalStyle(GraphLegend.PAUSED.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED)).setDrawable(R.drawable.ic_action_pause).setStroke(5);
            IntervalStyle.Style style3 = IntervalStyle.Style.RECT;
            graphView5.addIntervalPresentation(stroke2.setStyle(style3).setOffset(60).setPatternDrawable(R.drawable.pattern3).setColor(ColorUtil.i(graphView5.getContext(), R.color.awake)));
            graphView5.addIntervalPresentation(new IntervalStyle(GraphLegend.STANDBY.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.LOW_BATTERY)).setDrawable(R.drawable.ic_battery_60).setStyle(style2).setOffset(60));
            graphView5.addIntervalPresentation(new IntervalStyle(GraphLegend.SMART_WAKE_UP.eventLabelName(), EventsUtil.getIntervals(copiedEvents, EventLabel.ALARM_EARLIEST, EventLabel.ALARM_LATEST)).setStyle(style3).setOffset(20).setStroke(5).setPatternDrawable(R.drawable.pattern3).setColor(ColorUtil.i(graphView5.getContext(), R.color.negative)));
        }
        if (graphView5 == null && graphView4 == null) {
            return;
        }
        initTimeSeries(sleepRecord, graphView5, graphView4);
    }

    public GraphView initActigraph(GraphView graphView, SleepRecord sleepRecord) {
        if (graphView == null) {
            return null;
        }
        if (!sleepRecord.hasActigraph() && sleepRecord.hasHypnogram()) {
            graphView.setVisibility(8);
            return graphView;
        }
        List<Float> filteredHistoryForCharting = sleepRecord.getFilteredHistoryForCharting();
        graphView.setEquidistantValues(filteredHistoryForCharting, false);
        graphView.setFrom(sleepRecord.getFrom().getTime());
        graphView.setTo((sleepRecord.getTo() != null ? sleepRecord.getTo() : new Date()).getTime());
        graphView.setDoDrawGraphLine(false);
        graphView.setDrawXAxis(true);
        for (Float f : filteredHistoryForCharting) {
        }
        if (!sleepRecord.hasHypnogram()) {
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.AWAKE.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END)).setStyle(IntervalStyle.Style.BAR).setSize(100).setColor(ColorUtil.addAlpha(ColorUtil.i(graphView.getContext(), R.color.awake), 200)));
        }
        setVisibility(graphView, true, 0);
        return graphView;
    }

    public GraphView initHypnogram(GraphView graphView, SleepRecord sleepRecord) {
        ViewGroup viewGroup;
        if (graphView == null) {
            return null;
        }
        List<Float> filteredHistoryForCharting = sleepRecord.getFilteredHistoryForCharting();
        boolean zHasLabel = sleepRecord.getEvents().hasLabel(EventLabel.DEEP_START, EventLabel.TRACKING_PAUSED, EventLabel.LIGHT_START, EventLabel.REM_START);
        setVisibility(graphView, zHasLabel, 400, false);
        if (graphView.getParent() instanceof RelativeLayout) {
            ((ViewGroup) graphView.getParent()).setVisibility(zHasLabel ? 0 : 8);
        }
        graphView.setDrawGraph(false);
        graphView.setEquidistantValues(filteredHistoryForCharting, false);
        graphView.setDoGradient(true);
        graphView.setDoDrawGraphLine(false);
        if (!sleepRecord.hasActigraph() && sleepRecord.hasHypnogram()) {
            graphView.setDrawXAxis(true);
        }
        graphView.setFrom(sleepRecord.getFrom().getTime());
        graphView.setTo((sleepRecord.getTo() != null ? sleepRecord.getTo() : new Date()).getTime());
        graphView.setDoBlur(TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord));
        if (graphView.getParent() != null && (viewGroup = (ViewGroup) ((ViewGroup) graphView.getParent()).findViewById(R.id.trial_layout)) != null) {
            viewGroup.setVisibility(TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord) ? 0 : 8);
            viewGroup.findViewById(R.id.trial_button).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 10));
        }
        return graphView;
    }

    public GraphView initNoiseGraph(GraphView graphView, SleepRecord sleepRecord) {
        if (graphView == null) {
            return null;
        }
        List<Float> filteredNoiseHistory = sleepRecord.getFilteredNoiseHistory();
        if (filteredNoiseHistory != null && filteredNoiseHistory.size() != 0 && sleepRecord.hasNoiseData()) {
            graphView.setDoDrawGraphLine(false);
            graphView.setEquidistantValues(filteredNoiseHistory, false);
            graphView.setFrom(sleepRecord.getFrom().getTime());
            graphView.setTo((sleepRecord.getTo() != null ? sleepRecord.getTo() : new Date()).getTime());
            graphView.setDoGradient(false);
            graphView.setDrawGradientBackground(true);
            graphView.setCardColor(ColorUtil.i(this.context, R.color.bg_card));
            graphView.setGradientFullColor(ColorUtil.i(this.context, R.color.bg_main));
            graphView.setGradientFullColor(ColorUtil.i(this.context, R.color.transparent));
            graphView.setGradientTransColor(ColorUtil.i(this.context, R.color.transparent));
            graphView.setDrawAverage(false);
            graphView.setDoTrimming(true);
            graphView.setTrimMultipleLimit(4.0f);
            graphView.setDoMirrorGraph(true);
            graphView.setDrawXAxis(false);
            graphView.setYAxisLabels(new NoiseYDescriptionAxisLabels(graphView.getContext(), sleepRecord));
            graphView.setSleepGraphColor(ColorUtil.i(graphView.getContext(), R.color.actigraph));
            graphView.setEquidistantValues(filteredNoiseHistory, false);
            setVisibility(graphView, true, 600);
        }
        return graphView;
    }

    public GraphView initSensorGraph(GraphView graphView, SleepRecord sleepRecord) {
        if (graphView == null) {
            return null;
        }
        if (!sleepRecord.hasSensorData()) {
            setVisibility(graphView, false, 0);
            return graphView;
        }
        graphView.setEquidistantValues(sleepRecord.getFilteredHistoryForCharting(), false);
        graphView.setFrom(sleepRecord.getFrom().getTime());
        graphView.setTo((sleepRecord.getTo() != null ? sleepRecord.getTo() : new Date()).getTime());
        graphView.setDoDrawGraphLine(false);
        graphView.setDrawGraph(false);
        graphView.setDrawXAxis(false);
        graphView.setDoDrawAxisLine(false);
        graphView.setForceXAxisOffset(false);
        graphView.setDrawXAxisBars(true);
        graphView.setYAxisLabels(new SensorAxisLabels(graphView.getContext(), sleepRecord));
        setVisibility(graphView, true, 0);
        return graphView;
    }

    public void initTimeSerie(SleepRecord sleepRecord, GraphView graphView, GraphLegend graphLegend, boolean z) {
        double d;
        double d2;
        double d3;
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), graphLegend.getCorrespondingEventLabel());
        Logger.logInfo("Label: size " + events.size() + " ");
        if (graphLegend == GraphLegend.HR) {
            d = 27.0d;
            d2 = 150.0d;
        } else if (graphLegend == GraphLegend.HRV) {
            d = 0.0d;
            d2 = 1000.0d;
        } else if (graphLegend == GraphLegend.SPO2) {
            d = 50.0d;
            d2 = 100.0d;
        } else {
            d = -1.0d;
            d2 = -1.0d;
        }
        if (events.isEmpty()) {
            return;
        }
        TimeSeries timeSeries = new TimeSeries(graphLegend.eventLabelName());
        timeSeries.cornerPath = graphLegend != GraphLegend.SPO2;
        timeSeries.doBreaks = graphLegend == GraphLegend.LIGHT;
        timeSeries.color = ContextCompat.getColor(this.context, graphLegend.getIconDrawableOrColorResource());
        timeSeries.drawValues = !z;
        double d4 = Double.MAX_VALUE;
        double d5 = Double.MIN_VALUE;
        for (IEvent iEvent : events) {
            float value = iEvent.getValue();
            if (d == -1.0d) {
                timeSeries.getSeries().put(Long.valueOf(iEvent.getTimestamp()), Float.valueOf(value));
                d3 = d4;
            } else {
                d3 = d4;
                double d6 = value;
                if (d6 >= d && d6 <= d2) {
                    timeSeries.getSeries().put(Long.valueOf(iEvent.getTimestamp()), Float.valueOf(value));
                }
            }
            double d7 = value;
            if (d7 > d5) {
                d5 = d7;
            }
            d4 = d7 < d3 ? d7 : d3;
        }
        double d8 = d4;
        graphView.setDrawTimeSeries(true);
        graphView.addTimeSeries(timeSeries);
        if (z) {
            graphView.setYAxisLabels(new MinMaxAxisLabels(d8, d5));
            graphView.setRotateYAxisLabels(false);
        }
    }

    public void initTimeSerieHrv(SleepRecord sleepRecord, GraphView graphView, boolean z) {
        Map<Long, Float> smoothHrvSeries = HrvUtilKt.getSmoothHrvSeries(sleepRecord);
        Iterator<Float> it = smoothHrvSeries.values().iterator();
        double d = Double.MAX_VALUE;
        double d2 = Double.MIN_VALUE;
        while (it.hasNext()) {
            double dFloatValue = it.next().floatValue();
            if (dFloatValue > d2) {
                d2 = dFloatValue;
            }
            if (dFloatValue < d) {
                d = dFloatValue;
            }
        }
        if (smoothHrvSeries.size() > 0) {
            HrvUtilKt.logHrvStatistics(sleepRecord);
            TimeSeries timeSeries = new TimeSeries(GraphLegend.HRV.eventLabelName());
            timeSeries.color = ContextCompat.getColor(graphView.getContext(), R.color.hrv);
            timeSeries.cornerPath = true;
            timeSeries.drawValues = !z;
            timeSeries.yScale = TimeSeries.AxisScale.LOGARITHMIC;
            timeSeries.getSeries().putAll(smoothHrvSeries);
            graphView.setDrawTimeSeries(true);
            graphView.addTimeSeries(timeSeries);
            if (z) {
                graphView.setYAxisLabels(new MinMaxAxisLabels(d, d2));
            }
        }
    }

    public void initTimeSerieRr(SleepRecord sleepRecord, GraphView graphView, boolean z) {
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.RR);
        if (events.size() > 0) {
            TimeSeries timeSeries = new TimeSeries(GraphLegend.RESPIRATORY_RATE.eventLabelName());
            timeSeries.yRangeMin = Float.valueOf(10.0f);
            timeSeries.yRangeMax = Float.valueOf(18.0f);
            timeSeries.breakThreshold = AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED;
            timeSeries.doBreaks = true;
            timeSeries.color = ContextCompat.getColor(graphView.getContext(), R.color.rr);
            timeSeries.cornerPath = true;
            timeSeries.drawValues = !z;
            double d = Double.MAX_VALUE;
            double d2 = Double.MIN_VALUE;
            for (int i = 0; i < events.size(); i++) {
                float value = events.get(i).getValue();
                timeSeries.getSeries().put(Long.valueOf(events.get(i).getTimestamp()), Float.valueOf(value));
                double d3 = value;
                if (d3 > d2) {
                    d2 = d3;
                }
                if (d3 < d) {
                    d = d3;
                }
            }
            graphView.setDrawTimeSeries(true);
            graphView.addTimeSeries(timeSeries);
            if (z) {
                graphView.setYAxisLabels(new MinMaxAxisLabels(d, d2));
            }
        }
    }

    public void initTimeSeries(SleepRecord sleepRecord, GraphView graphView, GraphView graphView2) {
        if (graphView2 != null) {
            graphView = graphView2;
        }
        initTimeSerie(sleepRecord, graphView, GraphLegend.HR, false);
        initTimeSerie(sleepRecord, graphView, GraphLegend.LIGHT, false);
        initTimeSerie(sleepRecord, graphView, GraphLegend.SPO2, false);
        initTimeSerieHrv(sleepRecord, graphView, false);
        initTimeSerieRr(sleepRecord, graphView, false);
    }

    public void populateHypnogram(GraphView graphView, SleepRecord sleepRecord) {
        if (graphView != null) {
            List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.BROKEN_START, EventLabel.BROKEN_END);
            IntervalStyle intervalStyle = new IntervalStyle(GraphLegend.NO_SLEEP_DATA.eventLabelName(), intervals);
            IntervalStyle.Style style = IntervalStyle.Style.BAR;
            graphView.addIntervalPresentation(intervalStyle.setStyle(style).setSize(10).setColor(ColorUtil.i(graphView.getContext(), R.color.negative)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.DEEP_SLEEP.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.DEEP_START, EventLabel.DEEP_END)).setStyle(style).setSize(25).setColor(ColorUtil.i(graphView.getContext(), R.color.deep_sleep)));
            if (sleepRecord.getVersion() >= 10007) {
                IntervalStyle intervalStyle2 = new IntervalStyle(GraphLegend.LIGHT_SLEEP.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.LIGHT_START, EventLabel.LIGHT_END));
                IntervalStyle.Style style2 = IntervalStyle.Style.BAR_ROUND;
                graphView.addIntervalPresentation(intervalStyle2.setStyle(style2).setSize(50).setColor(ColorUtil.i(graphView.getContext(), R.color.light_sleep)));
                graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.REM.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.REM_START, EventLabel.REM_END)).setStyle(style2).setSize(75).setColor(ColorUtil.i(graphView.getContext(), R.color.light_sleep)));
            } else {
                IntervalStyle intervalStyle3 = new IntervalStyle(GraphLegend.LIGHT_SLEEP.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.LIGHT_START, EventLabel.LIGHT_END));
                IntervalStyle.Style style3 = IntervalStyle.Style.BAR_ROUND;
                graphView.addIntervalPresentation(intervalStyle3.setStyle(style3).setSize(75).setColor(ColorUtil.i(graphView.getContext(), R.color.light_sleep)));
                graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.REM.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.REM_START, EventLabel.REM_END)).setStyle(style3).setSize(50).setColor(ColorUtil.i(graphView.getContext(), R.color.deep_sleep)));
            }
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.PAUSED.eventLabelName(), transformPauseIntervals(EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED), intervals)).setStyle(style).setSize(100).setColor(ColorUtil.i(graphView.getContext(), R.color.awake)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.WALK.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.WALKING_START, EventLabel.WALKING_END)).setStyle(style).setSize(100).setColor(ColorUtil.i(graphView.getContext(), R.color.awake)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.AWAKE.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END)).setStyle(style).setSize(100).setColor(ColorUtil.i(graphView.getContext(), R.color.awake)));
        }
    }

    public void populateHypnogramOrPhases(Context context, GraphView graphView, SleepRecord sleepRecord) {
        StringBuilder sb = new StringBuilder("key_card_removed_");
        DashboardCard.Type type = DashboardCard.Type.SLEEP_HYPNOGRAM;
        sb.append(type);
        sb.append("_SleepDetailActivity");
        String str = "key_card_removed_" + type + "_SleepDetailActivity";
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(sb.toString(), false) || PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, false)) {
            populatePhases(graphView, new SleepRecordHealthSession(sleepRecord, new Events$$ExternalSyntheticBUOutline0(4)).toSegmentedSleepRecord());
        } else {
            populateHypnogram(graphView, sleepRecord);
        }
    }

    public void populatePhases(GraphView graphView, SleepRecord sleepRecord) {
        if (graphView != null) {
            List<com.urbandroid.sleep.domain.interval.Interval> intervals = EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.BROKEN_START, EventLabel.BROKEN_END);
            IntervalStyle intervalStyle = new IntervalStyle(GraphLegend.NO_SLEEP_DATA.eventLabelName(), intervals);
            IntervalStyle.Style style = IntervalStyle.Style.RANGE;
            graphView.addIntervalPresentation(intervalStyle.setStyle(style).setSize(10).setColor(ColorUtil.i(graphView.getContext(), R.color.negative)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.DEEP_SLEEP.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.DEEP_START, EventLabel.DEEP_END)).setStyle(style).setSize(25).setColor(ColorUtil.i(graphView.getContext(), R.color.deep_sleep_color)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.LIGHT_SLEEP.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.LIGHT_START, EventLabel.LIGHT_END)).setStyle(style).setSize(50).setFromSize(25).setColor(ColorUtil.i(graphView.getContext(), R.color.light_sleep)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.REM.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.REM_START, EventLabel.REM_END)).setStyle(style).setSize(75).setFromSize(50).setColor(ColorUtil.i(graphView.getContext(), R.color.rem_sleep)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.PAUSED.eventLabelName(), transformPauseIntervals(EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED), intervals)).setStyle(style).setSize(100).setFromSize(75).setColor(ColorUtil.i(graphView.getContext(), R.color.awake_color)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.WALK.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.WALKING_START, EventLabel.WALKING_END)).setStyle(style).setSize(100).setFromSize(75).setColor(ColorUtil.i(graphView.getContext(), R.color.awake_color)));
            graphView.addIntervalPresentation(new IntervalStyle(GraphLegend.AWAKE.eventLabelName(), EventsUtil.getIntervals(sleepRecord.getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END)).setStyle(style).setSize(100).setFromSize(75).setColor(ColorUtil.i(graphView.getContext(), R.color.awake_color)));
        }
    }

    public SleepGraphInitializer setDoGraphIntervals(boolean z) {
        this.doGraphIntervals = z;
        return this;
    }

    public List<com.urbandroid.sleep.domain.interval.Interval> transformPauseIntervals(List<com.urbandroid.sleep.domain.interval.Interval> list, List<com.urbandroid.sleep.domain.interval.Interval> list2) {
        if (list2.isEmpty() || list.isEmpty()) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        for (com.urbandroid.sleep.domain.interval.Interval interval : list) {
            long from = interval.getFrom();
            long to = interval.getTo();
            boolean z = false;
            boolean z2 = false;
            for (com.urbandroid.sleep.domain.interval.Interval interval2 : list2) {
                if (!z && interval2.getFrom() < interval.getFrom() && interval2.getFrom() + AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED > interval.getFrom() && interval2.getTo() > interval.getFrom()) {
                    from = interval2.getFrom();
                    z = true;
                }
                if (!z2 && interval2.getTo() > interval.getTo() && interval2.getTo() - AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED < interval.getTo() && interval2.getFrom() < interval.getTo()) {
                    to = interval2.getTo();
                    z2 = true;
                }
                if (!z || !z2) {
                }
            }
            linkedList.add(new com.urbandroid.sleep.domain.interval.Interval(from, to));
        }
        return linkedList;
    }

    private void setVisibility(View view, boolean z, int i) {
        setVisibility(view, z, i, true);
    }

    public void init(GraphViewMap graphViewMap, SleepRecord sleepRecord) {
        init(graphViewMap.get(R.id.graph), graphViewMap.get(R.id.hypnogram), graphViewMap.get(R.id.noise_graph), graphViewMap.get(R.id.sensor_graph), sleepRecord);
        this.graphs = graphViewMap;
    }
}

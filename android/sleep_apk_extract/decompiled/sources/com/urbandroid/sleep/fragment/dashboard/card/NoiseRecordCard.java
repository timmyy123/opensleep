package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.NoiseActivity;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailHypnogramCard;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.IntervalStyle;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseRecordCard extends DashboardCard<SleepDetailHypnogramCard.SleepRecordViewHolder> {
    private List<Noise> noises;
    private SleepRecord sleepRecord;

    public NoiseRecordCard(Activity activity, SleepRecord sleepRecord, List<Noise> list) {
        super(activity, DashboardCard.Type.NOISE, R.layout.card_noise);
        this.sleepRecord = sleepRecord;
        this.noises = new ArrayList(list);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepDetailHypnogramCard.SleepRecordViewHolder sleepRecordViewHolder) {
        if (sleepRecordViewHolder.itemView != null) {
            GraphView graphView = sleepRecordViewHolder.graph;
            SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(getContext());
            graphView.setRotateYAxisLabels(false);
            graphView.setDoGradient(false);
            graphView.setDrawYAxis(false);
            graphView.setDrawAverage(false);
            graphView.setDoDrawGraphLine(false);
            graphView.setDrawXAxisBars(false);
            graphView.setForceXAxisOffset(false);
            graphView.setDoMirrorGraph(true);
            graphView.resetIntervals();
            sleepGraphInitializer.initNoiseGraph(graphView, this.sleepRecord);
            graphView.setDoTrimming(true);
            graphView.setGradientFullColor(ColorUtil.i(getContext(), R.color.transparent));
            graphView.setGradientTransColor(ColorUtil.i(getContext(), R.color.transparent));
            graphView.setSleepGraphColor(ColorUtil.i(getContext(), R.color.actigraph));
            if (sleepRecordViewHolder.card.findViewById(R.id.left_axis) != null) {
                sleepRecordViewHolder.card.findViewById(R.id.left_axis).setBackgroundColor(ColorUtil.i(getContext(), R.color.actigraph));
            }
            if (sleepRecordViewHolder.card.findViewById(R.id.right_axis) != null) {
                sleepRecordViewHolder.card.findViewById(R.id.right_axis).setBackgroundColor(ColorUtil.i(getContext(), R.color.actigraph));
            }
            if (!graphView.hasIntervalPresentations()) {
                IntervalStyle drawable = new IntervalStyle(EventsUtil.getIntervals(this.sleepRecord.getEvents().getCopiedEvents(), EventLabel.SNORING)).setDrawable(R.drawable.ic_action_noise);
                IntervalStyle.Style style = IntervalStyle.Style.POINT;
                graphView.addIntervalPresentation(drawable.setStyle(style).setColor(ColorUtil.i(getContext(), R.color.primary)).setOffset(75));
                graphView.addIntervalPresentation(new IntervalStyle(EventsUtil.getIntervals(this.sleepRecord.getEvents().getCopiedEvents(), EventLabel.TALK)).setDrawable(R.drawable.ic_action_talk).setStyle(style).setColor(ColorUtil.i(getContext(), R.color.primary)).setOffset(65));
                List<Noise> list = this.noises;
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (Noise noise : this.noises) {
                        arrayList.add(new Interval(noise.getFrom().getTime(), noise.getTo().getTime()));
                    }
                    graphView.setSelectableIntervals(arrayList);
                    graphView.addIntervalPresentation(new IntervalStyle(arrayList).setDrawable(R.drawable.ic_action_mic).setStroke(2).setOffset(35).setStyle(IntervalStyle.Style.LINE).setColor(ColorUtil.i(getContext(), R.color.primary_icon_solid)));
                }
            }
            Calendar calendar = Calendar.getInstance();
            int datestampNumber = DateUtil.getDatestampNumber(calendar.getTime());
            calendar.add(5, -1);
            int datestampNumber2 = DateUtil.getDatestampNumber(calendar.getTime());
            calendar.setTime(this.sleepRecord.getTo());
            if (getContext() instanceof SleepDetailActivity) {
                sleepRecordViewHolder.subtitle.setText("");
            } else {
                int datestampNumber3 = DateUtil.getDatestampNumber(calendar.getTime());
                if (datestampNumber3 == datestampNumber) {
                    sleepRecordViewHolder.subtitle.setText(getContext().getString(R.string.last_night));
                } else {
                    TextView textView = sleepRecordViewHolder.subtitle;
                    if (datestampNumber3 == datestampNumber2) {
                        textView.setText(getContext().getString(R.string.yesterday));
                    } else {
                        textView.setText(new SleepRecordStringBuilder(getContext()).setAppendWeekDay(true).setAppendRange(false).setAppendYearIfOld(true).setAppendDuration(false).build(this.sleepRecord));
                    }
                }
            }
            List<Noise> list2 = this.noises;
            if (list2 != null && list2.size() > 0) {
                if (sleepRecordViewHolder.subtitle.getText() == null || sleepRecordViewHolder.subtitle.getText().equals("")) {
                    TextView textView2 = sleepRecordViewHolder.subtitle;
                    StringBuilder sb = new StringBuilder();
                    sb.append(getContext().getResources().getString(R.string.displaying_records_count, Integer.valueOf(this.noises.size())));
                    sb.append(this.noises.size() >= 99 ? MqttTopic.SINGLE_LEVEL_WILDCARD : "");
                    textView2.setText(sb.toString());
                } else {
                    TextView textView3 = sleepRecordViewHolder.subtitle;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((Object) sleepRecordViewHolder.subtitle.getText());
                    sb2.append("\n");
                    sb2.append(getContext().getResources().getString(R.string.displaying_records_count, Integer.valueOf(this.noises.size())));
                    sb2.append(this.noises.size() >= 99 ? MqttTopic.SINGLE_LEVEL_WILDCARD : "");
                    textView3.setText(sb2.toString());
                }
            }
            sleepRecordViewHolder.title.setText(getContext().getText(R.string.noise));
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepDetailHypnogramCard.SleepRecordViewHolder createViewHolder(View view) {
        return new SleepDetailHypnogramCard.SleepRecordViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.noise;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        Intent intent = new Intent(getContext(), (Class<?>) NoiseActivity.class);
        intent.putExtra("noise_from", this.sleepRecord.getFromTime());
        intent.putExtra("noise_to", this.sleepRecord.getToTime());
        intent.putExtra("noise_timezone", this.sleepRecord.getTimeZone());
        getContext().startActivity(intent);
    }
}

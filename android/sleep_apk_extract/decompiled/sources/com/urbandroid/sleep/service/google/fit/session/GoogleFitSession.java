package com.urbandroid.sleep.service.google.fit.session;

import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Session;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.session.AbstractHealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.sleep.service.health.session.HealthSessionSegmentKt;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionMerger;
import com.urbandroid.util.DateUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class GoogleFitSession extends AbstractHealthSession implements WalkingSensorSessionContainer<GoogleFitWalkingSensorSession> {
    private static final List<String> SPORT_ACTIVITIES = Arrays.asList("aerobics", "baseball", "badminton", "basketball", "biathlon", "biking", "biking.hand", "biking.mountain", "biking.road", "biking.spinning", "biking.stationary", "biking.utility", "boxing", "calisthenics", "circuit_training", "cricket", "curling", "dancing", "diving", "elliptical", "ergometer", "fencing", "football.american", "football.australian", "football.soccer", "frisbee_disc", "golf", "gymnastics", "handball", "hiking", "hockey", "horseback_riding", "ice_skating", "jump_rope", "kayaking", "kettlebell_training", "kick_scooter", "kickboxing", "kitesurfing", "martial_arts", "martial_arts.mixed", "paragliding", "pilates", "polo", "racquetball", "rock_climbing", "rowing", "rowing.machine", "rugby", "rugby", "running", "running.jogging", "running.sand", "running.treadmill", "sailing", "scuba_diving", "skateboarding", "skating", "skating.cross", "skating.indoor", "skating.inline", "skiing", "skiing.back_country", "skiing.cross_country", "skiing.downhill", "skiing.kite", "skiing.roller", "sledding", "snowboarding", "snowmobile", "snowshoeing", "squash", "stair_climbing", "stair_climbing.machine", "standup_paddleboarding", "strength_training", "surfing", "swimming", "swimming.pool", "swimming.open_water", "table_tennis", "team_sports", "tennis", "tilting", "treadmill", "volleyball", "volleyball.beach", "volleyball.indoor", "wakeboarding", "walking", "walking.fitness", "walking.nordic", "walking.treadmill", "water_polo", "weightlifting", "windsurfing", "yoga", "zumba");
    private final DataSet activitySegments;
    private final Session session;
    private final Collection<GoogleFitWalkingSensorSession> walkingSessions;

    /* JADX WARN: Illegal instructions before constructor call */
    public GoogleFitSession(Session session, List<DataSet> list, List<DataSet> list2) {
        String identifier = session.getIdentifier();
        DataSourceProvider dataSourceProviderFind = session.getAppPackageName() == null ? HealthDataSourceProvider.SLEEP : HealthDataSourceProvider.find(session.getAppPackageName());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        super(identifier, dataSourceProviderFind, new Date(session.getStartTime(timeUnit)), new Date(session.getEndTime(timeUnit)));
        this.session = session;
        DataSet dataSet = (list == null || list.isEmpty()) ? null : list.get(0);
        this.activitySegments = dataSet;
        if (dataSet != null) {
            Iterator<DataPoint> it = dataSet.getDataPoints().iterator();
            while (it.hasNext()) {
                addSegment(it.next());
            }
            Collections.sort(getSegments(), new Comparator<HealthSessionSegment>() { // from class: com.urbandroid.sleep.service.google.fit.session.GoogleFitSession.1
                @Override // java.util.Comparator
                public int compare(HealthSessionSegment healthSessionSegment, HealthSessionSegment healthSessionSegment2) {
                    return Long.compare(healthSessionSegment.getFromInMillis(), healthSessionSegment2.getFromInMillis());
                }
            });
        }
        if (list2 != null) {
            this.walkingSessions = mergeWalkingSessions(list2);
        } else {
            this.walkingSessions = null;
        }
    }

    private void addSegment(DataPoint dataPoint) {
        GoogleFitSessionSegment googleFitSessionSegmentCreate = GoogleFitSessionSegment.create(dataPoint);
        if (googleFitSessionSegmentCreate.getSleepSegmentType() == null && googleFitSessionSegmentCreate.getFromInMillis() == getFromInMillis() && googleFitSessionSegmentCreate.getToInMillis() == getToInMillis()) {
            return;
        }
        getSegments().add(googleFitSessionSegmentCreate);
    }

    private Collection<GoogleFitWalkingSensorSession> mergeWalkingSessions(List<DataSet> list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        WalkingSensorSessionMerger walkingSensorSessionMerger = new WalkingSensorSessionMerger(new WalkingSensorSessionMerger.WalkingSensorSessionFactory<GoogleFitWalkingSensorSession>() { // from class: com.urbandroid.sleep.service.google.fit.session.GoogleFitSession.2
            @Override // com.urbandroid.sleep.service.health.session.WalkingSensorSessionMerger.WalkingSensorSessionFactory
            public GoogleFitWalkingSensorSession create(long j, long j2, int i) {
                return new GoogleFitWalkingSensorSession(j, j2, i);
            }
        });
        Iterator<DataSet> it = list.iterator();
        while (it.hasNext()) {
            for (DataPoint dataPoint : it.next().getDataPoints()) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                walkingSensorSessionMerger.add(new GoogleFitWalkingSensorSession(dataPoint.getStartTime(timeUnit), dataPoint.getEndTime(timeUnit), dataPoint.getValue(Field.FIELD_STEPS).asInt()));
            }
        }
        return walkingSensorSessionMerger.merge().getWalkingSessions();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return this.session.getActivity();
    }

    @Override // com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer
    public Collection<GoogleFitWalkingSensorSession> getWalkingSessions() {
        return this.walkingSessions;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        return "sleep".equals(getActivity());
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        return SPORT_ACTIVITIES.contains(getActivity());
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        return "walking".equals(getActivity()) || "walking.fitness".equals(getActivity()) || "walking.nordic".equals(getActivity()) || "walking.treadmill".equals(getActivity());
    }

    public Session toSession() {
        return this.session;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public SleepRecord toSleepRecord() {
        if (getActivity() == null || !getActivity().equals("sleep")) {
            Fragment$$ExternalSyntheticBUOutline0.m$1("Converting non sleep activity(", getActivity(), ") to Sleep Record");
            return null;
        }
        SleepRecord sleepRecord = new SleepRecord(getFrom(), getTo(), getTimeZoneId());
        for (HealthSessionSegment healthSessionSegment : getSegments()) {
            SleepSegmentType sleepSegmentType = healthSessionSegment.getSleepSegmentType();
            if (sleepSegmentType == null || !HealthSessionSegmentKt.isInside(healthSessionSegment, getFromInMillis(), getToInMillis())) {
                Logger.logWarning("toSleepRecord: fit wrong segment: " + HeathSyncKt.pretty(healthSessionSegment));
            } else {
                sleepRecord.addEventLabel(sleepSegmentType.getStartLabel(), healthSessionSegment.getFromInMillis());
                sleepRecord.addEventLabel(sleepSegmentType.getEndLabel(), healthSessionSegment.getToInMillis());
            }
        }
        return sleepRecord;
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession
    public String toString() {
        return getClass().getSimpleName() + "{provider=" + getProvider() + ", id=" + getId() + ", activity=" + getActivity() + ", from=" + DateUtils.toReadableDate(getFromInMillis()) + ", to=" + DateUtils.toReadableDate(getToInMillis()) + ", segments=" + HeathSyncKt.pretty(HeathSyncKt.ordered(getSegments())) + "}\n";
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthInterval, com.urbandroid.sleep.service.health.session.HealthInterval
    public EventInterval toWalkingEventInterval() {
        if (isWalkingActivity()) {
            return new EventInterval(new Event(getFromInMillis(), EventLabel.WALKING_START), new Event(getToInMillis(), EventLabel.WALKING_END));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Converting non walking activity into event interval");
        return null;
    }
}

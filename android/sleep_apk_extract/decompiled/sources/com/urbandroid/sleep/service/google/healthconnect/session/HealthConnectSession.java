package com.urbandroid.sleep.service.google.healthconnect.session;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.metadata.Device;
import androidx.health.connect.client.records.metadata.Metadata;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSleepSegmentTypeKt;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.session.AbstractHealthInterval;
import com.urbandroid.sleep.service.health.session.AbstractHealthSession;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.sleep.service.health.session.HealthSessionSegmentKt;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import com.urbandroid.sleep.service.health.session.idresolver.FromToIdResolver;
import com.urbandroid.util.TimeZoneUtils;
import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.util.DateRetargetClass;
import j$.util.DesugarDate;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010#\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010)\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"¨\u0006+"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSession;", "Landroidx/health/connect/client/records/SleepSessionRecord;", "session", "", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "stages", "Lcom/urbandroid/sleep/service/health/DataSourceProvider;", "provider", "<init>", "(Landroidx/health/connect/client/records/SleepSessionRecord;Ljava/util/List;Lcom/urbandroid/sleep/service/health/DataSourceProvider;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/urbandroid/sleep/domain/SleepRecord;", "toSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Landroidx/health/connect/client/records/SleepSessionRecord;", "getSession", "()Landroidx/health/connect/client/records/SleepSessionRecord;", "Ljava/util/List;", "getStages", "()Ljava/util/List;", "", "Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "segments", "getSegments", "", "getActivity", "()Ljava/lang/String;", "activity", "isSportActivity", "()Z", "isWalkingActivity", "isSleepActivity", "getId", "id", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthConnectSession extends AbstractHealthSession {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<HealthSessionSegment> segments;
    private final SleepSessionRecord session;
    private final List<SleepSessionRecord.Stage> stages;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession$Companion;", "", "<init>", "()V", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "healthSession", "", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "toHealthConnectSleepNewStages", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;)Ljava/util/List;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "session", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "Landroidx/health/connect/client/records/SleepSessionRecord;", "toHealthConnectSleepSession", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/health/session/HealthSession;Landroidx/health/connect/client/records/metadata/Metadata;)Landroidx/health/connect/client/records/SleepSessionRecord;", "", "from", "to", "", "resolveId", "(JJ)Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<SleepSessionRecord.Stage> toHealthConnectSleepNewStages(HealthSession healthSession) {
            List<HealthSessionSegment> segments = healthSession.getSegments();
            ArrayList arrayList = new ArrayList();
            for (HealthSessionSegment healthSessionSegment : segments) {
                SleepSegmentType sleepSegmentType = healthSessionSegment.getSleepSegmentType();
                SleepSessionRecord.Stage stage = null;
                Integer numValueOf = sleepSegmentType != null ? Integer.valueOf(HealthConnectSleepSegmentTypeKt.toHealthConnectStageType(sleepSegmentType)) : null;
                Date to = healthSessionSegment.getTo();
                Instant instant = to != null ? DateRetargetClass.toInstant(to) : null;
                if (numValueOf != null && instant != null) {
                    Instant instant2 = DateRetargetClass.toInstant(healthSessionSegment.getFrom());
                    instant2.getClass();
                    stage = new SleepSessionRecord.Stage(instant2, instant, numValueOf.intValue());
                }
                if (stage != null) {
                    arrayList.add(stage);
                }
            }
            return arrayList;
        }

        public final String resolveId(long from, long to) {
            String strResolveId = FromToIdResolver.resolveId(from, to);
            strResolveId.getClass();
            return strResolveId;
        }

        public final SleepSessionRecord toHealthConnectSleepSession(Context context, HealthSession session, androidx.health.connect.client.records.metadata.Metadata metadata) {
            context.getClass();
            session.getClass();
            metadata.getClass();
            Date to = session.getTo();
            Instant instant = to != null ? DateRetargetClass.toInstant(to) : null;
            Instant instant2 = DateRetargetClass.toInstant(session.getFrom());
            ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(DesugarTimeZone.getTimeZone(session.getTimeZoneId()).getOffset(session.getFrom().getTime()) / 1000);
            Date to2 = session.getTo();
            ZoneOffset zoneOffsetOfTotalSeconds2 = to2 != null ? ZoneOffset.ofTotalSeconds(DesugarTimeZone.getTimeZone(session.getTimeZoneId()).getOffset(to2.getTime()) / 1000) : zoneOffsetOfTotalSeconds;
            long epochMilli = instant2.toEpochMilli();
            Long lValueOf = instant != null ? Long.valueOf(instant.toEpochMilli()) : null;
            Logger.logInfo("toHealthConnectSleepSession " + epochMilli + " - " + lValueOf + " zone " + session.getTimeZoneId() + " offset " + zoneOffsetOfTotalSeconds, null);
            if (instant == null || instant.toEpochMilli() <= instant2.toEpochMilli()) {
                return null;
            }
            String strResolveId = resolveId(instant2.toEpochMilli(), instant.toEpochMilli());
            Metadata.Companion companion = androidx.health.connect.client.records.metadata.Metadata.INSTANCE;
            Device device = metadata.getDevice();
            if (device == null) {
                device = new Device(2, Build.MANUFACTURER, Build.MODEL);
            }
            return new SleepSessionRecord(instant2, zoneOffsetOfTotalSeconds, instant, zoneOffsetOfTotalSeconds2, Metadata.Companion.activelyRecorded$default(companion, device, strResolveId, 0L, 4, null), context.getString(R.string.app_name_long), session.getSleepRecord().getComment(), toHealthConnectSleepNewStages(session));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HealthConnectSession(SleepSessionRecord sleepSessionRecord, List<SleepSessionRecord.Stage> list, DataSourceProvider dataSourceProvider) {
        String id;
        ZoneOffset startZoneOffset;
        sleepSessionRecord.getClass();
        list.getClass();
        dataSourceProvider.getClass();
        String clientRecordId = sleepSessionRecord.getMetadata().getClientRecordId();
        String strResolveId = clientRecordId == null ? INSTANCE.resolveId(sleepSessionRecord.getStartTime().toEpochMilli(), sleepSessionRecord.getEndTime().toEpochMilli()) : clientRecordId;
        Date dateFrom = DesugarDate.from(sleepSessionRecord.getStartTime());
        dateFrom.getClass();
        Date dateFrom2 = DesugarDate.from(sleepSessionRecord.getEndTime());
        dateFrom2.getClass();
        if (sleepSessionRecord.getStartZoneOffset() == null || ((startZoneOffset = sleepSessionRecord.getStartZoneOffset()) != null && startZoneOffset.getTotalSeconds() == 0)) {
            id = TimeZone.getDefault().getID();
            long epochMilli = sleepSessionRecord.getStartTime().toEpochMilli();
            long epochMilli2 = sleepSessionRecord.getEndTime().toEpochMilli();
            ZoneOffset startZoneOffset2 = sleepSessionRecord.getStartZoneOffset();
            ZoneOffset endZoneOffset = sleepSessionRecord.getEndZoneOffset();
            String id2 = TimeZone.getDefault().getID();
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("fromHealthConnectSleepSession ", " - ", epochMilli);
            sbM.append(epochMilli2);
            sbM.append(" offset ");
            sbM.append(startZoneOffset2);
            sbM.append(" ");
            sbM.append(endZoneOffset);
            sbM.append(" zone default ");
            sbM.append(id2);
            Logger.logInfo(sbM.toString(), null);
            Unit unit = Unit.INSTANCE;
        } else {
            id = String.valueOf(sleepSessionRecord.getStartZoneOffset() != null ? TimeZoneUtils.resolveFix(r0.getTotalSeconds(), TimeUnit.SECONDS).getID() : null);
            long epochMilli3 = sleepSessionRecord.getStartTime().toEpochMilli();
            long epochMilli4 = sleepSessionRecord.getEndTime().toEpochMilli();
            ZoneOffset startZoneOffset3 = sleepSessionRecord.getStartZoneOffset();
            ZoneOffset endZoneOffset2 = sleepSessionRecord.getEndZoneOffset();
            StringBuilder sbM2 = FileInsert$$ExternalSyntheticOutline0.m("fromHealthConnectSleepSession ", " - ", epochMilli3);
            sbM2.append(epochMilli4);
            sbM2.append(" offset ");
            sbM2.append(startZoneOffset3);
            sbM2.append(" ");
            sbM2.append(endZoneOffset2);
            sbM2.append(" zone ");
            sbM2.append(id);
            Logger.logInfo(sbM2.toString(), null);
            Unit unit2 = Unit.INSTANCE;
        }
        String str = id;
        str.getClass();
        super(strResolveId, dataSourceProvider, dateFrom, dateFrom2, str);
        this.session = sleepSessionRecord;
        this.stages = list;
        List<SleepSessionRecord.Stage> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(HealthConnectSessionSegment.INSTANCE.fromHealthConnectSleepStage((SleepSessionRecord.Stage) it.next()));
        }
        this.segments = CollectionsKt.toMutableList((Collection) arrayList);
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthSession)) {
            return false;
        }
        Companion companion = INSTANCE;
        AbstractHealthInterval abstractHealthInterval = (AbstractHealthInterval) other;
        return Intrinsics.areEqual(companion.resolveId(DateRetargetClass.toInstant(getFrom()).toEpochMilli(), DateRetargetClass.toInstant(getTo()).toEpochMilli()), companion.resolveId(DateRetargetClass.toInstant(abstractHealthInterval.getFrom()).toEpochMilli(), DateRetargetClass.toInstant(abstractHealthInterval.getTo()).toEpochMilli()));
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return "SleepSession";
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession, com.urbandroid.sleep.service.health.session.HealthSession
    public String getId() {
        return INSTANCE.resolveId(DateRetargetClass.toInstant(getFrom()).toEpochMilli(), DateRetargetClass.toInstant(getTo()).toEpochMilli());
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession, com.urbandroid.sleep.service.health.session.HealthSession
    public List<HealthSessionSegment> getSegments() {
        return this.segments;
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession, com.urbandroid.sleep.service.health.session.AbstractHealthInterval
    public int hashCode() {
        return this.session.getEndTime().hashCode() + ((this.session.getStartTime().hashCode() + (super.hashCode() * 31)) * 31);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: toSleepRecord */
    public SleepRecord getSleepRecord() {
        if (!isSleepActivity()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m("Converting non sleep activity(", getActivity(), ") to Sleep Record"));
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
}

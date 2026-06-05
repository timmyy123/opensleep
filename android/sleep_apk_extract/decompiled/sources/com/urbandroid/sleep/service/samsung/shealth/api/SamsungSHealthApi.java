package com.urbandroid.sleep.service.samsung.shealth.api;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import com.samsung.android.sdk.healthdata.HealthDataService;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.HealthDeviceManager;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.health.ExceptionResultStatus;
import com.urbandroid.sleep.service.health.GroupResultStatus;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.ResultStatus;
import com.urbandroid.sleep.service.health.api.AbstractHealthApi;
import com.urbandroid.sleep.service.health.api.BaseHealthUserProfile;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.api.HealthUserProfile;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionMerger;
import com.urbandroid.sleep.service.health.session.idresolver.FromToSegmentIdResolver;
import com.urbandroid.sleep.service.health.session.idresolver.IdResolver;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthResultStatus;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSleepSegmentType;
import com.urbandroid.sleep.service.samsung.shealth.session.SamsungSHealthSession;
import com.urbandroid.sleep.service.samsung.shealth.session.SamsungSHealthSessionSegment;
import com.urbandroid.sleep.service.samsung.shealth.session.SamsungSHealthWalkingSensorSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSHealthApi extends AbstractHealthApi<SamsungSHealthSession> implements HealthDataStore.ConnectionListener {
    public static final Set<HealthPermissionManager.PermissionKey> ALL_PERMISSIONS;
    public static final Set<HealthPermissionManager.PermissionKey> EXERCISE_PERMISSIONS;
    public static final Set<HealthPermissionManager.PermissionKey> HEART_RATE_PERMISSIONS;
    public static final Set<HealthPermissionManager.PermissionKey> MANDATORY_PERMISSIONS;
    public static final HealthPermissionManager.PermissionKey PROFILE_READ_PERMISSION;
    public static final Set<HealthPermissionManager.PermissionKey> SLEEP_PERMISSIONS;
    public static final Set<HealthPermissionManager.PermissionKey> SLEEP_STAGE_PERMISSIONS;
    public static final HealthPermissionManager.PermissionKey SLEEP_STAGE_READ_PERMISSION;
    public static final HealthPermissionManager.PermissionKey SLEEP_STAGE_WRITE_PERMISSION;
    public static final Set<HealthPermissionManager.PermissionKey> STEPS_PERMISSIONS;
    private CountDownLatch connectLatch;
    private final SamsungSHealthConnectionListener connectionListener;
    private final Context context;
    private final HealthDataStore dataStore;
    private final boolean fullSynchronization;
    private final Handler handler;
    private final AtomicBoolean isConnected = new AtomicBoolean(false);
    private final AtomicBoolean isConnecting = new AtomicBoolean(false);
    private final IdResolver idResolver = new FromToSegmentIdResolver();

    public interface PermissionListener {
        void permissionFailed();

        void permissionResult(Map<HealthPermissionManager.PermissionKey, Boolean> map);
    }

    public interface ReadDataProcessor {
        void dataReceived(Cursor cursor);
    }

    static {
        HealthPermissionManager.PermissionType permissionType = HealthPermissionManager.PermissionType.READ;
        HealthPermissionManager.PermissionKey permissionKey = new HealthPermissionManager.PermissionKey("com.samsung.health.user_profile", permissionType);
        PROFILE_READ_PERMISSION = permissionKey;
        HealthPermissionManager.PermissionKey permissionKey2 = new HealthPermissionManager.PermissionKey("com.samsung.health.sleep", permissionType);
        HealthPermissionManager.PermissionType permissionType2 = HealthPermissionManager.PermissionType.WRITE;
        HashSet hashSet = new HashSet(Arrays.asList(permissionKey2, new HealthPermissionManager.PermissionKey("com.samsung.health.sleep", permissionType2)));
        SLEEP_PERMISSIONS = hashSet;
        HealthPermissionManager.PermissionKey permissionKey3 = new HealthPermissionManager.PermissionKey("com.samsung.health.sleep_stage", permissionType);
        SLEEP_STAGE_READ_PERMISSION = permissionKey3;
        HealthPermissionManager.PermissionKey permissionKey4 = new HealthPermissionManager.PermissionKey("com.samsung.health.sleep_stage", permissionType2);
        SLEEP_STAGE_WRITE_PERMISSION = permissionKey4;
        HashSet hashSet2 = new HashSet(Arrays.asList(permissionKey3, permissionKey4));
        SLEEP_STAGE_PERMISSIONS = hashSet2;
        HashSet hashSet3 = new HashSet(Collections.singletonList(new HealthPermissionManager.PermissionKey("com.samsung.health.exercise", permissionType)));
        EXERCISE_PERMISSIONS = hashSet3;
        HashSet hashSet4 = new HashSet(Collections.singletonList(new HealthPermissionManager.PermissionKey("com.samsung.health.heart_rate", permissionType)));
        HEART_RATE_PERMISSIONS = hashSet4;
        HashSet hashSet5 = new HashSet(Collections.singletonList(new HealthPermissionManager.PermissionKey("com.samsung.health.step_count", permissionType)));
        STEPS_PERMISSIONS = hashSet5;
        HashSet hashSet6 = new HashSet();
        ALL_PERMISSIONS = hashSet6;
        hashSet6.addAll(hashSet);
        hashSet6.addAll(hashSet2);
        hashSet6.addAll(hashSet3);
        hashSet6.addAll(hashSet4);
        hashSet6.addAll(hashSet5);
        hashSet6.add(permissionKey);
        HashSet hashSet7 = new HashSet();
        MANDATORY_PERMISSIONS = hashSet7;
        hashSet7.addAll(hashSet);
        hashSet7.addAll(hashSet2);
    }

    public SamsungSHealthApi(Context context, Handler handler, SamsungSHealthConnectionListener samsungSHealthConnectionListener, boolean z) {
        this.context = context;
        this.handler = handler;
        try {
            Looper.prepare();
        } catch (Exception unused) {
        }
        this.dataStore = new HealthDataStore(context, this);
        this.connectionListener = samsungSHealthConnectionListener;
        this.fullSynchronization = z;
        try {
            new HealthDataService().initialize(context);
        } catch (Exception e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            throw null;
        }
    }

    private void appendSleepStages(final Map<String, SamsungSHealthSession> map, Date date, Date date2) {
        if (!hasPermission(SLEEP_STAGE_READ_PERMISSION) || map.isEmpty()) {
            return;
        }
        HealthDataResolver.Filter filterAnd = HealthDataResolver.Filter.and(HealthDataResolver.Filter.greaterThanEquals("start_time", Long.valueOf(date.getTime())), HealthDataResolver.Filter.lessThanEquals(SDKConstants.PARAM_TOURNAMENTS_END_TIME, Long.valueOf(date2.getTime())), HealthDataResolver.Filter.in("sleep_id", (String[]) map.keySet().toArray(new String[map.size()])));
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        find(filterAnd, new ReadDataProcessor() { // from class: com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.2
            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.ReadDataProcessor
            public void dataReceived(Cursor cursor) {
                long j = cursor.getLong(cursor.getColumnIndex("start_time"));
                long j2 = cursor.getLong(cursor.getColumnIndex(SDKConstants.PARAM_TOURNAMENTS_END_TIME));
                int i = cursor.getInt(cursor.getColumnIndex("stage"));
                SamsungSHealthSession samsungSHealthSession = (SamsungSHealthSession) map.get(cursor.getString(cursor.getColumnIndex("sleep_id")));
                if (samsungSHealthSession != null) {
                    samsungSHealthSession.addSegment(SamsungSHealthSessionSegment.create(i, j, j2));
                    atomicInteger.incrementAndGet();
                }
            }
        }, true, "com.samsung.health.sleep_stage");
    }

    private ResultStatus deleteSleepStages(Set<String> set) {
        try {
            return new SamsungSHealthResultStatus(new HealthDataResolver(this.dataStore, this.handler).delete(new HealthDataResolver.DeleteRequest.Builder().setDataType("com.samsung.health.sleep_stage").setFilter(HealthDataResolver.Filter.in("sleep_id", (String[]) set.toArray(new String[set.size()]))).build()).await());
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            Logger.logSevere("Delete S Health Sleep Stages fails.", e2);
            return new ExceptionResultStatus(e2);
        }
    }

    private void find(HealthDataResolver.Filter filter, ReadDataProcessor readDataProcessor, boolean z, String str) {
        HealthDataResolver healthDataResolver = new HealthDataResolver(this.dataStore, this.handler);
        HealthDataResolver.ReadRequest.Builder filter2 = new HealthDataResolver.ReadRequest.Builder().setDataType(str).setFilter(filter);
        if (!z) {
            filter2.setPackageName(this.context.getPackageName());
        }
        try {
            HealthDataResolver.ReadResult readResult = (HealthDataResolver.ReadResult) healthDataResolver.read(filter2.build()).await();
            if (readResult.getStatus() != 1) {
                return;
            }
            Cursor resultCursor = readResult.getResultCursor();
            if (resultCursor == null) {
                Logger.logInfo("There is no result.");
                return;
            }
            while (resultCursor.moveToNext()) {
                readDataProcessor.dataReceived(resultCursor);
            }
            resultCursor.close();
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            Logger.logSevere("Reading S Health data fails.", e2);
        }
    }

    private String format(HealthPermissionManager.PermissionKey permissionKey) {
        String dataType = permissionKey.getDataType();
        if (dataType.startsWith("com.samsung.health.")) {
            dataType = dataType.substring(19);
        }
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(dataType, "-");
        sbM.append(permissionKey.getPermissionType().name().toLowerCase());
        return sbM.toString();
    }

    public void asynchConnect() {
        TrialFilter trialFilter = TrialFilter.getInstance();
        StringBuilder sb = new StringBuilder("S Health version: ");
        sb.append(trialFilter.isSamsungSHealth() ? trialFilter.getSamsungSHealthPackageInfo().versionName : "unknown");
        Logger.logInfo(sb.toString());
        this.dataStore.connectService();
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public boolean connect() {
        TrialFilter trialFilter = TrialFilter.getInstance();
        StringBuilder sb = new StringBuilder("S Health version: ");
        sb.append(trialFilter.isSamsungSHealth() ? trialFilter.getSamsungSHealthPackageInfo().versionName : "unknown");
        Logger.logInfo(sb.toString());
        this.connectLatch = new CountDownLatch(1);
        this.dataStore.connectService();
        try {
            boolean zAwait = this.connectLatch.await(30L, TimeUnit.SECONDS);
            Logger.logInfo("S Health connected: " + zAwait);
            if (!zAwait) {
                return false;
            }
            if (!hasPermissions(SLEEP_PERMISSIONS)) {
                if (!hasPermissions(EXERCISE_PERMISSIONS)) {
                    return false;
                }
            }
            return true;
        } catch (InterruptedException unused) {
            this.onDisconnected();
            return false;
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public int count() {
        if (!hasPermissions(SLEEP_PERMISSIONS)) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -10);
        return find(calendar.getTime(), new Date(), false, "com.samsung.health.sleep", false).size();
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<SamsungSHealthSession> collection) {
        if (collection == null || collection.isEmpty()) {
            return ResultStatus.SUCCESS;
        }
        if (!hasPermissions(SLEEP_PERMISSIONS)) {
            Logger.logWarning("S Health - No permission for delete sleep records");
            return ResultStatus.FAILURE;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<SamsungSHealthSession> it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getUuid());
        }
        try {
            SamsungSHealthResultStatus samsungSHealthResultStatus = new SamsungSHealthResultStatus(new HealthDataResolver(this.dataStore, this.handler).delete(new HealthDataResolver.DeleteRequest.Builder().setDataType("com.samsung.health.sleep").setFilter(HealthDataResolver.Filter.in("datauuid", (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]))).build()).await());
            return samsungSHealthResultStatus.isSuccess() ? deleteSleepStages(linkedHashSet) : samsungSHealthResultStatus;
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            Logger.logSevere("Delete S Health data fails.", e2);
            return new ExceptionResultStatus(e2);
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public void disconnect() {
        this.dataStore.disconnectService();
        Logger.logInfo("S Health disconnected");
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public IdResolver getIdResolver() {
        return this.idResolver;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public HealthUserProfile getUserProfile() {
        Date date = null;
        try {
            if (!hasPermission(PROFILE_READ_PERMISSION)) {
                Logger.logWarning("S Health - no permission for reading user profile");
                return null;
            }
            try {
                com.samsung.android.sdk.healthdata.HealthUserProfile profile = com.samsung.android.sdk.healthdata.HealthUserProfile.getProfile(this.dataStore);
                Logger.logInfo("S Health - user profile: " + profile);
                String birthDate = profile.getBirthDate();
                if (birthDate != null && birthDate.length() == 8) {
                    try {
                        date = new SimpleDateFormat("yyyyMMdd").parse(birthDate);
                    } catch (ParseException unused) {
                        Logger.logInfo("S Health - Invalid birthDate: ".concat(birthDate));
                    }
                }
                int gender = profile.getGender();
                return new BaseHealthUserProfile(date, gender == 1 ? HealthUserProfile.Gender.MALE : gender == 2 ? HealthUserProfile.Gender.FEMALE : HealthUserProfile.Gender.UNKNOWN, profile.getHeight(), profile.getWeight());
            } catch (Exception e) {
                Logger.logWarning("S Health get profile call failure: ", e);
                return null;
            }
        } catch (IllegalArgumentException e2) {
            Logger.logWarning("S Health get profile failure: ", e2);
            return null;
        }
    }

    public boolean hasPermission(HealthPermissionManager.PermissionKey permissionKey) {
        return hasPermissions(Collections.singleton(permissionKey));
    }

    public boolean hasPermissions(Set<HealthPermissionManager.PermissionKey> set) {
        try {
            return !new HealthPermissionManager(this.dataStore).isPermissionAcquired(set).containsValue(Boolean.FALSE);
        } catch (Exception e) {
            Logger.logWarning("Getting " + set + " failure", e);
            return false;
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insert(HealthSession healthSession) {
        if (!hasPermissions(SLEEP_PERMISSIONS)) {
            Logger.logWarning("S Health - No permission for inserting sleep records");
            return ResultStatus.FAILURE;
        }
        Interval interval = HealthIntervalKt.toInterval(healthSession);
        HealthDataResolver healthDataResolver = new HealthDataResolver(this.dataStore, this.handler);
        TimeZone timeZone = healthSession.toSleepRecord().getTimeZone();
        HealthDataResolver.InsertRequest insertRequestBuild = new HealthDataResolver.InsertRequest.Builder().setDataType("com.samsung.health.sleep").build();
        HealthData healthData = new HealthData();
        healthData.putLong("start_time", interval.getFrom());
        healthData.putLong(SDKConstants.PARAM_TOURNAMENTS_END_TIME, interval.getTo());
        healthData.putLong("time_offset", timeZone.getOffset(interval.getFrom()));
        healthData.setSourceDevice(new HealthDeviceManager(this.dataStore).getLocalDevice().getUuid());
        insertRequestBuild.addHealthData(healthData);
        try {
            SamsungSHealthResultStatus samsungSHealthResultStatus = new SamsungSHealthResultStatus(healthDataResolver.insert(insertRequestBuild).await());
            if (!samsungSHealthResultStatus.isSuccess() || !hasPermission(SLEEP_STAGE_WRITE_PERMISSION) || !healthSession.hasSegments()) {
                return samsungSHealthResultStatus;
            }
            GroupResultStatus groupResultStatus = new GroupResultStatus();
            groupResultStatus.add(samsungSHealthResultStatus);
            HealthDataResolver.InsertRequest insertRequestBuild2 = new HealthDataResolver.InsertRequest.Builder().setDataType("com.samsung.health.sleep_stage").build();
            String uuid = new HealthDeviceManager(this.dataStore).getLocalDevice().getUuid();
            for (HealthSessionSegment healthSessionSegment : healthSession.getSegments()) {
                HealthData healthData2 = new HealthData();
                Interval interval2 = HealthIntervalKt.toInterval(healthSessionSegment);
                healthData2.putString("sleep_id", healthData.getUuid());
                healthData2.putInt("stage", SamsungSHealthSleepSegmentType.find(healthSessionSegment.getSleepSegmentType()));
                healthData2.putLong("start_time", interval2.getFrom());
                healthData2.putLong(SDKConstants.PARAM_TOURNAMENTS_END_TIME, interval2.getTo());
                healthData2.putLong("time_offset", timeZone.getOffset(interval2.getFrom()));
                healthData2.setSourceDevice(uuid);
                insertRequestBuild2.addHealthData(healthData2);
            }
            try {
                groupResultStatus.add(new SamsungSHealthResultStatus(healthDataResolver.insert(insertRequestBuild2).await()));
                return groupResultStatus;
            } catch (SecurityException e) {
                throw e;
            } catch (Exception e2) {
                Logger.logSevere("Insert S Health data - sleep stages fails.", e2);
                return new ExceptionResultStatus(e2);
            }
        } catch (SecurityException e3) {
            throw e3;
        } catch (Exception e4) {
            Logger.logSevere("Insert S Health data fails.", e4);
            return new ExceptionResultStatus(e4);
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    /* JADX INFO: renamed from: isConnected */
    public boolean getIsConnected() {
        return this.isConnected.get();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataStore.ConnectionListener
    public void onConnected() {
        this.isConnected.set(true);
        this.isConnecting.set(false);
        CountDownLatch countDownLatch = this.connectLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        SamsungSHealthConnectionListener samsungSHealthConnectionListener = this.connectionListener;
        if (samsungSHealthConnectionListener != null) {
            samsungSHealthConnectionListener.onConnected(this);
        }
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataStore.ConnectionListener
    public void onConnectionFailed(HealthConnectionErrorResult healthConnectionErrorResult) {
        CountDownLatch countDownLatch = this.connectLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        this.isConnected.set(false);
        this.isConnecting.set(false);
        SamsungSHealthConnectionListener samsungSHealthConnectionListener = this.connectionListener;
        if (samsungSHealthConnectionListener != null) {
            samsungSHealthConnectionListener.onConnectionFailed(healthConnectionErrorResult);
        }
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataStore.ConnectionListener
    public void onDisconnected() {
        this.isConnected.set(false);
        this.isConnecting.set(false);
    }

    public void printPermissions() {
        try {
            Map<HealthPermissionManager.PermissionKey, Boolean> mapIsPermissionAcquired = new HealthPermissionManager(this.dataStore).isPermissionAcquired(ALL_PERMISSIONS);
            Logger.logInfo("S Health permissions:");
            for (Map.Entry<HealthPermissionManager.PermissionKey, Boolean> entry : mapIsPermissionAcquired.entrySet()) {
                Logger.logInfo("\t" + format(entry.getKey()) + ": " + entry.getValue());
            }
        } catch (Exception e) {
            Logger.logWarning("", e);
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.HeartRate> readHeartRateData(Activity activity, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (!hasPermissions(HEART_RATE_PERMISSIONS)) {
            Logger.logWarning("S Health - No permission for reading heart rate records");
            return arrayList;
        }
        HealthDataResolver.AggregateResult aggregateResult = (HealthDataResolver.AggregateResult) new HealthDataResolver(this.dataStore, this.handler).aggregate(new HealthDataResolver.AggregateRequest.Builder().setDataType("com.samsung.health.heart_rate").addFunction(HealthDataResolver.AggregateRequest.AggregateFunction.AVG, "heart_rate", "average").setTimeGroup(HealthDataResolver.AggregateRequest.TimeGroupUnit.MINUTELY, 5, SDKConstants.PARAM_TOURNAMENTS_END_TIME, "time_offset", "groupedMinutes").build()).await();
        if (aggregateResult.getStatus() != 1) {
            Logger.logSevere("Read HR failure: " + aggregateResult.getStatus());
            return arrayList;
        }
        Cursor resultCursor = aggregateResult.getResultCursor();
        if (resultCursor == null) {
            Logger.logInfo("There is no result.");
            return arrayList;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Logger.logInfo("Found HR records: " + resultCursor.getCount());
        while (resultCursor.moveToNext()) {
            float f = resultCursor.getFloat(resultCursor.getColumnIndex("average"));
            String string = resultCursor.getString(resultCursor.getColumnIndex("groupedMinutes"));
            try {
                arrayList.add(new SensorRecord.HeartRate(simpleDateFormat.parse(string).getTime(), f));
            } catch (ParseException e) {
                Logger.logInfo("HR date parse error: " + string, e);
            }
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public WalkingSensorSessionContainer readStepsData(HealthSession healthSession) {
        if (!hasPermissions(STEPS_PERMISSIONS)) {
            Logger.logWarning("S Health - No permission for reading steps");
            return null;
        }
        final WalkingSensorSessionMerger walkingSensorSessionMerger = new WalkingSensorSessionMerger(new WalkingSensorSessionMerger.WalkingSensorSessionFactory<SamsungSHealthWalkingSensorSession>() { // from class: com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.3
            @Override // com.urbandroid.sleep.service.health.session.WalkingSensorSessionMerger.WalkingSensorSessionFactory
            public SamsungSHealthWalkingSensorSession create(long j, long j2, int i) {
                return new SamsungSHealthWalkingSensorSession(j, j2, i);
            }
        });
        find(healthSession.getFrom(), healthSession.getTo(), new ReadDataProcessor() { // from class: com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.4
            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.ReadDataProcessor
            public void dataReceived(Cursor cursor) {
                walkingSensorSessionMerger.add(new SamsungSHealthWalkingSensorSession(cursor.getLong(cursor.getColumnIndex("start_time")), cursor.getLong(cursor.getColumnIndex(SDKConstants.PARAM_TOURNAMENTS_END_TIME)), cursor.getInt(cursor.getColumnIndex("count"))));
            }
        }, true, "com.samsung.health.step_count");
        return walkingSensorSessionMerger.merge();
    }

    public void requestPermission(Activity activity, HealthPermissionManager.PermissionKey permissionKey, PermissionListener permissionListener) {
        requestPermissions(activity, Collections.singleton(permissionKey), permissionListener, false);
    }

    public void requestPermissions(Activity activity, Set<HealthPermissionManager.PermissionKey> set, final PermissionListener permissionListener, boolean z) {
        HealthPermissionManager healthPermissionManager = new HealthPermissionManager(this.dataStore);
        if (z) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (HealthPermissionManager.PermissionKey permissionKey : set) {
                if (!hasPermission(permissionKey)) {
                    linkedHashSet.add(permissionKey);
                }
            }
            set = linkedHashSet;
        }
        if (set.isEmpty()) {
            return;
        }
        try {
            healthPermissionManager.requestPermissions(set, activity).setResultListener(new HealthResultHolder.ResultListener<HealthPermissionManager.PermissionResult>() { // from class: com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.6
                @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.ResultListener
                public void onResult(HealthPermissionManager.PermissionResult permissionResult) {
                    PermissionListener permissionListener2 = permissionListener;
                    if (permissionListener2 == null) {
                        return;
                    }
                    if (permissionResult != null) {
                        permissionListener2.permissionResult(permissionResult.getResultMap());
                    } else {
                        permissionListener2.permissionFailed();
                    }
                }
            });
        } catch (IllegalArgumentException e) {
            Logger.logSevere("S Health request permissions failure", e);
        }
    }

    private Collection<SamsungSHealthSession> find(Date date, Date date2, boolean z, String str) {
        return find(date, date2, z, str, true);
    }

    private Collection<SamsungSHealthSession> find(Date date, Date date2, boolean z, final String str, boolean z2) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        find(date, date2, new ReadDataProcessor() { // from class: com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.1
            @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.ReadDataProcessor
            public void dataReceived(Cursor cursor) {
                String string = cursor.getString(cursor.getColumnIndex("datauuid"));
                linkedHashMap.put(string, new SamsungSHealthSession(HealthDataSourceProvider.find(cursor.getString(cursor.getColumnIndex("pkg_name"))), string, new Date(cursor.getLong(cursor.getColumnIndex("start_time"))), new Date(cursor.getLong(cursor.getColumnIndex(SDKConstants.PARAM_TOURNAMENTS_END_TIME))), cursor.getLong(cursor.getColumnIndex("time_offset")), str, str.equals("com.samsung.health.exercise") ? cursor.getInt(cursor.getColumnIndex("exercise_type")) : 0));
            }
        }, z, str);
        if (str.equals("com.samsung.health.sleep") && z2) {
            appendSleepStages(linkedHashMap, date, date2);
        }
        return linkedHashMap.values();
    }

    private void find(Date date, Date date2, ReadDataProcessor readDataProcessor, boolean z, String str) {
        find(HealthDataResolver.Filter.and(HealthDataResolver.Filter.greaterThanEquals("start_time", Long.valueOf(date.getTime())), HealthDataResolver.Filter.lessThanEquals(SDKConstants.PARAM_TOURNAMENTS_END_TIME, Long.valueOf(date2.getTime()))), readDataProcessor, z, str);
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public Collection<SamsungSHealthSession> find(Date date, Date date2) {
        ArrayList arrayList = new ArrayList();
        if (hasPermissions(SLEEP_PERMISSIONS)) {
            arrayList.addAll(find(date, date2, true, "com.samsung.health.sleep"));
        }
        if (hasPermissions(EXERCISE_PERMISSIONS)) {
            arrayList.addAll(find(date, date2, true, "com.samsung.health.exercise"));
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<SamsungSHealthSession> collection, HealthApi.Listener listener) {
        if (collection != null && !collection.isEmpty()) {
            if (!hasPermissions(SLEEP_PERMISSIONS)) {
                Logger.logWarning("S Health - No permission for delete sleep records");
                return ResultStatus.FAILURE;
            }
            Logger.logDebug("Deleting ... " + collection.size() + " events");
            ArrayList arrayList = new ArrayList(collection);
            Collections.sort(arrayList, new Comparator<SamsungSHealthSession>() { // from class: com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi.5
                @Override // java.util.Comparator
                public int compare(SamsungSHealthSession samsungSHealthSession, SamsungSHealthSession samsungSHealthSession2) {
                    if (samsungSHealthSession.equals(samsungSHealthSession2)) {
                        return 0;
                    }
                    return Long.valueOf(samsungSHealthSession.getFromInMillis()).compareTo(Long.valueOf(samsungSHealthSession2.getFromInMillis()));
                }
            });
            int size = 0;
            while (size < collection.size()) {
                List listSubList = arrayList.subList(size, Math.min(size + 100, collection.size()));
                ResultStatus resultStatusDelete = delete(listSubList);
                if (!resultStatusDelete.isSuccess()) {
                    return resultStatusDelete;
                }
                size += listSubList.size();
                Logger.logDebug("S Health - " + size + " deleted sessions");
                if (listener != null) {
                    listener.deleted(size);
                }
            }
            return ResultStatus.SUCCESS;
        }
        return ResultStatus.SUCCESS;
    }
}

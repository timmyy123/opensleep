package androidx.room;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.room.concurrent.CloseBarrier;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001VBo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u001b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0004\u0012\u00020\u00180 2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b'\u0010%J\u0010\u0010+\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b)\u0010*J/\u00101\u001a\u00020\u000f2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0,2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0,H\u0000¢\u0006\u0004\b/\u00100J\u000f\u00104\u001a\u00020\u000fH\u0000¢\u0006\u0004\b2\u00103J%\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0002¢\u0006\u0004\b5\u00106J \u00109\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u0002072\u0006\u00108\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b9\u0010:J \u0010;\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u0002072\u0006\u00108\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b;\u0010:J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0082@¢\u0006\u0004\b<\u0010*J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0014\u001a\u000207H\u0082@¢\u0006\u0004\b=\u0010>R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010?R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010@R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010@R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010AR&\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010BR \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u00060Lj\u0002`M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000b0,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006W"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "viewTables", "", "tableNames", "", "useTempTable", "Lkotlin/Function1;", "", "", "onInvalidatedTablesIds", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "configureConnection", "(Landroidx/sqlite/SQLiteConnection;)V", "resolvedTableNames", "", "tableIds", "emitInitialState", "Lkotlinx/coroutines/flow/Flow;", "createFlow$room_runtime_release", "([Ljava/lang/String;[IZ)Lkotlinx/coroutines/flow/Flow;", "createFlow", "names", "Lkotlin/Pair;", "validateTableNames$room_runtime_release", "([Ljava/lang/String;)Lkotlin/Pair;", "validateTableNames", "onObserverAdded$room_runtime_release", "([I)Z", "onObserverAdded", "onObserverRemoved$room_runtime_release", "onObserverRemoved", "syncTriggers$room_runtime_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncTriggers", "Lkotlin/Function0;", "onRefreshScheduled", "onRefreshCompleted", "refreshInvalidationAsync$room_runtime_release", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "refreshInvalidationAsync", "resetSync$room_runtime_release", "()V", "resetSync", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "Landroidx/room/PooledConnection;", "tableId", "startTrackingTable", "(Landroidx/room/PooledConnection;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTrackingTable", "notifyInvalidation", "checkInvalidatedTables", "(Landroidx/room/PooledConnection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Ljava/util/Map;", "Z", "Lkotlin/jvm/functions/Function1;", "tableIdLookup", "tablesNames", "[Ljava/lang/String;", "Landroidx/room/ObservedTableStates;", "observedTableStates", "Landroidx/room/ObservedTableStates;", "Landroidx/room/ObservedTableVersions;", "observedTableVersions", "Landroidx/room/ObservedTableVersions;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onAllowRefresh", "Lkotlin/jvm/functions/Function0;", "getOnAllowRefresh$room_runtime_release", "()Lkotlin/jvm/functions/Function0;", "setOnAllowRefresh$room_runtime_release", "(Lkotlin/jvm/functions/Function0;)V", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TriggerBasedInvalidationTracker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};
    private final RoomDatabase database;
    private final ObservedTableStates observedTableStates;
    private final ObservedTableVersions observedTableVersions;
    private Function0<Boolean> onAllowRefresh;
    private final Function1<Set<Integer>, Unit> onInvalidatedTablesIds;
    private final AtomicBoolean pendingRefresh;
    private final Map<String, String> shadowTablesMap;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final boolean useTempTable;
    private final Map<String, Set<String>> viewTables;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker$Companion;", "", "<init>", "()V", "TRIGGERS", "", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "TABLE_ID_COLUMN_NAME", "INVALIDATED_COLUMN_NAME", "CREATE_TRACKING_TABLE_SQL", "DROP_TRACKING_TABLE_SQL", "SELECT_UPDATED_TABLES_SQL", "RESET_UPDATED_TABLES_SQL", "getTriggerName", "tableName", "triggerType", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTriggerName(String tableName, String triggerType) {
            return "room_table_modification_trigger_" + tableName + '_' + triggerType;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {440, 448}, m = "checkInvalidatedTables")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.checkInvalidatedTables(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED}, m = "notifyInvalidation")
    public static final class C01141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01141(Continuation<? super C01141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.notifyInvalidation(this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {323, 328}, m = "startTrackingTable")
    public static final class C01151 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C01151(Continuation<? super C01151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.startTrackingTable(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {342}, m = "stopTrackingTable")
    public static final class C01161 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C01161(Continuation<? super C01161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.stopTrackingTable(null, 0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, ? extends Set<String>> map2, String[] strArr, boolean z, Function1<? super Set<Integer>, Unit> function1) {
        String lowerCase;
        roomDatabase.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        function1.getClass();
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.useTempTable = z;
        this.onInvalidatedTablesIds = function1;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new Tool$$ExternalSyntheticLambda0(9);
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i));
            String str2 = this.shadowTablesMap.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.tablesNames = strArr2;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = value.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(locale2);
                lowerCase4.getClass();
                Map<String, Integer> map3 = this.tableIdLookup;
                map3.put(lowerCase4, (Integer) MapsKt.getValue(map3, lowerCase3));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkInvalidatedTables(PooledConnection pooledConnection, Continuation<? super Set<Integer>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objUsePrepared = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUsePrepared);
            Data$$ExternalSyntheticLambda0 data$$ExternalSyntheticLambda0 = new Data$$ExternalSyntheticLambda0(6);
            anonymousClass1.L$0 = pooledConnection;
            anonymousClass1.label = 1;
            objUsePrepared = pooledConnection.usePrepared("SELECT * FROM room_table_modification_log WHERE invalidated = 1", data$$ExternalSyntheticLambda0, anonymousClass1);
            if (objUsePrepared != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Set set = (Set) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objUsePrepared);
            return set;
        }
        pooledConnection = (PooledConnection) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objUsePrepared);
        Set set2 = (Set) objUsePrepared;
        if (!set2.isEmpty()) {
            anonymousClass1.L$0 = set2;
            anonymousClass1.label = 2;
            if (TransactorKt.execSQL(pooledConnection, "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1", anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        while (sQLiteStatement.step()) {
            setCreateSetBuilder.add(Integer.valueOf((int) sQLiteStatement.getLong(0)));
        }
        return SetsKt.build(setCreateSetBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #1 {all -> 0x005e, blocks: (B:35:0x008d, B:37:0x0095, B:20:0x004d, B:22:0x0056, B:27:0x0063, B:29:0x0071, B:32:0x0079), top: B:46:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyInvalidation(Continuation<? super Set<Integer>> continuation) throws Throwable {
        C01141 c01141;
        CloseBarrier closeBarrier$room_runtime_release;
        Throwable th;
        CloseBarrier closeBarrier;
        Object objUseConnection$room_runtime_release;
        Set<Integer> set;
        if (continuation instanceof C01141) {
            c01141 = (C01141) continuation;
            int i = c01141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01141.label = i - Integer.MIN_VALUE;
            } else {
                c01141 = new C01141(continuation);
            }
        }
        Object obj = c01141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01141.label;
        if (i2 != 0) {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            closeBarrier = (CloseBarrier) c01141.L$1;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) c01141.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                closeBarrier$room_runtime_release = closeBarrier;
                this = triggerBasedInvalidationTracker;
                objUseConnection$room_runtime_release = obj;
                set = (Set) objUseConnection$room_runtime_release;
                if (!set.isEmpty()) {
                    this.observedTableVersions.increment(set);
                    this.onInvalidatedTablesIds.invoke(set);
                }
                closeBarrier$room_runtime_release.unblock$room_runtime_release();
                return set;
            } catch (Throwable th2) {
                th = th2;
                closeBarrier.unblock$room_runtime_release();
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        closeBarrier$room_runtime_release = this.database.getCloseBarrier();
        if (!closeBarrier$room_runtime_release.block$room_runtime_release()) {
            return SetsKt.emptySet();
        }
        try {
            if (!this.pendingRefresh.compareAndSet(true, false)) {
                Set setEmptySet = SetsKt.emptySet();
                closeBarrier$room_runtime_release.unblock$room_runtime_release();
                return setEmptySet;
            }
            if (!this.onAllowRefresh.invoke().booleanValue()) {
                Set setEmptySet2 = SetsKt.emptySet();
                closeBarrier$room_runtime_release.unblock$room_runtime_release();
                return setEmptySet2;
            }
            RoomDatabase roomDatabase = this.database;
            TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this, null);
            c01141.L$0 = this;
            c01141.L$1 = closeBarrier$room_runtime_release;
            c01141.label = 1;
            objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1, c01141);
            if (objUseConnection$room_runtime_release == coroutine_suspended) {
                return coroutine_suspended;
            }
            set = (Set) objUseConnection$room_runtime_release;
            if (!set.isEmpty()) {
            }
            closeBarrier$room_runtime_release.unblock$room_runtime_release();
            return set;
        } catch (Throwable th3) {
            th = th3;
            closeBarrier = closeBarrier$room_runtime_release;
            closeBarrier.unblock$room_runtime_release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    private final String[] resolveViews(String[] names) {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                setCreateSetBuilder.addAll(set);
            } else {
                setCreateSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(setCreateSetBuilder).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0089, code lost:
    
        if (androidx.room.TransactorKt.execSQL(r1, r3, r4) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00da, code lost:
    
        if (androidx.room.TransactorKt.execSQL(r10, r3, r4) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00dc, code lost:
    
        return r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00da -> B:28:0x00dd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startTrackingTable(PooledConnection pooledConnection, int i, Continuation<? super Unit> continuation) {
        C01151 c01151;
        String[] strArr;
        PooledConnection pooledConnection2;
        int i2;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        int length;
        String str;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker2 = this;
        PooledConnection pooledConnection3 = pooledConnection;
        int i3 = i;
        if (continuation instanceof C01151) {
            c01151 = (C01151) continuation;
            int i4 = c01151.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c01151.label = i4 - Integer.MIN_VALUE;
            } else {
                c01151 = triggerBasedInvalidationTracker2.new C01151(continuation);
            }
        }
        Object obj = c01151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c01151.label;
        boolean z = true;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i3 + ", 0)";
            c01151.L$0 = triggerBasedInvalidationTracker2;
            c01151.L$1 = pooledConnection3;
            c01151.I$0 = i3;
            c01151.label = 1;
        } else if (i5 == 1) {
            int i6 = c01151.I$0;
            pooledConnection3 = (PooledConnection) c01151.L$1;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker3 = (TriggerBasedInvalidationTracker) c01151.L$0;
            ResultKt.throwOnFailure(obj);
            i3 = i6;
            triggerBasedInvalidationTracker2 = triggerBasedInvalidationTracker3;
        } else {
            if (i5 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            length = c01151.I$2;
            i2 = c01151.I$1;
            i3 = c01151.I$0;
            strArr = (String[]) c01151.L$3;
            str = (String) c01151.L$2;
            pooledConnection2 = (PooledConnection) c01151.L$1;
            triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) c01151.L$0;
            ResultKt.throwOnFailure(obj);
            boolean z2 = true;
            i2++;
            z = z2;
            if (i2 < length) {
                return Unit.INSTANCE;
            }
            String str3 = strArr[i2];
            z2 = z;
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("CREATE ", triggerBasedInvalidationTracker.useTempTable ? "TEMP" : "", " TRIGGER IF NOT EXISTS `", INSTANCE.getTriggerName(str, str3), "` AFTER ");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str3, " ON `", str, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
            String strM = FileInsert$$ExternalSyntheticOutline0.m(i3, " AND invalidated = 0; END", sbM6m);
            c01151.L$0 = triggerBasedInvalidationTracker;
            c01151.L$1 = pooledConnection2;
            c01151.L$2 = str;
            c01151.L$3 = strArr;
            c01151.I$0 = i3;
            c01151.I$1 = i2;
            c01151.I$2 = length;
            c01151.label = 2;
        }
        String str4 = triggerBasedInvalidationTracker2.tablesNames[i3];
        strArr = TRIGGERS;
        pooledConnection2 = pooledConnection3;
        i2 = 0;
        triggerBasedInvalidationTracker = triggerBasedInvalidationTracker2;
        length = strArr.length;
        str = str4;
        if (i2 < length) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0075 -> B:19:0x0078). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopTrackingTable(PooledConnection pooledConnection, int i, Continuation<? super Unit> continuation) {
        C01161 c01161;
        String str;
        int length;
        String[] strArr;
        PooledConnection pooledConnection2;
        int i2;
        if (continuation instanceof C01161) {
            c01161 = (C01161) continuation;
            int i3 = c01161.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c01161.label = i3 - Integer.MIN_VALUE;
            } else {
                c01161 = new C01161(continuation);
            }
        }
        Object obj = c01161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c01161.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.tablesNames[i];
            String[] strArr2 = TRIGGERS;
            str = str2;
            length = strArr2.length;
            strArr = strArr2;
            pooledConnection2 = pooledConnection;
            i2 = 0;
            if (i2 < length) {
            }
        } else {
            if (i4 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            length = c01161.I$1;
            i2 = c01161.I$0;
            String[] strArr3 = (String[]) c01161.L$2;
            str = (String) c01161.L$1;
            PooledConnection pooledConnection3 = (PooledConnection) c01161.L$0;
            ResultKt.throwOnFailure(obj);
            strArr = strArr3;
            pooledConnection2 = pooledConnection3;
            i2++;
            if (i2 < length) {
                String strM = Fragment$$ExternalSyntheticOutline1.m('`', "DROP TRIGGER IF EXISTS `", INSTANCE.getTriggerName(str, strArr[i2]));
                c01161.L$0 = pooledConnection2;
                c01161.L$1 = str;
                c01161.L$2 = strArr;
                c01161.I$0 = i2;
                c01161.I$1 = length;
                c01161.label = 1;
                if (TransactorKt.execSQL(pooledConnection2, strM, c01161) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i2++;
                if (i2 < length) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void configureConnection(SQLiteConnection connection) {
        connection.getClass();
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA query_only");
        try {
            sQLiteStatementPrepare.step();
            boolean z = sQLiteStatementPrepare.getBoolean(0);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            if (z) {
                return;
            }
            SQLite.execSQL(connection, "PRAGMA temp_store = MEMORY");
            SQLite.execSQL(connection, "PRAGMA recursive_triggers = 1");
            SQLite.execSQL(connection, "DROP TABLE IF EXISTS room_table_modification_log");
            if (this.useTempTable) {
                SQLite.execSQL(connection, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            } else {
                SQLite.execSQL(connection, StringsKt.replace$default("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", ""));
            }
            this.observedTableStates.forceNeedSync$room_runtime_release();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public final Flow<Set<String>> createFlow$room_runtime_release(String[] resolvedTableNames, int[] tableIds, boolean emitInitialState) {
        resolvedTableNames.getClass();
        tableIds.getClass();
        return FlowKt.flow(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, emitInitialState, resolvedTableNames, null));
    }

    public final boolean onObserverAdded$room_runtime_release(int[] tableIds) {
        tableIds.getClass();
        return this.observedTableStates.onObserverAdded$room_runtime_release(tableIds);
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] tableIds) {
        tableIds.getClass();
        return this.observedTableStates.onObserverRemoved$room_runtime_release(tableIds);
    }

    public final void refreshInvalidationAsync$room_runtime_release(Function0<Unit> onRefreshScheduled, Function0<Unit> onRefreshCompleted) {
        onRefreshScheduled.getClass();
        onRefreshCompleted.getClass();
        if (this.pendingRefresh.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    public final void resetSync$room_runtime_release() {
        this.observedTableStates.resetTriggerState$room_runtime_release();
    }

    public final void setOnAllowRefresh$room_runtime_release(Function0<Boolean> function0) {
        function0.getClass();
        this.onAllowRefresh = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncTriggers$room_runtime_release(Continuation<? super Unit> continuation) throws Throwable {
        TriggerBasedInvalidationTracker$syncTriggers$1 triggerBasedInvalidationTracker$syncTriggers$1;
        Throwable th;
        CloseBarrier closeBarrier;
        if (continuation instanceof TriggerBasedInvalidationTracker$syncTriggers$1) {
            triggerBasedInvalidationTracker$syncTriggers$1 = (TriggerBasedInvalidationTracker$syncTriggers$1) continuation;
            int i = triggerBasedInvalidationTracker$syncTriggers$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$syncTriggers$1.label = i - Integer.MIN_VALUE;
            } else {
                triggerBasedInvalidationTracker$syncTriggers$1 = new TriggerBasedInvalidationTracker$syncTriggers$1(this, continuation);
            }
        }
        Object obj = triggerBasedInvalidationTracker$syncTriggers$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = triggerBasedInvalidationTracker$syncTriggers$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CloseBarrier closeBarrier$room_runtime_release = this.database.getCloseBarrier();
            if (closeBarrier$room_runtime_release.block$room_runtime_release()) {
                try {
                    RoomDatabase roomDatabase = this.database;
                    TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this, null);
                    triggerBasedInvalidationTracker$syncTriggers$1.L$0 = closeBarrier$room_runtime_release;
                    triggerBasedInvalidationTracker$syncTriggers$1.label = 1;
                    if (roomDatabase.useConnection$room_runtime_release(false, triggerBasedInvalidationTracker$syncTriggers$2$1, triggerBasedInvalidationTracker$syncTriggers$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeBarrier = closeBarrier$room_runtime_release;
                    closeBarrier.unblock$room_runtime_release();
                } catch (Throwable th2) {
                    th = th2;
                    closeBarrier = closeBarrier$room_runtime_release;
                    closeBarrier.unblock$room_runtime_release();
                    throw th;
                }
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            closeBarrier = (CloseBarrier) triggerBasedInvalidationTracker$syncTriggers$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                closeBarrier.unblock$room_runtime_release();
            } catch (Throwable th3) {
                th = th3;
                closeBarrier.unblock$room_runtime_release();
                throw th;
            }
        }
        return Unit.INSTANCE;
    }

    public final Pair<String[], int[]> validateTableNames$room_runtime_release(String[] names) {
        names.getClass();
        String[] strArrResolveViews = resolveViews(names);
        int length = strArrResolveViews.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str = strArrResolveViews[i];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Integer num = map.get(lowerCase);
            if (num == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("There is no table with name ".concat(str));
                return null;
            }
            iArr[i] = num.intValue();
        }
        return TuplesKt.to(strArrResolveViews, iArr);
    }
}

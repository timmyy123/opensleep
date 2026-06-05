package androidx.room;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import androidx.work.impl.utils.WorkProgressUpdater$$ExternalSyntheticLambda0;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 82\u00020\u0001:\u000298B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0010¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u0013\u0010\rJ\u0013\u0010\u0015\u001a\u00020\u000e*\u00020\u0014H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000e*\u00020\u0014H\u0004¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\rJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\rJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\rJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\rJ\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\rJ\u0017\u0010$\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010\u001fJ\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010\rJ\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010\rJ\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010\rR\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010.\u001a\u00020+8$X¤\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8$X¤\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000204038$X¤\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Landroidx/room/BaseRoomConnectionManager;", "", "<init>", "()V", "", "fileName", "resolveFileName$room_runtime_release", "(Ljava/lang/String;)Ljava/lang/String;", "resolveFileName", "Landroidx/sqlite/SQLiteConnection;", "connection", "", "onCreate", "(Landroidx/sqlite/SQLiteConnection;)V", "", "oldVersion", "newVersion", "onMigrate", "(Landroidx/sqlite/SQLiteConnection;II)V", "onOpen", "Landroidx/room/RoomDatabase$JournalMode;", "getMaxNumberOfReaders", "(Landroidx/room/RoomDatabase$JournalMode;)I", "getMaxNumberOfWriters", "configureDatabase", "configurationConnection", "configureJournalMode", "configureSynchronousFlag", "configureBusyTimeout", "", "hasEmptySchema", "(Landroidx/sqlite/SQLiteConnection;)Z", "updateIdentity", "createMasterTableIfNotExists", "dropAllTables", "checkIdentity", "hasRoomMasterTable", "invokeCreateCallback", "invokeDestructiveMigrationCallback", "invokeOpenCallback", "isConfigured", "Z", "isInitializing", "Landroidx/room/DatabaseConfiguration;", "getConfiguration", "()Landroidx/room/DatabaseConfiguration;", "configuration", "Landroidx/room/RoomOpenDelegate;", "getOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "openDelegate", "", "Landroidx/room/RoomDatabase$Callback;", "getCallbacks", "()Ljava/util/List;", "callbacks", "Companion", "DriverWrapper", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseRoomConnectionManager {
    private boolean isConfigured;
    private boolean isInitializing;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0084\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/BaseRoomConnectionManager$DriverWrapper;", "Landroidx/sqlite/SQLiteDriver;", "actual", "<init>", "(Landroidx/room/BaseRoomConnectionManager;Landroidx/sqlite/SQLiteDriver;)V", "open", "Landroidx/sqlite/SQLiteConnection;", "fileName", "", "openLocked", "filename", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DriverWrapper implements SQLiteDriver {
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver sQLiteDriver) {
            sQLiteDriver.getClass();
            this.this$0 = baseRoomConnectionManager;
            this.actual = sQLiteDriver;
        }

        private final SQLiteConnection openLocked(final String filename) {
            return (SQLiteConnection) new ExclusiveLock(filename, (this.this$0.isConfigured || this.this$0.isInitializing || Intrinsics.areEqual(filename, ":memory:")) ? false : true).withLock(new WorkProgressUpdater$$ExternalSyntheticLambda0(this.this$0, this, filename, 1), new Function1() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Throwable th) {
                    th.getClass();
                    throw new IllegalStateException(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Unable to open database '"), filename, "'. Was a proper path / name used in Room's database builder?"), th);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (baseRoomConnectionManager.isInitializing) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
                return null;
            }
            SQLiteConnection sQLiteConnectionOpen = driverWrapper.actual.open(str);
            if (baseRoomConnectionManager.isConfigured) {
                baseRoomConnectionManager.configurationConnection(sQLiteConnectionOpen);
                return sQLiteConnectionOpen;
            }
            try {
                baseRoomConnectionManager.isInitializing = true;
                baseRoomConnectionManager.configureDatabase(sQLiteConnectionOpen);
                return sQLiteConnectionOpen;
            } finally {
                baseRoomConnectionManager.isInitializing = false;
            }
        }

        @Override // androidx.sqlite.SQLiteDriver
        public SQLiteConnection open(String fileName) {
            fileName.getClass();
            return openLocked(this.this$0.resolveFileName$room_runtime_release(fileName));
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkIdentity(SQLiteConnection connection) throws Throwable {
        Object objM2357constructorimpl;
        RoomOpenDelegate.ValidationResult validationResultOnValidateSchema;
        if (hasRoomMasterTable(connection)) {
            SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            try {
                String text = sQLiteStatementPrepare.step() ? sQLiteStatementPrepare.getText(0) : null;
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
                if (Intrinsics.areEqual(getOpenDelegate().getIdentityHash(), text) || Intrinsics.areEqual(getOpenDelegate().getLegacyIdentityHash(), text)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + text).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(connection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.Companion companion = Result.INSTANCE;
            validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(connection);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2357constructorimpl = Result.m2357constructorimpl(ResultKt.createFailure(th3));
        }
        if (!validationResultOnValidateSchema.isValid) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
        }
        getOpenDelegate().onPostMigrate(connection);
        updateIdentity(connection);
        objM2357constructorimpl = Result.m2357constructorimpl(Unit.INSTANCE);
        if (Result.m2363isSuccessimpl(objM2357constructorimpl)) {
            SQLite.execSQL(connection, "END TRANSACTION");
        }
        Throwable thM2360exceptionOrNullimpl = Result.m2360exceptionOrNullimpl(objM2357constructorimpl);
        if (thM2360exceptionOrNullimpl == null) {
            Result.m2356boximpl(objM2357constructorimpl);
        } else {
            SQLite.execSQL(connection, "ROLLBACK TRANSACTION");
            throw thM2360exceptionOrNullimpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection connection) {
        configureSynchronousFlag(connection);
        configureBusyTimeout(connection);
        getOpenDelegate().onOpen(connection);
    }

    private final void configureBusyTimeout(SQLiteConnection connection) {
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA busy_timeout");
        try {
            sQLiteStatementPrepare.step();
            long j = sQLiteStatementPrepare.getLong(0);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            if (j < 3000) {
                SQLite.execSQL(connection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection connection) throws Throwable {
        Object objM2357constructorimpl;
        configureJournalMode(connection);
        configureSynchronousFlag(connection);
        configureBusyTimeout(connection);
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA user_version");
        try {
            sQLiteStatementPrepare.step();
            int i = (int) sQLiteStatementPrepare.getLong(0);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            if (i != getOpenDelegate().getVersion()) {
                SQLite.execSQL(connection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (i == 0) {
                        onCreate(connection);
                    } else {
                        onMigrate(connection, i, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(connection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    objM2357constructorimpl = Result.m2357constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM2357constructorimpl = Result.m2357constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m2363isSuccessimpl(objM2357constructorimpl)) {
                    SQLite.execSQL(connection, "END TRANSACTION");
                }
                Throwable thM2360exceptionOrNullimpl = Result.m2360exceptionOrNullimpl(objM2357constructorimpl);
                if (thM2360exceptionOrNullimpl != null) {
                    SQLite.execSQL(connection, "ROLLBACK TRANSACTION");
                    throw thM2360exceptionOrNullimpl;
                }
            }
            onOpen(connection);
        } finally {
        }
    }

    private final void configureJournalMode(SQLiteConnection connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(connection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(connection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(connection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(connection, "PRAGMA synchronous = FULL");
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void dropAllTables(SQLiteConnection connection) {
        if (!getConfiguration().allowDestructiveMigrationForAllTables) {
            getOpenDelegate().dropAllTables(connection);
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(0);
                if (!StringsKt.startsWith$default(text, "sqlite_") && !Intrinsics.areEqual(text, "android_metadata")) {
                    listCreateListBuilder.add(TuplesKt.to(text, Boolean.valueOf(Intrinsics.areEqual(sQLiteStatementPrepare.getText(1), ViewHierarchyConstants.VIEW_KEY))));
                }
            }
            List<Pair> listBuild = CollectionsKt.build(listCreateListBuilder);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            for (Pair pair : listBuild) {
                String str = (String) pair.component1();
                if (((Boolean) pair.component2()).booleanValue()) {
                    SQLite.execSQL(connection, "DROP VIEW IF EXISTS " + str);
                } else {
                    SQLite.execSQL(connection, "DROP TABLE IF EXISTS " + str);
                }
            }
        } finally {
        }
    }

    private final boolean hasEmptySchema(SQLiteConnection connection) {
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(0) == 0) {
                    z = true;
                }
            }
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            return z;
        } finally {
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection connection) {
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z = false;
            if (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(0) != 0) {
                    z = true;
                }
            }
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            return z;
        } finally {
        }
    }

    private final void invokeCreateCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onCreate(connection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onDestructiveMigration(connection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onOpen(connection);
        }
    }

    private final void updateIdentity(SQLiteConnection connection) {
        createMasterTableIfNotExists(connection);
        SQLite.execSQL(connection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    public abstract List<RoomDatabase.Callback> getCallbacks();

    public abstract DatabaseConfiguration getConfiguration();

    public final int getMaxNumberOfReaders(RoomDatabase.JournalMode journalMode) {
        journalMode.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 4;
        }
        FacebookSdk$$ExternalSyntheticLambda1.m$1("Can't get max number of reader for journal mode '", journalMode);
        return 0;
    }

    public final int getMaxNumberOfWriters(RoomDatabase.JournalMode journalMode) {
        journalMode.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1 || i == 2) {
            return 1;
        }
        FacebookSdk$$ExternalSyntheticLambda1.m$1("Can't get max number of writers for journal mode '", journalMode);
        return 0;
    }

    public abstract RoomOpenDelegate getOpenDelegate();

    public final void onCreate(SQLiteConnection connection) {
        connection.getClass();
        boolean zHasEmptySchema = hasEmptySchema(connection);
        getOpenDelegate().createAllTables(connection);
        if (!zHasEmptySchema) {
            RoomOpenDelegate.ValidationResult validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!validationResultOnValidateSchema.isValid) {
                FacebookSdk$$ExternalSyntheticLambda1.m$2("Pre-packaged database has an invalid schema: ", validationResultOnValidateSchema.expectedFoundMsg);
                return;
            }
        }
        updateIdentity(connection);
        getOpenDelegate().onCreate(connection);
        invokeCreateCallback(connection);
    }

    public final void onMigrate(SQLiteConnection connection, int oldVersion, int newVersion) {
        connection.getClass();
        List<Migration> listFindMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, oldVersion, newVersion);
        if (listFindMigrationPath != null) {
            getOpenDelegate().onPreMigrate(connection);
            Iterator<T> it = listFindMigrationPath.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).migrate(connection);
            }
            RoomOpenDelegate.ValidationResult validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!validationResultOnValidateSchema.isValid) {
                FacebookSdk$$ExternalSyntheticLambda1.m$2("Migration didn't properly handle: ", validationResultOnValidateSchema.expectedFoundMsg);
                return;
            } else {
                getOpenDelegate().onPostMigrate(connection);
                updateIdentity(connection);
                return;
            }
        }
        if (!MigrationUtil.isMigrationRequired(getConfiguration(), oldVersion, newVersion)) {
            dropAllTables(connection);
            invokeDestructiveMigrationCallback(connection);
            getOpenDelegate().createAllTables(connection);
        } else {
            throw new IllegalStateException(("A migration from " + oldVersion + " to " + newVersion + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
    }

    public final void onOpen(SQLiteConnection connection) throws Throwable {
        connection.getClass();
        checkIdentity(connection);
        getOpenDelegate().onOpen(connection);
        invokeOpenCallback(connection);
        this.isConfigured = true;
    }

    public abstract String resolveFileName$room_runtime_release(String fileName);
}

package androidx.room.coroutines;

import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00112\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\f0&j\b\u0012\u0004\u0012\u00020\f`'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u00060*j\u0002`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "Landroidx/sqlite/SQLiteDriver;", "driver", "", "fileName", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "", "maxNumOfReaders", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "Landroidx/room/coroutines/PooledConnectionImpl;", "connection", "Lkotlin/coroutines/CoroutineContext;", "createConnectionContext", "(Landroidx/room/coroutines/PooledConnectionImpl;)Lkotlin/coroutines/CoroutineContext;", "", "isReadOnly", "", "throwTimeoutException", "(Z)Ljava/lang/Void;", "R", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "block", "useConnection", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "Landroidx/sqlite/SQLiteDriver;", "Landroidx/room/coroutines/Pool;", "readers", "Landroidx/room/coroutines/Pool;", "writers", "Ljava/lang/ThreadLocal;", "Landroidx/room/concurrent/ThreadLocal;", "threadLocal", "Ljava/lang/ThreadLocal;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/time/Duration;", "timeout", "J", "getTimeout-UwyO8pc$room_runtime_release", "()J", "setTimeout-LRDsOJo$room_runtime_release", "(J)V", "isClosed", "()Z", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private long timeout;
    private final Pool writers;

    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", l = {114, 118, 541, 147}, m = "useConnection")
    public static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", l = {115}, m = "invokeSuspend")
    public static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ PooledConnectionImpl $confinedConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, PooledConnectionImpl pooledConnectionImpl, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$confinedConnection = pooledConnectionImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, this.$confinedConnection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Function2<Transactor, Continuation<? super R>, Object> function2 = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object objInvoke = function2.invoke(pooledConnectionImpl, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", l = {147}, m = "invokeSuspend")
    public static final class AnonymousClass4<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ Ref$ObjectRef<PooledConnectionImpl> $connection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Ref$ObjectRef<PooledConnectionImpl> ref$ObjectRef, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$connection = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$block, this.$connection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.room.coroutines.ConnectionPoolImpl$useConnection$4<R> for r3v2 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L16
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                return r4
            Lf:
                java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
                okio.Utf8$$ExternalSyntheticBUOutline0.m$3(r3)
                r3 = 0
                return r3
            L16:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function2<androidx.room.Transactor, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r3.$block
                kotlin.jvm.internal.Ref$ObjectRef<androidx.room.coroutines.PooledConnectionImpl> r1 = r3.$connection
                T r1 = r1.element
                r3.label = r2
                java.lang.Object r3 = r4.invoke(r1, r3)
                if (r3 != r0) goto L28
                return r0
            L28:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str, int i, int i2) {
        sQLiteDriver.getClass();
        str.getClass();
        this.threadLocal = new ThreadLocal<>();
        final int i3 = 0;
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        if (i <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Maximum number of readers must be greater than 0");
            throw null;
        }
        if (i2 <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Maximum number of writers must be greater than 0");
            throw null;
        }
        this.driver = sQLiteDriver;
        this.readers = new Pool(i, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                }
                return sQLiteDriver.open(str);
            }
        });
        final int i4 = 1;
        this.writers = new Pool(i2, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i4) {
                }
                return sQLiteDriver.open(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection sQLiteConnectionOpen = sQLiteDriver.open(str);
        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
        return sQLiteConnectionOpen;
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl connection) {
        return new ConnectionElement(connection).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, connection));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final Void throwTimeoutException(boolean isReadOnly) {
        String str = isReadOnly ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018c A[Catch: all -> 0x019d, TRY_LEAVE, TryCatch #6 {all -> 0x019d, blocks: (B:89:0x0186, B:91:0x018c), top: B:124:0x0186 }] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [T, androidx.room.coroutines.PooledConnectionImpl] */
    /* JADX WARN: Type inference failed for: r13v8 */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object useConnection(boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        Pool pool;
        CoroutineContext context;
        Ref$ObjectRef ref$ObjectRef2;
        Pool pool2;
        Ref$ObjectRef ref$ObjectRef3;
        CoroutineContext coroutineContext;
        ConnectionPoolImpl connectionPoolImpl;
        boolean z2;
        Ref$ObjectRef ref$ObjectRef4;
        ConnectionPoolImpl connectionPoolImpl2;
        Ref$ObjectRef ref$ObjectRef5;
        ?? pooledConnectionImpl;
        PooledConnectionImpl pooledConnectionImpl2;
        ConnectionPoolImpl connectionPoolImpl3 = this;
        boolean z3 = z;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function22 = function2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = connectionPoolImpl3.new AnonymousClass1(continuation);
            }
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean z4 = true;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                if (connectionPoolImpl3.isClosed()) {
                    throw zzba$$ExternalSyntheticOutline0.m257m(21, "Connection pool is closed");
                }
                PooledConnectionImpl connectionWrapper = connectionPoolImpl3.threadLocal.get();
                if (connectionWrapper == null) {
                    ConnectionElement connectionElement = (ConnectionElement) anonymousClass1.getContext().get(ConnectionElement.INSTANCE);
                    connectionWrapper = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
                }
                if (connectionWrapper == null) {
                    Pool pool3 = z3 ? connectionPoolImpl3.readers : connectionPoolImpl3.writers;
                    ref$ObjectRef = new Ref$ObjectRef();
                    try {
                        context = anonymousClass1.getContext();
                        ref$ObjectRef2 = new Ref$ObjectRef();
                        try {
                            long j = connectionPoolImpl3.timeout;
                            ConnectionPoolImpl$acquireWithTimeout$2 connectionPoolImpl$acquireWithTimeout$2 = new ConnectionPoolImpl$acquireWithTimeout$2(ref$ObjectRef2, pool3, null);
                            anonymousClass1.L$0 = connectionPoolImpl3;
                            anonymousClass1.L$1 = function22;
                            anonymousClass1.L$2 = pool3;
                            anonymousClass1.L$3 = ref$ObjectRef;
                            anonymousClass1.L$4 = context;
                            anonymousClass1.L$5 = ref$ObjectRef2;
                            anonymousClass1.Z$0 = z3;
                            anonymousClass1.label = 3;
                            if (TimeoutKt.m2571withTimeoutKLykuaI(j, connectionPoolImpl$acquireWithTimeout$2, anonymousClass1) != coroutine_suspended) {
                                pool2 = pool3;
                                ref$ObjectRef3 = ref$ObjectRef;
                                coroutineContext = context;
                                connectionPoolImpl = connectionPoolImpl3;
                                z2 = z3;
                                ref$ObjectRef4 = ref$ObjectRef2;
                                ref$ObjectRef2 = ref$ObjectRef4;
                                z3 = z2;
                                ref$ObjectRef5 = ref$ObjectRef3;
                                connectionPoolImpl2 = connectionPoolImpl;
                                context = coroutineContext;
                                th = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            pool2 = pool3;
                            ref$ObjectRef3 = ref$ObjectRef;
                            Ref$ObjectRef ref$ObjectRef6 = ref$ObjectRef3;
                            connectionPoolImpl2 = connectionPoolImpl3;
                            ref$ObjectRef5 = ref$ObjectRef6;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        pool = pool3;
                        throw th;
                    }
                } else {
                    if (!z3 && connectionWrapper.getIsReadOnly()) {
                        throw zzba$$ExternalSyntheticOutline0.m257m(1, "Cannot upgrade connection from reader to writer");
                    }
                    if (anonymousClass1.getContext().get(ConnectionElement.INSTANCE) == null) {
                        CoroutineContext coroutineContextCreateConnectionContext = connectionPoolImpl3.createConnectionContext(connectionWrapper);
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(function22, connectionWrapper, null);
                        anonymousClass1.label = 1;
                        Object objWithContext2 = BuildersKt.withContext(coroutineContextCreateConnectionContext, anonymousClass2, anonymousClass1);
                        if (objWithContext2 != coroutine_suspended) {
                            return objWithContext2;
                        }
                    } else {
                        anonymousClass1.label = 2;
                        Object objInvoke = function22.invoke(connectionWrapper, anonymousClass1);
                        if (objInvoke != coroutine_suspended) {
                            return objInvoke;
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i2 == 2) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i2 == 3) {
                z2 = anonymousClass1.Z$0;
                ref$ObjectRef4 = (Ref$ObjectRef) anonymousClass1.L$5;
                CoroutineContext coroutineContext2 = (CoroutineContext) anonymousClass1.L$4;
                ref$ObjectRef3 = (Ref$ObjectRef) anonymousClass1.L$3;
                pool2 = (Pool) anonymousClass1.L$2;
                Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function23 = (Function2) anonymousClass1.L$1;
                connectionPoolImpl = (ConnectionPoolImpl) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    coroutineContext = coroutineContext2;
                    function22 = function23;
                    ref$ObjectRef2 = ref$ObjectRef4;
                    z3 = z2;
                    ref$ObjectRef5 = ref$ObjectRef3;
                    connectionPoolImpl2 = connectionPoolImpl;
                    context = coroutineContext;
                    th = null;
                } catch (Throwable th4) {
                    th = th4;
                    ref$ObjectRef2 = ref$ObjectRef4;
                    z3 = z2;
                    connectionPoolImpl3 = connectionPoolImpl;
                    context = coroutineContext2;
                    function22 = function23;
                    Ref$ObjectRef ref$ObjectRef62 = ref$ObjectRef3;
                    connectionPoolImpl2 = connectionPoolImpl3;
                    ref$ObjectRef5 = ref$ObjectRef62;
                }
            } else {
                if (i2 != 4) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ref$ObjectRef5 = (Ref$ObjectRef) anonymousClass1.L$1;
                pool = (Pool) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    try {
                        pooledConnectionImpl2 = (PooledConnectionImpl) ref$ObjectRef5.element;
                        if (pooledConnectionImpl2 != null) {
                            pooledConnectionImpl2.markRecycled();
                            pooledConnectionImpl2.getDelegate().markReleased();
                            pool.recycle(pooledConnectionImpl2.getDelegate());
                        }
                    } catch (Throwable unused) {
                    }
                    return objWithContext;
                } catch (Throwable th5) {
                    th = th5;
                    ref$ObjectRef = ref$ObjectRef5;
                    th = th;
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            Pair pair = TuplesKt.to(ref$ObjectRef2.element, th);
            ConnectionWithLock connectionWithLock = (ConnectionWithLock) pair.component1();
            Throwable th6 = (Throwable) pair.component2();
            if (connectionWithLock != null) {
                ConnectionWithLock connectionWithLockMarkAcquired = connectionWithLock.markAcquired(context);
                if (connectionPoolImpl2.readers == connectionPoolImpl2.writers || !z3) {
                    z4 = false;
                }
                pooledConnectionImpl = new PooledConnectionImpl(connectionWithLockMarkAcquired, z4);
            } else {
                pooledConnectionImpl = 0;
            }
            ref$ObjectRef5.element = pooledConnectionImpl;
            if (th6 instanceof TimeoutCancellationException) {
                connectionPoolImpl2.throwTimeoutException(z3);
                throw new KotlinNothingValueException();
            }
            if (th6 != null) {
                throw th6;
            }
            if (pooledConnectionImpl == 0) {
                throw new IllegalArgumentException("Required value was null.");
            }
            CoroutineContext coroutineContextCreateConnectionContext2 = connectionPoolImpl2.createConnectionContext(pooledConnectionImpl);
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(function22, ref$ObjectRef5, null);
            anonymousClass1.L$0 = pool2;
            anonymousClass1.L$1 = ref$ObjectRef5;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.L$4 = null;
            anonymousClass1.L$5 = null;
            anonymousClass1.label = 4;
            objWithContext = BuildersKt.withContext(coroutineContextCreateConnectionContext2, anonymousClass4, anonymousClass1);
            if (objWithContext != coroutine_suspended) {
                pool = pool2;
                pooledConnectionImpl2 = (PooledConnectionImpl) ref$ObjectRef5.element;
                if (pooledConnectionImpl2 != null) {
                }
                return objWithContext;
            }
            return coroutine_suspended;
        } catch (Throwable th7) {
            th = th7;
            ref$ObjectRef = ref$ObjectRef5;
            pool = pool2;
            th = th;
            throw th;
        }
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str) {
        sQLiteDriver.getClass();
        str.getClass();
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.driver = sQLiteDriver;
        final int i = 2;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i) {
                }
                return sQLiteDriver.open(str);
            }
        });
        this.readers = pool;
        this.writers = pool;
    }
}

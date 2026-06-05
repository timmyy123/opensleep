package io.rebble.pebblekit2.common.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.rebble.pebblekit2.common.util.SuspendingBindingConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004*\u0001\u001a\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cBM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0086@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection;", "T", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "intentFactory", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroid/content/Intent;", "", "bind", "Landroid/os/IBinder;", "bindingFlags", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;I)V", "Lkotlin/jvm/functions/Function1;", "service", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status;", "getOrConnect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "connection", "io/rebble/pebblekit2/common/util/SuspendingBindingConnection$connection$1", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$connection$1;", "Status", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SuspendingBindingConnection<T> implements AutoCloseable {
    private final Function1<IBinder, T> bind;
    private final int bindingFlags;
    private final SuspendingBindingConnection$connection$1 connection;
    private final Context context;
    private final Function1<Continuation<? super Intent>, Object> intentFactory;
    private final MutableStateFlow<Status<T>> service;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status;", "T", "", "<init>", "()V", "Disconnected", "Connecting", "Connected", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status$Connected;", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status$Connecting;", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status$Disconnected;", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Status<T> {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00018\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status$Connected;", "T", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status;", "binder", "<init>", "(Ljava/lang/Object;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getBinder", "()Ljava/lang/Object;", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Connected<T> extends Status<T> {
            private final T binder;

            public Connected(T t) {
                super(null);
                this.binder = t;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Connected) && Intrinsics.areEqual(this.binder, ((Connected) other).binder);
            }

            public final T getBinder() {
                return this.binder;
            }

            public int hashCode() {
                T t = this.binder;
                if (t == null) {
                    return 0;
                }
                return t.hashCode();
            }

            public String toString() {
                return "Connected(binder=" + this.binder + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status$Connecting;", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Connecting extends Status<Object> {
            public static final Connecting INSTANCE = new Connecting();

            private Connecting() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Connecting);
            }

            public int hashCode() {
                return 2023664368;
            }

            public String toString() {
                return "Connecting";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status$Disconnected;", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection$Status;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Disconnected extends Status<Object> {
            public static final Disconnected INSTANCE = new Disconnected();

            private Disconnected() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Disconnected);
            }

            public int hashCode() {
                return 111783027;
            }

            public String toString() {
                return "Disconnected";
            }
        }

        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Status() {
        }
    }

    /* JADX INFO: renamed from: io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.common.util.SuspendingBindingConnection", f = "SuspendingBindingConnection.kt", l = {39, 48}, m = "getOrConnect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SuspendingBindingConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SuspendingBindingConnection<T> suspendingBindingConnection, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = suspendingBindingConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getOrConnect(this);
        }
    }

    /* JADX INFO: renamed from: io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$2", f = "SuspendingBindingConnection.kt", l = {49}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        int label;
        final /* synthetic */ SuspendingBindingConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SuspendingBindingConnection<T> suspendingBindingConnection, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = suspendingBindingConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final MutableStateFlow mutableStateFlow = ((SuspendingBindingConnection) this.this$0).service;
                Flow<Object> flow = new Flow<Object>() { // from class: io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$2$invokeSuspend$$inlined$filterIsInstance$1

                    /* JADX INFO: renamed from: io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$2$invokeSuspend$$inlined$filterIsInstance$1$2, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$2$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                        @DebugMetadata(c = "io.rebble.pebblekit2.common.util.SuspendingBindingConnection$getOrConnect$2$invokeSuspend$$inlined$filterIsInstance$1$2", f = "SuspendingBindingConnection.kt", l = {50}, m = "emit", v = 2)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object obj, Continuation continuation) {
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
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (obj instanceof SuspendingBindingConnection.Status.Connected) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                        Object objCollect = mutableStateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                obj = FlowKt.first(flow, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((Status.Connected) obj).getBinder();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [io.rebble.pebblekit2.common.util.SuspendingBindingConnection$connection$1] */
    public SuspendingBindingConnection(Context context, Function1<? super Continuation<? super Intent>, ? extends Object> function1, Function1<? super IBinder, ? extends T> function12, int i) {
        context.getClass();
        function1.getClass();
        function12.getClass();
        this.context = context;
        this.intentFactory = function1;
        this.bind = function12;
        this.bindingFlags = i;
        this.service = StateFlowKt.MutableStateFlow(Status.Disconnected.INSTANCE);
        this.connection = new ServiceConnection(this) { // from class: io.rebble.pebblekit2.common.util.SuspendingBindingConnection$connection$1
            final /* synthetic */ SuspendingBindingConnection<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.ServiceConnection
            public void onBindingDied(ComponentName name) {
                name.getClass();
                this.this$0.close();
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName name) {
                ((SuspendingBindingConnection) this.this$0).service.setValue(new SuspendingBindingConnection.Status.Connected(null));
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder binder) {
                binder.getClass();
                ((SuspendingBindingConnection) this.this$0).service.setValue(new SuspendingBindingConnection.Status.Connected(((SuspendingBindingConnection) this.this$0).bind.invoke(binder)));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                name.getClass();
                ((SuspendingBindingConnection) this.this$0).service.setValue(SuspendingBindingConnection.Status.Connecting.INSTANCE);
            }
        };
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.context.unbindService(this.connection);
        this.service.setValue(Status.Disconnected.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getOrConnect(Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        Status<T> value;
        boolean zCompareAndSet;
        Status<T> status;
        Object objM2572withTimeoutOrNullKLykuaI;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            value = this.service.getValue();
            if (value instanceof Status.Connected) {
                return ((Status.Connected) value).getBinder();
            }
            zCompareAndSet = this.service.compareAndSet(Status.Disconnected.INSTANCE, Status.Connecting.INSTANCE);
            if (zCompareAndSet) {
                Function1<Continuation<? super Intent>, Object> function1 = this.intentFactory;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(value);
                anonymousClass1.Z$0 = zCompareAndSet;
                anonymousClass1.label = 1;
                Object objInvoke = function1.invoke(anonymousClass1);
                if (objInvoke != coroutine_suspended) {
                    status = value;
                    obj = objInvoke;
                }
            } else {
                long j = SuspendingBindingConnectionKt.BINDING_TIMEOUT;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(value);
                anonymousClass1.Z$0 = zCompareAndSet;
                anonymousClass1.label = 2;
                objM2572withTimeoutOrNullKLykuaI = TimeoutKt.m2572withTimeoutOrNullKLykuaI(j, anonymousClass2, anonymousClass1);
                if (objM2572withTimeoutOrNullKLykuaI != coroutine_suspended) {
                    return objM2572withTimeoutOrNullKLykuaI;
                }
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        zCompareAndSet = anonymousClass1.Z$0;
        status = (Status) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        Intent intent = (Intent) obj;
        if (intent == null) {
            this.service.setValue(Status.Disconnected.INSTANCE);
            return null;
        }
        this.context.bindService(intent, this.connection, this.bindingFlags);
        value = status;
        long j2 = SuspendingBindingConnectionKt.BINDING_TIMEOUT;
        AnonymousClass2 anonymousClass22 = new AnonymousClass2(this, null);
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(value);
        anonymousClass1.Z$0 = zCompareAndSet;
        anonymousClass1.label = 2;
        objM2572withTimeoutOrNullKLykuaI = TimeoutKt.m2572withTimeoutOrNullKLykuaI(j2, anonymousClass22, anonymousClass1);
        if (objM2572withTimeoutOrNullKLykuaI != coroutine_suspended) {
            return coroutine_suspended;
        }
    }

    public /* synthetic */ SuspendingBindingConnection(Context context, Function1 function1, Function1 function12, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, function1, function12, (i2 & 8) != 0 ? 1 : i);
    }
}

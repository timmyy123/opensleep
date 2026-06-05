package io.rebble.pebblekit2.client;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.share.internal.ShareConstants;
import io.rebble.pebblekit2.PebbleKitProviderContract;
import io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever;
import io.rebble.pebblekit2.common.model.WatchIdentifier;
import io.rebble.pebblekit2.model.ConnectedWatch;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import kotlinx.serialization.json.JsonObject$$ExternalSyntheticLambda0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JW\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u000f\"\u0004\b\u0000\u0010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0006*\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\u000fH\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/rebble/pebblekit2/client/DefaultPebbleInfoRetriever;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "T", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "getUri", "", "projection", "Landroid/database/Cursor;", "mapper", "Lkotlinx/coroutines/flow/Flow;", "queryPebbleProvider", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Landroid/content/ContentResolver;", ShareConstants.MEDIA_URI, "", "flowOfChanges", "(Landroid/content/ContentResolver;Landroid/net/Uri;)Lkotlinx/coroutines/flow/Flow;", "mapToList", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lio/rebble/pebblekit2/model/ConnectedWatch;", "getConnectedWatches", "()Lkotlinx/coroutines/flow/Flow;", "Landroid/content/Context;", "client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultPebbleInfoRetriever {
    private final Context context;

    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$flowOfChanges$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$flowOfChanges$1", f = "DefaultPebbleInfoRetriever.kt", l = {127}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentResolver $this_flowOfChanges;
        final /* synthetic */ Uri $uri;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContentResolver contentResolver, Uri uri, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_flowOfChanges = contentResolver;
            this.$uri = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(ContentResolver contentResolver, DefaultPebbleInfoRetriever$flowOfChanges$1$observer$1 defaultPebbleInfoRetriever$flowOfChanges$1$observer$1) {
            contentResolver.unregisterContentObserver(defaultPebbleInfoRetriever$flowOfChanges$1$observer$1);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_flowOfChanges, this.$uri, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [android.database.ContentObserver, io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$flowOfChanges$1$observer$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Handler handler = new Handler(Looper.getMainLooper());
                final ?? r2 = new ContentObserver(handler) { // from class: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$flowOfChanges$1$observer$1
                    @Override // android.database.ContentObserver
                    public void onChange(boolean selfChange) {
                        producerScope.mo2581trySendJP2dKIU(Unit.INSTANCE);
                    }
                };
                this.$this_flowOfChanges.registerContentObserver(this.$uri, false, r2);
                producerScope.mo2581trySendJP2dKIU(Unit.INSTANCE);
                final ContentResolver contentResolver = this.$this_flowOfChanges;
                Function0 function0 = new Function0() { // from class: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$flowOfChanges$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultPebbleInfoRetriever.AnonymousClass1.invokeSuspend$lambda$0(contentResolver, r2);
                    }
                };
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$1", f = "DefaultPebbleInfoRetriever.kt", l = {92}, m = "invokeSuspend", v = 2)
    public static final class C22681 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        public C22681(Continuation<? super C22681> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DefaultPebbleInfoRetriever.this.new C22681(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> continuation) {
            return ((C22681) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            PebbleAndroidAppPicker companion = DefaultPebbleAndroidAppPicker.INSTANCE.getInstance(DefaultPebbleInfoRetriever.this.context);
            this.label = 1;
            Object currentlySelectedApp = companion.getCurrentlySelectedApp(this);
            return currentlySelectedApp == coroutine_suspended ? coroutine_suspended : currentlySelectedApp;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "T", "pebbleAppPackage", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$2", f = "DefaultPebbleInfoRetriever.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<String, Continuation<? super Flow<? extends List<? extends T>>>, Object> {
        final /* synthetic */ Function1<String, Uri> $getUri;
        final /* synthetic */ Function1<Cursor, T> $mapper;
        final /* synthetic */ List<String> $projection;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DefaultPebbleInfoRetriever this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super String, ? extends Uri> function1, DefaultPebbleInfoRetriever defaultPebbleInfoRetriever, List<String> list, Function1<? super Cursor, ? extends T> function12, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$getUri = function1;
            this.this$0 = defaultPebbleInfoRetriever;
            this.$projection = list;
            this.$mapper = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$getUri, this.this$0, this.$projection, this.$mapper, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Flow<? extends List<? extends T>>> continuation) {
            return ((AnonymousClass2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            if (str == null) {
                return FlowKt.flowOf(CollectionsKt.emptyList());
            }
            final Uri uriInvoke = this.$getUri.invoke(str);
            DefaultPebbleInfoRetriever defaultPebbleInfoRetriever = this.this$0;
            ContentResolver contentResolver = defaultPebbleInfoRetriever.context.getContentResolver();
            contentResolver.getClass();
            final Flow flowFlowOfChanges = defaultPebbleInfoRetriever.flowOfChanges(contentResolver, uriInvoke);
            final DefaultPebbleInfoRetriever defaultPebbleInfoRetriever2 = this.this$0;
            final List<String> list = this.$projection;
            final Function1<Cursor, T> function1 = this.$mapper;
            return new Flow<List<? extends T>>() { // from class: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$2$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Function1 $mapper$inlined;
                    final /* synthetic */ List $projection$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ Uri $uri$inlined;
                    final /* synthetic */ DefaultPebbleInfoRetriever this$0;

                    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                    @DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever$queryPebbleProvider$2$invokeSuspend$$inlined$map$1$2", f = "DefaultPebbleInfoRetriever.kt", l = {50}, m = "emit", v = 2)
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

                    public AnonymousClass2(FlowCollector flowCollector, DefaultPebbleInfoRetriever defaultPebbleInfoRetriever, Uri uri, List list, Function1 function1) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = defaultPebbleInfoRetriever;
                        this.$uri$inlined = uri;
                        this.$projection$inlined = list;
                        this.$mapper$inlined = function1;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        List listMapToList;
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
                            Cursor cursorQuery = this.this$0.context.getContentResolver().query(this.$uri$inlined, (String[]) this.$projection$inlined.toArray(new String[0]), null, null, null, null);
                            if (cursorQuery != null) {
                                try {
                                    listMapToList = this.this$0.mapToList(cursorQuery, this.$mapper$inlined);
                                } finally {
                                }
                            } else {
                                listMapToList = null;
                            }
                            if (listMapToList == null) {
                                listMapToList = CollectionsKt.emptyList();
                            }
                            CloseableKt.closeFinally(cursorQuery, null);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(listMapToList, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
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
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object objCollect = flowFlowOfChanges.collect(new AnonymousClass2(flowCollector, defaultPebbleInfoRetriever2, uriInvoke, list, function1), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
        }
    }

    public DefaultPebbleInfoRetriever(Context context) {
        context.getClass();
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Unit> flowOfChanges(ContentResolver contentResolver, Uri uri) {
        return FlowKt__ContextKt.buffer$default(FlowKt.channelFlow(new AnonymousClass1(contentResolver, uri, null)), -1, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri getConnectedWatches$lambda$0(String str) {
        str.getClass();
        return PebbleKitProviderContract.ConnectedWatch.getContentUri(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectedWatch getConnectedWatches$lambda$1(Cursor cursor) {
        cursor.getClass();
        String string = cursor.getString(0);
        string.getClass();
        String strM2350constructorimpl = WatchIdentifier.m2350constructorimpl(string);
        String string2 = cursor.getString(1);
        string2.getClass();
        String string3 = cursor.getString(2);
        string3.getClass();
        String string4 = cursor.getString(3);
        string4.getClass();
        return new ConnectedWatch(strM2350constructorimpl, string2, string3, string4, cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getString(7), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> List<T> mapToList(Cursor cursor, Function1<? super Cursor, ? extends T> function1) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        while (cursor.moveToNext()) {
            listCreateListBuilder.add(function1.invoke(cursor));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private final <T> Flow<List<T>> queryPebbleProvider(Function1<? super String, ? extends Uri> getUri, List<String> projection, Function1<? super Cursor, ? extends T> mapper) {
        return FlowKt.flatMapConcat(FlowKt.asFlow(new C22681(null)), new AnonymousClass2(getUri, this, projection, mapper, null));
    }

    public Flow<List<ConnectedWatch>> getConnectedWatches() {
        return queryPebbleProvider(new JsonObject$$ExternalSyntheticLambda0(1), PebbleKitProviderContract.ConnectedWatch.getALL_COLUMNS(), new JsonObject$$ExternalSyntheticLambda0(2));
    }
}

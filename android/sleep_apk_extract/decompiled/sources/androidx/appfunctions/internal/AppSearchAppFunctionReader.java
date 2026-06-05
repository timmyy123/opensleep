package androidx.appfunctions.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.util.Log;
import androidx.appfunctions.AppFunctionFunctionNotFoundException;
import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionDeprecationMetadata;
import androidx.appfunctions.metadata.AppFunctionDeprecationMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionName;
import androidx.appfunctions.metadata.AppFunctionPackageMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionRuntimeMetadata;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import androidx.appsearch.app.AppSearchBatchResult;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.GetByDocumentIdRequest;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.app.JoinSpec;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.app.SearchResults;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.observer.DocumentChangeInfo;
import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.observer.ObserverSpec;
import androidx.appsearch.observer.SchemaChangeInfo;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.util.concurrent.ListenableFuture;
import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0016J2\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\n\b\u0000\u0010\u001f\u0018\u0001*\u00020 2\u0006\u0010!\u001a\u00020\"H\u0082\b¢\u0006\u0002\u0010#J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\"H\u0002J \u00100\u001a\u0004\u0018\u00010%2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0012H\u0002J\"\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\n2\u0006\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010.H\u0002J\u001c\u00109\u001a\u0004\u0018\u00010:2\u0006\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010.H\u0002J8\u0010;\u001a\u0004\u0018\u00010\u00192\u0006\u00102\u001a\u00020\u00122\u0006\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010.2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u00107\u001a\u00020*H\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010/\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Landroidx/appfunctions/internal/AppSearchAppFunctionReader;", "Landroidx/appfunctions/internal/AppFunctionReader;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "schemaAppFunctionInventory", "Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "<init>", "(Landroid/content/Context;Landroidx/appfunctions/internal/SchemaAppFunctionInventory;)V", "searchAppFunctions", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "searchFunctionSpec", "Landroidx/appfunctions/AppFunctionSearchSpec;", "buildObserverSpec", "Landroidx/appsearch/observer/ObserverSpec;", "packageNames", "", "", "performSearch", "session", "Landroidx/appsearch/app/GlobalSearchSession;", "(Landroidx/appsearch/app/GlobalSearchSession;Landroidx/appfunctions/AppFunctionSearchSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTopLevelComponent", "", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "(Landroidx/appsearch/app/GlobalSearchSession;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractAppFunctionComponentsMetadataFromSearchResult", "searchResult", "Landroidx/appsearch/app/SearchResult;", "safeCastToDocumentClass", "T", "", "genericDocument", "Landroidx/appsearch/app/GenericDocument;", "(Landroidx/appsearch/app/GenericDocument;)Ljava/lang/Object;", "convertSearchResultToAppFunctionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "sharedTopLevelComponentsByPackage", "computeEffectivelyEnabled", "", "staticMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;", "runtimeMetadata", "Landroidx/appfunctions/metadata/AppFunctionRuntimeMetadata;", "buildSchemaMetadataFromGdForLegacyIndexer", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "document", "getAppFunctionMetadata", AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG, "packageName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppFunctionId", "getAppFunctionParameterMetadata", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "appFunctionMetadataDocument", "schemaMetadata", "getAppFunctionResponseMetadata", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "getAppFunctionComponentsMetadata", "getAppFunctionDeprecationMetadata", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "isAppFunctionMetadataDocumentFromDynamicIndexer", "AppSearchChannelObserver", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppSearchAppFunctionReader implements AppFunctionReader {

    @Deprecated
    public static final String APP_FUNCTIONS_NAMESPACE = "app_functions";

    @Deprecated
    public static final String APP_FUNCTIONS_RUNTIME_DATABASE_NAME = "appfunctions-db";

    @Deprecated
    public static final String APP_FUNCTIONS_RUNTIME_NAMESPACE = "app_functions_runtime";

    @Deprecated
    public static final String APP_FUNCTIONS_STATIC_DATABASE_NAME = "apps-db";
    private static final Companion Companion = new Companion(null);
    private static final long OBSERVER_DEBOUNCE_MILLIS;
    private static final SearchSpec RUNTIME_SEARCH_SPEC;

    @Deprecated
    public static final String SYSTEM_PACKAGE_NAME = "android";
    private final Context context;
    private final SchemaAppFunctionInventory schemaAppFunctionInventory;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u0006\u0010\u000e\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/internal/AppSearchAppFunctionReader$AppSearchChannelObserver;", "Landroidx/appsearch/observer/ObserverCallback;", "<init>", "()V", "updateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "onSchemaChanged", "changeInfo", "Landroidx/appsearch/observer/SchemaChangeInfo;", "onDocumentChanged", "Landroidx/appsearch/observer/DocumentChangeInfo;", "observe", "Lkotlinx/coroutines/flow/Flow;", "close", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppSearchChannelObserver implements ObserverCallback {
        private final Channel<Unit> updateChannel = ChannelKt.Channel$default(0, null, null, 6, null);

        public final void close() {
            SendChannel.close$default(this.updateChannel, null, 1, null);
        }

        public final Flow<Unit> observe() {
            return FlowKt.receiveAsFlow(this.updateChannel);
        }

        @Override // androidx.appsearch.observer.ObserverCallback
        public void onDocumentChanged(DocumentChangeInfo changeInfo) {
            changeInfo.getClass();
            this.updateChannel.mo2581trySendJP2dKIU(Unit.INSTANCE);
        }

        @Override // androidx.appsearch.observer.ObserverCallback
        public void onSchemaChanged(SchemaChangeInfo changeInfo) {
            changeInfo.getClass();
            this.updateChannel.mo2581trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/appfunctions/internal/AppSearchAppFunctionReader$Companion;", "", "<init>", "()V", "SYSTEM_PACKAGE_NAME", "", "APP_FUNCTIONS_NAMESPACE", "APP_FUNCTIONS_RUNTIME_NAMESPACE", "APP_FUNCTIONS_STATIC_DATABASE_NAME", "APP_FUNCTIONS_RUNTIME_DATABASE_NAME", "OBSERVER_DEBOUNCE_MILLIS", "Lkotlin/time/Duration;", "getOBSERVER_DEBOUNCE_MILLIS-UwyO8pc", "()J", "J", "RUNTIME_SEARCH_SPEC", "Landroidx/appsearch/app/SearchSpec;", "getRUNTIME_SEARCH_SPEC", "()Landroidx/appsearch/app/SearchSpec;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getOBSERVER_DEBOUNCE_MILLIS-UwyO8pc, reason: not valid java name */
        public final long m36getOBSERVER_DEBOUNCE_MILLISUwyO8pc() {
            return AppSearchAppFunctionReader.OBSERVER_DEBOUNCE_MILLIS;
        }

        public final SearchSpec getRUNTIME_SEARCH_SPEC() {
            return AppSearchAppFunctionReader.RUNTIME_SEARCH_SPEC;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$getAppFunctionMetadata$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader", f = "AppSearchAppFunctionReader.kt", l = {376, 388, 398, 424}, m = "getAppFunctionMetadata", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchAppFunctionReader.this.getAppFunctionMetadata(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$performSearch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader", f = "AppSearchAppFunctionReader.kt", l = {175, 182}, m = "performSearch", v = 1)
    public static final class C00821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00821(Continuation<? super C00821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchAppFunctionReader.this.performSearch(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$1", f = "AppSearchAppFunctionReader.kt", l = {85}, m = "invokeSuspend", v = 1)
    public static final class C00831 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends AppFunctionPackageMetadata>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C00831(Continuation<? super C00831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00831 c00831 = new C00831(continuation);
            c00831.L$0 = obj;
            return c00831;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<AppFunctionPackageMetadata>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00831) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                List listEmptyList = CollectionsKt.emptyList();
                this.label = 1;
                if (flowCollector.emit(listEmptyList, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends AppFunctionPackageMetadata>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<AppFunctionPackageMetadata>>) flowCollector, continuation);
        }
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2", f = "AppSearchAppFunctionReader.kt", l = {89, 92, 92, 113}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends AppFunctionPackageMetadata>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppFunctionSearchSpec $searchFunctionSpec;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AppFunctionSearchSpec appFunctionSearchSpec, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$searchFunctionSpec = appFunctionSearchSpec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Job job, AppSearchChannelObserver appSearchChannelObserver, GlobalSearchSession globalSearchSession) {
            Job.cancel$default(job, null, 1, null);
            appSearchChannelObserver.close();
            globalSearchSession.unregisterObserverCallback("android", appSearchChannelObserver);
            globalSearchSession.close();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = AppSearchAppFunctionReader.this.new AnonymousClass2(this.$searchFunctionSpec, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super List<AppFunctionPackageMetadata>> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00db, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r11, r4, r20) != r1) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope;
            Object objCreateSearchSession;
            GlobalSearchSession globalSearchSession;
            Object objPerformSearch;
            ProducerScope producerScope2;
            final GlobalSearchSession globalSearchSession2;
            ProducerScope producerScope3;
            Set<String> packageNames;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                Context context = AppSearchAppFunctionReader.this.context;
                this.L$0 = producerScope;
                this.label = 1;
                objCreateSearchSession = AppSearchUtilsKt.createSearchSession(context, this);
                if (objCreateSearchSession != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                producerScope = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objCreateSearchSession = obj;
            } else {
                if (i == 2) {
                    producerScope = (ProducerScope) this.L$2;
                    GlobalSearchSession globalSearchSession3 = (GlobalSearchSession) this.L$1;
                    ProducerScope producerScope4 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope2 = producerScope4;
                    globalSearchSession = globalSearchSession3;
                    objPerformSearch = obj;
                    this.L$0 = producerScope2;
                    this.L$1 = globalSearchSession;
                    this.L$2 = null;
                    this.label = 3;
                    if (producerScope.send(objPerformSearch, this) != coroutine_suspended) {
                        globalSearchSession2 = globalSearchSession;
                        producerScope3 = producerScope2;
                        final AppSearchChannelObserver appSearchChannelObserver = new AppSearchChannelObserver();
                        AppSearchAppFunctionReader appSearchAppFunctionReader = AppSearchAppFunctionReader.this;
                        packageNames = this.$searchFunctionSpec.getPackageNames();
                        if (packageNames == null) {
                        }
                        globalSearchSession2.registerObserverCallback("android", appSearchAppFunctionReader.buildObserverSpec(packageNames), ExecutorsKt.asExecutor(Dispatchers.INSTANCE.getWorker()), appSearchChannelObserver);
                        ProducerScope producerScope5 = producerScope3;
                        final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(producerScope5, null, null, new AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1(appSearchChannelObserver, producerScope5, AppSearchAppFunctionReader.this, globalSearchSession2, this.$searchFunctionSpec, null), 3, null);
                        Function0 function0 = new Function0() { // from class: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AppSearchAppFunctionReader.AnonymousClass2.invokeSuspend$lambda$0(jobLaunch$default, appSearchChannelObserver, globalSearchSession2);
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                GlobalSearchSession globalSearchSession4 = (GlobalSearchSession) this.L$1;
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                globalSearchSession2 = globalSearchSession4;
                producerScope3 = producerScope6;
                final AppSearchChannelObserver appSearchChannelObserver2 = new AppSearchChannelObserver();
                AppSearchAppFunctionReader appSearchAppFunctionReader2 = AppSearchAppFunctionReader.this;
                packageNames = this.$searchFunctionSpec.getPackageNames();
                if (packageNames == null) {
                    packageNames = SetsKt.emptySet();
                }
                globalSearchSession2.registerObserverCallback("android", appSearchAppFunctionReader2.buildObserverSpec(packageNames), ExecutorsKt.asExecutor(Dispatchers.INSTANCE.getWorker()), appSearchChannelObserver2);
                ProducerScope producerScope52 = producerScope3;
                final Job jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(producerScope52, null, null, new AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1(appSearchChannelObserver2, producerScope52, AppSearchAppFunctionReader.this, globalSearchSession2, this.$searchFunctionSpec, null), 3, null);
                Function0 function02 = new Function0() { // from class: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppSearchAppFunctionReader.AnonymousClass2.invokeSuspend$lambda$0(jobLaunch$default2, appSearchChannelObserver2, globalSearchSession2);
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.label = 4;
            }
            globalSearchSession = (GlobalSearchSession) objCreateSearchSession;
            AppSearchAppFunctionReader appSearchAppFunctionReader3 = AppSearchAppFunctionReader.this;
            AppFunctionSearchSpec appFunctionSearchSpec = this.$searchFunctionSpec;
            this.L$0 = producerScope;
            this.L$1 = globalSearchSession;
            this.L$2 = producerScope;
            this.label = 2;
            objPerformSearch = appSearchAppFunctionReader3.performSearch(globalSearchSession, appFunctionSearchSpec, this);
            if (objPerformSearch != coroutine_suspended) {
                producerScope2 = producerScope;
                this.L$0 = producerScope2;
                this.L$1 = globalSearchSession;
                this.L$2 = null;
                this.label = 3;
                if (producerScope.send(objPerformSearch, this) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super List<? extends AppFunctionPackageMetadata>> producerScope, Continuation<? super Unit> continuation) {
            return invoke2((ProducerScope<? super List<AppFunctionPackageMetadata>>) producerScope, continuation);
        }
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchTopLevelComponent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader", f = "AppSearchAppFunctionReader.kt", l = {225}, m = "searchTopLevelComponent", v = 1)
    public static final class C00841 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C00841(Continuation<? super C00841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchAppFunctionReader.this.searchTopLevelComponent(null, null, this);
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        OBSERVER_DEBOUNCE_MILLIS = DurationKt.toDuration(1, DurationUnit.SECONDS);
        SearchSpec searchSpecBuild = new SearchSpec.Builder().addFilterNamespaces(APP_FUNCTIONS_RUNTIME_NAMESPACE).addFilterDocumentClasses(AppFunctionRuntimeMetadata.class).addFilterPackageNames("android").setVerbatimSearchEnabled(true).build();
        searchSpecBuild.getClass();
        RUNTIME_SEARCH_SPEC = searchSpecBuild;
    }

    public AppSearchAppFunctionReader(Context context, SchemaAppFunctionInventory schemaAppFunctionInventory) {
        context.getClass();
        this.context = context;
        this.schemaAppFunctionInventory = schemaAppFunctionInventory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ObserverSpec buildObserverSpec(Set<String> packageNames) {
        ObserverSpec.Builder builder = new ObserverSpec.Builder();
        ArrayList arrayList = new ArrayList();
        for (String str : packageNames) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new String[]{FileInsert$$ExternalSyntheticOutline0.m("AppFunctionStaticMetadata-", str), FileInsert$$ExternalSyntheticOutline0.m("AppFunctionRuntimeMetadata-", str), FileInsert$$ExternalSyntheticOutline0.m("AppFunctionComponentMetadataDocument-", str)}));
        }
        ObserverSpec observerSpecBuild = builder.addFilterSchemas(arrayList).build();
        observerSpecBuild.getClass();
        return observerSpecBuild;
    }

    private final AppFunctionSchemaMetadata buildSchemaMetadataFromGdForLegacyIndexer(GenericDocument document) {
        String propertyString = document.getPropertyString("schemaName");
        String propertyString2 = document.getPropertyString("schemaCategory");
        long propertyLong = document.getPropertyLong("schemaVersion");
        if (propertyString != null && propertyString2 != null && propertyLong != 0) {
            return new AppFunctionSchemaMetadata(propertyString2, propertyString, propertyLong);
        }
        if (propertyString == null && propertyString2 == null && propertyLong == 0) {
            return null;
        }
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Unexpected state: schemaName=", propertyString, ", schemaCategory=", propertyString2, ", schemaVersion=");
        sbM6m.append(propertyLong);
        Log.e(Constants.APP_FUNCTIONS_TAG, sbM6m.toString());
        return null;
    }

    private final boolean computeEffectivelyEnabled(AppFunctionMetadataDocument staticMetadata, AppFunctionRuntimeMetadata runtimeMetadata) {
        int enabled = (int) runtimeMetadata.getEnabled();
        if (enabled == 0) {
            return staticMetadata.isEnabledByDefault();
        }
        if (enabled == 1) {
            return true;
        }
        if (enabled == 2) {
            return false;
        }
        throw new IllegalStateException("Unknown AppFunction state: " + runtimeMetadata.getEnabled() + '.');
    }

    private final AppFunctionMetadata convertSearchResultToAppFunctionMetadata(SearchResult searchResult, Map<String, AppFunctionComponentsMetadata> sharedTopLevelComponentsByPackage) {
        Object documentClass;
        Object documentClass2;
        AppFunctionResponseMetadata appFunctionResponseMetadata;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata;
        String propertyString = searchResult.getGenericDocument().getPropertyString(AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG);
        if (propertyString == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        String propertyString2 = searchResult.getGenericDocument().getPropertyString("packageName");
        if (propertyString2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        GenericDocument genericDocument = searchResult.getGenericDocument();
        genericDocument.getClass();
        try {
            documentClass = genericDocument.toDocumentClass(AppFunctionMetadataDocument.class);
        } catch (Exception e) {
            Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument.getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionMetadataDocument.class).getSimpleName(), e);
            documentClass = null;
        }
        AppFunctionMetadataDocument appFunctionMetadataDocument = (AppFunctionMetadataDocument) documentClass;
        if (appFunctionMetadataDocument == null) {
            return null;
        }
        List<SearchResult> joinedResults = searchResult.getJoinedResults();
        joinedResults.getClass();
        SearchResult searchResult2 = (SearchResult) CollectionsKt.singleOrNull((List) joinedResults);
        if (searchResult2 == null) {
            Log.e(Constants.APP_FUNCTIONS_TAG, "Runtime metadata not found for " + appFunctionMetadataDocument.getId());
            return null;
        }
        GenericDocument genericDocument2 = searchResult2.getGenericDocument();
        genericDocument2.getClass();
        try {
            documentClass2 = genericDocument2.toDocumentClass(AppFunctionRuntimeMetadata.class);
        } catch (Exception e2) {
            Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument2.getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionRuntimeMetadata.class).getSimpleName(), e2);
            documentClass2 = null;
        }
        AppFunctionRuntimeMetadata appFunctionRuntimeMetadata = (AppFunctionRuntimeMetadata) documentClass2;
        if (appFunctionRuntimeMetadata == null) {
            return null;
        }
        GenericDocument genericDocument3 = searchResult.getGenericDocument();
        genericDocument3.getClass();
        AppFunctionSchemaMetadata appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer = buildSchemaMetadataFromGdForLegacyIndexer(genericDocument3);
        List<AppFunctionParameterMetadata> appFunctionParameterMetadata = getAppFunctionParameterMetadata(appFunctionMetadataDocument, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer);
        if (appFunctionParameterMetadata == null || (appFunctionResponseMetadata = getAppFunctionResponseMetadata(appFunctionMetadataDocument, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer)) == null || (appFunctionComponentsMetadata = getAppFunctionComponentsMetadata(propertyString2, appFunctionMetadataDocument, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer, sharedTopLevelComponentsByPackage)) == null) {
            return null;
        }
        AppFunctionDeprecationMetadata appFunctionDeprecationMetadata = getAppFunctionDeprecationMetadata(appFunctionMetadataDocument);
        AppFunctionName appFunctionName = new AppFunctionName(propertyString2, propertyString);
        AppFunctionPackageMetadata appFunctionPackageMetadata = new AppFunctionPackageMetadata(propertyString2, appFunctionComponentsMetadata);
        String description = appFunctionMetadataDocument.getDescription();
        if (description == null) {
            description = "";
        }
        return new AppFunctionMetadata(appFunctionName, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer, appFunctionParameterMetadata, appFunctionResponseMetadata, appFunctionPackageMetadata, computeEffectivelyEnabled(appFunctionMetadataDocument, appFunctionRuntimeMetadata), description, appFunctionDeprecationMetadata);
    }

    private final AppFunctionComponentsMetadata extractAppFunctionComponentsMetadataFromSearchResult(SearchResult searchResult) {
        Object documentClass;
        try {
            GenericDocument genericDocument = searchResult.getGenericDocument();
            genericDocument.getClass();
            try {
                documentClass = genericDocument.toDocumentClass(AppFunctionComponentsMetadataDocument.class);
            } catch (Exception e) {
                Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument.getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionComponentsMetadataDocument.class).getSimpleName(), e);
                documentClass = null;
            }
            AppFunctionComponentsMetadataDocument appFunctionComponentsMetadataDocument = (AppFunctionComponentsMetadataDocument) documentClass;
            if (appFunctionComponentsMetadataDocument != null) {
                return appFunctionComponentsMetadataDocument.toAppFunctionComponentsMetadata();
            }
            return null;
        } catch (Exception e2) {
            Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + searchResult.getGenericDocument().getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionComponentsMetadata.class).getSimpleName(), e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AppFunctionComponentsMetadata getAppFunctionComponentsMetadata(String packageName, AppFunctionMetadataDocument appFunctionMetadataDocument, AppFunctionSchemaMetadata schemaMetadata, Map<String, AppFunctionComponentsMetadata> sharedTopLevelComponentsByPackage) {
        SchemaAppFunctionInventory schemaAppFunctionInventory;
        Map map = null;
        Object[] objArr = 0;
        if (isAppFunctionMetadataDocumentFromDynamicIndexer(appFunctionMetadataDocument)) {
            AppFunctionComponentsMetadata appFunctionComponentsMetadata = sharedTopLevelComponentsByPackage.get(packageName);
            return appFunctionComponentsMetadata == null ? new AppFunctionComponentsMetadata(map, 1, objArr == true ? 1 : 0) : appFunctionComponentsMetadata;
        }
        if (schemaMetadata == null || (schemaAppFunctionInventory = this.schemaAppFunctionInventory) == null) {
            return null;
        }
        return schemaAppFunctionInventory.getComponentsMetadata();
    }

    private final AppFunctionDeprecationMetadata getAppFunctionDeprecationMetadata(AppFunctionMetadataDocument appFunctionMetadataDocument) {
        AppFunctionDeprecationMetadataDocument deprecation = appFunctionMetadataDocument.getDeprecation();
        if (deprecation != null) {
            return deprecation.toAppFunctionDeprecationMetadata();
        }
        return null;
    }

    private final String getAppFunctionId(String packageName, String functionId) {
        return packageName + '/' + functionId;
    }

    private final List<AppFunctionParameterMetadata> getAppFunctionParameterMetadata(AppFunctionMetadataDocument appFunctionMetadataDocument, AppFunctionSchemaMetadata schemaMetadata) {
        SchemaAppFunctionInventory schemaAppFunctionInventory;
        Map<AppFunctionSchemaMetadata, CompileTimeAppFunctionMetadata> schemaFunctionsMap;
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata;
        if (!isAppFunctionMetadataDocumentFromDynamicIndexer(appFunctionMetadataDocument)) {
            if (schemaMetadata == null || (schemaAppFunctionInventory = this.schemaAppFunctionInventory) == null || (schemaFunctionsMap = schemaAppFunctionInventory.getSchemaFunctionsMap()) == null || (compileTimeAppFunctionMetadata = schemaFunctionsMap.get(schemaMetadata)) == null) {
                return null;
            }
            return compileTimeAppFunctionMetadata.getParameters();
        }
        List<AppFunctionParameterMetadataDocument> parameters = appFunctionMetadataDocument.getParameters();
        if (parameters == null) {
            return CollectionsKt.emptyList();
        }
        List<AppFunctionParameterMetadataDocument> list = parameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionParameterMetadataDocument) it.next()).toAppFunctionParameterMetadata());
        }
        return arrayList;
    }

    private final AppFunctionResponseMetadata getAppFunctionResponseMetadata(AppFunctionMetadataDocument appFunctionMetadataDocument, AppFunctionSchemaMetadata schemaMetadata) {
        SchemaAppFunctionInventory schemaAppFunctionInventory;
        Map<AppFunctionSchemaMetadata, CompileTimeAppFunctionMetadata> schemaFunctionsMap;
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata;
        if (isAppFunctionMetadataDocumentFromDynamicIndexer(appFunctionMetadataDocument)) {
            AppFunctionResponseMetadataDocument response = appFunctionMetadataDocument.getResponse();
            if (response != null) {
                return response.toAppFunctionResponseMetadata();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            return null;
        }
        if (schemaMetadata == null || (schemaAppFunctionInventory = this.schemaAppFunctionInventory) == null || (schemaFunctionsMap = schemaAppFunctionInventory.getSchemaFunctionsMap()) == null || (compileTimeAppFunctionMetadata = schemaFunctionsMap.get(schemaMetadata)) == null) {
            return null;
        }
        return compileTimeAppFunctionMetadata.getResponse();
    }

    private final boolean isAppFunctionMetadataDocumentFromDynamicIndexer(AppFunctionMetadataDocument document) {
        return document.getResponse() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00cd, code lost:
    
        if (r11 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performSearch(GlobalSearchSession globalSearchSession, AppFunctionSearchSpec appFunctionSearchSpec, Continuation<? super List<AppFunctionPackageMetadata>> continuation) {
        C00821 c00821;
        SearchSpec searchSpecBuild;
        Object objSearchTopLevelComponent;
        if (continuation instanceof C00821) {
            c00821 = (C00821) continuation;
            int i = c00821.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00821.label = i - Integer.MIN_VALUE;
            } else {
                c00821 = new C00821(continuation);
            }
        }
        Object all = c00821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c00821.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(all);
            JoinSpec joinSpecBuild = new JoinSpec.Builder(AppFunctionRuntimeMetadata.STATIC_METADATA_JOIN_PROPERTY).setNestedSearch("", RUNTIME_SEARCH_SPEC).build();
            joinSpecBuild.getClass();
            searchSpecBuild = new SearchSpec.Builder().addFilterNamespaces(APP_FUNCTIONS_NAMESPACE).addFilterDocumentClasses(AppFunctionMetadataDocument.class).addFilterPackageNames("android").setJoinSpec(joinSpecBuild).setVerbatimSearchEnabled(true).setNumericSearchEnabled(true).setListFilterQueryLanguageEnabled(true).build();
            searchSpecBuild.getClass();
            Set<String> packageNames = appFunctionSearchSpec.getPackageNames();
            c00821.L$0 = globalSearchSession;
            c00821.L$1 = appFunctionSearchSpec;
            c00821.L$2 = searchSpecBuild;
            c00821.label = 1;
            objSearchTopLevelComponent = searchTopLevelComponent(globalSearchSession, packageNames, c00821);
            if (objSearchTopLevelComponent != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(all);
            List listFilterNotNull = CollectionsKt.filterNotNull((Iterable) all);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listFilterNotNull) {
                String packageName = ((AppFunctionMetadata) obj).getPackageName();
                Object arrayList = linkedHashMap.get(packageName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(packageName, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList2.add(new AppFunctionPackageMetadata((String) entry.getKey(), (List) entry.getValue(), null, 4, null));
            }
            return arrayList2;
        }
        SearchSpec searchSpec = (SearchSpec) c00821.L$2;
        appFunctionSearchSpec = (AppFunctionSearchSpec) c00821.L$1;
        GlobalSearchSession globalSearchSession2 = (GlobalSearchSession) c00821.L$0;
        ResultKt.throwOnFailure(all);
        searchSpecBuild = searchSpec;
        globalSearchSession = globalSearchSession2;
        objSearchTopLevelComponent = all;
        SearchResults searchResultsSearch = globalSearchSession.search(appFunctionSearchSpec.toStaticMetadataAppSearchQuery$appfunctions(), searchSpecBuild);
        searchResultsSearch.getClass();
        FunSpec$$ExternalSyntheticLambda1 funSpec$$ExternalSyntheticLambda1 = new FunSpec$$ExternalSyntheticLambda1(this, (Map) objSearchTopLevelComponent, 3);
        c00821.L$0 = null;
        c00821.L$1 = null;
        c00821.L$2 = null;
        c00821.label = 2;
        all = AppSearchUtilsKt.readAll(searchResultsSearch, funSpec$$ExternalSyntheticLambda1, c00821);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionMetadata performSearch$lambda$0(AppSearchAppFunctionReader appSearchAppFunctionReader, Map map, SearchResult searchResult) {
        searchResult.getClass();
        try {
            return appSearchAppFunctionReader.convertSearchResultToAppFunctionMetadata(searchResult, map);
        } catch (Exception e) {
            Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + searchResult.getGenericDocument().getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionMetadata.class).getSimpleName(), e);
            return null;
        }
    }

    private final /* synthetic */ <T> T safeCastToDocumentClass(GenericDocument genericDocument) {
        try {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) genericDocument.toDocumentClass(Object.class);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Failed to convert search result ");
            sb.append(genericDocument.getId());
            sb.append(" to ");
            Intrinsics.reifiedOperationMarker(4, "T");
            sb.append(Reflection.getOrCreateKotlinClass(Object.class).getSimpleName());
            Log.w(Constants.APP_FUNCTIONS_TAG, sb.toString(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchTopLevelComponent(GlobalSearchSession globalSearchSession, Set<String> set, Continuation<? super Map<String, AppFunctionComponentsMetadata>> continuation) {
        C00841 c00841;
        if (continuation instanceof C00841) {
            c00841 = (C00841) continuation;
            int i = c00841.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00841.label = i - Integer.MIN_VALUE;
            } else {
                c00841 = new C00841(continuation);
            }
        }
        Object all = c00841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c00841.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(all);
            SearchSpec.Builder builderAddFilterNamespaces = new SearchSpec.Builder().addFilterNamespaces(APP_FUNCTIONS_NAMESPACE);
            if (set == null) {
                set = SetsKt.emptySet();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt.listOf("AppFunctionComponentMetadataDocument-" + ((String) it.next())));
            }
            SearchSpec searchSpecBuild = builderAddFilterNamespaces.addFilterSchemas(arrayList).addFilterPackageNames("android").setVerbatimSearchEnabled(true).setNumericSearchEnabled(true).setListFilterQueryLanguageEnabled(true).build();
            searchSpecBuild.getClass();
            SearchResults searchResultsSearch = globalSearchSession.search("", searchSpecBuild);
            searchResultsSearch.getClass();
            CodecsKt$$ExternalSyntheticLambda2 codecsKt$$ExternalSyntheticLambda2 = new CodecsKt$$ExternalSyntheticLambda2(this, 2);
            c00841.label = 1;
            all = AppSearchUtilsKt.readAll(searchResultsSearch, codecsKt$$ExternalSyntheticLambda2, c00841);
            if (all == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(all);
        }
        return MapsKt.toMap(CollectionsKt.filterNotNull((Iterable) all));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair searchTopLevelComponent$lambda$1(AppSearchAppFunctionReader appSearchAppFunctionReader, SearchResult searchResult) {
        searchResult.getClass();
        String propertyString = searchResult.getGenericDocument().getPropertyString("packageName");
        AppFunctionComponentsMetadata appFunctionComponentsMetadataExtractAppFunctionComponentsMetadataFromSearchResult = appSearchAppFunctionReader.extractAppFunctionComponentsMetadataFromSearchResult(searchResult);
        if (propertyString == null || appFunctionComponentsMetadataExtractAppFunctionComponentsMetadataFromSearchResult == null || appFunctionComponentsMetadataExtractAppFunctionComponentsMetadataFromSearchResult.getDataTypes().isEmpty()) {
            return null;
        }
        return TuplesKt.to(propertyString, appFunctionComponentsMetadataExtractAppFunctionComponentsMetadataFromSearchResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0215 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    @Override // androidx.appfunctions.internal.AppFunctionReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAppFunctionMetadata(String str, String str2, Continuation<? super AppFunctionMetadata> continuation) throws AppFunctionFunctionNotFoundException {
        AnonymousClass1 anonymousClass1;
        Object obj;
        String str3;
        String str4;
        String appFunctionId;
        String str5;
        String str6;
        GlobalSearchSession globalSearchSession;
        Object objAwait;
        AppSearchBatchResult appSearchBatchResult;
        String str7;
        String str8;
        String str9;
        GenericDocument genericDocument;
        Object documentClass;
        Object documentClass2;
        AppFunctionSchemaMetadata appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer;
        List<AppFunctionParameterMetadata> appFunctionParameterMetadata;
        AppFunctionResponseMetadata appFunctionResponseMetadata;
        List<AppFunctionParameterMetadata> list;
        AppSearchAppFunctionReader appSearchAppFunctionReader;
        AppFunctionSchemaMetadata appFunctionSchemaMetadata;
        AppFunctionMetadataDocument appFunctionMetadataDocument;
        String str10;
        String str11;
        String str12;
        AppFunctionRuntimeMetadata appFunctionRuntimeMetadata;
        AppFunctionResponseMetadata appFunctionResponseMetadata2;
        AppFunctionMetadataDocument appFunctionMetadataDocument2;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objCreateSearchSession = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            obj = null;
            ResultKt.throwOnFailure(objCreateSearchSession);
            Context context = this.context;
            anonymousClass1.L$0 = str;
            str3 = str2;
            anonymousClass1.L$1 = str3;
            anonymousClass1.label = 1;
            objCreateSearchSession = AppSearchUtilsKt.createSearchSession(context, anonymousClass1);
            if (objCreateSearchSession != coroutine_suspended) {
                str4 = str;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                appFunctionId = (String) anonymousClass1.L$3;
                GlobalSearchSession globalSearchSession2 = (GlobalSearchSession) anonymousClass1.L$2;
                str6 = (String) anonymousClass1.L$1;
                obj = null;
                str5 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objCreateSearchSession);
                globalSearchSession = globalSearchSession2;
                AppSearchBatchResult appSearchBatchResult2 = (AppSearchBatchResult) objCreateSearchSession;
                ListenableFuture<AppSearchBatchResult<String, GenericDocument>> byDocumentIdAsync = globalSearchSession.getByDocumentIdAsync("android", APP_FUNCTIONS_RUNTIME_DATABASE_NAME, new GetByDocumentIdRequest.Builder(APP_FUNCTIONS_RUNTIME_NAMESPACE).addIds(appFunctionId).build());
                byDocumentIdAsync.getClass();
                anonymousClass1.L$0 = str5;
                anonymousClass1.L$1 = str6;
                anonymousClass1.L$2 = globalSearchSession;
                anonymousClass1.L$3 = appFunctionId;
                anonymousClass1.L$4 = appSearchBatchResult2;
                anonymousClass1.label = 3;
                objAwait = ListenableFutureKt.await(byDocumentIdAsync, anonymousClass1);
                if (objAwait != coroutine_suspended) {
                    String str13 = appFunctionId;
                    appSearchBatchResult = appSearchBatchResult2;
                    objCreateSearchSession = objAwait;
                    str7 = str13;
                    str8 = str6;
                    str9 = str5;
                    AppSearchBatchResult appSearchBatchResult3 = (AppSearchBatchResult) objCreateSearchSession;
                    genericDocument = (GenericDocument) appSearchBatchResult.getSuccesses().get(str7);
                    if (genericDocument != null) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer = (AppFunctionSchemaMetadata) anonymousClass1.L$10;
                appFunctionMetadataDocument2 = (AppFunctionMetadataDocument) anonymousClass1.L$9;
                str10 = (String) anonymousClass1.L$8;
                appSearchAppFunctionReader = (AppSearchAppFunctionReader) anonymousClass1.L$7;
                AppFunctionResponseMetadata appFunctionResponseMetadata3 = (AppFunctionResponseMetadata) anonymousClass1.L$6;
                List<AppFunctionParameterMetadata> list2 = (List) anonymousClass1.L$5;
                AppFunctionSchemaMetadata appFunctionSchemaMetadata2 = (AppFunctionSchemaMetadata) anonymousClass1.L$4;
                AppFunctionRuntimeMetadata appFunctionRuntimeMetadata2 = (AppFunctionRuntimeMetadata) anonymousClass1.L$3;
                appFunctionMetadataDocument = (AppFunctionMetadataDocument) anonymousClass1.L$2;
                str11 = (String) anonymousClass1.L$1;
                str12 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objCreateSearchSession);
                appFunctionResponseMetadata2 = appFunctionResponseMetadata3;
                appFunctionRuntimeMetadata = appFunctionRuntimeMetadata2;
                list = list2;
                appFunctionSchemaMetadata = appFunctionSchemaMetadata2;
                obj = null;
                appFunctionComponentsMetadata = appSearchAppFunctionReader.getAppFunctionComponentsMetadata(str10, appFunctionMetadataDocument2, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer, (Map) objCreateSearchSession);
                if (appFunctionComponentsMetadata != null) {
                    return obj;
                }
                AppFunctionDeprecationMetadata appFunctionDeprecationMetadata = getAppFunctionDeprecationMetadata(appFunctionMetadataDocument);
                AppFunctionName appFunctionName = new AppFunctionName(str11, str12);
                AppFunctionPackageMetadata appFunctionPackageMetadata = new AppFunctionPackageMetadata(str11, appFunctionComponentsMetadata);
                String description = appFunctionMetadataDocument.getDescription();
                if (description == null) {
                    description = "";
                }
                return new AppFunctionMetadata(appFunctionName, appFunctionSchemaMetadata, list, appFunctionResponseMetadata2, appFunctionPackageMetadata, computeEffectivelyEnabled(appFunctionMetadataDocument, appFunctionRuntimeMetadata), description, appFunctionDeprecationMetadata);
            }
            appSearchBatchResult = (AppSearchBatchResult) anonymousClass1.L$4;
            str7 = (String) anonymousClass1.L$3;
            globalSearchSession = (GlobalSearchSession) anonymousClass1.L$2;
            str8 = (String) anonymousClass1.L$1;
            str9 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCreateSearchSession);
            obj = null;
            AppSearchBatchResult appSearchBatchResult32 = (AppSearchBatchResult) objCreateSearchSession;
            genericDocument = (GenericDocument) appSearchBatchResult.getSuccesses().get(str7);
            if (genericDocument != null) {
                throw new AppFunctionFunctionNotFoundException(Fragment$$ExternalSyntheticOutline1.m("Function ", str9, " is not available under ", str8));
            }
            GenericDocument genericDocument2 = (GenericDocument) appSearchBatchResult32.getSuccesses().get(str7);
            if (genericDocument2 == null) {
                throw new AppFunctionFunctionNotFoundException(Fragment$$ExternalSyntheticOutline1.m("Function ", str9, " is not available under ", str8));
            }
            try {
                documentClass = genericDocument.toDocumentClass(AppFunctionMetadataDocument.class);
            } catch (Exception e) {
                Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument.getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionMetadataDocument.class).getSimpleName(), e);
                documentClass = obj;
            }
            AppFunctionMetadataDocument appFunctionMetadataDocument3 = (AppFunctionMetadataDocument) documentClass;
            if (appFunctionMetadataDocument3 == null) {
                return obj;
            }
            try {
                documentClass2 = genericDocument2.toDocumentClass(AppFunctionRuntimeMetadata.class);
            } catch (Exception e2) {
                Log.w(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument2.getId() + " to " + Reflection.getOrCreateKotlinClass(AppFunctionRuntimeMetadata.class).getSimpleName(), e2);
                documentClass2 = obj;
            }
            AppFunctionRuntimeMetadata appFunctionRuntimeMetadata3 = (AppFunctionRuntimeMetadata) documentClass2;
            if (appFunctionRuntimeMetadata3 == null || (appFunctionParameterMetadata = getAppFunctionParameterMetadata(appFunctionMetadataDocument3, (appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer = buildSchemaMetadataFromGdForLegacyIndexer(genericDocument)))) == null || (appFunctionResponseMetadata = getAppFunctionResponseMetadata(appFunctionMetadataDocument3, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer)) == null) {
                return obj;
            }
            Set<String> of = SetsKt.setOf(str8);
            anonymousClass1.L$0 = str9;
            anonymousClass1.L$1 = str8;
            anonymousClass1.L$2 = appFunctionMetadataDocument3;
            anonymousClass1.L$3 = appFunctionRuntimeMetadata3;
            anonymousClass1.L$4 = appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer;
            anonymousClass1.L$5 = appFunctionParameterMetadata;
            anonymousClass1.L$6 = appFunctionResponseMetadata;
            anonymousClass1.L$7 = this;
            anonymousClass1.L$8 = str8;
            anonymousClass1.L$9 = appFunctionMetadataDocument3;
            anonymousClass1.L$10 = appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer;
            anonymousClass1.label = 4;
            Object objSearchTopLevelComponent = searchTopLevelComponent(globalSearchSession, of, anonymousClass1);
            if (objSearchTopLevelComponent != coroutine_suspended) {
                list = appFunctionParameterMetadata;
                appSearchAppFunctionReader = this;
                appFunctionSchemaMetadata = appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer;
                objCreateSearchSession = objSearchTopLevelComponent;
                appFunctionMetadataDocument = appFunctionMetadataDocument3;
                str10 = str8;
                str11 = str10;
                str12 = str9;
                appFunctionRuntimeMetadata = appFunctionRuntimeMetadata3;
                appFunctionResponseMetadata2 = appFunctionResponseMetadata;
                appFunctionMetadataDocument2 = appFunctionMetadataDocument;
                appFunctionComponentsMetadata = appSearchAppFunctionReader.getAppFunctionComponentsMetadata(str10, appFunctionMetadataDocument2, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer, (Map) objCreateSearchSession);
                if (appFunctionComponentsMetadata != null) {
                }
            }
            return coroutine_suspended;
        }
        obj = null;
        String str14 = (String) anonymousClass1.L$1;
        str4 = (String) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objCreateSearchSession);
        str3 = str14;
        GlobalSearchSession globalSearchSession3 = (GlobalSearchSession) objCreateSearchSession;
        appFunctionId = getAppFunctionId(str3, str4);
        ListenableFuture<AppSearchBatchResult<String, GenericDocument>> byDocumentIdAsync2 = globalSearchSession3.getByDocumentIdAsync("android", APP_FUNCTIONS_STATIC_DATABASE_NAME, new GetByDocumentIdRequest.Builder(APP_FUNCTIONS_NAMESPACE).addIds(appFunctionId).build());
        byDocumentIdAsync2.getClass();
        anonymousClass1.L$0 = str4;
        anonymousClass1.L$1 = str3;
        anonymousClass1.L$2 = globalSearchSession3;
        anonymousClass1.L$3 = appFunctionId;
        anonymousClass1.label = 2;
        Object objAwait2 = ListenableFutureKt.await(byDocumentIdAsync2, anonymousClass1);
        if (objAwait2 != coroutine_suspended) {
            String str15 = str3;
            str5 = str4;
            str6 = str15;
            globalSearchSession = globalSearchSession3;
            objCreateSearchSession = objAwait2;
            AppSearchBatchResult appSearchBatchResult22 = (AppSearchBatchResult) objCreateSearchSession;
            ListenableFuture<AppSearchBatchResult<String, GenericDocument>> byDocumentIdAsync3 = globalSearchSession.getByDocumentIdAsync("android", APP_FUNCTIONS_RUNTIME_DATABASE_NAME, new GetByDocumentIdRequest.Builder(APP_FUNCTIONS_RUNTIME_NAMESPACE).addIds(appFunctionId).build());
            byDocumentIdAsync3.getClass();
            anonymousClass1.L$0 = str5;
            anonymousClass1.L$1 = str6;
            anonymousClass1.L$2 = globalSearchSession;
            anonymousClass1.L$3 = appFunctionId;
            anonymousClass1.L$4 = appSearchBatchResult22;
            anonymousClass1.label = 3;
            objAwait = ListenableFutureKt.await(byDocumentIdAsync3, anonymousClass1);
            if (objAwait != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    @Override // androidx.appfunctions.internal.AppFunctionReader
    public Flow<List<AppFunctionPackageMetadata>> searchAppFunctions(AppFunctionSearchSpec searchFunctionSpec) {
        searchFunctionSpec.getClass();
        Set<String> packageNames = searchFunctionSpec.getPackageNames();
        return (packageNames == null || !packageNames.isEmpty()) ? FlowKt.callbackFlow(new AnonymousClass2(searchFunctionSpec, null)) : FlowKt.flow(new C00831(null));
    }
}

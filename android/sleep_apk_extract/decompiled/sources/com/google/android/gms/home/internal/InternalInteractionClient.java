package com.google.android.gms.home.internal;

import android.accounts.Account;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.IInterface;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.serialization.FilterQuery;
import com.google.android.gms.internal.serialization.InteractionClient;
import com.google.android.gms.internal.serialization.InteractionOptions;
import com.google.android.gms.internal.serialization.ObjectCommand;
import com.google.android.gms.internal.serialization.ObjectCommandResult;
import com.google.android.gms.internal.serialization.ReceiveHandle;
import com.google.android.gms.internal.serialization.SerializationMetadata;
import com.google.android.gms.internal.serialization.TraitElementPayload;
import com.google.android.gms.internal.serialization.TraitSubscriber;
import com.google.android.gms.internal.serialization.zzaaq;
import com.google.android.gms.internal.serialization.zzacj;
import com.google.android.gms.internal.serialization.zzack;
import com.google.android.gms.internal.serialization.zzacv;
import com.google.android.gms.internal.serialization.zzacz;
import com.google.android.gms.internal.serialization.zzadb;
import com.google.android.gms.internal.serialization.zzadm;
import com.google.android.gms.internal.serialization.zzadn;
import com.google.android.gms.internal.serialization.zzado;
import com.google.android.gms.internal.serialization.zzadp;
import com.google.android.gms.internal.serialization.zzadr;
import com.google.android.gms.internal.serialization.zzads;
import com.google.android.gms.internal.serialization.zzadt;
import com.google.android.gms.internal.serialization.zzadv;
import com.google.android.gms.internal.serialization.zzadx;
import com.google.android.gms.internal.serialization.zzadz;
import com.google.android.gms.internal.serialization.zzaea;
import com.google.android.gms.internal.serialization.zzaeb;
import com.google.android.gms.internal.serialization.zzaed;
import com.google.android.gms.internal.serialization.zzaee;
import com.google.android.gms.internal.serialization.zzaef;
import com.google.android.gms.internal.serialization.zzaeg;
import com.google.android.gms.internal.serialization.zzaeh;
import com.google.android.gms.internal.serialization.zzaej;
import com.google.android.gms.internal.serialization.zzaek;
import com.google.android.gms.internal.serialization.zzael;
import com.google.android.gms.internal.serialization.zzaen;
import com.google.android.gms.internal.serialization.zzaep;
import com.google.android.gms.internal.serialization.zzafr;
import com.google.android.gms.internal.serialization.zzafs;
import com.google.android.gms.internal.serialization.zzg;
import com.google.android.gms.internal.serialization.zztr;
import com.google.android.gms.internal.serialization.zzvj;
import com.google.android.gms.internal.serialization.zzvk;
import com.google.android.gms.internal.serialization.zzvm;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.home.HomeConfig;
import com.google.home.HomeError;
import com.google.home.HomeException;
import j$.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.tasks.TasksKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: renamed from: com.google.android.gms.home.internal.zzat, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004°\u0001±\u0001B_\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0017\u0010\u0016JJ\u0010\"\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0\u001eH\u0082@¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020$H\u0082@¢\u0006\u0004\b'\u0010(J,\u0010'\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\u0006\u0010*\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001bH\u0096@¢\u0006\u0004\b'\u0010.J\u001a\u00101\u001a\u0004\u0018\u0001002\u0006\u0010%\u001a\u00020/H\u0082@¢\u0006\u0004\b1\u00102J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020+0\u001b2\u0006\u0010%\u001a\u00020)H\u0096@¢\u0006\u0004\b1\u00103J\u001a\u00106\u001a\u0004\u0018\u0001052\u0006\u0010%\u001a\u000204H\u0082@¢\u0006\u0004\b6\u00107J\u001e\u00106\u001a\u00020\u00112\f\u00108\u001a\b\u0012\u0004\u0012\u00020-0\u001bH\u0096@¢\u0006\u0004\b6\u00109J¾\u0001\u0010O\u001a\u00020E\"\b\b\u0000\u0010;*\u00020:\"\b\b\u0001\u0010=*\u00020<2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010>\u001a\u00028\u00002\u0006\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00028\u00012\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010B0A2\u001e\u0010G\u001a\u001a\u0012\u0004\u0012\u00020E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010B\u0012\u0004\u0012\u00020F0D2\u001e\u0010J\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00110H2\u001e\u0010L\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00110HH\u0082@¢\u0006\u0004\bM\u0010NJ \u0010T\u001a\u00020E2\u0006\u0010@\u001a\u00020P2\u0006\u0010>\u001a\u00020QH\u0082@¢\u0006\u0004\bR\u0010SJ.\u0010T\u001a\u00020E2\u0006\u0010@\u001a\u00020P2\u0006\u0010*\u001a\u00020)2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020+0\u001bH\u0096@¢\u0006\u0004\bV\u0010WJ \u0010\\\u001a\u00020E2\u0006\u0010@\u001a\u00020X2\u0006\u0010>\u001a\u00020YH\u0082@¢\u0006\u0004\bZ\u0010[J.\u0010\\\u001a\u00020E2\u0006\u0010@\u001a\u00020X2\u0006\u0010*\u001a\u00020)2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020+0\u001bH\u0096@¢\u0006\u0004\b^\u0010_J\u0018\u0010c\u001a\u00020\u00102\u0006\u0010`\u001a\u00020EH\u0096@¢\u0006\u0004\ba\u0010bJ\u0018\u0010e\u001a\u00020\u00102\u0006\u0010`\u001a\u00020EH\u0082@¢\u0006\u0004\bd\u0010bJ\u0018\u0010g\u001a\u00020\u00102\u0006\u0010`\u001a\u00020EH\u0096@¢\u0006\u0004\bf\u0010bJ\u0018\u0010i\u001a\u00020\u00102\u0006\u0010`\u001a\u00020EH\u0082@¢\u0006\u0004\bh\u0010bJ\u001a\u0010l\u001a\u0004\u0018\u00010k2\u0006\u0010%\u001a\u00020jH\u0082@¢\u0006\u0004\bl\u0010mJ\u001a\u0010n\u001a\u0004\u0018\u00010k2\u0006\u0010%\u001a\u00020jH\u0082@¢\u0006\u0004\bn\u0010mJ$\u0010r\u001a\b\u0012\u0004\u0012\u00020q0\u001b2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020o0\u001bH\u0097@¢\u0006\u0004\br\u00109J*\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0s0\u001b2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020o0\u001bH\u0097@¢\u0006\u0004\bt\u00109JJ\u0010w\u001a\b\u0012\u0004\u0012\u00020q0\u001b2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020o0\u001b2$\u0010v\u001a \b\u0001\u0012\u0004\u0012\u00020j\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010k0u\u0012\u0006\u0012\u0004\u0018\u00010<0DH\u0082@¢\u0006\u0004\bw\u0010xJ\"\u0010|\u001a\u00020{2\u0006\u0010y\u001a\u00020\u000b2\b\u0010z\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0004\b|\u0010}J\"\u0010\u0080\u0001\u001a\u00020j2\u0006\u0010~\u001a\u00020+2\u0006\u0010\u007f\u001a\u00020+H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J$\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001d\u0010\u0087\u0001\u001a\r \u0086\u0001*\u0005\u0018\u00010\u0085\u00010\u0085\u0001H\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0012\u0010\u0089\u0001\u001a\u00020+H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001d\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\n\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\u000f\n\u0005\b\f\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\u000f\n\u0005\b\u000e\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006¢\u0006\u000f\n\u0005\b\u0012\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u0097\u0001\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R.\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u009c\u00018\u0000X\u0081\u0004¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u0012\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¤\u0001\u001a\u00030£\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R)\u0010¦\u0001\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0B0A8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R)\u0010¨\u0001\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0B0A8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010§\u0001R\u0018\u0010ª\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001a\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0098\u0001¨\u0006²\u0001"}, d2 = {"Lcom/google/android/gms/home/internal/InternalInteractionClient;", "Lcom/google/android/gms/common/api/GoogleApi;", "Lcom/google/android/gms/home/interaction/InteractionOptions;", "Lcom/google/android/gms/home/interaction/GmsInteractionClient;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/google/android/gms/common/api/Api;", "api", "Lcom/google/home/HomeConfig;", "homeConfig", "Lcom/google/android/gms/home/internal/AuthorizationClient;", "authorizationClient", "Landroid/accounts/Account;", "account", "Lkotlin/Function1;", "", "", "updatePermissionsState", "<init>", "(Landroid/content/Context;Lcom/google/android/gms/home/interaction/InteractionOptions;Lcom/google/android/gms/common/api/Api;Lcom/google/home/HomeConfig;Lcom/google/android/gms/home/internal/AuthorizationClient;Landroid/accounts/Account;Lkotlin/jvm/functions/Function1;)V", "shutdown", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "throwHomeExceptionIfShutdown", "Response", "", SDKConstants.PARAM_KEY, "", "Lcom/google/android/gms/common/Feature;", "additionalFeatures", "Lcom/google/android/gms/common/api/internal/RemoteCall;", "Lcom/google/android/gms/home/internal/InteractionClientImpl;", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "serviceCall", "callInteractionMethod", "(ILjava/util/List;Lcom/google/android/gms/common/api/internal/RemoteCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/protos/home/internal/interaction_api/ReadObjectsRequest;", "request", "Lcom/google/protos/home/internal/interaction_api/ReadObjectsResponse;", "readObjects", "(Lcom/google/protos/home/internal/interaction_api/ReadObjectsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "objectFilter", "", "reduceObjectFilter", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "(Lcom/google/nest/platform/mesh/interaction/FilterQuery;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/protos/home/internal/interaction_api/QueryObjectIdsRequest;", "Lcom/google/protos/home/internal/interaction_api/QueryObjectIdsResponse;", "queryObjectIds", "(Lcom/google/protos/home/internal/interaction_api/QueryObjectIdsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/nest/platform/mesh/interaction/FilterQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/protos/home/internal/interaction_api/WriteObjectsRequest;", "Lcom/google/protos/home/internal/interaction_api/WriteObjectsResponse;", "writeObjects", "(Lcom/google/protos/home/internal/interaction_api/WriteObjectsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "objects", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/protobuf/MessageLite;", "Request", "", "Subscriber", "registerRequest", "subscriberType", "subscriber", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/google/android/gms/common/api/internal/ListenerHolder;", "subscriberMap", "Lkotlin/Function2;", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "Landroid/os/IInterface;", "subscriberCallbackFactory", "Lkotlin/Function3;", "Lcom/google/android/gms/home/interaction/internal/IRegisterSubscriberCallback$Stub;", "registerCall", "Lcom/google/android/gms/common/api/internal/IStatusCallback$Stub;", "unregisterCall", "registerSubscriber-1fiRZeI", "(ILcom/google/protobuf/MessageLite;Ljava/lang/String;Ljava/lang/Object;Ljava/util/concurrent/ConcurrentHashMap;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSubscriber", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;", "Lcom/google/protos/home/internal/interaction_api/RegisterTraitSubscriberRequest;", "registerTraitSubscriber-t1JN82g", "(Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;Lcom/google/protos/home/internal/interaction_api/RegisterTraitSubscriberRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerTraitSubscriber", "traitFilter", "registerTraitSubscriber-OCNOtTU", "(Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;Lcom/google/nest/platform/mesh/interaction/FilterQuery;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/nest/platform/mesh/interaction/EventSubscriber;", "Lcom/google/protos/home/internal/interaction_api/RegisterEventSubscriberRequest;", "registerEventSubscriber-t1JN82g", "(Lcom/google/nest/platform/mesh/interaction/EventSubscriber;Lcom/google/protos/home/internal/interaction_api/RegisterEventSubscriberRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerEventSubscriber", "eventFilter", "registerEventSubscriber-OCNOtTU", "(Lcom/google/nest/platform/mesh/interaction/EventSubscriber;Lcom/google/nest/platform/mesh/interaction/FilterQuery;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "unregisterTraitSubscriber-n_T_TKg", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterTraitSubscriber", "privateUnregisterTraitSubscriber-n_T_TKg", "privateUnregisterTraitSubscriber", "unregisterEventSubscriber-n_T_TKg", "unregisterEventSubscriber", "privateUnregisterEventSubscriber-n_T_TKg", "privateUnregisterEventSubscriber", "Lcom/google/protos/home/internal/interaction_api/SendCommandsRequest;", "Lcom/google/protos/home/internal/interaction_api/SendCommandsResponse;", "sendCommandsSmall", "(Lcom/google/protos/home/internal/interaction_api/SendCommandsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCommandsLarge", "Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "commands", "Lcom/google/nest/platform/mesh/interaction/ObjectCommandResult;", "sendCommands", "Lkotlin/Result;", "sendCommandsWithResults", "Lkotlin/coroutines/Continuation;", "apiCall", "makeSendCommandsApiCall", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nonNullAuthClient", "previousToken", "Lcom/google/android/gms/home/internal/InternalInteractionClient$TokenRefreshStatus;", "refreshOAuthToken", "(Lcom/google/android/gms/home/internal/AuthorizationClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "objectId", "refreshedOAuthToken", "refreshOAuthTokenRequest", "(Ljava/lang/String;Ljava/lang/String;)Lcom/google/protos/home/internal/interaction_api/SendCommandsRequest;", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "authorizeAccount", "(Lcom/google/android/gms/home/internal/AuthorizationClient;Landroid/accounts/Account;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/home/interaction/ServiceRequestContext;", "kotlin.jvm.PlatformType", "generateServiceRequestContext", "()Lcom/google/android/gms/home/interaction/ServiceRequestContext;", "getNewHandle", "()Ljava/lang/String;", "Lcom/google/home/HomeConfig;", "getHomeConfig", "()Lcom/google/home/HomeConfig;", "Lcom/google/android/gms/home/internal/AuthorizationClient;", "getAuthorizationClient", "()Lcom/google/android/gms/home/internal/AuthorizationClient;", "Landroid/accounts/Account;", "getAccount", "()Landroid/accounts/Account;", "Lkotlin/jvm/functions/Function1;", "getUpdatePermissionsState", "()Lkotlin/jvm/functions/Function1;", "instanceTag", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "registrationsInProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getRegistrationsInProgress$java_com_google_android_gmscore_integ_client_home_home", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getRegistrationsInProgress$java_com_google_android_gmscore_integ_client_home_home$annotations", "()V", "Landroid/app/KeyguardManager;", "keyguardManager", "Landroid/app/KeyguardManager;", "eventSubscriberListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "traitSubscriberListenerMap", "Lkotlinx/coroutines/sync/Mutex;", "currentOAuthTokenLock", "Lkotlinx/coroutines/sync/Mutex;", "Ljava/util/concurrent/atomic/AtomicLong;", "nextHandleId", "Ljava/util/concurrent/atomic/AtomicLong;", "currentOAuthToken", "TokenRefreshStatus", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalInteractionClient extends GoogleApi implements InteractionClient {
    private final HomeConfig zzb;
    private final AuthorizationClient zzc;
    private final Account zzd;
    private final Function1 zze;
    private final String zzf;
    private final AtomicBoolean zzg;
    private final MutableStateFlow zzh;
    private final KeyguardManager zzi;
    private final ConcurrentHashMap zzj;
    private final ConcurrentHashMap zzk;
    private final Mutex zzl;
    private AtomicLong zzm;
    private String zzn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalInteractionClient(Context context, InteractionOptions interactionOptions, Api api, HomeConfig homeConfig, AuthorizationClient authorizationClient, Account account, Function1 function1) {
        super(context, (Api<InteractionOptions>) api, interactionOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        context.getClass();
        interactionOptions.getClass();
        api.getClass();
        homeConfig.getClass();
        function1.getClass();
        this.zzb = homeConfig;
        this.zzc = authorizationClient;
        this.zzd = account;
        this.zze = function1;
        if (interactionOptions.getZzc() != null && account == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("If 'options.oauthToken' is provided, an 'account' must also be associated with it.");
            throw null;
        }
        if (interactionOptions.getZzc() != null && authorizationClient == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("If 'options.oauthToken' is provided, an 'authorizationClient' must also be provided.");
            throw null;
        }
        this.zzf = "HomeInteractionClient@".concat(String.valueOf(StringsKt__StringsKt.substringAfter$default(toString(), "@", (String) null, 2, (Object) null)));
        this.zzg = new AtomicBoolean(false);
        this.zzh = StateFlowKt.MutableStateFlow(0);
        Object systemService = context.getSystemService("keyguard");
        systemService.getClass();
        this.zzi = (KeyguardManager) systemService;
        this.zzj = new ConcurrentHashMap();
        this.zzk = new ConcurrentHashMap();
        this.zzl = MutexKt.Mutex$default(false, 1, null);
        this.zzm = new AtomicLong();
        this.zzn = interactionOptions.getZzc();
    }

    private final Object zzC(Continuation continuation) throws HomeException {
        if (this.zzg.get()) {
            throw HomeException.INSTANCE.failedPrecondition("This InteractionClient has been shutdown and cannot be used.");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzD(int i, List list, RemoteCall remoteCall, Continuation continuation) {
        zzm zzmVar;
        if (continuation instanceof zzm) {
            zzmVar = (zzm) continuation;
            int i2 = zzmVar.zzf;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zzmVar.zzf = i2 - Integer.MIN_VALUE;
            } else {
                zzmVar = new zzm(this, continuation);
            }
        }
        Object obj = zzmVar.zzd;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = zzmVar.zzf;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            zzmVar.zzg = this;
            zzmVar.zza = list;
            zzmVar.zzb = remoteCall;
            zzmVar.zzc = i;
            zzmVar.zzf = 1;
            if (zzC(zzmVar) != coroutine_suspended) {
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = zzmVar.zzc;
        remoteCall = (RemoteCall) zzmVar.zzb;
        list = (List) zzmVar.zza;
        this = zzmVar.zzg;
        ResultKt.throwOnFailure(obj);
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Feature feature = zzg.zzn;
        feature.getClass();
        listCreateListBuilder.add(feature);
        listCreateListBuilder.addAll(list);
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        TaskApiCall.Builder builder = TaskApiCall.builder();
        Feature[] featureArr = (Feature[]) listBuild.toArray(new Feature[0]);
        Task taskDoRead = this.doRead(builder.setFeatures((Feature[]) Arrays.copyOf(featureArr, featureArr.length)).setAutoResolveMissingFeatures(false).setMethodKey(i).run(remoteCall).build());
        taskDoRead.getClass();
        zzmVar.zzg = null;
        zzmVar.zza = null;
        zzmVar.zzb = null;
        zzmVar.zzf = 2;
        Object objZza = zzd.zza(taskDoRead, zzmVar);
        return objZza == coroutine_suspended ? coroutine_suspended : objZza;
    }

    private final Object zzE(final zzadz zzadzVar, Continuation continuation) {
        return zzc(this, 31714, null, new RemoteCall() { // from class: com.google.android.gms.home.internal.zzau
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                InternalInteractionClient.zzw(zzadzVar, this, (InteractionClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzG(int i, zzaaq zzaaqVar, String str, Object obj, ConcurrentHashMap concurrentHashMap, Function2 function2, Function3 function3, Function3 function32, Continuation continuation) throws Throwable {
        zzaa zzaaVar;
        zzaaq zzaaqVar2;
        Object obj2;
        final ConcurrentHashMap concurrentHashMap2;
        Function2 function22;
        final Function3 function33;
        int i2;
        String str2;
        final Function3 function34;
        InternalInteractionClient internalInteractionClient;
        Object value;
        InternalInteractionClient internalInteractionClient2;
        String str3;
        MutableStateFlow mutableStateFlow;
        String message;
        MutableStateFlow mutableStateFlow2;
        if (continuation instanceof zzaa) {
            zzaaVar = (zzaa) continuation;
            int i3 = zzaaVar.zzj;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                zzaaVar.zzj = i3 - Integer.MIN_VALUE;
            } else {
                zzaaVar = new zzaa(this, continuation);
            }
        }
        Object obj3 = zzaaVar.zzh;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = zzaaVar.zzj;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            zzaaVar.zzk = this;
            zzaaqVar2 = zzaaqVar;
            zzaaVar.zza = zzaaqVar2;
            zzaaVar.zzl = str;
            obj2 = obj;
            zzaaVar.zzb = obj2;
            concurrentHashMap2 = concurrentHashMap;
            zzaaVar.zzc = concurrentHashMap2;
            function22 = function2;
            zzaaVar.zzd = function22;
            function33 = function3;
            zzaaVar.zze = function33;
            zzaaVar.zzf = function32;
            i2 = i;
            zzaaVar.zzg = i2;
            zzaaVar.zzj = 1;
            if (zzC(zzaaVar) != coroutine_suspended) {
                str2 = str;
                function34 = function32;
                internalInteractionClient = this;
            }
            return coroutine_suspended;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str3 = (String) zzaaVar.zza;
            internalInteractionClient2 = zzaaVar.zzk;
            try {
                try {
                    ResultKt.throwOnFailure(obj3);
                    mutableStateFlow2 = internalInteractionClient2.zzh;
                    do {
                    } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), Boxing.boxInt(((Number) r2).intValue() - 1)));
                    return str3;
                } catch (ApiException e) {
                    e = e;
                    message = e.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    throw new HomeException(13, message, e, null, 8, null);
                }
            } catch (Throwable th) {
                th = th;
                mutableStateFlow = internalInteractionClient2.zzh;
                do {
                } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), Boxing.boxInt(((Number) r2).intValue() - 1)));
                throw th;
            }
        }
        int i5 = zzaaVar.zzg;
        function34 = (Function3) zzaaVar.zzf;
        Function3 function35 = (Function3) zzaaVar.zze;
        Function2 function23 = (Function2) zzaaVar.zzd;
        ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) zzaaVar.zzc;
        Object obj4 = zzaaVar.zzb;
        str2 = zzaaVar.zzl;
        zzaaq zzaaqVar3 = (zzaaq) zzaaVar.zza;
        internalInteractionClient = zzaaVar.zzk;
        ResultKt.throwOnFailure(obj3);
        function33 = function35;
        obj2 = obj4;
        function22 = function23;
        concurrentHashMap2 = concurrentHashMap3;
        zzaaqVar2 = zzaaqVar3;
        i2 = i5;
        MutableStateFlow mutableStateFlow3 = internalInteractionClient.zzh;
        do {
            value = mutableStateFlow3.getValue();
        } while (!mutableStateFlow3.compareAndSet(value, Boxing.boxInt(((Number) value).intValue() + 1)));
        Object objZzb = zzacj.zza().zzb(zzaaqVar2.toByteString());
        new StringBuilder(String.valueOf(str2).length() + String.valueOf(objZzb).length());
        Objects.toString(objZzb);
        ListenerHolder listenerHolderRegisterListener = internalInteractionClient.registerListener(obj2, String.valueOf(str2).concat(String.valueOf(objZzb)));
        long andIncrement = internalInteractionClient.zzm.getAndIncrement();
        final String strM = zzba$$ExternalSyntheticOutline0.m(andIncrement, "handle", new StringBuilder(String.valueOf(andIncrement).length() + 6));
        if (((ListenerHolder) concurrentHashMap2.putIfAbsent(strM, listenerHolderRegisterListener)) != null) {
            MutableStateFlow mutableStateFlow4 = internalInteractionClient.zzh;
            do {
            } while (!mutableStateFlow4.compareAndSet(mutableStateFlow4.getValue(), Boxing.boxInt(((Number) r2).intValue() - 1)));
            throw HomeException.INSTANCE.internal(String.format("subscription already active for listenerHolder: %s", Arrays.copyOf(new Object[]{listenerHolderRegisterListener}, 1)));
        }
        ReceiveHandle receiveHandleZzb = ReceiveHandle.zzb(strM);
        listenerHolderRegisterListener.getClass();
        final IInterface iInterface = (IInterface) function22.invoke(receiveHandleZzb, listenerHolderRegisterListener);
        try {
            Task<Void> taskDoRegisterEventListener = internalInteractionClient.doRegisterEventListener(RegistrationMethods.builder().setFeatures(zzg.zzn).withHolder(listenerHolderRegisterListener).register(new RemoteCall() { // from class: com.google.android.gms.home.internal.zzaw
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj5, Object obj6) {
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj6;
                    InteractionClientImpl interactionClientImpl = (InteractionClientImpl) obj5;
                    interactionClientImpl.getClass();
                    taskCompletionSource.getClass();
                    zzab zzabVar = new zzab(concurrentHashMap2, strM, taskCompletionSource);
                    function33.invoke(interactionClientImpl, iInterface, zzabVar);
                }
            }).unregister(new RemoteCall() { // from class: com.google.android.gms.home.internal.zzax
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj5, Object obj6) {
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj6;
                    InteractionClientImpl interactionClientImpl = (InteractionClientImpl) obj5;
                    interactionClientImpl.getClass();
                    taskCompletionSource.getClass();
                    zzac zzacVar = new zzac(taskCompletionSource);
                    function34.invoke(interactionClientImpl, iInterface, zzacVar);
                    concurrentHashMap2.remove(strM);
                }
            }).setMethodKey(i2).build());
            try {
                zzaaVar.zzk = internalInteractionClient;
                zzaaVar.zza = strM;
                zzaaVar.zzl = null;
                zzaaVar.zzb = null;
                zzaaVar.zzc = null;
                zzaaVar.zzd = null;
                zzaaVar.zze = null;
                zzaaVar.zzf = null;
                zzaaVar.zzj = 2;
                if (TasksKt.await(taskDoRegisterEventListener, zzaaVar) != coroutine_suspended) {
                    str3 = strM;
                    internalInteractionClient2 = internalInteractionClient;
                    mutableStateFlow2 = internalInteractionClient2.zzh;
                    do {
                    } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), Boxing.boxInt(((Number) r2).intValue() - 1)));
                    return str3;
                }
                return coroutine_suspended;
            } catch (ApiException e2) {
                e = e2;
                internalInteractionClient2 = internalInteractionClient;
                message = e.getMessage();
                if (message == null) {
                }
                throw new HomeException(13, message, e, null, 8, null);
            } catch (Throwable th2) {
                th = th2;
                internalInteractionClient2 = internalInteractionClient;
                mutableStateFlow = internalInteractionClient2.zzh;
                do {
                } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), Boxing.boxInt(((Number) r2).intValue() - 1)));
                throw th;
            }
        } catch (ApiException e3) {
            MutableStateFlow mutableStateFlow5 = internalInteractionClient.zzh;
            do {
            } while (!mutableStateFlow5.compareAndSet(mutableStateFlow5.getValue(), Boxing.boxInt(((Number) r1).intValue() - 1)));
            String message2 = e3.getMessage();
            if (message2 == null) {
                message2 = "doRegisterEventListener failed";
            }
            throw new HomeException(17, message2, e3, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzH(TraitSubscriber traitSubscriber, zzaeh zzaehVar, Continuation continuation) throws Throwable {
        zzad zzadVar;
        Object objZzG;
        if (continuation instanceof zzad) {
            zzadVar = (zzad) continuation;
            int i = zzadVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzadVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzadVar = new zzad(this, continuation);
            }
        }
        zzad zzadVar2 = zzadVar;
        Object obj = zzadVar2.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzadVar2.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ConcurrentHashMap concurrentHashMap = this.zzk;
            Function2 function2 = zzag.zza;
            Function3 zzahVar = new zzah(zzaehVar, this);
            Function3 zzaiVar = new zzai(zzaehVar, this);
            zzadVar2.zzc = 1;
            objZzG = zzG(31717, zzaehVar, "traitSubscriber", traitSubscriber, concurrentHashMap, function2, zzahVar, zzaiVar, zzadVar2);
            if (objZzG == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objZzG = ((ReceiveHandle) obj).getZza();
        }
        return (String) objZzG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzI(String str, Continuation continuation) {
        zzp zzpVar;
        ListenerHolder.ListenerKey<?> listenerKey;
        if (continuation instanceof zzp) {
            zzpVar = (zzp) continuation;
            int i = zzpVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzpVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzpVar = new zzp(this, continuation);
            }
        }
        Object objZza = zzpVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzpVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZza);
            ListenerHolder listenerHolder = (ListenerHolder) this.zzk.get(str);
            if (listenerHolder == null || (listenerKey = listenerHolder.getListenerKey()) == null) {
                return Boxing.boxBoolean(false);
            }
            Task<Boolean> taskDoUnregisterEventListener = doUnregisterEventListener(listenerKey, 31719);
            taskDoUnregisterEventListener.getClass();
            zzpVar.zzc = 1;
            objZza = zzd.zza(taskDoUnregisterEventListener, zzpVar);
            if (objZza == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objZza);
        }
        Boolean bool = (Boolean) objZza;
        return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzJ(String str, Continuation continuation) {
        zzo zzoVar;
        ListenerHolder.ListenerKey<?> listenerKey;
        if (continuation instanceof zzo) {
            zzoVar = (zzo) continuation;
            int i = zzoVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzoVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzoVar = new zzo(this, continuation);
            }
        }
        Object objZza = zzoVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzoVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZza);
            ListenerHolder listenerHolder = (ListenerHolder) this.zzj.get(str);
            if (listenerHolder == null || (listenerKey = listenerHolder.getListenerKey()) == null) {
                return Boxing.boxBoolean(false);
            }
            Task<Boolean> taskDoUnregisterEventListener = doUnregisterEventListener(listenerKey, 31720);
            taskDoUnregisterEventListener.getClass();
            zzoVar.zzc = 1;
            objZza = zzd.zza(taskDoUnregisterEventListener, zzoVar);
            if (objZza == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objZza);
        }
        Boolean bool = (Boolean) objZza;
        return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzK(final zzaej zzaejVar, Continuation continuation) {
        return zzc(this, 31721, null, new RemoteCall() { // from class: com.google.android.gms.home.internal.zzay
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                InternalInteractionClient.zzy(zzaejVar, this, (InteractionClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzL(final zzaej zzaejVar, Continuation continuation) {
        return zzD(31738, CollectionsKt.listOf(zzg.zzq), new RemoteCall() { // from class: com.google.android.gms.home.internal.zzaz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                InternalInteractionClient.zzz(zzaejVar, this, (InteractionClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c4, code lost:
    
        if (r15 != r1) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0281  */
    /* JADX WARN: Type inference failed for: r12v11, types: [com.google.home.HomeException$Companion] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzM(List list, Function2 function2, Continuation continuation) throws HomeException {
        zzn zznVar;
        Mutex mutex;
        zzaej zzaejVar;
        String str;
        InternalInteractionClient internalInteractionClient;
        zzaen zzaenVar;
        ?? linkedHashMap;
        zzaen zzaenVar2;
        ?? r12;
        if (continuation instanceof zzn) {
            zznVar = (zzn) continuation;
            int i = zznVar.zzf;
            if ((i & Integer.MIN_VALUE) != 0) {
                zznVar.zzf = i - Integer.MIN_VALUE;
            } else {
                zznVar = new zzn(this, continuation);
            }
        }
        Object objInvoke = zznVar.zzd;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zznVar.zzf;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                mutex = this.zzl;
                zznVar.zzg = this;
                zznVar.zza = list;
                zznVar.zzb = function2;
                zznVar.zzc = mutex;
                zznVar.zzf = 1;
                if (mutex.lock(null, zznVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                Mutex mutex2 = (Mutex) zznVar.zzc;
                function2 = (Function2) zznVar.zzb;
                list = (List) zznVar.zza;
                InternalInteractionClient internalInteractionClient2 = zznVar.zzg;
                ResultKt.throwOnFailure(objInvoke);
                mutex = mutex2;
                this = internalInteractionClient2;
            } else if (i2 == 2) {
                zzaej zzaejVar2 = (zzaej) zznVar.zzb;
                str = (String) zznVar.zza;
                InternalInteractionClient internalInteractionClient3 = zznVar.zzg;
                ResultKt.throwOnFailure(objInvoke);
                internalInteractionClient = internalInteractionClient3;
                zzaejVar = zzaejVar2;
                zzaenVar = (zzaen) objInvoke;
                if (zzaenVar != null) {
                    return CollectionsKt.emptyList();
                }
                List listZza = zzaenVar.zza();
                listZza.getClass();
                ArrayList<zzacz> arrayList = new ArrayList();
                for (Object obj : listZza) {
                    if (((zzacz) obj).zzb()) {
                        arrayList.add(obj);
                    }
                }
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
                for (zzacz zzaczVar : arrayList) {
                    String strZza = zzaczVar.zza();
                    zzadb zzadbVarZzc = zzaczVar.zzc();
                    zzadbVarZzc.getClass();
                    Pair pair = TuplesKt.to(strZza, zzd.zzd(zzadbVarZzc));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                String zzc = ((InteractionOptions) internalInteractionClient.getApiOptions()).getZzc();
                if (zzc != null && !StringsKt.isBlank(zzc) && internalInteractionClient.zzc != null) {
                    Collection collectionValues = linkedHashMap.values();
                    if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                        Iterator it = collectionValues.iterator();
                        while (it.hasNext()) {
                            if (((HomeError) it.next()).getCode() == 16) {
                                Log.i(internalInteractionClient.zzf, "Command failed due to authentication error.");
                                AuthorizationClient authorizationClient = internalInteractionClient.zzc;
                                zznVar.zzg = internalInteractionClient;
                                zznVar.zza = zzaejVar;
                                zznVar.zzb = zzaenVar;
                                zznVar.zzc = linkedHashMap;
                                zznVar.zzf = 3;
                                objInvoke = internalInteractionClient.zzN(authorizationClient, str, zznVar);
                                if (objInvoke != coroutine_suspended) {
                                    zzaenVar2 = zzaenVar;
                                    r12 = linkedHashMap;
                                    if (objInvoke != zzl.zzb) {
                                    }
                                }
                                return coroutine_suspended;
                            }
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                }
            } else {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objInvoke);
                    zzaenVar = (zzaen) objInvoke;
                    if (zzaenVar == null) {
                        return CollectionsKt.emptyList();
                    }
                    List listZza2 = zzaenVar.zza();
                    listZza2.getClass();
                    ArrayList<zzacz> arrayList2 = new ArrayList();
                    for (Object obj2 : listZza2) {
                        if (((zzacz) obj2).zzb()) {
                            arrayList2.add(obj2);
                        }
                    }
                    linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                    for (zzacz zzaczVar2 : arrayList2) {
                        String strZza2 = zzaczVar2.zza();
                        zzadb zzadbVarZzc2 = zzaczVar2.zzc();
                        zzadbVarZzc2.getClass();
                        Pair pair2 = TuplesKt.to(strZza2, zzd.zzd(zzadbVarZzc2));
                        linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
                    }
                    if (!linkedHashMap.isEmpty()) {
                        throw HomeException.INSTANCE.bulkError(linkedHashMap);
                    }
                    List listZza3 = zzaenVar.zza();
                    listZza3.getClass();
                    List<zzacz> list2 = listZza3;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (zzacz zzaczVar3 : list2) {
                        String strZza3 = zzaczVar3.zza();
                        strZza3.getClass();
                        zzvm zzvmVar = TraitElementPayload.zza;
                        zzaep zzaepVarZzd = zzaczVar3.zzd();
                        zzaepVarZzd.getClass();
                        arrayList3.add(new ObjectCommandResult(strZza3, zzvj.zzb(zzvmVar, zzaepVarZzd)));
                    }
                    return arrayList3;
                }
                Map map = (Map) zznVar.zzc;
                zzaenVar2 = (zzaen) zznVar.zzb;
                zzaejVar = (zzaej) zznVar.zza;
                internalInteractionClient = zznVar.zzg;
                ResultKt.throwOnFailure(objInvoke);
                r12 = map;
                if (objInvoke != zzl.zzb) {
                    Log.i(internalInteractionClient.zzf, "Retrying the command after refreshing OAuthToken.");
                    zznVar.zzg = null;
                    zznVar.zza = null;
                    zznVar.zzb = null;
                    zznVar.zzc = null;
                    zznVar.zzf = 4;
                    objInvoke = internalInteractionClient.zzK(zzaejVar, zznVar);
                } else {
                    linkedHashMap = r12;
                    zzaenVar = zzaenVar2;
                    if (!linkedHashMap.isEmpty()) {
                    }
                }
            }
            String str2 = this.zzn;
            mutex.unlock(null);
            zzael zzaelVarZza = zzaek.zza(zzaej.zzb());
            zzack zzackVarZzb = zzaelVarZza.zzb();
            List list3 = list;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(zzd.zze((ObjectCommand) it2.next()));
            }
            zzaelVarZza.zzd(zzackVarZzb, arrayList4);
            zzaej zzaejVarZza = zzaelVarZza.zza();
            zznVar.zzg = this;
            zznVar.zza = str2;
            zznVar.zzb = zzaejVarZza;
            zznVar.zzc = null;
            zznVar.zzf = 2;
            objInvoke = function2.invoke(zzaejVarZza, zznVar);
            if (objInvoke != coroutine_suspended) {
                zzaejVar = zzaejVarZza;
                str = str2;
                internalInteractionClient = this;
                zzaenVar = (zzaen) objInvoke;
                if (zzaenVar != null) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0150, code lost:
    
        if (r1 != r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0214, code lost:
    
        if (r1 == r3) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012c A[Catch: HomeException -> 0x026a, TryCatch #1 {HomeException -> 0x026a, blocks: (B:78:0x0216, B:80:0x021a, B:82:0x0229, B:84:0x0233, B:68:0x0186, B:71:0x01b0, B:76:0x01da, B:73:0x01bf, B:74:0x01c4, B:75:0x01c5, B:87:0x023e, B:88:0x0241, B:56:0x0152, B:57:0x0154, B:59:0x015a, B:62:0x0162, B:64:0x016f, B:90:0x0243, B:92:0x024d, B:29:0x0079, B:50:0x0128, B:52:0x012c, B:54:0x0136, B:32:0x0086, B:39:0x00de, B:41:0x00e2, B:43:0x00ec, B:46:0x00f2, B:94:0x0260, B:67:0x0182), top: B:100:0x002b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a A[Catch: HomeException -> 0x026a, TryCatch #1 {HomeException -> 0x026a, blocks: (B:78:0x0216, B:80:0x021a, B:82:0x0229, B:84:0x0233, B:68:0x0186, B:71:0x01b0, B:76:0x01da, B:73:0x01bf, B:74:0x01c4, B:75:0x01c5, B:87:0x023e, B:88:0x0241, B:56:0x0152, B:57:0x0154, B:59:0x015a, B:62:0x0162, B:64:0x016f, B:90:0x0243, B:92:0x024d, B:29:0x0079, B:50:0x0128, B:52:0x012c, B:54:0x0136, B:32:0x0086, B:39:0x00de, B:41:0x00e2, B:43:0x00ec, B:46:0x00f2, B:94:0x0260, B:67:0x0182), top: B:100:0x002b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016f A[Catch: HomeException -> 0x026a, TRY_LEAVE, TryCatch #1 {HomeException -> 0x026a, blocks: (B:78:0x0216, B:80:0x021a, B:82:0x0229, B:84:0x0233, B:68:0x0186, B:71:0x01b0, B:76:0x01da, B:73:0x01bf, B:74:0x01c4, B:75:0x01c5, B:87:0x023e, B:88:0x0241, B:56:0x0152, B:57:0x0154, B:59:0x015a, B:62:0x0162, B:64:0x016f, B:90:0x0243, B:92:0x024d, B:29:0x0079, B:50:0x0128, B:52:0x012c, B:54:0x0136, B:32:0x0086, B:39:0x00de, B:41:0x00e2, B:43:0x00ec, B:46:0x00f2, B:94:0x0260, B:67:0x0182), top: B:100:0x002b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c5 A[Catch: HomeException -> 0x026a, TryCatch #1 {HomeException -> 0x026a, blocks: (B:78:0x0216, B:80:0x021a, B:82:0x0229, B:84:0x0233, B:68:0x0186, B:71:0x01b0, B:76:0x01da, B:73:0x01bf, B:74:0x01c4, B:75:0x01c5, B:87:0x023e, B:88:0x0241, B:56:0x0152, B:57:0x0154, B:59:0x015a, B:62:0x0162, B:64:0x016f, B:90:0x0243, B:92:0x024d, B:29:0x0079, B:50:0x0128, B:52:0x012c, B:54:0x0136, B:32:0x0086, B:39:0x00de, B:41:0x00e2, B:43:0x00ec, B:46:0x00f2, B:94:0x0260, B:67:0x0182), top: B:100:0x002b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0243 A[Catch: HomeException -> 0x026a, TryCatch #1 {HomeException -> 0x026a, blocks: (B:78:0x0216, B:80:0x021a, B:82:0x0229, B:84:0x0233, B:68:0x0186, B:71:0x01b0, B:76:0x01da, B:73:0x01bf, B:74:0x01c4, B:75:0x01c5, B:87:0x023e, B:88:0x0241, B:56:0x0152, B:57:0x0154, B:59:0x015a, B:62:0x0162, B:64:0x016f, B:90:0x0243, B:92:0x024d, B:29:0x0079, B:50:0x0128, B:52:0x012c, B:54:0x0136, B:32:0x0086, B:39:0x00de, B:41:0x00e2, B:43:0x00ec, B:46:0x00f2, B:94:0x0260, B:67:0x0182), top: B:100:0x002b, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzN(AuthorizationClient authorizationClient, String str, Continuation continuation) {
        zzs zzsVar;
        InternalInteractionClient internalInteractionClient;
        AuthorizationClient authorizationClient2;
        InternalInteractionClient internalInteractionClient2;
        String str2;
        String str3;
        String str4;
        AuthorizationClient authorizationClient3;
        InternalInteractionClient internalInteractionClient3;
        String str5;
        Mutex mutex;
        String accessToken;
        int iOrdinal;
        String strConcat;
        InternalInteractionClient internalInteractionClient4;
        AuthorizationResult authorizationResult;
        InternalInteractionClient internalInteractionClient5;
        InternalInteractionClient internalInteractionClient6;
        if (continuation instanceof zzs) {
            zzsVar = (zzs) continuation;
            int i = zzsVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzsVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzsVar = new zzs(this, continuation);
            }
        }
        Object objZzE = zzsVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzsVar.zze;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objZzE);
                    zzaeb zzaebVarZza = zzaea.zza(zzadz.zza());
                    zzadt zzadtVarZza = zzads.zza(zzadr.zzc());
                    zzack zzackVarZzd = zzadtVarZza.zzd();
                    zzadp zzadpVarZza = zzado.zza(zzadn.zza());
                    zzadpVarZza.zzb(zzadm.TRAIT_SUPPORTED);
                    zzadpVarZza.zzc("home.internal.traits.OAuthSessionTrait");
                    zzadtVarZza.zze(zzackVarZzd, zzadpVarZza.zza());
                    zzaebVarZza.zzb(zzadtVarZza.zza());
                    zzadz zzadzVarZza = zzaebVarZza.zza();
                    zzsVar.zzf = this;
                    authorizationClient2 = authorizationClient;
                    zzsVar.zza = authorizationClient2;
                    zzsVar.zzg = str;
                    zzsVar.zze = 1;
                    objZzE = zzE(zzadzVarZza, zzsVar);
                    if (objZzE != coroutine_suspended) {
                        internalInteractionClient2 = this;
                        str2 = str;
                    }
                    return coroutine_suspended;
                }
                if (i2 == 1) {
                    str2 = zzsVar.zzg;
                    authorizationClient2 = (AuthorizationClient) zzsVar.zza;
                    InternalInteractionClient internalInteractionClient7 = zzsVar.zzf;
                    ResultKt.throwOnFailure(objZzE);
                    internalInteractionClient2 = internalInteractionClient7;
                } else {
                    if (i2 == 2) {
                        str4 = (String) zzsVar.zzb;
                        str3 = zzsVar.zzg;
                        authorizationClient3 = (AuthorizationClient) zzsVar.zza;
                        InternalInteractionClient internalInteractionClient8 = zzsVar.zzf;
                        ResultKt.throwOnFailure(objZzE);
                        internalInteractionClient6 = internalInteractionClient8;
                        authorizationResult = (AuthorizationResult) objZzE;
                        internalInteractionClient4 = internalInteractionClient6;
                        if (str3 != null) {
                            internalInteractionClient4 = internalInteractionClient6;
                            if (str3.equals(authorizationResult.getAccessToken())) {
                                Log.i(internalInteractionClient6.zzf, "Refresh OAuth token unchanged, clearing cache and re-fetching");
                                authorizationClient3.zzc(str3);
                                Account account = internalInteractionClient6.zzd;
                                zzsVar.zzf = internalInteractionClient6;
                                zzsVar.zza = str3;
                                zzsVar.zzg = str4;
                                zzsVar.zzb = null;
                                zzsVar.zze = 3;
                                objZzE = internalInteractionClient6.zzO(authorizationClient3, account, zzsVar);
                                internalInteractionClient5 = internalInteractionClient6;
                            }
                            return coroutine_suspended;
                        }
                        accessToken = authorizationResult.getAccessToken();
                        if (accessToken != null) {
                            Log.i(internalInteractionClient4.zzf, "Fetched OAuth token successfully.");
                            if (!Intrinsics.areEqual(accessToken, str3)) {
                            }
                        }
                        Log.e(internalInteractionClient4.zzf, "Unable to fetch a refreshed OAuth token. This can possibly indicate revocation of OAuth consent. Permissions are no longer valid for this account.");
                        internalInteractionClient4.zze.invoke(Boxing.boxBoolean(false));
                        return zzl.zza;
                    }
                    try {
                        if (i2 == 3) {
                            str4 = zzsVar.zzg;
                            str3 = (String) zzsVar.zza;
                            InternalInteractionClient internalInteractionClient9 = zzsVar.zzf;
                            ResultKt.throwOnFailure(objZzE);
                            internalInteractionClient5 = internalInteractionClient9;
                            authorizationResult = (AuthorizationResult) objZzE;
                            internalInteractionClient4 = internalInteractionClient5;
                            accessToken = authorizationResult.getAccessToken();
                            if (accessToken != null && !StringsKt.isBlank(accessToken)) {
                                Log.i(internalInteractionClient4.zzf, "Fetched OAuth token successfully.");
                                if (!Intrinsics.areEqual(accessToken, str3)) {
                                    Log.i(internalInteractionClient4.zzf, "OAuth token is the same as the one stored in InteractionClient.");
                                    return zzl.zza;
                                }
                                mutex = internalInteractionClient4.zzl;
                                zzsVar.zzf = internalInteractionClient4;
                                zzsVar.zza = str4;
                                zzsVar.zzg = accessToken;
                                zzsVar.zzb = mutex;
                                zzsVar.zze = 4;
                                if (mutex.lock(null, zzsVar) != coroutine_suspended) {
                                    str5 = str4;
                                    internalInteractionClient = internalInteractionClient4;
                                    internalInteractionClient.zzn = accessToken;
                                    Unit unit = Unit.INSTANCE;
                                    mutex.unlock(null);
                                    Log.i(internalInteractionClient.zzf, "Attempting to send the updated OAuth token to LocalIAM.");
                                    zzafr zzafrVarZza = zzafs.zza();
                                    zzafrVarZza.zza(accessToken);
                                    zzzg zzzgVarBuild = zzafrVarZza.build();
                                    zzzgVarBuild.getClass();
                                    zzafs zzafsVar = (zzafs) zzzgVarBuild;
                                    zzvk zzvkVarZza = SerializationMetadata.zza();
                                    zzvk zzvkVar = zzvk.zza;
                                    iOrdinal = zzvkVarZza.ordinal();
                                    if (iOrdinal != 0) {
                                    }
                                    String str6 = strConcat;
                                    str6.getClass();
                                    TraitElementPayload traitElementPayload = new TraitElementPayload("home.internal.traits.OAuthSessionTrait.UpdateToken", "type.googleapis.com/home.internal.traits.OAuthSessionTrait.UpdateToken", str6, null, null);
                                    zzael zzaelVarZza = zzaek.zza(zzaej.zzb());
                                    zzaelVarZza.zzc(zzaelVarZza.zzb(), zzd.zze(new ObjectCommand(str5, traitElementPayload, false)));
                                    zzaej zzaejVarZza = zzaelVarZza.zza();
                                    zzsVar.zzf = internalInteractionClient;
                                    zzsVar.zza = null;
                                    zzsVar.zzg = null;
                                    zzsVar.zzb = null;
                                    zzsVar.zze = 5;
                                    objZzE = internalInteractionClient.zzK(zzaejVarZza, zzsVar);
                                    internalInteractionClient3 = internalInteractionClient;
                                }
                                return coroutine_suspended;
                            }
                            Log.e(internalInteractionClient4.zzf, "Unable to fetch a refreshed OAuth token. This can possibly indicate revocation of OAuth consent. Permissions are no longer valid for this account.");
                            internalInteractionClient4.zze.invoke(Boxing.boxBoolean(false));
                            return zzl.zza;
                        }
                        if (i2 != 4) {
                            if (i2 != 5) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            InternalInteractionClient internalInteractionClient10 = zzsVar.zzf;
                            ResultKt.throwOnFailure(objZzE);
                            internalInteractionClient3 = internalInteractionClient10;
                            zzaen zzaenVar = (zzaen) objZzE;
                            if (zzaenVar != null) {
                                List listZza = zzaenVar.zza();
                                listZza.getClass();
                                if (!listZza.isEmpty()) {
                                    Log.i(internalInteractionClient3.zzf, "OAuth token successfully updated in LocalIAM.");
                                    return zzl.zzb;
                                }
                            }
                            Log.w(internalInteractionClient3.zzf, "Command to send the updated OAuth token to LocalIAM was not successful.");
                            return zzl.zza;
                        }
                        Mutex mutex2 = (Mutex) zzsVar.zzb;
                        String str7 = zzsVar.zzg;
                        str5 = (String) zzsVar.zza;
                        InternalInteractionClient internalInteractionClient11 = zzsVar.zzf;
                        ResultKt.throwOnFailure(objZzE);
                        accessToken = str7;
                        internalInteractionClient = internalInteractionClient11;
                        mutex = mutex2;
                        try {
                            internalInteractionClient.zzn = accessToken;
                            Unit unit2 = Unit.INSTANCE;
                            mutex.unlock(null);
                            Log.i(internalInteractionClient.zzf, "Attempting to send the updated OAuth token to LocalIAM.");
                            zzafr zzafrVarZza2 = zzafs.zza();
                            zzafrVarZza2.zza(accessToken);
                            zzzg zzzgVarBuild2 = zzafrVarZza2.build();
                            zzzgVarBuild2.getClass();
                            zzafs zzafsVar2 = (zzafs) zzzgVarBuild2;
                            zzvk zzvkVarZza2 = SerializationMetadata.zza();
                            zzvk zzvkVar2 = zzvk.zza;
                            iOrdinal = zzvkVarZza2.ordinal();
                            if (iOrdinal != 0) {
                                strConcat = "proto:".concat(String.valueOf(Base64.getEncoder().encodeToString(zzafsVar2.toByteArray())));
                            } else {
                                if (iOrdinal != 1) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                strConcat = Base64.getEncoder().encodeToString(zzafsVar2.toByteArray());
                            }
                            String str62 = strConcat;
                            str62.getClass();
                            TraitElementPayload traitElementPayload2 = new TraitElementPayload("home.internal.traits.OAuthSessionTrait.UpdateToken", "type.googleapis.com/home.internal.traits.OAuthSessionTrait.UpdateToken", str62, null, null);
                            zzael zzaelVarZza2 = zzaek.zza(zzaej.zzb());
                            zzaelVarZza2.zzc(zzaelVarZza2.zzb(), zzd.zze(new ObjectCommand(str5, traitElementPayload2, false)));
                            zzaej zzaejVarZza2 = zzaelVarZza2.zza();
                            zzsVar.zzf = internalInteractionClient;
                            zzsVar.zza = null;
                            zzsVar.zzg = null;
                            zzsVar.zzb = null;
                            zzsVar.zze = 5;
                            objZzE = internalInteractionClient.zzK(zzaejVarZza2, zzsVar);
                            internalInteractionClient3 = internalInteractionClient;
                        } catch (Throwable th) {
                            mutex.unlock(null);
                            throw th;
                        }
                    } catch (HomeException unused) {
                        internalInteractionClient = 3;
                        Log.e(internalInteractionClient.zzf, "Unknown error while refreshing the OAuth token in SendCommands flow.");
                        return zzl.zza;
                    }
                }
                zzaed zzaedVar = (zzaed) objZzE;
                if (zzaedVar != null && !zzaedVar.zza().isEmpty() && internalInteractionClient2.zzd != null) {
                    List listZza2 = zzaedVar.zza();
                    listZza2.getClass();
                    String strZza = ((zzadv) CollectionsKt.first(listZza2)).zza();
                    strZza.getClass();
                    Log.i(internalInteractionClient2.zzf, "Attempting to fetch a refreshed OAuth token.");
                    Account account2 = internalInteractionClient2.zzd;
                    zzsVar.zzf = internalInteractionClient2;
                    zzsVar.zza = authorizationClient2;
                    zzsVar.zzg = str2;
                    zzsVar.zzb = strZza;
                    zzsVar.zze = 2;
                    Object objZzO = internalInteractionClient2.zzO(authorizationClient2, account2, zzsVar);
                    if (objZzO == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AuthorizationClient authorizationClient4 = authorizationClient2;
                    str3 = str2;
                    str4 = strZza;
                    objZzE = objZzO;
                    authorizationClient3 = authorizationClient4;
                    internalInteractionClient6 = internalInteractionClient2;
                    authorizationResult = (AuthorizationResult) objZzE;
                    internalInteractionClient4 = internalInteractionClient6;
                    if (str3 != null) {
                    }
                    accessToken = authorizationResult.getAccessToken();
                    if (accessToken != null) {
                    }
                    Log.e(internalInteractionClient4.zzf, "Unable to fetch a refreshed OAuth token. This can possibly indicate revocation of OAuth consent. Permissions are no longer valid for this account.");
                    internalInteractionClient4.zze.invoke(Boxing.boxBoolean(false));
                    return zzl.zza;
                }
                Log.e(internalInteractionClient2.zzf, "Unable to refresh the OAuth token due to incomplete Information.");
                return zzl.zza;
            } catch (HomeException unused2) {
            }
        } catch (HomeException unused3) {
            internalInteractionClient = this;
        }
    }

    private final Object zzO(AuthorizationClient authorizationClient, Account account, Continuation continuation) {
        AuthorizationRequest authorizationRequestBuild = new AuthorizationRequest.Builder().setRequestedScopes(CollectionsKt.listOf(new Scope("https://www.googleapis.com/auth/home.platform.selected.devices"))).setAccount(account).build();
        authorizationRequestBuild.getClass();
        return TasksKt.await(authorizationClient.zza(authorizationRequestBuild), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.internal.serialization.zzag zzP() {
        com.google.android.gms.internal.serialization.zzaf zzafVar = new com.google.android.gms.internal.serialization.zzaf();
        zzafVar.zza(UUID.randomUUID().toString());
        zzafVar.zzb(Boolean.valueOf(this.zzi.isDeviceLocked()));
        zzafVar.zzc(zzacv.zzb());
        return zzafVar.zzd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzQ(zztr zztrVar, zzaef zzaefVar, Continuation continuation) throws Throwable {
        zzt zztVar;
        Object objZzG;
        if (continuation instanceof zzt) {
            zztVar = (zzt) continuation;
            int i = zztVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zztVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zztVar = new zzt(this, continuation);
            }
        }
        zzt zztVar2 = zztVar;
        Object obj = zztVar2.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zztVar2.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ConcurrentHashMap concurrentHashMap = this.zzj;
            Function2 function2 = zzw.zza;
            Function3 zzxVar = new zzx(zzaefVar, this);
            Function3 zzyVar = new zzy(zzaefVar, this);
            zztVar2.zzc = 1;
            objZzG = zzG(31718, zzaefVar, "eventSubscriber", zztrVar, concurrentHashMap, function2, zzxVar, zzyVar, zztVar2);
            if (objZzG == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objZzG = ((ReceiveHandle) obj).getZza();
        }
        return (String) objZzG;
    }

    public static /* synthetic */ Object zzc(InternalInteractionClient internalInteractionClient, int i, List list, RemoteCall remoteCall, Continuation continuation, int i2, Object obj) {
        return internalInteractionClient.zzD(i, CollectionsKt.emptyList(), remoteCall, continuation);
    }

    public static /* synthetic */ void zzv(InternalInteractionClient internalInteractionClient, Task task) {
        task.getClass();
        if (task.isSuccessful()) {
            Log.i(internalInteractionClient.zzf, "Disconnected from InteractionService");
        } else {
            Log.e(internalInteractionClient.zzf, "Failed to disconnect from InteractionService", task.getException());
        }
    }

    public static /* synthetic */ void zzw(zzadz zzadzVar, InternalInteractionClient internalInteractionClient, InteractionClientImpl interactionClientImpl, TaskCompletionSource taskCompletionSource) {
        zzq zzqVar = new zzq(taskCompletionSource);
        com.google.android.gms.internal.serialization.zzm zzmVar = new com.google.android.gms.internal.serialization.zzm();
        zzmVar.zza(zzqVar);
        zzmVar.zzb(zzadzVar);
        zzmVar.zzc(internalInteractionClient.zzP());
        ((com.google.android.gms.internal.serialization.zzba) interactionClientImpl.getService()).zze(zzmVar.zzd());
    }

    public static /* synthetic */ void zzy(zzaej zzaejVar, InternalInteractionClient internalInteractionClient, InteractionClientImpl interactionClientImpl, TaskCompletionSource taskCompletionSource) {
        zzan zzanVar = new zzan(taskCompletionSource);
        com.google.android.gms.internal.serialization.zzaa zzaaVar = new com.google.android.gms.internal.serialization.zzaa();
        zzaaVar.zza(zzanVar);
        zzaaVar.zzb(zzaejVar);
        zzaaVar.zzc(internalInteractionClient.zzP());
        ((com.google.android.gms.internal.serialization.zzba) interactionClientImpl.getService()).zzk(zzaaVar.zzd());
    }

    public static /* synthetic */ void zzz(zzaej zzaejVar, InternalInteractionClient internalInteractionClient, InteractionClientImpl interactionClientImpl, TaskCompletionSource taskCompletionSource) {
        zzam zzamVar = new zzam(taskCompletionSource);
        com.google.android.gms.internal.serialization.zzx zzxVar = new com.google.android.gms.internal.serialization.zzx();
        zzxVar.zza(zzamVar);
        zzxVar.zzb(zzaejVar);
        zzxVar.zzc(internalInteractionClient.zzP());
        ((com.google.android.gms.internal.serialization.zzba) interactionClientImpl.getService()).zzl(zzxVar.zzd());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.gms.internal.serialization.InteractionClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzA(zztr zztrVar, FilterQuery filterQuery, List list, Continuation continuation) throws Throwable {
        zzz zzzVar;
        Object objZzQ;
        if (continuation instanceof zzz) {
            zzzVar = (zzz) continuation;
            int i = zzzVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzzVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzzVar = new zzz(this, continuation);
            }
        }
        Object obj = zzzVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzzVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            zzaee zzaeeVarZza = zzaef.zza();
            zzaeeVarZza.getClass();
            zzadr zzadrVarZzb = zzd.zzb(filterQuery);
            zzadrVarZzb.getClass();
            zzaeeVarZza.zza(zzadrVarZzb);
            zzadx zzadxVarZzc = zzd.zzc(list);
            zzadxVarZzc.getClass();
            zzaeeVarZza.zzb(zzadxVarZzc);
            Unit unit = Unit.INSTANCE;
            zzzg zzzgVarBuild = zzaeeVarZza.build();
            zzzgVarBuild.getClass();
            zzzVar.zzc = 1;
            objZzQ = zzQ(zztrVar, (zzaef) zzzgVarBuild, zzzVar);
            if (objZzQ == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objZzQ = ((ReceiveHandle) obj).getZza();
        }
        return (String) objZzQ;
    }

    @Override // com.google.android.gms.internal.serialization.InteractionClient
    /* JADX INFO: renamed from: zza, reason: from getter */
    public final HomeConfig getZzb() {
        return this.zzb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b6, code lost:
    
        if (kotlinx.coroutines.flow.FlowKt.first(r13, r2, r0) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb(Continuation continuation) {
        zzap zzapVar;
        final InternalInteractionClient internalInteractionClient;
        Iterator it;
        Iterator it2;
        InternalInteractionClient internalInteractionClient2;
        if (continuation instanceof zzap) {
            zzapVar = (zzap) continuation;
            int i = zzapVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzapVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzapVar = new zzap(this, continuation);
            }
        }
        Object obj = zzapVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzapVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Log.i(this.zzf, "Shutdown initiated");
            this.zzg.set(true);
            int iIntValue = ((Number) this.zzh.getValue()).intValue();
            if (iIntValue > 0) {
                String str = this.zzf;
                int length = String.valueOf(iIntValue).length();
                String str2 = iIntValue > 1 ? "s" : "";
                StringBuilder sb = new StringBuilder(str2.length() + length + 45 + 12);
                zzba$$ExternalSyntheticOutline0.m(sb, "Shutdown waiting for ", iIntValue, " subscriber registration", str2);
                sb.append(" to complete");
                Log.i(str, sb.toString());
                MutableStateFlow mutableStateFlow = this.zzh;
                zzaq zzaqVar = new zzaq(null);
                zzapVar.zze = this;
                zzapVar.zzd = 1;
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    it = (Iterator) zzapVar.zza;
                    internalInteractionClient = zzapVar.zze;
                    ResultKt.throwOnFailure(obj);
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        String str3 = (String) next;
                        str3.getClass();
                        zzapVar.zze = internalInteractionClient;
                        zzapVar.zza = it;
                        zzapVar.zzd = 2;
                        if (internalInteractionClient.zzI(str3, zzapVar) == coroutine_suspended) {
                            break;
                        }
                    }
                    it2 = internalInteractionClient.zzj.keySet().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    internalInteractionClient2 = zzapVar.zze;
                    ResultKt.throwOnFailure(obj);
                    Log.i(internalInteractionClient2.zzf, "Shutdown complete");
                    return Unit.INSTANCE;
                }
                it2 = (Iterator) zzapVar.zza;
                internalInteractionClient = zzapVar.zze;
                ResultKt.throwOnFailure(obj);
                while (true) {
                    if (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        String str4 = (String) next2;
                        str4.getClass();
                        zzapVar.zze = internalInteractionClient;
                        zzapVar.zza = it2;
                        zzapVar.zzd = 3;
                        if (internalInteractionClient.zzJ(str4, zzapVar) == coroutine_suspended) {
                            break;
                        }
                    } else {
                        Log.i(internalInteractionClient.zzf, "Disconnecting from InteractionService");
                        Task<Boolean> taskAddOnCompleteListener = internalInteractionClient.disconnectService().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.home.internal.zzba
                            @Override // com.google.android.gms.tasks.OnCompleteListener
                            public final /* synthetic */ void onComplete(Task task) {
                                InternalInteractionClient.zzv(this.zza, task);
                            }
                        });
                        taskAddOnCompleteListener.getClass();
                        zzapVar.zze = internalInteractionClient;
                        zzapVar.zza = null;
                        zzapVar.zzd = 4;
                        if (TasksKt.await(taskAddOnCompleteListener, zzapVar) != coroutine_suspended) {
                            internalInteractionClient2 = internalInteractionClient;
                        }
                    }
                }
                return coroutine_suspended;
            }
            this = zzapVar.zze;
            ResultKt.throwOnFailure(obj);
        }
        internalInteractionClient = this;
        it = this.zzk.keySet().iterator();
        while (it.hasNext()) {
        }
        it2 = internalInteractionClient.zzj.keySet().iterator();
        while (true) {
            if (it2.hasNext()) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.gms.internal.serialization.InteractionClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzf(TraitSubscriber traitSubscriber, FilterQuery filterQuery, List list, Continuation continuation) throws Throwable {
        zzaj zzajVar;
        Object objZzH;
        if (continuation instanceof zzaj) {
            zzajVar = (zzaj) continuation;
            int i = zzajVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzajVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzajVar = new zzaj(this, continuation);
            }
        }
        Object obj = zzajVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzajVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            zzaeg zzaegVarZza = zzaeh.zza();
            zzaegVarZza.getClass();
            zzadr zzadrVarZzb = zzd.zzb(filterQuery);
            zzadrVarZzb.getClass();
            zzaegVarZza.zza(zzadrVarZzb);
            zzadx zzadxVarZzc = zzd.zzc(list);
            zzadxVarZzc.getClass();
            zzaegVarZza.zzb(zzadxVarZzc);
            Unit unit = Unit.INSTANCE;
            zzzg zzzgVarBuild = zzaegVarZza.build();
            zzzgVarBuild.getClass();
            zzajVar.zzc = 1;
            objZzH = zzH(traitSubscriber, (zzaeh) zzzgVarBuild, zzajVar);
            if (objZzH == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objZzH = ((ReceiveHandle) obj).getZza();
        }
        return (String) objZzH;
    }

    @Override // com.google.android.gms.internal.serialization.InteractionClient
    public final Object zzg(String str, Continuation continuation) {
        return this.zzg.get() ? Boxing.boxBoolean(false) : zzI(str, continuation);
    }

    @Override // com.google.android.gms.internal.serialization.InteractionClient
    public final Object zzh(String str, Continuation continuation) {
        return this.zzg.get() ? Boxing.boxBoolean(false) : zzJ(str, continuation);
    }

    @Override // com.google.android.gms.internal.serialization.InteractionClient
    public final Object zzi(List list, Continuation continuation) {
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ObjectCommand) it.next()).getPayload().getZzb(), "home.internal.traits.automation.AutomationDiscoveryTrait.DiscoverAutomationCandidates")) {
                    return zzM(list, new zzal(this, null), continuation);
                }
            }
        }
        return zzM(list, new zzak(this), continuation);
    }

    public /* synthetic */ InternalInteractionClient(Context context, InteractionOptions interactionOptions, Api api, HomeConfig homeConfig, AuthorizationClient authorizationClient, Account account, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new InteractionOptions(1, null, null, null) : interactionOptions, (i & 4) != 0 ? zzbc.zzc : null, homeConfig, (i & 16) != 0 ? null : authorizationClient, (i & 32) != 0 ? null : account, (i & 64) != 0 ? zzk.zza : function1);
    }
}

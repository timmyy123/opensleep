package com.google.home;

import android.accounts.Account;
import android.content.Context;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.view.result.ActivityResultCaller;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.home.internal.AuthorizationClient;
import com.google.android.gms.home.internal.AuthorizationClientImpl;
import com.google.android.gms.home.internal.InternalInteractionClient;
import com.google.android.gms.home.internal.InternalPermissionsClient;
import com.google.android.gms.home.internal.PermissionsResultWithInfo;
import com.google.android.gms.home.internal.PermissionsUiManager;
import com.google.android.gms.home.internal.zzbn;
import com.google.android.gms.home.permissions.HomeAccountResult;
import com.google.android.gms.home.permissions.PermissionsClient;
import com.google.android.gms.internal.serialization.InteractionClient;
import com.google.android.gms.internal.serialization.InteractionOptions;
import com.google.android.gms.internal.serialization.zzrn;
import com.google.home.Home;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u0002:\u0002\u0083\u0001B[\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u001b\u001a\u00020\u00182\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0081@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0017¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00182\u0006\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b&\u0010'J\u0018\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0097@¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-H\u0096@¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0018H\u0003¢\u0006\u0004\b0\u00101J\u0018\u00103\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b3\u00104J;\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\b\b\u0000\u00106*\u0002052\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c07H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0018H\u0002¢\u0006\u0004\b;\u00101J.\u0010A\u001a\b\u0012\u0004\u0012\u00020@0>2\u0006\u0010=\u001a\u00020<2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020-0>H\u0087@¢\u0006\u0004\bA\u0010BJ0\u0010I\u001a\u00020F2\u0006\u0010D\u001a\u00020C2\u0006\u0010=\u001a\u00020<2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020-0>H\u0087@¢\u0006\u0004\bG\u0010HR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010JR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010\n\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010Q\u001a\u0004\bR\u0010SR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010TR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010UR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010VR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010WR\u0014\u0010X\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010c\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010YR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020f0e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001c\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bl\u0010hR\"\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160m8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR \u0010r\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\br\u0010W\u0012\u0004\bu\u00101\u001a\u0004\bs\u0010tR \u0010v\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bv\u0010U\u0012\u0004\by\u00101\u001a\u0004\bw\u0010xR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010|R/\u0010~\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0018078\u0000X\u0081\u0004¢\u0006\u0015\n\u0004\b~\u0010\u007f\u0012\u0005\b\u0082\u0001\u00101\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0084\u0001"}, d2 = {"Lcom/google/home/Home;", "Lcom/google/home/HomeClient;", "Lcom/google/home/internal/impl/TokenRefresh;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/google/android/gms/home/permissions/PermissionsClient;", "permissionsClient", "Lcom/google/android/gms/home/internal/AuthorizationClient;", "authorizationClient", "Lcom/google/home/HomeConfig;", "homeConfig", "Lcom/google/android/gms/common/GoogleApiAvailabilityLight;", "googleApiAvailability", "Lcom/google/android/gms/home/internal/PermissionsUiManager;", "permissionsUiManagerOverride", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "providedAccount", "Lcom/google/home/HomeManager;", "homeManagerOverride", "<init>", "(Landroid/content/Context;Lcom/google/android/gms/home/permissions/PermissionsClient;Lcom/google/android/gms/home/internal/AuthorizationClient;Lcom/google/home/HomeConfig;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;Lcom/google/android/gms/home/internal/PermissionsUiManager;Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;Lcom/google/home/HomeManager;)V", "Lkotlin/Function0;", "Lcom/google/nest/platform/mesh/interaction/InteractionClient;", "createClient", "", "setInteractionClient$java_com_google_android_gmscore_integ_client_home_home", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInteractionClient", "Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/HomeDevice;", "devices", "()Lcom/google/home/HomeObjectsFlow;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/home/PermissionsState;", "hasPermissions", "()Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/result/ActivityResultCaller;", "permissionsLauncher", "registerActivityResultCallerForPermissions", "(Landroidx/activity/result/ActivityResultCaller;)V", "", "forceLaunch", "Lcom/google/home/PermissionsResult;", "requestPermissions", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "refreshToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attemptToInitializeInteractionClient", "()V", "googleAccount", "initializeInteractionClientWithProvidedAccount", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/home/HasId;", "T", "Lkotlin/Function1;", "call", "executeHomeManagerCall", "(Lkotlin/jvm/functions/Function1;)Lcom/google/home/HomeObjectsFlow;", "throwHomeExceptionIfShutdown", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "objectFilter", "", "reduceObjectFilter", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "readObjects", "(Lcom/google/nest/platform/mesh/interaction/FilterQuery;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;", "subscriber", "traitFilter", "Lcom/google/nest/platform/mesh/interaction/ReceiveHandle;", "registerTraitSubscriber-OCNOtTU", "(Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;Lcom/google/nest/platform/mesh/interaction/FilterQuery;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerTraitSubscriber", "Landroid/content/Context;", "Lcom/google/android/gms/home/permissions/PermissionsClient;", "getPermissionsClient$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/android/gms/home/permissions/PermissionsClient;", "Lcom/google/android/gms/home/internal/AuthorizationClient;", "getAuthorizationClient$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/android/gms/home/internal/AuthorizationClient;", "Lcom/google/home/HomeConfig;", "getHomeConfig$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/home/HomeConfig;", "Lcom/google/android/gms/common/GoogleApiAvailabilityLight;", "Lcom/google/android/gms/home/internal/PermissionsUiManager;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "Lcom/google/home/HomeManager;", "instanceTag", "Ljava/lang/String;", "Lcom/google/home/Home$Companion$PermissionsType;", "permissionsType", "Lcom/google/home/Home$Companion$PermissionsType;", "Lkotlinx/coroutines/sync/Mutex;", "interactionClientLock", "Lkotlinx/coroutines/sync/Mutex;", "Landroid/accounts/Account;", "currentAccount", "Landroid/accounts/Account;", "cachedOAuthTokenLock", "cachedOAuthToken", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/google/home/Home$Companion$TokenRefreshState;", "tokenRefreshStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_interactionClientProvider", "Lkotlinx/coroutines/flow/StateFlow;", "interactionClientProvider", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractionClientProvider$java_com_google_android_gmscore_integ_client_home_home", "()Lkotlinx/coroutines/flow/StateFlow;", "homeManager", "getHomeManager$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/home/HomeManager;", "getHomeManager$java_com_google_android_gmscore_integ_client_home_home$annotations", "permissionsUiManager", "getPermissionsUiManager$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/android/gms/home/internal/PermissionsUiManager;", "getPermissionsUiManager$java_com_google_android_gmscore_integ_client_home_home$annotations", "Lkotlinx/coroutines/CompletableJob;", "initializationJob", "Lkotlinx/coroutines/CompletableJob;", "permissionsGrantedJob", "updateHasPermissionsFlow", "Lkotlin/jvm/functions/Function1;", "getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home", "()Lkotlin/jvm/functions/Function1;", "getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home$annotations", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Home implements HomeClient, zzrn {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MutableStateFlow<InteractionClient> _interactionClientProvider;
    private final AuthorizationClient authorizationClient;
    private String cachedOAuthToken;
    private final Mutex cachedOAuthTokenLock;
    private final Context context;
    private Account currentAccount;
    private final GoogleApiAvailabilityLight googleApiAvailability;
    private final HomeConfig homeConfig;
    private final HomeManager homeManager;
    private final HomeManager homeManagerOverride;
    private final CompletableJob initializationJob;
    private final String instanceTag;
    private final Mutex interactionClientLock;
    private final StateFlow<InteractionClient> interactionClientProvider;
    private AtomicBoolean isShutdown;
    private final PermissionsClient permissionsClient;
    private final CompletableJob permissionsGrantedJob;
    private Companion.PermissionsType permissionsType;
    private final PermissionsUiManager permissionsUiManager;
    private final PermissionsUiManager permissionsUiManagerOverride;
    private final GoogleSignInAccount providedAccount;
    private MutableStateFlow<Companion.TokenRefreshState> tokenRefreshStateFlow;
    private final Function1<Boolean, Unit> updateHasPermissionsFlow;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/google/home/Home$Companion;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/google/home/HomeConfig;", "homeConfig", "Lcom/google/home/HomeClient;", "getClient", "(Landroid/content/Context;Lcom/google/home/HomeConfig;)Lcom/google/home/HomeClient;", "Lcom/google/android/gms/home/interaction/GmsInteractionClient;", "getInteractionClient", "(Landroid/content/Context;)Lcom/google/android/gms/home/interaction/GmsInteractionClient;", "", "TAG", "Ljava/lang/String;", "PermissionsType", "TokenRefreshState", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/home/Home$Companion$PermissionsType;", "", "<init>", "(Ljava/lang/String;I)V", "OAUTH", "OAUTH_WITH_ACCOUNT_PROVIDED", "UNINITIALIZED", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class PermissionsType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ PermissionsType[] $VALUES;
            public static final PermissionsType OAUTH = new PermissionsType("OAUTH", 0);
            public static final PermissionsType OAUTH_WITH_ACCOUNT_PROVIDED = new PermissionsType("OAUTH_WITH_ACCOUNT_PROVIDED", 1);
            public static final PermissionsType UNINITIALIZED = new PermissionsType("UNINITIALIZED", 2);

            private static final /* synthetic */ PermissionsType[] $values() {
                return new PermissionsType[]{OAUTH, OAUTH_WITH_ACCOUNT_PROVIDED, UNINITIALIZED};
            }

            static {
                PermissionsType[] permissionsTypeArr$values = $values();
                $VALUES = permissionsTypeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(permissionsTypeArr$values);
            }

            private PermissionsType(String str, int i) {
            }

            public static PermissionsType valueOf(String str) {
                return (PermissionsType) Enum.valueOf(PermissionsType.class, str);
            }

            public static PermissionsType[] values() {
                return (PermissionsType[]) $VALUES.clone();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/home/Home$Companion$TokenRefreshState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TOKEN_FETCH_SUCCESSFUL", "TOKEN_FETCH_UNSUCCESSFUL", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class TokenRefreshState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ TokenRefreshState[] $VALUES;
            public static final TokenRefreshState UNKNOWN = new TokenRefreshState("UNKNOWN", 0);
            public static final TokenRefreshState TOKEN_FETCH_SUCCESSFUL = new TokenRefreshState("TOKEN_FETCH_SUCCESSFUL", 1);
            public static final TokenRefreshState TOKEN_FETCH_UNSUCCESSFUL = new TokenRefreshState("TOKEN_FETCH_UNSUCCESSFUL", 2);

            private static final /* synthetic */ TokenRefreshState[] $values() {
                return new TokenRefreshState[]{UNKNOWN, TOKEN_FETCH_SUCCESSFUL, TOKEN_FETCH_UNSUCCESSFUL};
            }

            static {
                TokenRefreshState[] tokenRefreshStateArr$values = $values();
                $VALUES = tokenRefreshStateArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(tokenRefreshStateArr$values);
            }

            private TokenRefreshState(String str, int i) {
            }

            public static TokenRefreshState valueOf(String str) {
                return (TokenRefreshState) Enum.valueOf(TokenRefreshState.class, str);
            }

            public static TokenRefreshState[] values() {
                return (TokenRefreshState[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        public final HomeClient getClient(Context context, HomeConfig homeConfig) {
            context.getClass();
            homeConfig.getClass();
            return new Home(context, new InternalPermissionsClient(context), null, homeConfig, null, null, null, null, 244, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$attemptToInitializeInteractionClient$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home$attemptToInitializeInteractionClient$1", f = "Home.kt", l = {214, 229, 838, 849, 240}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Home.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
        
            if (r12 != r0) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0169  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            HomeAccountResult homeAccountResult;
            Account zza;
            HomeAccountResult homeAccountResult2;
            Home home;
            Mutex mutex;
            final String str;
            Account account;
            final HomeAccountResult homeAccountResult3;
            final Home home2;
            Mutex mutex2;
            Mutex mutex3;
            Function0<InteractionClient> function0;
            Account account2;
            Home home3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (HomeException e) {
                Log.w(Home.this.instanceTag, "Failed to get user selected account for home access.", e);
                homeAccountResult = null;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PermissionsClient permissionsClient = Home.this.getPermissionsClient();
                this.label = 1;
                obj = permissionsClient.zza(this);
            } else {
                if (i != 1) {
                    if (i == 2) {
                        zza = (Account) this.L$1;
                        homeAccountResult2 = (HomeAccountResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Account account3 = zza;
                        String accessToken = ((AuthorizationResult) obj).getAccessToken();
                        home = Home.this;
                        mutex = home.cachedOAuthTokenLock;
                        this.L$0 = homeAccountResult2;
                        this.L$1 = account3;
                        this.L$2 = accessToken;
                        this.L$3 = mutex;
                        this.L$4 = home;
                        this.label = 3;
                        if (mutex.lock(null, this) != coroutine_suspended) {
                            str = accessToken;
                            account = account3;
                            homeAccountResult3 = homeAccountResult2;
                            home.cachedOAuthToken = str;
                            Unit unit = Unit.INSTANCE;
                            if (str != null) {
                            }
                            Home.this.initializationJob.complete();
                            Log.i(Home.this.instanceTag, "Initialization job completed for Home client.");
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            home3 = (Home) this.L$2;
                            mutex3 = (Mutex) this.L$1;
                            account2 = (Account) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                home3.currentAccount = account2;
                                home3.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL);
                                home3.permissionsGrantedJob.complete();
                                Home.this.initializationJob.complete();
                                Log.i(Home.this.instanceTag, "Initialization job completed for Home client.");
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        home2 = (Home) this.L$4;
                        mutex2 = (Mutex) this.L$3;
                        str = (String) this.L$2;
                        Account account4 = (Account) this.L$1;
                        homeAccountResult3 = (HomeAccountResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        account = account4;
                        try {
                            function0 = new Function0<InteractionClient>() { // from class: com.google.home.Home$attemptToInitializeInteractionClient$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final InteractionClient invoke() {
                                    Context context = home2.context;
                                    InteractionOptions interactionOptionsZzc = InteractionOptions.zzc(new InteractionOptions(1, null, null, null), 0, null, str, homeAccountResult3.getZzc(), 3, null);
                                    Home home4 = home2;
                                    return new InternalInteractionClient(context, interactionOptionsZzc, null, home4.getHomeConfig(), home4.getAuthorizationClient(), homeAccountResult3.getZza(), home4.getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home(), 4, null);
                                }
                            };
                            this.L$0 = account;
                            this.L$1 = mutex2;
                            this.L$2 = home2;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 5;
                            if (home2.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(function0, this) != coroutine_suspended) {
                                account2 = account;
                                home3 = home2;
                                mutex3 = mutex2;
                                home3.currentAccount = account2;
                                home3.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL);
                                home3.permissionsGrantedJob.complete();
                                Home.this.initializationJob.complete();
                                Log.i(Home.this.instanceTag, "Initialization job completed for Home client.");
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex3 = mutex2;
                            throw th;
                        }
                    }
                    home = (Home) this.L$4;
                    Mutex mutex4 = (Mutex) this.L$3;
                    String str2 = (String) this.L$2;
                    Account account5 = (Account) this.L$1;
                    HomeAccountResult homeAccountResult4 = (HomeAccountResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    account = account5;
                    homeAccountResult3 = homeAccountResult4;
                    mutex = mutex4;
                    str = str2;
                    try {
                        home.cachedOAuthToken = str;
                        Unit unit2 = Unit.INSTANCE;
                        if (str != null) {
                            String zzc = homeAccountResult3.getZzc();
                            if (zzc != null && zzc.length() > 0) {
                                String str3 = Home.this.instanceTag;
                                String zzc2 = homeAccountResult3.getZzc();
                                StringBuilder sb = new StringBuilder(String.valueOf(zzc2).length() + 46);
                                sb.append("Creating InteractionClient for ClientSession ");
                                sb.append(zzc2);
                                sb.append(".");
                                Log.i(str3, sb.toString());
                            }
                            home2 = Home.this;
                            Mutex mutex5 = home2.interactionClientLock;
                            this.L$0 = homeAccountResult3;
                            this.L$1 = account;
                            this.L$2 = str;
                            this.L$3 = mutex5;
                            this.L$4 = home2;
                            this.label = 4;
                            if (mutex5.lock(null, this) != coroutine_suspended) {
                                mutex2 = mutex5;
                                function0 = new Function0<InteractionClient>() { // from class: com.google.home.Home$attemptToInitializeInteractionClient$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final InteractionClient invoke() {
                                        Context context = home2.context;
                                        InteractionOptions interactionOptionsZzc = InteractionOptions.zzc(new InteractionOptions(1, null, null, null), 0, null, str, homeAccountResult3.getZzc(), 3, null);
                                        Home home4 = home2;
                                        return new InternalInteractionClient(context, interactionOptionsZzc, null, home4.getHomeConfig(), home4.getAuthorizationClient(), homeAccountResult3.getZza(), home4.getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home(), 4, null);
                                    }
                                };
                                this.L$0 = account;
                                this.L$1 = mutex2;
                                this.L$2 = home2;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 5;
                                if (home2.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(function0, this) != coroutine_suspended) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        Home.this.initializationJob.complete();
                        Log.i(Home.this.instanceTag, "Initialization job completed for Home client.");
                        return Unit.INSTANCE;
                    } finally {
                        mutex.unlock(null);
                    }
                }
                ResultKt.throwOnFailure(obj);
            }
            homeAccountResult = (HomeAccountResult) obj;
            zza = homeAccountResult != null ? homeAccountResult.getZza() : null;
            Home home4 = Home.this;
            if (zza == null) {
                home4.initializationJob.complete();
                Log.i(Home.this.instanceTag, "Initialization job completed for Home client.");
                return Unit.INSTANCE;
            }
            PermissionsUiManager permissionsUiManager = home4.getPermissionsUiManager();
            this.L$0 = homeAccountResult;
            this.L$1 = zza;
            this.label = 2;
            Object objZzb = permissionsUiManager.zzb(zza, this);
            if (objZzb != coroutine_suspended) {
                homeAccountResult2 = homeAccountResult;
                obj = objZzb;
                Account account32 = zza;
                String accessToken2 = ((AuthorizationResult) obj).getAccessToken();
                home = Home.this;
                mutex = home.cachedOAuthTokenLock;
                this.L$0 = homeAccountResult2;
                this.L$1 = account32;
                this.L$2 = accessToken2;
                this.L$3 = mutex;
                this.L$4 = home;
                this.label = 3;
                if (mutex.lock(null, this) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$devices$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C20631 extends FunctionReferenceImpl implements Function1<HomeManager, HomeObjectsFlow<HomeDevice>> {
        public static final C20631 INSTANCE = new C20631();

        public C20631() {
            super(1, HomeManager.class, "devices", "devices()Lcom/google/home/HomeObjectsFlow;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final HomeObjectsFlow<HomeDevice> invoke(HomeManager homeManager) {
            homeManager.getClass();
            return homeManager.devices();
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$executeHomeManagerCall$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "T", "Lcom/google/home/HasId;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home$executeHomeManagerCall$1", f = "Home.kt", l = {FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 343}, m = "invokeSuspend")
    public static final class C20641 extends SuspendLambda implements Function2<FlowCollector<? super Set>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HomeManager, HomeObjectsFlow> $call;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C20641(Function1<? super HomeManager, HomeObjectsFlow> function1, Continuation<? super C20641> continuation) {
            super(2, continuation);
            this.$call = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C20641 c20641 = Home.this.new C20641(this.$call, continuation);
            c20641.L$0 = obj;
            return c20641;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Set> flowCollector, Continuation<? super Unit> continuation) {
            return ((C20641) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, r6, r5) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws HomeException {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                CompletableJob completableJob = Home.this.initializationJob;
                this.L$0 = flowCollector;
                this.label = 1;
                if (completableJob.join(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            Home.this.throwHomeExceptionIfShutdown();
            HomeObjectsFlow homeObjectsFlowInvoke = this.$call.invoke(Home.this.getHomeManager());
            if (homeObjectsFlowInvoke != null) {
                this.L$0 = null;
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$hasPermissions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/home/PermissionsState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home$hasPermissions$1", f = "Home.kt", l = {383, 384, 394, 395, 406}, m = "invokeSuspend")
    public static final class C20651 extends SuspendLambda implements Function2<FlowCollector<? super PermissionsState>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C20651(Continuation<? super C20651> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C20651 c20651 = Home.this.new C20651(continuation);
            c20651.L$0 = obj;
            return c20651;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super PermissionsState> flowCollector, Continuation<? super Unit> continuation) {
            return ((C20651) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00d4, code lost:
        
            if (r4.collect(r10, r9) != r0) goto L39;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[PHI: r1
          0x0075: PHI (r1v4 kotlinx.coroutines.flow.FlowCollector) = 
          (r1v2 kotlinx.coroutines.flow.FlowCollector)
          (r1v3 kotlinx.coroutines.flow.FlowCollector)
          (r1v10 kotlinx.coroutines.flow.FlowCollector)
         binds: [B:17:0x0057, B:21:0x0073, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00bc A[PHI: r1
          0x00bc: PHI (r1v6 kotlinx.coroutines.flow.FlowCollector) = 
          (r1v4 kotlinx.coroutines.flow.FlowCollector)
          (r1v5 kotlinx.coroutines.flow.FlowCollector)
          (r1v14 kotlinx.coroutines.flow.FlowCollector)
         binds: [B:31:0x009e, B:35:0x00ba, B:12:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws HomeException {
            final FlowCollector flowCollector;
            CompletableJob completableJob;
            int iOrdinal;
            CompletableJob completableJob2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                if (Home.this.initializationJob.isActive()) {
                    PermissionsState permissionsState = PermissionsState.PERMISSIONS_STATE_UNINITIALIZED;
                    this.L$0 = flowCollector;
                    this.label = 1;
                    if (flowCollector.emit(permissionsState, this) != coroutine_suspended) {
                        completableJob = Home.this.initializationJob;
                        this.L$0 = flowCollector;
                        this.label = 2;
                        if (completableJob.join(this) != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                completableJob = Home.this.initializationJob;
                this.L$0 = flowCollector;
                this.label = 2;
                if (completableJob.join(this) != coroutine_suspended) {
                    Companion.PermissionsType permissionsType = Home.this.permissionsType;
                    Companion.PermissionsType permissionsType2 = Companion.PermissionsType.OAUTH;
                    iOrdinal = permissionsType.ordinal();
                    if (iOrdinal == 0) {
                    }
                    if (!Home.this.permissionsGrantedJob.isActive()) {
                    }
                }
                return coroutine_suspended;
            }
            if (i == 2) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                Companion.PermissionsType permissionsType3 = Home.this.permissionsType;
                Companion.PermissionsType permissionsType22 = Companion.PermissionsType.OAUTH;
                iOrdinal = permissionsType3.ordinal();
                if (iOrdinal == 0 && iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        throw HomeException.INSTANCE.internal("Permissions type MUST be set before initialization job is completed.");
                    }
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                if (!Home.this.permissionsGrantedJob.isActive()) {
                    PermissionsState permissionsState2 = PermissionsState.NOT_GRANTED;
                    this.L$0 = flowCollector;
                    this.label = 3;
                    if (flowCollector.emit(permissionsState2, this) != coroutine_suspended) {
                        completableJob2 = Home.this.permissionsGrantedJob;
                        this.L$0 = flowCollector;
                        this.label = 4;
                        if (completableJob2.join(this) != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i == 3) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                completableJob2 = Home.this.permissionsGrantedJob;
                this.L$0 = flowCollector;
                this.label = 4;
                if (completableJob2.join(this) != coroutine_suspended) {
                    final MutableStateFlow mutableStateFlow = Home.this.tokenRefreshStateFlow;
                    Flow<PermissionsState> flow = new Flow<PermissionsState>() { // from class: com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1

                        /* JADX INFO: renamed from: com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1$2", f = "Home.kt", l = {50}, m = "emit")
                            public static final class AnonymousClass1 extends ContinuationImpl {
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
                                    PermissionsState permissionsState = ((Home.Companion.TokenRefreshState) obj) == Home.Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL ? PermissionsState.GRANTED : PermissionsState.NOT_GRANTED;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(permissionsState, anonymousClass1) == coroutine_suspended) {
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
                        public Object collect(FlowCollector<? super PermissionsState> flowCollector2, Continuation continuation) {
                            Object objCollect = mutableStateFlow.collect(new AnonymousClass2(flowCollector2), continuation);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }
                    };
                    FlowCollector<? super PermissionsState> flowCollector2 = new FlowCollector() { // from class: com.google.home.Home.hasPermissions.1.2
                        public final Object emit(PermissionsState permissionsState3, Continuation<? super Unit> continuation) {
                            Object objEmit = flowCollector.emit(permissionsState3, continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((PermissionsState) obj2, (Continuation<? super Unit>) continuation);
                        }
                    };
                    this.L$0 = null;
                    this.label = 5;
                }
                return coroutine_suspended;
            }
            if (i != 4) {
                if (i == 5) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            final Flow mutableStateFlow2 = Home.this.tokenRefreshStateFlow;
            Flow<PermissionsState> flow2 = new Flow<PermissionsState>() { // from class: com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "com.google.home.Home$hasPermissions$1$invokeSuspend$$inlined$map$1$2", f = "Home.kt", l = {50}, m = "emit")
                    public static final class AnonymousClass1 extends ContinuationImpl {
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
                            PermissionsState permissionsState = ((Home.Companion.TokenRefreshState) obj) == Home.Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL ? PermissionsState.GRANTED : PermissionsState.NOT_GRANTED;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(permissionsState, anonymousClass1) == coroutine_suspended) {
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
                public Object collect(FlowCollector<? super PermissionsState> flowCollector22, Continuation continuation) {
                    Object objCollect = mutableStateFlow2.collect(new AnonymousClass2(flowCollector22), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            FlowCollector<? super PermissionsState> flowCollector22 = new FlowCollector() { // from class: com.google.home.Home.hasPermissions.1.2
                public final Object emit(PermissionsState permissionsState3, Continuation<? super Unit> continuation) {
                    Object objEmit = flowCollector.emit(permissionsState3, continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((PermissionsState) obj2, (Continuation<? super Unit>) continuation);
                }
            };
            this.L$0 = null;
            this.label = 5;
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$initializeInteractionClientWithProvidedAccount$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home", f = "Home.kt", l = {269, 838, 849, 282}, m = "initializeInteractionClientWithProvidedAccount")
    public static final class C20661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C20661(Continuation<? super C20661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Home.this.initializeInteractionClientWithProvidedAccount(null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$refreshToken$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home", f = "Home.kt", l = {838, 642}, m = "refreshToken")
    public static final class C20671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20671(Continuation<? super C20671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Home.this.refreshToken(this);
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$refreshToken$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home$refreshToken$2", f = "Home.kt", l = {644, 838, 654, 849, 860}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Account $account;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Account account, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$account = account;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Home.this.new AnonymousClass2(this.$account, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:38:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0154 A[PHI: r4 r5
          0x0154: PHI (r4v5 kotlin.jvm.internal.Ref$ObjectRef) = 
          (r4v3 kotlin.jvm.internal.Ref$ObjectRef)
          (r4v3 kotlin.jvm.internal.Ref$ObjectRef)
          (r4v7 kotlin.jvm.internal.Ref$ObjectRef)
         binds: [B:37:0x011c, B:39:0x0122, B:47:0x014c] A[DONT_GENERATE, DONT_INLINE]
          0x0154: PHI (r5v9 java.lang.String) = (r5v7 java.lang.String), (r5v7 java.lang.String), (r5v11 java.lang.String) binds: [B:37:0x011c, B:39:0x0122, B:47:0x014c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01a2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01a3 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref$ObjectRef ref$ObjectRef;
            Ref$ObjectRef ref$ObjectRef2;
            String str;
            T t;
            Home home;
            Mutex mutex;
            String accessToken;
            Ref$ObjectRef ref$ObjectRef3;
            String str2;
            Ref$ObjectRef ref$ObjectRef4;
            String accessToken2;
            Home home2;
            Mutex mutex2;
            T t2;
            Mutex mutex3;
            Home home3;
            Ref$ObjectRef ref$ObjectRef5;
            String str3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ref$ObjectRef = new Ref$ObjectRef();
                Home home4 = Home.this;
                Account account = this.$account;
                PermissionsUiManager permissionsUiManager = home4.getPermissionsUiManager();
                this.L$0 = "";
                this.L$1 = ref$ObjectRef;
                this.L$2 = ref$ObjectRef;
                this.label = 1;
                Object objZzb = permissionsUiManager.zzb(account, this);
                if (objZzb != coroutine_suspended) {
                    ref$ObjectRef2 = ref$ObjectRef;
                    str = "";
                    t = objZzb;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    home = (Home) this.L$3;
                    mutex = (Mutex) this.L$2;
                    ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        String str4 = home.cachedOAuthToken;
                        mutex.unlock(null);
                        accessToken = ((AuthorizationResult) ref$ObjectRef2.element).getAccessToken();
                        if (accessToken != null || StringsKt.isBlank(accessToken) || str4 == null || !str4.equals(((AuthorizationResult) ref$ObjectRef2.element).getAccessToken())) {
                            ref$ObjectRef3 = ref$ObjectRef2;
                            str2 = str;
                            accessToken2 = ((AuthorizationResult) ref$ObjectRef3.element).getAccessToken();
                            if (accessToken2 == null) {
                            }
                            Log.w(Home.this.instanceTag, "OAuth token was not fetched successfully and HasPermissions will now return NOT_GRANTED.");
                            Home.this.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_UNSUCCESSFUL);
                            String unused = Home.this.instanceTag;
                            Home home5 = Home.this;
                            mutex3 = home5.cachedOAuthTokenLock;
                            this.L$0 = str2;
                            this.L$1 = ref$ObjectRef3;
                            this.L$2 = mutex3;
                            this.L$3 = home5;
                            this.label = 5;
                            if (mutex3.lock(null, this) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        Log.i(Home.this.instanceTag, "Refresh OAuth token unchanged, clearing cache and re-fetching");
                        Home.this.getAuthorizationClient().zzc(str4);
                        Home home6 = Home.this;
                        Account account2 = this.$account;
                        PermissionsUiManager permissionsUiManager2 = home6.getPermissionsUiManager();
                        this.L$0 = str;
                        this.L$1 = ref$ObjectRef2;
                        this.L$2 = ref$ObjectRef2;
                        this.L$3 = null;
                        this.label = 3;
                        Object objZzb2 = permissionsUiManager2.zzb(account2, this);
                        if (objZzb2 != coroutine_suspended) {
                            ref$ObjectRef4 = ref$ObjectRef2;
                            ref$ObjectRef3 = ref$ObjectRef4;
                            str2 = str;
                            t2 = objZzb2;
                            ref$ObjectRef4.element = t2;
                            accessToken2 = ((AuthorizationResult) ref$ObjectRef3.element).getAccessToken();
                            if (accessToken2 == null) {
                            }
                            Log.w(Home.this.instanceTag, "OAuth token was not fetched successfully and HasPermissions will now return NOT_GRANTED.");
                            Home.this.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_UNSUCCESSFUL);
                            String unused2 = Home.this.instanceTag;
                            Home home52 = Home.this;
                            mutex3 = home52.cachedOAuthTokenLock;
                            this.L$0 = str2;
                            this.L$1 = ref$ObjectRef3;
                            this.L$2 = mutex3;
                            this.L$3 = home52;
                            this.label = 5;
                            if (mutex3.lock(null, this) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } finally {
                    }
                }
                if (i == 3) {
                    ref$ObjectRef4 = (Ref$ObjectRef) this.L$2;
                    ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                    str2 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t2 = obj;
                    ref$ObjectRef4.element = t2;
                    accessToken2 = ((AuthorizationResult) ref$ObjectRef3.element).getAccessToken();
                    if (accessToken2 == null && !StringsKt.isBlank(accessToken2)) {
                        if (((AuthorizationResult) ref$ObjectRef3.element).getPendingIntent() != null) {
                            home2 = Home.this;
                            Mutex mutex4 = home2.cachedOAuthTokenLock;
                            this.L$0 = str2;
                            this.L$1 = ref$ObjectRef3;
                            this.L$2 = mutex4;
                            this.L$3 = home2;
                            this.label = 4;
                            if (mutex4.lock(null, this) != coroutine_suspended) {
                                mutex2 = mutex4;
                                if (home2.cachedOAuthToken != null) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    String unused22 = Home.this.instanceTag;
                    Home home522 = Home.this;
                    mutex3 = home522.cachedOAuthTokenLock;
                    this.L$0 = str2;
                    this.L$1 = ref$ObjectRef3;
                    this.L$2 = mutex3;
                    this.L$3 = home522;
                    this.label = 5;
                    if (mutex3.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 4) {
                    if (i != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    home3 = (Home) this.L$3;
                    mutex3 = (Mutex) this.L$2;
                    ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
                    str3 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        home3.cachedOAuthToken = ((AuthorizationResult) ref$ObjectRef5.element).getAccessToken();
                        Unit unit = Unit.INSTANCE;
                        mutex3.unlock(null);
                        String accessToken3 = ((AuthorizationResult) ref$ObjectRef5.element).getAccessToken();
                        return accessToken3 != null ? str3 : accessToken3;
                    } finally {
                    }
                }
                home2 = (Home) this.L$3;
                mutex2 = (Mutex) this.L$2;
                ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    if (home2.cachedOAuthToken != null) {
                        Log.w(Home.this.instanceTag, "OAuth token was not fetched successfully and HasPermissions will now return NOT_GRANTED.");
                        Home.this.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_UNSUCCESSFUL);
                    }
                    String unused222 = Home.this.instanceTag;
                    Home home5222 = Home.this;
                    mutex3 = home5222.cachedOAuthTokenLock;
                    this.L$0 = str2;
                    this.L$1 = ref$ObjectRef3;
                    this.L$2 = mutex3;
                    this.L$3 = home5222;
                    this.label = 5;
                    if (mutex3.lock(null, this) != coroutine_suspended) {
                        home3 = home5222;
                        ref$ObjectRef5 = ref$ObjectRef3;
                        str3 = str2;
                        home3.cachedOAuthToken = ((AuthorizationResult) ref$ObjectRef5.element).getAccessToken();
                        Unit unit2 = Unit.INSTANCE;
                        mutex3.unlock(null);
                        String accessToken32 = ((AuthorizationResult) ref$ObjectRef5.element).getAccessToken();
                        if (accessToken32 != null) {
                        }
                    }
                    return coroutine_suspended;
                } finally {
                }
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            t = obj;
            ref$ObjectRef.element = t;
            home = Home.this;
            Mutex mutex5 = home.cachedOAuthTokenLock;
            this.L$0 = str;
            this.L$1 = ref$ObjectRef2;
            this.L$2 = mutex5;
            this.L$3 = home;
            this.label = 2;
            if (mutex5.lock(null, this) != coroutine_suspended) {
                mutex = mutex5;
                String str42 = home.cachedOAuthToken;
                mutex.unlock(null);
                accessToken = ((AuthorizationResult) ref$ObjectRef2.element).getAccessToken();
                if (accessToken != null) {
                }
                ref$ObjectRef3 = ref$ObjectRef2;
                str2 = str;
                accessToken2 = ((AuthorizationResult) ref$ObjectRef3.element).getAccessToken();
                if (accessToken2 == null) {
                }
                Log.w(Home.this.instanceTag, "OAuth token was not fetched successfully and HasPermissions will now return NOT_GRANTED.");
                Home.this.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_UNSUCCESSFUL);
                String unused2222 = Home.this.instanceTag;
                Home home52222 = Home.this;
                mutex3 = home52222.cachedOAuthTokenLock;
                this.L$0 = str2;
                this.L$1 = ref$ObjectRef3;
                this.L$2 = mutex3;
                this.L$3 = home52222;
                this.label = 5;
                if (mutex3.lock(null, this) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.google.home.Home$requestPermissions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.home.Home", f = "Home.kt", l = {459, 463, 838, 849, 470}, m = "requestPermissions")
    public static final class C20681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C20681(Continuation<? super C20681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Home.this.requestPermissions(false, this);
        }
    }

    public Home(Context context, PermissionsClient permissionsClient, AuthorizationClient authorizationClient, HomeConfig homeConfig, GoogleApiAvailabilityLight googleApiAvailabilityLight, PermissionsUiManager permissionsUiManager, GoogleSignInAccount googleSignInAccount, HomeManager homeManager) {
        PermissionsUiManager permissionsUiManager2 = permissionsUiManager;
        HomeManager homeManager2 = homeManager;
        context.getClass();
        permissionsClient.getClass();
        authorizationClient.getClass();
        homeConfig.getClass();
        googleApiAvailabilityLight.getClass();
        this.context = context;
        this.permissionsClient = permissionsClient;
        this.authorizationClient = authorizationClient;
        this.homeConfig = homeConfig;
        this.googleApiAvailability = googleApiAvailabilityLight;
        this.permissionsUiManagerOverride = permissionsUiManager2;
        this.providedAccount = googleSignInAccount;
        this.homeManagerOverride = homeManager2;
        String strConcat = "HomeClient@".concat(String.valueOf(StringsKt__StringsKt.substringAfter$default(toString(), "@", (String) null, 2, (Object) null)));
        this.instanceTag = strConcat;
        this.permissionsType = Companion.PermissionsType.UNINITIALIZED;
        this.interactionClientLock = MutexKt.Mutex$default(false, 1, null);
        this.cachedOAuthTokenLock = MutexKt.Mutex$default(false, 1, null);
        this.tokenRefreshStateFlow = StateFlowKt.MutableStateFlow(Companion.TokenRefreshState.UNKNOWN);
        this.isShutdown = new AtomicBoolean(false);
        MutableStateFlow<InteractionClient> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._interactionClientProvider = MutableStateFlow;
        StateFlow<InteractionClient> stateFlowAsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.interactionClientProvider = stateFlowAsStateFlow;
        this.homeManager = homeManager2 == null ? HomeManagerProvider.INSTANCE.getInstance(stateFlowAsStateFlow, homeConfig, this) : homeManager2;
        this.permissionsUiManager = permissionsUiManager2 == null ? new PermissionsUiManager(context, homeConfig, permissionsClient, authorizationClient, googleApiAvailabilityLight) : permissionsUiManager2;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        Log.i(strConcat, "Initialization job started for Home client.");
        if (googleSignInAccount != null) {
            Log.i(strConcat, "Permissions type set to OAUTH_WITH_ACCOUNT_PROVIDED.");
            this.permissionsType = Companion.PermissionsType.OAUTH_WITH_ACCOUNT_PROVIDED;
            BuildersKt__Builders_commonKt.launch$default(homeConfig.get_scope(), null, null, new Home$initializationJob$1$1(this, completableJobSupervisorJob$default, null), 3, null);
        } else {
            Log.i(strConcat, "Permissions type set to OAUTH.");
            this.permissionsType = Companion.PermissionsType.OAUTH;
            if (googleApiAvailabilityLight.getApkVersion(context) >= 241200000) {
                attemptToInitializeInteractionClient();
            } else {
                Log.w(strConcat, "OAuth permissions not available due to older GMSCore version, cannot instantiate InteractionClient.");
                completableJobSupervisorJob$default.complete();
                Log.i(strConcat, "Initialization job completed for Home client.");
            }
        }
        this.initializationJob = completableJobSupervisorJob$default;
        this.permissionsGrantedJob = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.updateHasPermissionsFlow = new Function1<Boolean, Unit>() { // from class: com.google.home.Home$updateHasPermissionsFlow$1
            {
                super(1);
            }

            public final void invoke(boolean z) {
                if (z) {
                    return;
                }
                this.this$0.tokenRefreshStateFlow.setValue(Home.Companion.TokenRefreshState.TOKEN_FETCH_UNSUCCESSFUL);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
    }

    private final void attemptToInitializeInteractionClient() {
        BuildersKt__Builders_commonKt.launch$default(this.homeConfig.get_scope(), null, null, new AnonymousClass1(null), 3, null);
    }

    private final <T extends HasId> HomeObjectsFlow<T> executeHomeManagerCall(Function1<? super HomeManager, HomeObjectsFlow<T>> call) {
        return HomeObjectsFlowKt.asHomeObjectsFlow(FlowKt.flow(new C20641(call, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.home.Home] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.home.Home, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.google.home.Home, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v9, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.home.Home, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.google.home.Home, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initializeInteractionClientWithProvidedAccount(GoogleSignInAccount googleSignInAccount, Continuation<? super Unit> continuation) {
        C20661 c20661;
        final Account account;
        ?? r10;
        ?? r6;
        Mutex mutex;
        GoogleSignInAccount googleSignInAccount2;
        final AuthorizationResult authorizationResult;
        Mutex mutex2;
        final GoogleSignInAccount googleSignInAccount3;
        final ?? r5;
        Mutex mutex3;
        Function0<InteractionClient> function0;
        Account account2;
        ?? r0;
        if (continuation instanceof C20661) {
            c20661 = (C20661) continuation;
            int i = c20661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20661.label = i - Integer.MIN_VALUE;
            } else {
                c20661 = new C20661(continuation);
            }
        }
        Object obj = c20661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20661.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Account account3 = googleSignInAccount.getAccount();
                account3.getClass();
                PermissionsUiManager permissionsUiManager = this.permissionsUiManager;
                c20661.L$0 = this;
                c20661.L$1 = googleSignInAccount;
                c20661.L$2 = account3;
                c20661.label = 1;
                Object objZzb = permissionsUiManager.zzb(account3, c20661);
                if (objZzb != coroutine_suspended) {
                    account = account3;
                    obj = objZzb;
                    this = this;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    mutex = (Mutex) c20661.L$4;
                    authorizationResult = (AuthorizationResult) c20661.L$3;
                    account = (Account) c20661.L$2;
                    googleSignInAccount2 = (GoogleSignInAccount) c20661.L$1;
                    Home home = (Home) c20661.L$0;
                    ResultKt.throwOnFailure(obj);
                    r6 = home;
                    try {
                        r6.cachedOAuthToken = authorizationResult.getAccessToken();
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        mutex2 = r6.interactionClientLock;
                        c20661.L$0 = r6;
                        c20661.L$1 = googleSignInAccount2;
                        c20661.L$2 = account;
                        c20661.L$3 = authorizationResult;
                        c20661.L$4 = mutex2;
                        c20661.label = 3;
                        if (mutex2.lock(null, c20661) != coroutine_suspended) {
                            googleSignInAccount3 = googleSignInAccount2;
                            r5 = r6;
                            mutex3 = mutex2;
                            function0 = new Function0<InteractionClient>() { // from class: com.google.home.Home$initializeInteractionClientWithProvidedAccount$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final InteractionClient invoke() {
                                    Context context = this.this$0.context;
                                    InteractionOptions interactionOptionsZzc = InteractionOptions.zzc(new InteractionOptions(1, null, null, null), 0, googleSignInAccount3, authorizationResult.getAccessToken(), null, 9, null);
                                    Home home2 = this.this$0;
                                    return new InternalInteractionClient(context, interactionOptionsZzc, null, home2.getHomeConfig(), home2.getAuthorizationClient(), account, home2.getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home(), 4, null);
                                }
                            };
                            c20661.L$0 = r5;
                            c20661.L$1 = account;
                            c20661.L$2 = mutex3;
                            c20661.L$3 = null;
                            c20661.L$4 = null;
                            c20661.label = 4;
                            if (r5.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(function0, c20661) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } finally {
                    }
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Mutex mutex4 = (Mutex) c20661.L$2;
                    account2 = (Account) c20661.L$1;
                    Home home2 = (Home) c20661.L$0;
                    ResultKt.throwOnFailure(obj);
                    r0 = home2;
                    this = mutex4;
                    r0.currentAccount = account2;
                    r0.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL);
                    r0.permissionsGrantedJob.complete();
                    this.unlock(null);
                    return Unit.INSTANCE;
                }
                Mutex mutex5 = (Mutex) c20661.L$4;
                authorizationResult = (AuthorizationResult) c20661.L$3;
                account = (Account) c20661.L$2;
                googleSignInAccount3 = (GoogleSignInAccount) c20661.L$1;
                Home home3 = (Home) c20661.L$0;
                ResultKt.throwOnFailure(obj);
                r5 = home3;
                mutex3 = mutex5;
                function0 = new Function0<InteractionClient>() { // from class: com.google.home.Home$initializeInteractionClientWithProvidedAccount$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InteractionClient invoke() {
                        Context context = this.this$0.context;
                        InteractionOptions interactionOptionsZzc = InteractionOptions.zzc(new InteractionOptions(1, null, null, null), 0, googleSignInAccount3, authorizationResult.getAccessToken(), null, 9, null);
                        Home home22 = this.this$0;
                        return new InternalInteractionClient(context, interactionOptionsZzc, null, home22.getHomeConfig(), home22.getAuthorizationClient(), account, home22.getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home(), 4, null);
                    }
                };
                c20661.L$0 = r5;
                c20661.L$1 = account;
                c20661.L$2 = mutex3;
                c20661.L$3 = null;
                c20661.L$4 = null;
                c20661.label = 4;
                if (r5.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(function0, c20661) != coroutine_suspended) {
                    account2 = account;
                    r0 = r5;
                    this = mutex3;
                    r0.currentAccount = account2;
                    r0.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL);
                    r0.permissionsGrantedJob.complete();
                    this.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            Account account4 = (Account) c20661.L$2;
            googleSignInAccount = (GoogleSignInAccount) c20661.L$1;
            Home home4 = (Home) c20661.L$0;
            ResultKt.throwOnFailure(obj);
            account = account4;
            r10 = home4;
            AuthorizationResult authorizationResult2 = (AuthorizationResult) obj;
            if (authorizationResult2.getAccessToken() == null) {
                Log.e(r10.instanceTag, "OAuth token for provided account is null.");
                r10.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_UNSUCCESSFUL);
                return Unit.INSTANCE;
            }
            Log.i(r10.instanceTag, "OAuth token for provided account is non-null.");
            Mutex mutex6 = r10.cachedOAuthTokenLock;
            c20661.L$0 = r10;
            c20661.L$1 = googleSignInAccount;
            c20661.L$2 = account;
            c20661.L$3 = authorizationResult2;
            c20661.L$4 = mutex6;
            c20661.label = 2;
            if (mutex6.lock(null, c20661) != coroutine_suspended) {
                r6 = r10;
                mutex = mutex6;
                googleSignInAccount2 = googleSignInAccount;
                authorizationResult = authorizationResult2;
                r6.cachedOAuthToken = authorizationResult.getAccessToken();
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                mutex2 = r6.interactionClientLock;
                c20661.L$0 = r6;
                c20661.L$1 = googleSignInAccount2;
                c20661.L$2 = account;
                c20661.L$3 = authorizationResult;
                c20661.L$4 = mutex2;
                c20661.label = 3;
                if (mutex2.lock(null, c20661) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void throwHomeExceptionIfShutdown() throws HomeException {
        if (this.isShutdown.get()) {
            throw HomeException.INSTANCE.failedPrecondition("This Home client has been shutdown and is no longer usable.");
        }
    }

    @Override // com.google.home.HomeClient
    public HomeObjectsFlow<HomeDevice> devices() {
        return executeHomeManagerCall(C20631.INSTANCE);
    }

    /* JADX INFO: renamed from: getAuthorizationClient$java_com_google_android_gmscore_integ_client_home_home, reason: from getter */
    public final AuthorizationClient getAuthorizationClient() {
        return this.authorizationClient;
    }

    /* JADX INFO: renamed from: getHomeConfig$java_com_google_android_gmscore_integ_client_home_home, reason: from getter */
    public final HomeConfig getHomeConfig() {
        return this.homeConfig;
    }

    /* JADX INFO: renamed from: getHomeManager$java_com_google_android_gmscore_integ_client_home_home, reason: from getter */
    public final HomeManager getHomeManager() {
        return this.homeManager;
    }

    /* JADX INFO: renamed from: getPermissionsClient$java_com_google_android_gmscore_integ_client_home_home, reason: from getter */
    public final PermissionsClient getPermissionsClient() {
        return this.permissionsClient;
    }

    /* JADX INFO: renamed from: getPermissionsUiManager$java_com_google_android_gmscore_integ_client_home_home, reason: from getter */
    public final PermissionsUiManager getPermissionsUiManager() {
        return this.permissionsUiManager;
    }

    public final Function1<Boolean, Unit> getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home() {
        return this.updateHasPermissionsFlow;
    }

    @Override // com.google.home.HomeClient
    public Flow<PermissionsState> hasPermissions() {
        return FlowKt.flow(new C20651(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.gms.internal.serialization.zzrn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object refreshToken(Continuation<? super String> continuation) {
        C20671 c20671;
        Mutex mutex;
        if (continuation instanceof C20671) {
            c20671 = (C20671) continuation;
            int i = c20671.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20671.label = i - Integer.MIN_VALUE;
            } else {
                c20671 = new C20671(continuation);
            }
        }
        Object obj = c20671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20671.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Log.i(this.instanceTag, "Attempting to refresh the OAuth Token.");
                mutex = this.interactionClientLock;
                c20671.L$0 = this;
                c20671.L$1 = mutex;
                c20671.label = 1;
                if (mutex.lock(null, c20671) != coroutine_suspended) {
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Mutex mutex2 = (Mutex) c20671.L$1;
            Home home = (Home) c20671.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = home;
            Account account = this.currentAccount;
            if (account == null) {
                this.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.UNKNOWN);
                return "";
            }
            CoroutineContext coroutineContext = this.homeConfig.get_scope().getCoroutineContext();
            AnonymousClass2 anonymousClass2 = this.new AnonymousClass2(account, null);
            c20671.L$0 = null;
            c20671.L$1 = null;
            c20671.label = 2;
            Object objWithContext = BuildersKt.withContext(coroutineContext, anonymousClass2, c20671);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        } finally {
            mutex.unlock(null);
        }
    }

    @Override // com.google.home.HomeClient
    public void registerActivityResultCallerForPermissions(ActivityResultCaller permissionsLauncher) throws HomeException {
        permissionsLauncher.getClass();
        throwHomeExceptionIfShutdown();
        this.permissionsUiManager.zza(permissionsLauncher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.google.android.gms.home.internal.PermissionsUiManager] */
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
    @Override // com.google.home.HomeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object requestPermissions(boolean z, Continuation<? super PermissionsResult> continuation) throws HomeException {
        C20681 c20681;
        ?? r1;
        PermissionsResultWithInfo permissionsResultWithInfo;
        zzbn oauthInfo;
        Mutex mutex;
        Home home;
        Mutex mutex2;
        Mutex mutex3;
        final zzbn zzbnVar;
        final Home home2;
        Function0<InteractionClient> function0;
        PermissionsResultWithInfo permissionsResultWithInfo2;
        Home home3;
        Home home4 = this;
        ?? r12 = z;
        if (continuation instanceof C20681) {
            c20681 = (C20681) continuation;
            int i = c20681.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20681.label = i - Integer.MIN_VALUE;
            } else {
                c20681 = home4.new C20681(continuation);
            }
        }
        Object objZzc = c20681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20681.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzc);
                String str = home4.instanceTag;
                ?? sb = new StringBuilder(String.valueOf((boolean) r12).length() + 44);
                sb.append("requestPermissions called with forceLaunch: ");
                sb.append(r12);
                Log.i(str, sb.toString());
                CompletableJob completableJob = home4.initializationJob;
                c20681.L$0 = home4;
                c20681.Z$0 = r12;
                c20681.label = 1;
                r1 = r12;
                if (completableJob.join(c20681) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    home4 = (Home) c20681.L$0;
                    ResultKt.throwOnFailure(objZzc);
                    permissionsResultWithInfo = (PermissionsResultWithInfo) objZzc;
                    if (permissionsResultWithInfo.getPermissionsResult().getStatus() == PermissionsResultStatus.SUCCESS) {
                        oauthInfo = permissionsResultWithInfo.getOauthInfo();
                        oauthInfo.getClass();
                        mutex = home4.cachedOAuthTokenLock;
                        c20681.L$0 = home4;
                        c20681.L$1 = permissionsResultWithInfo;
                        c20681.L$2 = oauthInfo;
                        c20681.L$3 = mutex;
                        c20681.label = 3;
                        if (mutex.lock(null, c20681) != coroutine_suspended) {
                            home = home4;
                            home.cachedOAuthToken = oauthInfo.getZzb();
                            Unit unit = Unit.INSTANCE;
                            mutex.unlock(null);
                            mutex2 = home.interactionClientLock;
                            c20681.L$0 = home;
                            c20681.L$1 = permissionsResultWithInfo;
                            c20681.L$2 = oauthInfo;
                            c20681.L$3 = mutex2;
                            c20681.label = 4;
                            if (mutex2.lock(null, c20681) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return permissionsResultWithInfo.getPermissionsResult();
                }
                if (i2 == 3) {
                    Mutex mutex4 = (Mutex) c20681.L$3;
                    oauthInfo = (zzbn) c20681.L$2;
                    permissionsResultWithInfo = (PermissionsResultWithInfo) c20681.L$1;
                    home = (Home) c20681.L$0;
                    ResultKt.throwOnFailure(objZzc);
                    mutex = mutex4;
                    try {
                        home.cachedOAuthToken = oauthInfo.getZzb();
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock(null);
                        mutex2 = home.interactionClientLock;
                        c20681.L$0 = home;
                        c20681.L$1 = permissionsResultWithInfo;
                        c20681.L$2 = oauthInfo;
                        c20681.L$3 = mutex2;
                        c20681.label = 4;
                        if (mutex2.lock(null, c20681) != coroutine_suspended) {
                            zzbn zzbnVar2 = oauthInfo;
                            mutex3 = mutex2;
                            zzbnVar = zzbnVar2;
                            home2 = home;
                            function0 = new Function0<InteractionClient>() { // from class: com.google.home.Home$requestPermissions$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final InteractionClient invoke() {
                                    Context context = this.this$0.context;
                                    InteractionOptions interactionOptions = new InteractionOptions(1, null, null, null);
                                    zzbn zzbnVar3 = zzbnVar;
                                    InteractionOptions interactionOptionsZzc = InteractionOptions.zzc(interactionOptions, 0, null, zzbnVar3.getZzb(), zzbnVar3.getZzc(), 3, null);
                                    Home home5 = this.this$0;
                                    return new InternalInteractionClient(context, interactionOptionsZzc, null, home5.getHomeConfig(), home5.getAuthorizationClient(), zzbnVar.getZza(), home5.getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home(), 4, null);
                                }
                            };
                            c20681.L$0 = home2;
                            c20681.L$1 = permissionsResultWithInfo;
                            c20681.L$2 = zzbnVar;
                            c20681.L$3 = mutex3;
                            c20681.label = 5;
                            if (home2.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(function0, c20681) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } finally {
                    }
                }
                if (i2 != 4) {
                    if (i2 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Mutex mutex5 = (Mutex) c20681.L$3;
                    zzbnVar = (zzbn) c20681.L$2;
                    permissionsResultWithInfo2 = (PermissionsResultWithInfo) c20681.L$1;
                    home3 = (Home) c20681.L$0;
                    ResultKt.throwOnFailure(objZzc);
                    r12 = mutex5;
                    home3.currentAccount = zzbnVar.getZza();
                    Log.i(home3.instanceTag, "OAuth permissions granted, new InteractionClient instantiated.");
                    home3.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL);
                    home3.permissionsGrantedJob.complete();
                    r12.unlock(null);
                    permissionsResultWithInfo = permissionsResultWithInfo2;
                    return permissionsResultWithInfo.getPermissionsResult();
                }
                Mutex mutex6 = (Mutex) c20681.L$3;
                zzbn zzbnVar3 = (zzbn) c20681.L$2;
                permissionsResultWithInfo = (PermissionsResultWithInfo) c20681.L$1;
                home2 = (Home) c20681.L$0;
                ResultKt.throwOnFailure(objZzc);
                mutex3 = mutex6;
                zzbnVar = zzbnVar3;
                function0 = new Function0<InteractionClient>() { // from class: com.google.home.Home$requestPermissions$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InteractionClient invoke() {
                        Context context = this.this$0.context;
                        InteractionOptions interactionOptions = new InteractionOptions(1, null, null, null);
                        zzbn zzbnVar32 = zzbnVar;
                        InteractionOptions interactionOptionsZzc = InteractionOptions.zzc(interactionOptions, 0, null, zzbnVar32.getZzb(), zzbnVar32.getZzc(), 3, null);
                        Home home5 = this.this$0;
                        return new InternalInteractionClient(context, interactionOptionsZzc, null, home5.getHomeConfig(), home5.getAuthorizationClient(), zzbnVar.getZza(), home5.getUpdateHasPermissionsFlow$java_com_google_android_gmscore_integ_client_home_home(), 4, null);
                    }
                };
                c20681.L$0 = home2;
                c20681.L$1 = permissionsResultWithInfo;
                c20681.L$2 = zzbnVar;
                c20681.L$3 = mutex3;
                c20681.label = 5;
                if (home2.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(function0, c20681) != coroutine_suspended) {
                    permissionsResultWithInfo2 = permissionsResultWithInfo;
                    home3 = home2;
                    r12 = mutex3;
                    home3.currentAccount = zzbnVar.getZza();
                    Log.i(home3.instanceTag, "OAuth permissions granted, new InteractionClient instantiated.");
                    home3.tokenRefreshStateFlow.setValue(Companion.TokenRefreshState.TOKEN_FETCH_SUCCESSFUL);
                    home3.permissionsGrantedJob.complete();
                    r12.unlock(null);
                    permissionsResultWithInfo = permissionsResultWithInfo2;
                    return permissionsResultWithInfo.getPermissionsResult();
                }
                return coroutine_suspended;
            }
            boolean z2 = c20681.Z$0;
            Home home5 = (Home) c20681.L$0;
            ResultKt.throwOnFailure(objZzc);
            r1 = z2;
            home4 = home5;
            home4.throwHomeExceptionIfShutdown();
            Companion.PermissionsType permissionsType = home4.permissionsType;
            Companion.PermissionsType permissionsType2 = Companion.PermissionsType.OAUTH;
            int iOrdinal = permissionsType.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    throw new HomeException(3, "Calls to requestPermissions are not supported when using a provided account.", null, null, 12, null);
                }
                if (iOrdinal == 2) {
                    throw new HomeException(10, "Initialization error, permissions type must be set.", null, null, 12, null);
                }
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            ?? r2 = home4.permissionsUiManager;
            c20681.L$0 = home4;
            c20681.label = 2;
            objZzc = r2.zzc(r1, c20681);
            if (objZzc != coroutine_suspended) {
                permissionsResultWithInfo = (PermissionsResultWithInfo) objZzc;
                if (permissionsResultWithInfo.getPermissionsResult().getStatus() == PermissionsResultStatus.SUCCESS) {
                }
                return permissionsResultWithInfo.getPermissionsResult();
            }
            return coroutine_suspended;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(Function0<? extends InteractionClient> function0, Continuation<? super Unit> continuation) {
        Home$setInteractionClient$1 home$setInteractionClient$1;
        InteractionOptions interactionOptions;
        if (continuation instanceof Home$setInteractionClient$1) {
            home$setInteractionClient$1 = (Home$setInteractionClient$1) continuation;
            int i = home$setInteractionClient$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                home$setInteractionClient$1.label = i - Integer.MIN_VALUE;
            } else {
                home$setInteractionClient$1 = new Home$setInteractionClient$1(this, continuation);
            }
        }
        Object obj = home$setInteractionClient$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = home$setInteractionClient$1.label;
        String zzd = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            InteractionClient value = this.interactionClientProvider.getValue();
            if (value != null) {
                this._interactionClientProvider.setValue(null);
                String str = this.instanceTag;
                StringBuilder sb = new StringBuilder(value.toString().length() + 44);
                sb.append("Shutting down previous InteractionClient - ");
                sb.append(value);
                sb.append(".");
                Log.i(str, sb.toString());
                home$setInteractionClient$1.L$0 = this;
                home$setInteractionClient$1.L$1 = function0;
                home$setInteractionClient$1.label = 1;
                if (((InternalInteractionClient) value).zzb(home$setInteractionClient$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function0 = (Function0) home$setInteractionClient$1.L$1;
            this = (Home) home$setInteractionClient$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        InteractionClient interactionClientInvoke = function0.invoke();
        InternalInteractionClient internalInteractionClient = (InternalInteractionClient) interactionClientInvoke;
        if (internalInteractionClient != null && (interactionOptions = (InteractionOptions) internalInteractionClient.getApiOptions()) != null) {
            zzd = interactionOptions.getZzd();
        }
        if (interactionClientInvoke == null) {
            Log.i(this.instanceTag, "Emitting null InteractionClient.");
        } else {
            String str2 = this.instanceTag;
            String strConcat = (zzd == null || zzd.length() == 0) ? "" : " with clientSessionId ".concat(String.valueOf(zzd));
            StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(interactionClientInvoke.toString().length() + 33, 1, strConcat));
            sb2.append("Emitting new InteractionClient - ");
            sb2.append(interactionClientInvoke);
            sb2.append(strConcat);
            sb2.append(".");
            Log.i(str2, sb2.toString());
        }
        this._interactionClientProvider.setValue(interactionClientInvoke);
        return Unit.INSTANCE;
    }

    public /* synthetic */ Home(Context context, PermissionsClient permissionsClient, AuthorizationClient authorizationClient, HomeConfig homeConfig, GoogleApiAvailabilityLight googleApiAvailabilityLight, PermissionsUiManager permissionsUiManager, GoogleSignInAccount googleSignInAccount, HomeManager homeManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, permissionsClient, (i & 4) != 0 ? new AuthorizationClientImpl(context, Identity.getAuthorizationClient(context)) : authorizationClient, (i & 8) != 0 ? new HomeConfig(false, null, null, 7, null) : homeConfig, (i & 16) != 0 ? GoogleApiAvailabilityLight.getInstance() : googleApiAvailabilityLight, (i & 32) != 0 ? null : permissionsUiManager, (i & 64) != 0 ? null : googleSignInAccount, (i & 128) != 0 ? null : homeManager);
    }
}

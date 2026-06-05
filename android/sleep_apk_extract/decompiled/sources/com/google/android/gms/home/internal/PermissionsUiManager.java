package com.google.android.gms.home.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.IntentCompat;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultCaller;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContracts$StartIntentSenderForResult;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.home.permissions.HomeAccountResult;
import com.google.android.gms.home.permissions.PermissionsClient;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.HomeConfig;
import com.google.home.PermissionsResult;
import com.google.home.PermissionsResultStatus;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.tasks.TasksKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u00002\u00020\u0001:\u0001TB1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0097@¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001fH\u0097@¢\u0006\u0004\b\"\u0010#J(\u0010)\u001a\u0004\u0018\u00010\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010(\u001a\u00020'H\u0082@¢\u0006\u0004\b)\u0010*J(\u0010,\u001a\u0004\u0018\u00010\u001a2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010(\u001a\u00020'H\u0082@¢\u0006\u0004\b,\u0010*J\u001f\u00100\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u00103\u001a\u0004\b4\u00105R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00106R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00107R.\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\"\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010:R.\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bB\u0010:\u0012\u0004\bD\u0010>\u001a\u0004\bC\u0010<R0\u0010E\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010?088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bE\u0010:\u0012\u0004\bG\u0010>\u001a\u0004\bF\u0010<R.\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bH\u0010:\u0012\u0004\bJ\u0010>\u001a\u0004\bI\u0010<R0\u0010K\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010?088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bK\u0010:\u0012\u0004\bM\u0010>\u001a\u0004\bL\u0010<R.\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bN\u0010:\u0012\u0004\bP\u0010>\u001a\u0004\bO\u0010<R.\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010?088\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bQ\u0010:\u0012\u0004\bS\u0010>\u001a\u0004\bR\u0010<¨\u0006U"}, d2 = {"Lcom/google/android/gms/home/internal/PermissionsUiManager;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/google/home/HomeConfig;", "homeConfig", "Lcom/google/android/gms/home/permissions/PermissionsClient;", "permissionsClient", "Lcom/google/android/gms/home/internal/AuthorizationClient;", "authorizationClient", "Lcom/google/android/gms/common/GoogleApiAvailabilityLight;", "googleApiAvailability", "<init>", "(Landroid/content/Context;Lcom/google/home/HomeConfig;Lcom/google/android/gms/home/permissions/PermissionsClient;Lcom/google/android/gms/home/internal/AuthorizationClient;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;)V", "Landroidx/activity/result/ActivityResultCaller;", "permissionsLauncher", "", "registerActivityResultCallerForPermissions", "(Landroidx/activity/result/ActivityResultCaller;)V", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPickerResult;", "generateAccountPickerResultFromIntent", "(Landroid/content/Intent;)Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPickerResult;", "Landroid/accounts/Account;", "account", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "authorizeAccount", "(Landroid/accounts/Account;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "forceLaunch", "Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$PermissionsResultWithInfo;", "requestOauthPermissions", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceLaunchRequestOauthPermissions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "accountPickerLauncher", "Landroid/content/IntentSender;", "intentSender", "launchAccountPickerAndGetResult", "(Landroidx/activity/result/ActivityResultLauncher;Landroid/content/IntentSender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authClientConsentUiLauncher", "launchOauthConsentUiAndGetToken", "activityResultCaller", "setAccountPickerLauncherForTesting$java_com_google_android_gmscore_integ_client_home_home", "(Landroidx/activity/result/ActivityResultCaller;Landroid/content/Intent;)V", "setAccountPickerLauncherForTesting", "Landroid/content/Context;", "Lcom/google/home/HomeConfig;", "Lcom/google/android/gms/home/permissions/PermissionsClient;", "getPermissionsClient$java_com_google_android_gmscore_integ_client_home_home", "()Lcom/google/android/gms/home/permissions/PermissionsClient;", "Lcom/google/android/gms/home/internal/AuthorizationClient;", "Lcom/google/android/gms/common/GoogleApiAvailabilityLight;", "Ljava/util/concurrent/atomic/AtomicReference;", "localPermissionsUiLauncherRef", "Ljava/util/concurrent/atomic/AtomicReference;", "getLocalPermissionsUiLauncherRef$java_com_google_android_gmscore_integ_client_home_home", "()Ljava/util/concurrent/atomic/AtomicReference;", "getLocalPermissionsUiLauncherRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "()V", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/google/home/PermissionsResult;", "localPermissionsUiContinuationRef", "accountPickerLauncherRef", "getAccountPickerLauncherRef$java_com_google_android_gmscore_integ_client_home_home", "getAccountPickerLauncherRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "accountPickerContinuationRef", "getAccountPickerContinuationRef$java_com_google_android_gmscore_integ_client_home_home", "getAccountPickerContinuationRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "authClientConsentUiLauncherRef", "getAuthClientConsentUiLauncherRef$java_com_google_android_gmscore_integ_client_home_home", "getAuthClientConsentUiLauncherRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "authClientConsentUiContinuationRef", "getAuthClientConsentUiContinuationRef$java_com_google_android_gmscore_integ_client_home_home", "getAuthClientConsentUiContinuationRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "permissionsClientConsentUiLauncherRef", "getPermissionsClientConsentUiLauncherRef$java_com_google_android_gmscore_integ_client_home_home", "getPermissionsClientConsentUiLauncherRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "permissionsClientConsentUiContinuationRef", "getPermissionsClientConsentUiContinuationRef$java_com_google_android_gmscore_integ_client_home_home", "getPermissionsClientConsentUiContinuationRef$java_com_google_android_gmscore_integ_client_home_home$annotations", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PermissionsUiManager {
    private final Context zza;
    private final HomeConfig zzb;
    private final PermissionsClient zzc;
    private final AuthorizationClient zzd;
    private final GoogleApiAvailabilityLight zze;
    private final AtomicReference zzf;
    private final AtomicReference zzg;
    private final AtomicReference zzh;
    private final AtomicReference zzi;
    private final AtomicReference zzj;
    private final AtomicReference zzk;
    private final AtomicReference zzl;
    private final AtomicReference zzm;

    public PermissionsUiManager(Context context, HomeConfig homeConfig, PermissionsClient permissionsClient, AuthorizationClient authorizationClient, GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        context.getClass();
        homeConfig.getClass();
        permissionsClient.getClass();
        authorizationClient.getClass();
        googleApiAvailabilityLight.getClass();
        this.zza = context;
        this.zzb = homeConfig;
        this.zzc = permissionsClient;
        this.zzd = authorizationClient;
        this.zze = googleApiAvailabilityLight;
        this.zzf = new AtomicReference(null);
        this.zzg = new AtomicReference(null);
        this.zzh = new AtomicReference(null);
        this.zzi = new AtomicReference(null);
        this.zzj = new AtomicReference(null);
        this.zzk = new AtomicReference(null);
        this.zzl = new AtomicReference(null);
        this.zzm = new AtomicReference(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x025d, code lost:
    
        if (r11 != r1) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object zzd(PermissionsUiManager permissionsUiManager, boolean z, Continuation continuation) {
        zzbs zzbsVar;
        ActivityResultLauncher activityResultLauncher;
        HomeAccountResult homeAccountResult;
        PermissionsUiManager permissionsUiManager2;
        ActivityResultLauncher activityResultLauncher2;
        PermissionsUiManager permissionsUiManager3;
        HomeAccountResult homeAccountResult2;
        Object obj;
        PermissionsUiManager permissionsUiManager4;
        PermissionsUiManager permissionsUiManager5;
        AccountPickerResult accountPickerResult;
        AuthorizationResult authorizationResult;
        AccountPickerResult accountPickerResult2;
        AuthorizationResult authorizationResult2;
        if (continuation instanceof zzbs) {
            zzbsVar = (zzbs) continuation;
            int i = zzbsVar.zzf;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbsVar.zzf = i - Integer.MIN_VALUE;
            } else {
                zzbsVar = new zzbs(permissionsUiManager, continuation);
            }
        }
        Object objZza = zzbsVar.zzd;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (zzbsVar.zzf) {
            case 0:
                ResultKt.throwOnFailure(objZza);
                StringBuilder sb = new StringBuilder(String.valueOf(z).length() + 49);
                sb.append("requesting OAuth permissions with forceLaunch = ");
                sb.append(z);
                sb.append(".");
                Log.i("PermissionsUiManager", sb.toString());
                if (z) {
                    if (permissionsUiManager.zze.getApkVersion(permissionsUiManager.zza) >= 242500000) {
                        zzbsVar.zzf = 1;
                        Object objZze = zze(permissionsUiManager, zzbsVar);
                        return objZze == coroutine_suspended ? coroutine_suspended : objZze;
                    }
                    Log.d("PermissionsUiManager", "requestPermissions with forceLaunch = true called, but GMSCore version is not up to date enough. Falling back to requestPermissions with forceLaunch = false.");
                }
                activityResultLauncher = (ActivityResultLauncher) permissionsUiManager.zzh.get();
                if (activityResultLauncher == null) {
                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "No registered launcher."), null);
                }
                PermissionsClient permissionsClient = permissionsUiManager.zzc;
                zzbsVar.zza = permissionsUiManager;
                zzbsVar.zzb = activityResultLauncher;
                zzbsVar.zzf = 2;
                objZza = permissionsClient.zza(zzbsVar);
                if (objZza != coroutine_suspended) {
                    homeAccountResult = (HomeAccountResult) objZza;
                    if (homeAccountResult.getZza() == null) {
                        Account zza = homeAccountResult.getZza();
                        zzbsVar.zza = permissionsUiManager;
                        zzbsVar.zzb = activityResultLauncher;
                        zzbsVar.zzc = homeAccountResult;
                        zzbsVar.zzf = 3;
                        Object objZzb = permissionsUiManager.zzb(zza, zzbsVar);
                        if (objZzb != coroutine_suspended) {
                            permissionsUiManager3 = permissionsUiManager;
                            homeAccountResult2 = homeAccountResult;
                            objZza = objZzb;
                            authorizationResult = (AuthorizationResult) objZza;
                            if (authorizationResult.getAccessToken() == null) {
                                PermissionsResult permissionsResult = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
                                Account zza2 = homeAccountResult2.getZza();
                                String accessToken = authorizationResult.getAccessToken();
                                accessToken.getClass();
                                return new PermissionsResultWithInfo(permissionsResult, new zzbn(zza2, accessToken, homeAccountResult2.getZzc()));
                            }
                            homeAccountResult = homeAccountResult2;
                            activityResultLauncher2 = activityResultLauncher;
                            permissionsUiManager2 = permissionsUiManager3;
                            if (permissionsUiManager2.zze.getApkVersion(permissionsUiManager2.zza) < 242500000) {
                                PermissionsClient permissionsClient2 = permissionsUiManager2.zzc;
                                zzbsVar.zza = permissionsUiManager2;
                                zzbsVar.zzb = permissionsUiManager2;
                                zzbsVar.zzc = activityResultLauncher2;
                                zzbsVar.zzf = 5;
                                Object objZzb2 = permissionsClient2.zzb(zzbsVar);
                                if (objZzb2 != coroutine_suspended) {
                                    obj = objZzb2;
                                    permissionsUiManager4 = permissionsUiManager2;
                                    zzbsVar.zza = permissionsUiManager2;
                                    zzbsVar.zzb = null;
                                    zzbsVar.zzc = null;
                                    zzbsVar.zzf = 6;
                                    objZza = permissionsUiManager4.zzk(activityResultLauncher2, (IntentSender) obj, zzbsVar);
                                    if (objZza != coroutine_suspended) {
                                        permissionsUiManager5 = permissionsUiManager2;
                                        accountPickerResult2 = (AccountPickerResult) objZza;
                                        AccountPickerResult accountPickerResult3 = accountPickerResult2;
                                        permissionsUiManager2 = permissionsUiManager5;
                                        accountPickerResult = accountPickerResult3;
                                        if (accountPickerResult == null) {
                                        }
                                    }
                                }
                            } else if (homeAccountResult.getZza() != null) {
                                accountPickerResult = new AccountPickerResult(homeAccountResult.getZza(), homeAccountResult.getZzc());
                                if (accountPickerResult == null) {
                                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled account picker."), null);
                                }
                                if (accountPickerResult.getAccount() == null) {
                                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled account picker."), null);
                                }
                                Account account = accountPickerResult.getAccount();
                                zzbsVar.zza = permissionsUiManager2;
                                zzbsVar.zzb = accountPickerResult;
                                zzbsVar.zzc = null;
                                zzbsVar.zzf = 7;
                                objZza = permissionsUiManager2.zzb(account, zzbsVar);
                                if (objZza != coroutine_suspended) {
                                    authorizationResult2 = (AuthorizationResult) objZza;
                                    if (authorizationResult2.getAccessToken() == null) {
                                        PermissionsResult permissionsResult2 = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
                                        Account account2 = accountPickerResult.getAccount();
                                        String accessToken2 = authorizationResult2.getAccessToken();
                                        accessToken2.getClass();
                                        return new PermissionsResultWithInfo(permissionsResult2, new zzbn(account2, accessToken2, accountPickerResult.getClientSessionId()));
                                    }
                                    PendingIntent pendingIntent = authorizationResult2.getPendingIntent();
                                    IntentSender intentSender = pendingIntent != null ? pendingIntent.getIntentSender() : null;
                                    if (intentSender == null) {
                                        return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "Failed to get intent sender."), null);
                                    }
                                    ActivityResultLauncher activityResultLauncher3 = (ActivityResultLauncher) permissionsUiManager2.zzj.get();
                                    if (activityResultLauncher3 == null) {
                                        return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "No registered launcher."), null);
                                    }
                                    zzbsVar.zza = accountPickerResult;
                                    zzbsVar.zzb = null;
                                    zzbsVar.zzf = 8;
                                    objZza = permissionsUiManager2.zzl(activityResultLauncher3, intentSender, zzbsVar);
                                }
                                break;
                            } else {
                                IntentSender zzb = homeAccountResult.getZzb();
                                if (zzb == null) {
                                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "Invalid result from PermissionsClient."), null);
                                }
                                zzbsVar.zza = permissionsUiManager2;
                                zzbsVar.zzb = null;
                                zzbsVar.zzc = null;
                                zzbsVar.zzf = 4;
                                objZza = permissionsUiManager2.zzk(activityResultLauncher2, zzb, zzbsVar);
                                if (objZza != coroutine_suspended) {
                                    permissionsUiManager5 = permissionsUiManager2;
                                    accountPickerResult2 = (AccountPickerResult) objZza;
                                    AccountPickerResult accountPickerResult32 = accountPickerResult2;
                                    permissionsUiManager2 = permissionsUiManager5;
                                    accountPickerResult = accountPickerResult32;
                                    if (accountPickerResult == null) {
                                    }
                                }
                            }
                        }
                    } else {
                        ActivityResultLauncher activityResultLauncher4 = activityResultLauncher;
                        permissionsUiManager2 = permissionsUiManager;
                        activityResultLauncher2 = activityResultLauncher4;
                        if (permissionsUiManager2.zze.getApkVersion(permissionsUiManager2.zza) < 242500000) {
                        }
                    }
                }
            case 1:
                ResultKt.throwOnFailure(objZza);
                return objZza;
            case 2:
                ActivityResultLauncher activityResultLauncher5 = (ActivityResultLauncher) zzbsVar.zzb;
                PermissionsUiManager permissionsUiManager6 = (PermissionsUiManager) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                activityResultLauncher = activityResultLauncher5;
                permissionsUiManager = permissionsUiManager6;
                homeAccountResult = (HomeAccountResult) objZza;
                if (homeAccountResult.getZza() == null) {
                }
                break;
            case 3:
                homeAccountResult2 = (HomeAccountResult) zzbsVar.zzc;
                activityResultLauncher = (ActivityResultLauncher) zzbsVar.zzb;
                permissionsUiManager3 = (PermissionsUiManager) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                authorizationResult = (AuthorizationResult) objZza;
                if (authorizationResult.getAccessToken() == null) {
                }
                break;
            case 4:
                permissionsUiManager5 = (PermissionsUiManager) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                accountPickerResult2 = (AccountPickerResult) objZza;
                AccountPickerResult accountPickerResult322 = accountPickerResult2;
                permissionsUiManager2 = permissionsUiManager5;
                accountPickerResult = accountPickerResult322;
                if (accountPickerResult == null) {
                }
                break;
            case 5:
                activityResultLauncher2 = (ActivityResultLauncher) zzbsVar.zzc;
                PermissionsUiManager permissionsUiManager7 = (PermissionsUiManager) zzbsVar.zzb;
                PermissionsUiManager permissionsUiManager8 = (PermissionsUiManager) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                permissionsUiManager4 = permissionsUiManager7;
                permissionsUiManager2 = permissionsUiManager8;
                obj = objZza;
                zzbsVar.zza = permissionsUiManager2;
                zzbsVar.zzb = null;
                zzbsVar.zzc = null;
                zzbsVar.zzf = 6;
                objZza = permissionsUiManager4.zzk(activityResultLauncher2, (IntentSender) obj, zzbsVar);
                if (objZza != coroutine_suspended) {
                }
            case 6:
                permissionsUiManager5 = (PermissionsUiManager) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                accountPickerResult2 = (AccountPickerResult) objZza;
                AccountPickerResult accountPickerResult3222 = accountPickerResult2;
                permissionsUiManager2 = permissionsUiManager5;
                accountPickerResult = accountPickerResult3222;
                if (accountPickerResult == null) {
                }
                break;
            case 7:
                accountPickerResult = (AccountPickerResult) zzbsVar.zzb;
                permissionsUiManager2 = (PermissionsUiManager) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                authorizationResult2 = (AuthorizationResult) objZza;
                if (authorizationResult2.getAccessToken() == null) {
                }
                break;
            case 8:
                accountPickerResult = (AccountPickerResult) zzbsVar.zza;
                ResultKt.throwOnFailure(objZza);
                AuthorizationResult authorizationResult3 = (AuthorizationResult) objZza;
                if (authorizationResult3 == null) {
                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled OAuth consent UI."), null);
                }
                if (authorizationResult3.getAccessToken() == null) {
                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "Failed to get OAuth token."), null);
                }
                PermissionsResult permissionsResult3 = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
                Account account3 = accountPickerResult.getAccount();
                String accessToken3 = authorizationResult3.getAccessToken();
                accessToken3.getClass();
                return new PermissionsResultWithInfo(permissionsResult3, new zzbn(account3, accessToken3, accountPickerResult.getClientSessionId()));
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0164 A[PHI: r2 r8 r9 r10
      0x0164: PHI (r2v14 kotlin.jvm.internal.Ref$ObjectRef) = (r2v12 kotlin.jvm.internal.Ref$ObjectRef), (r2v20 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:40:0x0138, B:44:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0164: PHI (r8v9 android.accounts.Account) = (r8v6 android.accounts.Account), (r8v11 android.accounts.Account) binds: [B:40:0x0138, B:44:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0164: PHI (r9v6 com.google.android.gms.home.internal.zzbo) = (r9v3 com.google.android.gms.home.internal.zzbo), (r9v7 com.google.android.gms.home.internal.zzbo) binds: [B:40:0x0138, B:44:0x0162] A[DONT_GENERATE, DONT_INLINE]
      0x0164: PHI (r10v5 com.google.android.gms.home.internal.PermissionsUiManager) = 
      (r10v2 com.google.android.gms.home.internal.PermissionsUiManager)
      (r10v8 com.google.android.gms.home.internal.PermissionsUiManager)
     binds: [B:40:0x0138, B:44:0x0162] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object zze(PermissionsUiManager permissionsUiManager, Continuation continuation) {
        zzbq zzbqVar;
        ActivityResultLauncher activityResultLauncher;
        PermissionsUiManager permissionsUiManager2;
        Object obj;
        Object objZzk;
        PermissionsUiManager permissionsUiManager3;
        Object obj2;
        AccountPickerResult accountPickerResult;
        AccountPickerResult accountPickerResult2;
        T t;
        PermissionsUiManager permissionsUiManager4;
        Ref$ObjectRef ref$ObjectRef;
        Account account;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Account account2;
        PermissionsUiManager permissionsUiManager5;
        IntentSender intentSender;
        AccountPickerResult accountPickerResult3;
        ActivityResultLauncher activityResultLauncher2;
        Account account3;
        Ref$ObjectRef ref$ObjectRef4;
        AccountPickerResult accountPickerResult4;
        T t2;
        Object obj3;
        CancellableContinuationImpl cancellableContinuationImpl;
        AtomicReference atomicReference;
        Object result;
        Account account4;
        AccountPickerResult accountPickerResult5;
        Object obj4;
        Boolean bool;
        Object obj5;
        AuthorizationResult authorizationResult;
        if (continuation instanceof zzbq) {
            zzbqVar = (zzbq) continuation;
            int i = zzbqVar.zzh;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbqVar.zzh = i - Integer.MIN_VALUE;
            } else {
                zzbqVar = new zzbq(permissionsUiManager, continuation);
            }
        }
        Object obj6 = zzbqVar.zzf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (zzbqVar.zzh) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                Log.i("PermissionsUiManager", "requesting OAuth permissions with forceLaunch = true.");
                activityResultLauncher = (ActivityResultLauncher) permissionsUiManager.zzh.get();
                if (activityResultLauncher == null) {
                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "No registered launcher."), null);
                }
                PermissionsClient permissionsClient = permissionsUiManager.zzc;
                zzbqVar.zza = permissionsUiManager;
                zzbqVar.zzb = permissionsUiManager;
                zzbqVar.zzc = activityResultLauncher;
                zzbqVar.zzh = 1;
                Object objZzb = permissionsClient.zzb(zzbqVar);
                if (objZzb != coroutine_suspended) {
                    permissionsUiManager2 = permissionsUiManager;
                    obj = objZzb;
                    zzbqVar.zza = permissionsUiManager2;
                    zzbqVar.zzb = null;
                    zzbqVar.zzc = null;
                    zzbqVar.zzh = 2;
                    objZzk = permissionsUiManager.zzk(activityResultLauncher, (IntentSender) obj, zzbqVar);
                    if (objZzk != coroutine_suspended) {
                        permissionsUiManager3 = permissionsUiManager2;
                        obj2 = objZzk;
                        accountPickerResult = (AccountPickerResult) obj2;
                        Account account5 = accountPickerResult == null ? accountPickerResult.getAccount() : null;
                        if (accountPickerResult != null || account5 == null) {
                            return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled account picker."), null);
                        }
                        Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
                        zzbqVar.zza = permissionsUiManager3;
                        zzbqVar.zzb = accountPickerResult;
                        zzbqVar.zzc = account5;
                        zzbqVar.zzi = ref$ObjectRef5;
                        zzbqVar.zzd = ref$ObjectRef5;
                        zzbqVar.zzh = 3;
                        Object objZzb2 = permissionsUiManager3.zzb(account5, zzbqVar);
                        if (objZzb2 != coroutine_suspended) {
                            accountPickerResult2 = accountPickerResult;
                            t = objZzb2;
                            permissionsUiManager4 = permissionsUiManager3;
                            ref$ObjectRef = ref$ObjectRef5;
                            account = account5;
                            ref$ObjectRef2 = ref$ObjectRef;
                            ref$ObjectRef.element = t;
                            if (((AuthorizationResult) ref$ObjectRef2.element).getAccessToken() == null) {
                                Log.i("PermissionsUiManager", "Clearing cached token.");
                                CoroutineContext coroutineContext = permissionsUiManager4.zzb.get_scope().getCoroutineContext();
                                zzbr zzbrVar = new zzbr(permissionsUiManager4, ref$ObjectRef2, account, null);
                                zzbqVar.zza = permissionsUiManager4;
                                zzbqVar.zzb = accountPickerResult2;
                                zzbqVar.zzc = account;
                                zzbqVar.zzi = ref$ObjectRef2;
                                zzbqVar.zzd = ref$ObjectRef2;
                                zzbqVar.zzh = 4;
                                Object objWithContext = BuildersKt.withContext(coroutineContext, zzbrVar, zzbqVar);
                                if (objWithContext != coroutine_suspended) {
                                    ref$ObjectRef3 = ref$ObjectRef2;
                                    t2 = objWithContext;
                                    ref$ObjectRef3.element = t2;
                                    account2 = account;
                                    permissionsUiManager5 = permissionsUiManager4;
                                    PendingIntent pendingIntent = ((AuthorizationResult) ref$ObjectRef2.element).getPendingIntent();
                                    intentSender = pendingIntent != null ? pendingIntent.getIntentSender() : null;
                                    if (intentSender != null) {
                                        ActivityResultLauncher activityResultLauncher3 = (ActivityResultLauncher) permissionsUiManager5.zzj.get();
                                        if (activityResultLauncher3 == null) {
                                            return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "No registered launcher."), null);
                                        }
                                        zzbqVar.zza = accountPickerResult2;
                                        zzbqVar.zzb = account2;
                                        zzbqVar.zzc = null;
                                        zzbqVar.zzi = null;
                                        zzbqVar.zzd = null;
                                        zzbqVar.zzh = 7;
                                        Object objZzl = permissionsUiManager5.zzl(activityResultLauncher3, intentSender, zzbqVar);
                                        if (objZzl != coroutine_suspended) {
                                            accountPickerResult3 = accountPickerResult2;
                                            obj5 = objZzl;
                                            authorizationResult = (AuthorizationResult) obj5;
                                            if (authorizationResult != null) {
                                                return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled OAuth consent UI."), null);
                                            }
                                            if (authorizationResult.getAccessToken() == null) {
                                                return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "Failed to get OAuth token."), null);
                                            }
                                            PermissionsResult permissionsResult = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
                                            String accessToken = authorizationResult.getAccessToken();
                                            accessToken.getClass();
                                            return new PermissionsResultWithInfo(permissionsResult, new zzbn(account2, accessToken, accountPickerResult3.getClientSessionId()));
                                        }
                                    } else {
                                        if (permissionsUiManager5.zze.getApkVersion(permissionsUiManager5.zza) < 243200000) {
                                            Log.i("PermissionsUiManager", "authClientIntentSender is null, cannot launch consent screen. Using previously granted permissions.");
                                            PermissionsResult permissionsResult2 = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
                                            String accessToken2 = ((AuthorizationResult) ref$ObjectRef2.element).getAccessToken();
                                            accessToken2.getClass();
                                            return new PermissionsResultWithInfo(permissionsResult2, new zzbn(account2, accessToken2, accountPickerResult2.getClientSessionId()));
                                        }
                                        Log.i("PermissionsUiManager", "authClientIntentSender is null, using consent screen from PermissionsClient.");
                                        activityResultLauncher2 = (ActivityResultLauncher) permissionsUiManager5.zzl.get();
                                        if (activityResultLauncher2 == null) {
                                            return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "No registered launcher."), null);
                                        }
                                        PermissionsClient permissionsClient2 = permissionsUiManager5.zzc;
                                        zzbqVar.zza = permissionsUiManager5;
                                        zzbqVar.zzb = accountPickerResult2;
                                        zzbqVar.zzc = account2;
                                        zzbqVar.zzi = ref$ObjectRef2;
                                        zzbqVar.zzd = activityResultLauncher2;
                                        zzbqVar.zzh = 5;
                                        Object objZzc = permissionsClient2.zzc(account2, zzbqVar);
                                        if (objZzc != coroutine_suspended) {
                                            Ref$ObjectRef ref$ObjectRef6 = ref$ObjectRef2;
                                            account3 = account2;
                                            ref$ObjectRef4 = ref$ObjectRef6;
                                            accountPickerResult4 = accountPickerResult2;
                                            obj3 = objZzc;
                                            IntentSender intentSender2 = (IntentSender) obj3;
                                            zzbqVar.zza = permissionsUiManager5;
                                            zzbqVar.zzb = accountPickerResult4;
                                            zzbqVar.zzc = account3;
                                            zzbqVar.zzi = ref$ObjectRef4;
                                            zzbqVar.zzd = activityResultLauncher2;
                                            zzbqVar.zze = intentSender2;
                                            zzbqVar.zzh = 6;
                                            cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(zzbqVar), 1);
                                            cancellableContinuationImpl.initCancellability();
                                            atomicReference = permissionsUiManager5.zzm;
                                            while (true) {
                                                if (!atomicReference.compareAndSet(null, cancellableContinuationImpl)) {
                                                    if (atomicReference.get() != null) {
                                                        cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(null));
                                                    }
                                                }
                                            }
                                            activityResultLauncher2.launch(new IntentSenderRequest.Builder(intentSender2).build());
                                            result = cancellableContinuationImpl.getResult();
                                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                DebugProbesKt.probeCoroutineSuspended(zzbqVar);
                                            }
                                            if (result != coroutine_suspended) {
                                                account4 = account3;
                                                accountPickerResult5 = accountPickerResult4;
                                                obj4 = result;
                                                bool = (Boolean) obj4;
                                                if (bool != null) {
                                                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.ERROR, "Cannot launch multiple consent UIs."), null);
                                                }
                                                if (Intrinsics.areEqual(bool, Boxing.boxBoolean(false))) {
                                                    return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled consent screen."), null);
                                                }
                                                if (!Intrinsics.areEqual(bool, Boxing.boxBoolean(true))) {
                                                    Home$$ExternalSyntheticBUOutline0.m();
                                                    return null;
                                                }
                                                PermissionsResult permissionsResult3 = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
                                                String accessToken3 = ((AuthorizationResult) ref$ObjectRef4.element).getAccessToken();
                                                accessToken3.getClass();
                                                return new PermissionsResultWithInfo(permissionsResult3, new zzbn(account4, accessToken3, accountPickerResult5.getClientSessionId()));
                                            }
                                        }
                                    }
                                }
                            } else {
                                account2 = account;
                                permissionsUiManager5 = permissionsUiManager4;
                                PendingIntent pendingIntent2 = ((AuthorizationResult) ref$ObjectRef2.element).getPendingIntent();
                                if (pendingIntent2 != null) {
                                }
                                if (intentSender != null) {
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                ActivityResultLauncher activityResultLauncher4 = (ActivityResultLauncher) zzbqVar.zzc;
                PermissionsUiManager permissionsUiManager6 = (PermissionsUiManager) zzbqVar.zzb;
                permissionsUiManager2 = (PermissionsUiManager) zzbqVar.zza;
                ResultKt.throwOnFailure(obj6);
                activityResultLauncher = activityResultLauncher4;
                permissionsUiManager = permissionsUiManager6;
                obj = obj6;
                zzbqVar.zza = permissionsUiManager2;
                zzbqVar.zzb = null;
                zzbqVar.zzc = null;
                zzbqVar.zzh = 2;
                objZzk = permissionsUiManager.zzk(activityResultLauncher, (IntentSender) obj, zzbqVar);
                if (objZzk != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                permissionsUiManager3 = (PermissionsUiManager) zzbqVar.zza;
                ResultKt.throwOnFailure(obj6);
                obj2 = obj6;
                accountPickerResult = (AccountPickerResult) obj2;
                if (accountPickerResult == null) {
                }
                if (accountPickerResult != null) {
                }
                return new PermissionsResultWithInfo(new PermissionsResult(PermissionsResultStatus.CANCELLED, "User cancelled account picker."), null);
            case 3:
                ref$ObjectRef = (Ref$ObjectRef) zzbqVar.zzd;
                ref$ObjectRef2 = zzbqVar.zzi;
                account = (Account) zzbqVar.zzc;
                accountPickerResult2 = (AccountPickerResult) zzbqVar.zzb;
                permissionsUiManager4 = (PermissionsUiManager) zzbqVar.zza;
                ResultKt.throwOnFailure(obj6);
                t = obj6;
                ref$ObjectRef.element = t;
                if (((AuthorizationResult) ref$ObjectRef2.element).getAccessToken() == null) {
                }
                return coroutine_suspended;
            case 4:
                ref$ObjectRef3 = (Ref$ObjectRef) zzbqVar.zzd;
                ref$ObjectRef2 = zzbqVar.zzi;
                account = (Account) zzbqVar.zzc;
                accountPickerResult2 = (AccountPickerResult) zzbqVar.zzb;
                permissionsUiManager4 = (PermissionsUiManager) zzbqVar.zza;
                ResultKt.throwOnFailure(obj6);
                t2 = obj6;
                ref$ObjectRef3.element = t2;
                account2 = account;
                permissionsUiManager5 = permissionsUiManager4;
                PendingIntent pendingIntent22 = ((AuthorizationResult) ref$ObjectRef2.element).getPendingIntent();
                if (pendingIntent22 != null) {
                }
                if (intentSender != null) {
                }
                return coroutine_suspended;
            case 5:
                ActivityResultLauncher activityResultLauncher5 = (ActivityResultLauncher) zzbqVar.zzd;
                Ref$ObjectRef ref$ObjectRef7 = zzbqVar.zzi;
                Account account6 = (Account) zzbqVar.zzc;
                accountPickerResult4 = (AccountPickerResult) zzbqVar.zzb;
                permissionsUiManager5 = (PermissionsUiManager) zzbqVar.zza;
                ResultKt.throwOnFailure(obj6);
                activityResultLauncher2 = activityResultLauncher5;
                ref$ObjectRef4 = ref$ObjectRef7;
                account3 = account6;
                obj3 = obj6;
                IntentSender intentSender22 = (IntentSender) obj3;
                zzbqVar.zza = permissionsUiManager5;
                zzbqVar.zzb = accountPickerResult4;
                zzbqVar.zzc = account3;
                zzbqVar.zzi = ref$ObjectRef4;
                zzbqVar.zzd = activityResultLauncher2;
                zzbqVar.zze = intentSender22;
                zzbqVar.zzh = 6;
                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(zzbqVar), 1);
                cancellableContinuationImpl.initCancellability();
                atomicReference = permissionsUiManager5.zzm;
                while (true) {
                    if (!atomicReference.compareAndSet(null, cancellableContinuationImpl)) {
                    }
                }
                activityResultLauncher2.launch(new IntentSenderRequest.Builder(intentSender22).build());
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                }
                if (result != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 6:
                ref$ObjectRef4 = zzbqVar.zzi;
                account4 = (Account) zzbqVar.zzc;
                accountPickerResult5 = (AccountPickerResult) zzbqVar.zzb;
                ResultKt.throwOnFailure(obj6);
                obj4 = obj6;
                bool = (Boolean) obj4;
                if (bool != null) {
                }
                break;
            case 7:
                account2 = (Account) zzbqVar.zzb;
                accountPickerResult3 = (AccountPickerResult) zzbqVar.zza;
                ResultKt.throwOnFailure(obj6);
                obj5 = obj6;
                authorizationResult = (AuthorizationResult) obj5;
                if (authorizationResult != null) {
                }
                break;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void zzg(PermissionsUiManager permissionsUiManager, ActivityResult activityResult) {
        PermissionsResult permissionsResult;
        PermissionsResult permissionsResult2;
        activityResult.getClass();
        CancellableContinuation cancellableContinuation = (CancellableContinuation) permissionsUiManager.zzg.getAndSet(null);
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            permissionsResult = new PermissionsResult(PermissionsResultStatus.SUCCESS, null, 2, null);
        } else {
            if (resultCode != 0) {
                PermissionsResultStatus permissionsResultStatus = PermissionsResultStatus.ERROR;
                int resultCode2 = activityResult.getResultCode();
                permissionsResult2 = new PermissionsResult(permissionsResultStatus, zzba$$ExternalSyntheticOutline0.m(resultCode2, "Failed to grant permissions with error: ", new StringBuilder(String.valueOf(resultCode2).length() + 40)));
                if (cancellableContinuation == null) {
                    cancellableContinuation.resumeWith(Result.m2357constructorimpl(permissionsResult2));
                    return;
                }
                return;
            }
            permissionsResult = new PermissionsResult(PermissionsResultStatus.CANCELLED, null, 2, null);
        }
        permissionsResult2 = permissionsResult;
        if (cancellableContinuation == null) {
        }
    }

    public static /* synthetic */ void zzh(PermissionsUiManager permissionsUiManager, ActivityResult activityResult) {
        activityResult.getClass();
        AccountPickerResult accountPickerResult = null;
        CancellableContinuation cancellableContinuation = (CancellableContinuation) permissionsUiManager.zzi.getAndSet(null);
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
            Intent data2 = activityResult.getData();
            data2.getClass();
            accountPickerResult = new AccountPickerResult((Account) IntentCompat.getParcelableExtra(data2, "extra_account_result", Account.class), data2.getStringExtra("extra_client_session_id"));
        }
        if (cancellableContinuation != null) {
            cancellableContinuation.resumeWith(Result.m2357constructorimpl(accountPickerResult));
        }
    }

    public static /* synthetic */ void zzi(PermissionsUiManager permissionsUiManager, ActivityResult activityResult) {
        activityResult.getClass();
        AuthorizationResult authorizationResultZzb = null;
        CancellableContinuation cancellableContinuation = (CancellableContinuation) permissionsUiManager.zzk.getAndSet(null);
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
            authorizationResultZzb = permissionsUiManager.zzd.zzb(activityResult.getData());
        }
        if (cancellableContinuation != null) {
            cancellableContinuation.resumeWith(Result.m2357constructorimpl(authorizationResultZzb));
        }
    }

    public static /* synthetic */ void zzj(PermissionsUiManager permissionsUiManager, ActivityResult activityResult) {
        activityResult.getClass();
        CancellableContinuation cancellableContinuation = (CancellableContinuation) permissionsUiManager.zzm.getAndSet(null);
        if (cancellableContinuation != null) {
            cancellableContinuation.resumeWith(Result.m2357constructorimpl(Boolean.valueOf(activityResult.getResultCode() == -1)));
        }
    }

    private final Object zzk(ActivityResultLauncher activityResultLauncher, IntentSender intentSender, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReference atomicReference = this.zzi;
        while (true) {
            if (atomicReference.compareAndSet(null, cancellableContinuationImpl)) {
                break;
            }
            if (atomicReference.get() != null) {
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(null));
                break;
            }
        }
        activityResultLauncher.launch(new IntentSenderRequest.Builder(intentSender).build());
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Object zzl(ActivityResultLauncher activityResultLauncher, IntentSender intentSender, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReference atomicReference = this.zzk;
        while (true) {
            if (atomicReference.compareAndSet(null, cancellableContinuationImpl)) {
                break;
            }
            if (atomicReference.get() != null) {
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(null));
                break;
            }
        }
        activityResultLauncher.launch(new IntentSenderRequest.Builder(intentSender).build());
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void zza(ActivityResultCaller activityResultCaller) {
        activityResultCaller.getClass();
        this.zzf.set(activityResultCaller.registerForActivityResult(new ActivityResultContracts$StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.google.android.gms.home.internal.zzbw
            @Override // androidx.view.result.ActivityResultCallback
            public final /* synthetic */ void onActivityResult(Object obj) {
                PermissionsUiManager.zzg(this.zza, (ActivityResult) obj);
            }
        }));
        this.zzh.set(activityResultCaller.registerForActivityResult(new ActivityResultContracts$StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.google.android.gms.home.internal.zzbt
            @Override // androidx.view.result.ActivityResultCallback
            public final /* synthetic */ void onActivityResult(Object obj) {
                PermissionsUiManager.zzh(this.zza, (ActivityResult) obj);
            }
        }));
        this.zzj.set(activityResultCaller.registerForActivityResult(new ActivityResultContracts$StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.google.android.gms.home.internal.zzbu
            @Override // androidx.view.result.ActivityResultCallback
            public final /* synthetic */ void onActivityResult(Object obj) {
                PermissionsUiManager.zzi(this.zza, (ActivityResult) obj);
            }
        }));
        this.zzl.set(activityResultCaller.registerForActivityResult(new ActivityResultContracts$StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.google.android.gms.home.internal.zzbv
            @Override // androidx.view.result.ActivityResultCallback
            public final /* synthetic */ void onActivityResult(Object obj) {
                PermissionsUiManager.zzj(this.zza, (ActivityResult) obj);
            }
        }));
    }

    public final Object zzb(Account account, Continuation continuation) {
        AuthorizationRequest authorizationRequestBuild = new AuthorizationRequest.Builder().setRequestedScopes(CollectionsKt.listOf(new Scope("https://www.googleapis.com/auth/home.platform.selected.devices"))).setAccount(account).build();
        authorizationRequestBuild.getClass();
        return TasksKt.await(this.zzd.zza(authorizationRequestBuild), continuation);
    }

    public final Object zzc(boolean z, Continuation continuation) {
        return zzd(this, z, continuation);
    }
}

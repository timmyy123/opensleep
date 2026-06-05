package com.google.android.gms.home.internal;

import android.accounts.Account;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.home.permissions.PermissionsClient;
import com.google.android.gms.internal.serialization.zzcu;
import com.google.android.gms.internal.serialization.zzg;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: renamed from: com.google.android.gms.home.internal.zzbh, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u0097@¢\u0006\u0002\u0010\nJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0097@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/android/gms/home/internal/InternalPermissionsClient;", "Lcom/google/android/gms/common/api/GoogleApi;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "Lcom/google/android/gms/home/permissions/PermissionsClient;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getUserSelectedAccountForHomeAccess", "Lcom/google/android/gms/home/permissions/HomeAccountResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountPickerIntentSender", "Landroid/content/IntentSender;", "getConsentScreenIntentSender", "account", "Landroid/accounts/Account;", "(Landroid/accounts/Account;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalPermissionsClient extends GoogleApi implements PermissionsClient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalPermissionsClient(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzbm.zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzf(PermissionsClientImpl permissionsClientImpl, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(((zzcu) permissionsClientImpl.getService()).zzf());
        } catch (UnsupportedOperationException unused) {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzg(Account account, PermissionsClientImpl permissionsClientImpl, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(((zzcu) permissionsClientImpl.getService()).zzg(account));
        } catch (UnsupportedOperationException unused) {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.gms.home.permissions.PermissionsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zza(Continuation continuation) {
        zzbf zzbfVar;
        if (continuation instanceof zzbf) {
            zzbfVar = (zzbf) continuation;
            int i = zzbfVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbfVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzbfVar = new zzbf(this, continuation);
            }
        }
        Object objZza = zzbfVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzbfVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZza);
            Task taskDoRead = doRead(TaskApiCall.builder().setFeatures(zzg.zzo).run(zzbk.zza).setMethodKey(31727).build());
            taskDoRead.getClass();
            zzbfVar.zzc = 1;
            objZza = zzd.zza(taskDoRead, zzbfVar);
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
        objZza.getClass();
        return objZza;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.gms.home.permissions.PermissionsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb(Continuation continuation) {
        zzbd zzbdVar;
        if (continuation instanceof zzbd) {
            zzbdVar = (zzbd) continuation;
            int i = zzbdVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbdVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzbdVar = new zzbd(this, continuation);
            }
        }
        Object objZza = zzbdVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzbdVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZza);
            Task taskDoRead = doRead(TaskApiCall.builder().setFeatures(zzg.zzo).run(zzbi.zza).setMethodKey(31732).build());
            taskDoRead.getClass();
            zzbdVar.zzc = 1;
            objZza = zzd.zza(taskDoRead, zzbdVar);
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
        objZza.getClass();
        return objZza;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.gms.home.permissions.PermissionsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzc(final Account account, Continuation continuation) {
        zzbe zzbeVar;
        if (continuation instanceof zzbe) {
            zzbeVar = (zzbe) continuation;
            int i = zzbeVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbeVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzbeVar = new zzbe(this, continuation);
            }
        }
        Object objZza = zzbeVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzbeVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZza);
            Task taskDoRead = doRead(TaskApiCall.builder().setFeatures(zzg.zzo).run(new RemoteCall() { // from class: com.google.android.gms.home.internal.zzbj
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) {
                    InternalPermissionsClient.zzg(account, (PermissionsClientImpl) obj, (TaskCompletionSource) obj2);
                }
            }).setMethodKey(31733).build());
            taskDoRead.getClass();
            zzbeVar.zzc = 1;
            objZza = zzd.zza(taskDoRead, zzbeVar);
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
        objZza.getClass();
        return objZza;
    }
}

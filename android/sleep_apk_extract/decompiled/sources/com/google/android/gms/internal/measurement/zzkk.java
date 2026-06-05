package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzkk extends GoogleApi {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Pair.create(zzkm.zza(0L), Tasks.forResult(null));
    }

    public zzkk(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzjx.zza, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task zza(final String str, int i, final String[] strArr, @Nullable byte[] bArr) {
        final int i2 = 0;
        final byte[] bArr2 = null;
        return doRead(TaskApiCall.builder().run(new RemoteCall(str, i2, strArr, bArr2) { // from class: com.google.android.gms.internal.measurement.zzki
            private final /* synthetic */ String zza;
            private final /* synthetic */ String[] zzb;

            {
                this.zzb = strArr;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i3 = zzkk.$r8$clinit;
                zzkj zzkjVar = new zzkj((TaskCompletionSource) obj2, null);
                ((zzkt) ((zzku) obj).getService()).zze(zzkjVar, this.zza, 0, this.zzb, null);
            }
        }).build());
    }

    public final Task zzb(final String str, String str2, @Nullable String str3) {
        final String str4 = null;
        final String str5 = "";
        return doRead(TaskApiCall.builder().run(new RemoteCall(str, str5, str4) { // from class: com.google.android.gms.internal.measurement.zzkb
            private final /* synthetic */ String zza;
            private final /* synthetic */ String zzb = "";

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i = zzkk.$r8$clinit;
                ((zzkt) ((zzku) obj).getService()).zzf(new zzkj((TaskCompletionSource) obj2, null), this.zza, this.zzb, null);
            }
        }).build());
    }

    public final Task zzc(final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkc
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i = zzkk.$r8$clinit;
                ((zzkt) ((zzku) obj).getService()).zzg(new zzkj((TaskCompletionSource) obj2, null), str);
            }
        }).build());
    }

    public final Task zzd(final zzme zzmeVar) {
        Preconditions.checkNotNull(zzmeVar);
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkd
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i = zzkk.$r8$clinit;
                ((zzkt) ((zzku) obj).getService()).zzh(new zzkj((TaskCompletionSource) obj2, null), zzmeVar.zzcd());
            }
        }).setFeatures(zzjn.zza).setAutoResolveMissingFeatures(false).build()).continueWithTask(MoreExecutors.directExecutor(), new Continuation() { // from class: com.google.android.gms.internal.measurement.zzke
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                boolean z = task.getException() instanceof UnsupportedApiCallException;
                zzme zzmeVar2 = zzmeVar;
                zzkk zzkkVar = this.zza;
                return z ? zzkkVar.zzc(zzmeVar2.zza()) : ((task.getException() instanceof ApiException) && ((ApiException) Preconditions.checkNotNull((ApiException) task.getException())).getStatusCode() == 29514) ? zzkkVar.zzc(zzmeVar2.zza()) : task;
            }
        });
    }

    public final Task zze() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkf
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zzkt) ((zzku) obj).getService()).zzi(new zzjy(this.zza, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzjn.zzi).setAutoResolveMissingFeatures(false).build());
    }

    public final Task zzf(zzpm zzpmVar) throws Throwable {
        final String string;
        final ListenerHolder listenerHolderRegisterListener = registerListener(zzpmVar, "zzku");
        String myProcessName = ProcessUtils.getMyProcessName();
        if (myProcessName == null) {
            string = "__PH_INTERNAL__NO_PROCESS__";
        } else {
            int length = myProcessName.length() + 1;
            int iIdentityHashCode = System.identityHashCode(zzku.class);
            StringBuilder sb = new StringBuilder(length + String.valueOf(iIdentityHashCode).length());
            sb.append(myProcessName);
            sb.append("|");
            sb.append(iIdentityHashCode);
            string = sb.toString();
        }
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkg
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zzkt) ((zzku) obj).getService()).zzj(string, new zzka(this.zza, listenerHolderRegisterListener));
            }
        };
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderRegisterListener).register(remoteCall).unregister(zzkh.zza).setFeatures(zzjn.zzd).setAutoResolveMissingFeatures(false).build());
    }
}

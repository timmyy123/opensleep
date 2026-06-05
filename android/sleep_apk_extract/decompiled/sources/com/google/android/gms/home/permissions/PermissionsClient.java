package com.google.android.gms.home.permissions;

import android.accounts.Account;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/google/android/gms/home/permissions/PermissionsClient;", "", "getUserSelectedAccountForHomeAccess", "Lcom/google/android/gms/home/permissions/HomeAccountResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountPickerIntentSender", "Landroid/content/IntentSender;", "getConsentScreenIntentSender", "account", "Landroid/accounts/Account;", "(Landroid/accounts/Account;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PermissionsClient {
    Object zza(Continuation continuation);

    Object zzb(Continuation continuation);

    Object zzc(Account account, Continuation continuation);
}

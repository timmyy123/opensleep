package com.google.android.gms.home.internal;

import android.accounts.Account;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.home.internal.zzbo, reason: from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPickerResult;", "", "account", "Landroid/accounts/Account;", "clientSessionId", "", "<init>", "(Landroid/accounts/Account;Ljava/lang/String;)V", "getAccount", "()Landroid/accounts/Account;", "getClientSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AccountPickerResult {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final Account account;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final String clientSessionId;

    public AccountPickerResult(Account account, String str) {
        this.account = account;
        this.clientSessionId = str;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountPickerResult)) {
            return false;
        }
        AccountPickerResult accountPickerResult = (AccountPickerResult) other;
        return Intrinsics.areEqual(this.account, accountPickerResult.account) && Intrinsics.areEqual(this.clientSessionId, accountPickerResult.clientSessionId);
    }

    public final int hashCode() {
        Account account = this.account;
        int iHashCode = account == null ? 0 : account.hashCode();
        String str = this.clientSessionId;
        return (iHashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        Account account = this.account;
        int length = String.valueOf(account).length();
        String str = this.clientSessionId;
        StringBuilder sb = new StringBuilder(length + 46 + String.valueOf(str).length() + 1);
        sb.append("AccountPickerResult(account=");
        sb.append(account);
        sb.append(", clientSessionId=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final Account getAccount() {
        return this.account;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getClientSessionId() {
        return this.clientSessionId;
    }
}

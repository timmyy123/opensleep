package com.google.android.gms.home.internal;

import android.accounts.Account;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPermissionsInfo;", "", "account", "Landroid/accounts/Account;", SDKConstants.PARAM_ACCESS_TOKEN, "", "clientSessionId", "<init>", "(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V", "getAccount", "()Landroid/accounts/Account;", "getAccessToken", "()Ljava/lang/String;", "getClientSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class zzbn {
    private final Account zza;
    private final String zzb;
    private final String zzc;

    public zzbn(Account account, String str, String str2) {
        account.getClass();
        str.getClass();
        this.zza = account;
        this.zzb = str;
        this.zzc = str2;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof zzbn)) {
            return false;
        }
        zzbn zzbnVar = (zzbn) other;
        return Intrinsics.areEqual(this.zza, zzbnVar.zza) && Intrinsics.areEqual(this.zzb, zzbnVar.zzb) && Intrinsics.areEqual(this.zzc, zzbnVar.zzc);
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + (this.zza.hashCode() * 31);
        String str = this.zzc;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        Account account = this.zza;
        int length = String.valueOf(account).length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        String str2 = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 45, length2, 18, String.valueOf(str2).length()) + 1);
        sb.append("AccountPermissionsInfo(account=");
        sb.append(account);
        sb.append(", accessToken=");
        sb.append(str);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", clientSessionId=", str2, ")");
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final Account getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }
}

package com.google.android.gms.home.permissions;

import android.accounts.Account;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.google.android.gms.home.permissions.zza, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB-\b\u0007\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/google/android/gms/home/permissions/HomeAccountResult;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "Landroid/accounts/Account;", "account", "Landroid/content/IntentSender;", "intentSender", "", "clientSessionId", "<init>", "(Landroid/accounts/Account;Landroid/content/IntentSender;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/accounts/Account;", "getAccount", "()Landroid/accounts/Account;", "Landroid/content/IntentSender;", "getIntentSender", "()Landroid/content/IntentSender;", "Ljava/lang/String;", "getClientSessionId", "()Ljava/lang/String;", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeAccountResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HomeAccountResult> CREATOR = new zzb();
    private final Account zza;
    private final IntentSender zzb;
    private final String zzc;

    public HomeAccountResult(Account account, IntentSender intentSender, String str) {
        this.zza = account;
        this.zzb = intentSender;
        this.zzc = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeParcelable(dest, 1, this.zza, flags, false);
        SafeParcelWriter.writeParcelable(dest, 2, this.zzb, flags, false);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final Account getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final IntentSender getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: zzc, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }
}

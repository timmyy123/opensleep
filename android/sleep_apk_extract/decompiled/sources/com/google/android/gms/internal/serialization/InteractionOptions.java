package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.internal.home.zzl, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B7\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0015J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0013J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0013J>\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b\"\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b'\u0010\u0013¨\u0006)"}, d2 = {"Lcom/google/android/gms/home/interaction/InteractionOptions;", "", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "", "type", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "account", "", "oauthToken", "clientSessionId", "<init>", "(ILcom/google/android/gms/auth/api/signin/GoogleSignInAccount;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "component1", "component2", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "component3", "component4", "copy", "(ILcom/google/android/gms/auth/api/signin/GoogleSignInAccount;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/home/interaction/InteractionOptions;", "I", "getType", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "getAccount", "Ljava/lang/String;", "getOauthToken", "getClientSessionId", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class InteractionOptions extends AbstractSafeParcelable implements Api.ApiOptions {
    public static final Parcelable.Creator<InteractionOptions> CREATOR = new zzj();

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final int type;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final GoogleSignInAccount account;
    private final String zzc;
    private final String zzd;

    public InteractionOptions(int i, @Nullable GoogleSignInAccount googleSignInAccount, @Nullable String str, @Nullable String str2) {
        this.type = i;
        this.account = googleSignInAccount;
        this.zzc = str;
        this.zzd = str2;
    }

    public static /* synthetic */ InteractionOptions zzc(InteractionOptions interactionOptions, int i, GoogleSignInAccount googleSignInAccount, String str, String str2, int i2, Object obj) {
        int i3 = (i2 & 1) != 0 ? interactionOptions.type : 0;
        if ((i2 & 2) != 0) {
            googleSignInAccount = interactionOptions.account;
        }
        if ((i2 & 4) != 0) {
            str = interactionOptions.zzc;
        }
        if ((i2 & 8) != 0) {
            str2 = interactionOptions.zzd;
        }
        return new InteractionOptions(i3, googleSignInAccount, str, str2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionOptions)) {
            return false;
        }
        InteractionOptions interactionOptions = (InteractionOptions) other;
        return this.type == interactionOptions.type && Intrinsics.areEqual(this.account, interactionOptions.account) && Intrinsics.areEqual(this.zzc, interactionOptions.zzc) && Intrinsics.areEqual(this.zzd, interactionOptions.zzd);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        GoogleSignInAccount googleSignInAccount = this.account;
        int iHashCode2 = (iHashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 31;
        String str = this.zzc;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzd;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        int i = this.type;
        int length = String.valueOf(i).length();
        GoogleSignInAccount googleSignInAccount = this.account;
        int length2 = String.valueOf(googleSignInAccount).length();
        String str = this.zzc;
        int length3 = String.valueOf(str).length();
        String str2 = this.zzd;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 34, length2, 13, length3, 18, String.valueOf(str2).length()) + 1);
        sb.append("InteractionOptions(type=");
        sb.append(i);
        sb.append(", account=");
        sb.append(googleSignInAccount);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", oauthToken=", str, ", clientSessionId=", str2);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, this.type);
        SafeParcelWriter.writeParcelable(dest, 2, this.account, flags, false);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.writeString(dest, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final String getZzd() {
        return this.zzd;
    }
}

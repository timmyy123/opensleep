package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.play.core.install.model.InstallErrorCode;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class zzcq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcq> CREATOR = new zzcr();
    private final int zza;
    private final String zzb;

    public zzcq(int i, String str) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcq)) {
            return false;
        }
        zzcq zzcqVar = (zzcq) obj;
        return this.zza == zzcqVar.zza && Objects.equals(this.zzb, zzcqVar.zzb);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strM;
        int i = this.zza;
        switch (i) {
            case InstallErrorCode.ERROR_PLAY_STORE_NOT_FOUND /* -9 */:
                strM = "Migration was cancelled";
                break;
            case -8:
                strM = "Another migration is already in progress";
                break;
            case InstallErrorCode.ERROR_DOWNLOAD_NOT_PRESENT /* -7 */:
                strM = "Connect message malformed";
                break;
            case InstallErrorCode.ERROR_INSTALL_NOT_ALLOWED /* -6 */:
                strM = "Migration status mismatch between watch and phone";
                break;
            case InstallErrorCode.ERROR_INSTALL_UNAVAILABLE /* -5 */:
                strM = "Phone switching feature disabled";
                break;
            case -4:
                strM = "Did not receive connect msg";
                break;
            case -3:
                strM = "No bluetooth connection";
                break;
            case -2:
                strM = "Accounts mismatch";
                break;
            case -1:
                strM = "Unknown failure";
                break;
            case 0:
                strM = "Connected";
                break;
            case 1:
                strM = "Connection handshake in progress";
                break;
            case 2:
                strM = "Connection handshake complete";
                break;
            case 3:
                strM = "Sync with old node suspended";
                break;
            case 4:
                strM = "Control plane transport connected";
                break;
            case 5:
                strM = "Accounts Matched";
                break;
            case 6:
                strM = "Association to watch terminated";
                break;
            default:
                strM = zzba$$ExternalSyntheticOutline0.m(i, "Unrecognized state value: ", new StringBuilder(String.valueOf(i).length() + 26));
                break;
        }
        return Fragment$$ExternalSyntheticOutline1.m("ConnectionStateEvent: address: ", this.zzb, ", state: ", strM);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

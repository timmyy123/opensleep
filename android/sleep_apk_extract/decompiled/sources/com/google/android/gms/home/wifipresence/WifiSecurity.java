package com.google.android.gms.home.wifipresence;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.serialization.zzdc;
import com.google.android.gms.internal.serialization.zzdd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/google/android/gms/home/wifipresence/WifiSecurity;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "", "wifiSecurityType", "<init>", "(I)V", "hashCode", "()I", "", "obj", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getWifiSecurityType", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WifiSecurity extends AbstractSafeParcelable {
    private final int zza;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<WifiSecurity> CREATOR = new zze();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/google/android/gms/home/wifipresence/WifiSecurity$Companion;", "", "", "wifiSecurityType", "", InAppPurchaseConstants.METHOD_TO_STRING, "(I)Ljava/lang/String;", "Landroid/os/Parcelable$Creator;", "Lcom/google/android/gms/home/wifipresence/WifiSecurity;", "CREATOR", "Landroid/os/Parcelable$Creator;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String toString(int wifiSecurityType) {
            switch (wifiSecurityType) {
                case 0:
                    return "OPEN";
                case 1:
                    return "WEP";
                case 2:
                    return "WPA";
                case 3:
                    return "WPA_WPA2_MIXED_MODE";
                case 4:
                    return "WPA2";
                case 5:
                    return "WPA2_WPA3_TRANSITION_MODE";
                case 6:
                    return "WPA3";
                default:
                    return "UNKNOWN";
            }
        }
    }

    public WifiSecurity(int i) {
        this.zza = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WifiSecurity) {
            return Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(((WifiSecurity) obj).zza));
        }
        return false;
    }

    /* JADX INFO: renamed from: getWifiSecurityType, reason: from getter */
    public final int getZza() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza));
    }

    public String toString() {
        zzdc zzdcVarZza = zzdd.zza(this);
        zzdcVarZza.zza("wifiSecurityType", INSTANCE.toString(this.zza));
        String string = zzdcVarZza.toString();
        string.getClass();
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, getZza());
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }
}

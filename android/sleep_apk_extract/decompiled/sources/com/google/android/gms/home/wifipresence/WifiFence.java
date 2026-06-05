package com.google.android.gms.home.wifipresence;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.serialization.zzdc;
import com.google.android.gms.internal.serialization.zzdd;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B-\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/google/android/gms/home/wifipresence/WifiFence;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "", "ssid", "", "Lcom/google/android/gms/home/wifipresence/WifiSecurity;", "wifiSecurityTypes", "Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "wifiFencingState", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/google/android/gms/home/wifipresence/WifiFencingState;)V", "", "hashCode", "()I", "", "obj", "", "equals", "(Ljava/lang/Object;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSsid", "Ljava/util/List;", "getWifiSecurityTypes", "()Ljava/util/List;", "Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "getWifiFencingState", "()Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "Companion", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WifiFence extends AbstractSafeParcelable {
    private final String zza;
    private final List zzb;
    private final WifiFencingState zzc;
    public static final Parcelable.Creator<WifiFence> CREATOR = new zzb();

    public WifiFence(String str, List<WifiSecurity> list, WifiFencingState wifiFencingState) {
        str.getClass();
        list.getClass();
        wifiFencingState.getClass();
        this.zza = str;
        this.zzb = list;
        this.zzc = wifiFencingState;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WifiFence) {
            WifiFence wifiFence = (WifiFence) obj;
            if (Objects.equal(this.zza, wifiFence.zza) && Objects.equal(this.zzb, wifiFence.zzb) && Objects.equal(this.zzc, wifiFence.zzc)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getSsid, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: getWifiFencingState, reason: from getter */
    public final WifiFencingState getZzc() {
        return this.zzc;
    }

    public final List<WifiSecurity> getWifiSecurityTypes() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    public String toString() {
        zzdc zzdcVarZza = zzdd.zza(this);
        zzdcVarZza.zza("ssid", this.zza);
        zzdcVarZza.zza("wifiSecurityTypes", this.zzb);
        if (!Intrinsics.areEqual(this.zzc, WifiFencingState.DEFAULT_INSTANCE)) {
            zzdcVarZza.zza("wifiFencingState", this.zzc);
        }
        String string = zzdcVarZza.toString();
        string.getClass();
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, getZza(), false);
        SafeParcelWriter.writeTypedList(dest, 2, getWifiSecurityTypes(), false);
        SafeParcelWriter.writeParcelable(dest, 3, getZzc(), flags, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }
}

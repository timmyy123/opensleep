package com.google.android.gms.home.wifipresence;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.serialization.zzdc;
import com.google.android.gms.internal.serialization.zzdd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#\"B5\b\u0007\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "", "ssid", "", "wifiSecurityType", "connectivityState", "", "elapsedRealtimeMillis", "<init>", "(Ljava/lang/String;IILjava/lang/Long;)V", "hashCode", "()I", "", "obj", "", "equals", "(Ljava/lang/Object;)Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSsid", "I", "getWifiSecurityType", "getConnectivityState", "Ljava/lang/Long;", "getElapsedRealtimeMillis", "()Ljava/lang/Long;", "Companion", "Builder", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WifiFencingState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WifiFencingState> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final WifiFencingState DEFAULT_INSTANCE;
    private static final WifiFencingState zze;
    private final String zza;
    private final int zzb;
    private final int zzc;
    private final Long zzd;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/google/android/gms/home/wifipresence/WifiFencingState$Builder;", "", "", "wifiSecurityType", "setWifiSecurityType", "(I)Lcom/google/android/gms/home/wifipresence/WifiFencingState$Builder;", "connectivityState", "setConnectivityState", "Lcom/google/android/gms/home/wifipresence/WifiFencingState;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Builder {
        WifiFencingState build();

        Builder setConnectivityState(int connectivityState);

        Builder setWifiSecurityType(int wifiSecurityType);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/android/gms/home/wifipresence/WifiFencingState$Companion;", "", "Lcom/google/android/gms/home/wifipresence/WifiFencingState$Builder;", "builder", "()Lcom/google/android/gms/home/wifipresence/WifiFencingState$Builder;", "", "connectivityState", "", InAppPurchaseConstants.METHOD_TO_STRING, "(I)Ljava/lang/String;", "Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "DEFAULT_INSTANCE", "Lcom/google/android/gms/home/wifipresence/WifiFencingState;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Builder builder() {
            zza zzaVar = new zza();
            zzaVar.setConnectivityState(-1);
            zzaVar.setWifiSecurityType(-1);
            return zzaVar;
        }

        public final String toString(int connectivityState) {
            return connectivityState != 0 ? connectivityState != 1 ? "UNKNOWN" : "DISCONNECTED" : "CONNECTED";
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        DEFAULT_INSTANCE = companion.builder().build();
        Builder builder = companion.builder();
        builder.setConnectivityState(1);
        zze = builder.build();
        CREATOR = new zzd();
    }

    public WifiFencingState(String str, int i, int i2, Long l) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = l;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WifiFencingState) {
            WifiFencingState wifiFencingState = (WifiFencingState) obj;
            if (TextUtils.equals(this.zza, wifiFencingState.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(wifiFencingState.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(wifiFencingState.zzc))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getConnectivityState, reason: from getter */
    public final int getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: getElapsedRealtimeMillis, reason: from getter */
    public final Long getZzd() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: getSsid, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: getWifiSecurityType, reason: from getter */
    public final int getZzb() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd);
    }

    public String toString() {
        zzdc zzdcVarZza = zzdd.zza(this);
        zzdcVarZza.zza("ssid", this.zza);
        zzdcVarZza.zza("wifiSecurityType", WifiSecurity.INSTANCE.toString(this.zzb));
        zzdcVarZza.zza("connectivityState", INSTANCE.toString(this.zzc));
        zzdcVarZza.zza("elapsedRealtimeMillis", this.zzd);
        String string = zzdcVarZza.toString();
        string.getClass();
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, getZza(), false);
        SafeParcelWriter.writeInt(dest, 2, getZzb());
        SafeParcelWriter.writeInt(dest, 3, getZzc());
        SafeParcelWriter.writeLongObject(dest, 4, getZzd(), false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }
}

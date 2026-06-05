package com.google.android.gms.home.matter.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.serialization.zzig;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NetworkLocation> CREATOR = new zzc();
    private final int zza;
    private final InetAddress zzb;

    public NetworkLocation(byte[] bArr, int i, String str) {
        this(bArr != null ? zza(bArr) : zzig.zza(str), i);
    }

    private static InetAddress zza(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Failed to parse IP address ".concat(String.valueOf(Arrays.toString(bArr))), e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkLocation)) {
            return false;
        }
        NetworkLocation networkLocation = (NetworkLocation) obj;
        if (this.zza == networkLocation.zza) {
            InetAddress inetAddress = this.zzb;
            InetAddress inetAddress2 = networkLocation.zzb;
            if (inetAddress.equals(inetAddress2) && (!(inetAddress instanceof Inet6Address) || !(inetAddress2 instanceof Inet6Address) || ((Inet6Address) inetAddress).getScopeId() == ((Inet6Address) inetAddress2).getScopeId())) {
                return true;
            }
        }
        return false;
    }

    public String getFormattedIpAddress() {
        String strM256m;
        int i = zzig.$r8$clinit;
        InetAddress inetAddress = this.zzb;
        inetAddress.getClass();
        if (inetAddress instanceof Inet4Address) {
            String hostAddress = inetAddress.getHostAddress();
            Objects.requireNonNull(hostAddress);
            return hostAddress;
        }
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = i2 + i2;
            iArr[i2] = (address[i3 + 1] & 255) | ((address[i3] & 255) << 8);
        }
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < 9; i7++) {
            if (i7 >= 8 || iArr[i7] != 0) {
                if (i6 >= 0) {
                    int i8 = i7 - i6;
                    int i9 = i8 > i4 ? i8 : i4;
                    if (i8 > i4) {
                        i5 = i6;
                    }
                    i6 = -1;
                    i4 = i9;
                }
            } else if (i6 < 0) {
                i6 = i7;
            }
        }
        if (i4 >= 2) {
            Arrays.fill(iArr, i5, i4 + i5, -1);
        }
        StringBuilder sb = new StringBuilder(39);
        int i10 = 0;
        boolean z = false;
        while (i10 < 8) {
            boolean z2 = iArr[i10] >= 0;
            if (z2) {
                if (z) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i10]));
            } else if (i10 == 0 || z) {
                sb.append("::");
            }
            i10++;
            z = z2;
        }
        String string = sb.toString();
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        NetworkInterface scopedInterface = inet6Address.getScopedInterface();
        if (scopedInterface != null) {
            strM256m = "%".concat(String.valueOf(scopedInterface.getName()));
        } else {
            int scopeId = inet6Address.getScopeId();
            strM256m = scopeId != 0 ? zzba$$ExternalSyntheticOutline0.m256m(zzba$$ExternalSyntheticOutline0.m(scopeId, 1), scopeId, "%") : "";
        }
        return string.concat(strM256m);
    }

    public int getPort() {
        return this.zza;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.Objects.hashCode(this.zzb, Integer.valueOf(this.zza));
    }

    public String toString() {
        String formattedIpAddress = getFormattedIpAddress();
        int length = String.valueOf(formattedIpAddress).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(FileInsert$$ExternalSyntheticOutline0.m(length, 1, String.valueOf(i).length(), 1));
        sb.append(formattedIpAddress);
        sb.append("[");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getPort());
        SafeParcelWriter.writeString(parcel, 3, getFormattedIpAddress(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    private NetworkLocation(InetAddress inetAddress, int i) {
        this.zzb = (InetAddress) Preconditions.checkNotNull(inetAddress);
        this.zza = i;
    }
}

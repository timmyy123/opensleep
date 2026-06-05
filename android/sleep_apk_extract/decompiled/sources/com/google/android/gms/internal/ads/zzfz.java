package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfz {
    public final int zzd;

    public static String zze(int i) {
        char c = (char) ((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN);
        int length = String.valueOf(c).length();
        char c2 = (char) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
        int length2 = String.valueOf(c2).length();
        char c3 = (char) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
        int length3 = String.valueOf(c3).length();
        char c4 = (char) (i & PHIpAddressSearchManager.END_IP_SCAN);
        StringBuilder sb = new StringBuilder(FileInsert$$ExternalSyntheticOutline0.m(length, length2, length3, String.valueOf(c4).length()));
        sb.append(c);
        sb.append(c2);
        sb.append(c3);
        sb.append(c4);
        return sb.toString();
    }

    public String toString() {
        return zze(this.zzd);
    }
}

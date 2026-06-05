package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.media.AudioDescriptor;
import android.media.AudioProfile;
import android.os.RemoteException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzbuy$$ExternalSyntheticBUOutline0 {
    public static /* synthetic */ void m(int i, Object obj) {
        throw new IllegalStateException("Source subfield " + i + ((Object) " is present but null: ") + ((Object) obj.toString()));
    }

    public static /* synthetic */ void m$1() throws zzies {
        throw new zzies("Protocol message tag had invalid wire type.");
    }

    public static /* synthetic */ void m$2(String str) throws com.google.android.gms.internal.aicore.zzfi {
        throw new com.google.android.gms.internal.aicore.zzfi(str);
    }

    public static /* bridge */ /* synthetic */ ApkChecksum m(Object obj) {
        return (ApkChecksum) obj;
    }

    public static /* synthetic */ void m$1(String str) throws zziet {
        throw new zziet(str);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AudioDescriptor m364m(Object obj) {
        return (AudioDescriptor) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AudioProfile m365m(Object obj) {
        return (AudioProfile) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m366m() throws RemoteException {
        throw new RemoteException();
    }

    public static /* synthetic */ void m(int i, int i2) {
        throw new IllegalArgumentException("Length too large: " + i + i2);
    }

    public static /* synthetic */ void m(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append((Object) "Length too large: ");
        sb.append(i2);
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(int i, int i2, Object obj) {
        StringBuilder sb = new StringBuilder(i);
        sb.append((Object) "Source subfield ");
        sb.append(i2);
        sb.append((Object) " is present but null: ");
        sb.append(obj);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void m(String str) throws GeneralSecurityException {
        throw new GeneralSecurityException(str);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, Throwable th) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3, th);
    }

    public static /* synthetic */ void m(Throwable th) throws zzflf {
        throw new zzflf(th);
    }
}

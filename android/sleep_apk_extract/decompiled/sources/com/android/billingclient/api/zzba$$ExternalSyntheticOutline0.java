package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Parcel;
import androidx.sqlite.SQLite;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzdzg;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzidj;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class zzba$$ExternalSyntheticOutline0 {
    public static void m(int i, int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        zzeg.zzc(str2, sb.toString());
    }

    public static int m$1(int i, int i2, int i3) {
        int i4 = i / i2;
        return i4 + i4 + i3;
    }

    public static int m$1(int i, int i2, int i3, int i4) {
        return ((i + i2) - i3) + i4;
    }

    public static int m(int i, int i2, int i3) {
        return zzidj.zzF(i) + i2 + i3;
    }

    public static int m(int i, int i2, int i3, int i4) {
        return ((i * i2) + i3) * i4;
    }

    public static int m(int i, int i2, int i3, int i4, int i5) {
        return i + i2 + i3 + i4 + i5;
    }

    public static int m(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return i + i2 + i3 + i4 + i5 + i6 + i7;
    }

    public static int m(int i, int i2, String str) {
        return str.length() + i + i2;
    }

    public static int m(int i, String str) {
        return String.valueOf(str).length() + i;
    }

    public static Bundle m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static BillingResult m255m(int i, String str) {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i);
        builderNewBuilder.setDebugMessage(str);
        return builderNewBuilder.build();
    }

    public static IObjectWrapper m(Parcel parcel) {
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapperAsInterface;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static String m256m(int i, int i2, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String m(int i, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String m(long j, String str) {
        return str + j;
    }

    public static String m(long j, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(j);
        return sb.toString();
    }

    public static String m(String str, String str2, long j) {
        return str + j + str2;
    }

    public static String m(StringBuilder sb, int i, String str, int i2, String str2) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, int i, String str2) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static KotlinNothingValueException m257m(int i, String str) {
        SQLite.throwSQLiteException(i, str);
        return new KotlinNothingValueException();
    }

    public static int m(int i, int i2) {
        return String.valueOf(i).length() + i2;
    }

    public static void m(int i, HashMap map, String str, int i2, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
    }

    public static /* synthetic */ void m(Object obj) {
        if (obj == null) {
            return;
        }
        Events$$ExternalSyntheticBUOutline0.m();
    }

    public static void m(String str, zzdzg zzdzgVar) {
        zzdzgVar.zzf(str, com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
    }

    public static void m(String str, String str2, String str3) {
        zzeg.zzc(str3, str2.concat(String.valueOf(str)));
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static void m258m(StringBuilder sb, String str, int i, String str2) {
        sb.append(str);
        sb.append(i);
        zzeg.zzc(str2, sb.toString());
    }

    public static void m(StringBuilder sb, String str, int i, String str2, String str3) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(str3);
    }

    public static void m(StringBuilder sb, String str, long j, String str2) {
        sb.append(str);
        sb.append(j);
        sb.append(str2);
    }

    public static void m(StringBuilder sb, String str, String str2, String str3, int i) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
    }

    public static void m(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }
}

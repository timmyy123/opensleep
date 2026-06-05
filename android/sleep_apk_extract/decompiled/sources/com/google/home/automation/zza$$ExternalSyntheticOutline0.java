package com.google.home.automation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzidj;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.consent_sdk.zzpv;
import com.google.android.gms.internal.measurement.zzada;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.play_billing.zzgr;
import com.google.android.gms.internal.serialization.zzxb;
import com.google.android.gms.internal.vision.zzii;
import com.google.android.gms.measurement.internal.zzic;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.home.matter.serialization.ClusterId;
import com.google.protobuf.CodedOutputStream;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApi;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class zza$$ExternalSyntheticOutline0 {
    public static void m(int i, int i2, String str, String str2) {
        Logger.logInfo(str + i + str2 + i2);
    }

    public static int m$2(int i, int i2, int i3, int i4) {
        return zzada.zzE(i) + i2 + i3 + i4;
    }

    public static int m$3(int i, int i2, int i3, int i4) {
        return zzii.zzg(i) + i2 + i3 + i4;
    }

    public static int m$4(int i, int i2, int i3, int i4) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i2 + i3 + i4;
    }

    public static int m$2(int i, int i2, int i3) {
        return zzada.zzE(i) + i2 + i3;
    }

    public static int m$3(int i, int i2, int i3) {
        return zzgr.zzz(i) + i2 + i3;
    }

    public static int m$1(int i, int i2, int i3, int i4) {
        return zzbn.zzt(i) + i2 + i3 + i4;
    }

    public static int m$1(int i, int i2, int i3) {
        return zzxb.zzD(i) + i2 + i3;
    }

    public static int m(int i, int i2, int i3, int i4) {
        return zzidj.zzF(i) + i2 + i3 + i4;
    }

    public static int m(KClass kClass, int i) {
        return String.valueOf(kClass).length() + i;
    }

    public static Float m(float f, TreeMap treeMap, Float f2, float f3) {
        treeMap.put(f2, Float.valueOf(f));
        return Float.valueOf(f3);
    }

    public static Object m(zzbk zzbkVar, int i, List list, int i2) {
        zzh.zza(zzbkVar.name(), i, list);
        return list.get(i2);
    }

    public static String m(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        return new ClusterId(i, str, str2, i2, defaultConstructorMarker).getTraitId();
    }

    public static String m(int i, KClass kClass, KClass kClass2, String str) {
        new StringBuilder(i);
        Objects.toString(kClass);
        return str.concat(String.valueOf(kClass2));
    }

    public static String m(Context context, int i) {
        context.getClass();
        String string = context.getString(i);
        string.getClass();
        return string;
    }

    public static String m(GoogleCalendarAlarmManager googleCalendarAlarmManager, StringBuilder sb, String str, String str2) {
        sb.append(googleCalendarAlarmManager.getTag());
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String m(GoogleFitApi googleFitApi, StringBuilder sb, String str, String str2) {
        sb.append(googleFitApi.getTag());
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String m(String str, PmdDataFrame.PmdDataFrameType pmdDataFrameType, String str2) {
        return str + pmdDataFrameType + str2;
    }

    public static int m(int i, int i2, int i3) {
        return zzpv.zzC(i) + i2 + i3;
    }

    public static void m(int i, String str) {
        Logger.logInfo(str + i);
    }

    public static void m(Context context, String str) {
        ContextExtKt.sendExplicitBroadcast(context, new Intent(str));
    }

    public static void m(zzic zzicVar, String str) {
        zzicVar.zzaW().zzb().zza(str);
    }

    public static void m(FirebaseAnalyticsManager firebaseAnalyticsManager, Bundle bundle, String str) {
        FirebaseAnalytics.getInstance(firebaseAnalyticsManager.context).logEvent(str, bundle);
    }

    public static void m(String str, String str2) {
        Logger.logInfo(str + str2);
    }

    public static void m(String str, boolean z) {
        Logger.logInfo(str + z);
    }

    public static void m(StringBuilder sb, int i) {
        sb.append(i);
        Logger.logInfo(sb.toString());
    }

    public static void m(StringBuilder sb, String str, Object obj, String str2, Object obj2) {
        sb.append(str);
        sb.append(obj);
        sb.append(str2);
        sb.append(obj2);
    }

    public static void m(StringBuilder sb, String str, boolean z, String str2, boolean z2) {
        sb.append(str);
        sb.append(z);
        sb.append(str2);
        sb.append(z2);
    }

    public static void m(StringBuilder sb, boolean z) {
        sb.append(z);
        Logger.logInfo(sb.toString());
    }
}

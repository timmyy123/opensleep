package com.google.android.gms.internal.serialization;

import android.util.Log;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0017¢\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0012J7\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0012J7\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0012J7\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/google/nest/platform/mesh/api/logger/AndroidPlatformLogger;", "Lcom/google/nest/platform/mesh/api/logger/PlatformLogger;", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "log", "", "logLevel", "Lcom/google/nest/platform/mesh/api/logger/LogLevel;", "message", "items", "", "", "(Lcom/google/nest/platform/mesh/api/logger/LogLevel;Ljava/lang/String;[Ljava/lang/Object;)V", "info", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "debug", "warn", "error", "java.com.google.nest.platform.mesh.api.logger_logger-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzrr {
    private final String zza;

    public zzrr(String str) {
        str.getClass();
        this.zza = str;
    }

    public final void zza(zzrs zzrsVar, String str, Object... objArr) {
        zzrsVar.getClass();
        str.getClass();
        objArr.getClass();
        zzrs zzrsVar2 = zzrs.zza;
        int iOrdinal = zzrsVar.ordinal();
        if (iOrdinal == 0) {
            String str2 = this.zza;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length);
            Log.i(str2, String.format(str, Arrays.copyOf(objArrCopyOf2, objArrCopyOf2.length)));
            return;
        }
        if (iOrdinal == 1) {
            String str3 = this.zza;
            Object[] objArrCopyOf3 = Arrays.copyOf(objArr, objArr.length);
            if (Log.isLoggable(str3, 3)) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                Object[] objArrCopyOf4 = Arrays.copyOf(objArrCopyOf3, objArrCopyOf3.length);
                Log.d(str3, String.format(str, Arrays.copyOf(objArrCopyOf4, objArrCopyOf4.length)));
                return;
            }
            return;
        }
        if (iOrdinal == 2) {
            String str4 = this.zza;
            Object[] objArrCopyOf5 = Arrays.copyOf(objArr, objArr.length);
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            Object[] objArrCopyOf6 = Arrays.copyOf(objArrCopyOf5, objArrCopyOf5.length);
            Log.w(str4, String.format(str, Arrays.copyOf(objArrCopyOf6, objArrCopyOf6.length)));
            return;
        }
        if (iOrdinal != 3) {
            Home$$ExternalSyntheticBUOutline0.m();
            return;
        }
        String str5 = this.zza;
        Object[] objArrCopyOf7 = Arrays.copyOf(objArr, objArr.length);
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        Object[] objArrCopyOf8 = Arrays.copyOf(objArrCopyOf7, objArrCopyOf7.length);
        Log.e(str5, String.format(str, Arrays.copyOf(objArrCopyOf8, objArrCopyOf8.length)));
    }
}

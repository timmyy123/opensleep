package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\rH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000eH&J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0012H\u0016J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0016H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;", "", "setIndent", "", "indent", "", "beginArray", "endArray", "beginObject", "endObject", "name", SDKConstants.PARAM_VALUE, "nullValue", "", "", "Lkotlin/UInt;", "value-WZ4Q5Ns", "(I)V", "", "Lkotlin/ULong;", "value-VKZWuLQ", "(J)V", "", "java.com.google.nest.platform.mesh.serialization.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface zzvv {
    void zza();

    void zzb();

    void zzc();

    void zzd();

    void zze(String str);

    void zzf(String str);

    void zzg();

    void zzh(boolean z);

    void zzi(double d);

    void zzj(Number number);

    default void zzk(long j) {
        int i = (int) j;
        if (i != j) {
            zzf(String.valueOf(j));
        } else {
            zzj(Integer.valueOf(i));
        }
    }
}

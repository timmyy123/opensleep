package com.google.android.gms.internal.serialization;

import android.util.JsonToken;
import kotlin.Metadata;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\t\u0010\u0007\u001a\u00020\bH¦\u0002J\u0011\u0010\t\u001a\u00060\nj\u0002`\u000bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u000f\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "", "beginArray", "", "endArray", "beginObject", "endObject", "hasNext", "", "peek", "Landroid/util/JsonToken;", "Lcom/google/nest/platform/mesh/serialization/json/JsonToken;", "()Landroid/util/JsonToken;", "nextName", "", "nextString", "nextBoolean", "nextNull", "nextDouble", "", "nextLong", "", "nextInt", "", "nextUInt", "Lkotlin/UInt;", "nextUInt-pVg5ArA", "()I", "nextULong", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "skipValue", "java.com.google.nest.platform.mesh.serialization.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface zzvs {
    void zza();

    void zzb();

    void zzc();

    void zzd();

    boolean zze();

    JsonToken zzf();

    String zzg();

    String zzh();

    boolean zzi();

    void zzj();

    void zzk();

    default int zzl() {
        return UStringsKt.toUInt(zzh());
    }

    default long zzm() {
        return UStringsKt.toULong(zzh());
    }
}

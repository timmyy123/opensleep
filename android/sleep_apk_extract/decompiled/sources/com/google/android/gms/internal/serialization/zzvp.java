package com.google.android.gms.internal.serialization;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\f\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/json/AndroidReader;", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "string", "", "reader", "Landroid/util/JsonReader;", "<init>", "(Ljava/lang/String;Landroid/util/JsonReader;)V", "getReader", "()Landroid/util/JsonReader;", "beginArray", "", "endArray", "beginObject", "endObject", "hasNext", "", "peek", "Landroid/util/JsonToken;", "Lcom/google/nest/platform/mesh/serialization/json/JsonToken;", "nextName", "nextString", "nextBoolean", "nextNull", "nextDouble", "", "nextLong", "", "nextInt", "", "skipValue", "java.com.google.nest.platform.mesh.serialization.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class zzvp implements zzvs {
    private final JsonReader zza;

    public zzvp(String str, JsonReader jsonReader) {
        str.getClass();
        jsonReader.getClass();
        this.zza = jsonReader;
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final void zza() throws IOException {
        this.zza.beginArray();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final void zzb() throws IOException {
        this.zza.endArray();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final void zzc() throws IOException {
        this.zza.beginObject();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final void zzd() throws IOException {
        this.zza.endObject();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final boolean zze() {
        return this.zza.hasNext();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final JsonToken zzf() throws IOException {
        JsonToken jsonTokenPeek = this.zza.peek();
        jsonTokenPeek.getClass();
        return jsonTokenPeek;
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final String zzg() throws IOException {
        String strNextName = this.zza.nextName();
        strNextName.getClass();
        return strNextName;
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final String zzh() throws IOException {
        String strNextString = this.zza.nextString();
        strNextString.getClass();
        return strNextString;
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final boolean zzi() {
        return this.zza.nextBoolean();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final void zzj() throws IOException {
        this.zza.nextNull();
    }

    @Override // com.google.android.gms.internal.serialization.zzvs
    public final void zzk() throws IOException {
        this.zza.skipValue();
    }
}

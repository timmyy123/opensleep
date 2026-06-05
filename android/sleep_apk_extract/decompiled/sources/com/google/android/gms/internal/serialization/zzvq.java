package com.google.android.gms.internal.serialization;

import android.util.JsonWriter;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.IOException;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/json/AndroidWriter;", "Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;", "stringWriter", "Ljava/io/StringWriter;", "writer", "Landroid/util/JsonWriter;", "<init>", "(Ljava/io/StringWriter;Landroid/util/JsonWriter;)V", "setIndent", "", "indent", "", "beginArray", "endArray", "beginObject", "endObject", "name", SDKConstants.PARAM_VALUE, "nullValue", "", "", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.serialization.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class zzvq implements zzvv {
    private final StringWriter zza;
    private final JsonWriter zzb;

    public /* synthetic */ zzvq(StringWriter stringWriter, JsonWriter jsonWriter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StringWriter stringWriter2 = new StringWriter();
        JsonWriter jsonWriter2 = new JsonWriter(stringWriter2);
        this.zza = stringWriter2;
        this.zzb = jsonWriter2;
    }

    public final String toString() throws IOException {
        this.zzb.flush();
        String string = this.zza.toString();
        string.getClass();
        return string;
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zza() throws IOException {
        this.zzb.beginArray();
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzb() throws IOException {
        this.zzb.endArray();
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzc() throws IOException {
        this.zzb.beginObject();
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzd() throws IOException {
        this.zzb.endObject();
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zze(String str) throws IOException {
        str.getClass();
        this.zzb.name(str);
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzf(String str) throws IOException {
        str.getClass();
        this.zzb.value(str);
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzg() throws IOException {
        this.zzb.nullValue();
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzh(boolean z) throws IOException {
        this.zzb.value(z);
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzi(double d) throws IOException {
        this.zzb.value(d);
    }

    @Override // com.google.android.gms.internal.serialization.zzvv
    public final void zzj(Number number) throws IOException {
        number.getClass();
        this.zzb.value(number);
    }
}

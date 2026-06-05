package com.google.android.gms.internal.serialization;

import android.util.JsonReader;
import java.io.StringReader;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/json/Json;", "", "<init>", "()V", "reader", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "json", "", "writer", "Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;", "java.com.google.nest.platform.mesh.serialization.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class zzvr {
    public static final zzvs zza(String str) {
        str.getClass();
        return new zzvp(str, new JsonReader(new StringReader(str)));
    }

    public static final zzvv zzb() {
        return new zzvq(null, null, 3, null);
    }
}

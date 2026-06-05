package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeap {
    public final long zza;
    public final int[] zzb;

    private zzeap(long j, int[] iArr) {
        this.zza = j;
        this.zzb = iArr;
    }

    public static zzgwm zza(JsonReader jsonReader) {
        int i = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            zzgwm zzgwmVarZzi = zzgwm.zzi();
            jsonReader.beginObject();
            zzeap zzeapVar = null;
            Long lValueOf = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (Objects.equals(strNextName, "id")) {
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                } else if (Objects.equals(strNextName, "event_types")) {
                    zzgwj zzgwjVar2 = new zzgwj();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzgwjVar2.zzf(Integer.valueOf(jsonReader.nextInt()));
                    }
                    jsonReader.endArray();
                    zzgwmVarZzi = zzgwjVar2.zzi();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (lValueOf != null && !zzgwmVarZzi.isEmpty()) {
                long jLongValue = lValueOf.longValue();
                int[] iArr = new int[zzgwmVarZzi.size()];
                for (int i2 = 0; i2 < zzgwmVarZzi.size(); i2++) {
                    iArr[i2] = ((Integer) zzgwmVarZzi.get(i2)).intValue();
                }
                zzeapVar = new zzeap(jLongValue, iArr);
            }
            if (zzeapVar != null) {
                zzgwjVar.zzf(zzeapVar);
            }
        }
        jsonReader.endArray();
        return zzgwjVar.zzi();
    }
}

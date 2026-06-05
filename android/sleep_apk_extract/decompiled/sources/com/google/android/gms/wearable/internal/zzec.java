package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class zzec extends DataBufferRef implements DataItem {
    private final int zza;

    public zzec(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zza = i2;
    }

    public final Map<String, DataItemAsset> getAssets() {
        int i = this.zza;
        HashMap map = new HashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            zzdy zzdyVar = new zzdy(this.mDataHolder, this.mDataRow + i2);
            if (zzdyVar.getString("asset_key") != null) {
                map.put(zzdyVar.getString("asset_key"), zzdyVar);
            }
        }
        return map;
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final String toString() {
        boolean zIsLoggable = Log.isLoggable("DataItem", 3);
        byte[] byteArray = getByteArray("data");
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemRef{ ");
        sb.append("uri=".concat(String.valueOf(getUri())));
        sb.append(", dataSz=".concat((byteArray == null ? "null" : Integer.valueOf(byteArray.length)).toString()));
        int size = assets.size();
        StringBuilder sb2 = new StringBuilder(String.valueOf(size).length() + 12);
        sb2.append(", numAssets=");
        sb2.append(size);
        sb.append(sb2.toString());
        if (zIsLoggable && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : assets.entrySet()) {
                String key = entry.getKey();
                String id = entry.getValue().getId();
                sb.append(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str.length() + String.valueOf(key).length() + 2 + String.valueOf(id).length()), str, key, ": ", id));
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }
}

package com.google.android.gms.wearable.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;

/* JADX INFO: loaded from: classes4.dex */
public final class zzdv extends DataBufferRef {
    private final int zza;

    public zzdv(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zza = i2;
    }

    public final DataItem getDataItem() {
        return new zzec(this.mDataHolder, this.mDataRow, this.zza);
    }

    public final String toString() {
        String str = getInteger("event_type") == 1 ? "changed" : getInteger("event_type") == 2 ? "deleted" : "unknown";
        String string = getDataItem().toString();
        StringBuilder sb = new StringBuilder(string.length() + 39);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "DataEventRef{ type=", str, ", dataitem=", string);
        sb.append(" }");
        return sb.toString();
    }
}

package com.google.android.gms.fitness.result;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Bucket;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataReadResponse extends Response<DataReadResult> {
    public List<Bucket> getBuckets() {
        return getResult().getBuckets();
    }

    public Status getStatus() {
        return getResult().getStatus();
    }
}

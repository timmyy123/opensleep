package com.urbandroid.sleep.service.samsung.shealth;

import com.facebook.GraphResponse;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.urbandroid.sleep.service.health.ResultStatus;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSHealthResultStatus implements ResultStatus {
    private final HealthResultHolder.BaseResult result;

    public SamsungSHealthResultStatus(HealthResultHolder.BaseResult baseResult) {
        this.result = baseResult;
    }

    @Override // com.urbandroid.sleep.service.health.ResultStatus
    public boolean isSuccess() {
        return this.result.getStatus() == 1;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("S Health Result: ");
        if (isSuccess()) {
            str = GraphResponse.SUCCESS_KEY;
        } else {
            str = "failure status=" + this.result.getStatus();
        }
        sb.append(str);
        if (this.result.getCount() > 1) {
            str2 = " count=" + this.result.getCount();
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }
}

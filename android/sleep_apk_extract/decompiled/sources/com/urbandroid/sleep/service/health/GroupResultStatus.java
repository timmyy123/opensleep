package com.urbandroid.sleep.service.health;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GroupResultStatus implements ResultStatus {
    private final List<ResultStatus> statuses = new ArrayList();

    private ResultStatus getStatus() {
        Iterator<ResultStatus> it = this.statuses.iterator();
        while (it.hasNext()) {
            if (!it.next().isSuccess()) {
                return ResultStatus.FAILURE;
            }
        }
        return ResultStatus.SUCCESS;
    }

    public void add(ResultStatus resultStatus) {
        this.statuses.add(resultStatus);
    }

    @Override // com.urbandroid.sleep.service.health.ResultStatus
    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public String toString() {
        return getStatus().toString();
    }
}

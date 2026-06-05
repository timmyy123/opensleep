package com.google.android.gms.home.matter.commissioning;

import android.content.IntentSender;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes5.dex */
public interface CommissioningClient {
    Task<IntentSender> commissionDevice(CommissioningRequest commissioningRequest);
}

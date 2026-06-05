package com.polar.androidcommunications.api.ble.model.gatt.client.psftp;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BlePsFtpClient$$ExternalSyntheticLambda1 implements Consumer, Action {
    public final /* synthetic */ BlePsFtpClient f$0;

    public /* synthetic */ BlePsFtpClient$$ExternalSyntheticLambda1(BlePsFtpClient blePsFtpClient) {
        this.f$0 = blePsFtpClient;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Object obj) {
        this.f$0.lambda$write$3((Subscription) obj);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        this.f$0.lambda$write$4();
    }
}

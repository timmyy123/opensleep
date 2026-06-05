package com.urbandroid.privacy;

import android.app.Activity;
import com.google.android.ump.ConsentInformation;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl;
import com.urbandroid.privacy.Consent;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Consent$Companion$$ExternalSyntheticLambda0 implements CompletableOnSubscribe, FlowableOnSubscribe, SingleOnSubscribe, ConsentInformation.OnConsentInfoUpdateSuccessListener {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ Consent$Companion$$ExternalSyntheticLambda0(Activity activity, ConsentInformation consentInformation, boolean z) {
        this.f$0 = activity;
        this.f$1 = consentInformation;
        this.f$2 = z;
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
    public void onConsentInfoUpdateSuccess() {
        Consent.Companion.loadAndShowConsent$lambda$0((Activity) this.f$0, (ConsentInformation) this.f$1, this.f$2);
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public void subscribe(CompletableEmitter completableEmitter) {
        ((BleGattBase) this.f$0).lambda$waitNotificationEnabled$1(this.f$2, (AtomicInteger) this.f$1, completableEmitter);
    }

    public /* synthetic */ Consent$Companion$$ExternalSyntheticLambda0(Object obj, boolean z, Serializable serializable) {
        this.f$0 = obj;
        this.f$2 = z;
        this.f$1 = serializable;
    }

    @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
    public void subscribe(FlowableEmitter flowableEmitter) {
        ((BDDeviceListenerImpl) this.f$0).lambda$search$0(this.f$2, (FlowableEmitter[]) this.f$1, flowableEmitter);
    }

    @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
    public void subscribe(SingleEmitter singleEmitter) {
        ((BDDeviceSessionImpl) this.f$0).lambda$monitorServicesDiscovered$5(this.f$2, (SingleEmitter[]) this.f$1, singleEmitter);
    }
}

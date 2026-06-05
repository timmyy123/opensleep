package com.facebook.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.LoginStatusCallback;
import com.facebook.internal.PlatformServiceClient;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdMeasurementType;
import com.polar.sdk.impl.BDBleApiImpl;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LoginManager$$ExternalSyntheticLambda1 implements PlatformServiceClient.CompletedListener, Action, OnSuccessListener, IBillingStatusListener, NativeAd.OnNativeAdLoadedListener {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ LoginManager$$ExternalSyntheticLambda1(NativeAdCard nativeAdCard, ViewGroup viewGroup, Function0 function0, String str) {
        this.f$3 = nativeAdCard;
        this.f$1 = viewGroup;
        this.f$2 = function0;
        this.f$0 = str;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        LoginManager.retrieveLoginStatusImpl$lambda$2((String) this.f$0, (LoginLogger) this.f$1, (LoginStatusCallback) this.f$2, (String) this.f$3, bundle);
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
    public void onNativeAdLoaded(NativeAd nativeAd) {
        NativeAdCard.createAdBuilder$lambda$0((NativeAdCard) this.f$3, (ViewGroup) this.f$1, (Function0) this.f$2, (String) this.f$0, nativeAd);
    }

    @Override // com.urbandroid.sleep.trial.IBillingStatusListener
    public void onStatusDetected(String str, IBillingStatusListener.Status status) {
        ((UnlockFlow) this.f$0).lambda$onStart$15((View) this.f$3, (View) this.f$1, (View) this.f$2, str, status);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((AlarmClock) this.f$0).lambda$showRatingPlayStore$25((Handler) this.f$3, (ReviewManager) this.f$1, (Settings) this.f$2, (ReviewInfo) obj);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        BDBleApiImpl.startStreaming$lambda$31((BDBleApiImpl) this.f$0, (BleDeviceSession) this.f$3, (BlePMDClient) this.f$1, (PmdMeasurementType) this.f$2);
    }

    public /* synthetic */ LoginManager$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f$0 = obj;
        this.f$3 = obj2;
        this.f$1 = obj3;
        this.f$2 = obj4;
    }

    public /* synthetic */ LoginManager$$ExternalSyntheticLambda1(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2) {
        this.f$0 = str;
        this.f$1 = loginLogger;
        this.f$2 = loginStatusCallback;
        this.f$3 = str2;
    }
}

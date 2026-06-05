package com.facebook.appevents;

import com.facebook.FacebookSdk$$ExternalSyntheticLambda3;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.gps.topics.GpsTopicsManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BannedParamManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.integrity.StdParamsEnforcementManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEventsManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppEventsManager {
    public static final AppEventsManager INSTANCE = new AppEventsManager();

    /* JADX INFO: renamed from: com.facebook.appevents.AppEventsManager$start$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$0(boolean z) {
            if (z) {
                MetadataIndexer.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$1(boolean z) {
            if (z) {
                RestrictiveDataManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$10(boolean z) {
            if (z) {
                RedactedEventsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$11(boolean z) {
            if (z) {
                SensitiveParamsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$12(boolean z) {
            if (z) {
                AppEventsCAPIManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$13(boolean z) {
            if (z) {
                GpsAraTriggersManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$14(boolean z) {
            if (z) {
                PACustomAudienceClient.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$15(boolean z) {
            if (z) {
                GpsTopicsManager.enableTopicsObservation();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$2(boolean z) {
            if (z) {
                ModelManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$3(boolean z) {
            if (z) {
                EventDeactivationManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$4(boolean z) {
            if (z) {
                BannedParamManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$5(boolean z) {
            if (z) {
                InAppPurchaseManager.enableAutoLogging();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$6(boolean z) {
            if (z) {
                StdParamsEnforcementManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$7(boolean z) {
            if (z) {
                ProtectedModeManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$8(boolean z) {
            if (z) {
                MACARuleMatchingManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$9(boolean z) {
            if (z) {
                BlocklistEventsManager.enable();
            }
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onError() {
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onSuccess(FetchedAppSettings fetchedAppSettings) {
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FacebookSdk$$ExternalSyntheticLambda3(6));
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FacebookSdk$$ExternalSyntheticLambda3(19));
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FacebookSdk$$ExternalSyntheticLambda3(20));
            FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FacebookSdk$$ExternalSyntheticLambda3(21));
            FeatureManager.checkFeature(FeatureManager.Feature.BannedParamFiltering, new FacebookSdk$$ExternalSyntheticLambda3(7));
            FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FacebookSdk$$ExternalSyntheticLambda3(8));
            FeatureManager.checkFeature(FeatureManager.Feature.StdParamEnforcement, new FacebookSdk$$ExternalSyntheticLambda3(9));
            FeatureManager.checkFeature(FeatureManager.Feature.ProtectedMode, new FacebookSdk$$ExternalSyntheticLambda3(10));
            FeatureManager.checkFeature(FeatureManager.Feature.MACARuleMatching, new FacebookSdk$$ExternalSyntheticLambda3(11));
            FeatureManager.checkFeature(FeatureManager.Feature.BlocklistEvents, new FacebookSdk$$ExternalSyntheticLambda3(12));
            FeatureManager.checkFeature(FeatureManager.Feature.FilterRedactedEvents, new FacebookSdk$$ExternalSyntheticLambda3(13));
            FeatureManager.checkFeature(FeatureManager.Feature.FilterSensitiveParams, new FacebookSdk$$ExternalSyntheticLambda3(14));
            FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new FacebookSdk$$ExternalSyntheticLambda3(15));
            FeatureManager.checkFeature(FeatureManager.Feature.GPSARATriggers, new FacebookSdk$$ExternalSyntheticLambda3(16));
            FeatureManager.checkFeature(FeatureManager.Feature.GPSPACAProcessing, new FacebookSdk$$ExternalSyntheticLambda3(17));
            FeatureManager.checkFeature(FeatureManager.Feature.GPSTopicsObservation, new FacebookSdk$$ExternalSyntheticLambda3(18));
        }
    }

    private AppEventsManager() {
    }

    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsManager.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager.getAppSettingsAsync(new AnonymousClass1());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsManager.class);
        }
    }
}

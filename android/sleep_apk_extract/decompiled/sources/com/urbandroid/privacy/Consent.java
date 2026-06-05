package com.urbandroid.privacy;

import android.app.Activity;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.privacy.Consent;
import com.urbandroid.sleep.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/privacy/Consent;", "Lcom/urbandroid/common/FeatureLogger;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Consent implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/privacy/Consent$Companion;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "debug", "Lcom/google/android/ump/ConsentRequestParameters;", "getParams", "(Landroid/content/Context;Z)Lcom/google/android/ump/ConsentRequestParameters;", "Landroid/app/Activity;", "activity", "", "showPrivacyOptionsForm", "(Landroid/app/Activity;)V", "privacyOptions", "loadAndShowConsent", "(Landroid/app/Activity;ZZ)V", "canServeAds", "(Landroid/content/Context;)Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ConsentRequestParameters getParams(Context context, boolean debug) {
            ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
            builder.setAdMobAppId(context.getString(R.string.admob_app_id));
            if (debug) {
                builder.setConsentDebugSettings(new ConsentDebugSettings.Builder(context).setForceTesting(true).setDebugGeography(1).addTestDeviceHashedId("98C4F04E409732EF0B3C1E74BD096C4E").build());
            }
            ConsentRequestParameters consentRequestParametersBuild = builder.build();
            consentRequestParametersBuild.getClass();
            return consentRequestParametersBuild;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void loadAndShowConsent$lambda$0(final Activity activity, final ConsentInformation consentInformation, final boolean z) {
            UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.urbandroid.privacy.Consent$Companion$$ExternalSyntheticLambda2
                @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
                public final void onConsentFormDismissed(FormError formError) {
                    Consent.Companion.loadAndShowConsent$lambda$0$0(consentInformation, z, activity, formError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void loadAndShowConsent$lambda$0$0(ConsentInformation consentInformation, boolean z, Activity activity, FormError formError) {
            Logger.logWarning("Load Show Error " + (formError != null ? Integer.valueOf(formError.getErrorCode()) : null) + " " + (formError != null ? formError.getMessage() : null), null);
            Logger.logInfo("Consent, can request ads " + consentInformation.canRequestAds() + " status " + consentInformation.getConsentStatus(), null);
            if (z) {
                Consent.INSTANCE.showPrivacyOptionsForm(activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void loadAndShowConsent$lambda$1(FormError formError) {
            Logger.logWarning("Request Error " + formError.getErrorCode() + " " + formError.getMessage(), null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showPrivacyOptionsForm$lambda$0(FormError formError) {
            if (formError != null) {
                Logger.logInfo("Consent, can request error " + formError.getErrorCode() + " message " + formError.getMessage(), null);
            }
        }

        public final boolean canServeAds(Context context) {
            context.getClass();
            return UserMessagingPlatform.getConsentInformation(context).canRequestAds();
        }

        public final void loadAndShowConsent(Activity activity, boolean privacyOptions, boolean debug) {
            activity.getClass();
            ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(activity);
            if (debug) {
                consentInformation.reset();
            }
            consentInformation.requestConsentInfoUpdate(activity, getParams(activity, debug), new Consent$Companion$$ExternalSyntheticLambda0(activity, consentInformation, privacyOptions), new Home$$ExternalSyntheticBUOutline0(23));
        }

        public final void showPrivacyOptionsForm(Activity activity) {
            activity.getClass();
            UserMessagingPlatform.showPrivacyOptionsForm(activity, new Consent$Companion$$ExternalSyntheticLambda3());
        }

        private Companion() {
        }
    }
}

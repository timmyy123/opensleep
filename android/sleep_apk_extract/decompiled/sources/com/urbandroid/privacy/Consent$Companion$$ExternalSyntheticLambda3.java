package com.urbandroid.privacy;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.urbandroid.privacy.Consent;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Consent$Companion$$ExternalSyntheticLambda3 implements ConsentForm.OnConsentFormDismissedListener {
    @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
    public final void onConsentFormDismissed(FormError formError) {
        Consent.Companion.showPrivacyOptionsForm$lambda$0(formError);
    }
}

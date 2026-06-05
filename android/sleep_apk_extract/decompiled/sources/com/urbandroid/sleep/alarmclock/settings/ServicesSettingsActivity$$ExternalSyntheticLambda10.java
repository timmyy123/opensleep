package com.urbandroid.sleep.alarmclock.settings;

import androidx.view.result.ActivityResultCallback;
import com.google.android.gms.common.api.Status;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ServicesSettingsActivity$$ExternalSyntheticLambda10 implements ActivityResultCallback, GoogleFitApiFactory.DisconnectAppFromFitListener {
    public final /* synthetic */ ServicesSettingsActivity f$0;

    public /* synthetic */ ServicesSettingsActivity$$ExternalSyntheticLambda10(ServicesSettingsActivity servicesSettingsActivity) {
        this.f$0 = servicesSettingsActivity;
    }

    public void disconnected(Status status) {
        ServicesSettingsActivity.refresh$lambda$5$0$3(this.f$0, status);
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ServicesSettingsActivity.requestPermissions$lambda$0(this.f$0, (Set) obj);
    }
}

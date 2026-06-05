package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class InstallException extends ApiException {
    public InstallException(int i) {
        super(new Status(i, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i), com.google.android.play.core.install.model.zza.zza(i))));
        if (i != 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("errorCode should not be 0.");
        throw null;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}

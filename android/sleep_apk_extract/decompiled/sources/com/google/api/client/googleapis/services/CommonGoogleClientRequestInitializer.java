package com.google.api.client.googleapis.services;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonGoogleClientRequestInitializer implements GoogleClientRequestInitializer {
    private final String key;
    private final String userIp;

    public CommonGoogleClientRequestInitializer(String str, String str2) {
        this.key = str;
        this.userIp = str2;
    }

    @Override // com.google.api.client.googleapis.services.GoogleClientRequestInitializer
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
        String str = this.key;
        if (str != null) {
            abstractGoogleClientRequest.put(SDKConstants.PARAM_KEY, (Object) str);
        }
        String str2 = this.userIp;
        if (str2 != null) {
            abstractGoogleClientRequest.put("userIp", (Object) str2);
        }
    }

    public CommonGoogleClientRequestInitializer(String str) {
        this(str, null);
    }
}

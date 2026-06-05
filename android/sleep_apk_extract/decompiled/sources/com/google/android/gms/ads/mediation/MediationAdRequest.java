package com.google.android.gms.ads.mediation;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface MediationAdRequest {
    Set<String> getKeywords();

    @Deprecated
    boolean isDesignedForFamilies();

    boolean isTesting();

    int taggedForChildDirectedTreatment();
}

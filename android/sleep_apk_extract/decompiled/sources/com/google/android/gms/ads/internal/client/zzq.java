package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzq {
    public static final zzq zza = new zzq();

    public final zzm zza(Context context, zzeh zzehVar) {
        String strZzx;
        String strZza = zzehVar.zza();
        Set setZzc = zzehVar.zzc();
        List listUnmodifiableList = !setZzc.isEmpty() ? Collections.unmodifiableList(new ArrayList(setZzc)) : null;
        boolean zZzh = zzehVar.zzh(context);
        Bundle bundleZzd = zzehVar.zzd(AdMobAdapter.class);
        String strZzf = zzehVar.zzf();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zza();
            strZzx = com.google.android.gms.ads.internal.util.client.zzf.zzx(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strZzx = null;
        }
        boolean zZzm = zzehVar.zzm();
        RequestConfiguration requestConfigurationZzp = zzeu.zzb().zzp();
        return new zzm(8, -1L, bundleZzd, -1, listUnmodifiableList, zZzh, Math.max(zzehVar.zzj(), requestConfigurationZzp.getTagForChildDirectedTreatment()), false, strZzf, null, null, strZza, zzehVar.zzi(), zzehVar.zzk(), Collections.unmodifiableList(new ArrayList(zzehVar.zzl())), zzehVar.zzg(), strZzx, zZzm, null, requestConfigurationZzp.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(null, requestConfigurationZzp.getMaxAdContentRating()), zzp.zza), zzehVar.zzb(), zzehVar.zzo(), zzehVar.zzn(), requestConfigurationZzp.getPublisherPrivacyPersonalizationState().getValue(), zzehVar.zzq(), zzehVar.zzr());
    }
}

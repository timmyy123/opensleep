package com.google.android.gms.auth;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zze {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    public static final Feature zzi;
    public static final Feature zzj;
    public static final Feature zzk;
    public static final Feature zzl;
    public static final Feature zzm;
    public static final Feature zzn;
    public static final Feature zzo;
    public static final Feature zzp;
    public static final Feature[] zzq;

    static {
        Feature feature = new Feature("account_capability_api", 1L);
        zza = feature;
        Feature feature2 = new Feature("account_data_service", 6L);
        zzb = feature2;
        Feature feature3 = new Feature("account_data_service_legacy", 1L);
        zzc = feature3;
        Feature feature4 = new Feature("account_data_service_token", 8L);
        zzd = feature4;
        Feature feature5 = new Feature("account_data_service_visibility", 1L);
        zze = feature5;
        Feature feature6 = new Feature("config_sync", 1L);
        zzf = feature6;
        Feature feature7 = new Feature("device_account_api", 1L);
        zzg = feature7;
        Feature feature8 = new Feature("device_account_jwt_creation", 1L);
        zzh = feature8;
        Feature feature9 = new Feature("gaiaid_primary_email_api", 1L);
        zzi = feature9;
        Feature feature10 = new Feature("get_restricted_accounts_api", 1L);
        zzj = feature10;
        Feature feature11 = new Feature("google_auth_service_accounts", 2L);
        zzk = feature11;
        Feature feature12 = new Feature("google_auth_service_token", 3L);
        zzl = feature12;
        Feature feature13 = new Feature("hub_mode_api", 1L);
        zzm = feature13;
        Feature feature14 = new Feature("work_account_client_is_whitelisted", 1L);
        zzn = feature14;
        Feature feature15 = new Feature("factory_reset_protection_api", 1L);
        zzo = feature15;
        Feature feature16 = new Feature("google_auth_api", 1L);
        zzp = feature16;
        zzq = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, feature11, feature12, feature13, feature14, feature15, feature16};
    }
}

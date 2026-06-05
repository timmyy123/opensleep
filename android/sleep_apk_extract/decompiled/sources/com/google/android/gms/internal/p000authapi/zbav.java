package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zbav {
    public static final Feature zba;
    public static final Feature zbb;
    public static final Feature zbc;
    public static final Feature zbd;
    public static final Feature zbe;
    public static final Feature zbf;
    public static final Feature zbg;
    public static final Feature zbh;
    public static final Feature zbi;
    public static final Feature zbj;
    public static final Feature zbk;
    public static final Feature zbl;
    public static final Feature zbm;
    public static final Feature zbn;
    public static final Feature zbo;
    public static final Feature zbp;
    public static final Feature zbq;
    public static final Feature zbr;
    public static final Feature zbs;
    public static final Feature zbt;
    public static final Feature zbu;
    public static final Feature zbv;
    public static final Feature zbw;
    public static final Feature[] zbx;

    static {
        Feature feature = new Feature("auth_api_credentials_begin_sign_in", 9L, true);
        zba = feature;
        Feature feature2 = new Feature("auth_api_credentials_sign_out", 2L, true);
        zbb = feature2;
        Feature feature3 = new Feature("auth_api_credentials_authorize", 1L, true);
        zbc = feature3;
        Feature feature4 = new Feature("auth_api_credentials_revoke_access", 1L, true);
        zbd = feature4;
        Feature feature5 = new Feature("auth_api_credentials_clear_token", 1L, true);
        zbe = feature5;
        Feature feature6 = new Feature("auth_api_credentials_save_password", 4L, true);
        zbf = feature6;
        Feature feature7 = new Feature("auth_api_credentials_get_sign_in_intent", 6L, true);
        zbg = feature7;
        Feature feature8 = new Feature("auth_api_credentials_save_account_linking_token", 3L, true);
        zbh = feature8;
        Feature feature9 = new Feature("auth_api_credentials_get_phone_number_hint_intent", 3L, true);
        zbi = feature9;
        Feature feature10 = new Feature("auth_api_credentials_verify_with_google", 1L, true);
        zbj = feature10;
        Feature feature11 = new Feature("auth_api_credentials_credential_provider", 1L, true);
        zbk = feature11;
        Feature feature12 = new Feature("auth_api_credentials_save_webauthn_credential_specifics", 1L, true);
        zbl = feature12;
        Feature feature13 = new Feature("auth_api_credentials_delete_webauthn_credential_specifics", 1L, false);
        zbm = feature13;
        Feature feature14 = new Feature("auth_api_credentials_list_webauthn_credential_specifics", 1L, true);
        zbn = feature14;
        Feature feature15 = new Feature("auth_api_credentials_get_google_passkey_for_export", 2L, true);
        zbo = feature15;
        Feature feature16 = new Feature("auth_api_credentials_get_authentication_intent", 1L, true);
        zbp = feature16;
        Feature feature17 = new Feature("auth_api_credentials_get_registration_intent", 1L, true);
        zbq = feature17;
        Feature feature18 = new Feature("auth_api_credentials_check_key_availability", 1L, true);
        zbr = feature18;
        Feature feature19 = new Feature("auth_api_credentials_has_discoverable_key", 1L, true);
        zbs = feature19;
        Feature feature20 = new Feature("auth_api_credentials_validate_calling_browser", 1L, true);
        zbt = feature20;
        Feature feature21 = new Feature("auth_api_credentials_validate_rp_id_and_calling_package", 1L, true);
        zbu = feature21;
        Feature feature22 = new Feature("auth_api_credentials_get_credential_list_for_browser", 1L, true);
        zbv = feature22;
        Feature feature23 = new Feature("auth_api_credentials_update_webauthn_credential_specifics", 1L, true);
        zbw = feature23;
        zbx = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, feature11, feature12, feature13, feature14, feature15, feature16, feature17, feature18, feature19, feature20, feature21, feature22, feature23};
    }
}

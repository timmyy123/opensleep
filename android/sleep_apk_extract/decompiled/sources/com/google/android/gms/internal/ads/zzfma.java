package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfma {
    public static com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        if (th instanceof zzelw) {
            zzelw zzelwVar = (zzelw) th;
            return zzc(zzelwVar.zza(), zzelwVar.zzb());
        }
        if (th instanceof zzeed) {
            return th.getMessage() == null ? zzd(((zzeed) th).zza(), null, null) : zzd(((zzeed) th).zza(), th.getMessage(), null);
        }
        if (!(th instanceof com.google.android.gms.ads.internal.util.zzaz)) {
            return zzd(1, null, null);
        }
        com.google.android.gms.ads.internal.util.zzaz zzazVar = (com.google.android.gms.ads.internal.util.zzaz) th;
        return new com.google.android.gms.ads.internal.client.zze(zzazVar.zza(), zzgua.zza(zzazVar.getMessage()), "com.google.android.gms.ads", null, null);
    }

    public static com.google.android.gms.ads.internal.client.zze zzb(Throwable th, zzelx zzelxVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar;
        com.google.android.gms.ads.internal.client.zze zzeVarZza = zza(th);
        int i = zzeVarZza.zza;
        if ((i == 3 || i == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals("com.google.android.gms.ads")) {
            zzeVarZza.zzd = null;
        }
        if (zzelxVar != null) {
            zzeVarZza.zze = zzelxVar.zzf();
        }
        return zzeVarZza;
    }

    public static com.google.android.gms.ads.internal.client.zze zzc(int i, com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (i == 0) {
            throw null;
        }
        if (i == 8) {
            if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjA)).intValue() > 0) {
                return zzeVar;
            }
            i = 8;
        }
        return zzd(i, null, zzeVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.google.android.gms.ads.internal.client.zze zzd(int i, String str, com.google.android.gms.ads.internal.client.zze zzeVar) {
        String str2;
        int i2 = i - 1;
        if (str == null) {
            if (i == 0) {
                throw null;
            }
            str = "No fill.";
            switch (i2) {
                case 1:
                    str = "Invalid request.";
                    break;
                case 2:
                    break;
                case 3:
                    str = "App ID missing.";
                    break;
                case 4:
                    str = "Network error.";
                    break;
                case 5:
                    str = "Invalid request: Invalid ad unit ID.";
                    break;
                case 6:
                    str = "Invalid request: Invalid ad size.";
                    break;
                case 7:
                    str = "A mediation adapter failed to show the ad.";
                    break;
                case 8:
                    str = "The ad is not ready.";
                    break;
                case 9:
                    str = "The ad has already been shown.";
                    break;
                case 10:
                    str = "The ad can not be shown when app is not in foreground.";
                    break;
                case 11:
                default:
                    str = "Internal error.";
                    break;
                case 12:
                    if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjD)).intValue() <= 0) {
                        str = "The mediation adapter did not return an ad.";
                    }
                    break;
                case 13:
                    str = "Mismatch request IDs.";
                    break;
                case 14:
                    str = "Invalid ad string.";
                    break;
                case 15:
                    str = "Ad inspector had an internal error.";
                    break;
                case 16:
                    str = "Ad inspector failed to load.";
                    break;
                case 17:
                    str = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.";
                    break;
                case 18:
                    str = "Ad inspector cannot be opened because it is already open.";
                    break;
            }
        }
        String str3 = str;
        if (i == 0) {
            throw null;
        }
        int i3 = 0;
        int i4 = 2;
        switch (i2) {
            case 0:
            case 11:
            case 15:
                i4 = i3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 1:
            case 5:
            case 6:
            case 9:
            case 16:
                i4 = 1;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 2:
            case 10:
            case 18:
                i4 = 3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 3:
                i3 = 8;
                i4 = i3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 4:
            case 8:
            case 17:
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 7:
                i3 = 4;
                i4 = i3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 12:
                if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjD)).intValue() <= 0) {
                    i3 = 9;
                    i4 = i3;
                    return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
                }
                i4 = 3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 13:
                i3 = 10;
                i4 = i3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            case 14:
                i3 = 11;
                i4 = i3;
                return new com.google.android.gms.ads.internal.client.zze(i4, str3, "com.google.android.gms.ads", zzeVar, null);
            default:
                switch (i) {
                    case 1:
                        str2 = "INTERNAL_ERROR";
                        break;
                    case 2:
                        str2 = "INVALID_REQUEST";
                        break;
                    case 3:
                        str2 = "NO_FILL";
                        break;
                    case 4:
                        str2 = "APP_ID_MISSING";
                        break;
                    case 5:
                        str2 = "NETWORK_ERROR";
                        break;
                    case 6:
                        str2 = "INVALID_AD_UNIT_ID";
                        break;
                    case 7:
                        str2 = "INVALID_AD_SIZE";
                        break;
                    case 8:
                        str2 = "MEDIATION_SHOW_ERROR";
                        break;
                    case 9:
                        str2 = "NOT_READY";
                        break;
                    case 10:
                        str2 = "AD_REUSED";
                        break;
                    case 11:
                        str2 = "APP_NOT_FOREGROUND";
                        break;
                    case 12:
                        str2 = "INTERNAL_SHOW_ERROR";
                        break;
                    case 13:
                        str2 = "MEDIATION_NO_FILL";
                        break;
                    case 14:
                        str2 = "REQUEST_ID_MISMATCH";
                        break;
                    case 15:
                        str2 = "INVALID_AD_STRING";
                        break;
                    case 16:
                        str2 = "AD_INSPECTOR_INTERNAL_ERROR";
                        break;
                    case 17:
                        str2 = "AD_INSPECTOR_FAILED_TO_LOAD";
                        break;
                    case 18:
                        str2 = "AD_INSPECTOR_NOT_IN_TEST_MODE";
                        break;
                    default:
                        str2 = "AD_INSPECTOR_ALREADY_OPEN";
                        break;
                }
                throw new AssertionError("Unknown SdkError: ".concat(str2));
        }
    }
}

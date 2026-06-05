package com.google.android.gms.fitness;

import android.accounts.Account;
import android.content.Context;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.fitness.zzag;
import com.google.android.gms.internal.fitness.zzal;
import com.google.android.gms.internal.fitness.zzaq;
import com.google.android.gms.internal.fitness.zzch;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import com.google.android.gms.internal.fitness.zzcz;
import com.google.android.gms.internal.fitness.zzdg;
import com.google.android.gms.internal.fitness.zzdk;
import com.google.android.gms.internal.fitness.zzdt;
import com.google.android.gms.internal.fitness.zzk;
import com.google.android.gms.internal.fitness.zzp;
import com.google.android.gms.internal.fitness.zzt;
import com.google.android.gms.internal.fitness.zzy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Fitness {

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> SENSORS_API = zzal.zzf;

    @Deprecated
    public static final SensorsApi SensorsApi = new zzdk();

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> RECORDING_API = zzag.zzf;

    @Deprecated
    public static final RecordingApi RecordingApi = new zzdg();

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> SESSIONS_API = zzaq.zzf;

    @Deprecated
    public static final SessionsApi SessionsApi = new zzdt();

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> HISTORY_API = zzy.zzf;

    @Deprecated
    public static final HistoryApi HistoryApi = new zzcz();

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> GOALS_API = zzt.zzf;

    @Deprecated
    public static final GoalsApi GoalsApi = new zzcp();

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> CONFIG_API = zzp.zzf;

    @Deprecated
    public static final ConfigApi ConfigApi = new zzcm();

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> BLE_API = zzk.zzf;

    @Deprecated
    public static final BleApi BleApi = new zzch();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    public static final Scope SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
    public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
    public static final Scope SCOPE_NUTRITION_READ = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");

    static {
        new Scope("https://www.googleapis.com/auth/fitness.heart_rate.read");
        new Scope("https://www.googleapis.com/auth/fitness.heart_rate.write");
        new Scope("https://www.googleapis.com/auth/fitness.respiratory_rate.read");
        new Scope("https://www.googleapis.com/auth/fitness.respiratory_rate.write");
        new Scope("https://www.googleapis.com/auth/fitness.sleep.read");
        new Scope("https://www.googleapis.com/auth/fitness.sleep.write");
        GoogleSignInAccount.fromAccount(new Account(IntegrityManager.INTEGRITY_TYPE_NONE, "com.google"));
    }

    @Deprecated
    public static ConfigClient getConfigClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new ConfigClient(context, new zzh(context, googleSignInAccount));
    }

    @Deprecated
    public static GoalsClient getGoalsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new GoalsClient(context, new zzh(context, googleSignInAccount));
    }

    @Deprecated
    public static HistoryClient getHistoryClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new HistoryClient(context, new zzh(context, googleSignInAccount));
    }

    @Deprecated
    public static SessionsClient getSessionsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new SessionsClient(context, new zzh(context, googleSignInAccount));
    }
}

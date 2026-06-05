package com.spotify.sdk.android.auth.app;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.spotify.sdk.android.auth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyNativeAuthUtil {
    private static final String[] SPOTIFY_PACKAGE_SUFFIXES = {".debug", ".canary", ".partners", ""};
    private static final String[] SPOTIFY_SIGNATURE_HASH = {"25a9b2d2745c098361edaa3b87936dc29a28e7f1", "80abdd17dcc4cb3a33815d354355bf87c9378624", "88df4d670ed5e01fc7b3eff13b63258628ff5a00", "d834ae340d1e854c5f4092722f9788216d9221e5", "1cbedd9e7345f64649bad2b493a20d9eea955352", "4b3d76a2de89033ea830f476a1f815692938e33b"};
    private final Activity mContextActivity;
    private final AuthorizationRequest mRequest;
    private final Sha1HashUtil mSha1HashUtil;

    public SpotifyNativeAuthUtil(Activity activity, AuthorizationRequest authorizationRequest, Sha1HashUtil sha1HashUtil) {
        this.mContextActivity = activity;
        this.mRequest = authorizationRequest;
        this.mSha1HashUtil = sha1HashUtil;
    }

    public static Intent createAuthActivityIntent(Context context, Sha1HashUtil sha1HashUtil) {
        Intent intentTryResolveActivity = null;
        for (String str : SPOTIFY_PACKAGE_SUFFIXES) {
            intentTryResolveActivity = tryResolveActivity(context, FileInsert$$ExternalSyntheticOutline0.m("com.spotify.music", str), sha1HashUtil);
            if (intentTryResolveActivity != null) {
                return intentTryResolveActivity;
            }
        }
        return intentTryResolveActivity;
    }

    private static Intent tryResolveActivity(Context context, String str, Sha1HashUtil sha1HashUtil) {
        Intent intent = new Intent("com.spotify.sso.action.START_AUTH_FLOW");
        intent.setPackage(str);
        ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
        if (componentNameResolveActivity != null && validateSignature(context, componentNameResolveActivity.getPackageName(), sha1HashUtil)) {
            return intent;
        }
        return null;
    }

    private static boolean validateSignature(Context context, String str, Sha1HashUtil sha1HashUtil) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return validateSignatures(sha1HashUtil, context.getPackageManager().getPackageInfo(str, 64).signatures);
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo == null) {
                return false;
            }
            boolean zHasMultipleSigners = signingInfo.hasMultipleSigners();
            SigningInfo signingInfo2 = packageInfo.signingInfo;
            return zHasMultipleSigners ? validateSignatures(sha1HashUtil, signingInfo2.getApkContentsSigners()) : validateSignatures(sha1HashUtil, signingInfo2.getSigningCertificateHistory());
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean validateSignatures(Sha1HashUtil sha1HashUtil, Signature[] signatureArr) {
        if (signatureArr == null || signatureArr.length == 0) {
            return false;
        }
        int length = signatureArr.length;
        int i = 0;
        while (i < length) {
            String strSha1Hash = sha1HashUtil.sha1Hash(signatureArr[i].toCharsString());
            for (String str : SPOTIFY_SIGNATURE_HASH) {
                if (str.equalsIgnoreCase(strSha1Hash)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public boolean startAuthActivity() {
        Intent intentCreateAuthActivityIntent = createAuthActivityIntent(this.mContextActivity, this.mSha1HashUtil);
        if (intentCreateAuthActivityIntent == null) {
            return false;
        }
        intentCreateAuthActivityIntent.putExtra("VERSION", 1);
        intentCreateAuthActivityIntent.putExtra("CLIENT_ID", this.mRequest.getClientId());
        intentCreateAuthActivityIntent.putExtra("REDIRECT_URI", this.mRequest.getRedirectUri());
        intentCreateAuthActivityIntent.putExtra("RESPONSE_TYPE", this.mRequest.getResponseType());
        intentCreateAuthActivityIntent.putExtra("SCOPES", this.mRequest.getScopes());
        intentCreateAuthActivityIntent.putExtra("STATE", this.mRequest.getState());
        intentCreateAuthActivityIntent.putExtra("UTM_SOURCE", this.mRequest.getSource());
        intentCreateAuthActivityIntent.putExtra("UTM_CAMPAIGN", this.mRequest.getCampaign());
        intentCreateAuthActivityIntent.putExtra("UTM_MEDIUM", this.mRequest.getMedium());
        try {
            this.mContextActivity.startActivityForResult(intentCreateAuthActivityIntent, 1138);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public void stopAuthActivity() {
        this.mContextActivity.finishActivity(1138);
    }
}

package com.facebook.gamingservices.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/gamingservices/internal/TournamentJoinDialogURIBuilder;", "", "()V", "baseUriBuilder", "Landroid/net/Uri$Builder;", "bundle", "Landroid/os/Bundle;", SDKConstants.PARAM_APP_ID, "", "tournamentID", "payload", "bundle$facebook_gamingservices_release", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "uri$facebook_gamingservices_release", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TournamentJoinDialogURIBuilder {
    public static final TournamentJoinDialogURIBuilder INSTANCE = new TournamentJoinDialogURIBuilder();

    private TournamentJoinDialogURIBuilder() {
    }

    private final Uri.Builder baseUriBuilder() {
        Uri.Builder builderAppendPath = new Uri.Builder().scheme(TournamentShareDialogURIBuilder.scheme).authority(FacebookSdk.getFacebookGamingDomain()).appendPath("dialog").appendPath("join_tournament");
        builderAppendPath.getClass();
        return builderAppendPath;
    }

    public static /* synthetic */ Bundle bundle$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return tournamentJoinDialogURIBuilder.bundle$facebook_gamingservices_release(str, str2, str3);
    }

    public static /* synthetic */ Uri uri$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return tournamentJoinDialogURIBuilder.uri$facebook_gamingservices_release(str, str2);
    }

    public final Bundle bundle$facebook_gamingservices_release(String appID, String tournamentID, String payload) {
        appID.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        if (tournamentID != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID);
        }
        if (payload != null) {
            bundle.putString("payload", payload);
        }
        return bundle;
    }

    public final Uri uri$facebook_gamingservices_release(String tournamentID, String payload) {
        Uri.Builder builderBaseUriBuilder = baseUriBuilder();
        if (tournamentID != null) {
            builderBaseUriBuilder.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID);
        }
        if (payload != null) {
            builderBaseUriBuilder.appendQueryParameter("payload", payload);
        }
        Uri uriBuild = builderBaseUriBuilder.build();
        uriBuild.getClass();
        return uriBuild;
    }
}

package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppToUserNotificationSender {
    private static Bundle getParameters() {
        return zzba$$ExternalSyntheticOutline0.m("upload_source", "A2U");
    }

    public static void scheduleAppToUserNotification(String str, String str2, Bitmap bitmap, int i, String str3, GraphRequest.Callback callback) {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, bitmap, getParameters(), new MediaUploadCallback(str, str2, i, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, File file, int i, String str3, GraphRequest.Callback callback) {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, file, getParameters(), new MediaUploadCallback(str, str2, i, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, Uri uri, int i, String str3, GraphRequest.Callback callback) {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, uri, getParameters(), new MediaUploadCallback(str, str2, i, str3, callback));
    }
}

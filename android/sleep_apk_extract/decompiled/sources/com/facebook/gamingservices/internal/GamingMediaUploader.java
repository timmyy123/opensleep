package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J.\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/gamingservices/internal/GamingMediaUploader;", "", "()V", "photoUploadEdge", "", "uploadToGamingServices", "Lcom/facebook/GraphRequestAsyncTask;", ShareConstants.FEED_CAPTION_PARAM, "imageBitmap", "Landroid/graphics/Bitmap;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "callback", "Lcom/facebook/GraphRequest$Callback;", "imageUri", "Landroid/net/Uri;", "imageFile", "Ljava/io/File;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GamingMediaUploader {
    public static final GamingMediaUploader INSTANCE = new GamingMediaUploader();
    private static final String photoUploadEdge = "me/photos";

    private GamingMediaUploader() {
    }

    public static final GraphRequestAsyncTask uploadToGamingServices(String caption, Uri imageUri, Bundle params, GraphRequest.Callback callback) {
        imageUri.getClass();
        if (Utility.isFileUri(imageUri) || Utility.isContentUri(imageUri)) {
            return GraphRequest.INSTANCE.newUploadPhotoRequest(AccessToken.INSTANCE.getCurrentAccessToken(), photoUploadEdge, imageUri, caption, params, callback).executeAsync();
        }
        Bundle bundle = new Bundle();
        if (params != null) {
            bundle.putAll(params);
        }
        bundle.putString("url", imageUri.toString());
        if (caption != null && caption.length() != 0) {
            bundle.putString(ShareConstants.FEED_CAPTION_PARAM, caption);
        }
        return new GraphRequest(AccessToken.INSTANCE.getCurrentAccessToken(), photoUploadEdge, bundle, HttpMethod.POST, callback, null, 32, null).executeAsync();
    }

    public static final GraphRequestAsyncTask uploadToGamingServices(String caption, File imageFile, Bundle params, GraphRequest.Callback callback) {
        imageFile.getClass();
        return GraphRequest.INSTANCE.newUploadPhotoRequest(AccessToken.INSTANCE.getCurrentAccessToken(), photoUploadEdge, imageFile, caption, params, callback).executeAsync();
    }

    public static final GraphRequestAsyncTask uploadToGamingServices(String caption, Bitmap imageBitmap, Bundle params, GraphRequest.Callback callback) {
        imageBitmap.getClass();
        return GraphRequest.INSTANCE.newUploadPhotoRequest(AccessToken.INSTANCE.getCurrentAccessToken(), photoUploadEdge, imageBitmap, caption, params, callback).executeAsync();
    }
}

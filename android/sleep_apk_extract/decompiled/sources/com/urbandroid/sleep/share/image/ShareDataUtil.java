package com.urbandroid.sleep.share.image;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.facebook.share.widget.ShareDialog;
import com.urbandroid.common.logging.Logger;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ShareDataUtil {
    public static Intent createIntent(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.addFlags(1);
        if (str2 != null) {
            intent.putExtra("android.intent.extra.TEXT", str2);
        }
        intent.putExtra("android.intent.extra.STREAM", getDataUri(context, str));
        return intent;
    }

    private static Uri getDataUri(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        Uri uriForFile = FileProvider.getUriForFile(context, "com.urbandroid.sleep.fileprovider", new File(FileInsert$$ExternalSyntheticOutline0.m(sb, File.separator, ShareDialog.WEB_SHARE_DIALOG), str));
        Logger.logInfo("FileProvider: Getting uri'" + uriForFile + "'");
        return uriForFile;
    }

    public static void saveData(Context context, String str, byte[] bArr) {
        new File(context.getCacheDir(), ShareDialog.WEB_SHARE_DIALOG).mkdirs();
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        File file = new File(FileInsert$$ExternalSyntheticOutline0.m(sb, File.separator, ShareDialog.WEB_SHARE_DIALOG), str);
        Logger.logInfo("FileProvider: Saving share file '" + file + "'");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArr);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}

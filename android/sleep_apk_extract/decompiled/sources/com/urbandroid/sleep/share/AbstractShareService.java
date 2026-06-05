package com.urbandroid.sleep.share;

import android.content.Context;
import android.content.SharedPreferences;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractShareService implements IShareService {
    @Override // com.urbandroid.sleep.share.IShareService
    public void disconnect(Context context) {
        SharedPreferences.Editor editorEdit = getPrefs(context).edit();
        editorEdit.putString(getTokenKey(), null);
        editorEdit.apply();
    }

    public SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(getServiceKey(), 0);
    }

    public abstract String getServiceKey();

    public abstract String getTokenKey();

    @Override // com.urbandroid.sleep.share.IShareService
    public boolean isConnected(Context context) {
        String string = getPrefs(context).getString(getTokenKey(), null);
        if (string == null) {
            Logger.logInfo("ShareService: isConnected token null");
        } else {
            Logger.logInfo("ShareService: isConnected token " + string.length());
        }
        return string != null && string.length() >= 1;
    }
}

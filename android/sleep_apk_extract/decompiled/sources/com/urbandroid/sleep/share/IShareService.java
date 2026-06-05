package com.urbandroid.sleep.share;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public interface IShareService {
    boolean authenticate(Context context);

    void disconnect(Context context);

    String getName(Context context);

    void initiateLoginActivity(Context context, Object obj);

    boolean isConnected(Context context);

    void publishImageAndCommentIt(Context context, byte[] bArr, Object obj, IHandler iHandler);

    void publishStatus(Context context, String str, IHandler iHandler);
}

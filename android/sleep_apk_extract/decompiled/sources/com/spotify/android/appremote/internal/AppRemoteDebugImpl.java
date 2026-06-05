package com.spotify.android.appremote.internal;

import android.util.Log;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.client.Debug;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class AppRemoteDebugImpl implements Debug.Logger, Debug.Assertion {
    @Override // com.spotify.protocol.client.Debug.Assertion
    public void assertTrue(boolean z, String str) {
        if (!SpotifyAppRemote.isDebugMode() || z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1((Object) str);
    }

    @Override // com.spotify.protocol.client.Debug.Logger
    public void d(Throwable th, String str, Object... objArr) {
        if (SpotifyAppRemote.isDebugMode()) {
            Log.d("SPOTIFY_APP_REMOTE", String.format(str, objArr), th);
        }
    }

    @Override // com.spotify.protocol.client.Debug.Logger
    public void e(Throwable th, String str, Object... objArr) {
        Log.e("SPOTIFY_APP_REMOTE", String.format(str, objArr), th);
    }

    @Override // com.spotify.protocol.client.Debug.Logger
    public void e(String str, Object... objArr) {
        e(null, str, objArr);
    }

    @Override // com.spotify.protocol.client.Debug.Logger
    public void d(String str, Object... objArr) {
        d(null, str, objArr);
    }
}
